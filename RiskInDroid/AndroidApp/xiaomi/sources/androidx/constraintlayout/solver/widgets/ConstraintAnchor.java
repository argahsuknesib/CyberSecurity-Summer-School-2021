package androidx.constraintlayout.solver.widgets;

import _m_j.oO0O000o;
import androidx.constraintlayout.solver.SolverVariable;
import com.google.android.exoplayer2.C;
import java.util.HashSet;
import java.util.Iterator;

public final class ConstraintAnchor {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ConstraintWidget f2787O000000o;
    public final Type O00000Oo;
    public int O00000o = 0;
    public ConstraintAnchor O00000o0;
    int O00000oO = -1;
    public SolverVariable O00000oo;
    private HashSet<ConstraintAnchor> O0000O0o = null;

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public final boolean O000000o() {
        HashSet<ConstraintAnchor> hashSet = this.O0000O0o;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().O00000oo().O00000oO()) {
                return true;
            }
        }
        return false;
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f2787O000000o = constraintWidget;
        this.O00000Oo = type;
    }

    public final void O00000Oo() {
        SolverVariable solverVariable = this.O00000oo;
        if (solverVariable == null) {
            this.O00000oo = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        } else {
            solverVariable.O00000Oo();
        }
    }

    public final int O00000o0() {
        ConstraintAnchor constraintAnchor;
        if (this.f2787O000000o.O000o0O == 8) {
            return 0;
        }
        if (this.O00000oO < 0 || (constraintAnchor = this.O00000o0) == null || constraintAnchor.f2787O000000o.O000o0O != 8) {
            return this.O00000o;
        }
        return this.O00000oO;
    }

    public final void O00000o() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.O00000o0;
        if (!(constraintAnchor == null || (hashSet = constraintAnchor.O0000O0o) == null)) {
            hashSet.remove(this);
        }
        this.O00000o0 = null;
        this.O00000o = 0;
        this.O00000oO = -1;
    }

    public final boolean O000000o(ConstraintAnchor constraintAnchor, int i, int i2, boolean z) {
        if (constraintAnchor == null) {
            O00000o();
            return true;
        } else if (!z && !O000000o(constraintAnchor)) {
            return false;
        } else {
            this.O00000o0 = constraintAnchor;
            ConstraintAnchor constraintAnchor2 = this.O00000o0;
            if (constraintAnchor2.O0000O0o == null) {
                constraintAnchor2.O0000O0o = new HashSet<>();
            }
            this.O00000o0.O0000O0o.add(this);
            if (i > 0) {
                this.O00000o = i;
            } else {
                this.O00000o = 0;
            }
            this.O00000oO = i2;
            return true;
        }
    }

    public final boolean O000000o(ConstraintAnchor constraintAnchor, int i) {
        return O000000o(constraintAnchor, i, -1, false);
    }

    public final boolean O00000oO() {
        return this.O00000o0 != null;
    }

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintAnchor$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2788O000000o = new int[Type.values().length];

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
            f2788O000000o[Type.CENTER.ordinal()] = 1;
            f2788O000000o[Type.LEFT.ordinal()] = 2;
            f2788O000000o[Type.RIGHT.ordinal()] = 3;
            f2788O000000o[Type.TOP.ordinal()] = 4;
            f2788O000000o[Type.BOTTOM.ordinal()] = 5;
            f2788O000000o[Type.BASELINE.ordinal()] = 6;
            f2788O000000o[Type.CENTER_X.ordinal()] = 7;
            f2788O000000o[Type.CENTER_Y.ordinal()] = 8;
            f2788O000000o[Type.NONE.ordinal()] = 9;
        }
    }

    public final void O000000o(int i) {
        if (O00000oO()) {
            this.O00000oO = i;
        }
    }

    public final String toString() {
        return this.f2787O000000o.O000o0OO + ":" + this.O00000Oo.toString();
    }

    public final ConstraintAnchor O00000oo() {
        switch (AnonymousClass1.f2788O000000o[this.O00000Oo.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
            case 9:
                return null;
            case 2:
                return this.f2787O000000o.O000O0oo;
            case 3:
                return this.f2787O000000o.O000O0o;
            case 4:
                return this.f2787O000000o.O000OO00;
            case 5:
                return this.f2787O000000o.O000O0oO;
            default:
                throw new AssertionError(this.O00000Oo.name());
        }
    }

    public final boolean O000000o(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type type = constraintAnchor.O00000Oo;
        Type type2 = this.O00000Oo;
        if (type != type2) {
            switch (AnonymousClass1.f2788O000000o[this.O00000Oo.ordinal()]) {
                case 1:
                    if (type == Type.BASELINE || type == Type.CENTER_X || type == Type.CENTER_Y) {
                        return false;
                    }
                    return true;
                case 2:
                case 3:
                    boolean z = type == Type.LEFT || type == Type.RIGHT;
                    if (constraintAnchor.f2787O000000o instanceof oO0O000o) {
                        return z || type == Type.CENTER_X;
                    }
                    return z;
                case 4:
                case 5:
                    boolean z2 = type == Type.TOP || type == Type.BOTTOM;
                    if (constraintAnchor.f2787O000000o instanceof oO0O000o) {
                        return z2 || type == Type.CENTER_Y;
                    }
                    return z2;
                case 6:
                case 7:
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                case 9:
                    return false;
                default:
                    throw new AssertionError(this.O00000Oo.name());
            }
        } else if (type2 != Type.BASELINE || (constraintAnchor.f2787O000000o.O000O0Oo && this.f2787O000000o.O000O0Oo)) {
            return true;
        } else {
            return false;
        }
    }
}
