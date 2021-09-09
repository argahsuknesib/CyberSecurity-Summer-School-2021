package _m_j;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.plugin.rn.debugmock.MockRnDevicePluginManager;
import org.json.JSONObject;

public final class gax {
    public static boolean O000000o(int i, String str) {
        if (TextUtils.isEmpty(str) || i != 1 || XmPluginHostApi.instance().getQrDebugModePackageName() != null) {
            return false;
        }
        JSONObject O000000o2 = fvu.O000000o(str);
        fvo.O000000o();
        return (!fvo.O00000oO() || O000000o2 == null || !O000000o2.optBoolean(fvt.O00000o0)) && !MockRnDevicePluginManager.getInstance().modelIsMockModel(str);
    }

    public static int O000000o(Bundle bundle) {
        if (bundle != null) {
            return bundle.getInt("package_msgType", 1);
        }
        return 1;
    }
}
