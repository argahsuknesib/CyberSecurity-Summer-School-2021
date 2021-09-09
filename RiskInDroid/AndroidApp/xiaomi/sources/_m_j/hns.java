package _m_j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.List;

public class hns extends hnm implements hoz {
    private List<SceneApi.O000OOOo> O00000oO;

    public final int O000000o() {
        return R.string.exectute_one_scene;
    }

    public final int O000000o(int i) {
        return -1;
    }

    public final int O000000o(SmartHomeSceneActionChooseActivity.O0000OOo o0000OOo, Context context, int i, Object obj, Object obj2) {
        return -2;
    }

    public final int O000000o(String str, Object obj) {
        return -1;
    }

    public hns(List<SceneApi.O000OOOo> list) {
        this.O00000oO = list;
        this.O00000Oo = new int[this.O00000oO.size()];
        for (int i = 0; i < this.O00000oO.size(); i++) {
            this.O00000Oo[i] = i;
        }
        this.f19096O000000o = new String[this.O00000oO.size()];
    }

    public final SceneApi.Action O000000o(String str, int i, Object obj, Intent intent) {
        SceneApi.O000OOOo o000OOOo = this.O00000oO.get(i);
        SceneApi.Action action = new SceneApi.Action();
        action.f11120O000000o = 2;
        action.O00000Oo = o000OOOo.O00000Oo;
        action.O00000o0 = o000OOOo.O00000Oo;
        SceneApi.O000O00o o000O00o = new SceneApi.O000O00o();
        o000O00o.f11127O000000o = o000OOOo.f11131O000000o;
        action.O0000O0o = o000O00o;
        return action;
    }

    public final String O000000o(Object obj) {
        return ServiceApplication.getAppContext().getString(R.string.exectute_one_scene);
    }

    public final int O000000o(SceneApi.Action action, Object obj) {
        if (!(action.O0000O0o instanceof SceneApi.O000O00o)) {
            return -1;
        }
        for (int i = 0; i < this.O00000oO.size(); i++) {
            if (TextUtils.equals(this.O00000oO.get(i).f11131O000000o, ((SceneApi.O000O00o) action.O0000O0o).f11127O000000o)) {
                return i;
            }
        }
        return -1;
    }
}
