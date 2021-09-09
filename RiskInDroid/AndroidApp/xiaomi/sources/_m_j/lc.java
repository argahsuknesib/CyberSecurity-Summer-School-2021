package _m_j;

import java.io.IOException;
import java.io.Reader;

public final class lc {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f2163O000000o;
    int O00000Oo;
    int O00000o;
    int O00000o0;
    protected int[] O00000oO;
    protected int[] O00000oo;
    protected int O0000O0o;
    protected int O0000OOo;
    protected boolean O0000Oo;
    protected boolean O0000Oo0;
    protected Reader O0000OoO;
    protected char[] O0000Ooo;
    protected int O0000o0;
    protected char[] O0000o00;
    protected int O0000o0O;
    protected int O0000o0o;

    public lc(Reader reader) {
        this(reader, 1, 1);
    }

    private lc(Reader reader, int i, int i2) {
        this.f2163O000000o = -1;
        this.O0000O0o = 0;
        this.O0000OOo = 1;
        this.O0000Oo0 = false;
        this.O0000Oo = false;
        this.O0000o0 = 0;
        this.O0000o0O = -1;
        this.O0000o0o = 0;
        this.O0000OoO = reader;
        this.O0000OOo = 1;
        this.O0000O0o = 0;
        this.O00000Oo = 4096;
        this.O00000o0 = 4096;
        this.O0000o00 = new char[4096];
        this.O00000oO = new int[4096];
        this.O00000oo = new int[4096];
        this.O0000Ooo = new char[4096];
    }

