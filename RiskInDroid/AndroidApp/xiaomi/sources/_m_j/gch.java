package _m_j;

import _m_j.gcg;
import android.text.TextUtils;
import android.util.Base64;
import com.madv.soundtouch.SoundTouch;
import com.mijia.generalplayer.utils.AudioBroadcastReceiver;
import com.tutk.IAudioSender;
import com.tutk.IOTC.Packet;
import com.xiaomi.aaccodec.AACEncodeEx;
import com.xiaomi.aaccodec.G711;
import com.xiaomi.smarthome.camera.AVFrame;
import com.xiaomi.smarthome.camera.ICameraPlayerListener;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.MissConfig;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmP2PInfo;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.util.Arrays;
import java.util.Timer;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class gch implements gcg, ICameraPlayerListener {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final cid f17525O000000o;
    public final IXmConnectionClient O00000Oo;
    protected boolean O00000o;
    protected cqj O00000o0;
    public int O00000oO;
    public gcg.O000000o O00000oo;
    public boolean O0000O0o;
    protected boolean O0000OOo;
    private ScheduledThreadPoolExecutor O0000Oo;
    private final boolean O0000Oo0;
    private Timer O0000OoO;
    private boolean O0000Ooo;
    private XmMp4Record O0000o;
    private boolean O0000o0;
    private boolean O0000o00;
    private int O0000o0O;
    private int O0000o0o;
    private faf O0000oO = new faf();
    private int O0000oO0;
    private int O0000oOO;
    private long O0000oOo;
    private boolean O0000oo;
    private int O0000oo0;
    private int O0000ooO;
    private boolean O0000ooo;
    private byte[] O000O00o;
    private int O000O0OO = 1;
    private int O000O0Oo;
    private AudioBroadcastReceiver O000O0o;
    private boolean O000O0o0;
    private long O000O0oO;
    private boolean O000O0oo = false;
    private byte[] O000OO = null;
    private int O000OO00;
    private Runnable O000OO0o = new Runnable() {
        /* class _m_j.gch.AnonymousClass2 */

        public final void run() {
            if (gch.this.O00000oo != null && gch.this.O0000O0o) {
                gch.this.O00000oo.O000000o(gch.this.f17525O000000o.O0000oo0(), gch.this.O00000oO);
            }
            gch.this.O00000oO = 0;
        }
    };
    private byte[] O000OOOo = null;
    private byte[] O000OOo0 = null;
    private int O00oOoOo;
    private byte[] O00oOooO;
    private AACEncodeEx O00oOooo;

    /* access modifiers changed from: protected */
    public void O000000o(byte[] bArr, int i, short s, short s2, int i2, long j) {
    }

    public void onPause() {
    }

    public void onProgress(int i) {
    }

    public void onResume() {
    }

    public void onRetry(int i, String str, int i2) {
    }

    public gch(cid cid, boolean z) {
        this.f17525O000000o = cid;
        this.O0000Oo0 = z;
        this.O00000Oo = this.f17525O000000o.O00000Oo(z);
        cki.O00000o("RNBaseCameraPlayer", "create in " + ftm.O00000o0(gkv.f17949O000000o));
        if (this.O00000Oo == null) {
            gsy.O000000o(6, "RNBaseCameraPlayer", "mXmStreamClient == null");
            return;
        }
        if (this.O000O0o == null && XmPluginHostApi.instance().context() != null) {
            this.O000O0o = new AudioBroadcastReceiver(new AudioBroadcastReceiver.O000000o() {
                /* class _m_j.$$Lambda$gch$zEYhieD5PoY3Ec_ogeQwBAAnbU */

                public final void setAudioMode(int i) {
                    gch.this.O00000Oo(i);
                }
            });
            this.O000O0o.O000000o(XmPluginHostApi.instance().context());
        }
        this.O00000Oo.setStreamClient(this);
        this.O00000Oo.setAutoVideo(false);
        this.O00000o = true;
        this.O00000o0 = new cqj(XmPluginHostApi.instance().context(), cid.getModel());
        this.O00000o0.O00000o0 = new IAudioSender() {
            /* class _m_j.gch.AnonymousClass1 */

            public final void onSendAudio(byte[] bArr, int i) {
                gch.this.O000000o(bArr.length);
                gch.this.O00000Oo.sendAudioData(bArr, i);
            }
        };
        this.O0000OoO = new Timer();
        this.O0000Oo = new ScheduledThreadPoolExecutor(1);
        this.O0000Oo.scheduleAtFixedRate(this.O000OO0o, 1, 1, TimeUnit.SECONDS);
    }

    public final void O000000o(int i) {
        this.O00000oO += i;
    }

    public void O000000o(int i, int i2, int i3, int i4) {
        this.O0000OOo = true;
        this.O00000Oo.setCallStatus(true);
        this.O00000o0.O000000o(i, i2, i3, i4);
        cqj cqj = this.O00000o0;
        if (cqj != null) {
            cqj.O00000Oo();
        }
    }

    public void O00000o0() {
        this.O0000OOo = false;
        cqj cqj = this.O00000o0;
        if (cqj != null) {
            cqj.O00000o0();
            if (cim.O000000o()) {
                this.O00000o0.O00000o();
            }
            this.O00000Oo.setCallStatus(false);
        }
    }

    public final void O000000o(final String str) {
        this.O000O0oo = false;
        this.O0000Ooo = true;
        if (O00000oo()) {
            wd.O00000o("RN_CAMERA", "startConnect:" + str + " already connected due to preConnection");
            gcg.O000000o o000000o = this.O00000oo;
            if (o000000o != null) {
                o000000o.O000000o(str, 2, 0);
                return;
            }
            return;
        }
        MissConfig missConfig = null;
        this.O00000Oo.releaseRN(false, null, false);
        if (TextUtils.equals(this.f17525O000000o.getModel(), "loock.cateye.v02")) {
            missConfig = new MissConfig.Builder().setExternalFlag(1).build();
        }
        this.O00000Oo.startConnect(new IXmConnectionClient.XmActionCallback() {
            /* class _m_j.gch.AnonymousClass3 */

            public final void onSuccess(String str, Object obj) {
                wd.O00000o("RN_CAMERA", "startConnect:" + str + " cmd success, state：Connectting");
                if (gch.this.O00000oo != null) {
                    gch.this.O00000oo.O000000o(str, 1, 0);
                }
            }

            public final void onFailed(int i, String str) {
                wd.O00000o("RN_CAMERA", "startConnect:" + str + " cmd fail, state：Error errorCode:" + i + " errorMsg:" + str);
                if (gch.this.O00000oo != null) {
                    gch.this.O00000oo.O000000o(str, 0, i);
                }
            }
        }, missConfig);
    }

    public final void O000000o(byte[] bArr, boolean z, final gcg.O00000Oo o00000Oo) {
        wd.O00000o("RN_CAMERA", "send rdtCmd:" + Arrays.toString(bArr));
        if (!this.O00000Oo.isConnected()) {
            o00000Oo.O000000o(-8888, "");
        } else {
            this.O00000Oo.sendRdtCmd(bArr, z, new IXmConnectionClient.XmActionCallback() {
                /* class _m_j.gch.AnonymousClass4 */

                public final void onSuccess(String str, Object obj) {
                    o00000Oo.O000000o(str);
                }

                public final void onFailed(int i, String str) {
                    o00000Oo.O000000o(i, str);
                }
            });
        }
    }

    public final void O000000o(int i, String str, final gcg.O00000Oo o00000Oo) {
        wd.O00000o("RN_CAMERA", "send cmd: type:" + i + " params:" + str);
        if (i != 259) {
            if (i == 271) {
                try {
                    this.O000O0OO = new JSONObject(str).getInt("speed");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (i == 269) {
                try {
                    this.O000O0OO = new JSONObject(str).getInt("speed");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        gbu.O00000o0("rncamera send server cmd ".concat(String.valueOf(i)));
        if (!this.O00000Oo.isConnected()) {
            o00000Oo.O000000o(-8888, "");
        } else {
            this.O00000Oo.sendP2pCmd(i, str, new IXmConnectionClient.XmActionCallback() {
                /* class _m_j.gch.AnonymousClass5 */

                public final void onSuccess(String str, Object obj) {
                    o00000Oo.O000000o(str);
                }

                public final void onFailed(int i, String str) {
                    o00000Oo.O000000o(i, str);
                }
            });
        }
    }

    public final void O000000o(boolean z) {
        this.O0000o00 = z;
    }

    public final void O00000o() {
        wd.O00000o("RN_CAMERA", "release camera:" + this.f17525O000000o.getDid());
        this.O0000Ooo = false;
        civ.O000000o("RNBaseCameraPlayer", "release");
        Timer timer = this.O0000OoO;
        if (timer != null) {
            timer.cancel();
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.O0000Oo;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.shutdownNow();
        }
        try {
            goq.O000000o(new Runnable() {
                /* class _m_j.$$Lambda$gch$ar6P2U6K2M1gvqntyiJA6rSee4Q */

                public final void run() {
                    gch.this.O0000o0();
                }
            });
            this.O00000o0.O00000oO();
            if (this.O00000Oo != null) {
                this.f17525O000000o.O000O00o();
                this.O00000Oo.pauseRN(this);
                this.O00000Oo.releaseRN(false, this);
                this.O00000Oo.setStreamClient(null);
            }
            this.O0000O0o = false;
            this.O0000o0O = 0;
            this.O0000o0o = 0;
            if (!(this.O000O0o == null || XmPluginHostApi.instance().context() == null)) {
                XmPluginHostApi.instance().context().unregisterReceiver(this.O000O0o);
                this.O000O0o = null;
            }
            this.O00000oo = null;
        } catch (Exception e) {
            gsy.O000000o(6, "RNBaseCameraPlayer", "release:" + e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(int i) {
        cqj cqj = this.O00000o0;
        if (cqj != null) {
            cqj.f14242O000000o.O000000o(i);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000o0() {
        try {
            if (this.O00000o0 != null) {
                cqj cqj = this.O00000o0;
                cqj.O00000Oo.clear();
                if (cqj.f14242O000000o != null) {
                    cqj.f14242O000000o.O0000o0o.clear();
                }
            }
        } catch (NullPointerException e) {
            gsy.O000000o(6, "RNBaseCameraPlayer", "NullPointerException clearQueue:" + e.getLocalizedMessage());
        }
    }

    public final boolean O00000oO() {
        return this.O0000o0;
    }

    public final boolean O00000oo() {
        return this.O00000Oo.isConnected();
    }

    public final boolean O000000o(String str, int i, int i2, int i3, int i4, int i5) {
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int i9 = i5;
        wd.O00000o("RN_CAMERA", "开始录制：videoType: " + i + " audioSammple:" + i2 + " width:" + i3 + " height:" + i4 + " fps:" + i9);
        if (i7 <= 0 || i8 <= 0) {
            i7 = this.O000O0Oo;
            i8 = this.O00oOoOo;
            this.O000O0o0 = false;
        } else {
            this.O000O0o0 = true;
        }
        this.O0000o0O = i7;
        this.O0000o0o = i8;
        if (this.O0000o != null || this.O0000o0O == 0 || this.O0000o0o == 0) {
            return false;
        }
        this.O0000oO0 = i6;
        this.O0000oO.O000000o();
        this.O0000o = XmPluginHostApi.instance().createMp4Record();
        if (i9 == 0) {
            this.O0000o.startRecord(str, i, this.O0000o0O, this.O0000o0o, i2);
        } else {
            this.O0000o.startRecord(str, i5, i, this.O0000o0O, this.O0000o0o, i2);
        }
        this.O0000o.setRecordTimeListener(new XmMp4Record.IRecordTimeListener() {
            /* class _m_j.gch.AnonymousClass6 */

            /* renamed from: O000000o  reason: collision with root package name */
            int f17531O000000o;

            public final void upDateTime(int i) {
                int i2 = i / 1000;
                if (i2 != this.f17531O000000o) {
                    this.f17531O000000o = i2;
                    if (gch.this.O00000oo != null) {
                        gch.this.O00000oo.O00000Oo(gch.this.f17525O000000o.O0000oo0(), this.f17531O000000o);
                    }
                }
            }
        });
        this.O0000o0 = true;
        return true;
    }

    public final void O000000o(XmMp4Record.IRecordListener iRecordListener) {
        this.O0000o0 = false;
        XmMp4Record xmMp4Record = this.O0000o;
        if (xmMp4Record == null) {
            iRecordListener.onFailed(-1, "");
            return;
        }
        xmMp4Record.stopRecord(iRecordListener);
        this.O0000o = null;
        this.O0000oO0 = 0;
        this.O000O0o0 = false;
    }

    public final long O0000O0o() {
        return (long) this.O0000oo0;
    }

    public final long O0000OOo() {
        return this.O000O0oO;
    }

    public final int O0000Oo0() {
        return this.O000OO00;
    }

    public final boolean O0000Oo() {
        return this.O0000ooo;
    }

    public final void O0000OoO() {
        this.O0000O0o = false;
    }

    public final void O00000Oo(boolean z) {
        this.O0000oo = z;
    }

    public final void O000000o(gcg.O000000o o000000o) {
        this.O00000oo = o000000o;
    }

    public final int O0000Ooo() {
        cqj cqj = this.O00000o0;
        if (cqj == null || cqj.f14242O000000o == null) {
            return 0;
        }
        return this.O00000o0.f14242O000000o.O00000oO;
    }

    public final void O000000o(XmP2PInfo xmP2PInfo) {
        if (!this.O0000Oo0) {
            this.O00000Oo.updateInfo(xmP2PInfo);
        }
    }

    public final boolean O0000o00() {
        return this.O0000Oo0;
    }

    public final void O000000o(int i, byte[] bArr, final gcg.O00000Oo o00000Oo) {
        this.O00000Oo.sendP2pCmd(i, bArr, new IXmConnectionClient.XmActionCallback() {
            /* class _m_j.gch.AnonymousClass7 */

            public final void onSuccess(String str, Object obj) {
                o00000Oo.O000000o(str);
            }

            public final void onFailed(int i, String str) {
                o00000Oo.O000000o(i, str);
            }
        });
    }

    public void onError(int i, String str) {
        wd.O00000o("RN_CAMERA", "p2p connection disConnected:  code:" + i + " info:" + str);
        this.O0000O0o = false;
        gcg.O000000o o000000o = this.O00000oo;
        if (o000000o != null && !this.O000O0oo) {
            this.O000O0oo = true;
            o000000o.O000000o(this.f17525O000000o.O0000oo0(), 0, i);
        }
    }

    public void onConnected() {
        wd.O00000o("RN_CAMERA", "startConnect:" + this.f17525O000000o.getDid() + " reach connected callback");
        gcg.O000000o o000000o = this.O00000oo;
        if (o000000o != null) {
            o000000o.O000000o(this.f17525O000000o.O0000oo0(), 2, 0);
        }
    }

    public void onDisConnected() {
        if (!this.O000O0oo) {
            this.O000O0oo = true;
            this.O00000oo.O000000o(this.f17525O000000o.O0000oo0(), 0, 2);
        }
        wd.O00000o("RN_CAMERA", "camera disconnected");
        gbu.O00000o0("on disconnect:");
        this.O0000O0o = false;
    }

    public void onDisconnectedWithCode(int i) {
        if (!this.O000O0oo) {
            this.O000O0oo = true;
            gcg.O000000o o000000o = this.O00000oo;
            if (o000000o != null) {
                o000000o.O000000o(this.f17525O000000o.O0000oo0(), 0, i);
            }
        }
        wd.O00000o("RN_CAMERA", "camera disconnected");
        gbu.O00000o0("on disconnect:");
        this.O0000O0o = false;
    }

    public void onCtrlData(int i, byte[] bArr) {
        wd.O00000o("RN_CAMERA", "receive p2p response:  type:" + i + " data:" + Arrays.toString(bArr));
        gcg.O000000o o000000o = this.O00000oo;
        if (o000000o != null) {
            o000000o.O000000o(this.f17525O000000o.O0000oo0(), i, bArr);
        }
    }

    public void onRdtDataReceived(byte[] bArr) {
        gcg.O000000o o000000o = this.O00000oo;
        if (o000000o != null) {
            o000000o.O000000o(this.f17525O000000o.O0000oo0(), bArr);
        }
    }

    public void onAudioData(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            try {
                int byteArrayToInt = Packet.byteArrayToInt(bArr2, 8, false);
                short byteArrayToShort = Packet.byteArrayToShort(bArr2, 16, false);
                short byteArrayToShort2 = Packet.byteArrayToShort(bArr2, 18, false);
                short byteArrayToShort3 = Packet.byteArrayToShort(bArr2, 0, false);
                long byteArrayToInt2 = (long) Packet.byteArrayToInt(bArr2, 12, false);
                O000000o(bArr.length);
                if (this.O0000Ooo && !this.O00000o) {
                    O000000o(bArr, byteArrayToInt, byteArrayToShort, byteArrayToShort2, byteArrayToShort3, byteArrayToInt2);
                }
                int i = (int) byteArrayToInt2;
                if (this.O0000o0 && this.O0000o != null) {
                    if (byteArrayToShort3 != 136) {
                        if (byteArrayToShort3 != 1024) {
                            if (this.O00oOooO == null) {
                                this.O00oOooO = new byte[10240];
                            }
                            int decode = G711.decode(bArr, 0, bArr.length, this.O00oOooO);
                            byte[] bArr3 = new byte[decode];
                            System.arraycopy(this.O00oOooO, 0, bArr3, 0, decode);
                            bArr = bArr3;
                        }
                        if (this.O00oOooo == null) {
                            this.O00oOooo = new AACEncodeEx();
                            this.O00oOooo.initial(this.O0000oO0, 1, 16000);
                            this.O000O00o = new byte[2048];
                            this.O0000oO.O000000o();
                        }
                        this.O0000oO.O00000Oo(bArr);
                        while (this.O0000oO.O000000o(this.O000O00o)) {
                            byte[] encode = this.O00oOooo.encode(this.O000O00o, 0, this.O000O00o.length);
                            this.O0000o.writeAAcData(encode, encode.length, i);
                        }
                        return;
                    }
                    this.O0000o.writeAAcData(bArr, bArr.length, i);
                }
            } catch (Exception e) {
                gsy.O000000o(6, "RNBaseCameraPlayer", "onAudioData:" + e.getLocalizedMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0160 A[RETURN] */
    public void onVideoData(byte[] bArr, byte[] bArr2) {
        char c;
        byte[] bArr3;
        byte[] bArr4 = bArr;
        if (bArr4 != null && bArr2 != null && this.O0000Ooo) {
            AVFrame aVFrame = new AVFrame((byte) 0, bArr2, bArr, bArr4.length, false, this.O0000Oo0);
            if (this.O00000oo.O00000o0(this.f17525O000000o.O0000oo0(), aVFrame.getTimeStampReal())) {
                this.O00000oo.O000000o(this.f17525O000000o.O0000oo0(), aVFrame.frmData, aVFrame.getTimeStamp(), aVFrame.getTimeStampReal());
                return;
            }
            if (DeviceConstant.isYunDingSpecial(this.f17525O000000o.getModel())) {
                if (this.O000OO == null && aVFrame.frmData.length <= 48 && aVFrame.frmData.length > 8) {
                    this.O000OO = aVFrame.frmData;
                }
                if (this.O000OOOo == null && aVFrame.frmData.length == 8) {
                    this.O000OOOo = aVFrame.frmData;
                }
                if (aVFrame.isIFrame() && (aVFrame.frmData.length == 89 || aVFrame.frmData.length == 88)) {
                    this.O000OOo0 = aVFrame.frmData;
                }
                byte[] bArr5 = this.O000OO;
                if (!(bArr5 == null || (bArr3 = this.O000OOOo) == null)) {
                    this.O000OOo0 = mk.O000000o(bArr5, bArr3);
                    this.O000OO = null;
                    this.O000OOOo = null;
                }
                if (aVFrame.isIFrame()) {
                    if (aVFrame.frmData.length <= 89) {
                        c = 65535;
                        if (c >= 0) {
                            cki.O00000Oo("RNBaseCameraPlayer", "dealWithSpecialPPS filter sps frame %d", Integer.valueOf(aVFrame.frmData.length));
                            return;
                        }
                        if (aVFrame.getVideoWidth() <= 0 || aVFrame.getVideoHeight() <= 0) {
                            aVFrame.setVideoWidth(640);
                            aVFrame.setVideoHeight(360);
                        }
                        this.O0000oOO++;
                        if (System.currentTimeMillis() - this.O0000oOo > 1000) {
                            gsy.O00000Oo("RNBaseCameraPlayer", this.f17525O000000o.O0000oo0() + " Receive Frame rate - " + (this.O0000oOO / 2));
                            this.O0000oOO = 0;
                            this.O0000oOo = System.currentTimeMillis();
                        }
                        this.O0000oo0 = aVFrame.getTimeStampReal();
                        this.O000O0oO = (long) aVFrame.getTimeStamp();
                        this.O000OO00 = aVFrame.moveType;
                        O000000o(aVFrame.frmData.length);
                        boolean z = !aVFrame.isPlayback();
                        if (this.O0000oo) {
                            if (z) {
                                this.O0000ooO++;
                                if (this.O0000ooO > 20) {
                                    gcg.O000000o o000000o = this.O00000oo;
                                    if (o000000o != null) {
                                        o000000o.O00000oO(this.f17525O000000o.O0000oo0());
                                    }
                                }
                                if (z) {
                                    return;
                                }
                            }
                            this.O0000ooO = 0;
                            if (z) {
                            }
                        }
                        if (this.O0000o0 && this.O0000o != null) {
                            int timeStamp = aVFrame.getTimeStamp();
                            if (!z && this.O000O0OO == 4) {
                                timeStamp /= 4;
                            }
                            if (!this.O000O0o0) {
                                this.O0000o.writeVideoData(aVFrame.frmData, aVFrame.frmData.length, aVFrame.isIFrame(), timeStamp);
                            } else if (aVFrame.getVideoWidth() == this.O0000o0O && aVFrame.getVideoHeight() == this.O0000o0o) {
                                this.O0000o.writeVideoData(aVFrame.frmData, aVFrame.frmData.length, aVFrame.isIFrame(), timeStamp);
                            } else {
                                wd.O00000o("RN_CAMERA", "录制时 分辨率不对： mRecordWidth:" + this.O0000o0O + " height:" + this.O0000o0o + " realWidth:" + aVFrame.getVideoWidth() + " realHeight:" + aVFrame.getVideoHeight());
                            }
                        }
                        try {
                            if (!this.O0000O0o && aVFrame.isIFrame()) {
                                this.O0000O0o = true;
                                this.O000O0Oo = aVFrame.getVideoWidth();
                                this.O00oOoOo = aVFrame.getVideoHeight();
                                wd.O00000o("RN_CAMERA", "receive videoFrame i frame: , state RESUMED");
                                if (this.O00000oo != null) {
                                    this.O00000oo.O000000o(this.f17525O000000o.O0000oo0(), 3, 0);
                                }
                                ckk.O000000o().O000000o("RNBaseCameraPlayer", "FIRST_RENDER_TIME", "onReceiveVideoFrame");
                                ckj.O000000o().O000000o(this, "FIRST_RENDER:onReceiveVideoFrame isPlayback:" + ((int) aVFrame.isPlayback));
                            } else if (!this.O0000O0o) {
                                wd.O00000o("RN_CAMERA", "receive videoFrame non i frame, when first enter");
                            }
                            this.O0000ooo = z;
                            int i = (!z || !this.O0000o00) ? 0 : aVFrame.isWartTime() ? 2 : 1;
                            if (this.O00000oo != null) {
                                this.O00000oo.O000000o(this.f17525O000000o.O0000oo0(), new VideoFrame(aVFrame.frmData, aVFrame.getFrmNo(), aVFrame.getFrmSize(), aVFrame.getVideoWidth(), aVFrame.getVideoHeight(), (long) aVFrame.getTimeStamp(), aVFrame.getVideoType(), aVFrame.isIFrame(), i, z, aVFrame.getTimeStampReal()));
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            gsy.O000000o(6, "RNBaseCameraPlayer", "onVideoData:" + e.getLocalizedMessage());
                            return;
                        }
                    } else {
                        byte[] bArr6 = this.O000OOo0;
                        if (bArr6 != null) {
                            aVFrame.frmData = mk.O000000o(bArr6, aVFrame.frmData);
                        }
                    }
                }
            }
            c = 0;
            if (c >= 0) {
            }
        }
    }

    public final void O00000o0(boolean z) {
        this.O00000Oo.useHualaiEncrypted(z);
    }

    public final void O00000o(boolean z) {
        this.O00000Oo.setCurrentDeviceUseFixedRdtChannel(z);
    }

    public final void O000000o(int i, int i2, int i3) {
        cqj cqj = this.O00000o0;
        if (cqj != null) {
            if (cqj.O00000o == null) {
                cqj.O00000o = bwz.O000000o();
                int i4 = i == 0 ? 8000 : 16000;
                bwz bwz = cqj.O00000o;
                bwz.O00000o0 = false;
                SoundTouch soundTouch = bwz.O00000Oo;
                soundTouch.setChannels(soundTouch.f4548O000000o, i2);
                SoundTouch soundTouch2 = bwz.O00000Oo;
                soundTouch2.setSampleRate(soundTouch2.f4548O000000o, i4);
            }
            if (i3 == 0) {
                cqj.O00000o.O000000o(0);
                cqj.O00000o.O00000o0 = false;
            } else if (i3 == 1) {
                cqj.O00000o.O000000o(6);
                cqj.O00000o.O00000o0 = true;
            } else if (i3 == 2) {
                cqj.O00000o.O000000o(-3);
                cqj.O00000o.O00000o0 = true;
            } else if (i3 == 3) {
                cqj.O00000o.O000000o(3);
                cqj.O00000o.O00000o0 = true;
            }
        }
    }

    public final void O000000o(String str, final gcg.O00000Oo o00000Oo) {
        if (TextUtils.equals(str, "IOTC_WakeUp_WakeDevice")) {
            this.O00000Oo.wakeUpDevice(new IXmConnectionClient.XmActionCallback() {
                /* class _m_j.gch.AnonymousClass8 */

                public final void onSuccess(String str, Object obj) {
                    gcg.O00000Oo o00000Oo = o00000Oo;
                    if (o00000Oo != null) {
                        o00000Oo.O000000o(str);
                    }
                }

                public final void onFailed(int i, String str) {
                    gcg.O00000Oo o00000Oo = o00000Oo;
                    if (o00000Oo != null) {
                        o00000Oo.O000000o(i, str);
                    }
                }
            });
        }
    }

    public final void O000000o(String str, int i, gcg.O00000Oo o00000Oo) {
        if (!O00000oo()) {
            o00000Oo.O000000o(2, "disConnected");
            return;
        }
        int i2 = 138;
        if (i == 1030) {
            i2 = 136;
        } else if (i != 1027 && i == 1024) {
            i2 = 140;
        }
        goq.O00000oO(new Runnable(Base64.decode(str, 2), i2, o00000Oo) {
            /* class _m_j.$$Lambda$gch$tdY9Y2U9PFta9MtNAv6M7tgD0eU */
            private final /* synthetic */ byte[] f$1;
            private final /* synthetic */ int f$2;
            private final /* synthetic */ gcg.O00000Oo f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                gch.this.O000000o(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(byte[] bArr, int i, gcg.O00000Oo o00000Oo) {
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length) {
            byte[] bArr2 = new byte[1024];
            if (i2 >= length - 1024) {
                System.arraycopy(bArr, i2, bArr2, 0, length - i2);
                gsy.O00000Oo("RN_CAMERA", "文件发送结束:".concat(String.valueOf(i2)));
            } else {
                System.arraycopy(bArr, i2, bArr2, 0, 1024);
                gsy.O00000Oo("RN_CAMERA", "发送了一包:".concat(String.valueOf(i2)));
            }
            i2 += 1024;
            this.O00000Oo.sendAudioData(bArr2, i);
            try {
                Thread.sleep(50);
            } catch (Exception unused) {
            }
        }
        if (o00000Oo != null) {
            o00000Oo.O000000o("0");
        }
    }
}
