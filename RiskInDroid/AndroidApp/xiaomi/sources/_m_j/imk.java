package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.ximalaya.ting.android.player.XMediaplayerJNI;
import java.io.FileDescriptor;

public final class imk extends XMediaplayerJNI implements Handler.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile int f1474O000000o;
    public O0000Oo O00000Oo;
    public O00000Oo O00000o;
    public O00000o0 O00000o0;
    public O0000o00 O00000oO;
    public O00000o O00000oo;
    public O0000O0o O0000O0o;
    public O0000Oo0 O0000OOo;
    private Handler O0000oo;
    private Context O0000oo0;
    private HandlerThread O0000ooO;
    private PowerManager.WakeLock O0000ooo = null;
    private long O000O00o = System.currentTimeMillis();
    private boolean O00oOooO;
    private O000000o O00oOooo;

    public interface O00000Oo {
        void O000000o(int i);
    }

    public interface O00000o {
        boolean O000000o(int i, int i2);
    }

    public interface O00000o0 {
        void O000000o();
    }

    public interface O0000O0o {
        boolean O000000o(int i);
    }

    public interface O0000OOo {
    }

    public interface O0000Oo {
        void O000000o(imn imn);
    }

    public interface O0000Oo0 {
        void O000000o(imn imn, int i);
    }

    public interface O0000o00 {
        void O000000o();
    }

    public imk(Context context, boolean z) {
        super(context, z);
        this.O0000oo0 = context.getApplicationContext();
        this.f1474O000000o = 1;
        this.O0000ooO = new img(getClass().getSimpleName() + ":HandlerForPlayer");
        this.O0000ooO.start();
        this.O0000oo = new Handler(this.O0000ooO.getLooper(), this);
        this.O0000oo.obtainMessage(10).sendToTarget();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.O00oOooo = new O000000o(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.O00oOooo = new O000000o(this, mainLooper);
            } else {
                this.O00oOooo = null;
            }
        }
        imc.O000000o("Mediaplayer XMediaPlayer init()");
    }

    public final void O00000Oo(String str) {
        this.O0000oo.obtainMessage(8, str).sendToTarget();
    }

    public final void O0000O0o() {
        this.O0000oo.obtainMessage(1).sendToTarget();
    }

    public final void O0000OOo() {
        O000000o(true);
        this.O0000oo.removeMessages(3);
        this.O0000oo.removeMessages(0);
        this.O0000oo.obtainMessage(0).sendToTarget();
    }

    public final void O0000Oo0() {
        O000000o(false);
        this.O0000oo.removeMessages(3);
        this.O0000oo.removeMessages(0);
        this.O0000oo.removeMessages(6);
        this.O0000oo.obtainMessage(4).sendToTarget();
    }

    public final void O00000oo() {
        O000000o(false);
        this.O0000oo.removeMessages(3);
        this.O0000oo.removeMessages(0);
        this.O0000oo.obtainMessage(3).sendToTarget();
    }

    public final void O0000Oo() {
        O000000o(false);
        this.O0000oo.removeCallbacksAndMessages(null);
        this.O00oOooo.removeCallbacksAndMessages(null);
        this.O00000Oo = null;
        this.O00000o = null;
        this.O00000o0 = null;
        this.O00000oO = null;
        this.O00000oo = null;
        this.O0000O0o = null;
        this.O0000OOo = null;
        this.O0000oo.obtainMessage(5).sendToTarget();
    }

    private void O000000o(boolean z) {
        PowerManager.WakeLock wakeLock = this.O0000ooo;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.O0000ooo.acquire();
            } else if (!z && this.O0000ooo.isHeld()) {
                this.O0000ooo.release();
            }
        }
        this.O00oOooO = z;
    }

    public final void O000000o(FileDescriptor fileDescriptor, String str) {
        O00000Oo(str);
    }

    public final int O00000o0() {
        if (this.f1474O000000o == 12) {
            return 0;
        }
        return super.O00000o0();
    }

    public final int O00000o() {
        if (this.f1474O000000o == 12) {
            return 0;
        }
        return super.O00000o();
    }

    public final boolean O00000oO() {
        if (this.f1474O000000o == 12 || this.f1474O000000o == 3 || !super.O00000oO() || this.f1474O000000o != 4) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final void O0000OoO() {
        O000000o(false);
        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_RESET start send");
        this.O0000oo.removeCallbacksAndMessages(null);
        this.O00oOooo.removeCallbacksAndMessages(null);
        this.O0000oo.obtainMessage(7).sendToTarget();
    }

    public final void O000000o(int i) {
        this.O0000oo.removeMessages(6);
        this.O0000oo.obtainMessage(6, Integer.valueOf(i)).sendToTarget();
    }

    public final void O000000o(float f, float f2) {
        super.O000000o(f, f2);
    }

    public final int O000000o() {
        return this.f1474O000000o;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final boolean handleMessage(Message message) {
        if (this.f1474O000000o == 12) {
            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 mPlayState NOT_ARCH_SUPPORT");
            return true;
        }
        String str = XMediaplayerJNI.O0000o0;
        imc.O000000o(str, (Object) ("handleMessage00 mPlayState:" + this.f1474O000000o));
        try {
            switch (message.what) {
                case 0:
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 STARTED start");
                    this.f1474O000000o = 4;
                    super.O0000OOo();
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 STARTED end");
                    break;
                case 1:
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_PREPARE start");
                    this.f1474O000000o = 2;
                    super.O0000O0o();
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_PREPARE end");
                    return true;
                case 2:
                default:
                    return false;
                case 3:
                    if (this.f1474O000000o != 8) {
                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_PAUSE start");
                        this.f1474O000000o = 5;
                        super.O00000oo();
                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_PAUSE end");
                    }
                    return true;
                case 4:
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_STOP start");
                    this.f1474O000000o = 6;
                    super.O0000Oo0();
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_STOP end");
                    return true;
                case 5:
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_RELEASE start");
                    this.f1474O000000o = 9;
                    super.O0000Oo();
                    this.O0000ooO.getLooper().quit();
                    this.O0000ooO.interrupt();
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_RELEASE end");
                    return true;
                case 6:
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_SEEK_TO start");
                    super.O000000o(((Integer) message.obj).intValue());
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_SEEK_TO end");
                    return true;
                case 7:
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_RESET start");
                    this.f1474O000000o = 0;
                    super.O0000OoO();
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_RESET end");
                    this.f1474O000000o = 0;
                    return true;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    if (message.obj != null) {
                        super.O00000Oo(message.obj.toString());
                    }
                    return true;
                case 9:
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_COMPLETE start");
                    this.f1474O000000o = 11;
                    super.O0000o0();
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage00 MSG_COMPLETE end");
                    return true;
                case 10:
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "Mediaplayer handleMessage00 MSG_INIT start");
                    this.O0000oO0 = false;
                    String str2 = XMediaplayerJNI.O0000o0;
                    imc.O000000o(str2, (Object) ("Mediaplayer Init 0000000000:" + this.O0000o0O));
                    this.O0000o0O = MediaplayerInit(this.O0000o0o, this.O0000o, 524288, 65536, ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES, ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
                    String str3 = XMediaplayerJNI.O0000o0;
                    imc.O000000o(str3, (Object) ("Mediaplayer Init 1:" + this.O0000o0O));
                    String str4 = XMediaplayerJNI.O0000o0;
                    imc.O000000o(str4, (Object) ("MediaplayerInit jniHandler:" + this.O0000o0O));
                    if (this.O0000o0O == 0) {
                        O00000o(XMediaplayerJNI.NativeErrorType.ERR_ARCH_NOT_SUPPORT.value());
                    }
                    ime.O000000o().O00000o0();
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "Mediaplayer handleMessage00 MSG_INIT end");
                    return true;
            }
        } catch (Exception unused) {
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final void O0000Ooo() {
        imc.O000000o(O0000o0, (Object) "onSeekCompletedInner");
        O000000o o000000o = this.O00oOooo;
        if (o000000o != null) {
            o000000o.obtainMessage(4).sendToTarget();
        }
    }

    public final void O00000Oo(int i) {
        if (this.f1474O000000o == 4 || this.f1474O000000o == 2) {
            if (i == 701) {
                this.O0000Ooo = true;
            } else if (i == 702) {
                this.O0000Ooo = false;
            }
            O000000o o000000o = this.O00oOooo;
            if (o000000o != null) {
                o000000o.obtainMessage(200, i, i).sendToTarget();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final void O000000o(int i, int i2) {
        if (i2 == -1011) {
            this.f1474O000000o = 12;
            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "onErrorInner mPlayState NOT_ARCH_SUPPORT");
        } else {
            String str = XMediaplayerJNI.O0000o0;
            imc.O000000o(str, (Object) ("onErrorInner errorCode:" + i + "extra:" + i2));
            this.f1474O000000o = 8;
        }
        super.O000000o(i, i2);
        O000000o(false);
        O000000o o000000o = this.O00oOooo;
        if (o000000o != null) {
            o000000o.obtainMessage(100, i, i2).sendToTarget();
        }
    }

    public final void O0000o00() {
        O000000o o000000o = this.O00oOooo;
        if (o000000o != null) {
            o000000o.removeMessages(202);
            this.O00oOooo.obtainMessage(202).sendToTarget();
        }
    }

    public final void O0000o0() {
        O000000o(false);
        this.O0000oo.obtainMessage(9).sendToTarget();
        O000000o o000000o = this.O00oOooo;
        if (o000000o != null) {
            o000000o.obtainMessage(2).sendToTarget();
        }
    }

    public final void O00000o0(int i) {
        if (this.O00oOooo != null && System.currentTimeMillis() - this.O000O00o >= 1000) {
            this.O000O00o = System.currentTimeMillis();
            this.O00oOooo.removeMessages(3);
            this.O00oOooo.obtainMessage(3, i, 0).sendToTarget();
        }
    }

    class O000000o extends Handler {
        private imk O00000Oo;

        public O000000o(imk imk, Looper looper) {
            super(looper);
            this.O00000Oo = imk;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.imc.O000000o(java.lang.String, java.lang.String):void
          _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
        public final void handleMessage(Message message) {
            if (imk.this.f1474O000000o != 12 || message.what == 100) {
                String str = XMediaplayerJNI.O0000o0;
                imc.O000000o(str, (Object) ("handleMessage11 mPlayState:" + imk.this.f1474O000000o));
                int i = message.what;
                if (i == 0) {
                    return;
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i == 99) {
                                    return;
                                }
                                if (i != 100) {
                                    switch (i) {
                                        case 6:
                                        case 7:
                                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                                            return;
                                        case 9:
                                            return;
                                        default:
                                            switch (i) {
                                                case 200:
                                                    if (imk.this.O0000O0o != null) {
                                                        O0000O0o o0000O0o = imk.this.O0000O0o;
                                                        int i2 = message.arg1;
                                                        int i3 = message.arg2;
                                                        o0000O0o.O000000o(i2);
                                                        return;
                                                    }
                                                    return;
                                                case 201:
                                                    return;
                                                case 202:
                                                    if (imk.this.O0000OOo != null && !imk.this.O0000OoO) {
                                                        O0000Oo0 o0000Oo0 = imk.this.O0000OOo;
                                                        imk imk = this.O00000Oo;
                                                        o0000Oo0.O000000o(imk, imk.O00000o0());
                                                        return;
                                                    }
                                                    return;
                                                default:
                                                    String str2 = XMediaplayerJNI.O0000o0;
                                                    imc.O000000o(str2, (Object) ("Unknown message type " + message.what));
                                                    return;
                                            }
                                    }
                                } else {
                                    String str3 = XMediaplayerJNI.O0000o0;
                                    imc.O000000o(str3, (Object) ("Error (" + message.arg1 + "," + message.arg2 + ")"));
                                    boolean z = false;
                                    if (imk.this.O00000oo != null) {
                                        z = imk.this.O00000oo.O000000o(message.arg1, message.arg2);
                                    }
                                    if (imk.this.O00000o0 != null && !z) {
                                        imk.this.O00000o0.O000000o();
                                    }
                                }
                            } else if (imk.this.O00000oO != null) {
                                imk.this.O00000oO.O000000o();
                            }
                        } else if (imk.this.O00000o != null) {
                            imk.this.O00000o.O000000o(message.arg1);
                        }
                    } else if (imk.this.O00000o0 != null) {
                        imk.this.O00000o0.O000000o();
                    }
                } else if (imk.this.O00000Oo != null) {
                    imk.this.O00000Oo.O000000o(this.O00000Oo);
                }
            } else {
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "handleMessage11 mPlayState NOT_ARCH_SUPPORT");
            }
        }
    }

    public final void O000000o(O0000Oo o0000Oo) {
        this.O00000Oo = o0000Oo;
    }

    public final void O000000o(O00000o0 o00000o0) {
        this.O00000o0 = o00000o0;
    }

    public final void O000000o(O00000Oo o00000Oo) {
        this.O00000o = o00000Oo;
    }

    public final void O000000o(O0000o00 o0000o00) {
        this.O00000oO = o0000o00;
    }

    public final void O000000o(O00000o o00000o) {
        this.O00000oo = o00000o;
    }

    public final void O000000o(O0000O0o o0000O0o) {
        this.O0000O0o = o0000O0o;
    }

    public final void O000000o(O0000Oo0 o0000Oo0) {
        this.O0000OOo = o0000Oo0;
    }

    public final void O000000o(imu imu) {
        imj.O000000o(imu);
    }
}
