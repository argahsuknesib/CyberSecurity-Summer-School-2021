package _m_j;

import _m_j.cpx;
import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.location.Location;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceHolder;
import com.otaliastudios.cameraview.Audio;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.Facing;
import com.otaliastudios.cameraview.Flash;
import com.otaliastudios.cameraview.Gesture;
import com.otaliastudios.cameraview.Hdr;
import com.otaliastudios.cameraview.SessionType;
import com.otaliastudios.cameraview.VideoQuality;
import com.otaliastudios.cameraview.WhiteBalance;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class cpl extends cpm implements Camera.ErrorCallback, Camera.PreviewCallback {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final cpo f14185O000000o = cpo.O000000o(cpl.class.getSimpleName());
    private static final String O000OoO = "cpl";
    public Camera O00000Oo;
    public Runnable O00000o = new Runnable() {
        /* class _m_j.cpl.AnonymousClass1 */

        public final void run() {
            if (cpl.this.O0000Oo0()) {
                cpl.this.O00000Oo.cancelAutoFocus();
                Camera.Parameters parameters = cpl.this.O00000Oo.getParameters();
                int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                if (maxNumFocusAreas > 0) {
                    parameters.setFocusAreas(null);
                }
                if (maxNumMeteringAreas > 0) {
                    parameters.setMeteringAreas(null);
                }
                cpl.this.O00000Oo(parameters);
                cpl.this.O00000Oo.setParameters(parameters);
            }
        }
    };
    public boolean O00000o0 = false;
    private final int O000OoOO = 3000;

    public cpl(CameraView.O00000Oo o00000Oo) {
        super(o00000Oo);
        this.O0000ooo = new cpx.O000000o();
    }

    private void O000000o(final cqd<Void> cqd, final boolean z, final Runnable runnable) {
        this.O0000OOo.O000000o(new Runnable() {
            /* class _m_j.cpl.AnonymousClass8 */

            public final void run() {
                if (!z || cpl.this.O0000Oo0()) {
                    runnable.run();
                    cqd cqd = cqd;
                    if (cqd != null) {
                        cqd.O000000o(null);
                        return;
                    }
                    return;
                }
                cqd cqd2 = cqd;
                if (cqd2 != null) {
                    cqd2.O000000o(null);
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [?[OBJECT, ARRAY], int, _m_j.cpl$10]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    public final void O000000o() {
        f14185O000000o.O000000o(1, "onSurfaceAvailable:", "Size is", this.O0000O0o.O00000o0());
        O000000o((cqd<Void>) null, false, (Runnable) new Runnable() {
            /* class _m_j.cpl.AnonymousClass10 */

            public final void run() {
                cpl.f14185O000000o.O000000o(1, "onSurfaceAvailable:", "Inside handler. About to bind.");
                if (cpl.this.O00000o0()) {
                    cpl.this.O00000o();
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [?[OBJECT, ARRAY], int, _m_j.cpl$11]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    public final void O00000Oo() {
        f14185O000000o.O000000o(1, "onSurfaceChanged, size is", this.O0000O0o.O00000o0());
        O000000o((cqd<Void>) null, true, (Runnable) new Runnable() {
            /* class _m_j.cpl.AnonymousClass11 */

            public final void run() {
                if (cpl.this.O00000o0) {
                    cpl cpl = cpl.this;
                    cpz O00000Oo = cpl.O00000Oo(cpl.O000000o(cpl.O00000Oo.getParameters().getSupportedPreviewSizes()));
                    if (!O00000Oo.equals(cpl.this.O000O0o)) {
                        cpl.f14185O000000o.O000000o(1, "onSurfaceChanged:", "Computed a new preview size. Going on.");
                        cpl cpl2 = cpl.this;
                        cpl2.O000O0o = O00000Oo;
                        cpl2.O00000Oo.stopPreview();
                        cpl.this.O000000o("onSurfaceChanged:");
                    }
                }
            }
        });
    }

    public final boolean O00000o0() {
        return O0000Oo0() && this.O0000O0o != null && this.O0000O0o.O00000oO() && !this.O00000o0;
    }

    public final void O00000o() {
        f14185O000000o.O000000o(1, "bindToSurface:", "Started");
        Object O00000Oo2 = this.O0000O0o.O00000Oo();
        try {
            if (this.O0000O0o.O000000o() == SurfaceHolder.class) {
                this.O00000Oo.setPreviewDisplay((SurfaceHolder) O00000Oo2);
            } else {
                this.O00000Oo.setPreviewTexture((SurfaceTexture) O00000Oo2);
            }
            this.O000O0o0 = O000OO0o();
            this.O000O0o = O00000Oo(O000000o(this.O00000Oo.getParameters().getSupportedPreviewSizes()));
            O000000o("bindToSurface:");
            this.O00000o0 = true;
        } catch (IOException e) {
            Log.e("bindToSurface:", "Failed to bind.", e);
            throw new CameraException(e, 2);
        }
    }

    public final void O000000o(String str) {
        int i;
        int i2;
        f14185O000000o.O000000o(1, str, "Dispatching onCameraPreviewSizeChanged.");
        this.O00000oo.O00000Oo();
        boolean O000O0oO = O000O0oO();
        cpq cpq = this.O0000O0o;
        if (O000O0oO) {
            i = this.O000O0o.O00000Oo;
        } else {
            i = this.O000O0o.f14222O000000o;
        }
        if (O000O0oO) {
            i2 = this.O000O0o.f14222O000000o;
        } else {
            i2 = this.O000O0o.O00000Oo;
        }
        cpq.O000000o(i, i2);
        Camera.Parameters parameters = this.O00000Oo.getParameters();
        this.O000O0oO = parameters.getPreviewFormat();
        parameters.setPreviewSize(this.O000O0o.f14222O000000o, this.O000O0o.O00000Oo);
        parameters.setPictureSize(this.O000O0o0.f14222O000000o, this.O000O0o0.O00000Oo);
        this.O00000Oo.setParameters(parameters);
        this.O00000Oo.setPreviewCallbackWithBuffer(null);
        this.O00000Oo.setPreviewCallbackWithBuffer(this);
        this.O00oOooO.O000000o(ImageFormat.getBitsPerPixel(this.O000O0oO), this.O000O0o);
        f14185O000000o.O000000o(1, str, "Starting preview with startPreview().");
        try {
            this.O00000Oo.startPreview();
            f14185O000000o.O000000o(1, str, "Started preview.");
        } catch (Exception e) {
            f14185O000000o.O000000o(3, str, "Failed to start preview.", e);
            throw new CameraException(e, 2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000oO() {
        if (O0000Oo0()) {
            f14185O000000o.O000000o(2, "onStart:", "Camera not available. Should not happen.");
            O00000oo();
        }
        if (O0000O0o()) {
            try {
                this.O00000Oo = Camera.open(this.O0000oo0);
                this.O00000Oo.setErrorCallback(this);
                f14185O000000o.O000000o(1, "onStart:", "Applying default parameters.");
                Camera.Parameters parameters = this.O00000Oo.getParameters();
                this.O0000oo = new cpt(parameters);
                this.O0000ooO = new cpp(parameters, O000O0oO());
                O00000Oo(parameters);
                O000000o(parameters, Flash.DEFAULT);
                O000000o(parameters);
                O000000o(parameters, WhiteBalance.DEFAULT);
                O000000o(parameters, Hdr.DEFAULT);
                O000000o(this.O0000oOo);
                parameters.setRecordingHint(this.O0000o0O == SessionType.VIDEO);
                this.O00000Oo.setParameters(parameters);
                this.O00000Oo.setDisplayOrientation(O000O0oo());
                if (O00000o0()) {
                    O00000o();
                }
                f14185O000000o.O000000o(1, "onStart:", "Ended");
            } catch (Exception e) {
                f14185O000000o.O000000o(3, "onStart:", "Failed to connect. Maybe in use by another app?");
                throw new CameraException(e, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000oo() {
        f14185O000000o.O000000o(1, "onStop:", "About to clean up.");
        this.O0000OOo.O00000Oo.removeCallbacks(this.O00000o);
        this.O00oOooO.O000000o();
        if (this.O00000Oo != null) {
            f14185O000000o.O000000o(1, "onStop:", "Clean up.", "Ending video.");
            O000OO();
            try {
                f14185O000000o.O000000o(1, "onStop:", "Clean up.", "Stopping preview.");
                this.O00000Oo.setPreviewCallbackWithBuffer(null);
                this.O00000Oo.stopPreview();
                f14185O000000o.O000000o(1, "onStop:", "Clean up.", "Stopped preview.");
            } catch (Exception e) {
                f14185O000000o.O000000o(2, "onStop:", "Clean up.", "Exception while stopping preview.", e);
            }
            try {
                f14185O000000o.O000000o(1, "onStop:", "Clean up.", "Releasing camera.");
                this.O00000Oo.release();
                f14185O000000o.O000000o(1, "onStop:", "Clean up.", "Released camera.");
            } catch (Exception e2) {
                f14185O000000o.O000000o(2, "onStop:", "Clean up.", "Exception while releasing camera.", e2);
            }
        }
        this.O0000oo = null;
        this.O0000ooO = null;
        this.O00000Oo = null;
        this.O000O0o = null;
        this.O000O0o0 = null;
        this.O00000o0 = false;
        this.O000OO = false;
        this.O000OOOo = false;
        f14185O000000o.O000000o(2, "onStop:", "Clean up.", "Returning.");
    }

    public final boolean O0000O0o() {
        int intValue = ((Integer) this.O0000ooo.O000000o(this.O0000Oo)).intValue();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == intValue) {
                this.O000O0oo = cameraInfo.orientation;
                this.O0000oo0 = i;
                return true;
            }
        }
        return false;
    }

    public final void O000000o(byte[] bArr) {
        if (O0000Oo0()) {
            this.O00000Oo.addCallbackBuffer(bArr);
        }
    }

    public void onError(int i, Camera camera) {
        int i2 = 0;
        if (i == 100) {
            f14185O000000o.O000000o(2, "Recoverable error inside the onError callback.", "CAMERA_ERROR_SERVER_DIED");
            O0000o0();
            O0000Ooo();
            return;
        }
        f14185O000000o.O000000o(3, "Error inside the onError callback.", Integer.valueOf(i));
        RuntimeException runtimeException = new RuntimeException(cpo.f14212O000000o);
        if (i != 1 && i == 2) {
            i2 = 3;
        }
        throw new CameraException(runtimeException, i2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [?[OBJECT, ARRAY], int, _m_j.cpl$12]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    /* access modifiers changed from: package-private */
    public final void O000000o(SessionType sessionType) {
        if (sessionType != this.O0000o0O) {
            this.O0000o0O = sessionType;
            O000000o((cqd<Void>) null, true, (Runnable) new Runnable() {
                /* class _m_j.cpl.AnonymousClass12 */

                public final void run() {
                    cpl.this.O0000o0O();
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [_m_j.cqd, int, _m_j.cpl$13]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    /* access modifiers changed from: package-private */
    public final void O000000o(Location location) {
        final Location location2 = this.O0000o;
        this.O0000o = location;
        O000000o((cqd<Void>) this.O000Oo0O, true, (Runnable) new Runnable() {
            /* class _m_j.cpl.AnonymousClass13 */

            public final void run() {
                Camera.Parameters parameters = cpl.this.O00000Oo.getParameters();
                cpl.this.O000000o(parameters);
                cpl.this.O00000Oo.setParameters(parameters);
            }
        });
    }

    public final boolean O000000o(Camera.Parameters parameters) {
        if (this.O0000o == null) {
            return true;
        }
        parameters.setGpsLatitude(this.O0000o.getLatitude());
        parameters.setGpsLongitude(this.O0000o.getLongitude());
        parameters.setGpsAltitude(this.O0000o.getAltitude());
        parameters.setGpsTimestamp(this.O0000o.getTime());
        parameters.setGpsProcessingMethod(this.O0000o.getProvider());
        if (!this.O000OOOo || this.O000O00o == null) {
            return true;
        }
        this.O000O00o.setLocation((float) this.O0000o.getLatitude(), (float) this.O0000o.getLongitude());
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [?[OBJECT, ARRAY], int, _m_j.cpl$14]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    /* access modifiers changed from: package-private */
    public final void O000000o(Facing facing) {
        if (facing != this.O0000Oo) {
            this.O0000Oo = facing;
            O000000o((cqd<Void>) null, true, (Runnable) new Runnable() {
                /* class _m_j.cpl.AnonymousClass14 */

                public final void run() {
                    if (cpl.this.O0000O0o()) {
                        cpl.this.O0000o0O();
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [_m_j.cqd, int, _m_j.cpl$15]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    /* access modifiers changed from: package-private */
    public final void O000000o(WhiteBalance whiteBalance) {
        final WhiteBalance whiteBalance2 = this.O0000Ooo;
        this.O0000Ooo = whiteBalance;
        O000000o((cqd<Void>) this.O000Oo00, true, (Runnable) new Runnable() {
            /* class _m_j.cpl.AnonymousClass15 */

            public final void run() {
                Camera.Parameters parameters = cpl.this.O00000Oo.getParameters();
                if (cpl.this.O000000o(parameters, whiteBalance2)) {
                    cpl.this.O00000Oo.setParameters(parameters);
                }
            }
        });
    }

    public final boolean O000000o(Camera.Parameters parameters, WhiteBalance whiteBalance) {
        if (this.O0000ooO.O000000o(this.O0000Ooo)) {
            parameters.setWhiteBalance((String) this.O0000ooo.O000000o(this.O0000Ooo));
            return true;
        }
        this.O0000Ooo = whiteBalance;
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [_m_j.cqd, int, _m_j.cpl$16]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    /* access modifiers changed from: package-private */
    public final void O000000o(Hdr hdr) {
        final Hdr hdr2 = this.O0000o0o;
        this.O0000o0o = hdr;
        O000000o((cqd<Void>) this.O000Oo0, true, (Runnable) new Runnable() {
            /* class _m_j.cpl.AnonymousClass16 */

            public final void run() {
                Camera.Parameters parameters = cpl.this.O00000Oo.getParameters();
                if (cpl.this.O000000o(parameters, hdr2)) {
                    cpl.this.O00000Oo.setParameters(parameters);
                }
            }
        });
    }

    public final boolean O000000o(Camera.Parameters parameters, Hdr hdr) {
        if (this.O0000ooO.O000000o(this.O0000o0o)) {
            parameters.setSceneMode((String) this.O0000ooo.O000000o(this.O0000o0o));
            return true;
        }
        this.O0000o0o = hdr;
        return false;
    }

    @TargetApi(17)
    public final boolean O000000o(boolean z) {
        if (Build.VERSION.SDK_INT >= 17) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.O0000oo0, cameraInfo);
            if (cameraInfo.canDisableShutterSound) {
                this.O00000Oo.enableShutterSound(this.O0000oOo);
                return true;
            }
        }
        if (this.O0000oOo) {
            return true;
        }
        this.O0000oOo = z;
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Audio audio) {
        if (this.O0000oO0 != audio) {
            if (this.O000OOOo) {
                f14185O000000o.O000000o(2, "Audio setting was changed while recording. Changes will take place starting from next video");
            }
            this.O0000oO0 = audio;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [_m_j.cqd, int, _m_j.cpl$2]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    /* access modifiers changed from: package-private */
    public final void O000000o(Flash flash) {
        final Flash flash2 = this.O0000OoO;
        this.O0000OoO = flash;
        O000000o((cqd<Void>) this.O000OOoo, true, (Runnable) new Runnable() {
            /* class _m_j.cpl.AnonymousClass2 */

            public final void run() {
                Camera.Parameters parameters = cpl.this.O00000Oo.getParameters();
                if (cpl.this.O000000o(parameters, flash2)) {
                    cpl.this.O00000Oo.setParameters(parameters);
                }
            }
        });
    }

    public final boolean O000000o(Camera.Parameters parameters, Flash flash) {
        if (this.O0000ooO.O000000o(this.O0000OoO)) {
            parameters.setFlashMode((String) this.O0000ooo.O000000o(this.O0000OoO));
            return true;
        }
        this.O0000OoO = flash;
        return false;
    }

    public final void O00000Oo(Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (this.O0000o0O == SessionType.VIDEO && supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        } else if (supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("infinity")) {
            parameters.setFocusMode("infinity");
        } else if (supportedFocusModes.contains("fixed")) {
            parameters.setFocusMode("fixed");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [_m_j.cqd, int, _m_j.cpl$3]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    /* access modifiers changed from: package-private */
    public final void O000000o(VideoQuality videoQuality) {
        final VideoQuality videoQuality2 = this.O0000o00;
        this.O0000o00 = videoQuality;
        O000000o((cqd<Void>) this.O000Oo0o, true, (Runnable) new Runnable() {
            /* class _m_j.cpl.AnonymousClass3 */

            public final void run() {
                if (cpl.this.O000OOOo) {
                    cpl.this.O0000o00 = videoQuality2;
                    throw new IllegalStateException("Can't change video quality while recording a video.");
                } else if (cpl.this.O0000o0O == SessionType.VIDEO) {
                    cpz cpz = cpl.this.O000O0o0;
                    cpl cpl = cpl.this;
                    cpl.O000O0o0 = cpl.O000OO0o();
                    if (!cpl.this.O000O0o0.equals(cpz)) {
                        Camera.Parameters parameters = cpl.this.O00000Oo.getParameters();
                        parameters.setPictureSize(cpl.this.O000O0o0.f14222O000000o, cpl.this.O000O0o0.O00000Oo);
                        cpl.this.O00000Oo.setParameters(parameters);
                        cpl.this.O00000Oo();
                    }
                    cpl.f14185O000000o.O000000o("setVideoQuality:", "captureSize:", cpl.this.O000O0o0);
                    cpl.f14185O000000o.O000000o("setVideoQuality:", "previewSize:", cpl.this.O000O0o);
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [?[OBJECT, ARRAY], int, _m_j.cpl$4]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    /* access modifiers changed from: package-private */
    public final void O0000OOo() {
        f14185O000000o.O000000o(0, "capturePicture: scheduling");
        O000000o((cqd<Void>) null, true, (Runnable) new Runnable() {
            /* class _m_j.cpl.AnonymousClass4 */

            public final void run() {
                final boolean z = false;
                cpl.f14185O000000o.O000000o(0, "capturePicture: performing.", Boolean.valueOf(cpl.this.O000OO));
                if (!cpl.this.O000OO) {
                    if (!cpl.this.O000OOOo || cpl.this.O0000ooO.O00000o0) {
                        cpl cpl = cpl.this;
                        cpl.O000OO = true;
                        int O000OO00 = cpl.O000OO00();
                        final boolean z2 = ((cpl.this.O000O0oo() + O000OO00) + 180) % 180 == 0;
                        if (cpl.this.O0000Oo == Facing.FRONT) {
                            z = true;
                        }
                        Camera.Parameters parameters = cpl.this.O00000Oo.getParameters();
                        parameters.setRotation(O000OO00);
                        cpl.this.O00000Oo.setParameters(parameters);
                        cpl.this.O00000Oo.takePicture(new Camera.ShutterCallback() {
                            /* class _m_j.cpl.AnonymousClass4.AnonymousClass1 */

                            public final void onShutter() {
                            }
                        }, null, null, new Camera.PictureCallback() {
                            /* class _m_j.cpl.AnonymousClass4.AnonymousClass2 */

                            public final void onPictureTaken(byte[] bArr, Camera camera) {
                                cpl.this.O000OO = false;
                                cpl.this.O00000oo.O000000o(bArr, z2);
                                camera.startPreview();
                            }
                        });
                    }
                }
            }
        });
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        cpv cpv = this.O00oOooO;
        long currentTimeMillis = System.currentTimeMillis();
        int O000OO00 = O000OO00();
        cpz cpz = this.O000O0o;
        int i = this.O000O0oO;
        cpu poll = cpv.f14218O000000o.poll();
        if (poll == null) {
            poll = new cpu(cpv);
        }
        poll.O00000Oo = bArr;
        poll.O00000o0 = currentTimeMillis;
        poll.O00000o = O000OO00;
        poll.O00000oO = cpz;
        poll.O00000oo = i;
        this.O00000oo.O000000o(poll);
    }

    public final boolean O0000Oo0() {
        int i = this.O000OOo0;
        if (!(i == -1 || i == 0)) {
            if (i != 1) {
                return i == 2;
            }
            if (this.O00000Oo != null) {
                return true;
            }
        }
        return false;
    }

    private void O000OO() {
        f14185O000000o.O000000o(1, "endVideoImmediately:", "is capturing:", Boolean.valueOf(this.O000OOOo));
        this.O000OOOo = false;
        if (this.O000O00o != null) {
            try {
                this.O000O00o.stop();
            } catch (Exception e) {
                f14185O000000o.O000000o(2, "endVideoImmediately:", "Error while closing media recorder. Swallowing", e);
            }
            this.O000O00o.release();
            this.O000O00o = null;
        }
        if (this.O000O0OO != null) {
            this.O00000oo.O000000o(this.O000O0OO);
            this.O000O0OO = null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [_m_j.cqd, int, _m_j.cpl$5]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    /* access modifiers changed from: package-private */
    public final void O000000o(final float f, final PointF[] pointFArr, final boolean z) {
        O000000o((cqd<Void>) this.O000OOo, true, (Runnable) new Runnable() {
            /* class _m_j.cpl.AnonymousClass5 */

            public final void run() {
                if (cpl.this.O0000ooO.O00000Oo) {
                    cpl cpl = cpl.this;
                    cpl.O0000oO = f;
                    Camera.Parameters parameters = cpl.O00000Oo.getParameters();
                    parameters.setZoom((int) (f * ((float) parameters.getMaxZoom())));
                    cpl.this.O00000Oo.setParameters(parameters);
                    if (z) {
                        cpl.this.O00000oo.O000000o(f, pointFArr);
                    }
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [_m_j.cqd, int, _m_j.cpl$6]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    /* access modifiers changed from: package-private */
    public final void O000000o(float f, float[] fArr, PointF[] pointFArr, boolean z) {
        final float f2 = f;
        final boolean z2 = z;
        final float[] fArr2 = fArr;
        final PointF[] pointFArr2 = pointFArr;
        O000000o((cqd<Void>) this.O000OOoO, true, (Runnable) new Runnable() {
            /* class _m_j.cpl.AnonymousClass6 */

            public final void run() {
                if (cpl.this.O0000ooO.O00000o) {
                    float f = f2;
                    float f2 = cpl.this.O0000ooO.O00000oo;
                    float f3 = cpl.this.O0000ooO.O00000oO;
                    if (f < f3) {
                        f = f3;
                    } else if (f > f2) {
                        f = f2;
                    }
                    cpl cpl = cpl.this;
                    cpl.O0000oOO = f;
                    Camera.Parameters parameters = cpl.O00000Oo.getParameters();
                    parameters.setExposureCompensation((int) (f / parameters.getExposureCompensationStep()));
                    cpl.this.O00000Oo.setParameters(parameters);
                    if (z2) {
                        cpl.this.O00000oo.O000000o(f, fArr2, pointFArr2);
                    }
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [?[OBJECT, ARRAY], int, _m_j.cpl$7]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    /* access modifiers changed from: package-private */
    public final void O000000o(Gesture gesture, PointF pointF) {
        final int i;
        final int i2;
        if (this.O0000O0o == null || !this.O0000O0o.O00000oO()) {
            i2 = 0;
            i = 0;
        } else {
            int width = this.O0000O0o.O00000o.getWidth();
            i = this.O0000O0o.O00000o.getHeight();
            i2 = width;
        }
        final PointF pointF2 = pointF;
        final Gesture gesture2 = gesture;
        O000000o((cqd<Void>) null, true, (Runnable) new Runnable() {
            /* class _m_j.cpl.AnonymousClass7 */

            public final void run() {
                if (cpl.this.O0000ooO.O0000O0o) {
                    final PointF pointF = new PointF(pointF2.x, pointF2.y);
                    List<Camera.Area> O000000o2 = cpl.O000000o((double) pointF.x, (double) pointF.y, i2, i, cpl.this.O000O0oo());
                    List<Camera.Area> subList = O000000o2.subList(0, 1);
                    Camera.Parameters parameters = cpl.this.O00000Oo.getParameters();
                    int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                    int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                    if (maxNumFocusAreas > 0) {
                        parameters.setFocusAreas(maxNumFocusAreas > 1 ? O000000o2 : subList);
                    }
                    if (maxNumMeteringAreas > 0) {
                        if (maxNumMeteringAreas <= 1) {
                            O000000o2 = subList;
                        }
                        parameters.setMeteringAreas(O000000o2);
                    }
                    parameters.setFocusMode("auto");
                    cpl.this.O00000Oo.setParameters(parameters);
                    cpl.this.O00000oo.O000000o(gesture2, pointF);
                    cpl.this.O00000Oo.autoFocus(new Camera.AutoFocusCallback() {
                        /* class _m_j.cpl.AnonymousClass7.AnonymousClass1 */

                        public final void onAutoFocus(boolean z, Camera camera) {
                            cpl.this.O00000oo.O000000o(gesture2, z, pointF);
                            cpl.this.O0000OOo.O00000Oo.removeCallbacks(cpl.this.O00000o);
                            cpl.this.O0000OOo.O00000Oo.postDelayed(cpl.this.O00000o, 3000);
                        }
                    });
                }
            }
        });
    }

    public static List<Camera.Area> O000000o(double d, double d2, int i, int i2, int i3) {
        double d3 = (double) i;
        Double.isNaN(d3);
        double d4 = ((d / d3) * 2000.0d) - 0.00408935546875d;
        double d5 = (double) i2;
        Double.isNaN(d5);
        double d6 = ((d2 / d5) * 2000.0d) - 0.00408935546875d;
        double d7 = (double) (-i3);
        Double.isNaN(d7);
        double d8 = (d7 * 3.141592653589793d) / 180.0d;
        double cos = (Math.cos(d8) * d4) - (Math.sin(d8) * d6);
        double cos2 = (Math.cos(d8) * d6) + (Math.sin(d8) * d4);
        f14185O000000o.O000000o(1, "focus:", "viewClickX:", Double.valueOf(d4), "viewClickY:", Double.valueOf(d6));
        f14185O000000o.O000000o(1, "focus:", "sensorClickX:", Double.valueOf(cos), "sensorClickY:", Double.valueOf(cos2));
        double d9 = cos;
        double d10 = cos2;
        Rect O000000o2 = O000000o(d9, d10, 150.0d);
        Rect O000000o3 = O000000o(d9, d10, 300.0d);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new Camera.Area(O000000o2, 1000));
        arrayList.add(new Camera.Area(O000000o3, 100));
        return arrayList;
    }

    private static Rect O000000o(double d, double d2, double d3) {
        double d4 = d3 / 2.0d;
        int max = (int) Math.max(d2 - d4, -1000.0d);
        int min = (int) Math.min(d2 + d4, 1000.0d);
        int max2 = (int) Math.max(d - d4, -1000.0d);
        int min2 = (int) Math.min(d + d4, 1000.0d);
        f14185O000000o.O000000o(1, "focus:", "computeMeteringArea:", "top:", Integer.valueOf(max), "left:", Integer.valueOf(max2), "bottom:", Integer.valueOf(min), "right:", Integer.valueOf(min2));
        return new Rect(max2, max, min2, min);
    }

    public static List<cpz> O000000o(List<Camera.Size> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Camera.Size next : list) {
            cpz cpz = new cpz(next.width, next.height);
            if (!arrayList.contains(cpz)) {
                arrayList.add(cpz);
            }
        }
        f14185O000000o.O000000o("size:", "sizesFromList:", arrayList);
        return arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void
     arg types: [_m_j.cqd, int, _m_j.cpl$9]
     candidates:
      _m_j.cpl.O000000o(double, double, double):android.graphics.Rect
      _m_j.cpl.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpm.O000000o(float, android.graphics.PointF[], boolean):void
      _m_j.cpl.O000000o(_m_j.cqd<java.lang.Void>, boolean, java.lang.Runnable):void */
    /* access modifiers changed from: package-private */
    public final void O00000Oo(boolean z) {
        final boolean z2 = this.O0000oOo;
        this.O0000oOo = z;
        O000000o((cqd<Void>) this.O00O0Oo, true, (Runnable) new Runnable() {
            /* class _m_j.cpl.AnonymousClass9 */

            public final void run() {
                cpl.this.O000000o(z2);
            }
        });
    }
}
