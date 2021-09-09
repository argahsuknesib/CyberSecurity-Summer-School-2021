package _m_j;

import _m_j.etc;
import _m_j.etg;
import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.xiaomi.qrcode.camera.SingleCamera;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class etd extends etc {
    private Camera O0000OoO;
    private Camera.PreviewCallback O0000Ooo;

    public etd(etg.O000000o o000000o) {
        this.f15789O000000o = o000000o;
        this.O0000Oo0 = new Handler(this);
        this.O00000Oo = SingleCamera.getInstance();
        this.O0000Oo = true;
    }

    public final void O000000o(Context context) {
        LogType logType = LogType.CAMERA;
        gsy.O000000o(logType, "CameraAPI1Scanner", getClass().getName() + ".openCamera()");
        Context applicationContext = context.getApplicationContext();
        WindowManager windowManager = (WindowManager) applicationContext.getSystemService("window");
        if (windowManager != null) {
            this.O00000oO = windowManager.getDefaultDisplay().getRotation();
        }
        LogType logType2 = LogType.CAMERA;
        gsy.O000000o(logType2, "CameraAPI1Scanner", getClass().getName() + ".takeOrientation() mOrientation = " + this.O00000oO);
        goq.O000000o(new Runnable(applicationContext) {
            /* class _m_j.$$Lambda$etd$XTEIjIPhDpZvVfAGOuZSgQMU2pE */
            private final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                etd.this.O00000Oo(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(Context context) {
        if (ContextCompat.O000000o(context, "android.permission.CAMERA") == 0) {
            try {
                if (this.O00000Oo.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                    this.O0000OoO = Camera.open();
                    Camera.Parameters parameters = this.O0000OoO.getParameters();
                    parameters.setFocusMode("continuous-picture");
                    O000000o(parameters.getSupportedPreviewSizes(), this.O0000O0o.f15790O000000o, this.O0000O0o.O00000Oo);
                    parameters.setPreviewSize(this.O00000oo.f15790O000000o, this.O00000oo.O00000Oo);
                    this.O0000OoO.setParameters(parameters);
                    if (this.O0000Oo0 != null) {
                        this.O0000Oo0.sendMessage(this.O0000Oo0.obtainMessage(70001));
                    }
                    this.O0000OoO.setPreviewTexture(this.O00000o);
                    this.O0000OoO.startPreview();
                    Camera camera = this.O0000OoO;
                    if (this.O0000Ooo == null) {
                        this.O0000Ooo = new Camera.PreviewCallback() {
                            /* class _m_j.etd.AnonymousClass1 */

                            public final void onPreviewFrame(byte[] bArr, Camera camera) {
                                etd etd = etd.this;
                                etd.O000000o(bArr, etd.O00000oo.f15790O000000o, etd.this.O00000oo.O00000Oo);
                            }
                        };
                    }
                    camera.setPreviewCallback(this.O0000Ooo);
                    this.O00000Oo.release();
                    return;
                }
                throw new RuntimeException("Time out waiting to lock camera opening.");
            } catch (RuntimeException unused) {
                if (this.O0000Oo0 != null) {
                    this.O0000Oo0.sendMessage(this.O0000Oo0.obtainMessage(80007));
                }
            } catch (Exception unused2) {
                if (this.O0000Oo0 != null) {
                    this.O0000Oo0.sendMessage(this.O0000Oo0.obtainMessage(80001));
                }
            }
        } else if (this.O0000Oo0 != null) {
            this.O0000Oo0.sendMessage(this.O0000Oo0.obtainMessage(80006));
        }
    }

    public final void O00000Oo() {
        LogType logType = LogType.CAMERA;
        gsy.O000000o(logType, "CameraAPI1Scanner", getClass().getName() + ".closeCamera()");
        try {
            this.O00000Oo.acquire();
            if (this.O0000OoO != null) {
                this.O0000OoO.stopPreview();
                this.O0000OoO.setPreviewCallback(null);
                this.O0000OoO.release();
                this.O0000OoO = null;
            }
            this.O00000Oo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public final void O00000o0() {
        try {
            this.O00000Oo.acquire();
            if (this.O0000OoO != null) {
                Camera.Parameters parameters = this.O0000OoO.getParameters();
                parameters.setFlashMode("torch");
                this.O0000OoO.setParameters(parameters);
            }
            this.O00000Oo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public final void O00000o() {
        try {
            this.O00000Oo.acquire();
            if (this.O0000OoO != null) {
                Camera.Parameters parameters = this.O0000OoO.getParameters();
                parameters.setFlashMode("off");
                this.O0000OoO.setParameters(parameters);
            }
            this.O00000Oo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public final boolean O00000oO() {
        Camera camera = this.O0000OoO;
        if (camera == null || "off".equals(camera.getParameters().getFlashMode())) {
            return false;
        }
        return true;
    }

    public final void O00000oo() {
        O00000Oo();
        if (this.O0000Oo0 != null) {
            this.O0000Oo0.removeCallbacksAndMessages(null);
            this.O0000Oo0 = null;
        }
        if (this.O00000o != null) {
            this.O00000o.release();
            this.O00000o = null;
        }
        this.O00000o0 = null;
        this.f15789O000000o = null;
    }

    private void O000000o(List<Camera.Size> list, int i, int i2) {
        if (this.O00000oO == 0 || this.O00000oO == 2) {
            this.O00000oo = O00000Oo(list, i, i2);
        } else {
            this.O00000oo = O00000Oo(list, i2, i);
        }
        if (Build.VERSION.SDK_INT >= 15) {
            this.O00000o.setDefaultBufferSize(this.O00000oo.f15790O000000o, this.O00000oo.O00000Oo);
        }
        LogType logType = LogType.CAMERA;
        gsy.O000000o(logType, "CameraAPI1Scanner", getClass().getName() + ".initSurfaceSize() mSurfaceSize = " + this.O00000oo.toString());
    }

    private static etc.O000000o O00000Oo(List<Camera.Size> list, int i, int i2) {
        Camera.Size size = list.get(0);
        boolean z = size.width >= i && size.height >= i2;
        Camera.Size size2 = size;
        for (int i3 = 1; i3 < list.size(); i3++) {
            Camera.Size size3 = list.get(i3);
            boolean z2 = size3.width >= i && size3.height >= i2;
            if (!z && z2) {
                size2 = size3;
                z = true;
            } else if ((!z2) ^ z) {
                if ((((long) size2.width) * ((long) size2.height) < ((long) size3.width) * ((long) size3.height)) ^ z) {
                    size2 = size3;
                }
            }
        }
        return new etc.O000000o(size2.width, size2.height);
    }
}
