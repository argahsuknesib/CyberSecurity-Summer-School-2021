package _m_j;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

public final class oOo000o0 extends oOo0oooO {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2327O000000o = -1;
    public int O00000Oo = -1;
    public int O00000o0 = -1;
    public int O000oo = -1;
    public int O000ooO = -1;
    public int O000ooO0 = -1;
    public float O000ooOO = 0.5f;
    public float O000ooOo = 0.5f;
    public float O000ooo = 0.5f;
    public float O000ooo0 = 0.5f;
    public float O000oooO = 0.5f;
    public float O000oooo = 0.5f;
    public int O00O000o = 2;
    public int O00O00Oo = 2;
    public int O00O00o = -1;
    public int O00O00o0 = 0;
    public int O00O00oO = 0;
    public ConstraintWidget[] O00O00oo;
    public int O00O0O0o = 0;
    private ConstraintWidget[] O00O0oo = null;
    private ArrayList<O000000o> O00O0oo0 = new ArrayList<>();
    private ConstraintWidget[] O00O0ooO = null;
    private int[] O00O0ooo = null;
    public int O00oOOoo = 0;
    public int oooOoO = 0;

    public final void O000000o(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.O000000o(constraintWidget, hashMap);
        oOo000o0 ooo000o0 = (oOo000o0) constraintWidget;
        this.f2327O000000o = ooo000o0.f2327O000000o;
        this.O00000Oo = ooo000o0.O00000Oo;
        this.O00000o0 = ooo000o0.O00000o0;
        this.O000oo = ooo000o0.O000oo;
        this.O000ooO0 = ooo000o0.O000ooO0;
        this.O000ooO = ooo000o0.O000ooO;
        this.O000ooOO = ooo000o0.O000ooOO;
        this.O000ooOo = ooo000o0.O000ooOo;
        this.O000ooo0 = ooo000o0.O000ooo0;
        this.O000ooo = ooo000o0.O000ooo;
        this.O000oooO = ooo000o0.O000oooO;
        this.O000oooo = ooo000o0.O000oooo;
        this.oooOoO = ooo000o0.oooOoO;
        this.O00oOOoo = ooo000o0.O00oOOoo;
        this.O00O000o = ooo000o0.O00O000o;
        this.O00O00Oo = ooo000o0.O00O00Oo;
        this.O00O00o0 = ooo000o0.O00O00o0;
        this.O00O00o = ooo000o0.O00O00o;
        this.O00O00oO = ooo000o0.O00O00oO;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r28v2 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r28v4 */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* JADX WARN: Type inference failed for: r28v6 */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0205 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0124  */
    public final void O000000o(int r34, int r35, int r36, int r37) {
        /*
            r33 = this;
            r8 = r33
            r9 = r34
            r10 = r35
            r11 = r36
            r12 = r37
            int r0 = r8.O00O0OOo
            r13 = 0
            if (r0 <= 0) goto L_0x001b
            boolean r0 = r33.O0000oO0()
            if (r0 != 0) goto L_0x001b
            r8.O00000o(r13, r13)
            r8.O00O0o0o = r13
            return
        L_0x001b:
            int r14 = r8.O00O0o0
            int r15 = r8.O00O0o0O
            int r7 = r8.O00O0Oo0
            int r6 = r8.O00O0OoO
            r0 = 2
            int[] r5 = new int[r0]
            int r1 = r10 - r14
            int r1 = r1 - r15
            int r2 = r8.O00O00oO
            r4 = 1
            if (r2 != r4) goto L_0x0031
            int r1 = r12 - r7
            int r1 = r1 - r6
        L_0x0031:
            r3 = r1
            int r1 = r8.O00O00oO
            r2 = -1
            if (r1 != 0) goto L_0x0044
            int r1 = r8.f2327O000000o
            if (r1 != r2) goto L_0x003d
            r8.f2327O000000o = r13
        L_0x003d:
            int r1 = r8.O00000Oo
            if (r1 != r2) goto L_0x0050
            r8.O00000Oo = r13
            goto L_0x0050
        L_0x0044:
            int r1 = r8.f2327O000000o
            if (r1 != r2) goto L_0x004a
            r8.f2327O000000o = r13
        L_0x004a:
            int r1 = r8.O00000Oo
            if (r1 != r2) goto L_0x0050
            r8.O00000Oo = r13
        L_0x0050:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r8.O00O0OO
            r2 = 0
            r16 = 0
        L_0x0055:
            int r13 = r8.O00O0OOo
            r0 = 8
            if (r2 >= r13) goto L_0x0069
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r13 = r8.O00O0OO
            r13 = r13[r2]
            int r13 = r13.O000o0O
            if (r13 != r0) goto L_0x0065
            int r16 = r16 + 1
        L_0x0065:
            int r2 = r2 + 1
            r0 = 2
            goto L_0x0055
        L_0x0069:
            int r2 = r8.O00O0OOo
            if (r16 <= 0) goto L_0x0091
            int r1 = r8.O00O0OOo
            int r1 = r1 - r16
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = new androidx.constraintlayout.solver.widgets.ConstraintWidget[r1]
            r2 = 0
            r13 = 0
        L_0x0075:
            int r4 = r8.O00O0OOo
            if (r2 >= r4) goto L_0x008c
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r4 = r8.O00O0OO
            r4 = r4[r2]
            r18 = r6
            int r6 = r4.O000o0O
            if (r6 == r0) goto L_0x0087
            r1[r13] = r4
            int r13 = r13 + 1
        L_0x0087:
            int r2 = r2 + 1
            r6 = r18
            goto L_0x0075
        L_0x008c:
            r18 = r6
            r6 = r13
            r13 = r1
            goto L_0x0095
        L_0x0091:
            r18 = r6
            r13 = r1
            r6 = r2
        L_0x0095:
            r8.O00O00oo = r13
            r8.O00O0O0o = r6
            int r0 = r8.O00O00o0
            if (r0 == 0) goto L_0x0450
            r2 = 1
            if (r0 == r2) goto L_0x0219
            r2 = 2
            if (r0 == r2) goto L_0x00b2
            r28 = r5
            r30 = r7
            r32 = r14
            r31 = r15
            r29 = r18
        L_0x00ad:
            r4 = 1
            r16 = 0
            goto L_0x04dd
        L_0x00b2:
            int r0 = r8.O00O00oO
            if (r0 != 0) goto L_0x00df
            int r2 = r8.O00O00o
            if (r2 > 0) goto L_0x00db
            r2 = 0
            r4 = 0
            r19 = 0
        L_0x00be:
            if (r2 >= r6) goto L_0x00d5
            if (r2 <= 0) goto L_0x00c5
            int r1 = r8.oooOoO
            int r4 = r4 + r1
        L_0x00c5:
            r1 = r13[r2]
            if (r1 == 0) goto L_0x00d2
            int r1 = r8.O000000o(r1, r3)
            int r4 = r4 + r1
            if (r4 > r3) goto L_0x00d5
            int r19 = r19 + 1
        L_0x00d2:
            int r2 = r2 + 1
            goto L_0x00be
        L_0x00d5:
            r2 = r19
            r1 = 0
            r19 = r7
            goto L_0x010b
        L_0x00db:
            r19 = r7
            r1 = 0
            goto L_0x010b
        L_0x00df:
            int r1 = r8.O00O00o
            if (r1 > 0) goto L_0x0108
            r1 = 0
            r2 = 0
            r4 = 0
        L_0x00e6:
            if (r1 >= r6) goto L_0x0104
            if (r1 <= 0) goto L_0x00f0
            r19 = r7
            int r7 = r8.O00oOOoo
            int r2 = r2 + r7
            goto L_0x00f2
        L_0x00f0:
            r19 = r7
        L_0x00f2:
            r7 = r13[r1]
            if (r7 == 0) goto L_0x00ff
            int r7 = r8.O00000Oo(r7, r3)
            int r2 = r2 + r7
            if (r2 > r3) goto L_0x0106
            int r4 = r4 + 1
        L_0x00ff:
            int r1 = r1 + 1
            r7 = r19
            goto L_0x00e6
        L_0x0104:
            r19 = r7
        L_0x0106:
            r1 = r4
            goto L_0x010a
        L_0x0108:
            r19 = r7
        L_0x010a:
            r2 = 0
        L_0x010b:
            int[] r4 = r8.O00O0ooo
            if (r4 != 0) goto L_0x0114
            r4 = 2
            int[] r4 = new int[r4]
            r8.O00O0ooo = r4
        L_0x0114:
            if (r1 != 0) goto L_0x0119
            r4 = 1
            if (r0 == r4) goto L_0x011d
        L_0x0119:
            if (r2 != 0) goto L_0x0120
            if (r0 != 0) goto L_0x0120
        L_0x011d:
            r4 = r1
        L_0x011e:
            r1 = 1
            goto L_0x0122
        L_0x0120:
            r4 = r1
            r1 = 0
        L_0x0122:
            if (r1 != 0) goto L_0x0205
            if (r0 != 0) goto L_0x0130
            float r4 = (float) r6
            float r7 = (float) r2
            float r4 = r4 / r7
            double r11 = (double) r4
            double r11 = java.lang.Math.ceil(r11)
            int r4 = (int) r11
            goto L_0x0139
        L_0x0130:
            float r2 = (float) r6
            float r7 = (float) r4
            float r2 = r2 / r7
            double r11 = (double) r2
            double r11 = java.lang.Math.ceil(r11)
            int r2 = (int) r11
        L_0x0139:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r7 = r8.O00O0ooO
            if (r7 == 0) goto L_0x0146
            int r11 = r7.length
            if (r11 >= r2) goto L_0x0141
            goto L_0x0146
        L_0x0141:
            r11 = 0
            java.util.Arrays.fill(r7, r11)
            goto L_0x014b
        L_0x0146:
            r11 = 0
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r7 = new androidx.constraintlayout.solver.widgets.ConstraintWidget[r2]
            r8.O00O0ooO = r7
        L_0x014b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r7 = r8.O00O0oo
            if (r7 == 0) goto L_0x0157
            int r12 = r7.length
            if (r12 >= r4) goto L_0x0153
            goto L_0x0157
        L_0x0153:
            java.util.Arrays.fill(r7, r11)
            goto L_0x015b
        L_0x0157:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r7 = new androidx.constraintlayout.solver.widgets.ConstraintWidget[r4]
            r8.O00O0oo = r7
        L_0x015b:
            r7 = 0
        L_0x015c:
            if (r7 >= r2) goto L_0x01ae
            r11 = 0
        L_0x015f:
            if (r11 >= r4) goto L_0x01a7
            int r12 = r11 * r2
            int r12 = r12 + r7
            r17 = r1
            r1 = 1
            if (r0 != r1) goto L_0x016d
            int r1 = r7 * r4
            int r12 = r1 + r11
        L_0x016d:
            int r1 = r13.length
            if (r12 >= r1) goto L_0x01a0
            r1 = r13[r12]
            if (r1 == 0) goto L_0x01a0
            int r12 = r8.O000000o(r1, r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = r8.O00O0ooO
            r21 = r10[r7]
            if (r21 == 0) goto L_0x0186
            r10 = r10[r7]
            int r10 = r10.O00000oO()
            if (r10 >= r12) goto L_0x018a
        L_0x0186:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = r8.O00O0ooO
            r10[r7] = r1
        L_0x018a:
            int r10 = r8.O00000Oo(r1, r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r12 = r8.O00O0oo
            r21 = r12[r11]
            if (r21 == 0) goto L_0x019c
            r12 = r12[r11]
            int r12 = r12.O00000oo()
            if (r12 >= r10) goto L_0x01a0
        L_0x019c:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = r8.O00O0oo
            r10[r11] = r1
        L_0x01a0:
            int r11 = r11 + 1
            r10 = r35
            r1 = r17
            goto L_0x015f
        L_0x01a7:
            r17 = r1
            int r7 = r7 + 1
            r10 = r35
            goto L_0x015c
        L_0x01ae:
            r17 = r1
            r1 = 0
            r7 = 0
        L_0x01b2:
            if (r1 >= r2) goto L_0x01c7
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = r8.O00O0ooO
            r10 = r10[r1]
            if (r10 == 0) goto L_0x01c4
            if (r1 <= 0) goto L_0x01bf
            int r11 = r8.oooOoO
            int r7 = r7 + r11
        L_0x01bf:
            int r10 = r8.O000000o(r10, r3)
            int r7 = r7 + r10
        L_0x01c4:
            int r1 = r1 + 1
            goto L_0x01b2
        L_0x01c7:
            r1 = 0
            r10 = 0
        L_0x01c9:
            if (r1 >= r4) goto L_0x01de
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r11 = r8.O00O0oo
            r11 = r11[r1]
            if (r11 == 0) goto L_0x01db
            if (r1 <= 0) goto L_0x01d6
            int r12 = r8.O00oOOoo
            int r10 = r10 + r12
        L_0x01d6:
            int r11 = r8.O00000Oo(r11, r3)
            int r10 = r10 + r11
        L_0x01db:
            int r1 = r1 + 1
            goto L_0x01c9
        L_0x01de:
            r1 = 0
            r5[r1] = r7
            r11 = 1
            r5[r11] = r10
            if (r0 != 0) goto L_0x01ed
            if (r7 <= r3) goto L_0x01fd
            if (r2 <= r11) goto L_0x01fd
            int r2 = r2 + -1
            goto L_0x01f3
        L_0x01ed:
            if (r10 <= r3) goto L_0x01fd
            if (r4 <= r11) goto L_0x01fd
            int r4 = r4 + -1
        L_0x01f3:
            r10 = r35
            r11 = r36
            r12 = r37
            r1 = r17
            goto L_0x0122
        L_0x01fd:
            r10 = r35
            r11 = r36
            r12 = r37
            goto L_0x011e
        L_0x0205:
            r11 = 1
            int[] r0 = r8.O00O0ooo
            r1 = 0
            r0[r1] = r2
            r0[r11] = r4
        L_0x020d:
            r28 = r5
            r32 = r14
            r31 = r15
            r29 = r18
            r30 = r19
            goto L_0x00ad
        L_0x0219:
            r19 = r7
            r11 = 1
            int r10 = r8.O00O00oO
            if (r6 == 0) goto L_0x020d
            java.util.ArrayList<_m_j.oOo000o0$O000000o> r0 = r8.O00O0oo0
            r0.clear()
            _m_j.oOo000o0$O000000o r12 = new _m_j.oOo000o0$O000000o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r8.O000O0o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r8.O000O0oO
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r8.O000O0oo
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r8.O000OO00
            r0 = r12
            r16 = r1
            r1 = r33
            r17 = r2
            r2 = r10
            r27 = r3
            r3 = r4
            r4 = r7
            r28 = r5
            r5 = r17
            r7 = r6
            r29 = r18
            r6 = r16
            r11 = r7
            r30 = r19
            r7 = r27
            r0.<init>(r2, r3, r4, r5, r6, r7)
            java.util.ArrayList<_m_j.oOo000o0$O000000o> r0 = r8.O00O0oo0
            r0.add(r12)
            if (r10 != 0) goto L_0x02d5
            r2 = r12
            r0 = 0
            r1 = 0
            r12 = 0
        L_0x0257:
            if (r12 >= r11) goto L_0x02d1
            r7 = r13[r12]
            r6 = r27
            int r16 = r8.O000000o(r7, r6)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r7.O000Oo00
            r4 = 0
            r3 = r3[r4]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x026c
            int r0 = r0 + 1
        L_0x026c:
            r17 = r0
            if (r1 == r6) goto L_0x0277
            int r0 = r8.oooOoO
            int r0 = r0 + r1
            int r0 = r0 + r16
            if (r0 <= r6) goto L_0x027d
        L_0x0277:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r2.f2328O000000o
            if (r0 == 0) goto L_0x027d
            r4 = 1
            goto L_0x027e
        L_0x027d:
            r4 = 0
        L_0x027e:
            if (r4 != 0) goto L_0x028b
            if (r12 <= 0) goto L_0x028b
            int r0 = r8.O00O00o
            if (r0 <= 0) goto L_0x028b
            int r0 = r12 % r0
            if (r0 != 0) goto L_0x028b
            r4 = 1
        L_0x028b:
            if (r4 == 0) goto L_0x02b9
            _m_j.oOo000o0$O000000o r5 = new _m_j.oOo000o0$O000000o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.O000O0o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r8.O000O0oO
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r8.O000O0oo
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r8.O000OO00
            r0 = r5
            r18 = r1
            r1 = r33
            r19 = r2
            r2 = r10
            r9 = r5
            r5 = r19
            r27 = r6
            r6 = r18
            r31 = r15
            r15 = r7
            r7 = r27
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r9.O00000oO = r12
            java.util.ArrayList<_m_j.oOo000o0$O000000o> r0 = r8.O00O0oo0
            r0.add(r9)
            r2 = r9
        L_0x02b6:
            r1 = r16
            goto L_0x02c5
        L_0x02b9:
            r27 = r6
            r31 = r15
            r15 = r7
            if (r12 <= 0) goto L_0x02b6
            int r0 = r8.oooOoO
            int r0 = r0 + r16
            int r1 = r1 + r0
        L_0x02c5:
            r2.O000000o(r15)
            int r12 = r12 + 1
            r9 = r34
            r0 = r17
            r15 = r31
            goto L_0x0257
        L_0x02d1:
            r31 = r15
            goto L_0x033e
        L_0x02d5:
            r31 = r15
            r0 = 0
            r1 = 0
            r9 = 0
        L_0x02da:
            if (r9 >= r11) goto L_0x033e
            r15 = r13[r9]
            r7 = r27
            int r16 = r8.O00000Oo(r15, r7)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r15.O000Oo00
            r3 = 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x02ef
            int r0 = r0 + 1
        L_0x02ef:
            r17 = r0
            if (r1 == r7) goto L_0x02fa
            int r0 = r8.O00oOOoo
            int r0 = r0 + r1
            int r0 = r0 + r16
            if (r0 <= r7) goto L_0x0300
        L_0x02fa:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r12.f2328O000000o
            if (r0 == 0) goto L_0x0300
            r4 = 1
            goto L_0x0301
        L_0x0300:
            r4 = 0
        L_0x0301:
            if (r4 != 0) goto L_0x030e
            if (r9 <= 0) goto L_0x030e
            int r0 = r8.O00O00o
            if (r0 <= 0) goto L_0x030e
            int r0 = r9 % r0
            if (r0 != 0) goto L_0x030e
            r4 = 1
        L_0x030e:
            if (r4 == 0) goto L_0x032d
            _m_j.oOo000o0$O000000o r12 = new _m_j.oOo000o0$O000000o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.O000O0o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r8.O000O0oO
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r8.O000O0oo
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r8.O000OO00
            r0 = r12
            r1 = r33
            r2 = r10
            r27 = r7
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r12.O00000oO = r9
            java.util.ArrayList<_m_j.oOo000o0$O000000o> r0 = r8.O00O0oo0
            r0.add(r12)
        L_0x032a:
            r1 = r16
            goto L_0x0336
        L_0x032d:
            r27 = r7
            if (r9 <= 0) goto L_0x032a
            int r0 = r8.O00oOOoo
            int r0 = r0 + r16
            int r1 = r1 + r0
        L_0x0336:
            r12.O000000o(r15)
            int r9 = r9 + 1
            r0 = r17
            goto L_0x02da
        L_0x033e:
            java.util.ArrayList<_m_j.oOo000o0$O000000o> r1 = r8.O00O0oo0
            int r1 = r1.size()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r8.O000O0o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.O000O0oO
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r8.O000O0oo
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r8.O000OO00
            int r6 = r8.O00O0o0
            int r7 = r8.O00O0Oo0
            int r9 = r8.O00O0o0O
            int r11 = r8.O00O0OoO
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r12 = r8.O000Oo00
            r13 = 0
            r12 = r12[r13]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 == r13) goto L_0x0369
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r12 = r8.O000Oo00
            r13 = 1
            r12 = r12[r13]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 != r13) goto L_0x0367
            goto L_0x0369
        L_0x0367:
            r12 = 0
            goto L_0x036a
        L_0x0369:
            r12 = 1
        L_0x036a:
            if (r0 <= 0) goto L_0x0391
            if (r12 == 0) goto L_0x0391
            r0 = 0
        L_0x036f:
            if (r0 >= r1) goto L_0x0391
            java.util.ArrayList<_m_j.oOo000o0$O000000o> r12 = r8.O00O0oo0
            java.lang.Object r12 = r12.get(r0)
            _m_j.oOo000o0$O000000o r12 = (_m_j.oOo000o0.O000000o) r12
            if (r10 != 0) goto L_0x0385
            int r13 = r12.O000000o()
            int r13 = r27 - r13
            r12.O000000o(r13)
            goto L_0x038e
        L_0x0385:
            int r13 = r12.O00000Oo()
            int r13 = r27 - r13
            r12.O000000o(r13)
        L_0x038e:
            int r0 = r0 + 1
            goto L_0x036f
        L_0x0391:
            r12 = r4
            r13 = r9
            r0 = 0
            r4 = r2
            r9 = r7
            r2 = 0
            r7 = r6
            r6 = r5
            r5 = r3
            r3 = 0
        L_0x039b:
            if (r0 >= r1) goto L_0x0446
            java.util.ArrayList<_m_j.oOo000o0$O000000o> r15 = r8.O00O0oo0
            java.lang.Object r15 = r15.get(r0)
            _m_j.oOo000o0$O000000o r15 = (_m_j.oOo000o0.O000000o) r15
            if (r10 != 0) goto L_0x03f5
            int r6 = r1 + -1
            if (r0 >= r6) goto L_0x03bd
            java.util.ArrayList<_m_j.oOo000o0$O000000o> r6 = r8.O00O0oo0
            int r11 = r0 + 1
            java.lang.Object r6 = r6.get(r11)
            _m_j.oOo000o0$O000000o r6 = (_m_j.oOo000o0.O000000o) r6
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r6.f2328O000000o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.O000O0oO
            r32 = r14
            r11 = 0
            goto L_0x03c3
        L_0x03bd:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r8.O000OO00
            int r11 = r8.O00O0OoO
            r32 = r14
        L_0x03c3:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r15.f2328O000000o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r14.O000OO00
            r16 = r15
            r17 = r10
            r18 = r4
            r19 = r5
            r20 = r12
            r21 = r6
            r22 = r7
            r23 = r9
            r24 = r13
            r25 = r11
            r26 = r27
            r16.O000000o(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            int r5 = r15.O000000o()
            int r2 = java.lang.Math.max(r2, r5)
            int r5 = r15.O00000Oo()
            int r3 = r3 + r5
            if (r0 <= 0) goto L_0x03f2
            int r5 = r8.O00oOOoo
            int r3 = r3 + r5
        L_0x03f2:
            r5 = r14
            r9 = 0
            goto L_0x0440
        L_0x03f5:
            r32 = r14
            int r12 = r1 + -1
            if (r0 >= r12) goto L_0x040b
            java.util.ArrayList<_m_j.oOo000o0$O000000o> r12 = r8.O00O0oo0
            int r13 = r0 + 1
            java.lang.Object r12 = r12.get(r13)
            _m_j.oOo000o0$O000000o r12 = (_m_j.oOo000o0.O000000o) r12
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r12.f2328O000000o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r12.O000O0o
            r13 = 0
            goto L_0x040f
        L_0x040b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r8.O000O0oo
            int r13 = r8.O00O0o0O
        L_0x040f:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r15.f2328O000000o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r14.O000O0oo
            r16 = r15
            r17 = r10
            r18 = r4
            r19 = r5
            r20 = r12
            r21 = r6
            r22 = r7
            r23 = r9
            r24 = r13
            r25 = r11
            r26 = r27
            r16.O000000o(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            int r4 = r15.O000000o()
            int r2 = r2 + r4
            int r4 = r15.O00000Oo()
            int r3 = java.lang.Math.max(r3, r4)
            if (r0 <= 0) goto L_0x043e
            int r4 = r8.oooOoO
            int r2 = r2 + r4
        L_0x043e:
            r4 = r14
            r7 = 0
        L_0x0440:
            int r0 = r0 + 1
            r14 = r32
            goto L_0x039b
        L_0x0446:
            r32 = r14
            r0 = 0
            r28[r0] = r2
            r0 = 1
            r28[r0] = r3
            goto L_0x00ad
        L_0x0450:
            r27 = r3
            r28 = r5
            r11 = r6
            r30 = r7
            r32 = r14
            r31 = r15
            r29 = r18
            int r2 = r8.O00O00oO
            if (r11 == 0) goto L_0x00ad
            java.util.ArrayList<_m_j.oOo000o0$O000000o> r0 = r8.O00O0oo0
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0482
            _m_j.oOo000o0$O000000o r9 = new _m_j.oOo000o0$O000000o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.O000O0o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r8.O000O0oO
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r8.O000O0oo
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r8.O000OO00
            r0 = r9
            r1 = r33
            r7 = r27
            r0.<init>(r2, r3, r4, r5, r6, r7)
            java.util.ArrayList<_m_j.oOo000o0$O000000o> r0 = r8.O00O0oo0
            r0.add(r9)
            r0 = r9
            goto L_0x04c3
        L_0x0482:
            java.util.ArrayList<_m_j.oOo000o0$O000000o> r0 = r8.O00O0oo0
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            _m_j.oOo000o0$O000000o r0 = (_m_j.oOo000o0.O000000o) r0
            r0.O00000Oo = r1
            r3 = 0
            r0.f2328O000000o = r3
            r0.O00000o0 = r1
            r0.O00000o = r1
            r0.O00000oO = r1
            r0.O00000oo = r1
            r0.O0000O0o = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r8.O000O0o
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.O000O0oO
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r8.O000O0oo
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r8.O000OO00
            int r6 = r8.O00O0o0
            int r7 = r8.O00O0Oo0
            int r9 = r8.O00O0o0O
            int r10 = r8.O00O0OoO
            r16 = r0
            r17 = r2
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r9
            r25 = r10
            r26 = r27
            r16.O000000o(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
        L_0x04c3:
            r1 = 0
        L_0x04c4:
            if (r1 >= r11) goto L_0x04ce
            r2 = r13[r1]
            r0.O000000o(r2)
            int r1 = r1 + 1
            goto L_0x04c4
        L_0x04ce:
            int r1 = r0.O000000o()
            r16 = 0
            r28[r16] = r1
            int r0 = r0.O00000Oo()
            r4 = 1
            r28[r4] = r0
        L_0x04dd:
            r0 = r28[r16]
            int r0 = r0 + r32
            int r0 = r0 + r31
            r1 = r28[r4]
            int r1 = r1 + r30
            int r1 = r1 + r29
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r5 = r34
            if (r5 != r3) goto L_0x04f6
            r5 = r35
        L_0x04f3:
            r0 = r36
            goto L_0x0506
        L_0x04f6:
            if (r5 != r2) goto L_0x0500
            r6 = r35
            int r0 = java.lang.Math.min(r0, r6)
        L_0x04fe:
            r5 = r0
            goto L_0x04f3
        L_0x0500:
            if (r5 != 0) goto L_0x0503
            goto L_0x04fe
        L_0x0503:
            r0 = r36
            r5 = 0
        L_0x0506:
            if (r0 != r3) goto L_0x050b
            r0 = r37
            goto L_0x0519
        L_0x050b:
            if (r0 != r2) goto L_0x0514
            r2 = r37
            int r0 = java.lang.Math.min(r1, r2)
            goto L_0x0519
        L_0x0514:
            if (r0 != 0) goto L_0x0518
            r0 = r1
            goto L_0x0519
        L_0x0518:
            r0 = 0
        L_0x0519:
            r8.O00000o(r5, r0)
            r8.O00000oO(r5)
            r8.O00000oo(r0)
            int r0 = r8.O00O0OOo
            if (r0 <= 0) goto L_0x0527
            goto L_0x0528
        L_0x0527:
            r4 = 0
        L_0x0528:
            r8.O00O0o0o = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.oOo000o0.O000000o(int, int, int, int):void");
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public ConstraintWidget f2328O000000o = null;
        int O00000Oo = 0;
        int O00000o = 0;
        int O00000o0 = 0;
        int O00000oO = 0;
        int O00000oo = 0;
        int O0000O0o = 0;
        private ConstraintAnchor O0000Oo;
        private int O0000Oo0 = 0;
        private ConstraintAnchor O0000OoO;
        private ConstraintAnchor O0000Ooo;
        private int O0000o = 0;
        private int O0000o0 = 0;
        private ConstraintAnchor O0000o00;
        private int O0000o0O = 0;
        private int O0000o0o = 0;
        private int O0000oO0 = 0;

        public O000000o(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2) {
            this.O0000Oo0 = i;
            this.O0000Oo = constraintAnchor;
            this.O0000OoO = constraintAnchor2;
            this.O0000Ooo = constraintAnchor3;
            this.O0000o00 = constraintAnchor4;
            this.O0000o0 = oOo000o0.this.O00O0o0;
            this.O0000o0O = oOo000o0.this.O00O0Oo0;
            this.O0000o0o = oOo000o0.this.O00O0o0O;
            this.O0000o = oOo000o0.this.O00O0OoO;
            this.O0000oO0 = i2;
        }

        public final void O000000o(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2, int i3, int i4, int i5, int i6) {
            this.O0000Oo0 = i;
            this.O0000Oo = constraintAnchor;
            this.O0000OoO = constraintAnchor2;
            this.O0000Ooo = constraintAnchor3;
            this.O0000o00 = constraintAnchor4;
            this.O0000o0 = i2;
            this.O0000o0O = i3;
            this.O0000o0o = i4;
            this.O0000o = i5;
            this.O0000oO0 = i6;
        }

        public final int O000000o() {
            if (this.O0000Oo0 == 0) {
                return this.O00000o0 - oOo000o0.this.oooOoO;
            }
            return this.O00000o0;
        }

        public final int O00000Oo() {
            if (this.O0000Oo0 == 1) {
                return this.O00000o - oOo000o0.this.O00oOOoo;
            }
            return this.O00000o;
        }

        public final void O000000o(ConstraintWidget constraintWidget) {
            int i = 0;
            if (this.O0000Oo0 == 0) {
                int O000000o2 = oOo000o0.this.O000000o(constraintWidget, this.O0000oO0);
                if (constraintWidget.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.O0000O0o++;
                    O000000o2 = 0;
                }
                int i2 = oOo000o0.this.oooOoO;
                if (constraintWidget.O000o0O != 8) {
                    i = i2;
                }
                this.O00000o0 += O000000o2 + i;
                int O00000Oo2 = oOo000o0.this.O00000Oo(constraintWidget, this.O0000oO0);
                if (this.f2328O000000o == null || this.O00000Oo < O00000Oo2) {
                    this.f2328O000000o = constraintWidget;
                    this.O00000Oo = O00000Oo2;
                    this.O00000o = O00000Oo2;
                }
            } else {
                int O000000o3 = oOo000o0.this.O000000o(constraintWidget, this.O0000oO0);
                int O00000Oo3 = oOo000o0.this.O00000Oo(constraintWidget, this.O0000oO0);
                if (constraintWidget.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.O0000O0o++;
                    O00000Oo3 = 0;
                }
                int i3 = oOo000o0.this.O00oOOoo;
                if (constraintWidget.O000o0O != 8) {
                    i = i3;
                }
                this.O00000o += O00000Oo3 + i;
                if (this.f2328O000000o == null || this.O00000Oo < O000000o3) {
                    this.f2328O000000o = constraintWidget;
                    this.O00000Oo = O000000o3;
                    this.O00000o0 = O000000o3;
                }
            }
            this.O00000oo++;
        }

        public final void O000000o(boolean z, int i, boolean z2) {
            ConstraintWidget constraintWidget;
            int i2 = this.O00000oo;
            int i3 = 0;
            while (i3 < i2 && this.O00000oO + i3 < oOo000o0.this.O00O0O0o) {
                ConstraintWidget constraintWidget2 = oOo000o0.this.O00O00oo[this.O00000oO + i3];
                if (constraintWidget2 != null) {
                    constraintWidget2.O0000Ooo();
                }
                i3++;
            }
            if (i2 != 0 && this.f2328O000000o != null) {
                boolean z3 = z2 && i == 0;
                int i4 = -1;
                int i5 = -1;
                for (int i6 = 0; i6 < i2; i6++) {
                    int i7 = z ? (i2 - 1) - i6 : i6;
                    if (this.O00000oO + i7 >= oOo000o0.this.O00O0O0o) {
                        break;
                    }
                    if (oOo000o0.this.O00O00oo[this.O00000oO + i7].O000o0O == 0) {
                        if (i4 == -1) {
                            i4 = i6;
                        }
                        i5 = i6;
                    }
                }
                if (this.O0000Oo0 == 0) {
                    ConstraintWidget constraintWidget3 = this.f2328O000000o;
                    constraintWidget3.O000oOOo = oOo000o0.this.O00000Oo;
                    int i8 = this.O0000o0O;
                    if (i > 0) {
                        i8 += oOo000o0.this.O00oOOoo;
                    }
                    constraintWidget3.O000O0oO.O000000o(this.O0000OoO, i8);
                    if (z2) {
                        constraintWidget3.O000OO00.O000000o(this.O0000o00, this.O0000o);
                    }
                    if (i > 0) {
                        this.O0000OoO.f2787O000000o.O000OO00.O000000o(constraintWidget3.O000O0oO, 0);
                    }
                    if (oOo000o0.this.O00O00Oo == 3 && !constraintWidget3.O000O0Oo) {
                        int i9 = 0;
                        while (true) {
                            if (i9 < i2) {
                                int i10 = z ? (i2 - 1) - i9 : i9;
                                if (this.O00000oO + i10 >= oOo000o0.this.O00O0O0o) {
                                    break;
                                }
                                constraintWidget = oOo000o0.this.O00O00oo[this.O00000oO + i10];
                                if (constraintWidget.O000O0Oo) {
                                    break;
                                }
                                i9++;
                            } else {
                                break;
                            }
                        }
                    }
                    constraintWidget = constraintWidget3;
                    ConstraintWidget constraintWidget4 = null;
                    int i11 = 0;
                    while (i11 < i2) {
                        int i12 = z ? (i2 - 1) - i11 : i11;
                        if (this.O00000oO + i12 < oOo000o0.this.O00O0O0o) {
                            ConstraintWidget constraintWidget5 = oOo000o0.this.O00O00oo[this.O00000oO + i12];
                            if (i11 == 0) {
                                constraintWidget5.O000000o(constraintWidget5.O000O0o, this.O0000Oo, this.O0000o0);
                            }
                            if (i12 == 0) {
                                int i13 = oOo000o0.this.f2327O000000o;
                                float f = oOo000o0.this.O000ooOO;
                                if (this.O00000oO == 0 && oOo000o0.this.O00000o0 != -1) {
                                    i13 = oOo000o0.this.O00000o0;
                                    f = oOo000o0.this.O000ooo0;
                                } else if (z2 && oOo000o0.this.O000ooO0 != -1) {
                                    i13 = oOo000o0.this.O000ooO0;
                                    f = oOo000o0.this.O000oooO;
                                }
                                constraintWidget5.O000oOOO = i13;
                                constraintWidget5.O000o00o = f;
                            }
                            if (i11 == i2 - 1) {
                                constraintWidget5.O000000o(constraintWidget5.O000O0oo, this.O0000Ooo, this.O0000o0o);
                            }
                            if (constraintWidget4 != null) {
                                constraintWidget5.O000O0o.O000000o(constraintWidget4.O000O0oo, oOo000o0.this.oooOoO);
                                if (i11 == i4) {
                                    constraintWidget5.O000O0o.O000000o(this.O0000o0);
                                }
                                constraintWidget4.O000O0oo.O000000o(constraintWidget5.O000O0o, 0);
                                if (i11 == i5 + 1) {
                                    constraintWidget4.O000O0oo.O000000o(this.O0000o0o);
                                }
                            }
                            if (constraintWidget5 != constraintWidget3) {
                                if (oOo000o0.this.O00O00Oo != 3 || !constraintWidget.O000O0Oo || constraintWidget5 == constraintWidget || !constraintWidget5.O000O0Oo) {
                                    int i14 = oOo000o0.this.O00O00Oo;
                                    if (i14 == 0) {
                                        constraintWidget5.O000O0oO.O000000o(constraintWidget3.O000O0oO, 0);
                                    } else if (i14 == 1) {
                                        constraintWidget5.O000OO00.O000000o(constraintWidget3.O000OO00, 0);
                                    } else if (z3) {
                                        constraintWidget5.O000O0oO.O000000o(this.O0000OoO, this.O0000o0O);
                                        constraintWidget5.O000OO00.O000000o(this.O0000o00, this.O0000o);
                                    } else {
                                        constraintWidget5.O000O0oO.O000000o(constraintWidget3.O000O0oO, 0);
                                        constraintWidget5.O000OO00.O000000o(constraintWidget3.O000OO00, 0);
                                    }
                                } else {
                                    constraintWidget5.O000OO0o.O000000o(constraintWidget.O000OO0o, 0);
                                }
                            }
                            i11++;
                            constraintWidget4 = constraintWidget5;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                ConstraintWidget constraintWidget6 = this.f2328O000000o;
                constraintWidget6.O000oOOO = oOo000o0.this.f2327O000000o;
                int i15 = this.O0000o0;
                if (i > 0) {
                    i15 += oOo000o0.this.oooOoO;
                }
                if (z) {
                    constraintWidget6.O000O0oo.O000000o(this.O0000Ooo, i15);
                    if (z2) {
                        constraintWidget6.O000O0o.O000000o(this.O0000Oo, this.O0000o0o);
                    }
                    if (i > 0) {
                        this.O0000Ooo.f2787O000000o.O000O0o.O000000o(constraintWidget6.O000O0oo, 0);
                    }
                } else {
                    constraintWidget6.O000O0o.O000000o(this.O0000Oo, i15);
                    if (z2) {
                        constraintWidget6.O000O0oo.O000000o(this.O0000Ooo, this.O0000o0o);
                    }
                    if (i > 0) {
                        this.O0000Oo.f2787O000000o.O000O0oo.O000000o(constraintWidget6.O000O0o, 0);
                    }
                }
                ConstraintWidget constraintWidget7 = null;
                int i16 = 0;
                while (i16 < i2 && this.O00000oO + i16 < oOo000o0.this.O00O0O0o) {
                    ConstraintWidget constraintWidget8 = oOo000o0.this.O00O00oo[this.O00000oO + i16];
                    if (i16 == 0) {
                        constraintWidget8.O000000o(constraintWidget8.O000O0oO, this.O0000OoO, this.O0000o0O);
                        int i17 = oOo000o0.this.O00000Oo;
                        float f2 = oOo000o0.this.O000ooOo;
                        if (this.O00000oO == 0 && oOo000o0.this.O000oo != -1) {
                            i17 = oOo000o0.this.O000oo;
                            f2 = oOo000o0.this.O000ooo;
                        } else if (z2 && oOo000o0.this.O000ooO != -1) {
                            i17 = oOo000o0.this.O000ooO;
                            f2 = oOo000o0.this.O000oooo;
                        }
                        constraintWidget8.O000oOOo = i17;
                        constraintWidget8.O000o0 = f2;
                    }
                    if (i16 == i2 - 1) {
                        constraintWidget8.O000000o(constraintWidget8.O000OO00, this.O0000o00, this.O0000o);
                    }
                    if (constraintWidget7 != null) {
                        constraintWidget8.O000O0oO.O000000o(constraintWidget7.O000OO00, oOo000o0.this.O00oOOoo);
                        if (i16 == i4) {
                            constraintWidget8.O000O0oO.O000000o(this.O0000o0O);
                        }
                        constraintWidget7.O000OO00.O000000o(constraintWidget8.O000O0oO, 0);
                        if (i16 == i5 + 1) {
                            constraintWidget7.O000OO00.O000000o(this.O0000o);
                        }
                    }
                    if (constraintWidget8 != constraintWidget6) {
                        if (z) {
                            int i18 = oOo000o0.this.O00O000o;
                            if (i18 == 0) {
                                constraintWidget8.O000O0oo.O000000o(constraintWidget6.O000O0oo, 0);
                            } else if (i18 == 1) {
                                constraintWidget8.O000O0o.O000000o(constraintWidget6.O000O0o, 0);
                            } else if (i18 == 2) {
                                constraintWidget8.O000O0o.O000000o(constraintWidget6.O000O0o, 0);
                                constraintWidget8.O000O0oo.O000000o(constraintWidget6.O000O0oo, 0);
                            }
                        } else {
                            int i19 = oOo000o0.this.O00O000o;
                            if (i19 == 0) {
                                constraintWidget8.O000O0o.O000000o(constraintWidget6.O000O0o, 0);
                            } else if (i19 == 1) {
                                constraintWidget8.O000O0oo.O000000o(constraintWidget6.O000O0oo, 0);
                            } else if (i19 == 2) {
                                if (z3) {
                                    constraintWidget8.O000O0o.O000000o(this.O0000Oo, this.O0000o0);
                                    constraintWidget8.O000O0oo.O000000o(this.O0000Ooo, this.O0000o0o);
                                } else {
                                    constraintWidget8.O000O0o.O000000o(constraintWidget6.O000O0o, 0);
                                    constraintWidget8.O000O0oo.O000000o(constraintWidget6.O000O0oo, 0);
                                }
                            }
                            i16++;
                            constraintWidget7 = constraintWidget8;
                        }
                    }
                    i16++;
                    constraintWidget7 = constraintWidget8;
                }
            }
        }

        public final void O000000o(int i) {
            int i2 = this.O0000O0o;
            if (i2 != 0) {
                int i3 = this.O00000oo;
                int i4 = i / i2;
                int i5 = 0;
                while (i5 < i3 && this.O00000oO + i5 < oOo000o0.this.O00O0O0o) {
                    ConstraintWidget constraintWidget = oOo000o0.this.O00O00oo[this.O00000oO + i5];
                    if (this.O0000Oo0 == 0) {
                        if (constraintWidget != null && constraintWidget.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.O0000o0O == 0) {
                            oOo000o0.this.O000000o(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i4, constraintWidget.O000Oo00[1], constraintWidget.O00000oo());
                        }
                    } else if (constraintWidget != null && constraintWidget.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.O0000o0o == 0) {
                        oOo000o0.this.O000000o(constraintWidget, constraintWidget.O000Oo00[0], constraintWidget.O00000oO(), ConstraintWidget.DimensionBehaviour.FIXED, i4);
                    }
                    i5++;
                }
                this.O00000o0 = 0;
                this.O00000o = 0;
                this.f2328O000000o = null;
                this.O00000Oo = 0;
                int i6 = this.O00000oo;
                int i7 = 0;
                while (i7 < i6 && this.O00000oO + i7 < oOo000o0.this.O00O0O0o) {
                    ConstraintWidget constraintWidget2 = oOo000o0.this.O00O00oo[this.O00000oO + i7];
                    if (this.O0000Oo0 == 0) {
                        int O00000oO2 = constraintWidget2.O00000oO();
                        int i8 = oOo000o0.this.oooOoO;
                        if (constraintWidget2.O000o0O == 8) {
                            i8 = 0;
                        }
                        this.O00000o0 += O00000oO2 + i8;
                        int O00000Oo2 = oOo000o0.this.O00000Oo(constraintWidget2, this.O0000oO0);
                        if (this.f2328O000000o == null || this.O00000Oo < O00000Oo2) {
                            this.f2328O000000o = constraintWidget2;
                            this.O00000Oo = O00000Oo2;
                            this.O00000o = O00000Oo2;
                        }
                    } else {
                        int O000000o2 = oOo000o0.this.O000000o(constraintWidget2, this.O0000oO0);
                        int O00000Oo3 = oOo000o0.this.O00000Oo(constraintWidget2, this.O0000oO0);
                        int i9 = oOo000o0.this.O00oOOoo;
                        if (constraintWidget2.O000o0O == 8) {
                            i9 = 0;
                        }
                        this.O00000o += O00000Oo3 + i9;
                        if (this.f2328O000000o == null || this.O00000Oo < O000000o2) {
                            this.f2328O000000o = constraintWidget2;
                            this.O00000Oo = O000000o2;
                            this.O00000o0 = O000000o2;
                        }
                    }
                    i7++;
                }
            }
        }
    }

    public final void O000000o(oO00Oo00 oo00oo00) {
        boolean z;
        ConstraintWidget constraintWidget;
        super.O000000o(oo00oo00);
        if (this.O000Oo0 != null) {
            z = ((oOo0000O) this.O000Oo0).O000oo;
        } else {
            z = false;
        }
        int i = this.O00O00o0;
        if (i != 0) {
            if (i == 1) {
                int size = this.O00O0oo0.size();
                int i2 = 0;
                while (i2 < size) {
                    this.O00O0oo0.get(i2).O000000o(z, i2, i2 == size + -1);
                    i2++;
                }
            } else if (!(i != 2 || this.O00O0ooo == null || this.O00O0ooO == null || this.O00O0oo == null)) {
                for (int i3 = 0; i3 < this.O00O0O0o; i3++) {
                    this.O00O00oo[i3].O0000Ooo();
                }
                int[] iArr = this.O00O0ooo;
                int i4 = iArr[0];
                int i5 = iArr[1];
                ConstraintWidget constraintWidget2 = null;
                for (int i6 = 0; i6 < i4; i6++) {
                    ConstraintWidget constraintWidget3 = this.O00O0ooO[z ? (i4 - i6) - 1 : i6];
                    if (!(constraintWidget3 == null || constraintWidget3.O000o0O == 8)) {
                        if (i6 == 0) {
                            constraintWidget3.O000000o(constraintWidget3.O000O0o, this.O000O0o, this.O00O0o0);
                            constraintWidget3.O000oOOO = this.f2327O000000o;
                            constraintWidget3.O000o00o = this.O000ooOO;
                        }
                        if (i6 == i4 - 1) {
                            constraintWidget3.O000000o(constraintWidget3.O000O0oo, this.O000O0oo, this.O00O0o0O);
                        }
                        if (i6 > 0) {
                            constraintWidget3.O000000o(constraintWidget3.O000O0o, constraintWidget2.O000O0oo, this.oooOoO);
                            constraintWidget2.O000000o(constraintWidget2.O000O0oo, constraintWidget3.O000O0o, 0);
                        }
                        constraintWidget2 = constraintWidget3;
                    }
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    ConstraintWidget constraintWidget4 = this.O00O0oo[i7];
                    if (!(constraintWidget4 == null || constraintWidget4.O000o0O == 8)) {
                        if (i7 == 0) {
                            constraintWidget4.O000000o(constraintWidget4.O000O0oO, this.O000O0oO, this.O00O0Oo0);
                            constraintWidget4.O000oOOo = this.O00000Oo;
                            constraintWidget4.O000o0 = this.O000ooOo;
                        }
                        if (i7 == i5 - 1) {
                            constraintWidget4.O000000o(constraintWidget4.O000OO00, this.O000OO00, this.O00O0OoO);
                        }
                        if (i7 > 0) {
                            constraintWidget4.O000000o(constraintWidget4.O000O0oO, constraintWidget2.O000OO00, this.O00oOOoo);
                            constraintWidget2.O000000o(constraintWidget2.O000OO00, constraintWidget4.O000O0oO, 0);
                        }
                        constraintWidget2 = constraintWidget4;
                    }
                }
                for (int i8 = 0; i8 < i4; i8++) {
                    for (int i9 = 0; i9 < i5; i9++) {
                        int i10 = (i9 * i4) + i8;
                        if (this.O00O00oO == 1) {
                            i10 = (i8 * i5) + i9;
                        }
                        ConstraintWidget[] constraintWidgetArr = this.O00O00oo;
                        if (!(i10 >= constraintWidgetArr.length || (constraintWidget = constraintWidgetArr[i10]) == null || constraintWidget.O000o0O == 8)) {
                            ConstraintWidget constraintWidget5 = this.O00O0ooO[i8];
                            ConstraintWidget constraintWidget6 = this.O00O0oo[i9];
                            if (constraintWidget != constraintWidget5) {
                                constraintWidget.O000000o(constraintWidget.O000O0o, constraintWidget5.O000O0o, 0);
                                constraintWidget.O000000o(constraintWidget.O000O0oo, constraintWidget5.O000O0oo, 0);
                            }
                            if (constraintWidget != constraintWidget6) {
                                constraintWidget.O000000o(constraintWidget.O000O0oO, constraintWidget6.O000O0oO, 0);
                                constraintWidget.O000000o(constraintWidget.O000OO00, constraintWidget6.O000OO00, 0);
                            }
                        }
                    }
                }
            }
        } else if (this.O00O0oo0.size() > 0) {
            this.O00O0oo0.get(0).O000000o(z, 0, true);
        }
        this.O00O0o0o = false;
    }

    public final int O000000o(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.O0000o0O == 0) {
                return 0;
            }
            if (constraintWidget.O0000o0O == 2) {
                int i2 = (int) (constraintWidget.O0000oOO * ((float) i));
                if (i2 != constraintWidget.O00000oO()) {
                    O000000o(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i2, constraintWidget.O000Oo00[1], constraintWidget.O00000oo());
                }
                return i2;
            } else if (constraintWidget.O0000o0O == 1) {
                return constraintWidget.O00000oO();
            } else {
                if (constraintWidget.O0000o0O == 3) {
                    return (int) ((((float) constraintWidget.O00000oo()) * constraintWidget.O000OoO0) + 0.5f);
                }
            }
        }
        return constraintWidget.O00000oO();
    }

    public final int O00000Oo(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.O0000o0o == 0) {
                return 0;
            }
            if (constraintWidget.O0000o0o == 2) {
                int i2 = (int) (constraintWidget.O0000oo * ((float) i));
                if (i2 != constraintWidget.O00000oo()) {
                    O000000o(constraintWidget, constraintWidget.O000Oo00[0], constraintWidget.O00000oO(), ConstraintWidget.DimensionBehaviour.FIXED, i2);
                }
                return i2;
            } else if (constraintWidget.O0000o0o == 1) {
                return constraintWidget.O00000oo();
            } else {
                if (constraintWidget.O0000o0o == 3) {
                    return (int) ((((float) constraintWidget.O00000oO()) * constraintWidget.O000OoO0) + 0.5f);
                }
            }
        }
        return constraintWidget.O00000oo();
    }
}
