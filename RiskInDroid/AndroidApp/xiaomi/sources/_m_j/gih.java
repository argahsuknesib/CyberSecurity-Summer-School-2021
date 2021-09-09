package _m_j;

import android.app.Activity;
import android.os.Bundle;
import com.xiaomi.smarthome.device.api.DeviceStat;

public interface gih {
    void showIRGateWayChooseActivity(Activity activity, String str);

    void showMatchingDeviceTypeActivity(Activity activity, DeviceStat deviceStat, int i, String[] strArr, Bundle bundle);
}
