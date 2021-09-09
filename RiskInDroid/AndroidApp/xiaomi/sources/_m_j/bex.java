package _m_j;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;

public final class bex implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bex f12917O000000o = new bex();

    public final int O000000o() {
        return 12;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void
     arg types: [java.lang.reflect.Type, java.util.ArrayList]
     candidates:
      _m_j.bdo.O000000o(java.lang.Object, java.lang.Object):_m_j.bdt
      _m_j.bdo.O000000o(java.util.Collection, java.lang.Object):void
      _m_j.bdo.O000000o(java.util.Map, java.lang.Object):java.lang.Object
      _m_j.bdo.O000000o(java.util.Map, java.lang.String):void
      _m_j.bdo.O000000o(java.lang.reflect.Type, java.util.Collection):void */
    public final <T> T O000000o(bdo bdo, Type type, Object obj) {
        if (!(type instanceof GenericArrayType)) {
            return bdo.O000000o(obj);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        if (genericComponentType instanceof TypeVariable) {
            genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
        }
        ArrayList arrayList = new ArrayList();
        bdo.O000000o(genericComponentType, (Collection) arrayList);
        if (!(genericComponentType instanceof Class)) {
            return arrayList.toArray();
        }
        Object obj2 = (Object[]) Array.newInstance((Class) genericComponentType, arrayList.size());
        arrayList.toArray(obj2);
        return obj2;
    }
}
