package in.cashify.otex.widget;

import _m_j.O0O00o0;
import a.a.a.b;
import a.a.a.e.c.d;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.widget.CameraPreview;
import in.cashify.otex.widget.CircleRoadProgress;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class DiagnoseCameraHeaderView extends DiagnoseHeaderView implements Camera.PictureCallback, CameraPreview.O000000o, CircleRoadProgress.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    public CameraPreview f12278O000000o;
    public Handler O00000Oo;
    public HandlerThread O00000o;
    public final Semaphore O00000o0 = new Semaphore(1);
    public Camera.CameraInfo O00000oO;
    public int O00000oo;
    public Camera.Size O0000O0o;
    public Camera O0000OOo;
    public b O0000Oo;
    public d O0000Oo0;
    public O0O00o0.O00000o0 O0000OoO;

    public class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ Camera f12280O000000o;

        public O00000Oo(Camera camera) {
            this.f12280O000000o = camera;
        }

        public final void run() {
            try {
                this.f12280O000000o.takePicture(null, null, DiagnoseCameraHeaderView.this);
            } catch (Exception unused) {
            }
        }
    }

    public DiagnoseCameraHeaderView(Context context) {
        super(context);
    }

    public DiagnoseCameraHeaderView(Context context, byte b) {
        super(context, R.layout.layout_diagnose_header_camera);
    }

    public final void O000000o() {
        if (this.O0000OOo == null) {
            O00000Oo();
        }
    }

    public final void O000000o(Context context, int i) {
        super.O000000o(context, i);
        this.f12278O000000o = (CameraPreview) this.O0000Ooo.findViewById(R.id.cameraPreview);
    }

    public final void O000000o(Camera camera, long j) {
        if (camera != null && this.O00000o.isAlive()) {
            this.O00000Oo.postDelayed(new O00000Oo(camera), j);
        }
    }

    public final void O00000Oo() {
        Handler handler = this.O00000Oo;
        if (handler != null) {
            handler.post(new O000000o());
        }
    }

    public final void O00000o0() {
        this.O00000o = new HandlerThread("CameraBackground");
        this.O00000o.start();
        this.O00000Oo = new Handler(this.O00000o.getLooper());
    }

    public final void O00000oO() {
    }

    public void setPictureTakenCallBack(O0O00o0.O00000o0 o00000o0) {
        this.O0000OoO = o00000o0;
    }

    public void setmCameraContext(d dVar) {
        this.O0000Oo0 = dVar;
    }

    public class O000000o implements Runnable {
        public O000000o() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[Catch:{ Exception -> 0x0133, all -> 0x0128 }] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0072 A[Catch:{ Exception -> 0x0133, all -> 0x0128 }] */
        public final void run() {
            int i;
            try {
                if (DiagnoseCameraHeaderView.this.O00000o0.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                    Camera unused = DiagnoseCameraHeaderView.this.O0000OOo = Camera.open(DiagnoseCameraHeaderView.O00000Oo(DiagnoseCameraHeaderView.this));
                    if (DiagnoseCameraHeaderView.this.O0000OOo != null) {
                        Camera.Parameters parameters = DiagnoseCameraHeaderView.this.O0000OOo.getParameters();
                        if (DiagnoseCameraHeaderView.O00000o(DiagnoseCameraHeaderView.this)) {
                            parameters.setFlashMode("auto");
                        }
                        if (DiagnoseCameraHeaderView.this.f12278O000000o != null) {
                            DiagnoseCameraHeaderView diagnoseCameraHeaderView = DiagnoseCameraHeaderView.this;
                            Camera.CameraInfo O00000oO = DiagnoseCameraHeaderView.this.O00000oO;
                            int i2 = diagnoseCameraHeaderView.O00000oo;
                            if (i2 != 0) {
                                if (i2 == 1) {
                                    i = 90;
                                } else if (i2 == 2) {
                                    i = 180;
                                } else if (i2 == 3) {
                                    i = 270;
                                }
                                int i3 = O00000oO.facing != 1 ? (360 - ((O00000oO.orientation + i) % 360)) % 360 : ((O00000oO.orientation - i) + 360) % 360;
                                DiagnoseCameraHeaderView.this.O0000OOo.setDisplayOrientation(i3);
                                parameters.setRotation(i3);
                            }
                            i = 0;
                            if (O00000oO.facing != 1) {
                            }
                            DiagnoseCameraHeaderView.this.O0000OOo.setDisplayOrientation(i3);
                            parameters.setRotation(i3);
                        }
                        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
                        if (supportedPictureSizes != null && supportedPictureSizes.size() > 0) {
                            Camera.Size unused2 = DiagnoseCameraHeaderView.this.O0000O0o = supportedPictureSizes.get(0);
                            int i4 = DiagnoseCameraHeaderView.this.O0000O0o.width;
                            for (Camera.Size next : supportedPictureSizes) {
                                if (next.width < i4) {
                                    i4 = DiagnoseCameraHeaderView.this.O0000O0o.width;
                                    Camera.Size unused3 = DiagnoseCameraHeaderView.this.O0000O0o = next;
                                }
                            }
                            parameters.setPictureSize(DiagnoseCameraHeaderView.this.O0000O0o.width, DiagnoseCameraHeaderView.this.O0000O0o.height);
                            DiagnoseCameraHeaderView.this.O0000OOo.setParameters(parameters);
                            DiagnoseCameraHeaderView.this.f12278O000000o.setPreviewSize(DiagnoseCameraHeaderView.this.O0000O0o);
                        }
                        CameraPreview cameraPreview = DiagnoseCameraHeaderView.this.f12278O000000o;
                        Camera O00000o0 = DiagnoseCameraHeaderView.this.O0000OOo;
                        if (cameraPreview.O00000Oo != O00000o0) {
                            cameraPreview.O000000o();
                            cameraPreview.O00000Oo = O00000o0;
                            Camera camera = cameraPreview.O00000Oo;
                            if (camera != null) {
                                camera.setPreviewDisplay(cameraPreview.getHolder());
                                cameraPreview.O00000Oo.startPreview();
                            }
                        }
                        DiagnoseCameraHeaderView.this.O000000o(DiagnoseCameraHeaderView.this.O0000OOo, 1000);
                    }
                    DiagnoseCameraHeaderView.this.O00000o0.release();
                    return;
                }
                throw new RuntimeException("Time out waiting to lock camera opening.");
            } catch (Exception unused4) {
            } catch (Throwable th) {
                DiagnoseCameraHeaderView.this.O00000o0.release();
                throw th;
            }
        }
    }

    private int getCameraFacing() {
        return this.O0000Oo0.O0000Oo0.equals(ExchangeManager.h.FRONT_CAMERA.a()) ? 1 : 0;
    }

    public static /* synthetic */ int O00000Oo(DiagnoseCameraHeaderView diagnoseCameraHeaderView) {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == diagnoseCameraHeaderView.getCameraFacing()) {
                diagnoseCameraHeaderView.O00000oO = cameraInfo;
                return i;
            }
        }
        return -1;
    }

    public static /* synthetic */ boolean O00000o(DiagnoseCameraHeaderView diagnoseCameraHeaderView) {
        List<String> supportedFlashModes = diagnoseCameraHeaderView.O0000OOo.getParameters().getSupportedFlashModes();
        if (supportedFlashModes == null) {
            return false;
        }
        for (String equals : supportedFlashModes) {
            if ("on".equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public void onPictureTaken(byte[] bArr, Camera camera) {
        byte[] bArr2 = bArr;
        double d = this.O0000Oo0.f2612O000000o;
        boolean z = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length, new BitmapFactory.Options());
        int width = decodeByteArray.getWidth();
        int height = decodeByteArray.getHeight();
        Random random = new Random();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < height) {
            int i4 = i3;
            int i5 = i2;
            for (int i6 = 0; i6 < width; i6 += random.nextInt(10) + 5) {
                int pixel = decodeByteArray.getPixel(i6, i);
                int i7 = (pixel >> 16) & 255;
                int i8 = (pixel >> 8) & 255;
                int i9 = pixel & 255;
                if (Math.sqrt((double) ((i7 * i7) + (i9 * i9) + (i8 * i8))) > d) {
                    i4++;
                }
                i5++;
            }
            i += random.nextInt(10) + 5;
            i2 = i5;
            i3 = i4;
        }
        float f = 0.0f;
        if (i2 > 0) {
            f = ((float) i3) / ((float) i2);
        }
        int i10 = (int) (f * 100.0f);
        if (i10 > this.O0000Oo0.O00000Oo) {
            z = true;
        }
        if (z) {
            this.O0000Oo = new b(getRequestKey(), Integer.valueOf(i10), true);
            O0O00o0.O00000o0 o00000o0 = this.O0000OoO;
            if (o00000o0 != null) {
                o00000o0.O000000o(this.O0000Oo);
                return;
            }
            return;
        }
        try {
            camera.startPreview();
            O000000o(camera, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getRequestKey() {
        return this.O0000Oo0.O0000Oo0.equals(ExchangeManager.h.FRONT_CAMERA.a()) ? "cf" : "cb";
    }
}
