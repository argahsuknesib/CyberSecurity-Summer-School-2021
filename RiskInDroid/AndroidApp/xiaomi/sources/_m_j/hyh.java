package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class hyh extends hyg {
    private List<hya> O00000o0 = new ArrayList();

    public hyh(String str) {
        super(str);
    }

    public final long O000000o(String str, Object... objArr) {
        return O000000o(str, O000000o(objArr));
    }

    public final long O000000o(String str, String str2, Object... objArr) {
        try {
            O000000o(str, O000000o(objArr), str2 == null ? "mihome" : str2, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.O000000o(str, str2, objArr);
    }

    public final long O000000o(String str, String str2, JSONObject jSONObject, String str3) {
        try {
            O000000o(str, jSONObject, str2 == null ? "mihome" : str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.O000000o(str, str2, jSONObject, str3);
    }

    public final long O00000Oo(String str, String str2, Object... objArr) {
        try {
            O000000o(str, O000000o(objArr), "mihome", str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.O00000Oo(str, str2, objArr);
    }

    private void O000000o(String str, JSONObject jSONObject, String str2, String str3) {
        if (this.O00000o0.size() > 0) {
            for (int i = 0; i < this.O00000o0.size(); i++) {
                hya hya = this.O00000o0.get(i);
                if (hya.O000000o()) {
                    O000000o(hya, this.f979O000000o, jSONObject, str, str3);
                }
            }
        }
    }

    private static void O000000o(hya hya, String str, JSONObject jSONObject, String str2, String str3) {
        if (hya != null && !TextUtils.isEmpty(str) && jSONObject != null && !TextUtils.isEmpty(str2)) {
            hya.O000000o(str, jSONObject, str2, str3);
        }
    }

    public final void O000000o(hya hya) {
        if (!this.O00000o0.contains(hya) && hya != null) {
            this.O00000o0.add(hya);
        }
    }

    public final long O000000o(String str, JSONObject jSONObject) {
        try {
            if (this.O00000o0.size() > 0) {
                for (int i = 0; i < this.O00000o0.size(); i++) {
                    hya hya = this.O00000o0.get(i);
                    String str2 = this.f979O000000o;
                    if (!(hya == null || TextUtils.isEmpty(str2) || jSONObject == null)) {
                        if (!TextUtils.isEmpty(str)) {
                            hya.O000000o(str2, jSONObject, str);
                        }
                    }
                }
            }
            return super.O000000o(str, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
            return System.currentTimeMillis();
        }
    }
}
