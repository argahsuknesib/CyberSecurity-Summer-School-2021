package _m_j;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hoi {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f445O000000o;
    O000000o O00000Oo;
    String O00000o;
    int[] O00000o0;

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        O000000o o000000o = this.f445O000000o;
        if (o000000o != null) {
            try {
                jSONObject.put("from", o000000o.O000000o());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        O000000o o000000o2 = this.O00000Oo;
        if (o000000o2 != null) {
            try {
                jSONObject.put("to", o000000o2.O000000o());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        int[] iArr = this.O00000o0;
        if (iArr != null && iArr.length > 0) {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (true) {
                int[] iArr2 = this.O00000o0;
                if (i >= iArr2.length) {
                    break;
                }
                jSONArray.put(iArr2[i]);
                i++;
            }
            try {
                jSONObject.put("wday", jSONArray);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.O00000o)) {
            try {
                jSONObject.put("filter", this.O00000o);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f446O000000o;
        public int O00000Oo;

        O000000o() {
        }

        O000000o(byte b) {
            this.O00000Oo = 0;
            this.f446O000000o = 0;
        }

        public static O000000o O000000o(JSONObject jSONObject) {
            O000000o o000000o = new O000000o();
            o000000o.O00000Oo = jSONObject.optInt("hour");
            o000000o.f446O000000o = jSONObject.optInt("min");
            return o000000o;
        }

        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("hour", this.O00000Oo);
                jSONObject.put("min", this.f446O000000o);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static hoi O000000o(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.keys().hasNext()) {
            hoi hoi = new hoi();
            hoi.f445O000000o = new O000000o((byte) 0);
            hoi.O00000Oo = new O000000o((byte) 0);
            hoi.O00000o0 = new int[]{0, 1, 2, 3, 4, 5, 6};
            return hoi;
        }
        hoi hoi2 = new hoi();
        JSONObject optJSONObject = jSONObject.optJSONObject("from");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("to");
        if (optJSONObject == null || !optJSONObject.keys().hasNext()) {
            hoi2.f445O000000o = new O000000o((byte) 0);
        } else {
            hoi2.f445O000000o = O000000o.O000000o(optJSONObject);
        }
        if (optJSONObject2 == null || !optJSONObject2.keys().hasNext()) {
            hoi2.O00000Oo = new O000000o((byte) 0);
        } else {
            hoi2.O00000Oo = O000000o.O000000o(optJSONObject2);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("wday");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            hoi2.O00000o0 = new int[]{0, 1, 2, 3, 4, 5, 6};
        } else {
            hoi2.O00000o0 = new int[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                hoi2.O00000o0[i] = optJSONArray.optInt(i);
            }
        }
        String optString = jSONObject.optString("filter");
        if (!TextUtils.isEmpty(optString)) {
            hoi2.O00000o = optString;
        }
        return hoi2;
    }
}
