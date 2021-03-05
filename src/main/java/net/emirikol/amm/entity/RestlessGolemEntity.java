package net.emirikol.amm.entity;

import net.emirikol.amm.*;
import net.emirikol.amm.entity.goal.*;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.world.*;
import net.minecraft.server.world.*;

import java.util.*;

public class RestlessGolemEntity extends AbstractGolemEntity {
	public RestlessGolemEntity(EntityType<? extends RestlessGolemEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override 
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0D));
	}
	
	@Override
	public RestlessGolemEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
		RestlessGolemEntity golemEntity = (RestlessGolemEntity) AriseMyMinionsMod.RESTLESS_GOLEM_ENTITY.create(serverWorld);
		UUID uUID = this.getOwnerUuid();
		
		if (uUID != null) {
			golemEntity.setOwnerUuid(uUID);
			golemEntity.setTamed(true);
		}
		return golemEntity;
	}
}