package _m_j;

import com.imi.fastjson.JSONException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public final class bei implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bei f12904O000000o = new bei();

    public final int O000000o() {
        return 14;
    }

    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        T t;
        Type type2;
        if (bdo.O0000O0o().O00000o0() == 8) {
            bdo.O0000O0o().O000000o(16);
            return null;
        }
        Type type3 = type;
        while (!(type3 instanceof Class)) {
            if (type3 instanceof ParameterizedType) {
                type3 = ((ParameterizedType) type3).getRawType();
            } else {
                throw new JSONException("TODO");
            }
        }
        Class<AbstractCollection> cls = (Class) type3;
        if (cls == AbstractCollection.class) {
            t = new ArrayList();
        } else if (cls.isAssignableFrom(HashSet.class)) {
            t = new HashSet();
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            t = new LinkedHashSet();
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            t = new TreeSet();
        } else if (cls.isAssignableFrom(ArrayList.class)) {
            t = new ArrayList();
        } else {
            try {
                t = (Collection) cls.newInstance();
            } catch (Exception unused) {
                throw new JSONException("create instane error, class " + cls.getName());
            }
        }
        if (type instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        } else {
            type2 = Object.class;
        }
        bdo.O000000o(type2, t, obj);
        return t;
    }
}
