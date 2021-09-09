package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactTextChangedEvent extends Event<ReactTextChangedEvent> {
    private int mEventCount;
    private String mText;

    public String getEventName() {
        return "topChange";
    }

    public ReactTextChangedEvent(int i, String str, int i2) {
        super(i);
        this.mText = str;
        this.mEventCount = i2;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("text", this.mText);
        createMap.putInt("eventCount", this.mEventCount);
        createMap.putInt("target", getViewTag());
        return createMap;
    }
}
