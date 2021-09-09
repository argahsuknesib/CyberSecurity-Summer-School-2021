package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tencent.mmkv.MMKVRecoverStrategic;
import java.io.IOException;
import java.util.EnumMap;

public final class amo extends amy<EnumMap<?, ?>> implements alc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ajv f12461O000000o;
    protected final Class<?> O00000Oo;
    protected ajw<Object> O00000o;
    protected ajw<Enum<?>> O00000o0;

    public final boolean O00000o0() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [_m_j.ajw<?>, _m_j.ajw<java.lang.Enum<?>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public amo(ajv ajv, ajw<?> r3, ajw<?> ajw) {
        super(EnumMap.class);
        this.f12461O000000o = ajv;
        this.O00000Oo = ajv.O0000o0O().O00000Oo();
        this.O00000o0 = r3;
        this.O00000o = ajw;
    }

    public final ajw<?> O000000o(ajt ajt, ajr ajr) throws JsonMappingException {
        ajw ajw = this.O00000o0;
        if (ajw == null) {
            ajw = ajt.O000000o(this.f12461O000000o.O0000o0O(), ajr);
        }
        ajw<?> ajw2 = this.O00000o;
        if (ajw2 == null) {
            ajw2 = ajt.O000000o(this.f12461O000000o.O0000o0o(), ajr);
        } else if (ajw2 instanceof alc) {
            ajw2 = ((alc) ajw2).O000000o(ajt, ajr);
        }
        if (ajw == this.O00000o0 && ajw2 == this.O00000o) {
            return this;
        }
        return new amo(this.f12461O000000o, ajw, ajw2);
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        return aof.O000000o(jsonParser, ajt);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [java.lang.Enum, java.lang.Object]
     candidates:
      ClspMth{java.util.EnumMap.put(java.lang.Object, java.lang.Object):java.lang.Object}
      ClspMth{java.util.AbstractMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        if (jsonParser.O00000oO() == JsonToken.START_OBJECT) {
            EnumMap enumMap = new EnumMap(this.O00000Oo);
            while (jsonParser.O00000Oo() != JsonToken.END_OBJECT) {
                Enum O000000o2 = this.O00000o0.O000000o(jsonParser, ajt);
                if (O000000o2 != null) {
                    enumMap.put((MMKVRecoverStrategic) O000000o2, (Integer) (jsonParser.O00000Oo() == JsonToken.VALUE_NULL ? null : this.O00000o.O000000o(jsonParser, ajt)));
                } else if (ajt.O000000o(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                    jsonParser.O00000Oo();
                    jsonParser.O00000o();
                } else {
                    throw ajt.O00000Oo(this.O00000Oo, "value not one of declared Enum instance names");
                }
            }
            return enumMap;
        }
        throw ajt.O00000Oo((Class<?>) EnumMap.class);
    }
}
