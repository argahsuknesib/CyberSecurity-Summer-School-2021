package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Date;

public abstract class amy<T> extends ajw<T> {
    protected final Class<?> O0000oOO;

    protected amy(Class<?> cls) {
        this.O0000oOO = cls;
    }

    protected amy(ajv ajv) {
        Class<?> cls;
        if (ajv == null) {
            cls = null;
        } else {
            cls = ajv.O00000Oo();
        }
        this.O0000oOO = cls;
    }

    public final Class<?> O00000oO() {
        return this.O0000oOO;
    }

    protected static boolean O000000o(aka aka) {
        return (aka == null || aka.getClass().getAnnotation(akg.class) == null) ? false : true;
    }

    public Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        return aof.O00000o(jsonParser, ajt);
    }

    /* access modifiers changed from: protected */
    public final boolean O00000oO(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_TRUE) {
            return true;
        }
        if (O00000oO == JsonToken.VALUE_FALSE || O00000oO == JsonToken.VALUE_NULL) {
            return false;
        }
        if (O00000oO == JsonToken.VALUE_NUMBER_INT) {
            if (jsonParser.O0000o() != JsonParser.NumberType.INT) {
                return O000000o(jsonParser);
            }
            if (jsonParser.O0000oOO() != 0) {
                return true;
            }
            return false;
        } else if (O00000oO == JsonToken.VALUE_STRING) {
            String trim = jsonParser.O0000OoO().trim();
            if ("true".equals(trim)) {
                return true;
            }
            if ("false".equals(trim) || trim.length() == 0) {
                return false;
            }
            throw ajt.O00000Oo(this.O0000oOO, "only \"true\" or \"false\" recognized");
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    /* access modifiers changed from: protected */
    public final Boolean O00000oo(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (O00000oO == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        if (O00000oO == JsonToken.VALUE_NUMBER_INT) {
            if (jsonParser.O0000o() == JsonParser.NumberType.INT) {
                return jsonParser.O0000oOO() == 0 ? Boolean.FALSE : Boolean.TRUE;
            }
            return Boolean.valueOf(O000000o(jsonParser));
        } else if (O00000oO == JsonToken.VALUE_NULL) {
            return (Boolean) O000000o();
        } else {
            if (O00000oO == JsonToken.VALUE_STRING) {
                String trim = jsonParser.O0000OoO().trim();
                if ("true".equals(trim)) {
                    return Boolean.TRUE;
                }
                if ("false".equals(trim)) {
                    return Boolean.FALSE;
                }
                if (trim.length() == 0) {
                    return (Boolean) O000000o();
                }
                throw ajt.O00000Oo(this.O0000oOO, "only \"true\" or \"false\" recognized");
            }
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    private static boolean O000000o(JsonParser jsonParser) throws IOException, JsonProcessingException {
        if (jsonParser.O0000o() == JsonParser.NumberType.LONG) {
            return (jsonParser.O0000oOo() == 0 ? Boolean.FALSE : Boolean.TRUE).booleanValue();
        }
        String O0000OoO = jsonParser.O0000OoO();
        return !"0.0".equals(O0000OoO) && !"0".equals(O0000OoO);
    }

    /* access modifiers changed from: protected */
    public final Byte O0000O0o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_NUMBER_INT || O00000oO == JsonToken.VALUE_NUMBER_FLOAT) {
            return Byte.valueOf(jsonParser.O0000oO0());
        }
        if (O00000oO == JsonToken.VALUE_STRING) {
            String trim = jsonParser.O0000OoO().trim();
            try {
                if (trim.length() == 0) {
                    return (Byte) O000000o();
                }
                int O000000o2 = aiw.O000000o(trim);
                if (O000000o2 >= -128 && O000000o2 <= 255) {
                    return Byte.valueOf((byte) O000000o2);
                }
                throw ajt.O00000Oo(this.O0000oOO, "overflow, value can not be represented as 8-bit value");
            } catch (IllegalArgumentException unused) {
                throw ajt.O00000Oo(this.O0000oOO, "not a valid Byte value");
            }
        } else if (O00000oO == JsonToken.VALUE_NULL) {
            return (Byte) O000000o();
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    /* access modifiers changed from: protected */
    public final Short O0000OOo(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_NUMBER_INT || O00000oO == JsonToken.VALUE_NUMBER_FLOAT) {
            return Short.valueOf(jsonParser.O0000oO());
        }
        if (O00000oO == JsonToken.VALUE_STRING) {
            String trim = jsonParser.O0000OoO().trim();
            try {
                if (trim.length() == 0) {
                    return (Short) O000000o();
                }
                int O000000o2 = aiw.O000000o(trim);
                if (O000000o2 >= -32768 && O000000o2 <= 32767) {
                    return Short.valueOf((short) O000000o2);
                }
                throw ajt.O00000Oo(this.O0000oOO, "overflow, value can not be represented as 16-bit value");
            } catch (IllegalArgumentException unused) {
                throw ajt.O00000Oo(this.O0000oOO, "not a valid Short value");
            }
        } else if (O00000oO == JsonToken.VALUE_NULL) {
            return (Short) O000000o();
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    /* access modifiers changed from: protected */
    public final short O0000Oo0(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        int O0000Oo = O0000Oo(jsonParser, ajt);
        if (O0000Oo >= -32768 && O0000Oo <= 32767) {
            return (short) O0000Oo;
        }
        throw ajt.O00000Oo(this.O0000oOO, "overflow, value can not be represented as 16-bit value");
    }

    /* access modifiers changed from: protected */
    public final int O0000Oo(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_NUMBER_INT || O00000oO == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.O0000oOO();
        }
        if (O00000oO == JsonToken.VALUE_STRING) {
            String trim = jsonParser.O0000OoO().trim();
            try {
                int length = trim.length();
                if (length > 9) {
                    long parseLong = Long.parseLong(trim);
                    if (parseLong >= -2147483648L && parseLong <= 2147483647L) {
                        return (int) parseLong;
                    }
                    Class<?> cls = this.O0000oOO;
                    throw ajt.O00000Oo(cls, "Overflow: numeric value (" + trim + ") out of range of int (-2147483648 - 2147483647" + ")");
                } else if (length == 0) {
                    return 0;
                } else {
                    return aiw.O000000o(trim);
                }
            } catch (IllegalArgumentException unused) {
                throw ajt.O00000Oo(this.O0000oOO, "not a valid int value");
            }
        } else if (O00000oO == JsonToken.VALUE_NULL) {
            return 0;
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    /* access modifiers changed from: protected */
    public final Integer O0000OoO(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_NUMBER_INT || O00000oO == JsonToken.VALUE_NUMBER_FLOAT) {
            return Integer.valueOf(jsonParser.O0000oOO());
        }
        if (O00000oO == JsonToken.VALUE_STRING) {
            String trim = jsonParser.O0000OoO().trim();
            try {
                int length = trim.length();
                if (length > 9) {
                    long parseLong = Long.parseLong(trim);
                    if (parseLong >= -2147483648L && parseLong <= 2147483647L) {
                        return Integer.valueOf((int) parseLong);
                    }
                    Class<?> cls = this.O0000oOO;
                    throw ajt.O00000Oo(cls, "Overflow: numeric value (" + trim + ") out of range of Integer (-2147483648 - 2147483647" + ")");
                } else if (length == 0) {
                    return (Integer) O000000o();
                } else {
                    return Integer.valueOf(aiw.O000000o(trim));
                }
            } catch (IllegalArgumentException unused) {
                throw ajt.O00000Oo(this.O0000oOO, "not a valid Integer value");
            }
        } else if (O00000oO == JsonToken.VALUE_NULL) {
            return (Integer) O000000o();
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    /* access modifiers changed from: protected */
    public final Long O0000Ooo(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_NUMBER_INT || O00000oO == JsonToken.VALUE_NUMBER_FLOAT) {
            return Long.valueOf(jsonParser.O0000oOo());
        }
        if (O00000oO == JsonToken.VALUE_STRING) {
            String trim = jsonParser.O0000OoO().trim();
            if (trim.length() == 0) {
                return (Long) O000000o();
            }
            try {
                return Long.valueOf(aiw.O00000Oo(trim));
            } catch (IllegalArgumentException unused) {
                throw ajt.O00000Oo(this.O0000oOO, "not a valid Long value");
            }
        } else if (O00000oO == JsonToken.VALUE_NULL) {
            return (Long) O000000o();
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    /* access modifiers changed from: protected */
    public final long O0000o00(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_NUMBER_INT || O00000oO == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.O0000oOo();
        }
        if (O00000oO == JsonToken.VALUE_STRING) {
            String trim = jsonParser.O0000OoO().trim();
            if (trim.length() == 0) {
                return 0;
            }
            try {
                return aiw.O00000Oo(trim);
            } catch (IllegalArgumentException unused) {
                throw ajt.O00000Oo(this.O0000oOO, "not a valid long value");
            }
        } else if (O00000oO == JsonToken.VALUE_NULL) {
            return 0;
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    /* access modifiers changed from: protected */
    public final Float O0000o0(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_NUMBER_INT || O00000oO == JsonToken.VALUE_NUMBER_FLOAT) {
            return Float.valueOf(jsonParser.O0000oo());
        }
        if (O00000oO == JsonToken.VALUE_STRING) {
            String trim = jsonParser.O0000OoO().trim();
            if (trim.length() == 0) {
                return (Float) O000000o();
            }
            char charAt = trim.charAt(0);
            if (charAt != '-') {
                if (charAt != 'I') {
                    if (charAt == 'N' && "NaN".equals(trim)) {
                        return Float.valueOf(Float.NaN);
                    }
                } else if ("Infinity".equals(trim) || "INF".equals(trim)) {
                    return Float.valueOf(Float.POSITIVE_INFINITY);
                }
            } else if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                return Float.valueOf(Float.NEGATIVE_INFINITY);
            }
            try {
                return Float.valueOf(Float.parseFloat(trim));
            } catch (IllegalArgumentException unused) {
                throw ajt.O00000Oo(this.O0000oOO, "not a valid Float value");
            }
        } else if (O00000oO == JsonToken.VALUE_NULL) {
            return (Float) O000000o();
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    /* access modifiers changed from: protected */
    public final float O0000o0O(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_NUMBER_INT || O00000oO == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.O0000oo();
        }
        if (O00000oO == JsonToken.VALUE_STRING) {
            String trim = jsonParser.O0000OoO().trim();
            if (trim.length() == 0) {
                return 0.0f;
            }
            char charAt = trim.charAt(0);
            if (charAt != '-') {
                if (charAt != 'I') {
                    if (charAt == 'N' && "NaN".equals(trim)) {
                        return Float.NaN;
                    }
                } else if ("Infinity".equals(trim) || "INF".equals(trim)) {
                    return Float.POSITIVE_INFINITY;
                }
            } else if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                return Float.NEGATIVE_INFINITY;
            }
            try {
                return Float.parseFloat(trim);
            } catch (IllegalArgumentException unused) {
                throw ajt.O00000Oo(this.O0000oOO, "not a valid float value");
            }
        } else if (O00000oO == JsonToken.VALUE_NULL) {
            return 0.0f;
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    /* access modifiers changed from: protected */
    public final Double O0000o0o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_NUMBER_INT || O00000oO == JsonToken.VALUE_NUMBER_FLOAT) {
            return Double.valueOf(jsonParser.O0000ooO());
        }
        if (O00000oO == JsonToken.VALUE_STRING) {
            String trim = jsonParser.O0000OoO().trim();
            if (trim.length() == 0) {
                return (Double) O000000o();
            }
            char charAt = trim.charAt(0);
            if (charAt != '-') {
                if (charAt != 'I') {
                    if (charAt == 'N' && "NaN".equals(trim)) {
                        return Double.valueOf(Double.NaN);
                    }
                } else if ("Infinity".equals(trim) || "INF".equals(trim)) {
                    return Double.valueOf(Double.POSITIVE_INFINITY);
                }
            } else if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
            try {
                return Double.valueOf(O000000o(trim));
            } catch (IllegalArgumentException unused) {
                throw ajt.O00000Oo(this.O0000oOO, "not a valid Double value");
            }
        } else if (O00000oO == JsonToken.VALUE_NULL) {
            return (Double) O000000o();
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    /* access modifiers changed from: protected */
    public final double O0000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_NUMBER_INT || O00000oO == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.O0000ooO();
        }
        if (O00000oO == JsonToken.VALUE_STRING) {
            String trim = jsonParser.O0000OoO().trim();
            if (trim.length() == 0) {
                return 0.0d;
            }
            char charAt = trim.charAt(0);
            if (charAt != '-') {
                if (charAt != 'I') {
                    if (charAt == 'N' && "NaN".equals(trim)) {
                        return Double.NaN;
                    }
                } else if ("Infinity".equals(trim) || "INF".equals(trim)) {
                    return Double.POSITIVE_INFINITY;
                }
            } else if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                return Double.NEGATIVE_INFINITY;
            }
            try {
                return O000000o(trim);
            } catch (IllegalArgumentException unused) {
                throw ajt.O00000Oo(this.O0000oOO, "not a valid double value");
            }
        } else if (O00000oO == JsonToken.VALUE_NULL) {
            return 0.0d;
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    /* access modifiers changed from: protected */
    public Date O00000Oo(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        JsonToken O00000oO = jsonParser.O00000oO();
        if (O00000oO == JsonToken.VALUE_NUMBER_INT) {
            return new Date(jsonParser.O0000oOo());
        }
        if (O00000oO == JsonToken.VALUE_NULL) {
            return (Date) O000000o();
        }
        if (O00000oO == JsonToken.VALUE_STRING) {
            try {
                String trim = jsonParser.O0000OoO().trim();
                if (trim.length() == 0) {
                    return (Date) O000000o();
                }
                return ajt.O000000o(trim);
            } catch (IllegalArgumentException e) {
                Class<?> cls = this.O0000oOO;
                throw ajt.O00000Oo(cls, "not a valid representation (error: " + e.getMessage() + ")");
            }
        } else {
            throw ajt.O000000o(this.O0000oOO, O00000oO);
        }
    }

    private static double O000000o(String str) throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    /* access modifiers changed from: protected */
    public void O000000o(JsonParser jsonParser, ajt ajt, Object obj, String str) throws IOException, JsonProcessingException {
        if (obj == null) {
            obj = this.O0000oOO;
        }
        ajt.O000000o(obj, str, this);
        jsonParser.O00000o();
    }
}
