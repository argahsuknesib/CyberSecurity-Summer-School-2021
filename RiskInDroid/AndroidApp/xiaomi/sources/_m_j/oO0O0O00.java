package _m_j;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public final class oO0O0O00 {

    /* renamed from: O000000o  reason: collision with root package name */
    static boolean[] f2282O000000o = new boolean[3];

    public static final boolean O000000o(int i, int i2) {
        return (i & i2) == i2;
    }

    static void O000000o(oOo0000O ooo0000o, oO00Oo00 oo00oo00, ConstraintWidget constraintWidget) {
        constraintWidget.O0000o00 = -1;
        constraintWidget.O0000o0 = -1;
        if (ooo0000o.O000Oo00[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.O000O0o.O00000o;
            int O00000oO = ooo0000o.O00000oO() - constraintWidget.O000O0oo.O00000o;
            constraintWidget.O000O0o.O00000oo = oo00oo00.O000000o(constraintWidget.O000O0o);
            constraintWidget.O000O0oo.O00000oo = oo00oo00.O000000o(constraintWidget.O000O0oo);
            oo00oo00.O000000o(constraintWidget.O000O0o.O00000oo, i);
            oo00oo00.O000000o(constraintWidget.O000O0oo.O00000oo, O00000oO);
            constraintWidget.O0000o00 = 2;
            constraintWidget.O00000Oo(i, O00000oO);
        }
        if (ooo0000o.O000Oo00[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.O000O0oO.O00000o;
            int O00000oo = ooo0000o.O00000oo() - constraintWidget.O000OO00.O00000o;
            constraintWidget.O000O0oO.O00000oo = oo00oo00.O000000o(constraintWidget.O000O0oO);
            constraintWidget.O000OO00.O00000oo = oo00oo00.O000000o(constraintWidget.O000OO00);
            oo00oo00.O000000o(constraintWidget.O000O0oO.O00000oo, i2);
            oo00oo00.O000000o(constraintWidget.O000OO00.O00000oo, O00000oo);
            if (constraintWidget.O000Oooo > 0 || constraintWidget.O000o0O == 8) {
                constraintWidget.O000OO0o.O00000oo = oo00oo00.O000000o(constraintWidget.O000OO0o);
                oo00oo00.O000000o(constraintWidget.O000OO0o.O00000oo, constraintWidget.O000Oooo + i2);
            }
            constraintWidget.O0000o0 = 2;
            constraintWidget.O00000o0(i2, O00000oo);
        }
    }
}
