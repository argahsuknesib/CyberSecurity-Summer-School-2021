package _m_j;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

public final class oOO0O000 extends WidgetRun {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int[] f2295O000000o = new int[2];

    public oOO0O000(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.O0000Oo.O00000oO = DependencyNode.Type.LEFT;
        this.O0000OoO.O00000oO = DependencyNode.Type.RIGHT;
        this.O0000OOo = 0;
    }

    public final String toString() {
        return "HorizontalRun " + this.O00000o.O000o0OO;
    }

    public final void O00000o0() {
        this.O00000oO = null;
        this.O0000Oo.O000000o();
        this.O0000OoO.O000000o();
        this.O0000O0o.O000000o();
        this.O0000Oo0 = false;
    }

    public final void O0000O0o() {
        this.O0000Oo0 = false;
        this.O0000Oo.O000000o();
        this.O0000Oo.O0000Oo = false;
        this.O0000OoO.O000000o();
        this.O0000OoO.O0000Oo = false;
        this.O0000O0o.O0000Oo = false;
    }

    public final boolean O000000o() {
        if (this.O00000oo != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.O00000o.O0000o0O == 0) {
            return true;
        }
        return false;
    }

    public final void O00000oo() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        if (this.O00000o.O00000o) {
            this.O0000O0o.O000000o(this.O00000o.O00000oO());
        }
        if (!this.O0000O0o.O0000Oo) {
            this.O00000oo = this.O00000o.O000Oo00[0];
            if (this.O00000oo != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (((constraintWidget2 = this.O00000o.O000Oo0) != null && constraintWidget2.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.FIXED) || constraintWidget2.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
                    int O00000oO = (constraintWidget2.O00000oO() - this.O00000o.O000O0o.O00000o0()) - this.O00000o.O000O0oo.O00000o0();
                    O000000o(this.O0000Oo, constraintWidget2.O0000OOo.O0000Oo, this.O00000o.O000O0o.O00000o0());
                    O000000o(this.O0000OoO, constraintWidget2.O0000OOo.O0000OoO, -this.O00000o.O000O0oo.O00000o0());
                    this.O0000O0o.O000000o(O00000oO);
                    return;
                } else if (this.O00000oo == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.O0000O0o.O000000o(this.O00000o.O00000oO());
                }
            }
        } else if (this.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (((constraintWidget = this.O00000o.O000Oo0) != null && constraintWidget.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.FIXED) || constraintWidget.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
            O000000o(this.O0000Oo, constraintWidget.O0000OOo.O0000Oo, this.O00000o.O000O0o.O00000o0());
            O000000o(this.O0000OoO, constraintWidget.O0000OOo.O0000OoO, -this.O00000o.O000O0oo.O00000o0());
            return;
        }
        if (!this.O0000O0o.O0000Oo || !this.O00000o.O00000o) {
            if (this.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int i = this.O00000o.O0000o0O;
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
                } else if (i == 3) {
                    if (this.O00000o.O0000o0o == 3) {
                        this.O0000Oo.f2791O000000o = this;
                        this.O0000OoO.f2791O000000o = this;
                        this.O00000o.O0000Oo0.O0000Oo.f2791O000000o = this;
                        this.O00000o.O0000Oo0.O0000OoO.f2791O000000o = this;
                        this.O0000O0o.f2791O000000o = this;
                        if (this.O00000o.O0000o0()) {
                            this.O0000O0o.O0000Ooo.add(this.O00000o.O0000Oo0.O0000O0o);
                            this.O00000o.O0000Oo0.O0000O0o.O0000OoO.add(this.O0000O0o);
                            this.O00000o.O0000Oo0.O0000O0o.f2791O000000o = this;
                            this.O0000O0o.O0000Ooo.add(this.O00000o.O0000Oo0.O0000Oo);
                            this.O0000O0o.O0000Ooo.add(this.O00000o.O0000Oo0.O0000OoO);
                            this.O00000o.O0000Oo0.O0000Oo.O0000OoO.add(this.O0000O0o);
                            this.O00000o.O0000Oo0.O0000OoO.O0000OoO.add(this.O0000O0o);
                        } else if (this.O00000o.O0000o00()) {
                            this.O00000o.O0000Oo0.O0000O0o.O0000Ooo.add(this.O0000O0o);
                            this.O0000O0o.O0000OoO.add(this.O00000o.O0000Oo0.O0000O0o);
                        } else {
                            this.O00000o.O0000Oo0.O0000O0o.O0000Ooo.add(this.O0000O0o);
                        }
                    } else {
                        oOO00000 ooo000002 = this.O00000o.O0000Oo0.O0000O0o;
                        this.O0000O0o.O0000Ooo.add(ooo000002);
                        ooo000002.O0000OoO.add(this.O0000O0o);
                        this.O00000o.O0000Oo0.O0000Oo.O0000OoO.add(this.O0000O0o);
                        this.O00000o.O0000Oo0.O0000OoO.O0000OoO.add(this.O0000O0o);
                        this.O0000O0o.O00000Oo = true;
                        this.O0000O0o.O0000OoO.add(this.O0000Oo);
                        this.O0000O0o.O0000OoO.add(this.O0000OoO);
                        this.O0000Oo.O0000Ooo.add(this.O0000O0o);
                        this.O0000OoO.O0000Ooo.add(this.O0000O0o);
                    }
                }
            }
            if (this.O00000o.O000OOo[0].O00000o0 == null || this.O00000o.O000OOo[1].O00000o0 == null) {
                if (this.O00000o.O000OOo[0].O00000o0 != null) {
                    DependencyNode O000000o2 = O000000o(this.O00000o.O000OOo[0]);
                    if (O000000o2 != null) {
                        O000000o(this.O0000Oo, O000000o2, this.O00000o.O000OOo[0].O00000o0());
                        O000000o(this.O0000OoO, this.O0000Oo, 1, this.O0000O0o);
                    }
                } else if (this.O00000o.O000OOo[1].O00000o0 != null) {
                    DependencyNode O000000o3 = O000000o(this.O00000o.O000OOo[1]);
                    if (O000000o3 != null) {
                        O000000o(this.O0000OoO, O000000o3, -this.O00000o.O000OOo[1].O00000o0());
                        O000000o(this.O0000Oo, this.O0000OoO, -1, this.O0000O0o);
                    }
                } else if (!(this.O00000o instanceof oO0O00Oo) && this.O00000o.O000Oo0 != null) {
                    O000000o(this.O0000Oo, this.O00000o.O000Oo0.O0000OOo.O0000Oo, this.O00000o.O00000o0());
                    O000000o(this.O0000OoO, this.O0000Oo, 1, this.O0000O0o);
                }
            } else if (this.O00000o.O0000o00()) {
                this.O0000Oo.O00000oo = this.O00000o.O000OOo[0].O00000o0();
                this.O0000OoO.O00000oo = -this.O00000o.O000OOo[1].O00000o0();
            } else {
                DependencyNode O000000o4 = O000000o(this.O00000o.O000OOo[0]);
                DependencyNode O000000o5 = O000000o(this.O00000o.O000OOo[1]);
                O000000o4.O000000o(this);
                O000000o5.O000000o(this);
                this.O0000Ooo = WidgetRun.RunType.CENTER;
            }
        } else if (this.O00000o.O000OOo[0].O00000o0 == null || this.O00000o.O000OOo[1].O00000o0 == null) {
            if (this.O00000o.O000OOo[0].O00000o0 != null) {
                DependencyNode O000000o6 = O000000o(this.O00000o.O000OOo[0]);
                if (O000000o6 != null) {
                    O000000o(this.O0000Oo, O000000o6, this.O00000o.O000OOo[0].O00000o0());
                    O000000o(this.O0000OoO, this.O0000Oo, this.O0000O0o.O0000O0o);
                }
            } else if (this.O00000o.O000OOo[1].O00000o0 != null) {
                DependencyNode O000000o7 = O000000o(this.O00000o.O000OOo[1]);
                if (O000000o7 != null) {
                    O000000o(this.O0000OoO, O000000o7, -this.O00000o.O000OOo[1].O00000o0());
                    O000000o(this.O0000Oo, this.O0000OoO, -this.O0000O0o.O0000O0o);
                }
            } else if (!(this.O00000o instanceof oO0O00Oo) && this.O00000o.O000Oo0 != null && this.O00000o.O000000o(ConstraintAnchor.Type.CENTER).O00000o0 == null) {
                O000000o(this.O0000Oo, this.O00000o.O000Oo0.O0000OOo.O0000Oo, this.O00000o.O00000o0());
                O000000o(this.O0000OoO, this.O0000Oo, this.O0000O0o.O0000O0o);
            }
        } else if (this.O00000o.O0000o00()) {
            this.O0000Oo.O00000oo = this.O00000o.O000OOo[0].O00000o0();
            this.O0000OoO.O00000oo = -this.O00000o.O000OOo[1].O00000o0();
        } else {
            DependencyNode O000000o8 = O000000o(this.O00000o.O000OOo[0]);
            if (O000000o8 != null) {
                O000000o(this.O0000Oo, O000000o8, this.O00000o.O000OOo[0].O00000o0());
            }
            DependencyNode O000000o9 = O000000o(this.O00000o.O000OOo[1]);
            if (O000000o9 != null) {
                O000000o(this.O0000OoO, O000000o9, -this.O00000o.O000OOo[1].O00000o0());
            }
            this.O0000Oo.O00000Oo = true;
            this.O0000OoO.O00000Oo = true;
        }
    }

    private static void O000000o(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 == -1) {
            int i8 = (int) ((((float) i7) * f) + 0.5f);
            int i9 = (int) ((((float) i6) / f) + 0.5f);
            if (i8 <= i6 && i7 <= i7) {
                iArr[0] = i8;
                iArr[1] = i7;
            } else if (i6 <= i6 && i9 <= i7) {
                iArr[0] = i6;
                iArr[1] = i9;
            }
        } else if (i5 == 0) {
            iArr[0] = (int) ((((float) i7) * f) + 0.5f);
            iArr[1] = i7;
        } else if (i5 == 1) {
            iArr[0] = i6;
            iArr[1] = (int) ((((float) i6) * f) + 0.5f);
        }
    }

    /* renamed from: _m_j.oOO0O000$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2296O000000o = new int[WidgetRun.RunType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f2296O000000o[WidgetRun.RunType.START.ordinal()] = 1;
            f2296O000000o[WidgetRun.RunType.END.ordinal()] = 2;
            try {
                f2296O000000o[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02d0, code lost:
        if (r11 != 1) goto L_0x033c;
     */
    public final void O00000o() {
        int i;
        float f;
        float f2;
        float f3;
        int i2 = AnonymousClass1.f2296O000000o[this.O0000Ooo.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 != 3) {
            if (!this.O0000O0o.O0000Oo && this.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int i3 = this.O00000o.O0000o0O;
                if (i3 == 2) {
                    ConstraintWidget constraintWidget = this.O00000o.O000Oo0;
                    if (constraintWidget != null && constraintWidget.O0000OOo.O0000O0o.O0000Oo) {
                        this.O0000O0o.O000000o((int) ((((float) constraintWidget.O0000OOo.O0000O0o.O0000O0o) * this.O00000o.O0000oOO) + 0.5f));
                    }
                } else if (i3 == 3) {
                    if (this.O00000o.O0000o0o == 0 || this.O00000o.O0000o0o == 3) {
                        DependencyNode dependencyNode = this.O00000o.O0000Oo0.O0000Oo;
                        DependencyNode dependencyNode2 = this.O00000o.O0000Oo0.O0000OoO;
                        boolean z = this.O00000o.O000O0o.O00000o0 != null;
                        boolean z2 = this.O00000o.O000O0oO.O00000o0 != null;
                        boolean z3 = this.O00000o.O000O0oo.O00000o0 != null;
                        boolean z4 = this.O00000o.O000OO00.O00000o0 != null;
                        int O0000OoO = this.O00000o.O0000OoO();
                        if (z && z2 && z3 && z4) {
                            float f4 = this.O00000o.O000OoO0;
                            if (!dependencyNode.O0000Oo || !dependencyNode2.O0000Oo) {
                                if (this.O0000Oo.O0000Oo && this.O0000OoO.O0000Oo) {
                                    if (dependencyNode.O00000o0 && dependencyNode2.O00000o0) {
                                        O000000o(f2295O000000o, this.O0000Oo.O0000O0o + this.O0000Oo.O00000oo, this.O0000OoO.O0000O0o - this.O0000OoO.O00000oo, dependencyNode.O0000Ooo.get(0).O0000O0o + dependencyNode.O00000oo, dependencyNode2.O0000Ooo.get(0).O0000O0o - dependencyNode2.O00000oo, f4, O0000OoO);
                                        this.O0000O0o.O000000o(f2295O000000o[0]);
                                        this.O00000o.O0000Oo0.O0000O0o.O000000o(f2295O000000o[1]);
                                    } else {
                                        return;
                                    }
                                }
                                if (this.O0000Oo.O00000o0 && this.O0000OoO.O00000o0 && dependencyNode.O00000o0 && dependencyNode2.O00000o0) {
                                    O000000o(f2295O000000o, this.O0000Oo.O0000Ooo.get(0).O0000O0o + this.O0000Oo.O00000oo, this.O0000OoO.O0000Ooo.get(0).O0000O0o - this.O0000OoO.O00000oo, dependencyNode.O0000Ooo.get(0).O0000O0o + dependencyNode.O00000oo, dependencyNode2.O0000Ooo.get(0).O0000O0o - dependencyNode2.O00000oo, f4, O0000OoO);
                                    this.O0000O0o.O000000o(f2295O000000o[0]);
                                    this.O00000o.O0000Oo0.O0000O0o.O000000o(f2295O000000o[1]);
                                } else {
                                    return;
                                }
                            } else if (this.O0000Oo.O00000o0 && this.O0000OoO.O00000o0) {
                                O000000o(f2295O000000o, this.O0000Oo.O0000Ooo.get(0).O0000O0o + this.O0000Oo.O00000oo, this.O0000OoO.O0000Ooo.get(0).O0000O0o - this.O0000OoO.O00000oo, dependencyNode.O0000O0o + dependencyNode.O00000oo, dependencyNode2.O0000O0o - dependencyNode2.O00000oo, f4, O0000OoO);
                                this.O0000O0o.O000000o(f2295O000000o[0]);
                                this.O00000o.O0000Oo0.O0000O0o.O000000o(f2295O000000o[1]);
                                return;
                            } else {
                                return;
                            }
                        } else if (!z || !z3) {
                            if (z2 && z4) {
                                if (dependencyNode.O00000o0 && dependencyNode2.O00000o0) {
                                    float f5 = this.O00000o.O000OoO0;
                                    int i4 = dependencyNode.O0000Ooo.get(0).O0000O0o + dependencyNode.O00000oo;
                                    int i5 = dependencyNode2.O0000Ooo.get(0).O0000O0o - dependencyNode2.O00000oo;
                                    if (O0000OoO != -1) {
                                        if (O0000OoO == 0) {
                                            int O000000o2 = O000000o(i5 - i4, 1);
                                            int i6 = (int) ((((float) O000000o2) * f5) + 0.5f);
                                            int O000000o3 = O000000o(i6, 0);
                                            if (i6 != O000000o3) {
                                                O000000o2 = (int) ((((float) O000000o3) / f5) + 0.5f);
                                            }
                                            this.O0000O0o.O000000o(O000000o3);
                                            this.O00000o.O0000Oo0.O0000O0o.O000000o(O000000o2);
                                        }
                                    }
                                    int O000000o4 = O000000o(i5 - i4, 1);
                                    int i7 = (int) ((((float) O000000o4) / f5) + 0.5f);
                                    int O000000o5 = O000000o(i7, 0);
                                    if (i7 != O000000o5) {
                                        O000000o4 = (int) ((((float) O000000o5) * f5) + 0.5f);
                                    }
                                    this.O0000O0o.O000000o(O000000o5);
                                    this.O00000o.O0000Oo0.O0000O0o.O000000o(O000000o4);
                                } else {
                                    return;
                                }
                            }
                        } else if (this.O0000Oo.O00000o0 && this.O0000OoO.O00000o0) {
                            float f6 = this.O00000o.O000OoO0;
                            int i8 = this.O0000Oo.O0000Ooo.get(0).O0000O0o + this.O0000Oo.O00000oo;
                            int i9 = this.O0000OoO.O0000Ooo.get(0).O0000O0o - this.O0000OoO.O00000oo;
                            if (O0000OoO == -1 || O0000OoO == 0) {
                                int O000000o6 = O000000o(i9 - i8, 0);
                                int i10 = (int) ((((float) O000000o6) * f6) + 0.5f);
                                int O000000o7 = O000000o(i10, 1);
                                if (i10 != O000000o7) {
                                    O000000o6 = (int) ((((float) O000000o7) / f6) + 0.5f);
                                }
                                this.O0000O0o.O000000o(O000000o6);
                                this.O00000o.O0000Oo0.O0000O0o.O000000o(O000000o7);
                            } else if (O0000OoO == 1) {
                                int O000000o8 = O000000o(i9 - i8, 0);
                                int i11 = (int) ((((float) O000000o8) / f6) + 0.5f);
                                int O000000o9 = O000000o(i11, 1);
                                if (i11 != O000000o9) {
                                    O000000o8 = (int) ((((float) O000000o9) * f6) + 0.5f);
                                }
                                this.O0000O0o.O000000o(O000000o8);
                                this.O00000o.O0000Oo0.O0000O0o.O000000o(O000000o9);
                            }
                        } else {
                            return;
                        }
                    } else {
                        int O0000OoO2 = this.O00000o.O0000OoO();
                        if (O0000OoO2 == -1) {
                            f3 = (float) this.O00000o.O0000Oo0.O0000O0o.O0000O0o;
                            f2 = this.O00000o.O000OoO0;
                        } else if (O0000OoO2 == 0) {
                            f = ((float) this.O00000o.O0000Oo0.O0000O0o.O0000O0o) / this.O00000o.O000OoO0;
                            i = (int) (f + 0.5f);
                            this.O0000O0o.O000000o(i);
                        } else if (O0000OoO2 != 1) {
                            i = 0;
                            this.O0000O0o.O000000o(i);
                        } else {
                            f3 = (float) this.O00000o.O0000Oo0.O0000O0o.O0000O0o;
                            f2 = this.O00000o.O000OoO0;
                        }
                        f = f3 * f2;
                        i = (int) (f + 0.5f);
                        this.O0000O0o.O000000o(i);
                    }
                }
            }
            if (this.O0000Oo.O00000o0 && this.O0000OoO.O00000o0) {
                if (this.O0000Oo.O0000Oo && this.O0000OoO.O0000Oo && this.O0000O0o.O0000Oo) {
                    return;
                }
                if (this.O0000O0o.O0000Oo || this.O00000oo != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.O00000o.O0000o0O != 0 || this.O00000o.O0000o00()) {
                    if (!this.O0000O0o.O0000Oo && this.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.O00000o0 == 1 && this.O0000Oo.O0000Ooo.size() > 0 && this.O0000OoO.O0000Ooo.size() > 0) {
                        int min = Math.min((this.O0000OoO.O0000Ooo.get(0).O0000O0o + this.O0000OoO.O00000oo) - (this.O0000Oo.O0000Ooo.get(0).O0000O0o + this.O0000Oo.O00000oo), this.O0000O0o.O0000o00);
                        int i12 = this.O00000o.O0000oO;
                        int max = Math.max(this.O00000o.O0000oO0, min);
                        if (i12 > 0) {
                            max = Math.min(i12, max);
                        }
                        this.O0000O0o.O000000o(max);
                    }
                    if (this.O0000O0o.O0000Oo) {
                        DependencyNode dependencyNode3 = this.O0000Oo.O0000Ooo.get(0);
                        DependencyNode dependencyNode4 = this.O0000OoO.O0000Ooo.get(0);
                        int i13 = dependencyNode3.O0000O0o + this.O0000Oo.O00000oo;
                        int i14 = dependencyNode4.O0000O0o + this.O0000OoO.O00000oo;
                        float f7 = this.O00000o.O000o00o;
                        if (dependencyNode3 == dependencyNode4) {
                            i13 = dependencyNode3.O0000O0o;
                            i14 = dependencyNode4.O0000O0o;
                            f7 = 0.5f;
                        }
                        this.O0000Oo.O000000o((int) (((float) i13) + 0.5f + (((float) ((i14 - i13) - this.O0000O0o.O0000O0o)) * f7)));
                        this.O0000OoO.O000000o(this.O0000Oo.O0000O0o + this.O0000O0o.O0000O0o);
                        return;
                    }
                    return;
                }
                int i15 = this.O0000Oo.O0000Ooo.get(0).O0000O0o + this.O0000Oo.O00000oo;
                int i16 = this.O0000OoO.O0000Ooo.get(0).O0000O0o + this.O0000OoO.O00000oo;
                this.O0000Oo.O000000o(i15);
                this.O0000OoO.O000000o(i16);
                this.O0000O0o.O000000o(i16 - i15);
                return;
            }
            return;
        }
        O000000o(this.O00000o.O000O0o, this.O00000o.O000O0oo, 0);
    }

    public final void O00000oO() {
        if (this.O0000Oo.O0000Oo) {
            this.O00000o.O00000o0(this.O0000Oo.O0000O0o);
        }
    }
}
