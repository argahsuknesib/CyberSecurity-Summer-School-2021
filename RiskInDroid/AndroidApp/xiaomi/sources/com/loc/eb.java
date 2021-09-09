package com.loc;

import _m_j.bvz;
import _m_j.bwi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

public final class eb implements SensorEventListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public SensorManager f4529O000000o = null;
    public Sensor O00000Oo = null;
    public Sensor O00000o = null;
    public Sensor O00000o0 = null;
    public boolean O00000oO = false;
    public double O00000oo = 0.0d;
    public float O0000O0o = 0.0f;
    public float O0000OOo = 0.0f;
    double O0000Oo = 0.0d;
    public Handler O0000Oo0 = new Handler() {
        /* class com.loc.eb.AnonymousClass1 */
    };
    double O0000OoO = 0.0d;
    double O0000Ooo = 0.0d;
    long O0000o = 0;
    double[] O0000o0 = new double[3];
    public double O0000o00 = 0.0d;
    volatile double O0000o0O = 0.0d;
    long O0000o0o = 0;
    final int O0000oO = 30;
    final int O0000oO0 = 100;
    private Context O0000oOO = null;
    private float O0000oOo = 1013.25f;

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|(1:4)|5|6|7|8|9|10|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x005e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0068 */
    public eb(Context context) {
        try {
            this.O0000oOO = context;
            if (this.f4529O000000o == null) {
                this.f4529O000000o = (SensorManager) this.O0000oOO.getSystemService("sensor");
            }
            this.O00000Oo = this.f4529O000000o.getDefaultSensor(6);
            this.O00000o0 = this.f4529O000000o.getDefaultSensor(11);
            this.O00000o = this.f4529O000000o.getDefaultSensor(1);
        } catch (Throwable th) {
            bvz.O000000o(th, "AMapSensorManager", "<init>");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:4|5|6|(1:8)|9|10|(1:12)|13|14|(2:16|18)(1:22)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0014 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0018 A[Catch:{ Throwable -> 0x001f }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0023 A[Catch:{ Throwable -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    public final void O000000o() {
        SensorManager sensorManager = this.f4529O000000o;
        if (sensorManager != null && this.O00000oO) {
            this.O00000oO = false;
            if (this.O00000Oo != null) {
                sensorManager.unregisterListener(this, this.O00000Oo);
            }
            if (this.O00000o0 != null) {
                this.f4529O000000o.unregisterListener(this, this.O00000o0);
            }
            try {
                if (this.O00000o != null) {
                    this.f4529O000000o.unregisterListener(this, this.O00000o);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        if (sensorEvent != null) {
            try {
                int type = sensorEvent.sensor.getType();
                if (type != 1) {
                    if (type == 6) {
                        try {
                            if (this.O00000Oo != null) {
                                float[] fArr2 = (float[]) sensorEvent.values.clone();
                                if (fArr2 != null) {
                                    this.O0000O0o = fArr2[0];
                                }
                                if (fArr2 != null) {
                                    this.O00000oo = (double) bwi.O000000o(SensorManager.getAltitude(this.O0000oOo, fArr2[0]));
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    } else if (type == 11) {
                        try {
                            if (this.O00000o0 != null && (fArr = (float[]) sensorEvent.values.clone()) != null) {
                                float[] fArr3 = new float[9];
                                SensorManager.getRotationMatrixFromVector(fArr3, fArr);
                                float[] fArr4 = new float[3];
                                SensorManager.getOrientation(fArr3, fArr4);
                                this.O0000OOo = (float) Math.toDegrees((double) fArr4[0]);
                                this.O0000OOo = (float) Math.floor((double) (this.O0000OOo > 0.0f ? this.O0000OOo : this.O0000OOo + 360.0f));
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                } else if (this.O00000o != null) {
                    float[] fArr5 = (float[]) sensorEvent.values.clone();
                    double[] dArr = this.O0000o0;
                    double d = this.O0000o0[0] * 0.800000011920929d;
                    double d2 = (double) (fArr5[0] * 0.19999999f);
                    Double.isNaN(d2);
                    dArr[0] = d + d2;
                    double[] dArr2 = this.O0000o0;
                    double d3 = this.O0000o0[1] * 0.800000011920929d;
                    double d4 = (double) (fArr5[1] * 0.19999999f);
                    Double.isNaN(d4);
                    dArr2[1] = d3 + d4;
                    double[] dArr3 = this.O0000o0;
                    double d5 = this.O0000o0[2] * 0.800000011920929d;
                    double d6 = (double) (fArr5[2] * 0.19999999f);
                    Double.isNaN(d6);
                    dArr3[2] = d5 + d6;
                    double d7 = (double) fArr5[0];
                    double d8 = this.O0000o0[0];
                    Double.isNaN(d7);
                    this.O0000Oo = d7 - d8;
                    double d9 = (double) fArr5[1];
                    double d10 = this.O0000o0[1];
                    Double.isNaN(d9);
                    this.O0000OoO = d9 - d10;
                    double d11 = (double) fArr5[2];
                    double d12 = this.O0000o0[2];
                    Double.isNaN(d11);
                    this.O0000Ooo = d11 - d12;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.O0000o0o >= 100) {
                        double sqrt = Math.sqrt((this.O0000Oo * this.O0000Oo) + (this.O0000OoO * this.O0000OoO) + (this.O0000Ooo * this.O0000Ooo));
                        this.O0000o++;
                        this.O0000o0o = currentTimeMillis;
                        this.O0000o0O += sqrt;
                        if (this.O0000o >= 30) {
                            double d13 = this.O0000o0O;
                            double d14 = (double) this.O0000o;
                            Double.isNaN(d14);
                            this.O0000o00 = d13 / d14;
                            this.O0000o0O = 0.0d;
                            this.O0000o = 0;
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }
}
