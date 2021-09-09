package _m_j;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.concurrent.TimeUnit;

public final class fza implements SensorEventListener {
    private static final long O00000o = TimeUnit.NANOSECONDS.convert(20, TimeUnit.MILLISECONDS);
    private static final float O00000oO = ((float) TimeUnit.NANOSECONDS.convert(3, TimeUnit.SECONDS));

    /* renamed from: O000000o  reason: collision with root package name */
    public SensorManager f17428O000000o;
    public long O00000Oo;
    public long O00000o0;
    private float O00000oo;
    private float O0000O0o;
    private float O0000OOo;
    private int O0000Oo;
    private final O000000o O0000Oo0;
    private int O0000OoO = 1;

    public interface O000000o {
        void O000000o();
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public fza(O000000o o000000o) {
        this.O0000Oo0 = o000000o;
    }

    public final void O000000o() {
        SensorManager sensorManager = this.f17428O000000o;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.f17428O000000o = null;
        }
    }

    public final void O00000Oo() {
        this.O0000Oo = 0;
        this.O00000oo = 0.0f;
        this.O0000O0o = 0.0f;
        this.O0000OOo = 0.0f;
    }

    private static boolean O000000o(float f) {
        return Math.abs(f) > 13.042845f;
    }

    private void O000000o(long j) {
        this.O00000o0 = j;
        this.O0000Oo++;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.timestamp - this.O00000Oo >= O00000o) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2] - 9.80665f;
            this.O00000Oo = sensorEvent.timestamp;
            if (O000000o(f) && this.O00000oo * f <= 0.0f) {
                O000000o(sensorEvent.timestamp);
                this.O00000oo = f;
            } else if (O000000o(f2) && this.O0000O0o * f2 <= 0.0f) {
                O000000o(sensorEvent.timestamp);
                this.O0000O0o = f2;
            } else if (O000000o(f3) && this.O0000OOo * f3 <= 0.0f) {
                O000000o(sensorEvent.timestamp);
                this.O0000OOo = f3;
            }
            long j = sensorEvent.timestamp;
            if (this.O0000Oo >= this.O0000OoO * 8) {
                O00000Oo();
                this.O0000Oo0.O000000o();
            }
            if (((float) (j - this.O00000o0)) > O00000oO) {
                O00000Oo();
            }
        }
    }
}
