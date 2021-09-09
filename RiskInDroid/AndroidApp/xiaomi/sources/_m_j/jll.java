package _m_j;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.IOException;
import java.util.List;
import org.opencv.android.CameraGLSurfaceView;

@TargetApi(GmsLogger.MAX_PII_TAG_LENGTH)
public final class jll extends jlk {

    /* renamed from: O000000o  reason: collision with root package name */
    private Camera f1923O000000o;
    private boolean O00000Oo = false;

    public jll(CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
    }

    /* access modifiers changed from: protected */
    public final synchronized void O00000o0() {
        Log.i("CameraRenderer", "closeCamera");
        if (this.f1923O000000o != null) {
            this.f1923O000000o.stopPreview();
            this.O00000Oo = false;
            this.f1923O000000o.release();
            this.f1923O000000o = null;
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void O000000o(int i) {
        Log.i("CameraRenderer", "openCamera");
        O00000o0();
        int i2 = 0;
        if (i == -1) {
            Log.d("CameraRenderer", "Trying to open camera with old open()");
            try {
                this.f1923O000000o = Camera.open();
            } catch (Exception e) {
                Log.e("CameraRenderer", "Camera is not available (in use or does not exist): " + e.getLocalizedMessage());
            }
            if (this.f1923O000000o == null && Build.VERSION.SDK_INT >= 9) {
                boolean z = false;
                while (i2 < Camera.getNumberOfCameras()) {
                    Log.d("CameraRenderer", "Trying to open camera with new open(" + i2 + ")");
                    try {
                        this.f1923O000000o = Camera.open(i2);
                        z = true;
                    } catch (RuntimeException e2) {
                        Log.e("CameraRenderer", "Camera #" + i2 + "failed to open: " + e2.getLocalizedMessage());
                    }
                    if (z) {
                        break;
                    }
                    i2++;
                }
            }
        } else if (Build.VERSION.SDK_INT >= 9) {
            int i3 = this.O0000o0;
            if (this.O0000o0 == 99) {
                Log.i("CameraRenderer", "Trying to open BACK camera");
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                while (true) {
                    if (i2 >= Camera.getNumberOfCameras()) {
                        break;
                    }
                    Camera.getCameraInfo(i2, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        break;
                    }
                    i2++;
                }
            } else if (this.O0000o0 == 98) {
                Log.i("CameraRenderer", "Trying to open FRONT camera");
                Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                while (true) {
                    if (i2 >= Camera.getNumberOfCameras()) {
                        break;
                    }
                    Camera.getCameraInfo(i2, cameraInfo2);
                    if (cameraInfo2.facing == 1) {
                        break;
                    }
                    i2++;
                }
            }
            i2 = i3;
            if (i2 == 99) {
                Log.e("CameraRenderer", "Back camera not found!");
            } else if (i2 == 98) {
                Log.e("CameraRenderer", "Front camera not found!");
            } else {
                Log.d("CameraRenderer", "Trying to open camera with new open(" + i2 + ")");
                try {
                    this.f1923O000000o = Camera.open(i2);
                } catch (RuntimeException e3) {
                    Log.e("CameraRenderer", "Camera #" + i2 + "failed to open: " + e3.getLocalizedMessage());
                }
            }
        }
        if (this.f1923O000000o == null) {
            Log.e("CameraRenderer", "Error: can't open camera");
            return;
        }
        Camera.Parameters parameters = this.f1923O000000o.getParameters();
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
        this.f1923O000000o.setParameters(parameters);
        try {
            this.f1923O000000o.setPreviewTexture(this.O0000o0O);
        } catch (IOException e4) {
            Log.e("CameraRenderer", "setPreviewTexture() failed: " + e4.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f6  */
    public final synchronized void O000000o(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        synchronized (this) {
            Log.i("CameraRenderer", "setCameraPreviewSize: " + i3 + "x" + i4);
            if (this.f1923O000000o == null) {
                Log.e("CameraRenderer", "Camera isn't initialized!");
                return;
            }
            if (this.O0000Ooo > 0 && this.O0000Ooo < i3) {
                i3 = this.O0000Ooo;
            }
            if (this.O0000o00 > 0 && this.O0000o00 < i4) {
                i4 = this.O0000o00;
            }
            Camera.Parameters parameters = this.f1923O000000o.getParameters();
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes.size() > 0) {
                float f = ((float) i3) / ((float) i4);
                int i5 = 0;
                int i6 = 0;
                for (Camera.Size next : supportedPreviewSizes) {
                    int i7 = next.width;
                    int i8 = next.height;
                    Log.d("CameraRenderer", "checking camera preview size: " + i7 + "x" + i8);
                    if (i7 <= i3 && i8 <= i4 && i7 >= i5 && i8 >= i6 && ((double) Math.abs(f - (((float) i7) / ((float) i8)))) < 0.2d) {
                        i6 = i8;
                        i5 = i7;
                    }
                }
                if (i5 > 0) {
                    if (i6 > 0) {
                        Log.i("CameraRenderer", "Selected best size: " + i5 + " x " + i6);
                        if (this.O00000Oo) {
                            this.f1923O000000o.stopPreview();
                            this.O00000Oo = false;
                        }
                        this.O0000OOo = i5;
                        this.O0000Oo0 = i6;
                        parameters.setPreviewSize(i5, i6);
                    }
                }
                i5 = supportedPreviewSizes.get(0).width;
                i6 = supportedPreviewSizes.get(0).height;
                Log.e("CameraRenderer", "Error: best size was not selected, using " + i5 + " x " + i6);
                if (this.O00000Oo) {
                }
                this.O0000OOo = i5;
                this.O0000Oo0 = i6;
                parameters.setPreviewSize(i5, i6);
            }
            parameters.set("orientation", "landscape");
            this.f1923O000000o.setParameters(parameters);
            this.f1923O000000o.startPreview();
            this.O00000Oo = true;
        }
    }
}
