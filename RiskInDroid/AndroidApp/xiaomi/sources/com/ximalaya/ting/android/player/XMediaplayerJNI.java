package com.ximalaya.ting.android.player;

import _m_j.ils;
import _m_j.ilt;
import _m_j.ilx;
import _m_j.imc;
import _m_j.ime;
import _m_j.imf;
import _m_j.imk;
import _m_j.imn;
import _m_j.ims;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class XMediaplayerJNI implements imn {
    public static String O0000o0 = "XMPLAY";

    /* renamed from: O000000o  reason: collision with root package name */
    private int f12233O000000o = -1;
    private int O00000Oo = 0;
    private boolean O00000o = true;
    private long O00000o0;
    private ils O00000oO;
    private ilx O00000oo;
    private ilt O0000O0o;
    private ims O0000OOo;
    public String O0000Oo = this.O0000Oo0;
    public String O0000Oo0;
    public boolean O0000OoO = false;
    public volatile boolean O0000Ooo = false;
    protected boolean O0000o = true;
    public AudioType O0000o00 = AudioType.NORMAL_FILE;
    protected long O0000o0O;
    public Context O0000o0o;
    public byte[] O0000oO;
    protected volatile boolean O0000oO0 = false;
    public int O0000oOO = 0;
    public imk.O0000OOo O0000oOo;
    private boolean O0000oo = false;
    private volatile boolean O0000oo0 = false;
    private float O0000ooO = 1.0f;
    private float O0000ooo = 0.0f;
    private float O00oOooO = 1.0f;

    public native int MediaplayerComplete(long j);

    public native int MediaplayerDestroy(long j);

    public native int MediaplayerFrameworkInit(Context context, boolean z);

    public native int MediaplayerGetCurPlayingFileType(long j);

    public native long MediaplayerGetCurrentDecodedDataTime(long j);

    public native long MediaplayerGetCurrentTime(long j);

    public native long MediaplayerGetMediaDuration(long j);

    public native int MediaplayerGetOutputData(byte[] bArr, int i, long j);

    public native long MediaplayerInit(Context context, boolean z, int i, int i2, int i3, int i4);

    public native int MediaplayerOutputDataAppointment(long j);

    public native int MediaplayerPause(long j);

    public native int MediaplayerPlay(long j);

    public native int MediaplayerPrepareAsync(long j);

    public native int MediaplayerReset(long j);

    public native int MediaplayerSeek(long j, long j2);

    public native int MediaplayerSetDataSourceInfo(String str, int i, long j, double d, double d2);

    public native int MediaplayerStop(long j);

    public abstract void O00000Oo(int i);

    public abstract void O00000o0(int i);

    public abstract void O0000Ooo();

    public abstract void O0000o00();

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public XMediaplayerJNI(Context context, boolean z) {
        this.O0000o0o = context.getApplicationContext();
        this.O0000oO0 = false;
        this.O0000o = z;
        int MediaplayerFrameworkInit = MediaplayerFrameworkInit(context, z);
        imc.O000000o(O0000o0, (Object) "MediaplayerFrameworkInit result:".concat(String.valueOf(MediaplayerFrameworkInit)));
        if (MediaplayerFrameworkInit < 0) {
            O00000o(NativeErrorType.ERR_ARCH_NOT_SUPPORT.value());
        }
    }

    public final AudioType O00000Oo() {
        return this.O0000o00;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    private ilt O0000o0o() {
        ilt ilt = this.O0000O0o;
        if (ilt != null && ilt.f1451O000000o) {
            this.O0000O0o = null;
        }
        if (this.O0000O0o == null) {
            imc.O000000o(O0000o0, (Object) "dataStreamInputFuncCallBackT getAudioTrackPlayThread new");
            this.O0000O0o = new ilt(this);
            this.O0000O0o.O000000o(this.O0000ooO, this.O0000ooo, this.O00oOooO);
        }
        return this.O0000O0o;
    }

    public final int O000000o(byte[] bArr, int i) {
        if (this.O0000O0o == null || this.O0000oO0) {
            return -1;
        }
        return MediaplayerGetOutputData(bArr, i, this.O0000o0O);
    }

    public final int O0000o0O() {
        return MediaplayerOutputDataAppointment(this.O0000o0O);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public void O0000O0o() {
        ils ils = this.O00000oO;
        if (ils != null && ils.O000000o()) {
            this.O00000oO.O00000oO = 0;
        }
        imc.O000000o(O0000o0, (Object) "prepareAsync");
        if (!this.O0000Ooo) {
            O00000Oo(701);
        }
        MediaplayerPrepareAsync(this.O0000o0O);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public void O000000o(int i, int i2) {
        imc.O000000o(O0000o0, (Object) "onErrorInner");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public void O0000Oo0() {
        imc.O000000o(O0000o0, (Object) "dataStreamInputFuncCallBackT stop");
        O0000o0o().O00000o0();
        O0000o();
        MediaplayerStop(this.O0000o0O);
        O0000oO0();
    }

    private void O0000o() {
        ils ils = this.O00000oO;
        if (ils != null) {
            ils.O000000o(ils.O00000o0);
        }
        ilx ilx = this.O00000oo;
        if (ilx != null) {
            ilx.O00000o();
        }
        ims ims = this.O0000OOo;
        if (ims != null) {
            ims.O000000o();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    private void O0000oO0() {
        this.O0000oo = false;
        this.O0000oOO = 0;
        this.O00000o = true;
        this.O0000oO = null;
        this.f12233O000000o = -1;
        this.O00000Oo = 0;
        this.O00000o0 = 0;
        ils ils = this.O00000oO;
        if (ils != null) {
            ils.O000000o(ils.O00000o0);
            imc.O000000o(O0000o0, (Object) "resetAllData mAudioFileRequestHandler.release()");
        } else {
            imc.O000000o(O0000o0, (Object) "resetAllData mAudioFileRequestHandler null");
        }
        ilx ilx = this.O00000oo;
        if (ilx != null) {
            ilx.O00000o();
            imc.O000000o(O0000o0, (Object) "resetAllData mHlsAudioFile.release()");
        } else {
            imc.O000000o(O0000o0, (Object) "resetAllData mHlsAudioFile null");
        }
        ims ims = this.O0000OOo;
        if (ims != null) {
            ims.O000000o();
            imc.O000000o(O0000o0, (Object) "resetAllData mFlvLiveAudioFile.release()");
        } else {
            imc.O000000o(O0000o0, (Object) "resetAllData mFlvLiveAudioFile null");
        }
        imc.O000000o(O0000o0, (Object) "dataStreamInputFuncCallBackT initAllData 重置0");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public void O00000oo() {
        imc.O000000o(O0000o0, (Object) "dataStreamInputFuncCallBackT pause");
        this.O0000oo = false;
        O0000o0o().O00000Oo();
        MediaplayerPause(this.O0000o0O);
        ims ims = this.O0000OOo;
        if (ims != null) {
            ims.O000000o();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public void O0000Oo() {
        this.O0000oO0 = true;
        O0000o();
        while (MediaplayerReset(this.O0000o0O) < 0) {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        imc.O000000o(O0000o0, (Object) "dataStreamInputFuncCallBackT release");
        O0000oO();
        O0000oO0();
        MediaplayerDestroy(this.O0000o0O);
        this.O0000oO = null;
        this.O0000ooO = 1.0f;
        this.O0000ooo = 0.0f;
        this.O00oOooO = 1.0f;
    }

    public int O00000o0() {
        return (int) MediaplayerGetCurrentTime(this.O0000o0O);
    }

    public int O00000o() {
        return (int) MediaplayerGetMediaDuration(this.O0000o0O);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public boolean O00000oO() {
        imc.O000000o(O0000o0, (Object) "dataStreamInputFuncCallBackT isPlaying");
        ilt O0000o0o2 = O0000o0o();
        return O0000o0o2.O00000Oo != null && O0000o0o2.O00000Oo.getPlayState() == 3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public void O0000OoO() {
        ilt O0000o0o2 = O0000o0o();
        O0000o0o2.O00000Oo();
        synchronized (O0000o0o2.O00000o0) {
            O0000o0o2.O00000o = null;
            if (O0000o0o2.O00000Oo != null && !O0000o0o2.f1451O000000o) {
                O0000o0o2.O00000Oo.flush();
            }
        }
        O0000o();
        imc.O000000o(O0000o0, (Object) "reset start");
        this.O0000oo0 = true;
        MediaplayerReset(this.O0000o0O);
        this.O0000oo0 = false;
        imc.O000000o(O0000o0, (Object) "reset end");
        O0000oO0();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public synchronized void O0000OOo() {
        String str = O0000o0;
        imc.O000000o(str, (Object) ("dataStreamInputFuncCallBackT start mAudioType" + this.O0000o00));
        if (this.O0000o00 != AudioType.FLV_FILE || this.O0000oo) {
            if (this.O00000oO != null && this.O00000oO.O000000o()) {
                this.O00000oO.O00000oO = 0;
            }
            O0000o0o().O000000o();
            MediaplayerPlay(this.O0000o0O);
        } else {
            imc.O000000o(O0000o0, (Object) "FLV_FILE start reset");
            O0000OoO();
            O00000Oo(this.O0000Oo0);
            O0000O0o();
        }
        this.O0000oo = false;
    }

    public final void O00000o0(String str) {
        ils ils = this.O00000oO;
        if (ils != null) {
            ils.O00000Oo = str;
            if (ils.f1450O000000o != null && !ils.f1450O000000o.O00000Oo) {
                ils.f1450O000000o.O00000oO = ils.O00000Oo;
            }
        }
    }

    public void O000000o(float f, float f2) {
        ilt O0000o0o2 = O0000o0o();
        if (O0000o0o2 != null) {
            O0000o0o2.O000000o(f);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    static {
        if (imf.O000000o()) {
            System.loadLibrary("xmediaplayer_x");
            return;
        }
        boolean O00000Oo2 = imf.O00000Oo();
        imc.O000000o(O0000o0, (Object) "loadLibrary xmediaplayer isArmV7Plus:".concat(String.valueOf(O00000Oo2)));
        if (O00000Oo2) {
            Log.i("loadLibrary", "xmediaplayerv7");
            System.loadLibrary("xmediaplayerv7");
            return;
        }
        Log.i("loadLibrary", "xmediaplayer");
        System.loadLibrary("xmediaplayer");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final void O00000o(int i) {
        NativeErrorType valueOf = NativeErrorType.valueOf(i);
        imc.O000000o(O0000o0, (Object) "handlePlayerStatus status:".concat(String.valueOf(i)));
        if (valueOf != null) {
            switch (AnonymousClass1.f12234O000000o[valueOf.ordinal()]) {
                case 1:
                    O000000o(8, -1004);
                    return;
                case 2:
                    O000000o(8, -1010);
                    return;
                case 3:
                    O000000o(8, 100);
                    return;
                case 4:
                    O000000o(8, -1004);
                    return;
                case 5:
                    O000000o(8, -1004);
                    return;
                case 6:
                    O000000o(8, 1);
                    return;
                case 7:
                    return;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    O000000o(8, -1011);
                    return;
                default:
                    O000000o(8, -1004);
                    return;
            }
        }
    }

    /* renamed from: com.ximalaya.ting.android.player.XMediaplayerJNI$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12234O000000o = new int[NativeErrorType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f12234O000000o[NativeErrorType.ERR_DECODEDATA_FILLIO_FAIL.ordinal()] = 1;
            f12234O000000o[NativeErrorType.ERR_DECODE_NOT_SUPPORT.ordinal()] = 2;
            f12234O000000o[NativeErrorType.ERR_FILE_MANAGER_INNER_ERR.ordinal()] = 3;
            f12234O000000o[NativeErrorType.ERR_M3U8STREAM_FILLIO_FAIL.ordinal()] = 4;
            f12234O000000o[NativeErrorType.ERR_M3U8_FILE_CONTENT_INVALID.ordinal()] = 5;
            f12234O000000o[NativeErrorType.ERR_NOTOK.ordinal()] = 6;
            f12234O000000o[NativeErrorType.NO_ERR.ordinal()] = 7;
            try {
                f12234O000000o[NativeErrorType.ERR_ARCH_NOT_SUPPORT.ordinal()] = 8;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public void O0000o0() {
        O0000oO0();
        MediaplayerComplete(this.O0000o0O);
        imc.O000000o(O0000o0, (Object) "flushAllDataInSoundTouch dataStreamInputFuncCallBackT onCompletionInner");
        O0000oO();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    private synchronized void O0000oO() {
        if (this.O0000O0o != null) {
            this.O0000O0o.O00000o();
            this.O0000O0o = null;
        }
        imc.O000000o(O0000o0, (Object) "releaseAudioTrackPlayThread releasePlay");
    }

    public enum AudioType {
        NORMAL_FILE(0),
        M3U8_STATIC_FILE(1),
        HLS_FILE(2),
        M3U8_FILE(3),
        XMLY_FORMAT(4),
        FLV_FILE(5);
        
        private int value = 0;

        private AudioType(int i) {
            this.value = i;
        }

        public static AudioType valueOf(int i) {
            if (i == 0) {
                return NORMAL_FILE;
            }
            if (i == 1) {
                return M3U8_STATIC_FILE;
            }
            if (i == 2) {
                return HLS_FILE;
            }
            if (i == 3) {
                return M3U8_FILE;
            }
            if (i == 4) {
                return XMLY_FORMAT;
            }
            if (i != 5) {
                return null;
            }
            return FLV_FILE;
        }

        public final int value() {
            return this.value;
        }
    }

    public enum NativeErrorType {
        NO_ERR(0),
        ERR_NOTOK(-1),
        ERR_DECODE_NOT_SUPPORT(-2),
        ERR_M3U8_FILE_CONTENT_INVALID(-3),
        ERR_FILE_MANAGER_INNER_ERR(-4),
        ERR_DECODEDATA_FILLIO_FAIL(-5),
        ERR_M3U8STREAM_FILLIO_FAIL(-6),
        ERR_ARCH_NOT_SUPPORT(-7),
        ERR_LIB_NOT_LOADED(-8),
        ERR_XMLY_DEC_ERR(-9),
        ERR_FLV_DEC_ERR(-10);
        
        private int value = 0;

        private NativeErrorType(int i) {
            this.value = i;
        }

        public static NativeErrorType valueOf(int i) {
            switch (i) {
                case -10:
                    return ERR_FLV_DEC_ERR;
                case SplitInstallErrorCode.SERVICE_DIED:
                    return ERR_XMLY_DEC_ERR;
                case -8:
                    return ERR_LIB_NOT_LOADED;
                case -7:
                    return ERR_ARCH_NOT_SUPPORT;
                case -6:
                    return ERR_M3U8STREAM_FILLIO_FAIL;
                case -5:
                    return ERR_DECODEDATA_FILLIO_FAIL;
                case -4:
                    return ERR_FILE_MANAGER_INNER_ERR;
                case -3:
                    return ERR_M3U8_FILE_CONTENT_INVALID;
                case -2:
                    return ERR_DECODE_NOT_SUPPORT;
                case -1:
                    return ERR_NOTOK;
                case 0:
                    return NO_ERR;
                default:
                    return ERR_NOTOK;
            }
        }

        public final int value() {
            return this.value;
        }
    }

    public final void O000000o(float f, float f2, float f3) {
        this.O0000ooO = f;
        this.O0000ooo = f2;
        this.O00oOooO = f3;
        ilt ilt = this.O0000O0o;
        if (ilt != null) {
            ilt.O000000o(f, f2, f3);
        }
    }

    public final void O000000o(imk.O0000OOo o0000OOo) {
        this.O0000oOo = o0000OOo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public void O000000o(int i) {
        if (!(this.O0000o00 == AudioType.FLV_FILE)) {
            imc.O000000o(O0000o0, (Object) "seekParaTimeStampMs msec:".concat(String.valueOf(i)));
            this.O0000OoO = true;
            MediaplayerSeek((long) i, this.O0000o0O);
            this.O0000OoO = false;
            O0000Ooo();
            O0000o00();
            String str = O0000o0;
            imc.O000000o(str, (Object) ("ttseek2:" + System.currentTimeMillis()));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00de, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ea, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00de A[ExcHandler: all (th java.lang.Throwable), Splitter:B:17:0x00c8] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e5 A[SYNTHETIC, Splitter:B:31:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f3 A[SYNTHETIC, Splitter:B:42:0x00f3] */
    public void O00000Oo(String str) {
        double d;
        double d2;
        RandomAccessFile randomAccessFile;
        this.O00000oO = null;
        this.O00000oo = null;
        this.O0000OOo = null;
        this.O0000oo = true;
        imc.O000000o(O0000o0, (Object) "flushAllDataInSoundTouch setDataSource src:".concat(String.valueOf(str)));
        this.O0000oOO = 0;
        O0000oO();
        if (str.contains("totalLength")) {
            String queryParameter = Uri.parse(str).getQueryParameter("totalLength");
            if (!TextUtils.isEmpty(queryParameter)) {
                this.O0000oOO = Integer.parseInt(queryParameter);
                imc.O000000o(O0000o0, (Object) ("chargeDataRealLength:" + this.O0000oOO));
            }
        }
        this.O0000Oo0 = str;
        if (this.O0000Oo0.contains(".flv")) {
            this.O0000OOo = new ims(this);
            this.O0000o00 = AudioType.FLV_FILE;
            MediaplayerSetDataSourceInfo(this.O0000Oo0, this.O0000o00.value(), this.O0000o0O, 0.0d, 0.0d);
        } else if (this.O0000Oo0.contains("m3u8")) {
            this.O00000oo = new ilx(this.O0000Oo0, this);
            this.O0000o00 = AudioType.M3U8_FILE;
            MediaplayerSetDataSourceInfo(this.O0000Oo0, this.O0000o00.value(), this.O0000o0O, 0.0d, 0.0d);
        } else if (this.O0000Oo0.endsWith(".xm")) {
            this.O00000oO = new ils(this);
            this.O0000o00 = AudioType.XMLY_FORMAT;
            try {
                randomAccessFile = new RandomAccessFile(this.O0000Oo0, "r");
                try {
                    randomAccessFile.seek(24);
                    d2 = randomAccessFile.readDouble();
                    double readDouble = randomAccessFile.readDouble();
                    try {
                        randomAccessFile.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    d = readDouble;
                } catch (IOException unused) {
                    if (randomAccessFile != null) {
                    }
                    d = 0.0d;
                    MediaplayerSetDataSourceInfo(this.O0000Oo0, this.O0000o00.value(), this.O0000o0O, d2, d);
                    imc.O000000o(O0000o0, (Object) ("setDataSource mAudioType:" + this.O0000o00.value()));
                    ime.O000000o().O000000o(this.O0000Oo0);
                } catch (Throwable th) {
                }
            } catch (IOException unused2) {
                randomAccessFile = null;
                d2 = 0.0d;
                if (randomAccessFile != null) {
                }
                d = 0.0d;
                MediaplayerSetDataSourceInfo(this.O0000Oo0, this.O0000o00.value(), this.O0000o0O, d2, d);
                imc.O000000o(O0000o0, (Object) ("setDataSource mAudioType:" + this.O0000o00.value()));
                ime.O000000o().O000000o(this.O0000Oo0);
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                Throwable th3 = th;
                if (randomAccessFile != null) {
                }
                throw th3;
            }
            MediaplayerSetDataSourceInfo(this.O0000Oo0, this.O0000o00.value(), this.O0000o0O, d2, d);
        } else {
            this.O00000oO = new ils(this);
            this.O0000o00 = AudioType.NORMAL_FILE;
            MediaplayerSetDataSourceInfo(this.O0000Oo0, this.O0000o00.value(), this.O0000o0O, 0.0d, 0.0d);
        }
        imc.O000000o(O0000o0, (Object) ("setDataSource mAudioType:" + this.O0000o00.value()));
        ime.O000000o().O000000o(this.O0000Oo0);
    }
}
