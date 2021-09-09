package _m_j;

import _m_j.fno;
import android.content.Intent;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfoStatus;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.miui10.MIUI10CardActivity;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@RouterService
public class fav implements fbg {
    private static final fav INSTANCE = new fav();

    @cug
    public static fav provideInstance() {
        return INSTANCE;
    }

    public void operateCardStat(Device device) {
        if (!TextUtils.isEmpty(MIUI10CardActivity.sRoomName)) {
            fbq.O000000o(device.model, MIUI10CardActivity.sRoomName, fml.O000000o(device));
        }
    }

    public void report_spec_result(long j, String str, boolean z, int i, List<String> list, String str2, String str3) {
        try {
            CoreApi.O000000o().O00000Oo().report_spec_result(j, str, z, i, getOneModel(list), str2, str3);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreApi.CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public fsn rpcAsync(String str, String str2, String str3, fsm<JSONObject, fso> fsm) {
        return fbm.O000000o(str, str2, str3, fsm);
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
    public void dataReadyRefresh() {
        LocalBroadcastManager.getInstance(CommonApplication.getAppContext()).sendBroadcast(new Intent("com.smarthome.refresh_list_view").putExtra("refresh_all", true));
    }

    private static String getOneModel(List<String> list) {
        Device O000000o2;
        if (list == null || list.size() != 1 || (O000000o2 = fno.O000000o().O000000o(list.get(0))) == null) {
            return "";
        }
        return O000000o2.model;
    }

    public Device getDeviceByDid(String str) {
        return fno.O000000o().O000000o(str);
    }

    public Map<String, Device> getAllDevices() {
        return fno.O000000o().O00000oO();
    }

    public void registerDeviceRefreshListener(fbf fbf) {
        fno.O000000o().O000000o(new fno.O000000o(fbf) {
            /* class _m_j.fbr.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ fbf f16047O000000o;

            public final void onRefreshClientDeviceChanged(int i, Device device) {
            }

            {
                this.f16047O000000o = r1;
            }

            public final void onRefreshClientDeviceSuccess(int i) {
                fbf fbf = this.f16047O000000o;
                if (fbf != null) {
                    fbf.O000000o(i);
                }
            }
        });
    }

    public <T> void callMethod(String str, String str2, Callback<T> callback, Parser<T> parser) {
        PluginHostApi.instance().callMethod(str, str2, callback, parser);
    }

    public int generateNonce() {
        return ((PluginHostApi) XmPluginHostApi.instance()).generateNonce();
    }

    public frb createDevicePropSubscriber() {
        return new frd();
    }

    public boolean isPluginNotRelease(String str) {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        return (O00000oO == null || O00000oO.O0000oO0() == PluginDeviceInfoStatus.RELEASE) ? false : true;
    }
}
