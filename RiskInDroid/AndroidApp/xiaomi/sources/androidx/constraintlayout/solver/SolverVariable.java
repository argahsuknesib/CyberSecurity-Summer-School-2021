package androidx.constraintlayout.solver;

import _m_j.oO00OOOo;
import java.util.Arrays;
import java.util.HashSet;

public final class SolverVariable {
    private static int O0000o = 1;
    private static int O0000o0 = 1;
    private static int O0000o0O = 1;
    private static int O0000o0o = 1;
    private static int O0000oO0 = 1;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f2786O000000o;
    public int O00000Oo = -1;
    public int O00000o = 0;
    public int O00000o0 = -1;
    public float O00000oO;
    public boolean O00000oo = false;
    public float[] O0000O0o = new float[9];
    public float[] O0000OOo = new float[9];
    oO00OOOo[] O0000Oo = new oO00OOOo[16];
    public Type O0000Oo0;
    int O0000OoO = 0;
    public int O0000Ooo = 0;
    HashSet<oO00OOOo> O0000o00 = null;
    private String O0000oO;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public static void O000000o() {
        O0000o0O++;
    }

    public SolverVariable(Type type) {
        this.O0000Oo0 = type;
    }

    public final void O000000o(oO00OOOo oo00oooo) {
        int i = 0;
        while (true) {
            int i2 = this.O0000OoO;
            if (i >= i2) {
                oO00OOOo[] oo00ooooArr = this.O0000Oo;
                if (i2 >= oo00ooooArr.length) {
                    this.O0000Oo = (oO00OOOo[]) Arrays.copyOf(oo00ooooArr, oo00ooooArr.length * 2);
                }
                oO00OOOo[] oo00ooooArr2 = this.O0000Oo;
                int i3 = this.O0000OoO;
                oo00ooooArr2[i3] = oo00oooo;
                this.O0000OoO = i3 + 1;
                return;
            } else if (this.O0000Oo[i] != oo00oooo) {
                i++;
            } else {
                return;
            }
        }
    }

    public final void O00000Oo(oO00OOOo oo00oooo) {
        int i = this.O0000OoO;
        int i2 = 0;
        while (i2 < i) {
            if (this.O0000Oo[i2] == oo00oooo) {
                while (i2 < i - 1) {
                    oO00OOOo[] oo00ooooArr = this.O0000Oo;
                    int i3 = i2 + 1;
                    oo00ooooArr[i2] = oo00ooooArr[i3];
                    i2 = i3;
                }
                this.O0000OoO--;
                return;
            }
            i2++;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.oO00OOOo.O000000o(_m_j.oO00OOOo, boolean):void
     arg types: [_m_j.oO00OOOo, int]
     candidates:
      _m_j.oO00OOOo.O000000o(_m_j.oO00Oo00, int):_m_j.oO00OOOo
      _m_j.oO00OOOo.O000000o(boolean[], androidx.constraintlayout.solver.SolverVariable):androidx.constraintlayout.solver.SolverVariable
      _m_j.oO00OOOo.O000000o(androidx.constraintlayout.solver.SolverVariable, boolean):void
      _m_j.oO00OOOo.O000000o(_m_j.oO00OOOo, boolean):void */
    public final void O00000o0(oO00OOOo oo00oooo) {
        int i = this.O0000OoO;
        for (int i2 = 0; i2 < i; i2++) {
            this.O0000Oo[i2].O000000o(oo00oooo, false);
        }
        this.O0000OoO = 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.oO00OOOo.O000000o(androidx.constraintlayout.solver.SolverVariable, boolean):void
     arg types: [androidx.constraintlayout.solver.SolverVariable, int]
     candidates:
      _m_j.oO00OOOo.O000000o(_m_j.oO00Oo00, int):_m_j.oO00OOOo
      _m_j.oO00OOOo.O000000o(boolean[], androidx.constraintlayout.solver.SolverVariable):androidx.constraintlayout.solver.SolverVariable
      _m_j.oO00OOOo.O000000o(_m_j.oO00OOOo, boolean):void
      _m_j.oO00OOOo.O000000o(androidx.constraintlayout.solver.SolverVariable, boolean):void */
    public final void O000000o(float f) {
        this.O00000oO = f;
        this.O00000oo = true;
        int i = this.O0000OoO;
        for (int i2 = 0; i2 < i; i2++) {
            this.O0000Oo[i2].O000000o(this, false);
        }
        this.O0000OoO = 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(float[], float):void}
     arg types: [float[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void} */
    public final void O00000Oo() {
        this.O0000oO = null;
        this.O0000Oo0 = Type.UNKNOWN;
        this.O00000o = 0;
        this.O00000Oo = -1;
        this.O00000o0 = -1;
        this.O00000oO = 0.0f;
        this.O00000oo = false;
        int i = this.O0000OoO;
        for (int i2 = 0; i2 < i; i2++) {
            this.O0000Oo[i2] = null;
        }
        this.O0000OoO = 0;
        this.O0000Ooo = 0;
        this.f2786O000000o = false;
        Arrays.fill(this.O0000OOo, 0.0f);
    }

    public final String toString() {
        if (this.O0000oO != null) {
            return "" + this.O0000oO;
        }
        return "" + this.O00000Oo;
    }
}
