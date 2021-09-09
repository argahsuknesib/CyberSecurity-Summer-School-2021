package _m_j;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class aip extends aiq {
    static final BigInteger O0000oO = BigInteger.valueOf(-2147483648L);
    static final BigInteger O0000oOO = BigInteger.valueOf(2147483647L);
    static final BigInteger O0000oOo = BigInteger.valueOf(Long.MIN_VALUE);
    static final BigDecimal O0000oo = new BigDecimal(O0000oOo);
    static final BigInteger O0000oo0 = BigInteger.valueOf(Long.MAX_VALUE);
    static final BigDecimal O0000ooO = new BigDecimal(O0000oo0);
    static final BigDecimal O0000ooo = new BigDecimal(O0000oO);
    static final BigDecimal O00oOooO = new BigDecimal(O0000oOO);
    protected final ait O00000Oo;
    protected int O00000o = 0;
    protected boolean O00000o0;
    protected int O00000oO = 0;
    protected long O00000oo = 0;
    protected int O0000O0o = 1;
    protected int O0000OOo = 0;
    protected int O0000Oo = 1;
    protected long O0000Oo0 = 0;
    protected int O0000OoO = 0;
    protected ajb O0000Ooo;
    protected ajk O0000o = null;
    protected final ajo O0000o0;
    protected JsonToken O0000o00;
    protected char[] O0000o0O = null;
    protected boolean O0000o0o = false;
    protected byte[] O0000oO0;
    protected int O000O00o;
    protected long O000O0OO;
    protected double O000O0Oo;
    protected boolean O000O0o;
    protected BigDecimal O000O0o0;
    protected int O000O0oO;
    protected int O000O0oo;
    protected int O000OO00;
    protected BigInteger O00oOoOo;
    protected int O00oOooo = 0;

    /* access modifiers changed from: protected */
    public abstract boolean O000O0Oo() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void O00oOoOo() throws IOException;

    protected aip(ait ait, int i) {
        this.f3597O000000o = i;
        this.O00000Oo = ait;
        this.O0000o0 = ait.O00000o0();
        this.O0000Ooo = new ajb(null, 0, 1, 0);
    }

    public final String O00000oo() throws IOException, JsonParseException {
        if (this.O000OO0o == JsonToken.START_OBJECT || this.O000OO0o == JsonToken.START_ARRAY) {
            return this.O0000Ooo.O0000Oo0().O0000OOo();
        }
        return this.O0000Ooo.O0000OOo();
    }

    public void close() throws IOException {
        if (!this.O00000o0) {
            this.O00000o0 = true;
            try {
                O00oOoOo();
            } finally {
                O000O0o0();
            }
        }
    }

    public final JsonLocation O0000O0o() {
        Object O000000o2 = this.O00000Oo.O000000o();
        long j = this.O0000Oo0;
        int i = this.O0000Oo;
        int i2 = this.O0000OoO;
        if (i2 >= 0) {
            i2++;
        }
        return new JsonLocation(O000000o2, j, i, i2);
    }

    public final JsonLocation O0000OOo() {
        return new JsonLocation(this.O00000Oo.O000000o(), (this.O00000oo + ((long) this.O00000o)) - 1, this.O0000O0o, (this.O00000o - this.O0000OOo) + 1);
    }

    public final boolean O0000o0O() {
        if (this.O000OO0o == JsonToken.VALUE_STRING) {
            return true;
        }
        if (this.O000OO0o == JsonToken.FIELD_NAME) {
            return this.O0000o0o;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void O000O0OO() throws IOException {
        if (!O000O0Oo()) {
            O000OO00();
        }
    }

    /* access modifiers changed from: protected */
    public void O000O0o0() throws IOException {
        this.O0000o0.O000000o();
        char[] cArr = this.O0000o0O;
        if (cArr != null) {
            this.O0000o0O = null;
            this.O00000Oo.O00000o0(cArr);
        }
    }

    /* access modifiers changed from: protected */
    public final void O000O0o() throws JsonParseException {
        if (!this.O0000Ooo.O00000Oo()) {
            O00000o0(": expected close marker for " + this.O0000Ooo.O00000o() + " (from " + this.O0000Ooo.O000000o(this.O00000Oo.O000000o()) + ")");
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i, char c) throws JsonParseException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.O0000Ooo.O000000o(this.O00000Oo.O000000o()));
        String sb2 = sb.toString();
        O00000o("Unexpected close marker '" + ((char) i) + "': expected '" + c + "' (for " + this.O0000Ooo.O00000o() + " starting at " + sb2 + ")");
    }

    public final ajk O000O0oO() {
        ajk ajk = this.O0000o;
        if (ajk == null) {
            this.O0000o = new ajk();
        } else {
            ajk.O000000o();
        }
        return this.O0000o;
    }

    /* access modifiers changed from: protected */
    public final JsonToken O000000o(String str, double d) {
        ajo ajo = this.O0000o0;
        ajo.O00000Oo = null;
        ajo.O00000o0 = -1;
        ajo.O00000o = 0;
        ajo.O0000OOo = str;
        ajo.O0000Oo0 = null;
        if (ajo.O00000oO) {
            ajo.O00000Oo();
        }
        ajo.O0000O0o = 0;
        this.O000O0Oo = d;
        this.O00oOooo = 8;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public final Number O0000o0o() throws IOException, JsonParseException {
        if (this.O00oOooo == 0) {
            O00000o0(0);
        }
        if (this.O000OO0o == JsonToken.VALUE_NUMBER_INT) {
            int i = this.O00oOooo;
            if ((i & 1) != 0) {
                return Integer.valueOf(this.O000O00o);
            }
            if ((i & 2) != 0) {
                return Long.valueOf(this.O000O0OO);
            }
            if ((i & 4) != 0) {
                return this.O00oOoOo;
            }
            return this.O000O0o0;
        }
        int i2 = this.O00oOooo;
        if ((i2 & 16) != 0) {
            return this.O000O0o0;
        }
        if ((i2 & 8) == 0) {
            O000OO();
        }
        return Double.valueOf(this.O000O0Oo);
    }

    public final JsonParser.NumberType O0000o() throws IOException, JsonParseException {
        if (this.O00oOooo == 0) {
            O00000o0(0);
        }
        if (this.O000OO0o == JsonToken.VALUE_NUMBER_INT) {
            int i = this.O00oOooo;
            if ((i & 1) != 0) {
                return JsonParser.NumberType.INT;
            }
            if ((i & 2) != 0) {
                return JsonParser.NumberType.LONG;
            }
            return JsonParser.NumberType.BIG_INTEGER;
        } else if ((this.O00oOooo & 16) != 0) {
            return JsonParser.NumberType.BIG_DECIMAL;
        } else {
            return JsonParser.NumberType.DOUBLE;
        }
    }

    public final int O0000oOO() throws IOException, JsonParseException {
        int i = this.O00oOooo;
        if ((i & 1) == 0) {
            if (i == 0) {
                O00000o0(1);
            }
            int i2 = this.O00oOooo;
            if ((i2 & 1) == 0) {
                if ((i2 & 2) != 0) {
                    long j = this.O000O0OO;
                    int i3 = (int) j;
                    if (((long) i3) != j) {
                        O00000o("Numeric value (" + O0000OoO() + ") out of range of int");
                    }
                    this.O000O00o = i3;
                } else if ((i2 & 4) != 0) {
                    if (O0000oO.compareTo(this.O00oOoOo) > 0 || O0000oOO.compareTo(this.O00oOoOo) < 0) {
                        O000OOo0();
                    }
                    this.O000O00o = this.O00oOoOo.intValue();
                } else if ((i2 & 8) != 0) {
                    double d = this.O000O0Oo;
                    if (d < -2.147483648E9d || d > 2.147483647E9d) {
                        O000OOo0();
                    }
                    this.O000O00o = (int) this.O000O0Oo;
                } else if ((i2 & 16) != 0) {
                    if (O0000ooo.compareTo(this.O000O0o0) > 0 || O00oOooO.compareTo(this.O000O0o0) < 0) {
                        O000OOo0();
                    }
                    this.O000O00o = this.O000O0o0.intValue();
                } else {
                    O000OO();
                }
                this.O00oOooo |= 1;
            }
        }
        return this.O000O00o;
    }

    public final long O0000oOo() throws IOException, JsonParseException {
        int i = this.O00oOooo;
        if ((i & 2) == 0) {
            if (i == 0) {
                O00000o0(2);
            }
            int i2 = this.O00oOooo;
            if ((i2 & 2) == 0) {
                if ((i2 & 1) != 0) {
                    this.O000O0OO = (long) this.O000O00o;
                } else if ((i2 & 4) != 0) {
                    if (O0000oOo.compareTo(this.O00oOoOo) > 0 || O0000oo0.compareTo(this.O00oOoOo) < 0) {
                        O000OOo();
                    }
                    this.O000O0OO = this.O00oOoOo.longValue();
                } else if ((i2 & 8) != 0) {
                    double d = this.O000O0Oo;
                    if (d < -9.223372036854776E18d || d > 9.223372036854776E18d) {
                        O000OOo();
                    }
                    this.O000O0OO = (long) this.O000O0Oo;
                } else if ((i2 & 16) != 0) {
                    if (O0000oo.compareTo(this.O000O0o0) > 0 || O0000ooO.compareTo(this.O000O0o0) < 0) {
                        O000OOo();
                    }
                    this.O000O0OO = this.O000O0o0.longValue();
                } else {
                    O000OO();
                }
                this.O00oOooo |= 2;
            }
        }
        return this.O000O0OO;
    }

    public final BigInteger O0000oo0() throws IOException, JsonParseException {
        int i = this.O00oOooo;
        if ((i & 4) == 0) {
            if (i == 0) {
                O00000o0(4);
            }
            int i2 = this.O00oOooo;
            if ((i2 & 4) == 0) {
                if ((i2 & 16) != 0) {
                    this.O00oOoOo = this.O000O0o0.toBigInteger();
                } else if ((i2 & 2) != 0) {
                    this.O00oOoOo = BigInteger.valueOf(this.O000O0OO);
                } else if ((i2 & 1) != 0) {
                    this.O00oOoOo = BigInteger.valueOf((long) this.O000O00o);
                } else if ((i2 & 8) != 0) {
                    this.O00oOoOo = BigDecimal.valueOf(this.O000O0Oo).toBigInteger();
                } else {
                    O000OO();
                }
                this.O00oOooo |= 4;
            }
        }
        return this.O00oOoOo;
    }

    public final float O0000oo() throws IOException, JsonParseException {
        return (float) O0000ooO();
    }

    public final double O0000ooO() throws IOException, JsonParseException {
        int i = this.O00oOooo;
        if ((i & 8) == 0) {
            if (i == 0) {
                O00000o0(8);
            }
            if ((this.O00oOooo & 8) == 0) {
                O000OOOo();
            }
        }
        return this.O000O0Oo;
    }

    public final BigDecimal O0000ooo() throws IOException, JsonParseException {
        int i = this.O00oOooo;
        if ((i & 16) == 0) {
            if (i == 0) {
                O00000o0(16);
            }
            int i2 = this.O00oOooo;
            if ((i2 & 16) == 0) {
                if ((i2 & 8) != 0) {
                    this.O000O0o0 = new BigDecimal(O0000OoO());
                } else if ((i2 & 4) != 0) {
                    this.O000O0o0 = new BigDecimal(this.O00oOoOo);
                } else if ((i2 & 2) != 0) {
                    this.O000O0o0 = BigDecimal.valueOf(this.O000O0OO);
                } else if ((i2 & 1) != 0) {
                    this.O000O0o0 = BigDecimal.valueOf((long) this.O000O00o);
                } else {
                    O000OO();
                }
                this.O00oOooo |= 16;
            }
        }
        return this.O000O0o0;
    }

    private void O00000o0(int i) throws IOException, JsonParseException {
        if (this.O000OO0o == JsonToken.VALUE_NUMBER_INT) {
            char[] O00000oO2 = this.O0000o0.O00000oO();
            int O00000o2 = this.O0000o0.O00000o();
            int i2 = this.O000O0oO;
            if (this.O000O0o) {
                O00000o2++;
            }
            if (i2 <= 9) {
                int O000000o2 = aiw.O000000o(O00000oO2, O00000o2, i2);
                if (this.O000O0o) {
                    O000000o2 = -O000000o2;
                }
                this.O000O00o = O000000o2;
                this.O00oOooo = 1;
            } else if (i2 <= 18) {
                long O00000Oo2 = aiw.O00000Oo(O00000oO2, O00000o2, i2);
                if (this.O000O0o) {
                    O00000Oo2 = -O00000Oo2;
                }
                if (i2 == 10) {
                    if (this.O000O0o) {
                        if (O00000Oo2 >= -2147483648L) {
                            this.O000O00o = (int) O00000Oo2;
                            this.O00oOooo = 1;
                            return;
                        }
                    } else if (O00000Oo2 <= 2147483647L) {
                        this.O000O00o = (int) O00000Oo2;
                        this.O00oOooo = 1;
                        return;
                    }
                }
                this.O000O0OO = O00000Oo2;
                this.O00oOooo = 2;
            } else {
                O000000o(O00000oO2, O00000o2, i2);
            }
        } else if (this.O000OO0o == JsonToken.VALUE_NUMBER_FLOAT) {
            O00000o(i);
        } else {
            O00000o("Current token (" + this.O000OO0o + ") not numeric, can not use numeric value accessors");
        }
    }

    private final void O00000o(int i) throws IOException, JsonParseException {
        if (i == 16) {
            try {
                this.O000O0o0 = this.O0000o0.O0000OOo();
                this.O00oOooo = 16;
            } catch (NumberFormatException e) {
                O000000o("Malformed numeric value '" + this.O0000o0.O00000oo() + "'", e);
            }
        } else {
            this.O000O0Oo = aiw.O00000o(this.O0000o0.O00000oo());
            this.O00oOooo = 8;
        }
    }

    private final void O000000o(char[] cArr, int i, int i2) throws IOException, JsonParseException {
        String O00000oo2 = this.O0000o0.O00000oo();
        try {
            if (aiw.O000000o(cArr, i, i2, this.O000O0o)) {
                this.O000O0OO = Long.parseLong(O00000oo2);
                this.O00oOooo = 2;
                return;
            }
            this.O00oOoOo = new BigInteger(O00000oo2);
            this.O00oOooo = 4;
        } catch (NumberFormatException e) {
            O000000o("Malformed numeric value '" + O00000oo2 + "'", e);
        }
    }

    private void O000OOOo() throws IOException, JsonParseException {
        int i = this.O00oOooo;
        if ((i & 16) != 0) {
            this.O000O0Oo = this.O000O0o0.doubleValue();
        } else if ((i & 4) != 0) {
            this.O000O0Oo = this.O00oOoOo.doubleValue();
        } else if ((i & 2) != 0) {
            this.O000O0Oo = (double) this.O000O0OO;
        } else if ((i & 1) != 0) {
            this.O000O0Oo = (double) this.O000O00o;
        } else {
            O000OO();
        }
        this.O00oOooo |= 8;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i, String str) throws JsonParseException {
        O00000o(("Unexpected character (" + O00000Oo(i) + ") in numeric value") + ": " + str);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(String str) throws JsonParseException {
        O00000o("Invalid numeric value: ".concat(String.valueOf(str)));
    }

    private void O000OOo0() throws IOException, JsonParseException {
        O00000o("Numeric value (" + O0000OoO() + ") out of range of int (-2147483648 - 2147483647" + ")");
    }

    private void O000OOo() throws IOException, JsonParseException {
        O00000o("Numeric value (" + O0000OoO() + ") out of range of long (-9223372036854775808 - 9223372036854775807" + ")");
    }

    /* access modifiers changed from: protected */
    public char O000O0oo() throws IOException, JsonParseException {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aip.O000000o(_m_j.aii, int, int, java.lang.String):java.lang.IllegalArgumentException
     arg types: [_m_j.aii, char, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.aip.O000000o(boolean, int, int, int):com.fasterxml.jackson.core.JsonToken
      _m_j.aiq.O000000o(_m_j.aii, char, int, java.lang.String):void
      _m_j.aip.O000000o(_m_j.aii, int, int, java.lang.String):java.lang.IllegalArgumentException */
    /* access modifiers changed from: protected */
    public final int O000000o(aii aii, char c, int i) throws IOException, JsonParseException {
        if (c == '\\') {
            char O000O0oo2 = O000O0oo();
            if (O000O0oo2 <= ' ' && i == 0) {
                return -1;
            }
            int O00000Oo2 = aii.O00000Oo(O000O0oo2);
            if (O00000Oo2 >= 0) {
                return O00000Oo2;
            }
            throw O000000o(aii, (int) O000O0oo2, i, (String) null);
        }
        throw O000000o(aii, (int) c, i, (String) null);
    }

    protected static IllegalArgumentException O000000o(aii aii, int i, int i2, String str) throws IllegalArgumentException {
        String str2;
        if (i <= 32) {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(i) + ") as character #" + (i2 + 1) + " of 4-char base64 unit: can only used between units";
        } else if (aii.O000000o(i)) {
            str2 = "Unexpected padding character ('" + aii.O00000o + "') as character #" + (i2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(i) || Character.isISOControl(i)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(i) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + ((char) i) + "' (code 0x" + Integer.toHexString(i) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        return new IllegalArgumentException(str2);
    }

    /* access modifiers changed from: protected */
    public final JsonToken O000000o(boolean z, int i, int i2, int i3) {
        if (i2 > 0 || i3 > 0) {
            this.O000O0o = z;
            this.O000O0oO = i;
            this.O000O0oo = i2;
            this.O000OO00 = i3;
            this.O00oOooo = 0;
            return JsonToken.VALUE_NUMBER_FLOAT;
        }
        this.O000O0o = z;
        this.O000O0oO = i;
        this.O000O0oo = 0;
        this.O000OO00 = 0;
        this.O00oOooo = 0;
        return JsonToken.VALUE_NUMBER_INT;
    }
}
