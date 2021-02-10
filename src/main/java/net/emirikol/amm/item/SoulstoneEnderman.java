package net.emirikol.amm.item;

import net.emirikol.amm.*;
import net.emirikol.amm.genetics.*;

import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;

public class SoulstoneEnderman extends Soulstone implements FilledSoulstone {
	
	public SoulstoneEnderman(Settings settings) {
		super(settings);
	}
	
	@Override
	//Return a name for the soul contained in this soulstone.
	public String getSoulName() {
		return "ENDERMAN";
	}
	
	@Override
	//Return the EntityType that should be spawned from this soulstone.
	public EntityType getEntityType() {
		return AriseMyMinionsMod.SUMMONED_ENDERMAN;
	}

	
	@Override
	//Initialises NBT data of a soulstone with defaults for that species.
	public void defaultGenes(ItemStack stack) {
		super.defaultGenes(stack);
		Genome genome = new Genome(stack);
		genome.loadTags();
		genome.createGenome(GenomeAttributes.ENDERMAN_POTENCY, GenomeAttributes.ENDERMAN_DAMAGE, GenomeAttributes.ENDERMAN_KNOCKBACK, GenomeAttributes.ENDERMAN_ARMOR, GenomeAttributes.ENDERMAN_MOVEMENT_SPEED);
		genome.saveTags();
	}
}