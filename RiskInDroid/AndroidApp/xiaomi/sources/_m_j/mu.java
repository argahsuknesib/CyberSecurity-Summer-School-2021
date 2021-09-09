package _m_j;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

public final class mu extends PushbackReader {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f2188O000000o = 0;
    private int O00000Oo = 0;
    private int O00000o0 = 0;

    public mu(Reader reader) {
        super(reader, 8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        if (r0.O00000o0 <= 5) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0063, code lost:
        if (_m_j.na.O000000o((char) r0.O00000Oo) != false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0099, code lost:
        if (r0.O00000o0 <= 4) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a7, code lost:
        if (_m_j.na.O000000o((char) r0.O00000Oo) != false) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00d5 A[SYNTHETIC] */
    public final int read(char[] cArr, int i, int i2) throws IOException {
        int i3;
        char[] cArr2 = new char[8];
        int i4 = 1;
        int i5 = i;
        boolean z = true;
        int i6 = 0;
        loop0:
        while (true) {
            int i7 = 0;
            while (z && i6 < i2) {
                z = super.read(cArr2, i7, i4) == i4;
                if (z) {
                    char c = cArr2[i7];
                    int i8 = this.f2188O000000o;
                    if (i8 != 0) {
                        if (i8 != i4) {
                            if (i8 != 2) {
                                if (i8 != 3) {
                                    if (i8 != 4) {
                                        if (i8 == 5) {
                                            this.f2188O000000o = 0;
                                        }
                                    } else if ('0' <= c && c <= '9') {
                                        this.O00000Oo = (this.O00000Oo * 10) + Character.digit(c, 10);
                                        this.O00000o0++;
                                    } else if (c == ';') {
                                    }
                                } else if (('0' <= c && c <= '9') || (('a' <= c && c <= 'f') || ('A' <= c && c <= 'F'))) {
                                    this.O00000Oo = (this.O00000Oo * 16) + Character.digit(c, 16);
                                    this.O00000o0++;
                                } else if (c == ';') {
                                }
                                this.f2188O000000o = 0;
                                c = (char) this.O00000Oo;
                            } else if (c == 'x') {
                                this.O00000Oo = 0;
                                this.O00000o0 = 0;
                                this.f2188O000000o = 3;
                            } else if ('0' <= c && c <= '9') {
                                this.O00000Oo = Character.digit(c, 10);
                                this.O00000o0 = 1;
                            }
                            this.f2188O000000o = 4;
                        } else if (c == '#') {
                            this.f2188O000000o = 2;
                        }
                        this.f2188O000000o = 5;
                    } else if (c == '&') {
                        this.f2188O000000o = 1;
                        i3 = this.f2188O000000o;
                        if (i3 != 0) {
                            if (na.O000000o(c)) {
                                c = ' ';
                            }
                            cArr[i5] = c;
                            i6++;
                            i5++;
                        } else if (i3 == 5) {
                            unread(cArr2, 0, i7 + 1);
                        } else {
                            i7++;
                        }
                        i4 = 1;
                    }
                    i3 = this.f2188O000000o;
                    if (i3 != 0) {
                    }
                    i4 = 1;
                } else if (i7 > 0) {
                    unread(cArr2, 0, i7);
                    this.f2188O000000o = 5;
                    i4 = 1;
                    z = true;
                }
                i4 = 1;
            }
        }
        if (i6 > 0 || z) {
            return i6;
        }
        return -1;
    }
}
