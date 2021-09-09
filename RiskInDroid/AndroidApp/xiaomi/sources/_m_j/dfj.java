package _m_j;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

public final class dfj extends dfk {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int[] f14578O000000o;

    public dfj(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
        this.f14578O000000o = dex.O000000o(readableMap.getArray("input"));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object evaluate() {
        WritableArray createArray = Arguments.createArray();
        for (int O000000o2 : this.f14578O000000o) {
            dfk O000000o3 = this.mNodesManager.O000000o(O000000o2, dfk.class);
            if (O000000o3.value() == null) {
                createArray.pushNull();
            } else {
                Object value = O000000o3.value();
                if (value instanceof String) {
                    createArray.pushString((String) value);
                } else {
                    createArray.pushDouble(O000000o3.doubleValue().doubleValue());
                }
            }
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", this.mNodeID);
        createMap.putArray("args", createArray);
        this.mNodesManager.O000000o("onReanimatedCall", createMap);
        return ZERO;
    }
}
