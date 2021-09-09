package com.facebook.react.views.image;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ImageLoadEvent extends Event<ImageLoadEvent> {
    private final int mEventType;
    private final int mHeight;
    private final String mImageError;
    private final String mImageUri;
    private final int mWidth;

    public ImageLoadEvent(int i, int i2) {
        this(i, i2, null);
    }

    public ImageLoadEvent(int i, int i2, boolean z, String str) {
        this(i, i2, null, 0, 0, str);
    }

    public ImageLoadEvent(int i, int i2, String str) {
        this(i, i2, str, 0, 0, null);
    }

    public ImageLoadEvent(int i, int i2, String str, int i3, int i4) {
        this(i, i2, str, i3, i4, null);
    }

    public ImageLoadEvent(int i, int i2, String str, int i3, int i4, String str2) {
        super(i);
        this.mEventType = i2;
        this.mImageUri = str;
        this.mWidth = i3;
        this.mHeight = i4;
        this.mImageError = str2;
    }

    public static String eventNameForType(int i) {
        if (i == 1) {
            return "topError";
        }
        if (i == 2) {
            return "topLoad";
        }
        if (i == 3) {
            return "topLoadEnd";
        }
        if (i == 4) {
            return "topLoadStart";
        }
        if (i == 5) {
            return "topProgress";
        }
        throw new IllegalStateException("Invalid image event: " + Integer.toString(i));
    }

    public String getEventName() {
        return eventNameForType(this.mEventType);
    }

    public short getCoalescingKey() {
        return (short) this.mEventType;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap writableMap;
        int i;
        if (this.mImageUri != null || (i = this.mEventType) == 2 || i == 1) {
            writableMap = Arguments.createMap();
            String str = this.mImageUri;
            if (str != null) {
                writableMap.putString("uri", str);
            }
            int i2 = this.mEventType;
            if (i2 == 2) {
                WritableMap createMap = Arguments.createMap();
                createMap.putDouble("width", (double) this.mWidth);
                createMap.putDouble("height", (double) this.mHeight);
                String str2 = this.mImageUri;
                if (str2 != null) {
                    createMap.putString("url", str2);
                }
                writableMap.putMap("source", createMap);
            } else if (i2 == 1) {
                writableMap.putString("error", this.mImageError);
            }
        } else {
            writableMap = null;
        }
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), writableMap);
    }
}
