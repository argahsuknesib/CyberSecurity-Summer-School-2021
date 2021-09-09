package _m_j;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public final class deo extends Event<deo> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pools.O00000Oo<deo> f14554O000000o = new Pools.O00000Oo<>(7);
    private WritableMap O00000Oo;

    public final boolean canCoalesce() {
        return false;
    }

    public final short getCoalescingKey() {
        return 0;
    }

    public final String getEventName() {
        return "onGestureHandlerEvent";
    }

    public static deo O000000o(dec dec, dep dep) {
        deo acquire = f14554O000000o.acquire();
        if (acquire == null) {
            acquire = new deo();
        }
        super.init(dec.O00000oo.getId());
        acquire.O00000Oo = Arguments.createMap();
        if (dep != null) {
            dep.O000000o(dec, acquire.O00000Oo);
        }
        acquire.O00000Oo.putInt("handlerTag", dec.O00000oO);
        acquire.O00000Oo.putInt("state", dec.O0000O0o);
        return acquire;
    }

    private deo() {
    }

    public final void onDispose() {
        this.O00000Oo = null;
        f14554O000000o.release(this);
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), "onGestureHandlerEvent", this.O00000Oo);
    }
}
