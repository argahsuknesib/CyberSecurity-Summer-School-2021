package _m_j;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public final class oO00Oo00 {
    public static boolean O0000Oo = true;
    public static oOOoOOO0 O0000Oo0 = null;
    public static long O0000OoO = 0;
    public static long O0000Ooo = 0;
    private static int O0000o00 = 1000;

    /* renamed from: O000000o  reason: collision with root package name */
    int f2278O000000o = 0;
    public O000000o O00000Oo;
    public boolean O00000o;
    public oO00OOOo[] O00000o0;
    public boolean O00000oO;
    int O00000oo;
    public int O0000O0o;
    public final oO00OOo0 O0000OOo;
    private boolean[] O0000o;
    private HashMap<String, SolverVariable> O0000o0 = null;
    private int O0000o0O = 32;
    private int O0000o0o;
    private SolverVariable[] O0000oO;
    private int O0000oO0;
    private int O0000oOO;
    private O000000o O0000oOo;

    interface O000000o {
        SolverVariable O000000o(boolean[] zArr);

        void O000000o(O000000o o000000o);

        void O00000Oo();

        void O00000o(SolverVariable solverVariable);

        SolverVariable O00000o0();
    }

    class O00000Oo extends oO00OOOo {
        public O00000Oo(oO00OOo0 oo00ooo0) {
            this.O00000oO = new oOo00o0o(this, oo00ooo0);
        }
    }

    public oO00Oo00() {
        int i = this.O0000o0O;
        this.O0000o0o = i;
        this.O00000o0 = null;
        this.O00000o = false;
        this.O00000oO = false;
        this.O0000o = new boolean[i];
        this.O00000oo = 1;
        this.O0000O0o = 0;
        this.O0000oO0 = i;
        this.O0000oO = new SolverVariable[O0000o00];
        this.O0000oOO = 0;
        this.O00000o0 = new oO00OOOo[i];
        O0000O0o();
        this.O0000OOo = new oO00OOo0();
        this.O00000Oo = new oO0OO000(this.O0000OOo);
        if (O0000Oo) {
            this.O0000oOo = new O00000Oo(this.O0000OOo);
        } else {
            this.O0000oOo = new oO00OOOo(this.O0000OOo);
        }
    }

    public static void O000000o(oOOoOOO0 ooooooo0) {
        O0000Oo0 = ooooooo0;
    }

    public static oOOoOOO0 O000000o() {
        return O0000Oo0;
    }

    private void O00000oo() {
        this.O0000o0O *= 2;
        this.O00000o0 = (oO00OOOo[]) Arrays.copyOf(this.O00000o0, this.O0000o0O);
        oO00OOo0 oo00ooo0 = this.O0000OOo;
        oo00ooo0.O00000o = (SolverVariable[]) Arrays.copyOf(oo00ooo0.O00000o, this.O0000o0O);
        int i = this.O0000o0O;
        this.O0000o = new boolean[i];
        this.O0000o0o = i;
        this.O0000oO0 = i;
        oOOoOOO0 ooooooo0 = O0000Oo0;
        if (ooooooo0 != null) {
            ooooooo0.O00000o++;
            oOOoOOO0 ooooooo02 = O0000Oo0;
            ooooooo02.O0000o0O = Math.max(ooooooo02.O0000o0O, (long) this.O0000o0O);
            oOOoOOO0 ooooooo03 = O0000Oo0;
            ooooooo03.O0000ooO = ooooooo03.O0000o0O;
        }
    }

    private void O0000O0o() {
        int i = 0;
        if (O0000Oo) {
            while (true) {
                oO00OOOo[] oo00ooooArr = this.O00000o0;
                if (i < oo00ooooArr.length) {
                    oO00OOOo oo00oooo = oo00ooooArr[i];
                    if (oo00oooo != null) {
                        this.O0000OOo.f2277O000000o.O000000o(oo00oooo);
                    }
                    this.O00000o0[i] = null;
                    i++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                oO00OOOo[] oo00ooooArr2 = this.O00000o0;
                if (i < oo00ooooArr2.length) {
                    oO00OOOo oo00oooo2 = oo00ooooArr2[i];
                    if (oo00oooo2 != null) {
                        this.O0000OOo.O00000Oo.O000000o(oo00oooo2);
                    }
                    this.O00000o0[i] = null;
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void O00000Oo() {
        for (SolverVariable solverVariable : this.O0000OOo.O00000o) {
            if (solverVariable != null) {
                solverVariable.O00000Oo();
            }
        }
        this.O0000OOo.O00000o0.O000000o(this.O0000oO, this.O0000oOO);
        this.O0000oOO = 0;
        Arrays.fill(this.O0000OOo.O00000o, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.O0000o0;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f2278O000000o = 0;
        this.O00000Oo.O00000Oo();
        this.O00000oo = 1;
        for (int i = 0; i < this.O0000O0o; i++) {
            this.O00000o0[i].O00000o0 = false;
        }
        O0000O0o();
        this.O0000O0o = 0;
        if (O0000Oo) {
            this.O0000oOo = new O00000Oo(this.O0000OOo);
        } else {
            this.O0000oOo = new oO00OOOo(this.O0000OOo);
        }
    }

    public final SolverVariable O000000o(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.O00000oo + 1 >= this.O0000o0o) {
            O00000oo();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.O00000oo;
            if (solverVariable == null) {
                constraintAnchor.O00000Oo();
                solverVariable = constraintAnchor.O00000oo;
            }
            if (solverVariable.O00000Oo == -1 || solverVariable.O00000Oo > this.f2278O000000o || this.O0000OOo.O00000o[solverVariable.O00000Oo] == null) {
                if (solverVariable.O00000Oo != -1) {
                    solverVariable.O00000Oo();
                }
                this.f2278O000000o++;
                this.O00000oo++;
                solverVariable.O00000Oo = this.f2278O000000o;
                solverVariable.O0000Oo0 = SolverVariable.Type.UNRESTRICTED;
                this.O0000OOo.O00000o[this.f2278O000000o] = solverVariable;
            }
        }
        return solverVariable;
    }

    public final oO00OOOo O00000o0() {
        oO00OOOo oo00oooo;
        if (O0000Oo) {
            oo00oooo = this.O0000OOo.f2277O000000o.O000000o();
            if (oo00oooo == null) {
                oo00oooo = new O00000Oo(this.O0000OOo);
                O0000Ooo++;
            } else {
                oo00oooo.O000000o();
            }
        } else {
            oo00oooo = this.O0000OOo.O00000Oo.O000000o();
            if (oo00oooo == null) {
                oo00oooo = new oO00OOOo(this.O0000OOo);
                O0000OoO++;
            } else {
                oo00oooo.O000000o();
            }
        }
        SolverVariable.O000000o();
        return oo00oooo;
    }

    public SolverVariable O00000o() {
        oOOoOOO0 ooooooo0 = O0000Oo0;
        if (ooooooo0 != null) {
            ooooooo0.O0000o00++;
        }
        if (this.O00000oo + 1 >= this.O0000o0o) {
            O00000oo();
        }
        SolverVariable O000000o2 = O000000o(SolverVariable.Type.SLACK);
        this.f2278O000000o++;
        this.O00000oo++;
        O000000o2.O00000Oo = this.f2278O000000o;
        this.O0000OOo.O00000o[this.f2278O000000o] = O000000o2;
        return O000000o2;
    }

    private void O000000o(oO00OOOo oo00oooo, int i, int i2) {
        oo00oooo.O00000oO.O000000o(O000000o(i2, (String) null), (float) i);
    }

    public final SolverVariable O000000o(int i, String str) {
        oOOoOOO0 ooooooo0 = O0000Oo0;
        if (ooooooo0 != null) {
            ooooooo0.O0000Ooo++;
        }
        if (this.O00000oo + 1 >= this.O0000o0o) {
            O00000oo();
        }
        SolverVariable O000000o2 = O000000o(SolverVariable.Type.ERROR);
        this.f2278O000000o++;
        this.O00000oo++;
        O000000o2.O00000Oo = this.f2278O000000o;
        O000000o2.O00000o = i;
        this.O0000OOo.O00000o[this.f2278O000000o] = O000000o2;
        this.O00000Oo.O00000o(O000000o2);
        return O000000o2;
    }

    private SolverVariable O000000o(SolverVariable.Type type) {
        SolverVariable O000000o2 = this.O0000OOo.O00000o0.O000000o();
        if (O000000o2 == null) {
            O000000o2 = new SolverVariable(type);
            O000000o2.O0000Oo0 = type;
        } else {
            O000000o2.O00000Oo();
            O000000o2.O0000Oo0 = type;
        }
        int i = this.O0000oOO;
        int i2 = O0000o00;
        if (i >= i2) {
            O0000o00 = i2 * 2;
            this.O0000oO = (SolverVariable[]) Arrays.copyOf(this.O0000oO, O0000o00);
        }
        SolverVariable[] solverVariableArr = this.O0000oO;
        int i3 = this.O0000oOO;
        this.O0000oOO = i3 + 1;
        solverVariableArr[i3] = O000000o2;
        return O000000o2;
    }

    public static int O00000Oo(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).O00000oo;
        if (solverVariable != null) {
            return (int) (solverVariable.O00000oO + 0.5f);
        }
        return 0;
    }

    public final void O000000o(O000000o o000000o) throws Exception {
        float f;
        int i;
        boolean z;
        long j;
        oOOoOOO0 ooooooo0 = O0000Oo0;
        long j2 = 1;
        if (ooooooo0 != null) {
            ooooooo0.O0000oOO++;
            oOOoOOO0 ooooooo02 = O0000Oo0;
            ooooooo02.O0000oOo = Math.max(ooooooo02.O0000oOo, (long) this.O00000oo);
            oOOoOOO0 ooooooo03 = O0000Oo0;
            ooooooo03.O0000oo0 = Math.max(ooooooo03.O0000oo0, (long) this.O0000O0o);
        }
        int i2 = 0;
        while (true) {
            f = 0.0f;
            i = 1;
            if (i2 < this.O0000O0o) {
                if (this.O00000o0[i2].f2276O000000o.O0000Oo0 != SolverVariable.Type.UNRESTRICTED && this.O00000o0[i2].O00000Oo < 0.0f) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            boolean z2 = false;
            int i3 = 0;
            while (!z2) {
                oOOoOOO0 ooooooo04 = O0000Oo0;
                if (ooooooo04 != null) {
                    ooooooo04.O0000OoO += j2;
                }
                i3 += i;
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                float f2 = Float.MAX_VALUE;
                int i7 = 0;
                while (i4 < this.O0000O0o) {
                    oO00OOOo oo00oooo = this.O00000o0[i4];
                    if (oo00oooo.f2276O000000o.O0000Oo0 != SolverVariable.Type.UNRESTRICTED && !oo00oooo.O00000oo && oo00oooo.O00000Oo < f) {
                        int i8 = 1;
                        while (i8 < this.O00000oo) {
                            SolverVariable solverVariable = this.O0000OOo.O00000o[i8];
                            float O00000Oo2 = oo00oooo.O00000oO.O00000Oo(solverVariable);
                            if (O00000Oo2 > f) {
                                int i9 = i7;
                                float f3 = f2;
                                int i10 = i6;
                                int i11 = i5;
                                for (int i12 = 0; i12 < 9; i12++) {
                                    float f4 = solverVariable.O0000O0o[i12] / O00000Oo2;
                                    if ((f4 < f3 && i12 == i9) || i12 > i9) {
                                        i10 = i8;
                                        f3 = f4;
                                        i11 = i4;
                                        i9 = i12;
                                    }
                                }
                                i5 = i11;
                                i6 = i10;
                                f2 = f3;
                                i7 = i9;
                            }
                            i8++;
                            f = 0.0f;
                        }
                    }
                    i4++;
                    f = 0.0f;
                }
                if (i5 != -1) {
                    oO00OOOo oo00oooo2 = this.O00000o0[i5];
                    oo00oooo2.f2276O000000o.O00000o0 = -1;
                    oOOoOOO0 ooooooo05 = O0000Oo0;
                    if (ooooooo05 != null) {
                        j = 1;
                        ooooooo05.O0000Oo++;
                    } else {
                        j = 1;
                    }
                    oo00oooo2.O00000o0(this.O0000OOo.O00000o[i6]);
                    oo00oooo2.f2276O000000o.O00000o0 = i5;
                    oo00oooo2.f2276O000000o.O00000o0(oo00oooo2);
                } else {
                    j = 1;
                    z2 = true;
                }
                if (i3 > this.O00000oo / 2) {
                    z2 = true;
                }
                j2 = j;
                f = 0.0f;
                i = 1;
            }
        }
        O00000Oo(o000000o);
        O00000oO();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.oO00OOOo.O000000o(androidx.constraintlayout.solver.SolverVariable, boolean):void
     arg types: [androidx.constraintlayout.solver.SolverVariable, int]
     candidates:
      _m_j.oO00OOOo.O000000o(_m_j.oO00Oo00, int):_m_j.oO00OOOo
      _m_j.oO00OOOo.O000000o(boolean[], androidx.constraintlayout.solver.SolverVariable):androidx.constraintlayout.solver.SolverVariable
      _m_j.oO00OOOo.O000000o(_m_j.oO00OOOo, boolean):void
      _m_j.oO00OOOo.O000000o(androidx.constraintlayout.solver.SolverVariable, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.oO00OOOo.O000000o(_m_j.oO00OOOo, boolean):void
     arg types: [_m_j.oO00OOOo, int]
     candidates:
      _m_j.oO00OOOo.O000000o(_m_j.oO00Oo00, int):_m_j.oO00OOOo
      _m_j.oO00OOOo.O000000o(boolean[], androidx.constraintlayout.solver.SolverVariable):androidx.constraintlayout.solver.SolverVariable
      _m_j.oO00OOOo.O000000o(androidx.constraintlayout.solver.SolverVariable, boolean):void
      _m_j.oO00OOOo.O000000o(_m_j.oO00OOOo, boolean):void */
    public final void O000000o(oO00OOOo oo00oooo) {
        boolean z;
        boolean z2;
        boolean z3;
        SolverVariable O000000o2;
        boolean O00000Oo2;
        boolean O00000Oo3;
        oO00OOOo oo00oooo2 = oo00oooo;
        if (oo00oooo2 != null) {
            oOOoOOO0 ooooooo0 = O0000Oo0;
            if (ooooooo0 != null) {
                ooooooo0.O00000oo++;
                if (oo00oooo2.O00000oo) {
                    O0000Oo0.O0000O0o++;
                }
            }
            if (this.O0000O0o + 1 >= this.O0000oO0 || this.O00000oo + 1 >= this.O0000o0o) {
                O00000oo();
            }
            if (!oo00oooo2.O00000oo) {
                if (this.O00000o0.length != 0) {
                    boolean z4 = false;
                    while (!z4) {
                        int O00000o02 = oo00oooo2.O00000oO.O00000o0();
                        for (int i = 0; i < O00000o02; i++) {
                            SolverVariable O000000o3 = oo00oooo2.O00000oO.O000000o(i);
                            if (O000000o3.O00000o0 != -1 || O000000o3.O00000oo) {
                                oo00oooo2.O00000o.add(O000000o3);
                            }
                        }
                        if (oo00oooo2.O00000o.size() > 0) {
                            Iterator<SolverVariable> it = oo00oooo2.O00000o.iterator();
                            while (it.hasNext()) {
                                SolverVariable next = it.next();
                                if (next.O00000oo) {
                                    oo00oooo2.O000000o(next, true);
                                } else {
                                    oo00oooo2.O000000o(this.O00000o0[next.O00000o0], true);
                                }
                            }
                            oo00oooo2.O00000o.clear();
                        } else {
                            z4 = true;
                        }
                    }
                }
                if (!(oo00oooo2.f2276O000000o == null && oo00oooo2.O00000Oo == 0.0f && oo00oooo2.O00000oO.O00000o0() == 0)) {
                    if (oo00oooo2.O00000Oo < 0.0f) {
                        oo00oooo2.O00000Oo *= -1.0f;
                        oo00oooo2.O00000oO.O00000Oo();
                    }
                    int O00000o03 = oo00oooo2.O00000oO.O00000o0();
                    SolverVariable solverVariable = null;
                    SolverVariable solverVariable2 = null;
                    float f = 0.0f;
                    boolean z5 = false;
                    float f2 = 0.0f;
                    boolean z6 = false;
                    for (int i2 = 0; i2 < O00000o03; i2++) {
                        float O00000Oo4 = oo00oooo2.O00000oO.O00000Oo(i2);
                        SolverVariable O000000o4 = oo00oooo2.O00000oO.O000000o(i2);
                        if (O000000o4.O0000Oo0 == SolverVariable.Type.UNRESTRICTED) {
                            if (solverVariable == null) {
                                O00000Oo3 = oO00OOOo.O00000Oo(O000000o4);
                            } else if (f > O00000Oo4) {
                                O00000Oo3 = oO00OOOo.O00000Oo(O000000o4);
                            } else if (!z5 && oO00OOOo.O00000Oo(O000000o4)) {
                                f = O00000Oo4;
                                solverVariable = O000000o4;
                                z5 = true;
                            }
                            z5 = O00000Oo3;
                            f = O00000Oo4;
                            solverVariable = O000000o4;
                        } else if (solverVariable == null && O00000Oo4 < 0.0f) {
                            if (solverVariable2 == null) {
                                O00000Oo2 = oO00OOOo.O00000Oo(O000000o4);
                            } else if (f2 > O00000Oo4) {
                                O00000Oo2 = oO00OOOo.O00000Oo(O000000o4);
                            } else if (!z6 && oO00OOOo.O00000Oo(O000000o4)) {
                                f2 = O00000Oo4;
                                solverVariable2 = O000000o4;
                                z6 = true;
                            }
                            z6 = O00000Oo2;
                            f2 = O00000Oo4;
                            solverVariable2 = O000000o4;
                        }
                    }
                    if (solverVariable == null) {
                        solverVariable = solverVariable2;
                    }
                    if (solverVariable == null) {
                        z2 = true;
                    } else {
                        oo00oooo2.O00000o0(solverVariable);
                        z2 = false;
                    }
                    if (oo00oooo2.O00000oO.O00000o0() == 0) {
                        oo00oooo2.O00000oo = true;
                    }
                    if (z2) {
                        oOOoOOO0 ooooooo02 = O0000Oo0;
                        if (ooooooo02 != null) {
                            ooooooo02.O0000o0++;
                        }
                        if (this.O00000oo + 1 >= this.O0000o0o) {
                            O00000oo();
                        }
                        SolverVariable O000000o5 = O000000o(SolverVariable.Type.SLACK);
                        this.f2278O000000o++;
                        this.O00000oo++;
                        O000000o5.O00000Oo = this.f2278O000000o;
                        this.O0000OOo.O00000o[this.f2278O000000o] = O000000o5;
                        oo00oooo2.f2276O000000o = O000000o5;
                        O00000Oo(oo00oooo);
                        this.O0000oOo.O000000o(oo00oooo2);
                        O00000Oo(this.O0000oOo);
                        if (O000000o5.O00000o0 == -1) {
                            if (oo00oooo2.f2276O000000o == O000000o5 && (O000000o2 = oo00oooo2.O000000o((boolean[]) null, O000000o5)) != null) {
                                oOOoOOO0 ooooooo03 = O0000Oo0;
                                if (ooooooo03 != null) {
                                    ooooooo03.O0000Oo++;
                                }
                                oo00oooo2.O00000o0(O000000o2);
                            }
                            if (!oo00oooo2.O00000oo) {
                                oo00oooo2.f2276O000000o.O00000o0(oo00oooo2);
                            }
                            this.O0000O0o--;
                        }
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (oo00oooo2.f2276O000000o != null && (oo00oooo2.f2276O000000o.O0000Oo0 == SolverVariable.Type.UNRESTRICTED || oo00oooo2.O00000Oo >= 0.0f)) {
                        z = z3;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                z = false;
            }
            if (!z) {
                O00000Oo(oo00oooo);
            }
        }
    }

    private final void O00000Oo(oO00OOOo oo00oooo) {
        if (O0000Oo) {
            if (this.O00000o0[this.O0000O0o] != null) {
                this.O0000OOo.f2277O000000o.O000000o(this.O00000o0[this.O0000O0o]);
            }
        } else if (this.O00000o0[this.O0000O0o] != null) {
            this.O0000OOo.O00000Oo.O000000o(this.O00000o0[this.O0000O0o]);
        }
        this.O00000o0[this.O0000O0o] = oo00oooo;
        SolverVariable solverVariable = oo00oooo.f2276O000000o;
        int i = this.O0000O0o;
        solverVariable.O00000o0 = i;
        this.O0000O0o = i + 1;
        oo00oooo.f2276O000000o.O00000o0(oo00oooo);
    }

    private final int O00000Oo(O000000o o000000o) {
        oOOoOOO0 ooooooo0 = O0000Oo0;
        if (ooooooo0 != null) {
            ooooooo0.O0000OOo++;
        }
        for (int i = 0; i < this.O00000oo; i++) {
            this.O0000o[i] = false;
        }
        boolean z = false;
        int i2 = 0;
        while (!z) {
            oOOoOOO0 ooooooo02 = O0000Oo0;
            if (ooooooo02 != null) {
                ooooooo02.O0000Oo0++;
            }
            i2++;
            if (i2 >= this.O00000oo * 2) {
                return i2;
            }
            if (o000000o.O00000o0() != null) {
                this.O0000o[o000000o.O00000o0().O00000Oo] = true;
            }
            SolverVariable O000000o2 = o000000o.O000000o(this.O0000o);
            if (O000000o2 != null) {
                if (this.O0000o[O000000o2.O00000Oo]) {
                    return i2;
                }
                this.O0000o[O000000o2.O00000Oo] = true;
            }
            if (O000000o2 != null) {
                int i3 = -1;
                float f = Float.MAX_VALUE;
                for (int i4 = 0; i4 < this.O0000O0o; i4++) {
                    oO00OOOo oo00oooo = this.O00000o0[i4];
                    if (oo00oooo.f2276O000000o.O0000Oo0 != SolverVariable.Type.UNRESTRICTED && !oo00oooo.O00000oo && oo00oooo.O000000o(O000000o2)) {
                        float O00000Oo2 = oo00oooo.O00000oO.O00000Oo(O000000o2);
                        if (O00000Oo2 < 0.0f) {
                            float f2 = (-oo00oooo.O00000Oo) / O00000Oo2;
                            if (f2 < f) {
                                i3 = i4;
                                f = f2;
                            }
                        }
                    }
                }
                if (i3 >= 0) {
                    oO00OOOo oo00oooo2 = this.O00000o0[i3];
                    oo00oooo2.f2276O000000o.O00000o0 = -1;
                    oOOoOOO0 ooooooo03 = O0000Oo0;
                    if (ooooooo03 != null) {
                        ooooooo03.O0000Oo++;
                    }
                    oo00oooo2.O00000o0(O000000o2);
                    oo00oooo2.f2276O000000o.O00000o0 = i3;
                    oo00oooo2.f2276O000000o.O00000o0(oo00oooo2);
                }
            } else {
                z = true;
            }
        }
        return i2;
    }

    public final void O00000oO() {
        for (int i = 0; i < this.O0000O0o; i++) {
            oO00OOOo oo00oooo = this.O00000o0[i];
            oo00oooo.f2276O000000o.O00000oO = oo00oooo.O00000Oo;
        }
    }

    public final void O000000o(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        oO00OOOo O00000o02 = O00000o0();
        SolverVariable O00000o2 = O00000o();
        O00000o2.O00000o = 0;
        O00000o02.O000000o(solverVariable, solverVariable2, O00000o2, i);
        if (i2 != 8) {
            O000000o(O00000o02, (int) (O00000o02.O00000oO.O00000Oo(O00000o2) * -1.0f), i2);
        }
        O000000o(O00000o02);
    }

    public final void O00000Oo(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        oO00OOOo O00000o02 = O00000o0();
        SolverVariable O00000o2 = O00000o();
        O00000o2.O00000o = 0;
        O00000o02.O00000Oo(solverVariable, solverVariable2, O00000o2, i);
        if (i2 != 8) {
            O000000o(O00000o02, (int) (O00000o02.O00000oO.O00000Oo(O00000o2) * -1.0f), i2);
        }
        O000000o(O00000o02);
    }

    public final void O000000o(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        oO00OOOo O00000o02 = O00000o0();
        if (solverVariable2 == solverVariable3) {
            O00000o02.O00000oO.O000000o(solverVariable, 1.0f);
            O00000o02.O00000oO.O000000o(solverVariable4, 1.0f);
            O00000o02.O00000oO.O000000o(solverVariable2, -2.0f);
        } else if (f == 0.5f) {
            O00000o02.O00000oO.O000000o(solverVariable, 1.0f);
            O00000o02.O00000oO.O000000o(solverVariable2, -1.0f);
            O00000o02.O00000oO.O000000o(solverVariable3, -1.0f);
            O00000o02.O00000oO.O000000o(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                O00000o02.O00000Oo = (float) ((-i) + i2);
            }
        } else if (f <= 0.0f) {
            O00000o02.O00000oO.O000000o(solverVariable, -1.0f);
            O00000o02.O00000oO.O000000o(solverVariable2, 1.0f);
            O00000o02.O00000Oo = (float) i;
        } else if (f >= 1.0f) {
            O00000o02.O00000oO.O000000o(solverVariable4, -1.0f);
            O00000o02.O00000oO.O000000o(solverVariable3, 1.0f);
            O00000o02.O00000Oo = (float) (-i2);
        } else {
            float f2 = 1.0f - f;
            O00000o02.O00000oO.O000000o(solverVariable, f2 * 1.0f);
            O00000o02.O00000oO.O000000o(solverVariable2, f2 * -1.0f);
            O00000o02.O00000oO.O000000o(solverVariable3, -1.0f * f);
            O00000o02.O00000oO.O000000o(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                O00000o02.O00000Oo = (((float) (-i)) * f2) + (((float) i2) * f);
            }
        }
        if (i3 != 8) {
            O00000o02.O000000o(this, i3);
        }
        O000000o(O00000o02);
    }

    public final void O000000o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        oO00OOOo O00000o02 = O00000o0();
        O00000o02.O000000o(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        O000000o(O00000o02);
    }

    public final oO00OOOo O00000o0(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        if (i2 == 8 && solverVariable2.O00000oo && solverVariable.O00000o0 == -1) {
            solverVariable.O000000o(solverVariable2.O00000oO + ((float) i));
            return null;
        }
        oO00OOOo O00000o02 = O00000o0();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            O00000o02.O00000Oo = (float) i;
        }
        if (!z) {
            O00000o02.O00000oO.O000000o(solverVariable, -1.0f);
            O00000o02.O00000oO.O000000o(solverVariable2, 1.0f);
        } else {
            O00000o02.O00000oO.O000000o(solverVariable, 1.0f);
            O00000o02.O00000oO.O000000o(solverVariable2, -1.0f);
        }
        if (i2 != 8) {
            O00000o02.O000000o(this, i2);
        }
        O000000o(O00000o02);
        return O00000o02;
    }

    public final void O000000o(SolverVariable solverVariable, int i) {
        if (solverVariable.O00000o0 == -1) {
            solverVariable.O000000o((float) i);
            return;
        }
        int i2 = solverVariable.O00000o0;
        if (solverVariable.O00000o0 != -1) {
            oO00OOOo oo00oooo = this.O00000o0[i2];
            if (oo00oooo.O00000oo) {
                oo00oooo.O00000Oo = (float) i;
            } else if (oo00oooo.O00000oO.O00000o0() == 0) {
                oo00oooo.O00000oo = true;
                oo00oooo.O00000Oo = (float) i;
            } else {
                oO00OOOo O00000o02 = O00000o0();
                if (i < 0) {
                    O00000o02.O00000Oo = (float) (i * -1);
                    O00000o02.O00000oO.O000000o(solverVariable, 1.0f);
                } else {
                    O00000o02.O00000Oo = (float) i;
                    O00000o02.O00000oO.O000000o(solverVariable, -1.0f);
                }
                O000000o(O00000o02);
            }
        } else {
            oO00OOOo O00000o03 = O00000o0();
            O00000o03.f2276O000000o = solverVariable;
            float f = (float) i;
            solverVariable.O00000oO = f;
            O00000o03.O00000Oo = f;
            O00000o03.O00000oo = true;
            O000000o(O00000o03);
        }
    }

    public static oO00OOOo O000000o(oO00Oo00 oo00oo00, SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        oO00OOOo O00000o02 = oo00oo00.O00000o0();
        O00000o02.O00000oO.O000000o(solverVariable, -1.0f);
        O00000o02.O00000oO.O000000o(solverVariable2, f);
        return O00000o02;
    }
}
