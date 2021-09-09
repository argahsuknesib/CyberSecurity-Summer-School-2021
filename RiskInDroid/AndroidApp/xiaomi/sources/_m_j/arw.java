package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.HashMap;

public final class arw {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final HashMap<String, ajz<?>> f12557O000000o;

    static {
        HashMap<String, ajz<?>> hashMap = new HashMap<>();
        f12557O000000o = hashMap;
        hashMap.put(boolean[].class.getName(), new O000000o());
        f12557O000000o.put(byte[].class.getName(), new O00000Oo());
        f12557O000000o.put(char[].class.getName(), new O00000o0());
        f12557O000000o.put(short[].class.getName(), new O0000Oo());
        f12557O000000o.put(int[].class.getName(), new O0000OOo());
        f12557O000000o.put(long[].class.getName(), new O0000Oo0());
        f12557O000000o.put(float[].class.getName(), new O0000O0o());
        f12557O000000o.put(double[].class.getName(), new O00000o());
    }

    public static ajz<?> O000000o(Class<?> cls) {
        return f12557O000000o.get(cls.getName());
    }

    public static abstract class O0000o00<T> extends aqy<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        protected final aoi f12561O000000o;

        protected O0000o00(Class<T> cls) {
            super(cls);
            this.f12561O000000o = null;
        }

