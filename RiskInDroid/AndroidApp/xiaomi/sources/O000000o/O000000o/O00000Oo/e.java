package O000000o.O000000o.O00000Oo;

import _m_j.O00Ooo00;
import android.content.Context;
import android.graphics.PointF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.hannto.print.widget.ScanCameraView;
import java.util.Calendar;

public class e implements SensorEventListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public static e f384O000000o;
    public SensorManager O00000Oo;
    public int O00000o;
    public Sensor O00000o0;
    public int O00000oO;
    public int O00000oo;
    public long O0000O0o = 0;
    public Calendar O0000OOo;
    public boolean O0000Oo = false;
    public boolean O0000Oo0 = false;
    public int O0000OoO = 0;
    public O000000o O0000Ooo;

    public interface O000000o {
    }

    public e(Context context) {
        this.O00000Oo = (SensorManager) context.getSystemService("sensor");
        this.O00000o0 = this.O00000Oo.getDefaultSensor(1);
    }

    public final void O000000o() {
        this.O0000OoO = 0;
        this.O0000Oo = false;
        this.O00000o = 0;
        this.O00000oO = 0;
        this.O00000oo = 0;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (sensor != null) {
            if (this.O0000Oo0) {
                O000000o();
            } else if (sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                int i = (int) fArr[0];
                int i2 = (int) fArr[1];
                int i3 = (int) fArr[2];
                this.O0000OOo = Calendar.getInstance();
                long timeInMillis = this.O0000OOo.getTimeInMillis();
                this.O0000OOo.get(13);
                if (this.O0000OoO != 0) {
                    int abs = Math.abs(this.O00000o - i);
                    int abs2 = Math.abs(this.O00000oO - i2);
                    int abs3 = Math.abs(this.O00000oo - i3);
                    if (Math.sqrt((double) ((abs3 * abs3) + (abs2 * abs2) + (abs * abs))) > 1.4d) {
                        this.O0000OoO = 2;
                        this.O00000o = i;
                        this.O00000oO = i2;
                        this.O00000oo = i3;
                    }
                    if (this.O0000OoO == 2) {
                        this.O0000O0o = timeInMillis;
                        this.O0000Oo = true;
                    }
                    if (this.O0000Oo && timeInMillis - this.O0000O0o > 500 && !this.O0000Oo0) {
                        this.O0000Oo = false;
                        O000000o o000000o = this.O0000Ooo;
                        if (o000000o != null) {
                            O00Ooo00 o00Ooo00 = (O00Ooo00) o000000o;
                            if (o00Ooo00.f6651O000000o.b != null) {
                                ScanCameraView a2 = o00Ooo00.f6651O000000o.b;
                                float width = (float) (o00Ooo00.f6651O000000o.b.getWidth() / 2);
                                float height = (float) (o00Ooo00.f6651O000000o.b.getHeight() / 2);
                                if (width < 0.0f || width > ((float) a2.getWidth())) {
                                    throw new IllegalArgumentException("x should be >= 0 and <= getWidth()");
                                } else if (height < 0.0f || height > ((float) a2.getHeight())) {
                                    throw new IllegalArgumentException("y should be >= 0 and <= getHeight()");
                                } else {
                                    a2.O0000Oo.O000000o(null, new PointF(width, height));
                                }
                            }
                        }
                    }
                } else {
                    this.O0000O0o = timeInMillis;
                }
                this.O0000OoO = 1;
                this.O00000o = i;
                this.O00000oO = i2;
                this.O00000oo = i3;
            }
        }
    }
}
