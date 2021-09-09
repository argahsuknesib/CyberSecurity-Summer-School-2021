package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class azy extends azz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f12738O000000o = null;
    public String O00000Oo;
    public int O00000o;
    public String O00000o0;
    public String O00000oO;
    public int O00000oo = -2;
    private String O0000O0o;
    private String O0000OOo;

    public final int O000000o() {
        return 4105;
    }

    public final String toString() {
        return "CommandMessage{, mRegisterID='" + this.O0000O0o + '\'' + ", mSdkVersion='" + this.O0000OOo + '\'' + ", mCommand=" + this.O00000o + ", mContent='" + this.O00000oO + '\'' + ", mResponseCode=" + this.O00000oo + '}';
    }

    public static List<bac> O000000o(String str, String str2, String str3, String str4) {
        ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(str2);
            arrayList = new ArrayList();
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    bac bac = new bac();
                    bac.O00000Oo = jSONObject.getString(str4);
                    bac.f12742O000000o = jSONObject.getString(str3);
                    arrayList.add(bac);
                    i++;
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    bae.O000000o("parseToSubscribeResultList--".concat(String.valueOf(arrayList)));
                    return arrayList;
                }
            }
        } catch (JSONException e2) {
            e = e2;
            arrayList = null;
            e.printStackTrace();
            bae.O000000o("parseToSubscribeResultList--".concat(String.valueOf(arrayList)));
            return arrayList;
        }
        bae.O000000o("parseToSubscribeResultList--".concat(String.valueOf(arrayList)));
        return arrayList;
    }
}
