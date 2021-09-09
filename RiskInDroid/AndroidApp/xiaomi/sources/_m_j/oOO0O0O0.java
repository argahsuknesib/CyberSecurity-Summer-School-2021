package _m_j;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

public final class oOO0O0O0 extends WidgetRun {

    /* renamed from: O000000o  reason: collision with root package name */
    public DependencyNode f2298O000000o = new DependencyNode(this);
    oOO00000 O00000Oo = null;

    public oOO0O0O0(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.O0000Oo.O00000oO = DependencyNode.Type.TOP;
        this.O0000OoO.O00000oO = DependencyNode.Type.BOTTOM;
        this.f2298O000000o.O00000oO = DependencyNode.Type.BASELINE;
        this.O0000OOo = 1;
    }

    public final String toString() {
        return "VerticalRun " + this.O00000o.O000o0OO;
    }

    public final void O00000o0() {
        this.O00000oO = null;
        this.O0000Oo.O000000o();
        this.O0000OoO.O000000o();
        this.f2298O000000o.O000000o();
        this.O0000O0o.O000000o();
        this.O0000Oo0 = false;
    }

    public final void O0000O0o() {
        this.O0000Oo0 = false;
        this.O0000Oo.O000000o();
        this.O0000Oo.O0000Oo = false;
        this.O0000OoO.O000000o();
        this.O0000OoO.O0000Oo = false;
        this.f2298O000000o.O000000o();
        this.f2298O000000o.O0000Oo = false;
        this.O0000O0o.O0000Oo = false;
    }

