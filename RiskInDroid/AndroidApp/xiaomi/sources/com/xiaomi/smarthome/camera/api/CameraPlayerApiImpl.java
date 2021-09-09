package com.xiaomi.smarthome.camera.api;

import _m_j.cid;
import _m_j.cih;
import _m_j.ckd;
import _m_j.cug;
import _m_j.fsf;
import _m_j.wd;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.sankuai.waimai.router.annotation.RouterService;
import com.tutk.DecryptUtil;
import com.tutk.TuTkClient;
import com.xiaomi.aaccodec.AAcCodecImp;
import com.xiaomi.mistream.XmStreamClient;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.IXmStreamClient;
import com.xiaomi.smarthome.camera.XmAAcCodec;
import com.xiaomi.smarthome.camera.XmCameraP2p;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmP2PInfo;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.exopackage.MJExoPlayer;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.fastvideo.decoder.Mp4Record;
import com.xiaomi.smarthome.framework.plugin.mpk.MJExoPlayerImpl;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDownloadManager;

@RouterService
public class CameraPlayerApiImpl implements ICameraPlayerApi {
    private static final CameraPlayerApiImpl INSTANCE = new CameraPlayerApiImpl();
    private CloudVideoDownloadManager.ICloudVideoDownloadListener mCloudVideoDownloadListener;

    @cug
    public static CameraPlayerApiImpl provideInstance() {
        return INSTANCE;
    }

    public XmVideoViewGl createVideoView(Context context, FrameLayout frameLayout, boolean z, int i) {
        return new fsf(context, frameLayout, z, i);
    }

    public XmVideoViewGl createVideoViewOnFront(Context context, FrameLayout frameLayout, boolean z, int i) {
        return new fsf(context, frameLayout, z, i);
    }

    public XmVideoViewGl createMp4View(Context context, FrameLayout frameLayout, boolean z) {
        return new ckd(context, frameLayout).f13962O000000o;
    }

    public XmMp4Record createMp4Record() {
        return new Mp4Record();
    }

    public XmCameraP2p createCameraP2p(XmP2PInfo xmP2PInfo, int i) {
        if (i == 1) {
            return TuTkClient.getCameraClient(xmP2PInfo);
        }
        return null;
    }

    public void updateP2pPwd(DeviceStat deviceStat, int i, Callback<XmP2PInfo> callback) {
        if (deviceStat == null) {
            if (callback != null) {
                callback.onFailure(-1, "deviceStat null");
            }
        } else if (i == 1) {
            DecryptUtil.updateTutkPwd(deviceStat, callback);
        } else if (callback != null) {
            callback.onFailure(-1, "not support type");
        }
    }

    public XmAAcCodec createAAcCodec(boolean z, int i, int i2, int i3) {
        if (z) {
            return new AAcCodecImp(i, i2, i3);
        }
        return new AAcCodecImp();
    }

    public IXmStreamClient createStreamClient(String str, String str2, DeviceStat deviceStat) {
        return XmStreamClient.getInstance(deviceStat, str2);
    }

    public IXmConnectionClient createConnectionClient(XmP2PInfo xmP2PInfo, DeviceStat deviceStat, boolean z) {
        if (!z) {
            if (xmP2PInfo == null) {
                return null;
            }
            return TuTkClient.getCameraClient(xmP2PInfo);
        } else if (deviceStat == null) {
            return null;
        } else {
            return XmStreamClient.getInstance(deviceStat, deviceStat.did);
        }
    }

    public IXmConnectionClient createConnectionClient(XmP2PInfo xmP2PInfo, DeviceStat deviceStat, String str, boolean z) {
        if (!z) {
            if (xmP2PInfo == null) {
                return null;
            }
            return TuTkClient.getCameraClient(xmP2PInfo);
        } else if (deviceStat == null) {
            return null;
        } else {
            return XmStreamClient.getInstance(deviceStat, str);
        }
    }

    public MJExoPlayer createExoPlayer(Context context, ViewGroup viewGroup, AttributeSet attributeSet, int i) {
        return new MJExoPlayerImpl(context, viewGroup, attributeSet, i);
    }

    public boolean shouldStartInCameraProcess(String str) {
        return cih.O00000Oo(str);
    }

    public void cameraPreConnection() {
        wd.O00000o("RN_CAMERA", "start preConnect camera");
        try {
            cih.O00000o();
        } catch (Exception unused) {
        }
    }

    public void disConnectAll() {
        wd.O00000o("RN_CAMERA", "disConnect all camera connections ");
        try {
            cih.O0000O0o();
        } catch (Exception unused) {
        }
    }

    public void disableCameraAutoDisconnect(DeviceStat deviceStat) {
        wd.O00000o("RN_CAMERA", "disable auto disconnect preCameraConnect " + deviceStat.did);
        if (XmStreamClient.sDelayedDisconnectDevices.containsKey(deviceStat.model + "_" + deviceStat.did)) {
            cid.O000000o(deviceStat, deviceStat.did).O00000o0 = true;
        }
        try {
            if (cih.O00000o(deviceStat)) {
                cih.O00000Oo(deviceStat);
            }
        } catch (Exception unused) {
        }
    }

    public void enableCameraAutoDisconnect(DeviceStat deviceStat) {
        wd.O00000o("RN_CAMERA", "enable auto disconnect preCameraConnect " + deviceStat.did);
        cid.O000000o(deviceStat, deviceStat.did).O00000o0 = false;
        try {
            if (cih.O00000o(deviceStat)) {
                cih.O000000o(deviceStat);
                cih.O00000oO();
            }
        } catch (Exception unused) {
        }
    }
}
