package _m_j;

import android.text.TextUtils;
import com.sdu.didi.openapi.DiDiWebActivity;
import com.sdu.didi.openapi.Methods;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import org.json.JSONObject;

public final class dba {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f14429O000000o;
    private static Methods O00000Oo;

    public static String O000000o(String str, DiDiWebActivity diDiWebActivity) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("cmd");
            f14429O000000o = jSONObject.optString("id");
            String optString2 = jSONObject.optString("params");
            Methods methods = new Methods(diDiWebActivity);
            O00000Oo = methods;
            String str2 = (String) methods.getClass().getDeclaredMethod(optString, String.class).invoke(O00000Oo, optString2);
            return str2.equals("success") ? "success" : O000000o(f14429O000000o, str2);
        } catch (JSONException e) {
            e.printStackTrace();
            return O000000o(f14429O000000o, "");
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return O000000o(f14429O000000o, "");
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return O000000o(f14429O000000o, (String) null);
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return O000000o(f14429O000000o, "");
        }
    }

    private static String O000000o(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        String str3 = str2 == null ? "404" : TextUtils.isEmpty(str2) ? "500" : "200";
        try {
            jSONObject.put("id", str);
            jSONObject.put("result", str2);
            jSONObject.put("errorcode", str3);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
