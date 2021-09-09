package com.facebook.react.views.switchview;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class ReactSwitchEvent extends Event<ReactSwitchEvent> {
    private final boolean mIsChecked;

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return "topChange";
    }

    public ReactSwitchEvent(int i, boolean z) {
        super(i);
        this.mIsChecked = z;
    }

    public boolean getIsChecked() {
        return this.mIsChecked;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", getViewTag());
        createMap.putBoolean("value", getIsChecked());
        return createMap;
    }
}
