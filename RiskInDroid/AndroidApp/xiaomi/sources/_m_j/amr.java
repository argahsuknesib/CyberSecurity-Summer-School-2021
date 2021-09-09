package _m_j;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

public final class amr {

    public static class O000000o extends anb<ajv> {
        public O000000o() {
            super(ajv.class);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            JsonToken O00000oO = jsonParser.O00000oO();
            if (O00000oO == JsonToken.VALUE_STRING) {
                String trim = jsonParser.O0000OoO().trim();
                if (trim.length() == 0) {
                    return (ajv) O000000o();
                }
                return ajt.O0000O0o().O000000o(trim);
            } else if (O00000oO == JsonToken.VALUE_EMBEDDED_OBJECT) {
                return (ajv) jsonParser.O00oOooO();
            } else {
                throw ajt.O00000Oo((Class<?>) this.O0000oOO);
            }
        }
    }

    public static class O00000Oo extends aln {
        public final boolean O0000Oo0() {
            return true;
        }

        public final String O000000o() {
            return JsonLocation.class.getName();
        }

        public final Object O000000o(Object[] objArr) {
            return new JsonLocation(objArr[0], O000000o(objArr[1]), O000000o(objArr[2]), O00000Oo(objArr[3]), O00000Oo(objArr[4]));
        }

        private static final long O000000o(Object obj) {
            if (obj == null) {
                return 0;
            }
            return ((Number) obj).longValue();
        }

        private static final int O00000Oo(Object obj) {
            if (obj == null) {
                return 0;
            }
            return ((Number) obj).intValue();
        }

        public final /* synthetic */ alm[] O000000o(ajs ajs) {
            ajv O00000Oo = ajs.O00000Oo(Integer.TYPE);
            ajv O00000Oo2 = ajs.O00000Oo(Long.TYPE);
            ajv ajv = O00000Oo;
            return new ale[]{new ale("sourceRef", ajs.O00000Oo(Object.class), null, null, null, 0, null), new ale("byteOffset", O00000Oo2, null, null, null, 1, null), new ale("charOffset", O00000Oo2, null, null, null, 2, null), new ale("lineNr", ajv, null, null, null, 3, null), new ale("columnNr", ajv, null, null, null, 4, null)};
        }
    }

    @akg
    public static class O00000o0 extends anb<ath> {
        public O00000o0() {
            super(ath.class);
        }

        public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
            ath ath = new ath(jsonParser.O000000o());
            ath.O00000Oo(jsonParser);
            return ath;
        }
    }
}
