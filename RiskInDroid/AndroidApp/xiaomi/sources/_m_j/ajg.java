package _m_j;

import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;

public final class ajg {

    /* renamed from: O000000o  reason: collision with root package name */
    static final ajg f12401O000000o = new ajg();
    protected ajg O00000Oo;
    protected final boolean O00000o;
    protected final boolean O00000o0;
    protected String[] O00000oO;
    protected O000000o[] O00000oo;
    protected int O0000O0o;
    protected int O0000OOo;
    protected boolean O0000Oo;
    protected int O0000Oo0;

    public static ajg O000000o() {
        ajg ajg = f12401O000000o;
        return new ajg(null, true, true, ajg.O00000oO, ajg.O00000oo, ajg.O0000O0o);
    }

    private ajg() {
        this.O00000o = true;
        this.O00000o0 = true;
        this.O0000Oo = true;
        O00000o0();
    }

    private void O00000o0() {
        this.O00000oO = new String[64];
        this.O00000oo = new O000000o[32];
        this.O0000Oo0 = 63;
        this.O0000O0o = 0;
        this.O0000OOo = 48;
    }

    private ajg(ajg ajg, boolean z, boolean z2, String[] strArr, O000000o[] o000000oArr, int i) {
        this.O00000Oo = ajg;
        this.O00000o = z;
        this.O00000o0 = z2;
        this.O00000oO = strArr;
        this.O00000oo = o000000oArr;
        this.O0000O0o = i;
        int length = strArr.length;
        this.O0000OOo = length - (length >> 2);
        this.O0000Oo0 = length - 1;
        this.O0000Oo = false;
    }

