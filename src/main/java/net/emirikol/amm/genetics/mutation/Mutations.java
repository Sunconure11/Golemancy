package net.emirikol.amm.genetics.mutation;

import net.emirikol.amm.*;

import java.util.*;

public class Mutations {
	public static final Mutation TEST = new Mutation(AriseMyMinionsMod.SOULSTONE_ENDERMAN, 1.0) {{
		addParents(AriseMyMinionsMod.SOULSTONE_ZOMBIE, AriseMyMinionsMod.SOULSTONE_SKELETON);
	}};
	
	public static final List<Mutation> MUTATIONS = new ArrayList<Mutation>() {{
		add(TEST);
	}};
}