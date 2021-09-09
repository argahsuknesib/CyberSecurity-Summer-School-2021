package com.facebook.react.bridge;

public class PromiseImpl implements Promise {
    private Callback mReject;
    private Callback mResolve;

    public PromiseImpl(Callback callback, Callback callback2) {
        this.mResolve = callback;
        this.mReject = callback2;
    }

    public void resolve(Object obj) {
        Callback callback = this.mResolve;
        if (callback != null) {
            callback.invoke(obj);
            this.mResolve = null;
            this.mReject = null;
        }
    }

    public void reject(String str, String str2) {
        reject(str, str2, null, null);
    }

    public void reject(String str, Throwable th) {
        reject(str, null, th, null);
    }

    public void reject(String str, String str2, Throwable th) {
        reject(str, str2, th, null);
    }

    public void reject(Throwable th) {
        reject(null, null, th, null);
    }

    public void reject(Throwable th, WritableMap writableMap) {
        reject(null, null, th, writableMap);
    }

    public void reject(String str, WritableMap writableMap) {
        reject(str, null, null, writableMap);
    }

    public void reject(String str, Throwable th, WritableMap writableMap) {
        reject(str, null, th, writableMap);
    }

    public void reject(String str, String str2, WritableMap writableMap) {
        reject(str, str2, null, writableMap);
    }

    public void reject(String str, String str2, Throwable th, WritableMap writableMap) {
        if (this.mReject == null) {
            this.mResolve = null;
            return;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (str == null) {
            writableNativeMap.putString("code", "EUNSPECIFIED");
        } else {
            writableNativeMap.putString("code", str);
        }
        if (str2 != null) {
            writableNativeMap.putString("message", str2);
        } else if (th != null) {
            writableNativeMap.putString("message", th.getMessage());
        } else {
            writableNativeMap.putString("message", "Error not specified.");
        }
        if (writableMap != null) {
            writableNativeMap.putMap("userInfo", writableMap);
        } else {
            writableNativeMap.putNull("userInfo");
        }
        if (th != null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            int i = 0;
            while (i < stackTrace.length && i < 50) {
                StackTraceElement stackTraceElement = stackTrace[i];
                WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                writableNativeMap2.putString("class", stackTraceElement.getClassName());
                writableNativeMap2.putString("file", stackTraceElement.getFileName());
                writableNativeMap2.putInt("lineNumber", stackTraceElement.getLineNumber());
                writableNativeMap2.putString("methodName", stackTraceElement.getMethodName());
                writableNativeArray.pushMap(writableNativeMap2);
                i++;
            }
            writableNativeMap.putArray("nativeStackAndroid", writableNativeArray);
        } else {
            writableNativeMap.putArray("nativeStackAndroid", new WritableNativeArray());
        }
        this.mReject.invoke(writableNativeMap);
        this.mResolve = null;
        this.mReject = null;
    }

    @Deprecated
    public void reject(String str) {
        reject(null, str, null, null);
    }
}
