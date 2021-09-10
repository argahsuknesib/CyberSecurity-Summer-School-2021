package _m_j;

import _m_j.cpq;
import _m_j.cpv;
import android.graphics.PointF;
import android.location.Location;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.otaliastudios.cameraview.Audio;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.Facing;
import com.otaliastudios.cameraview.Flash;
import com.otaliastudios.cameraview.Gesture;
import com.otaliastudios.cameraview.Hdr;
import com.otaliastudios.cameraview.SessionType;
import com.otaliastudios.cameraview.VideoCodec;
import com.otaliastudios.cameraview.VideoQuality;
import com.otaliastudios.cameraview.WhiteBalance;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class cpm implements cpq.O000000o, cpv.O000000o, Thread.UncaughtExceptionHandler {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f14205O000000o = "cpm";
    public static final cpo O00000oO = cpo.O000000o(cpm.class.getSimpleName());
    protected final CameraView.O00000Oo O00000oo;
    protected cpq O0000O0o;
    protected cqf O0000OOo;
    protected Facing O0000Oo;
    Handler O0000Oo0;
    protected Flash O0000OoO;
    protected WhiteBalance O0000Ooo;
    protected Location O0000o;
    protected VideoCodec O0000o0;
    protected VideoQuality O0000o00;
    protected SessionType O0000o0O;
    protected Hdr O0000o0o;
    protected float O0000oO;
    protected Audio O0000oO0;
    protected float O0000oOO;
    protected boolean O0000oOo;
    protected cpt O0000oo;
    public int O0000oo0;
    protected cpp O0000ooO;
    protected cpx O0000ooo;
    protected MediaRecorder O000O00o;
    protected File O000O0OO;
    protected long O000O0Oo;
    protected cpz O000O0o;
    protected cpz O000O0o0;
    protected int O000O0oO;
    protected int O000O0oo;
    protected boolean O000OO = false;
    public int O000OO00;
    public int O000OO0o;
    protected boolean O000OOOo = false;
    cqd<Void> O000OOo = new cqd<>();
    protected int O000OOo0 = 0;
    cqd<Void> O000OOoO = new cqd<>();
    cqd<Void> O000OOoo = new cqd<>();
    cqd<Void> O000Oo0 = new cqd<>();
    cqd<Void> O000Oo00 = new cqd<>();
    cqd<Void> O000Oo0O = new cqd<>();
    cqd<Void> O000Oo0o = new cqd<>();
    cqd<Void> O000OoO0 = new cqd<>();
    cqd<Void> O00O0Oo = new cqd<>();
    protected int O00oOoOo;
    protected cpv O00oOooO;
    protected cqa O00oOooo;

    public abstract void O000000o(float f, float[] fArr, PointF[] pointFArr, boolean z);

    public abstract void O000000o(float f, PointF[] pointFArr, boolean z);

    public abstract void O000000o(Location location);

    public abstract void O000000o(Audio audio);

    public abstract void O000000o(Facing facing);

    public abstract void O000000o(Flash flash);

    public abstract void O000000o(Gesture gesture, PointF pointF);

    public abstract void O000000o(Hdr hdr);

    public abstract void O000000o(SessionType sessionType);

    public abstract void O000000o(VideoQuality videoQuality);

    public abstract void O000000o(WhiteBalance whiteBalance);

    public abstract void O00000Oo(boolean z);

    /* access modifiers changed from: package-private */
    public abstract void O00000oO();

    /* access modifiers changed from: package-private */
    public abstract void O00000oo();

    public abstract void O0000OOo();

    cpm(CameraView.O00000Oo o00000Oo) {
        this.O00000oo = o00000Oo;
        this.O0000Oo0 = new Handler(Looper.getMainLooper());
        this.O0000OOo = cqf.O000000o("CameraViewController");
        this.O0000OOo.f14236O000000o.setUncaughtExceptionHandler(this);
        this.O00oOooO = new cpv(this);
    }

    public final void O000000o(cpq cpq) {
        this.O0000O0o = cpq;
        cpq cpq2 = this.O0000O0o;
        cpq2.O00000o0 = this;
        if (cpq2.O00000oo != 0 || cpq2.O0000O0o != 0) {
            cpq2.O00000o0.O000000o();
        }
    }

    static class O000000o implements Thread.UncaughtExceptionHandler {
        public final void uncaughtException(Thread thread, Throwable th) {
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    public void uncaughtException(Thread thread, final Throwable th) {
        if (!(th instanceof CameraException)) {
            O00000oO.O000000o(3, "uncaughtException:", "Unexpected exception:", th);
            O0000Oo();
            this.O0000Oo0.post(new Runnable() {
                /* class _m_j.cpm.AnonymousClass1 */

                public final void run() {
                    RuntimeException runtimeException;
                    Throwable th = th;
                    if (th instanceof RuntimeException) {
                        runtimeException = (RuntimeException) th;
                    } else {
                        runtimeException = new RuntimeException(th);
                    }
                    throw runtimeException;
                }
            });
            return;
        }
        final CameraException cameraException = (CameraException) th;
        O00000oO.O000000o(3, "uncaughtException:", "Interrupting thread with state:", O0000OoO(), "due to CameraException:", cameraException);
        thread.interrupt();
        this.O0000OOo = cqf.O000000o("CameraViewController");
        this.O0000OOo.f14236O000000o.setUncaughtExceptionHandler(this);
        O00000oO.O000000o(1, "uncaughtException:", "Calling stopImmediately and notifying.");
        this.O0000OOo.O000000o(new Runnable() {
            /* class _m_j.cpm.AnonymousClass2 */

            public final void run() {
                cpm.this.O0000o0();
                cpm.this.O00000oo.O000000o(cameraException);
            }
        });
    }

    public final void O0000Oo() {
        O00000oO.O000000o(1, "destroy:", "state:", O0000OoO());
        this.O0000OOo.f14236O000000o.setUncaughtExceptionHandler(new O000000o((byte) 0));
        O0000o0();
    }

    public final String O0000OoO() {
        int i = this.O000OOo0;
        if (i == -1) {
            return "STATE_STOPPING";
        }
        if (i == 0) {
            return "STATE_STOPPED";
        }
        if (i != 1) {
            return i != 2 ? "null" : "STATE_STARTED";
        }
        return "STATE_STARTING";
    }

    public final void O0000Ooo() {
        O00000oO.O000000o(1, "Start:", "posting runnable. State:", O0000OoO());
        this.O0000OOo.O000000o(new Runnable() {
            /* class _m_j.cpm.AnonymousClass3 */

            public final void run() {
                cpm.O00000oO.O000000o(1, "Start:", "executing. State:", cpm.this.O0000OoO());
                if (cpm.this.O000OOo0 <= 0) {
                    cpm.this.O000OOo0 = 1;
                    cpm.O00000oO.O000000o(1, "Start:", "about to call onStart()", cpm.this.O0000OoO());
                    cpm.this.O00000oO();
                    cpm.O00000oO.O000000o(1, "Start:", "returned from onStart().", "Dispatching.", cpm.this.O0000OoO());
                    cpm cpm = cpm.this;
                    cpm.O000OOo0 = 2;
                    cpm.O00000oo.O000000o(cpm.this.O0000ooO);
                }
            }
        });
    }

    public final void O0000o00() {
        O00000oO.O000000o(1, "Stop:", "posting runnable. State:", O0000OoO());
        this.O0000OOo.O000000o(new Runnable() {
            /* class _m_j.cpm.AnonymousClass4 */

            public final void run() {
                cpm.O00000oO.O000000o(1, "Stop:", "executing. State:", cpm.this.O0000OoO());
                if (cpm.this.O000OOo0 > 0) {
                    cpm.this.O000OOo0 = -1;
                    cpm.O00000oO.O000000o(1, "Stop:", "about to call onStop()");
                    cpm.this.O00000oo();
                    cpm.O00000oO.O000000o(1, "Stop:", "returned from onStop().", "Dispatching.");
                    cpm cpm = cpm.this;
                    cpm.O000OOo0 = 0;
                    cpm.O00000oo.O000000o();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void O0000o0() {
        try {
            O00000oO.O000000o(1, "stopImmediately:", "State was:", O0000OoO());
            if (this.O000OOo0 != 0) {
                this.O000OOo0 = -1;
                O00000oo();
                this.O000OOo0 = 0;
                O00000oO.O000000o(1, "stopImmediately:", "Stopped. State is:", O0000OoO());
            }
        } catch (Exception e) {
            O00000oO.O000000o(1, "stopImmediately:", "Swallowing exception while stopping.", e);
            this.O000OOo0 = 0;
        }
    }

    /* access modifiers changed from: protected */
    public final void O0000o0O() {
        O00000oO.O000000o(1, "Restart:", "posting runnable");
        this.O0000OOo.O000000o(new Runnable() {
            /* class _m_j.cpm.AnonymousClass5 */

            public final void run() {
                cpo cpo = cpm.O00000oO;
                Object[] objArr = new Object[4];
                objArr[0] = "Restart:";
                objArr[1] = "executing. Needs stopping:";
                objArr[2] = Boolean.valueOf(cpm.this.O000OOo0 > 0);
                objArr[3] = cpm.this.O0000OoO();
                cpo.O000000o(1, objArr);
                if (cpm.this.O000OOo0 > 0) {
                    cpm cpm = cpm.this;
                    cpm.O000OOo0 = -1;
                    cpm.O00000oo();
                    cpm.this.O000OOo0 = 0;
                    cpm.O00000oO.O000000o(1, "Restart:", "stopped. Dispatching.", cpm.this.O0000OoO());
                    cpm.this.O00000oo.O000000o();
                }
                cpm.O00000oO.O000000o(1, "Restart: about to start. State:", cpm.this.O0000OoO());
                cpm cpm2 = cpm.this;
                cpm2.O000OOo0 = 1;
                cpm2.O00000oO();
                cpm.this.O000OOo0 = 2;
                cpm.O00000oO.O000000o(1, "Restart: returned from start. Dispatching. State:", cpm.this.O0000OoO());
                cpm.this.O00000oo.O000000o(cpm.this.O0000ooO);
            }
        });
    }

    public final int O0000o0o() {
        return this.O000OOo0;
    }

    public final void O000000o(cqa cqa) {
        this.O00oOooo = cqa;
    }

    public final void O000000o(long j) {
        this.O000O0Oo = j;
    }

    public final void O000000o(int i) {
        this.O00oOoOo = i;
    }

    public final void O000000o(VideoCodec videoCodec) {
        this.O0000o0 = videoCodec;
    }

    public final cpt O0000o() {
        return this.O0000oo;
    }

    public final cpp O0000oO0() {
        return this.O0000ooO;
    }

    public final Facing O0000oO() {
        return this.O0000Oo;
    }

    public final Flash O0000oOO() {
        return this.O0000OoO;
    }

    public final WhiteBalance O0000oOo() {
        return this.O0000Ooo;
    }

    public final VideoQuality O0000oo0() {
        return this.O0000o00;
    }

    public final VideoCodec O0000oo() {
        return this.O0000o0;
    }

    public final long O0000ooO() {
        return this.O000O0Oo;
    }

    public final int O0000ooo() {
        return this.O00oOoOo;
    }

    public final SessionType O00oOooO() {
        return this.O0000o0O;
    }

    public final Hdr O00oOooo() {
        return this.O0000o0o;
    }

    public final Location O000O00o() {
        return this.O0000o;
    }

    public final Audio O000O0OO() {
        return this.O0000oO0;
    }

    public final cpz O000O0Oo() {
        return this.O000O0o0;
    }

    public final float O00oOoOo() {
        return this.O0000oO;
    }

    public final float O000O0o0() {
        return this.O0000oOO;
    }

    public final cpz O000O0o() {
        return this.O000O0o;
    }

    public final boolean O000O0oO() {
        int O000O0oo2 = O000O0oo();
        O00000oO.O000000o(1, "shouldFlipSizes:", "displayOffset=", Integer.valueOf(this.O000OO00), "sensorOffset=", Integer.valueOf(this.O000O0oo));
        O00000oO.O000000o(1, "shouldFlipSizes:", "sensorToDisplay=", Integer.valueOf(O000O0oo2));
        return O000O0oo2 % 180 != 0;
    }

    /* access modifiers changed from: protected */
    public final int O000O0oo() {
        if (this.O0000Oo == Facing.FRONT) {
            return (360 - ((this.O000O0oo + this.O000OO00) % 360)) % 360;
        }
        return ((this.O000O0oo - this.O000OO00) + 360) % 360;
    }

    /* access modifiers changed from: protected */
    public final int O000OO00() {
        if (this.O0000Oo == Facing.FRONT) {
            return ((this.O000O0oo - this.O000OO0o) + 360) % 360;
        }
        return (this.O000O0oo + this.O000OO0o) % 360;
    }

    /* access modifiers changed from: protected */
    public final cpz O000OO0o() {
        cqa cqa;
        CamcorderProfile camcorderProfile;
        boolean O000O0oO2 = O000O0oO();
        if (this.O0000o0O == SessionType.PICTURE) {
            cqa = cqb.O00000Oo(this.O00oOooo, new cqa() {
                /* class _m_j.cqb.AnonymousClass6 */

                public final List<cpz> O000000o(List<cpz> list) {
                    Collections.sort(list);
                    Collections.reverse(list);
                    return list;
                }
            });
        } else {
            switch (this.O0000o00) {
                case VideoQuality.HIGHEST:
                    camcorderProfile = CamcorderProfile.get(this.O0000oo0, 1);
                    break;
                case VideoQuality.MAX_2160P:
                    if (Build.VERSION.SDK_INT >= 21 && CamcorderProfile.hasProfile(8)) {
                        camcorderProfile = CamcorderProfile.get(this.O0000oo0, 8);
                        break;
                    }
                case VideoQuality.MAX_1080P:
                    if (CamcorderProfile.hasProfile(this.O0000oo0, 6)) {
                        camcorderProfile = CamcorderProfile.get(this.O0000oo0, 6);
                        break;
                    }
                case VideoQuality.MAX_720P:
                    if (CamcorderProfile.hasProfile(this.O0000oo0, 5)) {
                        camcorderProfile = CamcorderProfile.get(this.O0000oo0, 5);
                        break;
                    }
                case VideoQuality.MAX_480P:
                    if (CamcorderProfile.hasProfile(this.O0000oo0, 4)) {
                        camcorderProfile = CamcorderProfile.get(this.O0000oo0, 4);
                        break;
                    }
                case VideoQuality.MAX_QVGA:
                    if (CamcorderProfile.hasProfile(this.O0000oo0, 7)) {
                        camcorderProfile = CamcorderProfile.get(this.O0000oo0, 7);
                        break;
                    }
                default:
                    camcorderProfile = CamcorderProfile.get(this.O0000oo0, 0);
                    break;
            }
            cpk O000000o2 = cpk.O000000o(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
            if (O000O0oO2) {
                O000000o2 = cpk.O000000o(O000000o2.O00000o0, O000000o2.O00000Oo);
            }
            O00000oO.O000000o(1, "size:", "computeCaptureSize:", "videoQuality:", this.O0000o00, "targetRatio:", O000000o2);
            cqa O000000o3 = cqb.O000000o(O000000o2);
            cqa = cqb.O00000Oo(cqb.O000000o(O000000o3, this.O00oOooo), cqb.O000000o(O000000o3), this.O00oOooo);
        }
        cpz cpz = cqa.O000000o(new ArrayList(Collections.unmodifiableSet(this.O0000ooO.f14213O000000o))).get(0);
        O00000oO.O000000o("computePictureSize:", "result:", cpz, "flip:", Boolean.valueOf(O000O0oO2));
        return O000O0oO2 ? cpz.O000000o() : cpz;
    }

    /* access modifiers changed from: protected */
    public final cpz O00000Oo(List<cpz> list) {
        boolean O000O0oO2 = O000O0oO();
        cpk O000000o2 = cpk.O000000o(this.O000O0o0.f14222O000000o, this.O000O0o0.O00000Oo);
        cpz O00000o0 = this.O0000O0o.O00000o0();
        if (O000O0oO2) {
            O00000o0 = O00000o0.O000000o();
        }
        O00000oO.O000000o(1, "size:", "computePreviewSize:", "targetRatio:", O000000o2, "targetMinSize:", O00000o0);
        cqa O000000o3 = cqb.O000000o(O000000o2);
        cpz cpz = cqb.O00000Oo(cqb.O000000o(O000000o3, cqb.O000000o(cqb.O00000o(O00000o0.O00000Oo), cqb.O00000Oo(O00000o0.f14222O000000o))), cqb.O000000o(O000000o3, new cqa() {
            /* class _m_j.cqb.AnonymousClass6 */

            public final List<cpz> O000000o(List<cpz> list) {
                Collections.sort(list);
                Collections.reverse(list);
                return list;
            }
        }), new cqa() {
            /* class _m_j.cqb.AnonymousClass6 */

            public final List<cpz> O000000o(List<cpz> list) {
                Collections.sort(list);
                Collections.reverse(list);
                return list;
            }
        }).O000000o(list).get(0);
        O00000oO.O000000o(1, "computePreviewSize:", "result:", cpz, "flip:", Boolean.valueOf(O000O0oO2));
        return cpz;
    }
}
