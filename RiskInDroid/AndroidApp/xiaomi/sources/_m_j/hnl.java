package _m_j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.List;

public class hnl extends hnm implements hoz {
    private List<SceneApi.O000OOOo> O00000oO;

    public final int O000000o() {
        return R.string.control_scene_action;
    }

    public final int O000000o(int i) {
        return -1;
    }

    public final int O000000o(SmartHomeSceneActionChooseActivity.O0000OOo o0000OOo, Context context, int i, Object obj, Object obj2) {
        return -3;
    }

    public final int O000000o(String str, Object obj) {
        return -1;
    }

    public hnl(List<SceneApi.O000OOOo> list) {
        this.O00000oO = list;
        this.O00000Oo = new int[this.O00000oO.size()];
        for (int i = 0; i < this.O00000oO.size(); i++) {
            this.O00000Oo[i] = i;
        }
        this.f19096O000000o = new String[this.O00000oO.size()];
    }

    public final SceneApi.Action O000000o(String str, int i, Object obj, Intent intent) {
        String str2;
        if (i >= this.O00000oO.size()) {
            return new SceneApi.Action();
        }
        SceneApi.O000OOOo o000OOOo = this.O00000oO.get(i);
        SceneApi.Action action = new SceneApi.Action();
        action.f11120O000000o = 3;
        action.O00000Oo = o000OOOo.O00000Oo;
        action.O00000oO = "";
        SceneApi.O000O0OO o000o0oo = new SceneApi.O000O0OO();
        o000o0oo.f11128O000000o = o000OOOo.f11131O000000o;
        int i2 = -1;
        if (intent != null && intent.hasExtra("enable")) {
            i2 = intent.getIntExtra("enable", -1);
        }
        o000o0oo.O00000Oo = i2;
        action.O0000O0o = o000o0oo;
        if (i2 == 1) {
            str2 = ServiceApplication.getAppContext().getResources().getString(R.string.scene_open);
        } else {
            str2 = ServiceApplication.getAppContext().getResources().getString(R.string.scene_close);
        }
        action.O00000o0 = str2;
        return action;
    }

    public final String O000000o(Object obj) {
        return ServiceApplication.getAppContext().getString(R.string.control_scene_action);
    }

    public final int O000000o(SceneApi.Action action, Object obj) {
        if (!(action.O0000O0o instanceof SceneApi.O000O0OO)) {
            return -1;
        }
        for (int i = 0; i < this.O00000oO.size(); i++) {
            if (TextUtils.equals(this.O00000oO.get(i).f11131O000000o, ((SceneApi.O000O0OO) action.O0000O0o).f11128O000000o)) {
                return i;
            }
        }
        return -1;
    }
}
