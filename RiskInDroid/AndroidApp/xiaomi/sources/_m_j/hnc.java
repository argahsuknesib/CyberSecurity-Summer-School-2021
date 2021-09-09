package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.callback.ConfigKeyValuePair;
import com.xiaomi.smarthome.smartconfig.callback.ConfigNetRequest;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class hnc {
    public static String O000000o(Context context) {
        DhcpInfo dhcpInfo;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1 || (dhcpInfo = ((WifiManager) context.getSystemService("wifi")).getDhcpInfo()) == null) {
            return null;
        }
        return Formatter.formatIpAddress(dhcpInfo.gateway);
    }

    public static void O000000o(String str, Callback<String> callback) {
        SmartConfigRouterFactory.getSmartConfigManager().commonRequestHandle(String.format("http://%s/cgi-bin/luci/api/xqsystem/init_info", str), "GET", new ArrayList(), callback, new Parser<String>() {
            /* class _m_j.hnc.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
                return str;
            }
        });
    }

    public static void O000000o(String str, String str2, huc huc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "POST");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("serialNumber", str);
            jSONObject2.put("deviceID", str2);
            jSONObject.put("params", jSONObject2);
        } catch (JSONException unused) {
        }
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o("/appgateway/third/miwifi/app/s/device/isDeviceBound", jSONObject), huc);
    }

    public static ConfigNetRequest O000000o(String str, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o(str);
        O000000o2.O00000o0 = arrayList;
        return O000000o2.O000000o();
    }
}
