package _m_j;

import androidx.core.util.Pools;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

public final class jmc extends Event<jmc> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pools.O00000Oo<jmc> f1953O000000o = new Pools.O00000Oo<>(5);
    private WritableMap O00000Oo;

    private jmc() {
    }

    public static jmc O000000o(int i, WritableMap writableMap) {
        jmc acquire = f1953O000000o.acquire();
        if (acquire == null) {
            acquire = new jmc();
        }
        super.init(i);
        acquire.O00000Oo = writableMap;
        return acquire;
    }

    public final short getCoalescingKey() {
        return (short) (this.O00000Oo.getMap("data").getString("uri").hashCode() % 32767);
    }

    public final String getEventName() {
        return CameraViewManager.Events.EVENT_ON_PICTURE_SAVED.toString();
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), this.O00000Oo);
    }
}
