package _m_j;

import com.imi.fastjson.JSONException;
import com.imi.fastjson.JSONObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class bih {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ConcurrentMap<String, Class<?>> f12994O000000o;

    public static final String O000000o(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static final Byte O00000Oo(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        throw new JSONException("can not cast to byte, value : ".concat(String.valueOf(obj)));
    }

    public static final Character O00000o0(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new JSONException("can not cast to byte, value : ".concat(String.valueOf(obj)));
        }
        throw new JSONException("can not cast to byte, value : ".concat(String.valueOf(obj)));
    }

    public static final Short O00000o(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        throw new JSONException("can not cast to short, value : ".concat(String.valueOf(obj)));
    }

    public static final BigDecimal O00000oO(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0) {
            return null;
        }
        return new BigDecimal(obj2);
    }

    public static final BigInteger O00000oo(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0) {
            return null;
        }
        return new BigInteger(obj2);
    }

    public static final Float O0000O0o(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(obj2));
        }
        throw new JSONException("can not cast to float, value : ".concat(String.valueOf(obj)));
    }

    public static final Double O0000OOo(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(obj2));
        }
        throw new JSONException("can not cast to double, value : ".concat(String.valueOf(obj)));
    }

    private static Date O0000Ooo(Object obj) {
        String str;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        long j = -1;
        if (obj instanceof Number) {
            j = ((Number) obj).longValue();
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.indexOf(45) != -1) {
                if (str2.length() == bdf.O00000o0.length()) {
                    str = bdf.O00000o0;
                } else if (str2.length() == 10) {
                    str = "yyyy-MM-dd";
                } else {
                    str = str2.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd HH:mm:ss.SSS";
                }
                try {
                    return new SimpleDateFormat(str).parse(str2);
                } catch (ParseException unused) {
                    throw new JSONException("can not cast to Date, value : ".concat(String.valueOf(str2)));
                }
            } else if (str2.length() == 0) {
                return null;
            } else {
                j = Long.parseLong(str2);
            }
        }
        if (j >= 0) {
            return new Date(j);
        }
        throw new JSONException("can not cast to Date, value : ".concat(String.valueOf(obj)));
    }

    public static final Long O0000Oo0(Object obj) {
        Calendar calendar = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                bdq bdq = new bdq(str);
                if (bdq.O00000Oo(false)) {
                    calendar = bdq.O0000o0();
                }
                bdq.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        throw new JSONException("can not cast to long, value : ".concat(String.valueOf(obj)));
    }

    public static final Integer O0000Oo(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(str));
        }
        throw new JSONException("can not cast to int, value : ".concat(String.valueOf(obj)));
    }

    public static final Boolean O0000OoO(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            boolean z = true;
            if (((Number) obj).intValue() != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            if ("1".equals(str)) {
                return Boolean.TRUE;
            }
        }
        throw new JSONException("can not cast to int, value : ".concat(String.valueOf(obj)));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bih.O000000o(java.lang.Object, java.lang.Class, _m_j.bdu):T
     arg types: [java.lang.Object, java.lang.Class<?>, _m_j.bdu]
     candidates:
      _m_j.bih.O000000o(java.lang.Object, java.lang.reflect.Type, _m_j.bdu):T
      _m_j.bih.O000000o(java.util.Map<java.lang.String, java.lang.Object>, java.lang.Class, _m_j.bdu):T
      _m_j.bih.O000000o(java.lang.Class<?>, java.util.Map<java.lang.String, java.lang.String>, boolean):java.util.List<_m_j.bid>
      _m_j.bih.O000000o(java.lang.Object, java.lang.Class, _m_j.bdu):T */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static final <T> T O000000o(java.lang.Object r5, java.lang.Class r6, _m_j.bdu r7) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            if (r6 == 0) goto L_0x022e
            java.lang.Class r1 = r5.getClass()
            if (r6 != r1) goto L_0x000d
            return r5
        L_0x000d:
            boolean r1 = r5 instanceof java.util.Map
            if (r1 == 0) goto L_0x002b
            java.lang.Class<java.util.Map> r0 = java.util.Map.class
            if (r6 != r0) goto L_0x0016
            return r5
        L_0x0016:
            r0 = r5
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            if (r6 != r1) goto L_0x0026
            java.lang.String r1 = _m_j.bdf.f12884O000000o
            boolean r1 = r0.containsKey(r1)
            if (r1 != 0) goto L_0x0026
            return r5
        L_0x0026:
            java.lang.Object r5 = O000000o(r0, r6, r7)
            return r5
        L_0x002b:
            boolean r1 = r6.isArray()
            if (r1 == 0) goto L_0x0061
            boolean r1 = r5 instanceof java.util.Collection
            if (r1 == 0) goto L_0x0061
            java.util.Collection r5 = (java.util.Collection) r5
            r0 = 0
            java.lang.Class r1 = r6.getComponentType()
            int r2 = r5.size()
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r2)
            java.util.Iterator r5 = r5.iterator()
        L_0x0048:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0060
            java.lang.Object r2 = r5.next()
            java.lang.Class r3 = r6.getComponentType()
            java.lang.Object r2 = O000000o(r2, r3, r7)
            java.lang.reflect.Array.set(r1, r0, r2)
            int r0 = r0 + 1
            goto L_0x0048
        L_0x0060:
            return r1
        L_0x0061:
            java.lang.Class r7 = r5.getClass()
            boolean r7 = r6.isAssignableFrom(r7)
            if (r7 == 0) goto L_0x006c
            return r5
        L_0x006c:
            java.lang.Class r7 = java.lang.Boolean.TYPE
            if (r6 == r7) goto L_0x0229
            java.lang.Class<java.lang.Boolean> r7 = java.lang.Boolean.class
            if (r6 != r7) goto L_0x0076
            goto L_0x0229
        L_0x0076:
            java.lang.Class r7 = java.lang.Byte.TYPE
            if (r6 == r7) goto L_0x0224
            java.lang.Class<java.lang.Byte> r7 = java.lang.Byte.class
            if (r6 != r7) goto L_0x0080
            goto L_0x0224
        L_0x0080:
            java.lang.Class r7 = java.lang.Short.TYPE
            if (r6 == r7) goto L_0x021f
            java.lang.Class<java.lang.Short> r7 = java.lang.Short.class
            if (r6 != r7) goto L_0x008a
            goto L_0x021f
        L_0x008a:
            java.lang.Class r7 = java.lang.Integer.TYPE
            if (r6 == r7) goto L_0x021a
            java.lang.Class<java.lang.Integer> r7 = java.lang.Integer.class
            if (r6 != r7) goto L_0x0094
            goto L_0x021a
        L_0x0094:
            java.lang.Class r7 = java.lang.Long.TYPE
            if (r6 == r7) goto L_0x0215
            java.lang.Class<java.lang.Long> r7 = java.lang.Long.class
            if (r6 != r7) goto L_0x009e
            goto L_0x0215
        L_0x009e:
            java.lang.Class r7 = java.lang.Float.TYPE
            if (r6 == r7) goto L_0x0210
            java.lang.Class<java.lang.Float> r7 = java.lang.Float.class
            if (r6 != r7) goto L_0x00a8
            goto L_0x0210
        L_0x00a8:
            java.lang.Class r7 = java.lang.Double.TYPE
            if (r6 == r7) goto L_0x020b
            java.lang.Class<java.lang.Double> r7 = java.lang.Double.class
            if (r6 != r7) goto L_0x00b2
            goto L_0x020b
        L_0x00b2:
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            if (r6 != r7) goto L_0x00bb
            java.lang.String r5 = O000000o(r5)
            return r5
        L_0x00bb:
            java.lang.Class<java.math.BigDecimal> r7 = java.math.BigDecimal.class
            if (r6 != r7) goto L_0x00c4
            java.math.BigDecimal r5 = O00000oO(r5)
            return r5
        L_0x00c4:
            java.lang.Class<java.math.BigInteger> r7 = java.math.BigInteger.class
            if (r6 != r7) goto L_0x00cd
            java.math.BigInteger r5 = O00000oo(r5)
            return r5
        L_0x00cd:
            java.lang.Class<java.util.Date> r7 = java.util.Date.class
            if (r6 != r7) goto L_0x00d6
            java.util.Date r5 = O0000Ooo(r5)
            return r5
        L_0x00d6:
            java.lang.Class<java.sql.Date> r7 = java.sql.Date.class
            java.lang.String r1 = "can not cast to Date, value : "
            r2 = 0
            if (r6 != r7) goto L_0x013f
            if (r5 != 0) goto L_0x00e1
            return r0
        L_0x00e1:
            boolean r6 = r5 instanceof java.util.Calendar
            if (r6 == 0) goto L_0x00f1
            java.sql.Date r6 = new java.sql.Date
            java.util.Calendar r5 = (java.util.Calendar) r5
            long r0 = r5.getTimeInMillis()
            r6.<init>(r0)
            return r6
        L_0x00f1:
            boolean r6 = r5 instanceof java.sql.Date
            if (r6 == 0) goto L_0x00f8
            java.sql.Date r5 = (java.sql.Date) r5
            return r5
        L_0x00f8:
            boolean r6 = r5 instanceof java.util.Date
            if (r6 == 0) goto L_0x0108
            java.sql.Date r6 = new java.sql.Date
            java.util.Date r5 = (java.util.Date) r5
            long r0 = r5.getTime()
            r6.<init>(r0)
            return r6
        L_0x0108:
            boolean r6 = r5 instanceof java.lang.Number
            if (r6 == 0) goto L_0x0114
            r6 = r5
            java.lang.Number r6 = (java.lang.Number) r6
            long r6 = r6.longValue()
            goto L_0x0115
        L_0x0114:
            r6 = r2
        L_0x0115:
            boolean r4 = r5 instanceof java.lang.String
            if (r4 == 0) goto L_0x0127
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            int r7 = r6.length()
            if (r7 != 0) goto L_0x0123
            return r0
        L_0x0123:
            long r6 = java.lang.Long.parseLong(r6)
        L_0x0127:
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0131
            java.sql.Date r5 = new java.sql.Date
            r5.<init>(r6)
            return r5
        L_0x0131:
            com.imi.fastjson.JSONException r6 = new com.imi.fastjson.JSONException
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r5 = r1.concat(r5)
            r6.<init>(r5)
            throw r6
        L_0x013f:
            java.lang.Class<java.sql.Timestamp> r7 = java.sql.Timestamp.class
            if (r6 != r7) goto L_0x01a4
            if (r5 != 0) goto L_0x0146
            return r0
        L_0x0146:
            boolean r6 = r5 instanceof java.util.Calendar
            if (r6 == 0) goto L_0x0156
            java.sql.Timestamp r6 = new java.sql.Timestamp
            java.util.Calendar r5 = (java.util.Calendar) r5
            long r0 = r5.getTimeInMillis()
            r6.<init>(r0)
            return r6
        L_0x0156:
            boolean r6 = r5 instanceof java.sql.Timestamp
            if (r6 == 0) goto L_0x015d
            java.sql.Timestamp r5 = (java.sql.Timestamp) r5
            return r5
        L_0x015d:
            boolean r6 = r5 instanceof java.util.Date
            if (r6 == 0) goto L_0x016d
            java.sql.Timestamp r6 = new java.sql.Timestamp
            java.util.Date r5 = (java.util.Date) r5
            long r0 = r5.getTime()
            r6.<init>(r0)
            return r6
        L_0x016d:
            boolean r6 = r5 instanceof java.lang.Number
            if (r6 == 0) goto L_0x0179
            r6 = r5
            java.lang.Number r6 = (java.lang.Number) r6
            long r6 = r6.longValue()
            goto L_0x017a
        L_0x0179:
            r6 = r2
        L_0x017a:
            boolean r4 = r5 instanceof java.lang.String
            if (r4 == 0) goto L_0x018c
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            int r7 = r6.length()
            if (r7 != 0) goto L_0x0188
            return r0
        L_0x0188:
            long r6 = java.lang.Long.parseLong(r6)
        L_0x018c:
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0196
            java.sql.Timestamp r5 = new java.sql.Timestamp
            r5.<init>(r6)
            return r5
        L_0x0196:
            com.imi.fastjson.JSONException r6 = new com.imi.fastjson.JSONException
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r5 = r1.concat(r5)
            r6.<init>(r5)
            throw r6
        L_0x01a4:
            boolean r7 = r6.isEnum()
            if (r7 == 0) goto L_0x01af
            java.lang.Object r5 = O000000o(r5, r6)
            return r5
        L_0x01af:
            java.lang.Class<java.util.Calendar> r7 = java.util.Calendar.class
            boolean r7 = r7.isAssignableFrom(r6)
            java.lang.String r1 = "can not cast to : "
            if (r7 == 0) goto L_0x01e8
            java.util.Date r5 = O0000Ooo(r5)
            java.lang.Class<java.util.Calendar> r7 = java.util.Calendar.class
            if (r6 != r7) goto L_0x01c6
            java.util.Calendar r6 = java.util.Calendar.getInstance()
            goto L_0x01cd
        L_0x01c6:
            java.lang.Object r7 = r6.newInstance()     // Catch:{ Exception -> 0x01d1 }
            java.util.Calendar r7 = (java.util.Calendar) r7     // Catch:{ Exception -> 0x01d1 }
            r6 = r7
        L_0x01cd:
            r6.setTime(r5)
            return r6
        L_0x01d1:
            r5 = move-exception
            com.imi.fastjson.JSONException r7 = new com.imi.fastjson.JSONException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r1)
            java.lang.String r6 = r6.getName()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6, r5)
            throw r7
        L_0x01e8:
            boolean r7 = r5 instanceof java.lang.String
            if (r7 == 0) goto L_0x01f5
            java.lang.String r5 = (java.lang.String) r5
            int r5 = r5.length()
            if (r5 != 0) goto L_0x01f5
            return r0
        L_0x01f5:
            com.imi.fastjson.JSONException r5 = new com.imi.fastjson.JSONException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r1)
            java.lang.String r6 = r6.getName()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>(r6)
            throw r5
        L_0x020b:
            java.lang.Double r5 = O0000OOo(r5)
            return r5
        L_0x0210:
            java.lang.Float r5 = O0000O0o(r5)
            return r5
        L_0x0215:
            java.lang.Long r5 = O0000Oo0(r5)
            return r5
        L_0x021a:
            java.lang.Integer r5 = O0000Oo(r5)
            return r5
        L_0x021f:
            java.lang.Short r5 = O00000o(r5)
            return r5
        L_0x0224:
            java.lang.Byte r5 = O00000Oo(r5)
            return r5
        L_0x0229:
            java.lang.Boolean r5 = O0000OoO(r5)
            return r5
        L_0x022e:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "clazz is null"
            r5.<init>(r6)
            goto L_0x0237
        L_0x0236:
            throw r5
        L_0x0237:
            goto L_0x0236
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.bih.O000000o(java.lang.Object, java.lang.Class, _m_j.bdu):java.lang.Object");
    }

    private static <T> T O000000o(Object obj, Class<T> cls) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                for (T t : (Object[]) cls.getMethod("values", new Class[0]).invoke(null, new Object[0])) {
                    T t2 = (Enum) t;
                    if (t2.ordinal() == intValue) {
                        return t2;
                    }
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e) {
            throw new JSONException("can not cast to : " + cls.getName(), e);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static final <T> T O000000o(java.lang.Object r8, java.lang.reflect.Type r9, _m_j.bdu r10) {
        /*
        L_0x0000:
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r9 instanceof java.lang.Class
            if (r1 == 0) goto L_0x000f
            java.lang.Class r9 = (java.lang.Class) r9
            java.lang.Object r8 = O000000o(r8, r9, r10)
            return r8
        L_0x000f:
            boolean r1 = r9 instanceof java.lang.reflect.ParameterizedType
            java.lang.String r2 = "can not cast to : "
            if (r1 == 0) goto L_0x00c5
            java.lang.reflect.ParameterizedType r9 = (java.lang.reflect.ParameterizedType) r9
            java.lang.reflect.Type r1 = r9.getRawType()
            java.lang.Class<java.util.List> r3 = java.util.List.class
            r4 = 0
            if (r1 == r3) goto L_0x0024
            java.lang.Class<java.util.ArrayList> r3 = java.util.ArrayList.class
            if (r1 != r3) goto L_0x004c
        L_0x0024:
            java.lang.reflect.Type[] r3 = r9.getActualTypeArguments()
            r3 = r3[r4]
            boolean r5 = r8 instanceof java.lang.Iterable
            if (r5 == 0) goto L_0x004c
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x0039:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x004b
            java.lang.Object r0 = r8.next()
            java.lang.Object r0 = O000000o(r0, r3, r10)
            r9.add(r0)
            goto L_0x0039
        L_0x004b:
            return r9
        L_0x004c:
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            r5 = 1
            if (r1 == r3) goto L_0x0055
            java.lang.Class<java.util.HashMap> r3 = java.util.HashMap.class
            if (r1 != r3) goto L_0x0095
        L_0x0055:
            java.lang.reflect.Type[] r3 = r9.getActualTypeArguments()
            r3 = r3[r4]
            java.lang.reflect.Type[] r6 = r9.getActualTypeArguments()
            r6 = r6[r5]
            boolean r7 = r8 instanceof java.util.Map
            if (r7 == 0) goto L_0x0095
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.util.Map r8 = (java.util.Map) r8
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0074:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0094
            java.lang.Object r0 = r8.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.Object r1 = O000000o(r1, r3, r10)
            java.lang.Object r0 = r0.getValue()
            java.lang.Object r0 = O000000o(r0, r6, r10)
            r9.put(r1, r0)
            goto L_0x0074
        L_0x0094:
            return r9
        L_0x0095:
            boolean r3 = r8 instanceof java.lang.String
            if (r3 == 0) goto L_0x00a3
            r3 = r8
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x00a3
            return r0
        L_0x00a3:
            java.lang.reflect.Type[] r0 = r9.getActualTypeArguments()
            int r0 = r0.length
            if (r0 != r5) goto L_0x00b7
            java.lang.reflect.Type[] r0 = r9.getActualTypeArguments()
            r0 = r0[r4]
            boolean r0 = r0 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x00b7
            r9 = r1
            goto L_0x0000
        L_0x00b7:
            com.imi.fastjson.JSONException r8 = new com.imi.fastjson.JSONException
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r9 = r2.concat(r9)
            r8.<init>(r9)
            throw r8
        L_0x00c5:
            boolean r10 = r8 instanceof java.lang.String
            if (r10 == 0) goto L_0x00d3
            r10 = r8
            java.lang.String r10 = (java.lang.String) r10
            int r10 = r10.length()
            if (r10 != 0) goto L_0x00d3
            return r0
        L_0x00d3:
            boolean r10 = r9 instanceof java.lang.reflect.TypeVariable
            if (r10 == 0) goto L_0x00d8
            return r8
        L_0x00d8:
            com.imi.fastjson.JSONException r8 = new com.imi.fastjson.JSONException
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r9 = r2.concat(r9)
            r8.<init>(r9)
            goto L_0x00e7
        L_0x00e6:
            throw r8
        L_0x00e7:
            goto L_0x00e6
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.bih.O000000o(java.lang.Object, java.lang.reflect.Type, _m_j.bdu):java.lang.Object");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bih.O000000o(java.util.Map<java.lang.String, java.lang.Object>, java.lang.Class, _m_j.bdu):T
     arg types: [java.util.Map<java.lang.String, java.lang.Object>, java.lang.Class<?>, _m_j.bdu]
     candidates:
      _m_j.bih.O000000o(java.lang.Object, java.lang.Class, _m_j.bdu):T
      _m_j.bih.O000000o(java.lang.Object, java.lang.reflect.Type, _m_j.bdu):T
      _m_j.bih.O000000o(java.lang.Class<?>, java.util.Map<java.lang.String, java.lang.String>, boolean):java.util.List<_m_j.bid>
      _m_j.bih.O000000o(java.util.Map<java.lang.String, java.lang.Object>, java.lang.Class, _m_j.bdu):T */
    private static <T> T O000000o(Map<String, Object> map, Class cls, bdu bdu) {
        JSONObject jSONObject;
        int i = 0;
        if (cls == StackTraceElement.class) {
            try {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    i = number.intValue();
                }
                return new StackTraceElement(str, str2, str3, i);
            } catch (Exception e) {
                throw new JSONException(e.getMessage(), e);
            }
        } else {
            Object obj = map.get(bdf.f12884O000000o);
            if (obj instanceof String) {
                String str4 = (String) obj;
                Class<?> O000000o2 = O000000o(str4);
                if (O000000o2 == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                } else if (!O000000o2.equals(cls)) {
                    return O000000o(map, (Class) O000000o2, bdu);
                }
            }
            if (cls.isInterface()) {
                if (map instanceof JSONObject) {
                    jSONObject = (JSONObject) map;
                } else {
                    jSONObject = new JSONObject(map);
                }
                return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            }
            if (bdu == null) {
                bdu = bdu.O000000o();
            }
            Map<String, ben> O000000o3 = bdu.O000000o((Class<?>) cls);
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            T newInstance = declaredConstructor.newInstance(new Object[0]);
            for (Map.Entry next : O000000o3.entrySet()) {
                String str5 = (String) next.getKey();
                ben ben = (ben) next.getValue();
                if (map.containsKey(str5)) {
                    Object obj2 = map.get(str5);
                    Method O00000Oo = ben.O00000Oo();
                    if (O00000Oo != null) {
                        O00000Oo.invoke(newInstance, O000000o(obj2, O00000Oo.getGenericParameterTypes()[0], bdu));
                    } else {
                        Field O00000o0 = ben.O00000o0();
                        O00000o0.set(newInstance, O000000o(obj2, O00000o0.getGenericType(), bdu));
                    }
                }
            }
            return newInstance;
        }
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f12994O000000o = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        f12994O000000o.put("short", Short.TYPE);
        f12994O000000o.put("int", Integer.TYPE);
        f12994O000000o.put("long", Long.TYPE);
        f12994O000000o.put("float", Float.TYPE);
        f12994O000000o.put("double", Double.TYPE);
        f12994O000000o.put("boolean", Boolean.TYPE);
        f12994O000000o.put("char", Character.TYPE);
        f12994O000000o.put("[byte", byte[].class);
        f12994O000000o.put("[short", short[].class);
        f12994O000000o.put("[int", int[].class);
        f12994O000000o.put("[long", long[].class);
        f12994O000000o.put("[float", float[].class);
        f12994O000000o.put("[double", double[].class);
        f12994O000000o.put("[boolean", boolean[].class);
        f12994O000000o.put("[char", char[].class);
        f12994O000000o.put(HashMap.class.getName(), HashMap.class);
    }

    private static void O000000o(String str, Class<?> cls) {
        if (str == null) {
            str = cls.getName();
        }
        f12994O000000o.put(str, cls);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:18|19|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0 = java.lang.Class.forName(r5);
        O000000o(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0059 */
    public static Class<?> O000000o(String str) {
        while (str != null && str.length() != 0) {
            Class<?> cls = f12994O000000o.get(str);
            if (cls != null) {
                return cls;
            }
            if (str.charAt(0) == '[') {
                return Array.newInstance(O000000o(str.substring(1)), 0).getClass();
            }
            if (!str.startsWith("L") || !str.endsWith(";")) {
                cls = Thread.currentThread().getContextClassLoader().loadClass(str);
                O000000o(str, cls);
                return cls;
            }
            str = str.substring(1, str.length() - 1);
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bih.O000000o(java.lang.Class<?>, java.util.Map<java.lang.String, java.lang.String>, boolean):java.util.List<_m_j.bid>
     arg types: [java.lang.Class<?>, ?[OBJECT, ARRAY], int]
     candidates:
      _m_j.bih.O000000o(java.lang.Object, java.lang.Class, _m_j.bdu):T
      _m_j.bih.O000000o(java.lang.Object, java.lang.reflect.Type, _m_j.bdu):T
      _m_j.bih.O000000o(java.util.Map<java.lang.String, java.lang.Object>, java.lang.Class, _m_j.bdu):T
      _m_j.bih.O000000o(java.lang.Class<?>, java.util.Map<java.lang.String, java.lang.String>, boolean):java.util.List<_m_j.bid> */
    public static List<bid> O000000o(Class<?> cls) {
        return O000000o(cls, (Map<String, String>) null, true);
    }

    public static List<bid> O000000o(Class<?> cls, Map<String, String> map, boolean z) {
        String[] strArr;
        boolean z2;
        String str;
        bdk bdk;
        String str2;
        bdk bdk2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i = 0;
        while (true) {
            strArr = null;
            if (i >= length) {
                break;
            }
            Method method = methods[i];
            String name = method.getName();
            if (!Modifier.isStatic(method.getModifiers()) && !method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 0 && method.getReturnType() != ClassLoader.class && (!method.getName().equals("getMetaClass") || !method.getReturnType().getName().equals("groovy.lang.MetaClass"))) {
                bdk bdk3 = (bdk) method.getAnnotation(bdk.class);
                if (bdk3 == null) {
                    bdk3 = O000000o(cls, method);
                }
                if (bdk3 != null) {
                    if (bdk3.O00000o0()) {
                        if (bdk3.O000000o().length() != 0) {
                            String O000000o2 = bdk3.O000000o();
                            linkedHashMap.put(O000000o2, new bid(O000000o2, method, null));
                        }
                    }
                }
                if (name.startsWith("get")) {
                    if (name.length() >= 4 && !name.equals("getClass")) {
                        char charAt = name.charAt(3);
                        if (Character.isUpperCase(charAt)) {
                            str2 = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                        } else if (charAt == '_') {
                            str2 = name.substring(4);
                        } else if (charAt == 'f') {
                            str2 = name.substring(3);
                        }
                        if (!O000000o(cls, str2)) {
                            Field O000000o3 = bdu.O000000o(cls, str2);
                            if (O000000o3 == null) {
                                O000000o3 = bdu.O000000o(cls, str2);
                            }
                            if (!(O000000o3 == null || (bdk2 = (bdk) O000000o3.getAnnotation(bdk.class)) == null)) {
                                if (bdk2.O00000o0()) {
                                    if (bdk2.O000000o().length() != 0) {
                                        str2 = bdk2.O000000o();
                                    }
                                }
                            }
                            linkedHashMap.put(str2, new bid(str2, method, O000000o3));
                        }
                    }
                }
                if (name.startsWith("is") && name.length() >= 3) {
                    char charAt2 = name.charAt(2);
                    if (Character.isUpperCase(charAt2)) {
                        str = Character.toLowerCase(name.charAt(2)) + name.substring(3);
                    } else if (charAt2 == '_') {
                        str = name.substring(3);
                    } else if (charAt2 == 'f') {
                        str = name.substring(2);
                    }
                    Field O000000o4 = bdu.O000000o(cls, str);
                    if (!(O000000o4 == null || (bdk = (bdk) O000000o4.getAnnotation(bdk.class)) == null)) {
                        if (bdk.O00000o0()) {
                            if (bdk.O000000o().length() != 0) {
                                str = bdk.O000000o();
                            }
                        }
                    }
                    linkedHashMap.put(str, new bid(str, method, O000000o4));
                }
            }
            i++;
        }
        for (Field field : cls.getFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                bdk bdk4 = (bdk) field.getAnnotation(bdk.class);
                String name2 = field.getName();
                if (bdk4 != null) {
                    if (bdk4.O00000o0()) {
                        if (bdk4.O000000o().length() != 0) {
                            name2 = bdk4.O000000o();
                        }
                    }
                }
                if (!linkedHashMap.containsKey(name2)) {
                    linkedHashMap.put(name2, new bid(name2, null, field));
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        bdl bdl = (bdl) cls.getAnnotation(bdl.class);
        if (bdl != null && (strArr = bdl.O000000o()) != null && strArr.length == linkedHashMap.size()) {
            int length2 = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length2) {
                    if (!linkedHashMap.containsKey(strArr[i2])) {
                        break;
                    }
                    i2++;
                } else {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            for (String str3 : strArr) {
                arrayList.add((bid) linkedHashMap.get(str3));
            }
        } else {
            for (bid add : linkedHashMap.values()) {
                arrayList.add(add);
            }
            if (z) {
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public static bdk O000000o(Class<?> cls, Method method) {
        boolean z;
        bdk bdk;
        for (Class<?> methods : cls.getInterfaces()) {
            for (Method method2 : methods.getMethods()) {
                if (method2.getName().equals(method.getName()) && method2.getParameterTypes().length == method.getParameterTypes().length) {
                    int i = 0;
                    while (true) {
                        if (i >= method2.getParameterTypes().length) {
                            z = true;
                            break;
                        } else if (!method2.getParameterTypes()[i].equals(method.getParameterTypes()[i])) {
                            z = false;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z && (bdk = (bdk) method2.getAnnotation(bdk.class)) != null) {
                        return bdk;
                    }
                }
            }
        }
        return null;
    }

    private static boolean O000000o(Class<?> cls, String str) {
        bdl bdl = (bdl) cls.getAnnotation(bdl.class);
        if (!(bdl == null || bdl.O00000Oo() == null)) {
            for (String equalsIgnoreCase : bdl.O00000Oo()) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return (cls.getSuperclass() == Object.class || cls.getSuperclass() == null || !O000000o(cls.getSuperclass(), str)) ? false : true;
    }

    public static Class<?> O000000o(Type type) {
        while (type.getClass() != Class.class) {
            if (!(type instanceof ParameterizedType)) {
                return Object.class;
            }
            type = ((ParameterizedType) type).getRawType();
        }
        return (Class) type;
    }
}
