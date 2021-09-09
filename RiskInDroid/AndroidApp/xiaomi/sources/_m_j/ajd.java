package _m_j;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.Reader;

public final class ajd extends aip {
    protected Reader O000OOOo;
    protected ail O000OOo;
    protected char[] O000OOo0;
    protected final ajg O000OOoO;
    protected boolean O000OOoo = false;

    public final Object O00oOooO() throws IOException, JsonParseException {
        return null;
    }

    public ajd(ait ait, int i, Reader reader, ail ail, ajg ajg) {
        super(ait, i);
        this.O000OOOo = reader;
        this.O000OOo0 = ait.O00000o();
        this.O000OOo = ail;
        this.O000OOoO = ajg;
    }

    public final ail O000000o() {
        return this.O000OOo;
    }

    public final boolean O000O0Oo() throws IOException {
        this.O00000oo += (long) this.O00000oO;
        this.O0000OOo -= this.O00000oO;
        Reader reader = this.O000OOOo;
        if (reader != null) {
            char[] cArr = this.O000OOo0;
            int read = reader.read(cArr, 0, cArr.length);
            if (read > 0) {
                this.O00000o = 0;
                this.O00000oO = read;
                return true;
            }
            O00oOoOo();
            if (read == 0) {
                throw new IOException("Reader returned 0 characters when trying to read " + this.O00000oO);
            }
        }
        return false;
    }

