package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@DoNotStrip
public class ReadableNativeMap extends NativeMap implements ReadableMap {
    private static int mJniCallCounter;
    private String[] mKeys;
    private HashMap<String, Object> mLocalMap;
    private HashMap<String, ReadableType> mLocalTypeMap;

    private native String[] importKeys();

    private native Object[] importTypes();

    private native Object[] importValues();

    static {
        ReactBridge.staticInit();
    }

    protected ReadableNativeMap(HybridData hybridData) {
        super(hybridData);
    }

    public static int getJNIPassCounter() {
        return mJniCallCounter;
    }

    public HashMap<String, Object> getLocalMap() {
        HashMap<String, Object> hashMap = this.mLocalMap;
        if (hashMap != null) {
            return hashMap;
        }
        synchronized (this) {
            if (this.mKeys == null) {
                this.mKeys = (String[]) Assertions.assertNotNull(importKeys());
                mJniCallCounter++;
            }
            if (this.mLocalMap == null) {
                Object[] objArr = (Object[]) Assertions.assertNotNull(importValues());
                mJniCallCounter++;
                int length = this.mKeys.length;
                this.mLocalMap = new HashMap<>(length);
                for (int i = 0; i < length; i++) {
                    this.mLocalMap.put(this.mKeys[i], objArr[i]);
                }
            }
        }
        return this.mLocalMap;
    }

    private HashMap<String, ReadableType> getLocalTypeMap() {
        HashMap<String, ReadableType> hashMap = this.mLocalTypeMap;
        if (hashMap != null) {
            return hashMap;
        }
        synchronized (this) {
            if (this.mKeys == null) {
                this.mKeys = (String[]) Assertions.assertNotNull(importKeys());
                mJniCallCounter++;
            }
            if (this.mLocalTypeMap == null) {
                Object[] objArr = (Object[]) Assertions.assertNotNull(importTypes());
                mJniCallCounter++;
                int length = this.mKeys.length;
                this.mLocalTypeMap = new HashMap<>(length);
                for (int i = 0; i < length; i++) {
                    this.mLocalTypeMap.put(this.mKeys[i], (ReadableType) objArr[i]);
                }
            }
        }
        return this.mLocalTypeMap;
    }

    public boolean hasKey(String str) {
        return getLocalMap().containsKey(str);
    }

    public boolean isNull(String str) {
        if (getLocalMap().containsKey(str)) {
            return getLocalMap().get(str) == null;
        }
        throw new NoSuchKeyException(str);
    }

    private Object getValue(String str) {
        if (hasKey(str) && !isNull(str)) {
            return Assertions.assertNotNull(getLocalMap().get(str));
        }
        throw new NoSuchKeyException(str);
    }

    private <T> T getValue(String str, Class<T> cls) {
        T value = getValue(str);
        checkInstance(str, value, cls);
        return value;
    }

    private Object getNullableValue(String str) {
        if (hasKey(str)) {
            return getLocalMap().get(str);
        }
        throw new NoSuchKeyException(str);
    }

    private <T> T getNullableValue(String str, Class<T> cls) {
        T nullableValue = getNullableValue(str);
        checkInstance(str, nullableValue, cls);
        return nullableValue;
    }

    private void checkInstance(String str, Object obj, Class cls) {
        if (obj != null && !cls.isInstance(obj)) {
            throw new UnexpectedNativeTypeException("Value for " + str + " cannot be cast from " + obj.getClass().getSimpleName() + " to " + cls.getSimpleName());
        }
    }

    public boolean getBoolean(String str) {
        return ((Boolean) getValue(str, Boolean.class)).booleanValue();
    }

    public double getDouble(String str) {
        return ((Double) getValue(str, Double.class)).doubleValue();
    }

    public int getInt(String str) {
        return ((Double) getValue(str, Double.class)).intValue();
    }

    public String getString(String str) {
        return (String) getNullableValue(str, String.class);
    }

    public ReadableArray getArray(String str) {
        return (ReadableArray) getNullableValue(str, ReadableArray.class);
    }

    public ReadableNativeMap getMap(String str) {
        return (ReadableNativeMap) getNullableValue(str, ReadableNativeMap.class);
    }

    public ReadableType getType(String str) {
        if (getLocalTypeMap().containsKey(str)) {
            return (ReadableType) Assertions.assertNotNull(getLocalTypeMap().get(str));
        }
        throw new NoSuchKeyException(str);
    }

    public Dynamic getDynamic(String str) {
        return DynamicFromMap.create(this, str);
    }

    public Iterator<Map.Entry<String, Object>> getEntryIterator() {
        return getLocalMap().entrySet().iterator();
    }

    public ReadableMapKeySetIterator keySetIterator() {
        return new ReadableNativeMapKeySetIterator(this);
    }

    public int hashCode() {
        return getLocalMap().hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ReadableNativeMap)) {
            return false;
        }
        return getLocalMap().equals(((ReadableNativeMap) obj).getLocalMap());
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap<>(getLocalMap());
        for (String next : hashMap.keySet()) {
            switch (getType(next)) {
                case Null:
                case Boolean:
                case Number:
                case String:
                    break;
                case Map:
                    hashMap.put(next, ((ReadableNativeMap) Assertions.assertNotNull(getMap(next))).toHashMap());
                    break;
                case Array:
                    hashMap.put(next, ((ReadableArray) Assertions.assertNotNull(getArray(next))).toArrayList());
                    break;
                default:
                    throw new IllegalArgumentException("Could not convert object with key: " + next + ".");
            }
        }
        return hashMap;
    }

    static class ReadableNativeMapKeySetIterator implements ReadableMapKeySetIterator {
        private final Iterator<String> mIterator;

        public ReadableNativeMapKeySetIterator(ReadableNativeMap readableNativeMap) {
            this.mIterator = readableNativeMap.getLocalMap().keySet().iterator();
        }

        public boolean hasNextKey() {
            return this.mIterator.hasNext();
        }

        public String nextKey() {
            return this.mIterator.next();
        }
    }
}
