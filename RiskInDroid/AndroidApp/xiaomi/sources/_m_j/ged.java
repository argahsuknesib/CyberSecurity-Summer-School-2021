package _m_j;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class ged {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile ged f17594O000000o;
    private static final Object O00000Oo = new Object();

    private ged() {
    }

    public static ged O000000o() {
        if (f17594O000000o == null) {
            synchronized (O00000Oo) {
                if (f17594O000000o == null) {
                    f17594O000000o = new ged();
                }
            }
        }
        return f17594O000000o;
    }

    public static fsn O000000o(Context context, String str, String str2, String str3, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pushid", str);
            jSONObject.put("deviceid", str2);
            jSONObject.put("region", str3);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/mipush/reg").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
        } catch (JSONException unused) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
            return new fsn(null);
        }
    }

    public static fsn O000000o(Context context, String str, String str2, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pushid", str);
            jSONObject.put("deviceid", str2);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/mipush/unreg").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
        } catch (JSONException unused) {
            if (fsm != null) {
                fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
            }
            return new fsn(null);
        }
    }

    public final fsn O000000o(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgId", str);
            jSONObject.put("did", str2);
            jSONObject.put("alertType", str3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/message/clear_p0_alert").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.ged.AnonymousClass2 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, (fsm) null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void O000000o(String str, String str2, String str3, long j, String str4, boolean z) {
        Device O000000o2 = fno.O000000o().O000000o(str2);
        if (O000000o2 == null) {
            O000000o2 = fno.O000000o().O00000Oo(str2);
        }
        if (O000000o2 == null || str == null) {
            gsy.O00000Oo("PushApi", "device and pluginRecord is null");
            return;
        }
        gsy.O00000Oo("PushApi", "onReceiveScenePush:".concat(String.valueOf(str2)));
        Intent intent = new Intent();
        intent.putExtra("did", str2);
        intent.putExtra("event", str3);
        intent.putExtra("time", j);
        intent.putExtra("extra", str4);
        intent.putExtra("isNotified", z);
        intent.putExtra("type", "ScenePush");
        PluginApi.getInstance().sendMessage(ServiceApplication.getAppContext(), str, 2, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O000000o2), null, false, new SendMessageCallback() {
            /* class _m_j.ged.AnonymousClass3 */

            public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
            }
        });
    }
}
