package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.receiver;

import _m_j.fwz;
import _m_j.gbu;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.xiaomi.smarthome.camera.MessageReceiver;
import java.util.HashSet;
import java.util.Set;

public class CloudVideoDownloadReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Set<String> f8574O000000o = new HashSet();

    public static void O000000o(String str) {
        f8574O000000o.add(str);
    }

    public static void O00000Oo(String str) {
        f8574O000000o.remove(str);
    }

    public static boolean O000000o() {
        return f8574O000000o.isEmpty();
    }

    public void onReceive(Context context, Intent intent) {
        ReactContext currentReactContext;
        String stringExtra = intent.getStringExtra("fileId");
        int intExtra = intent.getIntExtra("errorCode", -1);
        int intExtra2 = intent.getIntExtra("status", -1);
        if (intExtra >= 0 && intExtra2 >= 0 && f8574O000000o.contains(stringExtra)) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putInt("status", intExtra2);
            writableNativeMap.putInt("errorCode", intExtra);
            writableNativeMap.putString("fileId", stringExtra);
            ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
            if (reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null) {
                gbu.O00000Oo("rncamera ReactInstanceManager is null, can not send message");
            } else {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(MessageReceiver.CLOUD_VIDEO_DOWNLOAD_LISTENER_NAME, writableNativeMap);
            }
        }
    }
}
