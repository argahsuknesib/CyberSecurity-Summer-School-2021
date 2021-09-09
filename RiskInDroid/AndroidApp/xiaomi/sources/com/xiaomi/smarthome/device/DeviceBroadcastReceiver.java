package com.xiaomi.smarthome.device;

import _m_j.fno;
import _m_j.fso;
import _m_j.gkv;
import _m_j.gnk;
import _m_j.gsy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;

public class DeviceBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, final Intent intent) {
        gnk.O00000o0("DeviceBroadcastReceiver.onReceive " + intent.getAction());
        if ("com.xiaomi.smarthome.RECEIVE_MESSAGE".equals(intent.getAction())) {
            gsy.O000000o(3, "DeviceBroadcastReceiver", "onReceive:" + intent.toString());
            final Device O00000o0 = fno.O000000o().O00000o0(intent.getStringExtra("device_id"));
            final String stringExtra = O00000o0 != null ? O00000o0.model : intent.getStringExtra("user_model");
            CoreApi.O000000o().O000000o(context, new CoreApi.O0000o0() {
                /* class com.xiaomi.smarthome.device.DeviceBroadcastReceiver.AnonymousClass1 */

                public final void onCoreReady() {
                    boolean O00000o2 = CoreApi.O000000o().O00000o(stringExtra);
                    gnk.O00000o0(">>> model = " + stringExtra + ", isPlugin = " + O00000o2);
                    if (!TextUtils.isEmpty(stringExtra) && O00000o2) {
                        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(stringExtra);
                        if (O0000Oo == null) {
                            gsy.O000000o(6, "DeviceBroadcastReceiver", "not found plugin record:" + stringExtra);
                        } else if (!O0000Oo.O0000o0()) {
                            gsy.O000000o(6, "DeviceBroadcastReceiver", "plugin is not installed:" + stringExtra);
                        } else {
                            Intent intent = new Intent();
                            Intent intent2 = intent;
                            if (intent2 != null) {
                                intent.putExtras(intent2);
                            }
                            PluginApi.getInstance().sendMessage(gkv.f17949O000000o, stringExtra, 15, intent, O00000o0 != null ? DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O00000o0) : null, null, false, new SendMessageCallback() {
                                /* class com.xiaomi.smarthome.device.DeviceBroadcastReceiver.AnonymousClass1.AnonymousClass1 */

                                public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                                    super.onDownloadStart(str, pluginDownloadTask);
                                    gnk.O00000o0(">>> onDownloadStart");
                                }

                                public final void onDownloadProgress(String str, float f) {
                                    super.onDownloadProgress(str, f);
                                    gnk.O00000o0(">>> onDownloadProgress");
                                }

                                public final void onDownloadSuccess(String str) {
                                    super.onDownloadSuccess(str);
                                    gnk.O00000o0(">>> onDownloadSuccess");
                                }

                                public final void onDownloadFailure(PluginError pluginError) {
                                    super.onDownloadFailure(pluginError);
                                    gnk.O00000o0(">>> onDownloadFailure");
                                }

                                public final void onDownloadCancel() {
                                    super.onDownloadCancel();
                                    gnk.O00000o0(">>> onDownloadCancel");
                                }

                                public final void onInstallStart(String str) {
                                    super.onInstallStart(str);
                                    gnk.O00000o0(">>> onInstallStart");
                                }

                                public final void onInstallSuccess(String str) {
                                    super.onInstallSuccess(str);
                                    gnk.O00000o0(">>> onInstallSuccess");
                                }

                                public final void onInstallFailure(PluginError pluginError) {
                                    super.onInstallFailure(pluginError);
                                    gnk.O00000o0(">>> onInstallFailure " + pluginError.O00000Oo);
                                }

                                public final void onLoadSuccess(String str) {
                                    super.onLoadSuccess(str);
                                    gnk.O00000o0(">>> onLoadSuccess");
                                }

                                public final void onLoadFailure(String str) {
                                    super.onLoadFailure(str);
                                    gnk.O00000o0(">>> onLoadFailure ");
                                }

                                public final void onSendSuccess(Bundle bundle) {
                                    super.onSendSuccess(bundle);
                                    gnk.O00000o0(">>> onSendSuccess ");
                                }

                                public final void onMessageHandle(boolean z) {
                                    super.onMessageHandle(z);
                                    gnk.O00000o0(">>> onMessageHandle ".concat(String.valueOf(z)));
                                }

                                public final void onMessageSuccess(Intent intent) {
                                    super.onMessageSuccess(intent);
                                    gnk.O00000o0(">>> onMessageSuccess ");
                                }

                                public final void onMessageFailure(int i, String str) {
                                    super.onMessageFailure(i, str);
                                    gnk.O00000o0(">>> onMessageFailure " + i + ", " + str);
                                }

                                public final void onSendCancel() {
                                    super.onSendCancel();
                                    gnk.O00000o0(">>> onSendCancel ");
                                }

                                public final void onSendFailure(fso fso) {
                                    super.onSendFailure(fso);
                                    gnk.O00000o0(">>> onSendFailure " + fso.O00000Oo);
                                }
                            });
                        }
                    }
                }
            });
        }
    }
}
