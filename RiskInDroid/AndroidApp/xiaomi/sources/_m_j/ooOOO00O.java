package _m_j;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Iterator;

public final class ooOOO00O extends WidgetRun {

    /* renamed from: O000000o  reason: collision with root package name */
    ArrayList<WidgetRun> f2361O000000o = new ArrayList<>();
    private int O00000Oo;

    public ooOOO00O(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.O0000OOo = i;
        O0000O0o();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.O0000OOo == 0 ? "horizontal : " : "vertical : ");
        String sb2 = sb.toString();
        Iterator<WidgetRun> it = this.f2361O000000o.iterator();
        while (it.hasNext()) {
            sb2 = ((sb2 + "<") + it.next()) + "> ";
        }
        return sb2;
    }

    public final boolean O000000o() {
        int size = this.f2361O000000o.size();
        for (int i = 0; i < size; i++) {
            if (!this.f2361O000000o.get(i).O000000o()) {
                return false;
            }
        }
        return true;
    }

    public final long O00000Oo() {
        int size = this.f2361O000000o.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = this.f2361O000000o.get(i);
            j = j + ((long) widgetRun.O0000Oo.O00000oo) + widgetRun.O00000Oo() + ((long) widgetRun.O0000OoO.O00000oo);
        }
        return j;
    }

    private void O0000O0o() {
        ConstraintWidget constraintWidget;
        int i;
        ConstraintWidget constraintWidget2 = this.O00000o;
        ConstraintWidget O0000OoO = constraintWidget2.O0000OoO(this.O0000OOo);
        while (true) {
            ConstraintWidget constraintWidget3 = O0000OoO;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            }
            O0000OoO = constraintWidget2.O0000OoO(this.O0000OOo);
        }
        this.O00000o = constraintWidget;
        this.f2361O000000o.add(constraintWidget.O000000o(this.O0000OOo));
        ConstraintWidget O0000Ooo = constraintWidget.O0000Ooo(this.O0000OOo);
        while (O0000Ooo != null) {
            this.f2361O000000o.add(O0000Ooo.O000000o(this.O0000OOo));
            O0000Ooo = O0000Ooo.O0000Ooo(this.O0000OOo);
        }
        Iterator<WidgetRun> it = this.f2361O000000o.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            if (this.O0000OOo == 0) {
                next.O00000o.O00000oo = this;
            } else if (this.O0000OOo == 1) {
                next.O00000o.O0000O0o = this;
            }
        }
        if ((this.O0000OOo == 0 && ((oOo0000O) this.O00000o.O000Oo0).O000oo) && this.f2361O000000o.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.f2361O000000o;
            this.O00000o = arrayList.get(arrayList.size() - 1).O00000o;
        }
        if (this.O0000OOo == 0) {
            i = this.O00000o.O000oOOO;
        } else {
            i = this.O00000o.O000oOOo;
        }
        this.O00000Oo = i;
    }

    public final void O00000o0() {
        this.O00000oO = null;
        Iterator<WidgetRun> it = this.f2361O000000o.iterator();
        while (it.hasNext()) {
            it.next().O00000o0();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0191, code lost:
        if (r7 != r11) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01bd, code lost:
        if (r7 != r11) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c5, code lost:
        if (r2.O0000O0o.O0000Oo != false) goto L_0x00c7;
     */
    public final void O00000o() {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        int i8;
        int i9;
        float f2;
        int i10;
        int i11;
        int i12;
        float f3;
        int i13;
        int i14;
        if (this.O0000Oo.O0000Oo && this.O0000OoO.O0000Oo) {
            ConstraintWidget constraintWidget = this.O00000o.O000Oo0;
            if (constraintWidget == null || !(constraintWidget instanceof oOo0000O)) {
                z = false;
            } else {
                z = ((oOo0000O) constraintWidget).O000oo;
            }
            int i15 = this.O0000OoO.O0000O0o - this.O0000Oo.O0000O0o;
            int size = this.f2361O000000o.size();
            int i16 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i16 >= size) {
                    i16 = -1;
                    break;
                } else if (this.f2361O000000o.get(i16).O00000o.O000o0O != 8) {
                    break;
                } else {
                    i16++;
                }
            }
            int i17 = size - 1;
            int i18 = i17;
            while (true) {
                if (i18 < 0) {
                    break;
                } else if (this.f2361O000000o.get(i18).O00000o.O000o0O != 8) {
                    i = i18;
                    break;
                } else {
                    i18--;
                }
            }
            int i19 = 0;
            while (true) {
                if (i19 >= 2) {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    f = 0.0f;
                    break;
                }
                int i20 = 0;
                i4 = 0;
                i5 = 0;
                i14 = 0;
                f = 0.0f;
                while (i20 < size) {
                    WidgetRun widgetRun = this.f2361O000000o.get(i20);
                    if (widgetRun.O00000o.O000o0O != i2) {
                        i14++;
                        if (i20 > 0 && i20 >= i16) {
                            i4 += widgetRun.O0000Oo.O00000oo;
                        }
                        int i21 = widgetRun.O0000O0o.O0000O0o;
                        boolean z2 = widgetRun.O00000oo != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (!z2) {
                            if (widgetRun.O00000o0 == 1 && i19 == 0) {
                                i21 = widgetRun.O0000O0o.O0000o00;
                                i5++;
                            }
                            z2 = true;
                        } else if (this.O0000OOo == 0 && !widgetRun.O00000o.O0000OOo.O0000O0o.O0000Oo) {
                            return;
                        } else {
                            if (this.O0000OOo == 1 && !widgetRun.O00000o.O0000Oo0.O0000O0o.O0000Oo) {
                                return;
                            }
                        }
                        if (!z2) {
                            i5++;
                            float f4 = widgetRun.O00000o.O000oOoO[this.O0000OOo];
                            if (f4 >= 0.0f) {
                                f += f4;
                            }
                        } else {
                            i4 += i21;
                        }
                        if (i20 < i17 && i20 < i) {
                            i4 += -widgetRun.O0000OoO.O00000oo;
                        }
                    }
                    i20++;
                    i2 = 8;
                }
                if (i4 < i15 || i5 == 0) {
                    i3 = i14;
                } else {
                    i19++;
                    i2 = 8;
                }
            }
            i3 = i14;
            int i22 = this.O0000Oo.O0000O0o;
            if (z) {
                i22 = this.O0000OoO.O0000O0o;
            }
            if (i6 > i15) {
                i22 = z ? i22 + ((int) ((((float) (i6 - i15)) / 2.0f) + 0.5f)) : i22 - ((int) ((((float) (i6 - i15)) / 2.0f) + 0.5f));
            }
            if (i5 > 0) {
                float f5 = (float) (i15 - i6);
                int i23 = (int) ((f5 / ((float) i5)) + 0.5f);
                int i24 = 0;
                int i25 = 0;
                while (i24 < size) {
                    WidgetRun widgetRun2 = this.f2361O000000o.get(i24);
                    int i26 = i23;
                    if (widgetRun2.O00000o.O000o0O == 8 || widgetRun2.O00000oo != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || widgetRun2.O0000O0o.O0000Oo) {
                        i11 = i22;
                        f3 = f5;
                        i12 = i6;
                    } else {
                        int i27 = f > 0.0f ? (int) (((widgetRun2.O00000o.O000oOoO[this.O0000OOo] * f5) / f) + 0.5f) : i26;
                        if (this.O0000OOo == 0) {
                            int i28 = widgetRun2.O00000o.O0000oO;
                            f3 = f5;
                            i12 = i6;
                            i11 = i22;
                            i13 = Math.max(widgetRun2.O00000o.O0000oO0, widgetRun2.O00000o0 == 1 ? Math.min(i27, widgetRun2.O0000O0o.O0000o00) : i27);
                            if (i28 > 0) {
                                i13 = Math.min(i28, i13);
                            }
                        } else {
                            i11 = i22;
                            f3 = f5;
                            i12 = i6;
                            int i29 = widgetRun2.O00000o.O0000oo0;
                            int max = Math.max(widgetRun2.O00000o.O0000oOo, widgetRun2.O00000o0 == 1 ? Math.min(i27, widgetRun2.O0000O0o.O0000o00) : i27);
                            i13 = i29 > 0 ? Math.min(i29, max) : max;
                        }
                        i25++;
                        i27 = i13;
                        widgetRun2.O0000O0o.O000000o(i27);
                    }
                    i24++;
                    i23 = i26;
                    f5 = f3;
                    i6 = i12;
                    i22 = i11;
                }
                i7 = i22;
                int i30 = i6;
                if (i25 > 0) {
                    i5 -= i25;
                    int i31 = 0;
                    for (int i32 = 0; i32 < size; i32++) {
                        WidgetRun widgetRun3 = this.f2361O000000o.get(i32);
                        if (widgetRun3.O00000o.O000o0O != 8) {
                            if (i32 > 0 && i32 >= i16) {
                                i31 += widgetRun3.O0000Oo.O00000oo;
                            }
                            i31 += widgetRun3.O0000O0o.O0000O0o;
                            if (i32 < i17 && i32 < i) {
                                i31 += -widgetRun3.O0000OoO.O00000oo;
                            }
                        }
                    }
                    i6 = i31;
                } else {
                    i6 = i30;
                }
                i8 = 2;
                if (this.O00000Oo == 2 && i25 == 0) {
                    i9 = 0;
                    this.O00000Oo = 0;
                } else {
                    i9 = 0;
                }
            } else {
                i7 = i22;
                i9 = 0;
                i8 = 2;
            }
            if (i6 > i15) {
                this.O00000Oo = i8;
            }
            if (i3 > 0 && i5 == 0 && i16 == i) {
                this.O00000Oo = i8;
            }
            int i33 = this.O00000Oo;
            if (i33 == 1) {
                if (i3 > 1) {
                    i10 = (i15 - i6) / (i3 - 1);
                } else {
                    i10 = i3 == 1 ? (i15 - i6) / 2 : 0;
                }
                if (i5 > 0) {
                    i10 = 0;
                }
                int i34 = i7;
                while (i9 < size) {
                    WidgetRun widgetRun4 = this.f2361O000000o.get(z ? size - (i9 + 1) : i9);
                    if (widgetRun4.O00000o.O000o0O == 8) {
                        widgetRun4.O0000Oo.O000000o(i34);
                        widgetRun4.O0000OoO.O000000o(i34);
                    } else {
                        if (i9 > 0) {
                            i34 = z ? i34 - i10 : i34 + i10;
                        }
                        if (i9 > 0 && i9 >= i16) {
                            if (z) {
                                i34 -= widgetRun4.O0000Oo.O00000oo;
                            } else {
                                i34 += widgetRun4.O0000Oo.O00000oo;
                            }
                        }
                        if (z) {
                            widgetRun4.O0000OoO.O000000o(i34);
                        } else {
                            widgetRun4.O0000Oo.O000000o(i34);
                        }
                        int i35 = widgetRun4.O0000O0o.O0000O0o;
                        if (widgetRun4.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.O00000o0 == 1) {
                            i35 = widgetRun4.O0000O0o.O0000o00;
                        }
                        i34 = z ? i34 - i35 : i34 + i35;
                        if (z) {
                            widgetRun4.O0000Oo.O000000o(i34);
                        } else {
                            widgetRun4.O0000OoO.O000000o(i34);
                        }
                        widgetRun4.O0000Oo0 = true;
                        if (i9 < i17 && i9 < i) {
                            i34 = z ? i34 - (-widgetRun4.O0000OoO.O00000oo) : i34 + (-widgetRun4.O0000OoO.O00000oo);
                        }
                    }
                    i9++;
                }
            } else if (i33 == 0) {
                int i36 = (i15 - i6) / (i3 + 1);
                if (i5 > 0) {
                    i36 = 0;
                }
                int i37 = i7;
                while (i9 < size) {
                    WidgetRun widgetRun5 = this.f2361O000000o.get(z ? size - (i9 + 1) : i9);
                    if (widgetRun5.O00000o.O000o0O == 8) {
                        widgetRun5.O0000Oo.O000000o(i37);
                        widgetRun5.O0000OoO.O000000o(i37);
                    } else {
                        int i38 = z ? i37 - i36 : i37 + i36;
                        if (i9 > 0 && i9 >= i16) {
                            i38 = z ? i38 - widgetRun5.O0000Oo.O00000oo : i38 + widgetRun5.O0000Oo.O00000oo;
                        }
                        if (z) {
                            widgetRun5.O0000OoO.O000000o(i38);
                        } else {
                            widgetRun5.O0000Oo.O000000o(i38);
                        }
                        int i39 = widgetRun5.O0000O0o.O0000O0o;
                        if (widgetRun5.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.O00000o0 == 1) {
                            i39 = Math.min(i39, widgetRun5.O0000O0o.O0000o00);
                        }
                        i37 = z ? i38 - i39 : i38 + i39;
                        if (z) {
                            widgetRun5.O0000Oo.O000000o(i37);
                        } else {
                            widgetRun5.O0000OoO.O000000o(i37);
                        }
                        if (i9 < i17 && i9 < i) {
                            i37 = z ? i37 - (-widgetRun5.O0000OoO.O00000oo) : i37 + (-widgetRun5.O0000OoO.O00000oo);
                        }
                    }
                    i9++;
                }
            } else if (i33 == 2) {
                if (this.O0000OOo == 0) {
                    f2 = this.O00000o.O000o00o;
                } else {
                    f2 = this.O00000o.O000o0;
                }
                if (z) {
                    f2 = 1.0f - f2;
                }
                int i40 = (int) ((((float) (i15 - i6)) * f2) + 0.5f);
                if (i40 < 0 || i5 > 0) {
                    i40 = 0;
                }
                int i41 = z ? i7 - i40 : i7 + i40;
                while (i9 < size) {
                    WidgetRun widgetRun6 = this.f2361O000000o.get(z ? size - (i9 + 1) : i9);
                    if (widgetRun6.O00000o.O000o0O == 8) {
                        widgetRun6.O0000Oo.O000000o(i41);
                        widgetRun6.O0000OoO.O000000o(i41);
                    } else {
                        if (i9 > 0 && i9 >= i16) {
                            if (z) {
                                i41 -= widgetRun6.O0000Oo.O00000oo;
                            } else {
                                i41 += widgetRun6.O0000Oo.O00000oo;
                            }
                        }
                        if (z) {
                            widgetRun6.O0000OoO.O000000o(i41);
                        } else {
                            widgetRun6.O0000Oo.O000000o(i41);
                        }
                        int i42 = widgetRun6.O0000O0o.O0000O0o;
                        if (widgetRun6.O00000oo == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            if (widgetRun6.O00000o0 == 1) {
                                i42 = widgetRun6.O0000O0o.O0000o00;
                            }
                        }
                        i41 = z ? i41 - i42 : i41 + i42;
                        if (z) {
                            widgetRun6.O0000Oo.O000000o(i41);
                        } else {
                            widgetRun6.O0000OoO.O000000o(i41);
                        }
                        if (i9 < i17 && i9 < i) {
                            i41 = z ? i41 - (-widgetRun6.O0000OoO.O00000oo) : i41 + (-widgetRun6.O0000OoO.O00000oo);
                        }
                    }
                    i9++;
                }
            }
        }
    }

    public final void O00000oO() {
        for (int i = 0; i < this.f2361O000000o.size(); i++) {
            this.f2361O000000o.get(i).O00000oO();
        }
    }

    private ConstraintWidget O0000OOo() {
        for (int i = 0; i < this.f2361O000000o.size(); i++) {
            WidgetRun widgetRun = this.f2361O000000o.get(i);
            if (widgetRun.O00000o.O000o0O != 8) {
                return widgetRun.O00000o;
            }
        }
        return null;
    }

    private ConstraintWidget O0000Oo0() {
        for (int size = this.f2361O000000o.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.f2361O000000o.get(size);
            if (widgetRun.O00000o.O000o0O != 8) {
                return widgetRun.O00000o;
            }
        }
        return null;
    }

    public final void O00000oo() {
        Iterator<WidgetRun> it = this.f2361O000000o.iterator();
        while (it.hasNext()) {
            it.next().O00000oo();
        }
        int size = this.f2361O000000o.size();
        if (size > 0) {
            ConstraintWidget constraintWidget = this.f2361O000000o.get(0).O00000o;
            ConstraintWidget constraintWidget2 = this.f2361O000000o.get(size - 1).O00000o;
            if (this.O0000OOo == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.O000O0o;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.O000O0oo;
                DependencyNode O000000o2 = O000000o(constraintAnchor, 0);
                int O00000o0 = constraintAnchor.O00000o0();
                ConstraintWidget O0000OOo = O0000OOo();
                if (O0000OOo != null) {
                    O00000o0 = O0000OOo.O000O0o.O00000o0();
                }
                if (O000000o2 != null) {
                    O000000o(this.O0000Oo, O000000o2, O00000o0);
                }
                DependencyNode O000000o3 = O000000o(constraintAnchor2, 0);
                int O00000o02 = constraintAnchor2.O00000o0();
                ConstraintWidget O0000Oo0 = O0000Oo0();
                if (O0000Oo0 != null) {
                    O00000o02 = O0000Oo0.O000O0oo.O00000o0();
                }
                if (O000000o3 != null) {
                    O000000o(this.O0000OoO, O000000o3, -O00000o02);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.O000O0oO;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.O000OO00;
                DependencyNode O000000o4 = O000000o(constraintAnchor3, 1);
                int O00000o03 = constraintAnchor3.O00000o0();
                ConstraintWidget O0000OOo2 = O0000OOo();
                if (O0000OOo2 != null) {
                    O00000o03 = O0000OOo2.O000O0oO.O00000o0();
                }
                if (O000000o4 != null) {
                    O000000o(this.O0000Oo, O000000o4, O00000o03);
                }
                DependencyNode O000000o5 = O000000o(constraintAnchor4, 1);
                int O00000o04 = constraintAnchor4.O00000o0();
                ConstraintWidget O0000Oo02 = O0000Oo0();
                if (O0000Oo02 != null) {
                    O00000o04 = O0000Oo02.O000OO00.O00000o0();
                }
                if (O000000o5 != null) {
                    O000000o(this.O0000OoO, O000000o5, -O00000o04);
                }
            }
            this.O0000Oo.f2791O000000o = this;
            this.O0000OoO.f2791O000000o = this;
        }
    }
}
