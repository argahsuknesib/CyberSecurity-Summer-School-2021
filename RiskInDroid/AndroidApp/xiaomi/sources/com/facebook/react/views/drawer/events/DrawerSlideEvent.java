package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class DrawerSlideEvent extends Event<DrawerSlideEvent> {
    private final float mOffset;

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return "topDrawerSlide";
    }

    public DrawerSlideEvent(int i, float f) {
        super(i);
        this.mOffset = f;
    }

    public float getOffset() {
        return this.mOffset;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("offset", (double) getOffset());
        return createMap;
    }
}
