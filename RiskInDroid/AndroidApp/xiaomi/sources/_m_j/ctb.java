package _m_j;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.facebook.react.bridge.ReactApplicationContext;

public final class ctb {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f14334O000000o = 0;
    public SensorEventListener O00000Oo = new O000000o(this, (byte) 0);
    public ctc O00000o = null;
    public SensorManager O00000o0;

    public ctb(ReactApplicationContext reactApplicationContext) {
        this.O00000o0 = (SensorManager) reactApplicationContext.getSystemService("sensor");
    }

    class O000000o implements SensorEventListener {
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(ctb ctb, byte b) {
            this();
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            if (f < 5.0f && f > -5.0f && f2 > 5.0f) {
                ctb.this.f14334O000000o = 0;
            } else if (f < -5.0f && f2 < 5.0f && f2 > -5.0f) {
                ctb.this.f14334O000000o = 3;
            } else if (f < 5.0f && f > -5.0f && f2 < -5.0f) {
                ctb.this.f14334O000000o = 2;
            } else if (f > 5.0f && f2 < 5.0f && f2 > -5.0f) {
                ctb.this.f14334O000000o = 1;
            }
            if (ctb.this.O00000o != null) {
                ctb.this.O00000o.O000000o();
            }
        }
    }
}
