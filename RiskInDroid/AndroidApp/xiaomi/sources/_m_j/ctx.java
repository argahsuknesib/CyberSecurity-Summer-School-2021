package _m_j;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public final class ctx extends Event<ctx> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f14354O000000o;

    public final String getEventName() {
        return "topPageScrollStateChanged";
    }

    public ctx(int i, String str) {
        super(i);
        this.f14354O000000o = str;
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        int viewTag = getViewTag();
        String eventName = getEventName();
        WritableMap createMap = Arguments.createMap();
        createMap.putString("pageScrollState", this.f14354O000000o);
        rCTEventEmitter.receiveEvent(viewTag, eventName, createMap);
    }
}
