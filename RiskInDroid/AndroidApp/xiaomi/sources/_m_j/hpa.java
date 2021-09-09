package _m_j;

import android.content.Intent;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;

public final class hpa extends hos implements hoz {
    public final int O000000o() {
        return R.string.condition_nfc;
    }

    public final int O000000o(SceneApi.O000000o o000000o) {
        return -1;
    }

    public final int O00000o0(int i) {
        return 101;
    }

    public final boolean O00000oo() {
        return false;
    }

    public hpa() {
        super(null);
    }

    public final SceneApi.O000000o O000000o(int i, Intent intent) {
        SceneApi.O000000o o000000o = new SceneApi.O000000o();
        o000000o.O0000Ooo = 101;
        o000000o.f11121O000000o = LAUNCH_TYPE.NFC;
        o000000o.O0000OOo = new SceneApi.O00oOooO();
        o000000o.O0000OOo.f11133O000000o = "nfc";
        return o000000o;
    }

    public final void O000000o(SimpleDraweeView simpleDraweeView) {
        simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_nfc));
    }

    public final String O00000o() {
        return ServiceApplication.getAppContext().getString(R.string.condition_nfc);
    }
}
