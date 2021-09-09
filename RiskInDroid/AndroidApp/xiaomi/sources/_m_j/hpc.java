package _m_j;

import android.content.Intent;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.WeatherConditionType;
import org.json.JSONException;
import org.json.JSONObject;

public class hpc extends hos implements hoz {
    public int O00000o;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public int O0000Oo;
    public Object O0000Oo0;

    public final int O000000o() {
        return R.string.condition_weather_name;
    }

    public final int O000000o(SceneApi.O000000o o000000o) {
        return -1;
    }

    public final String O00000Oo(int i) {
        return "";
    }

    public final int O00000o0(int i) {
        return 0;
    }

    public final boolean O00000oo() {
        return false;
    }

    public hpc() {
        super(null);
    }

    public final SceneApi.O000000o O000000o(int i, Intent intent) {
        WeatherConditionType weatherConditionType;
        SceneApi.O000000o o000000o = new SceneApi.O000000o();
        SceneApi.O0000o00 o0000o00 = new SceneApi.O0000o00();
        WeatherConditionType[] values = WeatherConditionType.values();
        int i2 = 0;
        while (true) {
            if (i2 >= values.length) {
                weatherConditionType = null;
                break;
            } else if (values[i2].conditionId == i) {
                weatherConditionType = values[i2];
                break;
            } else {
                i2++;
            }
        }
        o0000o00.O00000Oo = this.O00000oO;
        o0000o00.O00000o = weatherConditionType.conditionId;
        o0000o00.f11126O000000o = weatherConditionType.key;
        o0000o00.O0000O0o = this.O0000OOo;
        o0000o00.O00000oO = this.O0000O0o;
        o0000o00.O00000oo = this.O00000oo;
        o0000o00.O00000o0 = this.O0000Oo0;
        o0000o00.O0000OOo = this.O0000Oo;
        if (intent != null) {
            try {
                if (intent.hasExtra("value")) {
                    o0000o00.O00000o0 = new JSONObject(intent.getStringExtra("value"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        o000000o.O0000Ooo = weatherConditionType.compatibleId;
        o000000o.f11121O000000o = weatherConditionType.launchType;
        o000000o.O0000OoO = o0000o00;
        return o000000o;
    }

    public final String O00000o() {
        return ServiceApplication.getAppContext().getString(R.string.condition_weather_name);
    }

    public final void O000000o(SimpleDraweeView simpleDraweeView) {
        simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_weather));
    }
}
