package _m_j;

public final class bdv {

    /* renamed from: O000000o  reason: collision with root package name */
    private final O000000o[] f12892O000000o;
    private final String[] O00000Oo;
    private final int O00000o;
    private final char[][] O00000o0;
    private int O00000oO;

    public bdv() {
        this((byte) 0);
        O000000o("$ref", 0, 4, "$ref".hashCode());
        O000000o("@type", 0, 4, "$type".hashCode());
    }

    private bdv(byte b) {
        this.O00000oO = 0;
        this.O00000o = 255;
        this.f12892O000000o = new O000000o[256];
        this.O00000Oo = new String[256];
        this.O00000o0 = new char[256][];
    }

    public final String O000000o(char[] cArr, int i, int i2) {
        boolean z;
        boolean z2;
        int i3 = this.O00000o & i2;
        String str = this.O00000Oo[i3];
        if (str == null) {
            z = true;
        } else if (str.length() == i) {
            char[] cArr2 = this.O00000o0[i3];
            int i4 = 0;
            while (true) {
                if (i4 >= i) {
                    z = true;
                    break;
                } else if (cArr[i4 + 0] != cArr2[i4]) {
                    z = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z) {
                return str;
            }
        } else {
            z = false;
        }
        int i5 = 0;
        for (O000000o o000000o = this.f12892O000000o[i3]; o000000o != null; o000000o = o000000o.O00000oO) {
            char[] cArr3 = o000000o.O00000o0;
            if (i == cArr3.length && i2 == o000000o.O00000Oo) {
                int i6 = 0;
                while (true) {
                    if (i6 >= i) {
                        z2 = true;
                        break;
                    } else if (cArr[i6 + 0] != cArr3[i6]) {
                        z2 = false;
                        break;
                    } else {
                        i6++;
                    }
                }
                if (z2) {
                    return o000000o.f12893O000000o;
                }
                i5++;
            }
        }
        if (i5 >= 8) {
            return new String(cArr, 0, i);
        }
        if (this.O00000oO >= 1024) {
            return new String(cArr, 0, i);
        }
        O000000o o000000o2 = new O000000o(cArr, 0, i, i2, this.f12892O000000o[i3]);
        this.f12892O000000o[i3] = o000000o2;
        if (z) {
            this.O00000Oo[i3] = o000000o2.f12893O000000o;
            this.O00000o0[i3] = o000000o2.O00000o0;
        }
        this.O00000oO++;
        return o000000o2.f12893O000000o;
    }

    public final String O000000o(String str, int i, int i2, int i3) {
        boolean z;
        boolean z2;
        int i4 = this.O00000o & i3;
        String str2 = this.O00000Oo[i4];
        if (str2 == null) {
            z = true;
        } else if (str2.length() == i2) {
            char[] cArr = this.O00000o0[i4];
            int i5 = 0;
            while (true) {
                if (i5 >= i2) {
                    z = true;
                    break;
                } else if (str.charAt(i + i5) != cArr[i5]) {
                    z = false;
                    break;
                } else {
                    i5++;
                }
            }
            if (z) {
                return str2;
            }
        } else {
            z = false;
        }
        int i6 = 0;
        for (O000000o o000000o = this.f12892O000000o[i4]; o000000o != null; o000000o = o000000o.O00000oO) {
            char[] cArr2 = o000000o.O00000o0;
            if (i2 == cArr2.length && i3 == o000000o.O00000Oo) {
                int i7 = 0;
                while (true) {
                    if (i7 >= i2) {
                        z2 = true;
                        break;
                    } else if (str.charAt(i + i7) != cArr2[i7]) {
                        z2 = false;
                        break;
                    } else {
                        i7++;
                    }
                }
                if (z2) {
                    return o000000o.f12893O000000o;
                }
                i6++;
            }
        }
        if (i6 >= 8) {
            return str.substring(i, i2 + i);
        }
        if (this.O00000oO >= 1024) {
            return str.substring(i, i2 + i);
        }
        O000000o o000000o2 = new O000000o(str, i, i2, i3, this.f12892O000000o[i4]);
        this.f12892O000000o[i4] = o000000o2;
        if (z) {
            this.O00000Oo[i4] = o000000o2.f12893O000000o;
            this.O00000o0[i4] = o000000o2.O00000o0;
        }
        this.O00000oO++;
        return o000000o2.f12893O000000o;
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f12893O000000o;
        public final int O00000Oo;
        public final byte[] O00000o;
        public final char[] O00000o0;
        public O000000o O00000oO;

        public O000000o(char[] cArr, int i, int i2, int i3, O000000o o000000o) {
            this.O00000o0 = new char[i2];
            System.arraycopy(cArr, 0, this.O00000o0, 0, i2);
            this.f12893O000000o = new String(this.O00000o0).intern();
            this.O00000oO = o000000o;
            this.O00000Oo = i3;
            this.O00000o = null;
        }

        public O000000o(String str, int i, int i2, int i3, O000000o o000000o) {
            this.f12893O000000o = str.substring(i, i2 + i).intern();
            this.O00000o0 = this.f12893O000000o.toCharArray();
            this.O00000oO = o000000o;
            this.O00000Oo = i3;
            this.O00000o = null;
        }
    }
}
