package com.xiaomi.smarthome.camera;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.device.api.BaseWidgetView;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.IXmPluginMessageReceiver;
import com.xiaomi.smarthome.device.api.MessageCallback;

public class MessageReceiver implements IXmPluginMessageReceiver {
    public static String CLOUD_VIDEO_DOWNLOAD_LISTENER_NAME = "cloudVideoDownloadProgressCallbackName";

    public BaseWidgetView createWidgetView(Context context, LayoutInflater layoutInflater, XmPluginPackage xmPluginPackage, int i, Intent intent, DeviceStat deviceStat) {
        return null;
    }

    public boolean handleMessage(Context context, XmPluginPackage xmPluginPackage, int i, Intent intent, DeviceStat deviceStat, MessageCallback messageCallback) {
        return false;
    }

    public boolean handleMessage(Context context, XmPluginPackage xmPluginPackage, int i, Intent intent, DeviceStat deviceStat) {
        Intent intent2 = new Intent();
        if (i == 1) {
            intent2.setAction("com.xiaomi.smarthome.camera.LANUCH");
        } else if (i == 2) {
            intent2.setAction("com.xiaomi.smarthome.camera.PUSH_MSG");
        } else if (i == 18) {
            intent2.setAction("com.xiaomi.smarthome.camera.INIT_CAMERA_FRAME_SENDER");
        } else if (i == 19) {
            intent2.setAction("com.xiaomi.smarthome.camera.STAR_REQUEST_CAMERA_FRAME");
        } else if (i == 20) {
            intent2.setAction("com.xiaomi.smarthome.camera.STOP_REQUEST_CAMERA_FRAME");
        } else if (i == 21) {
            intent2.setAction("com.xiaomi.smarthome.camera.DESTROY_REQUEST_CAMERA_FRAME");
        } else if (i == 23) {
            intent2.setAction("com.xiaomi.smarthome.camera.MSG_START_AUDIO_CALL");
        } else if (i == 24) {
            intent2.setAction("com.xiaomi.smarthome.camera.MSG_STOP_AUDIO_CALL");
        }
        intent2.setPackage(context.getPackageName());
        intent2.putExtra("extra_device_did", deviceStat.did);
        intent2.putExtra("extra_device_model", deviceStat.model);
        if (intent != null) {
            intent2.putExtras(intent);
        }
        context.sendBroadcast(intent2);
        return false;
    }
}
