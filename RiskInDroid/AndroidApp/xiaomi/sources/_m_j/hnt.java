package _m_j;

import android.content.Intent;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.scene.api.SceneApi;

public class hnt extends hnm implements hoz {
    public final int O000000o() {
        return R.string.smarthome_scene_push_action;
    }

    public final int O000000o(int i) {
        return 0;
    }

    public final int O000000o(String str, Object obj) {
        return -1;
    }

    public final SceneApi.Action O000000o(String str, int i, Object obj, Intent intent) {
        SceneApi.Action action = new SceneApi.Action();
        action.f11120O000000o = 1;
        action.O00000Oo = gwc.O000000o((int) R.string.smarthome_scene_push_action);
        action.O00000o0 = str;
        action.O00000oO = "phone";
        SceneApi.O000OO o000oo = new SceneApi.O000OO();
        o000oo.f11129O000000o = gwc.O000000o((int) R.string.smarthome_scene_push_title);
        o000oo.O00000o0 = action.O00000oO + ".push";
        action.O0000O0o = o000oo;
        return action;
    }

    public final String O000000o(Object obj) {
        return gwc.O000000o((int) R.string.smarthome_scene_push_action);
    }

    public final int O000000o(SceneApi.Action action, Object obj) {
        return action.f11120O000000o == 1 ? 0 : -1;
    }
}
