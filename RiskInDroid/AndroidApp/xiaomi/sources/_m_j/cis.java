package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tutk.IAudioSender;
import com.tutk.IOTC.Packet;
import com.xiaomi.mistream.XmStreamClient;
import com.xiaomi.smarthome.camera.AVFrame;
import com.xiaomi.smarthome.camera.ICameraPlayerListener;
import com.xiaomi.smarthome.camera.IMISSListener;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;

public final class cis implements ICameraPlayerListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public XmStreamClient f13912O000000o;
    volatile boolean O00000Oo = false;
    public volatile boolean O00000o = true;
    cid O00000o0;
    volatile boolean O00000oO;
    private O000000o O00000oo;
    private cqg O0000O0o;
    private volatile long O0000OOo = System.currentTimeMillis();
    private int O0000Oo = 0;
    private int O0000Oo0 = 0;
    private Handler O0000OoO = null;
    private boolean O0000Ooo;
    private Runnable O0000o0 = new Runnable() {
        /* class _m_j.$$Lambda$cis$WYFIXQnp0VGxZCTllVZw9SHE3k */

        public final void run() {
            cis.this.O00000oO();
        }
    };
    private int O0000o00 = 3;

    public interface O000000o {
        void onVideoData(String str, VideoFrame videoFrame);
    }

    public final void onCtrlData(int i, byte[] bArr) {
    }

    public final void onRdtDataReceived(byte[] bArr) {
    }

    public final void onRetry(int i, String str, int i2) {
    }

    cis(cid cid, O000000o o000000o) {
        this.O00000o0 = cid;
        this.f13912O000000o = this.O00000o0.O00oOooO();
        XmStreamClient xmStreamClient = this.f13912O000000o;
        if (xmStreamClient == null) {
            gsy.O000000o(6, "LiteCameraPlayerEx", "mXmStreamClient == null");
            return;
        }
        xmStreamClient.setStreamClient(this);
        this.O00000oo = o000000o;
        cid cid2 = this.O00000o0;
        if (cid2 == null || TextUtils.isEmpty(cid2.getModel()) || (!"chuangmi.camera.ipc019".equals(this.O00000o0.getModel()) && !DeviceConstant.is16K(this.O00000o0.getModel()))) {
            this.O0000O0o = new cqg(XmPluginHostApi.instance().context(), 8000, this.O00000o0.getModel());
        } else {
            this.O0000O0o = new cqg(XmPluginHostApi.instance().context(), 16000, this.O00000o0.getModel());
        }
        this.O0000O0o.O00000o0 = new IAudioSender() {
            /* class _m_j.$$Lambda$cis$pyXRhmocqietCRc97bzE6XWlIb0 */

            public final void onSendAudio(byte[] bArr, int i) {
                cis.this.O000000o(bArr, i);
            }
        };
        this.O0000OoO = new Handler(Looper.getMainLooper());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(byte[] bArr, int i) {
        this.f13912O000000o.sendAudioData(bArr, i);
    }

    public final void onProgress(int i) {
        if (i < 100) {
            this.O00000oO = false;
        }
        gsy.O00000Oo("LiteCameraPlayerEx", "progress - ".concat(String.valueOf(i)));
    }

    public final void onConnected() {
        gsy.O00000Oo("LiteCameraPlayerEx", "onConnected");
    }

    public final void onDisConnected() {
        gsy.O00000Oo("LiteCameraPlayerEx", "onDisConnected");
    }

    public final void onDisconnectedWithCode(int i) {
        gsy.O00000Oo("LiteCameraPlayerEx", "onDisconnectedWithCode");
    }

    public final void onPause() {
        gsy.O00000Oo("LiteCameraPlayerEx", "onPause");
    }

    public final void onResume() {
        gsy.O00000Oo("LiteCameraPlayerEx", "onResume");
    }

    public final void onError(int i, String str) {
        Handler handler;
        gsy.O000000o(6, "LiteCameraPlayerEx", "error - " + i + ", " + str);
        this.O0000o00 = this.O0000o00 + -1;
        if (this.O0000o00 > 0 && (handler = this.O0000OoO) != null) {
            handler.removeCallbacks(this.O0000o0);
            this.O0000OoO.postDelayed(this.O0000o0, 3000);
        }
    }

    public final void onAudioData(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null && this.O00000Oo && !this.O00000o) {
            try {
                short byteArrayToShort = Packet.byteArrayToShort(bArr2, 0, false);
                this.O0000O0o.O000000o(bArr, (long) Packet.byteArrayToInt(bArr2, 12, false), byteArrayToShort);
            } catch (Exception e) {
                gsy.O000000o(6, "LiteCameraPlayerEx", "onAudioData:" + e.getLocalizedMessage());
            }
        }
    }

    public final void onVideoData(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        if (bArr3 != null && bArr2 != null && this.O00000Oo) {
            if (!this.O00000oO) {
                this.O00000oO = true;
                this.f13912O000000o.streamToggleRemoteAudio(!this.O00000o, null);
            }
            int length = bArr3.length;
            cid cid = this.O00000o0;
            AVFrame aVFrame = new AVFrame((byte) 0, bArr2, bArr, length, false, cid != null && cid.O00000o());
            short codecId = aVFrame.getCodecId();
            this.O0000Oo0++;
            if (System.currentTimeMillis() - this.O0000OOo > 2000) {
                gsy.O00000Oo("LiteCameraPlayerEx", this.O00000o0.getDid() + " Receive Frame rate - " + (this.O0000Oo0 / 2));
                this.O0000Oo0 = 0;
                this.O0000OOo = System.currentTimeMillis();
            }
            if (codecId != 138 && codecId != 136) {
                try {
                    this.O00000oo.onVideoData(this.O00000o0.getDid(), new VideoFrame(aVFrame.frmData, aVFrame.getFrmNo(), aVFrame.getFrmSize(), aVFrame.getVideoWidth(), aVFrame.getVideoHeight(), (long) aVFrame.getTimeStamp(), aVFrame.isIFrame()));
                } catch (Exception e) {
                    gsy.O000000o(6, "LiteCameraPlayerEx", "onVideoData:" + e.getLocalizedMessage());
                }
            } else if (!this.O00000o) {
                this.O0000O0o.O000000o(bArr3, (long) aVFrame.getTimeStamp(), codecId);
            }
        }
    }

    public final void O000000o() {
        if (this.f13912O000000o != null) {
            gsy.O00000Oo("LiteCameraPlayerEx", "startPlay");
            try {
                this.f13912O000000o.setStreamClient(this);
                this.O00000Oo = true;
                this.O0000o00 = 3;
                this.O0000O0o.O00000o0();
                this.f13912O000000o.setAutoVideo(true);
                this.f13912O000000o.streamStart(new IMISSListener() {
                    /* class _m_j.cis.AnonymousClass1 */

                    public final void onProgress(int i) {
                    }

                    public final void onSuccess(String str, Object obj) {
                        gsy.O00000Oo("LiteCameraPlayerEx", "startPlay:".concat(String.valueOf(str)));
                        cis.this.f13912O000000o.streamToggleRemoteAudio(!cis.this.O00000o, null);
                    }

                    public final void onFailed(int i, String str) {
                        gsy.O000000o(6, "LiteCameraPlayerEx", "startPlay:".concat(String.valueOf(i)));
                    }
                });
            } catch (Exception e) {
                gsy.O000000o(6, "LiteCameraPlayerEx", "startPlay:" + e.getLocalizedMessage());
            }
        }
    }

    public final void O00000Oo() {
        this.O00000Oo = false;
        this.O00000oO = false;
        if (this.f13912O000000o != null) {
            gsy.O00000Oo("LiteCameraPlayerEx", "stopPlay");
            try {
                this.f13912O000000o.streamStop(new IMISSListener() {
                    /* class _m_j.cis.AnonymousClass3 */

                    public final void onProgress(int i) {
                    }

                    public final void onSuccess(String str, Object obj) {
                        gsy.O00000Oo("LiteCameraPlayerEx", "stopPlay:".concat(String.valueOf(str)));
                    }

                    public final void onFailed(int i, String str) {
                        gsy.O000000o(6, "LiteCameraPlayerEx", "stopPlay:".concat(String.valueOf(i)));
                    }
                });
                this.O0000O0o.O00000oO();
                this.f13912O000000o.releaseRN(false, null);
            } catch (Exception e) {
                gsy.O000000o(6, "LiteCameraPlayerEx", "stopPlay:" + e.getLocalizedMessage());
            }
        }
    }

    public final void O000000o(boolean z) {
        this.O00000o = z;
        XmStreamClient xmStreamClient = this.f13912O000000o;
        if (xmStreamClient != null) {
            xmStreamClient.streamToggleRemoteAudio(!this.O00000o, new IMISSListener() {
                /* class _m_j.cis.AnonymousClass4 */

                public final void onProgress(int i) {
                }

                public final void onSuccess(String str, Object obj) {
                    gsy.O00000Oo("LiteCameraPlayerEx", "result:" + str + " extra:" + obj);
                }

                public final void onFailed(int i, String str) {
                    gsy.O000000o(6, "LiteCameraPlayerEx", "errorCode:" + i + " errorInfo:" + str);
                }
            });
        }
    }

    public final void O000000o(int i) {
        XmStreamClient xmStreamClient = this.f13912O000000o;
        if (xmStreamClient != null) {
            this.O0000Oo = i;
            xmStreamClient.streamResolution(i, null);
        }
    }

    public final synchronized void O00000o0() {
        gsy.O00000Oo("LiteCameraPlayerEx", "startCall");
        this.f13912O000000o.streamStartCall(null);
        this.O0000Ooo = true;
        this.O00000o = false;
        if (this.O0000O0o != null) {
            this.O0000O0o.O00000o();
        }
        chr.O0000oO0();
    }

    public final synchronized void O00000o() {
        gsy.O00000Oo("LiteCameraPlayerEx", "stopCall");
        this.f13912O000000o.streamStopCall(null);
        this.O0000Ooo = false;
        chr.O0000oO();
        if (this.O0000O0o != null) {
            this.O0000O0o.O00000oO();
            this.O0000O0o.O00000o0();
        }
        if (cim.O000000o()) {
            this.O0000O0o.O00000oo();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oO() {
        if (this.f13912O000000o != null) {
            gsy.O00000Oo("LiteCameraPlayerEx", "retryPlay");
            try {
                this.O00000Oo = true;
                this.f13912O000000o.setStreamClient(this);
                this.O0000O0o.O00000o0();
                this.f13912O000000o.setAutoVideo(true);
                this.f13912O000000o.streamStart(new IMISSListener() {
                    /* class _m_j.cis.AnonymousClass2 */

                    public final void onProgress(int i) {
                    }

                    public final void onSuccess(String str, Object obj) {
                        gsy.O00000Oo("LiteCameraPlayerEx", "retryPlay:".concat(String.valueOf(str)));
                        cis.this.f13912O000000o.streamToggleAudio(!cis.this.O00000o, null);
                    }

                    public final void onFailed(int i, String str) {
                        gsy.O000000o(6, "LiteCameraPlayerEx", "retryPlay:".concat(String.valueOf(i)));
                    }
                });
            } catch (Exception e) {
                gsy.O000000o(6, "LiteCameraPlayerEx", "retryPlay:" + e.getLocalizedMessage());
            }
        }
    }
}
