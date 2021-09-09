package _m_j;

import android.app.Activity;
import android.view.View;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.SmartHomeMainActivity;

@RouterService
public class hpg implements hom {
    public View getChooseSceneTitleBar(Activity activity) {
        if (activity == null || !(activity instanceof SmartHomeMainActivity)) {
            return null;
        }
        return ((SmartHomeMainActivity) activity).getChooseSceneTitleBar();
    }

    public View getChooseSceneMenuBar(Activity activity) {
        if (activity == null || !(activity instanceof SmartHomeMainActivity)) {
            return null;
        }
        return ((SmartHomeMainActivity) activity).getChooseSceneMenuBar();
    }
}
