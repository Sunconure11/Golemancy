package net.emirikol.amm.entity.goal;

import net.emirikol.amm.entity.*;

import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.util.math.*;

import java.util.*;

public class GolemMoveToItemGoal extends Goal {
	private final ClayEffigyEntity entity;
	private final float searchRadius;
	private final List<String> validTypes;
	
	private Entity targetItem;
	
	public GolemMoveToItemGoal(ClayEffigyEntity entity, float searchRadius, String[] validTypes) {
		this.entity = entity;
		this.searchRadius = searchRadius;
		this.validTypes = Arrays.asList(validTypes);
		this.setControls(EnumSet.of(Goal.Control.MOVE));
	}
	
	public boolean canStart() {
		//Check if the golem is the correct type for this behaviour.
		String golemType = entity.getGolemType();
		if (!this.validTypes.contains(golemType)) {
			return false;
		}
		//Check if there is an ItemEntity in the search radius and the golem's hand is empty.
		float r = this.searchRadius;
		List<ItemEntity> list = entity.world.getEntitiesByClass(ItemEntity.class, entity.getBoundingBox().expand(r,r,r), null);
		return !list.isEmpty() && entity.getEquippedStack(EquipmentSlot.MAINHAND).isEmpty();
	}
	
	public void start() {
		Random rand = new Random();
		float r = this.searchRadius;
		List<ItemEntity> list = entity.world.getEntitiesByClass(ItemEntity.class, entity.getBoundingBox().expand(r,r,r), null);
		if ((entity.getEquippedStack(EquipmentSlot.MAINHAND).isEmpty()) && (!list.isEmpty())) {
			targetItem = (Entity) list.get(rand.nextInt(list.size()));
		}
	}
	
	public void tick() {
		if (targetItem != null) {
			entity.getNavigation().startMovingTo(targetItem, 1);
		}
	}
	
	public boolean shouldContinue() {
		return !entity.getNavigation().isIdle() && (targetItem != null);
	}
}