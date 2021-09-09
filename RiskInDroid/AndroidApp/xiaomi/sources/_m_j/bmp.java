package _m_j;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bmp {

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, O00000o> f13105O000000o;
    SensorManager O00000Oo;

    public interface O00000o {
        Map<Long, Object> O000000o(String str);

        void O000000o(int i, int i2);

        void O00000Oo(String str);

        void O00000o();

        void O00000o0();

        String O00000oo();
    }

    public static class O0000OOo {
        /* access modifiers changed from: private */

        /* renamed from: O000000o  reason: collision with root package name */
        public static final bmp f13111O000000o = new bmp((byte) 0);
    }

    private bmp() {
        this.O00000Oo = null;
        this.f13105O000000o = new HashMap();
        this.f13105O000000o.put("gyro", new O00000o0(this, (byte) 0));
        this.f13105O000000o.put("light", new O0000O0o(this, (byte) 0));
        this.f13105O000000o.put("gravity", new O00000Oo(this, (byte) 0));
        Context context = blw.f13081O000000o;
        if (context != null) {
            this.O00000Oo = (SensorManager) context.getSystemService("sensor");
        }
    }

    /* synthetic */ bmp(byte b) {
        this();
    }

    public final List<String> O000000o() {
        ArrayList arrayList = new ArrayList();
        try {
            for (Sensor next : this.O00000Oo.getSensorList(-1)) {
                arrayList.add(next.getType() + "," + next.getVendor());
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    abstract class O000000o implements O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f13106O000000o;
        int O00000Oo;
        Map<String, Map<Long, Object>> O00000o0;
        private String O00000oO;
        private int O00000oo;
        private volatile float[] O0000O0o;

        private O000000o() {
            this.O00000oO = "Sensor_" + O00000oo();
            this.f13106O000000o = 1;
            this.O00000Oo = 3;
            this.O00000oo = 0;
            this.O00000o0 = new ConcurrentHashMap();
            this.O0000O0o = null;
        }

        /* synthetic */ O000000o(bmp bmp, byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public abstract SensorEventListener O000000o();

        public final Map<Long, Object> O000000o(String str) {
            Map map = this.O00000o0.get(str);
            if (map == null) {
                return null;
            }
            HashMap hashMap = new HashMap(map);
            map.clear();
            return hashMap;
        }

        public final void O000000o(int i, int i2) {
            this.f13106O000000o = i;
            this.O00000Oo = i2;
        }

        /* access modifiers changed from: protected */
        public final void O000000o(SensorEvent sensorEvent) {
            if (sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length != 0) {
                this.O0000O0o = Arrays.copyOf(sensorEvent.values, sensorEvent.values.length);
            }
        }

        /* access modifiers changed from: protected */
        public abstract List<Sensor> O00000Oo();

        public final void O00000Oo(final String str) {
            bmf.O00000Oo().O000000o(new Runnable() {
                /* class _m_j.bmp.O000000o.AnonymousClass1 */

                public final void run() {
                    Object O00000oO = O000000o.this.O00000oO();
                    Map map = O000000o.this.O00000o0.get(str);
                    if (map == null) {
                        map = new ConcurrentHashMap();
                        O000000o.this.O00000o0.put(str, map);
                    }
                    map.put(Long.valueOf(System.currentTimeMillis()), O00000oO);
                    if (map.size() < O000000o.this.f13106O000000o) {
                        bmf.O00000Oo().O000000o(this, 5, (long) O000000o.this.O00000Oo, false);
                    }
                }
            }, 5, (long) this.O00000Oo, false);
        }

        /* access modifiers changed from: protected */
        public Object O00000oO() {
            return this.O0000O0o == null ? new float[]{-1.0f, -1.0f, -1.0f} : Arrays.copyOf(this.O0000O0o, this.O0000O0o.length);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            _m_j.bmz.O00000o(r6.O00000oO, "register failed", new java.lang.Object[0]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0080, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0076 */
        public final synchronized void O00000o0() {
            if (bmp.this.O00000Oo != null) {
                if (this.O00000oo == 0) {
                    bmz.O000000o(this.O00000oO, "register listener", new Object[0]);
                    List<Sensor> O00000Oo2 = O00000Oo();
                    if (O00000Oo2 != null) {
                        if (O00000Oo2.size() != 0) {
                            int i = 3;
                            if (this.O00000Oo * 1000 < 200000) {
                                i = this.O00000Oo * 1000;
                            }
                            for (Sensor registerListener : O00000Oo2) {
                                if (!bmp.this.O00000Oo.registerListener(O000000o(), registerListener, i)) {
                                    bmz.O00000o(this.O00000oO, "sensor registerListener SENSOR_DELAY_NORMAL failed.", new Object[0]);
                                    return;
                                }
                            }
                        }
                    }
                }
                this.O00000oo++;
                bmz.O000000o(this.O00000oO, "registerSuccessedCount+1 = %d", Integer.valueOf(this.O00000oo));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            _m_j.bmz.O00000o(r5.O00000oO, "unregister failed", new java.lang.Object[0]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003b */
        public final synchronized void O00000o() {
            if (bmp.this.O00000Oo != null) {
                this.O00000oo--;
                bmz.O000000o(this.O00000oO, "registerSuccessedCount-1 = %d", Integer.valueOf(this.O00000oo));
                if (this.O00000oo == 0) {
                    bmp.this.O00000Oo.unregisterListener(O000000o());
                    bmz.O000000o(this.O00000oO, "unregisterListener", new Object[0]);
                }
            }
        }
    }

    class O00000Oo extends O000000o {
        private SensorEventListener O00000oo;

        private O00000Oo() {
            super(bmp.this, (byte) 0);
            this.O00000oo = new SensorEventListener() {
                /* class _m_j.bmp.O00000Oo.AnonymousClass1 */

                public final void onAccuracyChanged(Sensor sensor, int i) {
                }

                public final void onSensorChanged(SensorEvent sensorEvent) {
                    try {
                        if (sensorEvent.values == null) {
                            return;
                        }
                        if (sensorEvent.values.length != 0) {
                            if (sensorEvent.sensor.getType() == 9) {
                                O00000Oo.this.O000000o(sensorEvent);
                            }
                        }
                    } catch (Exception unused) {
                        bmz.O00000o("Sensor_gravity", "onSensorChanged failed", new Object[0]);
                    }
                }
            };
        }

        /* synthetic */ O00000Oo(bmp bmp, byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final SensorEventListener O000000o() {
            return this.O00000oo;
        }

        public final String O00000oo() {
            return "gravity";
        }

        /* access modifiers changed from: protected */
        public final List<Sensor> O00000Oo() {
            return bmp.this.O00000Oo == null ? Collections.emptyList() : Collections.singletonList(bmp.this.O00000Oo.getDefaultSensor(9));
        }
    }

    class O00000o0 extends O000000o {
        volatile float[] O00000oO;
        volatile float[] O00000oo;
        private SensorEventListener O0000OOo;

        private O00000o0() {
            super(bmp.this, (byte) 0);
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000OOo = new SensorEventListener() {
                /* class _m_j.bmp.O00000o0.AnonymousClass1 */

                public final void onAccuracyChanged(Sensor sensor, int i) {
                }

                public final void onSensorChanged(SensorEvent sensorEvent) {
                    try {
                        if (sensorEvent.values == null) {
                            return;
                        }
                        if (sensorEvent.values.length != 0) {
                            if (sensorEvent.sensor.getType() == 2) {
                                O00000o0.this.O00000oo = Arrays.copyOf(sensorEvent.values, sensorEvent.values.length);
                            }
                            if (sensorEvent.sensor.getType() == 1) {
                                O00000o0.this.O00000oO = Arrays.copyOf(sensorEvent.values, sensorEvent.values.length);
                            }
                        }
                    } catch (Exception unused) {
                        bmz.O00000o("Sensor_gyro", "gyro onSensorChanged failed", new Object[0]);
                    }
                }
            };
        }

        /* synthetic */ O00000o0(bmp bmp, byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final SensorEventListener O000000o() {
            return this.O0000OOo;
        }

        public final String O00000oo() {
            return "gyro";
        }

        /* access modifiers changed from: protected */
        public final List<Sensor> O00000Oo() {
            if (bmp.this.O00000Oo == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(bmp.this.O00000Oo.getDefaultSensor(1), bmp.this.O00000Oo.getDefaultSensor(2));
        }

        /* access modifiers changed from: protected */
        public final Object O00000oO() {
            if (this.O00000oO == null || this.O00000oo == null) {
                return new float[]{-1.0f, -1.0f, -1.0f};
            }
            float[] fArr = new float[3];
            float[] fArr2 = new float[9];
            float[] copyOf = Arrays.copyOf(this.O00000oO, this.O00000oO.length);
            float[] copyOf2 = Arrays.copyOf(this.O00000oo, this.O00000oo.length);
            this.O00000oO = null;
            this.O00000oo = null;
            SensorManager.getRotationMatrix(fArr2, null, copyOf, copyOf2);
            SensorManager.getOrientation(fArr2, fArr);
            float degrees = (float) Math.toDegrees((double) fArr[0]);
            float degrees2 = (float) Math.toDegrees((double) fArr[1]);
            float degrees3 = (float) Math.toDegrees((double) fArr[2]);
            bmz.O000000o("Sensor_gyro", "%f %f %f", Float.valueOf(degrees), Float.valueOf(degrees2), Float.valueOf(degrees3));
            return new float[]{degrees, degrees2, degrees3};
        }
    }

    class O0000O0o extends O000000o {
        private SensorEventListener O00000oo;

        private O0000O0o() {
            super(bmp.this, (byte) 0);
            this.O00000oo = new SensorEventListener() {
                /* class _m_j.bmp.O0000O0o.AnonymousClass1 */

                public final void onAccuracyChanged(Sensor sensor, int i) {
                }

                public final void onSensorChanged(SensorEvent sensorEvent) {
                    try {
                        if (sensorEvent.values == null) {
                            return;
                        }
                        if (sensorEvent.values.length != 0) {
                            if (sensorEvent.sensor.getType() == 5) {
                                O0000O0o.this.O000000o(sensorEvent);
                            }
                        }
                    } catch (Exception unused) {
                        bmz.O00000o("Sensor_light", "onSensorChanged failed", new Object[0]);
                    }
                }
            };
        }

        /* synthetic */ O0000O0o(bmp bmp, byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final SensorEventListener O000000o() {
            return this.O00000oo;
        }

        public final String O00000oo() {
            return "light";
        }

        /* access modifiers changed from: protected */
        public final List<Sensor> O00000Oo() {
            return bmp.this.O00000Oo == null ? Collections.emptyList() : Collections.singletonList(bmp.this.O00000Oo.getDefaultSensor(5));
        }
    }
}
