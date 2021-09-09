package org.opencv.android;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.util.List;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class JavaCameraView extends CameraBridgeViewBase implements Camera.PreviewCallback {

    /* renamed from: O000000o  reason: collision with root package name */
    private byte[] f15461O000000o;
    private Thread O00000Oo;
    private SurfaceTexture O00000o0;
    public Mat[] O0000oOo;
    public boolean O0000oo;
    public int O0000oo0 = 0;
    protected Camera O0000ooO;
    protected O00000Oo[] O0000ooo;
    public int O00oOooO = 17;
    public boolean O00oOooo = false;

    public static class O00000o0 implements CameraBridgeViewBase.O0000O0o {
        public final int O000000o(Object obj) {
            return ((Camera.Size) obj).width;
        }

        public final int O00000Oo(Object obj) {
            return ((Camera.Size) obj).height;
        }
    }

    public JavaCameraView(Context context, int i) {
        super(context, -1);
    }

    public JavaCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0263 A[Catch:{ Exception -> 0x030c }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02e8 A[Catch:{ Exception -> 0x030c }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02f9 A[Catch:{ Exception -> 0x030c }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e4 A[Catch:{ Exception -> 0x0022 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ec A[Catch:{ Exception -> 0x0022 }] */
    private boolean O000000o(int i, int i2) {
        boolean z;
        int i3;
        Log.d("JavaCameraView", "Initialize java camera");
        synchronized (this) {
            this.O0000ooO = null;
            z = false;
            if (this.O0000oO0 == -1) {
                Log.d("JavaCameraView", "Trying to open camera with old open()");
                try {
                    this.O0000ooO = Camera.open();
                } catch (Exception e) {
                    Log.e("JavaCameraView", "Camera is not available (in use or does not exist): " + e.getLocalizedMessage());
                }
                if (this.O0000ooO == null && Build.VERSION.SDK_INT >= 9) {
                    boolean z2 = false;
                    for (int i4 = 0; i4 < Camera.getNumberOfCameras(); i4++) {
                        Log.d("JavaCameraView", "Trying to open camera with new open(" + Integer.valueOf(i4) + ")");
                        try {
                            this.O0000ooO = Camera.open(i4);
                            z2 = true;
                        } catch (RuntimeException e2) {
                            Log.e("JavaCameraView", "Camera #" + i4 + "failed to open: " + e2.getLocalizedMessage());
                        }
                        if (z2) {
                            break;
                        }
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 9) {
                int i5 = this.O0000oO0;
                if (this.O0000oO0 == 99) {
                    Log.i("JavaCameraView", "Trying to open back camera");
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    i3 = 0;
                    while (true) {
                        if (i3 >= Camera.getNumberOfCameras()) {
                            break;
                        }
                        Camera.getCameraInfo(i3, cameraInfo);
                        if (cameraInfo.facing == 0) {
                            break;
                        }
                        i3++;
                    }
                    if (i3 == 99) {
                        Log.e("JavaCameraView", "Back camera not found!");
                    } else if (i3 == 98) {
                        Log.e("JavaCameraView", "Front camera not found!");
                    } else {
                        Log.d("JavaCameraView", "Trying to open camera with new open(" + Integer.valueOf(i3) + ")");
                        try {
                            this.O0000ooO = Camera.open(i3);
                        } catch (RuntimeException e3) {
                            Log.e("JavaCameraView", "Camera #" + i3 + "failed to open: " + e3.getLocalizedMessage());
                        }
                    }
                } else if (this.O0000oO0 == 98) {
                    Log.i("JavaCameraView", "Trying to open front camera");
                    Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                    int i6 = 0;
                    while (true) {
                        if (i3 >= Camera.getNumberOfCameras()) {
                            break;
                        }
                        Camera.getCameraInfo(i3, cameraInfo2);
                        if (cameraInfo2.facing == 1) {
                            break;
                        }
                        i6 = i3 + 1;
                    }
                    if (i3 == 99) {
                    }
                }
                i3 = i5;
                if (i3 == 99) {
                }
            }
            if (this.O0000ooO == null) {
                return false;
            }
            try {
                Camera.Parameters parameters = this.O0000ooO.getParameters();
                Log.d("JavaCameraView", "getSupportedPreviewSizes()");
                List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                if (supportedPreviewSizes != null) {
                    Size O000000o2 = O000000o(supportedPreviewSizes, new O00000o0(), i, i2);
                    if (!Build.FINGERPRINT.startsWith("generic") && !Build.FINGERPRINT.startsWith("unknown") && !Build.MODEL.contains("google_sdk") && !Build.MODEL.contains("Emulator") && !Build.MODEL.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && (!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic"))) {
                        if (!"google_sdk".equals(Build.PRODUCT)) {
                            parameters.setPreviewFormat(17);
                            this.O00oOooO = parameters.getPreviewFormat();
                            Log.d("JavaCameraView", "Set preview size to " + Integer.valueOf((int) O000000o2.width) + "x" + Integer.valueOf((int) O000000o2.height));
                            parameters.setPreviewSize((int) O000000o2.width, (int) O000000o2.height);
                            if (Build.VERSION.SDK_INT >= 14 && !Build.MODEL.equals("GT-I9100")) {
                                parameters.setRecordingHint(true);
                            }
                            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                                parameters.setFocusMode("continuous-video");
                            }
                            this.O0000ooO.setParameters(parameters);
                            Camera.Parameters parameters2 = this.O0000ooO.getParameters();
                            this.O0000Ooo = parameters2.getPreviewSize().width;
                            this.O0000o00 = parameters2.getPreviewSize().height;
                            if (getLayoutParams().width == -1 || getLayoutParams().height != -1) {
                                this.O0000o0o = 0.0f;
                            } else {
                                this.O0000o0o = Math.min(((float) i2) / ((float) this.O0000o00), ((float) i) / ((float) this.O0000Ooo));
                            }
                            if (this.O0000oOO != null) {
                                this.O0000oOO.O000000o(this.O0000Ooo, this.O0000o00);
                            }
                            this.f15461O000000o = new byte[(((this.O0000Ooo * this.O0000o00) * ImageFormat.getBitsPerPixel(parameters2.getPreviewFormat())) / 8)];
                            this.O0000ooO.addCallbackBuffer(this.f15461O000000o);
                            this.O0000ooO.setPreviewCallbackWithBuffer(this);
                            this.O0000oOo = new Mat[2];
                            this.O0000oOo[0] = new Mat(this.O0000o00 + (this.O0000o00 / 2), this.O0000Ooo, CvType.CV_8UC1);
                            this.O0000oOo[1] = new Mat(this.O0000o00 + (this.O0000o00 / 2), this.O0000Ooo, CvType.CV_8UC1);
                            O00000oO();
                            this.O0000ooo = new O00000Oo[2];
                            this.O0000ooo[0] = new O00000Oo(this.O0000oOo[0], this.O0000Ooo, this.O0000o00);
                            this.O0000ooo[1] = new O00000Oo(this.O0000oOo[1], this.O0000Ooo, this.O0000o00);
                            if (Build.VERSION.SDK_INT < 11) {
                                this.O00000o0 = new SurfaceTexture(10);
                                this.O0000ooO.setPreviewTexture(this.O00000o0);
                            } else {
                                this.O0000ooO.setPreviewDisplay(null);
                            }
                            Log.d("JavaCameraView", "startPreview");
                            this.O0000ooO.startPreview();
                            z = true;
                        }
                    }
                    parameters.setPreviewFormat(842094169);
                    this.O00oOooO = parameters.getPreviewFormat();
                    Log.d("JavaCameraView", "Set preview size to " + Integer.valueOf((int) O000000o2.width) + "x" + Integer.valueOf((int) O000000o2.height));
                    parameters.setPreviewSize((int) O000000o2.width, (int) O000000o2.height);
                    parameters.setRecordingHint(true);
                    List<String> supportedFocusModes2 = parameters.getSupportedFocusModes();
                    parameters.setFocusMode("continuous-video");
                    this.O0000ooO.setParameters(parameters);
                    Camera.Parameters parameters22 = this.O0000ooO.getParameters();
                    this.O0000Ooo = parameters22.getPreviewSize().width;
                    this.O0000o00 = parameters22.getPreviewSize().height;
                    if (getLayoutParams().width == -1) {
                    }
                    this.O0000o0o = 0.0f;
                    if (this.O0000oOO != null) {
                    }
                    this.f15461O000000o = new byte[(((this.O0000Ooo * this.O0000o00) * ImageFormat.getBitsPerPixel(parameters22.getPreviewFormat())) / 8)];
                    this.O0000ooO.addCallbackBuffer(this.f15461O000000o);
                    this.O0000ooO.setPreviewCallbackWithBuffer(this);
                    this.O0000oOo = new Mat[2];
                    this.O0000oOo[0] = new Mat(this.O0000o00 + (this.O0000o00 / 2), this.O0000Ooo, CvType.CV_8UC1);
                    this.O0000oOo[1] = new Mat(this.O0000o00 + (this.O0000o00 / 2), this.O0000Ooo, CvType.CV_8UC1);
                    O00000oO();
                    this.O0000ooo = new O00000Oo[2];
                    this.O0000ooo[0] = new O00000Oo(this.O0000oOo[0], this.O0000Ooo, this.O0000o00);
                    this.O0000ooo[1] = new O00000Oo(this.O0000oOo[1], this.O0000Ooo, this.O0000o00);
                    if (Build.VERSION.SDK_INT < 11) {
                    }
                    Log.d("JavaCameraView", "startPreview");
                    this.O0000ooO.startPreview();
                    z = true;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean O00000Oo(int i, int i2) {
        Log.d("JavaCameraView", "Connecting to camera");
        if (!O000000o(i, i2)) {
            return false;
        }
        this.O00oOooo = false;
        Log.d("JavaCameraView", "Starting processing thread");
        this.O0000oo = false;
        this.O00000Oo = new Thread(new O000000o(this, (byte) 0));
        this.O00000Oo.start();
        return true;
    }

    /* access modifiers changed from: protected */
    public void O00000Oo() {
        Log.d("JavaCameraView", "Disconnecting from camera");
        try {
            this.O0000oo = true;
            Log.d("JavaCameraView", "Notify thread");
            synchronized (this) {
                notify();
                Log.d("JavaCameraView", "Waiting for thread");
                if (this.O00000Oo != null) {
                    this.O00000Oo.join();
                }
                this.O00000Oo = null;
                synchronized (this) {
                    if (this.O0000ooO != null) {
                        this.O0000ooO.stopPreview();
                        this.O0000ooO.setPreviewCallback(null);
                        this.O0000ooO.release();
                    }
                    this.O0000ooO = null;
                    if (this.O0000oOo != null) {
                        this.O0000oOo[0].release();
                        this.O0000oOo[1].release();
                    }
                    if (this.O0000ooo != null) {
                        this.O0000ooo[0].f15463O000000o.release();
                        this.O0000ooo[1].f15463O000000o.release();
                    }
                }
            }
        } catch (InterruptedException e) {
            try {
                e.printStackTrace();
            } catch (Throwable th) {
                this.O00000Oo = null;
                throw th;
            }
        }
        this.O00oOooo = false;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this) {
            this.O0000oOo[this.O0000oo0].put(0, 0, bArr);
            this.O00oOooo = true;
            notify();
        }
        Camera camera2 = this.O0000ooO;
        if (camera2 != null) {
            camera2.addCallbackBuffer(this.f15461O000000o);
        }
    }

    class O00000Oo implements CameraBridgeViewBase.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Mat f15463O000000o = new Mat();
        private int O00000o;
        private Mat O00000o0;
        private int O00000oO;

        public final Mat O00000Oo() {
            return this.O00000o0.submat(0, this.O00000oO, 0, this.O00000o);
        }

        public final Mat O000000o() {
            if (JavaCameraView.this.O00oOooO == 17) {
                Imgproc.cvtColor(this.O00000o0, this.f15463O000000o, 96, 4);
            } else if (JavaCameraView.this.O00oOooO == 842094169) {
                Imgproc.cvtColor(this.O00000o0, this.f15463O000000o, 100, 4);
            } else {
                throw new IllegalArgumentException("Preview Format can be NV21 or YV12");
            }
            return this.f15463O000000o;
        }

        public O00000Oo(Mat mat, int i, int i2) {
            this.O00000o = i;
            this.O00000oO = i2;
            this.O00000o0 = mat;
        }
    }

    class O000000o implements Runnable {
        private O000000o() {
        }

        /* synthetic */ O000000o(JavaCameraView javaCameraView, byte b) {
            this();
        }

        public final void run() {
            boolean z;
            do {
                synchronized (JavaCameraView.this) {
                    while (!JavaCameraView.this.O00oOooo && !JavaCameraView.this.O0000oo) {
                        try {
                            JavaCameraView.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    z = false;
                    if (JavaCameraView.this.O00oOooo) {
                        JavaCameraView.this.O0000oo0 = 1 - JavaCameraView.this.O0000oo0;
                        JavaCameraView.this.O00oOooo = false;
                        z = true;
                    }
                }
                if (!JavaCameraView.this.O0000oo && z && !JavaCameraView.this.O0000oOo[1 - JavaCameraView.this.O0000oo0].empty()) {
                    JavaCameraView javaCameraView = JavaCameraView.this;
                    javaCameraView.O00000Oo(javaCameraView.O0000ooo[1 - JavaCameraView.this.O0000oo0]);
                }
            } while (!JavaCameraView.this.O0000oo);
            Log.d("JavaCameraView", "Finish processing thread");
        }
    }
}
