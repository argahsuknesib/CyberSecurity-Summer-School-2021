package _m_j;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.smarthome.device.Device;

public interface hmt {
    Intent getActionByDeviceRenderer(Device device, Context context, Bundle bundle);

    exo getStateNotifier();

    boolean isMIUIInternational();

    boolean isRNDebugQRCode(String str);

    boolean isSHMainActivityResumed();

    boolean shouldAddEntryShowByHomeVirtualDeviceHelper(String str);

    void updateVirtualDeviceInfoIfNeeded();
}
