package _m_j;

import _m_j.asu;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public final class amx {
    static final amx O00000Oo = new amx();

    /* renamed from: O000000o  reason: collision with root package name */
    HashMap<ajv, ajw<Object>> f12472O000000o = new HashMap<>();

    protected amx() {
        O000000o(Boolean.TYPE, new O00000Oo());
        O000000o(Byte.TYPE, new O00000o0());
        O000000o(Short.TYPE, new O0000o00());
        O000000o(Integer.TYPE, new O0000Oo0());
        O000000o(Long.TYPE, new O0000Oo());
        O000000o(Float.TYPE, new O0000OOo());
        O000000o(Double.TYPE, new O0000O0o());
        O000000o(String.class, new O0000o0());
        O000000o(Character.TYPE, new O00000o());
    }

    public static HashMap<ajv, ajw<Object>> O000000o() {
        return O00000Oo.f12472O000000o;
    }

    private void O000000o(Class<?> cls, ajw<?> ajw) {
        this.f12472O000000o.put(asq.O000000o().O000000o((Type) cls), ajw);
    }

    static abstract class O000000o<T> extends amy<T> {
        protected O000000o(Class<T> cls) {
            super((Class<?>) cls);
        }

        public final Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
            return aof.O00000Oo(jsonParser, ajt);
        }
    }

    @akg
    static final class O0000o0 extends O000000o<String[]> {
        public O0000o0() {
            super(String[].class);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            String str = null;
            if (jsonParser.O0000Oo0()) {
                atc O0000Oo = ajt.O0000Oo();
                Object[] O000000o2 = O0000Oo.O000000o();
                int i = 0;
                while (true) {
                    JsonToken O00000Oo = jsonParser.O00000Oo();
                    if (O00000Oo != JsonToken.END_ARRAY) {
                        String O0000OoO = O00000Oo == JsonToken.VALUE_NULL ? null : jsonParser.O0000OoO();
                        if (i >= O000000o2.length) {
                            O000000o2 = O0000Oo.O000000o(O000000o2);
                            i = 0;
                        }
                        O000000o2[i] = O0000OoO;
                        i++;
                    } else {
                        String[] strArr = (String[]) O0000Oo.O000000o(O000000o2, i, String.class);
                        ajt.O000000o(O0000Oo);
                        return strArr;
                    }
                }
            } else if (ajt.O000000o(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                String[] strArr2 = new String[1];
                if (jsonParser.O00000oO() != JsonToken.VALUE_NULL) {
                    str = jsonParser.O0000OoO();
                }
                strArr2[0] = str;
                return strArr2;
            } else if (jsonParser.O00000oO() == JsonToken.VALUE_STRING && ajt.O000000o(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.O0000OoO().length() == 0) {
                return null;
            } else {
                throw ajt.O00000Oo((Class<?>) this.O0000oOO);
            }
        }
    }

    @akg
    static final class O00000o extends O000000o<char[]> {
        public O00000o() {
            super(char[].class);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            JsonToken O00000oO = jsonParser.O00000oO();
            if (O00000oO == JsonToken.VALUE_STRING) {
                char[] O0000Ooo = jsonParser.O0000Ooo();
                int O0000o0 = jsonParser.O0000o0();
                int O0000o00 = jsonParser.O0000o00();
                char[] cArr = new char[O0000o00];
                System.arraycopy(O0000Ooo, O0000o0, cArr, 0, O0000o00);
                return cArr;
            } else if (jsonParser.O0000Oo0()) {
                StringBuilder sb = new StringBuilder(64);
                while (true) {
                    JsonToken O00000Oo = jsonParser.O00000Oo();
                    if (O00000Oo == JsonToken.END_ARRAY) {
                        return sb.toString().toCharArray();
                    }
                    if (O00000Oo == JsonToken.VALUE_STRING) {
                        String O0000OoO = jsonParser.O0000OoO();
                        if (O0000OoO.length() == 1) {
                            sb.append(O0000OoO.charAt(0));
                        } else {
                            throw JsonMappingException.from(jsonParser, "Can not convert a JSON String of length " + O0000OoO.length() + " into a char element of char array");
                        }
                    } else {
                        throw ajt.O00000Oo((Class<?>) Character.TYPE);
                    }
                }
            } else {
                if (O00000oO == JsonToken.VALUE_EMBEDDED_OBJECT) {
                    Object O00oOooO = jsonParser.O00oOooO();
                    if (O00oOooO == null) {
                        return null;
                    }
                    if (O00oOooO instanceof char[]) {
                        return (char[]) O00oOooO;
                    }
                    if (O00oOooO instanceof String) {
                        return ((String) O00oOooO).toCharArray();
                    }
                    if (O00oOooO instanceof byte[]) {
                        return aij.O000000o().O000000o((byte[]) O00oOooO, false).toCharArray();
                    }
                }
                throw ajt.O00000Oo((Class<?>) this.O0000oOO);
            }
        }
    }

    @akg
    static final class O00000Oo extends O000000o<boolean[]> {
        public O00000Oo() {
            super(boolean[].class);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            if (jsonParser.O0000Oo0()) {
                asu O0000OoO = ajt.O0000OoO();
                if (O0000OoO.f12575O000000o == null) {
                    O0000OoO.f12575O000000o = new asu.O00000Oo();
                }
                asu.O00000Oo o00000Oo = O0000OoO.f12575O000000o;
                boolean[] zArr = (boolean[]) o00000Oo.O000000o();
                int i = 0;
                while (jsonParser.O00000Oo() != JsonToken.END_ARRAY) {
                    boolean O00000oO = O00000oO(jsonParser, ajt);
                    if (i >= zArr.length) {
                        zArr = (boolean[]) o00000Oo.O000000o(zArr, i);
                        i = 0;
                    }
                    zArr[i] = O00000oO;
                    i++;
                }
                return (boolean[]) o00000Oo.O00000Oo(zArr, i);
            } else if (jsonParser.O00000oO() == JsonToken.VALUE_STRING && ajt.O000000o(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.O0000OoO().length() == 0) {
                return null;
            } else {
                if (ajt.O000000o(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                    return new boolean[]{O00000oO(jsonParser, ajt)};
                }
                throw ajt.O00000Oo((Class<?>) this.O0000oOO);
            }
        }
    }

    @akg
    static final class O00000o0 extends O000000o<byte[]> {
        public O00000o0() {
            super(byte[].class);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            byte b;
            byte b2;
            JsonToken O00000oO = jsonParser.O00000oO();
            if (O00000oO == JsonToken.VALUE_STRING) {
                return jsonParser.O000000o(ajs.O00000oO());
            }
            if (O00000oO == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object O00oOooO = jsonParser.O00oOooO();
                if (O00oOooO == null) {
                    return null;
                }
                if (O00oOooO instanceof byte[]) {
                    return (byte[]) O00oOooO;
                }
            }
            if (jsonParser.O0000Oo0()) {
                asu O0000OoO = ajt.O0000OoO();
                if (O0000OoO.O00000Oo == null) {
                    O0000OoO.O00000Oo = new asu.O00000o0();
                }
                asu.O00000o0 o00000o0 = O0000OoO.O00000Oo;
                byte[] bArr = (byte[]) o00000o0.O000000o();
                int i = 0;
                while (true) {
                    JsonToken O00000Oo = jsonParser.O00000Oo();
                    if (O00000Oo == JsonToken.END_ARRAY) {
                        return (byte[]) o00000o0.O00000Oo(bArr, i);
                    }
                    if (O00000Oo == JsonToken.VALUE_NUMBER_INT || O00000Oo == JsonToken.VALUE_NUMBER_FLOAT) {
                        b = jsonParser.O0000oO0();
                    } else if (O00000Oo == JsonToken.VALUE_NULL) {
                        b = 0;
                    } else {
                        throw ajt.O00000Oo(this.O0000oOO.getComponentType());
                    }
                    if (i >= bArr.length) {
                        bArr = (byte[]) o00000o0.O000000o(bArr, i);
                        i = 0;
                    }
                    bArr[i] = b;
                    i++;
                }
            } else if (jsonParser.O00000oO() == JsonToken.VALUE_STRING && ajt.O000000o(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.O0000OoO().length() == 0) {
                return null;
            } else {
                if (ajt.O000000o(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                    JsonToken O00000oO2 = jsonParser.O00000oO();
                    if (O00000oO2 == JsonToken.VALUE_NUMBER_INT || O00000oO2 == JsonToken.VALUE_NUMBER_FLOAT) {
                        b2 = jsonParser.O0000oO0();
                    } else if (O00000oO2 == JsonToken.VALUE_NULL) {
                        b2 = 0;
                    } else {
                        throw ajt.O00000Oo(this.O0000oOO.getComponentType());
                    }
                    return new byte[]{b2};
                }
                throw ajt.O00000Oo((Class<?>) this.O0000oOO);
            }
        }
    }

    @akg
    static final class O0000o00 extends O000000o<short[]> {
        public O0000o00() {
            super(short[].class);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            if (jsonParser.O0000Oo0()) {
                asu O0000OoO = ajt.O0000OoO();
                if (O0000OoO.O00000o0 == null) {
                    O0000OoO.O00000o0 = new asu.O0000Oo();
                }
                asu.O0000Oo o0000Oo = O0000OoO.O00000o0;
                short[] sArr = (short[]) o0000Oo.O000000o();
                int i = 0;
                while (jsonParser.O00000Oo() != JsonToken.END_ARRAY) {
                    short O0000Oo0 = O0000Oo0(jsonParser, ajt);
                    if (i >= sArr.length) {
                        sArr = (short[]) o0000Oo.O000000o(sArr, i);
                        i = 0;
                    }
                    sArr[i] = O0000Oo0;
                    i++;
                }
                return (short[]) o0000Oo.O00000Oo(sArr, i);
            } else if (jsonParser.O00000oO() == JsonToken.VALUE_STRING && ajt.O000000o(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.O0000OoO().length() == 0) {
                return null;
            } else {
                if (ajt.O000000o(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                    return new short[]{O0000Oo0(jsonParser, ajt)};
                }
                throw ajt.O00000Oo((Class<?>) this.O0000oOO);
            }
        }
    }

    @akg
    static final class O0000Oo0 extends O000000o<int[]> {
        public O0000Oo0() {
            super(int[].class);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            if (jsonParser.O0000Oo0()) {
                asu O0000OoO = ajt.O0000OoO();
                if (O0000OoO.O00000o == null) {
                    O0000OoO.O00000o = new asu.O0000OOo();
                }
                asu.O0000OOo o0000OOo = O0000OoO.O00000o;
                int[] iArr = (int[]) o0000OOo.O000000o();
                int i = 0;
                while (jsonParser.O00000Oo() != JsonToken.END_ARRAY) {
                    int O0000Oo = O0000Oo(jsonParser, ajt);
                    if (i >= iArr.length) {
                        iArr = (int[]) o0000OOo.O000000o(iArr, i);
                        i = 0;
                    }
                    iArr[i] = O0000Oo;
                    i++;
                }
                return (int[]) o0000OOo.O00000Oo(iArr, i);
            } else if (jsonParser.O00000oO() == JsonToken.VALUE_STRING && ajt.O000000o(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.O0000OoO().length() == 0) {
                return null;
            } else {
                if (ajt.O000000o(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                    return new int[]{O0000Oo(jsonParser, ajt)};
                }
                throw ajt.O00000Oo((Class<?>) this.O0000oOO);
            }
        }
    }

    @akg
    static final class O0000Oo extends O000000o<long[]> {
        public O0000Oo() {
            super(long[].class);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            if (jsonParser.O0000Oo0()) {
                asu O0000OoO = ajt.O0000OoO();
                if (O0000OoO.O00000oO == null) {
                    O0000OoO.O00000oO = new asu.O0000Oo0();
                }
                asu.O0000Oo0 o0000Oo0 = O0000OoO.O00000oO;
                long[] jArr = (long[]) o0000Oo0.O000000o();
                int i = 0;
                while (jsonParser.O00000Oo() != JsonToken.END_ARRAY) {
                    long O0000o00 = O0000o00(jsonParser, ajt);
                    if (i >= jArr.length) {
                        jArr = (long[]) o0000Oo0.O000000o(jArr, i);
                        i = 0;
                    }
                    jArr[i] = O0000o00;
                    i++;
                }
                return (long[]) o0000Oo0.O00000Oo(jArr, i);
            } else if (jsonParser.O00000oO() == JsonToken.VALUE_STRING && ajt.O000000o(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.O0000OoO().length() == 0) {
                return null;
            } else {
                if (ajt.O000000o(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                    return new long[]{O0000o00(jsonParser, ajt)};
                }
                throw ajt.O00000Oo((Class<?>) this.O0000oOO);
            }
        }
    }

    @akg
    static final class O0000OOo extends O000000o<float[]> {
        public O0000OOo() {
            super(float[].class);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            if (jsonParser.O0000Oo0()) {
                asu O0000OoO = ajt.O0000OoO();
                if (O0000OoO.O00000oo == null) {
                    O0000OoO.O00000oo = new asu.O0000O0o();
                }
                asu.O0000O0o o0000O0o = O0000OoO.O00000oo;
                float[] fArr = (float[]) o0000O0o.O000000o();
                int i = 0;
                while (jsonParser.O00000Oo() != JsonToken.END_ARRAY) {
                    float O0000o0O = O0000o0O(jsonParser, ajt);
                    if (i >= fArr.length) {
                        fArr = (float[]) o0000O0o.O000000o(fArr, i);
                        i = 0;
                    }
                    fArr[i] = O0000o0O;
                    i++;
                }
                return (float[]) o0000O0o.O00000Oo(fArr, i);
            } else if (jsonParser.O00000oO() == JsonToken.VALUE_STRING && ajt.O000000o(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.O0000OoO().length() == 0) {
                return null;
            } else {
                if (ajt.O000000o(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                    return new float[]{O0000o0O(jsonParser, ajt)};
                }
                throw ajt.O00000Oo((Class<?>) this.O0000oOO);
            }
        }
    }

    @akg
    static final class O0000O0o extends O000000o<double[]> {
        public O0000O0o() {
            super(double[].class);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            if (jsonParser.O0000Oo0()) {
                asu O0000OoO = ajt.O0000OoO();
                if (O0000OoO.O0000O0o == null) {
                    O0000OoO.O0000O0o = new asu.O00000o();
                }
                asu.O00000o o00000o = O0000OoO.O0000O0o;
                double[] dArr = (double[]) o00000o.O000000o();
                int i = 0;
                while (jsonParser.O00000Oo() != JsonToken.END_ARRAY) {
                    double O0000o = O0000o(jsonParser, ajt);
                    if (i >= dArr.length) {
                        dArr = (double[]) o00000o.O000000o(dArr, i);
                        i = 0;
                    }
                    dArr[i] = O0000o;
                    i++;
                }
                return (double[]) o00000o.O00000Oo(dArr, i);
            } else if (jsonParser.O00000oO() == JsonToken.VALUE_STRING && ajt.O000000o(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.O0000OoO().length() == 0) {
                return null;
            } else {
                if (ajt.O000000o(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                    return new double[]{O0000o(jsonParser, ajt)};
                }
                throw ajt.O00000Oo((Class<?>) this.O0000oOO);
            }
        }
    }
}
