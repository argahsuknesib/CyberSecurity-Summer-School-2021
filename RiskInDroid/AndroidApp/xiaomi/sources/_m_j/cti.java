package _m_j;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.reactnative.camera.CameraViewManager;
import com.reactnative.camera.facedetector.RNFaceDetector;

public final class cti extends Event<cti> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pools.O00000Oo<cti> f14342O000000o = new Pools.O00000Oo<>(3);
    private RNFaceDetector O00000Oo;

    public final short getCoalescingKey() {
        return 0;
    }

    private cti() {
    }

    public static cti O000000o(int i) {
        cti acquire = f14342O000000o.acquire();
        if (acquire == null) {
            acquire = new cti();
        }
        acquire.init(i);
        return acquire;
    }

    public final String getEventName() {
        return CameraViewManager.Events.EVENT_ON_MOUNT_ERROR.toString();
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        int viewTag = getViewTag();
        String eventName = getEventName();
        WritableMap createMap = Arguments.createMap();
        RNFaceDetector rNFaceDetector = this.O00000Oo;
        createMap.putBoolean("isOperational", rNFaceDetector != null ? rNFaceDetector.O000000o() : false);
        rCTEventEmitter.receiveEvent(viewTag, eventName, createMap);
    }
}
