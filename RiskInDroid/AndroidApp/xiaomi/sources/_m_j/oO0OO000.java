package _m_j;

import _m_j.oO00OOOo;
import android.support.v4.app.NotificationCompat;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.Arrays;
import java.util.Comparator;

public final class oO0OO000 extends oO00OOOo {
    O000000o O0000O0o;
    oO00OOo0 O0000OOo;
    private SolverVariable[] O0000Oo;
    private int O0000Oo0 = NotificationCompat.FLAG_HIGH_PRIORITY;
    private SolverVariable[] O0000OoO;
    private int O0000Ooo;

    class O000000o implements Comparable {

        /* renamed from: O000000o  reason: collision with root package name */
        SolverVariable f2285O000000o;
        oO0OO000 O00000Oo;

        public O000000o(oO0OO000 oo0oo000) {
            this.O00000Oo = oo0oo000;
        }

        public final int compareTo(Object obj) {
            return this.f2285O000000o.O00000Oo - ((SolverVariable) obj).O00000Oo;
        }

        public final String toString() {
            String str = "[ ";
            if (this.f2285O000000o != null) {
                for (int i = 0; i < 9; i++) {
                    str = str + this.f2285O000000o.O0000OOo[i] + " ";
                }
            }
            return str + "] " + this.f2285O000000o;
        }
    }

    public final void O00000Oo() {
        this.O0000Ooo = 0;
        this.O00000Oo = 0.0f;
    }

