package net.emirikol.golemancy.entity;

import net.emirikol.golemancy.*;
import net.emirikol.golemancy.entity.projectile.*;
import net.emirikol.golemancy.entity.goal.*;

import net.minecraft.entity.*;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.thrown.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.world.*;
import net.minecraft.sound.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.server.world.*;

import java.util.*;

public class IntrepidGolemEntity extends AbstractGolemEntity implements RangedAttackMob {
	public IntrepidGolemEntity(EntityType<? extends IntrepidGolemEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override 
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(1, new ProjectileAttackGoal(this, 1.25D, 40, 10.0F));
		this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
		this.targetSelector.add(2, new AttackWithOwnerGoal(this));
		this.targetSelector.add(3, new ActiveTargetGoal(this, MobEntity.class, 5, false, false, (livingEntity) -> {
			return livingEntity instanceof Monster && !(livingEntity instanceof CreeperEntity);
		}));
	}
	
	@Override
	public IntrepidGolemEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
		IntrepidGolemEntity golemEntity = (IntrepidGolemEntity) Golemancy.INTREPID_GOLEM_ENTITY.create(serverWorld);
		UUID uUID = this.getOwnerUuid();
		
		if (uUID != null) {
			golemEntity.setOwnerUuid(uUID);
			golemEntity.setTamed(true);
		}
		return golemEntity;
	}
	
	@Override
	protected ActionResult tryGiveToGolem(PlayerEntity player, Hand hand) {
		return ActionResult.PASS;
	}
	
	@Override
	public void attack(LivingEntity target, float pullProgress) {
		ClayballEntity clayballEntity = new ClayballEntity(this.world, this);
		clayballEntity.setDamage(this.getAttackDamageFromStrength(this.getGolemStrength()));
		double d = target.getX() - this.getX();
		double e = target.getBodyY(0.3333333333333333D) - clayballEntity.getY();
		double f = target.getZ() - this.getZ();
		double g = (double)MathHelper.sqrt((float) (MathHelper.square(d) + MathHelper.square(f)));
		clayballEntity.setVelocity(d, e + g * 0.20000000298023224D, f, 1.6F, (float)(14 - this.world.getDifficulty().getId() * 4));
		this.playSound(SoundEvents.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
		this.world.spawnEntity(clayballEntity);
	}
}