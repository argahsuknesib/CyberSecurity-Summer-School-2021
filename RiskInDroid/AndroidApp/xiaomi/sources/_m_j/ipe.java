package _m_j;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

final class ipe implements ipb {
    private static final SensorEventListener O00000Oo = new SensorEventListener() {
        /* class _m_j.ipe.AnonymousClass1 */

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f1535O000000o;

    ipe(Context context) {
        this.f1535O000000o = context;
    }

    public final boolean O000000o() throws Throwable {
        SensorManager sensorManager = (SensorManager) this.f1535O000000o.getSystemService("sensor");
        try {
            Sensor defaultSensor = sensorManager.getDefaultSensor(21);
            sensorManager.registerListener(O00000Oo, defaultSensor, 3);
            sensorManager.unregisterListener(O00000Oo, defaultSensor);
            return true;
        } catch (Throwable unused) {
            if (!this.f1535O000000o.getPackageManager().hasSystemFeature("android.hardware.sensor.heartrate")) {
                return true;
            }
            return false;
        }
    }
}
