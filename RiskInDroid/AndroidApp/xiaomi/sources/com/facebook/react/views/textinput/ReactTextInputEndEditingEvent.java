package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class ReactTextInputEndEditingEvent extends Event<ReactTextInputEndEditingEvent> {
    private String mText;

    public boolean canCoalesce() {
        return false;
    }

    public String getEventName() {
        return "topEndEditing";
    }

    public ReactTextInputEndEditingEvent(int i, String str) {
        super(i);
        this.mText = str;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", getViewTag());
        createMap.putString("text", this.mText);
        return createMap;
    }
}
