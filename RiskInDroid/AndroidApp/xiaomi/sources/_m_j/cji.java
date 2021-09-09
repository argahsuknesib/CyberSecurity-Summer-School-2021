package _m_j;

import _m_j.cjd;
import _m_j.cjg;
import _m_j.cji;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mijia.generalplayer.utils.AudioBroadcastReceiver;
import com.tutk.IAudioSender;
import com.tutk.IOTC.Packet;
import com.xiaomi.aaccodec.AACEncodeEx;
import com.xiaomi.aaccodec.G711;
import com.xiaomi.mistream.MIStreamStatistic;
import com.xiaomi.smarthome.camera.AVFrame;
import com.xiaomi.smarthome.camera.ICameraPlayerListener;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public final class cji implements cjd {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13937O000000o = "GeneralCameraClient";
    public dty O00000Oo;
    public cjd.O000000o O00000o;
    public cia O00000o0;
    boolean O00000oO = true;
    public final Handler O00000oo = new Handler(Looper.getMainLooper());
    public int O0000O0o = 1920;
    public int O0000OOo = 1080;
    public cjg.O00000Oo O0000Oo;
    public cjg.O000000o O0000Oo0;
    public volatile boolean O0000OoO = false;
    public volatile int O0000Ooo;
    public volatile boolean O0000o;
    public volatile boolean O0000o0 = false;
    public volatile int O0000o00;
    public volatile boolean O0000o0O = true;
    public volatile long O0000o0o;
    public volatile int O0000oO;
    public volatile boolean O0000oO0;
    public volatile long O0000oOO;
    public volatile long O0000oOo;
    public boolean O0000oo = false;
    public int O0000oo0 = 1;
    public boolean O0000ooO = false;
    public volatile XmMp4Record O0000ooo;
    public byte[] O000O00o = null;
    public faf O000O0OO = new faf();
    public IXmConnectionClient O000O0Oo;
    public int O000O0o;
    public boolean O000O0o0;
    public boolean O000O0oO;
    public int O000O0oo;
    private volatile boolean O000OO = false;
    private XmMp4Record.IRecordTimeListener O000OO00;
    private volatile boolean O000OO0o = false;
    private cqg O000OOOo;
    private long O000OOo = 0;
    private Timer O000OOo0;
    private int O000OOoO = -1;
    private Context O000OOoo;
    private cjj O000Oo0;
    private AudioBroadcastReceiver O000Oo00;
    private TimerTask O000Oo0O = new TimerTask() {
        /* class _m_j.cji.AnonymousClass1 */

        public final void run() {
            if (cji.this.O00000o0 != null && cji.this.O0000oO0) {
                cji.this.O00000o0.onVideoInfo(cji.this.O0000Ooo, cji.this.O0000o00, cji.this.O0000oO / 2, (int) (cji.this.O0000oOO / 2048), (int) (cji.this.O0000oOo / 1024));
            }
            cji cji = cji.this;
            cji.O0000oO = 0;
            cji.O0000oOO = 0;
        }
    };
    private int O000Oo0o;
    private long O000OoO0;
    private ICameraPlayerListener O00O0Oo = new ICameraPlayerListener() {
        /* class _m_j.cji.AnonymousClass2 */
        private long O00000Oo;

        public final void onPause() {
        }

        public final void onRdtDataReceived(byte[] bArr) {
        }

        public final void onResume() {
        }

        public final void onError(int i, String str) {
            cji cji = cji.this;
            cji.O0000oO0 = false;
            if (cji.O00000o0 != null) {
                cji.this.O00000o0.onVideoPlayError(i, str);
            }
            String str2 = cji.this.f13937O000000o;
            cki.O00000o0(str2, "onError:" + i + " info:" + str + ":" + cji.this.O00000o0);
        }

        public final void onProgress(int i) {
            if (i < 100) {
                cji.this.O0000oO0 = false;
            }
            if (cji.this.O00000o0 != null) {
                cji.this.O00000o0.onPrepare(i);
            }
            cji cji = cji.this;
            cji.O000O0oo = i;
            cki.O00000o0(cji.f13937O000000o, "onProgress:".concat(String.valueOf(i)));
        }

        public final void onConnected() {
            if (cji.this.O00000Oo != null) {
                String str = cji.this.f13937O000000o;
                cki.O00000o0(str, "onConnected:" + cji.this.O00000Oo.getModel() + ":" + cji.this.O00000Oo.getDid() + ":" + cji.this.O00000o0);
            }
            cji.this.O00000oo.post(new Runnable() {
                /* class _m_j.$$Lambda$cji$2$bkYIasng1Om6fofiyCFR4kVXNro */

                public final void run() {
                    cji.AnonymousClass2.this.O00000Oo();
                }
            });
            cji cji = cji.this;
            cji.O00000oO = true;
            cji.this.O000000o(cji.O00000Oo.O00000oO().O0000o00);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000Oo() {
            if (cji.this.O00000o0 != null) {
                cji.this.O00000o0.onConnected();
            }
        }

        public final void onDisConnected() {
            if (cji.this.O00000o0 != null) {
                cji.this.O00000o0.onDisConnected();
            }
            String str = cji.this.f13937O000000o;
            cki.O00000o0(str, "onDisConnected:" + cji.this.O00000o0);
        }

        public final void onDisconnectedWithCode(int i) {
            if (cji.this.O00000o0 != null) {
                cji.this.O00000o0.onDisconnectedWithCode(i);
            }
            String str = cji.this.f13937O000000o;
            cki.O00000o0(str, "onDisconnectedWithCode:" + i + ":" + cji.this.O00000o0);
        }

        public final void onCtrlData(int i, byte[] bArr) {
            if (cji.this.O00000o0 != null) {
                cji.this.O00000o0.onServerCmd(i, bArr);
            }
        }

        public final void onAudioData(byte[] bArr, byte[] bArr2) {
            if (bArr != null && bArr2 != null) {
                short byteArrayToShort = Packet.byteArrayToShort(bArr2, 0, false);
                int byteArrayToInt = Packet.byteArrayToInt(bArr2, 12, false);
                if (!cji.this.O0000o0O && cji.this.O0000OoO) {
                    cji.this.O00000o0(bArr.length);
                    if (cji.this.O00oOoOo != null) {
                        cji.this.O00oOoOo.O000000o(bArr, byteArrayToInt, byteArrayToShort);
                    }
                }
                if (cji.this.O0000o0 && cji.this.O0000ooo != null) {
                    if (byteArrayToShort != 1030) {
                        if (cji.this.O00oOooO == null) {
                            cji.this.O00oOooO = new byte[10240];
                        }
                        int decode = G711.decode(bArr, 0, bArr.length, cji.this.O00oOooO);
                        if (cji.this.O00oOooo == null) {
                            cji.this.O00oOooo = new AACEncodeEx();
                            cji.this.O00oOooo.initial(cji.this.O00000Oo.O000O0OO(), 1, 16000);
                            cji cji = cji.this;
                            cji.O000O00o = new byte[2048];
                            cji.O000O0OO.O000000o();
                        }
                        byte[] bArr3 = new byte[decode];
                        System.arraycopy(cji.this.O00oOooO, 0, bArr3, 0, decode);
                        cji.this.O000O0OO.O00000Oo(bArr3);
                        while (cji.this.O000O0OO.O000000o(cji.this.O000O00o)) {
                            byte[] encode = cji.this.O00oOooo.encode(cji.this.O000O00o, 0, cji.this.O000O00o.length);
                            cji.this.O0000ooo.writeAAcData(encode, encode.length, byteArrayToInt);
                        }
                        return;
                    }
                    cji.this.O0000ooo.writeAAcData(bArr, bArr.length, byteArrayToInt);
                }
            }
        }

        public final void onVideoData(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = bArr;
            if (bArr3 != null && bArr2 != null) {
                AVFrame aVFrame = new AVFrame((byte) 0, bArr2, bArr, bArr3.length, false, cji.this.O00000Oo.O00000o());
                if ((cji.this.O0000oO0 || aVFrame.isIFrame()) && cji.this.O0000OoO) {
                    cki.O000000o(cji.this.f13937O000000o, "handleVideoFrame length: %d, num:%d,iFrame:%b", Integer.valueOf(aVFrame.frmData.length), Long.valueOf(aVFrame.getFrmNo()), Boolean.valueOf(aVFrame.isIFrame()));
                    if (!(aVFrame.getFrmNo() == 0 || aVFrame.getFrmNo() == this.O00000Oo + 1)) {
                        cki.O00000Oo(cji.this.f13937O000000o, "handleVideoFrame frame num not expect last:%d,this:%d", Long.valueOf(this.O00000Oo), Long.valueOf(aVFrame.getFrmNo()));
                    }
                    this.O00000Oo = aVFrame.getFrmNo();
                    if (!cji.this.O0000oO0 && aVFrame.isIFrame() && cji.this.O0000OoO) {
                        ckk.O000000o().O000000o(cji.this.f13937O000000o, "FIRST_RENDER_TIME", "handleVideoFrame");
                        ckj.O000000o().O000000o(cji.this, "FIRST_RENDER:handleVideoFrame isPlayback:" + ((int) aVFrame.isPlayback));
                        cji cji = cji.this;
                        cji.O0000oO0 = true;
                        cji.O00000oo.post(new Runnable() {
                            /* class _m_j.$$Lambda$cji$2$9CQdks0rXk8oUIAYSfRMohILoxo */

                            public final void run() {
                                cji.AnonymousClass2.this.O000000o();
                            }
                        });
                        cji cji2 = cji.this;
                        cji2.O0000oo = cji2.O00000Oo.O00000oO().O0000OOo;
                        cji.this.O000O0oO = true;
                    }
                    cji.this.O0000oO++;
                    cji.this.O00000o0(aVFrame.frmData.length);
                    if (cji.this.O0000Oo != null && cji.this.O0000o == aVFrame.isPlayback()) {
                        cji.this.O0000Oo.onVideoLiveChanged(!aVFrame.isPlayback());
                    }
                    cji.this.O0000o = !aVFrame.isPlayback();
                    if (!cji.this.O0000o) {
                        cji cji3 = cji.this;
                        cji3.O000O0o0 = cji3.O0000o;
                    }
                    if (!cji.this.O0000ooO || !cji.this.O0000o) {
                        if (!(cji.this.O0000Oo0 == null || cji.this.O0000Ooo <= 0 || cji.this.O0000Ooo == aVFrame.getVideoWidth())) {
                            cji.this.O0000Oo0.onResolutionChanged(aVFrame.getVideoWidth(), aVFrame.getVideoHeight());
                        }
                        cji.this.O0000Ooo = aVFrame.getVideoWidth();
                        cji.this.O0000o00 = aVFrame.getVideoHeight();
                        boolean isWartTime = aVFrame.isWartTime();
                        cji.this.O0000o0o = (long) aVFrame.getTimeStampReal();
                        int i = (!cji.this.O0000o || !cji.this.O0000oo) ? 0 : isWartTime ? 2 : 1;
                        if (cji.this.O00oOoOo != null) {
                            cji.this.O00oOoOo.O000000o(new VideoFrame(aVFrame.frmData, aVFrame.getFrmNo(), aVFrame.getFrmSize(), aVFrame.getVideoWidth(), aVFrame.getVideoHeight(), (long) aVFrame.getTimeStamp(), aVFrame.getVideoType(), aVFrame.isIFrame(), i, cji.this.O0000o, aVFrame.getTimeStampReal()));
                        }
                        if (cji.this.O0000o0 && cji.this.O0000ooo != null && cji.this.O0000Ooo == cji.this.O0000O0o && cji.this.O0000o00 == cji.this.O0000OOo) {
                            cji.this.O0000ooo.writeVideoData(aVFrame.frmData, aVFrame.frmData.length, aVFrame.isIFrame(), aVFrame.getTimeStamp());
                            return;
                        }
                        return;
                    }
                    cki.O00000o(cji.this.f13937O000000o, "receive live frame in playback mode");
                    if (!cji.this.O0000ooO || !cji.this.O0000o) {
                        cji.this.O000O0o = 0;
                    } else if (!cji.this.O000O0o0) {
                        cji.this.O000O0o++;
                        if (cji.this.O000O0o > 10 || (cji.this.O000O0o >= 3 && cji.this.O0000oo0 >= 4)) {
                            if (cji.this.O00000o0 != null) {
                                cji.this.O00000o0.onPauseCamera();
                            }
                            cji.this.O000O0o = 0;
                        }
                    }
                }
            }
        }

        public final void onRetry(int i, String str, int i2) {
            if (cji.this.O00000o0 != null) {
                cji.this.O00000o0.onRetry(i, str, i2);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o() {
            synchronized (cji.this.O00000oo) {
                String str = cji.this.f13937O000000o;
                cki.O00000o0(str, "handleVideoFrame onLoad mFirstFrame:" + cji.this.O0000oO0);
                if (cji.this.O0000O0o()) {
                    cji.this.O00000Oo(true);
                }
                cio.O00000o0().O000000o(cji.this.O00000Oo);
                if (cji.this.O00000o != null) {
                    cji.this.O00000o.onLoad();
                }
                if (cji.this.O00000o0 != null) {
                    cji.this.O00000o0.onPrepare(101);
                }
            }
        }
    };
    public cjf O00oOoOo;
    public byte[] O00oOooO = null;
    public AACEncodeEx O00oOooo = null;

    public final void O00000o0(int i) {
        long j = (long) i;
        this.O0000oOO += j;
        this.O0000oOo += j;
    }

    public cji(Context context, dty dty) {
        this.O000OOoo = context;
        this.O00000Oo = dty;
        this.f13937O000000o = "GeneralCameraClient" + hashCode();
        this.O000O0Oo = this.O00000Oo.O00000Oo(dty.O00000o());
        if (this.O000O0Oo == null) {
            cki.O00000oO(this.f13937O000000o, "mXmStreamClient == null");
            return;
        }
        if (DeviceConstant.is2K(dty.getModel())) {
            this.O0000O0o = 2304;
            this.O0000OOo = 1296;
        }
        this.O000Oo0 = new cjk(this.O000O0Oo);
        this.O000OOo0 = new Timer();
        this.O000OOo0.schedule(this.O000Oo0O, 0, 2000);
        this.O000Oo00 = new AudioBroadcastReceiver(new AudioBroadcastReceiver.O000000o() {
            /* class _m_j.$$Lambda$cji$zPZ_aRdM7LfHlwy0r76p1IfhLzQ */

            public final void setAudioMode(int i) {
                cji.this.O00000o(i);
            }
        });
        this.O000Oo00.O000000o(this.O000OOoo);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(int i) {
        cqg cqg = this.O000OOOo;
        if (cqg != null) {
            cqg.O000000o(i);
        }
    }

    private boolean O0000Oo0() {
        cki.O00000o(this.f13937O000000o, "initial");
        this.O0000oO = 0;
        this.O0000oOO = 0;
        return true;
    }

    public final boolean O0000Oo() {
        return this.O000O0Oo.isConnected();
    }

    public final void O0000o() {
        O0000Oo0();
        cki.O00000o0(this.f13937O000000o, "retryPlay");
        try {
            this.O0000OoO = true;
            if (this.O000O0Oo != null) {
                MIStreamStatistic.getInstance().latestCameraConnect = System.currentTimeMillis();
                this.O000O0Oo.setAutoVideo(true);
                this.O000O0Oo.setStreamClient(this.O00O0Oo);
                this.O000O0Oo.startConnect(null);
            }
        } catch (Exception e) {
            String str = this.f13937O000000o;
            cki.O00000oO(str, "retryPlay:" + e.getLocalizedMessage());
        }
    }

    public final void O0000o0O() {
        O00000Oo((IXmConnectionClient.XmActionCallback) null);
    }

    public final void O00000Oo(IXmConnectionClient.XmActionCallback xmActionCallback) {
        if (this.O00000Oo != null) {
            String str = this.f13937O000000o;
            cki.O00000o0(str, "startStream:" + this.O00000Oo.getModel() + this.O00000Oo.getDid());
        }
        O0000Oo0();
        this.O0000OoO = true;
        this.O000OO = false;
        this.O0000oO0 = false;
        this.O000O0Oo.setAutoVideo(true);
        this.O000O0Oo.setStreamClient(this.O00O0Oo);
        this.O000O0Oo.startConnect(xmActionCallback);
        O00000o(true);
        this.O000Oo0o = 1;
        this.O000OoO0 = System.currentTimeMillis();
    }

    public final void O0000o0o() {
        if (this.O00000Oo != null) {
            String str = this.f13937O000000o;
            cki.O00000o0(str, "stopStream:" + this.O00000Oo.getModel() + this.O00000Oo.getDid());
        }
        this.O000O0Oo.releaseRN(false, null);
    }

    public final void O000000o(cia cia) {
        this.O00000o0 = cia;
    }

    public final void O000000o(cjd.O000000o o000000o) {
        this.O00000o = o000000o;
    }

    public final void O0000OOo() {
        if (this.O00000Oo != null) {
            String str = this.f13937O000000o;
            cki.O00000o0(str, "pausePlay:" + this.O00000Oo.getModel() + this.O00000Oo.getDid());
        }
        this.O0000OoO = false;
        this.O0000oO0 = false;
        O00000o(false);
        O00000Oo(false);
        IXmConnectionClient iXmConnectionClient = this.O000O0Oo;
        if (iXmConnectionClient != null) {
            iXmConnectionClient.setStreamClient(null);
        }
    }

    public final void O000000o(String str, int i) {
        O000000o(str, i, 20);
    }

    public final void O000000o(String str, int i, int i2) {
        if (this.O0000ooo == null) {
            cki.O00000o0(this.f13937O000000o, "startRecord");
            this.O000O0OO.O000000o();
            this.O0000ooo = XmPluginHostApi.instance().createMp4Record();
            this.O0000ooo.startRecord(str, i2, i, this.O0000O0o, this.O0000OOo, this.O00000Oo.O000O0OO());
            this.O0000ooo.setRecordTimeListener(this.O000OO00);
            this.O0000o0 = true;
            int i3 = this.O00000Oo.O00000oO().O0000o00;
            cjj cjj = this.O000Oo0;
            if (cjj != null && i3 != 3) {
                cjj.O000000o(3);
            }
        }
    }

    public final void O000000o(int i) {
        this.O000Oo0.O000000o(i);
    }

    public final boolean O0000Ooo() {
        return this.O0000OoO;
    }

    public final boolean O0000o0() {
        return this.O0000OoO;
    }

    public final boolean O00000Oo() {
        return this.O0000o;
    }

    public final boolean O0000o00() {
        return !this.O0000OoO || this.O000O0Oo.isPaused();
    }

    public final boolean O00000o0() {
        return this.O000OO0o;
    }

    public final void O00000o() {
        O0000Oo0();
        if (this.O00000Oo != null) {
            String str = this.f13937O000000o;
            cki.O00000o0(str, "startCall:" + this.O00000Oo.getModel() + this.O00000Oo.getDid());
        }
        O0000oo0();
        this.O000Oo0.O000000o();
        this.O000OO0o = true;
        this.O0000o0O = false;
        cqg cqg = this.O000OOOo;
        if (cqg != null) {
            cqg.O00000o();
        }
        cio.O00000o0().O000000o();
    }

    private void O0000oo0() {
        if (this.O000OOOo == null) {
            this.O000OOOo = new cqg(this.O000OOoo, this.O00000Oo.O000O0OO(), this.O00000Oo.getModel());
            this.O000OOOo.O00000o0 = new IAudioSender() {
                /* class _m_j.cji.AnonymousClass3 */

                public final void onSendAudio(byte[] bArr, int i) {
                    cji.this.O00000o0(bArr.length);
                    cji.this.O000O0Oo.sendAudioData(bArr, i);
                }
            };
        }
    }

    public final void O00000oO() {
        O0000Oo0();
        cki.O00000o(this.f13937O000000o, "stopCall");
        if (this.O00000Oo != null) {
            String str = this.f13937O000000o;
            cki.O00000o0(str, "stopCall:" + this.O00000Oo.getModel() + this.O00000Oo.getDid());
        }
        this.O000Oo0.O00000Oo();
        this.O000OO0o = false;
        cio.O00000o0().O00000Oo();
        cqg cqg = this.O000OOOo;
        if (cqg != null) {
            cqg.O00000oO();
        }
    }

    public final boolean O00000oo() {
        return this.O000OO;
    }

    public final boolean O0000O0o() {
        return this.O0000o0;
    }

    public final void O000000o(XmMp4Record.IRecordListener iRecordListener) {
        cki.O00000o0(this.f13937O000000o, "stopRecord");
        this.O0000o0 = false;
        if (this.O0000ooo != null) {
            this.O0000ooo.stopRecord(iRecordListener);
            this.O0000ooo = null;
            int i = this.O00000Oo.O00000oO().O0000o00;
            cjj cjj = this.O000Oo0;
            if (cjj != null) {
                cjj.O000000o(i);
            }
        } else if (iRecordListener != null) {
            iRecordListener.onFailed(-1, "");
        }
    }

    public final void O00000o(boolean z) {
        cjj cjj = this.O000Oo0;
        if (cjj != null && this.O00000Oo != null) {
            cjj.O00000Oo(z);
        }
    }

    public final void O000000o(boolean z) {
        cki.O00000o0(this.f13937O000000o, "release:".concat(String.valueOf(z)));
        if (this.O0000OoO) {
            O0000OOo();
        }
        try {
            if (this.O000OOOo != null) {
                this.O000OOOo.O00000oO();
            }
            if (this.O000O0Oo != null && !z) {
                this.O00000Oo.O000O00o();
                this.O000O0Oo.pauseRN(this.O00O0Oo);
                this.O000O0Oo.releaseRN(z, null);
            }
            if (this.O00oOooo != null) {
                this.O00oOooo.release();
                this.O00oOooo = null;
            }
            this.O0000oO0 = false;
            if (this.O000OOo0 != null) {
                this.O000OOo0.cancel();
            }
            this.O00000o0 = null;
            this.O00000o = null;
            this.O000OO00 = null;
            this.O0000Oo0 = null;
            this.O000OOoo.unregisterReceiver(this.O000Oo00);
            this.O000OOoo = null;
        } catch (Exception e) {
            String str = this.f13937O000000o;
            cki.O00000oO(str, "release:" + e.getLocalizedMessage());
        }
        if (this.O000Oo0o == 1 && !this.O000O0oO) {
            cki.O0000OOo("2000.2.1", this.O00000Oo.getModel() + ",progress:" + this.O000O0oo + ",in time:" + (System.currentTimeMillis() - this.O000OoO0));
        }
        if (this.O000Oo0o == 2 && !this.O000O0oO) {
            cki.O0000OOo("2000.3.1", this.O00000Oo.getModel() + ",progress:" + this.O000O0oo + ",in time:" + (System.currentTimeMillis() - this.O000OoO0));
        }
    }

    public final void O00000Oo(boolean z) {
        cjj cjj = this.O000Oo0;
        if (cjj != null && this.O00000Oo != null) {
            cjj.O000000o(z);
        }
    }

    public final void O000000o(XmMp4Record.IRecordTimeListener iRecordTimeListener) {
        this.O000OO00 = iRecordTimeListener;
    }

    public final void O0000oO0() {
        this.O000O0Oo.sendP2pCmd(Integer.MAX_VALUE, ckm.O000000o(dvq.O000000o(cij.O000000o(XmPluginHostApi.instance().context()))), (IXmConnectionClient.XmActionCallback) null);
    }

    public final void O0000oO() {
        this.O000O0Oo.sendP2pCmd(Integer.MAX_VALUE, ckm.O000000o(dvq.O000000o((long) ((int) ((System.currentTimeMillis() / 1000) + 1)))), (IXmConnectionClient.XmActionCallback) null);
    }

    public final void O000000o(cjg.O00000Oo o00000Oo) {
        this.O0000Oo = o00000Oo;
    }

    public final void O00000oO(boolean z) {
        this.O0000ooO = z;
    }

    public final void O00000Oo(final int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("speed", i);
            jSONObject.put("sessionid", this.O000OOoO);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.O000O0Oo.sendP2pCmd(271, jSONObject.toString(), new IXmConnectionClient.XmActionCallback() {
            /* class _m_j.cji.AnonymousClass4 */

            public final void onFailed(int i, String str) {
            }

            public final void onSuccess(String str, Object obj) {
                cji.this.O0000oo0 = i;
            }
        });
    }

    public final int O0000oOO() {
        return this.O0000oo0;
    }

    public final long O0000oOo() {
        return this.O0000o0o;
    }

    public final void O000000o(int i, int i2, int i3, IXmConnectionClient.XmActionCallback xmActionCallback) {
        String str = this.f13937O000000o;
        cki.O00000o0(str, "set play time " + i + " " + i2 + " " + i3);
        this.O000Oo0o = 2;
        this.O000OoO0 = System.currentTimeMillis();
        if (i != 0) {
            this.O0000OoO = true;
            this.O000OO = false;
            this.O0000oO0 = false;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sessionid", i);
                jSONObject.put("starttime", i);
                jSONObject.put("endtime", i3);
                jSONObject.put("autoswitchtolive", 1);
                jSONObject.put("offset", i2);
                jSONObject.put("speed", this.O0000oo0);
                jSONObject.put("avchannelmerge", 1);
                this.O000OOoO = i;
                this.O000O0Oo.setStreamClient(this.O00O0Oo);
                this.O000O0Oo.sendP2pCmd(269, jSONObject.toString(), xmActionCallback);
                this.O000OOo = (long) (i + i2);
            } catch (JSONException e) {
                String str2 = this.f13937O000000o;
                cki.O00000o(str2, "JSONException:" + e.getLocalizedMessage());
            }
        }
    }

    public final void O000000o(cjf cjf) {
        this.O00oOoOo = cjf;
    }

    public final cqg O000000o() {
        O0000oo0();
        return this.O000OOOo;
    }

    public final void O00000o0(boolean z) {
        this.O0000o0O = z;
    }

    public final boolean O0000OoO() {
        return this.O0000o0O;
    }

    public final void O000000o(int i, IXmConnectionClient.XmActionCallback xmActionCallback) {
        this.O000Oo0.O000000o(i, xmActionCallback);
    }

    public final void O000000o(cjg.O000000o o000000o) {
        this.O0000Oo0 = o000000o;
    }

    public final void O000000o(IXmConnectionClient.XmActionCallback xmActionCallback) {
        this.O000O0Oo.sendP2pCmd(Integer.MAX_VALUE, ckm.O000000o(dvr.O000000o(10540, 0, null)), xmActionCallback);
    }
}
