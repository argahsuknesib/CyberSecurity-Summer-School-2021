package com.xiaomi.smarthome.miio.camera.match;

import _m_j.ft;
import android.content.Intent;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.util.HashMap;

public class CameraInfoManager {
    private static CameraInfoManager __INSTANCE__;
    HashMap<String, CameraInfo> cameraInfoMap = new HashMap<>();

    private CameraInfoManager() {
    }

    public static synchronized CameraInfoManager instance() {
        CameraInfoManager cameraInfoManager;
        synchronized (CameraInfoManager.class) {
            if (__INSTANCE__ == null) {
                __INSTANCE__ = new CameraInfoManager();
            }
            cameraInfoManager = __INSTANCE__;
        }
        return cameraInfoManager;
    }

    public CameraInfo getCameraInfo(CameraDevice cameraDevice) {
        String str = cameraDevice.did;
        CameraInfo cameraInfo = this.cameraInfoMap.get(str);
        if (cameraInfo != null) {
            return cameraInfo;
        }
        CameraInfo cameraInfo2 = new CameraInfo(str);
        this.cameraInfoMap.put(str, cameraInfo2);
        return cameraInfo2;
    }

    public static void broadcastStatusChanged() {
        Intent intent = new Intent("p2p_status_refresh_broadcast");
        ft O000000o2 = ft.O000000o(XmPluginHostApi.instance().context());
        if (O000000o2 != null) {
            O000000o2.O000000o(intent);
        }
    }
}
