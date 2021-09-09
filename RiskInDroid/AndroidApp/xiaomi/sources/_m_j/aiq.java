package _m_j;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.exoplayer2.C;
import java.io.IOException;

public abstract class aiq extends JsonParser {
    protected JsonToken O000OO;
    protected JsonToken O000OO0o;

    public abstract JsonToken O00000Oo() throws IOException, JsonParseException;

    public abstract String O0000OoO() throws IOException, JsonParseException;

    /* access modifiers changed from: protected */
    public abstract void O000O0o() throws JsonParseException;

    protected aiq() {
    }

    protected aiq(byte b) {
        super(0);
    }

    public final JsonToken O00000oO() {
        return this.O000OO0o;
    }

    public final JsonToken O00000o0() throws IOException, JsonParseException {
        JsonToken O00000Oo = O00000Oo();
        return O00000Oo == JsonToken.FIELD_NAME ? O00000Oo() : O00000Oo;
    }

    public final JsonParser O00000o() throws IOException, JsonParseException {
        if (this.O000OO0o != JsonToken.START_OBJECT && this.O000OO0o != JsonToken.START_ARRAY) {
            return this;
        }
        int i = 1;
        while (true) {
            JsonToken O00000Oo = O00000Oo();
            if (O00000Oo == null) {
                O000O0o();
                return this;
            }
            int i2 = AnonymousClass1.f12391O000000o[O00000Oo.ordinal()];
            if (i2 == 1 || i2 == 2) {
                i++;
            } else if ((i2 == 3 || i2 == 4) && i - 1 == 0) {
                return this;
            }
        }
    }

