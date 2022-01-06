package net.emirikol.golemancy.genetics;

import net.minecraft.entity.*;

import java.util.*;

public class Genomes {
	public static final Genome GENERIC = new Genome() {{
		put("type", new Gene<String>(SoulTypes.GENERIC.getTypeString()));
		put("potency", new Gene<Integer>(1));
		put("strength", new Gene<Integer>(0));
		put("agility", new Gene<Integer>(0));
		put("vigor", new Gene<Integer>(0));
		put("smarts", new Gene<Integer>(0));
	}};
	
	public static final Genome BLAZE = new Genome() {{
		put("type", new Gene<String>(SoulTypes.PARCHED.getTypeString()));
		put("potency", new Gene<Integer>(3));
		put("strength", new Gene<Integer>(0));
		put("agility", new Gene<Integer>(1));
		put("vigor", new Gene<Integer>(1));
		put("smarts", new Gene<Integer>(1));
	}};
	
	public static final Genome CREEPER = new Genome() {{
		put("type", new Gene<String>(SoulTypes.ENTROPIC.getTypeString()));
		put("potency", new Gene<Integer>(3));
		put("strength", new Gene<Integer>(0));
		put("agility", new Gene<Integer>(1));
		put("vigor", new Gene<Integer>(1));
		put("smarts", new Gene<Integer>(1));
	}};
	
	public static final Genome ENDERMAN = new Genome() {{
		put("type", new Gene<String>(SoulTypes.COVETOUS.getTypeString()));
		put("potency", new Gene<Integer>(2));
		put("strength", new Gene<Integer>(1));
		put("agility", new Gene<Integer>(1));
		put("vigor", new Gene<Integer>(1));
		put("smarts", new Gene<Integer>(2));
	}};

	public static final Genome ENDERMITE = new Genome() {{
		put("type", new Gene<String>(SoulTypes.COVETOUS.getTypeString()));
		put("potency", new Gene<Integer>(4));
		put("strength", new Gene<Integer>(0));
		put("agility", new Gene<Integer>(1));
		put("vigor", new Gene<Integer>(0));
		put("smarts", new Gene<Integer>(0));
	}};
	
	public static final Genome GHAST = new Genome() {{
		put("type", new Gene<String>(SoulTypes.WEEPING.getTypeString()));
		put("potency", new Gene<Integer>(3));
		put("strength", new Gene<Integer>(0));
		put("agility", new Gene<Integer>(2));
		put("vigor", new Gene<Integer>(1));
		put("smarts", new Gene<Integer>(1));
	}};
	
	public static final Genome GUARDIAN = new Genome() {{
		put("type", new Gene<String>(SoulTypes.VALIANT.getTypeString()));
		put("potency", new Gene<Integer>(3));
		put("strength", new Gene<Integer>(1));
		put("agility", new Gene<Integer>(1));
		put("vigor", new Gene<Integer>(1));
		put("smarts", new Gene<Integer>(1));
	}};
	
	public static final Genome HOGLIN = new Genome() {{
		put("type", new Gene<String>(SoulTypes.HUNGRY.getTypeString()));
		put("potency", new Gene<Integer>(3));
		put("strength", new Gene<Integer>(1));
		put("agility", new Gene<Integer>(1));
		put("vigor", new Gene<Integer>(2));
		put("smarts", new Gene<Integer>(0));
	}};
	
	public static final Genome HUSK = new Genome() {{
		put("type", new Gene<String>(SoulTypes.PARCHED.getTypeString()));
		put("potency", new Gene<Integer>(3));
		put("strength", new Gene<Integer>(1));
		put("agility", new Gene<Integer>(0));
		put("vigor", new Gene<Integer>(1));
		put("smarts", new Gene<Integer>(0));
	}};
	
	public static final Genome PHANTOM = new Genome() {{
		put("type", new Gene<String>(SoulTypes.TACTILE.getTypeString()));
		put("potency", new Gene<Integer>(1));
		put("strength", new Gene<Integer>(1));
		put("agility", new Gene<Integer>(2));
		put("vigor", new Gene<Integer>(1));
		put("smarts", new Gene<Integer>(2));
	}};
	
