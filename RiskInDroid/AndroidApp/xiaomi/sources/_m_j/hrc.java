package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hrc extends hra {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f543O000000o;
    public int O00000Oo;
    public Object O0000O0o;
    public Object O0000OOo;
    private int O0000Oo;
    private String O0000Oo0;
    private List<O000000o> O0000OoO = new ArrayList();

    public hrc(String str, String str2, int i, int i2, int i3, Object obj) {
        super(str, i);
        SpecDevice specDevice;
        SpecService specService;
        this.O0000Oo0 = str2;
        this.f543O000000o = i2;
        this.O00000Oo = i3;
        this.O0000O0o = obj;
        try {
            Device O000000o2 = fno.O000000o().O000000o(this.O00000o0);
            String str3 = null;
            if (O000000o2 == null) {
                specDevice = null;
            } else {
                specDevice = faw.O000000o().getSpecInstance(O000000o2);
            }
            if (!(specDevice == null || specDevice.getServices() == null || (specService = specDevice.getServices().get(Integer.valueOf(this.O00000o))) == null)) {
                String description = specService.getDescription();
                if (!TextUtils.isEmpty(description)) {
                    this.O00000oO = description.toLowerCase().replaceAll("\\s", "").toLowerCase();
                }
                SpecProperty specProperty = specService.getProperties().get(Integer.valueOf(this.f543O000000o));
                str3 = specProperty != null ? hor.O000000o().getSpecValue(O000000o2, specProperty, null, null) : str3;
                if (!TextUtils.isEmpty(str3)) {
                    gsy.O00000Oo("RecScene", O000000o2.name + "---+" + description + "found in cardtype " + str3);
                } else {
                    String description2 = specProperty.getDescription();
                    if (TextUtils.isEmpty(str3)) {
                        str3 = description2.toLowerCase().replace("service", "");
                        gsy.O00000o0(LogType.SCENE, "multiname", O000000o2.name + "+++" + description + "can not show config");
                    }
                }
            }
            this.O00000oo = str3;
        } catch (Exception unused) {
            gsy.O00000o0(LogType.SCENE, "recScene", "getdisplayname fail");
        }
    }

    public final void O000000o(int i, List<O000000o> list) {
        this.O0000Oo = i;
        this.O0000OoO = list;
    }

    public final String O000000o() {
        return this.O0000Oo0 + "." + this.O00000o + "." + this.f543O000000o;
    }

    public final Object O00000o0() {
        return this.O0000O0o;
    }

    public final String O00000oO() {
        return this.O00000oo;
    }

    public final int O00000o() {
        return this.O00000Oo;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public Object f544O000000o;
        public String O00000Oo;
        private int O00000o;
        private Object O00000o0;
        private int O00000oO;
        private int O00000oo;

        public O000000o(Object obj, int i, int i2, int i3) {
            this.O00000o0 = obj;
            this.O00000o = i;
            this.O00000oO = i2;
            this.O00000oo = i3;
        }

        public O000000o(int i, int i2, int i3, Object obj) {
            this.O00000o = i;
            this.O00000oO = i2;
            this.O00000oo = i3;
            if (obj != null) {
                try {
                    this.O00000o0 = obj;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private O000000o() {
        }

        public static O000000o O000000o(JSONObject jSONObject) {
            O000000o o000000o = new O000000o();
            if (jSONObject.has("siid")) {
                o000000o.O00000oO = jSONObject.optInt("siid");
            } else {
                o000000o.O00000oO = -1;
            }
            if (jSONObject.has("piid")) {
                o000000o.O00000oo = jSONObject.optInt("piid");
            } else {
                o000000o.O00000oo = -1;
            }
            o000000o.O00000Oo = jSONObject.optString("key");
            o000000o.f544O000000o = jSONObject.opt("value");
            return o000000o;
        }

        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.O00000oO != -1) {
                    jSONObject.put("siid", this.O00000oO);
                }
                if (this.O00000oo != -1) {
                    jSONObject.put("piid", this.O00000oo);
                }
                if (!TextUtils.isEmpty(this.O00000Oo)) {
                    jSONObject.put("key", this.O00000Oo);
                }
                if (this.f544O000000o != null) {
                    jSONObject.put("value", this.f544O000000o);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    private hrc(int i) {
        super(null, i);
    }

    public static hrc O000000o(JSONObject jSONObject) {
        hrc hrc;
        int i;
        if (jSONObject.has("siid")) {
            hrc = new hrc(jSONObject.optInt("siid"));
        } else {
            hrc = new hrc(-1);
        }
        if (jSONObject.has("piid")) {
            hrc.f543O000000o = jSONObject.optInt("piid");
        } else {
            hrc.f543O000000o = -1;
        }
        if (jSONObject.has("value")) {
            hrc.O0000OOo = jSONObject.opt("value");
        }
        if (jSONObject.has("sub_props")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("sub_props");
            if (optJSONObject.has("express")) {
                hrc.O0000Oo = optJSONObject.optInt("express");
            } else {
                hrc.O0000Oo = -1;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("attr");
            ArrayList arrayList = new ArrayList();
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
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                if (optJSONObject2 != null) {
                    arrayList.add(O000000o.O000000o(optJSONObject2));
                }
                i2++;
            }
            int i3 = hrc.O0000Oo;
            if (i3 != -1) {
                hrc.O000000o(i3, arrayList);
            }
        }
        return hrc;
    }

    public final JSONObject O00000Oo() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.O00000o != -1) {
                jSONObject.put("siid", this.O00000o);
            }
            if (this.f543O000000o != -1) {
                jSONObject.put("piid", this.f543O000000o);
            }
            if (this.O0000OOo != null) {
                jSONObject.put("value", this.O0000OOo);
            }
            if (!(this.O0000Oo == -1 || this.O0000OoO == null || this.O0000OoO.size() <= 0)) {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.O0000OoO.size(); i++) {
                    jSONArray.put(this.O0000OoO.get(i).O000000o());
                }
                jSONObject2.put("attr", jSONArray);
                jSONObject2.put("express", this.O0000Oo);
                jSONObject.put("sub_props", jSONObject2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final O000000o O00000oo() {
        List<O000000o> list = this.O0000OoO;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.O0000OoO.get(0);
    }

    public final hrc O0000O0o() {
        hrc hrc = new hrc(this.O00000o);
        hrc.f543O000000o = this.f543O000000o;
        List<O000000o> list = this.O0000OoO;
        if (list != null) {
            hrc.O0000OoO.addAll(list);
        }
        hrc.O0000Oo = this.O0000Oo;
        hrc.O0000OOo = this.O0000OOo;
        return hrc;
    }
}
