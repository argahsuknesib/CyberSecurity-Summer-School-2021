package _m_j;

import java.util.ArrayList;
import java.util.List;

public final class cqb {

    public interface O00000Oo {
        boolean O000000o(cpz cpz);
    }

    private static cqa O000000o(O00000Oo o00000Oo) {
        return new O00000o0(o00000Oo, (byte) 0);
    }

    public static cqa O000000o(final int i) {
        return O000000o(new O00000Oo() {
            /* class _m_j.cqb.AnonymousClass1 */

            public final boolean O000000o(cpz cpz) {
                return cpz.f14222O000000o <= i;
            }
        });
    }

    public static cqa O00000Oo(final int i) {
        return O000000o(new O00000Oo() {
            /* class _m_j.cqb.AnonymousClass2 */

            public final boolean O000000o(cpz cpz) {
                return cpz.f14222O000000o >= i;
            }
        });
    }

    public static cqa O00000o0(final int i) {
        return O000000o(new O00000Oo() {
            /* class _m_j.cqb.AnonymousClass3 */

            public final boolean O000000o(cpz cpz) {
                return cpz.O00000Oo <= i;
            }
        });
    }

    public static cqa O00000o(final int i) {
        return O000000o(new O00000Oo() {
            /* class _m_j.cqb.AnonymousClass4 */

            public final boolean O000000o(cpz cpz) {
                return cpz.O00000Oo >= i;
            }
        });
    }

    public static cqa O000000o(cpk cpk) {
        return O000000o(new O00000Oo(cpk.O000000o(), 0.0f) {
            /* class _m_j.cqb.AnonymousClass5 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ float f14227O000000o;
            final /* synthetic */ float O00000Oo = 0.0f;

            {
                this.f14227O000000o = r1;
            }

            public final boolean O000000o(cpz cpz) {
                float O000000o2 = cpk.O000000o(cpz.f14222O000000o, cpz.O00000Oo).O000000o();
                float f = this.f14227O000000o;
                float f2 = this.O00000Oo;
                return O000000o2 >= f - f2 && O000000o2 <= f + f2;
            }
        });
    }

    public static cqa O00000oO(final int i) {
        return O000000o(new O00000Oo() {
            /* class _m_j.cqb.AnonymousClass8 */

            public final boolean O000000o(cpz cpz) {
                return cpz.O00000Oo * cpz.f14222O000000o <= i;
            }
        });
    }

    public static cqa O00000oo(final int i) {
        return O000000o(new O00000Oo() {
            /* class _m_j.cqb.AnonymousClass9 */

            public final boolean O000000o(cpz cpz) {
                return cpz.O00000Oo * cpz.f14222O000000o >= i;
            }
        });
    }

    public static cqa O000000o(cqa... cqaArr) {
        return new O000000o(cqaArr, (byte) 0);
    }

    public static cqa O00000Oo(cqa... cqaArr) {
        return new O00000o(cqaArr, (byte) 0);
    }

    static class O00000o0 implements cqa {

        /* renamed from: O000000o  reason: collision with root package name */
        private O00000Oo f14232O000000o;

        /* synthetic */ O00000o0(O00000Oo o00000Oo, byte b) {
            this(o00000Oo);
        }

        private O00000o0(O00000Oo o00000Oo) {
            this.f14232O000000o = o00000Oo;
        }

        public final List<cpz> O000000o(List<cpz> list) {
            ArrayList arrayList = new ArrayList();
            for (cpz next : list) {
                if (this.f14232O000000o.O000000o(next)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
    }

    static class O000000o implements cqa {

        /* renamed from: O000000o  reason: collision with root package name */
        private cqa[] f14230O000000o;

        /* synthetic */ O000000o(cqa[] cqaArr, byte b) {
            this(cqaArr);
        }

        private O000000o(cqa... cqaArr) {
            this.f14230O000000o = cqaArr;
        }

        public final List<cpz> O000000o(List<cpz> list) {
            for (cqa O000000o2 : this.f14230O000000o) {
                list = O000000o2.O000000o(list);
            }
            return list;
        }
    }

    static class O00000o implements cqa {

        /* renamed from: O000000o  reason: collision with root package name */
        private cqa[] f14231O000000o;

        /* synthetic */ O00000o(cqa[] cqaArr, byte b) {
            this(cqaArr);
        }

        private O00000o(cqa... cqaArr) {
            this.f14231O000000o = cqaArr;
        }

        public final List<cpz> O000000o(List<cpz> list) {
            List<cpz> list2 = null;
            for (cqa O000000o2 : this.f14231O000000o) {
                list2 = O000000o2.O000000o(list);
                if (!list2.isEmpty()) {
                    break;
                }
            }
            return list2 == null ? new ArrayList() : list2;
        }
    }
}
