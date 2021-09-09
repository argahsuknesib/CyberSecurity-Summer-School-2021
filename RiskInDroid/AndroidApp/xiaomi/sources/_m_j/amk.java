package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Collection;

@akg
public final class amk extends aml<Collection<Object>> implements alc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ajv f12457O000000o;
    protected final ajw<Object> O00000Oo;
    protected final aln O00000o;
    protected final aof O00000o0;
    protected final ajw<Object> O00000oO;

    public final /* bridge */ /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        return O000000o(jsonParser, ajt, (Collection<Object>) ((Collection) obj));
    }

    public amk(ajv ajv, ajw<Object> ajw, aof aof, aln aln) {
        this(ajv, ajw, aof, aln, null);
    }

    private amk(ajv ajv, ajw<Object> ajw, aof aof, aln aln, ajw<Object> ajw2) {
        super(ajv.O00000Oo());
        this.f12457O000000o = ajv;
        this.O00000Oo = ajw;
        this.O00000o0 = aof;
        this.O00000o = aln;
        this.O00000oO = ajw2;
    }

    public final ajw<Object> O00000o() {
        return this.O00000Oo;
    }

    private Collection<Object> O000000o(JsonParser jsonParser, ajt ajt, Collection<Object> collection) throws IOException, JsonProcessingException {
        Object obj;
        Object obj2 = null;
        if (jsonParser.O0000Oo0()) {
            ajw<Object> ajw = this.O00000Oo;
            aof aof = this.O00000o0;
            while (true) {
                JsonToken O00000Oo2 = jsonParser.O00000Oo();
                if (O00000Oo2 == JsonToken.END_ARRAY) {
                    return collection;
                }
                if (O00000Oo2 == JsonToken.VALUE_NULL) {
                    obj = null;
                } else if (aof == null) {
                    obj = ajw.O000000o(jsonParser, ajt);
                } else {
                    obj = ajw.O000000o(jsonParser, ajt, aof);
                }
                collection.add(obj);
            }
        } else if (ajt.O000000o(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            ajw<Object> ajw2 = this.O00000Oo;
            aof aof2 = this.O00000o0;
            if (jsonParser.O00000oO() != JsonToken.VALUE_NULL) {
                if (aof2 == null) {
                    obj2 = ajw2.O000000o(jsonParser, ajt);
                } else {
                    obj2 = ajw2.O000000o(jsonParser, ajt, aof2);
                }
            }
            collection.add(obj2);
            return collection;
        } else {
            throw ajt.O00000Oo(this.f12457O000000o.O00000Oo());
        }
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        return aof.O00000Oo(jsonParser, ajt);
    }

    public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        ajw<Object> ajw = this.O00000oO;
        if (ajw != null) {
            return (Collection) this.O00000o.O000000o(ajt, ajw.O000000o(jsonParser, ajt));
        }
        if (jsonParser.O00000oO() == JsonToken.VALUE_STRING) {
            String O0000OoO = jsonParser.O0000OoO();
            if (O0000OoO.length() == 0) {
                return (Collection) this.O00000o.O000000o(ajt, O0000OoO);
            }
        }
        return O000000o(jsonParser, ajt, (Collection<Object>) ((Collection) this.O00000o.O0000OoO()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    public final /* synthetic */ ajw O000000o(ajt ajt, ajr ajr) throws JsonMappingException {
        ajw<Object> ajw;
        ajw<?> ajw2;
        aof aof;
        aof aof2;
        ajw<?> O000000o2;
        aln aln = this.O00000o;
        if (aln == null || !aln.O0000OOo()) {
            ajw = null;
        } else {
            ajv O0000Oo = this.O00000o.O0000Oo();
            if (O0000Oo != null) {
                ajw = ajt.O000000o(O0000Oo, ajr);
            } else {
                throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.f12457O000000o + ": value instantiator (" + this.O00000o.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
        }
        ajw<Object> ajw3 = ajw;
        ajw<?> ajw4 = this.O00000Oo;
        if (ajw4 == null) {
            O000000o2 = ajt.O000000o(this.f12457O000000o.O0000o0o(), ajr);
        } else if (ajw4 instanceof alc) {
            O000000o2 = ((alc) ajw4).O000000o(ajt, ajr);
        } else {
            ajw2 = ajw4;
            aof = this.O00000o0;
            if (aof != null) {
                aof = aof.O000000o(ajr);
            }
            aof2 = aof;
            if (ajw3 != this.O00000oO && ajw2 == this.O00000Oo && aof2 == this.O00000o0) {
                return this;
            }
            return new amk(this.f12457O000000o, ajw2, aof2, this.O00000o, ajw3);
        }
        ajw2 = O000000o2;
        aof = this.O00000o0;
        if (aof != null) {
        }
        aof2 = aof;
        if (ajw3 != this.O00000oO) {
        }
        return new amk(this.f12457O000000o, ajw2, aof2, this.O00000o, ajw3);
    }
}
