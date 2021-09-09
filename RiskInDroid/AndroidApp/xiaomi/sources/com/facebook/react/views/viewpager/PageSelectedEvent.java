package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class PageSelectedEvent extends Event<PageSelectedEvent> {
    private final int mPosition;

    public String getEventName() {
        return "topPageSelected";
    }

    protected PageSelectedEvent(int i, int i2) {
        super(i);
        this.mPosition = i2;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("position", this.mPosition);
        return createMap;
    }
}
