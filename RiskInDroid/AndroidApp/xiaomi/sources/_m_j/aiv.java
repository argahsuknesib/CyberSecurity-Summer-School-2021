package _m_j;

import java.lang.ref.SoftReference;

public final class aiv {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final ThreadLocal<SoftReference<aiv>> f12394O000000o = new ThreadLocal<>();
    private static final char[] O00000o = air.O00000o();
    private static final byte[] O00000oO = air.O00000oO();
    protected ajo O00000Oo;
    protected final char[] O00000o0 = new char[6];

    public aiv() {
        char[] cArr = this.O00000o0;
        cArr[0] = '\\';
        cArr[2] = '0';
        cArr[3] = '0';
    }

    public static aiv O000000o() {
        aiv aiv;
        SoftReference softReference = f12394O000000o.get();
        if (softReference == null) {
            aiv = null;
        } else {
            aiv = (aiv) softReference.get();
        }
        if (aiv != null) {
            return aiv;
        }
        aiv aiv2 = new aiv();
        f12394O000000o.set(new SoftReference(aiv2));
        return aiv2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        if (r1 >= 0) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        r1 = -(r1 + 1);
        r9[1] = 'u';
        r10 = _m_j.aiv.O00000o;
        r9[4] = r10[r1 >> 4];
        r9[5] = r10[r1 & 15];
        r1 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0050, code lost:
        r9[1] = (char) r1;
        r1 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        r9 = r6 + r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0057, code lost:
        if (r9 <= r7.length) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        r9 = r7.length - r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005b, code lost:
        if (r9 <= 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        java.lang.System.arraycopy(r13.O00000o0, 0, r7, r6, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        r7 = r0.O0000OoO();
        r1 = r1 - r9;
        java.lang.System.arraycopy(r13.O00000o0, r9, r7, r6, r1);
        r6 = r6 + r1;
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006f, code lost:
        java.lang.System.arraycopy(r13.O00000o0, 0, r7, r6, r1);
        r1 = r8;
        r6 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        r8 = r1 + 1;
        r1 = r2[r14.charAt(r1)];
        r9 = r13.O00000o0;
     */
    public final char[] O000000o(String str) {
        ajo ajo = this.O00000Oo;
        if (ajo == null) {
            ajo = new ajo(null);
            this.O00000Oo = ajo;
        }
        char[] O0000Oo = ajo.O0000Oo();
        int[] O00000o02 = air.O00000o0();
        int length = O00000o02.length;
        int length2 = str.length();
        char[] cArr = O0000Oo;
        int i = 0;
        int i2 = 0;
        loop0:
        while (true) {
            if (i >= length2) {
                break;
            }
            while (true) {
                char charAt = str.charAt(i);
                if (charAt < length && O00000o02[charAt] != 0) {
                    break;
                }
                if (i2 >= cArr.length) {
                    cArr = ajo.O0000OoO();
                    i2 = 0;
                }
                int i3 = i2 + 1;
                cArr[i2] = charAt;
                i++;
                if (i >= length2) {
                    i2 = i3;
                    break loop0;
                }
                i2 = i3;
            }
        }
        ajo.O0000O0o = i2;
        return ajo.O0000O0o();
    }
}
