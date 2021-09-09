package _m_j;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.xiaomi.qrcode2.camera.CameraManager;

public final class eti implements SensorEventListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f15795O000000o;
    public CameraManager O00000Oo;
    public Sensor O00000o0;

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public eti(Context context) {
        this.f15795O000000o = context;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        CameraManager cameraManager = this.O00000Oo;
        if (cameraManager == null) {
            return;
        }
        if (f <= 45.0f) {
            cameraManager.O000000o(true);
        } else if (f >= 450.0f) {
            cameraManager.O000000o(false);
        }
    }
}
