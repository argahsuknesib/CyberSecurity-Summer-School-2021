package _m_j;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.infrared.bean.IRType;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class gje {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Set<String> f17841O000000o;
    public static Random O00000Oo;

    public static String O000000o(String str, Set<String> set) {
        String str2;
        if (O00000Oo == null) {
            O00000Oo = new Random();
        }
        do {
            str2 = "";
            for (int i = 0; i < 15; i++) {
                int abs = Math.abs(O00000Oo.nextInt()) % str.length();
                str2 = str2 + str.charAt(abs);
            }
        } while (set.contains(str2));
        set.add(str2);
        return str2;
    }

    public static List<gir> O000000o() {
        ArrayList arrayList = new ArrayList();
        for (int value = IRType.STB.value(); value <= IRType.WATER_HEATER.value(); value++) {
            arrayList.add(O000000o(value));
        }
        return arrayList;
    }

    public static List<gir> O00000Oo() {
        ArrayList arrayList = new ArrayList();
        for (int value = IRType.WATER_HEATER.value(); value >= IRType.Unknown.value(); value--) {
            arrayList.add(O000000o(value));
        }
        return arrayList;
    }

    public static List<gir> O000000o(String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String valueOfModel : strArr) {
            arrayList.add(O000000o(IRType.valueOfModel(valueOfModel).value()));
        }
        return arrayList;
    }

    public static gir O000000o(int i) {
        int i2;
        String str;
        int i3;
        if (i == IRType.STB.value()) {
            i2 = R.string.ir_device_type_set_top_box_text;
            i3 = R.drawable.ir_device_type_set_top_box_normal;
            str = "miir.stb.ir01";
        } else if (i == IRType.TV.value()) {
            i2 = R.string.ir_device_type_tv_text;
            i3 = R.drawable.ir_device_type_tv_normal;
            str = "miir.tv.ir01";
        } else if (i == IRType.BOX.value()) {
            i2 = R.string.ir_device_type_box_text;
            i3 = R.drawable.ir_device_type_box_normal;
            str = "miir.tvbox.ir01";
        } else if (i == IRType.DVD.value()) {
            i2 = R.string.ir_device_type_dvd_text;
            i3 = R.drawable.ir_device_type_dvd_normal;
            str = "miir.dvd.ir01";
        } else if (i == IRType.AC.value()) {
            i2 = R.string.ir_device_type_air_conditioner_text;
            i3 = R.drawable.ir_device_type_air_conditioner_normal;
            str = "miir.aircondition.ir01";
        } else if (i == IRType.PRO.value()) {
            i2 = R.string.ir_device_type_projector_text;
            i3 = R.drawable.ir_device_type_projector_normal;
            str = "miir.projector.ir01";
        } else if (i == IRType.PA.value()) {
            i2 = R.string.ir_device_type_amplifier;
            i3 = R.drawable.ir_device_type_amplifier_normal;
            str = "miir.wifispeaker.ir01";
        } else if (i == IRType.FAN.value()) {
            i2 = R.string.ir_device_type_fan_text;
            i3 = R.drawable.ir_device_type_fan_normal;
            str = "miir.fan.ir01";
        } else if (i == IRType.SLR.value()) {
            i2 = R.string.ir_device_type_camera;
            i3 = R.drawable.ir_device_type_camera_normal;
            str = "miir.camera.ir01";
        } else if (i == IRType.LIGHT.value()) {
            i2 = R.string.ir_device_type_lamp;
            i3 = R.drawable.ir_lamp_normal;
            str = "miir.light.ir01";
        } else if (i == IRType.AIR_CLEANER.value()) {
            i2 = R.string.ir_device_type_purifier_text;
            i3 = R.drawable.ir_device_type_purifier_normal;
            str = "miir.airpurifier.ir01";
        } else if (i == IRType.WATER_HEATER.value()) {
            i2 = R.string.ir_device_type_water_heater;
            i3 = R.drawable.ir_device_type_tv_wther_heater_normal;
            str = "miir.waterheater.ir01";
        } else {
            i2 = R.string.ir_device_type_unknown;
            i3 = R.drawable.ir_device_type_unknown_normal;
            str = "miir.remote.ir01";
        }
        return new gir(str, i2, i3);
    }

    public static String O000000o(String str, String str2) {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String O000000o2 = gjd.O000000o(jSONObject, "key");
            if (TextUtils.isEmpty(O000000o2) && (optJSONArray = jSONObject.optJSONArray("result")) != null && optJSONArray.length() > 0) {
                return O000000o(str, optJSONArray.optString(0));
            }
            String O000000o3 = gjd.O000000o(jSONObject, "code");
            if (str.equals(O000000o2)) {
                return O000000o3;
            }
            return "";
        } catch (Throwable th) {
            gsy.O00000o0(LogType.PLUGIN, "IRDataUtil", Log.getStackTraceString(th));
            return "";
        }
    }
}