    private static int O000000o(char c) throws IOException {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                switch (c) {
                    case 'A':
                        return 10;
                    case 'B':
                        return 11;
                    case 'C':
                        return 12;
                    case 'D':
                        return 13;
                    case 'E':
                        return 14;
                    case 'F':
                        return 15;
                    default:
                        switch (c) {
                            case 'a':
                                return 10;
                            case 'b':
                                return 11;
                            case 'c':
                                return 12;
                            case 'd':
                                return 13;
                            case 'e':
                                return 14;
                            case 'f':
                                return 15;
                            default:
                                throw new IOException();
                        }
                }
        }
    }

    private void O000000o(boolean z) {
        int i = this.O00000Oo;
        char[] cArr = new char[(i + 2048)];
        int[] iArr = new int[(i + 2048)];
        int[] iArr2 = new int[(i + 2048)];
        if (z) {
            try {
                System.arraycopy(this.O0000o00, this.O00000o, cArr, 0, i - this.O00000o);
                System.arraycopy(this.O0000o00, 0, cArr, this.O00000Oo - this.O00000o, this.f2163O000000o);
                this.O0000o00 = cArr;
                System.arraycopy(this.O00000oO, this.O00000o, iArr, 0, this.O00000Oo - this.O00000o);
                System.arraycopy(this.O00000oO, 0, iArr, this.O00000Oo - this.O00000o, this.f2163O000000o);
                this.O00000oO = iArr;
                System.arraycopy(this.O00000oo, this.O00000o, iArr2, 0, this.O00000Oo - this.O00000o);
                System.arraycopy(this.O00000oo, 0, iArr2, this.O00000Oo - this.O00000o, this.f2163O000000o);
                this.O00000oo = iArr2;
                this.f2163O000000o += this.O00000Oo - this.O00000o;
            } catch (Throwable th) {
                throw new Error(th.getMessage());
            }
        } else {
            System.arraycopy(this.O0000o00, this.O00000o, cArr, 0, i - this.O00000o);
            this.O0000o00 = cArr;
            System.arraycopy(this.O00000oO, this.O00000o, iArr, 0, this.O00000Oo - this.O00000o);
            this.O00000oO = iArr;
            System.arraycopy(this.O00000oo, this.O00000o, iArr2, 0, this.O00000Oo - this.O00000o);
            this.O00000oo = iArr2;
            this.f2163O000000o -= this.O00000o;
        }
        int i2 = this.O00000Oo + 2048;
        this.O00000Oo = i2;
        this.O00000o0 = i2;
        this.O00000o = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    private void O00000Oo(char c) {
        this.O0000O0o++;
        if (this.O0000Oo) {
            this.O0000Oo = false;
        } else {
            if (this.O0000Oo0) {
                this.O0000Oo0 = false;
                if (c == 10) {
                    this.O0000Oo = true;
                }
            }
            if (c != 9) {
                this.O0000O0o--;
                int i = this.O0000O0o;
                this.O0000O0o = i + (8 - (i & 7));
            } else if (c == 10) {
                this.O0000Oo = true;
            } else if (c == 13) {
                this.O0000Oo0 = true;
            }
            int[] iArr = this.O00000oO;
            int i2 = this.f2163O000000o;
            iArr[i2] = this.O0000OOo;
            this.O00000oo[i2] = this.O0000O0o;
        }
        int i3 = this.O0000OOo;
        this.O0000O0o = 1;
        this.O0000OOo = i3 + 1;
        if (c != 9) {
        }
        int[] iArr2 = this.O00000oO;
        int i22 = this.f2163O000000o;
        iArr2[i22] = this.O0000OOo;
        this.O00000oo[i22] = this.O0000O0o;
    }

    private void O00000Oo(Reader reader, int i, int i2) {
        this.O0000OoO = reader;
        this.O0000OOo = i;
        this.O0000O0o = i2 - 1;
        char[] cArr = this.O0000o00;
        if (cArr == null || 4096 != cArr.length) {
            this.O00000Oo = 4096;
            this.O00000o0 = 4096;
            this.O0000o00 = new char[4096];
            this.O00000oO = new int[4096];
            this.O00000oo = new int[4096];
            this.O0000Ooo = new char[4096];
        }
        this.O0000Oo0 = false;
        this.O0000Oo = false;
        this.O0000o0 = 0;
        this.O0000o0o = 0;
        this.O00000o = 0;
        this.f2163O000000o = -1;
        this.O0000o0O = -1;
    }

    private void O0000Oo0() {
        int i = this.O00000o0;
        int i2 = this.O00000Oo;
        if (i != i2) {
            int i3 = this.O00000o;
            if (i > i3) {
                this.O00000o0 = i2;
                return;
            } else if (i3 - i < 2048) {
                O000000o(true);
                return;
            }
        } else if (this.O00000o > 2048) {
            this.f2163O000000o = 0;
        } else {
            O000000o(false);
            return;
        }
        this.O00000o0 = this.O00000o;
    }

    public final char O000000o() throws IOException {
        int i = this.O0000o0o;
        if (i > 0) {
            this.O0000o0o = i - 1;
            int i2 = this.f2163O000000o + 1;
            this.f2163O000000o = i2;
            if (i2 == this.O00000Oo) {
                this.f2163O000000o = 0;
            }
            int i3 = this.f2163O000000o;
            this.O00000o = i3;
            return this.O0000o00[i3];
        }
        this.O00000o = 0;
        this.f2163O000000o = -1;
        return O00000Oo();
    }

    public final void O000000o(int i) {
        this.O0000o0o += i;
        int i2 = this.f2163O000000o - i;
        this.f2163O000000o = i2;
        if (i2 < 0) {
            this.f2163O000000o += this.O00000Oo;
        }
    }

    public final void O000000o(Reader reader, int i, int i2) {
        O00000Oo(reader, i, i2);
    }

    public final char O00000Oo() throws IOException {
        char O0000OOo2;
        char O0000OOo3;
        int i = this.O0000o0o;
        if (i > 0) {
            this.O0000o0o = i - 1;
            int i2 = this.f2163O000000o + 1;
            this.f2163O000000o = i2;
            if (i2 == this.O00000Oo) {
                this.f2163O000000o = 0;
            }
            return this.O0000o00[this.f2163O000000o];
        }
        int i3 = this.f2163O000000o + 1;
        this.f2163O000000o = i3;
        if (i3 == this.O00000o0) {
            O0000Oo0();
        }
        char[] cArr = this.O0000o00;
        int i4 = this.f2163O000000o;
        char O0000OOo4 = O0000OOo();
        cArr[i4] = O0000OOo4;
        if (O0000OOo4 == '\\') {
            O00000Oo(O0000OOo4);
            int i5 = 1;
            while (true) {
                int i6 = this.f2163O000000o + 1;
                this.f2163O000000o = i6;
                if (i6 == this.O00000o0) {
                    O0000Oo0();
                }
                try {
                    char[] cArr2 = this.O0000o00;
                    int i7 = this.f2163O000000o;
                    O0000OOo2 = O0000OOo();
                    cArr2[i7] = O0000OOo2;
                    if (O0000OOo2 != '\\') {
                        break;
                    }
                    O00000Oo(O0000OOo2);
                    i5++;
                } catch (IOException unused) {
                    if (i5 > 1) {
                        O000000o(i5);
                    }
                    return '\\';
                }
            }
            O00000Oo(O0000OOo2);
            if (O0000OOo2 == 'u' && (i5 & 1) == 1) {
                int i8 = this.f2163O000000o - 1;
                this.f2163O000000o = i8;
                if (i8 < 0) {
                    this.f2163O000000o = this.O00000Oo - 1;
                }
                while (true) {
                    try {
                        O0000OOo3 = O0000OOo();
                        if (O0000OOo3 != 'u') {
                            break;
                        }
                        this.O0000O0o++;
                    } catch (IOException unused2) {
                        StringBuffer stringBuffer = new StringBuffer("Invalid escape character at line ");
                        stringBuffer.append(this.O0000OOo);
                        stringBuffer.append(" column ");
                        stringBuffer.append(this.O0000O0o);
                        stringBuffer.append(".");
                        throw new Error(stringBuffer.toString());
                    }
                }
                char[] cArr3 = this.O0000o00;
                int i9 = this.f2163O000000o;
                char O000000o2 = (char) ((O000000o(O0000OOo3) << 12) | (O000000o(O0000OOo()) << 8) | (O000000o(O0000OOo()) << 4) | O000000o(O0000OOo()));
                cArr3[i9] = O000000o2;
                this.O0000O0o += 4;
                if (i5 == 1) {
                    return O000000o2;
                }
                O000000o(i5 - 1);
                return '\\';
            }
            O000000o(i5);
            return '\\';
        }
        O00000Oo(O0000OOo4);
        return O0000OOo4;
    }

    public final int O00000o() {
        return this.O00000oO[this.f2163O000000o];
    }

    public final int O00000o0() {
        return this.O00000oo[this.f2163O000000o];
    }

    public final int O00000oO() {
        return this.O00000oo[this.O00000o];
    }

    public final int O00000oo() {
        return this.O00000oO[this.O00000o];
    }

    public final String O0000O0o() {
        int i = this.f2163O000000o;
        int i2 = this.O00000o;
        if (i >= i2) {
            return new String(this.O0000o00, i2, (i - i2) + 1);
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArr = this.O0000o00;
        int i3 = this.O00000o;
        stringBuffer.append(new String(cArr, i3, this.O00000Oo - i3));
        stringBuffer.append(new String(this.O0000o00, 0, this.f2163O000000o + 1));
        return stringBuffer.toString();
    }

    private char O0000OOo() throws IOException {
        int i = this.O0000o0O + 1;
        this.O0000o0O = i;
        int i2 = this.O0000o0;
        if (i >= i2) {
            if (i2 == 4096) {
                this.O0000o0O = 0;
                this.O0000o0 = 0;
            }
            try {
                int read = this.O0000OoO.read(this.O0000Ooo, this.O0000o0, 4096 - this.O0000o0);
                if (read != -1) {
                    this.O0000o0 += read;
                } else {
                    this.O0000OoO.close();
                    throw new IOException();
                }
            } catch (IOException e) {
                int i3 = this.f2163O000000o;
                if (i3 != 0) {
                    this.f2163O000000o = i3 - 1;
                    O000000o(0);
                } else {
                    this.O00000oO[i3] = this.O0000OOo;
                    this.O00000oo[i3] = this.O0000O0o;
                }
                throw e;
            }
        }
        return this.O0000Ooo[this.O0000o0O];
    }
}
