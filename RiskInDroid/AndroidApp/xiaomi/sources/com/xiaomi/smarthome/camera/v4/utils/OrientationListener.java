package com.xiaomi.smarthome.camera.v4.utils;

import _m_j.gsy;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.Settings;

public class OrientationListener implements SensorEventListener {
    public static final String TAG = "OrientationListener";
    private Sensor mAccelerometer;
    private float[] mAccelerometerValues = new float[3];
    private Context mContext;
    private Sensor mMagnetic;
    private float[] mMagneticValues = new float[3];
    private OnOrientationListener mOnOrientationListener;
    private SensorManager mSensorManager;

    public interface OnOrientationListener {
        void onOrientationChanged(int i);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public OrientationListener(Context context) {
        this.mContext = context;
        start();
    }

    public void setOnOrientationListener(OnOrientationListener onOrientationListener) {
        this.mOnOrientationListener = onOrientationListener;
    }

    private void start() {
        this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.mAccelerometer = this.mSensorManager.getDefaultSensor(1);
        this.mMagnetic = this.mSensorManager.getDefaultSensor(2);
    }

    public void registerListener() {
        Sensor sensor;
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null && (sensor = this.mAccelerometer) != null && this.mMagnetic != null) {
            sensorManager.registerListener(this, sensor, 3);
            this.mSensorManager.registerListener(this, this.mMagnetic, 3);
        }
    }

    public void unregisterListener() {
        this.mSensorManager.unregisterListener(this);
    }

    private void calculateOrientation() {
        int i;
        try {
            i = Settings.System.getInt(this.mContext.getContentResolver(), "accelerometer_rotation");
        } catch (Settings.SettingNotFoundException e) {
            gsy.O000000o(6, TAG, e.toString());
            i = 0;
        }
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.mAccelerometerValues, this.mMagneticValues);
        SensorManager.getOrientation(fArr2, fArr);
        float degrees = (float) Math.toDegrees((double) fArr[1]);
        float degrees2 = (float) Math.toDegrees((double) fArr[2]);
        if (this.mOnOrientationListener != null && i == 1) {
            if (degrees < -40.0f && Math.abs(degrees2) < 40.0f) {
                this.mOnOrientationListener.onOrientationChanged(1);
            } else if (Math.abs(degrees) < 40.0f && degrees2 < -40.0f) {
                this.mOnOrientationListener.onOrientationChanged(0);
            } else if (Math.abs(degrees) < 40.0f && degrees2 > 40.0f) {
                this.mOnOrientationListener.onOrientationChanged(8);
            }
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            this.mAccelerometerValues = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 2) {
            this.mMagneticValues = sensorEvent.values;
        }
        calculateOrientation();
    }
}
