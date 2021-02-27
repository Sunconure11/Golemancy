package net.emirikol.amm.entity;

import net.emirikol.amm.*;
import net.emirikol.amm.item.*;
import net.emirikol.amm.entity.goal.*;
import net.emirikol.amm.genetics.*;
import net.emirikol.amm.component.*;

import net.minecraft.entity.*;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.text.*;
import net.minecraft.util.*;
import net.minecraft.server.world.*;

import java.util.*;

public class ClayEffigyEntity extends TameableEntity {
	private String type;
	private int strength,agility,vigor,smarts;
	
	public ClayEffigyEntity(EntityType<? extends ClayEffigyEntity> entityType, World world) {
		super(entityType, world);
		this.setTamed(false);
	}
   
	public static DefaultAttributeContainer.Builder createClayEffigyAttributes() {
		return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25).add(EntityAttributes.GENERIC_MAX_HEALTH, 6.0D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D);
	}
	
	public ClayEffigyEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
		ClayEffigyEntity clayEffigyEntity = (ClayEffigyEntity) AriseMyMinionsMod.CLAY_EFFIGY_ENTITY.create(serverWorld);
		UUID uUID = this.getOwnerUuid();
		
		if (uUID != null) {
			clayEffigyEntity.setOwnerUuid(uUID);
			clayEffigyEntity.setTamed(true);
		}
		return clayEffigyEntity;
	}
	
	@Override
	protected int getCurrentExperience(PlayerEntity player) {
		return 0;
	}
	
	@Override
	public boolean canBreatheInWater() {
		return true;
	}
	
	
	public void toComponent() {
		GolemComponent component = AriseMyMinionsComponents.GOLEM.get(this);
		component.setType(this.type);
		component.setAttribute("strength", this.strength);
		component.setAttribute("agility", this.agility);
		component.setAttribute("vigor", this.vigor);
		component.setAttribute("smarts", this.smarts);
	}
	
	public void fromComponent() {
		GolemComponent component = AriseMyMinionsComponents.GOLEM.get(this);
		this.type = component.getType();
		this.strength = component.getAttribute("strength");
		this.agility = component.getAttribute("agility");
		this.vigor = component.getAttribute("vigor");
		this.smarts = component.getAttribute("smarts");
	}

	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (this.world.isClient()) {
			return ActionResult.PASS;
		}
		if (this.isTamed()) {
			return ActionResult.PASS;
		}
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
			//Update tracked values from genome.
			this.type = typeGene.getActive();
			this.strength = strengthGene.getActive();
			this.agility = agilityGene.getActive();
			this.vigor = vigorGene.getActive();
			this.smarts = smartsGene.getActive();
			//Save tracked values using Cardinal Components.
			this.toComponent();
			//Remove the soulstone.
			stack.decrement(1);
			//Update golem attributes based on stats.
			this.updateAttributes();
			//Update golem AI based on type.
			this.updateGoals();
			//Set the golem as tamed.
			this.setOwner(player);
			return ActionResult.SUCCESS;
		} 
		return ActionResult.PASS;
	}
	
	public void updateAttributes() {
		this.fromComponent();
		EntityAttributeInstance entityAttributeInstance;
		//Update attack damage based on strength.
		entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
		entityAttributeInstance.setBaseValue(getAttackDamageFromStrength(this.strength));
		//Update movement speed based on agility.
		entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
		entityAttributeInstance.setBaseValue(getMovementSpeedFromAgility(this.agility));
		//Update health based on vigor.
		entityAttributeInstance = this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
		entityAttributeInstance.setBaseValue(getHealthFromVigor(this.vigor));
		this.heal(20.0F);
	}
	
	public void updateGoals() {
		this.fromComponent();
		switch(this.type) {
			case "Restless":
				this.goalSelector.add(10, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
				this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0D));
				return;
			case "Curious":
				this.goalSelector.add(10, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
				this.goalSelector.add(6, new GolemFollowOwnerGoal(this, 1.0D, 6.0F, 2.0F, 750.0F, false));
				return;
			default:
				return;
		}
	}
	
	//Update goals after loading from NBT, to ensure that Cardinal Components has loaded.
	@Override
	public void fromTag(CompoundTag tag) {
		super.fromTag(tag);
		this.updateGoals();
	}
	
	@Override
	public Text getName() {
		this.fromComponent();
		if (this.type == "") {
			return super.getName();
		}
		MutableText name = new LiteralText(this.type + " ");
		name.append(new TranslatableText("text.amm.golem"));
		return name;
	}
	
	public double getAttackDamageFromStrength(int strength) {
		switch(strength) {
			case 0:
				return 1.0D;
			case 1:
				return 2.0D;
			case 2:
				return 3.0D;
			case 3:
				return 4.0D;
			default:
				return 0.0D;
		}
	}
	
	public double getMovementSpeedFromAgility(int agility) {
		switch(agility) {
			case 0:
				return 0.2D;
			case 1:
				return 0.25D;
			case 2:
				return 0.3D;
			case 3:
				return 0.5D;
			default:
				return 0.0D;
		}
	}
	
	public double getHealthFromVigor(int vigor) {
		switch(vigor) {
			case 0:
				return 8.0D;
			case 1:
				return 10.0D;
			case 2:
				return 12.0D;
			case 3:
				return 16.0D;
			default:
				return 0.0D;
		}
	}
}