package _m_j;

import _m_j.oO00Oo00;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

public class oO00OOOo implements oO00Oo00.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    SolverVariable f2276O000000o = null;
    public float O00000Oo = 0.0f;
    ArrayList<SolverVariable> O00000o = new ArrayList<>();
    boolean O00000o0 = false;
    public O000000o O00000oO;
    public boolean O00000oo = false;

    public interface O000000o {
        float O000000o(oO00OOOo oo00oooo, boolean z);

        float O000000o(SolverVariable solverVariable, boolean z);

        SolverVariable O000000o(int i);

        void O000000o();

        void O000000o(float f);

        void O000000o(SolverVariable solverVariable, float f);

        void O000000o(SolverVariable solverVariable, float f, boolean z);

        boolean O000000o(SolverVariable solverVariable);

        float O00000Oo(int i);

        float O00000Oo(SolverVariable solverVariable);

        void O00000Oo();

        int O00000o0();
    }

    public oO00OOOo() {
    }

    public oO00OOOo(oO00OOo0 oo00ooo0) {
        this.O00000oO = new oO00OO0O(this, oo00ooo0);
    }

    public final void O000000o() {
        this.f2276O000000o = null;
        this.O00000oO.O000000o();
        this.O00000Oo = 0.0f;
        this.O00000oo = false;
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(SolverVariable solverVariable) {
        return this.O00000oO.O000000o(solverVariable);
    }

    public final oO00OOOo O000000o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.O00000Oo = (float) i;
        }
        if (!z) {
            this.O00000oO.O000000o(solverVariable, -1.0f);
            this.O00000oO.O000000o(solverVariable2, 1.0f);
            this.O00000oO.O000000o(solverVariable3, 1.0f);
        } else {
            this.O00000oO.O000000o(solverVariable, 1.0f);
            this.O00000oO.O000000o(solverVariable2, -1.0f);
            this.O00000oO.O000000o(solverVariable3, -1.0f);
        }
        return this;
    }

    public final oO00OOOo O00000Oo(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.O00000Oo = (float) i;
        }
        if (!z) {
            this.O00000oO.O000000o(solverVariable, -1.0f);
            this.O00000oO.O000000o(solverVariable2, 1.0f);
            this.O00000oO.O000000o(solverVariable3, -1.0f);
        } else {
            this.O00000oO.O000000o(solverVariable, 1.0f);
            this.O00000oO.O000000o(solverVariable2, -1.0f);
            this.O00000oO.O000000o(solverVariable3, 1.0f);
        }
        return this;
    }

    public final oO00OOOo O000000o(oO00Oo00 oo00oo00, int i) {
        this.O00000oO.O000000o(oo00oo00.O000000o(i, "ep"), 1.0f);
        this.O00000oO.O000000o(oo00oo00.O000000o(i, "em"), -1.0f);
        return this;
    }

    public final oO00OOOo O000000o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.O00000oO.O000000o(solverVariable, -1.0f);
        this.O00000oO.O000000o(solverVariable2, 1.0f);
        this.O00000oO.O000000o(solverVariable3, f);
        this.O00000oO.O000000o(solverVariable4, -f);
        return this;
    }

    public final oO00OOOo O00000Oo(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.O00000oO.O000000o(solverVariable3, 0.5f);
        this.O00000oO.O000000o(solverVariable4, 0.5f);
        this.O00000oO.O000000o(solverVariable, -0.5f);
        this.O00000oO.O000000o(solverVariable2, -0.5f);
        this.O00000Oo = -f;
        return this;
    }

    static boolean O00000Oo(SolverVariable solverVariable) {
        return solverVariable.O0000Ooo <= 1;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.oO00OOOo.O000000o.O000000o(androidx.constraintlayout.solver.SolverVariable, boolean):float
     arg types: [androidx.constraintlayout.solver.SolverVariable, int]
     candidates:
      _m_j.oO00OOOo.O000000o.O000000o(_m_j.oO00OOOo, boolean):float
      _m_j.oO00OOOo.O000000o.O000000o(androidx.constraintlayout.solver.SolverVariable, float):void
      _m_j.oO00OOOo.O000000o.O000000o(androidx.constraintlayout.solver.SolverVariable, boolean):float */
    /* access modifiers changed from: package-private */
    public final void O00000o0(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f2276O000000o;
        if (solverVariable2 != null) {
            this.O00000oO.O000000o(solverVariable2, -1.0f);
            this.f2276O000000o = null;
        }
        float O000000o2 = this.O00000oO.O000000o(solverVariable, true) * -1.0f;
        this.f2276O000000o = solverVariable;
        if (O000000o2 != 1.0f) {
            this.O00000Oo /= O000000o2;
            this.O00000oO.O000000o(O000000o2);
        }
    }

    public void O000000o(oO00OOOo oo00oooo, boolean z) {
        this.O00000Oo += oo00oooo.O00000Oo * this.O00000oO.O000000o(oo00oooo, z);
        if (z) {
            oo00oooo.f2276O000000o.O00000Oo(this);
        }
    }

    public final void O000000o(SolverVariable solverVariable, boolean z) {
        if (solverVariable.O00000oo) {
            this.O00000Oo += solverVariable.O00000oO * this.O00000oO.O00000Oo(solverVariable);
            this.O00000oO.O000000o(solverVariable, z);
            if (z) {
                solverVariable.O00000Oo(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final SolverVariable O000000o(boolean[] zArr, SolverVariable solverVariable) {
        int O00000o02 = this.O00000oO.O00000o0();
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        for (int i = 0; i < O00000o02; i++) {
            float O00000Oo2 = this.O00000oO.O00000Oo(i);
            if (O00000Oo2 < 0.0f) {
                SolverVariable O000000o2 = this.O00000oO.O000000o(i);
                if ((zArr == null || !zArr[O000000o2.O00000Oo]) && O000000o2 != solverVariable && ((O000000o2.O0000Oo0 == SolverVariable.Type.SLACK || O000000o2.O0000Oo0 == SolverVariable.Type.ERROR) && O00000Oo2 < f)) {
                    f = O00000Oo2;
                    solverVariable2 = O000000o2;
                }
            }
        }
        return solverVariable2;
    }

    public SolverVariable O000000o(boolean[] zArr) {
        return O000000o(zArr, (SolverVariable) null);
    }

    public void O00000Oo() {
        this.O00000oO.O000000o();
        this.f2276O000000o = null;
        this.O00000Oo = 0.0f;
    }

    public final void O000000o(oO00Oo00.O000000o o000000o) {
        if (o000000o instanceof oO00OOOo) {
            oO00OOOo oo00oooo = (oO00OOOo) o000000o;
            this.f2276O000000o = null;
            this.O00000oO.O000000o();
            for (int i = 0; i < oo00oooo.O00000oO.O00000o0(); i++) {
                this.O00000oO.O000000o(oo00oooo.O00000oO.O000000o(i), oo00oooo.O00000oO.O00000Oo(i), true);
            }
        }
    }

    public void O00000o(SolverVariable solverVariable) {
        float f = 1.0f;
        if (solverVariable.O00000o != 1) {
            if (solverVariable.O00000o == 2) {
                f = 1000.0f;
            } else if (solverVariable.O00000o == 3) {
                f = 1000000.0f;
            } else if (solverVariable.O00000o == 4) {
                f = 1.0E9f;
            } else if (solverVariable.O00000o == 5) {
                f = 1.0E12f;
            }
        }
        this.O00000oO.O000000o(solverVariable, f);
    }

    public final SolverVariable O00000o0() {
        return this.f2276O000000o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ce  */
    public String toString() {
        String str;
        boolean z;
        String str2;
        String str3;
        if (this.f2276O000000o == null) {
            str = "" + "0";
        } else {
            str = "" + this.f2276O000000o;
        }
        String str4 = str + " = ";
        if (this.O00000Oo != 0.0f) {
            str4 = str4 + this.O00000Oo;
            z = true;
        } else {
            z = false;
        }
        int O00000o02 = this.O00000oO.O00000o0();
        for (int i = 0; i < O00000o02; i++) {
            SolverVariable O000000o2 = this.O00000oO.O000000o(i);
            if (O000000o2 != null) {
                float O00000Oo2 = this.O00000oO.O00000Oo(i);
                if (O00000Oo2 != 0.0f) {
                    String solverVariable = O000000o2.toString();
                    if (!z) {
                        if (O00000Oo2 < 0.0f) {
                            str2 = str2 + "- ";
                        }
                        if (O00000Oo2 == 1.0f) {
                            str3 = str2 + solverVariable;
                        } else {
                            str3 = str2 + O00000Oo2 + " " + solverVariable;
                        }
                        z = true;
                    } else if (O00000Oo2 > 0.0f) {
                        str2 = str2 + " + ";
                        if (O00000Oo2 == 1.0f) {
                        }
                        z = true;
                    } else {
                        str2 = str2 + " - ";
                    }
                    O00000Oo2 *= -1.0f;
                    if (O00000Oo2 == 1.0f) {
                    }
                    z = true;
                }
            }
        }
        if (z) {
            return str2;
        }
        return str2 + "0.0";
    }
}