    /* renamed from: _m_j.aiq$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12391O000000o = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f12391O000000o[JsonToken.START_OBJECT.ordinal()] = 1;
            f12391O000000o[JsonToken.START_ARRAY.ordinal()] = 2;
            f12391O000000o[JsonToken.END_OBJECT.ordinal()] = 3;
            f12391O000000o[JsonToken.END_ARRAY.ordinal()] = 4;
            f12391O000000o[JsonToken.VALUE_NUMBER_INT.ordinal()] = 5;
            f12391O000000o[JsonToken.VALUE_TRUE.ordinal()] = 6;
            f12391O000000o[JsonToken.VALUE_FALSE.ordinal()] = 7;
            f12391O000000o[JsonToken.VALUE_NULL.ordinal()] = 8;
            f12391O000000o[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 9;
            f12391O000000o[JsonToken.VALUE_STRING.ordinal()] = 10;
            try {
                f12391O000000o[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 11;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void O0000Oo() {
        JsonToken jsonToken = this.O000OO0o;
        if (jsonToken != null) {
            this.O000OO = jsonToken;
            this.O000OO0o = null;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final int O00oOooo() throws IOException, JsonParseException {
        if (this.O000OO0o != null) {
            switch (AnonymousClass1.f12391O000000o[this.O000OO0o.ordinal()]) {
                case 5:
                case 11:
                    return O0000oOO();
                case 6:
                    return 1;
                case 7:
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    return 0;
                case 9:
                    Object O00oOooO = O00oOooO();
                    if (O00oOooO instanceof Number) {
                        return ((Number) O00oOooO).intValue();
                    }
                    break;
                case 10:
                    return aiw.O000000o(O0000OoO(), 0);
            }
        }
        return 0;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aiw.O000000o(java.lang.String, long):long
     arg types: [java.lang.String, int]
     candidates:
      _m_j.aiw.O000000o(java.lang.String, int):int
      _m_j.aiw.O000000o(java.lang.String, long):long */
    public final long O000O00o() throws IOException, JsonParseException {
        if (this.O000OO0o != null) {
            switch (AnonymousClass1.f12391O000000o[this.O000OO0o.ordinal()]) {
                case 5:
                case 11:
                    return O0000oOo();
                case 6:
                    return 1;
                case 7:
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    return 0;
                case 9:
                    Object O00oOooO = O00oOooO();
                    if (O00oOooO instanceof Number) {
                        return ((Number) O00oOooO).longValue();
                    }
                    break;
                case 10:
                    return aiw.O000000o(O0000OoO(), 0L);
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        if (r3 >= r0) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r6 = r3 + 1;
        r3 = r12.charAt(r3);
        r7 = r14.O00000Oo(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r7 >= 0) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        O000000o(r14, r3, 1, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        r3 = (r4 << 6) | r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r6 < r0) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r14.O00000o0 != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        r13.O000000o(r3 >> 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        throw O000000o("Unexpected end-of-String in base64 content");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        r4 = r6 + 1;
        r6 = r12.charAt(r6);
        r7 = r14.O00000Oo(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r7 >= 0) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        if (r7 == -2) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        O000000o(r14, r6, 2, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        if (r4 >= r0) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
        r2 = r4 + 1;
        r4 = r12.charAt(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r14.O000000o(r4) != false) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        O000000o(r14, r4, 3, "expected padding character '" + r14.O00000o + "'");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0080, code lost:
        r13.O000000o(r3 >> 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008a, code lost:
        throw O000000o("Unexpected end-of-String in base64 content");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008b, code lost:
        r3 = (r3 << 6) | r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008e, code lost:
        if (r4 < r0) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0092, code lost:
        if (r14.O00000o0 != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0094, code lost:
        r13.O00000Oo(r3 >> 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0099, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009e, code lost:
        throw O000000o("Unexpected end-of-String in base64 content");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009f, code lost:
        r2 = r4 + 1;
        r4 = r12.charAt(r4);
        r6 = r14.O00000Oo(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a9, code lost:
        if (r6 >= 0) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ab, code lost:
        if (r6 == -2) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ad, code lost:
        O000000o(r14, r4, 3, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b0, code lost:
        r13.O00000Oo(r3 >> 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b7, code lost:
        r13.O00000o0((r3 << 6) | r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c3, code lost:
        throw O000000o("Unexpected end-of-String in base64 content");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        r4 = r14.O00000Oo(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r4 >= 0) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        O000000o(r14, r2, 0, null);
     */
    public final void O000000o(String str, ajk ajk, aii aii) throws IOException, JsonParseException {
        int length = str.length();
        int i = 0;
        while (i < length) {
            while (true) {
                int i2 = i + 1;
                char charAt = str.charAt(i);
                if (i2 >= length) {
                    return;
                }
                if (charAt > ' ') {
                    break;
                }
                i = i2;
            }
        }
    }

    private void O000000o(aii aii, char c, int i, String str) throws JsonParseException {
        String str2;
        if (c <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units";
        } else if (aii.O000000o(c)) {
            str2 = "Unexpected padding character ('" + aii.O00000o + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw O000000o(str2);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(int i, String str) throws JsonParseException {
        String str2 = "Unexpected character (" + O00000Oo(i) + ")";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw O000000o(str2);
    }

    /* access modifiers changed from: protected */
    public final void O000OO00() throws JsonParseException {
        O00000o0(" in " + this.O000OO0o);
    }

    /* access modifiers changed from: protected */
    public final void O00000o0(String str) throws JsonParseException {
        throw O000000o("Unexpected end-of-input".concat(String.valueOf(str)));
    }

    /* access modifiers changed from: protected */
    public final void O000OO0o() throws JsonParseException {
        O00000o0(" in a value");
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i) throws JsonParseException {
        throw O000000o("Illegal character (" + O00000Oo((char) i) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    /* access modifiers changed from: protected */
    public final void O00000o0(int i, String str) throws JsonParseException {
        if (!O000000o(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i >= 32) {
            throw O000000o("Illegal unquoted character (" + O00000Oo((char) i) + "): has to be escaped using backslash to be included in " + str);
        }
    }

    /* access modifiers changed from: protected */
    public final char O000000o(char c) throws JsonProcessingException {
        if (O000000o(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {
            return c;
        }
        if (c == '\'' && O000000o(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return c;
        }
        throw O000000o("Unrecognized character escape " + O00000Oo(c));
    }

    protected static final String O00000Oo(int i) {
        char c = (char) i;
        if (Character.isISOControl(c)) {
            return "(CTRL-CHAR, code " + i + ")";
        } else if (i > 255) {
            return "'" + c + "' (code " + i + " / 0x" + Integer.toHexString(i) + ")";
        } else {
            return "'" + c + "' (code " + i + ")";
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o(String str) throws JsonParseException {
        throw O000000o(str);
    }

    protected static void O000OO() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }

    /* access modifiers changed from: protected */
    public final void O000000o(String str, Throwable th) throws JsonParseException {
        throw new JsonParseException(str, O0000OOo(), th);
    }
}