	public static final Genome RAVAGER = new Genome() {{
		put("type", new Gene<String>(SoulTypes.VALIANT.getTypeString()));
		put("potency", new Gene<Integer>(2));
		put("strength", new Gene<Integer>(2));
		put("agility", new Gene<Integer>(0));
		put("vigor", new Gene<Integer>(2));
		put("smarts", new Gene<Integer>(0));
	}};
	
	public static final Genome SHULKER = new Genome() {{
		put("type", new Gene<String>(SoulTypes.INTREPID.getTypeString()));
		put("potency", new Gene<Integer>(2));
		put("strength", new Gene<Integer>(0));
		put("agility", new Gene<Integer>(0));
		put("vigor", new Gene<Integer>(2));
		put("smarts", new Gene<Integer>(2));
	}};
	
	public static final Genome SILVERFISH = new Genome() {{
		put("type", new Gene<String>(SoulTypes.ENTROPIC.getTypeString()));
		put("potency", new Gene<Integer>(4));
		put("strength", new Gene<Integer>(0));
		put("agility", new Gene<Integer>(1));
		put("vigor", new Gene<Integer>(0));
		put("smarts", new Gene<Integer>(0));
	}};
	
	public static final Genome SKELETON = new Genome() {{
		put("type", new Gene<String>(SoulTypes.RESTLESS.getTypeString()));
		put("potency", new Gene<Integer>(3));
		put("strength", new Gene<Integer>(1));
		put("agility", new Gene<Integer>(1));
		put("vigor", new Gene<Integer>(0));
		put("smarts", new Gene<Integer>(1));
	}};
	
	public static final Genome SLIME = new Genome() {{
		put("type", new Gene<String>(SoulTypes.CURIOUS.getTypeString()));
		put("potency", new Gene<Integer>(5));
		put("strength", new Gene<Integer>(0));
		put("agility", new Gene<Integer>(0));
		put("vigor", new Gene<Integer>(0));
		put("smarts", new Gene<Integer>(0));
	}};
	
	public static final Genome SPIDER = new Genome() {{
		put("type", new Gene<String>(SoulTypes.RESTLESS.getTypeString()));
		put("potency", new Gene<Integer>(3));
		put("strength", new Gene<Integer>(1));
		put("agility", new Gene<Integer>(2));
		put("vigor", new Gene<Integer>(0));
		put("smarts", new Gene<Integer>(0));
	}};

	public static final Genome VEX = new Genome() {{
		put("type", new Gene<String>(SoulTypes.COVETOUS.getTypeString()));
		put("potency", new Gene<Integer>(3));
		put("strength", new Gene<Integer>(0));
		put("agility", new Gene<Integer>(2));
		put("vigor", new Gene<Integer>(0));
		put("smarts", new Gene<Integer>(1));
	}};
	
	public static final Genome WITHER_SKELETON = new Genome() {{
		put("type", new Gene<String>(SoulTypes.VALIANT.getTypeString()));
		put("potency", new Gene<Integer>(2));
		put("strength", new Gene<Integer>(2));
		put("agility", new Gene<Integer>(1));
		put("vigor", new Gene<Integer>(1));
		put("smarts", new Gene<Integer>(1));
	}};

	public static final Genome ZOGLIN = new Genome() {{
		put("type", new Gene<String>(SoulTypes.HUNGRY.getTypeString()));
		put("potency", new Gene<Integer>(3));
		put("strength", new Gene<Integer>(1));
		put("agility", new Gene<Integer>(1));
		put("vigor", new Gene<Integer>(2));
		put("smarts", new Gene<Integer>(0));
	}};
	
	public static final Genome ZOMBIE = new Genome() {{
		put("type", new Gene<String>(SoulTypes.HUNGRY.getTypeString()));
		put("potency", new Gene<Integer>(3));
		put("strength", new Gene<Integer>(1));
		put("agility", new Gene<Integer>(0));
		put("vigor", new Gene<Integer>(1));
		put("smarts", new Gene<Integer>(0));
	}};

	// Boss Genomes

