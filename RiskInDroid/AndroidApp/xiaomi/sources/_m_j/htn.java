package _m_j;

import _m_j.ggb;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebView;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class htn implements fck {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile htn f641O000000o;

    public static htn O00000o() {
        if (f641O000000o == null) {
            synchronized (htn.class) {
                if (f641O000000o == null) {
                    f641O000000o = new htn();
                }
            }
        }
        return f641O000000o;
    }

    private htn() {
    }

    public final ArrayList<fcj> O000000o() {
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        ArrayList<fcj> arrayList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (Home next : list) {
                if (next != null && next.isOwner()) {
                    ggb.O00000Oo();
                    arrayList.add(new fcj(ggb.O000000o(next), next.getId()));
                }
            }
        }
        return arrayList;
    }

    public final void O00000Oo(String str) {
        SmartConfigRouterFactory.getSmartConfigManager().uploadBluetoothExceptionLog(str);
    }

    public final fsn O000000o(String str, String str2, JSONObject jSONObject, fsm<JSONObject, fso> fsm) {
        return fru.O000000o().O000000o(str, str2, (JSONObject) null, fsm);
    }

    public final fsn O000000o(Context context, String[] strArr, fsm<List<Device>, fso> fsm) {
        return DeviceApi.getInstance().getDeviceDetail(context, strArr, fsm);
    }

    public final void O000000o(BleDevice bleDevice) {
        ggb.O0000o00 = bleDevice;
    }

    public final void O000000o(Device device) {
        Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
        if (O0000Oo0 != null) {
            ggb.O00000Oo().O000000o(O0000Oo0, (Room) null, device, (ggb.O00000o) null);
        }
    }

    public final void O000000o(BleDevice bleDevice, View view, Context context) {
        SmartConfigRouterFactory.getSmartConfigManager().getDeviceDetailPageUrl(context, bleDevice.model, view);
    }

    public final boolean O00000o0() {
        htx O000000o2 = hty.O000000o();
        if (O000000o2 != null && O000000o2.getDevicePlusType() == 7) {
            return true;
        }
        return false;
    }

    public final ArrayList<fcj> O000000o(String str) {
        ArrayList<fcj> arrayList = new ArrayList<>();
        List<Room> O000000o2 = ggb.O00000Oo().O000000o(str);
        if (!O000000o2.isEmpty()) {
            for (Room next : O000000o2) {
                arrayList.add(new fcj(next.getName(), next.getId()));
            }
        }
        return arrayList;
    }

    public final List<fcj> O00000Oo() {
        fnn.O000000o().O00000Oo();
        List<String> O0000o = fqv.O0000o();
        ArrayList arrayList = new ArrayList();
        for (String fcj : O0000o) {
            arrayList.add(new fcj(fcj, null));
        }
        return arrayList;
    }

    public final void O000000o(String str, String str2, final Callback<String> callback) {
        String str3 = str2;
        String str4 = str;
        ggb.O00000Oo().O000000o(str3, str4, ggb.O00000Oo().O00000o(str2).getDids(), null, new ggb.O00000o() {
            /* class _m_j.htn.AnonymousClass1 */

            public final void O000000o() {
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess("");
                }
            }

            public final void O000000o(int i, fso fso) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, "create new room failed, error code is " + fso.O00000Oo);
                }
            }
        });
    }

    public final void O000000o(String str, String str2, Device device, final Callback<Void> callback) {
        ggb.O00000Oo().O000000o(ggb.O00000Oo().O00000o(str), ggb.O00000Oo().O00000o0(str2), device, new ggb.O00000o() {
            /* class _m_j.htn.AnonymousClass2 */

            public final void O000000o() {
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }

            public final void O000000o(int i, fso fso) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, fso.O00000Oo);
                }
            }
        });
    }

    public final WebView O000000o(Context context, String str) {
        String str2;
        String str3;
        SmartHomeWebView smartHomeWebView = new SmartHomeWebView(context);
        smartHomeWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
            StringBuilder sb = new StringBuilder("https://");
            if (O0000ooO != null) {
                str3 = O0000ooO.f7546O000000o + ".";
            } else {
                str3 = "";
            }
            sb.append(str3);
            sb.append("home.mi.com/views/deviceReset.html?model=");
            sb.append(str);
            sb.append("&locale=");
            sb.append(flk.O000000o(O00oOooo));
            str2 = sb.toString();
        } else {
            str2 = "https://home.mi.com/views/deviceReset.html?model=" + str + "&locale=" + flk.O000000o(O00oOooo);
        }
        smartHomeWebView.loadUrl(str2);
        return smartHomeWebView;
    }
}
