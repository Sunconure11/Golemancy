package net.emirikol.golemancy.entity.goal;

import net.emirikol.golemancy.entity.*;
import net.emirikol.golemancy.network.*;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.server.network.*;

import java.util.*;

public class GolemHealGoal extends Goal {
	private final AbstractGolemEntity entity;
	
	private TameableEntity friend;
	private int healingTimer;
	
	public GolemHealGoal(AbstractGolemEntity entity) {
		this.entity = entity;
	}
	
	public boolean canStart() {
		return canStartHealing() || isHealing();
	}
	
	public void start() {
		this.setHealing();
	}
	
	public void tick() {
		if (this.isHealing()) {
			this.healingTimer--;
			if (this.healingTimer % 40 == 0) {
				Particles.healParticle(this.entity);
			}
		} else {
			this.friend.heal(2.0F);
			Particles.healParticle(this.friend);
			if (canStartHealing()) { this.setHealing(); }
		}
	}
	
	public boolean canStartHealing() {
		List<TameableEntity> list = entity.world.getEntitiesByClass(TameableEntity.class, entity.getBoundingBox().expand(1.5F,1.5F,1.5F), null);
		for (TameableEntity tameable: list) {
			if (wounded(tameable) && (this.entity.getOwner() == tameable.getOwner())) {
				this.friend = tameable;
				return true;
			}
		}
		return false;
	}
	
	public boolean wounded(LivingEntity entity) {
		return entity.getHealth() < entity.getMaxHealth();
	}
	
	public boolean isHealing() {
		return this.healingTimer > 0;
	}
	
	public void setHealing() {
		this.healingTimer = 80;
	}
}