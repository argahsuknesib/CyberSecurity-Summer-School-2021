package _m_j;

import _m_j.ooOOO0Oo;
import android.support.v4.app.NotificationCompat;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class oOo0000O extends oO0O0Oo0 {

    /* renamed from: O000000o  reason: collision with root package name */
    ooOOO0Oo f2325O000000o = new ooOOO0Oo(this);
    public oOo00o00 O00000Oo = new oOo00o00(this);
    protected ooOOO0Oo.O00000Oo O00000o0 = null;
    public boolean O000oo = false;
    protected oO00Oo00 O000ooO = new oO00Oo00();
    public oOOoOOO0 O000ooO0;
    public int O000ooOO;
    public int O000ooOo;
    int O000ooo;
    int O000ooo0;
    int O000oooO = 0;
    int O000oooo = 0;
    public boolean O00O000o = false;
    public boolean O00O00Oo = false;
    public int O00O00o = 0;
    public boolean O00O00o0 = false;
    public int O00O00oO = 0;
    public int O00O00oo = 263;
    public boolean O00O0O0o = false;
    public boolean O00O0OO = false;
    public boolean O00O0OOo = false;
    int O00O0Oo0 = 0;
    oOo000Oo[] O00oOOoo = new oOo000Oo[4];
    oOo000Oo[] oooOoO = new oOo000Oo[4];

    public final void O0000o() {
        this.O00000Oo.O00000Oo = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0159 A[SYNTHETIC] */
    private boolean O000000o(boolean z, int i) {
        boolean z2;
        Iterator<WidgetRun> it;
        Iterator<WidgetRun> it2;
        boolean z3;
        oOo00o00 ooo00o00 = this.O00000Oo;
        boolean z4 = z & true;
        ConstraintWidget.DimensionBehaviour O0000Oo = ooo00o00.f2332O000000o.O0000Oo(0);
        ConstraintWidget.DimensionBehaviour O0000Oo2 = ooo00o00.f2332O000000o.O0000Oo(1);
        int O00000o02 = ooo00o00.f2332O000000o.O00000o0();
        int O00000o = ooo00o00.f2332O000000o.O00000o();
        if (z4 && (O0000Oo == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || O0000Oo2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
            Iterator<WidgetRun> it3 = ooo00o00.O00000oO.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                WidgetRun next = it3.next();
                if (next.O0000OOo == i && !next.O000000o()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && O0000Oo == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    oOo0000O ooo0000o = ooo00o00.f2332O000000o;
                    ooo0000o.O000Oo00[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                    ooo00o00.f2332O000000o.O00000oO(ooo00o00.O000000o(ooo00o00.f2332O000000o, 0));
                    ooo00o00.f2332O000000o.O0000OOo.O0000O0o.O000000o(ooo00o00.f2332O000000o.O00000oO());
                }
            } else if (z4 && O0000Oo2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                oOo0000O ooo0000o2 = ooo00o00.f2332O000000o;
                ooo0000o2.O000Oo00[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                ooo00o00.f2332O000000o.O00000oo(ooo00o00.O000000o(ooo00o00.f2332O000000o, 1));
                ooo00o00.f2332O000000o.O0000Oo0.O0000O0o.O000000o(ooo00o00.f2332O000000o.O00000oo());
            }
        }
        if (i == 0) {
            if (ooo00o00.f2332O000000o.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.FIXED || ooo00o00.f2332O000000o.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int O00000oO = ooo00o00.f2332O000000o.O00000oO() + O00000o02;
                ooo00o00.f2332O000000o.O0000OOo.O0000OoO.O000000o(O00000oO);
                ooo00o00.f2332O000000o.O0000OOo.O0000O0o.O000000o(O00000oO - O00000o02);
                z2 = true;
                ooo00o00.O000000o();
                it = ooo00o00.O00000oO.iterator();
                while (it.hasNext()) {
                    WidgetRun next2 = it.next();
                    if (next2.O0000OOo == i && (next2.O00000o != ooo00o00.f2332O000000o || next2.O0000Oo0)) {
                        next2.O00000oO();
                    }
                }
                it2 = ooo00o00.O00000oO.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z3 = true;
                        break;
                    }
                    WidgetRun next3 = it2.next();
                    if (next3.O0000OOo != i || ((!z2 && next3.O00000o == ooo00o00.f2332O000000o) || (next3.O0000Oo.O0000Oo && next3.O0000OoO.O0000Oo && ((next3 instanceof ooOOO00O) || next3.O0000O0o.O0000Oo)))) {
                    }
                }
                z3 = false;
                ooo00o00.f2332O000000o.O000Oo00[0] = O0000Oo;
                ooo00o00.f2332O000000o.O000Oo00[1] = O0000Oo2;
                return z3;
            }
        } else if (ooo00o00.f2332O000000o.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.FIXED || ooo00o00.f2332O000000o.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int O00000oo = ooo00o00.f2332O000000o.O00000oo() + O00000o;
            ooo00o00.f2332O000000o.O0000Oo0.O0000OoO.O000000o(O00000oo);
            ooo00o00.f2332O000000o.O0000Oo0.O0000O0o.O000000o(O00000oo - O00000o);
            z2 = true;
            ooo00o00.O000000o();
            it = ooo00o00.O00000oO.iterator();
            while (it.hasNext()) {
            }
            it2 = ooo00o00.O00000oO.iterator();
            while (true) {
                if (!it2.hasNext()) {
                }
            }
            z3 = false;
            ooo00o00.f2332O000000o.O000Oo00[0] = O0000Oo;
            ooo00o00.f2332O000000o.O000Oo00[1] = O0000Oo2;
            return z3;
        }
        z2 = false;
        ooo00o00.O000000o();
        it = ooo00o00.O00000oO.iterator();
        while (it.hasNext()) {
        }
        it2 = ooo00o00.O00000oO.iterator();
        while (true) {
            if (!it2.hasNext()) {
            }
        }
        z3 = false;
        ooo00o00.f2332O000000o.O000Oo00[0] = O0000Oo;
        ooo00o00.f2332O000000o.O000Oo00[1] = O0000Oo2;
        return z3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ooOOO0Oo.O000000o(_m_j.ooOOO0Oo$O00000Oo, androidx.constraintlayout.solver.widgets.ConstraintWidget, boolean):boolean
     arg types: [_m_j.ooOOO0Oo$O00000Oo, androidx.constraintlayout.solver.widgets.ConstraintWidget, int]
     candidates:
      _m_j.ooOOO0Oo.O000000o(_m_j.oOo0000O, int, int):void
      _m_j.ooOOO0Oo.O000000o(_m_j.ooOOO0Oo$O00000Oo, androidx.constraintlayout.solver.widgets.ConstraintWidget, boolean):boolean */
    public final long O000000o(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        ooOOO0Oo.O00000Oo o00000Oo;
        int i8;
        boolean z;
        boolean z2;
        int i9;
        int i10;
        ooOOO0Oo.O00000Oo o00000Oo2;
        boolean z3;
        boolean z4;
        int i11;
        int i12;
        int i13;
        ooOOO0Oo.O00000Oo o00000Oo3;
        boolean z5;
        int i14;
        int i15;
        int i16;
        boolean z6;
        boolean z7;
        int i17 = i;
        int i18 = i2;
        int i19 = i4;
        this.O000ooOO = i6;
        this.O000ooOo = i7;
        ooOOO0Oo ooooo0oo = this.f2325O000000o;
        ooOOO0Oo.O00000Oo o00000Oo4 = this.O00000o0;
        int size = this.O00O0OoO.size();
        int O00000oO = O00000oO();
        int O00000oo = O00000oo();
        boolean O000000o2 = oO0O0O00.O000000o(i17, NotificationCompat.FLAG_HIGH_PRIORITY);
        char c = 1;
        boolean z8 = O000000o2 || oO0O0O00.O000000o(i17, 64);
        if (z8) {
            int i20 = 0;
            while (true) {
                if (i20 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget = (ConstraintWidget) this.O00O0OoO.get(i20);
                boolean z9 = (constraintWidget.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (constraintWidget.O000Oo00[c] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.O000OoO0 > 0.0f;
                if ((!constraintWidget.O0000o00() || !z9) && ((!constraintWidget.O0000o0() || !z9) && !(constraintWidget instanceof oOo0oooO) && !constraintWidget.O0000o00() && !constraintWidget.O0000o0())) {
                    i20++;
                    c = 1;
                }
            }
            z8 = false;
        }
        if (z8 && oO00Oo00.O0000Oo0 != null) {
            oO00Oo00.O0000Oo0.O00000o0++;
        }
        if (z8 && ((i18 == 1073741824 && i19 == 1073741824) || O000000o2)) {
            int min = Math.min(this.O000O00o[0], i3);
            int min2 = Math.min(this.O000O00o[1], i5);
            if (i18 == 1073741824 && O00000oO() != min) {
                O00000oO(min);
                O0000o();
            }
            if (i19 == 1073741824 && O00000oo() != min2) {
                O00000oo(min2);
                O0000o();
            }
            if (i18 == 1073741824 && i19 == 1073741824) {
                oOo00o00 ooo00o00 = this.O00000Oo;
                boolean z10 = O000000o2 & true;
                if (ooo00o00.O00000Oo || ooo00o00.O00000o0) {
                    Iterator it = ooo00o00.f2332O000000o.O00O0OoO.iterator();
                    while (it.hasNext()) {
                        ConstraintWidget constraintWidget2 = (ConstraintWidget) it.next();
                        constraintWidget2.O00000o = false;
                        constraintWidget2.O0000OOo.O0000O0o();
                        constraintWidget2.O0000Oo0.O0000O0o();
                    }
                    ooo00o00.f2332O000000o.O00000o = false;
                    ooo00o00.f2332O000000o.O0000OOo.O0000O0o();
                    ooo00o00.f2332O000000o.O0000Oo0.O0000O0o();
                    ooo00o00.O00000o0 = false;
                }
                ooo00o00.O000000o(ooo00o00.O00000o);
                ooo00o00.f2332O000000o.O00000o0(0);
                ooo00o00.f2332O000000o.O00000o(0);
                ConstraintWidget.DimensionBehaviour O0000Oo = ooo00o00.f2332O000000o.O0000Oo(0);
                ConstraintWidget.DimensionBehaviour O0000Oo2 = ooo00o00.f2332O000000o.O0000Oo(1);
                if (ooo00o00.O00000Oo) {
                    ooo00o00.O00000Oo();
                }
                int O00000o02 = ooo00o00.f2332O000000o.O00000o0();
                int O00000o = ooo00o00.f2332O000000o.O00000o();
                ooo00o00.f2332O000000o.O0000OOo.O0000Oo.O000000o(O00000o02);
                ooo00o00.f2332O000000o.O0000Oo0.O0000Oo.O000000o(O00000o);
                ooo00o00.O000000o();
                if (O0000Oo == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || O0000Oo2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    if (z10) {
                        Iterator<WidgetRun> it2 = ooo00o00.O00000oO.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (!it2.next().O000000o()) {
                                    z10 = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (!z10 || O0000Oo != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        o00000Oo = o00000Oo4;
                    } else {
                        ooo00o00.f2332O000000o.O000Oo00[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                        o00000Oo = o00000Oo4;
                        ooo00o00.f2332O000000o.O00000oO(ooo00o00.O000000o(ooo00o00.f2332O000000o, 0));
                        ooo00o00.f2332O000000o.O0000OOo.O0000O0o.O000000o(ooo00o00.f2332O000000o.O00000oO());
                    }
                    if (z10 && O0000Oo2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        ooo00o00.f2332O000000o.O000Oo00[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                        ooo00o00.f2332O000000o.O00000oo(ooo00o00.O000000o(ooo00o00.f2332O000000o, 1));
                        ooo00o00.f2332O000000o.O0000Oo0.O0000O0o.O000000o(ooo00o00.f2332O000000o.O00000oo());
                    }
                } else {
                    o00000Oo = o00000Oo4;
                }
                if (ooo00o00.f2332O000000o.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.FIXED || ooo00o00.f2332O000000o.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                    int O00000oO2 = ooo00o00.f2332O000000o.O00000oO() + O00000o02;
                    ooo00o00.f2332O000000o.O0000OOo.O0000OoO.O000000o(O00000oO2);
                    ooo00o00.f2332O000000o.O0000OOo.O0000O0o.O000000o(O00000oO2 - O00000o02);
                    ooo00o00.O000000o();
                    if (ooo00o00.f2332O000000o.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.FIXED || ooo00o00.f2332O000000o.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                        int O00000oo2 = ooo00o00.f2332O000000o.O00000oo() + O00000o;
                        ooo00o00.f2332O000000o.O0000Oo0.O0000OoO.O000000o(O00000oo2);
                        ooo00o00.f2332O000000o.O0000Oo0.O0000O0o.O000000o(O00000oo2 - O00000o);
                    }
                    ooo00o00.O000000o();
                    z7 = true;
                } else {
                    z7 = false;
                }
                Iterator<WidgetRun> it3 = ooo00o00.O00000oO.iterator();
                while (it3.hasNext()) {
                    WidgetRun next = it3.next();
                    if (next.O00000o != ooo00o00.f2332O000000o || next.O0000Oo0) {
                        next.O00000oO();
                    }
                }
                Iterator<WidgetRun> it4 = ooo00o00.O00000oO.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        z = true;
                        break;
                    }
                    WidgetRun next2 = it4.next();
                    if ((z7 || next2.O00000o != ooo00o00.f2332O000000o) && (!next2.O0000Oo.O0000Oo || ((!next2.O0000OoO.O0000Oo && !(next2 instanceof ooooOO00)) || (!next2.O0000O0o.O0000Oo && !(next2 instanceof ooOOO00O) && !(next2 instanceof ooooOO00))))) {
                        z = false;
                    }
                }
                z = false;
                ooo00o00.f2332O000000o.O000Oo00[0] = O0000Oo;
                ooo00o00.f2332O000000o.O000Oo00[1] = O0000Oo2;
                i15 = 1073741824;
                i8 = 2;
            } else {
                o00000Oo = o00000Oo4;
                oOo00o00 ooo00o002 = this.O00000Oo;
                if (ooo00o002.O00000Oo) {
                    Iterator it5 = ooo00o002.f2332O000000o.O00O0OoO.iterator();
                    while (it5.hasNext()) {
                        ConstraintWidget constraintWidget3 = (ConstraintWidget) it5.next();
                        constraintWidget3.O00000o = false;
                        constraintWidget3.O0000OOo.O0000O0o.O0000Oo = false;
                        constraintWidget3.O0000OOo.O0000Oo0 = false;
                        constraintWidget3.O0000OOo.O0000O0o();
                        constraintWidget3.O0000Oo0.O0000O0o.O0000Oo = false;
                        constraintWidget3.O0000Oo0.O0000Oo0 = false;
                        constraintWidget3.O0000Oo0.O0000O0o();
                    }
                    ooo00o002.f2332O000000o.O00000o = false;
                    ooo00o002.f2332O000000o.O0000OOo.O0000O0o.O0000Oo = false;
                    ooo00o002.f2332O000000o.O0000OOo.O0000Oo0 = false;
                    ooo00o002.f2332O000000o.O0000OOo.O0000O0o();
                    ooo00o002.f2332O000000o.O0000Oo0.O0000O0o.O0000Oo = false;
                    ooo00o002.f2332O000000o.O0000Oo0.O0000Oo0 = false;
                    ooo00o002.f2332O000000o.O0000Oo0.O0000O0o();
                    ooo00o002.O00000Oo();
                }
                ooo00o002.O000000o(ooo00o002.O00000o);
                ooo00o002.f2332O000000o.O00000o0(0);
                ooo00o002.f2332O000000o.O00000o(0);
                ooo00o002.f2332O000000o.O0000OOo.O0000Oo.O000000o(0);
                ooo00o002.f2332O000000o.O0000Oo0.O0000Oo.O000000o(0);
                i15 = 1073741824;
                if (i18 == 1073741824) {
                    i16 = 1;
                    z6 = O000000o(O000000o2, 0) & true;
                    i8 = 1;
                } else {
                    i16 = 1;
                    z6 = true;
                    i8 = 0;
                }
                if (i19 == 1073741824) {
                    z &= O000000o(O000000o2, i16);
                    i8++;
                }
            }
            if (z) {
                O000000o(i18 == i15, i19 == i15);
            }
        } else {
            o00000Oo = o00000Oo4;
            z = false;
            i8 = 0;
        }
        if (z && i8 == 2) {
            return 0;
        }
        if (size > 0) {
            int size2 = this.O00O0OoO.size();
            ooOOO0Oo.O00000Oo o00000Oo5 = this.O00000o0;
            for (int i21 = 0; i21 < size2; i21++) {
                ConstraintWidget constraintWidget4 = (ConstraintWidget) this.O00O0OoO.get(i21);
                if (!(constraintWidget4 instanceof oO0O000o) && (!constraintWidget4.O0000OOo.O0000O0o.O0000Oo || !constraintWidget4.O0000Oo0.O0000O0o.O0000Oo)) {
                    if (!(constraintWidget4.O0000Oo(0) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget4.O0000o0O != 1 && constraintWidget4.O0000Oo(1) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget4.O0000o0o != 1)) {
                        ooooo0oo.O000000o(o00000Oo5, constraintWidget4, false);
                        oOOoOOO0 ooooooo0 = this.O000ooO0;
                        if (ooooooo0 != null) {
                            ooooooo0.f2323O000000o++;
                        }
                    }
                }
            }
            o00000Oo5.O000000o();
        }
        int i22 = this.O00O00oo;
        int size3 = ooooo0oo.f2362O000000o.size();
        if (size > 0) {
            ooooo0oo.O000000o(this, O00000oO, O00000oo);
        }
        if (size3 > 0) {
            boolean z11 = this.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z12 = this.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            int max = Math.max(O00000oO(), ooooo0oo.O00000Oo.O0000O0o());
            int max2 = Math.max(O00000oo(), ooooo0oo.O00000Oo.O0000OOo());
            int i23 = 0;
            boolean z13 = false;
            while (i23 < size3) {
                ConstraintWidget constraintWidget5 = ooooo0oo.f2362O000000o.get(i23);
                if (constraintWidget5 instanceof oOo0oooO) {
                    int O00000oO3 = constraintWidget5.O00000oO();
                    int O00000oo3 = constraintWidget5.O00000oo();
                    o00000Oo3 = o00000Oo;
                    i13 = i22;
                    boolean O000000o3 = z13 | ooooo0oo.O000000o(o00000Oo3, constraintWidget5, true);
                    oOOoOOO0 ooooooo02 = this.O000ooO0;
                    if (ooooooo02 != null) {
                        i12 = O00000oO;
                        i11 = O00000oo;
                        ooooooo02.O00000Oo++;
                    } else {
                        i12 = O00000oO;
                        i11 = O00000oo;
                    }
                    int O00000oO4 = constraintWidget5.O00000oO();
                    int O00000oo4 = constraintWidget5.O00000oo();
                    if (O00000oO4 != O00000oO3) {
                        constraintWidget5.O00000oO(O00000oO4);
                        if (z11 && constraintWidget5.O0000Oo0() > max) {
                            max = Math.max(max, constraintWidget5.O0000Oo0() + constraintWidget5.O000000o(ConstraintAnchor.Type.RIGHT).O00000o0());
                        }
                        i14 = max;
                        z5 = true;
                    } else {
                        int i24 = max;
                        z5 = O000000o3;
                        i14 = i24;
                    }
                    if (O00000oo4 != O00000oo3) {
                        constraintWidget5.O00000oo(O00000oo4);
                        if (z12 && constraintWidget5.O0000Oo() > max2) {
                            max2 = Math.max(max2, constraintWidget5.O0000Oo() + constraintWidget5.O000000o(ConstraintAnchor.Type.BOTTOM).O00000o0());
                        }
                        z5 = true;
                    }
                    boolean z14 = ((oOo0oooO) constraintWidget5).O00O0o0o | z5;
                    max = i14;
                    z13 = z14;
                } else {
                    i12 = O00000oO;
                    i11 = O00000oo;
                    o00000Oo3 = o00000Oo;
                    i13 = i22;
                }
                i23++;
                i22 = i13;
                O00000oO = i12;
                O00000oo = i11;
                o00000Oo = o00000Oo3;
            }
            int i25 = O00000oO;
            int i26 = O00000oo;
            ooOOO0Oo.O00000Oo o00000Oo6 = o00000Oo;
            int i27 = i22;
            int i28 = 0;
            while (i28 < 2) {
                int i29 = max;
                int i30 = 0;
                boolean z15 = z13;
                while (i30 < size3) {
                    ConstraintWidget constraintWidget6 = ooooo0oo.f2362O000000o.get(i30);
                    if ((!(constraintWidget6 instanceof oO0O00Oo) || (constraintWidget6 instanceof oOo0oooO)) && !(constraintWidget6 instanceof oO0O000o) && constraintWidget6.O000o0O != 8 && ((!constraintWidget6.O0000OOo.O0000O0o.O0000Oo || !constraintWidget6.O0000Oo0.O0000O0o.O0000Oo) && !(constraintWidget6 instanceof oOo0oooO))) {
                        int O00000oO5 = constraintWidget6.O00000oO();
                        int O00000oo5 = constraintWidget6.O00000oo();
                        int i31 = constraintWidget6.O000Oooo;
                        boolean O000000o4 = z15 | ooooo0oo.O000000o(o00000Oo6, constraintWidget6, true);
                        oOOoOOO0 ooooooo03 = this.O000ooO0;
                        if (ooooooo03 != null) {
                            z3 = O000000o4;
                            o00000Oo2 = o00000Oo6;
                            ooooooo03.O00000Oo++;
                        } else {
                            z3 = O000000o4;
                            o00000Oo2 = o00000Oo6;
                        }
                        int O00000oO6 = constraintWidget6.O00000oO();
                        int O00000oo6 = constraintWidget6.O00000oo();
                        if (O00000oO6 != O00000oO5) {
                            constraintWidget6.O00000oO(O00000oO6);
                            if (z11 && constraintWidget6.O0000Oo0() > i29) {
                                i29 = Math.max(i29, constraintWidget6.O0000Oo0() + constraintWidget6.O000000o(ConstraintAnchor.Type.RIGHT).O00000o0());
                            }
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        if (O00000oo6 != O00000oo5) {
                            constraintWidget6.O00000oo(O00000oo6);
                            if (z12 && constraintWidget6.O0000Oo() > max2) {
                                max2 = Math.max(max2, constraintWidget6.O0000Oo() + constraintWidget6.O000000o(ConstraintAnchor.Type.BOTTOM).O00000o0());
                            }
                            z15 = true;
                        } else {
                            z15 = z4;
                        }
                        if (constraintWidget6.O000O0Oo && i31 != constraintWidget6.O000Oooo) {
                            z15 = true;
                        }
                    } else {
                        o00000Oo2 = o00000Oo6;
                    }
                    i30++;
                    o00000Oo6 = o00000Oo2;
                }
                ooOOO0Oo.O00000Oo o00000Oo7 = o00000Oo6;
                if (z15) {
                    i10 = i25;
                    i9 = i26;
                    ooooo0oo.O000000o(this, i10, i9);
                    z13 = false;
                } else {
                    i10 = i25;
                    i9 = i26;
                    z13 = z15;
                }
                i28++;
                i25 = i10;
                i26 = i9;
                max = i29;
                o00000Oo6 = o00000Oo7;
            }
            int i32 = i25;
            int i33 = i26;
            if (z13) {
                ooooo0oo.O000000o(this, i32, i33);
                if (O00000oO() < max) {
                    O00000oO(max);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (O00000oo() < max2) {
                    O00000oo(max2);
                    z2 = true;
                }
                if (z2) {
                    ooooo0oo.O000000o(this, i32, i33);
                }
            }
            i22 = i27;
        }
        O0000o00(i22);
        return 0;
    }

    public final void O0000oO0() {
        this.f2325O000000o.O000000o(this);
    }

    public final void O000000o(ooOOO0Oo.O00000Oo o00000Oo) {
        this.O00000o0 = o00000Oo;
        this.O00000Oo.O00000oo = o00000Oo;
    }

    public final ooOOO0Oo.O00000Oo O0000oO() {
        return this.O00000o0;
    }

    public final void O0000o00(int i) {
        this.O00O00oo = i;
        oO00Oo00.O0000Oo = oO0O0O00.O000000o(i, 256);
    }

    private boolean O0000o0(int i) {
        return (this.O00O00oo & i) == i;
    }

    public final void O00000Oo() {
        this.O000ooO.O00000Oo();
        this.O000ooOO = 0;
        this.O000ooo0 = 0;
        this.O000ooOo = 0;
        this.O000ooo = 0;
        this.O00O0O0o = false;
        super.O00000Oo();
    }

    private void O000000o(oO00Oo00 oo00oo00, boolean[] zArr) {
        zArr[2] = false;
        O0000o0o();
        int size = this.O00O0OoO.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.O00O0OoO.get(i)).O0000o0o();
        }
    }

    public final void O000000o(boolean z, boolean z2) {
        super.O000000o(z, z2);
        int size = this.O00O0OoO.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.O00O0OoO.get(i)).O000000o(z, z2);
        }
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r8v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean, code=?, for r2v1, types: [boolean] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0305  */
    public final void O0000oOO() {
        ArrayList arrayList;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int max;
        int max2;
        ? r8;
        boolean z6;
        ConstraintWidget constraintWidget;
        ? r2 = 0;
        this.O000OoO = 0;
        this.O000OoOO = 0;
        int max3 = Math.max(0, O00000oO());
        int max4 = Math.max(0, O00000oo());
        this.O00O0OO = false;
        this.O00O0OOo = false;
        boolean z7 = O0000o0(64) || O0000o0(NotificationCompat.FLAG_HIGH_PRIORITY);
        oO00Oo00 oo00oo00 = this.O000ooO;
        oo00oo00.O00000o = false;
        oo00oo00.O00000oO = false;
        if (this.O00O00oo != 0 && z7) {
            oo00oo00.O00000oO = true;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.O000Oo00[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.O000Oo00[0];
        ArrayList arrayList2 = this.O00O0OoO;
        boolean z8 = this.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || this.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        O0000oOo();
        int size = this.O00O0OoO.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget2 = (ConstraintWidget) this.O00O0OoO.get(i);
            if (constraintWidget2 instanceof oO0O0Oo0) {
                ((oO0O0Oo0) constraintWidget2).O0000oOO();
            }
        }
        int i2 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (z9) {
            int i3 = i2 + 1;
            try {
                this.O000ooO.O00000Oo();
                O0000oOo();
                O00000Oo(this.O000ooO);
                int i4 = 0;
                while (i4 < size) {
                    try {
                        ((ConstraintWidget) this.O00O0OoO.get(i4)).O00000Oo(this.O000ooO);
                        i4++;
                    } catch (Exception e) {
                        e = e;
                        arrayList = arrayList2;
                        z3 = z9;
                        z = z10;
                        e.printStackTrace();
                        System.out.println("EXCEPTION : ".concat(String.valueOf(e)));
                        if (z3) {
                        }
                        if (z8) {
                        }
                        z4 = z;
                        z5 = false;
                        max = Math.max(this.O000o000, O00000oO());
                        if (max > O00000oO()) {
                        }
                        max2 = Math.max(this.O000o00, O00000oo());
                        if (max2 > O00000oo()) {
                        }
                        if (!z4) {
                        }
                        z9 = z5;
                        z10 = z4;
                        i2 = i3;
                        arrayList2 = arrayList;
                        r2 = 0;
                    }
                }
                oO00Oo00 oo00oo002 = this.O000ooO;
                O000000o(oo00oo002);
                int size2 = this.O00O0OoO.size();
                int i5 = 0;
                boolean z11 = false;
                while (i5 < size2) {
                    try {
                        constraintWidget = (ConstraintWidget) this.O00O0OoO.get(i5);
                        z2 = z9;
                    } catch (Exception e2) {
                        e = e2;
                        z2 = z9;
                        arrayList = arrayList2;
                        z = z10;
                        z3 = z2;
                        e.printStackTrace();
                        System.out.println("EXCEPTION : ".concat(String.valueOf(e)));
                        if (z3) {
                        }
                        if (z8) {
                        }
                        z4 = z;
                        z5 = false;
                        max = Math.max(this.O000o000, O00000oO());
                        if (max > O00000oO()) {
                        }
                        max2 = Math.max(this.O000o00, O00000oo());
                        if (max2 > O00000oo()) {
                        }
                        if (!z4) {
                        }
                        z9 = z5;
                        z10 = z4;
                        i2 = i3;
                        arrayList2 = arrayList;
                        r2 = 0;
                    }
                    try {
                        constraintWidget.O000OOoo[r2] = r2;
                        constraintWidget.O000OOoo[1] = r2;
                        if (constraintWidget instanceof oOo00ooO) {
                            z11 = true;
                        }
                        i5++;
                        z9 = z2;
                    } catch (Exception e3) {
                        e = e3;
                        arrayList = arrayList2;
                        z = z10;
                        z3 = z2;
                        e.printStackTrace();
                        System.out.println("EXCEPTION : ".concat(String.valueOf(e)));
                        if (z3) {
                        }
                        if (z8) {
                        }
                        z4 = z;
                        z5 = false;
                        max = Math.max(this.O000o000, O00000oO());
                        if (max > O00000oO()) {
                        }
                        max2 = Math.max(this.O000o00, O00000oo());
                        if (max2 > O00000oo()) {
                        }
                        if (!z4) {
                        }
                        z9 = z5;
                        z10 = z4;
                        i2 = i3;
                        arrayList2 = arrayList;
                        r2 = 0;
                    }
                }
                z2 = z9;
                if (z11) {
                    int i6 = 0;
                    while (i6 < size2) {
                        ConstraintWidget constraintWidget3 = (ConstraintWidget) this.O00O0OoO.get(i6);
                        if (constraintWidget3 instanceof oOo00ooO) {
                            oOo00ooO ooo00ooo = (oOo00ooO) constraintWidget3;
                            int i7 = 0;
                            while (i7 < ooo00ooo.O00O0OOo) {
                                ConstraintWidget constraintWidget4 = ooo00ooo.O00O0OO[i7];
                                z = z10;
                                try {
                                    if (ooo00ooo.f2334O000000o != 0) {
                                        arrayList = arrayList2;
                                        if (ooo00ooo.f2334O000000o != 1) {
                                            try {
                                                if (ooo00ooo.f2334O000000o == 2 || ooo00ooo.f2334O000000o == 3) {
                                                    constraintWidget4.O000OOoo[1] = true;
                                                    i7++;
                                                    z10 = z;
                                                    arrayList2 = arrayList;
                                                } else {
                                                    i7++;
                                                    z10 = z;
                                                    arrayList2 = arrayList;
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                                z3 = z2;
                                                e.printStackTrace();
                                                System.out.println("EXCEPTION : ".concat(String.valueOf(e)));
                                                if (z3) {
                                                }
                                                if (z8) {
                                                }
                                                z4 = z;
                                                z5 = false;
                                                max = Math.max(this.O000o000, O00000oO());
                                                if (max > O00000oO()) {
                                                }
                                                max2 = Math.max(this.O000o00, O00000oo());
                                                if (max2 > O00000oo()) {
                                                }
                                                if (!z4) {
                                                }
                                                z9 = z5;
                                                z10 = z4;
                                                i2 = i3;
                                                arrayList2 = arrayList;
                                                r2 = 0;
                                            }
                                        }
                                    } else {
                                        arrayList = arrayList2;
                                    }
                                    constraintWidget4.O000OOoo[0] = true;
                                    i7++;
                                    z10 = z;
                                    arrayList2 = arrayList;
                                } catch (Exception e5) {
                                    e = e5;
                                    arrayList = arrayList2;
                                    z3 = z2;
                                    e.printStackTrace();
                                    System.out.println("EXCEPTION : ".concat(String.valueOf(e)));
                                    if (z3) {
                                    }
                                    if (z8) {
                                    }
                                    z4 = z;
                                    z5 = false;
                                    max = Math.max(this.O000o000, O00000oO());
                                    if (max > O00000oO()) {
                                    }
                                    max2 = Math.max(this.O000o00, O00000oo());
                                    if (max2 > O00000oo()) {
                                    }
                                    if (!z4) {
                                    }
                                    z9 = z5;
                                    z10 = z4;
                                    i2 = i3;
                                    arrayList2 = arrayList;
                                    r2 = 0;
                                }
                            }
                        }
                        arrayList = arrayList2;
                        i6++;
                        z10 = z10;
                        arrayList2 = arrayList;
                    }
                }
                arrayList = arrayList2;
                z = z10;
                for (int i8 = 0; i8 < size2; i8++) {
                    ConstraintWidget constraintWidget5 = (ConstraintWidget) this.O00O0OoO.get(i8);
                    if (constraintWidget5.O0000o0O()) {
                        constraintWidget5.O000000o(oo00oo002);
                    }
                }
                for (int i9 = 0; i9 < size2; i9++) {
                    ConstraintWidget constraintWidget6 = (ConstraintWidget) this.O00O0OoO.get(i9);
                    if (constraintWidget6 instanceof oOo0000O) {
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = constraintWidget6.O000Oo00[0];
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidget6.O000Oo00[1];
                        if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            constraintWidget6.O000Oo00[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                        }
                        if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            constraintWidget6.O000Oo00[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                        }
                        constraintWidget6.O000000o(oo00oo002);
                        if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            constraintWidget6.O000Oo00[0] = dimensionBehaviour3;
                        }
                        if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                            constraintWidget6.O000Oo00[1] = dimensionBehaviour4;
                        }
                    } else {
                        oO0O0O00.O000000o(this, oo00oo002, constraintWidget6);
                        if (!constraintWidget6.O0000o0O()) {
                            constraintWidget6.O000000o(oo00oo002);
                        }
                    }
                }
                if (this.O000oooO > 0) {
                    oO0OO00o.O000000o(this, oo00oo002, 0);
                }
                if (this.O000oooo > 0) {
                    oO0OO00o.O000000o(this, oo00oo002, 1);
                }
                try {
                    oO00Oo00 oo00oo003 = this.O000ooO;
                    if (oO00Oo00.O0000Oo0 != null) {
                        oO00Oo00.O0000Oo0.O00000oO++;
                    }
                    if (!oo00oo003.O00000o) {
                        if (!oo00oo003.O00000oO) {
                            oo00oo003.O000000o(oo00oo003.O00000Oo);
                            z3 = true;
                            if (z3) {
                                O000000o(this.O000ooO, oO0O0O00.f2282O000000o);
                            } else {
                                O0000o0o();
                                for (int i10 = 0; i10 < size; i10++) {
                                    ((ConstraintWidget) this.O00O0OoO.get(i10)).O0000o0o();
                                }
                            }
                            if (z8 || i3 >= 8 || !oO0O0O00.f2282O000000o[2]) {
                                z4 = z;
                                z5 = false;
                            } else {
                                int i11 = 0;
                                int i12 = 0;
                                for (int i13 = 0; i13 < size; i13++) {
                                    ConstraintWidget constraintWidget7 = (ConstraintWidget) this.O00O0OoO.get(i13);
                                    i11 = Math.max(i11, constraintWidget7.O000OoO + constraintWidget7.O00000oO());
                                    i12 = Math.max(i12, constraintWidget7.O000OoOO + constraintWidget7.O00000oo());
                                }
                                int max5 = Math.max(this.O000o000, i11);
                                int max6 = Math.max(this.O000o00, i12);
                                if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || O00000oO() >= max5) {
                                    z5 = false;
                                } else {
                                    O00000oO(max5);
                                    this.O000Oo00[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                                    z5 = true;
                                    z = true;
                                }
                                if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || O00000oo() >= max6) {
                                    z4 = z;
                                } else {
                                    O00000oo(max6);
                                    this.O000Oo00[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                                    z5 = true;
                                    z4 = true;
                                }
                            }
                            max = Math.max(this.O000o000, O00000oO());
                            if (max > O00000oO()) {
                                O00000oO(max);
                                this.O000Oo00[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                                z5 = true;
                                z4 = true;
                            }
                            max2 = Math.max(this.O000o00, O00000oo());
                            if (max2 > O00000oo()) {
                                O00000oo(max2);
                                r8 = 1;
                                this.O000Oo00[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                                z5 = true;
                                z4 = true;
                            } else {
                                r8 = 1;
                            }
                            if (!z4) {
                                if (this.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && max3 > 0 && O00000oO() > max3) {
                                    this.O00O0OO = r8;
                                    this.O000Oo00[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                                    O00000oO(max3);
                                    z5 = true;
                                    z4 = true;
                                }
                                if (this.O000Oo00[r8] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && max4 > 0 && O00000oo() > max4) {
                                    this.O00O0OOo = r8;
                                    this.O000Oo00[r8] = ConstraintWidget.DimensionBehaviour.FIXED;
                                    O00000oo(max4);
                                    z9 = true;
                                    z10 = true;
                                    i2 = i3;
                                    arrayList2 = arrayList;
                                    r2 = 0;
                                }
                            }
                            z9 = z5;
                            z10 = z4;
                            i2 = i3;
                            arrayList2 = arrayList;
                            r2 = 0;
                        }
                    }
                    if (oO00Oo00.O0000Oo0 != null) {
                        oO00Oo00.O0000Oo0.O0000o++;
                    }
                    int i14 = 0;
                    while (true) {
                        if (i14 >= oo00oo003.O0000O0o) {
                            z6 = true;
                            break;
                        } else if (!oo00oo003.O00000o0[i14].O00000oo) {
                            z6 = false;
                            break;
                        } else {
                            i14++;
                        }
                    }
                    if (!z6) {
                        oo00oo003.O000000o(oo00oo003.O00000Oo);
                    } else {
                        if (oO00Oo00.O0000Oo0 != null) {
                            oO00Oo00.O0000Oo0.O0000o0o++;
                        }
                        oo00oo003.O00000oO();
                    }
                    z3 = true;
                } catch (Exception e6) {
                    e = e6;
                    z3 = true;
                    e.printStackTrace();
                    System.out.println("EXCEPTION : ".concat(String.valueOf(e)));
                    if (z3) {
                    }
                    if (z8) {
                    }
                    z4 = z;
                    z5 = false;
                    max = Math.max(this.O000o000, O00000oO());
                    if (max > O00000oO()) {
                    }
                    max2 = Math.max(this.O000o00, O00000oo());
                    if (max2 > O00000oo()) {
                    }
                    if (!z4) {
                    }
                    z9 = z5;
                    z10 = z4;
                    i2 = i3;
                    arrayList2 = arrayList;
                    r2 = 0;
                }
            } catch (Exception e7) {
                e = e7;
                arrayList = arrayList2;
                z2 = z9;
                z = z10;
                z3 = z2;
                e.printStackTrace();
                System.out.println("EXCEPTION : ".concat(String.valueOf(e)));
                if (z3) {
                }
                if (z8) {
                }
                z4 = z;
                z5 = false;
                max = Math.max(this.O000o000, O00000oO());
                if (max > O00000oO()) {
                }
                max2 = Math.max(this.O000o00, O00000oo());
                if (max2 > O00000oo()) {
                }
                if (!z4) {
                }
                z9 = z5;
                z10 = z4;
                i2 = i3;
                arrayList2 = arrayList;
                r2 = 0;
            }
            if (z3) {
            }
            if (z8) {
            }
            z4 = z;
            z5 = false;
            max = Math.max(this.O000o000, O00000oO());
            if (max > O00000oO()) {
            }
            max2 = Math.max(this.O000o00, O00000oo());
            if (max2 > O00000oo()) {
            }
            if (!z4) {
            }
            z9 = z5;
            z10 = z4;
            i2 = i3;
            arrayList2 = arrayList;
            r2 = 0;
        }
        boolean z12 = z10;
        this.O00O0OoO = arrayList2;
        if (z12) {
            this.O000Oo00[0] = dimensionBehaviour2;
            this.O000Oo00[1] = dimensionBehaviour;
        }
        O000000o(this.O000ooO.O0000OOo);
    }

    private void O0000oOo() {
        this.O000oooO = 0;
        this.O000oooo = 0;
    }

    public final void O000000o(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            O00000o0(constraintWidget);
        } else if (i == 1) {
            O00000o(constraintWidget);
        }
    }

    private void O00000o0(ConstraintWidget constraintWidget) {
        int i = this.O000oooO + 1;
        oOo000Oo[] ooo000ooArr = this.O00oOOoo;
        if (i >= ooo000ooArr.length) {
            this.O00oOOoo = (oOo000Oo[]) Arrays.copyOf(ooo000ooArr, ooo000ooArr.length * 2);
        }
        this.O00oOOoo[this.O000oooO] = new oOo000Oo(constraintWidget, 0, this.O000oo);
        this.O000oooO++;
    }

    private void O00000o(ConstraintWidget constraintWidget) {
        int i = this.O000oooo + 1;
        oOo000Oo[] ooo000ooArr = this.oooOoO;
        if (i >= ooo000ooArr.length) {
            this.oooOoO = (oOo000Oo[]) Arrays.copyOf(ooo000ooArr, ooo000ooArr.length * 2);
        }
        this.oooOoO[this.O000oooo] = new oOo000Oo(constraintWidget, 1, this.O000oo);
        this.O000oooo++;
    }
}
