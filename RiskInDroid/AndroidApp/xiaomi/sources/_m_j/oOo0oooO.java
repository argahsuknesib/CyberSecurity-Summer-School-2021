package _m_j;

import _m_j.ooOOO0Oo;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public class oOo0oooO extends oO0O00o0 {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f2335O000000o = 0;
    private int O00000Oo = 0;
    public int O00O0Oo0 = 0;
    public int O00O0OoO = 0;
    public int O00O0Ooo = 0;
    public int O00O0o = 0;
    public int O00O0o0 = 0;
    public int O00O0o00 = 0;
    public int O00O0o0O = 0;
    public boolean O00O0o0o = false;
    public int O00O0oO0 = 0;
    protected ooOOO0Oo.O000000o O00O0oOO = new ooOOO0Oo.O000000o();
    ooOOO0Oo.O00000Oo O00O0oOo = null;

    public void O000000o(int i, int i2, int i3, int i4) {
    }

    public final void O0000o00(int i) {
        this.f2335O000000o = i;
        this.O00O0Oo0 = i;
        this.O00000Oo = i;
        this.O00O0OoO = i;
        this.O00O0Ooo = i;
        this.O00O0o00 = i;
    }

    public final void O0000o0(int i) {
        this.f2335O000000o = i;
        this.O00O0o0 = i;
    }

    public final void O0000o0O(int i) {
        this.O00000Oo = i;
        this.O00O0o0O = i;
    }

    public final void c_() {
        O0000o();
    }

    public final void O0000o() {
        for (int i = 0; i < this.O00O0OOo; i++) {
            ConstraintWidget constraintWidget = this.O00O0OO[i];
            if (constraintWidget != null) {
                constraintWidget.O000O0o0 = true;
            }
        }
    }

    public final void O00000o(int i, int i2) {
        this.O00O0o = i;
        this.O00O0oO0 = i2;
    }

    /* access modifiers changed from: protected */
    public final boolean O0000oO0() {
        ooOOO0Oo.O00000Oo O0000oO = this.O000Oo0 != null ? ((oOo0000O) this.O000Oo0).O0000oO() : null;
        if (O0000oO == null) {
            return false;
        }
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= this.O00O0OOo) {
                return true;
            }
            ConstraintWidget constraintWidget = this.O00O0OO[i];
            if (constraintWidget != null && !(constraintWidget instanceof oO0O000o)) {
                ConstraintWidget.DimensionBehaviour O0000Oo = constraintWidget.O0000Oo(0);
                ConstraintWidget.DimensionBehaviour O0000Oo2 = constraintWidget.O0000Oo(1);
                if (O0000Oo != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.O0000o0O == 1 || O0000Oo2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.O0000o0o == 1) {
                    z = false;
                }
                if (!z) {
                    if (O0000Oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        O0000Oo = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (O0000Oo2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        O0000Oo2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    ooOOO0Oo.O000000o o000000o = this.O00O0oOO;
                    o000000o.f2363O000000o = O0000Oo;
                    o000000o.O00000Oo = O0000Oo2;
                    o000000o.O00000o0 = constraintWidget.O00000oO();
                    this.O00O0oOO.O00000o = constraintWidget.O00000oo();
                    O0000oO.O000000o(constraintWidget, this.O00O0oOO);
                    constraintWidget.O00000oO(this.O00O0oOO.O00000oO);
                    constraintWidget.O00000oo(this.O00O0oOO.O00000oo);
                    constraintWidget.O0000Oo0(this.O00O0oOO.O0000O0o);
                }
            }
            i++;
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        while (this.O00O0oOo == null && this.O000Oo0 != null) {
            this.O00O0oOo = ((oOo0000O) this.O000Oo0).O0000oO();
        }
        ooOOO0Oo.O000000o o000000o = this.O00O0oOO;
        o000000o.f2363O000000o = dimensionBehaviour;
        o000000o.O00000Oo = dimensionBehaviour2;
        o000000o.O00000o0 = i;
        o000000o.O00000o = i2;
        this.O00O0oOo.O000000o(constraintWidget, o000000o);
        constraintWidget.O00000oO(this.O00O0oOO.O00000oO);
        constraintWidget.O00000oo(this.O00O0oOO.O00000oo);
        constraintWidget.O000O0Oo = this.O00O0oOO.O0000OOo;
        constraintWidget.O0000Oo0(this.O00O0oOO.O0000O0o);
    }
}
