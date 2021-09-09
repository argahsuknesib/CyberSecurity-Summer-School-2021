package _m_j;

import _m_j.etc;
import _m_j.etg;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.xiaomi.qrcode.camera.SingleCamera;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class ete extends etc {
    public String O0000OoO;
    public CameraDevice O0000Ooo;
    public Handler O0000o;
    public CameraCaptureSession O0000o0;
    public CameraManager O0000o00;
    public CaptureRequest.Builder O0000o0O;
    CameraDevice.StateCallback O0000o0o;
    private CameraCaptureSession.StateCallback O0000oO;
    public Semaphore O0000oO0;
    private ImageReader O0000oOO;
    private List<Surface> O0000oOo = new ArrayList();
    private ImageReader.OnImageAvailableListener O0000oo = new ImageReader.OnImageAvailableListener() {
        /* class _m_j.$$Lambda$ete$hJIpTVjWuKB03tkom0_U0JBa3GA */

        public final void onImageAvailable(ImageReader imageReader) {
            ete.this.O000000o(imageReader);
        }
    };
    private HandlerThread O0000oo0;

    public final boolean O000000o() {
        return true;
    }

    public ete(etg.O000000o o000000o) {
        this.f15789O000000o = o000000o;
        this.O0000Oo0 = new Handler(this);
        this.O0000oo0 = new HandlerThread("CameraAPI2Scanner");
        this.O0000oo0.start();
        this.O0000o = new Handler(this.O0000oo0.getLooper(), null);
        this.O0000oO0 = SingleCamera.getInstance();
        this.O0000Oo = true;
    }

    public final void O000000o(Context context) {
        final Context applicationContext = context.getApplicationContext();
        WindowManager windowManager = (WindowManager) applicationContext.getSystemService("window");
        if (windowManager != null) {
            this.O00000oO = windowManager.getDefaultDisplay().getRotation();
        }
        LogType logType = LogType.CAMERA;
        gsy.O000000o(logType, "CameraAPI2Scanner", getClass().getName() + ".takeOrientation() mOrientation = " + this.O00000oO);
        this.O0000o.post(new Runnable() {
            /* class _m_j.ete.AnonymousClass1 */

            public final void run() {
                if (ContextCompat.O000000o(applicationContext, "android.permission.CAMERA") == 0) {
                    if (ete.this.O0000o00 == null) {
                        ete.this.O0000o00 = (CameraManager) applicationContext.getSystemService("camera");
                    }
                    try {
                        if (ete.this.O0000oO0.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                            Size[] outputSizes = ete.this.O0000O0o().getOutputSizes(SurfaceTexture.class);
                            ete.this.O000000o(outputSizes, ete.this.O0000O0o.f15790O000000o, ete.this.O0000O0o.O00000Oo);
                            ete.this.O000000o(outputSizes);
                            CameraManager cameraManager = ete.this.O0000o00;
                            String str = ete.this.O0000OoO;
                            ete ete = ete.this;
                            if (ete.O0000o0o == null) {
                                ete.O0000o0o = new CameraDevice.StateCallback() {
                                    /* class _m_j.ete.AnonymousClass2 */

                                    public final void onOpened(CameraDevice cameraDevice) {
                                        LogType logType = LogType.CAMERA;
                                        gsy.O000000o(logType, "CameraAPI2Scanner", getClass().getName() + ".onOpened()");
                                        ete ete = ete.this;
                                        ete.O0000Ooo = cameraDevice;
                                        ete.O0000OOo();
                                    }

                                    public final void onDisconnected(CameraDevice cameraDevice) {
                                        LogType logType = LogType.CAMERA;
                                        gsy.O000000o(logType, "CameraAPI2Scanner", getClass().getName() + ".onDisconnected()");
                                        ete.this.O0000oO0.release();
                                        if (ete.this.O0000Oo0 != null) {
                                            ete.this.O0000Oo0.sendMessage(ete.this.O0000Oo0.obtainMessage(80005));
                                        }
                                    }

                                    public final void onError(CameraDevice cameraDevice, int i) {
                                        LogType logType = LogType.CAMERA;
                                        gsy.O000000o(logType, "CameraAPI2Scanner", getClass().getName() + ".onError() error = " + i);
                                        ete.this.O0000oO0.release();
                                        if (ete.this.O0000Oo0 != null) {
                                            ete.this.O0000Oo0.sendMessage(ete.this.O0000Oo0.obtainMessage(80001));
                                        }
                                    }
                                };
                            }
                            cameraManager.openCamera(str, ete.O0000o0o, ete.this.O0000o);
                            return;
                        }
                        throw new RuntimeException("Time out waiting to lock camera opening.");
                    } catch (Exception e) {
                        LogType logType = LogType.CAMERA;
                        gsy.O000000o(logType, "CameraAPI2Scanner", getClass().getName() + ".openCamera() : " + e);
                        if (ete.this.O0000Oo0 != null) {
                            ete.this.O0000Oo0.sendMessage(ete.this.O0000Oo0.obtainMessage(80001));
                        }
                    }
                } else if (ete.this.O0000Oo0 != null) {
                    ete.this.O0000Oo0.sendMessage(ete.this.O0000Oo0.obtainMessage(80006));
                }
            }
        });
    }

    public final void O00000Oo() {
        LogType logType = LogType.CAMERA;
        gsy.O000000o(logType, "CameraAPI2Scanner", getClass().getName() + ".closeCamera()");
        try {
            this.O0000oO0.acquire();
            if (this.O0000o0 != null) {
                this.O0000o0.close();
                this.O0000o0 = null;
            }
            if (this.O0000Ooo != null) {
                this.O0000Ooo.close();
                this.O0000Ooo = null;
            }
            for (Surface release : this.O0000oOo) {
                release.release();
            }
            this.O0000oOo.clear();
            this.O0000o0O = null;
            this.O0000o0 = null;
            this.O0000oO0.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public final void O00000o0() {
        try {
            this.O0000oO0.acquire();
            try {
                if (!(this.O0000o0 == null || this.O0000o0O == null)) {
                    this.O0000o0O.set(CaptureRequest.CONTROL_AE_MODE, 1);
                    this.O0000o0O.set(CaptureRequest.FLASH_MODE, 2);
                    this.O0000o0.setRepeatingRequest(this.O0000o0O.build(), null, this.O0000o);
                }
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
            this.O0000oO0.release();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public final void O00000o() {
        try {
            this.O0000oO0.acquire();
            try {
                if (!(this.O0000o0 == null || this.O0000o0O == null)) {
                    this.O0000o0O.set(CaptureRequest.CONTROL_AE_MODE, 1);
                    this.O0000o0O.set(CaptureRequest.FLASH_MODE, 0);
                    this.O0000o0.setRepeatingRequest(this.O0000o0O.build(), null, this.O0000o);
                }
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
            this.O0000oO0.release();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public final boolean O00000oO() {
        CaptureRequest.Builder builder;
        if (!(this.O0000o0 == null || (builder = this.O0000o0O) == null)) {
            builder.get(CaptureRequest.FLASH_MODE);
            Integer num = (Integer) this.O0000o0O.get(CaptureRequest.FLASH_MODE);
            if (num == null || num.intValue() == 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final void O00000oo() {
        LogType logType = LogType.CAMERA;
        gsy.O000000o(logType, "CameraAPI2Scanner", getClass().getName() + ".detach()");
        O00000Oo();
        if (this.O0000Oo0 != null) {
            this.O0000Oo0.removeCallbacksAndMessages(null);
            this.O0000Oo0 = null;
        }
        Handler handler = this.O0000o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.O0000o = null;
        }
        HandlerThread handlerThread = this.O0000oo0;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        if (this.O00000o != null) {
            this.O00000o.release();
            this.O00000o = null;
        }
    }

    public final StreamConfigurationMap O0000O0o() throws NullPointerException, CameraAccessException {
        String[] cameraIdList = this.O0000o00.getCameraIdList();
        int length = cameraIdList.length;
        int i = 0;
        while (i < length) {
            String str = cameraIdList[i];
            CameraCharacteristics cameraCharacteristics = this.O0000o00.getCameraCharacteristics(str);
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            if (num == null || num.intValue() != 1) {
                i++;
            } else {
                this.O0000OoO = str;
                return (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            }
        }
        throw new NullPointerException("No Back Camera Stream Configuration Map found!");
    }

    public final void O000000o(Size[] sizeArr, int i, int i2) {
        Size size;
        if (this.O00000oO == 0 || this.O00000oO == 2) {
            size = etf.O000000o(sizeArr, i2, i);
        } else {
            size = etf.O000000o(sizeArr, i, i2);
        }
        this.O00000oo = new etc.O000000o(size.getWidth(), size.getHeight());
        this.O00000o.setDefaultBufferSize(this.O00000oo.f15790O000000o, this.O00000oo.O00000Oo);
        LogType logType = LogType.CAMERA;
        gsy.O000000o(logType, "CameraAPI2Scanner", getClass().getName() + ".initSurfaceSize() mSurfaceSize = " + this.O00000oo.toString());
    }

    public final void O000000o(Size[] sizeArr) {
        Size size;
        Size[] sizeArr2 = sizeArr;
        ImageReader imageReader = this.O0000oOO;
        if (imageReader == null || imageReader.getSurface() == null || !this.O0000oOO.getSurface().isValid()) {
            long j = (long) (this.O00000oo.f15790O000000o * this.O00000oo.O00000Oo * 2);
            etc.O000000o o000000o = this.O00000oo;
            Long valueOf = Long.valueOf(j);
            Size size2 = sizeArr2[0];
            boolean z = o000000o != null && o000000o.O00000Oo * size2.getWidth() == o000000o.f15790O000000o * size2.getHeight();
            Size size3 = size2;
            for (int i = 1; i < sizeArr2.length; i++) {
                Size size4 = sizeArr2[i];
                boolean z2 = o000000o != null && o000000o.O00000Oo * size4.getWidth() == o000000o.f15790O000000o * size4.getHeight();
                if (z || !z2) {
                    if (z2 ^ (!z)) {
                        long width = ((long) size3.getWidth()) * ((long) size3.getHeight());
                        size = size3;
                        long width2 = ((long) size4.getWidth()) * ((long) size4.getHeight());
                        boolean z3 = width > width2;
                        if (valueOf == null ? !z3 : !((!z3 || width <= valueOf.longValue()) && (z3 || width2 > valueOf.longValue()))) {
                            size3 = size4;
                        }
                    } else {
                        size = size3;
                    }
                    size3 = size;
                } else {
                    size3 = size4;
                    z = true;
                }
            }
            this.O0000oo0 = new HandlerThread("CameraBackground");
            this.O0000oo0.start();
            this.O0000oOO = ImageReader.newInstance(this.O0000O0o.f15790O000000o, this.O0000O0o.O00000Oo, 35, 2);
            this.O0000oOO.setOnImageAvailableListener(this.O0000oo, this.O0000o);
            LogType logType = LogType.CAMERA;
            gsy.O000000o(logType, "CameraAPI2Scanner", getClass().getName() + ".initTextureReader() mTextureReader = " + size3.toString());
        }
    }

    public final void O0000OOo() {
        try {
            this.O0000o0O = this.O0000Ooo.createCaptureRequest(1);
            this.O0000oOo.clear();
            Surface surface = new Surface(this.O00000o);
            this.O0000oOo.add(surface);
            this.O0000oOo.add(this.O0000oOO.getSurface());
            this.O0000o0O.addTarget(surface);
            this.O0000o0O.addTarget(this.O0000oOO.getSurface());
            CameraDevice cameraDevice = this.O0000Ooo;
            List<Surface> list = this.O0000oOo;
            if (this.O0000oO == null) {
                this.O0000oO = new CameraCaptureSession.StateCallback() {
                    /* class _m_j.ete.AnonymousClass3 */

                    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
                        LogType logType = LogType.CAMERA;
                        gsy.O000000o(logType, "CameraAPI2Scanner", getClass().getName() + ".onConfigured()");
                        ete ete = ete.this;
                        ete.O0000o0 = cameraCaptureSession;
                        try {
                            ete.O0000o0O.set(CaptureRequest.CONTROL_AF_MODE, 4);
                            ete.this.O0000o0O.set(CaptureRequest.CONTROL_AE_MODE, 1);
                            ete.this.O0000o0.setRepeatingRequest(ete.this.O0000o0O.build(), null, ete.this.O0000o);
                            if (ete.this.O0000Oo0 != null) {
                                ete.this.O0000Oo0.sendMessage(ete.this.O0000Oo0.obtainMessage(70001));
                            }
                        } catch (CameraAccessException e) {
                            LogType logType2 = LogType.CAMERA;
                            gsy.O000000o(logType2, "CameraAPI2Scanner", getClass().getName() + ".onConfigured() : " + e);
                            if (ete.this.O0000Oo0 != null) {
                                ete.this.O0000Oo0.sendMessage(ete.this.O0000Oo0.obtainMessage(80003));
                            }
                        }
                        if (ete.this.O0000oO0.availablePermits() <= 0) {
                            ete.this.O0000oO0.release();
                        }
                    }

                    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                        LogType logType = LogType.CAMERA;
                        gsy.O000000o(logType, "CameraAPI2Scanner", getClass().getName() + ".onConfigureFailed()");
                        if (ete.this.O0000oO0.availablePermits() <= 0) {
                            ete.this.O0000oO0.release();
                        }
                        if (ete.this.O0000Oo0 != null) {
                            ete.this.O0000Oo0.sendMessage(ete.this.O0000Oo0.obtainMessage(80003));
                        }
                    }
                };
            }
            cameraDevice.createCaptureSession(list, this.O0000oO, this.O0000o);
        } catch (Exception e) {
            if (this.O0000oO0.availablePermits() <= 0) {
                this.O0000oO0.release();
            }
            LogType logType = LogType.CAMERA;
            gsy.O000000o(logType, "CameraAPI2Scanner", getClass().getName() + ".createCaptureSession() : " + e);
            if (this.O0000Oo0 != null) {
                this.O0000Oo0.sendMessage(this.O0000Oo0.obtainMessage(80004));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(ImageReader imageReader) {
        Image acquireLatestImage = imageReader.acquireLatestImage();
        if (acquireLatestImage != null) {
            O000000o(O000000o(acquireLatestImage), acquireLatestImage.getWidth(), acquireLatestImage.getHeight());
            acquireLatestImage.close();
        }
    }

    private static byte[] O000000o(Image image) {
        byte[] bArr = null;
        if (image != null) {
            try {
                if (image.getPlanes() != null) {
                    if (image.getPlanes().length != 0) {
                        Image.Plane[] planes = image.getPlanes();
                        int remaining = planes[0].getBuffer().remaining();
                        int remaining2 = planes[2].getBuffer().remaining();
                        int width = image.getWidth();
                        int height = image.getHeight();
                        byte[] bArr2 = new byte[remaining];
                        byte[] bArr3 = new byte[remaining2];
                        bArr = new byte[(((width * height) * 3) / 2)];
                        planes[0].getBuffer().get(bArr2);
                        planes[2].getBuffer().get(bArr3);
                        for (int i = 0; i < height; i++) {
                            System.arraycopy(bArr2, planes[0].getRowStride() * i, bArr, width * i, width);
                            if (i <= image.getHeight() / 2) {
                                int i2 = (height + i) * width;
                                if (i2 + width < bArr.length) {
                                    System.arraycopy(bArr3, planes[2].getRowStride() * i, bArr, i2, width);
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return bArr;
    }
}
