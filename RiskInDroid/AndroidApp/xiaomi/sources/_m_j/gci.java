package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tutk.IAudioSender;
import com.tutk.IOTC.Packet;
import com.xiaomi.smarthome.camera.AVFrame;
import com.xiaomi.smarthome.camera.ICameraPlayerListener;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceModelManager;
import java.util.Arrays;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class gci implements ICameraPlayerListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public IXmConnectionClient f17534O000000o;
    public volatile boolean O00000Oo = false;
    public cqj O00000o;
    public cid O00000o0;
    public volatile boolean O00000oO = true;
    public int O00000oo = 0;
    private O000000o O0000O0o;
    private volatile boolean O0000OOo;
    private int O0000Oo = 0;
    private volatile long O0000Oo0 = System.currentTimeMillis();
    private int O0000OoO = 0;
    private boolean O0000Ooo = false;
    private Runnable O0000o = new Runnable() {
        /* class _m_j.$$Lambda$gci$zQgy2Z2KWP_GZCAZjHsST8Di0YI */

        public final void run() {
            gci.this.O00000o0();
        }
    };
    private bau O0000o0;
    private Handler O0000o00 = null;
    private int O0000o0O = 3;
    private final int O0000o0o = 4;

    public interface O000000o {
        void O000000o(VideoFrame videoFrame);
    }

    public final void onDisConnected() {
    }

    public final void onDisconnectedWithCode(int i) {
    }

    public final void onPause() {
    }

    public final void onRdtDataReceived(byte[] bArr) {
    }

    public final void onResume() {
    }

    public final void onRetry(int i, String str, int i2) {
    }

    public gci(cid cid, O000000o o000000o, boolean z) {
        this.O0000Ooo = z;
        this.O00000o0 = cid;
        this.f17534O000000o = this.O00000o0.O00000Oo(z);
        IXmConnectionClient iXmConnectionClient = this.f17534O000000o;
        if (iXmConnectionClient == null) {
            gsy.O000000o(6, "RNCameraAllPagePlayerEx", "mXmConnectionClient == null");
            return;
        }
        iXmConnectionClient.setStreamClient(this);
        this.f17534O000000o.setAutoVideo(true);
        this.O0000O0o = o000000o;
        this.O00000o = new cqj(XmPluginHostApi.instance().context(), cid.getModel());
        this.O00000o.O00000o0 = new IAudioSender() {
            /* class _m_j.$$Lambda$gci$RZkDn_vsUBpGcFG9WIp1RX9WgZQ */

            public final void onSendAudio(byte[] bArr, int i) {
                gci.this.O000000o(bArr, i);
            }
        };
        this.O0000o00 = new Handler(Looper.getMainLooper());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(byte[] bArr, int i) {
        this.f17534O000000o.sendAudioData(bArr, i);
    }

    public final void onProgress(int i) {
        if (i < 100) {
            this.O0000OOo = false;
        }
        gsy.O00000Oo("RNCameraAllPagePlayerEx", "progress - ".concat(String.valueOf(i)));
    }

    public final void onConnected() {
        if (DeviceModelManager.getInstance().isHualaiCamera(this.O00000o0.getModel())) {
            this.f17534O000000o.sendP2pCmd(256, baw.O000000o(190, null, 4), new IXmConnectionClient.XmActionCallback() {
                /* class _m_j.gci.AnonymousClass1 */

                public final void onFailed(int i, String str) {
                }

                public final void onSuccess(String str, Object obj) {
                    gci.this.O00000oo = 1;
                }
            });
        } else if (!this.O00000o0.O00000o) {
            this.f17534O000000o.resume();
        }
    }

    public final void onCtrlData(int i, byte[] bArr) {
        if (i == 256) {
            int i2 = this.O00000oo;
            if (i2 == 1) {
                this.O0000o0 = new bau();
                bav O000000o2 = this.O0000o0.O000000o(bArr);
                if (O000000o2.f12756O000000o == 191) {
                    this.f17534O000000o.sendP2pCmd(256, O00000Oo(O000000o2), new IXmConnectionClient.XmActionCallback() {
                        /* class _m_j.gci.AnonymousClass2 */

                        public final void onFailed(int i, String str) {
                        }

                        public final void onSuccess(String str, Object obj) {
                            gci.this.O00000oo = 2;
                        }
                    });
                }
            } else if (i2 == 2) {
                bav O000000o3 = this.O0000o0.O000000o(bArr);
                if (O000000o3.f12756O000000o == 193) {
                    O000000o(O000000o3);
                    this.O00000oo = 0;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005e  */
    private static boolean O000000o(bav bav) {
        String str;
        wd.O000000o("RNCameraAllPagePlayerEx", "handleMsg193() called with: info = [" + bav + "]");
        byte[] bArr = bav.O00000o;
        if (bArr == null) {
            wd.O00000o0("RNCameraAllPagePlayerEx", "handleMsg193: ProtocolText is null");
            return false;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(new String(bArr)).nextValue();
            String string = jSONObject.getString("ConnectionRes");
            if (!TextUtils.isEmpty(string)) {
                if (string.equalsIgnoreCase("1")) {
                    str = jSONObject.getString("CameraInfo");
                    if (!TextUtils.isEmpty(str)) {
                        wd.O00000o0("RNCameraAllPagePlayerEx", "protocolControl command 193 cameraInfoString is null");
                        return false;
                    }
                    if (!TextUtils.isEmpty(string) && string.equalsIgnoreCase("1")) {
                        try {
                            JSONObject jSONObject2 = (JSONObject) new JSONTokener(str).nextValue();
                            jSONObject2.getString("iCameraVideoParm");
                            try {
                                JSONObject jSONObject3 = (JSONObject) new JSONTokener(jSONObject2.getString("ChannelResquestResult")).nextValue();
                                String string2 = jSONObject3.getString("controlchannelres");
                                String string3 = jSONObject3.getString("videochannelres");
                                String string4 = jSONObject3.getString("audiochannelres");
                                if ("1".equals(string2) && "1".equals(string3) && "1".equals(string4)) {
                                    wd.O000000o("RNCameraAllPagePlayerEx", "handleMsg193: CONNECT_CAMERA_SUCCESS");
                                    return true;
                                }
                            } catch (Exception e) {
                                wd.O000000o("RNCameraAllPagePlayerEx", "handleMsg193: ", e);
                            }
                        } catch (Exception e2) {
                            wd.O000000o("RNCameraAllPagePlayerEx", "handleMsg193: ", e2);
                        }
                    }
                    return false;
                }
            }
            str = "";
            if (!TextUtils.isEmpty(str)) {
            }
        } catch (Exception e3) {
            wd.O000000o("RNCameraAllPagePlayerEx", "handleMsg193: ", e3);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070 A[SYNTHETIC, Splitter:B:17:0x0070] */
    private byte[] O00000Oo(bav bav) {
        String str;
        byte[] bArr;
        wd.O000000o("RNCameraAllPagePlayerEx", "handleMsg191() called with: info = [" + bav + "]");
        byte[] bArr2 = bav.O00000o;
        byte[] bArr3 = null;
        if (bArr2 != null && bArr2.length >= 17 && (bArr2[0] == 1 || bArr2[0] == 3)) {
            byte[] bArr4 = new byte[16];
            System.arraycopy(bArr2, 1, bArr4, 0, 16);
            String pwd = this.O00000o0.O00000oO.getPwd();
            this.O00000o0.O00000oO.getUid();
            if (bArr2[0] == 3) {
                if (pwd.length() >= 16) {
                    str = pwd.substring(0, 16);
                    wd.O000000o("RNCameraAllPagePlayerEx", " protocolControl 191 使用R'验证 R'=".concat(String.valueOf(str)));
                    if (!str.equals("")) {
                        try {
                            bArr = bat.O00000oO(bax.O000000o(bat.O00000oO(bArr4), bat.O00000oO(str.getBytes())));
                        } catch (Exception e) {
                            wd.O000000o("RNCameraAllPagePlayerEx", "handleMsg191: ", e);
                            bArr = null;
                        }
                        String valueOf = String.valueOf(new Random(System.currentTimeMillis()).nextInt(1000));
                        wd.O000000o("RNCameraAllPagePlayerEx", "k192_connectAuth:");
                        if (bArr.length != 16) {
                            wd.O000000o("RNCameraAllPagePlayerEx", " k192_connectAuth r2 is null");
                        } else {
                            byte[] bArr5 = new byte[23];
                            if (valueOf.length() < 4) {
                                valueOf = valueOf + "1234";
                            }
                            bat.O000000o(bArr5, 0, bArr, 0, 15);
                            bat.O000000o(bArr5, 16, valueOf.getBytes(), 0, 3);
                            bArr5[20] = 1;
                            bArr5[21] = 1;
                            bArr5[22] = 1;
                            wd.O000000o("RNCameraAllPagePlayerEx", " k192_connectAuth data=" + bat.O00000o(bArr5));
                            bArr3 = baw.O000000o(192, bArr5, 4);
                        }
                        wd.O000000o("RNCameraAllPagePlayerEx", "protocolControl send command 192 data:" + bat.O00000o(bArr3));
                    }
                } else {
                    wd.O000000o("RNCameraAllPagePlayerEx", " protocolControl 191 cameraSecretk <16");
                }
            }
            str = "FFFFFFFFFFFFFFFF";
            if (!str.equals("")) {
            }
        }
        return bArr3;
    }

    public final void onError(int i, String str) {
        gsy.O000000o(6, "RNCameraAllPagePlayerEx", "error - " + i + ", " + str);
        this.O0000o0O = this.O0000o0O + -1;
        if (this.O0000o0O > 0) {
            this.O0000o00.removeCallbacks(this.O0000o);
            this.O0000o00.postDelayed(this.O0000o, 3000);
        }
    }

    public final void onAudioData(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null && this.O00000Oo && !this.O00000oO) {
            try {
                int byteArrayToInt = Packet.byteArrayToInt(bArr2, 8, false);
                short byteArrayToShort = Packet.byteArrayToShort(bArr2, 16, false);
                short byteArrayToShort2 = Packet.byteArrayToShort(bArr2, 18, false);
                short byteArrayToShort3 = Packet.byteArrayToShort(bArr2, 0, false);
                long byteArrayToInt2 = (long) Packet.byteArrayToInt(bArr2, 12, false);
                if (this.O00000o != null) {
                    this.O00000o.O000000o(bArr, byteArrayToInt2, byteArrayToShort3, byteArrayToInt, byteArrayToShort, byteArrayToShort2);
                }
            } catch (Exception e) {
                gsy.O000000o(6, "RNCameraAllPagePlayerEx", "onAudioData:" + e.getLocalizedMessage());
            }
        }
    }

    public final void onVideoData(byte[] bArr, byte[] bArr2) {
        AVFrame aVFrame;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (bArr3 != null && bArr4 != null && this.O00000Oo) {
            if (!this.O0000OOo) {
                this.O0000OOo = true;
                O000000o(this.O00000oO);
            }
            if (DeviceModelManager.getInstance().isLvmiAQ1(this.O00000o0.getModel())) {
                aVFrame = new AVFrame(bArr4, bArr3, bArr3.length);
            } else {
                int length = bArr3.length;
                cid cid = this.O00000o0;
                aVFrame = new AVFrame((byte) 0, bArr2, bArr, length, false, cid != null && cid.O00000o());
            }
            if (aVFrame.getVideoWidth() <= 0 || aVFrame.getVideoHeight() <= 0) {
                aVFrame.setVideoWidth(640);
                aVFrame.setVideoHeight(360);
            }
            this.O0000Oo++;
            if (System.currentTimeMillis() - this.O0000Oo0 > 2000) {
                gsy.O00000Oo("RNCameraAllPagePlayerEx", this.O00000o0.getDid() + " Receive Frame rate - " + (this.O0000Oo / 2));
                this.O0000Oo = 0;
                this.O0000Oo0 = System.currentTimeMillis();
            }
            try {
                int i = bArr4[0] == 80 ? 2 : 1;
                O000000o o000000o = this.O0000O0o;
                this.O00000o0.getDid();
                o000000o.O000000o(new VideoFrame(aVFrame.frmData, aVFrame.getFrmNo(), aVFrame.getFrmSize(), aVFrame.getVideoWidth(), aVFrame.getVideoHeight(), (long) aVFrame.getTimeStamp(), i, aVFrame.isIFrame()));
            } catch (Exception e) {
                gsy.O000000o(6, "RNCameraAllPagePlayerEx", "onVideoData:" + e.getLocalizedMessage());
            }
        }
    }

    public final boolean O000000o() {
        return this.O00000Oo && this.O0000OOo;
    }

    public final void O00000Oo() {
        if (this.f17534O000000o != null) {
            gsy.O00000Oo("RNCameraAllPagePlayerEx", "startPlay");
            try {
                this.f17534O000000o.setStreamClient(this);
                this.O00000Oo = true;
                this.O0000o0O = 3;
                this.O00000o.O000000o();
                this.f17534O000000o.startConnect(new IXmConnectionClient.XmActionCallback() {
                    /* class _m_j.gci.AnonymousClass3 */

                    public final void onFailed(int i, String str) {
                    }

                    public final void onSuccess(String str, Object obj) {
                        gci gci = gci.this;
                        gci.O000000o(gci.O00000oO);
                    }
                });
            } catch (Exception e) {
                gsy.O000000o(6, "RNCameraAllPagePlayerEx", "startPlay:" + e.getLocalizedMessage());
            }
        }
    }

    public final void O000000o(boolean z) {
        this.O00000oO = z;
        if (this.f17534O000000o != null) {
            O00000Oo(this.O00000oO);
        }
    }

    public final void O000000o(int i) {
        if (this.f17534O000000o != null) {
            this.O0000OoO = i;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("videoquality", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f17534O000000o.sendP2pCmd(265, jSONObject.toString(), (IXmConnectionClient.XmActionCallback) null);
        }
    }

    private void O00000Oo(boolean z) {
        if (this.O0000Ooo || !DeviceModelManager.getInstance().isHualaiCamera(this.O00000o0.getModel())) {
            this.f17534O000000o.sendP2pCmd(z ? 261 : 260, Arrays.toString(new byte[8]), new IXmConnectionClient.XmActionCallback() {
                /* class _m_j.gci.AnonymousClass5 */

                public final void onFailed(int i, String str) {
                }

                public final void onSuccess(String str, Object obj) {
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0() {
        if (this.f17534O000000o != null) {
            gsy.O00000Oo("RNCameraAllPagePlayerEx", "retryPlay");
            try {
                this.O00000Oo = true;
                this.O00000o.O000000o();
                this.f17534O000000o.startConnect(new IXmConnectionClient.XmActionCallback() {
                    /* class _m_j.gci.AnonymousClass4 */

                    public final void onSuccess(String str, Object obj) {
                        gsy.O00000Oo("RNCameraAllPagePlayerEx", "retryPlay:".concat(String.valueOf(str)));
                        gci gci = gci.this;
                        gci.O000000o(gci.O00000oO);
                    }

                    public final void onFailed(int i, String str) {
                        gsy.O000000o(6, "RNCameraAllPagePlayerEx", "retryPlay:".concat(String.valueOf(i)));
                    }
                });
            } catch (Exception e) {
                gsy.O000000o(6, "RNCameraAllPagePlayerEx", "retryPlay:" + e.getLocalizedMessage());
            }
        }
    }
}
