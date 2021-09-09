package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;

public class TouchesHelper {
    private static WritableArray createsPointersArray(int i, TouchEvent touchEvent) {
        WritableArray createArray = Arguments.createArray();
        MotionEvent motionEvent = touchEvent.getMotionEvent();
        float x = motionEvent.getX() - touchEvent.getViewX();
        float y = motionEvent.getY() - touchEvent.getViewY();
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("pageX", (double) PixelUtil.toDIPFromPixel(motionEvent.getX(i2)));
            createMap.putDouble("pageY", (double) PixelUtil.toDIPFromPixel(motionEvent.getY(i2)));
            createMap.putDouble("locationX", (double) PixelUtil.toDIPFromPixel(motionEvent.getX(i2) - x));
            createMap.putDouble("locationY", (double) PixelUtil.toDIPFromPixel(motionEvent.getY(i2) - y));
            createMap.putInt("target", i);
            createMap.putDouble("timestamp", (double) touchEvent.getTimestampMs());
            createMap.putDouble("identifier", (double) motionEvent.getPointerId(i2));
            createArray.pushMap(createMap);
        }
        return createArray;
    }

    public static void sendTouchEvent(RCTEventEmitter rCTEventEmitter, TouchEventType touchEventType, int i, TouchEvent touchEvent) {
        WritableArray createsPointersArray = createsPointersArray(i, touchEvent);
        MotionEvent motionEvent = touchEvent.getMotionEvent();
        WritableArray createArray = Arguments.createArray();
        if (touchEventType == TouchEventType.MOVE || touchEventType == TouchEventType.CANCEL) {
            for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                createArray.pushInt(i2);
            }
        } else if (touchEventType == TouchEventType.START || touchEventType == TouchEventType.END) {
            createArray.pushInt(motionEvent.getActionIndex());
        } else {
            throw new RuntimeException("Unknown touch type: ".concat(String.valueOf(touchEventType)));
        }
        rCTEventEmitter.receiveTouches(TouchEventType.getJSEventName(touchEventType), createsPointersArray, createArray);
    }
}
