package _m_j;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.reactnative.camera.CameraViewManager;

public final class cth extends Event<cth> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pools.O00000Oo<cth> f14341O000000o = new Pools.O00000Oo<>(3);

    public final short getCoalescingKey() {
        return 0;
    }

    private cth() {
    }

    public static cth O000000o(int i) {
        cth acquire = f14341O000000o.acquire();
        if (acquire == null) {
            acquire = new cth();
        }
        acquire.init(i);
        return acquire;
    }

    public final String getEventName() {
        return CameraViewManager.Events.EVENT_CAMERA_READY.toString();
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), Arguments.createMap());
    }
}
