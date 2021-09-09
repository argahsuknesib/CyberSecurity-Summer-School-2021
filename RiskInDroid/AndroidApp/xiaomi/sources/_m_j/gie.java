package _m_j;

import androidx.fragment.app.FragmentActivity;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.SmartHomeMainActivity;

@RouterService
public class gie implements hyx {
    public void gotoDevicePage(FragmentActivity fragmentActivity) {
        if (fragmentActivity instanceof SmartHomeMainActivity) {
            ((SmartHomeMainActivity) fragmentActivity).gotoDevicePage();
        }
    }
}
