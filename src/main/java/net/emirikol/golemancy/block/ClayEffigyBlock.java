package net.emirikol.golemancy.block;

import net.emirikol.golemancy.entity.AbstractGolemEntity;
import net.emirikol.golemancy.genetics.Gene;
import net.emirikol.golemancy.genetics.Genome;
import net.emirikol.golemancy.genetics.SoulType;
import net.emirikol.golemancy.item.SoulstoneFilled;

import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ClayEffigyBlock extends Block {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public ClayEffigyBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(((this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(FACING);
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return super.onUse(state, world, pos, player, hand, hit);
        }
        ServerWorld serverWorld = (ServerWorld) world;
        ItemStack stack = player.getStackInHand(hand);
        if (stack.getItem() instanceof SoulstoneFilled) {
            //Load genome from soulstone.
            Genome genome = new Genome(stack);
            Gene<SoulType> typeGene = genome.get("type");
            Gene<Integer> strengthGene = genome.get("strength");
            Gene<Integer> agilityGene = genome.get("agility");
            Gene<Integer> vigorGene = genome.get("vigor");
            Gene<Integer> smartsGene = genome.get("smarts");
            //Get entity type.
            EntityType<? extends AbstractGolemEntity> golemType = typeGene.getActive().getEntityType();
            if (golemType == null) { return ActionResult.PASS; } //shouldn't throw an error, as this can happen w/ soulstones that have invalid data (i.e. "generic soulstone")
            AbstractGolemEntity entity = golemType.create(serverWorld, null, null, null, pos, SpawnReason.SPAWN_EGG, true, true);
            if (entity == null) { throw new java.lang.RuntimeException("Attempt to create golem entity from soulstone returned NULL entity!"); }
            //Replace this block with air and spawn the new entity.
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            serverWorld.spawnEntityAndPassengers(entity);
            //Update tracked values from genome.
            entity.setGolemStats(strengthGene.getActive(), agilityGene.getActive(), vigorGene.getActive(), smartsGene.getActive());
            //Update golem "baked" value based on whether effigy was terracotta.
            entity.setBaked(this.isTerracotta());
            //Update golem attack damage, speed, and so on based on their stats.
            entity.updateAttributes();
            //Set the golem as tamed.
            entity.setOwner(player);
            //Remove the soulstone.
            stack.decrement(1);

            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    public boolean isTerracotta() { return false; }
}
