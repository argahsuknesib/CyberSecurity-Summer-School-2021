package com.xiaomi.smarthome.device;

import _m_j.fmo;
import _m_j.ftt;
import _m_j.izb;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.api.CameraApi;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class RouterDevice extends MiioDeviceV2 {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final DecimalFormat f7026O000000o = new DecimalFormat("0.#");
    public static final DecimalFormat O00000Oo = new DecimalFormat("0.##");
    private static int O00000o = 1;
    public int deviceCount;
    public int downloading;
    public int downloads;
    public int installedPluginCount;
    public int lanSpeed;
    public boolean readStatusError = false;
    public long useableSpace;
    public int wanSpeed;

    public RouterDevice() {
        this.canAuth = false;
    }

    public void parseExtra(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.lanSpeed = jSONObject.optInt("lanSpeed");
                this.installedPluginCount = jSONObject.optInt("installedPluginCount");
                this.useableSpace = jSONObject.optLong("useableSpace");
                this.wanSpeed = jSONObject.optInt("wanSpeed");
                this.downloading = jSONObject.optInt("downloading");
                this.downloads = jSONObject.optInt("downloads");
                this.readStatusError = false;
            } catch (JSONException unused) {
            }
        }
    }

    public final void O000000o(Context context, final fmo fmo) {
        DeviceRouterFactory.getDeviceHelper().bindRouterDevice(context, this, new ftt<Void>() {
            /* class com.xiaomi.smarthome.device.RouterDevice.AnonymousClass1 */

            public final void O000000o(int i) {
                fmo fmo = fmo;
                if (fmo != null) {
                    fmo.O00000Oo();
                }
            }

            public final void O000000o(int i, Object obj) {
                fmo fmo = fmo;
                if (fmo != null) {
                    fmo.O00000Oo();
                }
            }

            public final /* synthetic */ void O000000o(Object obj) {
                CameraApi.getInstance().doBindCameraSuscess(this, null);
                fmo fmo = fmo;
                if (fmo != null) {
                    fmo.O000000o();
                }
                izb.O000000o(CommonApplication.getAppContext(), (int) R.string.button_bind_success, 0).show();
            }
        });
    }
}