    private char O00000oO(String str) throws IOException, JsonParseException {
        if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
            O00000o0(str);
        }
        char[] cArr = this.O000OOo0;
        int i = this.O00000o;
        this.O00000o = i + 1;
        return cArr[i];
    }

    public final void O00oOoOo() throws IOException {
        if (this.O000OOOo != null) {
            if (this.O00000Oo.O00000Oo() || O000000o(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.O000OOOo.close();
            }
            this.O000OOOo = null;
        }
    }

    public final void O000O0o0() throws IOException {
        super.O000O0o0();
        char[] cArr = this.O000OOo0;
        if (cArr != null) {
            this.O000OOo0 = null;
            this.O00000Oo.O000000o(cArr);
        }
    }

    public final String O0000OoO() throws IOException, JsonParseException {
        JsonToken jsonToken = this.O000OO0o;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this.O000OOoo) {
                this.O000OOoo = false;
                O000OOo0();
            }
            return this.O0000o0.O00000oo();
        } else if (jsonToken == null) {
            return null;
        } else {
            int i = AnonymousClass1.f12399O000000o[jsonToken.ordinal()];
            if (i == 1) {
                return this.O0000Ooo.O0000OOo();
            }
            if (i == 2 || i == 3 || i == 4) {
                return this.O0000o0.O00000oo();
            }
            return jsonToken.asString();
        }
    }

    /* renamed from: _m_j.ajd$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12399O000000o = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|(3:11|12|14)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f12399O000000o[JsonToken.FIELD_NAME.ordinal()] = 1;
            f12399O000000o[JsonToken.VALUE_STRING.ordinal()] = 2;
            f12399O000000o[JsonToken.VALUE_NUMBER_INT.ordinal()] = 3;
            f12399O000000o[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 4;
            f12399O000000o[JsonToken.VALUE_TRUE.ordinal()] = 5;
            try {
                f12399O000000o[JsonToken.VALUE_FALSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final char[] O0000Ooo() throws IOException, JsonParseException {
        if (this.O000OO0o == null) {
            return null;
        }
        int i = AnonymousClass1.f12399O000000o[this.O000OO0o.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (!(i == 3 || i == 4)) {
                    return this.O000OO0o.asCharArray();
                }
            } else if (this.O000OOoo) {
                this.O000OOoo = false;
                O000OOo0();
            }
            return this.O0000o0.O00000oO();
        }
        if (!this.O0000o0o) {
            String O0000OOo = this.O0000Ooo.O0000OOo();
            int length = O0000OOo.length();
            if (this.O0000o0O == null) {
                this.O0000o0O = this.O00000Oo.O000000o(length);
            } else if (this.O0000o0O.length < length) {
                this.O0000o0O = new char[length];
            }
            O0000OOo.getChars(0, length, this.O0000o0O, 0);
            this.O0000o0o = true;
        }
        return this.O0000o0O;
    }

    public final int O0000o00() throws IOException, JsonParseException {
        if (this.O000OO0o == null) {
            return 0;
        }
        int i = AnonymousClass1.f12399O000000o[this.O000OO0o.ordinal()];
        if (i == 1) {
            return this.O0000Ooo.O0000OOo().length();
        }
        if (i != 2) {
            if (!(i == 3 || i == 4)) {
                return this.O000OO0o.asCharArray().length;
            }
        } else if (this.O000OOoo) {
            this.O000OOoo = false;
            O000OOo0();
        }
        return this.O0000o0.O00000o0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r0 != 4) goto L_0x002c;
     */
    public final int O0000o0() throws IOException, JsonParseException {
        int i;
        if (!(this.O000OO0o == null || (i = AnonymousClass1.f12399O000000o[this.O000OO0o.ordinal()]) == 1)) {
            if (i != 2) {
                if (i != 3) {
                }
            } else if (this.O000OOoo) {
                this.O000OOoo = false;
                O000OOo0();
            }
            return this.O0000o0.O00000o();
        }
        return 0;
    }

    public final byte[] O000000o(aii aii) throws IOException, JsonParseException {
        if (this.O000OO0o != JsonToken.VALUE_STRING && (this.O000OO0o != JsonToken.VALUE_EMBEDDED_OBJECT || this.O0000oO0 == null)) {
            O00000o("Current token (" + this.O000OO0o + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this.O000OOoo) {
            try {
                this.O0000oO0 = O00000Oo(aii);
                this.O000OOoo = false;
            } catch (IllegalArgumentException e) {
                throw O000000o("Failed to decode VALUE_STRING as base64 (" + aii + "): " + e.getMessage());
            }
        } else if (this.O0000oO0 == null) {
            ajk O000O0oO = O000O0oO();
            O000000o(O0000OoO(), O000O0oO, aii);
            this.O0000oO0 = O000O0oO.O00000Oo();
        }
        return this.O0000oO0;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:135:0x00a3 */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: char} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aip.O000000o(int, char):void
     arg types: [char, int]
     candidates:
      _m_j.ajd.O000000o(int, boolean):com.fasterxml.jackson.core.JsonToken
      _m_j.ajd.O000000o(java.lang.String, int):void
      _m_j.aip.O000000o(java.lang.String, double):com.fasterxml.jackson.core.JsonToken
      _m_j.aip.O000000o(int, java.lang.String):void
      _m_j.aiq.O000000o(java.lang.String, java.lang.Throwable):void
      _m_j.aip.O000000o(int, char):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aip.O000000o(java.lang.String, double):com.fasterxml.jackson.core.JsonToken
     arg types: [java.lang.String, int]
     candidates:
      _m_j.ajd.O000000o(int, boolean):com.fasterxml.jackson.core.JsonToken
      _m_j.ajd.O000000o(java.lang.String, int):void
      _m_j.aip.O000000o(int, char):void
      _m_j.aip.O000000o(int, java.lang.String):void
      _m_j.aiq.O000000o(java.lang.String, java.lang.Throwable):void
      _m_j.aip.O000000o(java.lang.String, double):com.fasterxml.jackson.core.JsonToken */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ajd.O000000o(int, boolean):com.fasterxml.jackson.core.JsonToken
     arg types: [char, int]
     candidates:
      _m_j.ajd.O000000o(java.lang.String, int):void
      _m_j.aip.O000000o(java.lang.String, double):com.fasterxml.jackson.core.JsonToken
      _m_j.aip.O000000o(int, char):void
      _m_j.aip.O000000o(int, java.lang.String):void
      _m_j.aiq.O000000o(java.lang.String, java.lang.Throwable):void
      _m_j.ajd.O000000o(int, boolean):com.fasterxml.jackson.core.JsonToken */
    /* JADX WARNING: Multi-variable type inference failed */
    public final JsonToken O00000Oo() throws IOException, JsonParseException {
        char c;
        int i;
        this.O00oOooo = 0;
        JsonToken jsonToken = null;
        if (this.O000OO0o == JsonToken.FIELD_NAME) {
            this.O0000o0o = false;
            JsonToken jsonToken2 = this.O0000o00;
            this.O0000o00 = null;
            if (jsonToken2 == JsonToken.START_ARRAY) {
                this.O0000Ooo = this.O0000Ooo.O000000o(this.O0000Oo, this.O0000OoO);
            } else if (jsonToken2 == JsonToken.START_OBJECT) {
                this.O0000Ooo = this.O0000Ooo.O00000Oo(this.O0000Oo, this.O0000OoO);
            }
            this.O000OO0o = jsonToken2;
            return jsonToken2;
        }
        if (this.O000OOoo) {
            this.O000OOoo = false;
            int i2 = this.O00000o;
            int i3 = this.O00000oO;
            char[] cArr = this.O000OOo0;
            while (true) {
                if (i2 >= i3) {
                    this.O00000o = i2;
                    if (!O000O0Oo()) {
                        O00000o0(": was expecting closing quote for a string value");
                    }
                    i2 = this.O00000o;
                    i3 = this.O00000oO;
                }
                i = i2 + 1;
                char c2 = cArr[i2];
                if (c2 <= '\\') {
                    if (c2 == '\\') {
                        this.O00000o = i;
                        O000O0oo();
                        i2 = this.O00000o;
                        i3 = this.O00000oO;
                    } else if (c2 <= '\"') {
                        if (c2 == '\"') {
                            break;
                        } else if (c2 < ' ') {
                            this.O00000o = i;
                            O00000o0(c2, "string value");
                        }
                    }
                }
                i2 = i;
            }
            this.O00000o = i;
        }
        while (true) {
            if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                O000O0o();
                c = 65535;
                break;
            }
            char[] cArr2 = this.O000OOo0;
            int i4 = this.O00000o;
            this.O00000o = i4 + 1;
            c = cArr2[i4];
            if (c > ' ') {
                if (c != '/') {
                    break;
                }
                O000Oo0();
            } else if (c != ' ') {
                if (c == 10) {
                    O000OOoo();
                } else if (c == 13) {
                    O000OOoO();
                } else if (c != 9) {
                    O000000o((int) c);
                }
            }
        }
        if (c < 0) {
            close();
            this.O000OO0o = null;
            return null;
        }
        this.O0000Oo0 = (this.O00000oo + ((long) this.O00000o)) - 1;
        this.O0000Oo = this.O0000O0o;
        this.O0000OoO = (this.O00000o - this.O0000OOo) - 1;
        this.O0000oO0 = null;
        if (c == ']') {
            if (!this.O0000Ooo.O000000o()) {
                O000000o((int) c, '}');
            }
            this.O0000Ooo = this.O0000Ooo.O0000Oo0();
            JsonToken jsonToken3 = JsonToken.END_ARRAY;
            this.O000OO0o = jsonToken3;
            return jsonToken3;
        } else if (c == '}') {
            if (!this.O0000Ooo.O00000o0()) {
                O000000o((int) c, ']');
            }
            this.O0000Ooo = this.O0000Ooo.O0000Oo0();
            JsonToken jsonToken4 = JsonToken.END_OBJECT;
            this.O000OO0o = jsonToken4;
            return jsonToken4;
        } else {
            char c3 = c;
            if (this.O0000Ooo.O0000Oo()) {
                if (c != ',') {
                    O00000Oo(c, "was expecting comma to separate " + this.O0000Ooo.O00000o() + " entries");
                }
                c3 = O000Oo00();
            }
            boolean O00000o0 = this.O0000Ooo.O00000o0();
            int i5 = c3;
            if (O00000o0) {
                this.O0000Ooo.O000000o(O00000o(c3));
                this.O000OO0o = JsonToken.FIELD_NAME;
                int O000Oo00 = O000Oo00();
                if (O000Oo00 != 58) {
                    O00000Oo(O000Oo00, "was expecting a colon to separate field name and value");
                }
                i5 = O000Oo00();
            }
            if (i5 != 34) {
                if (i5 != 45) {
                    if (i5 != 91) {
                        if (i5 != 93) {
                            if (i5 == 102) {
                                O000000o("false", 1);
                                jsonToken = JsonToken.VALUE_FALSE;
                            } else if (i5 != 110) {
                                if (i5 != 116) {
                                    if (i5 != 123) {
                                        if (i5 != 125) {
                                            switch (i5) {
                                                case 48:
                                                case 49:
                                                case 50:
                                                case 51:
                                                case 52:
                                                case 53:
                                                case 54:
                                                case 55:
                                                case 56:
                                                case 57:
                                                    break;
                                                default:
                                                    if (i5 == 39) {
                                                        if (O000000o(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
                                                            jsonToken = O000OOOo();
                                                            break;
                                                        }
                                                    } else if (i5 == 43) {
                                                        if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                                                            O000OO0o();
                                                        }
                                                        char[] cArr3 = this.O000OOo0;
                                                        int i6 = this.O00000o;
                                                        this.O00000o = i6 + 1;
                                                        jsonToken = O000000o((int) cArr3[i6], false);
                                                        break;
                                                    } else if (i5 == 78) {
                                                        O000000o("NaN", 1);
                                                        if (O000000o(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                                                            jsonToken = O000000o("NaN", Double.NaN);
                                                            break;
                                                        } else {
                                                            O00000o("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                                                        }
                                                    }
                                                    O00000Oo(i5, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
                                                    break;
                                            }
                                        }
                                    } else {
                                        if (!O00000o0) {
                                            this.O0000Ooo = this.O0000Ooo.O00000Oo(this.O0000Oo, this.O0000OoO);
                                        }
                                        jsonToken = JsonToken.START_OBJECT;
                                    }
                                }
                                O000000o("true", 1);
                                jsonToken = JsonToken.VALUE_TRUE;
                            } else {
                                O000000o("null", 1);
                                jsonToken = JsonToken.VALUE_NULL;
                            }
                        }
                        O00000Oo(i5, "expected a value");
                        O000000o("true", 1);
                        jsonToken = JsonToken.VALUE_TRUE;
                    } else {
                        if (!O00000o0) {
                            this.O0000Ooo = this.O0000Ooo.O000000o(this.O0000Oo, this.O0000OoO);
                        }
                        jsonToken = JsonToken.START_ARRAY;
                    }
                }
                jsonToken = O00000o0(i5);
            } else {
                this.O000OOoo = true;
                jsonToken = JsonToken.VALUE_STRING;
            }
            if (O00000o0) {
                this.O0000o00 = jsonToken;
                return this.O000OO0o;
            }
            this.O000OO0o = jsonToken;
            return jsonToken;
        }
    }

    public final void close() throws IOException {
        super.close();
        this.O000OOoO.O00000Oo();
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ajd.O000000o(int, boolean):com.fasterxml.jackson.core.JsonToken
     arg types: [char, int]
     candidates:
      _m_j.ajd.O000000o(java.lang.String, int):void
      _m_j.aip.O000000o(java.lang.String, double):com.fasterxml.jackson.core.JsonToken
      _m_j.aip.O000000o(int, char):void
      _m_j.aip.O000000o(int, java.lang.String):void
      _m_j.aiq.O000000o(java.lang.String, java.lang.Throwable):void
      _m_j.ajd.O000000o(int, boolean):com.fasterxml.jackson.core.JsonToken */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0074, code lost:
        if (r6 == 'e') goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0076, code lost:
        if (r6 != 'E') goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0079, code lost:
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007b, code lost:
        if (r10 >= r8) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007d, code lost:
        r12 = r10 + 1;
        r6 = r0.O000OOo0[r10];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0083, code lost:
        if (r6 == '-') goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0087, code lost:
        if (r6 != '+') goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008a, code lost:
        r10 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008b, code lost:
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008d, code lost:
        if (r12 >= r8) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008f, code lost:
        r10 = r12 + 1;
        r6 = r0.O000OOo0[r12];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0096, code lost:
        if (r6 > '9') goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0098, code lost:
        if (r6 < '0') goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009a, code lost:
        r12 = r12 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009c, code lost:
        if (r10 >= r8) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x009e, code lost:
        r6 = r0.O000OOo0[r10];
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a7, code lost:
        if (r12 != 0) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a9, code lost:
        O000000o(r6, "Exponent indicator not followed by a digit");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ac, code lost:
        r10 = r10 - 1;
        r0.O00000o = r10;
        r0.O0000o0.O000000o(r0.O000OOo0, r7, r10 - r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00bc, code lost:
        return O000000o(r5, r4, r14, r12);
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00eb  */
    private JsonToken O00000o0(int i) throws IOException, JsonParseException {
        int i2;
        char c;
        char[] cArr;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        ajd ajd;
        int i8;
        int i9;
        char c2;
        char c3;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        char c4 = i;
        boolean z2 = c4 == 45;
        int i16 = this.O00000o;
        int i17 = i16 - 1;
        int i18 = this.O00000oO;
        if (z2) {
            if (i16 < this.O00000oO) {
                int i19 = i16 + 1;
                char c5 = this.O000OOo0[i16];
                if (c5 > '9' || c5 < '0') {
                    this.O00000o = i19;
                    return O000000o((int) c5, true);
                }
                i16 = i19;
                c4 = c5;
            }
            if (z2) {
                i17++;
            }
            this.O00000o = i17;
            char[] O0000Oo = this.O0000o0.O0000Oo();
            if (!z2) {
                O0000Oo[0] = '-';
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.O00000o >= this.O00000oO) {
                char[] cArr2 = this.O000OOo0;
                int i20 = this.O00000o;
                this.O00000o = i20 + 1;
                c = cArr2[i20];
            } else {
                c = O00000oO("No digit following minus sign");
            }
            if (c == '0') {
                if ((this.O00000o < this.O00000oO || O000O0Oo()) && (c = this.O000OOo0[this.O00000o]) >= '0' && c <= '9') {
                    if (!O000000o(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
                        O00000Oo("Leading zeroes not allowed");
                    }
                    this.O00000o++;
                    if (c == '0') {
                        while (true) {
                            if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                                break;
                            }
                            c = this.O000OOo0[this.O00000o];
                            if (c < '0' || c > '9') {
                                break;
                            }
                            this.O00000o++;
                            if (c != '0') {
                                break;
                            }
                        }
                    }
                }
                c = '0';
            }
            cArr = O0000Oo;
            i3 = 0;
            while (true) {
                if (c >= '0' && c <= '9') {
                    i3++;
                    if (i2 >= cArr.length) {
                        cArr = this.O0000o0.O0000OoO();
                        i2 = 0;
                    }
                    i12 = i2 + 1;
                    cArr[i2] = c;
                    if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                        i2 = i12;
                        c = 0;
                        z = true;
                        break;
                    }
                    char[] cArr3 = this.O000OOo0;
                    int i21 = this.O00000o;
                    this.O00000o = i21 + 1;
                    c = cArr3[i21];
                    i2 = i12;
                } else {
                    z = false;
                }
            }
            z = false;
            if (i3 == 0) {
                O00000Oo("Missing integer part (next char " + O00000Oo(c) + ")");
            }
            if (c != '.') {
                i5 = i2 + 1;
                cArr[i2] = c;
                i4 = 0;
                while (true) {
                    if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                        z = true;
                        break;
                    }
                    char[] cArr4 = this.O000OOo0;
                    int i22 = this.O00000o;
                    this.O00000o = i22 + 1;
                    c = cArr4[i22];
                    if (c < '0' || c > '9') {
                        break;
                    }
                    i4++;
                    if (i5 >= cArr.length) {
                        cArr = this.O0000o0.O0000OoO();
                        i5 = 0;
                    }
                    cArr[i5] = c;
                    i5++;
                }
                if (i4 == 0) {
                    O000000o(c, "Decimal point not followed by a digit");
                }
            } else {
                i5 = i2;
                i4 = 0;
            }
            if (c != 'e' || c == 'E') {
                if (i5 >= cArr.length) {
                    cArr = this.O0000o0.O0000OoO();
                    i5 = 0;
                }
                i8 = i5 + 1;
                cArr[i5] = c;
                if (this.O00000o >= this.O00000oO) {
                    char[] cArr5 = this.O000OOo0;
                    int i23 = this.O00000o;
                    this.O00000o = i23 + 1;
                    c2 = cArr5[i23];
                } else {
                    c2 = O00000oO("expected a digit for number exponent");
                }
                if (c2 != '-' || c2 == '+') {
                    if (i8 >= cArr.length) {
                        cArr = this.O0000o0.O0000OoO();
                        i8 = 0;
                    }
                    int i24 = i8 + 1;
                    cArr[i8] = c2;
                    if (this.O00000o >= this.O00000oO) {
                        char[] cArr6 = this.O000OOo0;
                        int i25 = this.O00000o;
                        this.O00000o = i25 + 1;
                        c3 = cArr6[i25];
                    } else {
                        c3 = O00000oO("expected a digit for number exponent");
                    }
                    c2 = c3;
                    i6 = i4;
                    i8 = i24;
                    i7 = i3;
                    i10 = 0;
                } else {
                    i6 = i4;
                    i10 = 0;
                    i7 = i3;
                }
                ajd = this;
                while (true) {
                    if (c2 <= '9' && c2 >= '0') {
                        i10++;
                        if (i8 >= cArr.length) {
                            cArr = ajd.O0000o0.O0000OoO();
                            i8 = 0;
                        }
                        i11 = i8 + 1;
                        cArr[i8] = c2;
                        if (ajd.O00000o >= ajd.O00000oO && !ajd.O000O0Oo()) {
                            i9 = i10;
                            i8 = i11;
                            z = true;
                            break;
                        }
                        char[] cArr7 = ajd.O000OOo0;
                        int i26 = ajd.O00000o;
                        ajd.O00000o = i26 + 1;
                        c2 = cArr7[i26];
                        i8 = i11;
                    } else {
                        i9 = i10;
                    }
                }
                if (i9 == 0) {
                    ajd.O000000o(c2, "Exponent indicator not followed by a digit");
                }
            } else {
                i8 = i5;
                i6 = i4;
                i9 = 0;
                i7 = i3;
                ajd = this;
            }
            if (!z) {
                ajd.O00000o--;
            }
            ajd.O0000o0.O0000O0o = i8;
            return ajd.O000000o(z2, i7, i6, i9);
        }
        if (c4 != 48) {
            int i27 = 1;
            while (true) {
                if (i16 >= this.O00000oO) {
                    break;
                }
                int i28 = i16 + 1;
                char c6 = this.O000OOo0[i16];
                if (c6 >= '0' && c6 <= '9') {
                    i27++;
                    i16 = i28;
                } else if (c6 == '.') {
                    int i29 = i28;
                    int i30 = 0;
                    while (true) {
                        if (i29 >= i18) {
                            break;
                        }
                        i15 = i29 + 1;
                        c6 = this.O000OOo0[i29];
                        if (c6 >= '0' && c6 <= '9') {
                            i30++;
                            i29 = i15;
                        } else if (i30 == 0) {
                            O000000o(c6, "Decimal point not followed by a digit");
                        }
                    }
                    if (i30 == 0) {
                    }
                    i13 = i30;
                    i14 = i15;
                } else {
                    i14 = i28;
                    i13 = 0;
                }
            }
        }
        if (z2) {
        }
        this.O00000o = i17;
        char[] O0000Oo2 = this.O0000o0.O0000Oo();
        if (!z2) {
        }
        if (this.O00000o >= this.O00000oO) {
        }
        if (c == '0') {
        }
        cArr = O0000Oo2;
        i3 = 0;
        while (true) {
            if (c >= '0') {
                break;
            }
            break;
            char[] cArr32 = this.O000OOo0;
            int i212 = this.O00000o;
            this.O00000o = i212 + 1;
            c = cArr32[i212];
            i2 = i12;
        }
        z = false;
        if (i3 == 0) {
        }
        if (c != '.') {
        }
        if (c != 'e') {
        }
        if (i5 >= cArr.length) {
        }
        i8 = i5 + 1;
        cArr[i5] = c;
        if (this.O00000o >= this.O00000oO) {
        }
        if (c2 != '-') {
        }
        if (i8 >= cArr.length) {
        }
        int i242 = i8 + 1;
        cArr[i8] = c2;
        if (this.O00000o >= this.O00000oO) {
        }
        c2 = c3;
        i6 = i4;
        i8 = i242;
        i7 = i3;
        i10 = 0;
        ajd = this;
        while (true) {
            if (c2 <= '9') {
                break;
            }
            break;
            char[] cArr72 = ajd.O000OOo0;
            int i262 = ajd.O00000o;
            ajd.O00000o = i262 + 1;
            c2 = cArr72[i262];
            i8 = i11;
        }
        if (i9 == 0) {
        }
        if (!z) {
        }
        ajd.O0000o0.O0000O0o = i8;
        return ajd.O000000o(z2, i7, i6, i9);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ?, r9v1 ?, r9v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private com.fasterxml.jackson.core.JsonToken O000000o(
/*
Method generation error in method: _m_j.ajd.O000000o(int, boolean):com.fasterxml.jackson.core.JsonToken, dex: classes6.dex
    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ?
    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:161)
    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:133)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:332)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
    
*/

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0086  */
    private String O000000o(int i, int i2, int i3) throws IOException, JsonParseException {
        char c;
        int i4;
        this.O0000o0.O000000o(this.O000OOo0, i, this.O00000o - i);
        char[] O0000Oo0 = this.O0000o0.O0000Oo0();
        int i5 = this.O0000o0.O0000O0o;
        while (true) {
            if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                O00000o0(": was expecting closing '" + ((char) i3) + "' for name");
            }
            char[] cArr = this.O000OOo0;
            int i6 = this.O00000o;
            this.O00000o = i6 + 1;
            char c2 = cArr[i6];
            if (c2 <= '\\') {
                if (c2 == '\\') {
                    c = O000O0oo();
                    i2 = (i2 * 31) + c2;
                    i4 = i5 + 1;
                    O0000Oo0[i5] = c;
                    if (i4 < O0000Oo0.length) {
                        O0000Oo0 = this.O0000o0.O0000OoO();
                        i5 = 0;
                    } else {
                        i5 = i4;
                    }
                } else if (c2 <= i3) {
                    if (c2 == i3) {
                        this.O0000o0.O0000O0o = i5;
                        ajo ajo = this.O0000o0;
                        return this.O000OOoO.O000000o(ajo.O00000oO(), ajo.O00000o(), ajo.O00000o0(), i2);
                    } else if (c2 < ' ') {
                        O00000o0(c2, "name");
                    }
                }
            }
            c = c2;
            i2 = (i2 * 31) + c2;
            i4 = i5 + 1;
            O0000Oo0[i5] = c;
            if (i4 < O0000Oo0.length) {
            }
        }
    }

    private JsonToken O000OOOo() throws IOException, JsonParseException {
        char[] O0000Oo = this.O0000o0.O0000Oo();
        int i = this.O0000o0.O0000O0o;
        while (true) {
            if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                O00000o0(": was expecting closing quote for a string value");
            }
            char[] cArr = this.O000OOo0;
            int i2 = this.O00000o;
            this.O00000o = i2 + 1;
            char c = cArr[i2];
            if (c <= '\\') {
                if (c == '\\') {
                    c = O000O0oo();
                } else if (c <= '\'') {
                    if (c == '\'') {
                        this.O0000o0.O0000O0o = i;
                        return JsonToken.VALUE_STRING;
                    } else if (c < ' ') {
                        O00000o0(c, "string value");
                    }
                }
            }
            if (i >= O0000Oo.length) {
                O0000Oo = this.O0000o0.O0000OoO();
                i = 0;
            }
            O0000Oo[i] = c;
            i++;
        }
    }

    private void O000OOo0() throws IOException, JsonParseException {
        int i = this.O00000o;
        int i2 = this.O00000oO;
        if (i < i2) {
            int[] O000000o2 = air.O000000o();
            int length = O000000o2.length;
            while (true) {
                char c = this.O000OOo0[i];
                if (c >= length || O000000o2[c] == 0) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                } else if (c == '\"') {
                    ajo ajo = this.O0000o0;
                    char[] cArr = this.O000OOo0;
                    int i3 = this.O00000o;
                    ajo.O000000o(cArr, i3, i - i3);
                    this.O00000o = i + 1;
                    return;
                }
            }
        }
        ajo ajo2 = this.O0000o0;
        char[] cArr2 = this.O000OOo0;
        int i4 = this.O00000o;
        ajo2.O00000Oo(cArr2, i4, i - i4);
        this.O00000o = i;
        O000OOo();
    }

    private void O000OOo() throws IOException, JsonParseException {
        char[] O0000Oo0 = this.O0000o0.O0000Oo0();
        int i = this.O0000o0.O0000O0o;
        while (true) {
            if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                O00000o0(": was expecting closing quote for a string value");
            }
            char[] cArr = this.O000OOo0;
            int i2 = this.O00000o;
            this.O00000o = i2 + 1;
            char c = cArr[i2];
            if (c <= '\\') {
                if (c == '\\') {
                    c = O000O0oo();
                } else if (c <= '\"') {
                    if (c == '\"') {
                        this.O0000o0.O0000O0o = i;
                        return;
                    } else if (c < ' ') {
                        O00000o0(c, "string value");
                    }
                }
            }
            if (i >= O0000Oo0.length) {
                O0000Oo0 = this.O0000o0.O0000OoO();
                i = 0;
            }
            O0000Oo0[i] = c;
            i++;
        }
    }

    private void O000OOoO() throws IOException {
        if ((this.O00000o < this.O00000oO || O000O0Oo()) && this.O000OOo0[this.O00000o] == 10) {
            this.O00000o++;
        }
        this.O0000O0o++;
        this.O0000OOo = this.O00000o;
    }

    private void O000OOoo() throws IOException {
        this.O0000O0o++;
        this.O0000OOo = this.O00000o;
    }

    private final int O000Oo00() throws IOException, JsonParseException {
        while (true) {
            if (this.O00000o < this.O00000oO || O000O0Oo()) {
                char[] cArr = this.O000OOo0;
                int i = this.O00000o;
                this.O00000o = i + 1;
                char c = cArr[i];
                if (c > ' ') {
                    if (c != '/') {
                        return c;
                    }
                    O000Oo0();
                } else if (c != ' ') {
                    if (c == 10) {
                        O000OOoo();
                    } else if (c == 13) {
                        O000OOoO();
                    } else if (c != 9) {
                        O000000o((int) c);
                    }
                }
            } else {
                throw O000000o("Unexpected end-of-input within/between " + this.O0000Ooo.O00000o() + " entries");
            }
        }
    }

    private final void O000Oo0() throws IOException, JsonParseException {
        if (!O000000o(JsonParser.Feature.ALLOW_COMMENTS)) {
            O00000Oo(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
            O00000o0(" in a comment");
        }
        char[] cArr = this.O000OOo0;
        int i = this.O00000o;
        this.O00000o = i + 1;
        char c = cArr[i];
        if (c == '/') {
            O000Oo0o();
        } else if (c == '*') {
            O000Oo0O();
        } else {
            O00000Oo(c, "was expecting either '*' or '/' for a comment");
        }
    }

    private final void O000Oo0O() throws IOException, JsonParseException {
        while (true) {
            if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                break;
            }
            char[] cArr = this.O000OOo0;
            int i = this.O00000o;
            this.O00000o = i + 1;
            char c = cArr[i];
            if (c <= '*') {
                if (c == '*') {
                    if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                        break;
                    } else if (this.O000OOo0[this.O00000o] == '/') {
                        this.O00000o++;
                        return;
                    }
                } else if (c < ' ') {
                    if (c == 10) {
                        O000OOoo();
                    } else if (c == 13) {
                        O000OOoO();
                    } else if (c != 9) {
                        O000000o((int) c);
                    }
                }
            }
        }
        O00000o0(" in a comment");
    }

    private final void O000Oo0o() throws IOException, JsonParseException {
        while (true) {
            if (this.O00000o < this.O00000oO || O000O0Oo()) {
                char[] cArr = this.O000OOo0;
                int i = this.O00000o;
                this.O00000o = i + 1;
                char c = cArr[i];
                if (c < ' ') {
                    if (c == 10) {
                        O000OOoo();
                        return;
                    } else if (c == 13) {
                        O000OOoO();
                        return;
                    } else if (c != 9) {
                        O000000o((int) c);
                    }
                }
            } else {
                return;
            }
        }
    }

    public final char O000O0oo() throws IOException, JsonParseException {
        if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
            O00000o0(" in character escape sequence");
        }
        char[] cArr = this.O000OOo0;
        int i = this.O00000o;
        this.O00000o = i + 1;
        char c = cArr[i];
        if (c == '\"' || c == '/' || c == '\\') {
            return c;
        }
        if (c == 'b') {
            return 8;
        }
        if (c == 'f') {
            return 12;
        }
        if (c == 'n') {
            return 10;
        }
        if (c == 'r') {
            return 13;
        }
        if (c == 't') {
            return 9;
        }
        if (c != 'u') {
            return O000000o(c);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                O00000o0(" in character escape sequence");
            }
            char[] cArr2 = this.O000OOo0;
            int i4 = this.O00000o;
            this.O00000o = i4 + 1;
            char c2 = cArr2[i4];
            int O000000o2 = air.O000000o(c2);
            if (O000000o2 < 0) {
                O00000Oo(c2, "expected a hex-digit for character escape sequence");
            }
            i2 = (i2 << 4) | O000000o2;
        }
        return (char) i2;
    }

    private void O000000o(String str, int i) throws IOException, JsonParseException {
        char c;
        int length = str.length();
        do {
            if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                O000OO0o();
            }
            if (this.O000OOo0[this.O00000o] != str.charAt(i)) {
                O00000oo(str.substring(0, i));
            }
            this.O00000o++;
            i++;
        } while (i < length);
        if ((this.O00000o < this.O00000oO || O000O0Oo()) && (c = this.O000OOo0[this.O00000o]) >= '0' && c != ']' && c != '}' && Character.isJavaIdentifierPart(c)) {
            this.O00000o++;
            O00000oo(str.substring(0, i));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aip.O000000o(_m_j.aii, int, int, java.lang.String):java.lang.IllegalArgumentException
     arg types: [_m_j.aii, char, int, java.lang.String]
     candidates:
      _m_j.aip.O000000o(boolean, int, int, int):com.fasterxml.jackson.core.JsonToken
      _m_j.aiq.O000000o(_m_j.aii, char, int, java.lang.String):void
      _m_j.aip.O000000o(_m_j.aii, int, int, java.lang.String):java.lang.IllegalArgumentException */
    private byte[] O00000Oo(aii aii) throws IOException, JsonParseException {
        ajk O000O0oO = O000O0oO();
        while (true) {
            if (this.O00000o >= this.O00000oO) {
                O000O0OO();
            }
            char[] cArr = this.O000OOo0;
            int i = this.O00000o;
            this.O00000o = i + 1;
            char c = cArr[i];
            if (c > ' ') {
                int O00000Oo = aii.O00000Oo(c);
                if (O00000Oo < 0) {
                    if (c == '\"') {
                        return O000O0oO.O00000Oo();
                    }
                    O00000Oo = O000000o(aii, c, 0);
                    if (O00000Oo < 0) {
                        continue;
                    }
                }
                if (this.O00000o >= this.O00000oO) {
                    O000O0OO();
                }
                char[] cArr2 = this.O000OOo0;
                int i2 = this.O00000o;
                this.O00000o = i2 + 1;
                char c2 = cArr2[i2];
                int O00000Oo2 = aii.O00000Oo(c2);
                if (O00000Oo2 < 0) {
                    O00000Oo2 = O000000o(aii, c2, 1);
                }
                int i3 = (O00000Oo << 6) | O00000Oo2;
                if (this.O00000o >= this.O00000oO) {
                    O000O0OO();
                }
                char[] cArr3 = this.O000OOo0;
                int i4 = this.O00000o;
                this.O00000o = i4 + 1;
                char c3 = cArr3[i4];
                int O00000Oo3 = aii.O00000Oo(c3);
                if (O00000Oo3 < 0) {
                    if (O00000Oo3 != -2) {
                        if (c3 != '\"' || aii.O00000o0) {
                            O00000Oo3 = O000000o(aii, c3, 2);
                        } else {
                            O000O0oO.O000000o(i3 >> 4);
                            return O000O0oO.O00000Oo();
                        }
                    }
                    if (O00000Oo3 == -2) {
                        if (this.O00000o >= this.O00000oO) {
                            O000O0OO();
                        }
                        char[] cArr4 = this.O000OOo0;
                        int i5 = this.O00000o;
                        this.O00000o = i5 + 1;
                        char c4 = cArr4[i5];
                        if (aii.O000000o(c4)) {
                            O000O0oO.O000000o(i3 >> 4);
                        } else {
                            throw O000000o(aii, (int) c4, 3, "expected padding character '" + aii.O00000o + "'");
                        }
                    }
                }
                int i6 = (i3 << 6) | O00000Oo3;
                if (this.O00000o >= this.O00000oO) {
                    O000O0OO();
                }
                char[] cArr5 = this.O000OOo0;
                int i7 = this.O00000o;
                this.O00000o = i7 + 1;
                char c5 = cArr5[i7];
                int O00000Oo4 = aii.O00000Oo(c5);
                if (O00000Oo4 < 0) {
                    if (O00000Oo4 != -2) {
                        if (c5 != '\"' || aii.O00000o0) {
                            O00000Oo4 = O000000o(aii, c5, 3);
                        } else {
                            O000O0oO.O00000Oo(i6 >> 2);
                            return O000O0oO.O00000Oo();
                        }
                    }
                    if (O00000Oo4 == -2) {
                        O000O0oO.O00000Oo(i6 >> 2);
                    }
                }
                O000O0oO.O00000o0((i6 << 6) | O00000Oo4);
            }
        }
    }

    private void O00000oo(String str) throws IOException, JsonParseException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                break;
            }
            char c = this.O000OOo0[this.O00000o];
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            this.O00000o++;
            sb.append(c);
        }
        O00000o("Unrecognized token '" + sb.toString() + "': was expecting ");
    }

    private String O00000o(int i) throws IOException, JsonParseException {
        boolean z;
        int i2;
        int i3 = 0;
        if (i == 34) {
            int i4 = this.O00000o;
            int i5 = this.O00000oO;
            if (i4 < i5) {
                int[] O000000o2 = air.O000000o();
                int length = O000000o2.length;
                while (true) {
                    char c = this.O000OOo0[i4];
                    if (c >= length || O000000o2[c] == 0) {
                        i3 = (i3 * 31) + c;
                        i4++;
                        if (i4 >= i5) {
                            break;
                        }
                    } else if (c == '\"') {
                        int i6 = this.O00000o;
                        this.O00000o = i4 + 1;
                        return this.O000OOoO.O000000o(this.O000OOo0, i6, i4 - i6, i3);
                    }
                }
            }
            int i7 = this.O00000o;
            this.O00000o = i4;
            return O000000o(i7, i3, 34);
        } else if (i != 39 || !O000000o(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            if (!O000000o(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
                O00000Oo(i, "was expecting double-quote to start field name");
            }
            int[] O00000Oo = air.O00000Oo();
            int length2 = O00000Oo.length;
            if (i < length2) {
                z = O00000Oo[i] == 0 && (i < 48 || i > 57);
            } else {
                z = Character.isJavaIdentifierPart((char) i);
            }
            if (!z) {
                O00000Oo(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
            }
            int i8 = this.O00000o;
            int i9 = this.O00000oO;
            if (i8 < i9) {
                i2 = 0;
                do {
                    char c2 = this.O000OOo0[i8];
                    if (c2 < length2) {
                        if (O00000Oo[c2] != 0) {
                            int i10 = this.O00000o - 1;
                            this.O00000o = i8;
                            return this.O000OOoO.O000000o(this.O000OOo0, i10, i8 - i10, i2);
                        }
                    } else if (!Character.isJavaIdentifierPart((char) c2)) {
                        int i11 = this.O00000o - 1;
                        this.O00000o = i8;
                        return this.O000OOoO.O000000o(this.O000OOo0, i11, i8 - i11, i2);
                    }
                    i2 = (i2 * 31) + c2;
                    i8++;
                } while (i8 < i9);
            } else {
                i2 = 0;
            }
            int i12 = this.O00000o - 1;
            this.O00000o = i8;
            this.O0000o0.O000000o(this.O000OOo0, i12, this.O00000o - i12);
            char[] O0000Oo0 = this.O0000o0.O0000Oo0();
            int i13 = this.O0000o0.O0000O0o;
            int length3 = O00000Oo.length;
            while (true) {
                if (this.O00000o >= this.O00000oO && !O000O0Oo()) {
                    break;
                }
                char c3 = this.O000OOo0[this.O00000o];
                if (c3 > length3) {
                    if (!Character.isJavaIdentifierPart(c3)) {
                        break;
                    }
                } else if (O00000Oo[c3] != 0) {
                    break;
                }
                this.O00000o++;
                i2 = (i2 * 31) + c3;
                int i14 = i13 + 1;
                O0000Oo0[i13] = c3;
                if (i14 >= O0000Oo0.length) {
                    O0000Oo0 = this.O0000o0.O0000OoO();
                    i13 = 0;
                } else {
                    i13 = i14;
                }
            }
            this.O0000o0.O0000O0o = i13;
            ajo ajo = this.O0000o0;
            return this.O000OOoO.O000000o(ajo.O00000oO(), ajo.O00000o(), ajo.O00000o0(), i2);
        } else {
            int i15 = this.O00000o;
            int i16 = this.O00000oO;
            if (i15 < i16) {
                int[] O000000o3 = air.O000000o();
                int length4 = O000000o3.length;
                do {
                    char c4 = this.O000OOo0[i15];
                    if (c4 != '\'') {
                        if (c4 < length4 && O000000o3[c4] != 0) {
                            break;
                        }
                        i3 = (i3 * 31) + c4;
                        i15++;
                    } else {
                        int i17 = this.O00000o;
                        this.O00000o = i15 + 1;
                        return this.O000OOoO.O000000o(this.O000OOo0, i17, i15 - i17, i3);
                    }
                } while (i15 < i16);
            }
            int i18 = this.O00000o;
            this.O00000o = i15;
            return O000000o(i18, i3, 39);
        }
    }
}
