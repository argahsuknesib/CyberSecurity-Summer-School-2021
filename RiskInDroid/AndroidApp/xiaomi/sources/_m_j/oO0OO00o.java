package _m_j;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

final class oO0OO00o {
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0447  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x044e  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x04db  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x05a0  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x05fb  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0600  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0606  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x060e  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0614  */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x0626  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0639  */
    static void O000000o(oOo0000O ooo0000o, oO00Oo00 oo00oo00, int i) {
        int i2;
        int i3;
        oOo000Oo[] ooo000ooArr;
        boolean z;
        int i4;
        float f;
        boolean z2;
        boolean z3;
        boolean z4;
        ConstraintWidget constraintWidget;
        oOo000Oo ooo000oo;
        int i5;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintAnchor constraintAnchor;
        int i6;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget5;
        SolverVariable solverVariable3;
        ConstraintWidget constraintWidget6;
        int i7;
        ConstraintWidget constraintWidget7;
        oOo000Oo ooo000oo2;
        ConstraintWidget constraintWidget8;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget9;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        ConstraintAnchor constraintAnchor5;
        ConstraintWidget constraintWidget10;
        ConstraintWidget constraintWidget11;
        int i8;
        ConstraintWidget constraintWidget12;
        ConstraintWidget constraintWidget13;
        int i9;
        ConstraintWidget constraintWidget14;
        ConstraintWidget constraintWidget15;
        ConstraintWidget constraintWidget16;
        ConstraintAnchor constraintAnchor6;
        SolverVariable solverVariable6;
        int i10;
        ConstraintWidget constraintWidget17;
        float f2;
        int size;
        int i11;
        ArrayList<ConstraintWidget> arrayList;
        int i12;
        oOo000Oo ooo000oo3;
        ConstraintWidget constraintWidget18;
        int i13;
        ConstraintWidget constraintWidget19;
        ConstraintWidget constraintWidget20;
        int i14;
        oOo000Oo[] ooo000ooArr2;
        boolean z5;
        int i15;
        boolean z6;
        oOo0000O ooo0000o2 = ooo0000o;
        oO00Oo00 oo00oo002 = oo00oo00;
        if (i == 0) {
            i2 = ooo0000o2.O000oooO;
            ooo000ooArr = ooo0000o2.O00oOOoo;
            i3 = 0;
        } else {
            i2 = ooo0000o2.O000oooo;
            ooo000ooArr = ooo0000o2.oooOoO;
            i3 = 2;
        }
        int i16 = 0;
        while (i16 < i2) {
            oOo000Oo ooo000oo4 = ooo000ooArr[i16];
            if (!ooo000oo4.O0000oOO) {
                ooo000oo4.O000000o();
            }
            ooo000oo4.O0000oOO = true;
            ConstraintWidget constraintWidget21 = ooo000oo4.f2326O000000o;
            ConstraintWidget constraintWidget22 = ooo000oo4.O00000o0;
            ConstraintWidget constraintWidget23 = ooo000oo4.O00000Oo;
            ConstraintWidget constraintWidget24 = ooo000oo4.O00000o;
            ConstraintWidget constraintWidget25 = ooo000oo4.O00000oO;
            float f3 = ooo000oo4.O0000OoO;
            boolean z7 = ooo0000o2.O000Oo00[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (i == 0) {
                if (constraintWidget25.O000oOOO == 0) {
                    f = f3;
                    z6 = true;
                } else {
                    f = f3;
                    z6 = false;
                }
                boolean z8 = constraintWidget25.O000oOOO == 1;
                z4 = constraintWidget25.O000oOOO == 2;
                constraintWidget = constraintWidget21;
                z2 = z6;
                z = z8;
                z3 = false;
                i4 = i16;
            } else {
                f = f3;
                boolean z9 = constraintWidget25.O000oOOo == 0;
                i4 = i16;
                z = constraintWidget25.O000oOOo == 1;
                z2 = z9;
                z3 = false;
                z4 = constraintWidget25.O000oOOo == 2;
                constraintWidget = constraintWidget21;
            }
            while (true) {
                ConstraintWidget constraintWidget26 = null;
                if (z3) {
                    break;
                }
                ConstraintAnchor constraintAnchor7 = constraintWidget.O000OOo[i3];
                int i17 = z4 ? 1 : 4;
                int O00000o0 = constraintAnchor7.O00000o0();
                boolean z10 = z3;
                oOo000Oo[] ooo000ooArr3 = ooo000ooArr;
                boolean z11 = constraintWidget.O000Oo00[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.O0000o[i] == 0;
                if (!(constraintAnchor7.O00000o0 == null || constraintWidget == constraintWidget21)) {
                    O00000o0 += constraintAnchor7.O00000o0.O00000o0();
                }
                int i18 = O00000o0;
                if (!z4 || constraintWidget == constraintWidget21 || constraintWidget == constraintWidget23) {
                    i13 = i2;
                } else {
                    i13 = i2;
                    i17 = 5;
                }
                if (constraintAnchor7.O00000o0 != null) {
                    if (constraintWidget == constraintWidget23) {
                        constraintWidget20 = constraintWidget25;
                        constraintWidget19 = constraintWidget21;
                        oo00oo002.O000000o(constraintAnchor7.O00000oo, constraintAnchor7.O00000o0.O00000oo, i18, 6);
                    } else {
                        constraintWidget20 = constraintWidget25;
                        constraintWidget19 = constraintWidget21;
                        oo00oo002.O000000o(constraintAnchor7.O00000oo, constraintAnchor7.O00000o0.O00000oo, i18, 8);
                    }
                    oo00oo002.O00000o0(constraintAnchor7.O00000oo, constraintAnchor7.O00000o0.O00000oo, i18, (!z11 || z4) ? i17 : 5);
                } else {
                    constraintWidget20 = constraintWidget25;
                    constraintWidget19 = constraintWidget21;
                }
                if (z7) {
                    if (constraintWidget.O000o0O == 8 || constraintWidget.O000Oo00[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i15 = 0;
                    } else {
                        i15 = 0;
                        oo00oo002.O000000o(constraintWidget.O000OOo[i3 + 1].O00000oo, constraintWidget.O000OOo[i3].O00000oo, 0, 5);
                    }
                    oo00oo002.O000000o(constraintWidget.O000OOo[i3].O00000oo, ooo0000o2.O000OOo[i3].O00000oo, i15, 8);
                }
                ConstraintAnchor constraintAnchor8 = constraintWidget.O000OOo[i3 + 1].O00000o0;
                if (constraintAnchor8 != null) {
                    ConstraintWidget constraintWidget27 = constraintAnchor8.f2787O000000o;
                    if (constraintWidget27.O000OOo[i3].O00000o0 != null && constraintWidget27.O000OOo[i3].O00000o0.f2787O000000o == constraintWidget) {
                        constraintWidget26 = constraintWidget27;
                    }
                }
                if (constraintWidget26 != null) {
                    constraintWidget = constraintWidget26;
                    i14 = i13;
                    z5 = z10;
                    ooo000ooArr2 = ooo000ooArr3;
                    constraintWidget25 = constraintWidget20;
                    constraintWidget21 = constraintWidget19;
                } else {
                    i14 = i13;
                    ooo000ooArr2 = ooo000ooArr3;
                    constraintWidget25 = constraintWidget20;
                    constraintWidget21 = constraintWidget19;
                    z5 = true;
                }
            }
            ConstraintWidget constraintWidget28 = constraintWidget25;
            ConstraintWidget constraintWidget29 = constraintWidget21;
            oOo000Oo[] ooo000ooArr4 = ooo000ooArr;
            int i19 = i2;
            if (constraintWidget24 != null) {
                int i20 = i3 + 1;
                if (constraintWidget22.O000OOo[i20].O00000o0 != null) {
                    ConstraintAnchor constraintAnchor9 = constraintWidget24.O000OOo[i20];
                    if ((constraintWidget24.O000Oo00[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget24.O0000o[i] == 0) && !z4 && constraintAnchor9.O00000o0.f2787O000000o == ooo0000o2) {
                        oo00oo002.O00000o0(constraintAnchor9.O00000oo, constraintAnchor9.O00000o0.O00000oo, -constraintAnchor9.O00000o0(), 5);
                    } else if (z4 && constraintAnchor9.O00000o0.f2787O000000o == ooo0000o2) {
                        oo00oo002.O00000o0(constraintAnchor9.O00000oo, constraintAnchor9.O00000o0.O00000oo, -constraintAnchor9.O00000o0(), 4);
                    }
                    oo00oo002.O00000Oo(constraintAnchor9.O00000oo, constraintWidget22.O000OOo[i20].O00000o0.O00000oo, -constraintAnchor9.O00000o0(), 6);
                    if (z7) {
                        int i21 = i3 + 1;
                        oo00oo002.O000000o(ooo0000o2.O000OOo[i21].O00000oo, constraintWidget22.O000OOo[i21].O00000oo, constraintWidget22.O000OOo[i21].O00000o0(), 8);
                    }
                    ArrayList<ConstraintWidget> arrayList2 = ooo000oo4.O0000OOo;
                    if (arrayList2 != null && (size = arrayList2.size()) > 1) {
                        if (ooo000oo4.O0000o0o && !ooo000oo4.O0000oO0) {
                            f = (float) ooo000oo4.O0000Oo;
                        }
                        float f4 = 0.0f;
                        ConstraintWidget constraintWidget30 = null;
                        i11 = 0;
                        float f5 = 0.0f;
                        while (i11 < size) {
                            ConstraintWidget constraintWidget31 = arrayList2.get(i11);
                            float f6 = constraintWidget31.O000oOoO[i];
                            if (f6 < f4) {
                                if (ooo000oo4.O0000oO0) {
                                    oo00oo002.O00000o0(constraintWidget31.O000OOo[i3 + 1].O00000oo, constraintWidget31.O000OOo[i3].O00000oo, 0, 4);
                                    ooo000oo3 = ooo000oo4;
                                    arrayList = arrayList2;
                                    i12 = size;
                                    i11++;
                                    ooo000oo4 = ooo000oo3;
                                    size = i12;
                                    arrayList2 = arrayList;
                                    f4 = 0.0f;
                                } else {
                                    f6 = 1.0f;
                                }
                            }
                            if (f6 == 0.0f) {
                                oo00oo002.O00000o0(constraintWidget31.O000OOo[i3 + 1].O00000oo, constraintWidget31.O000OOo[i3].O00000oo, 0, 8);
                                ooo000oo3 = ooo000oo4;
                                arrayList = arrayList2;
                                i12 = size;
                                i11++;
                                ooo000oo4 = ooo000oo3;
                                size = i12;
                                arrayList2 = arrayList;
                                f4 = 0.0f;
                            } else {
                                if (constraintWidget30 != null) {
                                    SolverVariable solverVariable7 = constraintWidget30.O000OOo[i3].O00000oo;
                                    int i22 = i3 + 1;
                                    SolverVariable solverVariable8 = constraintWidget30.O000OOo[i22].O00000oo;
                                    SolverVariable solverVariable9 = constraintWidget31.O000OOo[i3].O00000oo;
                                    arrayList = arrayList2;
                                    SolverVariable solverVariable10 = constraintWidget31.O000OOo[i22].O00000oo;
                                    i12 = size;
                                    oO00OOOo O00000o02 = oo00oo00.O00000o0();
                                    constraintWidget18 = constraintWidget31;
                                    O00000o02.O00000Oo = 0.0f;
                                    ooo000oo3 = ooo000oo4;
                                    if (f == 0.0f || f5 == f6) {
                                        O00000o02.O00000oO.O000000o(solverVariable7, 1.0f);
                                        O00000o02.O00000oO.O000000o(solverVariable8, -1.0f);
                                        O00000o02.O00000oO.O000000o(solverVariable10, 1.0f);
                                        O00000o02.O00000oO.O000000o(solverVariable9, -1.0f);
                                    } else if (f5 == 0.0f) {
                                        O00000o02.O00000oO.O000000o(solverVariable7, 1.0f);
                                        O00000o02.O00000oO.O000000o(solverVariable8, -1.0f);
                                    } else if (f6 == 0.0f) {
                                        O00000o02.O00000oO.O000000o(solverVariable9, 1.0f);
                                        O00000o02.O00000oO.O000000o(solverVariable10, -1.0f);
                                    } else {
                                        float f7 = (f5 / f) / (f6 / f);
                                        O00000o02.O00000oO.O000000o(solverVariable7, 1.0f);
                                        O00000o02.O00000oO.O000000o(solverVariable8, -1.0f);
                                        O00000o02.O00000oO.O000000o(solverVariable10, f7);
                                        O00000o02.O00000oO.O000000o(solverVariable9, -f7);
                                    }
                                    oo00oo002.O000000o(O00000o02);
                                } else {
                                    ooo000oo3 = ooo000oo4;
                                    arrayList = arrayList2;
                                    i12 = size;
                                    constraintWidget18 = constraintWidget31;
                                }
                                f5 = f6;
                                constraintWidget30 = constraintWidget18;
                                i11++;
                                ooo000oo4 = ooo000oo3;
                                size = i12;
                                arrayList2 = arrayList;
                                f4 = 0.0f;
                            }
                        }
                    }
                    ooo000oo = ooo000oo4;
                    if (constraintWidget23 != null || (constraintWidget23 != constraintWidget24 && !z4)) {
                        constraintWidget4 = constraintWidget24;
                        constraintWidget3 = constraintWidget23;
                        constraintWidget6 = constraintWidget22;
                        i7 = i4;
                        constraintWidget7 = constraintWidget29;
                        if (z2 || constraintWidget3 == null) {
                            ConstraintWidget constraintWidget32 = constraintWidget7;
                            i5 = i7;
                            ooo000oo2 = ooo000oo;
                            int i23 = 8;
                            if (z && constraintWidget3 != null) {
                                boolean z12 = ooo000oo2.O0000Oo <= 0 && ooo000oo2.O0000Oo0 == ooo000oo2.O0000Oo;
                                constraintWidget8 = constraintWidget3;
                                ConstraintWidget constraintWidget33 = constraintWidget8;
                                while (constraintWidget8 != null) {
                                    ConstraintWidget constraintWidget34 = constraintWidget8.O000oo0[i];
                                    while (constraintWidget34 != null && constraintWidget34.O000o0O == i23) {
                                        constraintWidget34 = constraintWidget34.O000oo0[i];
                                    }
                                    if (constraintWidget8 == constraintWidget3 || constraintWidget8 == constraintWidget4 || constraintWidget34 == null) {
                                        constraintWidget9 = constraintWidget33;
                                    } else {
                                        ConstraintWidget constraintWidget35 = constraintWidget34 == constraintWidget4 ? null : constraintWidget34;
                                        ConstraintAnchor constraintAnchor10 = constraintWidget8.O000OOo[i3];
                                        SolverVariable solverVariable11 = constraintAnchor10.O00000oo;
                                        int i24 = i3 + 1;
                                        SolverVariable solverVariable12 = constraintWidget33.O000OOo[i24].O00000oo;
                                        int O00000o03 = constraintAnchor10.O00000o0();
                                        int O00000o04 = constraintWidget8.O000OOo[i24].O00000o0();
                                        if (constraintWidget35 != null) {
                                            constraintAnchor5 = constraintWidget35.O000OOo[i3];
                                            solverVariable5 = constraintAnchor5.O00000oo;
                                            solverVariable4 = constraintAnchor5.O00000o0 != null ? constraintAnchor5.O00000o0.O00000oo : null;
                                        } else {
                                            constraintAnchor5 = constraintWidget4.O000OOo[i3];
                                            solverVariable5 = constraintAnchor5 != null ? constraintAnchor5.O00000oo : null;
                                            solverVariable4 = constraintWidget8.O000OOo[i24].O00000oo;
                                        }
                                        if (constraintAnchor5 != null) {
                                            O00000o04 += constraintAnchor5.O00000o0();
                                        }
                                        int i25 = O00000o04;
                                        if (constraintWidget33 != null) {
                                            O00000o03 += constraintWidget33.O000OOo[i24].O00000o0();
                                        }
                                        int i26 = O00000o03;
                                        int i27 = z12 ? 8 : 4;
                                        if (solverVariable11 == null || solverVariable12 == null || solverVariable5 == null || solverVariable4 == null) {
                                            constraintWidget10 = constraintWidget35;
                                            constraintWidget9 = constraintWidget33;
                                        } else {
                                            SolverVariable solverVariable13 = solverVariable5;
                                            SolverVariable solverVariable14 = solverVariable4;
                                            constraintWidget10 = constraintWidget35;
                                            int i28 = i25;
                                            constraintWidget9 = constraintWidget33;
                                            oo00oo00.O000000o(solverVariable11, solverVariable12, i26, 0.5f, solverVariable13, solverVariable14, i28, i27);
                                        }
                                        constraintWidget34 = constraintWidget10;
                                    }
                                    constraintWidget33 = constraintWidget8.O000o0O != 8 ? constraintWidget8 : constraintWidget9;
                                    constraintWidget8 = constraintWidget34;
                                    i23 = 8;
                                }
                                ConstraintAnchor constraintAnchor11 = constraintWidget3.O000OOo[i3];
                                constraintAnchor3 = constraintWidget32.O000OOo[i3].O00000o0;
                                int i29 = i3 + 1;
                                ConstraintAnchor constraintAnchor12 = constraintWidget4.O000OOo[i29];
                                ConstraintAnchor constraintAnchor13 = constraintWidget6.O000OOo[i29].O00000o0;
                                if (constraintAnchor3 != null) {
                                    if (constraintWidget3 != constraintWidget4) {
                                        oo00oo002.O00000o0(constraintAnchor11.O00000oo, constraintAnchor3.O00000oo, constraintAnchor11.O00000o0(), 5);
                                    } else if (constraintAnchor13 != null) {
                                        constraintWidget2 = constraintWidget6;
                                        constraintAnchor4 = constraintAnchor13;
                                        oo00oo00.O000000o(constraintAnchor11.O00000oo, constraintAnchor3.O00000oo, constraintAnchor11.O00000o0(), 0.5f, constraintAnchor12.O00000oo, constraintAnchor13.O00000oo, constraintAnchor12.O00000o0(), 5);
                                        if (!(constraintAnchor4 == null || constraintWidget3 == constraintWidget4)) {
                                            oo00oo002.O00000o0(constraintAnchor12.O00000oo, constraintAnchor4.O00000oo, -constraintAnchor12.O00000o0(), 5);
                                        }
                                    }
                                }
                                constraintWidget2 = constraintWidget6;
                                constraintAnchor4 = constraintAnchor13;
                                oo00oo002.O00000o0(constraintAnchor12.O00000oo, constraintAnchor4.O00000oo, -constraintAnchor12.O00000o0(), 5);
                            }
                        } else {
                            oOo000Oo ooo000oo5 = ooo000oo;
                            boolean z13 = ooo000oo5.O0000Oo > 0 && ooo000oo5.O0000Oo0 == ooo000oo5.O0000Oo;
                            ConstraintWidget constraintWidget36 = constraintWidget3;
                            ConstraintWidget constraintWidget37 = constraintWidget36;
                            while (constraintWidget37 != null) {
                                ConstraintWidget constraintWidget38 = constraintWidget37.O000oo0[i];
                                while (true) {
                                    if (constraintWidget38 != null) {
                                        if (constraintWidget38.O000o0O != 8) {
                                            break;
                                        }
                                        constraintWidget38 = constraintWidget38.O000oo0[i];
                                    } else {
                                        break;
                                    }
                                }
                                if (constraintWidget38 != null || constraintWidget37 == constraintWidget4) {
                                    ConstraintAnchor constraintAnchor14 = constraintWidget37.O000OOo[i3];
                                    SolverVariable solverVariable15 = constraintAnchor14.O00000oo;
                                    SolverVariable solverVariable16 = constraintAnchor14.O00000o0 != null ? constraintAnchor14.O00000o0.O00000oo : null;
                                    if (constraintWidget36 != constraintWidget37) {
                                        solverVariable16 = constraintWidget36.O000OOo[i3 + 1].O00000oo;
                                    } else if (constraintWidget37 == constraintWidget3 && constraintWidget36 == constraintWidget37) {
                                        solverVariable16 = constraintWidget7.O000OOo[i3].O00000o0 != null ? constraintWidget7.O000OOo[i3].O00000o0.O00000oo : null;
                                    }
                                    int O00000o05 = constraintAnchor14.O00000o0();
                                    int i30 = i3 + 1;
                                    int O00000o06 = constraintWidget37.O000OOo[i30].O00000o0();
                                    if (constraintWidget38 != null) {
                                        constraintAnchor6 = constraintWidget38.O000OOo[i3];
                                        constraintWidget15 = constraintWidget7;
                                        solverVariable6 = constraintAnchor6.O00000oo;
                                    } else {
                                        constraintWidget15 = constraintWidget7;
                                        constraintAnchor6 = constraintWidget6.O000OOo[i30].O00000o0;
                                        if (constraintAnchor6 != null) {
                                            solverVariable6 = constraintAnchor6.O00000oo;
                                        } else {
                                            constraintWidget16 = constraintWidget38;
                                            solverVariable6 = null;
                                            SolverVariable solverVariable17 = constraintWidget37.O000OOo[i30].O00000oo;
                                            if (constraintAnchor6 != null) {
                                                O00000o06 += constraintAnchor6.O00000o0();
                                            }
                                            if (constraintWidget36 != null) {
                                                O00000o05 += constraintWidget36.O000OOo[i30].O00000o0();
                                            }
                                            if (solverVariable15 != null || solverVariable16 == null || solverVariable6 == null || solverVariable17 == null) {
                                                constraintWidget14 = constraintWidget37;
                                                i8 = i7;
                                                constraintWidget12 = constraintWidget16;
                                                constraintWidget11 = constraintWidget15;
                                                i9 = 8;
                                                constraintWidget13 = constraintWidget36;
                                            } else {
                                                if (constraintWidget37 == constraintWidget3) {
                                                    O00000o05 = constraintWidget3.O000OOo[i3].O00000o0();
                                                }
                                                int i31 = O00000o05;
                                                int O00000o07 = constraintWidget37 == constraintWidget4 ? constraintWidget4.O000OOo[i30].O00000o0() : O00000o06;
                                                int i32 = i31;
                                                SolverVariable solverVariable18 = solverVariable6;
                                                ConstraintWidget constraintWidget39 = constraintWidget16;
                                                constraintWidget13 = constraintWidget36;
                                                constraintWidget11 = constraintWidget15;
                                                int i33 = O00000o07;
                                                constraintWidget12 = constraintWidget39;
                                                constraintWidget14 = constraintWidget37;
                                                i8 = i7;
                                                i9 = 8;
                                                oo00oo00.O000000o(solverVariable15, solverVariable16, i32, 0.5f, solverVariable18, solverVariable17, i33, z13 ? 8 : 5);
                                            }
                                        }
                                    }
                                    constraintWidget16 = constraintWidget38;
                                    SolverVariable solverVariable172 = constraintWidget37.O000OOo[i30].O00000oo;
                                    if (constraintAnchor6 != null) {
                                    }
                                    if (constraintWidget36 != null) {
                                    }
                                    if (solverVariable15 != null) {
                                    }
                                    constraintWidget14 = constraintWidget37;
                                    i8 = i7;
                                    constraintWidget12 = constraintWidget16;
                                    constraintWidget11 = constraintWidget15;
                                    i9 = 8;
                                    constraintWidget13 = constraintWidget36;
                                } else {
                                    constraintWidget11 = constraintWidget7;
                                    constraintWidget12 = constraintWidget38;
                                    constraintWidget13 = constraintWidget36;
                                    constraintWidget14 = constraintWidget37;
                                    i8 = i7;
                                    i9 = 8;
                                }
                                constraintWidget36 = constraintWidget14.O000o0O != i9 ? constraintWidget14 : constraintWidget13;
                                constraintWidget37 = constraintWidget12;
                                i7 = i8;
                                constraintWidget7 = constraintWidget11;
                            }
                            i5 = i7;
                        }
                        constraintWidget2 = constraintWidget6;
                    } else {
                        ConstraintAnchor constraintAnchor15 = constraintWidget29.O000OOo[i3];
                        int i34 = i3 + 1;
                        ConstraintAnchor constraintAnchor16 = constraintWidget22.O000OOo[i34];
                        SolverVariable solverVariable19 = constraintAnchor15.O00000o0 != null ? constraintAnchor15.O00000o0.O00000oo : null;
                        SolverVariable solverVariable20 = constraintAnchor16.O00000o0 != null ? constraintAnchor16.O00000o0.O00000oo : null;
                        ConstraintAnchor constraintAnchor17 = constraintWidget23.O000OOo[i3];
                        ConstraintAnchor constraintAnchor18 = constraintWidget24.O000OOo[i34];
                        if (solverVariable19 == null || solverVariable20 == null) {
                            constraintWidget4 = constraintWidget24;
                            constraintWidget3 = constraintWidget23;
                            constraintWidget17 = constraintWidget22;
                            i10 = i4;
                        } else {
                            if (i == 0) {
                                f2 = constraintWidget28.O000o00o;
                            } else {
                                f2 = constraintWidget28.O000o0;
                            }
                            float f8 = f2;
                            int O00000o08 = constraintAnchor17.O00000o0();
                            int O00000o09 = constraintAnchor18.O00000o0();
                            SolverVariable solverVariable21 = constraintAnchor17.O00000oo;
                            SolverVariable solverVariable22 = constraintAnchor18.O00000oo;
                            SolverVariable solverVariable23 = solverVariable21;
                            constraintWidget4 = constraintWidget24;
                            constraintWidget3 = constraintWidget23;
                            SolverVariable solverVariable24 = solverVariable20;
                            constraintWidget17 = constraintWidget22;
                            i10 = i4;
                            oo00oo00.O000000o(solverVariable23, solverVariable19, O00000o08, f8, solverVariable24, solverVariable22, O00000o09, 7);
                        }
                        constraintWidget2 = constraintWidget17;
                        i5 = i10;
                    }
                    if (!((!z2 && !z) || constraintWidget3 == null || constraintWidget3 == constraintWidget4)) {
                        constraintAnchor = constraintWidget3.O000OOo[i3];
                        i6 = i3 + 1;
                        constraintAnchor2 = constraintWidget4.O000OOo[i6];
                        solverVariable = constraintAnchor.O00000o0 == null ? constraintAnchor.O00000o0.O00000oo : null;
                        if (constraintAnchor2.O00000o0 == null) {
                            solverVariable2 = constraintAnchor2.O00000o0.O00000oo;
                            constraintWidget5 = constraintWidget2;
                        } else {
                            constraintWidget5 = constraintWidget2;
                            solverVariable2 = null;
                        }
                        if (constraintWidget5 != constraintWidget4) {
                            ConstraintAnchor constraintAnchor19 = constraintWidget5.O000OOo[i6];
                            solverVariable2 = constraintAnchor19.O00000o0 != null ? constraintAnchor19.O00000o0.O00000oo : null;
                        }
                        solverVariable3 = solverVariable2;
                        if (constraintWidget3 == constraintWidget4) {
                            constraintAnchor = constraintWidget3.O000OOo[i3];
                            constraintAnchor2 = constraintWidget3.O000OOo[i6];
                        }
                        if (!(solverVariable == null || solverVariable3 == null)) {
                            int O00000o010 = constraintAnchor.O00000o0();
                            if (constraintWidget4 != null) {
                                constraintWidget5 = constraintWidget4;
                            }
                            oo00oo00.O000000o(constraintAnchor.O00000oo, solverVariable, O00000o010, 0.5f, solverVariable3, constraintAnchor2.O00000oo, constraintWidget5.O000OOo[i6].O00000o0(), 5);
                        }
                    }
                    i16 = i5 + 1;
                    ooo0000o2 = ooo0000o;
                    i2 = i19;
                    ooo000ooArr = ooo000ooArr4;
                }
            }
            if (z7) {
            }
            ArrayList<ConstraintWidget> arrayList22 = ooo000oo4.O0000OOo;
            f = (float) ooo000oo4.O0000Oo;
            float f42 = 0.0f;
            ConstraintWidget constraintWidget302 = null;
            i11 = 0;
            float f52 = 0.0f;
            while (i11 < size) {
            }
            ooo000oo = ooo000oo4;
            if (constraintWidget23 != null) {
            }
            constraintWidget4 = constraintWidget24;
            constraintWidget3 = constraintWidget23;
            constraintWidget6 = constraintWidget22;
            i7 = i4;
            constraintWidget7 = constraintWidget29;
            if (z2) {
            }
            ConstraintWidget constraintWidget322 = constraintWidget7;
            i5 = i7;
            ooo000oo2 = ooo000oo;
            int i232 = 8;
            if (ooo000oo2.O0000Oo <= 0) {
            }
            constraintWidget8 = constraintWidget3;
            ConstraintWidget constraintWidget332 = constraintWidget8;
            while (constraintWidget8 != null) {
            }
            ConstraintAnchor constraintAnchor112 = constraintWidget3.O000OOo[i3];
            constraintAnchor3 = constraintWidget322.O000OOo[i3].O00000o0;
            int i292 = i3 + 1;
            ConstraintAnchor constraintAnchor122 = constraintWidget4.O000OOo[i292];
            ConstraintAnchor constraintAnchor132 = constraintWidget6.O000OOo[i292].O00000o0;
            if (constraintAnchor3 != null) {
            }
            constraintWidget2 = constraintWidget6;
            constraintAnchor4 = constraintAnchor132;
            oo00oo002.O00000o0(constraintAnchor122.O00000oo, constraintAnchor4.O00000oo, -constraintAnchor122.O00000o0(), 5);
            constraintAnchor = constraintWidget3.O000OOo[i3];
            i6 = i3 + 1;
            constraintAnchor2 = constraintWidget4.O000OOo[i6];
            if (constraintAnchor.O00000o0 == null) {
            }
            if (constraintAnchor2.O00000o0 == null) {
            }
            if (constraintWidget5 != constraintWidget4) {
            }
            solverVariable3 = solverVariable2;
            if (constraintWidget3 == constraintWidget4) {
            }
            int O00000o0102 = constraintAnchor.O00000o0();
            if (constraintWidget4 != null) {
            }
            oo00oo00.O000000o(constraintAnchor.O00000oo, solverVariable, O00000o0102, 0.5f, solverVariable3, constraintAnchor2.O00000oo, constraintWidget5.O000OOo[i6].O00000o0(), 5);
            i16 = i5 + 1;
            ooo0000o2 = ooo0000o;
            i2 = i19;
            ooo000ooArr = ooo000ooArr4;
        }
    }
}
