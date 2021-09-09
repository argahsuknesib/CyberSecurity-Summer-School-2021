package _m_j;

import _m_j.fno;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import java.util.ArrayList;
import java.util.Map;

public final class gdp {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f17566O000000o = 10001;
    public boolean O00000Oo = false;
    private final String O00000o = "xiaomi.router.v1";
    public boolean O00000o0 = false;
    private final String O00000oO = "xiaomi.router.mv1";
    private final String O00000oo = "xiaomi.router.v2";
    private BroadcastReceiver O0000O0o = new BroadcastReceiver() {
        /* class _m_j.gdp.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            gdp gdp = gdp.this;
            gdp.O00000Oo = true;
            gdp.O000000o();
        }
    };
    private fno.O000000o O0000OOo = new fno.O000000o() {
        /* class _m_j.gdp.AnonymousClass2 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            gdp gdp = gdp.this;
            gdp.O00000o0 = true;
            gdp.O000000o();
        }
    };

    public final void O000000o() {
        if (this.O00000Oo && this.O00000o0) {
            ft.O000000o(CommonApplication.getAppContext()).O000000o(this.O0000O0o);
            fno.O000000o().O00000Oo(this.O0000OOo);
            Map<String, Device> O0000O0o2 = fno.O000000o().O0000O0o();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Device> value : O0000O0o2.entrySet()) {
                Device device = (Device) value.getValue();
                if (!TextUtils.isEmpty(device.model) && (device.model.equalsIgnoreCase("xiaomi.router.v1") || device.model.equalsIgnoreCase("xiaomi.router.mv1") || device.model.equalsIgnoreCase("xiaomi.router.v2"))) {
                    arrayList.add(device.did);
                }
            }
            if (arrayList.size() > 0) {
                PluginApi.getInstance().sendMessage(CommonApplication.getAppContext(), "xiaomi.router.v1", 10001, new Intent("action_app_start"), null, null, true, null);
            }
        }
    }

    public final void O00000Oo() {
        ft.O000000o(CommonApplication.getAppContext()).O000000o(this.O0000O0o, new IntentFilter("action_on_application_start"));
        fno.O000000o().O000000o(this.O0000OOo);
    }
}
