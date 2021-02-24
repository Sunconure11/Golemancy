package net.emirikol.amm.genetics;

import net.minecraft.entity.*;

import java.util.*;

public class Genomes {
	public static final Map<EntityType,Genome> GENOMES = new HashMap<EntityType,Genome>() {{
		put(EntityType.DROWNED, ZOMBIE);
		put(EntityType.HUSK, ZOMBIE);
		put(EntityType.ZOMBIE, ZOMBIE);
	}};
	
	public static final Genome GENERIC = new Genome() {{
		put("type", new Gene<String>("NONE"));
		put("strength", new Gene<Integer>(0));
		put("agility", new Gene<Integer>(0));
		put("vigor", new Gene<Integer>(0));
		put("smarts", new Gene<Integer>(0));
	}};
	
	public static final Genome ZOMBIE = new Genome() {{
		put("type", new Gene<String>("NONE"));
		put("strength", new Gene<Integer>(1));
		put("agility", new Gene<Integer>(0));
		put("vigor", new Gene<Integer>(1));
		put("smarts", new Gene<Integer>(0));
	}};
}