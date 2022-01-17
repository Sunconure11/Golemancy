package net.emirikol.golemancy.genetics;

import net.emirikol.golemancy.Golemancy;
import net.emirikol.golemancy.entity.AbstractGolemEntity;

import net.minecraft.entity.EntityType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SoulTypes {
    public static final SoulType GENERIC = new SoulType("Generic", Golemancy.RESTLESS_GOLEM_ENTITY);

    public static final SoulType COVETOUS = new SoulType("Covetous", Golemancy.COVETOUS_GOLEM_ENTITY);
    public static final SoulType CURIOUS = new SoulType("Curious", Golemancy.CURIOUS_GOLEM_ENTITY);
    public static final SoulType ENTROPIC =  new SoulType("Entropic", Golemancy.ENTROPIC_GOLEM_ENTITY);
    public static final SoulType HUNGRY = new SoulType("Hungry", Golemancy.HUNGRY_GOLEM_ENTITY);
    public static final SoulType INTREPID = new SoulType("Intrepid", Golemancy.INTREPID_GOLEM_ENTITY);
    public static final SoulType MARSHY = new SoulType("Marshy", Golemancy.MARSHY_GOLEM_ENTITY);
    public static final SoulType PARCHED = new SoulType("Parched", Golemancy.PARCHED_GOLEM_ENTITY);
    public static final SoulType RESTLESS = new SoulType("Restless", Golemancy.RESTLESS_GOLEM_ENTITY);
    public static final SoulType RUSTIC = new SoulType("Rustic", Golemancy.RUSTIC_GOLEM_ENTITY);
    public static final SoulType TACTILE = new SoulType("Tactile", Golemancy.TACTILE_GOLEM_ENTITY);
    public static final SoulType VALIANT = new SoulType("Valiant", Golemancy.VALIANT_GOLEM_ENTITY);
    public static final SoulType VERDANT = new SoulType("Verdant", Golemancy.VERDANT_GOLEM_ENTITY);
    public static final SoulType WEEPING = new SoulType("Weeping", Golemancy.WEEPING_GOLEM_ENTITY);

    public static final List<SoulType> SOUL_TYPES = Arrays.asList(GENERIC, COVETOUS, CURIOUS, ENTROPIC, HUNGRY, INTREPID, MARSHY, PARCHED, RESTLESS, RUSTIC, TACTILE, VALIANT, VERDANT, WEEPING);

    public static SoulType get(String typeString) {
        //Find a SoulType from the type string, i.e. "Curious".
        for (SoulType soulType : SOUL_TYPES) {
            if (soulType.getTypeString().equals(typeString)) { return soulType; }
        }
        return null;
    }

    public static Collection<EntityType<? extends AbstractGolemEntity>> getEntityTypes() {
        return new ArrayList<EntityType<? extends  AbstractGolemEntity>>() {{
            for (SoulType soulType : SOUL_TYPES) {
                add(soulType.getEntityType());
            }
        }};
    }
}
