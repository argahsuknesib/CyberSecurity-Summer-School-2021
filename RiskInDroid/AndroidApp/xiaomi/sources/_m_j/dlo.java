package _m_j;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public final class dlo {

    /* renamed from: O000000o  reason: collision with root package name */
    String f14772O000000o;
    String O00000Oo;
    int O00000o;
    DisplayMetrics O00000o0;
    String O00000oO;
    String O00000oo;
    String O0000O0o;
    String O0000OOo;
    String O0000Oo;
    String O0000Oo0;
    String O0000OoO;
    int O0000Ooo;
    private String O0000o;
    String O0000o0;
    String O0000o00;
    Context O0000o0O;
    private String O0000o0o;
    private String O0000oO;
    private String O0000oO0;

    private dlo(Context context) {
        this.O00000Oo = "2.0.3";
        this.O00000o = Build.VERSION.SDK_INT;
        this.O00000oO = Build.MODEL;
        this.O00000oo = Build.MANUFACTURER;
        this.O0000O0o = Locale.getDefault().getLanguage();
        this.O0000Ooo = 0;
        this.O0000o00 = null;
        this.O0000o0 = null;
        this.O0000o0O = null;
        this.O0000o0o = null;
        this.O0000o = null;
        this.O0000oO0 = null;
        this.O0000oO = null;
        this.O0000o0O = context.getApplicationContext();
        this.O00000o0 = dlv.O00000o(this.O0000o0O);
        this.f14772O000000o = dlv.O0000Oo(this.O0000o0O);
        this.O0000OOo = dkd.O00000Oo(this.O0000o0O);
        this.O0000Oo0 = dlv.O0000Oo0(this.O0000o0O);
        this.O0000Oo = TimeZone.getDefault().getID();
        this.O0000Ooo = dlv.O00000Oo();
        this.O0000OoO = dlv.O0000o0(this.O0000o0O);
        this.O0000o00 = this.O0000o0O.getPackageName();
        if (this.O00000o >= 14) {
            this.O0000o0o = dlv.O0000oO(this.O0000o0O);
        }
        this.O0000o = dlv.O0000O0o().toString();
        this.O0000oO0 = dlv.O0000oO0(this.O0000o0O);
        this.O0000oO = dlv.O00000oo();
        this.O0000o0 = dlv.O0000ooO(this.O0000o0O);
    }

    public /* synthetic */ dlo(Context context, byte b) {
        this(context);
    }

    public final void O000000o(JSONObject jSONObject, Thread thread) {
        if (thread == null) {
            if (this.O00000o0 != null) {
                jSONObject.put("sr", this.O00000o0.widthPixels + "*" + this.O00000o0.heightPixels);
                jSONObject.put("dpi", this.O00000o0.xdpi + "*" + this.O00000o0.ydpi);
            }
            if (dkg.O000000o(this.O0000o0O).O000000o()) {
                JSONObject jSONObject2 = new JSONObject();
                dmb.O000000o(jSONObject2, "bs", dmb.O00000o0(this.O0000o0O));
                dmb.O000000o(jSONObject2, "ss", dmb.O00000o(this.O0000o0O));
                if (jSONObject2.length() > 0) {
                    dmb.O000000o(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray O00000oo2 = dmb.O00000oo(this.O0000o0O);
            if (O00000oo2 != null && O00000oo2.length() > 0) {
                dmb.O000000o(jSONObject, "wflist", O00000oo2.toString());
            }
            dmb.O000000o(jSONObject, "sen", this.O0000o0o);
        } else {
            dmb.O000000o(jSONObject, "thn", thread.getName());
            dmb.O000000o(jSONObject, "qq", dkd.O00000o0(this.O0000o0O));
            dmb.O000000o(jSONObject, "cui", dkd.O00000o(this.O0000o0O));
            if (dlv.O00000o0(this.O0000oO0) && this.O0000oO0.split("/").length == 2) {
                dmb.O000000o(jSONObject, "fram", this.O0000oO0.split("/")[0]);
            }
            if (dlv.O00000o0(this.O0000oO) && this.O0000oO.split("/").length == 2) {
                dmb.O000000o(jSONObject, "from", this.O0000oO.split("/")[0]);
            }
            if (dkz.O000000o(this.O0000o0O).O00000Oo(this.O0000o0O) != null) {
                jSONObject.put("ui", dkz.O000000o(this.O0000o0O).O00000Oo(this.O0000o0O).f14771O000000o);
            }
            dmb.O000000o(jSONObject, "mid", dkd.O00000oO(this.O0000o0O));
        }
        dmb.O000000o(jSONObject, "pcn", dlv.O0000o0O(this.O0000o0O));
        dmb.O000000o(jSONObject, "osn", Build.VERSION.RELEASE);
        dmb.O000000o(jSONObject, "av", this.f14772O000000o);
        dmb.O000000o(jSONObject, "ch", this.O0000OOo);
        dmb.O000000o(jSONObject, "mf", this.O00000oo);
        dmb.O000000o(jSONObject, "sv", this.O00000Oo);
        dmb.O000000o(jSONObject, "osd", Build.DISPLAY);
        dmb.O000000o(jSONObject, "prod", Build.PRODUCT);
        dmb.O000000o(jSONObject, "tags", Build.TAGS);
        dmb.O000000o(jSONObject, "id", Build.ID);
        dmb.O000000o(jSONObject, "fng", Build.FINGERPRINT);
        dmb.O000000o(jSONObject, "lch", this.O0000o0);
        dmb.O000000o(jSONObject, "ov", Integer.toString(this.O00000o));
        jSONObject.put("os", 1);
        dmb.O000000o(jSONObject, "op", this.O0000Oo0);
        dmb.O000000o(jSONObject, "lg", this.O0000O0o);
        dmb.O000000o(jSONObject, "md", this.O00000oO);
        dmb.O000000o(jSONObject, "tz", this.O0000Oo);
        int i = this.O0000Ooo;
        if (i != 0) {
            jSONObject.put("jb", i);
        }
        dmb.O000000o(jSONObject, "sd", this.O0000OoO);
        dmb.O000000o(jSONObject, "apn", this.O0000o00);
        dmb.O000000o(jSONObject, "cpu", this.O0000o);
        dmb.O000000o(jSONObject, "abi", Build.CPU_ABI);
        dmb.O000000o(jSONObject, "abi2", Build.CPU_ABI2);
        dmb.O000000o(jSONObject, "ram", this.O0000oO0);
        dmb.O000000o(jSONObject, "rom", this.O0000oO);
    }
}
