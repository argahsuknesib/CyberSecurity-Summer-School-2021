package _m_j;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public final class cty extends Event<cty> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f14355O000000o;

    public final String getEventName() {
        return "topPageSelected";
    }

    public cty(int i, int i2) {
        super(i);
        this.f14355O000000o = i2;
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        int viewTag = getViewTag();
        String eventName = getEventName();
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("position", this.f14355O000000o);
        rCTEventEmitter.receiveEvent(viewTag, eventName, createMap);
    }
}
