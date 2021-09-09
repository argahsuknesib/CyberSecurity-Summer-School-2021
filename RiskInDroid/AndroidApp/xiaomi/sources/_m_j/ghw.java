package _m_j;

import android.app.Activity;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.family.ShareDeviceActivity;
import com.xiaomi.smarthome.family.ShareHomeActivity;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.miio.page.deviceshare.ShareDeviceInfoActivity;

@RouterService
public class ghw implements hsv {
    public void startShareHomeActivityForResult(Activity activity, String str, int i, boolean z) {
        ShareHomeActivity.startActivityForResult(activity, str, i, z);
    }

    public void checkMsgAlert(BaseActivity baseActivity, int i) {
        hsr.O000000o(baseActivity, i);
    }

    public Class<?> getShareDeviceActivity() {
        return ShareDeviceActivity.class;
    }

    public Class<?> getShareDeviceInfoActivity() {
        return ShareDeviceInfoActivity.class;
    }

    public void getShareManagerInstance() {
        if (hss.f605O000000o == null) {
            hss.f605O000000o = new hss();
        }
    }
}
