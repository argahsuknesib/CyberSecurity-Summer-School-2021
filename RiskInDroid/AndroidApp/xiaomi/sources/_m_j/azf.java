package _m_j;

import android.os.HandlerThread;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import org.json.JSONArray;
import org.json.JSONObject;

public final class azf {

    /* renamed from: O000000o  reason: collision with root package name */
    public static HandlerThread f12727O000000o;

    public interface O000000o {
        void O000000o();

        void O000000o(boolean z, int i, String str);
    }

    public static void O000000o(String str, int i, Callback<JSONObject> callback) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put(i);
            jSONObject.put("print_job_id", jSONArray);
            XmPluginHostApi.instance().callMethod(str, "cancel_job", jSONObject, callback, Parser.DEFAULT_PARSER);
        } catch (Exception e) {
            e.printStackTrace();
            callback.onFailure(-1, e.getMessage());
        }
    }
}
