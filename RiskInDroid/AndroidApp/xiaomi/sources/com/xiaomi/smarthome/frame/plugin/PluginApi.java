package com.xiaomi.smarthome.frame.plugin;

import _m_j.exz;
import _m_j.fcx;
import _m_j.fkl;
import _m_j.fso;
import _m_j.fsr;
import _m_j.ftc;
import _m_j.gsy;
import _m_j.hsi;
import _m_j.hxi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.DownloadRnSdkResult;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.rn.debugmock.MockRnDevicePluginManager;
import com.xiaomi.smarthome.library.common.util.SerialExecutor;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.concurrent.Executor;

public class PluginApi {
    private static volatile PluginApi sInstance;
    private static final Object sLock = new Object();
    private Executor mExecutor;

    public static class BindServiceCallback {
        public void onFailure(fso fso) {
        }

        public void onSuccess() {
        }
    }

    public static class StartServiceCallback {
        public void onFailure(fso fso) {
        }

        public void onSuccess() {
        }
    }

    public static class UnBindServiceCallback {
        public void onFailure(fso fso) {
        }

        public void onSuccess() {
        }
    }

    public static boolean checkPluginUpdateMessageType(int i) {
        return i == 1;
    }

    private PluginApi() {
    }

    public static PluginApi getInstance() {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new PluginApi();
                }
            }
        }
        return sInstance;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
     arg types: [java.lang.String, int, com.xiaomi.smarthome.frame.plugin.PluginApi$1]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
     arg types: [java.lang.String, int, com.xiaomi.smarthome.frame.plugin.PluginApi$2]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
     arg types: [java.lang.String, int, com.xiaomi.smarthome.frame.plugin.PluginApi$3]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void */
    public SendMessageHandle installPlugin(Context context, String str, SendMessageCallback sendMessageCallback) {
        gsy.O000000o(6, "Device_Renderer", "1 - " + System.currentTimeMillis());
        if (context == null) {
            if (sendMessageCallback != null) {
                sendMessageCallback.onSendFailure(new fso(-1, CommonApplication.getAppContext().getString(R.string.code_env_error)));
            }
            LogType logType = LogType.PLUGIN;
            gsy.O00000Oo(logType, "click_device_list", str + "sendMessage 1");
            return new SendMessageHandle();
        } else if (CoreApi.O000000o().O0000Oo0(str)) {
            if (sendMessageCallback != null) {
                sendMessageCallback.onSendFailure(new fso(-1, context.getString(R.string.installerror_forceupdate)));
            }
            LogType logType2 = LogType.PLUGIN;
            gsy.O00000Oo(logType2, "click_device_list", str + "sendMessage 3");
            return new SendMessageHandle();
        } else {
            SendMessageHandle sendMessageHandle = new SendMessageHandle();
            PluginPackageInfo O0000OoO = CoreApi.O000000o().O0000OoO(str);
            PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str);
            if (O0000OoO == null && O0000Oo == null) {
                final SendMessageCallback sendMessageCallback2 = sendMessageCallback;
                final String str2 = str;
                final SendMessageHandle sendMessageHandle2 = sendMessageHandle;
                final Context context2 = context;
                CoreApi.O000000o().O000000o(str, true, (CoreApi.O0000OOo) new CoreApi.O0000OOo() {
                    /* class com.xiaomi.smarthome.frame.plugin.PluginApi.AnonymousClass1 */
                    private long startTime = 0;

                    public void onStart(String str, PluginDownloadTask pluginDownloadTask) {
                        this.startTime = System.currentTimeMillis();
                        SendMessageCallback sendMessageCallback = sendMessageCallback2;
                        if (sendMessageCallback != null) {
                            sendMessageCallback.onDownloadStart(str, pluginDownloadTask);
                        }
                    }

                    public void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
                        SendMessageCallback sendMessageCallback = sendMessageCallback2;
                        if (sendMessageCallback != null) {
                            sendMessageCallback.onDownInfoSuccess(str, pluginDownloadTask);
                        }
                    }

                    public void onProgress(String str, float f) {
                        SendMessageCallback sendMessageCallback = sendMessageCallback2;
                        if (sendMessageCallback != null) {
                            sendMessageCallback.onDownloadProgress(str, f);
                        }
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
                     arg types: [java.lang.String, int, com.xiaomi.smarthome.frame.plugin.PluginApi$1$1]
                     candidates:
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void */
                    public void onSuccess(String str) {
                        if (this.startTime > 0 && str != null) {
                            hxi.O0000Oo.O000000o(System.currentTimeMillis() - this.startTime, str);
                        }
                        SendMessageCallback sendMessageCallback = sendMessageCallback2;
                        if (sendMessageCallback != null) {
                            sendMessageCallback.onDownloadSuccess(str);
                        }
                        SendMessageCallback sendMessageCallback2 = sendMessageCallback2;
                        if (sendMessageCallback2 != null) {
                            sendMessageCallback2.onInstallBefore(str);
                        }
                        CoreApi.O000000o().O000000o(str, false, (CoreApi.O0000Oo) new CoreApi.O0000Oo() {
                            /* class com.xiaomi.smarthome.frame.plugin.PluginApi.AnonymousClass1.AnonymousClass1 */

                            public void onStart(String str) {
                                if (sendMessageCallback2 != null) {
                                    sendMessageCallback2.onInstallStart(str2);
                                }
                            }

                            public void onSuccess(String str) {
                                if (sendMessageCallback2 != null) {
                                    sendMessageCallback2.onInstallSuccess(str2);
                                }
                                if (sendMessageHandle2.isCanceled() && sendMessageCallback2 != null) {
                                    sendMessageCallback2.onSendCancel();
                                }
                            }

                            public void onFailure(PluginError pluginError) {
                                if (sendMessageCallback2 != null) {
                                    sendMessageCallback2.onInstallFailure(pluginError);
                                    sendMessageCallback2.onSendFailure(new fso(pluginError.f6718O000000o, pluginError.O000000o(context2)));
                                }
                                LogType logType = LogType.PLUGIN;
                                gsy.O00000o0(logType, "click_device_list", str2 + " sendMessage-downloadPlugin-installPlugin-onFailure error:" + pluginError);
                            }

                            public void onCancel() {
                                if (sendMessageCallback2 != null) {
                                    sendMessageCallback2.onInstallFailure(new PluginError(-6, ""));
                                    sendMessageCallback2.onSendFailure(new fso(-1, context2.getString(R.string.sh_common_cancel)));
                                }
                                LogType logType = LogType.PLUGIN;
                                gsy.O00000o0(logType, "click_device_list", str2 + " sendMessage-downloadPlugin-installPlugin-onCancel");
                            }
                        });
                    }

                    public void onFailure(PluginError pluginError) {
                        SendMessageCallback sendMessageCallback = sendMessageCallback2;
                        if (sendMessageCallback != null) {
                            sendMessageCallback.onDownloadFailure(pluginError);
                            sendMessageCallback2.onSendFailure(new fso(pluginError.f6718O000000o, pluginError.O000000o(context2)));
                        }
                        LogType logType = LogType.PLUGIN;
                        gsy.O00000o0(logType, "click_device_list", str2 + " sendMessage-downloadPlugin-onFailure error:" + pluginError);
                    }

                    public void onCancel() {
                        SendMessageCallback sendMessageCallback = sendMessageCallback2;
                        if (sendMessageCallback != null) {
                            sendMessageCallback.onDownloadCancel();
                            sendMessageCallback2.onSendFailure(new fso(-1, context2.getString(R.string.sh_common_cancel)));
                        }
                        LogType logType = LogType.PLUGIN;
                        gsy.O00000o0(logType, "click_device_list", str2 + " sendMessage-downloadPlugin-onCancel");
                    }
                });
            } else if (O0000OoO != null && O0000Oo == null) {
                if (sendMessageCallback != null) {
                    sendMessageCallback.onInstallBefore(str);
                }
                final SendMessageCallback sendMessageCallback3 = sendMessageCallback;
                final String str3 = str;
                final SendMessageHandle sendMessageHandle3 = sendMessageHandle;
                final Context context3 = context;
                CoreApi.O000000o().O000000o(str, false, (CoreApi.O0000Oo) new CoreApi.O0000Oo() {
                    /* class com.xiaomi.smarthome.frame.plugin.PluginApi.AnonymousClass2 */

                    public void onStart(String str) {
                        SendMessageCallback sendMessageCallback = sendMessageCallback3;
                        if (sendMessageCallback != null) {
                            sendMessageCallback.onInstallStart(str3);
                        }
                    }

                    public void onSuccess(String str) {
                        SendMessageCallback sendMessageCallback;
                        SendMessageCallback sendMessageCallback2 = sendMessageCallback3;
                        if (sendMessageCallback2 != null) {
                            sendMessageCallback2.onInstallSuccess(str3);
                        }
                        if (sendMessageHandle3.isCanceled() && (sendMessageCallback = sendMessageCallback3) != null) {
                            sendMessageCallback.onSendCancel();
                        }
                    }

                    public void onFailure(PluginError pluginError) {
                        SendMessageCallback sendMessageCallback = sendMessageCallback3;
                        if (sendMessageCallback != null) {
                            sendMessageCallback.onInstallFailure(pluginError);
                            sendMessageCallback3.onSendFailure(new fso(pluginError.f6718O000000o, pluginError.O000000o(context3)));
                        }
                        LogType logType = LogType.PLUGIN;
                        gsy.O00000o0(logType, "click_device_list", str3 + " sendMessage-installPlugin-onFailure error:" + pluginError);
                    }

                    public void onCancel() {
                        SendMessageCallback sendMessageCallback = sendMessageCallback3;
                        if (sendMessageCallback != null) {
                            sendMessageCallback.onInstallFailure(new PluginError(-6, " canceled"));
                            sendMessageCallback3.onSendFailure(new fso(-1, context3.getString(R.string.sh_common_cancel)));
                        }
                        LogType logType = LogType.PLUGIN;
                        gsy.O00000o0(logType, "click_device_list", str3 + " sendMessage-installPlugin-onCancel");
                    }
                });
            } else if (O0000OoO != null || O0000Oo == null) {
                if (O0000OoO.O00000Oo() != O0000Oo.O00000Oo()) {
                    if (sendMessageCallback != null) {
                        sendMessageCallback.onInstallBefore(str);
                    }
                    final SendMessageCallback sendMessageCallback4 = sendMessageCallback;
                    final String str4 = str;
                    final SendMessageHandle sendMessageHandle4 = sendMessageHandle;
                    final Context context4 = context;
                    CoreApi.O000000o().O000000o(str, true, (CoreApi.O0000Oo) new CoreApi.O0000Oo() {
                        /* class com.xiaomi.smarthome.frame.plugin.PluginApi.AnonymousClass3 */

                        public void onStart(String str) {
                            SendMessageCallback sendMessageCallback = sendMessageCallback4;
                            if (sendMessageCallback != null) {
                                sendMessageCallback.onInstallStart(str4);
                            }
                        }

                        public void onSuccess(String str) {
                            SendMessageCallback sendMessageCallback;
                            SendMessageCallback sendMessageCallback2 = sendMessageCallback4;
                            if (sendMessageCallback2 != null) {
                                sendMessageCallback2.onInstallSuccess(str4);
                            }
                            if (sendMessageHandle4.isCanceled() && (sendMessageCallback = sendMessageCallback4) != null) {
                                sendMessageCallback.onSendCancel();
                            }
                        }

                        public void onFailure(PluginError pluginError) {
                            SendMessageCallback sendMessageCallback = sendMessageCallback4;
                            if (sendMessageCallback != null) {
                                sendMessageCallback.onInstallFailure(pluginError);
                                sendMessageCallback4.onSendFailure(new fso(pluginError.f6718O000000o, pluginError.O000000o(context4)));
                            }
                            gsy.O00000o0(LogType.PLUGIN, "click_device_list", "sendMessage-installPluginNew-onFailure error:".concat(String.valueOf(pluginError)));
                        }

                        public void onCancel() {
                            SendMessageCallback sendMessageCallback = sendMessageCallback4;
                            if (sendMessageCallback != null) {
                                sendMessageCallback.onInstallFailure(new PluginError(-6, "canceled"));
                                sendMessageCallback4.onSendFailure(new fso(-1, context4.getString(R.string.sh_common_cancel)));
                            }
                            gsy.O00000o0(LogType.PLUGIN, "click_device_list", "sendMessage-installPluginNew-onCancel");
                        }
                    });
                } else if (sendMessageCallback != null) {
                    sendMessageCallback.onInstallSuccess(str);
                }
            } else if (sendMessageCallback != null) {
                sendMessageCallback.onInstallSuccess(str);
            }
            return sendMessageHandle;
        }
    }

    public SendMessageHandle sendMessage(Context context, String str, int i, Intent intent, DeviceStat deviceStat, RunningProcess runningProcess, boolean z, SendMessageCallback sendMessageCallback) {
        SendMessageHandle sendMessageHandle = new SendMessageHandle();
        sendMessage(context, str, i, intent, deviceStat, runningProcess, z, sendMessageCallback, sendMessageHandle);
        return sendMessageHandle;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
     arg types: [java.lang.String, int, com.xiaomi.smarthome.frame.plugin.PluginApi$4]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
     arg types: [java.lang.String, int, com.xiaomi.smarthome.frame.plugin.PluginApi$5]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
     arg types: [java.lang.String, int, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
     arg types: [java.lang.String, int, com.xiaomi.smarthome.frame.plugin.PluginApi$6]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01f9  */
    public SendMessageHandle sendMessage(Context context, String str, int i, Intent intent, DeviceStat deviceStat, RunningProcess runningProcess, boolean z, SendMessageCallback sendMessageCallback, SendMessageHandle sendMessageHandle) {
        CoreApi.O0000OOo o0000OOo;
        CoreApi.O0000OOo o0000OOo2;
        Context context2 = context;
        String str2 = str;
        SendMessageCallback sendMessageCallback2 = sendMessageCallback;
        gsy.O000000o(4, "Device_Renderer", "1 - " + System.currentTimeMillis());
        final Intent intent2 = intent == null ? new Intent() : intent;
        if (context2 == null) {
            if (sendMessageCallback2 != null) {
                sendMessageCallback2.onSendFailure(new fso(-1, CommonApplication.getAppContext().getString(R.string.code_env_error)));
            }
            gsy.O00000Oo(LogType.PLUGIN, "click_device_list", str2 + " sendMessage 1");
            return new SendMessageHandle();
        } else if (CoreApi.O000000o().O0000Oo0(str2)) {
            if (sendMessageCallback2 != null) {
                sendMessageCallback2.onSendFailure(new fso(-1, context2.getString(R.string.installerror_forceupdate)));
            }
            gsy.O00000Oo(LogType.PLUGIN, "click_device_list", str2 + " sendMessage 3");
            return new SendMessageHandle();
        } else {
            final PluginPackageInfo O0000OoO = CoreApi.O000000o().O0000OoO(str2);
            PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str2);
            Context applicationContext = context.getApplicationContext();
            if (!(O0000OoO == null && O0000Oo == null)) {
                PluginPackageInfo pluginPackageInfo = O0000Oo != null ? O0000Oo : O0000OoO;
                if (pluginPackageInfo.O0000o0O()) {
                    if (fcx.f16092O000000o.O000000o(i, str2)) {
                        fcx.f16092O000000o.O000000o(str2, pluginPackageInfo, "click");
                    }
                    intent2.putExtra("open_plugin_click_start_time", System.currentTimeMillis());
                    if (O0000OoO != null && O0000Oo == null) {
                        gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage, plugin not downloaded and not installed...".concat(String.valueOf(str)));
                        final SendMessageCallback sendMessageCallback3 = sendMessageCallback;
                        final Intent intent3 = intent2;
                        final Context context3 = context;
                        final DeviceStat deviceStat2 = deviceStat;
                        final String str3 = str;
                        final Context context4 = applicationContext;
                        final SendMessageHandle sendMessageHandle2 = sendMessageHandle;
                        final int i2 = i;
                        final RunningProcess runningProcess2 = runningProcess;
                        final boolean z2 = z;
                        CoreApi.O000000o().O000000o(str2, true, (CoreApi.O0000OOo) new CoreApi.O0000OOo() {
                            /* class com.xiaomi.smarthome.frame.plugin.PluginApi.AnonymousClass4 */
                            public BroadcastReceiver mCancelReceiver;
                            public boolean rnPlugin = false;
                            long startTime = 0;

                            public void onStart(String str, PluginDownloadTask pluginDownloadTask) {
                                SendMessageCallback sendMessageCallback = sendMessageCallback3;
                                if (sendMessageCallback != null) {
                                    sendMessageCallback.onDownloadStart(str, pluginDownloadTask);
                                }
                                this.startTime = System.currentTimeMillis();
                            }

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
                             arg types: [java.lang.String, int]
                             candidates:
                              ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
                              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
                            public void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
                                if ("rn".equals(pluginDownloadTask.O0000O0o)) {
                                    this.rnPlugin = true;
                                    intent3.putExtra("type_loading_sendmessage", 1);
                                    intent3.putExtra("isOpenLoadingRNActivity", true);
                                    Intent intent = new Intent(context3, fcx.f16092O000000o.O00000o0());
                                    intent.addFlags(268435456);
                                    intent.putExtra("extra_devicestat", deviceStat2);
                                    intent.putExtra("extra_downloadtask", pluginDownloadTask);
                                    exz exz = exz.f15941O000000o;
                                    exz.O000000o(intent, str3);
                                    intent.putExtra("activity_start_from", 1003);
                                    context3.startActivity(intent);
                                    this.mCancelReceiver = new BroadcastReceiver() {
                                        /* class com.xiaomi.smarthome.frame.plugin.PluginApi.AnonymousClass4.AnonymousClass1 */

                                        public void onReceive(Context context, Intent intent) {
                                            context4.unregisterReceiver(this);
                                            AnonymousClass4 r2 = AnonymousClass4.this;
                                            r2.mCancelReceiver = null;
                                            if (deviceStat2 != null && deviceStat2.equals(intent.getParcelableExtra("extra_devicestat"))) {
                                                sendMessageHandle2.cancel();
                                            }
                                        }
                                    };
                                    context4.registerReceiver(this.mCancelReceiver, new IntentFilter("action_loading_finish"));
                                    SendMessageCallback sendMessageCallback = sendMessageCallback3;
                                    if (sendMessageCallback != null) {
                                        sendMessageCallback.onDownloadSuccess(str);
                                        sendMessageCallback3.onInstallSuccess(str);
                                        sendMessageCallback3.onSendSuccess(new Bundle());
                                    }
                                    if (fcx.f16092O000000o.O000000o(i2, str3)) {
                                        PluginPackageInfo pluginPackageInfo = new PluginPackageInfo();
                                        pluginPackageInfo.O00000Oo(pluginDownloadTask.O00000o);
                                        pluginPackageInfo.O000000o(pluginDownloadTask.O00000oO);
                                        fcx.f16092O000000o.O000000o(str3, pluginPackageInfo, "click");
                                    }
                                } else {
                                    this.rnPlugin = false;
                                    SendMessageCallback sendMessageCallback2 = sendMessageCallback3;
                                    if (sendMessageCallback2 != null) {
                                        sendMessageCallback2.onDownInfoSuccess(str, pluginDownloadTask);
                                    }
                                }
                                LogType logType = LogType.PLUGIN;
                                gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "sendMessage-downloadPlugin-onDownInfoSuccess:" + str3);
                            }

                            public void onProgress(String str, float f) {
                                if (this.rnPlugin) {
                                    PluginApi.this.sendDownloadPluginProgressToLoadingActivity(context3, deviceStat2, f);
                                }
                                SendMessageCallback sendMessageCallback = sendMessageCallback3;
                                if (sendMessageCallback != null && !this.rnPlugin) {
                                    sendMessageCallback.onDownloadProgress(str, f);
                                }
                            }

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
                             arg types: [java.lang.String, int, com.xiaomi.smarthome.frame.plugin.PluginApi$4$2]
                             candidates:
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void */
                            public void onSuccess(String str) {
                                SendMessageCallback sendMessageCallback = sendMessageCallback3;
                                if (sendMessageCallback != null && !this.rnPlugin) {
                                    sendMessageCallback.onDownloadSuccess(str);
                                }
                                if (this.startTime > 0) {
                                    hxi.O0000Oo.O000000o(System.currentTimeMillis() - this.startTime, str);
                                }
                                SendMessageCallback sendMessageCallback2 = sendMessageCallback3;
                                if (sendMessageCallback2 != null && !this.rnPlugin) {
                                    sendMessageCallback2.onInstallBefore(str);
                                }
                                LogType logType = LogType.PLUGIN;
                                gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "sendMessage-downloadPlugin-onDownInfoSuccess-onSuccess-will installPlugin:" + str3);
                                CoreApi.O000000o().O000000o(str, false, (CoreApi.O0000Oo) new CoreApi.O0000Oo() {
                                    /* class com.xiaomi.smarthome.frame.plugin.PluginApi.AnonymousClass4.AnonymousClass2 */

                                    public void onStart(String str) {
                                        if (sendMessageCallback3 != null && !AnonymousClass4.this.rnPlugin) {
                                            sendMessageCallback3.onInstallStart(str3);
                                        }
                                    }

                                    public void onSuccess(String str) {
                                        if (sendMessageCallback3 != null && !AnonymousClass4.this.rnPlugin) {
                                            sendMessageCallback3.onInstallSuccess(str3);
                                        }
                                        if (!sendMessageHandle2.isCanceled()) {
                                            if (AnonymousClass4.this.rnPlugin && AnonymousClass4.this.mCancelReceiver != null) {
                                                context4.unregisterReceiver(AnonymousClass4.this.mCancelReceiver);
                                                AnonymousClass4.this.mCancelReceiver = null;
                                            }
                                            PluginApi.this.checkRnSdkAndSendMessageToOpenRnPlugin(context3, str, i2, intent3, deviceStat2, runningProcess2, false, z2, sendMessageCallback3);
                                        } else if (sendMessageCallback3 != null && !AnonymousClass4.this.rnPlugin) {
                                            sendMessageCallback3.onSendCancel();
                                        }
                                    }

                                    public void onFailure(PluginError pluginError) {
                                        if (CoreApi.O000000o().O0000Oo(str3) == null) {
                                            if (AnonymousClass4.this.rnPlugin) {
                                                if (AnonymousClass4.this.mCancelReceiver != null) {
                                                    context4.unregisterReceiver(AnonymousClass4.this.mCancelReceiver);
                                                    AnonymousClass4.this.mCancelReceiver = null;
                                                }
                                            } else if (sendMessageCallback3 != null) {
                                                sendMessageCallback3.onInstallFailure(pluginError);
                                                sendMessageCallback3.onSendFailure(new fso(pluginError.f6718O000000o, pluginError.O000000o(context3)));
                                            }
                                            LogType logType = LogType.PLUGIN;
                                            gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "sendMessage-downloadPlugin-installPlugin-onFailure error:" + pluginError + "model:" + str3);
                                            return;
                                        }
                                        onSuccess(str3);
                                        LogType logType2 = LogType.PLUGIN;
                                        gsy.O00000o0(logType2, "rn-plugin-framework", "miot-rn-plugin", "sendMessage-downloadPlugin-installPlugin-onFailure-getInstalledPackageInfo error:" + pluginError + "model:" + str3);
                                    }

                                    public void onCancel() {
                                        if (AnonymousClass4.this.rnPlugin) {
                                            if (AnonymousClass4.this.mCancelReceiver != null) {
                                                context4.unregisterReceiver(AnonymousClass4.this.mCancelReceiver);
                                                AnonymousClass4.this.mCancelReceiver = null;
                                            }
                                        } else if (sendMessageCallback3 != null) {
                                            sendMessageCallback3.onInstallFailure(new PluginError(-6, ""));
                                            sendMessageCallback3.onSendFailure(new fso(-1, context3.getString(R.string.sh_common_cancel)));
                                        }
                                        LogType logType = LogType.PLUGIN;
                                        gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "sendMessage-downloadPlugin-installPlugin-onCancel:" + str3);
                                    }
                                });
                            }

                            public void onFailure(PluginError pluginError) {
                                if (CoreApi.O000000o().O0000OoO(str3) == null) {
                                    if (this.rnPlugin) {
                                        BroadcastReceiver broadcastReceiver = this.mCancelReceiver;
                                        if (broadcastReceiver != null) {
                                            context4.unregisterReceiver(broadcastReceiver);
                                            this.mCancelReceiver = null;
                                        }
                                        PluginApi.this.sendFinishLoadingActivityForDownloadError(context3);
                                    }
                                    SendMessageCallback sendMessageCallback = sendMessageCallback3;
                                    if (sendMessageCallback != null) {
                                        sendMessageCallback.onDownloadFailure(pluginError);
                                        sendMessageCallback3.onSendFailure(new fso(pluginError.f6718O000000o, pluginError.O000000o(context3)));
                                    }
                                    fcx.f16092O000000o.O000000o(str3, pluginError.f6718O000000o);
                                    LogType logType = LogType.PLUGIN;
                                    gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "sendMessage-downloadPlugin-onFailure error:" + pluginError + " model:" + str3);
                                    return;
                                }
                                onSuccess(str3);
                                LogType logType2 = LogType.PLUGIN;
                                gsy.O00000o0(logType2, "rn-plugin-framework", "miot-rn-plugin", "sendMessage-downloadPlugin-onFailure-getDownloadedPackageInfo error:" + pluginError + " model:" + str3);
                            }

                            public void onCancel() {
                                if (this.rnPlugin) {
                                    BroadcastReceiver broadcastReceiver = this.mCancelReceiver;
                                    if (broadcastReceiver != null) {
                                        context4.unregisterReceiver(broadcastReceiver);
                                        this.mCancelReceiver = null;
                                    }
                                } else {
                                    SendMessageCallback sendMessageCallback = sendMessageCallback3;
                                    if (sendMessageCallback != null) {
                                        sendMessageCallback.onDownloadCancel();
                                        sendMessageCallback3.onSendFailure(new fso(-1, context3.getString(R.string.sh_common_cancel)));
                                    }
                                }
                                LogType logType = LogType.PLUGIN;
                                gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "sendMessage-downloadPlugin-onCancel:" + str3);
                            }
                        });
                    } else if (O0000OoO == null && O0000Oo == null) {
                        gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "mIot-rn-plugin-framework --> sendMessage, plugin is downloaded and not installed...".concat(String.valueOf(str)));
                        if (sendMessageCallback2 != null) {
                            sendMessageCallback2.onInstallBefore(str2);
                        }
                        final SendMessageCallback sendMessageCallback4 = sendMessageCallback;
                        final String str4 = str;
                        final SendMessageHandle sendMessageHandle3 = sendMessageHandle;
                        final Context context5 = context;
                        final int i3 = i;
                        final DeviceStat deviceStat3 = deviceStat;
                        final RunningProcess runningProcess3 = runningProcess;
                        final boolean z3 = z;
                        CoreApi.O000000o().O000000o(str2, false, (CoreApi.O0000Oo) new CoreApi.O0000Oo() {
                            /* class com.xiaomi.smarthome.frame.plugin.PluginApi.AnonymousClass5 */

                            public void onStart(String str) {
                                SendMessageCallback sendMessageCallback = sendMessageCallback4;
                                if (sendMessageCallback != null) {
                                    sendMessageCallback.onInstallStart(str4);
                                }
                            }

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
                             arg types: [java.lang.String, int, ?[OBJECT, ARRAY]]
                             candidates:
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
                              com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void */
                            public void onSuccess(String str) {
                                SendMessageCallback sendMessageCallback = sendMessageCallback4;
                                if (sendMessageCallback != null) {
                                    sendMessageCallback.onInstallSuccess(str4);
                                }
                                if (sendMessageHandle3.isCanceled()) {
                                    SendMessageCallback sendMessageCallback2 = sendMessageCallback4;
                                    if (sendMessageCallback2 != null) {
                                        sendMessageCallback2.onSendCancel();
                                    }
                                } else {
                                    PluginApi.this.checkRnSdkAndSendMessageToOpenRnPlugin(context5, str4, i3, intent2, deviceStat3, runningProcess3, true, z3, sendMessageCallback4);
                                }
                                if (PluginApi.checkPluginUpdateMessageType(i3)) {
                                    CoreApi.O000000o().O000000o(str, false, (CoreApi.O0000OOo) null);
                                }
                            }

                            public void onFailure(PluginError pluginError) {
                                SendMessageCallback sendMessageCallback = sendMessageCallback4;
                                if (sendMessageCallback != null) {
                                    sendMessageCallback.onInstallFailure(pluginError);
                                    sendMessageCallback4.onSendFailure(new fso(pluginError.f6718O000000o, pluginError.O000000o(context5)));
                                }
                                PluginPackageInfo pluginPackageInfo = O0000OoO;
                                if (pluginPackageInfo != null && pluginPackageInfo.O0000o0O()) {
                                    fcx.f16092O000000o.O000000o(str4, pluginError.f6718O000000o);
                                }
                                LogType logType = LogType.PLUGIN;
                                gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "sendMessage-installPlugin-onFailure error:" + pluginError + ",model:" + str4);
                            }

                            public void onCancel() {
                                SendMessageCallback sendMessageCallback = sendMessageCallback4;
                                if (sendMessageCallback != null) {
                                    sendMessageCallback.onInstallFailure(new PluginError(-6, " canceled"));
                                    sendMessageCallback4.onSendFailure(new fso(-1, context5.getString(R.string.sh_common_cancel)));
                                }
                                LogType logType = LogType.PLUGIN;
                                gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "sendMessage-installPlugin-onCancel:" + str4);
                            }
                        });
                    } else if (O0000OoO == null || O0000Oo == null) {
                        intent2.putExtra("open_plugin_cached", true);
                        gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage, plugin is downloaded and is installed... down:" + O0000OoO.O00000Oo() + " install:" + O0000Oo.O00000Oo() + ",model:" + str2);
                        if (O0000OoO.O00000Oo() == O0000Oo.O00000Oo()) {
                            if (sendMessageCallback2 != null) {
                                sendMessageCallback2.onInstallBefore(str2);
                            }
                            final SendMessageCallback sendMessageCallback5 = sendMessageCallback;
                            final String str5 = str;
                            final SendMessageHandle sendMessageHandle4 = sendMessageHandle;
                            final Context context6 = context;
                            final int i4 = i;
                            final DeviceStat deviceStat4 = deviceStat;
                            final RunningProcess runningProcess4 = runningProcess;
                            final boolean z4 = z;
                            final PluginPackageInfo pluginPackageInfo2 = O0000Oo;
                            CoreApi.O000000o().O000000o(str2, true, (CoreApi.O0000Oo) new CoreApi.O0000Oo() {
                                /* class com.xiaomi.smarthome.frame.plugin.PluginApi.AnonymousClass6 */

                                public void onStart(String str) {
                                    SendMessageCallback sendMessageCallback = sendMessageCallback5;
                                    if (sendMessageCallback != null) {
                                        sendMessageCallback.onInstallStart(str5);
                                    }
                                }

                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                 method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
                                 arg types: [java.lang.String, int, ?[OBJECT, ARRAY]]
                                 candidates:
                                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, boolean, java.lang.String):void
                                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, _m_j.fsm):_m_j.fsn
                                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
                                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, android.os.Bundle):void
                                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, int):void
                                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000Oo):void
                                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<java.lang.String>, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000O0o):void
                                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, int, boolean):boolean
                                  com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void */
                                public void onSuccess(String str) {
                                    SendMessageCallback sendMessageCallback = sendMessageCallback5;
                                    if (sendMessageCallback != null) {
                                        sendMessageCallback.onInstallSuccess(str5);
                                    }
                                    if (sendMessageHandle4.isCanceled()) {
                                        SendMessageCallback sendMessageCallback2 = sendMessageCallback5;
                                        if (sendMessageCallback2 != null) {
                                            sendMessageCallback2.onSendCancel();
                                        }
                                    } else {
                                        PluginApi.this.checkRnSdkAndSendMessageToOpenRnPlugin(context6, str5, i4, intent2, deviceStat4, runningProcess4, true, z4, sendMessageCallback5);
                                    }
                                    if (PluginApi.checkPluginUpdateMessageType(i4)) {
                                        CoreApi.O000000o().O000000o(str, false, (CoreApi.O0000OOo) null);
                                    }
                                }

                                public void onFailure(PluginError pluginError) {
                                    SendMessageCallback sendMessageCallback = sendMessageCallback5;
                                    if (sendMessageCallback != null) {
                                        sendMessageCallback.onInstallFailure(pluginError);
                                        sendMessageCallback5.onSendFailure(new fso(pluginError.f6718O000000o, pluginError.O000000o(context6)));
                                    }
                                    PluginPackageInfo pluginPackageInfo = pluginPackageInfo2;
                                    if (pluginPackageInfo != null && pluginPackageInfo.O0000o0O()) {
                                        fcx.f16092O000000o.O000000o(str5, pluginError.f6718O000000o);
                                    }
                                    LogType logType = LogType.PLUGIN;
                                    gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "sendMessage-installPluginNew-onFailure error:" + pluginError + ",model:" + str5);
                                }

                                public void onCancel() {
                                    SendMessageCallback sendMessageCallback = sendMessageCallback5;
                                    if (sendMessageCallback != null) {
                                        sendMessageCallback.onInstallFailure(new PluginError(-6, "canceled"));
                                        sendMessageCallback5.onSendFailure(new fso(-6, context6.getString(R.string.sh_common_cancel)));
                                    }
                                    LogType logType = LogType.PLUGIN;
                                    gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "sendMessage-installPluginNew-onCancel,model:" + str5);
                                }
                            });
                        } else {
                            if (sendMessageHandle.isCanceled()) {
                                gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage, cancel open plugin...".concat(String.valueOf(str)));
                                if (sendMessageCallback2 != null) {
                                    sendMessageCallback.onSendCancel();
                                }
                                o0000OOo = null;
                            } else {
                                o0000OOo = null;
                                checkRnSdkAndSendMessageToOpenRnPlugin(context, str, i, intent2, deviceStat, runningProcess, true, z, sendMessageCallback);
                            }
                            if (!MockRnDevicePluginManager.getInstance().modelIsMockModel(str2) && checkPluginUpdateMessageType(i)) {
                                CoreApi.O000000o().O000000o(str2, false, o0000OOo);
                            }
                        }
                    } else {
                        gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage, plugin not downloaded and is installed...".concat(String.valueOf(str)));
                        if (sendMessageHandle.isCanceled()) {
                            if (sendMessageCallback2 != null) {
                                sendMessageCallback.onSendCancel();
                            }
                            o0000OOo2 = null;
                        } else {
                            intent2.putExtra("open_plugin_cached", true);
                            o0000OOo2 = null;
                            checkRnSdkAndSendMessageToOpenRnPlugin(context, str, i, intent2, deviceStat, runningProcess, true, z, sendMessageCallback);
                        }
                        if (checkPluginUpdateMessageType(i)) {
                            CoreApi.O000000o().O000000o(str2, false, o0000OOo2);
                        }
                    }
                    return sendMessageHandle;
                }
            }
            intent2.putExtra("open_plugin_click_start_time", System.currentTimeMillis());
            if (O0000OoO != null) {
            }
            if (O0000OoO == null) {
            }
            if (O0000OoO == null) {
            }
            intent2.putExtra("open_plugin_cached", true);
            gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> sendMessage, plugin is downloaded and is installed... down:" + O0000OoO.O00000Oo() + " install:" + O0000Oo.O00000Oo() + ",model:" + str2);
            if (O0000OoO.O00000Oo() == O0000Oo.O00000Oo()) {
            }
            return sendMessageHandle;
        }
    }

    public void startLoadingRnActivity(Context context) {
        Intent intent = new Intent(context, fcx.f16092O000000o.O00000o0());
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private Executor getTaskExecutor() {
        if (this.mExecutor == null) {
            this.mExecutor = new SerialExecutor();
        }
        return this.mExecutor;
    }

    public void checkRnSdkAndSendMessageToOpenRnPlugin(Context context, String str, int i, Intent intent, DeviceStat deviceStat, RunningProcess runningProcess, boolean z, boolean z2, SendMessageCallback sendMessageCallback) {
        int i2 = i;
        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str);
        if (O0000Oo == null) {
            LogType logType = LogType.PLUGIN;
            gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "error installInfo is null model:" + str + " stack:" + Log.getStackTraceString(new Exception()));
            sendPluginBundleNotExitsCrash(context, deviceStat);
        } else if (!O0000Oo.O0000o0O()) {
            PluginRuntimeManager.getInstance().sendMessage(context, str, i, intent, deviceStat, runningProcess, z2, sendMessageCallback);
        } else if (i2 == 1 || i2 == 1) {
            gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> will check rn sdk update...");
            final Context context2 = context;
            final boolean z3 = z;
            final Intent intent2 = intent;
            final String str2 = str;
            final int i3 = i;
            final DeviceStat deviceStat2 = deviceStat;
            final RunningProcess runningProcess2 = runningProcess;
            final boolean z4 = z2;
            final SendMessageCallback sendMessageCallback2 = sendMessageCallback;
            new AsyncTask<Object, Integer, hsi.O000000o>() {
                /* class com.xiaomi.smarthome.frame.plugin.PluginApi.AnonymousClass7 */

                /* access modifiers changed from: protected */
                public hsi.O000000o doInBackground(Object... objArr) {
                    fkl.O000000o();
                    return fkl.O000000o(context2);
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(hsi.O000000o o000000o) {
                    if (o000000o == null || o000000o.f598O000000o < 10058) {
                        gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> will update rn sdk...");
                        if (z3) {
                            intent2.putExtra("type_loading_sendmessage", 1);
                            PluginApi.this.startLoadingRnActivity(context2);
                        }
                        CoreApi.O000000o().O000000o(new CoreApi.O0000Oo0() {
                            /* class com.xiaomi.smarthome.frame.plugin.PluginApi.AnonymousClass7.AnonymousClass1 */

                            public void onSuccess(DownloadRnSdkResult downloadRnSdkResult) {
                                LogType logType = LogType.PLUGIN;
                                gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> update rn sdk  flag: " + downloadRnSdkResult.f6734O000000o + "  msg=" + downloadRnSdkResult.O00000Oo);
                                intent2.putExtra("open_plugin_download_plugin_finish_time", System.currentTimeMillis());
                                if (downloadRnSdkResult.f6734O000000o == 4) {
                                    PluginRuntimeManager.getInstance().sendMessage(context2, str2, i3, intent2, deviceStat2, runningProcess2, z4, sendMessageCallback2);
                                }
                            }

                            public void onFailure(DownloadRnSdkResult downloadRnSdkResult) {
                                fso fso;
                                if (downloadRnSdkResult != null) {
                                    LogType logType = LogType.PLUGIN;
                                    gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> update rn sdk flag: " + downloadRnSdkResult.f6734O000000o + "  msg=" + downloadRnSdkResult.O00000Oo);
                                    if (sendMessageCallback2 != null) {
                                        if (downloadRnSdkResult.f6734O000000o == 5) {
                                            fso = new fso(downloadRnSdkResult.f6734O000000o, context2.getString(R.string.downerror_infoerror));
                                        } else if (downloadRnSdkResult.f6734O000000o == 6) {
                                            fso = new fso(downloadRnSdkResult.f6734O000000o, context2.getString(R.string.downerror_downerror));
                                        } else if (downloadRnSdkResult.f6734O000000o == 7) {
                                            fso = new fso(downloadRnSdkResult.f6734O000000o, context2.getString(R.string.installerror_install));
                                        } else {
                                            fso = new fso(downloadRnSdkResult.f6734O000000o, context2.getString(R.string.installerror_typeinvaild));
                                        }
                                        sendMessageCallback2.onSendFailure(fso);
                                    }
                                    PluginApi.this.finishRnLoadingActivity(context2);
                                    fcx.f16092O000000o.O000000o(str2, downloadRnSdkResult.f6734O000000o * -1000);
                                }
                            }
                        });
                        return;
                    }
                    intent2.putExtra("open_plugin_download_plugin_finish_time", System.currentTimeMillis());
                    LogType logType = LogType.PLUGIN;
                    gsy.O00000o0(logType, "rn-plugin-framework", "miot-rn-plugin", "mIot-rn-plugin-framework --> update rn sdk is newest, will open plugin..." + i3);
                    PluginRuntimeManager.getInstance().sendMessage(context2, str2, i3, intent2, deviceStat2, runningProcess2, z4, sendMessageCallback2);
                }
            }.executeOnExecutor(getTaskExecutor(), new Object[0]);
        } else {
            PluginRuntimeManager.getInstance().sendMessage(context, str, i, intent, deviceStat, runningProcess, z2, sendMessageCallback);
        }
    }

    private void sendPluginBundleNotExitsCrash(Context context, DeviceStat deviceStat) {
        String str;
        String str2;
        DeviceStat deviceStat2 = deviceStat;
        if (deviceStat2 != null) {
            String str3 = deviceStat2.model;
            str2 = deviceStat2.did;
            str = str3;
        } else {
            str2 = "";
            str = str2;
        }
        ftc.O000000o().O000000o(context, "@ExceptionFromReactNative", "@ExceptionFromReactNative", "安装成功了，却又没有获取到安装包信息...", "plugin_crash", fsr.O0000Oo, str2, 104, 0, str, "xxx.xxx.xxx", "10058");
    }

    public void finishRnLoadingActivity(Context context) {
        if (context != null) {
            context.sendBroadcast(new Intent("action_launch_plugin_finish"));
        }
    }

    public void sendDownloadPluginProgressToLoadingActivity(Context context, DeviceStat deviceStat, float f) {
        if (context != null && deviceStat != null) {
            Intent intent = new Intent("action_download_plugin_progress");
            intent.putExtra("deviceId", deviceStat.did);
            intent.putExtra("progress", f);
            context.sendBroadcast(intent);
        }
    }

    public void sendFinishLoadingActivityForDownloadError(Context context) {
        if (context != null) {
            context.sendBroadcast(new Intent("action_download_plugin_error"));
        }
    }

    public void startService(RunningProcess runningProcess, String str, long j, long j2, Intent intent, String str2, StartServiceCallback startServiceCallback) {
        PluginRuntimeManager.getInstance().startService(runningProcess, str, j, j2, intent, str2, startServiceCallback);
    }

    public void exitProcess(RunningProcess runningProcess) {
        PluginRuntimeManager.getInstance().exitProcess(runningProcess);
    }

    public void bindService(RunningProcess runningProcess, String str, long j, long j2, String str2, ServiceConnection serviceConnection, int i, BindServiceCallback bindServiceCallback) {
        PluginRuntimeManager.getInstance().bindService(runningProcess, str, j, j2, str2, serviceConnection, i, bindServiceCallback);
    }

    public void unbindService(RunningProcess runningProcess, String str, long j, long j2, String str2, ServiceConnection serviceConnection, UnBindServiceCallback unBindServiceCallback) {
        PluginRuntimeManager.getInstance().unbindService(runningProcess, str, j, j2, str2, serviceConnection, unBindServiceCallback);
    }

    public boolean getSupportRN(String str) {
        return CommonApplication.getAppContext().getSharedPreferences(String.valueOf(str), 0).getBoolean("is_support_rn", false);
    }
}
