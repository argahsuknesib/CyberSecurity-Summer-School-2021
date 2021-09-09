package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.lang.reflect.Array;

@akg
public final class amw extends aml<Object[]> implements alc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final asg f12471O000000o;
    protected final boolean O00000Oo;
    protected ajw<Object> O00000o;
    protected final Class<?> O00000o0;
    protected final aof O00000oO;

    public amw(asg asg, ajw<Object> ajw, aof aof) {
        super(Object[].class);
        this.f12471O000000o = asg;
        this.O00000o0 = asg.O0000o0o().O00000Oo();
        this.O00000Oo = this.O00000o0 == Object.class;
        this.O00000o = ajw;
        this.O00000oO = aof;
    }

    public final ajw<?> O000000o(ajt ajt, ajr ajr) throws JsonMappingException {
        ajw<?> ajw = this.O00000o;
        if (ajw == null) {
            ajw = ajt.O000000o(this.f12471O000000o.O0000o0o(), ajr);
        } else if (ajw instanceof alc) {
            ajw = ((alc) ajw).O000000o(ajt, ajr);
        }
        aof aof = this.O00000oO;
        if (aof != null) {
            aof = aof.O000000o(ajr);
        }
        if (ajw == this.O00000o && aof == this.O00000oO) {
            return this;
        }
        return new amw(this.f12471O000000o, ajw, aof);
    }

    public final ajw<Object> O00000o() {
        return this.O00000o;
    }

    public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        return (Object[]) aof.O00000Oo(jsonParser, ajt);
    }

    public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        Object[] objArr;
        Object obj;
        Object[] objArr2;
        Object obj2 = null;
        if (jsonParser.O0000Oo0()) {
            atc O0000Oo = ajt.O0000Oo();
            Object[] O000000o2 = O0000Oo.O000000o();
            aof aof = this.O00000oO;
            int i = 0;
            while (true) {
                JsonToken O00000Oo2 = jsonParser.O00000Oo();
                if (O00000Oo2 == JsonToken.END_ARRAY) {
                    break;
                }
                if (O00000Oo2 == JsonToken.VALUE_NULL) {
                    obj = null;
                } else if (aof == null) {
                    obj = this.O00000o.O000000o(jsonParser, ajt);
                } else {
                    obj = this.O00000o.O000000o(jsonParser, ajt, aof);
                }
                if (i >= O000000o2.length) {
                    O000000o2 = O0000Oo.O000000o(O000000o2);
                    i = 0;
                }
                O000000o2[i] = obj;
                i++;
            }
            if (this.O00000Oo) {
                objArr = O0000Oo.O000000o(O000000o2, i);
            } else {
                objArr = O0000Oo.O000000o(O000000o2, i, this.O00000o0);
            }
            ajt.O000000o(O0000Oo);
            return objArr;
        } else if (jsonParser.O00000oO() == JsonToken.VALUE_STRING && ajt.O000000o(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.O0000OoO().length() == 0) {
            return null;
        } else {
            if (ajt.O000000o(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                if (jsonParser.O00000oO() != JsonToken.VALUE_NULL) {
                    aof aof2 = this.O00000oO;
                    if (aof2 == null) {
                        obj2 = this.O00000o.O000000o(jsonParser, ajt);
                    } else {
                        obj2 = this.O00000o.O000000o(jsonParser, ajt, aof2);
                    }
                }
                if (this.O00000Oo) {
                    objArr2 = new Object[1];
                } else {
                    objArr2 = (Object[]) Array.newInstance(this.O00000o0, 1);
                }
                objArr2[0] = obj2;
                return objArr2;
            } else if (jsonParser.O00000oO() == JsonToken.VALUE_STRING && this.O00000o0 == Byte.class) {
                byte[] O000000o3 = jsonParser.O000000o(ajs.O00000oO());
                Byte[] bArr = new Byte[O000000o3.length];
                int length = O000000o3.length;
                for (int i2 = 0; i2 < length; i2++) {
                    bArr[i2] = Byte.valueOf(O000000o3[i2]);
                }
                return bArr;
            } else {
                throw ajt.O00000Oo(this.f12471O000000o.O00000Oo());
            }
        }
    }
}
