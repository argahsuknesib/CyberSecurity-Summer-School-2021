package _m_j;

import javax.security.auth.x500.X500Principal;

final class jqk {

    /* renamed from: O000000o  reason: collision with root package name */
    final String f2058O000000o;
    final int O00000Oo = this.f2058O000000o.length();
    int O00000o;
    int O00000o0;
    int O00000oO;
    int O00000oo;
    char[] O0000O0o;

    public jqk(X500Principal x500Principal) {
        this.f2058O000000o = x500Principal.getName("RFC2253");
    }

    private int O000000o(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.O00000Oo) {
            char c = this.O0000O0o[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f2058O000000o);
            } else {
                i2 = c - '7';
            }
            char c2 = this.O0000O0o[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f2058O000000o);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f2058O000000o);
    }

    private char O00000oO() {
        int i;
        int i2;
        int O000000o2 = O000000o(this.O00000o0);
        this.O00000o0++;
        if (O000000o2 < 128) {
            return (char) O000000o2;
        }
        if (O000000o2 < 192 || O000000o2 > 247) {
            return '?';
        }
        if (O000000o2 <= 223) {
            i2 = O000000o2 & 31;
            i = 1;
        } else if (O000000o2 <= 239) {
            i = 2;
            i2 = O000000o2 & 15;
        } else {
            i = 3;
            i2 = O000000o2 & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.O00000o0++;
            int i4 = this.O00000o0;
            if (i4 == this.O00000Oo || this.O0000O0o[i4] != '\\') {
                return '?';
            }
            this.O00000o0 = i4 + 1;
            int O000000o3 = O000000o(this.O00000o0);
            this.O00000o0++;
            if ((O000000o3 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (O000000o3 & 63);
        }
        return (char) i2;
    }

    /* access modifiers changed from: package-private */
    public final String O000000o() {
        int i;
        char[] cArr;
        while (true) {
            int i2 = this.O00000o0;
            if (i2 >= this.O00000Oo || this.O0000O0o[i2] != ' ') {
                int i3 = this.O00000o0;
            } else {
                this.O00000o0 = i2 + 1;
            }
        }
        int i32 = this.O00000o0;
        if (i32 == this.O00000Oo) {
            return null;
        }
        this.O00000o = i32;
        do {
            this.O00000o0 = i32 + 1;
            i32 = this.O00000o0;
            if (i32 >= this.O00000Oo) {
                break;
            }
            cArr = this.O0000O0o;
            if (cArr[i32] == '=') {
                break;
            }
        } while (cArr[i32] != ' ');
        int i4 = this.O00000o0;
        if (i4 < this.O00000Oo) {
            this.O00000oO = i4;
            if (this.O0000O0o[i4] == ' ') {
                while (true) {
                    int i5 = this.O00000o0;
                    if (i5 >= this.O00000Oo) {
                        break;
                    }
                    char[] cArr2 = this.O0000O0o;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.O00000o0 = i5 + 1;
                }
                char[] cArr3 = this.O0000O0o;
                int i6 = this.O00000o0;
                if (cArr3[i6] != '=' || i6 == this.O00000Oo) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f2058O000000o);
                }
            }
            do {
                this.O00000o0++;
                i = this.O00000o0;
                if (i >= this.O00000Oo) {
                    break;
                }
            } while (this.O0000O0o[i] == ' ');
            int i7 = this.O00000oO;
            int i8 = this.O00000o;
            if (i7 - i8 > 4) {
                char[] cArr4 = this.O0000O0o;
                if (cArr4[i8 + 3] == '.' && (cArr4[i8] == 'O' || cArr4[i8] == 'o')) {
                    char[] cArr5 = this.O0000O0o;
                    int i9 = this.O00000o;
                    if (cArr5[i9 + 1] == 'I' || cArr5[i9 + 1] == 'i') {
                        char[] cArr6 = this.O0000O0o;
                        int i10 = this.O00000o;
                        if (cArr6[i10 + 2] == 'D' || cArr6[i10 + 2] == 'd') {
                            this.O00000o += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.O0000O0o;
            int i11 = this.O00000o;
            return new String(cArr7, i11, this.O00000oO - i11);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f2058O000000o);
    }

    /* access modifiers changed from: package-private */
    public final String O00000Oo() {
        int i = this.O00000o0;
        if (i + 4 < this.O00000Oo) {
            this.O00000o = i;
            while (true) {
                this.O00000o0 = i + 1;
                int i2 = this.O00000o0;
                if (i2 == this.O00000Oo) {
                    break;
                }
                char[] cArr = this.O0000O0o;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.O00000oO = i2;
                    do {
                        this.O00000o0 = i2 + 1;
                        i2 = this.O00000o0;
                        if (i2 >= this.O00000Oo) {
                            break;
                        }
                    } while (this.O0000O0o[i2] == ' ');
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    i = this.O00000o0;
                }
            }
            this.O00000oO = this.O00000o0;
            int i3 = this.O00000oO;
            int i4 = this.O00000o;
            int i5 = i3 - i4;
            if (i5 < 5 || (i5 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f2058O000000o);
            }
            byte[] bArr = new byte[(i5 / 2)];
            int i6 = i4 + 1;
            for (int i7 = 0; i7 < bArr.length; i7++) {
                bArr[i7] = (byte) O000000o(i6);
                i6 += 2;
            }
            return new String(this.O0000O0o, this.O00000o, i5);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f2058O000000o);
    }

    /* access modifiers changed from: package-private */
    public final char O00000o() {
        this.O00000o0++;
        int i = this.O00000o0;
        if (i != this.O00000Oo) {
            char c = this.O0000O0o[i];
            if (!(c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#')) {
                switch (c) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return O00000oO();
                        }
                }
            }
            return this.O0000O0o[this.O00000o0];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f2058O000000o);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
        r1 = r8.O0000O0o;
        r2 = r8.O00000o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a3, code lost:
        return new java.lang.String(r1, r2, r8.O00000oo - r2);
     */
    public final String O00000o0() {
        int i = this.O00000o0;
        this.O00000o = i;
        this.O00000oO = i;
        while (true) {
            int i2 = this.O00000o0;
            if (i2 < this.O00000Oo) {
                char[] cArr = this.O0000O0o;
                char c = cArr[i2];
                if (c == ' ') {
                    int i3 = this.O00000oO;
                    this.O00000oo = i3;
                    this.O00000o0 = i2 + 1;
                    this.O00000oO = i3 + 1;
                    cArr[i3] = ' ';
                    while (true) {
                        int i4 = this.O00000o0;
                        if (i4 >= this.O00000Oo) {
                            break;
                        }
                        char[] cArr2 = this.O0000O0o;
                        if (cArr2[i4] != ' ') {
                            break;
                        }
                        int i5 = this.O00000oO;
                        this.O00000oO = i5 + 1;
                        cArr2[i5] = ' ';
                        this.O00000o0 = i4 + 1;
                    }
                    int i6 = this.O00000o0;
                    if (i6 == this.O00000Oo) {
                        break;
                    }
                    char[] cArr3 = this.O0000O0o;
                    if (cArr3[i6] == ',' || cArr3[i6] == '+' || cArr3[i6] == ';') {
                        break;
                    }
                } else if (c == ';') {
                    break;
                } else {
                    if (c != '\\') {
                        if (c == '+' || c == ',') {
                            break;
                        }
                        int i7 = this.O00000oO;
                        this.O00000oO = i7 + 1;
                        cArr[i7] = cArr[i2];
                    } else {
                        int i8 = this.O00000oO;
                        this.O00000oO = i8 + 1;
                        cArr[i8] = O00000o();
                        i2 = this.O00000o0;
                    }
                    this.O00000o0 = i2 + 1;
                }
            } else {
                char[] cArr4 = this.O0000O0o;
                int i9 = this.O00000o;
                return new String(cArr4, i9, this.O00000oO - i9);
            }
        }
        char[] cArr5 = this.O0000O0o;
        int i10 = this.O00000o;
        return new String(cArr5, i10, this.O00000oO - i10);
    }
}
