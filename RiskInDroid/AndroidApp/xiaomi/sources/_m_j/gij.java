package _m_j;

import android.app.Activity;
import android.os.Bundle;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.infrared.activity.IRGateWayChooseActivity;
import com.xiaomi.smarthome.infrared.activity.IRMatchingDeviceTypeActivity;

@RouterService
public class gij implements gih {
    public void showMatchingDeviceTypeActivity(Activity activity, DeviceStat deviceStat, int i, String[] strArr, Bundle bundle) {
        IRMatchingDeviceTypeActivity.showMatchingDeviceTypeActivity(activity, deviceStat, i, strArr, bundle);
    }

    public void showIRGateWayChooseActivity(Activity activity, String str) {
        IRGateWayChooseActivity.showIRGateWayChooseActivity(activity, str);
    }
}