    public final boolean O000000o() {
        if (this.O00000oo != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.O00000o.O0000o0o == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: _m_j.oOO0O0O0$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2299O000000o = new int[WidgetRun.RunType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f2299O000000o[WidgetRun.RunType.START.ordinal()] = 1;
            f2299O000000o[WidgetRun.RunType.END.ordinal()] = 2;
            try {
                f2299O000000o[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void O00000o() {
        int i;
        float f;
        float f2;
        float f3;
        int i2 = AnonymousClass1.f2299O000000o[this.O0000Ooo.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 != 3) {
            if (this.O0000O0o.O00000o0 && !this.O0000O0o.O0000Oo && this.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int i3 = this.O00000o.O0000o0o;
                if (i3 == 2) {
                    ConstraintWidget constraintWidget = this.O00000o.O000Oo0;
                    if (constraintWidget != null && constraintWidget.O0000Oo0.O0000O0o.O0000Oo) {
                        float f4 = this.O00000o.O0000oo;
                        this.O0000O0o.O000000o((int) ((((float) constraintWidget.O0000Oo0.O0000O0o.O0000O0o) * f4) + 0.5f));
                    }
                } else if (i3 == 3 && this.O00000o.O0000OOo.O0000O0o.O0000Oo) {
                    int O0000OoO = this.O00000o.O0000OoO();
                    if (O0000OoO == -1) {
                        f3 = (float) this.O00000o.O0000OOo.O0000O0o.O0000O0o;
                        f2 = this.O00000o.O000OoO0;
                    } else if (O0000OoO == 0) {
                        f = ((float) this.O00000o.O0000OOo.O0000O0o.O0000O0o) * this.O00000o.O000OoO0;
                        i = (int) (f + 0.5f);
                        this.O0000O0o.O000000o(i);
                    } else if (O0000OoO != 1) {
                        i = 0;
                        this.O0000O0o.O000000o(i);
                    } else {
                        f3 = (float) this.O00000o.O0000OOo.O0000O0o.O0000O0o;
                        f2 = this.O00000o.O000OoO0;
                    }
                    f = f3 / f2;
                    i = (int) (f + 0.5f);
                    this.O0000O0o.O000000o(i);
                }
            }
            if (this.O0000Oo.O00000o0 && this.O0000OoO.O00000o0) {
                if (this.O0000Oo.O0000Oo && this.O0000OoO.O0000Oo && this.O0000O0o.O0000Oo) {
                    return;
                }
                if (this.O0000O0o.O0000Oo || this.O00000oo != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.O00000o.O0000o0O != 0 || this.O00000o.O0000o0()) {
                    if (!this.O0000O0o.O0000Oo && this.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.O00000o0 == 1 && this.O0000Oo.O0000Ooo.size() > 0 && this.O0000OoO.O0000Ooo.size() > 0) {
                        int i4 = (this.O0000OoO.O0000Ooo.get(0).O0000O0o + this.O0000OoO.O00000oo) - (this.O0000Oo.O0000Ooo.get(0).O0000O0o + this.O0000Oo.O00000oo);
                        if (i4 < this.O0000O0o.O0000o00) {
                            this.O0000O0o.O000000o(i4);
                        } else {
                            this.O0000O0o.O000000o(this.O0000O0o.O0000o00);
                        }
                    }
                    if (this.O0000O0o.O0000Oo && this.O0000Oo.O0000Ooo.size() > 0 && this.O0000OoO.O0000Ooo.size() > 0) {
                        DependencyNode dependencyNode = this.O0000Oo.O0000Ooo.get(0);
                        DependencyNode dependencyNode2 = this.O0000OoO.O0000Ooo.get(0);
                        int i5 = dependencyNode.O0000O0o + this.O0000Oo.O00000oo;
                        int i6 = dependencyNode2.O0000O0o + this.O0000OoO.O00000oo;
                        float f5 = this.O00000o.O000o0;
                        if (dependencyNode == dependencyNode2) {
                            i5 = dependencyNode.O0000O0o;
                            i6 = dependencyNode2.O0000O0o;
                            f5 = 0.5f;
                        }
                        this.O0000Oo.O000000o((int) (((float) i5) + 0.5f + (((float) ((i6 - i5) - this.O0000O0o.O0000O0o)) * f5)));
                        this.O0000OoO.O000000o(this.O0000Oo.O0000O0o + this.O0000O0o.O0000O0o);
                        return;
                    }
                    return;
                }
                int i7 = this.O0000Oo.O0000Ooo.get(0).O0000O0o + this.O0000Oo.O00000oo;
                int i8 = this.O0000OoO.O0000Ooo.get(0).O0000O0o + this.O0000OoO.O00000oo;
                this.O0000Oo.O000000o(i7);
                this.O0000OoO.O000000o(i8);
                this.O0000O0o.O000000o(i8 - i7);
                return;
            }
            return;
        }
        O000000o(this.O00000o.O000O0oO, this.O00000o.O000OO00, 1);
    }

    public final void O00000oo() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        if (this.O00000o.O00000o) {
            this.O0000O0o.O000000o(this.O00000o.O00000oo());
        }
        if (!this.O0000O0o.O0000Oo) {
            this.O00000oo = this.O00000o.O000Oo00[1];
            if (this.O00000o.O000O0Oo) {
                this.O00000Oo = new oOo0o0oO(this);
            }
            if (this.O00000oo != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidget2 = this.O00000o.O000Oo0) != null && constraintWidget2.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int O00000oo = (constraintWidget2.O00000oo() - this.O00000o.O000O0oO.O00000o0()) - this.O00000o.O000OO00.O00000o0();
                    O000000o(this.O0000Oo, constraintWidget2.O0000Oo0.O0000Oo, this.O00000o.O000O0oO.O00000o0());
                    O000000o(this.O0000OoO, constraintWidget2.O0000Oo0.O0000OoO, -this.O00000o.O000OO00.O00000o0());
                    this.O0000O0o.O000000o(O00000oo);
                    return;
                } else if (this.O00000oo == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.O0000O0o.O000000o(this.O00000o.O00000oo());
                }
            }
        } else if (this.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidget = this.O00000o.O000Oo0) != null && constraintWidget.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.FIXED) {
            O000000o(this.O0000Oo, constraintWidget.O0000Oo0.O0000Oo, this.O00000o.O000O0oO.O00000o0());
            O000000o(this.O0000OoO, constraintWidget.O0000Oo0.O0000OoO, -this.O00000o.O000OO00.O00000o0());
            return;
        }
        if (!this.O0000O0o.O0000Oo || !this.O00000o.O00000o) {
            if (this.O0000O0o.O0000Oo || this.O00000oo != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.O0000O0o.O000000o(this);
            } else {
                int i = this.O00000o.O0000o0o;
                if (i == 2) {
                    ConstraintWidget constraintWidget3 = this.O00000o.O000Oo0;
                    if (constraintWidget3 != null) {
                        oOO00000 ooo00000 = constraintWidget3.O0000Oo0.O0000O0o;
                        this.O0000O0o.O0000Ooo.add(ooo00000);
                        ooo00000.O0000OoO.add(this.O0000O0o);
                        this.O0000O0o.O00000Oo = true;
                        this.O0000O0o.O0000OoO.add(this.O0000Oo);
                        this.O0000O0o.O0000OoO.add(this.O0000OoO);
                    }
                } else if (i == 3 && !this.O00000o.O0000o0() && this.O00000o.O0000o0O != 3) {
                    oOO00000 ooo000002 = this.O00000o.O0000OOo.O0000O0o;
                    this.O0000O0o.O0000Ooo.add(ooo000002);
                    ooo000002.O0000OoO.add(this.O0000O0o);
                    this.O0000O0o.O00000Oo = true;
                    this.O0000O0o.O0000OoO.add(this.O0000Oo);
                    this.O0000O0o.O0000OoO.add(this.O0000OoO);
                }
            }
            if (this.O00000o.O000OOo[2].O00000o0 != null && this.O00000o.O000OOo[3].O00000o0 != null) {
                if (this.O00000o.O0000o0()) {
                    this.O0000Oo.O00000oo = this.O00000o.O000OOo[2].O00000o0();
                    this.O0000OoO.O00000oo = -this.O00000o.O000OOo[3].O00000o0();
                } else {
                    DependencyNode O000000o2 = O000000o(this.O00000o.O000OOo[2]);
                    DependencyNode O000000o3 = O000000o(this.O00000o.O000OOo[3]);
                    O000000o2.O000000o(this);
                    O000000o3.O000000o(this);
                    this.O0000Ooo = WidgetRun.RunType.CENTER;
                }
                if (this.O00000o.O000O0Oo) {
                    O000000o(this.f2298O000000o, this.O0000Oo, 1, this.O00000Oo);
                }
            } else if (this.O00000o.O000OOo[2].O00000o0 != null) {
                DependencyNode O000000o4 = O000000o(this.O00000o.O000OOo[2]);
                if (O000000o4 != null) {
                    O000000o(this.O0000Oo, O000000o4, this.O00000o.O000OOo[2].O00000o0());
                    O000000o(this.O0000OoO, this.O0000Oo, 1, this.O0000O0o);
                    if (this.O00000o.O000O0Oo) {
                        O000000o(this.f2298O000000o, this.O0000Oo, 1, this.O00000Oo);
                    }
                    if (this.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.O00000o.O000OoO0 > 0.0f && this.O00000o.O0000OOo.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        this.O00000o.O0000OOo.O0000O0o.O0000OoO.add(this.O0000O0o);
                        this.O0000O0o.O0000Ooo.add(this.O00000o.O0000OOo.O0000O0o);
                        this.O0000O0o.f2791O000000o = this;
                    }
                }
            } else if (this.O00000o.O000OOo[3].O00000o0 != null) {
                DependencyNode O000000o5 = O000000o(this.O00000o.O000OOo[3]);
                if (O000000o5 != null) {
                    O000000o(this.O0000OoO, O000000o5, -this.O00000o.O000OOo[3].O00000o0());
                    O000000o(this.O0000Oo, this.O0000OoO, -1, this.O0000O0o);
                    if (this.O00000o.O000O0Oo) {
                        O000000o(this.f2298O000000o, this.O0000Oo, 1, this.O00000Oo);
                    }
                }
            } else if (this.O00000o.O000OOo[4].O00000o0 != null) {
                DependencyNode O000000o6 = O000000o(this.O00000o.O000OOo[4]);
                if (O000000o6 != null) {
                    O000000o(this.f2298O000000o, O000000o6, 0);
                    O000000o(this.O0000Oo, this.f2298O000000o, -1, this.O00000Oo);
                    O000000o(this.O0000OoO, this.O0000Oo, 1, this.O0000O0o);
                }
            } else if (!(this.O00000o instanceof oO0O00Oo) && this.O00000o.O000Oo0 != null) {
                O000000o(this.O0000Oo, this.O00000o.O000Oo0.O0000Oo0.O0000Oo, this.O00000o.O00000o());
                O000000o(this.O0000OoO, this.O0000Oo, 1, this.O0000O0o);
                if (this.O00000o.O000O0Oo) {
                    O000000o(this.f2298O000000o, this.O0000Oo, 1, this.O00000Oo);
                }
                if (this.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.O00000o.O000OoO0 > 0.0f && this.O00000o.O0000OOo.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.O00000o.O0000OOo.O0000O0o.O0000OoO.add(this.O0000O0o);
                    this.O0000O0o.O0000Ooo.add(this.O00000o.O0000OOo.O0000O0o);
                    this.O0000O0o.f2791O000000o = this;
                }
            }
            if (this.O0000O0o.O0000Ooo.size() == 0) {
                this.O0000O0o.O00000o0 = true;
            }
        } else if (this.O00000o.O000OOo[2].O00000o0 != null && this.O00000o.O000OOo[3].O00000o0 != null) {
            if (this.O00000o.O0000o0()) {
                this.O0000Oo.O00000oo = this.O00000o.O000OOo[2].O00000o0();
                this.O0000OoO.O00000oo = -this.O00000o.O000OOo[3].O00000o0();
            } else {
                DependencyNode O000000o7 = O000000o(this.O00000o.O000OOo[2]);
                if (O000000o7 != null) {
                    O000000o(this.O0000Oo, O000000o7, this.O00000o.O000OOo[2].O00000o0());
                }
                DependencyNode O000000o8 = O000000o(this.O00000o.O000OOo[3]);
                if (O000000o8 != null) {
                    O000000o(this.O0000OoO, O000000o8, -this.O00000o.O000OOo[3].O00000o0());
                }
                this.O0000Oo.O00000Oo = true;
                this.O0000OoO.O00000Oo = true;
            }
            if (this.O00000o.O000O0Oo) {
                O000000o(this.f2298O000000o, this.O0000Oo, this.O00000o.O000Oooo);
            }
        } else if (this.O00000o.O000OOo[2].O00000o0 != null) {
            DependencyNode O000000o9 = O000000o(this.O00000o.O000OOo[2]);
            if (O000000o9 != null) {
                O000000o(this.O0000Oo, O000000o9, this.O00000o.O000OOo[2].O00000o0());
                O000000o(this.O0000OoO, this.O0000Oo, this.O0000O0o.O0000O0o);
                if (this.O00000o.O000O0Oo) {
                    O000000o(this.f2298O000000o, this.O0000Oo, this.O00000o.O000Oooo);
                }
            }
        } else if (this.O00000o.O000OOo[3].O00000o0 != null) {
            DependencyNode O000000o10 = O000000o(this.O00000o.O000OOo[3]);
            if (O000000o10 != null) {
                O000000o(this.O0000OoO, O000000o10, -this.O00000o.O000OOo[3].O00000o0());
                O000000o(this.O0000Oo, this.O0000OoO, -this.O0000O0o.O0000O0o);
            }
            if (this.O00000o.O000O0Oo) {
                O000000o(this.f2298O000000o, this.O0000Oo, this.O00000o.O000Oooo);
            }
        } else if (this.O00000o.O000OOo[4].O00000o0 != null) {
            DependencyNode O000000o11 = O000000o(this.O00000o.O000OOo[4]);
            if (O000000o11 != null) {
                O000000o(this.f2298O000000o, O000000o11, 0);
                O000000o(this.O0000Oo, this.f2298O000000o, -this.O00000o.O000Oooo);
                O000000o(this.O0000OoO, this.O0000Oo, this.O0000O0o.O0000O0o);
            }
        } else if (!(this.O00000o instanceof oO0O00Oo) && this.O00000o.O000Oo0 != null && this.O00000o.O000000o(ConstraintAnchor.Type.CENTER).O00000o0 == null) {
            O000000o(this.O0000Oo, this.O00000o.O000Oo0.O0000Oo0.O0000Oo, this.O00000o.O00000o());
            O000000o(this.O0000OoO, this.O0000Oo, this.O0000O0o.O0000O0o);
            if (this.O00000o.O000O0Oo) {
                O000000o(this.f2298O000000o, this.O0000Oo, this.O00000o.O000Oooo);
            }
        }
    }

    public final void O00000oO() {
        if (this.O0000Oo.O0000Oo) {
            this.O00000o.O00000o(this.O0000Oo.O0000O0o);
        }
    }
}
