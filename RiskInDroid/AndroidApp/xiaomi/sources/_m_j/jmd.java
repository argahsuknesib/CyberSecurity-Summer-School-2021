package _m_j;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;

public final class jmd extends Event<jmd> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pools.O00000Oo<jmd> f1954O000000o = new Pools.O00000Oo<>(3);

    public final short getCoalescingKey() {
        return 0;
    }

    private jmd() {
    }

    public static jmd O000000o(int i) {
        jmd acquire = f1954O000000o.acquire();
        if (acquire == null) {
            acquire = new jmd();
        }
        acquire.init(i);
        return acquire;
    }

    public final String getEventName() {
        return CameraViewManager.Events.EVENT_ON_PICTURE_TAKEN.toString();
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), Arguments.createMap());
    }
}
