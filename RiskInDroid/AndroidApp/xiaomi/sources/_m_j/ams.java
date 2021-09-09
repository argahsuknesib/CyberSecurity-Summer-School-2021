package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class ams {

    @akg
    public static final class O0000o00 extends anb<String> {
        public O0000o00() {
            super(String.class);
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000o0 */
        public String O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            JsonToken O00000oO = jsonParser.O00000oO();
            if (O00000oO == JsonToken.VALUE_STRING) {
                return jsonParser.O0000OoO();
            }
            if (O00000oO == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object O00oOooO = jsonParser.O00oOooO();
                if (O00oOooO == null) {
                    return null;
                }
                if (O00oOooO instanceof byte[]) {
                    return aij.O000000o().O000000o((byte[]) O00oOooO, false);
                }
                return O00oOooO.toString();
            } else if (O00000oO.isScalarValue()) {
                return jsonParser.O0000OoO();
            } else {
                throw ajt.O000000o(this.O0000oOO, O00000oO);
            }
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
            return O000000o(jsonParser, ajt);
        }
    }

    public static class O00oOooO extends amq<UUID> {
        public O00oOooO() {
            super(UUID.class);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object O000000o(Object obj, ajt ajt) throws IOException, JsonProcessingException {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (bArr.length != 16) {
                    ajt.O00000Oo("Can only construct UUIDs from 16 byte arrays; got " + bArr.length + " bytes");
                }
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
                return new UUID(dataInputStream.readLong(), dataInputStream.readLong());
            }
            super.O000000o(obj, ajt);
            return null;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object O000000o(String str) throws IOException, JsonProcessingException {
            return UUID.fromString(str);
        }
    }

    public static class O0000o extends amq<URL> {
        public O0000o() {
            super(URL.class);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object O000000o(String str) throws IOException, JsonProcessingException {
            return new URL(str);
        }
    }

    public static class O0000o0 extends amq<URI> {
        public O0000o0() {
            super(URI.class);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object O000000o(String str) throws IOException, JsonProcessingException {
            return URI.create(str);
        }
    }

    public static class O00000o extends amq<Currency> {
        public O00000o() {
            super(Currency.class);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object O000000o(String str) throws IOException, JsonProcessingException {
            return Currency.getInstance(str);
        }
    }

    public static class O0000Oo0 extends amq<Pattern> {
        public O0000Oo0() {
            super(Pattern.class);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object O000000o(String str) throws IOException, JsonProcessingException {
            return Pattern.compile(str);
        }
    }

    public static class O0000OOo extends amq<Locale> {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object O000000o(String str) throws IOException, JsonProcessingException {
            return O00000Oo(str);
        }

        public O0000OOo() {
            super(Locale.class);
        }

        protected static Locale O00000Oo(String str) throws IOException {
            int indexOf = str.indexOf(95);
            if (indexOf < 0) {
                return new Locale(str);
            }
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1);
            int indexOf2 = substring2.indexOf(95);
            if (indexOf2 < 0) {
                return new Locale(substring, substring2);
            }
            return new Locale(substring, substring2.substring(0, indexOf2), substring2.substring(indexOf2 + 1));
        }
    }

    public static class O0000O0o extends amq<InetAddress> {
        public O0000O0o() {
            super(InetAddress.class);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object O000000o(String str) throws IOException, JsonProcessingException {
            return InetAddress.getByName(str);
        }
    }

    public static class O00000o0 extends amq<Charset> {
        public O00000o0() {
            super(Charset.class);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object O000000o(String str) throws IOException, JsonProcessingException {
            return Charset.forName(str);
        }
    }

    public static class O00000Oo extends anb<AtomicReference<?>> implements alc {

        /* renamed from: O000000o  reason: collision with root package name */
        protected final ajv f12463O000000o;
        protected final ajw<?> O00000Oo;

        public O00000Oo(ajv ajv) {
            this(ajv, null);
        }

        private O00000Oo(ajv ajv, ajw<?> ajw) {
            super(AtomicReference.class);
            this.f12463O000000o = ajv;
            this.O00000Oo = ajw;
        }

        public final ajw<?> O000000o(ajt ajt, ajr ajr) throws JsonMappingException {
            if (this.O00000Oo != null) {
                return this;
            }
            ajv ajv = this.f12463O000000o;
            return new O00000Oo(ajv, ajt.O000000o(ajv, ajr));
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            return new AtomicReference(this.O00000Oo.O000000o(jsonParser, ajt));
        }
    }

    public static class O000000o extends anb<AtomicBoolean> {
        public O000000o() {
            super(AtomicBoolean.class);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            return new AtomicBoolean(O00000oO(jsonParser, ajt));
        }
    }

    public static class O0000Oo extends anb<StackTraceElement> {
        public O0000Oo() {
            super(StackTraceElement.class);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            JsonToken O00000oO = jsonParser.O00000oO();
            if (O00000oO == JsonToken.START_OBJECT) {
                String str = "";
                String str2 = str;
                String str3 = str2;
                int i = -1;
                while (true) {
                    JsonToken O00000o0 = jsonParser.O00000o0();
                    if (O00000o0 == JsonToken.END_OBJECT) {
                        return new StackTraceElement(str, str2, str3, i);
                    }
                    String O00000oo = jsonParser.O00000oo();
                    if ("className".equals(O00000oo)) {
                        str = jsonParser.O0000OoO();
                    } else if ("fileName".equals(O00000oo)) {
                        str3 = jsonParser.O0000OoO();
                    } else if ("lineNumber".equals(O00000oo)) {
                        if (O00000o0.isNumeric()) {
                            i = jsonParser.O0000oOO();
                        } else {
                            throw JsonMappingException.from(jsonParser, "Non-numeric token (" + O00000o0 + ") for property 'lineNumber'");
                        }
                    } else if ("methodName".equals(O00000oo)) {
                        str2 = jsonParser.O0000OoO();
                    } else if (!"nativeMethod".equals(O00000oo)) {
                        O000000o(jsonParser, ajt, this.O0000oOO, O00000oo);
                    }
                }
            } else {
                throw ajt.O000000o(this.O0000oOO, O00000oO);
            }
        }
    }
}
