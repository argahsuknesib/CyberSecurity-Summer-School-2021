package _m_j;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

final class iny implements inv {
    private static final SensorEventListener O00000Oo = new SensorEventListener() {
        /* class _m_j.iny.AnonymousClass1 */

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f1510O000000o;

    iny(Context context) {
        this.f1510O000000o = context;
    }

    public final boolean O000000o() throws Throwable {
        SensorManager sensorManager = (SensorManager) this.f1510O000000o.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(21);
        if (defaultSensor == null) {
            return true;
        }
        sensorManager.registerListener(O00000Oo, defaultSensor, 3);
        sensorManager.unregisterListener(O00000Oo);
        return true;
    }
}
