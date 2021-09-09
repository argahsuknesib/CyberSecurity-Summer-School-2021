package _m_j;

import _m_j.fui;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gts {
    private static gts O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f18269O000000o = false;
    public boolean O00000Oo = false;
    public ArrayList<O000000o> O00000o = new ArrayList<>();
    public boolean O00000o0 = false;
    long O00000oO;
    boolean O00000oo = false;
    public List<gtr> O0000O0o = new ArrayList();
    List<gtr> O0000OOo = new ArrayList();

    private gts() {
    }

    public static synchronized gts O000000o() {
        gts gts;
        synchronized (gts.class) {
            if (O0000Oo0 == null) {
                O0000Oo0 = new gts();
            }
            gts = O0000Oo0;
        }
        return gts;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18272O000000o;
        public List<String> O00000Oo;

        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tag", this.f18272O000000o == null ? "" : this.f18272O000000o);
                JSONArray jSONArray = new JSONArray();
                if (this.O00000Oo != null) {
                    for (String put : this.O00000Oo) {
                        jSONArray.put(put);
                    }
                }
                jSONObject.put("gridDids", jSONArray);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public final void O000000o(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f18272O000000o = jSONObject.optString("tag");
                this.O00000Oo = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("gridDids");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            this.O00000Oo.add(optString);
                        }
                    }
                }
            }
        }
    }

    public final synchronized void O000000o(String str, List<String> list) {
        if (str == null) {
            str = "";
        }
        if (this.O00000o == null) {
            this.O00000o = new ArrayList<>();
        }
        Iterator<O000000o> it = this.O00000o.iterator();
        while (it.hasNext()) {
            O000000o next = it.next();
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(next.f18272O000000o)) {
                next.O00000Oo = list;
                return;
            } else if (str.equals(next.f18272O000000o)) {
                next.O00000Oo = list;
                return;
            }
        }
        O000000o o000000o = new O000000o();
        o000000o.f18272O000000o = str;
        o000000o.O00000Oo = list;
        this.O00000o.add(o000000o);
    }

    private static ArrayList<O000000o> O000000o(JSONArray jSONArray) {
        gsy.O000000o(3, "LiteDeviceManager", "parseGridTagsFromJSONArray:" + jSONArray.toString());
        ArrayList<O000000o> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        if (length == 0) {
            return arrayList;
        }
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                O000000o o000000o = new O000000o();
                o000000o.O000000o(optJSONObject);
                arrayList.add(o000000o);
            }
        }
        return arrayList;
    }

    public final ArrayList<O000000o> O000000o(fui fui) {
        gsy.O000000o(3, "LiteDeviceManager", "handleUserConfigData");
        ArrayList<O000000o> arrayList = new ArrayList<>();
        if (fui == null || fui.O00000o0 == null) {
            return arrayList;
        }
        ArrayList<O000000o> arrayList2 = arrayList;
        for (int i = 0; i < fui.O00000o0.size(); i++) {
            fui.O000000o o000000o = fui.O00000o0.get(i);
            if (!TextUtils.isEmpty(o000000o.f17182O000000o) && !TextUtils.isEmpty(o000000o.O00000Oo)) {
                if ("grid_tag_info".equals(o000000o.f17182O000000o)) {
                    try {
                        arrayList2 = O000000o(new JSONArray(o000000o.O00000Oo));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if ("timestamp".equals(o000000o.f17182O000000o)) {
                    try {
                        long longValue = Long.getLong(o000000o.O00000Oo).longValue();
                        this.O00000oo = longValue != this.O00000oO;
                        this.O00000oO = longValue;
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return arrayList2;
    }

    public static fui O000000o(ArrayList<O000000o> arrayList) {
        fui fui = new fui();
        fui.f17181O000000o = 0;
        fui.O00000Oo = "5";
        fui.O00000o0 = new ArrayList<>();
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            Iterator<O000000o> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().O000000o());
            }
        }
        fui.O00000o0.add(new fui.O000000o("grid_tag_info", jSONArray.toString()));
        fui.O00000o0.add(new fui.O000000o("timestamp", String.valueOf(System.currentTimeMillis() / 1000)));
        return fui;
    }
}
