package _m_j;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.barcodedetector.RNBarcodeDetector;
import org.reactnative.camera.CameraViewManager;

public final class jlw extends Event<jlw> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pools.O00000Oo<jlw> f1946O000000o = new Pools.O00000Oo<>(3);
    private RNBarcodeDetector O00000Oo;

    public final short getCoalescingKey() {
        return 0;
    }

    private jlw() {
    }

    public static jlw O000000o(int i, RNBarcodeDetector rNBarcodeDetector) {
        jlw acquire = f1946O000000o.acquire();
        if (acquire == null) {
            acquire = new jlw();
        }
        super.init(i);
        acquire.O00000Oo = rNBarcodeDetector;
        return acquire;
    }

    public final String getEventName() {
        return CameraViewManager.Events.EVENT_ON_BARCODE_DETECTION_ERROR.toString();
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        int viewTag = getViewTag();
        String eventName = getEventName();
        WritableMap createMap = Arguments.createMap();
        RNBarcodeDetector rNBarcodeDetector = this.O00000Oo;
        createMap.putBoolean("isOperational", rNBarcodeDetector != null && rNBarcodeDetector.O000000o());
        rCTEventEmitter.receiveEvent(viewTag, eventName, createMap);
    }
}
