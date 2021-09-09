package _m_j;

import android.util.Log;
import org.json.JSONObject;

public interface dxe {
    void onResponse(String str);

    public static abstract class O000000o implements dxe {
        public abstract void O000000o(int i, String str, Throwable th);

        public abstract void O000000o(JSONObject jSONObject);

        public void onResponse(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("code", -1);
                if (optInt == 0) {
                    O000000o(jSONObject.optJSONObject("result"));
                } else {
                    O000000o(optInt, str, null);
                }
            } catch (Throwable th) {
                Log.e("fatal", "MiioLocalRpcResponseSimple.onResponse", th);
                O000000o(Integer.MIN_VALUE, null, th);
            }
        }
    }
}
