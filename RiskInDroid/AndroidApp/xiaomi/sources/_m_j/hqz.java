package _m_j;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hqz extends hra {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f541O000000o;
    public List<hrc> O00000Oo = new ArrayList();
    private List<hrc> O0000O0o = new ArrayList();

    public final int O00000o() {
        return 0;
    }

    public final Object O00000o0() {
        return null;
    }

    public hqz(String str, int i, int i2, List<hrc> list) {
        super(str, i);
        this.f541O000000o = i2;
        this.O00000Oo = list;
        this.O0000O0o = null;
        for (int i3 = 0; i3 < list.size(); i3++) {
            gsy.O00000Oo("RecScene", list.get(i3).O00000oo == null ? "" : list.get(i3).O00000oo);
        }
    }

    public hqz(int i) {
        super(null, i);
    }

    public static hqz O000000o(JSONObject jSONObject) {
        hqz hqz;
        int i;
        if (jSONObject.has("siid")) {
            hqz = new hqz(jSONObject.optInt("siid"));
        } else {
            hqz = new hqz(-1);
        }
        if (jSONObject.has("aiid")) {
            hqz.f541O000000o = jSONObject.optInt("aiid");
        } else {
            hqz.f541O000000o = -1;
        }
        if (jSONObject.has("in")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("in");
            int i2 = 0;
            while (true) {
                if (optJSONArray == null) {
                    i = 0;
                } else {
                    i = optJSONArray.length();
                }
                if (i2 >= i) {
                    break;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    hqz.O00000Oo.add(hrc.O000000o(optJSONObject));
                }
                i2++;
            }
        }
        return hqz;
    }

    public final JSONObject O00000Oo() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.O00000o != -1) {
                jSONObject.put("siid", this.O00000o);
            }
            if (this.f541O000000o != -1) {
                jSONObject.put("aiid", this.f541O000000o);
            }
            if (this.O00000Oo != null && this.O00000Oo.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.O00000Oo.size(); i++) {
                    jSONArray.put(this.O00000Oo.get(i).O00000Oo());
                }
                jSONObject.put("in", jSONArray);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
