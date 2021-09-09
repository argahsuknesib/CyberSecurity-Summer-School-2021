package _m_j;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceSearch;
import com.xiaomi.smarthome.device.ZhilianCameraDevice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fnv extends DeviceSearch<Device> {
    private static volatile fnv O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    ScanResult f16726O000000o;
    private List<Device> O00000o0 = new ArrayList();

    public final void O000000o(Collection<? extends Device> collection, DeviceSearch.REMOTESTATE remotestate) {
    }

    private fnv() {
    }

    public static fnv O00000oo() {
        if (O00000Oo == null) {
            synchronized (fnv.class) {
                if (O00000Oo == null) {
                    O00000Oo = new fnv();
                }
            }
        }
        return O00000Oo;
    }

    static boolean O000000o(String str) {
        return !TextUtils.isEmpty(str) && str.contains("isa-camera-isc5");
    }

    static Context O0000O0o() {
        return CommonApplication.getAppContext();
    }

    static void O0000OOo() {
        fno.O000000o().O0000OOo();
        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("refresh_xiaofang_dialog"));
    }

    public final void O00000Oo() {
        this.O0000O0o = true;
    }

    public final List<Device> O00000o0() {
        this.O00000o0.clear();
        ScanResult scanResult = this.f16726O000000o;
        if (scanResult != null) {
            ZhilianCameraDevice zhilianCameraDevice = new ZhilianCameraDevice(scanResult);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ssid", scanResult.SSID);
                jSONObject.put("bssid", scanResult.BSSID);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            zhilianCameraDevice.extra = jSONArray.toString();
            this.O00000o0.add(zhilianCameraDevice);
        }
        return this.O00000o0;
    }

    public final void O00000o() {
        this.O00000o0.clear();
    }

    static ScanResult O00000Oo(String str) {
        for (ScanResult next : ((WifiManager) CommonApplication.getAppContext().getSystemService("wifi")).getScanResults()) {
            if (iag.O000000o(next.SSID, str)) {
                return next;
            }
        }
        return null;
    }
}
