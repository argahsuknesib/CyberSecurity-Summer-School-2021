package _m_j;

import com.imi.fastjson.JSONException;
import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class bhe implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final bgs[] f12970O000000o;
    private final bgs[] O00000Oo;

    public bhe(Class<?> cls) {
        this(cls, (byte) 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bih.O000000o(java.lang.Class<?>, java.util.Map<java.lang.String, java.lang.String>, boolean):java.util.List<_m_j.bid>
     arg types: [java.lang.Class<?>, ?[OBJECT, ARRAY], int]
     candidates:
      _m_j.bih.O000000o(java.lang.Object, java.lang.Class, _m_j.bdu):T
      _m_j.bih.O000000o(java.lang.Object, java.lang.reflect.Type, _m_j.bdu):T
      _m_j.bih.O000000o(java.util.Map<java.lang.String, java.lang.Object>, java.lang.Class, _m_j.bdu):T
      _m_j.bih.O000000o(java.lang.Class<?>, java.util.Map<java.lang.String, java.lang.String>, boolean):java.util.List<_m_j.bid> */
    private bhe(Class<?> cls, byte b) {
        ArrayList arrayList = new ArrayList();
        for (bid O000000o2 : bih.O000000o(cls, (Map<String, String>) null, false)) {
            arrayList.add(O000000o(O000000o2));
        }
        this.f12970O000000o = (bgs[]) arrayList.toArray(new bgs[arrayList.size()]);
        ArrayList arrayList2 = new ArrayList();
        for (bid O000000o3 : bih.O000000o(cls, (Map<String, String>) null, true)) {
            arrayList2.add(O000000o(O000000o3));
        }
        this.O00000Oo = (bgs[]) arrayList2.toArray(new bgs[arrayList2.size()]);
    }

    /* access modifiers changed from: protected */
    public boolean O000000o(bhc bhc, Type type) {
        if (!bhc.f12968O000000o.O000000o(SerializerFeature.WriteClassName)) {
            return false;
        }
        if (type == null && bhc.O000000o(SerializerFeature.NotWriteRootClassName)) {
            if (bhc.O00000oo.f12978O000000o == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bhu.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.bhu.O000000o(int, char):void
      _m_j.bhu.O000000o(long, char):void
      _m_j.bhu.O000000o(java.lang.String, boolean):void */
    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bgs[] bgsArr;
        boolean z;
        Field O000000o2;
        bhu bhu = bhc.f12968O000000o;
        if (obj == null) {
            bhu.write("null");
        } else if (bhc.O000000o(obj)) {
            bhc.O00000Oo(obj);
        } else {
            if (bhu.O000000o(SerializerFeature.SortField)) {
                bgsArr = this.O00000Oo;
            } else {
                bgsArr = this.f12970O000000o;
            }
            bhs bhs = bhc.O00000oo;
            bhc.O000000o(bhs, obj, obj2);
            try {
                bhu.O00000Oo('{');
                if (bgsArr.length > 0 && bhu.O000000o(SerializerFeature.PrettyFormat)) {
                    bhc.O00000Oo();
                    bhc.O00000o();
                }
                if (!O000000o(bhc, type) || obj.getClass() == type) {
                    z = false;
                } else {
                    bhu.O000000o(bdf.f12884O000000o, false);
                    bhc.O00000o0(obj.getClass());
                    z = true;
                }
                boolean z2 = z;
                for (bgs bgs : bgsArr) {
                    if ((!bhc.O000000o(SerializerFeature.SkipTransientField) || (O000000o2 = bgs.O000000o()) == null || !Modifier.isTransient(O000000o2.getModifiers())) && bgu.O000000o(bhc)) {
                        Object O000000o3 = bgs.O000000o(obj);
                        if (bgu.O00000Oo(bhc)) {
                            String O000000o4 = bgu.O000000o(bhc, bgs.O00000Oo());
                            Object O000000o5 = bgu.O000000o(bhc, O000000o3);
                            if (O000000o5 != null || bgs.O00000Oo || bhc.O000000o(SerializerFeature.WriteMapNullValue)) {
                                if (z2) {
                                    bhu.O00000Oo(',');
                                    if (bhu.O000000o(SerializerFeature.PrettyFormat)) {
                                        bhc.O00000o();
                                    }
                                }
                                if (O000000o4 != bgs.O00000Oo()) {
                                    bhu.O000000o(O000000o4, false);
                                    bhc.O00000o0(O000000o5);
                                } else if (O000000o3 != O000000o5) {
                                    bgs.O000000o(bhc);
                                    bhc.O00000o0(O000000o5);
                                } else {
                                    bgs.O000000o(bhc, O000000o5);
                                }
                                z2 = true;
                            }
                        }
                    }
                }
                if (bgsArr.length > 0 && bhu.O000000o(SerializerFeature.PrettyFormat)) {
                    bhc.O00000o0();
                    bhc.O00000o();
                }
                bhu.O00000Oo('}');
                bhc.O00000oo = bhs;
            } catch (Exception e) {
                throw new JSONException("write javaBean error", e);
            } catch (Throwable th) {
                bhc.O00000oo = bhs;
                throw th;
            }
        }
    }

    private static bgs O000000o(bid bid) {
        if (bid.O00000o == Number.class) {
            return new bhk(bid);
        }
        return new bhm(bid);
    }
}
