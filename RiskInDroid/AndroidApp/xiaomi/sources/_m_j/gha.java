package _m_j;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class gha {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f17769O000000o = 0;
    public static int O00000Oo = 1;
    public static int O00000o = 3;
    public static int O00000o0 = 2;
    public long O00000oO;
    public long O00000oo;
    public int O0000O0o;
    public long O0000OOo;
    public String O0000Oo;
    public long O0000Oo0;
    private long O0000OoO;
    private long O0000Ooo;
    private String O0000o0;
    private String O0000o00;
    private String O0000o0O;

    private static gha O000000o(JSONObject jSONObject) {
        JSONObject optJSONObject;
        gha gha = new gha();
        try {
            if (!jSONObject.isNull("owner_uid")) {
                gha.O00000oO = jSONObject.optLong("owner_uid");
            }
            if (!jSONObject.isNull("share_to_uid")) {
                gha.O0000OoO = jSONObject.optLong("share_to_uid");
            }
            if (!jSONObject.isNull("home_id")) {
                gha.O00000oo = jSONObject.optLong("home_id");
                gha.O0000Oo = jSONObject.optString("home_id");
            }
            if (!jSONObject.isNull("message_id")) {
                gha.O0000Ooo = jSONObject.optLong("message_id");
            }
            if (!jSONObject.isNull("status")) {
                gha.O0000O0o = jSONObject.optInt("status");
            }
            if (!jSONObject.isNull("update_time")) {
                gha.O0000OOo = (long) jSONObject.optInt("update_time");
            }
            if (!jSONObject.isNull("expire_time")) {
                gha.O0000Oo0 = jSONObject.optLong("expire_time");
            }
            if (!jSONObject.isNull("home_detail") && (optJSONObject = jSONObject.optJSONObject("home_detail")) != null) {
                if (!optJSONObject.isNull("name")) {
                    gha.O0000Oo = optJSONObject.optString("name");
                }
                if (!optJSONObject.isNull("longitude")) {
                    gha.O0000o00 = optJSONObject.optString("longitude");
                }
                if (!optJSONObject.isNull("latitude")) {
                    gha.O0000o0 = optJSONObject.optString("latitude");
                }
                if (!optJSONObject.isNull("city_id")) {
                    gha.O0000o0O = optJSONObject.optString("city_id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gha;
    }

    public static SparseArray<List<gha>> O000000o(JSONArray jSONArray, Set<Long> set) {
        SparseArray<List<gha>> sparseArray = new SparseArray<>();
        if (jSONArray == null) {
            return sparseArray;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                gha O000000o2 = O000000o(optJSONObject);
                List list = sparseArray.get(O000000o2.O0000O0o);
                if (list == null) {
                    list = new ArrayList();
                    sparseArray.put(O000000o2.O0000O0o, list);
                }
                list.add(O000000o2);
                set.add(Long.valueOf(O000000o2.O00000oO));
                set.add(Long.valueOf(O000000o2.O0000OoO));
            }
        }
        return sparseArray;
    }
}
