package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class DrawerStateChangedEvent extends Event<DrawerStateChangedEvent> {
    private final int mDrawerState;

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return "topDrawerStateChanged";
    }

    public DrawerStateChangedEvent(int i, int i2) {
        super(i);
        this.mDrawerState = i2;
    }

    public int getDrawerState() {
        return this.mDrawerState;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("drawerState", (double) getDrawerState());
        return createMap;
    }
}
