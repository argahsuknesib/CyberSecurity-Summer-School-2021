package _m_j;

import _m_j.oO00OOOo;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.Arrays;

public final class oOo00o0o implements oO00OOOo.O000000o {
    private static float O0000Oo = 0.001f;

    /* renamed from: O000000o  reason: collision with root package name */
    int[] f2333O000000o;
    int[] O00000Oo;
    float[] O00000o;
    int[] O00000o0;
    int[] O00000oO;
    int[] O00000oo;
    int O0000O0o;
    int O0000OOo;
    protected final oO00OOo0 O0000Oo0;
    private final int O0000OoO = -1;
    private int O0000Ooo = 16;
    private final oO00OOOo O0000o0;
    private int O0000o00 = 16;

    oOo00o0o(oO00OOOo oo00oooo, oO00OOo0 oo00ooo0) {
        int i = this.O0000Ooo;
        this.f2333O000000o = new int[i];
        this.O00000Oo = new int[i];
        this.O00000o0 = new int[i];
        this.O00000o = new float[i];
        this.O00000oO = new int[i];
        this.O00000oo = new int[i];
        this.O0000O0o = 0;
        this.O0000OOo = -1;
        this.O0000o0 = oo00oooo;
        this.O0000Oo0 = oo00ooo0;
        O000000o();
    }

    public final int O00000o0() {
        return this.O0000O0o;
    }

    public final SolverVariable O000000o(int i) {
        int i2 = this.O0000O0o;
        if (i2 == 0) {
            return null;
        }
        int i3 = this.O0000OOo;
        int i4 = 0;
        while (i4 < i2) {
            if (i4 != i || i3 == -1) {
                i3 = this.O00000oo[i3];
                if (i3 == -1) {
                    break;
                }
                i4++;
            } else {
                return this.O0000Oo0.O00000o[this.O00000o0[i3]];
            }
        }
        return null;
    }

