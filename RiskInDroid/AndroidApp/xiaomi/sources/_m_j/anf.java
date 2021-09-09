package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

public class anf extends akw {
    public anf(akw akw) {
        super(akw);
        this.O0000O0o = false;
    }

    private anf(akw akw, atb atb) {
        super(akw, atb);
    }

    public final ajw<Object> O000000o(atb atb) {
        if (getClass() != anf.class) {
            return this;
        }
        return new anf(this, atb);
    }

    public final Object a_(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        Object obj;
        if (this.O00000oO != null) {
            return O00000o0(jsonParser, ajt);
        }
        if (this.O00000o != null) {
            return this.O00000o0.O000000o(ajt, this.O00000o.O000000o(jsonParser, ajt));
        }
        if (!this.O00000Oo.O00000o0()) {
            boolean O00000Oo = this.O00000o0.O00000Oo();
            boolean O0000O0o = this.O00000o0.O0000O0o();
            if (O00000Oo || O0000O0o) {
                Object obj2 = null;
                Object[] objArr = null;
                int i = 0;
                while (jsonParser.O00000oO() != JsonToken.END_OBJECT) {
                    String O00000oo = jsonParser.O00000oo();
                    alm O000000o2 = this.O0000OOo.O000000o(O00000oo);
                    jsonParser.O00000Oo();
                    if (O000000o2 != null) {
                        if (obj2 != null) {
                            O000000o2.O000000o(jsonParser, ajt, obj2);
                        } else {
                            if (objArr == null) {
                                int i2 = this.O0000OOo.f12434O000000o;
                                objArr = new Object[(i2 + i2)];
                            }
                            int i3 = i + 1;
                            objArr[i] = O000000o2;
                            i = i3 + 1;
                            objArr[i3] = O000000o2.O000000o(jsonParser, ajt);
                        }
                    } else if ("message".equals(O00000oo) && O00000Oo) {
                        obj2 = this.O00000o0.O000000o(ajt, jsonParser.O0000OoO());
                        if (objArr != null) {
                            for (int i4 = 0; i4 < i; i4 += 2) {
                                ((alm) objArr[i4]).O000000o(obj2, objArr[i4 + 1]);
                            }
                            objArr = null;
                        }
                    } else if (this.O0000OoO != null && this.O0000OoO.contains(O00000oo)) {
                        jsonParser.O00000o();
                    } else if (this.O0000Oo != null) {
                        this.O0000Oo.O000000o(jsonParser, ajt, obj2, O00000oo);
                    } else {
                        O000000o(jsonParser, ajt, obj2, O00000oo);
                    }
                    jsonParser.O00000Oo();
                }
                if (obj2 == null) {
                    if (O00000Oo) {
                        obj = this.O00000o0.O000000o(ajt, (String) null);
                    } else {
                        obj = this.O00000o0.O0000OoO();
                    }
                    obj2 = obj;
                    if (objArr != null) {
                        for (int i5 = 0; i5 < i; i5 += 2) {
                            ((alm) objArr[i5]).O000000o(obj2, objArr[i5 + 1]);
                        }
                    }
                }
                return obj2;
            }
            throw new JsonMappingException("Can not deserialize Throwable of type " + this.O00000Oo + " without having a default contructor, a single-String-arg constructor; or explicit @JsonCreator");
        }
        throw JsonMappingException.from(jsonParser, "Can not instantiate abstract type " + this.O00000Oo + " (need to add/enable type information?)");
    }
}
