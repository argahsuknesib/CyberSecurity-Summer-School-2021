package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p2p.audio.AudioProcess;
import com.tutk.IAudioSender;
import com.tutk.IOTC.Packet;
import com.xiaomi.aaccodec.AACEncodeEx;
import com.xiaomi.aaccodec.G711;
import com.xiaomi.mistream.MIStreamStatistic;
import com.xiaomi.mistream.XmStreamClient;
import com.xiaomi.smarthome.camera.AVFrame;
import com.xiaomi.smarthome.camera.IClientExListener;
import com.xiaomi.smarthome.camera.IMISSListener;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public final class chw implements IClientExListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f13851O000000o = Integer.MAX_VALUE;
    public O00000Oo O00000Oo;
    public long O00000o = 0;
    public O00000o0 O00000o0;
    public XmStreamClient O00000oO;
    public cia O00000oo;
    public XmMp4Record.IRecordTimeListener O0000O0o;
    public volatile boolean O0000OOo = false;
    public cqg O0000Oo;
    public dty O0000Oo0;
    public volatile int O0000OoO;
    public volatile int O0000Ooo;
    public volatile boolean O0000o;
    public volatile boolean O0000o0 = false;
    public volatile XmMp4Record O0000o00;
    public volatile boolean O0000o0O = true;
    public volatile long O0000o0o;
    public volatile int O0000oO;
    public volatile boolean O0000oO0;
    public volatile long O0000oOO;
    public volatile long O0000oOo;
    public int O0000oo = 1;
    public int O0000oo0 = -1;
    public boolean O0000ooO;
    private int O0000ooo = 1920;
    private volatile boolean O000O00o = false;
    private XmVideoViewGl O000O0OO;
    private Handler O000O0Oo = new Handler(Looper.getMainLooper());
    private volatile int O000O0o = 0;
    private long O000O0o0 = 0;
    private volatile long O000O0oO = 0;
    private volatile long O000O0oo = 0;
    private boolean O000OO = false;
    private boolean O000OO00 = false;
    private Context O000OO0o;
    private int O000OOOo;
    private long O000OOo = -1;
    private boolean O000OOo0 = true;
    private long O000OOoO = 0;
    private TimerTask O000OOoo = new TimerTask() {
        /* class _m_j.chw.AnonymousClass1 */

        public final void run() {
            if (chw.this.O00000oo != null && chw.this.O0000oO0) {
                chw.this.O00000oo.onVideoInfo(chw.this.O0000OoO, chw.this.O0000Ooo, chw.this.O0000oO / 2, (int) (chw.this.O0000oOO / 2048), (int) (chw.this.O0000oOo / 1024));
            }
            chw chw = chw.this;
            chw.O0000oO = 0;
            chw.O0000oOO = 0;
        }
    };
    private AACEncodeEx O000Oo0 = null;
    private byte[] O000Oo00 = null;
    private byte[] O000Oo0O = null;
    private faf O000Oo0o = new faf();
    private BroadcastReceiver O000OoO = null;
    private boolean O000OoO0 = true;
    private boolean O00O0Oo = true;
    private Timer O00oOoOo;
    private int O00oOooO = 1080;
    private volatile boolean O00oOooo = false;

    public interface O00000Oo {
    }

    public interface O00000o0 {
    }

    public final void onRetry(int i, String str, int i2) {
    }

    public chw(Context context, dty dty, cia cia, XmVideoViewGl xmVideoViewGl) {
        XmVideoViewGl xmVideoViewGl2;
        this.O000OO0o = context;
        if (this.O000OoO == null && this.O000OO0o != null) {
            this.O000OoO = new O000000o();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            this.O000OO0o.registerReceiver(this.O000OoO, intentFilter);
        }
        this.O0000Oo0 = dty;
        if (DeviceConstant.is2K(dty.getModel())) {
            this.O0000ooo = 2304;
            this.O00oOooO = 1296;
        }
        this.O00000oO = this.O0000Oo0.O00oOooO();
        XmStreamClient xmStreamClient = this.O00000oO;
        if (xmStreamClient == null) {
            gsy.O000000o(6, "CameraPlayerEx", "mXmStreamClient == null");
            return;
        }
        xmStreamClient.setClientListener(this);
        this.O00000oo = cia;
        this.O000O0OO = xmVideoViewGl;
        dty dty2 = this.O0000Oo0;
        if (!(dty2 == null || (xmVideoViewGl2 = this.O000O0OO) == null)) {
            xmVideoViewGl2.setDid(dty2.getDid());
        }
        dty dty3 = this.O0000Oo0;
        if (dty3 == null || TextUtils.isEmpty(dty3.getModel()) || (!"chuangmi.camera.ipc019".equals(this.O0000Oo0.getModel()) && !DeviceConstant.is16K(this.O0000Oo0.getModel()))) {
            this.O0000Oo = new cqg(context, 8000, this.O0000Oo0.getModel());
        } else {
            this.O0000Oo = new cqg(context, 16000, this.O0000Oo0.getModel());
        }
        this.O0000Oo.O00000o0 = new IAudioSender() {
            /* class _m_j.chw.AnonymousClass6 */

            public final void onSendAudio(byte[] bArr, int i) {
                chw.this.O000000o(bArr.length);
                chw.this.O00000oO.sendAudioData(bArr, i);
            }
        };
        this.O00oOoOo = new Timer();
        this.O00oOoOo.schedule(this.O000OOoo, 0, 2000);
        this.O0000o0O = true;
        this.O00000oO.streamResolution(((cid) this.O0000Oo0).O00000oO().O0000o00, new IMISSListener() {
            /* class _m_j.chw.AnonymousClass7 */

            public final void onProgress(int i) {
            }

            public final void onSuccess(String str, Object obj) {
                gsy.O00000Oo("CameraPlayerEx", "streamResolution success:".concat(String.valueOf(str)));
            }

            public final void onFailed(int i, String str) {
                gsy.O000000o(6, "CameraPlayerEx", "streamResolution failed:".concat(String.valueOf(i)));
            }
        });
    }

    public chw(dty dty, cia cia) {
        this.O0000Oo0 = dty;
        this.O00000oO = this.O0000Oo0.O00oOooO();
        this.O00000oO.setClientListener(this);
        this.O00000oo = cia;
    }

    public final void O000000o(int i) {
        long j = (long) i;
        this.O0000oOO += j;
        this.O0000oOo += j;
        this.O000O0oO += j;
    }

    public final void onError(int i, String str) {
        this.O00oOooo = false;
        this.O0000oO0 = false;
        cia cia = this.O00000oo;
        if (cia != null) {
            cia.onVideoPlayError(i, str);
        }
    }

    public final void onProgress(int i) {
        if (i < 100) {
            this.O0000oO0 = false;
        }
        cia cia = this.O00000oo;
        if (cia != null) {
            cia.onPrepare(i);
        }
    }

    public final void onConnected() {
        cia cia = this.O00000oo;
        if (cia != null) {
            cia.onConnected();
        }
        int i = ((cid) this.O0000Oo0).O00000oO().O0000o00;
        XmStreamClient xmStreamClient = this.O00000oO;
        if (xmStreamClient != null) {
            xmStreamClient.streamResolution(i, null);
        }
    }

    public final void onDisConnected() {
        cia cia = this.O00000oo;
        if (cia != null) {
            cia.onDisConnected();
        }
    }

    public final void onDisconnectedWithCode(int i) {
        cia cia = this.O00000oo;
        if (cia != null) {
            cia.onDisconnectedWithCode(i);
        }
    }

    public final void onCtrlData(final int i, final byte[] bArr) {
        if (this.O00000oo != null) {
            this.O000O0Oo.post(new Runnable() {
                /* class _m_j.chw.AnonymousClass8 */

                public final void run() {
                    if (chw.this.O00000oo != null) {
                        chw.this.O00000oo.onServerCmd(i, bArr);
                    }
                }
            });
        }
    }

    public final void onAudioData(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            short byteArrayToShort = Packet.byteArrayToShort(bArr2, 0, false);
            long byteArrayToInt = (long) Packet.byteArrayToInt(bArr2, 12, false);
            boolean z = bArr2[25] == 1;
            if (bArr != null && bArr.length != 0 && !this.O000O00o && this.O00oOooo) {
                if (!this.O000OO || z) {
                    if (!this.O0000o0O) {
                        O000000o(bArr.length);
                        this.O0000Oo.O000000o(bArr, byteArrayToInt, byteArrayToShort);
                    }
                    if (this.O0000o0 && this.O0000o00 != null) {
                        if (byteArrayToShort != 136) {
                            if (this.O000Oo00 == null) {
                                this.O000Oo00 = new byte[10240];
                            }
                            int decode = G711.decode(bArr, 0, bArr.length, this.O000Oo00);
                            if (this.O000Oo0 == null) {
                                this.O000Oo0 = new AACEncodeEx();
                                dty dty = this.O0000Oo0;
                                if (dty == null || TextUtils.isEmpty(dty.getModel()) || (!"chuangmi.camera.ipc019".equals(this.O0000Oo0.getModel()) && !DeviceConstant.is16K(this.O0000Oo0.getModel()))) {
                                    this.O000Oo0.initial(8000, 1, 16000);
                                } else {
                                    this.O000Oo0.initial(16000, 1, 16000);
                                }
                                this.O000Oo0O = new byte[2048];
                                this.O000Oo0o.O000000o();
                            }
                            byte[] bArr3 = new byte[decode];
                            System.arraycopy(this.O000Oo00, 0, bArr3, 0, decode);
                            this.O000Oo0o.O00000Oo(bArr3);
                            while (this.O000Oo0o.O000000o(this.O000Oo0O)) {
                                AACEncodeEx aACEncodeEx = this.O000Oo0;
                                byte[] bArr4 = this.O000Oo0O;
                                byte[] encode = aACEncodeEx.encode(bArr4, 0, bArr4.length);
                                this.O0000o00.writeAAcData(encode, encode.length, (int) byteArrayToInt);
                            }
                            return;
                        }
                        this.O0000o00.writeAAcData(bArr, bArr.length, (int) byteArrayToInt);
                        return;
                    }
                    return;
                }
                gsy.O00000Oo("CameraPlayerEx", "receive live audio frame in playback mode");
            }
        }
    }

    public final void onVideoData(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        if (bArr3 != null && bArr2 != null && this.O000OoO0) {
            int length = bArr3.length;
            dty dty = this.O0000Oo0;
            AVFrame aVFrame = new AVFrame((byte) 0, bArr2, bArr, length, false, dty != null && dty.O00000o());
            if (this.O0000oO0 || aVFrame.isIFrame()) {
                if (!this.O0000oO0 && aVFrame.isIFrame()) {
                    ckk.O000000o().O000000o("CameraPlayerEx", "FIRST_RENDER_TIME", "handleVideoFrame");
                    ckj.O000000o().O000000o(this, "FIRST_RENDER:handleVideoFrame isPlayback:" + ((int) aVFrame.isPlayback));
                    this.O0000oO0 = true;
                    this.O000O0oo = System.currentTimeMillis();
                    cin.O000000o(this.O0000Oo0);
                    this.O000O0Oo.post(new Runnable() {
                        /* class _m_j.chw.AnonymousClass2 */

                        public final void run() {
                            if (chw.this.O00000oo != null) {
                                chw.this.O00000oo.onPrepare(101);
                            }
                        }
                    });
                    this.O000OO00 = ((cid) this.O0000Oo0).O00000oO().O0000OOo;
                }
                O000000o(aVFrame.frmData.length);
                if (this.O00000o0 != null && this.O0000o == aVFrame.isPlayback()) {
                    aVFrame.isPlayback();
                }
                this.O0000o = !aVFrame.isPlayback();
                if (!(this.O00000Oo == null || this.O0000OoO == aVFrame.getVideoWidth())) {
                    aVFrame.getVideoWidth();
                    aVFrame.getVideoHeight();
                }
                this.O0000OoO = aVFrame.getVideoWidth();
                this.O0000Ooo = aVFrame.getVideoHeight();
                this.O0000o = !aVFrame.isPlayback();
                if (!this.O0000o) {
                    this.O000OOo0 = this.O0000o;
                }
                if (this.O000OO && this.O0000o) {
                    gsy.O00000Oo("CameraPlayerEx", "receive live frame in playback mode");
                    if (!this.O000OO || !this.O0000o) {
                        this.O000OOOo = 0;
                    } else if (!this.O000OOo0) {
                        this.O000OOOo++;
                        if (this.O000OOOo > 10) {
                            cia cia = this.O00000oo;
                            if (cia != null) {
                                cia.onPauseCamera();
                            }
                            this.O000OOOo = 0;
                        }
                    }
                } else if (!this.O0000ooO || !this.O0000o) {
                    if (this.O0000o0 && this.O0000o00 != null) {
                        int timeStamp = aVFrame.getTimeStamp();
                        if (!this.O0000o && this.O0000oo == 4) {
                            timeStamp /= 4;
                        }
                        if (this.O0000OoO == this.O0000ooo && this.O0000Ooo == this.O00oOooO) {
                            this.O0000o00.writeVideoData(aVFrame.frmData, aVFrame.frmData.length, aVFrame.isIFrame(), timeStamp);
                        }
                    }
                    try {
                        this.O0000oO++;
                        this.O000O0o++;
                        VideoFrame videoFrame = new VideoFrame(aVFrame.frmData, aVFrame.getFrmNo(), aVFrame.getFrmSize(), aVFrame.getVideoWidth(), aVFrame.getVideoHeight(), (long) aVFrame.getTimeStamp(), aVFrame.getVideoType(), aVFrame.isIFrame(), (!this.O0000o || !this.O000OO00) ? 0 : aVFrame.isWartTime() ? 2 : 1, this.O0000o, aVFrame.getTimeStampReal());
                        if (this.O000O0OO != null) {
                            this.O000O0OO.drawVideoFrame(videoFrame);
                        }
                        this.O0000o0o = (long) aVFrame.getTimeStampReal();
                        if ((this.O000O0o0 == 0 && this.O0000o && this.O0000oO0) || (this.O000O0o0 > 0 && aVFrame.isIFrame() && !this.O0000o)) {
                            this.O000O0o0 = -1;
                            this.O000O0Oo.post(new Runnable() {
                                /* class _m_j.chw.AnonymousClass3 */

                                public final void run() {
                                    if (chw.this.O00000oo != null) {
                                        chw.this.O00000oo.onPrepare(102);
                                        if (chw.this.O0000o) {
                                            chw.this.O0000oo = 1;
                                        }
                                    }
                                }
                            });
                        }
                    } catch (Exception e) {
                        civ.O00000o("CameraPlayerEx", e.toString());
                    }
                } else {
                    gsy.O00000Oo("xm111", "v3 upgrade received live frame when playbackmode, filtered");
                }
            }
        }
    }

    public final void onPause() {
        this.O000OoO0 = false;
    }

    public final void onResume() {
        this.O000OoO0 = true;
    }

    public final boolean O000000o() {
        return this.O00oOooo && this.O0000oO0;
    }

    public final synchronized boolean O00000Oo() {
        return !this.O00oOooo;
    }

    private boolean O0000OoO() {
        gsy.O00000Oo("CameraPlayerEx", "initial");
        this.O0000oO = 0;
        this.O0000oOO = 0;
        return true;
    }

    public final void O000000o(IMISSListener iMISSListener) {
        O0000OoO();
        gsy.O00000Oo("CameraPlayerEx", "startStreamPlay with listener");
        try {
            this.O00oOooo = true;
            this.O000O00o = false;
            this.O0000oO0 = false;
            this.O0000Oo.O00000o0();
            if (this.O00000oO != null) {
                MIStreamStatistic.getInstance().latestCameraConnect = System.currentTimeMillis();
                this.O00000oO.setClientListener(this);
                this.O00000oO.setAutoVideo(true);
                this.O00000oO.streamStart(iMISSListener);
            }
            O0000Ooo();
        } catch (Exception e) {
            gsy.O000000o(6, "CameraPlayerEx", "startStreamPlay:" + e.getLocalizedMessage());
        }
    }

    public final void O00000o0() {
        gsy.O00000Oo("CameraPlayerEx", "pausePlay");
        try {
            this.O00oOooo = false;
            if (this.O00000oO != null) {
                O00000o0(false);
                O00000o(false);
            }
            this.O0000Oo.O00000oO();
            this.O000O00o = false;
            this.O0000oO0 = false;
            O0000Ooo();
            this.O000O0o = 0;
            this.O000O0oO = 0;
        } catch (Exception e) {
            gsy.O000000o(6, "CameraPlayerEx", "pausePlay:" + e.getLocalizedMessage());
        }
    }

    private void O0000Ooo() {
        goq.O000000o(new Runnable() {
            /* class _m_j.$$Lambda$chw$V139fEvElUIA9Cxa99CbP10x51A */

            public final void run() {
                chw.this.O0000o00();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000o00() {
        try {
            if (this.O000O0OO != null) {
                this.O000O0OO.clearQueue();
            }
            if (this.O0000Oo != null) {
                this.O0000Oo.O0000O0o();
            }
        } catch (NullPointerException e) {
            gsy.O000000o(6, "CameraPlayerEx", "NullPointerException clearQueue:" + e.getLocalizedMessage());
        }
    }

    public final boolean O00000o() {
        return !this.O00oOooo || this.O00000oO.isPaused();
    }

    public final void O00000oO() {
        O0000OoO();
        gsy.O00000Oo("CameraPlayerEx", "retryPlay");
        try {
            this.O00oOooo = true;
            this.O0000Oo.O00000o0();
            if (this.O00000oO != null) {
                MIStreamStatistic.getInstance().latestCameraConnect = System.currentTimeMillis();
                this.O00000oO.setAutoVideo(true);
                this.O00000oO.streamStart(new IMISSListener() {
                    /* class _m_j.chw.AnonymousClass9 */

                    public final void onProgress(int i) {
                    }

                    public final void onSuccess(String str, Object obj) {
                        gsy.O00000Oo("CameraPlayerEx", "retryPlay success:".concat(String.valueOf(str)));
                    }

                    public final void onFailed(int i, String str) {
                        gsy.O000000o(6, "CameraPlayerEx", "retryPlay failed:".concat(String.valueOf(i)));
                    }
                });
            }
        } catch (Exception e) {
            gsy.O000000o(6, "CameraPlayerEx", "retryPlay:" + e.getLocalizedMessage());
        }
    }

    public final void O00000oo() {
        XmStreamClient xmStreamClient = this.O00000oO;
        if (xmStreamClient != null) {
            xmStreamClient.streamStop(null);
        }
    }

    public final void O000000o(int i, int i2, int i3, IMISSListener iMISSListener) {
        gsy.O00000Oo("CameraPlayerEx", "set play time " + i + " " + i2 + " " + i3);
        if (i != 0) {
            XmVideoViewGl xmVideoViewGl = this.O000O0OO;
            if (xmVideoViewGl != null) {
                xmVideoViewGl.setNeedIFrame();
            }
            cqg cqg = this.O0000Oo;
            if (cqg != null) {
                cqg.O00000o0();
            }
            this.O00oOooo = true;
            int i4 = i3 == 0 ? 1 : 0;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sessionid", i);
                jSONObject.put("starttime", i);
                jSONObject.put("endtime", i3);
                jSONObject.put("autoswitchtolive", i4);
                jSONObject.put("offset", i2);
                jSONObject.put("speed", this.O0000oo);
                jSONObject.put("avchannelmerge", 1);
                this.O0000oo0 = i;
                this.O00000oO.streamPlayback(jSONObject.toString(), iMISSListener);
                this.O000O0o0 = (long) (i + i2);
            } catch (JSONException e) {
                gsy.O00000Oo("CameraPlayerEx", "JSONException:" + e.getLocalizedMessage());
            }
        }
    }

    public final void O0000O0o() {
        Context context;
        this.O00oOooo = false;
        this.O0000oO0 = false;
        Timer timer = this.O00oOoOo;
        if (timer != null) {
            timer.cancel();
        }
        this.O00000oO.setClientListener(null);
        this.O00000oo = null;
        XmVideoViewGl xmVideoViewGl = this.O000O0OO;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.release();
            this.O000O0OO = null;
        }
        BroadcastReceiver broadcastReceiver = this.O000OoO;
        if (broadcastReceiver != null && (context = this.O000OO0o) != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.O000OoO = null;
        }
    }

    public final void O0000OOo() {
        cqg cqg = this.O0000Oo;
        if (cqg != null && cqg.O00000Oo != null) {
            AudioProcess audioProcess = this.O0000Oo.O00000Oo;
            if (audioProcess.O0000oO != null) {
                audioProcess.O0000oO.O000000o();
            }
            audioProcess.O0000o0 = 18;
        }
    }

    public final void O00000Oo(boolean z) {
        cqg cqg = this.O0000Oo;
        if (cqg != null && cqg.O00000Oo != null) {
            this.O0000Oo.O00000Oo.O0000o0O = z;
        }
    }

    public final void O00000o0(boolean z) {
        XmStreamClient xmStreamClient = this.O00000oO;
        if (xmStreamClient != null && this.O0000Oo0 != null) {
            xmStreamClient.streamToggleRemoteVideo(z, null);
        }
    }

    public final void O00000o(boolean z) {
        XmStreamClient xmStreamClient = this.O00000oO;
        if (xmStreamClient != null && this.O0000Oo0 != null) {
            xmStreamClient.streamToggleRemoteAudio(z, null);
        }
    }

    public final void O0000Oo0() {
        this.O00000oO.streamCmdMessage(f13851O000000o, cin.O000000o(dvq.O000000o((long) ((int) ((System.currentTimeMillis() / 1000) + 1)))), new IMISSListener() {
            /* class _m_j.chw.AnonymousClass4 */

            public final void onFailed(int i, String str) {
            }

            public final void onProgress(int i) {
            }

            public final void onSuccess(String str, Object obj) {
            }
        });
    }

    public final void O0000Oo() {
        this.O00000oO.streamCmdMessage(f13851O000000o, cin.O000000o(dvq.O000000o(cij.O000000o(XmPluginHostApi.instance().context()))), new IMISSListener() {
            /* class _m_j.chw.AnonymousClass5 */

            public final void onFailed(int i, String str) {
            }

            public final void onProgress(int i) {
            }

            public final void onSuccess(String str, Object obj) {
            }
        });
    }

    class O000000o extends BroadcastReceiver {
        O000000o() {
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                if (cim.O000000o()) {
                    chw.this.O0000Oo.O000000o(3);
                } else if (cim.O000000o(context)) {
                    chw.this.O0000Oo.O000000o(2);
                } else {
                    chw.this.O0000Oo.O000000o(1);
                }
            } else if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction()) && intent.hasExtra("state")) {
                intent.getIntExtra("state", 0);
                if (intent.getIntExtra("state", 0) == 0) {
                    if (cim.O000000o()) {
                        chw.this.O0000Oo.O000000o(3);
                    } else {
                        chw.this.O0000Oo.O000000o(1);
                    }
                } else if (intent.getIntExtra("state", 0) == 1) {
                    chw.this.O0000Oo.O000000o(2);
                }
            }
        }
    }

    public final void O000000o(boolean z) {
        if (!this.O0000o0) {
            this.O00000oO.streamToggleAudio(z, null);
        }
        this.O0000o0O = z;
        cqg cqg = this.O0000Oo;
        if (cqg != null) {
            if (z) {
                cqg.O0000O0o();
                this.O0000Oo.O00000Oo();
            } else {
                cqg.O00000o0();
                this.O0000Oo.O000000o();
            }
        }
        chr.O000000o(chr.O0000O0o);
    }
}
