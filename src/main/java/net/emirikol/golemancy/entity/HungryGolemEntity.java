package net.emirikol.golemancy.entity;

import net.emirikol.golemancy.*;
import net.emirikol.golemancy.entity.goal.*;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.server.world.*;

import java.util.*;

public class HungryGolemEntity extends AbstractGolemEntity {
	public HungryGolemEntity(EntityType<? extends HungryGolemEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override 
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(5, new GolemEatHeldItemGoal(this));
		this.goalSelector.add(5, new GolemExtractItemGoal(this));
		this.goalSelector.add(6, new GolemMoveToPickupGoal(this, 5.0F));
	}
	
	@Override
	public HungryGolemEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
		HungryGolemEntity golemEntity = Golemancy.HUNGRY_GOLEM_ENTITY.create(serverWorld);
		UUID uUID = this.getOwnerUuid();
		
		if ((uUID != null) && (golemEntity != null)) {
			golemEntity.setOwnerUuid(uUID);
			golemEntity.setTamed(true);
		}
		return golemEntity;
	}
}