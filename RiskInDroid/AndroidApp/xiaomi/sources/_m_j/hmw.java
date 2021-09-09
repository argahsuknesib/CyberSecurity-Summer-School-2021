package _m_j;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.EmptyPlaceholderActivity;

public final class hmw implements hmt {
    public final exo getStateNotifier() {
        return null;
    }

    public final boolean isMIUIInternational() {
        return false;
    }

    public final boolean isRNDebugQRCode(String str) {
        return false;
    }

    public final boolean isSHMainActivityResumed() {
        return false;
    }

    public final boolean shouldAddEntryShowByHomeVirtualDeviceHelper(String str) {
        return false;
    }

    public final void updateVirtualDeviceInfoIfNeeded() {
    }

    public final Intent getActionByDeviceRenderer(Device device, Context context, Bundle bundle) {
        return new Intent(context, EmptyPlaceholderActivity.class);
    }
}
