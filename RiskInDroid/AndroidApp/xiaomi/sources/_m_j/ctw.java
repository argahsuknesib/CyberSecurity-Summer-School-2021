package _m_j;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public final class ctw extends Event<ctw> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f14353O000000o;
    private final float O00000Oo;

    public final String getEventName() {
        return "topPageScroll";
    }

    public ctw(int i, int i2, float f) {
        super(i);
        this.f14353O000000o = i2;
        this.O00000Oo = (Float.isInfinite(f) || Float.isNaN(f)) ? 0.0f : f;
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        int viewTag = getViewTag();
        String eventName = getEventName();
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("position", this.f14353O000000o);
        createMap.putDouble("offset", (double) this.O00000Oo);
        rCTEventEmitter.receiveEvent(viewTag, eventName, createMap);
    }
}
