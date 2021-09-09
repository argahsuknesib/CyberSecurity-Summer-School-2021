package com.google.android.exoplayer2.ui.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.spherical.OrientationListener;
import com.google.android.exoplayer2.ui.spherical.TouchTracker;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class SphericalGLSurfaceView extends GLSurfaceView {
    private boolean isOrientationListenerRegistered;
    private boolean isStarted;
    private final Handler mainHandler;
    private final OrientationListener orientationListener;
    private final Sensor orientationSensor;
    private final SceneRenderer scene;
    private final SensorManager sensorManager;
    private Surface surface;
    private SurfaceTexture surfaceTexture;
    private final TouchTracker touchTracker;
    private boolean useSensorRotation;
    private Player.VideoComponent videoComponent;

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    public SphericalGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.sensorManager = (SensorManager) Assertions.checkNotNull(context.getSystemService("sensor"));
        Sensor defaultSensor = Util.SDK_INT >= 18 ? this.sensorManager.getDefaultSensor(15) : null;
        this.orientationSensor = defaultSensor == null ? this.sensorManager.getDefaultSensor(11) : defaultSensor;
        this.scene = new SceneRenderer();
        Renderer renderer = new Renderer(this.scene);
        this.touchTracker = new TouchTracker(context, renderer, 25.0f);
        this.orientationListener = new OrientationListener(((WindowManager) Assertions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), this.touchTracker, renderer);
        this.useSensorRotation = true;
        setEGLContextClientVersion(2);
        setRenderer(renderer);
        setOnTouchListener(this.touchTracker);
    }

    public final void setDefaultStereoMode(int i) {
        this.scene.setDefaultStereoMode(i);
    }

    public final void setVideoComponent(Player.VideoComponent videoComponent2) {
        Player.VideoComponent videoComponent3 = this.videoComponent;
        if (videoComponent2 != videoComponent3) {
            if (videoComponent3 != null) {
                Surface surface2 = this.surface;
                if (surface2 != null) {
                    videoComponent3.clearVideoSurface(surface2);
                }
                this.videoComponent.clearVideoFrameMetadataListener(this.scene);
                this.videoComponent.clearCameraMotionListener(this.scene);
            }
            this.videoComponent = videoComponent2;
            Player.VideoComponent videoComponent4 = this.videoComponent;
            if (videoComponent4 != null) {
                videoComponent4.setVideoFrameMetadataListener(this.scene);
                this.videoComponent.setCameraMotionListener(this.scene);
                this.videoComponent.setVideoSurface(this.surface);
            }
        }
    }

    public final void setSingleTapListener(SingleTapListener singleTapListener) {
        this.touchTracker.setSingleTapListener(singleTapListener);
    }

    public final void setUseSensorRotation(boolean z) {
        this.useSensorRotation = z;
        updateOrientationListenerRegistration();
    }

    public final void onResume() {
        super.onResume();
        this.isStarted = true;
        updateOrientationListenerRegistration();
    }

    public final void onPause() {
        this.isStarted = false;
        updateOrientationListenerRegistration();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mainHandler.post(new Runnable() {
            /* class com.google.android.exoplayer2.ui.spherical.$$Lambda$SphericalGLSurfaceView$svRenkwMuRhLEst9s1zm1Jg6UCE */

            public final void run() {
                SphericalGLSurfaceView.this.lambda$onDetachedFromWindow$0$SphericalGLSurfaceView();
            }
        });
    }

    public /* synthetic */ void lambda$onDetachedFromWindow$0$SphericalGLSurfaceView() {
        Surface surface2 = this.surface;
        if (surface2 != null) {
            Player.VideoComponent videoComponent2 = this.videoComponent;
            if (videoComponent2 != null) {
                videoComponent2.clearVideoSurface(surface2);
            }
            releaseSurface(this.surfaceTexture, this.surface);
            this.surfaceTexture = null;
            this.surface = null;
        }
    }

    private void updateOrientationListenerRegistration() {
        boolean z = this.useSensorRotation && this.isStarted;
        Sensor sensor = this.orientationSensor;
        if (sensor != null && z != this.isOrientationListenerRegistered) {
            if (z) {
                this.sensorManager.registerListener(this.orientationListener, sensor, 0);
            } else {
                this.sensorManager.unregisterListener(this.orientationListener);
            }
            this.isOrientationListenerRegistered = z;
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture2) {
        this.mainHandler.post(new Runnable(surfaceTexture2) {
            /* class com.google.android.exoplayer2.ui.spherical.$$Lambda$SphericalGLSurfaceView$SULIvMLF1CXjpubqiDYRNzkxCPc */
            private final /* synthetic */ SurfaceTexture f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                SphericalGLSurfaceView.this.lambda$onSurfaceTextureAvailable$1$SphericalGLSurfaceView(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$onSurfaceTextureAvailable$1$SphericalGLSurfaceView(SurfaceTexture surfaceTexture2) {
        SurfaceTexture surfaceTexture3 = this.surfaceTexture;
        Surface surface2 = this.surface;
        this.surfaceTexture = surfaceTexture2;
        this.surface = new Surface(surfaceTexture2);
        Player.VideoComponent videoComponent2 = this.videoComponent;
        if (videoComponent2 != null) {
            videoComponent2.setVideoSurface(this.surface);
        }
        releaseSurface(surfaceTexture3, surface2);
    }

    private static void releaseSurface(SurfaceTexture surfaceTexture2, Surface surface2) {
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        if (surface2 != null) {
            surface2.release();
        }
    }

    class Renderer implements GLSurfaceView.Renderer, OrientationListener.Listener, TouchTracker.Listener {
        private final float[] deviceOrientationMatrix = new float[16];
        private float deviceRoll;
        private final float[] projectionMatrix = new float[16];
        private final SceneRenderer scene;
        private final float[] tempMatrix = new float[16];
        private float touchPitch;
        private final float[] touchPitchMatrix = new float[16];
        private final float[] touchYawMatrix = new float[16];
        private final float[] viewMatrix = new float[16];
        private final float[] viewProjectionMatrix = new float[16];

        public Renderer(SceneRenderer sceneRenderer) {
            this.scene = sceneRenderer;
            Matrix.setIdentityM(this.deviceOrientationMatrix, 0);
            Matrix.setIdentityM(this.touchPitchMatrix, 0);
            Matrix.setIdentityM(this.touchYawMatrix, 0);
            this.deviceRoll = 3.1415927f;
        }

        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView.this.onSurfaceTextureAvailable(this.scene.init());
        }

        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            float f = ((float) i) / ((float) i2);
            Matrix.perspectiveM(this.projectionMatrix, 0, calculateFieldOfViewInYDirection(f), f, 0.1f, 100.0f);
        }

        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.tempMatrix, 0, this.deviceOrientationMatrix, 0, this.touchYawMatrix, 0);
                Matrix.multiplyMM(this.viewMatrix, 0, this.touchPitchMatrix, 0, this.tempMatrix, 0);
            }
            Matrix.multiplyMM(this.viewProjectionMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
            this.scene.drawFrame(this.viewProjectionMatrix, false);
        }

        public synchronized void onOrientationChange(float[] fArr, float f) {
            System.arraycopy(fArr, 0, this.deviceOrientationMatrix, 0, this.deviceOrientationMatrix.length);
            this.deviceRoll = -f;
            updatePitchMatrix();
        }

        private void updatePitchMatrix() {
            Matrix.setRotateM(this.touchPitchMatrix, 0, -this.touchPitch, (float) Math.cos((double) this.deviceRoll), (float) Math.sin((double) this.deviceRoll), 0.0f);
        }

        public synchronized void onScrollChange(PointF pointF) {
            this.touchPitch = pointF.y;
            updatePitchMatrix();
            Matrix.setRotateM(this.touchYawMatrix, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        private float calculateFieldOfViewInYDirection(float f) {
            if (!(f > 1.0f)) {
                return 90.0f;
            }
            double tan = Math.tan(Math.toRadians(45.0d));
            double d = (double) f;
            Double.isNaN(d);
            return (float) (Math.toDegrees(Math.atan(tan / d)) * 2.0d);
        }
    }
}
