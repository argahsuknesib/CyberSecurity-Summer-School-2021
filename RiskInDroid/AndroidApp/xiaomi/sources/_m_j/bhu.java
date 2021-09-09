package _m_j;

import com.imi.fastjson.JSONException;
import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.io.Writer;
import java.lang.ref.SoftReference;

public final class bhu extends Writer {
    private static final ThreadLocal<SoftReference<char[]>> O00000o = new ThreadLocal<>();

    /* renamed from: O000000o  reason: collision with root package name */
    protected char[] f12980O000000o;
    protected int O00000Oo;
    public int O00000o0;
    private final Writer O00000oO;

    public bhu() {
        this((byte) 0);
    }

    private bhu(byte b) {
        this.O00000oO = null;
        this.O00000o0 = bdf.O00000o;
        SoftReference softReference = O00000o.get();
        if (softReference != null) {
            this.f12980O000000o = (char[]) softReference.get();
            O00000o.set(null);
        }
        if (this.f12980O000000o == null) {
            this.f12980O000000o = new char[1024];
        }
    }

    public final boolean O000000o(SerializerFeature serializerFeature) {
        return SerializerFeature.isEnabled(this.O00000o0, serializerFeature);
    }

    public final void write(int i) {
        int i2 = this.O00000Oo + 1;
        if (i2 > this.f12980O000000o.length) {
            if (this.O00000oO == null) {
                O00000Oo(i2);
            } else {
                flush();
                i2 = 1;
            }
        }
        this.f12980O000000o[this.O00000Oo] = (char) i;
        this.O00000Oo = i2;
    }

    public final void O000000o(char c) {
        int i = this.O00000Oo + 1;
        if (i > this.f12980O000000o.length) {
            if (this.O00000oO == null) {
                O00000Oo(i);
            } else {
                flush();
                i = 1;
            }
        }
        this.f12980O000000o[this.O00000Oo] = c;
        this.O00000Oo = i;
    }