    public final synchronized ajg O000000o(boolean z, boolean z2) {
        return new ajg(this, z, z2, this.O00000oO, this.O00000oo, this.O0000O0o);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a  */
    public final String O000000o(char[] cArr, int i, int i2, int i3) {
        String O000000o2;
        if (i2 <= 0) {
            return "";
        }
        if (!this.O00000o) {
            return new String(cArr, i, i2);
        }
        int i4 = i3 & this.O0000Oo0;
        String str = this.O00000oO[i4];
        if (str != null) {
            if (str.length() == i2) {
                int i5 = 0;
                while (str.charAt(i5) == cArr[i + i5] && (i5 = i5 + 1) < i2) {
                    while (str.charAt(i5) == cArr[i + i5]) {
                        while (str.charAt(i5) == cArr[i + i5]) {
                        }
                    }
                }
                if (i5 == i2) {
                    return str;
                }
            }
            O000000o o000000o = this.O00000oo[i4 >> 1];
            if (!(o000000o == null || (O000000o2 = o000000o.O000000o(cArr, i, i2)) == null)) {
                return O000000o2;
            }
        }
        if (!this.O0000Oo) {
            String[] strArr = this.O00000oO;
            int length = strArr.length;
            this.O00000oO = new String[length];
            System.arraycopy(strArr, 0, this.O00000oO, 0, length);
            O000000o[] o000000oArr = this.O00000oo;
            int length2 = o000000oArr.length;
            this.O00000oo = new O000000o[length2];
            System.arraycopy(o000000oArr, 0, this.O00000oo, 0, length2);
            this.O0000Oo = true;
        } else if (this.O0000O0o >= this.O0000OOo) {
            O00000o();
            i4 = O000000o(cArr, i2) & this.O0000Oo0;
        }
        this.O0000O0o++;
        String str2 = new String(cArr, i, i2);
        if (this.O00000o0) {
            str2 = InternCache.f3599O000000o.O000000o(str2);
        }
        String[] strArr2 = this.O00000oO;
        if (strArr2[i4] == null) {
            strArr2[i4] = str2;
        } else {
            int i6 = i4 >> 1;
            O000000o[] o000000oArr2 = this.O00000oo;
            o000000oArr2[i6] = new O000000o(str2, o000000oArr2[i6]);
        }
        return str2;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    private static int O000000o(char[] cArr, int i) {
        int i2 = cArr[0];
        for (int i3 = 1; i3 < i; i3++) {
            i2 = (i2 * 31) + cArr[i3];
        }
        return i2;
    }

    private static int O000000o(String str) {
        int charAt = str.charAt(0);
        int length = str.length();
        for (int i = 1; i < length; i++) {
            charAt = (charAt * 31) + str.charAt(i);
        }
        return charAt;
    }

    private void O00000o() {
        String[] strArr = this.O00000oO;
        int i = r1 + r1;
        if (i > 65536) {
            this.O0000O0o = 0;
            Arrays.fill(strArr, (Object) null);
            Arrays.fill(this.O00000oo, (Object) null);
            this.O0000Oo = true;
            return;
        }
        O000000o[] o000000oArr = this.O00000oo;
        this.O00000oO = new String[i];
        this.O00000oo = new O000000o[(i >> 1)];
        this.O0000Oo0 = i - 1;
        int i2 = this.O0000OOo;
        this.O0000OOo = i2 + i2;
        int i3 = 0;
        for (String str : strArr) {
            if (str != null) {
                i3++;
                int O000000o2 = O000000o(str) & this.O0000Oo0;
                String[] strArr2 = this.O00000oO;
                if (strArr2[O000000o2] == null) {
                    strArr2[O000000o2] = str;
                } else {
                    int i4 = O000000o2 >> 1;
                    O000000o[] o000000oArr2 = this.O00000oo;
                    o000000oArr2[i4] = new O000000o(str, o000000oArr2[i4]);
                }
            }
        }
        int i5 = r1 >> 1;
        for (int i6 = 0; i6 < i5; i6++) {
            for (O000000o o000000o = o000000oArr[i6]; o000000o != null; o000000o = o000000o.O00000Oo) {
                i3++;
                String str2 = o000000o.f12402O000000o;
                int O000000o3 = O000000o(str2) & this.O0000Oo0;
                String[] strArr3 = this.O00000oO;
                if (strArr3[O000000o3] == null) {
                    strArr3[O000000o3] = str2;
                } else {
                    int i7 = O000000o3 >> 1;
                    O000000o[] o000000oArr3 = this.O00000oo;
                    o000000oArr3[i7] = new O000000o(str2, o000000oArr3[i7]);
                }
            }
        }
        if (i3 != this.O0000O0o) {
            throw new Error("Internal error on SymbolTable.rehash(): had " + this.O0000O0o + " entries; now have " + i3 + ".");
        }
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f12402O000000o;
        final O000000o O00000Oo;

        public O000000o(String str, O000000o o000000o) {
            this.f12402O000000o = str;
            this.O00000Oo = o000000o;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x0015  */
        public final String O000000o(char[] cArr, int i, int i2) {
            String str = this.f12402O000000o;
            O000000o o000000o = this.O00000Oo;
            while (true) {
                if (str.length() == i2) {
                    int i3 = 0;
                    while (str.charAt(i3) == cArr[i + i3] && (i3 = i3 + 1) < i2) {
                        while (str.charAt(i3) == cArr[i + i3]) {
                            while (str.charAt(i3) == cArr[i + i3]) {
                            }
                        }
                    }
                    if (i3 == i2) {
                        return str;
                    }
                }
                if (o000000o == null) {
                    return null;
                }
                str = o000000o.f12402O000000o;
                o000000o = o000000o.O00000Oo;
            }
        }
    }

    private synchronized void O000000o(ajg ajg) {
        if (ajg.O0000O0o > 12000) {
            O00000o0();
        } else if (ajg.O0000O0o > this.O0000O0o) {
            this.O00000oO = ajg.O00000oO;
            this.O00000oo = ajg.O00000oo;
            this.O0000O0o = ajg.O0000O0o;
            this.O0000OOo = ajg.O0000OOo;
            this.O0000Oo0 = ajg.O0000Oo0;
        } else {
            return;
        }
        this.O0000Oo = false;
    }

    public final void O00000Oo() {
        ajg ajg;
        if (this.O0000Oo && (ajg = this.O00000Oo) != null) {
            ajg.O000000o(this);
            this.O0000Oo = false;
        }
    }
}
