package _m_j;

import android.util.SparseArray;
import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.gms.vision.face.Face;
import com.reactnative.camera.CameraViewManager;

public final class ctj extends Event<ctj> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pools.O00000Oo<ctj> f14343O000000o = new Pools.O00000Oo<>(3);
    private double O00000Oo;
    private SparseArray<Face> O00000o;
    private double O00000o0;
    private cts O00000oO;

    private ctj() {
    }

    public static ctj O000000o(int i, SparseArray<Face> sparseArray, cts cts, double d, double d2) {
        ctj acquire = f14343O000000o.acquire();
        if (acquire == null) {
            acquire = new ctj();
        }
        super.init(i);
        acquire.O00000o = sparseArray;
        acquire.O00000oO = cts;
        acquire.O00000Oo = d;
        acquire.O00000o0 = d2;
        return acquire;
    }

    public final short getCoalescingKey() {
        if (this.O00000o.size() > 32767) {
            return Short.MAX_VALUE;
        }
        return (short) this.O00000o.size();
    }

    public final String getEventName() {
        return CameraViewManager.Events.EVENT_ON_FACES_DETECTED.toString();
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap writableMap;
        int viewTag = getViewTag();
        String eventName = getEventName();
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < this.O00000o.size(); i++) {
            WritableMap O000000o2 = ctk.O000000o(this.O00000o.valueAt(i), this.O00000Oo, this.O00000o0);
            if (this.O00000oO.f14350O000000o == 1) {
                writableMap = ctk.O000000o(O000000o2, this.O00000oO.O000000o(), this.O00000Oo);
            } else {
                writableMap = ctk.O000000o(O000000o2);
            }
            createArray.pushMap(writableMap);
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "face");
        createMap.putArray("faces", createArray);
        createMap.putInt("target", getViewTag());
        rCTEventEmitter.receiveEvent(viewTag, eventName, createMap);
    }
}
