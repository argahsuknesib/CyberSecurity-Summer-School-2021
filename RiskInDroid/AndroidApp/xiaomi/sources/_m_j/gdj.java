package _m_j;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import org.opencv.core.Mat;

public final class gdj implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    Mat f17561O000000o;
    ReadableMap O00000Oo;
    Promise O00000o0;

    public gdj(ReadableMap readableMap, Promise promise) {
        this.O00000Oo = readableMap;
        this.O00000o0 = promise;
    }

    public final void run() {
        gde.O000000o();
        gde.O000000o(this.f17561O000000o, this.O00000Oo.getString("filename"), this.O00000o0);
    }
}
