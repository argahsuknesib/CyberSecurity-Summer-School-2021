package _m_j;

import _m_j.oO00OOOo;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.Arrays;

public final class oO00OO0O implements oO00OOOo.O000000o {
    private static float O0000Ooo = 0.001f;

    /* renamed from: O000000o  reason: collision with root package name */
    int f2275O000000o = 0;
    protected final oO00OOo0 O00000Oo;
    private int O00000o = 8;
    private final oO00OOOo O00000o0;
    private SolverVariable O00000oO = null;
    private int[] O00000oo;
    private int[] O0000O0o;
    private float[] O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private boolean O0000OoO;

    oO00OO0O(oO00OOOo oo00oooo, oO00OOo0 oo00ooo0) {
        int i = this.O00000o;
        this.O00000oo = new int[i];
        this.O0000O0o = new int[i];
        this.O0000OOo = new float[i];
        this.O0000Oo0 = -1;
        this.O0000Oo = -1;
        this.O0000OoO = false;
        this.O00000o0 = oo00oooo;
        this.O00000Oo = oo00ooo0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.oO00OO0O.O000000o(androidx.constraintlayout.solver.SolverVariable, boolean):float
     arg types: [androidx.constraintlayout.solver.SolverVariable, int]
     candidates:
      _m_j.oO00OO0O.O000000o(_m_j.oO00OOOo, boolean):float
      _m_j.oO00OO0O.O000000o(androidx.constraintlayout.solver.SolverVariable, float):void
      _m_j.oO00OOOo.O000000o.O000000o(_m_j.oO00OOOo, boolean):float
      _m_j.oO00OOOo.O000000o.O000000o(androidx.constraintlayout.solver.SolverVariable, float):void
      _m_j.oO00OO0O.O000000o(androidx.constraintlayout.solver.SolverVariable, boolean):float */
    public final void O000000o(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            O000000o(solverVariable, true);
            return;
        }
        int i = this.O0000Oo0;
        if (i == -1) {
            this.O0000Oo0 = 0;
            float[] fArr = this.O0000OOo;
            int i2 = this.O0000Oo0;
            fArr[i2] = f;
            this.O00000oo[i2] = solverVariable.O00000Oo;
            this.O0000O0o[this.O0000Oo0] = -1;
            solverVariable.O0000Ooo++;
            solverVariable.O000000o(this.O00000o0);
            this.f2275O000000o++;
            if (!this.O0000OoO) {
                this.O0000Oo++;
                int i3 = this.O0000Oo;
                int[] iArr = this.O00000oo;
                if (i3 >= iArr.length) {
                    this.O0000OoO = true;
                    this.O0000Oo = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i != -1 && i4 < this.f2275O000000o) {
            if (this.O00000oo[i] == solverVariable.O00000Oo) {
                this.O0000OOo[i] = f;
                return;
            }
            if (this.O00000oo[i] < solverVariable.O00000Oo) {
                i5 = i;
            }
            i = this.O0000O0o[i];
            i4++;
        }
        int i6 = this.O0000Oo;
        int i7 = i6 + 1;
        if (this.O0000OoO) {
            int[] iArr2 = this.O00000oo;
            if (iArr2[i6] != -1) {
                i6 = iArr2.length;
            }
        } else {
            i6 = i7;
        }
        int[] iArr3 = this.O00000oo;
        if (i6 >= iArr3.length && this.f2275O000000o < iArr3.length) {
            int i8 = 0;
            while (true) {
                int[] iArr4 = this.O00000oo;
                if (i8 >= iArr4.length) {
                    break;
                } else if (iArr4[i8] == -1) {
                    i6 = i8;
                    break;
                } else {
                    i8++;
                }
            }
        }
        int[] iArr5 = this.O00000oo;
        if (i6 >= iArr5.length) {
            i6 = iArr5.length;
            this.O00000o *= 2;
            this.O0000OoO = false;
            this.O0000Oo = i6 - 1;
            this.O0000OOo = Arrays.copyOf(this.O0000OOo, this.O00000o);
            this.O00000oo = Arrays.copyOf(this.O00000oo, this.O00000o);
            this.O0000O0o = Arrays.copyOf(this.O0000O0o, this.O00000o);
        }
        this.O00000oo[i6] = solverVariable.O00000Oo;
        this.O0000OOo[i6] = f;
        if (i5 != -1) {
            int[] iArr6 = this.O0000O0o;
            iArr6[i6] = iArr6[i5];
            iArr6[i5] = i6;
        } else {
            this.O0000O0o[i6] = this.O0000Oo0;
            this.O0000Oo0 = i6;
        }
        solverVariable.O0000Ooo++;
        solverVariable.O000000o(this.O00000o0);
        this.f2275O000000o++;
        if (!this.O0000OoO) {
            this.O0000Oo++;
        }
        if (this.f2275O000000o >= this.O00000oo.length) {
            this.O0000OoO = true;
        }
        int i9 = this.O0000Oo;
        int[] iArr7 = this.O00000oo;
        if (i9 >= iArr7.length) {
            this.O0000OoO = true;
            this.O0000Oo = iArr7.length - 1;
        }
    }

    public final void O000000o(SolverVariable solverVariable, float f, boolean z) {
        float f2 = O0000Ooo;
        if (f <= (-f2) || f >= f2) {
            int i = this.O0000Oo0;
            if (i == -1) {
                this.O0000Oo0 = 0;
                float[] fArr = this.O0000OOo;
                int i2 = this.O0000Oo0;
                fArr[i2] = f;
                this.O00000oo[i2] = solverVariable.O00000Oo;
                this.O0000O0o[this.O0000Oo0] = -1;
                solverVariable.O0000Ooo++;
                solverVariable.O000000o(this.O00000o0);
                this.f2275O000000o++;
                if (!this.O0000OoO) {
                    this.O0000Oo++;
                    int i3 = this.O0000Oo;
                    int[] iArr = this.O00000oo;
                    if (i3 >= iArr.length) {
                        this.O0000OoO = true;
                        this.O0000Oo = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i != -1 && i4 < this.f2275O000000o) {
                if (this.O00000oo[i] == solverVariable.O00000Oo) {
                    float f3 = this.O0000OOo[i] + f;
                    float f4 = O0000Ooo;
                    if (f3 > (-f4) && f3 < f4) {
                        f3 = 0.0f;
                    }
                    this.O0000OOo[i] = f3;
                    if (f3 == 0.0f) {
                        if (i == this.O0000Oo0) {
                            this.O0000Oo0 = this.O0000O0o[i];
                        } else {
                            int[] iArr2 = this.O0000O0o;
                            iArr2[i5] = iArr2[i];
                        }
                        if (z) {
                            solverVariable.O00000Oo(this.O00000o0);
                        }
                        if (this.O0000OoO) {
                            this.O0000Oo = i;
                        }
                        solverVariable.O0000Ooo--;
                        this.f2275O000000o--;
                        return;
                    }
                    return;
                }
                if (this.O00000oo[i] < solverVariable.O00000Oo) {
                    i5 = i;
                }
                i = this.O0000O0o[i];
                i4++;
            }
            int i6 = this.O0000Oo;
            int i7 = i6 + 1;
            if (this.O0000OoO) {
                int[] iArr3 = this.O00000oo;
                if (iArr3[i6] != -1) {
                    i6 = iArr3.length;
                }
            } else {
                i6 = i7;
            }
            int[] iArr4 = this.O00000oo;
            if (i6 >= iArr4.length && this.f2275O000000o < iArr4.length) {
                int i8 = 0;
                while (true) {
                    int[] iArr5 = this.O00000oo;
                    if (i8 >= iArr5.length) {
                        break;
                    } else if (iArr5[i8] == -1) {
                        i6 = i8;
                        break;
                    } else {
                        i8++;
                    }
                }
            }
            int[] iArr6 = this.O00000oo;
            if (i6 >= iArr6.length) {
                i6 = iArr6.length;
                this.O00000o *= 2;
                this.O0000OoO = false;
                this.O0000Oo = i6 - 1;
                this.O0000OOo = Arrays.copyOf(this.O0000OOo, this.O00000o);
                this.O00000oo = Arrays.copyOf(this.O00000oo, this.O00000o);
                this.O0000O0o = Arrays.copyOf(this.O0000O0o, this.O00000o);
            }
            this.O00000oo[i6] = solverVariable.O00000Oo;
            this.O0000OOo[i6] = f;
            if (i5 != -1) {
                int[] iArr7 = this.O0000O0o;
                iArr7[i6] = iArr7[i5];
                iArr7[i5] = i6;
            } else {
                this.O0000O0o[i6] = this.O0000Oo0;
                this.O0000Oo0 = i6;
            }
            solverVariable.O0000Ooo++;
            solverVariable.O000000o(this.O00000o0);
            this.f2275O000000o++;
            if (!this.O0000OoO) {
                this.O0000Oo++;
            }
            int i9 = this.O0000Oo;
            int[] iArr8 = this.O00000oo;
            if (i9 >= iArr8.length) {
                this.O0000OoO = true;
                this.O0000Oo = iArr8.length - 1;
            }
        }
    }

    public final float O000000o(oO00OOOo oo00oooo, boolean z) {
        float O00000Oo2 = O00000Oo(oo00oooo.f2276O000000o);
        O000000o(oo00oooo.f2276O000000o, z);
        oO00OOOo.O000000o o000000o = oo00oooo.O00000oO;
        int O00000o02 = o000000o.O00000o0();
        for (int i = 0; i < O00000o02; i++) {
            SolverVariable O000000o2 = o000000o.O000000o(i);
            O000000o(O000000o2, o000000o.O00000Oo(O000000o2) * O00000Oo2, z);
        }
        return O00000Oo2;
    }

    public final float O000000o(SolverVariable solverVariable, boolean z) {
        if (this.O00000oO == solverVariable) {
            this.O00000oO = null;
        }
        int i = this.O0000Oo0;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f2275O000000o) {
            if (this.O00000oo[i] == solverVariable.O00000Oo) {
                if (i == this.O0000Oo0) {
                    this.O0000Oo0 = this.O0000O0o[i];
                } else {
                    int[] iArr = this.O0000O0o;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    solverVariable.O00000Oo(this.O00000o0);
                }
                solverVariable.O0000Ooo--;
                this.f2275O000000o--;
                this.O00000oo[i] = -1;
                if (this.O0000OoO) {
                    this.O0000Oo = i;
                }
                return this.O0000OOo[i];
            }
            i2++;
            i3 = i;
            i = this.O0000O0o[i];
        }
        return 0.0f;
    }

    public final void O000000o() {
        int i = this.O0000Oo0;
        int i2 = 0;
        while (i != -1 && i2 < this.f2275O000000o) {
            SolverVariable solverVariable = this.O00000Oo.O00000o[this.O00000oo[i]];
            if (solverVariable != null) {
                solverVariable.O00000Oo(this.O00000o0);
            }
            i = this.O0000O0o[i];
            i2++;
        }
        this.O0000Oo0 = -1;
        this.O0000Oo = -1;
        this.O0000OoO = false;
        this.f2275O000000o = 0;
    }

    public final boolean O000000o(SolverVariable solverVariable) {
        int i = this.O0000Oo0;
        if (i == -1) {
            return false;
        }
        int i2 = 0;
        while (i != -1 && i2 < this.f2275O000000o) {
            if (this.O00000oo[i] == solverVariable.O00000Oo) {
                return true;
            }
            i = this.O0000O0o[i];
            i2++;
        }
        return false;
    }

    public final void O00000Oo() {
        int i = this.O0000Oo0;
        int i2 = 0;
        while (i != -1 && i2 < this.f2275O000000o) {
            float[] fArr = this.O0000OOo;
            fArr[i] = fArr[i] * -1.0f;
            i = this.O0000O0o[i];
            i2++;
        }
    }

    public final void O000000o(float f) {
        int i = this.O0000Oo0;
        int i2 = 0;
        while (i != -1 && i2 < this.f2275O000000o) {
            float[] fArr = this.O0000OOo;
            fArr[i] = fArr[i] / f;
            i = this.O0000O0o[i];
            i2++;
        }
    }

    public final int O00000o0() {
        return this.f2275O000000o;
    }

    public final SolverVariable O000000o(int i) {
        int i2 = this.O0000Oo0;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2275O000000o) {
            if (i3 == i) {
                return this.O00000Oo.O00000o[this.O00000oo[i2]];
            }
            i2 = this.O0000O0o[i2];
            i3++;
        }
        return null;
    }

    public final float O00000Oo(int i) {
        int i2 = this.O0000Oo0;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2275O000000o) {
            if (i3 == i) {
                return this.O0000OOo[i2];
            }
            i2 = this.O0000O0o[i2];
            i3++;
        }
        return 0.0f;
    }

    public final float O00000Oo(SolverVariable solverVariable) {
        int i = this.O0000Oo0;
        int i2 = 0;
        while (i != -1 && i2 < this.f2275O000000o) {
            if (this.O00000oo[i] == solverVariable.O00000Oo) {
                return this.O0000OOo[i];
            }
            i = this.O0000O0o[i];
            i2++;
        }
        return 0.0f;
    }

    public final String toString() {
        int i = this.O0000Oo0;
        String str = "";
        int i2 = 0;
        while (i != -1 && i2 < this.f2275O000000o) {
            str = ((str + " -> ") + this.O0000OOo[i] + " : ") + this.O00000Oo.O00000o[this.O00000oo[i]];
            i = this.O0000O0o[i];
            i2++;
        }
        return str;
    }
}
