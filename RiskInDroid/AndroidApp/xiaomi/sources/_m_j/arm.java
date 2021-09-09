package _m_j;

import _m_j.aqp;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@akg
public final class arm extends apy<Map<?, ?>> implements apz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final ajv f12548O000000o = asq.O00000Oo();
    protected final ajr O00000Oo;
    protected final boolean O00000o;
    protected final HashSet<String> O00000o0;
    protected final ajv O00000oO;
    protected final ajv O00000oo;
    protected ajz<Object> O0000O0o;
    protected ajz<Object> O0000OOo;
    protected aqp O0000Oo;
    protected final aoi O0000Oo0;

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        Map<?, ?> map = (Map) obj;
        jsonGenerator.O00000o();
        if (!map.isEmpty()) {
            if (akf.O000000o(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                map = O000000o(map);
            }
            ajz<Object> ajz = this.O0000OOo;
            if (ajz != null) {
                O000000o(map, jsonGenerator, akf, ajz);
            } else {
                O000000o(map, jsonGenerator, akf);
            }
        }
        jsonGenerator.O00000oO();
    }

    public final /* synthetic */ void O000000o(Object obj, JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonProcessingException {
        Map<?, ?> map = (Map) obj;
        aoi.O00000Oo(map, jsonGenerator);
        if (!map.isEmpty()) {
            if (akf.O000000o(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                map = O000000o(map);
            }
            ajz<Object> ajz = this.O0000OOo;
            if (ajz != null) {
                O000000o(map, jsonGenerator, akf, ajz);
            } else {
                O000000o(map, jsonGenerator, akf);
            }
        }
        aoi.O00000oO(map, jsonGenerator);
    }

    public final /* synthetic */ boolean O000000o(Object obj) {
        Map map = (Map) obj;
        return map == null || map.isEmpty();
    }

    public final /* synthetic */ boolean O00000Oo(Object obj) {
        return ((Map) obj).size() == 1;
    }

    private arm(HashSet<String> hashSet, ajv ajv, ajv ajv2, boolean z, aoi aoi, ajz<?> ajz, ajz<?> ajz2) {
        super(Map.class, (byte) 0);
        this.O00000o0 = hashSet;
        this.O00000oO = ajv;
        this.O00000oo = ajv2;
        this.O00000o = z;
        this.O0000Oo0 = aoi;
        this.O0000O0o = ajz;
        this.O0000OOo = ajz2;
        this.O0000Oo = aqp.O000000o();
        this.O00000Oo = null;
    }

    private arm(arm arm, ajr ajr, ajz<?> ajz, ajz<?> ajz2, HashSet<String> hashSet) {
        super(Map.class, (byte) 0);
        this.O00000o0 = hashSet;
        this.O00000oO = arm.O00000oO;
        this.O00000oo = arm.O00000oo;
        this.O00000o = arm.O00000o;
        this.O0000Oo0 = arm.O0000Oo0;
        this.O0000O0o = ajz;
        this.O0000OOo = ajz2;
        this.O0000Oo = arm.O0000Oo;
        this.O00000Oo = ajr;
    }

    private arm(arm arm, aoi aoi) {
        super(Map.class, (byte) 0);
        this.O00000o0 = arm.O00000o0;
        this.O00000oO = arm.O00000oO;
        this.O00000oo = arm.O00000oo;
        this.O00000o = arm.O00000o;
        this.O0000Oo0 = aoi;
        this.O0000O0o = arm.O0000O0o;
        this.O0000OOo = arm.O0000OOo;
        this.O0000Oo = arm.O0000Oo;
        this.O00000Oo = arm.O00000Oo;
    }

    public final ajz<?> O000000o(akf akf, ajr ajr) throws JsonMappingException {
        String[] O00000Oo2;
        ajz<?> ajz = this.O0000OOo;
        if (ajz == null) {
            if (this.O00000o) {
                ajz = akf.O000000o(this.O00000oo, ajr);
            }
        } else if (ajz instanceof apz) {
            ajz = ((apz) ajz).O000000o(akf, ajr);
        }
        ajz<?> ajz2 = ajz;
        ajz<?> ajz3 = this.O0000O0o;
        if (ajz3 == null) {
            ajz3 = akf.O00000o0(this.O00000oO, ajr);
        } else if (ajz3 instanceof apz) {
            ajz3 = ((apz) ajz3).O000000o(akf, ajr);
        }
        ajz<?> ajz4 = ajz3;
        HashSet<String> hashSet = this.O00000o0;
        AnnotationIntrospector O00000o02 = akf.O00000o0();
        if (!(O00000o02 == null || ajr == null || (O00000Oo2 = O00000o02.O00000Oo((ani) ajr.O00000Oo())) == null)) {
            hashSet = hashSet == null ? new HashSet<>() : new HashSet<>(hashSet);
            for (String add : O00000Oo2) {
                hashSet.add(add);
            }
        }
        return new arm(this, ajr, ajz4, ajz2, hashSet);
    }

    public final void O000000o(Map<?, ?> map, JsonGenerator jsonGenerator, akf akf) throws IOException, JsonGenerationException {
        ajz<Object> ajz;
        if (this.O0000Oo0 != null) {
            ajz<Object> ajz2 = this.O0000O0o;
            HashSet<String> hashSet = this.O00000o0;
            boolean z = !akf.O000000o(SerializationFeature.WRITE_NULL_MAP_VALUES);
            Class<?> cls = null;
            ajz<Object> ajz3 = null;
            for (Map.Entry next : map.entrySet()) {
                Object value = next.getValue();
                Object key = next.getKey();
                if (key == null) {
                    akf.O0000Oo().O000000o(null, jsonGenerator, akf);
                } else if ((!z || value != null) && (hashSet == null || !hashSet.contains(key))) {
                    ajz2.O000000o(key, jsonGenerator, akf);
                }
                if (value == null) {
                    akf.O000000o(jsonGenerator);
                } else {
                    Class<?> cls2 = value.getClass();
                    if (cls2 != cls) {
                        ajz3 = akf.O000000o(cls2, this.O00000Oo);
                        cls = cls2;
                    }
                    try {
                        ajz3.O000000o(value, jsonGenerator, akf, this.O0000Oo0);
                    } catch (Exception e) {
                        O000000o(akf, e, map, String.valueOf(key));
                    }
                }
            }
            return;
        }
        ajz<Object> ajz4 = this.O0000O0o;
        HashSet<String> hashSet2 = this.O00000o0;
        boolean z2 = !akf.O000000o(SerializationFeature.WRITE_NULL_MAP_VALUES);
        aqp aqp = this.O0000Oo;
        for (Map.Entry next2 : map.entrySet()) {
            Object value2 = next2.getValue();
            Object key2 = next2.getKey();
            if (key2 == null) {
                akf.O0000Oo().O000000o(null, jsonGenerator, akf);
            } else if ((!z2 || value2 != null) && (hashSet2 == null || !hashSet2.contains(key2))) {
                ajz4.O000000o(key2, jsonGenerator, akf);
            }
            if (value2 == null) {
                akf.O000000o(jsonGenerator);
            } else {
                Class<?> cls3 = value2.getClass();
                ajz<Object> O000000o2 = aqp.O000000o(cls3);
                if (O000000o2 == null) {
                    if (this.O00000oo.O0000o0()) {
                        aqp.O00000o O000000o3 = aqp.O000000o(akf.O000000o(this.O00000oo, cls3), akf, this.O00000Oo);
                        if (aqp != O000000o3.O00000Oo) {
                            this.O0000Oo = O000000o3.O00000Oo;
                        }
                        ajz = O000000o3.f12530O000000o;
                    } else {
                        aqp.O00000o O000000o4 = aqp.O000000o(cls3, akf, this.O00000Oo);
                        if (aqp != O000000o4.O00000Oo) {
                            this.O0000Oo = O000000o4.O00000Oo;
                        }
                        ajz = O000000o4.f12530O000000o;
                    }
                    O000000o2 = ajz;
                    aqp = this.O0000Oo;
                }
                try {
                    O000000o2.O000000o(value2, jsonGenerator, akf);
                } catch (Exception e2) {
                    O000000o(akf, e2, map, String.valueOf(key2));
                }
            }
        }
    }

    private void O000000o(Map<?, ?> map, JsonGenerator jsonGenerator, akf akf, ajz<Object> ajz) throws IOException, JsonGenerationException {
        ajz<Object> ajz2 = this.O0000O0o;
        HashSet<String> hashSet = this.O00000o0;
        aoi aoi = this.O0000Oo0;
        boolean z = !akf.O000000o(SerializationFeature.WRITE_NULL_MAP_VALUES);
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            Object key = next.getKey();
            if (key == null) {
                akf.O0000Oo().O000000o(null, jsonGenerator, akf);
            } else if ((!z || value != null) && (hashSet == null || !hashSet.contains(key))) {
                ajz2.O000000o(key, jsonGenerator, akf);
            }
            if (value == null) {
                akf.O000000o(jsonGenerator);
            } else if (aoi == null) {
                try {
                    ajz.O000000o(value, jsonGenerator, akf);
                } catch (Exception e) {
                    O000000o(akf, e, map, String.valueOf(key));
                }
            } else {
                ajz.O000000o(value, jsonGenerator, akf, aoi);
            }
        }
    }

    private static Map<?, ?> O000000o(Map<?, ?> map) {
        if (map instanceof SortedMap) {
            return map;
        }
        return new TreeMap(map);
    }

    public static arm O000000o(String[] strArr, ajv ajv, boolean z, aoi aoi, ajz<Object> ajz, ajz<Object> ajz2) {
        HashSet hashSet;
        ajv ajv2;
        ajv ajv3;
        if (strArr == null || strArr.length == 0) {
            hashSet = null;
        } else {
            hashSet = new HashSet(strArr.length);
            for (String add : strArr) {
                hashSet.add(add);
            }
        }
        HashSet hashSet2 = hashSet;
        if (ajv == null) {
            ajv3 = f12548O000000o;
            ajv2 = ajv3;
        } else {
            ajv3 = ajv.O0000o0O();
            ajv2 = ajv.O0000o0o();
        }
        if (!z) {
            z = ajv2 != null && ajv2.O0000Oo();
        }
        return new arm(hashSet2, ajv3, ajv2, z, aoi, ajz, ajz2);
    }

    public final /* synthetic */ apy O00000Oo(aoi aoi) {
        return new arm(this, aoi);
    }
}