    public final void write(char[] cArr, int i, int i2) {
        int i3;
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) > cArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            int i4 = this.O00000Oo + i2;
            if (i4 > this.f12980O000000o.length) {
                if (this.O00000oO == null) {
                    O00000Oo(i4);
                } else {
                    do {
                        char[] cArr2 = this.f12980O000000o;
                        int length = cArr2.length;
                        int i5 = this.O00000Oo;
                        int i6 = length - i5;
                        System.arraycopy(cArr, i, cArr2, i5, i6);
                        this.O00000Oo = this.f12980O000000o.length;
                        flush();
                        i2 -= i6;
                        i += i6;
                    } while (i2 > this.f12980O000000o.length);
                    i4 = i2;
                }
            }
            System.arraycopy(cArr, i, this.f12980O000000o, this.O00000Oo, i2);
            this.O00000Oo = i4;
        }
    }

    private void O00000Oo(int i) {
        int length = ((this.f12980O000000o.length * 3) / 2) + 1;
        if (length >= i) {
            i = length;
        }
        char[] cArr = new char[i];
        System.arraycopy(this.f12980O000000o, 0, cArr, 0, this.O00000Oo);
        this.f12980O000000o = cArr;
    }

    public final void write(String str, int i, int i2) {
        int i3;
        int i4 = this.O00000Oo + i2;
        if (i4 > this.f12980O000000o.length) {
            if (this.O00000oO == null) {
                O00000Oo(i4);
            } else {
                while (true) {
                    char[] cArr = this.f12980O000000o;
                    int length = cArr.length;
                    int i5 = this.O00000Oo;
                    int i6 = length - i5;
                    i3 = i + i6;
                    str.getChars(i, i3, cArr, i5);
                    this.O00000Oo = this.f12980O000000o.length;
                    flush();
                    i2 -= i6;
                    if (i2 <= this.f12980O000000o.length) {
                        break;
                    }
                    i = i3;
                }
                i4 = i2;
                i = i3;
            }
        }
        str.getChars(i, i2 + i, this.f12980O000000o, this.O00000Oo);
        this.O00000Oo = i4;
    }

    /* renamed from: O000000o */
    public final bhu append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public bhu append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public final bhu O00000Oo(char c) {
        O000000o(c);
        return this;
    }

    public final String toString() {
        return new String(this.f12980O000000o, 0, this.O00000Oo);
    }

    public final void close() {
        if (this.O00000oO != null && this.O00000Oo > 0) {
            flush();
        }
        char[] cArr = this.f12980O000000o;
        if (cArr.length <= 8192) {
            O00000o.set(new SoftReference(cArr));
        }
        this.f12980O000000o = null;
    }

    public final void write(String str) {
        while (str == null) {
            str = "null";
        }
        write(str, 0, str.length());
    }

    public final void O000000o(int i) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int O000000o2 = i < 0 ? bie.O000000o(-i) + 1 : bie.O000000o(i);
        int i2 = this.O00000Oo + O000000o2;
        if (i2 > this.f12980O000000o.length) {
            if (this.O00000oO == null) {
                O00000Oo(i2);
            } else {
                char[] cArr = new char[O000000o2];
                bie.O000000o(i, O000000o2, cArr);
                write(cArr, 0, cArr.length);
                return;
            }
        }
        bie.O000000o(i, i2, this.f12980O000000o);
        this.O00000Oo = i2;
    }

    public final void O000000o(byte[] bArr) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        if (length == 0) {
            write("\"\"");
            return;
        }
        char[] cArr = bib.f12987O000000o;
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = this.O00000Oo;
        int i4 = (((i2 / 3) + 1) << 2) + i3 + 2;
        int i5 = 0;
        if (i4 > this.f12980O000000o.length) {
            if (this.O00000oO != null) {
                O000000o('\"');
                int i6 = 0;
                while (i6 < i) {
                    int i7 = i6 + 1;
                    int i8 = i7 + 1;
                    byte b = ((bArr2[i6] & 255) << 16) | ((bArr2[i7] & 255) << 8) | (bArr2[i8] & 255);
                    O000000o(cArr[(b >>> 18) & 63]);
                    O000000o(cArr[(b >>> 12) & 63]);
                    O000000o(cArr[(b >>> 6) & 63]);
                    O000000o(cArr[b & 63]);
                    i6 = i8 + 1;
                }
                int i9 = length - i;
                if (i9 > 0) {
                    int i10 = (bArr2[i] & 255) << 10;
                    if (i9 == 2) {
                        i5 = (bArr2[i2] & 255) << 2;
                    }
                    int i11 = i10 | i5;
                    O000000o(cArr[i11 >> 12]);
                    O000000o(cArr[(i11 >>> 6) & 63]);
                    O000000o(i9 == 2 ? cArr[i11 & 63] : '=');
                    O000000o('=');
                }
                O000000o('\"');
                return;
            }
            O00000Oo(i4);
        }
        this.O00000Oo = i4;
        int i12 = i3 + 1;
        this.f12980O000000o[i3] = '\"';
        int i13 = 0;
        while (i13 < i) {
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            byte b2 = ((bArr2[i13] & 255) << 16) | ((bArr2[i14] & 255) << 8);
            int i16 = i15 + 1;
            byte b3 = b2 | (bArr2[i15] & 255);
            char[] cArr2 = this.f12980O000000o;
            int i17 = i12 + 1;
            cArr2[i12] = cArr[(b3 >>> 18) & 63];
            int i18 = i17 + 1;
            cArr2[i17] = cArr[(b3 >>> 12) & 63];
            int i19 = i18 + 1;
            cArr2[i18] = cArr[(b3 >>> 6) & 63];
            i12 = i19 + 1;
            cArr2[i19] = cArr[b3 & 63];
            i13 = i16;
        }
        int i20 = length - i;
        if (i20 > 0) {
            int i21 = (bArr2[i] & 255) << 10;
            if (i20 == 2) {
                i5 = (bArr2[i2] & 255) << 2;
            }
            int i22 = i21 | i5;
            char[] cArr3 = this.f12980O000000o;
            cArr3[i4 - 5] = cArr[i22 >> 12];
            cArr3[i4 - 4] = cArr[(i22 >>> 6) & 63];
            cArr3[i4 - 3] = i20 == 2 ? cArr[i22 & 63] : '=';
            this.f12980O000000o[i4 - 2] = '=';
        }
        this.f12980O000000o[i4 - 1] = '\"';
    }

    public final void O000000o(int i, char c) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            O000000o(c);
            return;
        }
        int O000000o2 = this.O00000Oo + (i < 0 ? bie.O000000o(-i) + 1 : bie.O000000o(i));
        int i2 = O000000o2 + 1;
        if (i2 > this.f12980O000000o.length) {
            if (this.O00000oO != null) {
                O000000o(i);
                O000000o(c);
                return;
            }
            O00000Oo(i2);
        }
        bie.O000000o(i, O000000o2, this.f12980O000000o);
        this.f12980O000000o[O000000o2] = c;
        this.O00000Oo = i2;
    }

    public final void O000000o(long j, char c) throws IOException {
        if (j == Long.MIN_VALUE) {
            write("-9223372036854775808");
            O000000o(c);
            return;
        }
        int O000000o2 = this.O00000Oo + (j < 0 ? bie.O000000o(-j) + 1 : bie.O000000o(j));
        int i = O000000o2 + 1;
        if (i > this.f12980O000000o.length) {
            if (this.O00000oO != null) {
                O000000o(j);
                O000000o(c);
                return;
            }
            O00000Oo(i);
        }
        bie.O000000o(j, O000000o2, this.f12980O000000o);
        this.f12980O000000o[O000000o2] = c;
        this.O00000Oo = i;
    }

    public final void O000000o(long j) {
        if (j == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        int O000000o2 = j < 0 ? bie.O000000o(-j) + 1 : bie.O000000o(j);
        int i = this.O00000Oo + O000000o2;
        if (i > this.f12980O000000o.length) {
            if (this.O00000oO == null) {
                O00000Oo(i);
            } else {
                char[] cArr = new char[O000000o2];
                bie.O000000o(j, O000000o2, cArr);
                write(cArr, 0, cArr.length);
                return;
            }
        }
        bie.O000000o(j, i, this.f12980O000000o);
        this.O00000Oo = i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bhu.O000000o(java.lang.String, char, boolean):void
     arg types: [java.lang.String, int, int]
     candidates:
      _m_j.bhu.O000000o(java.lang.CharSequence, int, int):_m_j.bhu
      _m_j.bhu.O000000o(java.lang.String, char, boolean):void */
    public final void O000000o(String str) {
        if (O000000o(SerializerFeature.UseSingleQuotes)) {
            O00000Oo(str);
        } else {
            O000000o(str, 0, true);
        }
    }

    private void O00000Oo(String str) {
        int i = 0;
        if (str == null) {
            int i2 = this.O00000Oo + 4;
            if (i2 > this.f12980O000000o.length) {
                O00000Oo(i2);
            }
            "null".getChars(0, 4, this.f12980O000000o, this.O00000Oo);
            this.O00000Oo = i2;
            return;
        }
        int length = str.length();
        int i3 = this.O00000Oo + length + 2;
        if (i3 > this.f12980O000000o.length) {
            if (this.O00000oO != null) {
                O000000o('\'');
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt <= 13 || charAt == '\\' || charAt == '\'' || (charAt == '/' && O000000o(SerializerFeature.WriteSlashAsSpecial))) {
                        O000000o('\\');
                        O000000o(bdn.O00000oo[charAt]);
                    } else {
                        O000000o(charAt);
                    }
                    i++;
                }
                O000000o('\'');
                return;
            }
            O00000Oo(i3);
        }
        int i4 = this.O00000Oo;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.f12980O000000o;
        cArr[i4] = '\'';
        str.getChars(0, length, cArr, i5);
        this.O00000Oo = i3;
        int i7 = -1;
        char c = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c2 = this.f12980O000000o[i8];
            if (c2 <= 13 || c2 == '\\' || c2 == '\'' || (c2 == '/' && O000000o(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                i7 = i8;
                c = c2;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.f12980O000000o.length) {
            O00000Oo(i9);
        }
        this.O00000Oo = i9;
        if (i == 1) {
            char[] cArr2 = this.f12980O000000o;
            int i10 = i7 + 1;
            System.arraycopy(cArr2, i10, cArr2, i7 + 2, (i6 - i7) - 1);
            char[] cArr3 = this.f12980O000000o;
            cArr3[i7] = '\\';
            cArr3[i10] = bdn.O00000oo[c];
        } else if (i > 1) {
            char[] cArr4 = this.f12980O000000o;
            int i11 = i7 + 1;
            System.arraycopy(cArr4, i11, cArr4, i7 + 2, (i6 - i7) - 1);
            char[] cArr5 = this.f12980O000000o;
            cArr5[i7] = '\\';
            cArr5[i11] = bdn.O00000oo[c];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char c3 = this.f12980O000000o[i13];
                if (c3 <= 13 || c3 == '\\' || c3 == '\'' || (c3 == '/' && O000000o(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.f12980O000000o;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr6, i14, cArr6, i13 + 2, (i12 - i13) - 1);
                    char[] cArr7 = this.f12980O000000o;
                    cArr7[i13] = '\\';
                    cArr7[i14] = bdn.O00000oo[c3];
                    i12++;
                }
            }
        }
        this.f12980O000000o[this.O00000Oo - 1] = '\'';
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bhu.O000000o(java.lang.String, char, boolean):void
     arg types: [java.lang.String, int, boolean]
     candidates:
      _m_j.bhu.O000000o(java.lang.CharSequence, int, int):_m_j.bhu
      _m_j.bhu.O000000o(java.lang.String, char, boolean):void */
    public final void O000000o(String str, boolean z) {
        if (str == null) {
            write("null:");
        } else if (O000000o(SerializerFeature.UseSingleQuotes)) {
            if (O000000o(SerializerFeature.QuoteFieldNames)) {
                O00000Oo(str);
                O000000o(':');
                return;
            }
            O00000o(str);
        } else if (O000000o(SerializerFeature.QuoteFieldNames)) {
            O000000o(str, ':', z);
        } else {
            O00000o0(str);
        }
    }

    private void O00000o0(String str) {
        int i;
        String str2 = str;
        boolean[] zArr = bdn.O00000o;
        int length = str.length();
        boolean z = true;
        int i2 = this.O00000Oo + length + 1;
        int i3 = 0;
        if (i2 > this.f12980O000000o.length) {
            if (this.O00000oO == null) {
                O00000Oo(i2);
            } else if (length == 0) {
                O000000o('\"');
                O000000o('\"');
                O000000o(':');
                return;
            } else {
                int i4 = 0;
                while (true) {
                    if (i4 < length) {
                        char charAt = str2.charAt(i4);
                        if (charAt < zArr.length && zArr[charAt]) {
                            break;
                        }
                        i4++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    O000000o('\"');
                }
                while (i3 < length) {
                    char charAt2 = str2.charAt(i3);
                    if (charAt2 >= zArr.length || !zArr[charAt2]) {
                        O000000o(charAt2);
                    } else {
                        O000000o('\\');
                        O000000o(bdn.O00000oo[charAt2]);
                    }
                    i3++;
                }
                if (z) {
                    O000000o('\"');
                }
                O000000o(':');
                return;
            }
        }
        if (length == 0) {
            int i5 = this.O00000Oo;
            if (i5 + 3 > this.f12980O000000o.length) {
                O00000Oo(i5 + 3);
            }
            char[] cArr = this.f12980O000000o;
            int i6 = this.O00000Oo;
            this.O00000Oo = i6 + 1;
            cArr[i6] = '\"';
            int i7 = this.O00000Oo;
            this.O00000Oo = i7 + 1;
            cArr[i7] = '\"';
            int i8 = this.O00000Oo;
            this.O00000Oo = i8 + 1;
            cArr[i8] = ':';
            return;
        }
        int i9 = this.O00000Oo;
        int i10 = i9 + length;
        str2.getChars(0, length, this.f12980O000000o, i9);
        this.O00000Oo = i2;
        int i11 = i9;
        boolean z2 = false;
        while (i11 < i10) {
            char[] cArr2 = this.f12980O000000o;
            char c = cArr2[i11];
            if (c >= zArr.length || !zArr[c]) {
                i = i11;
            } else if (!z2) {
                i2 += 3;
                if (i2 > cArr2.length) {
                    O00000Oo(i2);
                }
                this.O00000Oo = i2;
                char[] cArr3 = this.f12980O000000o;
                int i12 = i11 + 1;
                System.arraycopy(cArr3, i12, cArr3, i11 + 3, (i10 - i11) - 1);
                char[] cArr4 = this.f12980O000000o;
                System.arraycopy(cArr4, i3, cArr4, 1, i11);
                char[] cArr5 = this.f12980O000000o;
                cArr5[i9] = '\"';
                cArr5[i12] = '\\';
                int i13 = i12 + 1;
                cArr5[i13] = bdn.O00000oo[c];
                i10 += 2;
                this.f12980O000000o[this.O00000Oo - 2] = '\"';
                i = i13;
                z2 = true;
            } else {
                i2++;
                if (i2 > cArr2.length) {
                    O00000Oo(i2);
                }
                this.O00000Oo = i2;
                char[] cArr6 = this.f12980O000000o;
                i = i11 + 1;
                System.arraycopy(cArr6, i, cArr6, i11 + 2, i10 - i11);
                char[] cArr7 = this.f12980O000000o;
                cArr7[i11] = '\\';
                cArr7[i] = bdn.O00000oo[c];
                i10++;
            }
            i11 = i + 1;
            i3 = 0;
        }
        this.f12980O000000o[this.O00000Oo - 1] = ':';
    }

    private void O00000o(String str) {
        int i;
        String str2 = str;
        boolean[] zArr = bdn.O00000oO;
        int length = str.length();
        boolean z = true;
        int i2 = this.O00000Oo + length + 1;
        int i3 = 0;
        if (i2 > this.f12980O000000o.length) {
            if (this.O00000oO == null) {
                O00000Oo(i2);
            } else if (length == 0) {
                O000000o('\'');
                O000000o('\'');
                O000000o(':');
                return;
            } else {
                int i4 = 0;
                while (true) {
                    if (i4 < length) {
                        char charAt = str2.charAt(i4);
                        if (charAt < zArr.length && zArr[charAt]) {
                            break;
                        }
                        i4++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    O000000o('\'');
                }
                while (i3 < length) {
                    char charAt2 = str2.charAt(i3);
                    if (charAt2 >= zArr.length || !zArr[charAt2]) {
                        O000000o(charAt2);
                    } else {
                        O000000o('\\');
                        O000000o(bdn.O00000oo[charAt2]);
                    }
                    i3++;
                }
                if (z) {
                    O000000o('\'');
                }
                O000000o(':');
                return;
            }
        }
        if (length == 0) {
            int i5 = this.O00000Oo;
            if (i5 + 3 > this.f12980O000000o.length) {
                O00000Oo(i5 + 3);
            }
            char[] cArr = this.f12980O000000o;
            int i6 = this.O00000Oo;
            this.O00000Oo = i6 + 1;
            cArr[i6] = '\'';
            int i7 = this.O00000Oo;
            this.O00000Oo = i7 + 1;
            cArr[i7] = '\'';
            int i8 = this.O00000Oo;
            this.O00000Oo = i8 + 1;
            cArr[i8] = ':';
            return;
        }
        int i9 = this.O00000Oo;
        int i10 = i9 + length;
        str2.getChars(0, length, this.f12980O000000o, i9);
        this.O00000Oo = i2;
        int i11 = i9;
        boolean z2 = false;
        while (i11 < i10) {
            char[] cArr2 = this.f12980O000000o;
            char c = cArr2[i11];
            if (c >= zArr.length || !zArr[c]) {
                i = i11;
            } else if (!z2) {
                i2 += 3;
                if (i2 > cArr2.length) {
                    O00000Oo(i2);
                }
                this.O00000Oo = i2;
                char[] cArr3 = this.f12980O000000o;
                int i12 = i11 + 1;
                System.arraycopy(cArr3, i12, cArr3, i11 + 3, (i10 - i11) - 1);
                char[] cArr4 = this.f12980O000000o;
                System.arraycopy(cArr4, i3, cArr4, 1, i11);
                char[] cArr5 = this.f12980O000000o;
                cArr5[i9] = '\'';
                cArr5[i12] = '\\';
                int i13 = i12 + 1;
                cArr5[i13] = bdn.O00000oo[c];
                i10 += 2;
                this.f12980O000000o[this.O00000Oo - 2] = '\'';
                i = i13;
                z2 = true;
            } else {
                i2++;
                if (i2 > cArr2.length) {
                    O00000Oo(i2);
                }
                this.O00000Oo = i2;
                char[] cArr6 = this.f12980O000000o;
                i = i11 + 1;
                System.arraycopy(cArr6, i, cArr6, i11 + 2, i10 - i11);
                char[] cArr7 = this.f12980O000000o;
                cArr7[i11] = '\\';
                cArr7[i] = bdn.O00000oo[c];
                i10++;
            }
            i11 = i + 1;
            i3 = 0;
        }
        this.f12980O000000o[i2 - 1] = ':';
    }

    public final void flush() {
        Writer writer = this.O00000oO;
        if (writer != null) {
            try {
                writer.write(this.f12980O000000o, 0, this.O00000Oo);
                this.O00000oO.flush();
                this.O00000Oo = 0;
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
    }

    private void O000000o(String str, char c, boolean z) {
        int i;
        int i2;
        char c2;
        int i3;
        int i4;
        String str2 = str;
        char c3 = c;
        if (str2 == null) {
            write("null");
            if (c3 != 0) {
                O000000o(c3);
                return;
            }
            return;
        }
        int length = str.length();
        int i5 = this.O00000Oo + length + 2;
        if (c3 != 0) {
            i5++;
        }
        int i6 = 0;
        if (i > this.f12980O000000o.length) {
            if (this.O00000oO != null) {
                O000000o('\"');
                while (i6 < str.length()) {
                    char charAt = str2.charAt(i6);
                    if (O000000o(SerializerFeature.BrowserCompatible)) {
                        if (charAt == 8 || charAt == 12 || charAt == 10 || charAt == 13 || charAt == 9 || charAt == '\"' || charAt == '/' || charAt == '\\') {
                            O000000o('\\');
                            O000000o(bdn.O00000oo[charAt]);
                            i6++;
                        } else {
                            if (charAt < ' ') {
                                O000000o('\\');
                                O000000o('u');
                                O000000o('0');
                                O000000o('0');
                                int i7 = charAt * 2;
                                O000000o(bdn.O0000O0o[i7]);
                                O000000o(bdn.O0000O0o[i7 + 1]);
                            } else if (charAt >= 127) {
                                O000000o('\\');
                                O000000o('u');
                                O000000o(bdn.f12885O000000o[(charAt >>> 12) & 15]);
                                O000000o(bdn.f12885O000000o[(charAt >>> 8) & 15]);
                                O000000o(bdn.f12885O000000o[(charAt >>> 4) & 15]);
                                O000000o(bdn.f12885O000000o[charAt & 15]);
                            }
                            i6++;
                        }
                    } else if ((charAt < bdn.O00000o.length && bdn.O00000o[charAt]) || (charAt == '/' && O000000o(SerializerFeature.WriteSlashAsSpecial))) {
                        O000000o('\\');
                        O000000o(bdn.O00000oo[charAt]);
                        i6++;
                    }
                    O000000o(charAt);
                    i6++;
                }
                O000000o('\"');
                if (c3 != 0) {
                    O000000o(c3);
                    return;
                }
                return;
            }
            O00000Oo(i);
        }
        int i8 = this.O00000Oo;
        int i9 = i8 + 1;
        int i10 = i9 + length;
        char[] cArr = this.f12980O000000o;
        cArr[i8] = '\"';
        str2.getChars(0, length, cArr, i9);
        this.O00000Oo = i;
        if (O000000o(SerializerFeature.BrowserCompatible)) {
            int i11 = -1;
            for (int i12 = i9; i12 < i10; i12++) {
                char c4 = this.f12980O000000o[i12];
                if (c4 == '\"' || c4 == '/' || c4 == '\\' || c4 == 8 || c4 == 12 || c4 == 10 || c4 == 13 || c4 == 9) {
                    i++;
                } else if (c4 >= ' ' && c4 < 127) {
                } else {
                    i += 5;
                }
                i11 = i12;
            }
            if (i > this.f12980O000000o.length) {
                O00000Oo(i);
            }
            this.O00000Oo = i;
            while (i11 >= i9) {
                char[] cArr2 = this.f12980O000000o;
                char c5 = cArr2[i11];
                if (c5 == 8 || c5 == 12 || c5 == 10 || c5 == 13 || c5 == 9) {
                    char[] cArr3 = this.f12980O000000o;
                    int i13 = i11 + 1;
                    System.arraycopy(cArr3, i13, cArr3, i11 + 2, (i10 - i11) - 1);
                    char[] cArr4 = this.f12980O000000o;
                    cArr4[i11] = '\\';
                    cArr4[i13] = bdn.O00000oo[c5];
                } else if (c5 == '\"' || c5 == '/' || c5 == '\\') {
                    char[] cArr5 = this.f12980O000000o;
                    int i14 = i11 + 1;
                    System.arraycopy(cArr5, i14, cArr5, i11 + 2, (i10 - i11) - 1);
                    char[] cArr6 = this.f12980O000000o;
                    cArr6[i11] = '\\';
                    cArr6[i14] = c5;
                } else {
                    if (c5 < ' ') {
                        int i15 = i11 + 1;
                        System.arraycopy(cArr2, i15, cArr2, i11 + 6, (i10 - i11) - 1);
                        char[] cArr7 = this.f12980O000000o;
                        cArr7[i11] = '\\';
                        cArr7[i15] = 'u';
                        cArr7[i11 + 2] = '0';
                        cArr7[i11 + 3] = '0';
                        int i16 = c5 * 2;
                        cArr7[i11 + 4] = bdn.O0000O0o[i16];
                        this.f12980O000000o[i11 + 5] = bdn.O0000O0o[i16 + 1];
                    } else if (c5 >= 127) {
                        int i17 = i11 + 1;
                        System.arraycopy(cArr2, i17, cArr2, i11 + 6, (i10 - i11) - 1);
                        char[] cArr8 = this.f12980O000000o;
                        cArr8[i11] = '\\';
                        cArr8[i17] = 'u';
                        cArr8[i11 + 2] = bdn.f12885O000000o[(c5 >>> 12) & 15];
                        this.f12980O000000o[i11 + 3] = bdn.f12885O000000o[(c5 >>> 8) & 15];
                        this.f12980O000000o[i11 + 4] = bdn.f12885O000000o[(c5 >>> 4) & 15];
                        this.f12980O000000o[i11 + 5] = bdn.f12885O000000o[c5 & 15];
                    } else {
                        i11--;
                    }
                    i10 += 5;
                    i11--;
                }
                i10++;
                i11--;
            }
            if (c3 != 0) {
                char[] cArr9 = this.f12980O000000o;
                int i18 = this.O00000Oo;
                cArr9[i18 - 2] = '\"';
                cArr9[i18 - 1] = c3;
                return;
            }
            this.f12980O000000o[this.O00000Oo - 1] = '\"';
            return;
        }
        if (z) {
            int i19 = -1;
            c2 = 0;
            i2 = -1;
            for (int i20 = i9; i20 < i10; i20++) {
                char c6 = this.f12980O000000o[i20];
                if (c6 < ']' && c6 != ' ' && ((c6 < '0' || c6 == '\\') && ((c6 < bdn.O00000o.length && bdn.O00000o[c6]) || (c6 == '/' && O000000o(SerializerFeature.WriteSlashAsSpecial))))) {
                    i6++;
                    if (i2 == -1) {
                        i19 = i20;
                        i2 = i19;
                    } else {
                        i19 = i20;
                    }
                    c2 = c6;
                }
            }
            i3 = i19;
        } else {
            i3 = -1;
            c2 = 0;
            i2 = -1;
        }
        int i21 = i + i6;
        if (i21 > this.f12980O000000o.length) {
            O00000Oo(i21);
        }
        this.O00000Oo = i21;
        if (i6 == 1) {
            char[] cArr10 = this.f12980O000000o;
            int i22 = i3 + 1;
            System.arraycopy(cArr10, i22, cArr10, i3 + 2, (i10 - i3) - 1);
            char[] cArr11 = this.f12980O000000o;
            cArr11[i3] = '\\';
            cArr11[i22] = bdn.O00000oo[c2];
        } else if (i6 > 1) {
            for (int i23 = i2 - i9; i23 < str.length(); i23++) {
                char charAt2 = str2.charAt(i23);
                if ((charAt2 >= bdn.O00000o.length || !bdn.O00000o[charAt2]) && (charAt2 != '/' || !O000000o(SerializerFeature.WriteSlashAsSpecial))) {
                    this.f12980O000000o[i2] = charAt2;
                    i4 = i2 + 1;
                } else {
                    char[] cArr12 = this.f12980O000000o;
                    int i24 = i2 + 1;
                    cArr12[i2] = '\\';
                    cArr12[i24] = bdn.O00000oo[charAt2];
                    i4 = i24 + 1;
                }
            }
        }
        if (c3 != 0) {
            char[] cArr13 = this.f12980O000000o;
            int i25 = this.O00000Oo;
            cArr13[i25 - 2] = '\"';
            cArr13[i25 - 1] = c3;
            return;
        }
        this.f12980O000000o[this.O00000Oo - 1] = '\"';
    }
}
