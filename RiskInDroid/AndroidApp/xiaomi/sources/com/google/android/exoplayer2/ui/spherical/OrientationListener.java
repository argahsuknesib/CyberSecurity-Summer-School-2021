package com.google.android.exoplayer2.ui.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import com.google.android.exoplayer2.video.spherical.FrameRotationQueue;

final class OrientationListener implements SensorEventListener {
    private final float[] angles = new float[3];
    private final float[] deviceOrientationMatrix4x4 = new float[16];
    private final Display display;
    private final Listener[] listeners;
    private final float[] recenterMatrix4x4 = new float[16];
    private boolean recenterMatrixComputed;
    private final float[] tempMatrix4x4 = new float[16];

    public interface Listener {
        void onOrientationChange(float[] fArr, float f);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public OrientationListener(Display display2, Listener... listenerArr) {
        this.display = display2;
        this.listeners = listenerArr;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.deviceOrientationMatrix4x4, sensorEvent.values);
        rotateAroundZ(this.deviceOrientationMatrix4x4, this.display.getRotation());
        float extractRoll = extractRoll(this.deviceOrientationMatrix4x4);
        rotateYtoSky(this.deviceOrientationMatrix4x4);
        recenter(this.deviceOrientationMatrix4x4);
        notifyListeners(this.deviceOrientationMatrix4x4, extractRoll);
    }

    private void notifyListeners(float[] fArr, float f) {
        for (Listener onOrientationChange : this.listeners) {
            onOrientationChange.onOrientationChange(fArr, f);
        }
    }

    private void recenter(float[] fArr) {
        if (!this.recenterMatrixComputed) {
            FrameRotationQueue.computeRecenterMatrix(this.recenterMatrix4x4, fArr);
            this.recenterMatrixComputed = true;
        }
        float[] fArr2 = this.tempMatrix4x4;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.tempMatrix4x4, 0, this.recenterMatrix4x4, 0);
    }

    private float extractRoll(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.tempMatrix4x4);
        SensorManager.getOrientation(this.tempMatrix4x4, this.angles);
        return this.angles[2];
    }

    private void rotateAroundZ(float[] fArr, int i) {
        if (i != 0) {
            int i2 = 130;
            int i3 = 129;
            if (i == 1) {
                i2 = 2;
            } else if (i == 2) {
                i2 = 129;
                i3 = 130;
            } else if (i == 3) {
                i3 = 1;
            } else {
                throw new IllegalStateException();
            }
            float[] fArr2 = this.tempMatrix4x4;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.tempMatrix4x4, i2, i3, fArr);
        }
    }

    private static void rotateYtoSky(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }
}
