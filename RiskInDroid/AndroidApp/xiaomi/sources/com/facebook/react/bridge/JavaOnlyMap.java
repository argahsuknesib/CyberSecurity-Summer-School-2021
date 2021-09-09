package com.facebook.react.bridge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JavaOnlyMap implements ReadableMap, WritableMap {
    public final Map mBackingMap;

    public static JavaOnlyMap of(Object... objArr) {
        return new JavaOnlyMap(objArr);
    }

    public static JavaOnlyMap deepClone(ReadableMap readableMap) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (readableMap.getType(nextKey)) {
                case Null:
                    javaOnlyMap.putNull(nextKey);
                    break;
                case Boolean:
                    javaOnlyMap.putBoolean(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case Number:
                    javaOnlyMap.putDouble(nextKey, readableMap.getDouble(nextKey));
                    break;
                case String:
                    javaOnlyMap.putString(nextKey, readableMap.getString(nextKey));
                    break;
                case Map:
                    javaOnlyMap.putMap(nextKey, deepClone(readableMap.getMap(nextKey)));
                    break;
                case Array:
                    javaOnlyMap.putArray(nextKey, JavaOnlyArray.deepClone(readableMap.getArray(nextKey)));
                    break;
            }
        }
        return javaOnlyMap;
    }

    private JavaOnlyMap(Object... objArr) {
        if (objArr.length % 2 == 0) {
            this.mBackingMap = new HashMap();
            for (int i = 0; i < objArr.length; i += 2) {
                Object obj = objArr[i + 1];
                if (obj instanceof Number) {
                    obj = Double.valueOf(((Number) obj).doubleValue());
                }
                this.mBackingMap.put(objArr[i], obj);
            }
            return;
        }
        throw new IllegalArgumentException("You must provide the same number of keys and values");
    }

    public JavaOnlyMap() {
        this.mBackingMap = new HashMap();
    }

    public boolean hasKey(String str) {
        return this.mBackingMap.containsKey(str);
    }

    public boolean isNull(String str) {
        return this.mBackingMap.get(str) == null;
    }

    public boolean getBoolean(String str) {
        return ((Boolean) this.mBackingMap.get(str)).booleanValue();
    }

    public double getDouble(String str) {
        return ((Number) this.mBackingMap.get(str)).doubleValue();
    }

    public int getInt(String str) {
        return ((Number) this.mBackingMap.get(str)).intValue();
    }

    public String getString(String str) {
        return (String) this.mBackingMap.get(str);
    }

    public ReadableMap getMap(String str) {
        return (ReadableMap) this.mBackingMap.get(str);
    }

    public ReadableArray getArray(String str) {
        return (ReadableArray) this.mBackingMap.get(str);
    }

    public Dynamic getDynamic(String str) {
        return DynamicFromMap.create(this, str);
    }

    public ReadableType getType(String str) {
        Object obj = this.mBackingMap.get(str);
        if (obj == null) {
            return ReadableType.Null;
        }
        if (obj instanceof Number) {
            return ReadableType.Number;
        }
        if (obj instanceof String) {
            return ReadableType.String;
        }
        if (obj instanceof Boolean) {
            return ReadableType.Boolean;
        }
        if (obj instanceof ReadableMap) {
            return ReadableType.Map;
        }
        if (obj instanceof ReadableArray) {
            return ReadableType.Array;
        }
        if (obj instanceof Dynamic) {
            return ((Dynamic) obj).getType();
        }
        throw new IllegalArgumentException("Invalid value " + obj.toString() + " for key " + str + "contained in JavaOnlyMap");
    }

    public Iterator<Map.Entry<String, Object>> getEntryIterator() {
        return this.mBackingMap.entrySet().iterator();
    }

    public ReadableMapKeySetIterator keySetIterator() {
        return new ReadableMapKeySetIterator() {
            /* class com.facebook.react.bridge.JavaOnlyMap.AnonymousClass1 */
            Iterator<Map.Entry<String, Object>> mIterator = JavaOnlyMap.this.mBackingMap.entrySet().iterator();

            public boolean hasNextKey() {
                return this.mIterator.hasNext();
            }

            public String nextKey() {
                return (String) this.mIterator.next().getKey();
            }
        };
    }

    public void putBoolean(String str, boolean z) {
        this.mBackingMap.put(str, Boolean.valueOf(z));
    }

    public void putDouble(String str, double d) {
        this.mBackingMap.put(str, Double.valueOf(d));
    }

    public void putInt(String str, int i) {
        this.mBackingMap.put(str, new Double((double) i));
    }

    public void putString(String str, String str2) {
        this.mBackingMap.put(str, str2);
    }

    public void putNull(String str) {
        this.mBackingMap.put(str, null);
    }

    public void putMap(String str, ReadableMap readableMap) {
        this.mBackingMap.put(str, readableMap);
    }

    public void merge(ReadableMap readableMap) {
        this.mBackingMap.putAll(((JavaOnlyMap) readableMap).mBackingMap);
    }

    public WritableMap copy() {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.merge(this);
        return javaOnlyMap;
    }

    public void putArray(String str, ReadableArray readableArray) {
        this.mBackingMap.put(str, readableArray);
    }

    public HashMap<String, Object> toHashMap() {
        return new HashMap<>(this.mBackingMap);
    }

    public String toString() {
        return this.mBackingMap.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JavaOnlyMap javaOnlyMap = (JavaOnlyMap) obj;
        Map map = this.mBackingMap;
        return map == null ? javaOnlyMap.mBackingMap == null : map.equals(javaOnlyMap.mBackingMap);
    }

    public int hashCode() {
        Map map = this.mBackingMap;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }
}
