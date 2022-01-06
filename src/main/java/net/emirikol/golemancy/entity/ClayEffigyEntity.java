package net.emirikol.golemancy.entity;

import net.emirikol.golemancy.item.*;
import net.emirikol.golemancy.genetics.*;

import net.minecraft.entity.*;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.server.world.*;

public class ClayEffigyEntity extends PathAwareEntity {
	
	public ClayEffigyEntity(EntityType<? extends ClayEffigyEntity> entityType, World world) {
		super(entityType, world);
	}
   
	public static DefaultAttributeContainer.Builder createEffigyAttributes() {
		return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25).add(EntityAttributes.GENERIC_MAX_HEALTH, 6.0D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D);
	}
	
	@Override
	public boolean canBreatheInWater() {
		return true;
	}
	
	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (this.world.isClient()) {
			return super.interactMob(player, hand);
		}
		return tryInsertSoulstone(player, hand);
	}
	
	private ActionResult tryInsertSoulstone(PlayerEntity player, Hand hand) {
		ItemStack stack = player.getStackInHand(hand);
		ServerWorld world = (ServerWorld) this.world;
		if (stack.getItem() instanceof SoulstoneFilled) {
			//Load genome from soulstone.
			Genome genome = new Genome(stack);
			Gene<String> typeGene = genome.get("type");
			Gene<Integer> strengthGene = genome.get("strength");
			Gene<Integer> agilityGene = genome.get("agility");
			Gene<Integer> vigorGene = genome.get("vigor");
			Gene<Integer> smartsGene = genome.get("smarts");
			//Get entity type and replace this entity with the correct golem.
			EntityType<? extends AbstractGolemEntity> golemType = SoulTypes.get(typeGene.getActive()).getEntityType();
			if (golemType == null) { return ActionResult.PASS; } //shouldn't throw an error, as this can happen w/ soulstones that have invalid data (i.e. "generic soulstone")
			BlockPos pos = this.getBlockPos();
			this.discard();
			AbstractGolemEntity entity = golemType.create(world, null, null, null, pos, SpawnReason.SPAWN_EGG, true, true);
			if (entity == null) { throw new java.lang.RuntimeException("Attempt to create golem entity from soulstone returned NULL entity!"); }
			world.spawnEntityAndPassengers(entity);
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
		} else {
			return ActionResult.PASS;
		}
	}

	public boolean isTerracotta() {
		return false;
	}
}