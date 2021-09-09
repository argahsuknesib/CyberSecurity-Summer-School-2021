package _m_j;

import com.imi.fastjson.JSONException;
import com.imi.fastjson.JSONObject;
import com.imi.fastjson.parser.Feature;
import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bew implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Map<String, ben> f12916O000000o;
    private final List<ben> O00000Oo;
    private bic O00000o;
    private final Class<?> O00000o0;

    public int O000000o() {
        return 12;
    }

    public bew(bdu bdu, Class<?> cls) {
        this(bdu, cls, cls);
    }

    public bew(bdu bdu, Class<?> cls, Type type) {
        this.f12916O000000o = new IdentityHashMap();
        this.O00000Oo = new ArrayList();
        this.O00000o0 = cls;
        this.O00000o = bic.O000000o(cls, type);
        for (bid next : this.O00000o.O00000o) {
            ben O000000o2 = bdu.O000000o(bdu, cls, next);
            this.f12916O000000o.put(next.f12989O000000o.intern(), O000000o2);
            this.O00000Oo.add(O000000o2);
        }
    }

    public final Object O000000o(bdo bdo, Type type) {
        Object obj;
        if ((type instanceof Class) && this.O00000o0.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        } else if (this.O00000o.f12988O000000o == null) {
            return null;
        } else {
            try {
                Constructor<?> constructor = this.O00000o.f12988O000000o;
                if (constructor.getParameterTypes().length == 0) {
                    obj = constructor.newInstance(new Object[0]);
                } else {
                    obj = constructor.newInstance(bdo.O00000o().f12890O000000o);
                }
                if (bdo.O000000o(Feature.InitStringFieldAsEmpty)) {
                    for (bid next : this.O00000o.O00000o) {
                        if (next.O00000o == String.class) {
                            try {
                                if (next.O00000Oo != null) {
                                    next.O00000Oo.invoke(obj, "");
                                } else {
                                    next.O00000o0.set(obj, "");
                                }
                            } catch (Exception e) {
                                throw new JSONException("create instance error, class " + this.O00000o0.getName(), e);
                            }
                        }
                    }
                }
                return obj;
            } catch (Exception e2) {
                throw new JSONException("create instance error, class " + this.O00000o0.getName(), e2);
            }
        }
    }

    public <T> T O000000o(bdo bdo, Type type, Object obj) {
        return O000000o(bdo, type, obj, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01dd, code lost:
        r1 = r16;
        r2 = r17;
        r3 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01e3, code lost:
        if (r1 != null) goto L_0x0269;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01e5, code lost:
        if (r2 != null) goto L_0x01f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        r0 = O000000o(r20, r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01eb, code lost:
        if (r3 == null) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01ed, code lost:
        r3.f12890O000000o = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01ef, code lost:
        r8.O000000o(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01f2, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        r0 = r7.O00000o.O00000o;
        r4 = r0.size();
        r5 = new java.lang.Object[r4];
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01fe, code lost:
        if (r6 >= r4) goto L_0x0211;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0200, code lost:
        r5[r6] = r2.get(r0.get(r6).f12989O000000o);
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0215, code lost:
        if (r7.O00000o.O00000Oo == null) goto L_0x023d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        r1 = r7.O00000o.O00000Oo.newInstance(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0241, code lost:
        if (r7.O00000o.O00000o0 == null) goto L_0x0269;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        r1 = r7.O00000o.O00000o0.invoke(null, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0269, code lost:
        if (r3 == null) goto L_0x026d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x026b, code lost:
        r3.f12890O000000o = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x026d, code lost:
        r8.O000000o(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0270, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a5, code lost:
        r10.O00000Oo(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ac, code lost:
        if (r10.O00000o0() != 4) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ae, code lost:
        r0 = r10.O0000oO0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b8, code lost:
        if ("@".equals(r0) == false) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ba, code lost:
        r0 = r13.f12890O000000o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bc, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c4, code lost:
        if ("..".equals(r0) == false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c6, code lost:
        r2 = r13.O00000Oo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ca, code lost:
        if (r2.f12890O000000o == null) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cc, code lost:
        r0 = r2.f12890O000000o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cf, code lost:
        r8.O000000o(new _m_j.bdo.O000000o(r2, r0));
        r8.O0000O0o = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e0, code lost:
        if ("$".equals(r0) == false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e2, code lost:
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e5, code lost:
        if (r2.O00000Oo == null) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e7, code lost:
        r2 = r2.O00000Oo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ec, code lost:
        if (r2.f12890O000000o == null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ee, code lost:
        r0 = r2.f12890O000000o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f1, code lost:
        r8.O000000o(new _m_j.bdo.O000000o(r2, r0));
        r8.O0000O0o = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fc, code lost:
        r8.O000000o(new _m_j.bdo.O000000o(r13, r0));
        r8.O0000O0o = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0106, code lost:
        r10.O000000o(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010d, code lost:
        if (r10.O00000o0() != 13) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010f, code lost:
        r10.O000000o(16);
        r8.O000000o(r13, r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0115, code lost:
        if (r3 == null) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0117, code lost:
        r3.f12890O000000o = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0119, code lost:
        r8.O000000o(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x011c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0124, code lost:
        throw new com.imi.fastjson.JSONException("illegal ref");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0140, code lost:
        throw new com.imi.fastjson.JSONException("illegal ref, " + _m_j.bdr.O000000o(r10.O00000o0()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0184, code lost:
        if (r3 == null) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0186, code lost:
        r3.f12890O000000o = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0188, code lost:
        r8.O000000o(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x018b, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02b2  */
    private <T> T O000000o(bdo bdo, Type type, Object obj, Object obj2) {
        bdt bdt;
        Object obj3;
        bdo bdo2 = bdo;
        Type type2 = type;
        Object obj4 = obj;
        bdp O0000O0o = bdo.O0000O0o();
        if (O0000O0o.O00000o0() == 8) {
            O0000O0o.O000000o(16);
            return null;
        }
        bdt O00000o2 = bdo.O00000o();
        try {
            if (O0000O0o.O00000o0() == 13) {
                O0000O0o.O000000o(16);
                T O000000o2 = O000000o(bdo, type);
                bdo2.O000000o(O00000o2);
                return O000000o2;
            } else if (O0000O0o.O00000o0() == 12 || O0000O0o.O00000o0() == 16) {
                if (bdo2.O0000O0o == 2) {
                    bdo2.O0000O0o = 0;
                }
                obj3 = obj2;
                HashMap hashMap = null;
                bdt = null;
                while (true) {
                    try {
                        String O000000o3 = O0000O0o.O000000o(bdo.O00000Oo());
                        if (O000000o3 == null) {
                            if (O0000O0o.O00000o0() == 13) {
                                O0000O0o.O000000o(16);
                                break;
                            } else if (O0000O0o.O00000o0() == 16 && bdo2.O000000o(Feature.AllowArbitraryCommas)) {
                            }
                        }
                        if ("$ref" == O000000o3) {
                            break;
                        } else if (bdf.f12884O000000o == O000000o3) {
                            O0000O0o.O00000Oo(4);
                            if (O0000O0o.O00000o0() == 4) {
                                String O0000oO0 = O0000O0o.O0000oO0();
                                O0000O0o.O000000o(16);
                                if (!(type2 instanceof Class) || !O0000oO0.equals(((Class) type2).getName())) {
                                    Class<?> O000000o4 = bih.O000000o(O0000oO0);
                                    T O000000o5 = bdo.O00000o0().O000000o((Type) O000000o4).O000000o(bdo2, O000000o4, obj4);
                                } else if (O0000O0o.O00000o0() == 13) {
                                    O0000O0o.O000000o();
                                    break;
                                }
                            } else {
                                throw new JSONException("syntax error");
                            }
                        } else {
                            if (obj3 == null && hashMap == null) {
                                obj3 = O000000o(bdo, type);
                                if (obj3 == null) {
                                    hashMap = new HashMap(this.O00000Oo.size());
                                }
                                bdt = bdo2.O000000o(O00000o2, obj3, obj4);
                            }
                            Object obj5 = obj3;
                            HashMap hashMap2 = hashMap;
                            bdt bdt2 = bdt;
                            try {
                                if (!O000000o(bdo, O000000o3, obj5, type, hashMap2)) {
                                    if (O0000O0o.O00000o0() == 13) {
                                        O0000O0o.O000000o();
                                        break;
                                    }
                                    obj3 = obj5;
                                    hashMap = hashMap2;
                                    bdt = bdt2;
                                } else {
                                    if (O0000O0o.O00000o0() != 16) {
                                        if (O0000O0o.O00000o0() == 13) {
                                            O0000O0o.O000000o(16);
                                            break;
                                        } else if (O0000O0o.O00000o0() == 18 || O0000O0o.O00000o0() == 1) {
                                        }
                                    }
                                    obj3 = obj5;
                                    hashMap = hashMap2;
                                    bdt = bdt2;
                                }
                            } catch (Throwable th) {
                                th = th;
                                obj3 = obj5;
                                bdt = bdt2;
                                if (bdt != null) {
                                }
                                bdo2.O000000o(O00000o2);
                                throw th;
                            }
                        }
                    } catch (Exception e) {
                        throw new JSONException("create factory method error, " + this.O00000o.O00000o0.toString(), e);
                    } catch (Exception e2) {
                        throw new JSONException("create instance error, " + this.O00000o.O00000Oo.toGenericString(), e2);
                    } catch (Throwable th2) {
                        th = th2;
                        if (bdt != null) {
                            bdt.f12890O000000o = obj3;
                        }
                        bdo2.O000000o(O00000o2);
                        throw th;
                    }
                }
                throw new JSONException("syntax error, unexpect token " + bdr.O000000o(O0000O0o.O00000o0()));
            } else {
                StringBuffer stringBuffer = new StringBuffer("syntax error, expect {, actual ");
                stringBuffer.append(O0000O0o.O00000o());
                stringBuffer.append(", pos ");
                stringBuffer.append(O0000O0o.O00000oO());
                if (obj4 instanceof String) {
                    stringBuffer.append(", fieldName ");
                    stringBuffer.append(obj4);
                }
                throw new JSONException(stringBuffer.toString());
            }
        } catch (Throwable th3) {
            th = th3;
            obj3 = obj2;
            bdt = null;
            if (bdt != null) {
            }
            bdo2.O000000o(O00000o2);
            throw th;
        }
    }

    private boolean O000000o(bdo bdo, String str, Object obj, Type type, Map<String, Object> map) {
        bdp O0000O0o = bdo.O0000O0o();
        ben ben = this.f12916O000000o.get(str);
        if (ben == null) {
            Iterator<Map.Entry<String, ben>> it = this.f12916O000000o.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (((String) next.getKey()).equalsIgnoreCase(str)) {
                    ben = (ben) next.getValue();
                    break;
                }
            }
        }
        if (ben != null) {
            O0000O0o.O00000Oo(ben.O000000o());
            ben.O000000o(bdo, obj, type, map);
            return true;
        } else if (bdo.O000000o(Feature.IgnoreNotMatch)) {
            O0000O0o.O00000Oo();
            bdo.O000000o((Object) null);
            return false;
        } else {
            throw new JSONException("setter not found, class " + this.O00000o0.getName() + ", property " + str);
        }
    }
}
