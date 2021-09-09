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

public final class fyy extends fyw {

    /* renamed from: O000000o  reason: collision with root package name */
    SensorManager f17426O000000o;
    Sensor O00000Oo;
    SensorEventListener O00000o;
    Sensor O00000o0;

    public final void O000000o(Context context, String str) {
        if (context != null) {
            this.f17426O000000o = (SensorManager) context.getSystemService("sensor");
            this.O00000Oo = this.f17426O000000o.getDefaultSensor(1);
            this.O00000o0 = this.f17426O000000o.getDefaultSensor(2);
            this.O00000o = new O000000o();
            int O000000o2 = O000000o(str);
            this.f17426O000000o.registerListener(this.O00000o, this.O00000Oo, O000000o2);
            this.f17426O000000o.registerListener(this.O00000o, this.O00000o0, O000000o2);
        }
    }

    public final void O000000o() {
        SensorManager sensorManager = this.f17426O000000o;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.O00000o, this.O00000Oo);
            this.f17426O000000o.unregisterListener(this.O00000o, this.O00000o0);
            this.O00000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.f17426O000000o = null;
        }
    }

    class O000000o implements SensorEventListener {

        /* renamed from: O000000o  reason: collision with root package name */
        float[] f17427O000000o = new float[3];
        float[] O00000Oo = new float[3];

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        O000000o() {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            ReactContext currentReactContext;
            if (sensorEvent.sensor.getType() == 1) {
                this.f17427O000000o = (float[]) sensorEvent.values.clone();
            } else if (sensorEvent.sensor.getType() == 2) {
                this.O00000Oo = (float[]) sensorEvent.values.clone();
            }
            float[] fArr = new float[9];
            float[] fArr2 = new float[3];
            SensorManager.getRotationMatrix(fArr, null, this.f17427O000000o, this.O00000Oo);
            SensorManager.getOrientation(fArr, fArr2);
            double degrees = Math.toDegrees((double) fArr2[0]);
            gbu.O00000o0("sendCompassChangeEvent,degree:".concat(String.valueOf(degrees)));
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("direction", degrees);
            createMap.putString("eventName", "onCompassChange_36621");
            ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
            if (reactInstanceManager != null && (currentReactContext = reactInstanceManager.getCurrentReactContext()) != null) {
                gbu.O00000o0("sendCompassChangeEvent,emit");
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onCompassChange_36621", createMap);
            }
        }
    }
}
