package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public final class bhi implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static bhi f12974O000000o = new bhi();

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bhu.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.bhu.O000000o(int, char):void
      _m_j.bhu.O000000o(long, char):void
      _m_j.bhu.O000000o(java.lang.String, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c9 A[Catch:{ all -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cd A[Catch:{ all -> 0x00ff }] */
    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        boolean z;
        bhc bhc2 = bhc;
        Object obj3 = obj;
        bhu bhu = bhc2.f12968O000000o;
        if (obj3 == null) {
            bhu.write("null");
            return;
        }
        Map map = (Map) obj3;
        if (bhu.O000000o(SerializerFeature.SortField) && !(map instanceof SortedMap) && !(map instanceof LinkedHashMap)) {
            try {
                map = new TreeMap(map);
            } catch (Exception unused) {
            }
        }
        if (bhc.O000000o(obj)) {
            bhc.O00000Oo(obj);
            return;
        }
        bhs bhs = bhc2.O00000oo;
        bhc2.O000000o(bhs, obj3, obj2);
        try {
            bhu.O000000o('{');
            bhc.O00000Oo();
            if (bhu.O000000o(SerializerFeature.WriteClassName)) {
                bhu.O000000o(bdf.f12884O000000o, false);
                bhu.O000000o(obj.getClass().getName());
                z = false;
            } else {
                z = true;
            }
            Class<?> cls = null;
            bhn bhn = null;
            for (Map.Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                Object key = entry.getKey();
                if (key != null) {
                    if (!(key instanceof String)) {
                        if (!z) {
                            bhu.O000000o(',');
                        }
                        bhc2.O00000o0(key);
                        bhu.O000000o(':');
                        if (value != null) {
                            bhu.write("null");
                        } else {
                            Class<?> cls2 = value.getClass();
                            if (cls2 == cls) {
                                bhn.O000000o(bhc2, value, key, null);
                            } else {
                                bhn = bhc2.O000000o(cls2);
                                bhn.O000000o(bhc2, value, key, null);
                                cls = cls2;
                            }
                        }
                        z = false;
                    }
                }
                String str = (String) key;
                if (bgu.O000000o(bhc) && bgu.O00000Oo(bhc)) {
                    String O000000o2 = bgu.O000000o(bhc2, str);
                    value = bgu.O000000o(bhc2, value);
                    if (value != null || bhc2.O000000o(SerializerFeature.WriteMapNullValue)) {
                        if (!z) {
                            bhu.O000000o(',');
                        }
                        if (bhu.O000000o(SerializerFeature.PrettyFormat)) {
                            bhc.O00000o();
                        }
                        bhu.O000000o(O000000o2, true);
                        if (value != null) {
                        }
                        z = false;
                    }
                }
            }
            bhc2.O00000oo = bhs;
            bhc.O00000o0();
            if (bhu.O000000o(SerializerFeature.PrettyFormat) && map.size() > 0) {
                bhc.O00000o();
            }
            bhu.O000000o('}');
        } catch (Throwable th) {
            bhc2.O00000oo = bhs;
            throw th;
        }
    }
}
