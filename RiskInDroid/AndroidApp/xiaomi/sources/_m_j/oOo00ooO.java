package _m_j;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.HashMap;

public final class oOo00ooO extends oO0O00o0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2334O000000o = 0;
    public boolean O00000Oo = true;
    public int O00000o0 = 0;

    public final boolean O000000o() {
        return true;
    }

    public final void O000000o(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.O000000o(constraintWidget, hashMap);
        oOo00ooO ooo00ooo = (oOo00ooO) constraintWidget;
        this.f2334O000000o = ooo00ooo.f2334O000000o;
        this.O00000Oo = ooo00ooo.O00000Oo;
        this.O00000o0 = ooo00ooo.O00000o0;
    }

    public final String toString() {
        String str = "[Barrier] " + this.O000o0OO + " {";
        for (int i = 0; i < this.O00O0OOo; i++) {
            ConstraintWidget constraintWidget = this.O00O0OO[i];
            if (i > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.O000o0OO;
        }
        return str + "}";
    }

    public final void O000000o(oO00Oo00 oo00oo00) {
        boolean z;
        int i;
        int i2;
        this.O000OOo[0] = this.O000O0o;
        this.O000OOo[2] = this.O000O0oO;
        this.O000OOo[1] = this.O000O0oo;
        this.O000OOo[3] = this.O000OO00;
        for (int i3 = 0; i3 < this.O000OOo.length; i3++) {
            this.O000OOo[i3].O00000oo = oo00oo00.O000000o(this.O000OOo[i3]);
        }
        int i4 = this.f2334O000000o;
        if (i4 >= 0 && i4 < 4) {
            ConstraintAnchor constraintAnchor = this.O000OOo[this.f2334O000000o];
            int i5 = 0;
            while (true) {
                if (i5 >= this.O00O0OOo) {
                    z = false;
                    break;
                }
                ConstraintWidget constraintWidget = this.O00O0OO[i5];
                if ((this.O00000Oo || constraintWidget.O000000o()) && ((((i = this.f2334O000000o) == 0 || i == 1) && constraintWidget.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.O000O0o.O00000o0 != null && constraintWidget.O000O0oo.O00000o0 != null) || (((i2 = this.f2334O000000o) == 2 || i2 == 3) && constraintWidget.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.O000O0oO.O00000o0 != null && constraintWidget.O000OO00.O00000o0 != null))) {
                    z = true;
                } else {
                    i5++;
                }
            }
            z = true;
            boolean z2 = this.O000O0o.O000000o() || this.O000O0oo.O000000o();
            boolean z3 = this.O000O0oO.O000000o() || this.O000OO00.O000000o();
            boolean z4 = !z && ((this.f2334O000000o == 0 && z2) || ((this.f2334O000000o == 2 && z3) || ((this.f2334O000000o == 1 && z2) || (this.f2334O000000o == 3 && z3))));
            int i6 = 5;
            if (!z4) {
                i6 = 4;
            }
            for (int i7 = 0; i7 < this.O00O0OOo; i7++) {
                ConstraintWidget constraintWidget2 = this.O00O0OO[i7];
                if (this.O00000Oo || constraintWidget2.O000000o()) {
                    SolverVariable O000000o2 = oo00oo00.O000000o(constraintWidget2.O000OOo[this.f2334O000000o]);
                    constraintWidget2.O000OOo[this.f2334O000000o].O00000oo = O000000o2;
                    int i8 = (constraintWidget2.O000OOo[this.f2334O000000o].O00000o0 == null || constraintWidget2.O000OOo[this.f2334O000000o].O00000o0.f2787O000000o != this) ? 0 : constraintWidget2.O000OOo[this.f2334O000000o].O00000o + 0;
                    int i9 = this.f2334O000000o;
                    if (i9 == 0 || i9 == 2) {
                        oO00OOOo O00000o02 = oo00oo00.O00000o0();
                        SolverVariable O00000o = oo00oo00.O00000o();
                        O00000o.O00000o = 0;
                        O00000o02.O00000Oo(constraintAnchor.O00000oo, O000000o2, O00000o, this.O00000o0 - i8);
                        oo00oo00.O000000o(O00000o02);
                    } else {
                        oO00OOOo O00000o03 = oo00oo00.O00000o0();
                        SolverVariable O00000o2 = oo00oo00.O00000o();
                        O00000o2.O00000o = 0;
                        O00000o03.O000000o(constraintAnchor.O00000oo, O000000o2, O00000o2, this.O00000o0 + i8);
                        oo00oo00.O000000o(O00000o03);
                    }
                    oo00oo00.O00000o0(constraintAnchor.O00000oo, O000000o2, this.O00000o0 + i8, i6);
                }
            }
            int i10 = this.f2334O000000o;
            if (i10 == 0) {
                oo00oo00.O00000o0(this.O000O0oo.O00000oo, this.O000O0o.O00000oo, 0, 8);
                oo00oo00.O00000o0(this.O000O0o.O00000oo, this.O000Oo0.O000O0oo.O00000oo, 0, 4);
                oo00oo00.O00000o0(this.O000O0o.O00000oo, this.O000Oo0.O000O0o.O00000oo, 0, 0);
            } else if (i10 == 1) {
                oo00oo00.O00000o0(this.O000O0o.O00000oo, this.O000O0oo.O00000oo, 0, 8);
                oo00oo00.O00000o0(this.O000O0o.O00000oo, this.O000Oo0.O000O0o.O00000oo, 0, 4);
                oo00oo00.O00000o0(this.O000O0o.O00000oo, this.O000Oo0.O000O0oo.O00000oo, 0, 0);
            } else if (i10 == 2) {
                oo00oo00.O00000o0(this.O000OO00.O00000oo, this.O000O0oO.O00000oo, 0, 8);
                oo00oo00.O00000o0(this.O000O0oO.O00000oo, this.O000Oo0.O000OO00.O00000oo, 0, 4);
                oo00oo00.O00000o0(this.O000O0oO.O00000oo, this.O000Oo0.O000O0oO.O00000oo, 0, 0);
            } else if (i10 == 3) {
                oo00oo00.O00000o0(this.O000O0oO.O00000oo, this.O000OO00.O00000oo, 0, 8);
                oo00oo00.O00000o0(this.O000O0oO.O00000oo, this.O000Oo0.O000O0oO.O00000oo, 0, 4);
                oo00oo00.O00000o0(this.O000O0oO.O00000oo, this.O000Oo0.O000OO00.O00000oo, 0, 0);
            }
        }
    }
}