	public static final Genome ELDER_GUARDIAN = new Genome() {{
		put("type", new Gene<String>(SoulTypes.VALIANT.getTypeString()));
		put("potency", new Gene<Integer>(3));
		put("strength", new Gene<Integer>(1));
		put("agility", new Gene<Integer>(1));
		put("vigor", new Gene<Integer>(3));
		put("smarts", new Gene<Integer>(1));
	}};

	public static final Genome WITHER = new Genome() {{
		put("type", new Gene<String>(SoulTypes.VALIANT.getTypeString()));
		put("potency", new Gene<Integer>(2));
		put("strength", new Gene<Integer>(2));
		put("agility", new Gene<Integer>(1));
		put("vigor", new Gene<Integer>(1));
		put("smarts", new Gene<Integer>(3));
	}};

	public static final Genome ENDER_DRAGON = new Genome() {{
		put("type", new Gene<String>(SoulTypes.COVETOUS.getTypeString()));
		put("potency", new Gene<Integer>(2));
		put("strength", new Gene<Integer>(3));
		put("agility", new Gene<Integer>(3));
		put("vigor", new Gene<Integer>(1));
		put("smarts", new Gene<Integer>(2));
	}};
	
	public static final Map<String,Integer> TEXTURE_VARIANTS = new HashMap<String,Integer>() {{
		put(SoulTypes.RESTLESS.getTypeString(), 1);
		put(SoulTypes.CURIOUS.getTypeString(), 2);
		put(SoulTypes.HUNGRY.getTypeString(), 3);
		put(SoulTypes.COVETOUS.getTypeString(), 4);
		put(SoulTypes.VALIANT.getTypeString(), 5);
		put(SoulTypes.PARCHED.getTypeString(), 6);
		put(SoulTypes.ENTROPIC.getTypeString(), 7);
		put(SoulTypes.TACTILE.getTypeString(), 8);
		put(SoulTypes.INTREPID.getTypeString(), 9);
		put(SoulTypes.WEEPING.getTypeString(), 10);
	}};
	
	public static final Map<EntityType,Genome> GENOMES = new HashMap<EntityType,Genome>() {{
		put(EntityType.BLAZE, BLAZE);
		put(EntityType.CREEPER, CREEPER);
		put(EntityType.ENDERMAN, ENDERMAN);
		put(EntityType.ENDERMITE, ENDERMITE);
		put(EntityType.GHAST, GHAST);
		put(EntityType.GUARDIAN, GUARDIAN);
		put(EntityType.HOGLIN, HOGLIN);
		put(EntityType.HUSK, HUSK);
		put(EntityType.PHANTOM, PHANTOM);
		put(EntityType.RAVAGER, RAVAGER);
		put(EntityType.SHULKER, SHULKER);
		put(EntityType.SILVERFISH, SILVERFISH);
		put(EntityType.SKELETON, SKELETON);
		put(EntityType.SKELETON_HORSE, SKELETON);
		put(EntityType.STRAY, SKELETON);
		put(EntityType.MAGMA_CUBE, SLIME);
		put(EntityType.SLIME, SLIME);
		put(EntityType.CAVE_SPIDER, SPIDER);
		put(EntityType.SPIDER, SPIDER);
		put(EntityType.VEX, VEX);
		put(EntityType.WITHER_SKELETON, WITHER_SKELETON);
		put(EntityType.ZOGLIN, ZOGLIN);
		put(EntityType.DROWNED, ZOMBIE);
		put(EntityType.ZOMBIE, ZOMBIE);
		put(EntityType.ZOMBIE_HORSE, ZOMBIE);
		put(EntityType.ZOMBIE_VILLAGER, ZOMBIE);
		put(EntityType.ZOMBIFIED_PIGLIN, ZOMBIE);

		put(EntityType.ELDER_GUARDIAN, ELDER_GUARDIAN);
		put(EntityType.WITHER, WITHER);
		put(EntityType.ENDER_DRAGON, ENDER_DRAGON);
	}};
	
	public static Set<EntityType> getEntityTypes() {
		return GENOMES.keySet();
	}
	
	public static Genome get(EntityType entityType) {
		return GENOMES.get(entityType);
	}
}