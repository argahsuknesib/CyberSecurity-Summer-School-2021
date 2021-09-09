package _m_j;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.frame.plugin.SendMessageHandle;

public final class fbn {

    public interface O000000o {
        void O000000o(boolean z);
    }

    public static boolean O000000o(String str) {
        return CoreApi.O000000o().O0000OoO(str) != null;
    }

    public static boolean O00000Oo(String str) {
        return CoreApi.O000000o().O0000Oo(str) != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void
     arg types: [int, _m_j.fbn$1]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.account.OAuthAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.frame.server_compact.ServerBean, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.LoginMiAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.Locale, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader):com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(long, long):java.lang.String
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o00):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o0):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O00oOooO):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest, com.xiaomi.smarthome.core.server.bluetooth.SearchResponse):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, byte[]):byte[]
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void */
    public static void O000000o(final O000000o o000000o) {
        CoreApi.O000000o().O000000o(true, (CoreApi.O000O0o0) new CoreApi.O000O0o0() {
            /* class _m_j.fbn.AnonymousClass1 */

            public final void O000000o(boolean z) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O000000o(z);
                }
            }
        });
    }

    public static SendMessageHandle O000000o(Context context, String str, final fbp fbp) {
        return PluginApi.getInstance().installPlugin(context, str, new SendMessageCallback() {
            /* class _m_j.fbn.AnonymousClass2 */

            public final void onInstallBefore(String str) {
            }

            public final void onLoadFailure(String str) {
            }

            public final void onLoadSuccess(String str) {
            }

            public final void onMessageFailure(int i, String str) {
            }

            public final void onMessageHandle(boolean z) {
            }

            public final void onMessageSuccess(Intent intent) {
            }

            public final void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
                if (fbp != null) {
                    fbn.O000000o(pluginDownloadTask);
                }
            }

            public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o(str, fbn.O000000o(pluginDownloadTask));
                }
            }

            public final void onDownloadProgress(String str, float f) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o(str, f);
                }
            }

            public final void onDownloadSuccess(String str) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o(str);
                }
            }

            public final void onDownloadFailure(PluginError pluginError) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o(pluginError);
                }
            }

            public final void onDownloadCancel() {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o();
                }
            }

            public final void onInstallStart(String str) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O00000Oo(str);
                }
            }

            public final void onInstallSuccess(String str) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O00000o0(str);
                }
            }

            public final void onInstallFailure(PluginError pluginError) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O00000Oo(pluginError);
                }
            }

            public final void onSendSuccess(Bundle bundle) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o(bundle);
                }
            }

            public final void onSendCancel() {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O00000Oo();
                }
            }

            public final void onSendFailure(fso fso) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o(fso);
                }
            }
        });
    }

    public static SendMessageHandle O000000o(Context context, String str, Intent intent, DeviceStat deviceStat, final fbp fbp) {
        return PluginApi.getInstance().sendMessage(context, str, 1, intent, deviceStat, null, false, new SendMessageCallback() {
            /* class _m_j.fbn.AnonymousClass3 */

            public final void onInstallBefore(String str) {
            }

            public final void onLoadFailure(String str) {
            }

            public final void onLoadSuccess(String str) {
            }

            public final void onMessageFailure(int i, String str) {
            }

            public final void onMessageHandle(boolean z) {
            }

            public final void onMessageSuccess(Intent intent) {
            }

            public final void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
                if (fbp != null) {
                    fbn.O000000o(pluginDownloadTask);
                }
            }

            public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o(str, fbn.O000000o(pluginDownloadTask));
                }
            }

            public final void onDownloadProgress(String str, float f) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o(str, f);
                }
            }

            public final void onDownloadSuccess(String str) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o(str);
                }
            }

            public final void onDownloadFailure(PluginError pluginError) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o(pluginError);
                }
            }

            public final void onDownloadCancel() {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o();
                }
            }

            public final void onInstallStart(String str) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O00000Oo(str);
                }
            }

            public final void onInstallSuccess(String str) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O00000o0(str);
                }
            }

            public final void onInstallFailure(PluginError pluginError) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O00000Oo(pluginError);
                }
            }

            public final void onSendSuccess(Bundle bundle) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o(bundle);
                }
            }

            public final void onSendCancel() {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O00000Oo();
                }
            }

            public final void onSendFailure(fso fso) {
                fbp fbp = fbp;
                if (fbp != null) {
                    fbp.O000000o(fso);
                }
            }
        });
    }

    public static fbo O000000o(PluginDownloadTask pluginDownloadTask) {
        if (pluginDownloadTask == null) {
            return null;
        }
        fbo fbo = new fbo();
        fbo.f16046O000000o = pluginDownloadTask.f6738O000000o;
        fbo.O00000Oo = pluginDownloadTask.O00000Oo;
        fbo.O00000o0 = pluginDownloadTask.O00000o0;
        fbo.O00000o = pluginDownloadTask.O00000o;
        fbo.O00000oO = pluginDownloadTask.O00000oO;
        fbo.O00000oo = pluginDownloadTask.O00000oo;
        fbo.O0000O0o = pluginDownloadTask.O0000O0o;
        return fbo;
    }
}
