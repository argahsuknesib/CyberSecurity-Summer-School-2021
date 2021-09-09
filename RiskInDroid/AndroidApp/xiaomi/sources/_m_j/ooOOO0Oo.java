package _m_j;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public final class ooOOO0Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ArrayList<ConstraintWidget> f2362O000000o = new ArrayList<>();
    public oOo0000O O00000Oo;
    private O000000o O00000o0 = new O000000o();

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f2363O000000o;
        public ConstraintWidget.DimensionBehaviour O00000Oo;
        public int O00000o;
        public int O00000o0;
        public int O00000oO;
        public int O00000oo;
        public int O0000O0o;
        public boolean O0000OOo;
        public boolean O0000Oo;
        public boolean O0000Oo0;
    }

    public interface O00000Oo {
        void O000000o();

        void O000000o(ConstraintWidget constraintWidget, O000000o o000000o);
    }

    public final void O000000o(oOo0000O ooo0000o) {
        this.f2362O000000o.clear();
        int size = ooo0000o.O00O0OoO.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) ooo0000o.O00O0OoO.get(i);
            if (constraintWidget.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || constraintWidget.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                this.f2362O000000o.add(constraintWidget);
            }
        }
        ooo0000o.O0000o();
    }

    public ooOOO0Oo(oOo0000O ooo0000o) {
        this.O00000Oo = ooo0000o;
    }

    public final void O000000o(oOo0000O ooo0000o, int i, int i2) {
        int O0000O0o = ooo0000o.O0000O0o();
        int O0000OOo = ooo0000o.O0000OOo();
        ooo0000o.O0000O0o(0);
        ooo0000o.O0000OOo(0);
        ooo0000o.O00000oO(i);
        ooo0000o.O00000oo(i2);
        ooo0000o.O0000O0o(O0000O0o);
        ooo0000o.O0000OOo(O0000OOo);
        this.O00000Oo.O0000oOO();
    }

    public final boolean O000000o(O00000Oo o00000Oo, ConstraintWidget constraintWidget, boolean z) {
        this.O00000o0.f2363O000000o = constraintWidget.O000Oo00[0];
        this.O00000o0.O00000Oo = constraintWidget.O000Oo00[1];
        this.O00000o0.O00000o0 = constraintWidget.O00000oO();
        this.O00000o0.O00000o = constraintWidget.O00000oo();
        O000000o o000000o = this.O00000o0;
        o000000o.O0000Oo0 = false;
        o000000o.O0000Oo = z;
        boolean z2 = o000000o.f2363O000000o == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = this.O00000o0.O00000Oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z4 = z2 && constraintWidget.O000OoO0 > 0.0f;
        boolean z5 = z3 && constraintWidget.O000OoO0 > 0.0f;
        if (z4 && constraintWidget.O0000o[0] == 4) {
            this.O00000o0.f2363O000000o = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z5 && constraintWidget.O0000o[1] == 4) {
            this.O00000o0.O00000Oo = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        o00000Oo.O000000o(constraintWidget, this.O00000o0);
        constraintWidget.O00000oO(this.O00000o0.O00000oO);
        constraintWidget.O00000oo(this.O00000o0.O00000oo);
        constraintWidget.O000O0Oo = this.O00000o0.O0000OOo;
        constraintWidget.O0000Oo0(this.O00000o0.O0000O0o);
        O000000o o000000o2 = this.O00000o0;
        o000000o2.O0000Oo = false;
        return o000000o2.O0000Oo0;
    }
}
