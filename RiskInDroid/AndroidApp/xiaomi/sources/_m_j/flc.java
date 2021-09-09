package _m_j;

import _m_j.hxd;
import android.app.Activity;
import android.text.TextUtils;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfoStatus;
import com.xiaomi.smarthome.frame.core.CoreApi;

public final class flc extends flu {
    public final int O000000o(String str) {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        if (O00000oO != null) {
            return O00000oO.O00000o();
        }
        return -3;
    }

    public final boolean O000000o() {
        return fsl.O000000o(CommonApplication.getAppContext());
    }

    public final boolean O00000Oo(String str) {
        PluginDeviceInfo O00000oO;
        if (TextUtils.isEmpty(str) || (O00000oO = CoreApi.O000000o().O00000oO(str)) == null) {
            return false;
        }
        int O00000o = O00000oO.O00000o();
        if (O00000o == 0 || O00000o == 3 || O00000o == 2 || O00000o == 11 || O00000o == 4) {
            return true;
        }
        return false;
    }

    public final boolean O00000Oo() {
        return CoreApi.O000000o().O0000OoO();
    }

    public final boolean O00000o0() {
        return flq.O000000o().O00000o0;
    }

    public final boolean O00000o0(String str) {
        PluginDeviceInfo O00000oO;
        if (!TextUtils.isEmpty(str) && (O00000oO = CoreApi.O000000o().O00000oO(str)) != null && !PluginDeviceInfoStatus.RELEASE.equals(O00000oO.O0000oO0())) {
            return true;
        }
        return false;
    }

    public final boolean O00000o() {
        return CoreApi.O000000o().O0000O0o();
    }

    public final boolean O000000o(String str, boolean z) {
        return CoreApi.O000000o().O00000Oo(str, z);
    }

    public final String O000000o(long j, long j2) {
        return CoreApi.O000000o().O000000o(j, j2);
    }

    public final void O000000o(Activity activity) {
        XmPluginPackage O000000o2 = fcx.f16092O000000o.O000000o(activity);
        hyd.O00000Oo().O000000o(activity, "switch_to_app", O000000o2);
        hxd.O000000o.f946O000000o.O000000o(activity, "switch_to_app", O000000o2);
    }

    public final void O00000Oo(Activity activity) {
        XmPluginPackage O000000o2 = fcx.f16092O000000o.O000000o(activity);
        hyd.O00000Oo().O000000o(activity, "switch_to_backstage", O000000o2);
        hxd.O000000o.f946O000000o.O000000o(activity, "switch_to_backstage", O000000o2);
    }
}
