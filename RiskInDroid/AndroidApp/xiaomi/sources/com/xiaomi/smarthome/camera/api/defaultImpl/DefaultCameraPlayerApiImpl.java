package com.xiaomi.smarthome.camera.api.defaultImpl;

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
import com.xiaomi.smarthome.camera.api.ICameraPlayerApi;
import com.xiaomi.smarthome.camera.exopackage.MJExoPlayer;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;

public class DefaultCameraPlayerApiImpl implements ICameraPlayerApi {
    public void cameraPreConnection() {
    }

    public XmAAcCodec createAAcCodec(boolean z, int i, int i2, int i3) {
        return null;
    }

    public XmCameraP2p createCameraP2p(XmP2PInfo xmP2PInfo, int i) {
        return null;
    }

    public IXmConnectionClient createConnectionClient(XmP2PInfo xmP2PInfo, DeviceStat deviceStat, String str, boolean z) {
        return null;
    }

    public IXmConnectionClient createConnectionClient(XmP2PInfo xmP2PInfo, DeviceStat deviceStat, boolean z) {
        return null;
    }

    public MJExoPlayer createExoPlayer(Context context, ViewGroup viewGroup, AttributeSet attributeSet, int i) {
        return null;
    }

    public XmMp4Record createMp4Record() {
        return null;
    }

    public XmVideoViewGl createMp4View(Context context, FrameLayout frameLayout, boolean z) {
        return null;
    }

    public IXmStreamClient createStreamClient(String str, String str2, DeviceStat deviceStat) {
        return null;
    }

    public XmVideoViewGl createVideoView(Context context, FrameLayout frameLayout, boolean z, int i) {
        return null;
    }

    public XmVideoViewGl createVideoViewOnFront(Context context, FrameLayout frameLayout, boolean z, int i) {
        return null;
    }

    public void disConnectAll() {
    }

    public void disableCameraAutoDisconnect(DeviceStat deviceStat) {
    }

    public void enableCameraAutoDisconnect(DeviceStat deviceStat) {
    }

    public boolean shouldStartInCameraProcess(String str) {
        return false;
    }

    public void updateP2pPwd(DeviceStat deviceStat, int i, Callback<XmP2PInfo> callback) {
    }
}
