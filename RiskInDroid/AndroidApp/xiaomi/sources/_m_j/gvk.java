package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class gvk {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<O000000o> f18378O000000o;
    public boolean O00000Oo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18379O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public long O00000oO;
    }

    public static gvk O000000o(JSONObject jSONObject) {
        gvk gvk = new gvk();
        if (jSONObject == null) {
            return gvk;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    O000000o o000000o = new O000000o();
                    String optString = optJSONObject.optString("did");
                    String optString2 = optJSONObject.optString("name");
                    String optString3 = optJSONObject.optString("model");
                    String optString4 = optJSONObject.optString("type");
                    long optLong = optJSONObject.optLong("pd_id");
                    if (TextUtils.isEmpty(optString)) {
                        o000000o = null;
                    } else {
                        o000000o.f18379O000000o = optString;
                        o000000o.O00000Oo = optString2;
                        o000000o.O00000o0 = optString3;
                        o000000o.O00000o = optString4;
                        o000000o.O00000oO = optLong;
                    }
                    if (o000000o != null) {
                        arrayList.add(o000000o);
                    }
                }
            }
            gvk.f18378O000000o = arrayList;
        }
        gvk.O00000Oo = jSONObject.optBoolean("need_gateway");
        return gvk;
    }
}
