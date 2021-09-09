package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tutk.IAudioSender;
import com.tutk.IOTC.Packet;
import com.xiaomi.aaccodec.AACEncodeEx;
import com.xiaomi.aaccodec.G711;
import com.xiaomi.smarthome.camera.AVFrame;
import com.xiaomi.smarthome.camera.IClientListener;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmCameraP2p;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.nio.charset.Charset;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public final class chv implements IClientListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public O00000Oo f13842O000000o;
    public O00000o0 O00000Oo;
    public cia O00000o;
    public XmCameraP2p O00000o0;
    public XmMp4Record.IRecordTimeListener O00000oO;
    public volatile boolean O00000oo = false;
    public volatile boolean O0000O0o = false;
    public cqg O0000OOo;
    public volatile int O0000Oo;
    public XmVideoViewGl O0000Oo0;
    public volatile int O0000OoO;
    public volatile boolean O0000Ooo = false;
    public volatile int O0000o;
    public volatile long O0000o0;
    public volatile boolean O0000o00 = true;
    public volatile boolean O0000o0O;
    public volatile boolean O0000o0o;
    public volatile long O0000oO;
    public volatile long O0000oO0;
    public long O0000oOO = 0;
    public int O0000oOo = -1;
    public boolean O0000oo;
    public int O0000oo0 = 1;
    private int O0000ooO = 1920;
    private int O0000ooo = 1080;
    private Handler O000O00o = new Handler(Looper.getMainLooper());
    private volatile XmMp4Record O000O0OO;
    private Timer O000O0Oo;
    private volatile long O000O0o = 0;
    private volatile long O000O0o0 = 0;
    private boolean O000O0oO = false;
    private Context O000O0oo;
    private int O000OO;
    private TimerTask O000OO00 = new TimerTask() {
        /* class _m_j.chv.AnonymousClass1 */

        public final void run() {
            if (chv.this.O00000o != null && chv.this.O0000o0o) {
                chv.this.O00000o.onVideoInfo(chv.this.O0000Oo, chv.this.O0000OoO, chv.this.O0000o / 2, (int) (chv.this.O0000oO0 / 2048), (int) (chv.this.O0000oO / 1024));
            }
            chv chv = chv.this;
            chv.O0000o = 0;
            chv.O0000oO0 = 0;
        }
    };
    private boolean O000OO0o;
    private byte[] O000OOOo = null;
    private byte[] O000OOo = null;
    private AACEncodeEx O000OOo0 = null;
    private faf O000OOoO = new faf();
    private boolean O000OOoo = true;
    private BroadcastReceiver O000Oo00 = null;
    private volatile int O00oOoOo = 0;
    private volatile boolean O00oOooO = false;
    private dty O00oOooo;

    public interface O00000Oo {
    }

    public interface O00000o0 {
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onRetry(int i, String str, int i2) {
    }

    public final void O000000o(int i) {
        long j = (long) i;
        this.O0000oO0 += j;
        this.O0000oO += j;
        this.O000O0o0 += j;
    }

    public chv(Context context, dty dty, cia cia, XmVideoViewGl xmVideoViewGl) {
        XmVideoViewGl xmVideoViewGl2;
        this.O000O0oo = context;
        if (this.O000Oo00 == null && this.O000O0oo != null) {
            this.O000Oo00 = new O000000o();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            this.O000O0oo.registerReceiver(this.O000Oo00, intentFilter);
        }
        this.O00oOooo = dty;
        if (DeviceConstant.is2K(dty.getModel())) {
            this.O0000ooO = 2304;
            this.O0000ooo = 1296;
        }
        this.O00000o0 = this.O00oOooo.O0000ooo();
        this.O00000o0.updateInfo(this.O00oOooo.O00000oO);
        this.O00000o0.setClientListener(this);
        this.O00000o = cia;
        this.O0000Oo0 = xmVideoViewGl;
        dty dty2 = this.O00oOooo;
        if (!(dty2 == null || (xmVideoViewGl2 = this.O0000Oo0) == null)) {
            xmVideoViewGl2.setDid(dty2.getDid());
        }
        dty dty3 = this.O00oOooo;
        if (dty3 == null || TextUtils.isEmpty(dty3.getModel()) || (!"chuangmi.camera.ipc019".equals(this.O00oOooo.getModel()) && !"chuangmi.camera.ipc021".equals(this.O00oOooo.getModel()) && !"chuangmi.camera.021a04".equals(this.O00oOooo.getModel()))) {
            this.O0000OOo = new cqg(context, 8000, this.O00oOooo.getModel());
        } else {
            this.O0000OOo = new cqg(context, 16000, this.O00oOooo.getModel());
        }
        this.O0000OOo.O00000o0 = new IAudioSender() {
            /* class _m_j.chv.AnonymousClass2 */

            public final void onSendAudio(byte[] bArr, int i) {
                chv.this.O000000o(bArr.length);
                chv.this.O00000o0.sendAudioData(bArr, i);
            }
        };
        this.O000O0Oo = new Timer();
        this.O000O0Oo.schedule(this.O000OO00, 0, 2000);
        this.O0000o00 = true;
        this.O00000o0.setQuality(((cid) this.O00oOooo).O00000oO().O0000o00);
    }

    public final void onError(int i, String str) {
        cia cia = this.O00000o;
        if (cia != null) {
            cia.onVideoPlayError(i, str);
        }
    }

    public final void onProgress(int i) {
        if (i < 100) {
            this.O0000o0o = false;
        }
        cia cia = this.O00000o;
        if (cia != null) {
            cia.onPrepare(i);
        }
    }

    public final void onConnected() {
        this.O000O00o.post(new Runnable() {
            /* class _m_j.chv.AnonymousClass3 */

            public final void run() {
                if (chv.this.O00000o != null) {
                    chv.this.O00000o.onConnected();
                }
            }
        });
        if (this.O000OOoo) {
            this.O00000o0.resume();
        }
        ((cid) this.O00oOooo).O0000OOo().O00000Oo((Callback<Void>) null);
    }

    public final void onDisConnected() {
        cia cia = this.O00000o;
        if (cia != null) {
            cia.onDisConnected();
        }
    }

    public final void onCtrlData(final int i, final byte[] bArr) {
        if (this.O00000o != null) {
            this.O000O00o.post(new Runnable() {
                /* class _m_j.chv.AnonymousClass4 */

                public final void run() {
                    if (chv.this.O00000o != null) {
                        chv.this.O00000o.onServerCmd(i, bArr);
                    }
                }
            });
        }
    }

    public final void onAudioData(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            O000000o(bArr, (long) Packet.byteArrayToInt(bArr2, 12, false), Packet.byteArrayToShort(bArr2, 0, false));
        }
    }

    public final void onVideoData(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        if (bArr3 != null && bArr2 != null) {
            int length = bArr3.length;
            dty dty = this.O00oOooo;
            AVFrame aVFrame = new AVFrame((byte) 0, bArr2, bArr, length, false, dty != null && dty.O00000o());
            short codecId = aVFrame.getCodecId();
            if (codecId == 138 || codecId == 136) {
                O000000o(bArr3, (long) aVFrame.getTimeStamp(), codecId);
            } else if (this.O0000o0o || aVFrame.isIFrame()) {
                if (!this.O0000o0o && aVFrame.isIFrame()) {
                    this.O0000o0o = true;
                    this.O000O0o = System.currentTimeMillis();
                    this.O000O00o.post(new Runnable() {
                        /* class _m_j.chv.AnonymousClass6 */

                        public final void run() {
                            if (chv.this.O00000o != null) {
                                chv.this.O00000o.onPrepare(101);
                            }
                        }
                    });
                    this.O000O0oO = ((cid) this.O00oOooo).O00000oO().O0000OOo;
                }
                O000000o(aVFrame.frmData.length);
                if (this.O00000Oo != null && this.O0000o0O == aVFrame.isPlayback()) {
                    aVFrame.isPlayback();
                }
                this.O0000o0O = !aVFrame.isPlayback();
                if (!(this.f13842O000000o == null || this.O0000Oo <= 0 || this.O0000Oo == aVFrame.getVideoWidth())) {
                    aVFrame.getVideoWidth();
                    aVFrame.getVideoHeight();
                }
                if (!this.O0000o0O) {
                    this.O000OO0o = this.O0000o0O;
                }
                if (!this.O0000oo || !this.O0000o0O) {
                    this.O000OO = 0;
                    this.O0000Oo = aVFrame.getVideoWidth();
                    this.O0000OoO = aVFrame.getVideoHeight();
                    this.O0000o0O = !aVFrame.isPlayback();
                    if (this.O0000o0O) {
                        this.O0000oo0 = 1;
                    }
                    if (this.O0000Ooo && this.O000O0OO != null) {
                        int timeStamp = aVFrame.getTimeStamp();
                        if (!this.O0000o0O && this.O0000oo0 == 4) {
                            timeStamp /= 4;
                        } else if (!this.O0000o0O && this.O0000oo0 == 16) {
                            timeStamp /= 16;
                        }
                        if (this.O0000Oo == this.O0000ooO && this.O0000OoO == this.O0000ooo) {
                            this.O000O0OO.writeVideoData(aVFrame.frmData, aVFrame.frmData.length, aVFrame.isIFrame(), timeStamp);
                        }
                    }
                    try {
                        this.O0000o++;
                        this.O00oOoOo++;
                        VideoFrame videoFrame = new VideoFrame(aVFrame.frmData, aVFrame.getFrmNo(), aVFrame.getFrmSize(), aVFrame.getVideoWidth(), aVFrame.getVideoHeight(), (long) aVFrame.getTimeStamp(), aVFrame.getVideoType(), aVFrame.isIFrame(), (!this.O0000o0O || !this.O000O0oO) ? 0 : aVFrame.isWartTime() ? 2 : 1, this.O0000o0O, aVFrame.getTimeStampReal());
                        if (this.O0000Oo0 != null) {
                            this.O0000Oo0.drawVideoFrame(videoFrame);
                            if (this.O0000Oo0.getScale() > 0.0f && this.O0000Oo0.getMiniScale() > 0.0f && this.O0000Oo0.getScale() < this.O0000Oo0.getMiniScale()) {
                                this.O0000Oo0.setScale(this.O0000Oo0.getMiniScale(), false);
                            }
                        }
                        this.O0000o0 = (long) aVFrame.getTimeStampReal();
                        if ((this.O0000oOO == 0 && this.O0000o0O && this.O0000o0o) || (this.O0000oOO > 0 && aVFrame.isIFrame() && !this.O0000o0O)) {
                            this.O0000oOO = -1;
                            this.O000O00o.post(new Runnable() {
                                /* class _m_j.chv.AnonymousClass7 */

                                public final void run() {
                                    if (chv.this.O00000o != null) {
                                        chv.this.O00000o.onPrepare(102);
                                        if (chv.this.O0000o0O) {
                                            chv.this.O0000oo0 = 1;
                                        }
                                    }
                                }
                            });
                        }
                    } catch (Exception e) {
                        civ.O00000o("CameraPlayer", e.toString());
                    }
                } else if (!this.O000OO0o) {
                    this.O000OO++;
                    if (this.O000OO > 10) {
                        cia cia = this.O00000o;
                        if (cia != null) {
                            cia.onPauseCamera();
                        }
                        this.O000OO = 0;
                    }
                }
            }
        }
    }

    public final boolean O000000o() {
        return this.O00000oo && this.O0000o0o;
    }

    public final synchronized boolean O00000Oo() {
        return !this.O00000oo;
    }

    public final void O00000o0() {
        civ.O000000o("CameraPlayer", "pausePlay");
        this.O00000oo = false;
        this.O00000o0.pause(this);
        this.O0000OOo.O00000oO();
        this.O00oOooO = false;
        this.O0000o0o = false;
        O0000OOo();
        this.O00oOoOo = 0;
        this.O000O0o0 = 0;
    }

    private void O0000OOo() {
        this.O00000o0.runInP2pThread(new Runnable() {
            /* class _m_j.chv.AnonymousClass5 */

            public final void run() {
                if (chv.this.O0000Oo0 != null) {
                    try {
                        chv.this.O0000Oo0.clearQueue();
                    } catch (Exception e) {
                        cki.O00000oO("CameraPlayer", "Exception:" + e.getLocalizedMessage());
                    }
                }
                if (chv.this.O0000OOo != null) {
                    chv.this.O0000OOo.O0000O0o();
                }
            }
        });
    }

    public final void O00000Oo(int i) {
        civ.O000000o("CameraPlayer", "resumePlay");
        this.O00000o0.setClientListener(this);
        this.O0000OOo.O00000o0();
        boolean z = true;
        this.O00000oo = true;
        this.O00oOooO = false;
        this.O00000o0.resume();
        if (i != 0) {
            z = false;
        }
        this.O000OOoo = z;
        O0000OOo();
    }

    public final boolean O00000o() {
        return !this.O00000oo || this.O00000o0.isPaused();
    }

    public final boolean O00000oO() {
        return this.O00000o0.isConnected();
    }

    public final void O000000o(String str, int i) {
        if (this.O000O0OO == null) {
            civ.O000000o("CameraPlayer", "startRecord");
            this.O000OOoO.O000000o();
            this.O000O0OO = XmPluginHostApi.instance().createMp4Record();
            this.O000O0OO.startRecord(str, i, this.O0000ooO, this.O0000ooo, ("chuangmi.camera.ipc019".equals(this.O00oOooo.getModel()) || "chuangmi.camera.ipc021".equals(this.O00oOooo.getModel()) || "chuangmi.camera.021a04".equals(this.O00oOooo.getModel())) ? 16000 : 8000);
            this.O000O0OO.setRecordTimeListener(this.O00000oO);
            this.O0000Ooo = true;
            if (((cid) this.O00oOooo).O00000oO().O0000o00 != 3) {
                this.O00000o0.setQuality(3);
            }
        }
    }

    public final void O000000o(XmMp4Record.IRecordListener iRecordListener) {
        civ.O000000o("CameraPlayer", "stopRecord");
        this.O0000Ooo = false;
        if (this.O000O0OO == null) {
            iRecordListener.onFailed(-1, "");
            return;
        }
        this.O000O0OO.stopRecord(iRecordListener);
        this.O000O0OO = null;
        this.O00000o0.setQuality(((cid) this.O00oOooo).O00000oO().O0000o00);
    }

    public final void O000000o(boolean z) {
        cqg cqg;
        this.O0000o00 = z;
        if (z && (cqg = this.O0000OOo) != null) {
            cqg.O0000O0o();
        }
        chr.O000000o(chr.O0000O0o);
    }

    public final void O00000o0(int i) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("speed", i);
            jSONObject.put("sessionid", this.O0000oOo);
            str = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            str = "";
        }
        this.O00000o0.playBackSpeed(str.getBytes(Charset.forName("UTF-8")));
        this.O0000oo0 = i;
    }

    public final void O0000O0o() {
        this.O00000oo = false;
        this.O0000o0o = false;
        this.O000O0Oo.cancel();
        this.O00000o0.setClientListener(null);
        this.O00000o = null;
        this.O0000Oo0 = null;
    }

    private void O000000o(byte[] bArr, long j, int i) {
        if (bArr != null && bArr.length != 0 && !this.O00oOooO && this.O00000oo) {
            if (!this.O0000o00) {
                O000000o(bArr.length);
                this.O0000OOo.O000000o(bArr, j, i);
            }
            if (this.O0000Ooo && this.O000O0OO != null) {
                if (i != 136) {
                    if (this.O000OOOo == null) {
                        this.O000OOOo = new byte[10240];
                    }
                    int decode = G711.decode(bArr, 0, bArr.length, this.O000OOOo);
                    if (this.O000OOo0 == null) {
                        this.O000OOo0 = new AACEncodeEx();
                        dty dty = this.O00oOooo;
                        if (dty == null || TextUtils.isEmpty(dty.getModel()) || (!"chuangmi.camera.ipc019".equals(this.O00oOooo.getModel()) && !"chuangmi.camera.ipc021".equals(this.O00oOooo.getModel()) && !"chuangmi.camera.021a04".equals(this.O00oOooo.getModel()))) {
                            this.O000OOo0.initial(8000, 1, 16000);
                        } else {
                            this.O000OOo0.initial(16000, 1, 16000);
                        }
                        this.O000OOo = new byte[2048];
                        this.O000OOoO.O000000o();
                    }
                    byte[] bArr2 = new byte[decode];
                    System.arraycopy(this.O000OOOo, 0, bArr2, 0, decode);
                    this.O000OOoO.O00000Oo(bArr2);
                    while (this.O000OOoO.O000000o(this.O000OOo)) {
                        AACEncodeEx aACEncodeEx = this.O000OOo0;
                        byte[] bArr3 = this.O000OOo;
                        byte[] encode = aACEncodeEx.encode(bArr3, 0, bArr3.length);
                        this.O000O0OO.writeAAcData(encode, encode.length, (int) j);
                    }
                    return;
                }
                this.O000O0OO.writeAAcData(bArr, bArr.length, (int) j);
            }
        }
    }

    class O000000o extends BroadcastReceiver {
        O000000o() {
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                if (cim.O000000o()) {
                    chv.this.O0000OOo.O000000o(3);
                } else if (cim.O000000o(context)) {
                    chv.this.O0000OOo.O000000o(2);
                } else {
                    chv.this.O0000OOo.O000000o(1);
                }
            } else if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction()) && intent.hasExtra("state")) {
                intent.getIntExtra("state", 0);
                if (intent.getIntExtra("state", 0) == 0) {
                    if (cim.O000000o()) {
                        chv.this.O0000OOo.O000000o(3);
                    } else {
                        chv.this.O0000OOo.O000000o(1);
                    }
                } else if (intent.getIntExtra("state", 0) == 1) {
                    chv.this.O0000OOo.O000000o(2);
                }
            }
        }
    }

    public final void O00000oo() {
        civ.O000000o("CameraPlayer", "initial");
        boolean z = false;
        if (TextUtils.isEmpty(this.O00oOooo.O0000oOo()) || TextUtils.isEmpty(this.O00oOooo.O00oOooo())) {
            cia cia = this.O00000o;
            if (cia != null) {
                cia.onVideoPlayError(-20009, "");
            }
        } else {
            this.O0000o = 0;
            this.O0000oO0 = 0;
            this.O00000o0.updateInfo(this.O00oOooo.O00000oO);
            z = true;
        }
        if (z) {
            civ.O000000o("CameraPlayer", "retryPlay");
            this.O00000oo = true;
            this.O0000OOo.O00000o0();
            this.O00000o0.reconnect();
        }
    }
}
