package _m_j;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;

public final class bcw {

    /* renamed from: O000000o  reason: collision with root package name */
    public WritableMap f12874O000000o = Arguments.createMap();

    public final void O000000o(String str, String str2) {
        this.f12874O000000o.putString(str, str2);
    }

    public final void O000000o(String str, int i) {
        this.f12874O000000o.putInt(str, i);
    }

    public final void O000000o(String str, double d) {
        this.f12874O000000o.putDouble(str, d);
    }

    public final void O00000Oo(Callback callback) {
        callback.invoke(this.f12874O000000o);
    }

    public final void O000000o(Callback callback) {
        this.f12874O000000o = Arguments.createMap();
        this.f12874O000000o.putBoolean("didCancel", true);
        O00000Oo(callback);
    }

    public final void O000000o(Callback callback, String str) {
        this.f12874O000000o = Arguments.createMap();
        this.f12874O000000o.putString("error", str);
        O00000Oo(callback);
    }
}
