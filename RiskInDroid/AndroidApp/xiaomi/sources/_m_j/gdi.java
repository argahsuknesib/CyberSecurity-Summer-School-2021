package _m_j;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;

public final class gdi implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    ReadableMap f17560O000000o;
    int O00000Oo;
    Promise O00000o;
    int O00000o0;

    public gdi(ReadableMap readableMap, Promise promise) {
        this.f17560O000000o = readableMap;
        this.O00000o = promise;
    }

    public final void run() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("width", this.O00000Oo);
        writableNativeMap.putInt("height", this.O00000o0);
        writableNativeMap.putString("uri", this.f17560O000000o.getString("filename"));
        this.O00000o.resolve(writableNativeMap);
    }
}
