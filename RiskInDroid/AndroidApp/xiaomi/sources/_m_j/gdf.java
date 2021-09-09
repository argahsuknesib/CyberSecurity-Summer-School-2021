package _m_j;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableNativeMap;

public final class gdf implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    Promise f17558O000000o;
    gdc O00000Oo;

    public gdf(gdc gdc, Promise promise) {
        this.O00000Oo = gdc;
        this.f17558O000000o = promise;
    }

    public final void run() {
        this.O00000Oo.setVisibility(0);
        if (this.f17558O000000o != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putBoolean("cameraInitialized", true);
            this.f17558O000000o.resolve(writableNativeMap);
        }
    }
}
