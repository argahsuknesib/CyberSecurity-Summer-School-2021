package _m_j;

import com.imi.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public final class bhf implements bhn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bhf f12971O000000o = new bhf();

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bhu.O000000o(int, char):void
     arg types: [int, int]
     candidates:
      _m_j.bhu.O000000o(long, char):void
      _m_j.bhu.O000000o(java.lang.String, boolean):void
      _m_j.bhu.O000000o(int, char):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bhu.O000000o(long, char):void
     arg types: [long, int]
     candidates:
      _m_j.bhu.O000000o(int, char):void
      _m_j.bhu.O000000o(java.lang.String, boolean):void
      _m_j.bhu.O000000o(long, char):void */
    public final void O000000o(bhc bhc, Object obj, Object obj2, Type type) throws IOException {
        bhc bhc2 = bhc;
        Object obj3 = obj;
        Object obj4 = obj2;
        Type type2 = type;
        boolean O000000o2 = bhc2.O000000o(SerializerFeature.WriteClassName);
        bhu bhu = bhc2.f12968O000000o;
        int i = 0;
        Type type3 = (!O000000o2 || !(type2 instanceof ParameterizedType)) ? null : ((ParameterizedType) type2).getActualTypeArguments()[0];
        if (obj3 != null) {
            List list = (List) obj3;
            int size = list.size();
            int i2 = size - 1;
            if (i2 == -1) {
                bhu.append((CharSequence) "[]");
                return;
            }
            bhs bhs = bhc2.O00000oo;
            bhc2.O000000o(bhs, obj3, obj4);
            if (size > 1) {
                try {
                    if (bhu.O000000o(SerializerFeature.PrettyFormat)) {
                        bhu.O00000Oo('[');
                        bhc.O00000Oo();
                        while (i < size) {
                            if (i != 0) {
                                bhu.O00000Oo(',');
                            }
                            bhc.O00000o();
                            Object obj5 = list.get(i);
                            if (obj5 == null) {
                                bhc2.f12968O000000o.write("null");
                            } else if (bhc2.O000000o(obj5)) {
                                bhc2.O00000Oo(obj5);
                            } else {
                                bhn O000000o3 = bhc2.O000000o(obj5.getClass());
                                bhc2.O00000oo = new bhs(bhs, obj3, obj4);
                                O000000o3.O000000o(bhc2, obj5, Integer.valueOf(i), type3);
                            }
                            i++;
                        }
                        bhc.O00000o0();
                        bhc.O00000o();
                        bhu.O00000Oo(']');
                        bhc2.O00000oo = bhs;
                        return;
                    }
                } catch (Throwable th) {
                    bhc2.O00000oo = bhs;
                    throw th;
                }
            }
            bhu.O00000Oo('[');
            while (i < i2) {
                Object obj6 = list.get(i);
                if (obj6 == null) {
                    bhu.append((CharSequence) "null,");
                } else {
                    Class<?> cls = obj6.getClass();
                    if (cls == Integer.class) {
                        bhu.O000000o(((Integer) obj6).intValue(), ',');
                    } else if (cls == Long.class) {
                        long longValue = ((Long) obj6).longValue();
                        if (O000000o2) {
                            bhu.O000000o(longValue, 'L');
                            bhu.O000000o(',');
                        } else {
                            bhu.O000000o(longValue, ',');
                        }
                    } else {
                        bhc2.O00000oo = new bhs(bhs, obj3, obj4);
                        if (bhc2.O000000o(obj6)) {
                            bhc2.O00000Oo(obj6);
                        } else {
                            bhc2.O000000o(obj6.getClass()).O000000o(bhc2, obj6, Integer.valueOf(i), type3);
                        }
                        bhu.O00000Oo(',');
                    }
                }
                i++;
            }
            Object obj7 = list.get(i2);
            if (obj7 == null) {
                bhu.append((CharSequence) "null]");
            } else {
                Class<?> cls2 = obj7.getClass();
                if (cls2 == Integer.class) {
                    bhu.O000000o(((Integer) obj7).intValue(), ']');
                } else if (cls2 != Long.class) {
                    bhc2.O00000oo = new bhs(bhs, obj3, obj4);
                    if (bhc2.O000000o(obj7)) {
                        bhc2.O00000Oo(obj7);
                    } else {
                        bhc2.O000000o(obj7.getClass()).O000000o(bhc2, obj7, Integer.valueOf(i2), type3);
                    }
                    bhu.O00000Oo(']');
                } else if (O000000o2) {
                    bhu.O000000o(((Long) obj7).longValue(), 'L');
                    bhu.O000000o(']');
                } else {
                    bhu.O000000o(((Long) obj7).longValue(), ']');
                }
            }
            bhc2.O00000oo = bhs;
        } else if (bhu.O000000o(SerializerFeature.WriteNullListAsEmpty)) {
            bhu.write("[]");
        } else {
            bhu.write("null");
        }
    }
}
