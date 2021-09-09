package _m_j;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.Formatter;
import org.reactnative.camera.CameraViewManager;

public final class jlv extends Event<jlv> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pools.O00000Oo<jlv> f1945O000000o = new Pools.O00000Oo<>(3);
    private idf O00000Oo;
    private int O00000o;
    private int O00000o0;

    private jlv() {
    }

    public static jlv O000000o(int i, idf idf, int i2, int i3) {
        jlv acquire = f1945O000000o.acquire();
        if (acquire == null) {
            acquire = new jlv();
        }
        super.init(i);
        acquire.O00000Oo = idf;
        acquire.O00000o0 = i2;
        acquire.O00000o = i3;
        return acquire;
    }

    public final short getCoalescingKey() {
        return (short) (this.O00000Oo.f1208O000000o.hashCode() % 32767);
    }

    public final String getEventName() {
        return CameraViewManager.Events.EVENT_ON_BAR_CODE_READ.toString();
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        int viewTag = getViewTag();
        String eventName = getEventName();
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap.putInt("target", getViewTag());
        createMap.putString("data", this.O00000Oo.f1208O000000o);
        byte[] bArr = this.O00000Oo.O00000Oo;
        if (bArr != null && bArr.length > 0) {
            Formatter formatter = new Formatter();
            int length = bArr.length;
            for (int i = 0; i < length; i++) {
                formatter.format("%02x", Byte.valueOf(bArr[i]));
            }
            createMap.putString("rawData", formatter.toString());
            formatter.close();
        }
        createMap.putString("type", this.O00000Oo.O00000o.toString());
        WritableArray createArray = Arguments.createArray();
        for (idg idg : this.O00000Oo.O00000o0) {
            if (idg != null) {
                WritableMap createMap3 = Arguments.createMap();
                createMap3.putString("x", String.valueOf(idg.f1209O000000o));
                createMap3.putString("y", String.valueOf(idg.O00000Oo));
                createArray.pushMap(createMap3);
            }
        }
        createMap2.putArray("origin", createArray);
        createMap2.putInt("height", this.O00000o);
        createMap2.putInt("width", this.O00000o0);
        createMap.putMap("bounds", createMap2);
        rCTEventEmitter.receiveEvent(viewTag, eventName, createMap);
    }
}
