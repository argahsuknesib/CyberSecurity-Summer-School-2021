package _m_j;

import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

public abstract class jlq {
    public static String O000000o(ReadableMap readableMap, String str, String str2) {
        if (readableMap == null) {
            return str2;
        }
        try {
            int i = AnonymousClass1.f1927O000000o[readableMap.getType(str).ordinal()];
            if (i == 1) {
                double d = readableMap.getDouble(str);
                long j = (long) d;
                if (d == ((double) j)) {
                    return String.valueOf(j);
                }
                return String.valueOf(d);
            } else if (i == 2) {
                return String.valueOf(readableMap.getBoolean(str));
            } else {
                if (i == 3) {
                    return readableMap.getString(str);
                }
                if (i != 4) {
                    return str2;
                }
                return null;
            }
        } catch (NoSuchKeyException unused) {
            return str2;
        }
    }

    public static boolean O000000o(ReadableMap readableMap, String str) {
        if (readableMap == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.f1927O000000o[readableMap.getType(str).ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return readableMap.getBoolean(str);
                }
                if (i != 3) {
                    if (i != 4) {
                    }
                    return false;
                }
                String string = readableMap.getString(str);
                if ("true".equalsIgnoreCase(string)) {
                    return true;
                }
                if ("false".equalsIgnoreCase(string)) {
                }
                return false;
            } else if (readableMap.getDouble(str) == 0.0d) {
                return false;
            } else {
                return true;
            }
        } catch (NoSuchKeyException unused) {
            return false;
        }
    }

    public static String O000000o(ReadableArray readableArray, int i, String str) {
        if (readableArray == null) {
            return str;
        }
        try {
            int i2 = AnonymousClass1.f1927O000000o[readableArray.getType(i).ordinal()];
            if (i2 == 1) {
                double d = readableArray.getDouble(i);
                long j = (long) d;
                if (d == ((double) j)) {
                    return String.valueOf(j);
                }
                return String.valueOf(d);
            } else if (i2 == 2) {
                return String.valueOf(readableArray.getBoolean(i));
            } else {
                if (i2 == 3) {
                    return readableArray.getString(i);
                }
                if (i2 != 4) {
                    return str;
                }
                return null;
            }
        } catch (NoSuchKeyException unused) {
            return str;
        }
    }

    public static Object O00000Oo(ReadableMap readableMap, String str) {
        if (readableMap == null) {
            return null;
        }
        try {
            switch (readableMap.getType(str)) {
                case Number:
                    return Double.valueOf(readableMap.getDouble(str));
                case Boolean:
                    return Boolean.valueOf(readableMap.getBoolean(str));
                case String:
                    return readableMap.getString(str);
                case Null:
                    return null;
                case Map:
                    return readableMap.getMap(str);
                case Array:
                    return readableMap.getArray(str);
                default:
                    return null;
            }
        } catch (NoSuchKeyException unused) {
            return null;
        }
    }

    public static Object O000000o(ReadableArray readableArray, int i) {
        if (readableArray == null) {
            return null;
        }
        try {
            int i2 = AnonymousClass1.f1927O000000o[readableArray.getType(i).ordinal()];
            if (i2 == 1) {
                return Double.valueOf(readableArray.getDouble(i));
            }
            if (i2 == 2) {
                return Boolean.valueOf(readableArray.getBoolean(i));
            }
            if (i2 == 3) {
                return readableArray.getString(i);
            }
            if (i2 == 5) {
                return readableArray.getMap(i);
            }
            if (i2 != 6) {
                return null;
            }
            return readableArray.getArray(i);
        } catch (NoSuchKeyException unused) {
            return null;
        }
    }
}
