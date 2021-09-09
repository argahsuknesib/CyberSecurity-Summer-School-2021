package com.otaliastudios.cameraview;

import _m_j.cps;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class Grid extends Enum<Grid> implements cps {
    private static final /* synthetic */ Grid[] $VALUES;
    static final Grid DEFAULT;
    public static final Grid DRAW_3X3 = new Grid("DRAW_3X3", 1, 1);
    public static final Grid DRAW_4X4 = new Grid("DRAW_4X4", 2, 2);
    public static final Grid DRAW_PHI = new Grid("DRAW_PHI", 3, 3);
    public static final Grid OFF = new Grid("OFF", 0, 0);
    private int value;

    public static Grid valueOf(String str) {
        return (Grid) Enum.valueOf(Grid.class, str);
    }

    public static Grid[] values() {
        return (Grid[]) $VALUES.clone();
    }

    static {
        Grid grid = OFF;
        $VALUES = new Grid[]{grid, DRAW_3X3, DRAW_4X4, DRAW_PHI};
        DEFAULT = grid;
    }

    private Grid(String str, int i, int i2) {
        this.value = i2;
    }

    /* access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    static Grid fromValue(int i) {
        for (Grid grid : values()) {
            if (grid.value() == i) {
                return grid;
            }
        }
        return null;
    }
}
