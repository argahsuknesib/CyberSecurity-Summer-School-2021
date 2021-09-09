package _m_j;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public abstract class fyx extends fyw {

    /* renamed from: O000000o  reason: collision with root package name */
    SensorManager f17424O000000o;
    Sensor O00000Oo;
    SensorEventListener O00000o0;

    public abstract int O000000o();

    public abstract String O00000Oo();

    public final void O000000o(Context context, String str) {
        if (context != null) {
            this.f17424O000000o = (SensorManager) context.getSystemService("sensor");
            this.O00000Oo = this.f17424O000000o.getDefaultSensor(O000000o());
            this.O00000o0 = new O000000o();
            this.f17424O000000o.registerListener(this.O00000o0, this.O00000Oo, O000000o(str));
        }
    }

    public final void O00000o0() {
        SensorManager sensorManager = this.f17424O000000o;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.O00000o0, this.O00000Oo);
            this.O00000o0 = null;
            this.O00000Oo = null;
            this.f17424O000000o = null;
        }
    }

    class O000000o implements SensorEventListener {
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        O000000o() {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            ReactContext currentReactContext;
            float[] fArr = sensorEvent.values;
            if (fyx.this.O000000o() == sensorEvent.sensor.getType()) {
                fyx fyx = fyx.this;
                gbu.O00000o0("sendChangeEvent,values[0]" + fArr[0] + ",values[1]:" + fArr[1] + ",values[2]:" + fArr[2]);
                WritableMap createMap = Arguments.createMap();
                createMap.putDouble("x", (double) fArr[0]);
                createMap.putDouble("y", (double) fArr[1]);
                createMap.putDouble("z", (double) fArr[2]);
                createMap.putString("eventName", fyx.O00000Oo());
                ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
                if (reactInstanceManager != null && (currentReactContext = reactInstanceManager.getCurrentReactContext()) != null) {
                    gbu.O00000o0("sendChangeEvent,emit");
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(fyx.O00000Oo(), createMap);
                }
            }
        }
    }
}
