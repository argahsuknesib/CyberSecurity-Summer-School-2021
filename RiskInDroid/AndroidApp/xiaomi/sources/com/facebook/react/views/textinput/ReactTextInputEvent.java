package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactTextInputEvent extends Event<ReactTextInputEvent> {
    private String mPreviousText;
    private int mRangeEnd;
    private int mRangeStart;
    private String mText;

    public boolean canCoalesce() {
        return false;
    }

    public String getEventName() {
        return "topTextInput";
    }

    public ReactTextInputEvent(int i, String str, String str2, int i2, int i3) {
        super(i);
        this.mText = str;
        this.mPreviousText = str2;
        this.mRangeStart = i2;
        this.mRangeEnd = i3;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("start", (double) this.mRangeStart);
        createMap2.putDouble("end", (double) this.mRangeEnd);
        createMap.putString("text", this.mText);
        createMap.putString("previousText", this.mPreviousText);
        createMap.putMap("range", createMap2);
        createMap.putInt("target", getViewTag());
        return createMap;
    }
}
