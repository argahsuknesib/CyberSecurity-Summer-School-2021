package _m_j;

import android.graphics.RectF;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.SmartHomeMainActivity;
import com.xiaomi.smarthome.device.Device;

@RouterService
public class ghy implements eye {
    public ImageView getWallPaperView(FragmentActivity fragmentActivity) {
        return ((SmartHomeMainActivity) fragmentActivity).getWallPaperView();
    }

    public void onClickCommonUseDevice(FragmentActivity fragmentActivity, Device device, RectF rectF, String str) {
        if (fragmentActivity != null && !fragmentActivity.isDestroyed()) {
            ((SmartHomeMainActivity) fragmentActivity).onClickCommonUseDevice(device, rectF, str);
        }
    }
}
