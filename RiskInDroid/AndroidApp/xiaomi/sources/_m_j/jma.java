package _m_j;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import org.reactnative.camera.CameraViewManager;
import org.reactnative.facedetector.RNFaceDetector;

public final class jma extends Event<jma> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pools.O00000Oo<jma> f1951O000000o = new Pools.O00000Oo<>(3);
    private RNFaceDetector O00000Oo;

    public final short getCoalescingKey() {
        return 0;
    }

    private jma() {
    }

    public static jma O000000o(int i, RNFaceDetector rNFaceDetector) {
        jma acquire = f1951O000000o.acquire();
        if (acquire == null) {
            acquire = new jma();
        }
        super.init(i);
        acquire.O00000Oo = rNFaceDetector;
        return acquire;
    }

    public final String getEventName() {
        return CameraViewManager.Events.EVENT_ON_FACE_DETECTION_ERROR.toString();
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        int viewTag = getViewTag();
        String eventName = getEventName();
        WritableMap createMap = Arguments.createMap();
        RNFaceDetector rNFaceDetector = this.O00000Oo;
        createMap.putBoolean("isOperational", rNFaceDetector != null && rNFaceDetector.O000000o());
        rCTEventEmitter.receiveEvent(viewTag, eventName, createMap);
    }
}
