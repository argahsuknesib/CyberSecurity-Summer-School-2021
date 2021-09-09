package _m_j;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

public final class jmb extends Event<jmb> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pools.O00000Oo<jmb> f1952O000000o = new Pools.O00000Oo<>(3);
    private WritableArray O00000Oo;

    private jmb() {
    }

    public static jmb O000000o(int i, WritableArray writableArray) {
        jmb acquire = f1952O000000o.acquire();
        if (acquire == null) {
            acquire = new jmb();
        }
        super.init(i);
        acquire.O00000Oo = writableArray;
        return acquire;
    }

    public final short getCoalescingKey() {
        if (this.O00000Oo.size() > 32767) {
            return Short.MAX_VALUE;
        }
        return (short) this.O00000Oo.size();
    }

    public final String getEventName() {
        return CameraViewManager.Events.EVENT_ON_FACES_DETECTED.toString();
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        int viewTag = getViewTag();
        String eventName = getEventName();
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "face");
        createMap.putArray("faces", this.O00000Oo);
        createMap.putInt("target", getViewTag());
        rCTEventEmitter.receiveEvent(viewTag, eventName, createMap);
    }
}
