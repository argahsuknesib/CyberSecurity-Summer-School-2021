package _m_j;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hdc {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<O000000o> f18807O000000o;
    public List<Object> O00000Oo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18808O000000o;
        public int O00000Oo;
        public String O00000o0;

        public O000000o(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                char c = 65535;
                int hashCode = next.hashCode();
                if (hashCode != 106079) {
                    if (hashCode != 3575610) {
                        if (hashCode == 100346066 && next.equals("index")) {
                            c = 1;
                        }
                    } else if (next.equals("type")) {
                        c = 2;
                    }
                } else if (next.equals("key")) {
                    c = 0;
                }
                if (c == 0) {
                    this.f18808O000000o = jSONObject.optString(next);
                } else if (c == 1) {
                    this.O00000Oo = jSONObject.optInt("index");
                } else if (c == 2) {
                    this.O00000o0 = jSONObject.optString("type");
                }
            }
        }
    }

    public hdc(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray != null) {
            this.O00000Oo = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.O00000Oo.add(jSONArray.opt(i));
            }
        }
        if (jSONArray2 != null) {
            this.f18807O000000o = new ArrayList();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                this.f18807O000000o.add(new O000000o(jSONArray2.optJSONObject(i2)));
            }
        }
    }

    public final Object O000000o(Object obj) {
        List<Object> list = this.O00000Oo;
        if (list != null && list.size() > 0) {
            List<O000000o> list2 = this.f18807O000000o;
            if (list2 != null && list2.size() != 0) {
                return O000000o(obj, this.O00000Oo);
            }
            JSONArray jSONArray = new JSONArray();
            for (Object put : this.O00000Oo) {
                jSONArray.put(put);
            }
            return jSONArray;
        } else if (obj != null) {
            return O000000o(obj, (List<Object>) null);
        } else {
            return new JSONArray().toString();
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:80:0x0102 */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: org.json.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v36, resolved type: org.json.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v37, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v40, resolved type: org.json.JSONArray} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final Object O000000o(Object obj, List<Object> list) {
        JSONArray jSONArray;
        List<O000000o> list2 = this.f18807O000000o;
        if (list2 == null || list2.size() == 0) {
            return obj;
        }
        int i = null;
        for (int size = this.f18807O000000o.size() - 1; size >= 0; size--) {
            if (this.f18807O000000o.get(size).O00000o0 != null) {
                if (this.f18807O000000o.get(size).O00000o0.equalsIgnoreCase("int")) {
                    if (!(obj instanceof Integer)) {
                        try {
                            i = Integer.valueOf(Math.round((float) Double.parseDouble(String.valueOf(obj))));
                        } catch (Exception e) {
                            Log.e("Param", "error", e);
                            i = 0;
                        }
                    }
                } else if (!this.f18807O000000o.get(size).O00000o0.equalsIgnoreCase("long")) {
                    if (this.f18807O000000o.get(size).O00000o0.equalsIgnoreCase("double")) {
                        if (!(obj instanceof Number)) {
                            try {
                                i = Double.valueOf(Double.parseDouble(String.valueOf(obj)));
                            } catch (Exception e2) {
                                Log.e("Param", "error", e2);
                                i = 0;
                            }
                        }
                    } else if (this.f18807O000000o.get(size).O00000o0.equalsIgnoreCase("string")) {
                        i = String.valueOf(obj);
                    } else {
                        if (this.f18807O000000o.get(size).O00000o0.equalsIgnoreCase("JSONObject")) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(this.f18807O000000o.get(size).f18808O000000o, i);
                                jSONArray = jSONObject;
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        } else if (this.f18807O000000o.get(size).O00000o0.equalsIgnoreCase("JSONArray")) {
                            jSONArray = new JSONArray();
                            if (list != null) {
                                try {
                                    if (list.size() != 0) {
                                        for (Object next : list) {
                                            if (this.f18807O000000o.get(size).O00000Oo == jSONArray.length()) {
                                                jSONArray.put(this.f18807O000000o.get(size).O00000Oo, i);
                                            }
                                            jSONArray.put(next);
                                        }
                                    }
                                } catch (JSONException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            jSONArray.put(this.f18807O000000o.get(size).O00000Oo, i);
                            jSONArray = jSONArray;
                        }
                        i = jSONArray;
                    }
                } else if (!(obj instanceof Long) && !(obj instanceof Integer)) {
                    try {
                        i = Long.valueOf(Math.round(Double.parseDouble(String.valueOf(obj))));
                    } catch (Exception e5) {
                        Log.e("Param", "error", e5);
                        i = 0;
                    }
                }
            }
            i = obj;
        }
        return i;
    }

    public static Object O000000o(O000000o o000000o, Object obj) {
        if (o000000o.O00000o0 == null || obj == null || obj.toString().equalsIgnoreCase("null")) {
            return null;
        }
        if (o000000o.O00000o0.equalsIgnoreCase("JSONObject")) {
            try {
                return new JSONObject(obj.toString()).opt(o000000o.f18808O000000o);
            } catch (JSONException e) {
                Log.e("Param", "error", e);
            }
        } else {
            if (o000000o.O00000o0.equalsIgnoreCase("JSONArray")) {
                try {
                    return new JSONArray(obj.toString()).opt(o000000o.O00000Oo);
                } catch (JSONException e2) {
                    Log.w("Param", "error", e2);
                }
            }
            return obj;
        }
    }
}
