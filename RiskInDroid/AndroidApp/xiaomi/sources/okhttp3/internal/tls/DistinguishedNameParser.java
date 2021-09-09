package okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length = this.dn.length();
    private int pos;

    DistinguishedNameParser(X500Principal x500Principal) {
        this.dn = x500Principal.getName("RFC2253");
    }

    private String nextAT() {
        int i;
        while (true) {
            int i2 = this.pos;
            if (i2 >= this.length || this.chars[i2] != ' ') {
                int i3 = this.pos;
            } else {
                this.pos = i2 + 1;
            }
        }
        int i32 = this.pos;
        if (i32 == this.length) {
            return null;
        }
        this.beg = i32;
        this.pos = i32 + 1;
        while (true) {
            int i4 = this.pos;
            if (i4 >= this.length) {
                break;
            }
            char[] cArr = this.chars;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.pos = i4 + 1;
        }
        int i5 = this.pos;
        if (i5 < this.length) {
            this.end = i5;
            if (this.chars[i5] == ' ') {
                while (true) {
                    int i6 = this.pos;
                    if (i6 >= this.length) {
                        break;
                    }
                    char[] cArr2 = this.chars;
                    if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                        break;
                    }
                    this.pos = i6 + 1;
                }
                char[] cArr3 = this.chars;
                int i7 = this.pos;
                if (cArr3[i7] != '=' || i7 == this.length) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.dn);
                }
            }
            do {
                this.pos++;
                i = this.pos;
                if (i >= this.length) {
                    break;
                }
            } while (this.chars[i] == ' ');
            int i8 = this.end;
            int i9 = this.beg;
            if (i8 - i9 > 4) {
                char[] cArr4 = this.chars;
                if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                    char[] cArr5 = this.chars;
                    int i10 = this.beg;
                    if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                        char[] cArr6 = this.chars;
                        int i11 = this.beg;
                        if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                            this.beg += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.chars;
            int i12 = this.beg;
            return new String(cArr7, i12, this.end - i12);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private String quotedAV() {
        this.pos++;
        this.beg = this.pos;
        this.end = this.beg;
        while (true) {
            int i = this.pos;
            if (i != this.length) {
                char[] cArr = this.chars;
                if (cArr[i] == '\"') {
                    this.pos = i + 1;
                    while (true) {
                        int i2 = this.pos;
                        if (i2 >= this.length || this.chars[i2] != ' ') {
                            char[] cArr2 = this.chars;
                            int i3 = this.beg;
                        } else {
                            this.pos = i2 + 1;
                        }
                    }
                    char[] cArr22 = this.chars;
                    int i32 = this.beg;
                    return new String(cArr22, i32, this.end - i32);
                }
                if (cArr[i] == '\\') {
                    cArr[this.end] = getEscaped();
                } else {
                    cArr[this.end] = cArr[i];
                }
                this.pos++;
                this.end++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
    }

    private String hexAV() {
        int i = this.pos;
        if (i + 4 < this.length) {
            this.beg = i;
            this.pos = i + 1;
            while (true) {
                int i2 = this.pos;
                if (i2 == this.length) {
                    break;
                }
                char[] cArr = this.chars;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.end = i2;
                    this.pos = i2 + 1;
                    while (true) {
                        int i3 = this.pos;
                        if (i3 >= this.length || this.chars[i3] != ' ') {
                            break;
                        }
                        this.pos = i3 + 1;
                    }
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    this.pos++;
                }
            }
            this.end = this.pos;
            int i4 = this.end;
            int i5 = this.beg;
            int i6 = i4 - i5;
            if (i6 < 5 || (i6 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
            byte[] bArr = new byte[(i6 / 2)];
            int i7 = i5 + 1;
            for (int i8 = 0; i8 < bArr.length; i8++) {
                bArr[i8] = (byte) getByte(i7);
                i7 += 2;
            }
            return new String(this.chars, this.beg, i6);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        r1 = r8.chars;
        r2 = r8.beg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.cur - r2);
     */
    private String escapedAV() {
        int i = this.pos;
        this.beg = i;
        this.end = i;
        while (true) {
            int i2 = this.pos;
            if (i2 < this.length) {
                char[] cArr = this.chars;
                char c = cArr[i2];
                if (c == ' ') {
                    int i3 = this.end;
                    this.cur = i3;
                    this.pos = i2 + 1;
                    this.end = i3 + 1;
                    cArr[i3] = ' ';
                    while (true) {
                        int i4 = this.pos;
                        if (i4 >= this.length) {
                            break;
                        }
                        char[] cArr2 = this.chars;
                        if (cArr2[i4] != ' ') {
                            break;
                        }
                        int i5 = this.end;
                        this.end = i5 + 1;
                        cArr2[i5] = ' ';
                        this.pos = i4 + 1;
                    }
                    int i6 = this.pos;
                    if (i6 == this.length) {
                        break;
                    }
                    char[] cArr3 = this.chars;
                    if (cArr3[i6] == ',' || cArr3[i6] == '+' || cArr3[i6] == ';') {
                        break;
                    }
                } else if (c == ';') {
                    break;
                } else if (c != '\\') {
                    if (c == '+' || c == ',') {
                        break;
                    }
                    int i7 = this.end;
                    this.end = i7 + 1;
                    cArr[i7] = cArr[i2];
                    this.pos = i2 + 1;
                } else {
                    int i8 = this.end;
                    this.end = i8 + 1;
                    cArr[i8] = getEscaped();
                    this.pos++;
                }
            } else {
                char[] cArr4 = this.chars;
                int i9 = this.beg;
                return new String(cArr4, i9, this.end - i9);
            }
        }
        char[] cArr5 = this.chars;
        int i10 = this.beg;
        return new String(cArr5, i10, this.end - i10);
    }

    private char getEscaped() {
        this.pos++;
        int i = this.pos;
        if (i != this.length) {
            char c = this.chars[i];
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
                                return getUTF8();
                        }
                }
            }
            return this.chars[this.pos];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private char getUTF8() {
        int i;
        int i2;
        int i3 = getByte(this.pos);
        this.pos++;
        if (i3 < 128) {
            return (char) i3;
        }
        if (i3 < 192 || i3 > 247) {
            return '?';
        }
        if (i3 <= 223) {
            i2 = i3 & 31;
            i = 1;
        } else if (i3 <= 239) {
            i = 2;
            i2 = i3 & 15;
        } else {
            i = 3;
            i2 = i3 & 7;
        }
        for (int i4 = 0; i4 < i; i4++) {
            this.pos++;
            int i5 = this.pos;
            if (i5 == this.length || this.chars[i5] != '\\') {
                return '?';
            }
            this.pos = i5 + 1;
            int i6 = getByte(this.pos);
            this.pos++;
            if ((i6 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (i6 & 63);
        }
        return (char) i2;
    }

    private int getByte(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.length) {
            char c = this.chars[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            } else {
                i2 = c - '7';
            }
            char c2 = this.chars[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }

    public final String findMostSpecific(String str) {
        String str2;
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String nextAT = nextAT();
        if (nextAT == null) {
            return null;
        }
        do {
            int i = this.pos;
            if (i == this.length) {
                return null;
            }
            char c = this.chars[i];
            if (c != '\"') {
                str2 = c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : escapedAV() : hexAV();
            } else {
                str2 = quotedAV();
            }
            if (str.equalsIgnoreCase(nextAT)) {
                return str2;
            }
            int i2 = this.pos;
            if (i2 >= this.length) {
                return null;
            }
            char[] cArr = this.chars;
            if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                this.pos++;
                nextAT = nextAT();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
        } while (nextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }
}
