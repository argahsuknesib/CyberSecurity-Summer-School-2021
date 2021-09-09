package _m_j;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

public final class jme extends Event<jme> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pools.O00000Oo<jme> f1955O000000o = new Pools.O00000Oo<>(3);
    private WritableArray O00000Oo;

    private jme() {
    }

    public static jme O000000o(int i, WritableArray writableArray) {
        jme acquire = f1955O000000o.acquire();
        if (acquire == null) {
            acquire = new jme();
        }
        super.init(i);
        acquire.O00000Oo = writableArray;
        return acquire;
    }

    public final String getEventName() {
        return CameraViewManager.Events.EVENT_ON_TEXT_RECOGNIZED.toString();
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        int viewTag = getViewTag();
        String eventName = getEventName();
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "textBlock");
        createMap.putArray("textBlocks", this.O00000Oo);
        createMap.putInt("target", getViewTag());
        rCTEventEmitter.receiveEvent(viewTag, eventName, createMap);
    }
}
