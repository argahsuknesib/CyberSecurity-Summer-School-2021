package _m_j;

import _m_j.cpq;
import _m_j.cpv;
import android.graphics.PointF;
import android.location.Location;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
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
            cqa = cqb.O00000Oo(this.O00oOooo, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001d: INVOKE  (r1v42 'cqa' _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r1v41 _m_j.cqa[]) = 
                  (wrap: _m_j.cqa : 0x0012: IGET  (r2v8 _m_j.cqa) = (r11v0 'this' _m_j.cpm A[THIS]) _m_j.cpm.O00oOooo _m_j.cqa)
                  (wrap: _m_j.cqb$6 : 0x0018: CONSTRUCTOR  (r2v9 _m_j.cqb$6) =  call: _m_j.cqb.6.<init>():void type: CONSTRUCTOR)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O00000Oo(_m_j.cqa[]):_m_j.cqa in method: _m_j.cpm.O000OO0o():_m_j.cpz, dex: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: CONSTRUCTOR  (r2v9 _m_j.cqb$6) =  call: _m_j.cqb.6.<init>():void type: CONSTRUCTOR in method: _m_j.cpm.O000OO0o():_m_j.cpz, dex: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                	at jadx.core.codegen.InsnGen.processVarArg(InsnGen.java:814)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 36 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.cqb, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 43 more
                */
            /*
                this = this;
                boolean r0 = r11.O000O0oO()
                com.otaliastudios.cameraview.SessionType r1 = r11.O0000o0O
                com.otaliastudios.cameraview.SessionType r2 = com.otaliastudios.cameraview.SessionType.PICTURE
                r3 = 3
                r4 = 4
                r5 = 5
                r6 = 2
                r7 = 1
                r8 = 0
                if (r1 != r2) goto L_0x0023
                _m_j.cqa[] r1 = new _m_j.cqa[r6]
                _m_j.cqa r2 = r11.O00oOooo
                r1[r8] = r2
                _m_j.cqb$6 r2 = new _m_j.cqb$6
                r2.<init>()
                r1[r7] = r2
                _m_j.cqa r1 = _m_j.cqb.O00000Oo(r1)
                goto L_0x00e6
            L_0x0023:
                int[] r1 = _m_j.cpm.AnonymousClass6.f14211O000000o
                com.otaliastudios.cameraview.VideoQuality r2 = r11.O0000o00
                int r2 = r2.ordinal()
                r1 = r1[r2]
                r2 = 6
                switch(r1) {
                    case 1: goto L_0x0084;
                    case 2: goto L_0x0032;
                    case 3: goto L_0x0047;
                    case 4: goto L_0x0056;
                    case 5: goto L_0x0065;
                    case 6: goto L_0x0074;
                    default: goto L_0x0031;
                }
            L_0x0031:
                goto L_0x008b
            L_0x0032:
                int r1 = android.os.Build.VERSION.SDK_INT
                r9 = 21
                if (r1 < r9) goto L_0x0047
                r1 = 8
                boolean r9 = android.media.CamcorderProfile.hasProfile(r1)
                if (r9 == 0) goto L_0x0047
                int r9 = r11.O0000oo0
                android.media.CamcorderProfile r1 = android.media.CamcorderProfile.get(r9, r1)
                goto L_0x0091
            L_0x0047:
                int r1 = r11.O0000oo0
                boolean r1 = android.media.CamcorderProfile.hasProfile(r1, r2)
                if (r1 == 0) goto L_0x0056
                int r1 = r11.O0000oo0
                android.media.CamcorderProfile r1 = android.media.CamcorderProfile.get(r1, r2)
                goto L_0x0091
            L_0x0056:
                int r1 = r11.O0000oo0
                boolean r1 = android.media.CamcorderProfile.hasProfile(r1, r5)
                if (r1 == 0) goto L_0x0065
                int r1 = r11.O0000oo0
                android.media.CamcorderProfile r1 = android.media.CamcorderProfile.get(r1, r5)
                goto L_0x0091
            L_0x0065:
                int r1 = r11.O0000oo0
                boolean r1 = android.media.CamcorderProfile.hasProfile(r1, r4)
                if (r1 == 0) goto L_0x0074
                int r1 = r11.O0000oo0
                android.media.CamcorderProfile r1 = android.media.CamcorderProfile.get(r1, r4)
                goto L_0x0091
            L_0x0074:
                int r1 = r11.O0000oo0
                r9 = 7
                boolean r1 = android.media.CamcorderProfile.hasProfile(r1, r9)
                if (r1 == 0) goto L_0x008b
                int r1 = r11.O0000oo0
                android.media.CamcorderProfile r1 = android.media.CamcorderProfile.get(r1, r9)
                goto L_0x0091
            L_0x0084:
                int r1 = r11.O0000oo0
                android.media.CamcorderProfile r1 = android.media.CamcorderProfile.get(r1, r7)
                goto L_0x0091
            L_0x008b:
                int r1 = r11.O0000oo0
                android.media.CamcorderProfile r1 = android.media.CamcorderProfile.get(r1, r8)
            L_0x0091:
                int r9 = r1.videoFrameWidth
                int r1 = r1.videoFrameHeight
                _m_j.cpk r1 = _m_j.cpk.O000000o(r9, r1)
                if (r0 == 0) goto L_0x00a3
                int r9 = r1.O00000o0
                int r1 = r1.O00000Oo
                _m_j.cpk r1 = _m_j.cpk.O000000o(r9, r1)
            L_0x00a3:
                _m_j.cpo r9 = _m_j.cpm.O00000oO
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.String r10 = "size:"
                r2[r8] = r10
                java.lang.String r10 = "computeCaptureSize:"
                r2[r7] = r10
                java.lang.String r10 = "videoQuality:"
                r2[r6] = r10
                com.otaliastudios.cameraview.VideoQuality r10 = r11.O0000o00
                r2[r3] = r10
                java.lang.String r10 = "targetRatio:"
                r2[r4] = r10
                r2[r5] = r1
                r9.O000000o(r7, r2)
                _m_j.cqa r1 = _m_j.cqb.O000000o(r1)
                _m_j.cqa[] r2 = new _m_j.cqa[r3]
                _m_j.cqa[] r9 = new _m_j.cqa[r6]
                r9[r8] = r1
                _m_j.cqa r10 = r11.O00oOooo
                r9[r7] = r10
                _m_j.cqa r9 = _m_j.cqb.O000000o(r9)
                r2[r8] = r9
                _m_j.cqa[] r9 = new _m_j.cqa[r7]
                r9[r8] = r1
                _m_j.cqa r1 = _m_j.cqb.O000000o(r9)
                r2[r7] = r1
                _m_j.cqa r1 = r11.O00oOooo
                r2[r6] = r1
                _m_j.cqa r1 = _m_j.cqb.O00000Oo(r2)
            L_0x00e6:
                java.util.ArrayList r2 = new java.util.ArrayList
                _m_j.cpp r9 = r11.O0000ooO
                java.util.Set<_m_j.cpz> r9 = r9.f14213O000000o
                java.util.Set r9 = java.util.Collections.unmodifiableSet(r9)
                r2.<init>(r9)
                java.util.List r1 = r1.O000000o(r2)
                java.lang.Object r1 = r1.get(r8)
                _m_j.cpz r1 = (_m_j.cpz) r1
                _m_j.cpo r2 = _m_j.cpm.O00000oO
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r9 = "computePictureSize:"
                r5[r8] = r9
                java.lang.String r8 = "result:"
                r5[r7] = r8
                r5[r6] = r1
                java.lang.String r6 = "flip:"
                r5[r3] = r6
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
                r5[r4] = r3
                r2.O000000o(r5)
                if (r0 == 0) goto L_0x011e
                _m_j.cpz r1 = r1.O000000o()
            L_0x011e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: _m_j.cpm.O000OO0o():_m_j.cpz");
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
            cpz cpz = cqb.O00000Oo(cqb.O000000o(O000000o3, cqb.O000000o(cqb.O00000o(O00000o0.O00000Oo), cqb.O00000Oo(O00000o0.f14222O000000o))), cqb.O000000o(O000000o3, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x008a: INVOKE  (r13v3 'cpz' _m_j.cpz) = 
                  (wrap: java.util.List<_m_j.cpz> : 0x0082: INVOKE  (r13v1 java.util.List<_m_j.cpz>) = 
                  (wrap: _m_j.cqa : 0x007e: INVOKE  (r1v7 _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r3v2 _m_j.cqa[]) = 
                  (wrap: _m_j.cqa : 0x0060: INVOKE  (r2v8 _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r4v4 _m_j.cqa[]) = 
                  (r1v3 'O000000o3' _m_j.cqa)
                  (wrap: _m_j.cqa : 0x0054: INVOKE  (r2v7 _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r3v1 _m_j.cqa[]) = 
                  (wrap: _m_j.cqa : 0x0046: INVOKE  (r4v3 _m_j.cqa) = (wrap: int : 0x0044: IGET  (r4v2 int) = (r2v4 'O00000o0' _m_j.cpz) _m_j.cpz.O00000Oo int) type: STATIC call: _m_j.cqb.O00000o(int):_m_j.cqa)
                  (wrap: _m_j.cqa : 0x004e: INVOKE  (r2v6 _m_j.cqa) = (wrap: int : 0x004c: IGET  (r2v5 int) = (r2v4 'O00000o0' _m_j.cpz) _m_j.cpz.O000000o int) type: STATIC call: _m_j.cqb.O00000Oo(int):_m_j.cqa)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O000000o(_m_j.cqa[]):_m_j.cqa)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O000000o(_m_j.cqa[]):_m_j.cqa)
                  (wrap: _m_j.cqa : 0x0071: INVOKE  (r1v5 _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r2v9 _m_j.cqa[]) = 
                  (r1v3 'O000000o3' _m_j.cqa)
                  (wrap: _m_j.cqb$6 : 0x006c: CONSTRUCTOR  (r1v4 _m_j.cqb$6) =  call: _m_j.cqb.6.<init>():void type: CONSTRUCTOR)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O000000o(_m_j.cqa[]):_m_j.cqa)
                  (wrap: _m_j.cqb$6 : 0x0079: CONSTRUCTOR  (r1v6 _m_j.cqb$6) =  call: _m_j.cqb.6.<init>():void type: CONSTRUCTOR)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O00000Oo(_m_j.cqa[]):_m_j.cqa)
                  (r13v0 'list' java.util.List<_m_j.cpz>)
                 type: INTERFACE call: _m_j.cqa.O000000o(java.util.List):java.util.List)
                  (0 int)
                 type: INTERFACE call: java.util.List.get(int):java.lang.Object in method: _m_j.cpm.O00000Oo(java.util.List<_m_j.cpz>):_m_j.cpz, dex: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0082: INVOKE  (r13v1 java.util.List<_m_j.cpz>) = 
                  (wrap: _m_j.cqa : 0x007e: INVOKE  (r1v7 _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r3v2 _m_j.cqa[]) = 
                  (wrap: _m_j.cqa : 0x0060: INVOKE  (r2v8 _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r4v4 _m_j.cqa[]) = 
                  (r1v3 'O000000o3' _m_j.cqa)
                  (wrap: _m_j.cqa : 0x0054: INVOKE  (r2v7 _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r3v1 _m_j.cqa[]) = 
                  (wrap: _m_j.cqa : 0x0046: INVOKE  (r4v3 _m_j.cqa) = (wrap: int : 0x0044: IGET  (r4v2 int) = (r2v4 'O00000o0' _m_j.cpz) _m_j.cpz.O00000Oo int) type: STATIC call: _m_j.cqb.O00000o(int):_m_j.cqa)
                  (wrap: _m_j.cqa : 0x004e: INVOKE  (r2v6 _m_j.cqa) = (wrap: int : 0x004c: IGET  (r2v5 int) = (r2v4 'O00000o0' _m_j.cpz) _m_j.cpz.O000000o int) type: STATIC call: _m_j.cqb.O00000Oo(int):_m_j.cqa)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O000000o(_m_j.cqa[]):_m_j.cqa)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O000000o(_m_j.cqa[]):_m_j.cqa)
                  (wrap: _m_j.cqa : 0x0071: INVOKE  (r1v5 _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r2v9 _m_j.cqa[]) = 
                  (r1v3 'O000000o3' _m_j.cqa)
                  (wrap: _m_j.cqb$6 : 0x006c: CONSTRUCTOR  (r1v4 _m_j.cqb$6) =  call: _m_j.cqb.6.<init>():void type: CONSTRUCTOR)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O000000o(_m_j.cqa[]):_m_j.cqa)
                  (wrap: _m_j.cqb$6 : 0x0079: CONSTRUCTOR  (r1v6 _m_j.cqb$6) =  call: _m_j.cqb.6.<init>():void type: CONSTRUCTOR)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O00000Oo(_m_j.cqa[]):_m_j.cqa)
                  (r13v0 'list' java.util.List<_m_j.cpz>)
                 type: INTERFACE call: _m_j.cqa.O000000o(java.util.List):java.util.List in method: _m_j.cpm.O00000Oo(java.util.List<_m_j.cpz>):_m_j.cpz, dex: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 31 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007e: INVOKE  (r1v7 _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r3v2 _m_j.cqa[]) = 
                  (wrap: _m_j.cqa : 0x0060: INVOKE  (r2v8 _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r4v4 _m_j.cqa[]) = 
                  (r1v3 'O000000o3' _m_j.cqa)
                  (wrap: _m_j.cqa : 0x0054: INVOKE  (r2v7 _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r3v1 _m_j.cqa[]) = 
                  (wrap: _m_j.cqa : 0x0046: INVOKE  (r4v3 _m_j.cqa) = (wrap: int : 0x0044: IGET  (r4v2 int) = (r2v4 'O00000o0' _m_j.cpz) _m_j.cpz.O00000Oo int) type: STATIC call: _m_j.cqb.O00000o(int):_m_j.cqa)
                  (wrap: _m_j.cqa : 0x004e: INVOKE  (r2v6 _m_j.cqa) = (wrap: int : 0x004c: IGET  (r2v5 int) = (r2v4 'O00000o0' _m_j.cpz) _m_j.cpz.O000000o int) type: STATIC call: _m_j.cqb.O00000Oo(int):_m_j.cqa)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O000000o(_m_j.cqa[]):_m_j.cqa)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O000000o(_m_j.cqa[]):_m_j.cqa)
                  (wrap: _m_j.cqa : 0x0071: INVOKE  (r1v5 _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r2v9 _m_j.cqa[]) = 
                  (r1v3 'O000000o3' _m_j.cqa)
                  (wrap: _m_j.cqb$6 : 0x006c: CONSTRUCTOR  (r1v4 _m_j.cqb$6) =  call: _m_j.cqb.6.<init>():void type: CONSTRUCTOR)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O000000o(_m_j.cqa[]):_m_j.cqa)
                  (wrap: _m_j.cqb$6 : 0x0079: CONSTRUCTOR  (r1v6 _m_j.cqb$6) =  call: _m_j.cqb.6.<init>():void type: CONSTRUCTOR)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O00000Oo(_m_j.cqa[]):_m_j.cqa in method: _m_j.cpm.O00000Oo(java.util.List<_m_j.cpz>):_m_j.cpz, dex: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:90)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:699)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 37 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0071: INVOKE  (r1v5 _m_j.cqa) = 
                  (wrap: _m_j.cqa[] : ?: FILLED_NEW_ARRAY  (r2v9 _m_j.cqa[]) = 
                  (r1v3 'O000000o3' _m_j.cqa)
                  (wrap: _m_j.cqb$6 : 0x006c: CONSTRUCTOR  (r1v4 _m_j.cqb$6) =  call: _m_j.cqb.6.<init>():void type: CONSTRUCTOR)
                 elemType: _m_j.cqa)
                 type: STATIC call: _m_j.cqb.O000000o(_m_j.cqa[]):_m_j.cqa in method: _m_j.cpm.O00000Oo(java.util.List<_m_j.cpz>):_m_j.cpz, dex: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                	at jadx.core.codegen.InsnGen.processVarArg(InsnGen.java:814)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 43 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006c: CONSTRUCTOR  (r1v4 _m_j.cqb$6) =  call: _m_j.cqb.6.<init>():void type: CONSTRUCTOR in method: _m_j.cpm.O00000Oo(java.util.List<_m_j.cpz>):_m_j.cpz, dex: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                	at jadx.core.codegen.InsnGen.processVarArg(InsnGen.java:814)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 50 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.cqb, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 57 more
                */
            /*
                this = this;
                boolean r0 = r12.O000O0oO()
                _m_j.cpz r1 = r12.O000O0o0
                int r1 = r1.f14222O000000o
                _m_j.cpz r2 = r12.O000O0o0
                int r2 = r2.O00000Oo
                _m_j.cpk r1 = _m_j.cpk.O000000o(r1, r2)
                _m_j.cpq r2 = r12.O0000O0o
                _m_j.cpz r2 = r2.O00000o0()
                if (r0 == 0) goto L_0x001c
                _m_j.cpz r2 = r2.O000000o()
            L_0x001c:
                _m_j.cpo r3 = _m_j.cpm.O00000oO
                r4 = 6
                java.lang.Object[] r4 = new java.lang.Object[r4]
                r5 = 0
                java.lang.String r6 = "size:"
                r4[r5] = r6
                java.lang.String r6 = "computePreviewSize:"
                r7 = 1
                r4[r7] = r6
                r8 = 2
                java.lang.String r9 = "targetRatio:"
                r4[r8] = r9
                r9 = 3
                r4[r9] = r1
                r10 = 4
                java.lang.String r11 = "targetMinSize:"
                r4[r10] = r11
                r11 = 5
                r4[r11] = r2
                r3.O000000o(r7, r4)
                _m_j.cqa r1 = _m_j.cqb.O000000o(r1)
                _m_j.cqa[] r3 = new _m_j.cqa[r8]
                int r4 = r2.O00000Oo
                _m_j.cqa r4 = _m_j.cqb.O00000o(r4)
                r3[r5] = r4
                int r2 = r2.f14222O000000o
                _m_j.cqa r2 = _m_j.cqb.O00000Oo(r2)
                r3[r7] = r2
                _m_j.cqa r2 = _m_j.cqb.O000000o(r3)
                _m_j.cqa[] r3 = new _m_j.cqa[r9]
                _m_j.cqa[] r4 = new _m_j.cqa[r8]
                r4[r5] = r1
                r4[r7] = r2
                _m_j.cqa r2 = _m_j.cqb.O000000o(r4)
                r3[r5] = r2
                _m_j.cqa[] r2 = new _m_j.cqa[r8]
                r2[r5] = r1
                _m_j.cqb$6 r1 = new _m_j.cqb$6
                r1.<init>()
                r2[r7] = r1
                _m_j.cqa r1 = _m_j.cqb.O000000o(r2)
                r3[r7] = r1
                _m_j.cqb$6 r1 = new _m_j.cqb$6
                r1.<init>()
                r3[r8] = r1
                _m_j.cqa r1 = _m_j.cqb.O00000Oo(r3)
                java.util.List r13 = r1.O000000o(r13)
                java.lang.Object r13 = r13.get(r5)
                _m_j.cpz r13 = (_m_j.cpz) r13
                _m_j.cpo r1 = _m_j.cpm.O00000oO
                java.lang.Object[] r2 = new java.lang.Object[r11]
                r2[r5] = r6
                java.lang.String r3 = "result:"
                r2[r7] = r3
                r2[r8] = r13
                java.lang.String r3 = "flip:"
                r2[r9] = r3
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                r2[r10] = r0
                r1.O000000o(r7, r2)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: _m_j.cpm.O00000Oo(java.util.List):_m_j.cpz");
        }
    }
