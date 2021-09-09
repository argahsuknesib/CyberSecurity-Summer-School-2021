package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class ftn {
    public static String O000000o(Context context, String str) {
        return fdc.O000000o().O000000o(context, str);
    }

    public static List<ServerBean> O000000o(Locale locale, Context context) {
        return fdc.O000000o().O000000o(locale, context);
    }

    public static String O000000o(ServerBean serverBean) {
        return fdc.O000000o().O000000o(serverBean);
    }

    public static ServerBean O000000o(Context context) {
        return fdc.O000000o().O000000o(context);
    }

    public static ServerBean O00000Oo(Context context) {
        return fdc.O000000o().O00000Oo(context);
    }

    public static Locale O00000o0(Context context) {
        return fdc.O000000o().O00000o0(context);
    }

    public static Locale O00000o(Context context) {
        return fdc.O000000o().O00000o(context);
    }

    public static ServerBean O00000Oo(Context context, String str) {
        return fdc.O000000o().O00000Oo(context, str);
    }

    public static boolean O00000oO(Context context) {
        return fdc.O000000o().O00000oO(context);
    }

    public static boolean O00000Oo(ServerBean serverBean) {
        return fdc.O000000o().O00000Oo(serverBean);
    }

    public static boolean O00000o0(ServerBean serverBean) {
        return fdc.O000000o().O00000o0(serverBean);
    }

    public static boolean O00000oo(Context context) {
        return fdc.O000000o().O00000oo(context);
    }

    public static boolean O0000O0o(Context context) {
        return fdc.O000000o().O0000O0o(context);
    }

    public static boolean O00000o(ServerBean serverBean) {
        return fdc.O000000o().O00000o(serverBean);
    }

    public static boolean O0000OOo(Context context) {
        return fdc.O000000o().O0000OOo(context);
    }

    public static boolean O00000oO(ServerBean serverBean) {
        return fdc.O000000o().O00000oO(serverBean);
    }

    public static boolean O00000oo(ServerBean serverBean) {
        return fdc.O000000o().O00000oo(serverBean);
    }

    public static boolean O0000Oo0(Context context) {
        return fdc.O000000o().O0000Oo0(context);
    }

    public static boolean O0000Oo(Context context) {
        return fdc.O000000o().O0000Oo(context);
    }

    public static boolean O0000OoO(Context context) {
        return fdc.O000000o().O0000OoO(context);
    }

    public static boolean O0000O0o(ServerBean serverBean) {
        return fdc.O000000o().O0000OOo(serverBean);
    }

    public static boolean O0000Ooo(Context context) {
        return fdc.O000000o().O0000Ooo(context);
    }

    public static boolean O0000o00(Context context) {
        return fdc.O000000o().O0000o00(context);
    }

    public static boolean O0000OOo(ServerBean serverBean) {
        return fdc.O000000o().O0000Oo(serverBean);
    }

    public static boolean O0000o0(Context context) {
        return fdc.O000000o().O0000o0(context);
    }

    public static boolean O0000Oo0(ServerBean serverBean) {
        return fdc.O000000o().O0000OoO(serverBean);
    }

    public static boolean O0000o0O(Context context) {
        return fdc.O000000o().O0000o0O(context);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void O000000o(Context context, ServerBean serverBean) {
        fdc.O000000o().O000000o(context, serverBean);
    }

    public static ServerBean O000000o() {
        return fdc.O000000o().O00000Oo();
    }

    public static ServerBean O00000Oo() {
        return fdc.O000000o().O00000o0();
    }

    public static ServerBean O00000o0() {
        return fdc.O000000o().O00000o();
    }

    public static ServerBean O00000o() {
        return fdc.O000000o().O00000oO();
    }

    public static ServerBean O00000oO() {
        return fdc.O000000o().O00000oo();
    }

    public static ServerBean O00000oo() {
        return fdc.O000000o().O0000O0o();
    }

    public static ServerBean O0000O0o() {
        return fdc.O000000o().O0000OOo();
    }

    public static ServerBean O0000OOo() {
        return fdc.O000000o().O0000Oo0();
    }

    public static ServerBean O0000Oo0() {
        return fdc.O000000o().O0000Oo();
    }

    public static ServerBean O0000Oo() {
        return fdc.O000000o().O0000OoO();
    }

    public static String O000000o(ServerBean serverBean, JSONObject jSONObject) {
        String O00000Oo = O00000Oo(serverBean, jSONObject);
        if (TextUtils.isEmpty(O00000Oo)) {
            O00000Oo = jSONObject.optString("cn");
        }
        return O00000Oo == null ? "" : O00000Oo;
    }

    public static String O00000Oo(ServerBean serverBean, JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        if (fdc.O000000o().O00000o0(serverBean) || fdc.O000000o().O0000OoO(serverBean)) {
            return jSONObject.optString("cn");
        }
        if (fdc.O000000o().O0000Oo(serverBean)) {
            return jSONObject.optString("sg");
        }
        if (fdc.O000000o().O0000OOo(serverBean)) {
            return jSONObject.optString("us");
        }
        if (fdc.O000000o().O00000o(serverBean)) {
            return jSONObject.optString("de");
        }
        if (fdc.O000000o().O0000Oo0(serverBean)) {
            return jSONObject.optString("ru");
        }
        if (fdc.O000000o().O0000O0o(serverBean)) {
            return jSONObject.optString("in");
        }
        return "";
    }
}
