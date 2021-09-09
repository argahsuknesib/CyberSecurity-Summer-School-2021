package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import org.json.JSONException;
import org.json.JSONObject;

public final class gxz {
    public static JSONObject O000000o() {
        String string = ServiceApplication.getApplication().getSharedPreferences("msg_center_setting", 0).getString("msg_center_content", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            return new JSONObject("{\n    \"scene\": 1,\n    \"device_share\": 1,\n    \"family_share\": 1,\n    \"shop\": 1,\n    \"no_interrupt\": 0,\n    \"no_interrupt_time\": {\n        \"from\": {\n            \"hour\": 0,\n            \"min\": 0\n        },\n        \"to\": {\n            \"hour\": 0,\n            \"min\": 0\n        },\n        \"wday\": [\n            0,\n            1,\n            2,\n            3,\n            4,\n            5,\n            6\n        ]\n    }\n}");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
