package _m_j;

import _m_j.bdo;
import com.imi.fastjson.JSONArray;
import com.imi.fastjson.JSONException;
import com.imi.fastjson.JSONObject;
import com.imi.fastjson.parser.Feature;
import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class bdf implements bdg, bdh {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f12884O000000o = "@type";
    public static int O00000Oo = ((((((((Feature.AutoCloseSource.getMask() | 0) | Feature.InternFieldNames.getMask()) | Feature.UseBigDecimal.getMask()) | Feature.AllowUnQuotedFieldNames.getMask()) | Feature.AllowSingleQuotes.getMask()) | Feature.AllowArbitraryCommas.getMask()) | Feature.SortFeidFastMatch.getMask()) | Feature.IgnoreNotMatch.getMask());
    public static int O00000o = ((((SerializerFeature.QuoteFieldNames.getMask() | 0) | SerializerFeature.SkipTransientField.getMask()) | SerializerFeature.WriteEnumUsingToString.getMask()) | SerializerFeature.SortField.getMask());
    public static String O00000o0 = "yyyy-MM-dd HH:mm:ss";

    public static final <T> T O000000o(String str, bdi<T> bdi, Feature... featureArr) {
        return O000000o(str, bdi.getType(), bdu.O000000o(), O00000Oo, featureArr);
    }

    private static <T> T O000000o(String str, Type type, bdu bdu, int i, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (Feature config : featureArr) {
            i = Feature.config(i, config, true);
        }
        bdo bdo = new bdo(str, bdu, i);
        T O000000o2 = bdo.O000000o(type);
        O000000o(bdo);
        bdo.close();
        return O000000o2;
    }

    public static final <T> T O000000o(String str, Class<T> cls) {
        return O000000o(str, cls, bdu.O000000o(), O00000Oo, new Feature[0]);
    }

    public static final String O000000o(Object obj) {
        return O000000o(obj, new SerializerFeature[0]);
    }

    public static final String O000000o(Object obj, SerializerFeature... serializerFeatureArr) {
        bhu bhu = new bhu();
        try {
            bhc bhc = new bhc(bhu);
            for (SerializerFeature mask : serializerFeatureArr) {
                bhu bhu2 = bhc.f12968O000000o;
                bhu2.O00000o0 = mask.getMask() | bhu2.O00000o0;
            }
            bhc.O00000o0(obj);
            return bhu.toString();
        } finally {
            bhu.close();
        }
    }

    public String toString() {
        return O000000o();
    }

    public final String O000000o() {
        bhu bhu = new bhu();
        try {
            new bhc(bhu).O00000o0(this);
            return bhu.toString();
        } finally {
            bhu.close();
        }
    }

    public final void O000000o(Appendable appendable) {
        bhu bhu = new bhu();
        try {
            new bhc(bhu).O00000o0(this);
            appendable.append(bhu.toString());
            bhu.close();
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        } catch (Throwable th) {
            bhu.close();
            throw th;
        }
    }

    public static final Object O00000Oo(Object obj) {
        return O000000o(obj, bdu.O000000o());
    }

    private static Object O000000o(Object obj, bdu bdu) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof bdf) {
            return (bdf) obj;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            JSONObject jSONObject = new JSONObject(map.size());
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put(bih.O000000o(entry.getKey()), O000000o(entry.getValue(), bdu.O000000o()));
            }
            return jSONObject;
        } else if (obj instanceof Collection) {
            Collection<Object> collection = (Collection) obj;
            JSONArray jSONArray = new JSONArray(collection.size());
            for (Object O000000o2 : collection) {
                jSONArray.add(O000000o(O000000o2, bdu.O000000o()));
            }
            return jSONArray;
        } else {
            Class<?> cls = obj.getClass();
            if (cls.isEnum()) {
                return ((Enum) obj).name();
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                JSONArray jSONArray2 = new JSONArray(length);
                for (int i = 0; i < length; i++) {
                    jSONArray2.add(O000000o(Array.get(obj, i), bdu.O000000o()));
                }
                return jSONArray2;
            } else if (bdu.f12891O000000o.contains(cls)) {
                return obj;
            } else {
                try {
                    List<bid> O000000o3 = bih.O000000o(cls);
                    JSONObject jSONObject2 = new JSONObject(O000000o3.size());
                    for (bid next : O000000o3) {
                        jSONObject2.put(next.f12989O000000o, O000000o(next.O000000o(obj), bdu.O000000o()));
                    }
                    return jSONObject2;
                } catch (Exception e) {
                    throw new JSONException("toJSON error", e);
                }
            }
        }
    }

    private static <T> int O000000o(bdo bdo) {
        Object obj;
        int size = bdo.O00000oo.size();
        for (int i = 0; i < size; i++) {
            bdo.O000000o o000000o = bdo.O00000oo.get(i);
            ben ben = o000000o.O00000o0;
            Object obj2 = null;
            if (o000000o.O00000o != null) {
                obj2 = o000000o.O00000o.f12890O000000o;
            }
            String str = o000000o.O00000Oo;
            if (str.startsWith("$")) {
                obj = bdo.O000000o(str);
            } else {
                obj = o000000o.f12887O000000o.f12890O000000o;
            }
            ben.O000000o(obj2, obj);
        }
        return size;
    }
}