    public oO0OO000(oO00OOo0 oo00ooo0) {
        super(oo00ooo0);
        int i = this.O0000Oo0;
        this.O0000Oo = new SolverVariable[i];
        this.O0000OoO = new SolverVariable[i];
        this.O0000Ooo = 0;
        this.O0000O0o = new O000000o(this);
        this.O0000OOo = oo00ooo0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r9 < r8) goto L_0x0051;
     */
    public final SolverVariable O000000o(boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.O0000Ooo; i2++) {
            SolverVariable solverVariable = this.O0000Oo[i2];
            if (!zArr[solverVariable.O00000Oo]) {
                O000000o o000000o = this.O0000O0o;
                o000000o.f2285O000000o = solverVariable;
                int i3 = 8;
                boolean z = true;
                if (i == -1) {
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        float f = o000000o.f2285O000000o.O0000OOo[i3];
                        if (f > 0.0f) {
                            break;
                        } else if (f < 0.0f) {
                            break;
                        } else {
                            i3--;
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                } else {
                    SolverVariable solverVariable2 = this.O0000Oo[i];
                    while (true) {
                        if (i3 < 0) {
                            break;
                        }
                        float f2 = solverVariable2.O0000OOo[i3];
                        float f3 = o000000o.f2285O000000o.O0000OOo[i3];
                        if (f3 == f2) {
                            i3--;
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
                i = i2;
            }
        }
        if (i == -1) {
            return null;
        }
        return this.O0000Oo[i];
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
    public final void O00000o(SolverVariable solverVariable) {
        O000000o o000000o = this.O0000O0o;
        o000000o.f2285O000000o = solverVariable;
        Arrays.fill(o000000o.f2285O000000o.O0000OOo, 0.0f);
        solverVariable.O0000OOo[solverVariable.O00000o] = 1.0f;
        O00000oO(solverVariable);
    }

    private final void O00000oO(SolverVariable solverVariable) {
        int i;
        int i2 = this.O0000Ooo + 1;
        SolverVariable[] solverVariableArr = this.O0000Oo;
        if (i2 > solverVariableArr.length) {
            this.O0000Oo = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            SolverVariable[] solverVariableArr2 = this.O0000Oo;
            this.O0000OoO = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.O0000Oo;
        int i3 = this.O0000Ooo;
        solverVariableArr3[i3] = solverVariable;
        this.O0000Ooo = i3 + 1;
        int i4 = this.O0000Ooo;
        if (i4 > 1 && solverVariableArr3[i4 - 1].O00000Oo > solverVariable.O00000Oo) {
            int i5 = 0;
            while (true) {
                i = this.O0000Ooo;
                if (i5 >= i) {
                    break;
                }
                this.O0000OoO[i5] = this.O0000Oo[i5];
                i5++;
            }
            Arrays.sort(this.O0000OoO, 0, i, new Comparator<SolverVariable>() {
                /* class _m_j.oO0OO000.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((SolverVariable) obj).O00000Oo - ((SolverVariable) obj2).O00000Oo;
                }
            });
            for (int i6 = 0; i6 < this.O0000Ooo; i6++) {
                this.O0000Oo[i6] = this.O0000OoO[i6];
            }
        }
        solverVariable.f2786O000000o = true;
        solverVariable.O000000o(this);
    }

    private void O00000oo(SolverVariable solverVariable) {
        int i = 0;
        while (i < this.O0000Ooo) {
            if (this.O0000Oo[i] == solverVariable) {
                while (true) {
                    int i2 = this.O0000Ooo;
                    if (i < i2 - 1) {
                        SolverVariable[] solverVariableArr = this.O0000Oo;
                        int i3 = i + 1;
                        solverVariableArr[i] = solverVariableArr[i3];
                        i = i3;
                    } else {
                        this.O0000Ooo = i2 - 1;
                        solverVariable.f2786O000000o = false;
                        return;
                    }
                }
            } else {
                i++;
            }
        }
    }

    public final void O000000o(oO00OOOo oo00oooo, boolean z) {
        oO00OOOo oo00oooo2 = oo00oooo;
        SolverVariable solverVariable = oo00oooo2.f2276O000000o;
        if (solverVariable != null) {
            oO00OOOo.O000000o o000000o = oo00oooo2.O00000oO;
            int O00000o0 = o000000o.O00000o0();
            for (int i = 0; i < O00000o0; i++) {
                SolverVariable O000000o2 = o000000o.O000000o(i);
                float O00000Oo = o000000o.O00000Oo(i);
                O000000o o000000o2 = this.O0000O0o;
                o000000o2.f2285O000000o = O000000o2;
                boolean z2 = true;
                if (o000000o2.f2285O000000o.f2786O000000o) {
                    for (int i2 = 0; i2 < 9; i2++) {
                        float[] fArr = o000000o2.f2285O000000o.O0000OOo;
                        fArr[i2] = fArr[i2] + (solverVariable.O0000OOo[i2] * O00000Oo);
                        if (Math.abs(o000000o2.f2285O000000o.O0000OOo[i2]) < 1.0E-4f) {
                            o000000o2.f2285O000000o.O0000OOo[i2] = 0.0f;
                        } else {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        oO0OO000.this.O00000oo(o000000o2.f2285O000000o);
                    }
                    z2 = false;
                } else {
                    for (int i3 = 0; i3 < 9; i3++) {
                        float f = solverVariable.O0000OOo[i3];
                        if (f != 0.0f) {
                            float f2 = f * O00000Oo;
                            if (Math.abs(f2) < 1.0E-4f) {
                                f2 = 0.0f;
                            }
                            o000000o2.f2285O000000o.O0000OOo[i3] = f2;
                        } else {
                            o000000o2.f2285O000000o.O0000OOo[i3] = 0.0f;
                        }
                    }
                }
                if (z2) {
                    O00000oO(O000000o2);
                }
                this.O00000Oo += oo00oooo2.O00000Oo * O00000Oo;
            }
            O00000oo(solverVariable);
        }
    }

    public final String toString() {
        String str = "" + " goal -> (" + this.O00000Oo + ") : ";
        for (int i = 0; i < this.O0000Ooo; i++) {
            this.O0000O0o.f2285O000000o = this.O0000Oo[i];
            str = str + this.O0000O0o + " ";
        }
        return str;
    }
}
