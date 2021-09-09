package _m_j;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.xiaomi.shopviews.adapter.bigvision.GravityImageVirtualView;
import java.util.Iterator;
import java.util.LinkedList;

public final class euu implements SensorEventListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public LinkedList<GravityImageVirtualView> f15836O000000o;
    private long O00000Oo;
    private double O00000o;
    private double O00000o0;
    private double O00000oO;

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float abs = Math.abs(sensorEvent.values[0]);
        float abs2 = Math.abs(sensorEvent.values[1]);
        float abs3 = Math.abs(sensorEvent.values[2]);
        long j = sensorEvent.timestamp;
        long j2 = this.O00000Oo;
        if (j - j2 >= 50) {
            if (j2 == 0) {
                this.O00000Oo = sensorEvent.timestamp;
            } else if (((double) (abs + abs2 + abs3)) < 0.2d) {
                return;
            }
            float f = ((float) (sensorEvent.timestamp - this.O00000Oo)) * 1.0E-9f;
            double d = this.O00000o0;
            double d2 = (double) (sensorEvent.values[1] * f);
            Double.isNaN(d2);
            this.O00000o0 = d + d2;
            double d3 = this.O00000o0;
            double d4 = this.O00000oO;
            if (d3 > d4) {
                this.O00000o0 = d4;
            } else if (d3 < (-d4)) {
                this.O00000o0 = -d4;
            }
            double d5 = this.O00000o;
            double d6 = (double) (sensorEvent.values[0] * f);
            Double.isNaN(d6);
            this.O00000o = d5 + d6;
            double d7 = this.O00000o;
            double d8 = this.O00000oO;
            if (d7 > d8) {
                this.O00000o = d8;
            } else if (d7 < (-d8)) {
                this.O00000o = -d8;
            }
            Iterator<GravityImageVirtualView> it = this.f15836O000000o.iterator();
            while (it.hasNext()) {
                GravityImageVirtualView next = it.next();
                if (next != null) {
                    double d9 = this.O00000o;
                    double d10 = this.O00000oO;
                    next.updateProgress((float) (d9 / d10), (float) (this.O00000o0 / d10));
                }
            }
            this.O00000Oo = sensorEvent.timestamp;
        }
    }
}
