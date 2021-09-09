package _m_j;

import _m_j.amb;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Map;

@akg
public final class amu extends aml<Map<Object, Object>> implements alc, alk {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ajv f12468O000000o;
    protected final aka O00000Oo;
    protected final ajw<Object> O00000o;
    protected boolean O00000o0;
    protected final aof O00000oO;
    protected final aln O00000oo;
    protected final boolean O0000O0o;
    protected ajw<Object> O0000OOo;
    protected HashSet<String> O0000Oo;
    protected alz O0000Oo0;

    public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        Map map = (Map) obj;
        JsonToken O00000oO2 = jsonParser.O00000oO();
        if (O00000oO2 != JsonToken.START_OBJECT && O00000oO2 != JsonToken.FIELD_NAME) {
            throw ajt.O00000Oo(this.f12468O000000o.O00000Oo());
        } else if (this.O00000o0) {
            O00000Oo(jsonParser, ajt, map);
            return map;
        } else {
            O000000o(jsonParser, ajt, (Map<Object, Object>) map);
            return map;
        }
    }

    public amu(ajv ajv, aln aln, aka aka, ajw<Object> ajw, aof aof) {
        super(Map.class);
        this.f12468O000000o = ajv;
        this.O00000Oo = aka;
        this.O00000o = ajw;
        this.O00000oO = aof;
        this.O00000oo = aln;
        this.O0000O0o = aln.O0000O0o();
        this.O0000OOo = null;
        this.O0000Oo0 = null;
        this.O00000o0 = O000000o(ajv, aka);
    }

    private amu(amu amu, aka aka, ajw<Object> ajw, aof aof, HashSet<String> hashSet) {
        super(amu.O0000oOO);
        this.f12468O000000o = amu.f12468O000000o;
        this.O00000Oo = aka;
        this.O00000o = ajw;
        this.O00000oO = aof;
        this.O00000oo = amu.O00000oo;
        this.O0000Oo0 = amu.O0000Oo0;
        this.O0000OOo = amu.O0000OOo;
        this.O0000O0o = amu.O0000O0o;
        this.O0000Oo = hashSet;
        this.O00000o0 = O000000o(this.f12468O000000o, aka);
    }

    private static boolean O000000o(ajv ajv, aka aka) {
        ajv O0000o0O;
        if (aka == null || (O0000o0O = ajv.O0000o0O()) == null) {
            return true;
        }
        Class<?> O00000Oo2 = O0000o0O.O00000Oo();
        if ((O00000Oo2 == String.class || O00000Oo2 == Object.class) && O000000o(aka)) {
            return true;
        }
        return false;
    }

    public final void O000000o(String[] strArr) {
        this.O0000Oo = (strArr == null || strArr.length == 0) ? null : asu.O000000o(strArr);
    }

    public final void O000000o(ajt ajt) throws JsonMappingException {
        if (this.O00000oo.O0000OOo()) {
            ajv O0000Oo2 = this.O00000oo.O0000Oo();
            if (O0000Oo2 != null) {
                this.O0000OOo = ajt.O000000o(O0000Oo2, (ajr) null);
            } else {
                throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.f12468O000000o + ": value instantiator (" + this.O00000oo.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
        }
        if (this.O00000oo.O0000Oo0()) {
            this.O0000Oo0 = alz.O000000o(ajt, this.O00000oo, this.O00000oo.O000000o(ajt.O000000o()));
        }
        this.O00000o0 = O000000o(this.f12468O000000o, this.O00000Oo);
    }

    public final ajw<?> O000000o(ajt ajt, ajr ajr) throws JsonMappingException {
        HashSet<String> hashSet;
        String[] O00000Oo2;
        aka aka = this.O00000Oo;
        if (aka == null) {
            aka = ajt.O00000Oo(this.f12468O000000o.O0000o0O());
        } else if (aka instanceof ald) {
            aka = ((ald) aka).O000000o();
        }
        aka aka2 = aka;
        ajw<?> ajw = this.O00000o;
        if (ajw == null) {
            ajw = ajt.O000000o(this.f12468O000000o.O0000o0o(), ajr);
        } else if (ajw instanceof alc) {
            ajw = ((alc) ajw).O000000o(ajt, ajr);
        }
        ajw<?> ajw2 = ajw;
        aof aof = this.O00000oO;
        if (aof != null) {
            aof = aof.O000000o(ajr);
        }
        aof aof2 = aof;
        HashSet<String> hashSet2 = this.O0000Oo;
        AnnotationIntrospector O00000Oo3 = ajt.O00000Oo();
        if (O00000Oo3 == null || ajr == null || (O00000Oo2 = O00000Oo3.O00000Oo((ani) ajr.O00000Oo())) == null) {
            hashSet = hashSet2;
        } else {
            HashSet<String> hashSet3 = hashSet2 == null ? new HashSet<>() : new HashSet<>(hashSet2);
            for (String add : O00000Oo2) {
                hashSet3.add(add);
            }
            hashSet = hashSet3;
        }
        if (this.O00000Oo == aka2 && this.O00000o == ajw2 && this.O00000oO == aof2 && this.O0000Oo == hashSet) {
            return this;
        }
        return new amu(this, aka2, ajw2, aof2, hashSet);
    }

    public final ajw<Object> O00000o() {
        return this.O00000o;
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt, aof aof) throws IOException, JsonProcessingException {
        return aof.O000000o(jsonParser, ajt);
    }

    private void O000000o(JsonParser jsonParser, ajt ajt, Map<Object, Object> map) throws IOException, JsonProcessingException {
        Object obj;
        JsonToken O00000oO2 = jsonParser.O00000oO();
        if (O00000oO2 == JsonToken.START_OBJECT) {
            O00000oO2 = jsonParser.O00000Oo();
        }
        aka aka = this.O00000Oo;
        ajw<Object> ajw = this.O00000o;
        aof aof = this.O00000oO;
        while (O00000oO2 == JsonToken.FIELD_NAME) {
            String O00000oo2 = jsonParser.O00000oo();
            Object O000000o2 = aka.O000000o(O00000oo2, ajt);
            JsonToken O00000Oo2 = jsonParser.O00000Oo();
            HashSet<String> hashSet = this.O0000Oo;
            if (hashSet == null || !hashSet.contains(O00000oo2)) {
                if (O00000Oo2 == JsonToken.VALUE_NULL) {
                    obj = null;
                } else if (aof == null) {
                    obj = ajw.O000000o(jsonParser, ajt);
                } else {
                    obj = ajw.O000000o(jsonParser, ajt, aof);
                }
                map.put(O000000o2, obj);
            } else {
                jsonParser.O00000o();
            }
            O00000oO2 = jsonParser.O00000Oo();
        }
    }

    private void O00000Oo(JsonParser jsonParser, ajt ajt, Map<Object, Object> map) throws IOException, JsonProcessingException {
        Object obj;
        JsonToken O00000oO2 = jsonParser.O00000oO();
        if (O00000oO2 == JsonToken.START_OBJECT) {
            O00000oO2 = jsonParser.O00000Oo();
        }
        ajw<Object> ajw = this.O00000o;
        aof aof = this.O00000oO;
        while (O00000oO2 == JsonToken.FIELD_NAME) {
            String O00000oo2 = jsonParser.O00000oo();
            JsonToken O00000Oo2 = jsonParser.O00000Oo();
            HashSet<String> hashSet = this.O0000Oo;
            if (hashSet == null || !hashSet.contains(O00000oo2)) {
                if (O00000Oo2 == JsonToken.VALUE_NULL) {
                    obj = null;
                } else if (aof == null) {
                    obj = ajw.O000000o(jsonParser, ajt);
                } else {
                    obj = ajw.O000000o(jsonParser, ajt, aof);
                }
                map.put(O00000oo2, obj);
            } else {
                jsonParser.O00000o();
            }
            O00000oO2 = jsonParser.O00000Oo();
        }
    }

    private Map<Object, Object> O00000o0(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        alz alz = this.O0000Oo0;
        amc O000000o2 = alz.O000000o(jsonParser, ajt);
        JsonToken O00000oO2 = jsonParser.O00000oO();
        if (O00000oO2 == JsonToken.START_OBJECT) {
            O00000oO2 = jsonParser.O00000Oo();
        }
        ajw<Object> ajw = this.O00000o;
        aof aof = this.O00000oO;
        while (true) {
            Object obj = null;
            if (O00000oO2 == JsonToken.FIELD_NAME) {
                String O00000oo2 = jsonParser.O00000oo();
                JsonToken O00000Oo2 = jsonParser.O00000Oo();
                HashSet<String> hashSet = this.O0000Oo;
                if (hashSet == null || !hashSet.contains(O00000oo2)) {
                    alm O000000o3 = alz.O000000o(O00000oo2);
                    if (O000000o3 != null) {
                        if (O000000o2.O000000o(O000000o3.O0000OoO(), O000000o3.O000000o(jsonParser, ajt))) {
                            jsonParser.O00000Oo();
                            try {
                                Map<Object, Object> map = (Map) alz.O000000o(O000000o2);
                                O000000o(jsonParser, ajt, map);
                                return map;
                            } catch (Exception e) {
                                O000000o(e, this.f12468O000000o.O00000Oo());
                                return null;
                            }
                        }
                    } else {
                        Object O000000o4 = this.O00000Oo.O000000o(jsonParser.O00000oo(), ajt);
                        if (O00000Oo2 != JsonToken.VALUE_NULL) {
                            if (aof == null) {
                                obj = ajw.O000000o(jsonParser, ajt);
                            } else {
                                obj = ajw.O000000o(jsonParser, ajt, aof);
                            }
                        }
                        O000000o2.O00000o = new amb.O00000Oo(O000000o2.O00000o, obj, O000000o4);
                    }
                } else {
                    jsonParser.O00000o();
                }
                O00000oO2 = jsonParser.O00000Oo();
            } else {
                try {
                    return (Map) alz.O000000o(O000000o2);
                } catch (Exception e2) {
                    O000000o(e2, this.f12468O000000o.O00000Oo());
                    return null;
                }
            }
        }
    }

    private static void O000000o(Throwable th, Object obj) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (!(th instanceof IOException) || (th instanceof JsonMappingException)) {
            throw JsonMappingException.wrapWithPath(th, obj, (String) null);
        } else {
            throw ((IOException) th);
        }
    }

    public final /* synthetic */ Object O000000o(JsonParser jsonParser, ajt ajt) throws IOException, JsonProcessingException {
        if (this.O0000Oo0 != null) {
            return O00000o0(jsonParser, ajt);
        }
        ajw<Object> ajw = this.O0000OOo;
        if (ajw != null) {
            return (Map) this.O00000oo.O000000o(ajt, ajw.O000000o(jsonParser, ajt));
        }
        if (this.O0000O0o) {
            JsonToken O00000oO2 = jsonParser.O00000oO();
            if (O00000oO2 == JsonToken.START_OBJECT || O00000oO2 == JsonToken.FIELD_NAME || O00000oO2 == JsonToken.END_OBJECT) {
                Map map = (Map) this.O00000oo.O0000OoO();
                if (this.O00000o0) {
                    O00000Oo(jsonParser, ajt, map);
                    return map;
                }
                O000000o(jsonParser, ajt, (Map<Object, Object>) map);
                return map;
            } else if (O00000oO2 == JsonToken.VALUE_STRING) {
                return (Map) this.O00000oo.O000000o(ajt, jsonParser.O0000OoO());
            } else {
                throw ajt.O00000Oo(this.f12468O000000o.O00000Oo());
            }
        } else {
            throw ajt.O000000o(this.f12468O000000o.O00000Oo(), "No default constructor found");
        }
    }
}
