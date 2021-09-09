package _m_j;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerDelay;
import com.xiaomi.smarthome.scene.api.SceneApi;

public class hno extends hnm implements hoz {
    public final int O000000o() {
        return R.string.smarthome_scene_delay;
    }

    public final int O000000o(int i) {
        return 0;
    }

    public final int O000000o(String str, Object obj) {
        return -1;
    }

    public hno() {
        this.O00000Oo = new int[1];
        this.f19096O000000o = new String[1];
    }

    public final SceneApi.Action O000000o(String str, int i, Object obj, Intent intent) {
        SceneApi.Action action = new SceneApi.Action();
        action.f11120O000000o = 2;
        action.O00000Oo = ServiceApplication.getAppContext().getString(R.string.smarthome_scene_delay);
        action.O00000o0 = str;
        action.O00000oO = "delay";
        SceneApi.O000O0o0 o000O0o0 = new SceneApi.O000O0o0();
        if (intent != null) {
            o000O0o0.O00000oo = intent.getIntExtra("value", 0);
        }
        o000O0o0.O00000o0 = action.O00000oO + ".delay";
        action.O0000O0o = o000O0o0;
        return action;
    }

    public final String O000000o(Object obj) {
        return ServiceApplication.getAppContext().getString(R.string.smarthome_scene_delay);
    }

    public final int O000000o(SceneApi.Action action, Object obj) {
        return action.f11120O000000o == 1 ? 0 : -1;
    }

    public final int O000000o(SmartHomeSceneActionChooseActivity.O0000OOo o0000OOo, Context context, int i, Object obj, Object obj2) {
        o0000OOo.O000000o(new Intent(context, SmartHomeSceneTimerDelay.class), 102);
        return 102;
    }
}
