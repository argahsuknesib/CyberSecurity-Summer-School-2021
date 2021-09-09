package _m_j;

import android.content.Intent;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;

public class hot extends hos implements hoz {
    public final int O000000o() {
        return R.string.smarthome_scene_click_start;
    }

    public final int O00000o0(int i) {
        return 101;
    }

    public final boolean O00000oo() {
        return false;
    }

    public hot() {
        super(null);
    }

    public final SceneApi.O000000o O000000o(int i, Intent intent) {
        SceneApi.O000000o o000000o = new SceneApi.O000000o();
        o000000o.O0000Ooo = 101;
        o000000o.f11121O000000o = LAUNCH_TYPE.CLICK;
        return o000000o;
    }

    public final int O000000o(SceneApi.O000000o o000000o) {
        return o000000o.f11121O000000o == LAUNCH_TYPE.CLICK ? 0 : -1;
    }

    public final String O00000o() {
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            return ServiceApplication.getAppContext().getString(R.string.smarthome_scene_click_start);
        }
        return ServiceApplication.getAppContext().getString(R.string.smarthome_scene_click_start_mainland);
    }

    public final void O000000o(SimpleDraweeView simpleDraweeView) {
        simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.scene_click_lite_scene_icon));
    }
}
