package _m_j;

import java.util.ArrayList;
import java.util.HashMap;

public final class bvl {

    /* renamed from: O000000o  reason: collision with root package name */
    HashMap<Long, bvm> f13312O000000o = new HashMap<>();
    long O00000Oo = 0;

    private static long O000000o(int i, int i2) {
        return (((long) i2) & 65535) | ((((long) i) & 65535) << 32);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
    public final long O000000o(bvm bvm) {
        long j;
        bvm bvm2;
        int i;
        int i2;
        if (bvm == null || !bvm.O0000o0o) {
            return 0;
        }
        HashMap<Long, bvm> hashMap = this.f13312O000000o;
        int i3 = bvm.O0000OoO;
        if (i3 != 1) {
            if (i3 == 2) {
                i2 = bvm.O0000OOo;
                i = bvm.O0000Oo0;
                j = O000000o(i2, i);
                bvm2 = hashMap.get(Long.valueOf(j));
                if (bvm2 == null) {
                }
            } else if (!(i3 == 3 || i3 == 4)) {
                j = 0;
                bvm2 = hashMap.get(Long.valueOf(j));
                if (bvm2 == null) {
                    bvm.O0000o00 = bwi.O00000o0();
                    hashMap.put(Long.valueOf(j), bvm);
                    return 0;
                } else if (bvm2.O0000Oo != bvm.O0000Oo) {
                    bvm.O0000o00 = bwi.O00000o0();
                    hashMap.put(Long.valueOf(j), bvm);
                    return 0;
                } else {
                    bvm.O0000o00 = bvm2.O0000o00;
                    hashMap.put(Long.valueOf(j), bvm);
                    return (bwi.O00000o0() - bvm2.O0000o00) / 1000;
                }
            }
        }
        i2 = bvm.O00000o0;
        i = bvm.O00000o;
        j = O000000o(i2, i);
        bvm2 = hashMap.get(Long.valueOf(j));
        if (bvm2 == null) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r13 != 4) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0080, code lost:
        if (r12 != 4) goto L_0x0090;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0062 A[SYNTHETIC] */
    public final void O000000o(ArrayList<? extends bvm> arrayList) {
        int i;
        int i2;
        bvm bvm;
        int i3;
        int i4;
        if (arrayList != null) {
            long O00000o0 = bwi.O00000o0();
            long j = this.O00000Oo;
            if (j <= 0 || O00000o0 - j >= 60000) {
                HashMap<Long, bvm> hashMap = this.f13312O000000o;
                int size = arrayList.size();
                long j2 = 0;
                for (int i5 = 0; i5 < size; i5++) {
                    bvm bvm2 = (bvm) arrayList.get(i5);
                    if (bvm2.O0000o0o) {
                        int i6 = bvm2.O0000OoO;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                i4 = bvm2.O0000OOo;
                                i3 = bvm2.O0000Oo0;
                                j2 = O000000o(i4, i3);
                                bvm = hashMap.get(Long.valueOf(j2));
                                if (bvm != null) {
                                    if (bvm.O0000Oo == bvm2.O0000Oo) {
                                        bvm2.O0000o00 = bvm.O0000o00;
                                    } else {
                                        bvm2.O0000o00 = O00000o0;
                                    }
                                }
                            } else if (i6 != 3) {
                            }
                        }
                        i4 = bvm2.O00000o0;
                        i3 = bvm2.O00000o;
                        j2 = O000000o(i4, i3);
                        bvm = hashMap.get(Long.valueOf(j2));
                        if (bvm != null) {
                        }
                    }
                }
                hashMap.clear();
                int size2 = arrayList.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    bvm bvm3 = (bvm) arrayList.get(i7);
                    if (bvm3.O0000o0o) {
                        int i8 = bvm3.O0000OoO;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                i2 = bvm3.O0000OOo;
                                i = bvm3.O0000Oo0;
                                j2 = O000000o(i2, i);
                                hashMap.put(Long.valueOf(j2), bvm3);
                            } else if (i8 != 3) {
                            }
                        }
                        i2 = bvm3.O00000o0;
                        i = bvm3.O00000o;
                        j2 = O000000o(i2, i);
                        hashMap.put(Long.valueOf(j2), bvm3);
                    }
                }
                this.O00000Oo = O00000o0;
            }
        }
    }
}
