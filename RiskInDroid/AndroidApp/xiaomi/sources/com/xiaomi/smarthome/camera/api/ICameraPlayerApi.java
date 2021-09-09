package com.xiaomi.smarthome.camera.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

public interface ICameraPlayerApi {
    void cameraPreConnection();

    XmAAcCodec createAAcCodec(boolean z, int i, int i2, int i3);

    XmCameraP2p createCameraP2p(XmP2PInfo xmP2PInfo, int i);

    IXmConnectionClient createConnectionClient(XmP2PInfo xmP2PInfo, DeviceStat deviceStat, String str, boolean z);

    IXmConnectionClient createConnectionClient(XmP2PInfo xmP2PInfo, DeviceStat deviceStat, boolean z);

    MJExoPlayer createExoPlayer(Context context, ViewGroup viewGroup, AttributeSet attributeSet, int i);

    XmMp4Record createMp4Record();

    XmVideoViewGl createMp4View(Context context, FrameLayout frameLayout, boolean z);

    IXmStreamClient createStreamClient(String str, String str2, DeviceStat deviceStat);

    XmVideoViewGl createVideoView(Context context, FrameLayout frameLayout, boolean z, int i);

    XmVideoViewGl createVideoViewOnFront(Context context, FrameLayout frameLayout, boolean z, int i);

    void disConnectAll();

    void disableCameraAutoDisconnect(DeviceStat deviceStat);

    void enableCameraAutoDisconnect(DeviceStat deviceStat);

    boolean shouldStartInCameraProcess(String str);

    void updateP2pPwd(DeviceStat deviceStat, int i, Callback<XmP2PInfo> callback);
}
