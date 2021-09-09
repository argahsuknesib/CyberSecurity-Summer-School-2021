package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.Locale;

@RouterService
public class ghn implements huz {
    public void addSmartHomeStatRecord(StatType statType, String str, String str2, String str3, boolean z) {
        CoreApi.O000000o().O000000o(statType, str, str2, str3, z);
    }

    public boolean isInternationalServer() {
        return ftn.O00000Oo(CoreApi.O000000o().O0000ooO());
    }

    public void startScan(int i, huf huf) {
        CoreApi O000000o2 = CoreApi.O000000o();
        try {
            O000000o2.O00000Oo().startScanWithCallback(i, new IClientCallback.Stub(new CoreApi.O000O0o() {
                /* class _m_j.$$Lambda$ghn$42JFR29xU3ZvJkF3YX7qoSN98M */

                public final void onScanResult(String str) {
                    huf.this.accept(str);
                }
            }) {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass45 */
                final /* synthetic */ O000O0o val$scanCallback;

                public void onFailure(Bundle bundle) {
                }

                {
                    this.val$scanCallback = r2;
                }

                public void onSuccess(Bundle bundle) {
                    if (bundle != null && bundle.containsKey("result")) {
                        this.val$scanCallback.onScanResult(bundle.getString("result"));
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void startScanWithModel(String str, huf huf) {
        CoreApi O000000o2 = CoreApi.O000000o();
        try {
            O000000o2.O00000Oo().startScanWithModel(str, new IClientCallback.Stub(new CoreApi.O000O0o() {
                /* class _m_j.$$Lambda$ghn$H2IQQdGpqLeRyBNL9MT5_xAnBLI */

                public final void onScanResult(String str) {
                    huf.this.accept(str);
                }
            }) {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass46 */
                final /* synthetic */ O000O0o val$scanCallback;

                public void onFailure(Bundle bundle) {
                }

                {
                    this.val$scanCallback = r2;
                }

                public void onSuccess(Bundle bundle) {
                    if (bundle != null && bundle.containsKey("result")) {
                        this.val$scanCallback.onScanResult(bundle.getString("result"));
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void stopScan() {
        CoreApi.O000000o().O000O0OO();
    }

    public String getMiId() {
        return CoreApi.O000000o().O0000o0();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.frame.core.CoreApi$O0000OOo):void
     arg types: [java.lang.String, int, _m_j.ghn$1]
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
    public void downloadPlugin(String str, final huh huh) {
        CoreApi.O000000o().O000000o(str, true, (CoreApi.O0000OOo) new CoreApi.O0000OOo() {
            /* class _m_j.ghn.AnonymousClass1 */

            public final void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
            }

            public final void onStart(String str, PluginDownloadTask pluginDownloadTask) {
                huh.O000000o();
            }

            public final void onProgress(String str, float f) {
                huh.O000000o(f);
            }

            public final void onSuccess(String str) {
                if (str != null) {
                    huh.O000000o(str);
                }
            }

            public final void onFailure(PluginError pluginError) {
                huh.O00000Oo();
            }

            public final void onCancel() {
                huh.O00000o0();
            }
        });
    }

    public Locale getGlobalSettingLocale() {
        return CoreApi.O000000o().O00oOooo();
    }

    public PluginDeviceInfo getPluginInfo(String str) {
        return CoreApi.O000000o().O00000oO(str);
    }

    public PluginDeviceInfo getExtraPluginInfo(String str) {
        return CoreApi.O000000o().O00000oo(str);
    }

    public void setScanTimePeriod(int i) {
        CoreApi.O000000o().O000000o(i);
    }

    public huw getInstallInfo(String str) {
        long j;
        long j2;
        long j3;
        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str);
        PluginPackageInfo O0000OoO = CoreApi.O000000o().O0000OoO(str);
        long j4 = 0;
        if (O0000Oo == null) {
            j = 0;
        } else {
            j = O0000Oo.O000000o();
        }
        if (O0000Oo == null) {
            j2 = 0;
        } else {
            j2 = O0000Oo.O00000Oo();
        }
        if (O0000OoO == null) {
            j3 = 0;
        } else {
            j3 = O0000OoO.O00000Oo();
        }
        if (O0000OoO != null) {
            j4 = O0000OoO.O000000o();
        }
        return new huw(j, j2, j3, j4);
    }

    public void addStatRecord(StatType statType, String str, String str2, String str3, String str4, boolean z) {
        CoreApi.O000000o().O000000o(statType, str, str2, str3, str4, z);
    }

    public void stopSearchBluetoothDevice() {
        CoreApi.O000000o().O000O0o();
    }

    public String getGlobalSettingServerEnv() {
        return CoreApi.O000000o().O00oOooO();
    }

    public IBleChannelWriter registerSecureAuthChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException {
        return CoreApi.O000000o().O000000o(str, iBleChannelReader);
    }

    public void unRegisterSecureAuthChannelReader(String str, IBleChannelReader iBleChannelReader) throws RemoteException {
        try {
            CoreApi.O000000o().O00000Oo().unRegisterSecureAuthChannelReader(str, iBleChannelReader);
        } catch (Throwable th) {
            gnk.O00000Oo(gnk.O00000Oo(th));
        }
    }

    public ServerBean getGlobalSettingServer() {
        return CoreApi.O000000o().O0000ooO();
    }

    public String getCountryDomain() {
        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        if (O0000ooO == null || ftn.O00000o0(O0000ooO)) {
            return CoreApi.O000000o().O0000oo() ? "p1" : "";
        }
        return O0000ooO.f7546O000000o;
    }

    public String getCountryCode() {
        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        if (O0000ooO == null) {
            return ftn.O000000o().O00000Oo;
        }
        return O0000ooO.O00000Oo;
    }

    public String getModelByProductId(int i) {
        return CoreApi.O000000o().O00000Oo(i);
    }

    public boolean isMiLoggedIn() {
        return CoreApi.O000000o().O0000Ooo();
    }

    public void isCoreReady(Context context, final hug hug) {
        CoreApi.O000000o().O000000o(context, new CoreApi.O0000o0() {
            /* class _m_j.ghn.AnonymousClass2 */

            public final void onCoreReady() {
                hug hug = hug;
                if (hug != null) {
                    hug.O000000o();
                }
            }
        });
    }
}
