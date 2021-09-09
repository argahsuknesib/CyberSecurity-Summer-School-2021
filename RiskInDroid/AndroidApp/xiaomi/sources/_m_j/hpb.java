package _m_j;

import android.app.Activity;
import android.content.Intent;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;

public class hpb extends hos implements hoz {
    public final int O000000o() {
        return R.string.smarthome_scene_start_timer;
    }

    public final int O00000o0(int i) {
        return 101;
    }

    public final boolean O00000oo() {
        return false;
    }

    public hpb() {
        super(null);
    }

    public final SceneApi.O000000o O000000o(int i, Intent intent) {
        SceneApi.O000000o o000000o = new SceneApi.O000000o();
        o000000o.f11121O000000o = LAUNCH_TYPE.TIMER;
        o000000o.O0000Ooo = 101;
        return o000000o;
    }

    public final int O000000o(SceneApi.O000000o o000000o) {
        return o000000o.O00000Oo != null ? 0 : -1;
    }

    public final int O000000o(int i, Activity activity, SceneApi.O000000o o000000o) {
        activity.startActivityForResult(new Intent(activity, SmartHomeSceneTimerActivity.class), 102);
        return 102;
    }

    public final String O00000o() {
        return ServiceApplication.getAppContext().getString(R.string.smarthome_scene_start_timer);
    }

    public final void O000000o(SimpleDraweeView simpleDraweeView) {
        simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.condition_timer_icon));
    }
}
