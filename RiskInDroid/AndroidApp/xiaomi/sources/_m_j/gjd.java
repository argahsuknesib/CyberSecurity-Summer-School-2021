package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.infrared.bean.IRKeyValue;
import org.json.JSONObject;

public final class gjd {
    public static String O000000o(JSONObject jSONObject, String str) {
        Object opt = jSONObject.opt(str);
        return (opt == JSONObject.NULL || opt == null) ? "" : String.valueOf(opt);
    }

    public static String O000000o(IRKeyValue iRKeyValue) {
        String str = iRKeyValue.O00000o;
        String str2 = iRKeyValue.O0000OOo;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return (!TextUtils.isEmpty(str2) && ftl.O00000Oo()) ? str2 : str;
    }
}
