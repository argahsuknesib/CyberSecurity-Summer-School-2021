package _m_j;

import android.content.Intent;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.scene.api.SceneApi;

public class hnr extends hnm implements hoz {
    public final int O000000o() {
        return R.string.smarthome_scene_create_auto_device;
    }

    public final int O000000o(int i) {
        return 0;
    }

    public final int O000000o(SceneApi.Action action, Object obj) {
        return 0;
    }

    public final int O000000o(String str, Object obj) {
        return 0;
    }

    public final SceneApi.Action O000000o(String str, int i, Object obj, Intent intent) {
        return null;
    }

    public final String O000000o(Object obj) {
        return ServiceApplication.getAppContext().getString(R.string.smarthome_scene_create_auto_device);
    }
}