    public final float O00000Oo(int i) {
        int i2 = this.O0000O0o;
        int i3 = this.O0000OOo;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i) {
                return this.O00000o[i3];
            }
            i3 = this.O00000oo[i3];
            if (i3 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public final boolean O000000o(SolverVariable solverVariable) {
        return O00000o0(solverVariable) != -1;
    }

    private int O00000o0(SolverVariable solverVariable) {
        if (this.O0000O0o == 0) {
            return -1;
        }
        int i = solverVariable.O00000Oo;
        int i2 = this.f2333O000000o[i % this.O0000o00];
        if (i2 == -1) {
            return -1;
        }
        if (this.O00000o0[i2] == i) {
            return i2;
        }
        while (true) {
            int[] iArr = this.O00000Oo;
            if (iArr[i2] == -1 || this.O00000o0[iArr[i2]] == i) {
                int[] iArr2 = this.O00000Oo;
            } else {
                i2 = iArr[i2];
            }
        }
        int[] iArr22 = this.O00000Oo;
        if (iArr22[i2] != -1 && this.O00000o0[iArr22[i2]] == i) {
            return iArr22[i2];
        }
        return -1;
    }

    public final float O00000Oo(SolverVariable solverVariable) {
        int O00000o02 = O00000o0(solverVariable);
        if (O00000o02 != -1) {
            return this.O00000o[O00000o02];
        }
        return 0.0f;
    }

    public final String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i = this.O0000O0o;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable O000000o2 = O000000o(i2);
            if (O000000o2 != null) {
                String str4 = str3 + O000000o2 + " = " + O00000Oo(i2) + " ";
                int O00000o02 = O00000o0(O000000o2);
                String str5 = str4 + "[p: ";
                if (this.O00000oO[O00000o02] != -1) {
                    str = str5 + this.O0000Oo0.O00000o[this.O00000o0[this.O00000oO[O00000o02]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.O00000oo[O00000o02] != -1) {
                    str2 = str6 + this.O0000Oo0.O00000o[this.O00000o0[this.O00000oo[O00000o02]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }

    public final void O000000o() {
        int i = this.O0000O0o;
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable O000000o2 = O000000o(i2);
            if (O000000o2 != null) {
                O000000o2.O00000Oo(this.O0000o0);
            }
        }
        for (int i3 = 0; i3 < this.O0000Ooo; i3++) {
            this.O00000o0[i3] = -1;
            this.O00000Oo[i3] = -1;
        }
        for (int i4 = 0; i4 < this.O0000o00; i4++) {
            this.f2333O000000o[i4] = -1;
        }
        this.O0000O0o = 0;
        this.O0000OOo = -1;
    }

    private void O000000o(SolverVariable solverVariable, int i) {
        int[] iArr;
        int i2 = solverVariable.O00000Oo % this.O0000o00;
        int[] iArr2 = this.f2333O000000o;
        int i3 = iArr2[i2];
        if (i3 == -1) {
            iArr2[i2] = i;
        } else {
            while (true) {
                iArr = this.O00000Oo;
                if (iArr[i3] == -1) {
                    break;
                }
                i3 = iArr[i3];
            }
            iArr[i3] = i;
        }
        this.O00000Oo[i] = -1;
    }

    private void O00000o(SolverVariable solverVariable) {
        int i = solverVariable.O00000Oo % this.O0000o00;
        int i2 = this.f2333O000000o[i];
        if (i2 != -1) {
            int i3 = solverVariable.O00000Oo;
            if (this.O00000o0[i2] == i3) {
                int[] iArr = this.f2333O000000o;
                int[] iArr2 = this.O00000Oo;
                iArr[i] = iArr2[i2];
                iArr2[i2] = -1;
                return;
            }
            while (true) {
                int[] iArr3 = this.O00000Oo;
                if (iArr3[i2] == -1 || this.O00000o0[iArr3[i2]] == i3) {
                    int[] iArr4 = this.O00000Oo;
                    int i4 = iArr4[i2];
                } else {
                    i2 = iArr3[i2];
                }
            }
            int[] iArr42 = this.O00000Oo;
            int i42 = iArr42[i2];
            if (i42 != -1 && this.O00000o0[i42] == i3) {
                iArr42[i2] = iArr42[i42];
                iArr42[i42] = -1;
            }
        }
    }

    private void O000000o(int i, SolverVariable solverVariable, float f) {
        this.O00000o0[i] = solverVariable.O00000Oo;
        this.O00000o[i] = f;
        this.O00000oO[i] = -1;
        this.O00000oo[i] = -1;
        solverVariable.O000000o(this.O0000o0);
        solverVariable.O0000Ooo++;
        this.O0000O0o++;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.oOo00o0o.O000000o(androidx.constraintlayout.solver.SolverVariable, boolean):float
     arg types: [androidx.constraintlayout.solver.SolverVariable, int]
     candidates:
      _m_j.oOo00o0o.O000000o(androidx.constraintlayout.solver.SolverVariable, int):void
      _m_j.oOo00o0o.O000000o(_m_j.oO00OOOo, boolean):float
      _m_j.oOo00o0o.O000000o(androidx.constraintlayout.solver.SolverVariable, float):void
      _m_j.oO00OOOo.O000000o.O000000o(_m_j.oO00OOOo, boolean):float
      _m_j.oO00OOOo.O000000o.O000000o(androidx.constraintlayout.solver.SolverVariable, float):void
      _m_j.oOo00o0o.O000000o(androidx.constraintlayout.solver.SolverVariable, boolean):float */
    public final void O000000o(SolverVariable solverVariable, float f) {
        float f2 = O0000Oo;
        if (f <= (-f2) || f >= f2) {
            int i = 0;
            if (this.O0000O0o == 0) {
                O000000o(0, solverVariable, f);
                O000000o(solverVariable, 0);
                this.O0000OOo = 0;
                return;
            }
            int O00000o02 = O00000o0(solverVariable);
            if (O00000o02 != -1) {
                this.O00000o[O00000o02] = f;
                return;
            }
            int i2 = this.O0000O0o + 1;
            int i3 = this.O0000Ooo;
            if (i2 >= i3) {
                int i4 = i3 * 2;
                this.O00000o0 = Arrays.copyOf(this.O00000o0, i4);
                this.O00000o = Arrays.copyOf(this.O00000o, i4);
                this.O00000oO = Arrays.copyOf(this.O00000oO, i4);
                this.O00000oo = Arrays.copyOf(this.O00000oo, i4);
                this.O00000Oo = Arrays.copyOf(this.O00000Oo, i4);
                for (int i5 = this.O0000Ooo; i5 < i4; i5++) {
                    this.O00000o0[i5] = -1;
                    this.O00000Oo[i5] = -1;
                }
                this.O0000Ooo = i4;
            }
            int i6 = this.O0000O0o;
            int i7 = this.O0000OOo;
            int i8 = 0;
            int i9 = -1;
            while (i8 < i6) {
                if (this.O00000o0[i7] != solverVariable.O00000Oo) {
                    if (this.O00000o0[i7] < solverVariable.O00000Oo) {
                        i9 = i7;
                    }
                    i7 = this.O00000oo[i7];
                    if (i7 == -1) {
                        break;
                    }
                    i8++;
                } else {
                    this.O00000o[i7] = f;
                    return;
                }
            }
            while (true) {
                if (i >= this.O0000Ooo) {
                    i = -1;
                    break;
                } else if (this.O00000o0[i] == -1) {
                    break;
                } else {
                    i++;
                }
            }
            O000000o(i, solverVariable, f);
            if (i9 != -1) {
                this.O00000oO[i] = i9;
                int[] iArr = this.O00000oo;
                iArr[i] = iArr[i9];
                iArr[i9] = i;
            } else {
                this.O00000oO[i] = -1;
                if (this.O0000O0o > 0) {
                    this.O00000oo[i] = this.O0000OOo;
                    this.O0000OOo = i;
                } else {
                    this.O00000oo[i] = -1;
                }
            }
            int[] iArr2 = this.O00000oo;
            if (iArr2[i] != -1) {
                this.O00000oO[iArr2[i]] = i;
            }
            O000000o(solverVariable, i);
            return;
        }
        O000000o(solverVariable, true);
    }

    public final float O000000o(SolverVariable solverVariable, boolean z) {
        int O00000o02 = O00000o0(solverVariable);
        if (O00000o02 == -1) {
            return 0.0f;
        }
        O00000o(solverVariable);
        float f = this.O00000o[O00000o02];
        if (this.O0000OOo == O00000o02) {
            this.O0000OOo = this.O00000oo[O00000o02];
        }
        this.O00000o0[O00000o02] = -1;
        int[] iArr = this.O00000oO;
        if (iArr[O00000o02] != -1) {
            int[] iArr2 = this.O00000oo;
            iArr2[iArr[O00000o02]] = iArr2[O00000o02];
        }
        int[] iArr3 = this.O00000oo;
        if (iArr3[O00000o02] != -1) {
            int[] iArr4 = this.O00000oO;
            iArr4[iArr3[O00000o02]] = iArr4[O00000o02];
        }
        this.O0000O0o--;
        solverVariable.O0000Ooo--;
        if (z) {
            solverVariable.O00000Oo(this.O0000o0);
        }
        return f;
    }

    public final void O000000o(SolverVariable solverVariable, float f, boolean z) {
        float f2 = O0000Oo;
        if (f <= (-f2) || f >= f2) {
            int O00000o02 = O00000o0(solverVariable);
            if (O00000o02 == -1) {
                O000000o(solverVariable, f);
                return;
            }
            float[] fArr = this.O00000o;
            fArr[O00000o02] = fArr[O00000o02] + f;
            float f3 = fArr[O00000o02];
            float f4 = O0000Oo;
            if (f3 > (-f4) && fArr[O00000o02] < f4) {
                fArr[O00000o02] = 0.0f;
                O000000o(solverVariable, z);
            }
        }
    }

    public final float O000000o(oO00OOOo oo00oooo, boolean z) {
        float O00000Oo2 = O00000Oo(oo00oooo.f2276O000000o);
        O000000o(oo00oooo.f2276O000000o, z);
        oOo00o0o ooo00o0o = (oOo00o0o) oo00oooo.O00000oO;
        int i = ooo00o0o.O0000O0o;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            if (ooo00o0o.O00000o0[i3] != -1) {
                O000000o(this.O0000Oo0.O00000o[ooo00o0o.O00000o0[i3]], ooo00o0o.O00000o[i3] * O00000Oo2, z);
                i2++;
            }
            i3++;
        }
        return O00000Oo2;
    }

    public final void O00000Oo() {
        int i = this.O0000O0o;
        int i2 = this.O0000OOo;
        int i3 = 0;
        while (i3 < i) {
            float[] fArr = this.O00000o;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.O00000oo[i2];
            if (i2 != -1) {
                i3++;
            } else {
                return;
            }
        }
    }

    public final void O000000o(float f) {
        int i = this.O0000O0o;
        int i2 = this.O0000OOo;
        int i3 = 0;
        while (i3 < i) {
            float[] fArr = this.O00000o;
            fArr[i2] = fArr[i2] / f;
            i2 = this.O00000oo[i2];
            if (i2 != -1) {
                i3++;
            } else {
                return;
            }
        }
    }
}
