package _m_j;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

public final class jly extends Event<jly> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pools.O00000Oo<jly> f1948O000000o = new Pools.O00000Oo<>(3);
    private String O00000Oo;

    public final short getCoalescingKey() {
        return 0;
    }

    private jly() {
    }

    public static jly O000000o(int i, String str) {
        jly acquire = f1948O000000o.acquire();
        if (acquire == null) {
            acquire = new jly();
        }
        super.init(i);
        acquire.O00000Oo = str;
        return acquire;
    }

    public final String getEventName() {
        return CameraViewManager.Events.EVENT_ON_MOUNT_ERROR.toString();
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        int viewTag = getViewTag();
        String eventName = getEventName();
        WritableMap createMap = Arguments.createMap();
        createMap.putString("message", this.O00000Oo);
        rCTEventEmitter.receiveEvent(viewTag, eventName, createMap);
    }
}
