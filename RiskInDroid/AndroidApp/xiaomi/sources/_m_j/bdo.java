package _m_j;

import com.google.android.exoplayer2.C;
import com.imi.fastjson.JSONArray;
import com.imi.fastjson.JSONException;
import com.imi.fastjson.JSONObject;
import com.imi.fastjson.parser.Feature;
import java.io.Closeable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class bdo extends bdm implements Closeable {
    private static final Set<Class<?>> O0000OOo;

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Object f12886O000000o;
    protected final bdv O00000Oo;
    protected final bdp O00000o;
    protected bdu O00000o0;
    protected bdt O00000oO;
    public final List<O000000o> O00000oo;
    public int O0000O0o;
    private DateFormat O0000Oo;
    private String O0000Oo0;
    private bdt[] O0000OoO;
    private int O0000Ooo;

    static {
        HashSet hashSet = new HashSet();
        O0000OOo = hashSet;
        hashSet.add(Boolean.TYPE);
        O0000OOo.add(Byte.TYPE);
        O0000OOo.add(Short.TYPE);
        O0000OOo.add(Integer.TYPE);
        O0000OOo.add(Long.TYPE);
        O0000OOo.add(Float.TYPE);
        O0000OOo.add(Double.TYPE);
        O0000OOo.add(Boolean.class);
        O0000OOo.add(Byte.class);
        O0000OOo.add(Short.class);
        O0000OOo.add(Integer.class);
        O0000OOo.add(Long.class);
        O0000OOo.add(Float.class);
        O0000OOo.add(Double.class);
        O0000OOo.add(BigInteger.class);
        O0000OOo.add(BigDecimal.class);
        O0000OOo.add(String.class);
    }

    public final DateFormat O000000o() {
        if (this.O0000Oo == null) {
            this.O0000Oo = new SimpleDateFormat(this.O0000Oo0);
        }
        return this.O0000Oo;
    }

    public bdo(String str, bdu bdu, int i) {
        this(str, new bdq(str, i), bdu);
    }

    private bdo(Object obj, bdp bdp, bdu bdu) {
        this.O0000Oo0 = bdf.O00000o0;
        this.O0000OoO = new bdt[8];
        this.O0000Ooo = 0;
        this.O00000oo = new ArrayList();
        this.O0000O0o = 0;
        this.O00000o = bdp;
        this.f12886O000000o = obj;
        this.O00000o0 = bdu;
        this.O00000Oo = bdu.O00000Oo();
        bdp.O000000o(12);
    }

    public final bdv O00000Oo() {
        return this.O00000Oo;
    }

    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
     arg types: [java.util.Map, java.lang.Object]
     candidates:
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
     arg types: [com.imi.fastjson.JSONArray, java.lang.Object]
     candidates:
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
     arg types: [com.imi.fastjson.JSONObject, java.lang.Object]
     candidates:
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01e8, code lost:
        r0 = r1.O00000o0.O000000o((java.lang.reflect.Type) r6).O000000o(r1, r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f2, code lost:
        O000000o(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01f5, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        r3.O000000o(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0203, code lost:
        if (r3.O00000o0() != 4) goto L_0x027e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0205, code lost:
        r0 = r3.O0000oO0();
        r3.O000000o(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0212, code lost:
        if ("@".equals(r0) == false) goto L_0x021d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0216, code lost:
        if (r1.O00000oO == null) goto L_0x0268;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0218, code lost:
        r0 = r1.O00000oO.f12890O000000o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0223, code lost:
        if ("..".equals(r0) == false) goto L_0x023a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0225, code lost:
        r2 = r4.O00000Oo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0229, code lost:
        if (r2.f12890O000000o == null) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x022b, code lost:
        r0 = r2.f12890O000000o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x022e, code lost:
        O000000o(new _m_j.bdo.O000000o(r2, r0));
        r1.O0000O0o = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0240, code lost:
        if ("$".equals(r0) == false) goto L_0x025d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0242, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0245, code lost:
        if (r2.O00000Oo == null) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0247, code lost:
        r2 = r2.O00000Oo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x024c, code lost:
        if (r2.f12890O000000o == null) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x024e, code lost:
        r0 = r2.f12890O000000o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0251, code lost:
        O000000o(new _m_j.bdo.O000000o(r2, r0));
        r1.O0000O0o = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x025d, code lost:
        O000000o(new _m_j.bdo.O000000o(r4, r0));
        r1.O0000O0o = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0268, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x026d, code lost:
        if (r3.O00000o0() != 13) goto L_0x0278;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x026f, code lost:
        r3.O000000o(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0274, code lost:
        O000000o(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0277, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x027d, code lost:
        throw new com.imi.fastjson.JSONException("syntax error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0299, code lost:
        throw new com.imi.fastjson.JSONException("illegal ref, " + _m_j.bdr.O000000o(r3.O00000o0()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x031b, code lost:
        if (r5 != '}') goto L_0x032d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x031d, code lost:
        r3.O0000OoO();
        r3.O0000Ooo();
        r3.O000000o();
        O000000o((java.lang.Object) r17, r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0329, code lost:
        O000000o(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x032c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x034a, code lost:
        throw new com.imi.fastjson.JSONException("syntax error, position at " + r3.O00000oO() + ", name " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x019e, code lost:
        r3.O000000o(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01a7, code lost:
        if (r3.O00000o0() != 13) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a9, code lost:
        r3.O000000o(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        r0 = r1.O00000o0.O000000o((java.lang.reflect.Type) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b4, code lost:
        if ((r0 instanceof _m_j.bew) == false) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b6, code lost:
        r14 = ((_m_j.bew) r0).O000000o(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01bd, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01be, code lost:
        if (r14 != null) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01c2, code lost:
        if (r6 != java.lang.Cloneable.class) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c4, code lost:
        r14 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01ca, code lost:
        r14 = r6.newInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01ce, code lost:
        O000000o(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01d1, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01db, code lost:
        r1.O0000O0o = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01df, code lost:
        if (r1.O00000oO == null) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e3, code lost:
        if ((r2 instanceof java.lang.Integer) != false) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01e5, code lost:
        O00000oo();
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0174 A[Catch:{ Exception -> 0x01d2, all -> 0x0424 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0187 A[Catch:{ Exception -> 0x01d2, all -> 0x0424 }] */
    public final Object O000000o(Map map, Object obj) {
        Object obj2;
        boolean z;
        char c;
        Number number;
        Map map2 = map;
        Object obj3 = obj;
        bdp bdp = this.O00000o;
        if (bdp.O00000o0() == 12 || bdp.O00000o0() == 16) {
            bdt bdt = this.O00000oO;
            boolean z2 = false;
            while (true) {
                try {
                    bdp.O0000oOO();
                    char O0000Oo2 = bdp.O0000Oo();
                    if (O000000o(Feature.AllowArbitraryCommas)) {
                        while (O0000Oo2 == ',') {
                            bdp.O0000OoO();
                            bdp.O0000oOO();
                            O0000Oo2 = bdp.O0000Oo();
                        }
                    }
                    if (O0000Oo2 == '\"') {
                        obj2 = bdp.O000000o(this.O00000Oo, '\"');
                        bdp.O0000oOO();
                        if (bdp.O0000Oo() != ':') {
                            throw new JSONException("expect ':' at " + bdp.O00000oO() + ", name " + obj2);
                        }
                    } else if (O0000Oo2 == '}') {
                        bdp.O0000OoO();
                        bdp.O0000Ooo();
                        bdp.O000000o();
                        O000000o(bdt);
                        return map2;
                    } else if (O0000Oo2 == '\'') {
                        if (O000000o(Feature.AllowSingleQuotes)) {
                            obj2 = bdp.O000000o(this.O00000Oo, '\'');
                            bdp.O0000oOO();
                            if (bdp.O0000Oo() != ':') {
                                throw new JSONException("expect ':' at " + bdp.O00000oO());
                            }
                        } else {
                            throw new JSONException("syntax error");
                        }
                    } else if (O0000Oo2 == 26) {
                        throw new JSONException("syntax error");
                    } else if (O0000Oo2 == ',') {
                        throw new JSONException("syntax error");
                    } else if ((O0000Oo2 < '0' || O0000Oo2 > '9') && O0000Oo2 != '-') {
                        if (O0000Oo2 != '{') {
                            if (O0000Oo2 != '[') {
                                if (O000000o(Feature.AllowUnQuotedFieldNames)) {
                                    obj2 = bdp.O00000Oo(this.O00000Oo);
                                    bdp.O0000oOO();
                                    char O0000Oo3 = bdp.O0000Oo();
                                    if (O0000Oo3 != ':') {
                                        throw new JSONException("expect ':' at " + bdp.O00000oO() + ", actual " + O0000Oo3);
                                    }
                                } else {
                                    throw new JSONException("syntax error");
                                }
                            }
                        }
                        bdp.O000000o();
                        obj2 = O000000o((Object) null);
                        z = true;
                        if (!z) {
                            bdp.O0000OoO();
                            bdp.O0000oOO();
                        }
                        char O0000Oo4 = bdp.O0000Oo();
                        bdp.O0000Ooo();
                        if (obj2 == bdf.f12884O000000o) {
                            if (obj2 != "$ref") {
                                if (!z2) {
                                    O000000o((Object) map, obj);
                                    if (this.O00000oO != null && !(obj3 instanceof Integer)) {
                                        O00000oo();
                                    }
                                    c = '\"';
                                    z2 = true;
                                } else {
                                    c = '\"';
                                }
                                if (O0000Oo4 == c) {
                                    bdp.O0000o00();
                                    String O0000oO0 = bdp.O0000oO0();
                                    Object obj4 = O0000oO0;
                                    if (bdp.O000000o(Feature.AllowISO8601DateFormat)) {
                                        bdq bdq = new bdq(O0000oO0);
                                        Object obj5 = O0000oO0;
                                        if (bdq.O0000ooo()) {
                                            obj5 = bdq.O0000o0().getTime();
                                        }
                                        bdq.close();
                                        obj4 = obj5;
                                    }
                                    if (map.getClass() == JSONObject.class) {
                                        map2.put(obj2.toString(), obj4);
                                    } else {
                                        map2.put(obj2, obj4);
                                    }
                                } else if ((O0000Oo4 >= '0' && O0000Oo4 <= '9') || O0000Oo4 == '-') {
                                    bdp.O0000oOo();
                                    if (bdp.O00000o0() == 2) {
                                        number = bdp.O0000O0o();
                                    } else {
                                        number = bdp.O0000ooO();
                                    }
                                    map2.put(obj2, number);
                                } else if (O0000Oo4 == '[') {
                                    bdp.O000000o();
                                    JSONArray jSONArray = new JSONArray();
                                    O000000o((Collection) jSONArray, obj2);
                                    map2.put(obj2, jSONArray);
                                    if (bdp.O00000o0() == 13) {
                                        bdp.O000000o();
                                        O000000o(bdt);
                                        return map2;
                                    } else if (bdp.O00000o0() != 16) {
                                        throw new JSONException("syntax error");
                                    }
                                } else if (O0000Oo4 == '{') {
                                    bdp.O000000o();
                                    Object O000000o2 = O000000o((Map) new JSONObject(), obj2);
                                    O000000o(map2, obj2.toString());
                                    if (map.getClass() == JSONObject.class) {
                                        map2.put(obj2.toString(), O000000o2);
                                    } else {
                                        map2.put(obj2, O000000o2);
                                    }
                                    O000000o(bdt, O000000o2, obj2);
                                    if (bdp.O00000o0() == 13) {
                                        bdp.O000000o();
                                        O000000o(bdt);
                                        O000000o(bdt);
                                        return map2;
                                    } else if (bdp.O00000o0() != 16) {
                                        throw new JSONException("syntax error, " + bdp.O00000o());
                                    }
                                } else {
                                    bdp.O000000o();
                                    map2.put(obj2, O000000o((Object) null));
                                    if (bdp.O00000o0() == 13) {
                                        bdp.O000000o();
                                        O000000o(bdt);
                                        return map2;
                                    } else if (bdp.O00000o0() != 16) {
                                        throw new JSONException("syntax error, position at " + bdp.O00000oO() + ", name " + obj2);
                                    }
                                }
                                bdp.O0000oOO();
                                char O0000Oo5 = bdp.O0000Oo();
                                if (O0000Oo5 != ',') {
                                    break;
                                }
                                bdp.O0000OoO();
                            } else {
                                break;
                            }
                        } else {
                            String O000000o3 = bdp.O000000o(this.O00000Oo, '\"');
                            Class<?> O000000o4 = bih.O000000o(O000000o3);
                            if (O000000o4 != null) {
                                break;
                            }
                            map2.put(bdf.f12884O000000o, O000000o3);
                        }
                    } else {
                        bdp.O0000Ooo();
                        bdp.O0000oOo();
                        if (bdp.O00000o0() == 2) {
                            obj2 = bdp.O0000O0o();
                        } else {
                            obj2 = bdp.O000000o(true);
                        }
                        if (bdp.O0000Oo() != ':') {
                            throw new JSONException("expect ':' at " + bdp.O00000oO() + ", name " + obj2);
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                    char O0000Oo42 = bdp.O0000Oo();
                    bdp.O0000Ooo();
                    if (obj2 == bdf.f12884O000000o) {
                    }
                } catch (Exception e) {
                    throw new JSONException("create instance error", e);
                } catch (Throwable th) {
                    O000000o(bdt);
                    throw th;
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + bdp.O00000o());
        }
    }

    public final bdu O00000o0() {
        return this.O00000o0;
    }

    public final <T> T O000000o(Type type) {
        if (this.O00000o.O00000o0() == 8) {
            this.O00000o.O000000o();
            return null;
        }
        try {
            return this.O00000o0.O000000o(type).O000000o(this, type, null);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public final void O000000o(Type type, Collection collection) {
        O000000o(type, collection, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
     arg types: [java.util.Collection, java.lang.Object]
     candidates:
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt */
    public final void O000000o(Type type, Collection collection, Object obj) {
        bff bff;
        if (this.O00000o.O00000o0() == 21 || this.O00000o.O00000o0() == 22) {
            this.O00000o.O000000o();
        }
        if (this.O00000o.O00000o0() == 14) {
            if (Integer.TYPE == type) {
                bff = bes.f12913O000000o;
                this.O00000o.O000000o(2);
            } else if (String.class == type) {
                bff = bfk.f12926O000000o;
                this.O00000o.O000000o(4);
            } else {
                bff = this.O00000o0.O000000o(type);
                this.O00000o.O000000o(bff.O000000o());
            }
            bdt bdt = this.O00000oO;
            O000000o((Object) collection, obj);
            int i = 0;
            while (true) {
                try {
                    if (O000000o(Feature.AllowArbitraryCommas)) {
                        while (this.O00000o.O00000o0() == 16) {
                            this.O00000o.O000000o();
                        }
                    }
                    if (this.O00000o.O00000o0() != 15) {
                        Object obj2 = null;
                        if (Integer.TYPE == type) {
                            collection.add(bes.f12913O000000o.O000000o(this, null, null));
                        } else if (String.class == type) {
                            if (this.O00000o.O00000o0() == 4) {
                                obj2 = this.O00000o.O0000oO0();
                                this.O00000o.O000000o(16);
                            } else {
                                Object O000000o2 = O000000o((Object) null);
                                if (O000000o2 != null) {
                                    obj2 = O000000o2.toString();
                                }
                            }
                            collection.add(obj2);
                        } else {
                            if (this.O00000o.O00000o0() == 8) {
                                this.O00000o.O000000o();
                            } else {
                                obj2 = bff.O000000o(this, type, Integer.valueOf(i));
                            }
                            collection.add(obj2);
                            O000000o(collection);
                        }
                        if (this.O00000o.O00000o0() == 16) {
                            this.O00000o.O000000o(bff.O000000o());
                        }
                        i++;
                    } else {
                        O000000o(bdt);
                        this.O00000o.O000000o(16);
                        return;
                    }
                } catch (Throwable th) {
                    O000000o(bdt);
                    throw th;
                }
            }
        } else {
            throw new JSONException("exepct '[', but " + bdr.O000000o(this.O00000o.O00000o0()));
        }
    }

    public final Object O000000o(String str) {
        for (int i = 0; i < this.O0000Ooo; i++) {
            if (str.equals(this.O0000OoO[i].O000000o())) {
                return this.O0000OoO[i].f12890O000000o;
            }
        }
        return null;
    }

    public final void O000000o(Collection collection) {
        if (this.O0000O0o == 1) {
            O000000o O00000oO2 = O00000oO();
            O00000oO2.O00000o0 = new bey(this, (List) collection, collection.size() - 1);
            O00000oO2.O00000o = this.O00000oO;
            this.O0000O0o = 0;
        }
    }

    public final void O000000o(Map map, String str) {
        if (this.O0000O0o == 1) {
            bfd bfd = new bfd(map, str);
            O000000o O00000oO2 = O00000oO();
            O00000oO2.O00000o0 = bfd;
            O00000oO2.O00000o = this.O00000oO;
            this.O0000O0o = 0;
        }
    }

    public final void O00000Oo(Collection collection) {
        O000000o(collection, (Object) null);
    }

    public final bdt O00000o() {
        return this.O00000oO;
    }

    public final void O000000o(O000000o o000000o) {
        this.O00000oo.add(o000000o);
    }

    public final O000000o O00000oO() {
        List<O000000o> list = this.O00000oo;
        return list.get(list.size() - 1);
    }

    public final void O000000o(bdt bdt) {
        if (!O000000o(Feature.DisableCircularReferenceDetect)) {
            this.O00000oO = bdt;
        }
    }

    public final void O00000oo() {
        if (!O000000o(Feature.DisableCircularReferenceDetect)) {
            this.O00000oO = this.O00000oO.O00000Oo;
            bdt[] bdtArr = this.O0000OoO;
            int i = this.O0000Ooo;
            bdtArr[i - 1] = null;
            this.O0000Ooo = i - 1;
        }
    }

    private bdt O000000o(Object obj, Object obj2) {
        if (O000000o(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return O000000o(this.O00000oO, obj, obj2);
    }

    public final bdt O000000o(bdt bdt, Object obj, Object obj2) {
        if (O000000o(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        this.O00000oO = new bdt(bdt, obj, obj2);
        O00000Oo(this.O00000oO);
        return this.O00000oO;
    }

    private void O00000Oo(bdt bdt) {
        int i = this.O0000Ooo;
        this.O0000Ooo = i + 1;
        bdt[] bdtArr = this.O0000OoO;
        if (i >= bdtArr.length) {
            bdt[] bdtArr2 = new bdt[((bdtArr.length * 3) / 2)];
            System.arraycopy(bdtArr, 0, bdtArr2, 0, bdtArr.length);
            this.O0000OoO = bdtArr2;
        }
        this.O0000OoO[i] = bdt;
    }

    public final bdp O0000O0o() {
        return this.O00000o;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final bdt f12887O000000o;
        public final String O00000Oo;
        public bdt O00000o;
        public ben O00000o0;

        public O000000o(bdt bdt, String str) {
            this.f12887O000000o = bdt;
            this.O00000Oo = str;
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: com.imi.fastjson.JSONArray} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
     arg types: [java.util.Collection, java.lang.Object]
     candidates:
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
     arg types: [com.imi.fastjson.JSONArray, java.lang.Integer]
     candidates:
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
     arg types: [com.imi.fastjson.JSONObject, java.lang.Integer]
     candidates:
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object */
    /* JADX WARNING: Multi-variable type inference failed */
    private void O000000o(Collection collection, Object obj) {
        Object obj2;
        bdp bdp = this.O00000o;
        if (bdp.O00000o0() == 21 || bdp.O00000o0() == 22) {
            bdp.O000000o();
        }
        if (bdp.O00000o0() == 14) {
            bdp.O000000o(4);
            bdt bdt = this.O00000oO;
            O000000o((Object) collection, obj);
            int i = 0;
            while (true) {
                try {
                    if (O000000o(Feature.AllowArbitraryCommas)) {
                        while (bdp.O00000o0() == 16) {
                            bdp.O000000o();
                        }
                    }
                    int O00000o02 = bdp.O00000o0();
                    Object obj3 = null;
                    if (O00000o02 == 2) {
                        Object O0000O0o2 = bdp.O0000O0o();
                        bdp.O000000o(16);
                        obj3 = O0000O0o2;
                    } else if (O00000o02 == 3) {
                        if (bdp.O000000o(Feature.UseBigDecimal)) {
                            obj2 = bdp.O000000o(true);
                        } else {
                            obj2 = bdp.O000000o(false);
                        }
                        obj3 = obj2;
                        bdp.O000000o(16);
                    } else if (O00000o02 == 4) {
                        String O0000oO0 = bdp.O0000oO0();
                        bdp.O000000o(16);
                        obj3 = O0000oO0;
                        if (bdp.O000000o(Feature.AllowISO8601DateFormat)) {
                            bdq bdq = new bdq(O0000oO0);
                            Object obj4 = O0000oO0;
                            if (bdq.O0000ooo()) {
                                obj4 = bdq.O0000o0().getTime();
                            }
                            bdq.close();
                            obj3 = obj4;
                        }
                    } else if (O00000o02 == 6) {
                        Object obj5 = Boolean.TRUE;
                        bdp.O000000o(16);
                        obj3 = obj5;
                    } else if (O00000o02 == 7) {
                        Object obj6 = Boolean.FALSE;
                        bdp.O000000o(16);
                        obj3 = obj6;
                    } else if (O00000o02 == 8) {
                        bdp.O000000o(4);
                    } else if (O00000o02 == 12) {
                        obj3 = O000000o((Map) new JSONObject(), (Object) Integer.valueOf(i));
                    } else if (O00000o02 == 20) {
                        throw new JSONException("unclosed jsonArray");
                    } else if (O00000o02 == 14) {
                        JSONArray jSONArray = new JSONArray();
                        O000000o((Collection) jSONArray, (Object) Integer.valueOf(i));
                        obj3 = jSONArray;
                    } else if (O00000o02 != 15) {
                        obj3 = O000000o((Object) null);
                    } else {
                        bdp.O000000o(16);
                        return;
                    }
                    collection.add(obj3);
                    O000000o(collection);
                    if (bdp.O00000o0() == 16) {
                        bdp.O000000o(4);
                    }
                    i++;
                } finally {
                    O000000o(bdt);
                }
            }
        } else {
            throw new JSONException("syntax error, expect [, actual " + bdr.O000000o(bdp.O00000o0()) + ", pos " + bdp.O00000oO());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
     arg types: [java.util.TreeSet, java.lang.Object]
     candidates:
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
     arg types: [java.util.HashSet, java.lang.Object]
     candidates:
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
     arg types: [com.imi.fastjson.JSONArray, java.lang.Object]
     candidates:
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
     arg types: [com.imi.fastjson.JSONObject, java.lang.Object]
     candidates:
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object */
    public final Object O000000o(Object obj) {
        bdp bdp = this.O00000o;
        int O00000o02 = bdp.O00000o0();
        if (O00000o02 == 2) {
            Number O0000O0o2 = bdp.O0000O0o();
            bdp.O000000o();
            return O0000O0o2;
        } else if (O00000o02 == 3) {
            Number O000000o2 = bdp.O000000o(O000000o(Feature.UseBigDecimal));
            bdp.O000000o();
            return O000000o2;
        } else if (O00000o02 == 4) {
            String O0000oO0 = bdp.O0000oO0();
            bdp.O000000o(16);
            if (bdp.O000000o(Feature.AllowISO8601DateFormat)) {
                bdq bdq = new bdq(O0000oO0);
                try {
                    if (bdq.O0000ooo()) {
                        return bdq.O0000o0().getTime();
                    }
                    bdq.close();
                } finally {
                    bdq.close();
                }
            }
            return O0000oO0;
        } else if (O00000o02 == 12) {
            return O000000o((Map) new JSONObject(), obj);
        } else {
            if (O00000o02 != 14) {
                switch (O00000o02) {
                    case 6:
                        bdp.O000000o();
                        return Boolean.TRUE;
                    case 7:
                        bdp.O000000o();
                        return Boolean.FALSE;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        bdp.O000000o();
                        return null;
                    case 9:
                        bdp.O000000o(18);
                        if (bdp.O00000o0() == 18) {
                            bdp.O000000o(10);
                            O000000o(10);
                            long longValue = bdp.O0000O0o().longValue();
                            O000000o(2);
                            O000000o(11);
                            return new Date(longValue);
                        }
                        throw new JSONException("syntax error");
                    default:
                        switch (O00000o02) {
                            case 20:
                                if (bdp.O0000oO()) {
                                    return null;
                                }
                                throw new JSONException("unterminated json string, pos " + bdp.O00000oo());
                            case 21:
                                bdp.O000000o();
                                HashSet hashSet = new HashSet();
                                O000000o((Collection) hashSet, obj);
                                return hashSet;
                            case 22:
                                bdp.O000000o();
                                TreeSet treeSet = new TreeSet();
                                O000000o((Collection) treeSet, obj);
                                return treeSet;
                            default:
                                throw new JSONException("syntax error, pos " + bdp.O00000oo());
                        }
                }
            } else {
                JSONArray jSONArray = new JSONArray();
                O000000o((Collection) jSONArray, obj);
                return jSONArray;
            }
        }
    }

    public final boolean O000000o(Feature feature) {
        return this.O00000o.O000000o(feature);
    }

    public final void O000000o(int i) {
        bdp bdp = this.O00000o;
        if (bdp.O00000o0() == i) {
            bdp.O000000o();
            return;
        }
        throw new JSONException("syntax error, expect " + bdr.O000000o(i) + ", actual " + bdr.O000000o(bdp.O00000o0()));
    }

    public final void close() {
        bdp bdp = this.O00000o;
        try {
            if (O000000o(Feature.AutoCloseSource)) {
                if (bdp.O00000o0() != 20) {
                    throw new JSONException("not close json text, token : " + bdr.O000000o(bdp.O00000o0()));
                }
            }
        } finally {
            bdp.close();
        }
    }
}
