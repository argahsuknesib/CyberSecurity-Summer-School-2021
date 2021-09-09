package _m_j;

import _m_j.chu;
import _m_j.cir;
import _m_j.cis;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.util.HashMap;

public final class ciq {
    private static ciq O0000O0o;

    /* renamed from: O000000o  reason: collision with root package name */
    public HashMap<String, Object> f13906O000000o = new HashMap<>();
    HandlerThread O00000Oo = new HandlerThread("camera_frame_receiver");
    private XmPluginPackage O00000o;
    private Handler O00000o0;
    private int O00000oO = 1;
    private boolean O00000oo = true;

    class O000000o extends Handler {
        O000000o(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                final cid cid = (cid) message.obj;
                cid.O00000Oo(new Callback<Void>() {
                    /* class _m_j.ciq.O000000o.AnonymousClass1 */

                    public final void onFailure(int i, String str) {
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        ciq.this.O000000o(cid);
                    }
                });
            }
        }
    }

    public final void O000000o(cid cid) {
        if (cid == null || !cid.O00000o()) {
            gsy.O00000Oo("CameraFrameManager", "startPlay:" + cid.getModel() + ":" + cid.getDid());
            cir cir = new cir(cid, new cir.O000000o() {
                /* class _m_j.$$Lambda$ciq$bVbsAMfpbVTBKhcmC1nLkNHQ1YY */

                public final void onVideoData(String str, VideoFrame videoFrame) {
                    ciq.O00000Oo(cid.this, str, videoFrame);
                }
            });
            cir.O00000o = this.O00000oo;
            cir.O000000o(this.O00000oO);
            cir.O000000o();
            this.f13906O000000o.put(cid.getDid(), cir);
            return;
        }
        gsy.O00000Oo("CameraFrameManager", "startPlayEx:" + cid.getModel() + ":" + cid.getDid());
        cis cis = new cis(cid, new cis.O000000o() {
            /* class _m_j.$$Lambda$ciq$Z7kHi1SLv_8Q94uJCZUD7msLCgQ */

            public final void onVideoData(String str, VideoFrame videoFrame) {
                ciq.O00000o0(cid.this, str, videoFrame);
            }
        });
        cis.O000000o(this.O00000oo);
        cis.O000000o(this.O00000oO);
        cis.O000000o();
        this.f13906O000000o.put(cid.getDid(), cis);
    }

    public static ciq O000000o() {
        if (O0000O0o == null) {
            O0000O0o = new ciq();
        }
        return O0000O0o;
    }

    private ciq() {
        this.O00000Oo.start();
        this.O00000o0 = new O000000o(this.O00000Oo.getLooper());
    }

    public final void O000000o(DeviceStat deviceStat) {
        cid O000000o2 = cid.O000000o(deviceStat, deviceStat.did);
        if (O000000o2 != null) {
            try {
                if (O000000o2.O00000o()) {
                    gsy.O00000Oo("CameraFrameManager", "stopPlayEx");
                    cis cis = (cis) this.f13906O000000o.get(deviceStat.did);
                    if (cis != null) {
                        gsy.O00000Oo("CameraFrameManager", "do stopPlayEx");
                        cis.O00000Oo();
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                gsy.O000000o(6, "CameraFrameManager", "JSONException:" + e.getLocalizedMessage());
                return;
            }
        }
        gsy.O00000Oo("CameraFrameManager", "stopPlay");
        cir cir = (cir) this.f13906O000000o.get(deviceStat.did);
        if (cir != null) {
            cir.O00000o0();
        }
    }

    public static void O00000Oo(DeviceStat deviceStat) {
        XmPluginHostApi.instance().initCameraFrameSender(deviceStat.did);
    }

    public final void O00000o0(DeviceStat deviceStat) {
        cid O000000o2 = cid.O000000o(deviceStat, deviceStat.did);
        if (O000000o2 != null) {
            try {
                if (O000000o2.O00000o()) {
                    cis cis = (cis) this.f13906O000000o.get(deviceStat.did);
                    gsy.O000000o(4, "CameraFrameManager", "stopRequestDataEx");
                    if (cis != null) {
                        cis.O00000Oo();
                        cis.O00000Oo = false;
                        cis.O00000oO = false;
                        if (cis.f13912O000000o != null) {
                            gsy.O00000Oo("LiteCameraPlayerEx", "release");
                            try {
                                cis.f13912O000000o.releaseRN(false, null);
                                cis.O00000o0.O000O00o();
                            } catch (Exception e) {
                                gsy.O000000o(6, "LiteCameraPlayerEx", "release:" + e.getLocalizedMessage());
                            }
                        }
                    }
                    XmPluginHostApi.instance().closeCameraFrameSender(deviceStat.did);
                    this.f13906O000000o.remove(deviceStat.did);
                    return;
                }
            } catch (Exception e2) {
                gsy.O000000o(6, "CameraFrameManager", "JSONException:" + e2.getLocalizedMessage());
                return;
            }
        }
        gsy.O00000Oo("CameraFrameManager", "stopRequestData");
        cir cir = (cir) this.f13906O000000o.get(deviceStat.did);
        if (cir != null) {
            cir.O00000o0();
            if (cir.f13909O000000o != null) {
                gsy.O00000Oo("LiteCameraPlayer", "release");
                try {
                    cir.f13909O000000o.release(true, cir);
                    cir.f13909O000000o.setClientListener(null);
                    cir.O00000o0.O000O00o();
                } catch (NullPointerException e3) {
                    gsy.O000000o(6, "LiteCameraPlayer", "release NullPointerException:" + e3.getLocalizedMessage());
                }
            }
        }
        XmPluginHostApi.instance().closeCameraFrameSender(deviceStat.did);
        this.f13906O000000o.remove(deviceStat.did);
    }

    public final void O000000o(DeviceStat deviceStat, Intent intent) {
        goq.O000000o(new Runnable(intent, deviceStat, null) {
            /* class _m_j.$$Lambda$ciq$Tos99nnNbQ3SfthQ0JbPnRyMHMY */
            private final /* synthetic */ Intent f$1;
            private final /* synthetic */ DeviceStat f$2;
            private final /* synthetic */ XmPluginPackage f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                ciq.this.O000000o(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Intent intent, DeviceStat deviceStat, XmPluginPackage xmPluginPackage) {
        boolean z = true;
        if (intent != null) {
            this.O00000oO = intent.getIntExtra("request_frame_rate", 1);
            this.O00000oo = intent.getBooleanExtra("mute", true);
        }
        cid O000000o2 = cid.O000000o(deviceStat, deviceStat.did);
        if (O000000o2 != null) {
            try {
                if (O000000o2.O00000o()) {
                    civ.O000000o(O000000o2.getModel());
                    cis cis = (cis) this.f13906O000000o.get(deviceStat.did);
                    gsy.O00000Oo("CameraFrameManager", "startRequestDataEx");
                    if (cis != null) {
                        cis.O000000o(this.O00000oo);
                        if (!cis.O00000Oo || !cis.O00000oO) {
                            z = false;
                        }
                        if (z) {
                            cis.O000000o(this.O00000oO);
                        } else {
                            cis.O000000o(this.O00000oO);
                            cis.O000000o();
                        }
                        gsy.O000000o(4, "CameraFrameManager", "playerEx not null");
                        return;
                    }
                    cid cid = new cid(deviceStat);
                    cis cis2 = new cis(cid, new cis.O000000o() {
                        /* class _m_j.$$Lambda$ciq$cA0_FluglC4vfAgKM1mKqT3kp0 */

                        public final void onVideoData(String str, VideoFrame videoFrame) {
                            ciq.O000000o(cid.this, str, videoFrame);
                        }
                    });
                    cis2.O000000o(this.O00000oo);
                    cis2.O000000o(this.O00000oO);
                    cis2.O000000o();
                    this.f13906O000000o.put(cid.getDid(), cis2);
                    gsy.O000000o(6, "CameraFrameManager", "playerEx null");
                    return;
                }
            } catch (Exception e) {
                gsy.O000000o(6, "CameraFrameManager", "JSONException:" + e.getLocalizedMessage());
                return;
            }
        }
        gsy.O00000Oo("CameraFrameManager", "startRequestData");
        cir cir = (cir) this.f13906O000000o.get(deviceStat.did);
        if (cir == null) {
            cid cid2 = new cid(deviceStat);
            this.O00000o = xmPluginPackage;
            civ.O000000o(cid2.getModel());
            chr.O000000o(cid2.getDid(), cid2.getModel());
            chp.O000000o(XmPluginHostApi.instance().context());
            Message message = new Message();
            message.what = 1;
            message.obj = cid2;
            this.O00000o0.sendMessage(message);
            return;
        }
        cir.O00000o = this.O00000oo;
        if (!cir.O00000Oo || !cir.O00000oO) {
            z = false;
        }
        if (z) {
            cir.O000000o(this.O00000oO);
            return;
        }
        cir.O000000o(this.O00000oO);
        cir.O000000o();
    }

    public final void O00000o(DeviceStat deviceStat) {
        cis cis;
        cid O000000o2 = cid.O000000o(deviceStat, deviceStat.did);
        if (O000000o2 != null && O000000o2.O00000o() && (cis = (cis) this.f13906O000000o.get(deviceStat.did)) != null) {
            gsy.O00000Oo("CameraFrameManager", "do stopCall");
            cis.O00000o();
        }
    }

    public final void O00000oO(DeviceStat deviceStat) {
        cis cis;
        cid O000000o2 = cid.O000000o(deviceStat, deviceStat.did);
        if (O000000o2 != null && O000000o2.O00000o() && (cis = (cis) this.f13906O000000o.get(deviceStat.did)) != null) {
            gsy.O00000Oo("CameraFrameManager", "do startCall");
            cis.O00000o0();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(cid cid, String str, VideoFrame videoFrame) {
        VideoFrame videoFrame2 = videoFrame;
        chu chu = chu.O000000o.f13841O000000o;
        if (chu.O00000Oo(cid.getModel()) == 0) {
            XmPluginHostApi.instance().sendCameraFrame(str, videoFrame2.data, videoFrame2.num, videoFrame2.size, videoFrame2.timeStamp, 2, videoFrame2.isIFrame, videoFrame2.width, videoFrame2.height);
            return;
        }
        XmPluginHostApi.instance().sendCameraFrame(str, videoFrame2.data, videoFrame2.num, videoFrame2.size, videoFrame2.timeStamp, videoFrame2.isIFrame, videoFrame2.width, videoFrame2.height);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000Oo(cid cid, String str, VideoFrame videoFrame) {
        VideoFrame videoFrame2 = videoFrame;
        chu chu = chu.O000000o.f13841O000000o;
        if (chu.O00000Oo(cid.getModel()) == 0) {
            XmPluginHostApi.instance().sendCameraFrame(str, videoFrame2.data, videoFrame2.num, videoFrame2.size, videoFrame2.timeStamp, 2, videoFrame2.isIFrame, videoFrame2.width, videoFrame2.height);
            return;
        }
        XmPluginHostApi.instance().sendCameraFrame(str, videoFrame2.data, videoFrame2.num, videoFrame2.size, videoFrame2.timeStamp, videoFrame2.isIFrame, videoFrame2.width, videoFrame2.height);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000o0(cid cid, String str, VideoFrame videoFrame) {
        VideoFrame videoFrame2 = videoFrame;
        chu chu = chu.O000000o.f13841O000000o;
        if (chu.O00000Oo(cid.getModel()) == 0) {
            XmPluginHostApi.instance().sendCameraFrame(str, videoFrame2.data, videoFrame2.num, videoFrame2.size, videoFrame2.timeStamp, 2, videoFrame2.isIFrame, videoFrame2.width, videoFrame2.height);
            return;
        }
        XmPluginHostApi.instance().sendCameraFrame(str, videoFrame2.data, videoFrame2.num, videoFrame2.size, videoFrame2.timeStamp, videoFrame2.isIFrame, videoFrame2.width, videoFrame2.height);
    }
}
