package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class WritableNativeMap extends ReadableNativeMap implements WritableMap {
    private static native HybridData initHybrid();

    private native void mergeNativeMap(ReadableNativeMap readableNativeMap);

    private native void putNativeArray(String str, WritableNativeArray writableNativeArray);

    private native void putNativeMap(String str, WritableNativeMap writableNativeMap);

    public native void putBoolean(String str, boolean z);

    public native void putDouble(String str, double d);

    public native void putInt(String str, int i);

    public native void putNull(String str);

    public native void putString(String str, String str2);

    static {
        ReactBridge.staticInit();
    }

    public void putMap(String str, ReadableMap readableMap) {
        Assertions.assertCondition(readableMap == null || (readableMap instanceof WritableNativeMap), "Illegal type provided");
        putNativeMap(str, (WritableNativeMap) readableMap);
    }

    public void putArray(String str, ReadableArray readableArray) {
        Assertions.assertCondition(readableArray == null || (readableArray instanceof WritableNativeArray), "Illegal type provided");
        putNativeArray(str, (WritableNativeArray) readableArray);
    }

    public void merge(ReadableMap readableMap) {
        Assertions.assertCondition(readableMap instanceof ReadableNativeMap, "Illegal type provided");
        mergeNativeMap((ReadableNativeMap) readableMap);
    }

    public WritableMap copy() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.merge(this);
        return writableNativeMap;
    }

    public WritableNativeMap() {
        super(initHybrid());
    }
}
