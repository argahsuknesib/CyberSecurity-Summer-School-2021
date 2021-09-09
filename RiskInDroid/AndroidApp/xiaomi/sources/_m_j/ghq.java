package _m_j;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.SmartHomeMainActivity;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;

@RouterService
public class ghq implements hmt {
    public exo getStateNotifier() {
        return ServiceApplication.getStateNotifier();
    }

    public boolean shouldAddEntryShowByHomeVirtualDeviceHelper(String str) {
        return ggd.O000000o(str);
    }

    public Intent getActionByDeviceRenderer(Device device, Context context, Bundle bundle) {
        return ext.O000000o(device).getAction(device, context, bundle, false, null);
    }

    public void updateVirtualDeviceInfoIfNeeded() {
        fnr.O000000o();
    }

    public boolean isSHMainActivityResumed() {
        return SmartHomeMainActivity.mIsActivityResumed;
    }

    public boolean isMIUIInternational() {
        return goy.O000000o();
    }

    public boolean isRNDebugQRCode(String str) {
        return hmq.O000000o().isDebugQRCode(str);
    }
}
