package _m_j;

import android.util.Log;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dni extends dnh {
    public final int O000000o(Object obj) {
        dnc dnc;
        int O000000o2 = super.O000000o(obj);
        Set<Object> O00000Oo = O00000Oo();
        if (O00000Oo != null) {
            int i = -1;
            if (this.f14805O000000o > 0) {
                i = this.O0000Oo.O00000Oo();
            }
            byte O000000o3 = this.O0000Oo.O000000o();
            dmx O000000o4 = O000000o(O000000o3);
            if (O000000o4 != null) {
                dnc = O000000o4.f14798O000000o;
            } else {
                Log.e("ArrayExecutor_TMTEST", "read param failed:".concat(String.valueOf((int) O000000o3)));
                dnc = null;
            }
            if (dnc == null) {
                Log.e("ArrayExecutor_TMTEST", "param is null");
                return O000000o2;
            } else if (O000000o(i, this.O0000Oo.O000000o(), dnc, O00000Oo)) {
                return 1;
            } else {
                Log.e("ArrayExecutor_TMTEST", "call array failed");
                return O000000o2;
            }
        } else {
            Log.e("ArrayExecutor_TMTEST", "execute findObject failed");
            return O000000o2;
        }
    }

    private boolean O000000o(int i, int i2, dnc dnc, Set<Object> set) {
        JSONArray jSONArray;
        String O000000o2 = this.O0000OOo.O000000o(i);
        Object O00000o0 = dnc.O00000o0();
        if (O00000o0 instanceof Integer) {
            boolean z = true;
            int intValue = ((Integer) O00000o0).intValue();
            for (Object next : set) {
                if (next instanceof dms) {
                    jSONArray = (JSONArray) this.O0000Ooo.f14793O000000o.opt(O000000o2);
                } else if (next instanceof JSONObject) {
                    jSONArray = ((JSONObject) next).optJSONArray(O000000o2);
                } else if (next instanceof JSONArray) {
                    jSONArray = (JSONArray) next;
                } else {
                    Log.e("ArrayExecutor_TMTEST", "error object:".concat(String.valueOf(next)));
                    return false;
                }
                try {
                    Object obj = jSONArray.get(intValue);
                    dmx O000000o3 = this.O0000OoO.O000000o(i2);
                    if (obj != null) {
                        O000000o3.O000000o(obj);
                    } else {
                        O000000o3.O00000Oo = 0;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("ArrayExecutor_TMTEST", "set value failed");
                    z = false;
                }
            }
            return z;
        }
        Log.e("ArrayExecutor_TMTEST", "param not integer");
        return false;
    }
}
