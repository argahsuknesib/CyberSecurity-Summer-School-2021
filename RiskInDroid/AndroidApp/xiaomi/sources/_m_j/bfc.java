package _m_j;

import _m_j.bdo;
import com.imi.fastjson.JSONException;
import com.imi.fastjson.parser.Feature;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class bfc implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bfc f12920O000000o = new bfc();

    public final int O000000o() {
        return 12;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bfc.O000000o(_m_j.bdo, java.util.Map<java.lang.String, java.lang.Object>, java.lang.reflect.Type, java.lang.Object):java.util.Map
     arg types: [_m_j.bdo, java.util.Map<java.lang.Object, java.lang.Object>, java.lang.reflect.Type, java.lang.Object]
     candidates:
      _m_j.bfc.O000000o(_m_j.bdo, java.util.Map<java.lang.Object, java.lang.Object>, java.lang.reflect.Type, java.lang.reflect.Type):java.lang.Object
      _m_j.bfc.O000000o(_m_j.bdo, java.util.Map<java.lang.String, java.lang.Object>, java.lang.reflect.Type, java.lang.Object):java.util.Map */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
     arg types: [java.util.Map<java.lang.Object, java.lang.Object>, java.lang.Object]
     candidates:
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object */
    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        T t;
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 8) {
            O0000O0o.O000000o(16);
            return null;
        }
        Map<Object, Object> O000000o2 = O000000o(type);
        bdt O00000o = bdo.O00000o();
        try {
            bdo.O000000o(O00000o, O000000o2, obj);
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                Type type3 = parameterizedType.getActualTypeArguments()[1];
                if (String.class == type2) {
                    t = O000000o(bdo, (Map<String, Object>) O000000o2, type3, obj);
                } else {
                    t = O000000o(bdo, O000000o2, type2, type3);
                }
            } else {
                t = bdo.O000000o((Map) O000000o2, obj);
            }
            return t;
        } finally {
            bdo.O000000o(O00000o);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
     arg types: [java.util.Map<java.lang.String, java.lang.Object>, java.lang.String]
     candidates:
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r10 = r9.O00000o0().O000000o((java.lang.reflect.Type) r2);
        r0.O000000o(16);
        r9.O0000O0o = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0106, code lost:
        if (r1 == null) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010a, code lost:
        if ((r12 instanceof java.lang.Integer) != false) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010c, code lost:
        r9.O00000oo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010f, code lost:
        r10 = (java.util.Map) r10.O000000o(r9, r2, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0115, code lost:
        r9.O000000o(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0118, code lost:
        return r10;
     */
    private static Map O000000o(bdo bdo, Map<String, Object> map, Type type, Object obj) {
        String str;
        Object obj2;
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 12) {
            bdt O00000o = bdo.O00000o();
            while (true) {
                try {
                    O0000O0o.O0000oOO();
                    char O0000Oo = O0000O0o.O0000Oo();
                    if (bdo.O000000o(Feature.AllowArbitraryCommas)) {
                        while (O0000Oo == ',') {
                            O0000O0o.O0000OoO();
                            O0000O0o.O0000oOO();
                            O0000Oo = O0000O0o.O0000Oo();
                        }
                    }
                    if (O0000Oo == '\"') {
                        str = O0000O0o.O000000o(bdo.O00000Oo(), '\"');
                        O0000O0o.O0000oOO();
                        if (O0000O0o.O0000Oo() != ':') {
                            throw new JSONException("expect ':' at " + O0000O0o.O00000oO());
                        }
                    } else if (O0000Oo == '}') {
                        O0000O0o.O0000OoO();
                        O0000O0o.O0000Ooo();
                        O0000O0o.O000000o(16);
                        bdo.O000000o(O00000o);
                        return map;
                    } else if (O0000Oo == '\'') {
                        if (bdo.O000000o(Feature.AllowSingleQuotes)) {
                            str = O0000O0o.O000000o(bdo.O00000Oo(), '\'');
                            O0000O0o.O0000oOO();
                            if (O0000O0o.O0000Oo() != ':') {
                                throw new JSONException("expect ':' at " + O0000O0o.O00000oO());
                            }
                        } else {
                            throw new JSONException("syntax error");
                        }
                    } else if (bdo.O000000o(Feature.AllowUnQuotedFieldNames)) {
                        str = O0000O0o.O00000Oo(bdo.O00000Oo());
                        O0000O0o.O0000oOO();
                        char O0000Oo2 = O0000O0o.O0000Oo();
                        if (O0000Oo2 != ':') {
                            throw new JSONException("expect ':' at " + O0000O0o.O00000oO() + ", actual " + O0000Oo2);
                        }
                    } else {
                        throw new JSONException("syntax error");
                    }
                    O0000O0o.O0000OoO();
                    O0000O0o.O0000oOO();
                    O0000O0o.O0000Ooo();
                    if (str == bdf.f12884O000000o) {
                        Class<?> O000000o2 = bih.O000000o(O0000O0o.O000000o(bdo.O00000Oo(), '\"'));
                        if (O000000o2 != map.getClass()) {
                            break;
                        }
                        O0000O0o.O000000o(16);
                        if (O0000O0o.O00000o0() == 13) {
                            O0000O0o.O000000o(16);
                            return map;
                        }
                    } else {
                        O0000O0o.O000000o();
                        if (O0000O0o.O00000o0() == 8) {
                            obj2 = null;
                            O0000O0o.O000000o();
                        } else {
                            obj2 = bdo.O000000o(type);
                        }
                        map.put(str, obj2);
                        bdo.O000000o((Map) map, str);
                        bdo.O000000o(O00000o, obj2, str);
                        int O00000o0 = O0000O0o.O00000o0();
                        if (O00000o0 == 20) {
                            break;
                        } else if (O00000o0 == 15) {
                            break;
                        } else if (O00000o0 == 13) {
                            O0000O0o.O000000o();
                            bdo.O000000o(O00000o);
                            return map;
                        }
                    }
                } finally {
                    bdo.O000000o(O00000o);
                }
            }
            bdo.O000000o(O00000o);
            return map;
        }
        throw new JSONException("syntax error, expect {, actual " + O0000O0o.O00000o0());
    }

    private static Object O000000o(bdo bdo, Map<Object, Object> map, Type type, Type type2) {
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 12 || O0000O0o.O00000o0() == 16) {
            bff O000000o2 = bdo.O00000o0().O000000o(type);
            bff O000000o3 = bdo.O00000o0().O000000o(type2);
            O0000O0o.O000000o(O000000o2.O000000o());
            bdt O00000o = bdo.O00000o();
            while (O0000O0o.O00000o0() != 13) {
                try {
                    Object obj = null;
                    if (O0000O0o.O00000o0() != 4 || !O0000O0o.O0000o()) {
                        if (map.size() == 0 && O0000O0o.O00000o0() == 4 && bdf.f12884O000000o.equals(O0000O0o.O0000oO0())) {
                            O0000O0o.O00000Oo(4);
                            O0000O0o.O000000o(16);
                            if (O0000O0o.O00000o0() == 13) {
                                O0000O0o.O000000o();
                                return map;
                            }
                            O0000O0o.O000000o(O000000o2.O000000o());
                        }
                        Object O000000o4 = O000000o2.O000000o(bdo, type, null);
                        if (O0000O0o.O00000o0() == 17) {
                            O0000O0o.O000000o(O000000o3.O000000o());
                            map.put(O000000o4, O000000o3.O000000o(bdo, type2, O000000o4));
                            if (O0000O0o.O00000o0() == 16) {
                                O0000O0o.O000000o(O000000o2.O000000o());
                            }
                        } else {
                            throw new JSONException("syntax error, expect :, actual " + O0000O0o.O00000o0());
                        }
                    } else {
                        O0000O0o.O00000Oo(4);
                        if (O0000O0o.O00000o0() == 4) {
                            String O0000oO0 = O0000O0o.O0000oO0();
                            if ("..".equals(O0000oO0)) {
                                obj = O00000o.O00000Oo.f12890O000000o;
                            } else if ("$".equals(O0000oO0)) {
                                bdt bdt = O00000o;
                                while (bdt.O00000Oo != null) {
                                    bdt = bdt.O00000Oo;
                                }
                                obj = bdt.f12890O000000o;
                            } else {
                                bdo.O000000o(new bdo.O000000o(O00000o, O0000oO0));
                                bdo.O0000O0o = 1;
                            }
                            O0000O0o.O000000o(13);
                            if (O0000O0o.O00000o0() == 13) {
                                O0000O0o.O000000o(16);
                                bdo.O000000o(O00000o);
                                return obj;
                            }
                            throw new JSONException("illegal ref");
                        }
                        throw new JSONException("illegal ref, " + bdr.O000000o(O0000O0o.O00000o0()));
                    }
                } finally {
                    bdo.O000000o(O00000o);
                }
            }
            O0000O0o.O000000o(16);
            bdo.O000000o(O00000o);
            return map;
        }
        throw new JSONException("syntax error, expect {, actual " + O0000O0o.O00000o());
    }

    private Map<Object, Object> O000000o(Type type) {
        while (type != Properties.class) {
            if (type == Hashtable.class) {
                return new Hashtable();
            }
            if (type == IdentityHashMap.class) {
                return new IdentityHashMap();
            }
            if (type == SortedMap.class || type == TreeMap.class) {
                return new TreeMap();
            }
            if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
                return new ConcurrentHashMap();
            }
            if (type == Map.class || type == HashMap.class) {
                return new HashMap();
            }
            if (type == LinkedHashMap.class) {
                return new LinkedHashMap();
            }
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            } else {
                Class cls = (Class) type;
                if (!cls.isInterface()) {
                    try {
                        return (Map) cls.newInstance();
                    } catch (Exception e) {
                        throw new JSONException("unsupport type ".concat(String.valueOf(type)), e);
                    }
                } else {
                    throw new JSONException("unsupport type ".concat(String.valueOf(type)));
                }
            }
        }
        return new Properties();
    }
}
