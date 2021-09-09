package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Collection;

@akg
public final class and extends aml<Collection<String>> implements alc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ajv f12478O000000o;
    protected final ajw<String> O00000Oo;
    protected final ajw<Object> O00000o;
    protected final aln O00000o0;

    public final /* bridge */ /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        return O000000o(jsonParser, ajt, (Collection<String>) ((Collection) obj));
    }

    public and(ajv ajv, ajw<?> ajw, aln aln) {
        this(ajv, aln, null, ajw);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [_m_j.ajw<?>, _m_j.ajw<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private and(ajv ajv, aln aln, ajw<?> ajw, ajw<?> r5) {
        super(ajv.O00000Oo());
        this.f12478O000000o = ajv;
        this.O00000Oo = r5;
        this.O00000o0 = aln;
        this.O00000o = ajw;
    }

    public final ajw<?> O000000o(ajt ajt, ajr ajr) throws JsonMappingException {
        ajw<Object> ajw;
        ajw<?> ajw2;
        aln aln = this.O00000o0;
        if (aln == null || aln.O0000o00() == null) {
            ajw = null;
        } else {
            ajw = ajt.O000000o(this.O00000o0.O0000Oo(), ajr);
        }
        ajw<String> ajw3 = this.O00000Oo;
        if (ajw3 == null) {
            ajw2 = ajt.O000000o(this.f12478O000000o.O0000o0o(), ajr);
        } else {
            ajw2 = ajw3 instanceof alc ? ((alc) ajw3).O000000o(ajt, ajr) : ajw3;
        }
        if ((ajw2 == null || ajw2.getClass().getAnnotation(akg.class) == null) ? false : true) {
            ajw2 = null;
        }
        if (this.O00000Oo == ajw2 && this.O00000o == ajw) {
            return this;
        }
        return new and(this.f12478O000000o, this.O00000o0, ajw, ajw2);
    }

    public final ajw<Object> O00000o() {
        return this.O00000Oo;
    }

    private Collection<String> O000000o(JsonParser jsonParser, ajt ajt, Collection<String> collection) throws IOException, JsonProcessingException {
        String str;
        String str2 = null;
        if (jsonParser.O0000Oo0()) {
            ajw<String> ajw = this.O00000Oo;
            if (ajw != null) {
                while (true) {
                    JsonToken O00000Oo2 = jsonParser.O00000Oo();
                    if (O00000Oo2 == JsonToken.END_ARRAY) {
                        return collection;
                    }
                    if (O00000Oo2 == JsonToken.VALUE_NULL) {
                        str = null;
                    } else {
                        str = ajw.O000000o(jsonParser, ajt);
                    }
                    collection.add(str);
                }
            } else {
                while (true) {
                    JsonToken O00000Oo3 = jsonParser.O00000Oo();
                    if (O00000Oo3 == JsonToken.END_ARRAY) {
                        return collection;
                    }
                    collection.add(O00000Oo3 == JsonToken.VALUE_NULL ? null : jsonParser.O0000OoO());
                }
            }
        } else if (ajt.O000000o(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            ajw<String> ajw2 = this.O00000Oo;
            if (jsonParser.O00000oO() != JsonToken.VALUE_NULL) {
                str2 = ajw2 == null ? jsonParser.O0000OoO() : ajw2.O000000o(jsonParser, ajt);
            }
            collection.add(str2);
            return collection;
        } else {
            throw ajt.O00000Oo(this.f12478O000000o.O00000Oo());
        }
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        return aof.O00000Oo(jsonParser, ajt);
    }

    public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        ajw<Object> ajw = this.O00000o;
        if (ajw != null) {
            return (Collection) this.O00000o0.O000000o(ajt, ajw.O000000o(jsonParser, ajt));
        }
        return O000000o(jsonParser, ajt, (Collection<String>) ((Collection) this.O00000o0.O0000OoO()));
    }
}
