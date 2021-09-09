package _m_j;

import android.util.Log;
import com.facebook.react.bridge.ReadableMap;

public final class dfg extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f14576O000000o;
    private final int O00000Oo;

    public dfg(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        this.f14576O000000o = readableMap.getString("message");
        this.O00000Oo = readableMap.getInt("value");
    }

    /* access modifiers changed from: protected */
    public final Object evaluate() {
        Object value = this.mNodesManager.O000000o(this.O00000Oo, dfk.class).value();
        Log.d("REANIMATED", String.format("%s %s", this.f14576O000000o, value));
        return value;
    }
}
