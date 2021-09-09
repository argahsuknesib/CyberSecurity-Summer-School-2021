package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import _m_j.gnk;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;

public class MediaButtonReceiver extends BroadcastReceiver {
    public void onReceive(Context context, final Intent intent) {
        final String str;
        if (intent != null && "android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
            KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (keyEvent != null) {
                gnk.O00000o0(String.format("MediaButtonReceiver.onReceive " + keyEvent.getAction(), new Object[0]));
            }
            if (((foj) XmBluetoothManager.getInstance()) != null) {
                str = foj.O000000o();
            } else {
                gnk.O00000o0(">>> BluetoothManager null");
                str = "";
            }
            gnk.O00000o0(String.format(">>> model = %s", str));
            CoreApi.O000000o().O000000o(context, new CoreApi.O0000o0() {
                /* class com.xiaomi.smarthome.device.bluetooth.MediaButtonReceiver.AnonymousClass1 */

                public final void onCoreReady() {
                    boolean O00000o = CoreApi.O000000o().O00000o(str);
                    if (!TextUtils.isEmpty(str) && O00000o) {
                        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str);
                        if (CoreApi.O000000o().O00000oO(str) == null) {
                            gnk.O00000oO("not found plugin record:" + str);
                        } else if (O0000Oo == null || O0000Oo.O0000o0()) {
                            Intent intent = new Intent();
                            Intent intent2 = intent;
                            if (intent2 != null) {
                                intent.putExtras(intent2);
                            }
                            PluginApi.getInstance().sendMessage(CommonApplication.getAppContext(), str, 15, intent, null, null, false, null);
                        } else {
                            gnk.O00000oO("plugin is not installed:" + str);
                        }
                    }
                }
            });
        }
    }
}
