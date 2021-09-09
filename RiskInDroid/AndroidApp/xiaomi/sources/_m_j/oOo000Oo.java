package _m_j;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public final class oOo000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    protected ConstraintWidget f2326O000000o;
    protected ConstraintWidget O00000Oo;
    protected ConstraintWidget O00000o;
    protected ConstraintWidget O00000o0;
    protected ConstraintWidget O00000oO;
    protected ConstraintWidget O00000oo;
    protected ConstraintWidget O0000O0o;
    protected ArrayList<ConstraintWidget> O0000OOo;
    protected int O0000Oo;
    protected int O0000Oo0;
    protected float O0000OoO = 0.0f;
    int O0000Ooo;
    protected boolean O0000o;
    int O0000o0;
    int O0000o00;
    boolean O0000o0O;
    protected boolean O0000o0o;
    protected boolean O0000oO;
    protected boolean O0000oO0;
    boolean O0000oOO;
    private int O0000oOo;
    private boolean O0000oo0 = false;

    public oOo000Oo(ConstraintWidget constraintWidget, int i, boolean z) {
        this.f2326O000000o = constraintWidget;
        this.O0000oOo = i;
        this.O0000oo0 = z;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0130, code lost:
        if (r5.O0000oo0 == 0) goto L_0x0134;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013a  */
    public final void O000000o() {
        int i;
        int i2 = this.O0000oOo * 2;
        ConstraintWidget constraintWidget = this.f2326O000000o;
        boolean z = true;
        this.O0000o0O = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        ConstraintWidget constraintWidget3 = constraintWidget2;
        boolean z2 = false;
        while (!z2) {
            this.O0000Oo0++;
            ConstraintWidget constraintWidget4 = null;
            constraintWidget2.O000oo0[this.O0000oOo] = null;
            constraintWidget2.O000oOoo[this.O0000oOo] = null;
            if (constraintWidget2.O000o0O != 8) {
                this.O0000Ooo++;
                if (constraintWidget2.O0000Oo(this.O0000oOo) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    int i3 = this.O0000o00;
                    int i4 = this.O0000oOo;
                    if (i4 == 0) {
                        i = constraintWidget2.O00000oO();
                    } else if (i4 == 1) {
                        i = constraintWidget2.O00000oo();
                    } else {
                        i = 0;
                    }
                    this.O0000o00 = i3 + i;
                }
                this.O0000o00 += constraintWidget2.O000OOo[i2].O00000o0();
                int i5 = i2 + 1;
                this.O0000o00 += constraintWidget2.O000OOo[i5].O00000o0();
                this.O0000o0 += constraintWidget2.O000OOo[i2].O00000o0();
                this.O0000o0 += constraintWidget2.O000OOo[i5].O00000o0();
                if (this.O00000Oo == null) {
                    this.O00000Oo = constraintWidget2;
                }
                this.O00000o = constraintWidget2;
                if (constraintWidget2.O000Oo00[this.O0000oOo] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget2.O0000o[this.O0000oOo] == 0 || constraintWidget2.O0000o[this.O0000oOo] == 3 || constraintWidget2.O0000o[this.O0000oOo] == 2) {
                        this.O0000Oo++;
                        float f = constraintWidget2.O000oOoO[this.O0000oOo];
                        if (f > 0.0f) {
                            this.O0000OoO += constraintWidget2.O000oOoO[this.O0000oOo];
                        }
                        int i6 = this.O0000oOo;
                        if (constraintWidget2.O000o0O != 8 && constraintWidget2.O000Oo00[i6] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (constraintWidget2.O0000o[i6] == 0 || constraintWidget2.O0000o[i6] == 3)) {
                            if (f < 0.0f) {
                                this.O0000o0o = true;
                            } else {
                                this.O0000o = true;
                            }
                            if (this.O0000OOo == null) {
                                this.O0000OOo = new ArrayList<>();
                            }
                            this.O0000OOo.add(constraintWidget2);
                        }
                        if (this.O00000oo == null) {
                            this.O00000oo = constraintWidget2;
                        }
                        ConstraintWidget constraintWidget5 = this.O0000O0o;
                        if (constraintWidget5 != null) {
                            constraintWidget5.O000oOoo[this.O0000oOo] = constraintWidget2;
                        }
                        this.O0000O0o = constraintWidget2;
                    }
                    if (this.O0000oOo == 0) {
                        if (constraintWidget2.O0000o0O == 0) {
                            if (!(constraintWidget2.O0000oO0 == 0 && constraintWidget2.O0000oO == 0)) {
                                this.O0000o0O = false;
                            }
                            if (constraintWidget2.O000OoO0 != 0.0f) {
                                this.O0000o0O = false;
                                this.O0000oO = true;
                            }
                        }
                    } else if (constraintWidget2.O0000o0o == 0) {
                        if (constraintWidget2.O0000oOo == 0) {
                        }
                    }
                    this.O0000o0O = false;
                    if (constraintWidget2.O000OoO0 != 0.0f) {
                    }
                }
            }
            if (constraintWidget3 != constraintWidget2) {
                constraintWidget3.O000oo0[this.O0000oOo] = constraintWidget2;
            }
            ConstraintAnchor constraintAnchor = constraintWidget2.O000OOo[i2 + 1].O00000o0;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget6 = constraintAnchor.f2787O000000o;
                if (constraintWidget6.O000OOo[i2].O00000o0 != null && constraintWidget6.O000OOo[i2].O00000o0.f2787O000000o == constraintWidget2) {
                    constraintWidget4 = constraintWidget6;
                }
            }
            if (constraintWidget4 != null) {
                constraintWidget3 = constraintWidget2;
                constraintWidget2 = constraintWidget4;
            } else {
                constraintWidget3 = constraintWidget2;
                z2 = true;
            }
        }
        ConstraintWidget constraintWidget7 = this.O00000Oo;
        if (constraintWidget7 != null) {
            this.O0000o00 -= constraintWidget7.O000OOo[i2].O00000o0();
        }
        ConstraintWidget constraintWidget8 = this.O00000o;
        if (constraintWidget8 != null) {
            this.O0000o00 -= constraintWidget8.O000OOo[i2 + 1].O00000o0();
        }
        this.O00000o0 = constraintWidget2;
        if (this.O0000oOo != 0 || !this.O0000oo0) {
            this.O00000oO = this.f2326O000000o;
        } else {
            this.O00000oO = this.O00000o0;
        }
        if (!this.O0000o || !this.O0000o0o) {
            z = false;
        }
        this.O0000oO0 = z;
    }
}
