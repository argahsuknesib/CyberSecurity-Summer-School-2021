package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class aje extends aio {
    protected static final char[] O0000O0o = air.O00000o();
    protected static final int[] O0000OOo = air.O00000o0();
    protected final Writer O0000Oo;
    protected final ait O0000Oo0;
    protected int[] O0000OoO = O0000OOo;
    protected int O0000Ooo;
    protected int O0000o = 0;
    protected ain O0000o0;
    protected ais O0000o00;
    protected char[] O0000o0O;
    protected int O0000o0o = 0;
    protected char[] O0000oO;
    protected int O0000oO0;

    public aje(ait ait, int i, ail ail, Writer writer) {
        super(i, ail);
        this.O0000Oo0 = ait;
        this.O0000Oo = writer;
        this.O0000o0O = ait.O00000oO();
        this.O0000oO0 = this.O0000o0O.length;
        if (O000000o(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            this.O0000Ooo = 127;
        }
    }

    public final JsonGenerator O000000o(ais ais) {
        this.O0000o00 = ais;
        if (ais == null) {
            this.O0000OoO = O0000OOo;
        } else {
            this.O0000OoO = ais.O000000o();
        }
        return this;
    }

    public final void O000000o(String str) throws IOException, JsonGenerationException {
        int O000000o2 = this.O00000oO.O000000o(str);
        if (O000000o2 == 4) {
            O0000OOo("Can not write a field name, expecting a value");
        }
        boolean z = O000000o2 == 1;
        if (this.f3595O000000o != null) {
            if (z) {
                this.f3595O000000o.O00000o0(this);
            } else {
                this.f3595O000000o.O0000OOo(this);
            }
            if (O000000o(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
                if (this.O0000o >= this.O0000oO0) {
                    O0000Ooo();
                }
                char[] cArr = this.O0000o0O;
                int i = this.O0000o;
                this.O0000o = i + 1;
                cArr[i] = '\"';
                O0000Oo0(str);
                if (this.O0000o >= this.O0000oO0) {
                    O0000Ooo();
                }
                char[] cArr2 = this.O0000o0O;
                int i2 = this.O0000o;
                this.O0000o = i2 + 1;
                cArr2[i2] = '\"';
                return;
            }
            O0000Oo0(str);
            return;
        }
        if (this.O0000o + 1 >= this.O0000oO0) {
            O0000Ooo();
        }
        if (z) {
            char[] cArr3 = this.O0000o0O;
            int i3 = this.O0000o;
            this.O0000o = i3 + 1;
            cArr3[i3] = ',';
        }
        if (!O000000o(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            O0000Oo0(str);
            return;
        }
        char[] cArr4 = this.O0000o0O;
        int i4 = this.O0000o;
        this.O0000o = i4 + 1;
        cArr4[i4] = '\"';
        O0000Oo0(str);
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr5 = this.O0000o0O;
        int i5 = this.O0000o;
        this.O0000o = i5 + 1;
        cArr5[i5] = '\"';
    }

    public final void O000000o(String str, String str2) throws IOException, JsonGenerationException {
        O000000o(str);
        O00000Oo(str2);
    }

    public final void O000000o(ain ain) throws IOException, JsonGenerationException {
        int O000000o2 = this.O00000oO.O000000o(ain.O000000o());
        if (O000000o2 == 4) {
            O0000OOo("Can not write a field name, expecting a value");
        }
        boolean z = O000000o2 == 1;
        if (this.f3595O000000o != null) {
            if (z) {
                this.f3595O000000o.O00000o0(this);
            } else {
                this.f3595O000000o.O0000OOo(this);
            }
            char[] O00000Oo = ain.O00000Oo();
            if (O000000o(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
                if (this.O0000o >= this.O0000oO0) {
                    O0000Ooo();
                }
                char[] cArr = this.O0000o0O;
                int i = this.O0000o;
                this.O0000o = i + 1;
                cArr[i] = '\"';
                O000000o(O00000Oo, O00000Oo.length);
                if (this.O0000o >= this.O0000oO0) {
                    O0000Ooo();
                }
                char[] cArr2 = this.O0000o0O;
                int i2 = this.O0000o;
                this.O0000o = i2 + 1;
                cArr2[i2] = '\"';
                return;
            }
            O000000o(O00000Oo, O00000Oo.length);
            return;
        }
        if (this.O0000o + 1 >= this.O0000oO0) {
            O0000Ooo();
        }
        if (z) {
            char[] cArr3 = this.O0000o0O;
            int i3 = this.O0000o;
            this.O0000o = i3 + 1;
            cArr3[i3] = ',';
        }
        char[] O00000Oo2 = ain.O00000Oo();
        if (!O000000o(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            O000000o(O00000Oo2, O00000Oo2.length);
            return;
        }
        char[] cArr4 = this.O0000o0O;
        int i4 = this.O0000o;
        this.O0000o = i4 + 1;
        cArr4[i4] = '\"';
        int length = O00000Oo2.length;
        int i5 = this.O0000o;
        if (i5 + length + 1 >= this.O0000oO0) {
            O000000o(O00000Oo2, length);
            if (this.O0000o >= this.O0000oO0) {
                O0000Ooo();
            }
            char[] cArr5 = this.O0000o0O;
            int i6 = this.O0000o;
            this.O0000o = i6 + 1;
            cArr5[i6] = '\"';
            return;
        }
        System.arraycopy(O00000Oo2, 0, cArr4, i5, length);
        this.O0000o += length;
        char[] cArr6 = this.O0000o0O;
        int i7 = this.O0000o;
        this.O0000o = i7 + 1;
        cArr6[i7] = '\"';
    }

    public final void O00000Oo() throws IOException, JsonGenerationException {
        O0000O0o("start an array");
        this.O00000oO = this.O00000oO.O0000OOo();
        if (this.f3595O000000o != null) {
            this.f3595O000000o.O00000oO(this);
            return;
        }
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr = this.O0000o0O;
        int i = this.O0000o;
        this.O0000o = i + 1;
        cArr[i] = '[';
    }

    public final void O00000o0() throws IOException, JsonGenerationException {
        if (!this.O00000oO.O000000o()) {
            O0000OOo("Current context not an ARRAY but " + this.O00000oO.O00000o());
        }
        if (this.f3595O000000o != null) {
            this.f3595O000000o.O00000Oo(this, this.O00000oO.O00000oO());
        } else {
            if (this.O0000o >= this.O0000oO0) {
                O0000Ooo();
            }
            char[] cArr = this.O0000o0O;
            int i = this.O0000o;
            this.O0000o = i + 1;
            cArr[i] = ']';
        }
        this.O00000oO = this.O00000oO.O0000Oo();
    }

    public final void O00000o() throws IOException, JsonGenerationException {
        O0000O0o("start an object");
        this.O00000oO = this.O00000oO.O0000Oo0();
        if (this.f3595O000000o != null) {
            this.f3595O000000o.O00000Oo(this);
            return;
        }
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr = this.O0000o0O;
        int i = this.O0000o;
        this.O0000o = i + 1;
        cArr[i] = '{';
    }

    public final void O00000oO() throws IOException, JsonGenerationException {
        if (!this.O00000oO.O00000o0()) {
            O0000OOo("Current context not an object but " + this.O00000oO.O00000o());
        }
        this.O00000oO = this.O00000oO.O0000Oo();
        if (this.f3595O000000o != null) {
            this.f3595O000000o.O000000o(this, this.O00000oO.O00000oO());
            return;
        }
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr = this.O0000o0O;
        int i = this.O0000o;
        this.O0000o = i + 1;
        cArr[i] = '}';
    }

    public final void O00000Oo(String str) throws IOException, JsonGenerationException {
        O0000O0o("write text value");
        if (str == null) {
            O0000Oo();
            return;
        }
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr = this.O0000o0O;
        int i = this.O0000o;
        this.O0000o = i + 1;
        cArr[i] = '\"';
        O0000Oo0(str);
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr2 = this.O0000o0O;
        int i2 = this.O0000o;
        this.O0000o = i2 + 1;
        cArr2[i2] = '\"';
    }

    public final void O000000o(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        char c;
        char c2;
        char[] cArr2 = cArr;
        O0000O0o("write text value");
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr3 = this.O0000o0O;
        int i3 = this.O0000o;
        this.O0000o = i3 + 1;
        cArr3[i3] = '\"';
        if (this.O0000o00 == null) {
            int i4 = this.O0000Ooo;
            if (i4 == 0) {
                int i5 = i2 + i;
                int[] iArr = this.O0000OoO;
                int length = iArr.length;
                int i6 = i;
                while (i6 < i5) {
                    int i7 = i6;
                    do {
                        char c3 = cArr2[i7];
                        if (c3 < length && iArr[c3] != 0) {
                            break;
                        }
                        i7++;
                    } while (i7 < i5);
                    int i8 = i7 - i6;
                    if (i8 < 32) {
                        if (this.O0000o + i8 > this.O0000oO0) {
                            O0000Ooo();
                        }
                        if (i8 > 0) {
                            System.arraycopy(cArr2, i6, this.O0000o0O, this.O0000o, i8);
                            this.O0000o += i8;
                        }
                    } else {
                        O0000Ooo();
                        this.O0000Oo.write(cArr2, i6, i8);
                    }
                    if (i7 >= i5) {
                        break;
                    }
                    i6 = i7 + 1;
                    char c4 = cArr2[i7];
                    O00000Oo(c4, iArr[c4]);
                }
            } else {
                int i9 = i2 + i;
                int[] iArr2 = this.O0000OoO;
                int min = Math.min(iArr2.length, i4 + 1);
                int i10 = i;
                int i11 = 0;
                while (i10 < i9) {
                    int i12 = i11;
                    int i13 = i10;
                    while (true) {
                        c = cArr2[i13];
                        if (c >= min) {
                            if (c > i4) {
                                i12 = -1;
                                break;
                            }
                        } else {
                            i12 = iArr2[c];
                            if (i12 != 0) {
                                break;
                            }
                        }
                        i13++;
                        if (i13 >= i9) {
                            break;
                        }
                    }
                    int i14 = i13 - i10;
                    if (i14 < 32) {
                        if (this.O0000o + i14 > this.O0000oO0) {
                            O0000Ooo();
                        }
                        if (i14 > 0) {
                            System.arraycopy(cArr2, i10, this.O0000o0O, this.O0000o, i14);
                            this.O0000o += i14;
                        }
                    } else {
                        O0000Ooo();
                        this.O0000Oo.write(cArr2, i10, i14);
                    }
                    if (i13 >= i9) {
                        break;
                    }
                    i10 = i13 + 1;
                    O00000Oo(c, i12);
                    i11 = i12;
                }
            }
        } else {
            int i15 = i2 + i;
            int[] iArr3 = this.O0000OoO;
            int i16 = this.O0000Ooo;
            if (i16 <= 0) {
                i16 = 65535;
            }
            int min2 = Math.min(iArr3.length, i16 + 1);
            ais ais = this.O0000o00;
            int i17 = i;
            int i18 = 0;
            while (i17 < i15) {
                int i19 = i18;
                int i20 = i17;
                while (true) {
                    c2 = cArr2[i20];
                    if (c2 >= min2) {
                        if (c2 <= i16) {
                            ain O00000Oo = ais.O00000Oo();
                            this.O0000o0 = O00000Oo;
                            if (O00000Oo != null) {
                                i19 = -2;
                                break;
                            }
                        } else {
                            i19 = -1;
                            break;
                        }
                    } else {
                        i19 = iArr3[c2];
                        if (i19 != 0) {
                            break;
                        }
                    }
                    i20++;
                    if (i20 >= i15) {
                        break;
                    }
                }
                int i21 = i20 - i17;
                if (i21 < 32) {
                    if (this.O0000o + i21 > this.O0000oO0) {
                        O0000Ooo();
                    }
                    if (i21 > 0) {
                        System.arraycopy(cArr2, i17, this.O0000o0O, this.O0000o, i21);
                        this.O0000o += i21;
                    }
                } else {
                    O0000Ooo();
                    this.O0000Oo.write(cArr2, i17, i21);
                }
                if (i20 >= i15) {
                    break;
                }
                i17 = i20 + 1;
                O00000Oo(c2, i19);
                i18 = i19;
            }
        }
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr4 = this.O0000o0O;
        int i22 = this.O0000o;
        this.O0000o = i22 + 1;
        cArr4[i22] = '\"';
    }

    public final void O00000Oo(ain ain) throws IOException, JsonGenerationException {
        O0000O0o("write text value");
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr = this.O0000o0O;
        int i = this.O0000o;
        this.O0000o = i + 1;
        cArr[i] = '\"';
        char[] O00000Oo = ain.O00000Oo();
        int length = O00000Oo.length;
        if (length < 32) {
            if (length > this.O0000oO0 - this.O0000o) {
                O0000Ooo();
            }
            System.arraycopy(O00000Oo, 0, this.O0000o0O, this.O0000o, length);
            this.O0000o += length;
        } else {
            O0000Ooo();
            this.O0000Oo.write(O00000Oo, 0, length);
        }
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr2 = this.O0000o0O;
        int i2 = this.O0000o;
        this.O0000o = i2 + 1;
        cArr2[i2] = '\"';
    }

    public final void O00000o0(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        int i = this.O0000oO0 - this.O0000o;
        if (i == 0) {
            O0000Ooo();
            i = this.O0000oO0 - this.O0000o;
        }
        if (i >= length) {
            str.getChars(0, length, this.O0000o0O, this.O0000o);
            this.O0000o += length;
            return;
        }
        int i2 = this.O0000oO0;
        int i3 = this.O0000o;
        int i4 = i2 - i3;
        str.getChars(0, i4, this.O0000o0O, i3);
        this.O0000o += i4;
        O0000Ooo();
        int length2 = str.length() - i4;
        while (true) {
            int i5 = this.O0000oO0;
            if (length2 > i5) {
                int i6 = i4 + i5;
                str.getChars(i4, i6, this.O0000o0O, 0);
                this.O0000o0o = 0;
                this.O0000o = i5;
                O0000Ooo();
                length2 -= i5;
                i4 = i6;
            } else {
                str.getChars(i4, i4 + length2, this.O0000o0O, 0);
                this.O0000o0o = 0;
                this.O0000o = length2;
                return;
            }
        }
    }

    public final void O000000o(char[] cArr, int i) throws IOException, JsonGenerationException {
        if (i < 32) {
            if (i > this.O0000oO0 - this.O0000o) {
                O0000Ooo();
            }
            System.arraycopy(cArr, 0, this.O0000o0O, this.O0000o, i);
            this.O0000o += i;
            return;
        }
        O0000Ooo();
        this.O0000Oo.write(cArr, 0, i);
    }

    public final void O000000o(char c) throws IOException, JsonGenerationException {
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr = this.O0000o0O;
        int i = this.O0000o;
        this.O0000o = i + 1;
        cArr[i] = c;
    }

    public final void O000000o(aii aii, byte[] bArr, int i) throws IOException, JsonGenerationException {
        O0000O0o("write binary value");
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr = this.O0000o0O;
        int i2 = this.O0000o;
        this.O0000o = i2 + 1;
        cArr[i2] = '\"';
        int i3 = 0;
        int i4 = i + 0;
        int i5 = i4 - 3;
        int i6 = this.O0000oO0 - 6;
        int i7 = aii.O00000oO >> 2;
        while (i3 <= i5) {
            if (this.O0000o > i6) {
                O0000Ooo();
            }
            int i8 = i3 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            byte b = (((bArr[i3] << 8) | (bArr[i8] & 255)) << 8) | (bArr[i9] & 255);
            char[] cArr2 = this.O0000o0O;
            int i11 = this.O0000o;
            int i12 = i11 + 1;
            cArr2[i11] = aii.f12388O000000o[(b >> 18) & 63];
            int i13 = i12 + 1;
            cArr2[i12] = aii.f12388O000000o[(b >> 12) & 63];
            int i14 = i13 + 1;
            cArr2[i13] = aii.f12388O000000o[(b >> 6) & 63];
            cArr2[i14] = aii.f12388O000000o[b & 63];
            this.O0000o = i14 + 1;
            i7--;
            if (i7 <= 0) {
                char[] cArr3 = this.O0000o0O;
                int i15 = this.O0000o;
                this.O0000o = i15 + 1;
                cArr3[i15] = '\\';
                int i16 = this.O0000o;
                this.O0000o = i16 + 1;
                cArr3[i16] = 'n';
                i7 = aii.O00000oO >> 2;
            }
            i3 = i10;
        }
        int i17 = i4 - i3;
        if (i17 > 0) {
            if (this.O0000o > i6) {
                O0000Ooo();
            }
            int i18 = i3 + 1;
            int i19 = bArr[i3] << 16;
            if (i17 == 2) {
                i19 |= (bArr[i18] & 255) << 8;
            }
            char[] cArr4 = this.O0000o0O;
            int i20 = this.O0000o;
            int i21 = i20 + 1;
            cArr4[i20] = aii.f12388O000000o[(i19 >> 18) & 63];
            int i22 = i21 + 1;
            cArr4[i21] = aii.f12388O000000o[(i19 >> 12) & 63];
            if (aii.O00000o0) {
                int i23 = i22 + 1;
                cArr4[i22] = i17 == 2 ? aii.f12388O000000o[(i19 >> 6) & 63] : aii.O00000o;
                i22 = i23 + 1;
                cArr4[i23] = aii.O00000o;
            } else if (i17 == 2) {
                cArr4[i22] = aii.f12388O000000o[(i19 >> 6) & 63];
                i22++;
            }
            this.O0000o = i22;
        }
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr5 = this.O0000o0O;
        int i24 = this.O0000o;
        this.O0000o = i24 + 1;
        cArr5[i24] = '\"';
    }

    public final void O000000o(int i) throws IOException, JsonGenerationException {
        O0000O0o("write number");
        if (this.O00000o) {
            if (this.O0000o + 13 >= this.O0000oO0) {
                O0000Ooo();
            }
            char[] cArr = this.O0000o0O;
            int i2 = this.O0000o;
            this.O0000o = i2 + 1;
            cArr[i2] = '\"';
            this.O0000o = aix.O000000o(i, cArr, this.O0000o);
            char[] cArr2 = this.O0000o0O;
            int i3 = this.O0000o;
            this.O0000o = i3 + 1;
            cArr2[i3] = '\"';
            return;
        }
        if (this.O0000o + 11 >= this.O0000oO0) {
            O0000Ooo();
        }
        this.O0000o = aix.O000000o(i, this.O0000o0O, this.O0000o);
    }

    public final void O000000o(long j) throws IOException, JsonGenerationException {
        O0000O0o("write number");
        if (this.O00000o) {
            if (this.O0000o + 23 >= this.O0000oO0) {
                O0000Ooo();
            }
            char[] cArr = this.O0000o0O;
            int i = this.O0000o;
            this.O0000o = i + 1;
            cArr[i] = '\"';
            this.O0000o = aix.O000000o(j, cArr, this.O0000o);
            char[] cArr2 = this.O0000o0O;
            int i2 = this.O0000o;
            this.O0000o = i2 + 1;
            cArr2[i2] = '\"';
            return;
        }
        if (this.O0000o + 21 >= this.O0000oO0) {
            O0000Ooo();
        }
        this.O0000o = aix.O000000o(j, this.O0000o0O, this.O0000o);
    }

    public final void O000000o(BigInteger bigInteger) throws IOException, JsonGenerationException {
        O0000O0o("write number");
        if (bigInteger == null) {
            O0000Oo();
        } else if (this.O00000o) {
            O00000Oo(bigInteger);
        } else {
            O00000o0(bigInteger.toString());
        }
    }

    public final void O000000o(double d) throws IOException, JsonGenerationException {
        if (this.O00000o || ((Double.isNaN(d) || Double.isInfinite(d)) && O000000o(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            O00000Oo(String.valueOf(d));
            return;
        }
        O0000O0o("write number");
        O00000o0(String.valueOf(d));
    }

    public final void O000000o(float f) throws IOException, JsonGenerationException {
        if (this.O00000o || ((Float.isNaN(f) || Float.isInfinite(f)) && O000000o(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            O00000Oo(String.valueOf(f));
            return;
        }
        O0000O0o("write number");
        O00000o0(String.valueOf(f));
    }

    public final void O000000o(BigDecimal bigDecimal) throws IOException, JsonGenerationException {
        O0000O0o("write number");
        if (bigDecimal == null) {
            O0000Oo();
        } else if (this.O00000o) {
            O00000Oo(bigDecimal);
        } else {
            O00000o0(bigDecimal.toString());
        }
    }

    public final void O00000oO(String str) throws IOException, JsonGenerationException {
        O0000O0o("write number");
        if (this.O00000o) {
            O00000Oo((Object) str);
        } else {
            O00000o0(str);
        }
    }

    private final void O00000Oo(Object obj) throws IOException {
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr = this.O0000o0O;
        int i = this.O0000o;
        this.O0000o = i + 1;
        cArr[i] = '\"';
        O00000o0(obj.toString());
        if (this.O0000o >= this.O0000oO0) {
            O0000Ooo();
        }
        char[] cArr2 = this.O0000o0O;
        int i2 = this.O0000o;
        this.O0000o = i2 + 1;
        cArr2[i2] = '\"';
    }

    public final void O000000o(boolean z) throws IOException, JsonGenerationException {
        int i;
        O0000O0o("write boolean value");
        if (this.O0000o + 5 >= this.O0000oO0) {
            O0000Ooo();
        }
        int i2 = this.O0000o;
        char[] cArr = this.O0000o0O;
        if (z) {
            cArr[i2] = 't';
            int i3 = i2 + 1;
            cArr[i3] = 'r';
            int i4 = i3 + 1;
            cArr[i4] = 'u';
            i = i4 + 1;
            cArr[i] = 'e';
        } else {
            cArr[i2] = 'f';
            int i5 = i2 + 1;
            cArr[i5] = 'a';
            int i6 = i5 + 1;
            cArr[i6] = 'l';
            int i7 = i6 + 1;
            cArr[i7] = 's';
            i = i7 + 1;
            cArr[i] = 'e';
        }
        this.O0000o = i + 1;
    }

    public final void O00000oo() throws IOException, JsonGenerationException {
        O0000O0o("write null value");
        O0000Oo();
    }

    public final void O0000O0o(String str) throws IOException, JsonGenerationException {
        char c;
        int O0000OoO2 = this.O00000oO.O0000OoO();
        if (O0000OoO2 == 5) {
            O0000OOo("Can not " + str + ", expecting field name");
        }
        if (this.f3595O000000o == null) {
            if (O0000OoO2 == 1) {
                c = ',';
            } else if (O0000OoO2 == 2) {
                c = ':';
            } else if (O0000OoO2 == 3) {
                c = ' ';
            } else {
                return;
            }
            if (this.O0000o >= this.O0000oO0) {
                O0000Ooo();
            }
            char[] cArr = this.O0000o0O;
            int i = this.O0000o;
            cArr[i] = c;
            this.O0000o = i + 1;
            return;
        }
        O00000Oo(O0000OoO2);
    }

    private void O00000Oo(int i) throws IOException, JsonGenerationException {
        if (i != 0) {
            if (i == 1) {
                this.f3595O000000o.O00000oo(this);
            } else if (i == 2) {
                this.f3595O000000o.O00000o(this);
            } else if (i != 3) {
                O0000Oo0();
            } else {
                this.f3595O000000o.O000000o(this);
            }
        } else if (this.O00000oO.O000000o()) {
            this.f3595O000000o.O0000O0o(this);
        } else if (this.O00000oO.O00000o0()) {
            this.f3595O000000o.O0000OOo(this);
        }
    }

    public final void O0000O0o() throws IOException {
        O0000Ooo();
        if (this.O0000Oo != null && O000000o(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this.O0000Oo.flush();
        }
    }

    public final void close() throws IOException {
        super.close();
        if (this.O0000o0O != null && O000000o(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                ajc O0000OOo2 = O0000OOo();
                if (!O0000OOo2.O000000o()) {
                    if (!O0000OOo2.O00000o0()) {
                        break;
                    }
                    O00000oO();
                } else {
                    O00000o0();
                }
            }
        }
        O0000Ooo();
        if (this.O0000Oo != null) {
            if (this.O0000Oo0.O00000Oo() || O000000o(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                this.O0000Oo.close();
            } else if (O000000o(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                this.O0000Oo.flush();
            }
        }
        char[] cArr = this.O0000o0O;
        if (cArr != null) {
            this.O0000o0O = null;
            this.O0000Oo0.O00000Oo(cArr);
        }
    }

    private void O0000Oo0(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        int i = this.O0000oO0;
        if (length > i) {
            O0000Oo(str);
            return;
        }
        if (this.O0000o + length > i) {
            O0000Ooo();
        }
        str.getChars(0, length, this.O0000o0O, this.O0000o);
        if (this.O0000o00 != null) {
            O00000oO(length);
            return;
        }
        int i2 = this.O0000Ooo;
        if (i2 != 0) {
            O000000o(length, i2);
        } else {
            O00000o0(length);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        r2 = r6.O0000o0O;
        r3 = r6.O0000o;
        r6.O0000o = r3 + 1;
        r2 = r2[r3];
        O000000o(r2, r7[r2]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r4 = r6.O0000o0o;
        r3 = r3 - r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        if (r3 <= 0) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r6.O0000Oo.write(r2, r4, r3);
     */
    private void O00000o0(int i) throws IOException, JsonGenerationException {
        int i2 = this.O0000o + i;
        int[] iArr = this.O0000OoO;
        int length = iArr.length;
        while (this.O0000o < i2) {
            while (true) {
                char[] cArr = this.O0000o0O;
                int i3 = this.O0000o;
                char c = cArr[i3];
                if (c < length && iArr[c] != 0) {
                    break;
                }
                int i4 = this.O0000o + 1;
                this.O0000o = i4;
                if (i4 >= i2) {
                    return;
                }
            }
        }
    }

    private void O0000Oo(String str) throws IOException, JsonGenerationException {
        O0000Ooo();
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = this.O0000oO0;
            if (i + i2 > length) {
                i2 = length - i;
            }
            int i3 = i + i2;
            str.getChars(i, i3, this.O0000o0O, 0);
            if (this.O0000o00 != null) {
                O00000oo(i2);
            } else {
                int i4 = this.O0000Ooo;
                if (i4 != 0) {
                    O00000Oo(i2, i4);
                } else {
                    O00000o(i2);
                }
            }
            if (i3 < length) {
                i = i3;
            } else {
                return;
            }
        }
    }

    private final void O00000o(int i) throws IOException, JsonGenerationException {
        char c;
        int[] iArr = this.O0000OoO;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            do {
                c = this.O0000o0O[i2];
                if (c < length && iArr[c] != 0) {
                    break;
                }
                i2++;
            } while (i2 < i);
            int i4 = i2 - i3;
            if (i4 > 0) {
                this.O0000Oo.write(this.O0000o0O, i3, i4);
                if (i2 >= i) {
                    return;
                }
            }
            i2++;
            i3 = O000000o(this.O0000o0O, i2, i, c, iArr[c]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040 A[SYNTHETIC] */
    private void O000000o(int i, int i2) throws IOException, JsonGenerationException {
        char c;
        int i3;
        int i4;
        int i5 = this.O0000o + i;
        int[] iArr = this.O0000OoO;
        int min = Math.min(iArr.length, i2 + 1);
        while (this.O0000o < i5) {
            while (true) {
                c = this.O0000o0O[this.O0000o];
                if (c < min) {
                    i4 = iArr[c];
                    if (i4 != 0) {
                        break;
                    }
                    i3 = this.O0000o + 1;
                    this.O0000o = i3;
                    if (i3 >= i5) {
                        return;
                    }
                } else {
                    if (c > i2) {
                        i4 = -1;
                        break;
                    }
                    i3 = this.O0000o + 1;
                    this.O0000o = i3;
                    if (i3 >= i5) {
                    }
                }
            }
            int i6 = this.O0000o;
            int i7 = this.O0000o0o;
            int i8 = i6 - i7;
            if (i8 > 0) {
                this.O0000Oo.write(this.O0000o0O, i7, i8);
            }
            this.O0000o++;
            O000000o(c, i4);
        }
    }

    private final void O00000Oo(int i, int i2) throws IOException, JsonGenerationException {
        char c;
        int[] iArr = this.O0000OoO;
        int min = Math.min(iArr.length, i2 + 1);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            while (true) {
                c = this.O0000o0O[i3];
                if (c >= min) {
                    if (c > i2) {
                        i5 = -1;
                        break;
                    }
                } else {
                    i5 = iArr[c];
                    if (i5 != 0) {
                        break;
                    }
                }
                i3++;
                if (i3 >= i) {
                    break;
                }
            }
            int i6 = i3 - i4;
            if (i6 > 0) {
                this.O0000Oo.write(this.O0000o0O, i4, i6);
                if (i3 >= i) {
                    return;
                }
            }
            i3++;
            i4 = O000000o(this.O0000o0O, i3, i, c, i5);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053 A[SYNTHETIC] */
    private void O00000oO(int i) throws IOException, JsonGenerationException {
        char c;
        int i2;
        int i3;
        int i4 = this.O0000o + i;
        int[] iArr = this.O0000OoO;
        int i5 = this.O0000Ooo;
        if (i5 <= 0) {
            i5 = 65535;
        }
        int min = Math.min(iArr.length, i5 + 1);
        ais ais = this.O0000o00;
        while (this.O0000o < i4) {
            while (true) {
                c = this.O0000o0O[this.O0000o];
                if (c < min) {
                    i3 = iArr[c];
                    if (i3 != 0) {
                        break;
                    }
                    i2 = this.O0000o + 1;
                    this.O0000o = i2;
                    if (i2 >= i4) {
                        return;
                    }
                } else if (c > i5) {
                    i3 = -1;
                    break;
                } else {
                    ain O00000Oo = ais.O00000Oo();
                    this.O0000o0 = O00000Oo;
                    if (O00000Oo != null) {
                        i3 = -2;
                        break;
                    }
                    i2 = this.O0000o + 1;
                    this.O0000o = i2;
                    if (i2 >= i4) {
                    }
                }
            }
            int i6 = this.O0000o;
            int i7 = this.O0000o0o;
            int i8 = i6 - i7;
            if (i8 > 0) {
                this.O0000Oo.write(this.O0000o0O, i7, i8);
            }
            this.O0000o++;
            O000000o(c, i3);
        }
    }

    private final void O00000oo(int i) throws IOException, JsonGenerationException {
        char c;
        int[] iArr = this.O0000OoO;
        int i2 = this.O0000Ooo;
        if (i2 <= 0) {
            i2 = 65535;
        }
        int min = Math.min(iArr.length, i2 + 1);
        ais ais = this.O0000o00;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            while (true) {
                c = this.O0000o0O[i3];
                if (c >= min) {
                    if (c <= i2) {
                        ain O00000Oo = ais.O00000Oo();
                        this.O0000o0 = O00000Oo;
                        if (O00000Oo != null) {
                            i5 = -2;
                            break;
                        }
                    } else {
                        i5 = -1;
                        break;
                    }
                } else {
                    i5 = iArr[c];
                    if (i5 != 0) {
                        break;
                    }
                }
                i3++;
                if (i3 >= i) {
                    break;
                }
            }
            int i6 = i3 - i4;
            if (i6 > 0) {
                this.O0000Oo.write(this.O0000o0O, i4, i6);
                if (i3 >= i) {
                    return;
                }
            }
            i3++;
            i4 = O000000o(this.O0000o0O, i3, i, c, i5);
        }
    }

    private final void O0000Oo() throws IOException {
        if (this.O0000o + 4 >= this.O0000oO0) {
            O0000Ooo();
        }
        int i = this.O0000o;
        char[] cArr = this.O0000o0O;
        cArr[i] = 'n';
        int i2 = i + 1;
        cArr[i2] = 'u';
        int i3 = i2 + 1;
        cArr[i3] = 'l';
        int i4 = i3 + 1;
        cArr[i4] = 'l';
        this.O0000o = i4 + 1;
    }

    private final void O000000o(char c, int i) throws IOException, JsonGenerationException {
        String str;
        int i2;
        if (i >= 0) {
            int i3 = this.O0000o;
            if (i3 >= 2) {
                int i4 = i3 - 2;
                this.O0000o0o = i4;
                char[] cArr = this.O0000o0O;
                cArr[i4] = '\\';
                cArr[i4 + 1] = (char) i;
                return;
            }
            char[] cArr2 = this.O0000oO;
            if (cArr2 == null) {
                cArr2 = O0000OoO();
            }
            this.O0000o0o = this.O0000o;
            cArr2[1] = (char) i;
            this.O0000Oo.write(cArr2, 0, 2);
        } else if (i != -2) {
            int i5 = this.O0000o;
            if (i5 >= 6) {
                char[] cArr3 = this.O0000o0O;
                int i6 = i5 - 6;
                this.O0000o0o = i6;
                cArr3[i6] = '\\';
                int i7 = i6 + 1;
                cArr3[i7] = 'u';
                if (c > 255) {
                    int i8 = (c >> 8) & 255;
                    int i9 = i7 + 1;
                    char[] cArr4 = O0000O0o;
                    cArr3[i9] = cArr4[i8 >> 4];
                    i2 = i9 + 1;
                    cArr3[i2] = cArr4[i8 & 15];
                    c = (char) (c & 255);
                } else {
                    int i10 = i7 + 1;
                    cArr3[i10] = '0';
                    i2 = i10 + 1;
                    cArr3[i2] = '0';
                }
                int i11 = i2 + 1;
                char[] cArr5 = O0000O0o;
                cArr3[i11] = cArr5[c >> 4];
                cArr3[i11 + 1] = cArr5[c & 15];
                return;
            }
            char[] cArr6 = this.O0000oO;
            if (cArr6 == null) {
                cArr6 = O0000OoO();
            }
            this.O0000o0o = this.O0000o;
            if (c > 255) {
                int i12 = (c >> 8) & 255;
                char c2 = c & 255;
                char[] cArr7 = O0000O0o;
                cArr6[10] = cArr7[i12 >> 4];
                cArr6[11] = cArr7[i12 & 15];
                cArr6[12] = cArr7[c2 >> 4];
                cArr6[13] = cArr7[c2 & 15];
                this.O0000Oo.write(cArr6, 8, 6);
                return;
            }
            char[] cArr8 = O0000O0o;
            cArr6[6] = cArr8[c >> 4];
            cArr6[7] = cArr8[c & 15];
            this.O0000Oo.write(cArr6, 2, 6);
        } else {
            ain ain = this.O0000o0;
            if (ain == null) {
                str = this.O0000o00.O00000Oo().O000000o();
            } else {
                str = ain.O000000o();
                this.O0000o0 = null;
            }
            int length = str.length();
            int i13 = this.O0000o;
            if (i13 >= length) {
                int i14 = i13 - length;
                this.O0000o0o = i14;
                str.getChars(0, length, this.O0000o0O, i14);
                return;
            }
            this.O0000o0o = i13;
            this.O0000Oo.write(str);
        }
    }

    private final int O000000o(char[] cArr, int i, int i2, char c, int i3) throws IOException, JsonGenerationException {
        String str;
        int i4;
        if (i3 >= 0) {
            if (i <= 1 || i >= i2) {
                char[] cArr2 = this.O0000oO;
                if (cArr2 == null) {
                    cArr2 = O0000OoO();
                }
                cArr2[1] = (char) i3;
                this.O0000Oo.write(cArr2, 0, 2);
                return i;
            }
            int i5 = i - 2;
            cArr[i5] = '\\';
            cArr[i5 + 1] = (char) i3;
            return i5;
        } else if (i3 == -2) {
            ain ain = this.O0000o0;
            if (ain == null) {
                str = this.O0000o00.O00000Oo().O000000o();
            } else {
                str = ain.O000000o();
                this.O0000o0 = null;
            }
            int length = str.length();
            if (i < length || i >= i2) {
                this.O0000Oo.write(str);
                return i;
            }
            int i6 = i - length;
            str.getChars(0, length, cArr, i6);
            return i6;
        } else if (i <= 5 || i >= i2) {
            char[] cArr3 = this.O0000oO;
            if (cArr3 == null) {
                cArr3 = O0000OoO();
            }
            this.O0000o0o = this.O0000o;
            if (c > 255) {
                int i7 = (c >> 8) & 255;
                char c2 = c & 255;
                char[] cArr4 = O0000O0o;
                cArr3[10] = cArr4[i7 >> 4];
                cArr3[11] = cArr4[i7 & 15];
                cArr3[12] = cArr4[c2 >> 4];
                cArr3[13] = cArr4[c2 & 15];
                this.O0000Oo.write(cArr3, 8, 6);
                return i;
            }
            char[] cArr5 = O0000O0o;
            cArr3[6] = cArr5[c >> 4];
            cArr3[7] = cArr5[c & 15];
            this.O0000Oo.write(cArr3, 2, 6);
            return i;
        } else {
            int i8 = i - 6;
            int i9 = i8 + 1;
            cArr[i8] = '\\';
            int i10 = i9 + 1;
            cArr[i9] = 'u';
            if (c > 255) {
                int i11 = (c >> 8) & 255;
                int i12 = i10 + 1;
                char[] cArr6 = O0000O0o;
                cArr[i10] = cArr6[i11 >> 4];
                i4 = i12 + 1;
                cArr[i12] = cArr6[i11 & 15];
                c = (char) (c & 255);
            } else {
                int i13 = i10 + 1;
                cArr[i10] = '0';
                i4 = i13 + 1;
                cArr[i13] = '0';
            }
            int i14 = i4 + 1;
            char[] cArr7 = O0000O0o;
            cArr[i4] = cArr7[c >> 4];
            cArr[i14] = cArr7[c & 15];
            return i14 - 5;
        }
    }

    private final void O00000Oo(char c, int i) throws IOException, JsonGenerationException {
        String str;
        int i2;
        if (i >= 0) {
            if (this.O0000o + 2 > this.O0000oO0) {
                O0000Ooo();
            }
            char[] cArr = this.O0000o0O;
            int i3 = this.O0000o;
            this.O0000o = i3 + 1;
            cArr[i3] = '\\';
            int i4 = this.O0000o;
            this.O0000o = i4 + 1;
            cArr[i4] = (char) i;
        } else if (i != -2) {
            if (this.O0000o + 2 > this.O0000oO0) {
                O0000Ooo();
            }
            int i5 = this.O0000o;
            char[] cArr2 = this.O0000o0O;
            int i6 = i5 + 1;
            cArr2[i5] = '\\';
            int i7 = i6 + 1;
            cArr2[i6] = 'u';
            if (c > 255) {
                int i8 = 255 & (c >> 8);
                int i9 = i7 + 1;
                char[] cArr3 = O0000O0o;
                cArr2[i7] = cArr3[i8 >> 4];
                i2 = i9 + 1;
                cArr2[i9] = cArr3[i8 & 15];
                c = (char) (c & 255);
            } else {
                int i10 = i7 + 1;
                cArr2[i7] = '0';
                i2 = i10 + 1;
                cArr2[i10] = '0';
            }
            int i11 = i2 + 1;
            char[] cArr4 = O0000O0o;
            cArr2[i2] = cArr4[c >> 4];
            cArr2[i11] = cArr4[c & 15];
            this.O0000o = i11;
        } else {
            ain ain = this.O0000o0;
            if (ain == null) {
                str = this.O0000o00.O00000Oo().O000000o();
            } else {
                str = ain.O000000o();
                this.O0000o0 = null;
            }
            int length = str.length();
            if (this.O0000o + length > this.O0000oO0) {
                O0000Ooo();
                if (length > this.O0000oO0) {
                    this.O0000Oo.write(str);
                    return;
                }
            }
            str.getChars(0, length, this.O0000o0O, this.O0000o);
            this.O0000o += length;
        }
    }

    private char[] O0000OoO() {
        char[] cArr = new char[14];
        cArr[0] = '\\';
        cArr[2] = '\\';
        cArr[3] = 'u';
        cArr[4] = '0';
        cArr[5] = '0';
        cArr[8] = '\\';
        cArr[9] = 'u';
        this.O0000oO = cArr;
        return cArr;
    }

    private void O0000Ooo() throws IOException {
        int i = this.O0000o;
        int i2 = this.O0000o0o;
        int i3 = i - i2;
        if (i3 > 0) {
            this.O0000o0o = 0;
            this.O0000o = 0;
            this.O0000Oo.write(this.O0000o0O, i2, i3);
        }
    }
}
