package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.scene.ConstantType;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hqs {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f529O000000o;
    public long O00000Oo = 0;
    public String O00000o;
    public String O00000o0;
    public int O00000oO;
    public String O00000oo;
    public boolean O0000O0o;
    public boolean O0000OOo;
    public hoi O0000Oo;
    public boolean O0000Oo0;
    public ArrayList<O00000o0> O0000OoO = new ArrayList<>();
    public int O0000Ooo;
    public int O0000o0;
    public ArrayList<O0000Oo0> O0000o00 = new ArrayList<>();
    public ArrayList<O000000o> O0000o0O = new ArrayList<>();
    public JSONObject O0000o0o = null;

    public final boolean equals(Object obj) {
        ArrayList<O000000o> arrayList;
        ArrayList<O000000o> arrayList2;
        ArrayList<O000000o> arrayList3;
        ArrayList<O0000Oo0> arrayList4;
        ArrayList<O0000Oo0> arrayList5;
        ArrayList<O0000Oo0> arrayList6;
        ArrayList<O00000o0> arrayList7;
        ArrayList<O00000o0> arrayList8;
        ArrayList<O00000o0> arrayList9;
        hoi hoi;
        if (obj == null || !(obj instanceof hqs)) {
            return false;
        }
        hqs hqs = (hqs) obj;
        if (hqs.O0000Oo0 != this.O0000Oo0 || hqs.f529O000000o != this.f529O000000o || hqs.O00000Oo != this.O00000Oo || !TextUtils.equals(this.O00000o, hqs.O00000o) || this.O0000O0o != hqs.O0000O0o || this.O0000OOo != hqs.O0000OOo || (this.O0000Oo == null && hqs.O0000Oo != null)) {
            return false;
        }
        if (this.O0000Oo != null && hqs.O0000Oo == null) {
            return false;
        }
        hoi hoi2 = this.O0000Oo;
        if ((hoi2 == null || (hoi = hqs.O0000Oo) == null || hoi2.equals(hoi)) && this.O0000Ooo == hqs.O0000Ooo && this.O0000o0 == hqs.O0000o0) {
            ArrayList<O00000o0> arrayList10 = this.O0000OoO;
            if (arrayList10 != null && arrayList10.size() > 0 && ((arrayList9 = hqs.O0000OoO) == null || arrayList9.size() == 0)) {
                return false;
            }
            ArrayList<O00000o0> arrayList11 = hqs.O0000OoO;
            if (arrayList11 != null && arrayList11.size() > 0 && ((arrayList8 = this.O0000OoO) == null || arrayList8.size() == 0)) {
                return false;
            }
            ArrayList<O00000o0> arrayList12 = hqs.O0000OoO;
            if (arrayList12 != null && arrayList12.size() > 0 && (arrayList7 = this.O0000OoO) != null && arrayList7.size() > 0 && !hqs.O0000OoO.equals(this.O0000OoO)) {
                return false;
            }
            ArrayList<O0000Oo0> arrayList13 = this.O0000o00;
            if (arrayList13 != null && arrayList13.size() > 0 && ((arrayList6 = hqs.O0000o00) == null || arrayList6.size() == 0)) {
                return false;
            }
            ArrayList<O0000Oo0> arrayList14 = hqs.O0000o00;
            if (arrayList14 != null && arrayList14.size() > 0 && ((arrayList5 = this.O0000o00) == null || arrayList5.size() == 0)) {
                return false;
            }
            ArrayList<O0000Oo0> arrayList15 = hqs.O0000o00;
            if (arrayList15 != null && arrayList15.size() > 0 && (arrayList4 = this.O0000o00) != null && arrayList4.size() > 0 && !hqs.O0000o00.equals(this.O0000o00)) {
                return false;
            }
            ArrayList<O000000o> arrayList16 = this.O0000o0O;
            if (arrayList16 != null && arrayList16.size() > 0 && ((arrayList3 = hqs.O0000o0O) == null || arrayList3.size() == 0)) {
                return false;
            }
            ArrayList<O000000o> arrayList17 = hqs.O0000o0O;
            if (arrayList17 != null && arrayList17.size() > 0 && ((arrayList2 = this.O0000o0O) == null || arrayList2.size() == 0)) {
                return false;
            }
            ArrayList<O000000o> arrayList18 = hqs.O0000o0O;
            if (arrayList18 == null || arrayList18.size() <= 0 || (arrayList = this.O0000o0O) == null || arrayList.size() <= 0 || hqs.O0000o0O.equals(this.O0000o0O)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static hqs O000000o(JSONObject jSONObject) {
        JSONArray optJSONArray;
        O0000Oo0 o0000Oo0;
        O00000o0 o00000o0;
        JSONObject jSONObject2 = jSONObject;
        hqs hqs = new hqs();
        if (jSONObject2 != null) {
            try {
                String optString = jSONObject2.optString("scene_id");
                if (!TextUtils.isEmpty(optString)) {
                    hqs.f529O000000o = Long.parseLong(optString);
                }
                String optString2 = jSONObject2.optString("template_id");
                if (!TextUtils.isEmpty(optString2)) {
                    hqs.O00000Oo = Long.parseLong(optString2);
                }
                hqs.O00000o0 = jSONObject2.optString("home_id");
                hqs.O00000o = jSONObject2.optString("name");
                hqs.O0000OOo = jSONObject2.optBoolean("enable_push");
                hqs.O0000Oo0 = jSONObject2.optBoolean("common_use");
                hqs.O0000O0o = jSONObject2.optBoolean("enable");
                hqs.O0000Oo = hoi.O000000o(jSONObject2.optJSONObject("timespan"));
                JSONObject optJSONObject = jSONObject2.optJSONObject("scene_condition");
                if (optJSONObject != null) {
                    if (optJSONObject.keys().hasNext()) {
                        hqs.O0000Ooo = optJSONObject.optInt("express");
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("conditions");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            for (int i = 0; i < optJSONArray2.length(); i++) {
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i);
                                if (optJSONObject2 == null) {
                                    o00000o0 = null;
                                } else {
                                    o00000o0 = new O00000o0();
                                    o00000o0.f536O000000o = optJSONObject2.optInt("id");
                                    o00000o0.O00000Oo = optJSONObject2.optString("src");
                                    o00000o0.O00000o0 = optJSONObject2.optString("name");
                                    o00000o0.O00000o = optJSONObject2.optString("key");
                                    o00000o0.O00000oo = optJSONObject2.optInt("value_type");
                                    o00000o0.O00000oO = optJSONObject2.optString("value_json");
                                    o00000o0.O0000O0o = O0000O0o.O000000o(optJSONObject2.opt("extra_json"), o00000o0.O00000Oo);
                                }
                                if (o00000o0 != null) {
                                    hqs.O0000OoO.add(o00000o0);
                                }
                            }
                        }
                    }
                }
                JSONObject optJSONObject3 = jSONObject2.optJSONObject("scene_trigger");
                if (optJSONObject3 != null && optJSONObject3.keys().hasNext()) {
                    hqs.O0000o0 = optJSONObject3.optInt("express");
                    JSONArray optJSONArray3 = optJSONObject3.optJSONArray("triggers");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                            JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i2);
                            if (optJSONObject4 == null) {
                                o0000Oo0 = null;
                            } else {
                                o0000Oo0 = new O0000Oo0();
                                o0000Oo0.f538O000000o = optJSONObject4.optInt("id");
                                o0000Oo0.O00000Oo = optJSONObject4.optString("src");
                                o0000Oo0.O00000o0 = optJSONObject4.optString("name");
                                o0000Oo0.O00000oo = optJSONObject4.optString("key");
                                o0000Oo0.O00000o = optJSONObject4.opt("value_json");
                                o0000Oo0.O00000oO = optJSONObject4.optInt("value_type");
                                o0000Oo0.O0000O0o = O0000O0o.O000000o(optJSONObject4.opt("extra_json"), o0000Oo0.O00000Oo);
                            }
                            if (o0000Oo0 != null) {
                                hqs.O0000o00.add(o0000Oo0);
                            }
                        }
                    }
                }
                JSONObject optJSONObject5 = jSONObject2.optJSONObject("scene_action");
                if (optJSONObject5 != null && optJSONObject5.keys().hasNext() && (optJSONArray = optJSONObject5.optJSONArray("actions")) != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        O000000o O000000o2 = O000000o.O000000o(optJSONArray.optJSONObject(i3));
                        if (O000000o2 != null) {
                            hqs.O0000o0O.add(O000000o2);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hqs;
    }

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f529O000000o > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f529O000000o);
                jSONObject.put("scene_id", sb.toString());
            }
            if (this.O00000Oo > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.O00000Oo);
                jSONObject.put("template_id", sb2.toString());
            }
            if (!TextUtils.isEmpty(this.O00000o0)) {
                jSONObject.put("home_id", this.O00000o0);
            }
            if (!TextUtils.isEmpty(this.O00000o)) {
                jSONObject.put("scene_name", this.O00000o);
            }
            jSONObject.put("enable_push", this.O0000OOo);
            jSONObject.put("common_use", this.O0000Oo0);
            jSONObject.put("enable", this.O0000O0o);
            if (this.O0000Oo != null) {
                jSONObject.put("timespan", this.O0000Oo.O000000o());
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("express", this.O0000Ooo);
            if (this.O0000OoO != null && this.O0000OoO.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.O0000OoO.size(); i++) {
                    jSONArray.put(this.O0000OoO.get(i).O000000o(i));
                }
                jSONObject2.put("conditions", jSONArray);
            }
            jSONObject.put("scene_condition", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("express", this.O0000o0);
            if (this.O0000o00 != null && this.O0000o00.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < this.O0000o00.size(); i2++) {
                    jSONArray2.put(this.O0000o00.get(i2).O000000o(i2));
                }
                jSONObject3.put("triggers", jSONArray2);
            }
            jSONObject.put("scene_trigger", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("mode", 1);
            if (this.O0000o0O != null && this.O0000o0O.size() > 0) {
                JSONArray jSONArray3 = new JSONArray();
                for (int i3 = 0; i3 < this.O0000o0O.size(); i3++) {
                    jSONArray3.put(this.O0000o0O.get(i3).O000000o(i3));
                }
                jSONObject4.put("actions", jSONArray3);
            }
            jSONObject.put("scene_action", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f536O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public Object O00000oO;
        public int O00000oo;
        public O0000O0o O0000O0o;

        public final boolean equals(Object obj) {
            O0000O0o o0000O0o;
            if (obj == null || !(obj instanceof O00000o0)) {
                return false;
            }
            O00000o0 o00000o0 = (O00000o0) obj;
            if (this.f536O000000o != o00000o0.f536O000000o || !TextUtils.equals(this.O00000Oo, o00000o0.O00000Oo) || !TextUtils.equals(this.O00000o, o00000o0.O00000o)) {
                return false;
            }
            if (this.O0000O0o != null && o00000o0.O0000O0o == null) {
                return false;
            }
            if (this.O0000O0o == null && o00000o0.O0000O0o != null) {
                return false;
            }
            O0000O0o o0000O0o2 = this.O0000O0o;
            if ((o0000O0o2 == null || (o0000O0o = o00000o0.O0000O0o) == null || o0000O0o2.equals(o0000O0o)) && this.O00000oo == o00000o0.O00000oo) {
                return true;
            }
            return false;
        }

        public final JSONObject O000000o(int i) {
            JSONObject O000000o2;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f536O000000o);
                jSONObject.put("order", i + 1);
                jSONObject.put("src", this.O00000Oo);
                jSONObject.put("name", this.O00000o0);
                jSONObject.put("key", this.O00000o);
                if (this.O00000oO != null) {
                    jSONObject.put("value_json", this.O00000oO);
                }
                jSONObject.put("value_type", this.O00000oo);
                if (!(this.O0000O0o == null || (O000000o2 = this.O0000O0o.O000000o()) == null)) {
                    jSONObject.put("extra_json", O000000o2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static class O0000Oo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f538O000000o;
        public String O00000Oo;
        public Object O00000o;
        public String O00000o0;
        public int O00000oO;
        public String O00000oo;
        public O0000O0o O0000O0o;

        public final boolean equals(Object obj) {
            O0000O0o o0000O0o;
            if (obj == null || !(obj instanceof O0000Oo0)) {
                return false;
            }
            O0000Oo0 o0000Oo0 = (O0000Oo0) obj;
            if (this.f538O000000o != o0000Oo0.f538O000000o || !TextUtils.equals(this.O00000Oo, o0000Oo0.O00000Oo) || !TextUtils.equals(this.O00000oo, o0000Oo0.O00000oo)) {
                return false;
            }
            if (this.O0000O0o != null && o0000Oo0.O0000O0o == null) {
                return false;
            }
            if (this.O0000O0o == null && o0000Oo0.O0000O0o != null) {
                return false;
            }
            O0000O0o o0000O0o2 = this.O0000O0o;
            if ((o0000O0o2 == null || (o0000O0o = o0000Oo0.O0000O0o) == null || o0000O0o2.equals(o0000O0o)) && this.O00000oO == o0000Oo0.O00000oO) {
                return true;
            }
            return false;
        }

        public final JSONObject O000000o(int i) {
            JSONObject O000000o2;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f538O000000o);
                jSONObject.put("order", i + 1);
                jSONObject.put("src", this.O00000Oo);
                jSONObject.put("name", this.O00000o0);
                jSONObject.put("key", this.O00000oo);
                if (this.O00000o != null) {
                    jSONObject.put("value_json", this.O00000o);
                    jSONObject.put("value_type", this.O00000oO);
                } else {
                    jSONObject.put("value_type", 5);
                }
                if (!(this.O0000O0o == null || (O000000o2 = this.O0000O0o.O000000o()) == null)) {
                    jSONObject.put("extra_json", O000000o2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static abstract class O0000O0o {
        /* access modifiers changed from: package-private */
        public abstract JSONObject O000000o();

        O0000O0o() {
        }

        public static O0000O0o O000000o(Object obj, String str) {
            if (obj == null || !(obj instanceof JSONObject)) {
                return null;
            }
            JSONObject jSONObject = (JSONObject) obj;
            if (TextUtils.equals("cloud", str)) {
                return O00000Oo.O000000o(jSONObject);
            }
            if (TextUtils.equals("device", str)) {
                return O00000o.O000000o(jSONObject);
            }
            if (TextUtils.equals("user", str)) {
                return null;
            }
            if (TextUtils.equals("location", str)) {
                return O0000OOo.O000000o(jSONObject);
            }
            if (TextUtils.equals("timer", str)) {
            }
            return null;
        }
    }

    public static class O00000Oo extends O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f534O000000o;
        public String O00000Oo;
        public String O00000o0;

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof O00000Oo)) {
                return false;
            }
            O00000Oo o00000Oo = (O00000Oo) obj;
            if (!TextUtils.isEmpty(this.O00000o0)) {
                return TextUtils.equals(this.O00000o0, o00000Oo.O00000o0);
            }
            if (!TextUtils.isEmpty(o00000Oo.O00000o0)) {
                return TextUtils.equals(this.O00000o0, o00000Oo.O00000o0);
            }
            if (!TextUtils.equals(this.f534O000000o, o00000Oo.f534O000000o) || !TextUtils.equals(this.O00000Oo, o00000Oo.O00000Oo)) {
                return false;
            }
            return true;
        }

        private O00000Oo(String str, String str2) {
            this.f534O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = null;
        }

        public O00000Oo(String str) {
            this.O00000o0 = str;
            this.f534O000000o = null;
            this.O00000Oo = null;
        }

        /* access modifiers changed from: package-private */
        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                if (TextUtils.isEmpty(this.f534O000000o) || TextUtils.isEmpty(this.O00000Oo)) {
                    jSONObject.put("home_id", this.O00000o0);
                } else {
                    jSONObject.put("city_name", this.O00000Oo);
                    jSONObject.put("city_id", this.f534O000000o);
                }
                return jSONObject;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static O00000Oo O000000o(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            if (jSONObject.has("home_id")) {
                return new O00000Oo(jSONObject.optString("home_id"));
            }
            if (!jSONObject.has("city_id") || !jSONObject.has("city_name")) {
                return null;
            }
            return new O00000Oo(jSONObject.optString("city_id"), jSONObject.optString("city_name"));
        }
    }

    public static class O0000OOo extends O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public long f537O000000o;
        public String O00000Oo;
        public double O00000o = Double.NaN;
        public double O00000o0 = Double.NaN;
        public float O00000oO;
        public String O00000oo;

        public static O0000OOo O000000o(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            O0000OOo o0000OOo = new O0000OOo(jSONObject.optLong("po_id"), jSONObject.optString("home_id"), (float) jSONObject.optDouble("raduis"));
            o0000OOo.O00000oo = jSONObject.optString("platform");
            return o0000OOo;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof O0000OOo)) {
                return false;
            }
            O0000OOo o0000OOo = (O0000OOo) obj;
            if (!TextUtils.isEmpty(this.O00000Oo)) {
                if (!TextUtils.equals(this.O00000Oo, o0000OOo.O00000Oo) || this.O00000oO != o0000OOo.O00000oO) {
                    return false;
                }
                return true;
            } else if (!TextUtils.isEmpty(o0000OOo.O00000Oo)) {
                if (!TextUtils.equals(this.O00000Oo, o0000OOo.O00000Oo) || this.O00000oO != o0000OOo.O00000oO) {
                    return false;
                }
                return true;
            } else if (this.O00000o0 == o0000OOo.O00000o0 && this.O00000o == o0000OOo.O00000o && this.O00000oO == o0000OOo.O00000oO) {
                return true;
            } else {
                return false;
            }
        }

        public O0000OOo(long j, String str, float f) {
            this.f537O000000o = j;
            this.O00000Oo = str;
            this.O00000oO = f;
            this.O00000oo = "iOS";
        }

        /* access modifiers changed from: package-private */
        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("po_id", this.f537O000000o);
                if (!TextUtils.isEmpty(this.O00000Oo)) {
                    jSONObject.put("home_id", this.O00000Oo);
                } else if (!(this.O00000o0 == Double.NaN || this.O00000o == Double.NaN)) {
                    jSONObject.put("latitude", this.O00000o0);
                    jSONObject.put("longitude", this.O00000o);
                }
                jSONObject.put("raduis", (double) this.O00000oO);
                jSONObject.put("platform", this.O00000oo);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static class O00000o extends O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f535O000000o;
        public String O00000Oo;
        public String O00000o0;

        public static O00000o O000000o(JSONObject jSONObject) {
            if (jSONObject != null) {
                return new O00000o(jSONObject.optString("did"), jSONObject.optString("model"), jSONObject.optString("device_name"));
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof O00000o) && TextUtils.equals(this.f535O000000o, ((O00000o) obj).f535O000000o)) {
                return true;
            }
            return false;
        }

        public O00000o(String str, String str2, String str3) {
            this.f535O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = str3;
        }

        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.f535O000000o);
                jSONObject.put("model", this.O00000Oo);
                jSONObject.put("device_name", this.O00000o0);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f530O000000o;
        public int O00000Oo;
        public String O00000o;
        public ConstantType.PayloadType O00000o0;
        public C0002O000000o O00000oO;

        /* renamed from: _m_j.hqs$O000000o$O000000o  reason: collision with other inner class name */
        public static abstract class C0002O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            int f531O000000o;

            /* access modifiers changed from: package-private */
            public abstract JSONObject O000000o();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Failed to insert an additional move for type inference into block B:38:0x00d8 */
        /* JADX INFO: additional move instructions added (5) to help type inference */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: _m_j.hqs$O000000o$O00000o0} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: _m_j.hqs$O000000o$O00000o0} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: _m_j.hqs$O000000o$O00000Oo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: _m_j.hqs$O000000o$O00000o0} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: _m_j.hqs$O000000o$O00000o0} */
        /* JADX WARNING: Multi-variable type inference failed */
        public static O000000o O000000o(JSONObject jSONObject) {
            O00000o0 o00000o0 = null;
            if (jSONObject == null) {
                return null;
            }
            O000000o o000000o = new O000000o();
            o000000o.f530O000000o = jSONObject.optInt("id");
            o000000o.O00000Oo = jSONObject.optInt("group_id");
            o000000o.O00000o = jSONObject.optString("name");
            o000000o.O00000o0 = jSONObject.optInt("type") == 0 ? ConstantType.PayloadType.RPC : ConstantType.PayloadType.PUSH;
            Object opt = jSONObject.opt("payload_json");
            if (opt != null && (opt instanceof JSONObject)) {
                try {
                    JSONObject jSONObject2 = (JSONObject) opt;
                    int i = o000000o.O00000o0.type;
                    if (i == 0) {
                        o00000o0 = new O00000o0();
                        o00000o0.O00000Oo = jSONObject2.optString("did");
                        o00000o0.O00000o = jSONObject2.optInt("delay_time");
                        o00000o0.O00000oO = jSONObject2.optString("model");
                        o00000o0.O00000oo = jSONObject2.optString("device_name");
                        if (TextUtils.equals(ConstantType.RpcMethod.PROPERTY.method, jSONObject2.optString("command"))) {
                            o00000o0.O00000o0 = ConstantType.RpcMethod.PROPERTY;
                            JSONArray optJSONArray = jSONObject2.optJSONArray("value");
                            o00000o0 = o00000o0;
                            if (optJSONArray != null) {
                                o00000o0 = o00000o0;
                                if (optJSONArray.length() > 0) {
                                    o00000o0.O0000O0o = new ArrayList<>();
                                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                        o00000o0.O0000O0o.add(O00000o0.O00000Oo.O000000o(optJSONArray.optJSONObject(i2)));
                                    }
                                }
                            }
                        } else {
                            o00000o0.O00000o0 = ConstantType.RpcMethod.ACION;
                            JSONObject optJSONObject = jSONObject2.optJSONObject("value");
                            o00000o0 = o00000o0;
                            if (optJSONObject != null) {
                                o00000o0.O0000OOo = O00000o0.C0003O000000o.O000000o(optJSONObject);
                                o00000o0 = o00000o0;
                            }
                        }
                    } else if (i == 1) {
                        O00000Oo o00000Oo = new O00000Oo();
                        o00000Oo.f531O000000o = jSONObject2.optInt("delay_time");
                        o00000Oo.O00000Oo = jSONObject2.optString("desc");
                        o00000Oo.O00000o0 = jSONObject2.optString("title");
                        o00000o0 = o00000Oo;
                    }
                    o000000o.O00000oO = o00000o0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return o000000o;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof O000000o)) {
                return false;
            }
            O000000o o000000o = (O000000o) obj;
            if (o000000o.f530O000000o == this.f530O000000o && o000000o.O00000Oo == this.O00000Oo && this.O00000o0 == o000000o.O00000o0 && this.O00000oO.equals(o000000o.O00000oO)) {
                return true;
            }
            return false;
        }

        public final JSONObject O000000o(int i) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f530O000000o);
                jSONObject.put("order", i + 1);
                jSONObject.put("group_id", this.O00000Oo);
                if (this.O00000o0 != null) {
                    jSONObject.put("type", this.O00000o0.type);
                }
                if (this.O00000oO != null) {
                    jSONObject.put("payload_json", this.O00000oO.O000000o());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        public static class O00000o0 extends C0002O000000o {
            public String O00000Oo;
            public int O00000o;
            public ConstantType.RpcMethod O00000o0;
            public String O00000oO;
            public String O00000oo;
            public ArrayList<O00000Oo> O0000O0o;
            public C0003O000000o O0000OOo;

            /* access modifiers changed from: package-private */
            public final JSONObject O000000o() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("did", this.O00000Oo);
                    if (this.O00000o0 != null) {
                        jSONObject.put("command", this.O00000o0.method);
                    }
                    jSONObject.put("delay_time", this.O00000o);
                    jSONObject.put("model", this.O00000oO);
                    jSONObject.put("device_name", this.O00000oo);
                    if (this.O0000OOo != null) {
                        if (this.O0000OOo.O000000o().keys().hasNext()) {
                            jSONObject.put("value", this.O0000OOo.O000000o());
                        }
                    } else if (this.O0000O0o != null && this.O0000O0o.size() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (int i = 0; i < this.O0000O0o.size(); i++) {
                            jSONArray.put(this.O0000O0o.get(i).O000000o());
                        }
                        jSONObject.put("value", jSONArray);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return jSONObject;
            }

            public final boolean equals(Object obj) {
                ArrayList<O00000Oo> arrayList;
                C0003O000000o o000000o;
                if (obj == null || !(obj instanceof O00000o0)) {
                    return false;
                }
                O00000o0 o00000o0 = (O00000o0) obj;
                if (!TextUtils.equals(o00000o0.O00000Oo, this.O00000Oo) || o00000o0.O00000o0 != this.O00000o0) {
                    return false;
                }
                if (this.O0000OOo == null && o00000o0.O0000OOo != null) {
                    return false;
                }
                if (this.O0000OOo != null && o00000o0.O0000OOo == null) {
                    return false;
                }
                C0003O000000o o000000o2 = this.O0000OOo;
                if (o000000o2 != null && (o000000o = o00000o0.O0000OOo) != null && !o000000o2.equals(o000000o)) {
                    return false;
                }
                ArrayList<O00000Oo> arrayList2 = this.O0000O0o;
                if (arrayList2 != null && arrayList2.size() > 0 && ((arrayList = o00000o0.O0000O0o) == null || arrayList.size() == 0)) {
                    return false;
                }
                if (o00000o0.O0000O0o == null || this.O0000O0o.size() <= 0) {
                    return true;
                }
                ArrayList<O00000Oo> arrayList3 = this.O0000O0o;
                if (arrayList3 == null || arrayList3.size() == 0) {
                    return false;
                }
                return true;
            }

            public static class O00000Oo {

                /* renamed from: O000000o  reason: collision with root package name */
                public String f533O000000o;
                public int O00000Oo;
                public Object O00000o;
                public int O00000o0;

                public final boolean equals(Object obj) {
                    int i;
                    if (obj == null || !(obj instanceof O00000Oo)) {
                        return false;
                    }
                    O00000Oo o00000Oo = (O00000Oo) obj;
                    if (TextUtils.equals(o00000Oo.f533O000000o, this.f533O000000o) && (i = o00000Oo.O00000Oo) == i && o00000Oo.O00000o0 == this.O00000o0) {
                        return this.O00000o.equals(o00000Oo.O00000o);
                    }
                    return false;
                }

                public O00000Oo(String str, int i, int i2, Object obj) {
                    this.f533O000000o = str;
                    this.O00000Oo = i;
                    this.O00000o0 = i2;
                    this.O00000o = obj;
                }

                public static O00000Oo O000000o(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        return new O00000Oo(jSONObject.optString("did"), jSONObject.optInt("siid"), jSONObject.optInt("piid"), jSONObject.opt("value"));
                    }
                    return null;
                }

                public final JSONObject O000000o() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("did", this.f533O000000o);
                        jSONObject.put("siid", this.O00000Oo);
                        jSONObject.put("piid", this.O00000o0);
                        jSONObject.put("value", this.O00000o);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return jSONObject;
                }
            }

            /* renamed from: _m_j.hqs$O000000o$O00000o0$O000000o  reason: collision with other inner class name */
            public static class C0003O000000o {

                /* renamed from: O000000o  reason: collision with root package name */
                public String f532O000000o;
                public int O00000Oo;
                public ArrayList<O00000Oo> O00000o = new ArrayList<>();
                public int O00000o0;

                public final boolean equals(Object obj) {
                    ArrayList<O00000Oo> arrayList;
                    ArrayList<O00000Oo> arrayList2;
                    ArrayList<O00000Oo> arrayList3;
                    if (obj == null || !(obj instanceof C0003O000000o)) {
                        return false;
                    }
                    C0003O000000o o000000o = (C0003O000000o) obj;
                    if (!TextUtils.equals(this.f532O000000o, o000000o.f532O000000o) || this.O00000Oo != o000000o.O00000Oo || this.O00000o0 != o000000o.O00000o0) {
                        return false;
                    }
                    if (this.O00000o != null && o000000o.O00000o.size() > 0 && ((arrayList3 = o000000o.O00000o) == null || arrayList3.size() == 0)) {
                        return false;
                    }
                    if (o000000o.O00000o != null && this.O00000o.size() > 0 && ((arrayList2 = this.O00000o) == null || arrayList2.size() == 0)) {
                        return false;
                    }
                    ArrayList<O00000Oo> arrayList4 = this.O00000o;
                    if (arrayList4 == null || (arrayList = o000000o.O00000o) == null) {
                        return true;
                    }
                    return arrayList4.equals(arrayList);
                }

                public static C0003O000000o O000000o(JSONObject jSONObject) {
                    C0003O000000o o000000o = new C0003O000000o();
                    if (jSONObject != null) {
                        o000000o.f532O000000o = jSONObject.optString("did");
                        o000000o.O00000Oo = jSONObject.optInt("siid");
                        o000000o.O00000o0 = jSONObject.optInt("aiid");
                        JSONArray optJSONArray = jSONObject.optJSONArray("in");
                        o000000o.O00000o = new ArrayList<>();
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                o000000o.O00000o.add(O00000Oo.O000000o(optJSONArray.optJSONObject(i)));
                            }
                        }
                    }
                    return o000000o;
                }

                public final JSONObject O000000o() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("did", this.f532O000000o);
                        jSONObject.put("siid", this.O00000Oo);
                        jSONObject.put("aiid", this.O00000o0);
                        JSONArray jSONArray = new JSONArray();
                        if (this.O00000o != null && this.O00000o.size() > 0) {
                            for (int i = 0; i < this.O00000o.size(); i++) {
                                jSONArray.put(this.O00000o.get(i).O000000o());
                            }
                        }
                        jSONObject.put("in", jSONArray);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return jSONObject;
                }
            }
        }

        public static class O00000Oo extends C0002O000000o {
            public String O00000Oo;
            public String O00000o0;

            /* access modifiers changed from: package-private */
            public final JSONObject O000000o() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("delay_time", this.f531O000000o);
                    jSONObject.put("desc", this.O00000Oo);
                    jSONObject.put("title", this.O00000o0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return jSONObject;
            }

            public final boolean equals(Object obj) {
                if (obj == null || !(obj instanceof O00000Oo)) {
                    return false;
                }
                O00000Oo o00000Oo = (O00000Oo) obj;
                if (!TextUtils.equals(this.O00000Oo, o00000Oo.O00000Oo) || !TextUtils.equals(this.O00000Oo, o00000Oo.O00000o0)) {
                    return false;
                }
                return true;
            }
        }
    }
}
