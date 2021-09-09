package _m_j;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;

public final class dfm extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final O00000Oo f14579O000000o = new O00000o0() {
        /* class _m_j.dfm.AnonymousClass1 */

        public final double O000000o(Double d, Double d2) {
            return d.doubleValue() + d2.doubleValue();
        }
    };
    private static final O00000Oo O00000Oo = new O00000o0() {
        /* class _m_j.dfm.AnonymousClass12 */

        public final double O000000o(Double d, Double d2) {
            return d.doubleValue() - d2.doubleValue();
        }
    };
    private static final O00000Oo O00000o = new O00000o0() {
        /* class _m_j.dfm.AnonymousClass21 */

        public final double O000000o(Double d, Double d2) {
            return d.doubleValue() / d2.doubleValue();
        }
    };
    private static final O00000Oo O00000o0 = new O00000o0() {
        /* class _m_j.dfm.AnonymousClass20 */

        public final double O000000o(Double d, Double d2) {
            return d.doubleValue() * d2.doubleValue();
        }
    };
    private static final O00000Oo O00000oO = new O00000o0() {
        /* class _m_j.dfm.AnonymousClass22 */

        public final double O000000o(Double d, Double d2) {
            return Math.pow(d.doubleValue(), d2.doubleValue());
        }
    };
    private static final O00000Oo O00000oo = new O00000o0() {
        /* class _m_j.dfm.AnonymousClass23 */

        public final double O000000o(Double d, Double d2) {
            return ((d.doubleValue() % d2.doubleValue()) + d2.doubleValue()) % d2.doubleValue();
        }
    };
    private static final O00000Oo O0000O0o = new O00000o() {
        /* class _m_j.dfm.AnonymousClass24 */

        public final double O000000o(Double d) {
            return Math.sqrt(d.doubleValue());
        }
    };
    private static final O00000Oo O0000OOo = new O00000o() {
        /* class _m_j.dfm.AnonymousClass25 */

        public final double O000000o(Double d) {
            return Math.log(d.doubleValue());
        }
    };
    private static final O00000Oo O0000Oo = new O00000o() {
        /* class _m_j.dfm.AnonymousClass2 */

        public final double O000000o(Double d) {
            return Math.cos(d.doubleValue());
        }
    };
    private static final O00000Oo O0000Oo0 = new O00000o() {
        /* class _m_j.dfm.AnonymousClass26 */

        public final double O000000o(Double d) {
            return Math.sin(d.doubleValue());
        }
    };
    private static final O00000Oo O0000OoO = new O00000o() {
        /* class _m_j.dfm.AnonymousClass3 */

        public final double O000000o(Double d) {
            return Math.tan(d.doubleValue());
        }
    };
    private static final O00000Oo O0000Ooo = new O00000o() {
        /* class _m_j.dfm.AnonymousClass4 */

        public final double O000000o(Double d) {
            return Math.acos(d.doubleValue());
        }
    };
    private static final O00000Oo O0000o = new O00000Oo() {
        /* class _m_j.dfm.AnonymousClass9 */

        public final double O000000o(dfk[] dfkArr) {
            boolean O000000o2 = dfm.O000000o(dfkArr[0].value());
            for (int i = 1; i < dfkArr.length && O000000o2; i++) {
                O000000o2 = O000000o2 && dfm.O000000o(dfkArr[i].value());
            }
            return O000000o2 ? 1.0d : 0.0d;
        }
    };
    private static final O00000Oo O0000o0 = new O00000o() {
        /* class _m_j.dfm.AnonymousClass6 */

        public final double O000000o(Double d) {
            return Math.atan(d.doubleValue());
        }
    };
    private static final O00000Oo O0000o00 = new O00000o() {
        /* class _m_j.dfm.AnonymousClass5 */

        public final double O000000o(Double d) {
            return Math.asin(d.doubleValue());
        }
    };
    private static final O00000Oo O0000o0O = new O00000o() {
        /* class _m_j.dfm.AnonymousClass7 */

        public final double O000000o(Double d) {
            return Math.exp(d.doubleValue());
        }
    };
    private static final O00000Oo O0000o0o = new O00000o() {
        /* class _m_j.dfm.AnonymousClass8 */

        public final double O000000o(Double d) {
            return (double) Math.round(d.doubleValue());
        }
    };
    private static final O00000Oo O0000oO = new O00000Oo() {
        /* class _m_j.dfm.AnonymousClass11 */

        public final double O000000o(dfk[] dfkArr) {
            return dfm.O000000o(dfkArr[0].value()) ? 0.0d : 1.0d;
        }
    };
    private static final O00000Oo O0000oO0 = new O00000Oo() {
        /* class _m_j.dfm.AnonymousClass10 */

        public final double O000000o(dfk[] dfkArr) {
            boolean O000000o2 = dfm.O000000o(dfkArr[0].value());
            for (int i = 1; i < dfkArr.length && !O000000o2; i++) {
                O000000o2 = O000000o2 || dfm.O000000o(dfkArr[i].value());
            }
            return O000000o2 ? 1.0d : 0.0d;
        }
    };
    private static final O00000Oo O0000oOO = new O00000Oo() {
        /* class _m_j.dfm.AnonymousClass13 */

        public final double O000000o(dfk[] dfkArr) {
            Object value = dfkArr[0].value();
            if (value != null) {
                return (!(value instanceof Double) || !((Double) value).isNaN()) ? 1.0d : 0.0d;
            }
            return 0.0d;
        }
    };
    private static final O00000Oo O0000oOo = new O000000o() {
        /* class _m_j.dfm.AnonymousClass14 */

        public final boolean O000000o(Double d, Double d2) {
            return d.doubleValue() < d2.doubleValue();
        }
    };
    private static final O00000Oo O0000oo = new O000000o() {
        /* class _m_j.dfm.AnonymousClass16 */

        public final boolean O000000o(Double d, Double d2) {
            return d.doubleValue() > d2.doubleValue();
        }
    };
    private static final O00000Oo O0000oo0 = new O000000o() {
        /* class _m_j.dfm.AnonymousClass15 */

        public final boolean O000000o(Double d, Double d2) {
            return d.equals(d2);
        }
    };
    private static final O00000Oo O0000ooO = new O000000o() {
        /* class _m_j.dfm.AnonymousClass17 */

        public final boolean O000000o(Double d, Double d2) {
            return d.doubleValue() <= d2.doubleValue();
        }
    };
    private static final O00000Oo O0000ooo = new O000000o() {
        /* class _m_j.dfm.AnonymousClass18 */

        public final boolean O000000o(Double d, Double d2) {
            return d.doubleValue() >= d2.doubleValue();
        }
    };
    private static final O00000Oo O00oOooO = new O000000o() {
        /* class _m_j.dfm.AnonymousClass19 */

        public final boolean O000000o(Double d, Double d2) {
            return !d.equals(d2);
        }
    };
    private final dfk[] O000O00o = new dfk[this.O00oOooo.length];
    private final O00000Oo O000O0OO;
    private final int[] O00oOooo;

    interface O00000Oo {
        double O000000o(dfk[] dfkArr);
    }

    public static boolean O000000o(Object obj) {
        return obj != null && !obj.equals(Double.valueOf(0.0d));
    }

    static abstract class O00000o0 implements O00000Oo {
        public abstract double O000000o(Double d, Double d2);

        private O00000o0() {
        }

        /* synthetic */ O00000o0(byte b) {
            this();
        }

        public final double O000000o(dfk[] dfkArr) {
            double doubleValue = dfkArr[0].doubleValue().doubleValue();
            for (int i = 1; i < dfkArr.length; i++) {
                doubleValue = O000000o(Double.valueOf(doubleValue), dfkArr[i].doubleValue());
            }
            return doubleValue;
        }
    }

    static abstract class O00000o implements O00000Oo {
        public abstract double O000000o(Double d);

        private O00000o() {
        }

        /* synthetic */ O00000o(byte b) {
            this();
        }

        public final double O000000o(dfk[] dfkArr) {
            return O000000o((Double) dfkArr[0].value());
        }
    }

    static abstract class O000000o implements O00000Oo {
        public abstract boolean O000000o(Double d, Double d2);

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final double O000000o(dfk[] dfkArr) {
            return O000000o((Double) dfkArr[0].value(), (Double) dfkArr[1].value()) ? 1.0d : 0.0d;
        }
    }

    public dfm(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        this.O00oOooo = dex.O000000o(readableMap.getArray("input"));
        String string = readableMap.getString("op");
        if ("add".equals(string)) {
            this.O000O0OO = f14579O000000o;
        } else if ("sub".equals(string)) {
            this.O000O0OO = O00000Oo;
        } else if ("multiply".equals(string)) {
            this.O000O0OO = O00000o0;
        } else if ("divide".equals(string)) {
            this.O000O0OO = O00000o;
        } else if ("pow".equals(string)) {
            this.O000O0OO = O00000oO;
        } else if ("modulo".equals(string)) {
            this.O000O0OO = O00000oo;
        } else if ("sqrt".equals(string)) {
            this.O000O0OO = O0000O0o;
        } else if ("log".equals(string)) {
            this.O000O0OO = O0000OOo;
        } else if ("sin".equals(string)) {
            this.O000O0OO = O0000Oo0;
        } else if ("cos".equals(string)) {
            this.O000O0OO = O0000Oo;
        } else if ("tan".equals(string)) {
            this.O000O0OO = O0000OoO;
        } else if ("acos".equals(string)) {
            this.O000O0OO = O0000Ooo;
        } else if ("asin".equals(string)) {
            this.O000O0OO = O0000o00;
        } else if ("atan".equals(string)) {
            this.O000O0OO = O0000o0;
        } else if ("exp".equals(string)) {
            this.O000O0OO = O0000o0O;
        } else if ("round".equals(string)) {
            this.O000O0OO = O0000o0o;
        } else if ("and".equals(string)) {
            this.O000O0OO = O0000o;
        } else if ("or".equals(string)) {
            this.O000O0OO = O0000oO0;
        } else if ("not".equals(string)) {
            this.O000O0OO = O0000oO;
        } else if ("defined".equals(string)) {
            this.O000O0OO = O0000oOO;
        } else if ("lessThan".equals(string)) {
            this.O000O0OO = O0000oOo;
        } else if ("eq".equals(string)) {
            this.O000O0OO = O0000oo0;
        } else if ("greaterThan".equals(string)) {
            this.O000O0OO = O0000oo;
        } else if ("lessOrEq".equals(string)) {
            this.O000O0OO = O0000ooO;
        } else if ("greaterOrEq".equals(string)) {
            this.O000O0OO = O0000ooo;
        } else if ("neq".equals(string)) {
            this.O000O0OO = O00oOooO;
        } else {
            throw new JSApplicationIllegalArgumentException("Unrecognized operator ".concat(String.valueOf(string)));
        }
    }

    /* access modifiers changed from: protected */
    public final Object evaluate() {
        for (int i = 0; i < this.O00oOooo.length; i++) {
            this.O000O00o[i] = this.mNodesManager.O000000o(this.O00oOooo[i], dfk.class);
        }
        return Double.valueOf(this.O000O0OO.O000000o(this.O000O00o));
    }
}
