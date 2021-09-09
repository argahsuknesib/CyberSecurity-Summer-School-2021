package _m_j;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import com.google.android.exoplayer2.C;
import java.util.HashMap;

public final class oO0O000o extends ConstraintWidget {

    /* renamed from: O000000o  reason: collision with root package name */
    protected float f2280O000000o = -1.0f;
    protected int O00000Oo = -1;
    protected int O00000o0 = -1;
    public int O000oo;
    private int O000ooO;
    private ConstraintAnchor O000ooO0 = this.O000O0oO;

    public final boolean O000000o() {
        return true;
    }

    public oO0O000o() {
        this.O000oo = 0;
        this.O000ooO = 0;
        this.O000OOoO.clear();
        this.O000OOoO.add(this.O000ooO0);
        int length = this.O000OOo.length;
        for (int i = 0; i < length; i++) {
            this.O000OOo[i] = this.O000ooO0;
        }
    }

    public final void O000000o(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.O000000o(constraintWidget, hashMap);
        oO0O000o oo0o000o = (oO0O000o) constraintWidget;
        this.f2280O000000o = oo0o000o.f2280O000000o;
        this.O00000Oo = oo0o000o.O00000Oo;
        this.O00000o0 = oo0o000o.O00000o0;
        O0000o00(oo0o000o.O000oo);
    }

    public final void O0000o00(int i) {
        if (this.O000oo != i) {
            this.O000oo = i;
            this.O000OOoO.clear();
            if (this.O000oo == 1) {
                this.O000ooO0 = this.O000O0o;
            } else {
                this.O000ooO0 = this.O000O0oO;
            }
            this.O000OOoO.add(this.O000ooO0);
            int length = this.O000OOo.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.O000OOo[i2] = this.O000ooO0;
            }
        }
    }

    /* renamed from: _m_j.oO0O000o$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2281O000000o = new int[ConstraintAnchor.Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f2281O000000o[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            f2281O000000o[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            f2281O000000o[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            f2281O000000o[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            f2281O000000o[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            f2281O000000o[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            f2281O000000o[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            f2281O000000o[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            f2281O000000o[ConstraintAnchor.Type.NONE.ordinal()] = 9;
        }
    }

    public final ConstraintAnchor O000000o(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f2281O000000o[type.ordinal()]) {
            case 1:
            case 2:
                if (this.O000oo == 1) {
                    return this.O000ooO0;
                }
                break;
            case 3:
            case 4:
                if (this.O000oo == 0) {
                    return this.O000ooO0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
            case 9:
                return null;
        }
        throw new AssertionError(type.name());
    }

    public final void O000000o(float f) {
        if (f > -1.0f) {
            this.f2280O000000o = f;
            this.O00000Oo = -1;
            this.O00000o0 = -1;
        }
    }

    public final void O0000o0(int i) {
        if (i >= 0) {
            this.f2280O000000o = -1.0f;
            this.O00000Oo = i;
            this.O00000o0 = -1;
        }
    }

    public final void O0000o0O(int i) {
        if (i >= 0) {
            this.f2280O000000o = -1.0f;
            this.O00000Oo = -1;
            this.O00000o0 = i;
        }
    }

    public final float O0000o() {
        return this.f2280O000000o;
    }

    public final int O0000oO0() {
        return this.O00000Oo;
    }

    public final int O0000oO() {
        return this.O00000o0;
    }

    public final void O000000o(oO00Oo00 oo00oo00) {
        oOo0000O ooo0000o = (oOo0000O) this.O000Oo0;
        if (ooo0000o != null) {
            ConstraintAnchor O000000o2 = ooo0000o.O000000o(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor O000000o3 = ooo0000o.O000000o(ConstraintAnchor.Type.RIGHT);
            boolean z = this.O000Oo0 != null && this.O000Oo0.O000Oo00[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (this.O000oo == 0) {
                O000000o2 = ooo0000o.O000000o(ConstraintAnchor.Type.TOP);
                O000000o3 = ooo0000o.O000000o(ConstraintAnchor.Type.BOTTOM);
                z = this.O000Oo0 != null && this.O000Oo0.O000Oo00[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            }
            if (this.O00000Oo != -1) {
                SolverVariable O000000o4 = oo00oo00.O000000o(this.O000ooO0);
                oo00oo00.O00000o0(O000000o4, oo00oo00.O000000o(O000000o2), this.O00000Oo, 8);
                if (z) {
                    oo00oo00.O000000o(oo00oo00.O000000o(O000000o3), O000000o4, 0, 5);
                }
            } else if (this.O00000o0 != -1) {
                SolverVariable O000000o5 = oo00oo00.O000000o(this.O000ooO0);
                SolverVariable O000000o6 = oo00oo00.O000000o(O000000o3);
                oo00oo00.O00000o0(O000000o5, O000000o6, -this.O00000o0, 8);
                if (z) {
                    oo00oo00.O000000o(O000000o5, oo00oo00.O000000o(O000000o2), 0, 5);
                    oo00oo00.O000000o(O000000o6, O000000o5, 0, 5);
                }
            } else if (this.f2280O000000o != -1.0f) {
                oo00oo00.O000000o(oO00Oo00.O000000o(oo00oo00, oo00oo00.O000000o(this.O000ooO0), oo00oo00.O000000o(O000000o3), this.f2280O000000o));
            }
        }
    }

    public final void O0000o0o() {
        if (this.O000Oo0 != null) {
            int O00000Oo2 = oO00Oo00.O00000Oo(this.O000ooO0);
            if (this.O000oo == 1) {
                O00000o0(O00000Oo2);
                O00000o(0);
                O00000oo(this.O000Oo0.O00000oo());
                O00000oO(0);
                return;
            }
            O00000o0(0);
            O00000o(O00000Oo2);
            O00000oO(this.O000Oo0.O00000oO());
            O00000oo(0);
        }
    }
}
