package _m_j;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.zxing.Result;
import com.reactnative.camera.CameraViewManager;

public final class ctf extends Event<ctf> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pools.O00000Oo<ctf> f14339O000000o = new Pools.O00000Oo<>(3);
    private Result O00000Oo;

    private ctf() {
    }

    public static ctf O000000o(int i, Result result) {
        ctf acquire = f14339O000000o.acquire();
        if (acquire == null) {
            acquire = new ctf();
        }
        super.init(i);
        acquire.O00000Oo = result;
        return acquire;
    }

    public final short getCoalescingKey() {
        return (short) (this.O00000Oo.getText().hashCode() % 32767);
    }

    public final String getEventName() {
        return CameraViewManager.Events.EVENT_ON_BAR_CODE_READ.toString();
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        int viewTag = getViewTag();
        String eventName = getEventName();
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", getViewTag());
        createMap.putString("data", this.O00000Oo.getText());
        createMap.putString("type", this.O00000Oo.getBarcodeFormat().toString());
        rCTEventEmitter.receiveEvent(viewTag, eventName, createMap);
    }
}
