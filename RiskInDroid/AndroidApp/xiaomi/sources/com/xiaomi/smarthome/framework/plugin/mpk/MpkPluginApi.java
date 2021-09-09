package com.xiaomi.smarthome.framework.plugin.mpk;

import _m_j.fno;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import org.json.JSONArray;

public class MpkPluginApi {
    public static void onReceiveDevicePush(String str, String str2, JSONArray jSONArray) {
        Device O000000o2 = fno.O000000o().O000000o(str2);
        if (O000000o2 == null) {
            O000000o2 = fno.O000000o().O00000Oo(str2);
        }
        if (O000000o2 != null && str != null) {
            Intent intent = new Intent();
            intent.putExtra("did", str2);
            intent.putExtra("data", jSONArray.toString());
            intent.putExtra("type", "DevicePush");
            PluginApi.getInstance().sendMessage(CommonApplication.getAppContext(), str, 2, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O000000o2), null, false, null);
        }
    }

    public static Intent getIntent(String str, String str2, long j, String str3, boolean z) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("did", str);
        intent.putExtra("event", str2);
        intent.putExtra("time", j);
        intent.putExtra("extra", str3);
        intent.putExtra("isNotified", z);
        intent.putExtra("type", "ScenePush");
        return intent;
    }

    @Deprecated
    public static void callPlugin(String str, int i, Intent intent, DeviceStat deviceStat, SendMessageCallback sendMessageCallback) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 != null) {
            PluginApi.getInstance().sendMessage(CommonApplication.getAppContext(), O000000o2.model, i, intent, deviceStat, null, true, sendMessageCallback);
        } else if (sendMessageCallback != null) {
            sendMessageCallback.onMessageFailure(-1, "not found device");
        }
    }
}
