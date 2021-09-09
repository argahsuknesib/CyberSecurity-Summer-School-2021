package _m_j;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dbg {
    private static Activity O000O0oo;
    private static dbg O00oOooO;

    /* renamed from: O000000o  reason: collision with root package name */
    SensorManager f14435O000000o;
    LocationManager O00000Oo;
    float O00000o;
    float O00000o0;
    float O00000oO;
    float O00000oo;
    float O0000O0o;
    float O0000OOo;
    float O0000Oo;
    float O0000Oo0;
    float O0000OoO;
    float O0000Ooo;
    float O0000o;
    float O0000o0;
    float O0000o00;
    float O0000o0O;
    float O0000o0o;
    float O0000oO;
    float O0000oO0;
    float O0000oOO;
    boolean O0000oOo;
    Object O0000oo = new Object();
    List<GpsSatellite> O0000oo0 = new ArrayList();
    SensorEventListener O0000ooO = new SensorEventListener() {
        /* class _m_j.dbg.AnonymousClass2 */

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            dbg.this.O0000oO0 = sensorEvent.values[0];
            dbg.this.O0000oO = sensorEvent.values[1];
            dbg.this.O0000oOO = sensorEvent.values[2];
        }
    };
    GpsStatus.Listener O0000ooo = new GpsStatus.Listener() {
        /* class _m_j.dbg.AnonymousClass3 */

        public final void onGpsStatusChanged(int i) {
            if (i != 1 && i != 2 && i != 3 && i == 4) {
                GpsStatus gpsStatus = dbg.this.O00000Oo.getGpsStatus(null);
                Iterator<GpsSatellite> it = gpsStatus.getSatellites().iterator();
                int i2 = 0;
                int maxSatellites = gpsStatus.getMaxSatellites();
                synchronized (dbg.this.O0000oo) {
                    dbg.this.O0000oo0.clear();
                    while (it.hasNext() && i2 < maxSatellites) {
                        GpsSatellite next = it.next();
                        if (next.usedInFix()) {
                            dbg.this.O0000oo0.add(next);
                        }
                        i2++;
                    }
                }
            }
        }
    };
    private boolean O000O00o;
    private boolean O000O0OO;
    private boolean O000O0Oo;
    private boolean O000O0o;
    private boolean O000O0o0;
    private boolean O000O0oO = false;
    private SensorEventListener O000OO = new SensorEventListener() {
        /* class _m_j.dbg.AnonymousClass6 */

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            dbg.this.O0000Oo0 = sensorEvent.values[0];
            dbg.this.O0000Oo = sensorEvent.values[1];
            dbg.this.O0000OoO = sensorEvent.values[2];
        }
    };
    private SensorEventListener O000OO00 = new SensorEventListener() {
        /* class _m_j.dbg.AnonymousClass4 */

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            dbg.this.O00000o0 = sensorEvent.values[0];
            dbg.this.O00000o = sensorEvent.values[1];
            dbg.this.O00000oO = sensorEvent.values[2];
        }
    };
    private SensorEventListener O000OO0o = new SensorEventListener() {
        /* class _m_j.dbg.AnonymousClass5 */

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            dbg.this.O00000oo = sensorEvent.values[0];
            dbg.this.O0000O0o = sensorEvent.values[1];
            dbg.this.O0000OOo = sensorEvent.values[2];
        }
    };
    private SensorEventListener O000OOOo = new SensorEventListener() {
        /* class _m_j.dbg.AnonymousClass7 */

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            dbg.this.O0000Ooo = sensorEvent.values[0];
        }
    };
    private SensorEventListener O000OOo = new SensorEventListener() {
        /* class _m_j.dbg.AnonymousClass9 */

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            dbg.this.O0000o0o = sensorEvent.values[0];
        }
    };
    private SensorEventListener O000OOo0 = new SensorEventListener() {
        /* class _m_j.dbg.AnonymousClass8 */

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            dbg.this.O0000o00 = sensorEvent.values[0];
            dbg.this.O0000o0 = sensorEvent.values[1];
            dbg.this.O0000o0O = sensorEvent.values[2];
        }
    };
    private SensorEventListener O000OOoO = new SensorEventListener() {
        /* class _m_j.dbg.AnonymousClass10 */

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            dbg.this.O0000o = sensorEvent.values[0];
        }
    };
    private boolean O00oOoOo;
    private boolean O00oOooo;

    private dbg(Context context) {
        this.f14435O000000o = (SensorManager) context.getSystemService("sensor");
        this.O00000Oo = (LocationManager) context.getSystemService("location");
    }

    public static synchronized dbg O000000o(Activity activity) {
        dbg dbg;
        synchronized (dbg.class) {
            if (O00oOooO == null) {
                O00oOooO = new dbg(activity);
            }
            O000O0oo = activity;
            dbg = O00oOooO;
        }
        return dbg;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o() {
        if (!this.O000O0oO) {
            this.O000O0oO = true;
            final List[] listArr = {null};
            if (!this.O00oOooo) {
                listArr[0] = this.f14435O000000o.getSensorList(1);
                if (listArr[0] == null || listArr[0].size() <= 0) {
                    this.O00oOooo = false;
                } else {
                    this.O00oOooo = this.f14435O000000o.registerListener(this.O000OO00, (Sensor) listArr[0].get(0), 3);
                }
            }
            if (!this.O000O00o) {
                listArr[0] = this.f14435O000000o.getSensorList(3);
                if (listArr[0] == null || listArr[0].size() <= 0) {
                    this.O000O00o = false;
                } else {
                    this.O000O00o = this.f14435O000000o.registerListener(this.O000OO0o, (Sensor) listArr[0].get(0), 3);
                }
            }
            if (!this.O000O0OO) {
                listArr[0] = this.f14435O000000o.getSensorList(9);
                if (listArr[0] == null || listArr[0].size() <= 0) {
                    this.O000O0OO = false;
                } else {
                    this.O000O0OO = this.f14435O000000o.registerListener(this.O000OO, (Sensor) listArr[0].get(0), 3);
                }
            }
            if (!this.O000O0Oo) {
                listArr[0] = this.f14435O000000o.getSensorList(5);
                if (listArr[0] == null || listArr[0].size() <= 0) {
                    this.O000O0Oo = false;
                } else {
                    this.O000O0Oo = this.f14435O000000o.registerListener(this.O000OOOo, (Sensor) listArr[0].get(0), 3);
                }
            }
            if (!this.O00oOoOo) {
                listArr[0] = this.f14435O000000o.getSensorList(4);
                if (listArr[0] == null || listArr[0].size() <= 0) {
                    this.O00oOoOo = false;
                } else {
                    this.O00oOoOo = this.f14435O000000o.registerListener(this.O000OOo0, (Sensor) listArr[0].get(0), 3);
                }
            }
            if (!this.O000O0o0) {
                listArr[0] = this.f14435O000000o.getSensorList(8);
                if (listArr[0] == null || listArr[0].size() <= 0) {
                    this.O000O0o0 = false;
                } else {
                    this.O000O0o0 = this.f14435O000000o.registerListener(this.O000OOo, (Sensor) listArr[0].get(0), 3);
                }
            }
            if (!this.O000O0o) {
                listArr[0] = this.f14435O000000o.getSensorList(6);
                if (listArr[0] == null || listArr[0].size() <= 0) {
                    this.O000O0o = false;
                } else {
                    this.O000O0o = this.f14435O000000o.registerListener(this.O000OOoO, (Sensor) listArr[0].get(0), 3);
                }
            }
            O000O0oo.runOnUiThread(new Runnable() {
                /* class _m_j.dbg.AnonymousClass1 */

                public final void run() {
                    if (!dbg.this.O0000oOo) {
                        listArr[0] = dbg.this.f14435O000000o.getSensorList(11);
                        List[] listArr = listArr;
                        if (listArr[0] == null || listArr[0].size() <= 0) {
                            dbg.this.O0000oOo = false;
                        } else {
                            dbg dbg = dbg.this;
                            dbg.O0000oOo = dbg.f14435O000000o.registerListener(dbg.this.O0000ooO, (Sensor) listArr[0].get(0), 3);
                        }
                    }
                    dbg.this.O00000Oo.addGpsStatusListener(dbg.this.O0000ooo);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(JSONObject jSONObject) {
        try {
            if (this.O00oOooo) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.O00000o0);
                jSONObject.putOpt("accelerometerX", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.O00000o);
                jSONObject.putOpt("accelerometerY", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.O00000oO);
                jSONObject.putOpt("accelerometerZ", sb3.toString());
            }
            if (this.O000O00o) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.O00000oo);
                jSONObject.putOpt("orientationYaw", sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.O0000O0o);
                jSONObject.putOpt("orientationPitch", sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.O0000OOo);
                jSONObject.putOpt("orientationRoll", sb6.toString());
            }
            if (this.O000O0OO) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(this.O0000Oo0);
                jSONObject.putOpt("gravityX", sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append(this.O0000Oo);
                jSONObject.putOpt("gravityY", sb8.toString());
                StringBuilder sb9 = new StringBuilder();
                sb9.append(this.O0000OoO);
                jSONObject.putOpt("gravityZ", sb9.toString());
            }
            if (this.O000O0Oo) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append(this.O0000Ooo);
                jSONObject.putOpt("light", sb10.toString());
            }
            if (this.O00oOoOo) {
                StringBuilder sb11 = new StringBuilder();
                sb11.append(this.O0000o00);
                jSONObject.putOpt("gyroscopeX", sb11.toString());
                StringBuilder sb12 = new StringBuilder();
                sb12.append(this.O0000o0);
                jSONObject.putOpt("gyroscopeY", sb12.toString());
                StringBuilder sb13 = new StringBuilder();
                sb13.append(this.O0000o0O);
                jSONObject.putOpt("gyroscopeZ", sb13.toString());
            }
            if (this.O000O0o0) {
                StringBuilder sb14 = new StringBuilder();
                sb14.append(this.O0000o0o);
                jSONObject.putOpt("proximity", sb14.toString());
            }
            if (this.O000O0o) {
                StringBuilder sb15 = new StringBuilder();
                sb15.append(this.O0000o);
                jSONObject.putOpt("pressValue", sb15.toString());
            }
            if (this.O0000oOo) {
                StringBuilder sb16 = new StringBuilder();
                sb16.append(this.O0000oO0);
                jSONObject.putOpt("rotationVectorX", sb16.toString());
                StringBuilder sb17 = new StringBuilder();
                sb17.append(this.O0000oO);
                jSONObject.putOpt("rotationVectorY", sb17.toString());
                StringBuilder sb18 = new StringBuilder();
                sb18.append(this.O0000oOO);
                jSONObject.putOpt("rotationVectorZ", sb18.toString());
            }
            synchronized (this.O0000oo) {
                if (this.O0000oo0.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    int size = this.O0000oo0.size();
                    for (int i = 0; i < size; i++) {
                        GpsSatellite gpsSatellite = this.O0000oo0.get(i);
                        JSONObject jSONObject2 = new JSONObject();
                        float azimuth = gpsSatellite.getAzimuth();
                        float elevation = gpsSatellite.getElevation();
                        int prn = gpsSatellite.getPrn();
                        float snr = gpsSatellite.getSnr();
                        jSONObject2.put("az", (double) azimuth);
                        jSONObject2.put("el", (double) elevation);
                        jSONObject2.put("prn", prn);
                        jSONObject2.put("snr", (double) snr);
                        jSONArray.put(i, jSONObject2);
                    }
                    jSONObject.putOpt("sat", jSONArray);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O00000Oo() {
        if (this.O000O0oO) {
            if (this.O00oOooo) {
                this.f14435O000000o.unregisterListener(this.O000OO00);
                this.O00oOooo = false;
            }
            if (this.O000O00o) {
                this.f14435O000000o.unregisterListener(this.O000OO0o);
                this.O000O00o = false;
            }
            if (this.O000O0OO) {
                this.f14435O000000o.unregisterListener(this.O000OO);
                this.O000O0OO = false;
            }
            if (this.O000O0Oo) {
                this.f14435O000000o.unregisterListener(this.O000OOOo);
                this.O000O0Oo = false;
            }
            if (this.O00oOoOo) {
                this.f14435O000000o.unregisterListener(this.O000OOo0);
                this.O00oOoOo = false;
            }
            if (this.O000O0o0) {
                this.f14435O000000o.unregisterListener(this.O000OOo);
                this.O000O0o0 = false;
            }
            if (this.O000O0o) {
                this.f14435O000000o.unregisterListener(this.O000OOoO);
                this.O000O0o = false;
            }
            if (this.O0000oOo) {
                this.f14435O000000o.unregisterListener(this.O0000ooO);
                this.O0000oOo = false;
            }
            this.O00000Oo.removeGpsStatusListener(this.O0000ooo);
            this.O000O0oO = false;
        }
    }
}
