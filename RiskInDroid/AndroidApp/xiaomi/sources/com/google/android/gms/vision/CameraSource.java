package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.vision.Frame;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CameraSource {
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public final Object zzd;
    /* access modifiers changed from: private */
    public Camera zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;
    /* access modifiers changed from: private */
    public Size zzh;
    /* access modifiers changed from: private */
    public float zzi;
    /* access modifiers changed from: private */
    public int zzj;
    /* access modifiers changed from: private */
    public int zzk;
    /* access modifiers changed from: private */
    public boolean zzl;
    private SurfaceTexture zzm;
    private boolean zzn;
    private Thread zzo;
    /* access modifiers changed from: private */
    public zzb zzp;
    /* access modifiers changed from: private */
    public Map<byte[], ByteBuffer> zzq;

    public static class Builder {
        private final Detector<?> zzr;
        private CameraSource zzs = new CameraSource();

        public Builder(Context context, Detector<?> detector) {
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            } else if (detector != null) {
                this.zzr = detector;
                Context unused = this.zzs.mContext = context;
            } else {
                throw new IllegalArgumentException("No detector supplied.");
            }
        }

        public CameraSource build() {
            CameraSource cameraSource = this.zzs;
            cameraSource.getClass();
            zzb unused = cameraSource.zzp = new zzb(this.zzr);
            return this.zzs;
        }

        public Builder setAutoFocusEnabled(boolean z) {
            boolean unused = this.zzs.zzl = z;
            return this;
        }

        public Builder setFacing(int i) {
            if (i == 0 || i == 1) {
                int unused = this.zzs.zzf = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(27);
            sb.append("Invalid camera: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setRequestedFps(float f) {
            if (f > 0.0f) {
                float unused = this.zzs.zzi = f;
                return this;
            }
            StringBuilder sb = new StringBuilder(28);
            sb.append("Invalid fps: ");
            sb.append(f);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setRequestedPreviewSize(int i, int i2) {
            if (i <= 0 || i > 1000000 || i2 <= 0 || i2 > 1000000) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Invalid preview size: ");
                sb.append(i);
                sb.append("x");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
            int unused = this.zzs.zzj = i;
            int unused2 = this.zzs.zzk = i2;
            return this;
        }
    }

    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    class zza implements Camera.PreviewCallback {
        private zza() {
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraSource.this.zzp.zza(bArr, camera);
        }
    }

    class zzb implements Runnable {
        private boolean mActive = true;
        private final Object mLock = new Object();
        private Detector<?> zzr;
        private long zzu = SystemClock.elapsedRealtime();
        private long zzv;
        private int zzw = 0;
        private ByteBuffer zzx;

        zzb(Detector<?> detector) {
            this.zzr = detector;
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"Assert"})
        public final void release() {
            this.zzr.release();
            this.zzr = null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r6.zzr.receiveFrame(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0075, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0077, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            android.util.Log.e("CameraSource", "Exception thrown from receiver.", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x008e, code lost:
            com.google.android.gms.vision.CameraSource.zzb(r6.zzt).addCallbackBuffer(r2.array());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x009b, code lost:
            throw r0;
         */
        @SuppressLint({"InlinedApi"})
        public final void run() {
            while (true) {
                synchronized (this.mLock) {
                    while (this.mActive && this.zzx == null) {
                        try {
                            this.mLock.wait();
                        } catch (InterruptedException e) {
                            Log.d("CameraSource", "Frame processing loop terminated.", e);
                            return;
                        }
                    }
                    if (this.mActive) {
                        Frame build = new Frame.Builder().setImageData(this.zzx, CameraSource.this.zzh.getWidth(), CameraSource.this.zzh.getHeight(), 17).setId(this.zzw).setTimestampMillis(this.zzv).setRotation(CameraSource.this.zzg).build();
                        ByteBuffer byteBuffer = this.zzx;
                        this.zzx = null;
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void setActive(boolean z) {
            synchronized (this.mLock) {
                this.mActive = z;
                this.mLock.notifyAll();
            }
        }

        /* access modifiers changed from: package-private */
        public final void zza(byte[] bArr, Camera camera) {
            synchronized (this.mLock) {
                if (this.zzx != null) {
                    camera.addCallbackBuffer(this.zzx.array());
                    this.zzx = null;
                }
                if (!CameraSource.this.zzq.containsKey(bArr)) {
                    Log.d("CameraSource", "Skipping frame. Could not find ByteBuffer associated with the image data from the camera.");
                    return;
                }
                this.zzv = SystemClock.elapsedRealtime() - this.zzu;
                this.zzw++;
                this.zzx = (ByteBuffer) CameraSource.this.zzq.get(bArr);
                this.mLock.notifyAll();
            }
        }
    }

    class zzc implements Camera.PictureCallback {
        /* access modifiers changed from: private */
        public PictureCallback zzy;

        private zzc() {
        }

        public final void onPictureTaken(byte[] bArr, Camera camera) {
            PictureCallback pictureCallback = this.zzy;
            if (pictureCallback != null) {
                pictureCallback.onPictureTaken(bArr);
            }
            synchronized (CameraSource.this.zzd) {
                if (CameraSource.this.zze != null) {
                    CameraSource.this.zze.startPreview();
                }
            }
        }
    }

    static class zzd implements Camera.ShutterCallback {
        /* access modifiers changed from: private */
        public ShutterCallback zzz;

        private zzd() {
        }

        public final void onShutter() {
            ShutterCallback shutterCallback = this.zzz;
            if (shutterCallback != null) {
                shutterCallback.onShutter();
            }
        }
    }

    @VisibleForTesting
    static class zze {
        private Size zzaa;
        private Size zzab;

        public zze(Camera.Size size, Camera.Size size2) {
            this.zzaa = new Size(size.width, size.height);
            if (size2 != null) {
                this.zzab = new Size(size2.width, size2.height);
            }
        }

        public final Size zzb() {
            return this.zzaa;
        }

        public final Size zzc() {
            return this.zzab;
        }
    }

    private CameraSource() {
        this.zzd = new Object();
        this.zzf = 0;
        this.zzi = 30.0f;
        this.zzj = 1024;
        this.zzk = 768;
        this.zzl = false;
        this.zzq = new HashMap();
    }

    @SuppressLint({"InlinedApi"})
    private final Camera zza() throws IOException {
        int i;
        int i2;
        int i3 = this.zzf;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= Camera.getNumberOfCameras()) {
                i5 = -1;
                break;
            }
            Camera.getCameraInfo(i5, cameraInfo);
            if (cameraInfo.facing == i3) {
                break;
            }
            i5++;
        }
        if (i5 != -1) {
            Camera open = Camera.open(i5);
            int i6 = this.zzj;
            int i7 = this.zzk;
            Camera.Parameters parameters = open.getParameters();
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
            ArrayList arrayList = new ArrayList();
            for (Camera.Size next : supportedPreviewSizes) {
                float f = ((float) next.width) / ((float) next.height);
                Iterator<Camera.Size> it = supportedPictureSizes.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Camera.Size next2 = it.next();
                    if (Math.abs(f - (((float) next2.width) / ((float) next2.height))) < 0.01f) {
                        arrayList.add(new zze(next, next2));
                        break;
                    }
                }
            }
            if (arrayList.size() == 0) {
                Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
                for (Camera.Size zze2 : supportedPreviewSizes) {
                    arrayList.add(new zze(zze2, null));
                }
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            zze zze3 = null;
            int i8 = 0;
            int i9 = Integer.MAX_VALUE;
            while (i8 < size) {
                Object obj = arrayList2.get(i8);
                i8++;
                zze zze4 = (zze) obj;
                Size zzb2 = zze4.zzb();
                int abs = Math.abs(zzb2.getWidth() - i6) + Math.abs(zzb2.getHeight() - i7);
                if (abs < i9) {
                    zze3 = zze4;
                    i9 = abs;
                }
            }
            if (zze3 != null) {
                Size zzc2 = zze3.zzc();
                this.zzh = zze3.zzb();
                int i10 = (int) (this.zzi * 1000.0f);
                int[] iArr = null;
                int i11 = Integer.MAX_VALUE;
                for (int[] next3 : open.getParameters().getSupportedPreviewFpsRange()) {
                    int abs2 = Math.abs(i10 - next3[0]) + Math.abs(i10 - next3[1]);
                    if (abs2 < i11) {
                        iArr = next3;
                        i11 = abs2;
                    }
                }
                if (iArr != null) {
                    Camera.Parameters parameters2 = open.getParameters();
                    if (zzc2 != null) {
                        parameters2.setPictureSize(zzc2.getWidth(), zzc2.getHeight());
                    }
                    parameters2.setPreviewSize(this.zzh.getWidth(), this.zzh.getHeight());
                    parameters2.setPreviewFpsRange(iArr[0], iArr[1]);
                    parameters2.setPreviewFormat(17);
                    int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
                    if (rotation != 0) {
                        if (rotation == 1) {
                            i4 = 90;
                        } else if (rotation == 2) {
                            i4 = 180;
                        } else if (rotation != 3) {
                            StringBuilder sb = new StringBuilder(31);
                            sb.append("Bad rotation value: ");
                            sb.append(rotation);
                            Log.e("CameraSource", sb.toString());
                        } else {
                            i4 = 270;
                        }
                    }
                    Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                    Camera.getCameraInfo(i5, cameraInfo2);
                    if (cameraInfo2.facing == 1) {
                        i2 = (cameraInfo2.orientation + i4) % 360;
                        i = (360 - i2) % 360;
                    } else {
                        i2 = ((cameraInfo2.orientation - i4) + 360) % 360;
                        i = i2;
                    }
                    this.zzg = i2 / 90;
                    open.setDisplayOrientation(i);
                    parameters2.setRotation(i2);
                    if (this.zzl) {
                        if (parameters2.getSupportedFocusModes().contains("continuous-video")) {
                            parameters2.setFocusMode("continuous-video");
                        } else {
                            Log.i("CameraSource", "Camera auto focus is not supported on this device.");
                        }
                    }
                    open.setParameters(parameters2);
                    open.setPreviewCallbackWithBuffer(new zza());
                    open.addCallbackBuffer(zza(this.zzh));
                    open.addCallbackBuffer(zza(this.zzh));
                    open.addCallbackBuffer(zza(this.zzh));
                    open.addCallbackBuffer(zza(this.zzh));
                    return open;
                }
                throw new IOException("Could not find suitable preview frames per second range.");
            }
            throw new IOException("Could not find suitable preview size.");
        }
        throw new IOException("Could not find requested camera.");
    }

    @SuppressLint({"InlinedApi"})
    private final byte[] zza(Size size) {
        double height = (double) ((long) (size.getHeight() * size.getWidth() * ImageFormat.getBitsPerPixel(17)));
        Double.isNaN(height);
        byte[] bArr = new byte[(((int) Math.ceil(height / 8.0d)) + 1)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (!wrap.hasArray() || wrap.array() != bArr) {
            throw new IllegalStateException("Failed to create valid buffer for camera source.");
        }
        this.zzq.put(bArr, wrap);
        return bArr;
    }

    public int getCameraFacing() {
        return this.zzf;
    }

    public Size getPreviewSize() {
        return this.zzh;
    }

    public void release() {
        synchronized (this.zzd) {
            stop();
            this.zzp.release();
        }
    }

    public CameraSource start() throws IOException {
        synchronized (this.zzd) {
            if (this.zze != null) {
                return this;
            }
            this.zze = zza();
            this.zzm = new SurfaceTexture(100);
            this.zze.setPreviewTexture(this.zzm);
            this.zzn = true;
            this.zze.startPreview();
            this.zzo = new Thread(this.zzp);
            this.zzp.setActive(true);
            this.zzo.start();
            return this;
        }
    }

    public CameraSource start(SurfaceHolder surfaceHolder) throws IOException {
        synchronized (this.zzd) {
            if (this.zze != null) {
                return this;
            }
            this.zze = zza();
            this.zze.setPreviewDisplay(surfaceHolder);
            this.zze.startPreview();
            this.zzo = new Thread(this.zzp);
            this.zzp.setActive(true);
            this.zzo.start();
            this.zzn = false;
            return this;
        }
    }

    public void stop() {
        synchronized (this.zzd) {
            this.zzp.setActive(false);
            if (this.zzo != null) {
                try {
                    this.zzo.join();
                } catch (InterruptedException unused) {
                    Log.d("CameraSource", "Frame processing thread interrupted on release.");
                }
                this.zzo = null;
            }
            if (this.zze != null) {
                this.zze.stopPreview();
                this.zze.setPreviewCallbackWithBuffer(null);
                try {
                    if (this.zzn) {
                        this.zze.setPreviewTexture(null);
                    } else {
                        this.zze.setPreviewDisplay(null);
                    }
                } catch (Exception e) {
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32);
                    sb.append("Failed to clear camera preview: ");
                    sb.append(valueOf);
                    Log.e("CameraSource", sb.toString());
                }
                this.zze.release();
                this.zze = null;
            }
            this.zzq.clear();
        }
    }

    public void takePicture(ShutterCallback shutterCallback, PictureCallback pictureCallback) {
        synchronized (this.zzd) {
            if (this.zze != null) {
                zzd zzd2 = new zzd();
                ShutterCallback unused = zzd2.zzz = shutterCallback;
                zzc zzc2 = new zzc();
                PictureCallback unused2 = zzc2.zzy = pictureCallback;
                this.zze.takePicture(zzd2, null, null, zzc2);
            }
        }
    }
}
