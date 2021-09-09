package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.DataConvertUtils;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DataFormatUtils {
    public static ResultPair<Boolean, Boolean> tryBool(Object obj) {
        if (obj == null) {
            Boolean bool = Boolean.FALSE;
            return new ResultPair<>(bool, bool);
        }
        String type = getType(obj);
        char c = 65535;
        boolean z = false;
        switch (type.hashCode()) {
            case -1808118735:
                if (type.equals("String")) {
                    c = 1;
                    break;
                }
                break;
            case -672261858:
                if (type.equals("Integer")) {
                    c = 3;
                    break;
                }
                break;
            case 2374300:
                if (type.equals("Long")) {
                    c = 2;
                    break;
                }
                break;
            case 67973692:
                if (type.equals("Float")) {
                    c = 5;
                    break;
                }
                break;
            case 1729365000:
                if (type.equals("Boolean")) {
                    c = 0;
                    break;
                }
                break;
            case 2052876273:
                if (type.equals("Double")) {
                    c = 4;
                    break;
                }
                break;
        }
        if (c == 0) {
            return new ResultPair<>((Boolean) obj, Boolean.TRUE);
        }
        if (c == 1) {
            return new ResultPair<>(Boolean.valueOf(!obj.equals("false")), Boolean.TRUE);
        }
        if (c == 2 || c == 3) {
            if (Float.parseFloat(String.valueOf(obj)) != 0.0f) {
                z = true;
            }
            return new ResultPair<>(Boolean.valueOf(z), Boolean.TRUE);
        } else if (c == 4 || c == 5) {
            if (((Float) obj).floatValue() != 0.0f) {
                z = true;
            }
            return new ResultPair<>(Boolean.valueOf(z), Boolean.TRUE);
        } else {
            Boolean bool2 = Boolean.FALSE;
            return new ResultPair<>(bool2, bool2);
        }
    }

    public static ResultPair<Float, Boolean> tryNumber(Object obj) {
        Float valueOf = Float.valueOf(0.0f);
        if (obj == null) {
            return new ResultPair<>(valueOf, Boolean.TRUE);
        }
        String type = getType(obj);
        char c = 65535;
        switch (type.hashCode()) {
            case -1808118735:
                if (type.equals("String")) {
                    c = 5;
                    break;
                }
                break;
            case -672261858:
                if (type.equals("Integer")) {
                    c = 4;
                    break;
                }
                break;
            case 2374300:
                if (type.equals("Long")) {
                    c = 3;
                    break;
                }
                break;
            case 67973692:
                if (type.equals("Float")) {
                    c = 2;
                    break;
                }
                break;
            case 1729365000:
                if (type.equals("Boolean")) {
                    c = 0;
                    break;
                }
                break;
            case 2052876273:
                if (type.equals("Double")) {
                    c = 1;
                    break;
                }
                break;
        }
        if (c != 0) {
            if (c == 1 || c == 2 || c == 3 || c == 4) {
                return new ResultPair<>(Float.valueOf(Float.parseFloat(String.valueOf(obj))), Boolean.TRUE);
            }
            if (c != 5) {
                return new ResultPair<>(valueOf, Boolean.FALSE);
            }
            try {
                return new ResultPair<>(Float.valueOf(Float.parseFloat((String) obj)), Boolean.TRUE);
            } catch (Exception unused) {
                return new ResultPair<>(valueOf, Boolean.FALSE);
            }
        } else if (((Boolean) obj).booleanValue()) {
            return new ResultPair<>(Float.valueOf(1.0f), Boolean.TRUE);
        } else {
            return new ResultPair<>(valueOf, Boolean.TRUE);
        }
    }

    public static ResultPair<String, Boolean> tryString(Object obj) {
        if (obj == null) {
            return new ResultPair<>("", Boolean.TRUE);
        }
        String type = getType(obj);
        char c = 65535;
        switch (type.hashCode()) {
            case -1808118735:
                if (type.equals("String")) {
                    c = 5;
                    break;
                }
                break;
            case -672261858:
                if (type.equals("Integer")) {
                    c = 2;
                    break;
                }
                break;
            case 2374300:
                if (type.equals("Long")) {
                    c = 1;
                    break;
                }
                break;
            case 67973692:
                if (type.equals("Float")) {
                    c = 3;
                    break;
                }
                break;
            case 1729365000:
                if (type.equals("Boolean")) {
                    c = 0;
                    break;
                }
                break;
            case 2052876273:
                if (type.equals("Double")) {
                    c = 4;
                    break;
                }
                break;
        }
        if (c != 0) {
            if (c == 1) {
                return new ResultPair<>(Long.toString((long) ((Integer) obj).intValue()), Boolean.TRUE);
            }
            if (c == 2) {
                return new ResultPair<>(Integer.toString(((Integer) obj).intValue()), Boolean.TRUE);
            }
            if (c == 3) {
                Float f = (Float) obj;
                int floatValue = (int) f.floatValue();
                if (((float) floatValue) == f.floatValue()) {
                    return new ResultPair<>(Integer.toString(floatValue), Boolean.TRUE);
                }
                return new ResultPair<>(Float.toString(f.floatValue()), Boolean.TRUE);
            } else if (c == 4) {
                Double d = (Double) obj;
                int doubleValue = (int) d.doubleValue();
                if (((double) doubleValue) == d.doubleValue()) {
                    return new ResultPair<>(Integer.toString(doubleValue), Boolean.TRUE);
                }
                return new ResultPair<>(Double.toString(d.doubleValue()), Boolean.TRUE);
            } else if (c != 5) {
                return new ResultPair<>("", Boolean.FALSE);
            } else {
                return new ResultPair<>((String) obj, Boolean.TRUE);
            }
        } else if (((Boolean) obj).booleanValue()) {
            return new ResultPair<>("1", Boolean.TRUE);
        } else {
            return new ResultPair<>("0", Boolean.TRUE);
        }
    }

    public Object toParserValue(Object obj) {
        if (obj == null) {
            System.out.println("parser value meet an error ! ");
            return null;
        }
        String type = getType(obj);
        char c = 65535;
        switch (type.hashCode()) {
            case -1808118735:
                if (type.equals("String")) {
                    c = 0;
                    break;
                }
                break;
            case -672261858:
                if (type.equals("Integer")) {
                    c = 4;
                    break;
                }
                break;
            case 2887:
                if (type.equals("[B")) {
                    c = 6;
                    break;
                }
                break;
            case 2374300:
                if (type.equals("Long")) {
                    c = 3;
                    break;
                }
                break;
            case 67973692:
                if (type.equals("Float")) {
                    c = 1;
                    break;
                }
                break;
            case 1729365000:
                if (type.equals("Boolean")) {
                    c = 2;
                    break;
                }
                break;
            case 2052876273:
                if (type.equals("Double")) {
                    c = 5;
                    break;
                }
                break;
        }
        float f = 0.0f;
        switch (c) {
            case 0:
            case 1:
            case 2:
                return obj;
            case 3:
            case 4:
                try {
                    f = Float.parseFloat(((Long) obj).toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Integer convert to float failed ! ");
                }
                return Float.valueOf(f);
            case 5:
                try {
                    f = Float.parseFloat(((Double) obj).toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    System.out.println("Double convert to float failed ! ");
                }
                return Float.valueOf(f);
            case 6:
                return new String((byte[]) obj);
            default:
                if (!obj.getClass().isArray() && !(obj instanceof Map)) {
                    System.out.println("The input parameter is not array or map ! ");
                    return null;
                } else if (obj.getClass().isArray()) {
                    Object[] objArr = new Object[Array.getLength(obj)];
                    for (int i = 0; i < objArr.length; i++) {
                        Object parserValue = toParserValue(Array.get(obj, i));
                        if (parserValue == null) {
                            System.out.println("The value in array should not be null ! ");
                            return null;
                        }
                        objArr[i] = parserValue;
                    }
                    return objArr;
                } else if (obj instanceof Map) {
                    Map map = (Map) obj;
                    Set keySet = map.keySet();
                    Iterator it = keySet.iterator();
                    if (!(it.hasNext() ? getType(it.next()) : null).equals("String")) {
                        System.out.println("The key in map only string be permitted ! ");
                        return null;
                    }
                    HashMap hashMap = new HashMap();
                    for (Object next : keySet) {
                        if (next == null || map.get(next) == null) {
                            System.out.println("The value in map should not be null ! ");
                            return null;
                        }
                        hashMap.put((String) next, toParserValue(map.get(next)));
                    }
                    return hashMap;
                } else {
                    System.out.println("The value can not be converted ! ");
                    return null;
                }
        }
    }

    private static String getType(Object obj) {
        String name = obj.getClass().getName();
        return name.substring(name.lastIndexOf(".") + 1);
    }
}
