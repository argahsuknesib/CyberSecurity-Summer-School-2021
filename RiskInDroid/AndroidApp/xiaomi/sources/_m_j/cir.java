package _m_j;

import android.text.TextUtils;
import com.tutk.IAudioSender;
import com.tutk.IOTC.Packet;
import com.xiaomi.smarthome.camera.AVFrame;
import com.xiaomi.smarthome.camera.IClientListener;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmCameraP2p;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;

public final class cir implements IClientListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public XmCameraP2p f13909O000000o;
    volatile boolean O00000Oo = false;
    volatile boolean O00000o = true;
    public cid O00000o0;
    volatile boolean O00000oO;
    private O000000o O00000oo;
    private cqg O0000O0o;
    private volatile long O0000OOo = System.currentTimeMillis();
    private int O0000Oo = 0;
    private int O0000Oo0 = 0;
    private int O0000OoO = 3;

    public interface O000000o {
        void onVideoData(String str, VideoFrame videoFrame);
    }

    public final void onCtrlData(int i, byte[] bArr) {
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onRetry(int i, String str, int i2) {
    }

    cir(cid cid, O000000o o000000o) {
        this.O00000o0 = cid;
        this.f13909O000000o = this.O00000o0.O0000ooo();
        XmCameraP2p xmCameraP2p = this.f13909O000000o;
        if (xmCameraP2p != null) {
            xmCameraP2p.setClientListener(this);
            this.f13909O000000o.updateInfo(this.O00000o0.O00000oO);
        }
        this.O00000oo = o000000o;
        cid cid2 = this.O00000o0;
        if (cid2 == null || TextUtils.isEmpty(cid2.getModel()) || (!"chuangmi.camera.ipc019".equals(this.O00000o0.getModel()) && !DeviceConstant.is16K(this.O00000o0.getModel()))) {
            this.O0000O0o = new cqg(XmPluginHostApi.instance().context(), 8000, this.O00000o0.getModel());
        } else {
            this.O0000O0o = new cqg(XmPluginHostApi.instance().context(), 16000, this.O00000o0.getModel());
        }
        this.O0000O0o.O00000o0 = new IAudioSender() {
            /* class _m_j.cir.AnonymousClass1 */

            public final void onSendAudio(byte[] bArr, int i) {
                cir.this.f13909O000000o.sendAudioData(bArr, i);
            }
        };
    }

    public final void onProgress(int i) {
        if (i < 100) {
            this.O00000oO = false;
        }
        gsy.O000000o(6, "LiteCameraPlayer", "progress - ".concat(String.valueOf(i)));
    }

    public final void onConnected() {
        this.f13909O000000o.resume();
    }

    public final void onDisConnected() {
        O000000o();
    }

    public final void onError(int i, String str) {
        gsy.O000000o(6, "LiteCameraPlayer", "error - " + i + ", " + str);
        if (i == -20009) {
            this.O00000o0.O00000Oo(new Callback<Void>() {
                /* class _m_j.cir.AnonymousClass2 */

                public final void onFailure(int i, String str) {
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (cir.this.f13909O000000o != null) {
                        cir.this.f13909O000000o.updateInfo(cir.this.O00000o0.O00000oO);
                        cir.this.O00000Oo();
                    }
                }
            });
            return;
        }
        this.O0000OoO--;
        if (this.O0000OoO > 0) {
            O00000Oo();
        }
    }

    public final void onAudioData(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null && this.O00000Oo && !this.O00000o) {
            short byteArrayToShort = Packet.byteArrayToShort(bArr2, 0, false);
            this.O0000O0o.O000000o(bArr, (long) Packet.byteArrayToInt(bArr2, 12, false), byteArrayToShort);
        }
    }

    public final void onVideoData(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        if (bArr3 != null && bArr2 != null && this.O00000Oo) {
            if (!this.O00000oO) {
                this.O00000oO = true;
            }
            int length = bArr3.length;
            cid cid = this.O00000o0;
            AVFrame aVFrame = new AVFrame((byte) 0, bArr2, bArr, length, false, cid != null && cid.O00000o());
            short codecId = aVFrame.getCodecId();
            this.O0000Oo0++;
            if (System.currentTimeMillis() - this.O0000OOo > 2000) {
                gsy.O000000o(6, "LiteCameraPlayer", this.O00000o0.getDid() + " Receive Frame rate - " + (this.O0000Oo0 / 2));
                this.O0000Oo0 = 0;
                this.O0000OOo = System.currentTimeMillis();
            }
            if (codecId != 138 && codecId != 136) {
                try {
                    this.O00000oo.onVideoData(this.O00000o0.getDid(), new VideoFrame(aVFrame.frmData, aVFrame.getFrmNo(), aVFrame.getFrmSize(), aVFrame.getVideoWidth(), aVFrame.getVideoHeight(), (long) aVFrame.getTimeStamp(), aVFrame.isIFrame()));
                } catch (Exception e) {
                    gsy.O000000o(6, "LiteCameraPlayer", "Exception:" + e.getLocalizedMessage());
                }
            } else if (!this.O00000o) {
                this.O0000O0o.O000000o(bArr3, (long) aVFrame.getTimeStamp(), codecId);
            }
        }
    }

    public final void O000000o() {
        if (this.f13909O000000o != null) {
            gsy.O00000Oo("LiteCameraPlayer", "startPlay");
            try {
                this.f13909O000000o.setClientListener(this);
                this.O00000Oo = true;
                this.O0000OoO = 3;
                this.O0000O0o.O00000o0();
                this.f13909O000000o.connect();
            } catch (NullPointerException e) {
                gsy.O000000o(6, "LiteCameraPlayer", "startPlay NullPointerException:" + e.getLocalizedMessage());
            }
        }
    }

    public final void O00000Oo() {
        if (this.f13909O000000o != null) {
            gsy.O00000Oo("LiteCameraPlayer", "retryPlay");
            try {
                this.O00000Oo = true;
                this.O0000O0o.O00000o0();
                this.f13909O000000o.reconnect();
            } catch (NullPointerException e) {
                gsy.O000000o(6, "LiteCameraPlayer", "retryPlay NullPointerException:" + e.getLocalizedMessage());
            }
        }
    }

    public final void O00000o0() {
        if (this.f13909O000000o != null) {
            gsy.O00000Oo("LiteCameraPlayer", "stopPlay");
            try {
                this.O00000Oo = false;
                this.f13909O000000o.pause(this);
                this.O0000O0o.O00000oO();
                this.f13909O000000o.release(true, this);
                this.f13909O000000o.setClientListener(null);
            } catch (NullPointerException e) {
                gsy.O000000o(6, "LiteCameraPlayer", "stopPlay NullPointerException:" + e.getLocalizedMessage());
            }
        }
    }

    public final void O000000o(int i) {
        XmCameraP2p xmCameraP2p = this.f13909O000000o;
        if (xmCameraP2p != null) {
            this.O0000Oo = i;
            xmCameraP2p.setQuality(i);
        }
    }
}
