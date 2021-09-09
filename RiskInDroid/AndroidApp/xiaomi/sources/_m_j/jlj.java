package _m_j;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.opencv.android.CameraGLSurfaceView;

@TargetApi(21)
public final class jlj extends jlk {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final String f1919O000000o = "Camera2Renderer";
    public CameraDevice O00000Oo;
    public CaptureRequest.Builder O00000o;
    public CameraCaptureSession O00000o0;
    public Handler O00000oO;
    public Semaphore O00000oo = new Semaphore(1);
    private Size O0000oo = new Size(-1, -1);
    private String O0000oo0;
    private HandlerThread O0000ooO;
    private final CameraDevice.StateCallback O0000ooo = new CameraDevice.StateCallback() {
        /* class _m_j.jlj.AnonymousClass1 */

        public final void onOpened(CameraDevice cameraDevice) {
            jlj jlj = jlj.this;
            jlj.O00000Oo = cameraDevice;
            jlj.O00000oo.release();
            jlj.this.O00000o();
        }

        public final void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            jlj jlj = jlj.this;
            jlj.O00000Oo = null;
            jlj.O00000oo.release();
        }

        public final void onError(CameraDevice cameraDevice, int i) {
            cameraDevice.close();
            jlj jlj = jlj.this;
            jlj.O00000Oo = null;
            jlj.O00000oo.release();
        }
    };

    public jlj(CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        Log.d("Camera2Renderer", "doStart");
        Log.i("Camera2Renderer", "startBackgroundThread");
        O0000O0o();
        this.O0000ooO = new HandlerThread("CameraBackground");
        this.O0000ooO.start();
        this.O00000oO = new Handler(this.O0000ooO.getLooper());
        super.O000000o();
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        Log.d("Camera2Renderer", "doStop");
        super.O00000Oo();
        O0000O0o();
    }

    private boolean O00000Oo(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        Log.i("Camera2Renderer", "cacPreviewSize: " + i3 + "x" + i4);
        if (this.O0000oo0 == null) {
            Log.e("Camera2Renderer", "Camera isn't initialized!");
            return false;
        }
        try {
            float f = ((float) i3) / ((float) i4);
            int i5 = 0;
            int i6 = 0;
            for (Size size : ((StreamConfigurationMap) ((CameraManager) this.O0000oOo.getContext().getSystemService("camera")).getCameraCharacteristics(this.O0000oo0).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(SurfaceTexture.class)) {
                int width = size.getWidth();
                int height = size.getHeight();
                Log.d("Camera2Renderer", "trying size: " + width + "x" + height);
                if (i3 >= width && i4 >= height && i5 <= width && i6 <= height && ((double) Math.abs(f - (((float) width) / ((float) height)))) < 0.2d) {
                    i6 = height;
                    i5 = width;
                }
            }
            Log.i("Camera2Renderer", "best size: " + i5 + "x" + i6);
            if (!(i5 == 0 || i6 == 0)) {
                if (this.O0000oo.getWidth() != i5 || this.O0000oo.getHeight() != i6) {
                    this.O0000oo = new Size(i5, i6);
                    return true;
                }
            }
            return false;
        } catch (CameraAccessException unused) {
            Log.e("Camera2Renderer", "cacPreviewSize - Camera Access Exception");
            return false;
        } catch (IllegalArgumentException unused2) {
            Log.e("Camera2Renderer", "cacPreviewSize - Illegal Argument Exception");
            return false;
        } catch (SecurityException unused3) {
            Log.e("Camera2Renderer", "cacPreviewSize - Security Exception");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        r9.O0000oo0 = r5;
     */
    public final void O000000o(int i) {
        Log.i("Camera2Renderer", "openCamera");
        CameraManager cameraManager = (CameraManager) this.O0000oOo.getContext().getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length == 0) {
                Log.e("Camera2Renderer", "Error: camera isn't detected.");
                return;
            }
            int i2 = 0;
            if (i != -1) {
                int length = cameraIdList.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    String str = cameraIdList[i2];
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    if (!((i == 99 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) || (i == 98 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0))) {
                        i2++;
                    }
                }
            } else {
                this.O0000oo0 = cameraIdList[0];
            }
            if (this.O0000oo0 == null) {
                return;
            }
            if (this.O00000oo.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                Log.i("Camera2Renderer", "Opening camera: " + this.O0000oo0);
                cameraManager.openCamera(this.O0000oo0, this.O0000ooo, this.O00000oO);
                return;
            }
            throw new RuntimeException("Time out waiting to lock camera opening.");
        } catch (CameraAccessException unused) {
            Log.e("Camera2Renderer", "OpenCamera - Camera Access Exception");
        } catch (IllegalArgumentException unused2) {
            Log.e("Camera2Renderer", "OpenCamera - Illegal Argument Exception");
        } catch (SecurityException unused3) {
            Log.e("Camera2Renderer", "OpenCamera - Security Exception");
        } catch (InterruptedException unused4) {
            Log.e("Camera2Renderer", "OpenCamera - Interrupted Exception");
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o0() {
        Log.i("Camera2Renderer", "closeCamera");
        try {
            this.O00000oo.acquire();
            if (this.O00000o0 != null) {
                this.O00000o0.close();
                this.O00000o0 = null;
            }
            if (this.O00000Oo != null) {
                this.O00000Oo.close();
                this.O00000Oo = null;
            }
            this.O00000oo.release();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while trying to lock camera closing.", e);
        } catch (Throwable th) {
            this.O00000oo.release();
            throw th;
        }
    }

    public final void O00000o() {
        int width = this.O0000oo.getWidth();
        int height = this.O0000oo.getHeight();
        Log.i("Camera2Renderer", "createCameraPreviewSession(" + width + "x" + height + ")");
        if (width >= 0 && height >= 0) {
            try {
                this.O00000oo.acquire();
                if (this.O00000Oo == null) {
                    this.O00000oo.release();
                    Log.e("Camera2Renderer", "createCameraPreviewSession: camera isn't opened");
                } else if (this.O00000o0 != null) {
                    this.O00000oo.release();
                    Log.e("Camera2Renderer", "createCameraPreviewSession: mCaptureSession is already started");
                } else if (this.O0000o0O == null) {
                    this.O00000oo.release();
                    Log.e("Camera2Renderer", "createCameraPreviewSession: preview SurfaceTexture is null");
                } else {
                    this.O0000o0O.setDefaultBufferSize(width, height);
                    Surface surface = new Surface(this.O0000o0O);
                    this.O00000o = this.O00000Oo.createCaptureRequest(1);
                    this.O00000o.addTarget(surface);
                    this.O00000Oo.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() {
                        /* class _m_j.jlj.AnonymousClass2 */

                        public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
                            jlj jlj = jlj.this;
                            jlj.O00000o0 = cameraCaptureSession;
                            try {
                                jlj.O00000o.set(CaptureRequest.CONTROL_AF_MODE, 4);
                                jlj.this.O00000o.set(CaptureRequest.CONTROL_AE_MODE, 2);
                                jlj.this.O00000o0.setRepeatingRequest(jlj.this.O00000o.build(), null, jlj.this.O00000oO);
                                Log.i("Camera2Renderer", "CameraPreviewSession has been started");
                            } catch (CameraAccessException unused) {
                                Log.e("Camera2Renderer", "createCaptureSession failed");
                            }
                            jlj.this.O00000oo.release();
                        }

                        public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                            Log.e("Camera2Renderer", "createCameraPreviewSession failed");
                            jlj.this.O00000oo.release();
                        }
                    }, this.O00000oO);
                }
            } catch (CameraAccessException unused) {
                Log.e("Camera2Renderer", "createCameraPreviewSession");
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted while createCameraPreviewSession", e);
            }
        }
    }

    private void O0000O0o() {
        Log.i("Camera2Renderer", "stopBackgroundThread");
        HandlerThread handlerThread = this.O0000ooO;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.O0000ooO.join();
                this.O0000ooO = null;
                this.O00000oO = null;
            } catch (InterruptedException unused) {
                Log.e("Camera2Renderer", "stopBackgroundThread");
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jlj.O00000Oo(int, int):boolean
     arg types: [int, int]
     candidates:
      _m_j.jlk.O00000Oo(int, int):void
      _m_j.jlj.O00000Oo(int, int):boolean */
    /* access modifiers changed from: protected */
    public final void O000000o(int i, int i2) {
        Log.i("Camera2Renderer", "setCameraPreviewSize(" + i + "x" + i2 + ")");
        if (this.O0000Ooo > 0 && this.O0000Ooo < i) {
            i = this.O0000Ooo;
        }
        if (this.O0000o00 > 0 && this.O0000o00 < i2) {
            i2 = this.O0000o00;
        }
        try {
            this.O00000oo.acquire();
            boolean O00000Oo2 = O00000Oo(i, i2);
            this.O0000OOo = this.O0000oo.getWidth();
            this.O0000Oo0 = this.O0000oo.getHeight();
            if (!O00000Oo2) {
                this.O00000oo.release();
                return;
            }
            if (this.O00000o0 != null) {
                Log.d("Camera2Renderer", "closing existing previewSession");
                this.O00000o0.close();
                this.O00000o0 = null;
            }
            this.O00000oo.release();
            O00000o();
        } catch (InterruptedException e) {
            this.O00000oo.release();
            throw new RuntimeException("Interrupted while setCameraPreviewSize.", e);
        }
    }
}