        protected O0000o00(O0000o00<T> o0000o00, ajr ajr, aoi aoi) {
            super(o0000o00, ajr);
            this.f12561O000000o = aoi;
        }
    }

    @akg
    public static final class O000000o extends aqy<boolean[]> {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final ajv f12558O000000o = asq.O000000o((Class<?>) Boolean.class);

        public final apy<?> O00000Oo(aoi aoi) {
            return this;
        }

        public final /* bridge */ /* synthetic */ boolean O000000o(Object obj) {
            boolean[] zArr = (boolean[]) obj;
            return zArr == null || zArr.length == 0;
        }

        public final /* synthetic */ void O00000Oo(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            for (boolean O000000o2 : (boolean[]) obj) {
                jsonGenerator.O000000o(O000000o2);
            }
        }

        public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
            return ((boolean[]) obj).length == 1;
        }

        static {
            asq.O000000o();
        }

        public O000000o() {
            super(boolean[].class, (byte) 0);
        }
    }

    @akg
    public static final class O00000Oo extends asb<byte[]> {
        public final /* bridge */ /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            jsonGenerator.O000000o((byte[]) obj);
        }

        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonProcessingException {
            byte[] bArr = (byte[]) obj;
            aoi.O000000o(bArr, jsonGenerator);
            jsonGenerator.O000000o(bArr);
            aoi.O00000o(bArr, jsonGenerator);
        }

        public final /* bridge */ /* synthetic */ boolean O000000o(Object obj) {
            byte[] bArr = (byte[]) obj;
            return bArr == null || bArr.length == 0;
        }

        public O00000Oo() {
            super(byte[].class);
        }
    }

    @akg
    public static final class O0000Oo extends O0000o00<short[]> {
        private static final ajv O00000Oo = asq.O000000o((Class<?>) Short.TYPE);

        public final /* bridge */ /* synthetic */ boolean O000000o(Object obj) {
            short[] sArr = (short[]) obj;
            return sArr == null || sArr.length == 0;
        }

        public final /* synthetic */ void O00000Oo(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            short[] sArr = (short[]) obj;
            int i = 0;
            if (this.f12561O000000o != null) {
                int length = sArr.length;
                while (i < length) {
                    this.f12561O000000o.O000000o((Object) null, jsonGenerator, Short.TYPE);
                    jsonGenerator.O000000o((int) sArr[i]);
                    this.f12561O000000o.O00000o(null, jsonGenerator);
                    i++;
                }
                return;
            }
            int length2 = sArr.length;
            while (i < length2) {
                jsonGenerator.O000000o((int) sArr[i]);
                i++;
            }
        }

        public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
            return ((short[]) obj).length == 1;
        }

        static {
            asq.O000000o();
        }

        public O0000Oo() {
            super(short[].class);
        }

        private O0000Oo(O0000Oo o0000Oo, ajr ajr, aoi aoi) {
            super(o0000Oo, ajr, aoi);
        }

        public final apy<?> O00000Oo(aoi aoi) {
            return new O0000Oo(this, this.O00000o0, aoi);
        }
    }

    @akg
    public static final class O00000o0 extends asb<char[]> {
        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            char[] cArr = (char[]) obj;
            if (akf.O000000o(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                jsonGenerator.O00000Oo();
                O000000o(jsonGenerator, cArr);
                jsonGenerator.O00000o0();
                return;
            }
            jsonGenerator.O000000o(cArr, 0, cArr.length);
        }

        public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonProcessingException {
            char[] cArr = (char[]) obj;
            if (akf.O000000o(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                aoi.O00000o0(cArr, jsonGenerator);
                O000000o(jsonGenerator, cArr);
                aoi.O00000oo(cArr, jsonGenerator);
                return;
            }
            aoi.O000000o(cArr, jsonGenerator);
            jsonGenerator.O000000o(cArr, 0, cArr.length);
            aoi.O00000o(cArr, jsonGenerator);
        }

        public final /* bridge */ /* synthetic */ boolean O000000o(Object obj) {
            char[] cArr = (char[]) obj;
            return cArr == null || cArr.length == 0;
        }

        public O00000o0() {
            super(char[].class);
        }

        private static void O000000o(JsonGenerator jsonGenerator, char[] cArr) throws IOException, JsonGenerationException {
            int length = cArr.length;
            for (int i = 0; i < length; i++) {
                jsonGenerator.O000000o(cArr, i, 1);
            }
        }
    }

    @akg
    public static final class O0000OOo extends aqy<int[]> {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final ajv f12560O000000o = asq.O000000o((Class<?>) Integer.TYPE);

        public final apy<?> O00000Oo(aoi aoi) {
            return this;
        }

        public final /* bridge */ /* synthetic */ boolean O000000o(Object obj) {
            int[] iArr = (int[]) obj;
            return iArr == null || iArr.length == 0;
        }

        public final /* synthetic */ void O00000Oo(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            for (int O000000o2 : (int[]) obj) {
                jsonGenerator.O000000o(O000000o2);
            }
        }

        public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
            return ((int[]) obj).length == 1;
        }

        static {
            asq.O000000o();
        }

        public O0000OOo() {
            super(int[].class, (byte) 0);
        }
    }

    @akg
    public static final class O0000Oo0 extends O0000o00<long[]> {
        private static final ajv O00000Oo = asq.O000000o((Class<?>) Long.TYPE);

        public final /* bridge */ /* synthetic */ boolean O000000o(Object obj) {
            long[] jArr = (long[]) obj;
            return jArr == null || jArr.length == 0;
        }

        public final /* synthetic */ void O00000Oo(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            long[] jArr = (long[]) obj;
            int i = 0;
            if (this.f12561O000000o != null) {
                int length = jArr.length;
                while (i < length) {
                    this.f12561O000000o.O000000o((Object) null, jsonGenerator, Long.TYPE);
                    jsonGenerator.O000000o(jArr[i]);
                    this.f12561O000000o.O00000o(null, jsonGenerator);
                    i++;
                }
                return;
            }
            int length2 = jArr.length;
            while (i < length2) {
                jsonGenerator.O000000o(jArr[i]);
                i++;
            }
        }

        public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
            return ((long[]) obj).length == 1;
        }

        static {
            asq.O000000o();
        }

        public O0000Oo0() {
            super(long[].class);
        }

        private O0000Oo0(O0000Oo0 o0000Oo0, ajr ajr, aoi aoi) {
            super(o0000Oo0, ajr, aoi);
        }

        public final apy<?> O00000Oo(aoi aoi) {
            return new O0000Oo0(this, this.O00000o0, aoi);
        }
    }

    @akg
    public static final class O0000O0o extends O0000o00<float[]> {
        private static final ajv O00000Oo = asq.O000000o((Class<?>) Float.TYPE);

        public final /* bridge */ /* synthetic */ boolean O000000o(Object obj) {
            float[] fArr = (float[]) obj;
            return fArr == null || fArr.length == 0;
        }

        public final /* synthetic */ void O00000Oo(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            float[] fArr = (float[]) obj;
            int i = 0;
            if (this.f12561O000000o != null) {
                int length = fArr.length;
                while (i < length) {
                    this.f12561O000000o.O000000o((Object) null, jsonGenerator, Float.TYPE);
                    jsonGenerator.O000000o(fArr[i]);
                    this.f12561O000000o.O00000o(null, jsonGenerator);
                    i++;
                }
                return;
            }
            int length2 = fArr.length;
            while (i < length2) {
                jsonGenerator.O000000o(fArr[i]);
                i++;
            }
        }

        public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
            return ((float[]) obj).length == 1;
        }

        static {
            asq.O000000o();
        }

        public O0000O0o() {
            super(float[].class);
        }

        private O0000O0o(O0000O0o o0000O0o, ajr ajr, aoi aoi) {
            super(o0000O0o, ajr, aoi);
        }

        public final apy<?> O00000Oo(aoi aoi) {
            return new O0000O0o(this, this.O00000o0, aoi);
        }
    }

    @akg
    public static final class O00000o extends aqy<double[]> {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final ajv f12559O000000o = asq.O000000o((Class<?>) Double.TYPE);

        public final apy<?> O00000Oo(aoi aoi) {
            return this;
        }

        public final /* bridge */ /* synthetic */ boolean O000000o(Object obj) {
            double[] dArr = (double[]) obj;
            return dArr == null || dArr.length == 0;
        }

        public final /* synthetic */ void O00000Oo(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
            for (double O000000o2 : (double[]) obj) {
                jsonGenerator.O000000o(O000000o2);
            }
        }

        public final /* bridge */ /* synthetic */ boolean O00000Oo(Object obj) {
            return ((double[]) obj).length == 1;
        }

        static {
            asq.O000000o();
        }

        public O00000o() {
            super(double[].class, (byte) 0);
        }
    }
}
