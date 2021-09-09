package com.facebook.react.bridge;

import android.os.Bundle;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Arguments {
    private static Object makeNativeObject(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Float) || (obj instanceof Long) || (obj instanceof Byte) || (obj instanceof Short)) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj.getClass().isArray()) {
            return makeNativeArray(obj);
        }
        if (obj instanceof List) {
            return makeNativeArray((List) obj);
        }
        if (obj instanceof Map) {
            return makeNativeMap((Map) obj);
        }
        return obj instanceof Bundle ? makeNativeMap((Bundle) obj) : obj;
    }

    public static WritableNativeArray makeNativeArray(List list) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        if (list == null) {
            return writableNativeArray;
        }
        for (Object makeNativeObject : list) {
            Object makeNativeObject2 = makeNativeObject(makeNativeObject);
            if (makeNativeObject2 == null) {
                writableNativeArray.pushNull();
            } else if (makeNativeObject2 instanceof Boolean) {
                writableNativeArray.pushBoolean(((Boolean) makeNativeObject2).booleanValue());
            } else if (makeNativeObject2 instanceof Integer) {
                writableNativeArray.pushInt(((Integer) makeNativeObject2).intValue());
            } else if (makeNativeObject2 instanceof Double) {
                writableNativeArray.pushDouble(((Double) makeNativeObject2).doubleValue());
            } else if (makeNativeObject2 instanceof String) {
                writableNativeArray.pushString((String) makeNativeObject2);
            } else if (makeNativeObject2 instanceof WritableNativeArray) {
                writableNativeArray.pushArray((WritableNativeArray) makeNativeObject2);
            } else if (makeNativeObject2 instanceof WritableNativeMap) {
                writableNativeArray.pushMap((WritableNativeMap) makeNativeObject2);
            } else {
                throw new IllegalArgumentException("Could not convert " + makeNativeObject2.getClass());
            }
        }
        return writableNativeArray;
    }

    public static <T> WritableNativeArray makeNativeArray(final Object obj) {
        if (obj == null) {
            return new WritableNativeArray();
        }
        return makeNativeArray((List) new AbstractList() {
            /* class com.facebook.react.bridge.Arguments.AnonymousClass1 */

            public final int size() {
                return Array.getLength(obj);
            }

            public final Object get(int i) {
                return Array.get(obj, i);
            }
        });
    }

    private static void addEntry(WritableNativeMap writableNativeMap, String str, Object obj) {
        Object makeNativeObject = makeNativeObject(obj);
        if (makeNativeObject == null) {
            writableNativeMap.putNull(str);
        } else if (makeNativeObject instanceof Boolean) {
            writableNativeMap.putBoolean(str, ((Boolean) makeNativeObject).booleanValue());
        } else if (makeNativeObject instanceof Integer) {
            writableNativeMap.putInt(str, ((Integer) makeNativeObject).intValue());
        } else if (makeNativeObject instanceof Number) {
            writableNativeMap.putDouble(str, ((Number) makeNativeObject).doubleValue());
        } else if (makeNativeObject instanceof String) {
            writableNativeMap.putString(str, (String) makeNativeObject);
        } else if (makeNativeObject instanceof WritableNativeArray) {
            writableNativeMap.putArray(str, (WritableNativeArray) makeNativeObject);
        } else if (makeNativeObject instanceof WritableNativeMap) {
            writableNativeMap.putMap(str, (WritableNativeMap) makeNativeObject);
        } else {
            throw new IllegalArgumentException("Could not convert " + makeNativeObject.getClass());
        }
    }

    public static WritableNativeMap makeNativeMap(Map<String, Object> map) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (map == null) {
            return writableNativeMap;
        }
        for (Map.Entry next : map.entrySet()) {
            addEntry(writableNativeMap, (String) next.getKey(), next.getValue());
        }
        return writableNativeMap;
    }

    public static WritableNativeMap makeNativeMap(Bundle bundle) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (bundle == null) {
            return writableNativeMap;
        }
        for (String next : bundle.keySet()) {
            addEntry(writableNativeMap, next, bundle.get(next));
        }
        return writableNativeMap;
    }

    public static WritableArray createArray() {
        return new WritableNativeArray();
    }

    public static WritableMap createMap() {
        return new WritableNativeMap();
    }

    public static WritableNativeArray fromJavaArgs(Object[] objArr) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (Object obj : objArr) {
            if (obj == null) {
                writableNativeArray.pushNull();
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class) {
                    writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (cls == Integer.class) {
                    writableNativeArray.pushDouble(((Integer) obj).doubleValue());
                } else if (cls == Double.class) {
                    writableNativeArray.pushDouble(((Double) obj).doubleValue());
                } else if (cls == Float.class) {
                    writableNativeArray.pushDouble(((Float) obj).doubleValue());
                } else if (cls == String.class) {
                    writableNativeArray.pushString(obj.toString());
                } else if (cls == WritableNativeMap.class) {
                    writableNativeArray.pushMap((WritableNativeMap) obj);
                } else if (cls == WritableNativeArray.class) {
                    writableNativeArray.pushArray((WritableNativeArray) obj);
                } else {
                    throw new RuntimeException("Cannot convert argument of type ".concat(String.valueOf(cls)));
                }
            }
        }
        return writableNativeArray;
    }

    public static WritableArray fromArray(Object obj) {
        WritableArray createArray = createArray();
        int i = 0;
        if (obj instanceof String[]) {
            String[] strArr = (String[]) obj;
            int length = strArr.length;
            while (i < length) {
                createArray.pushString(strArr[i]);
                i++;
            }
        } else if (obj instanceof Bundle[]) {
            Bundle[] bundleArr = (Bundle[]) obj;
            int length2 = bundleArr.length;
            while (i < length2) {
                createArray.pushMap(fromBundle(bundleArr[i]));
                i++;
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length;
            while (i < length3) {
                createArray.pushInt(iArr[i]);
                i++;
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length4 = fArr.length;
            while (i < length4) {
                createArray.pushDouble((double) fArr[i]);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length5 = dArr.length;
            while (i < length5) {
                createArray.pushDouble(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length6 = zArr.length;
            while (i < length6) {
                createArray.pushBoolean(zArr[i]);
                i++;
            }
        } else {
            throw new IllegalArgumentException("Unknown array type " + obj.getClass());
        }
        return createArray;
    }

    public static WritableArray fromList(List list) {
        WritableArray createArray = createArray();
        for (Object next : list) {
            if (next == null) {
                createArray.pushNull();
            } else if (next.getClass().isArray()) {
                createArray.pushArray(fromArray(next));
            } else if (next instanceof Bundle) {
                createArray.pushMap(fromBundle((Bundle) next));
            } else if (next instanceof List) {
                createArray.pushArray(fromList((List) next));
            } else if (next instanceof String) {
                createArray.pushString((String) next);
            } else if (next instanceof Integer) {
                createArray.pushInt(((Integer) next).intValue());
            } else if (next instanceof Number) {
                createArray.pushDouble(((Number) next).doubleValue());
            } else if (next instanceof Boolean) {
                createArray.pushBoolean(((Boolean) next).booleanValue());
            } else {
                throw new IllegalArgumentException("Unknown value type " + next.getClass());
            }
        }
        return createArray;
    }

    public static WritableMap fromBundle(Bundle bundle) {
        WritableMap createMap = createMap();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj == null) {
                createMap.putNull(next);
            } else if (obj.getClass().isArray()) {
                createMap.putArray(next, fromArray(obj));
            } else if (obj instanceof String) {
                createMap.putString(next, (String) obj);
            } else if (obj instanceof Number) {
                if (obj instanceof Integer) {
                    createMap.putInt(next, ((Integer) obj).intValue());
                } else {
                    createMap.putDouble(next, ((Number) obj).doubleValue());
                }
            } else if (obj instanceof Boolean) {
                createMap.putBoolean(next, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Bundle) {
                createMap.putMap(next, fromBundle((Bundle) obj));
            } else if (obj instanceof List) {
                createMap.putArray(next, fromList((List) obj));
            } else {
                throw new IllegalArgumentException("Could not convert " + obj.getClass());
            }
        }
        return createMap;
    }

    public static ArrayList toList(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            switch (readableArray.getType(i)) {
                case Null:
                    arrayList.add(null);
                    break;
                case Boolean:
                    arrayList.add(Boolean.valueOf(readableArray.getBoolean(i)));
                    break;
                case Number:
                    double d = readableArray.getDouble(i);
                    if (d != Math.rint(d)) {
                        arrayList.add(Double.valueOf(d));
                        break;
                    } else {
                        arrayList.add(Integer.valueOf((int) d));
                        break;
                    }
                case String:
                    arrayList.add(readableArray.getString(i));
                    break;
                case Map:
                    arrayList.add(toBundle(readableArray.getMap(i)));
                    break;
                case Array:
                    arrayList.add(toList(readableArray.getArray(i)));
                    break;
                default:
                    throw new IllegalArgumentException("Could not convert object in array.");
            }
        }
        return arrayList;
    }

    public static Bundle toBundle(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        Bundle bundle = new Bundle();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (readableMap.getType(nextKey)) {
                case Null:
                    bundle.putString(nextKey, null);
                    break;
                case Boolean:
                    bundle.putBoolean(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case Number:
                    bundle.putDouble(nextKey, readableMap.getDouble(nextKey));
                    break;
                case String:
                    bundle.putString(nextKey, readableMap.getString(nextKey));
                    break;
                case Map:
                    bundle.putBundle(nextKey, toBundle(readableMap.getMap(nextKey)));
                    break;
                case Array:
                    bundle.putSerializable(nextKey, toList(readableMap.getArray(nextKey)));
                    break;
                default:
                    throw new IllegalArgumentException("Could not convert object with key: " + nextKey + ".");
            }
        }
        return bundle;
    }
}
