package net.nikk.beyondcultivation.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum SpiritFoxVariant {
    WHITE(0),
    WHITE_RED(1),
    WHITE2_RED(2),
    WHITE_ORANGE(3),
    WHITE_BLACK(4),
    RED(5),
    GOLD(6),
    DEFAULT_RED(7),
    CYAN_FOX(8),
    DEFAULT(9);

    private static final SpiritFoxVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(SpiritFoxVariant::getId)).toArray(SpiritFoxVariant[]::new);
    private final int id;

    SpiritFoxVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SpiritFoxVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
