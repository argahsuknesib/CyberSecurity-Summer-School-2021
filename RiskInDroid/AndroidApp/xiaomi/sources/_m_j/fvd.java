package _m_j;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.smarthome.framework.navigate.PageUrl$1;
import com.xiaomi.smarthome.framework.navigate.PageUrl$2;
import com.xiaomi.smarthome.framework.navigate.PageUrl$3;
import com.xiaomi.smarthome.framework.navigate.PageUrl$4;
import com.xiaomi.smarthome.framework.navigate.PageUrl$5;
import com.xiaomi.smarthome.framework.navigate.PageUrl$6;
import com.xiaomi.smarthome.framework.navigate.UrlResolver;
import java.util.HashMap;
import java.util.Map;

public final class fvd {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final O00000o0 f17248O000000o;
    private static final O00000o0 O00000Oo;
    private static Map<String, O00000o0> O00000o = new PageUrl$1();
    private static final O00000o0 O00000o0;
    private static Map<String, O00000o0> O00000oO = new PageUrl$2();
    private static Map<String, O00000o0> O00000oo = new PageUrl$3();
    private static Map<String, O00000o0> O0000O0o = new PageUrl$4();
    private static Map<String, O00000o0> O0000OOo = new PageUrl$5();
    private static Map<String, O00000o0> O0000Oo0 = new PageUrl$6();

    static {
        O00000o0 o00000o0 = new O00000o0();
        o00000o0.f17250O000000o = O000000o("com.xiaomi.smarthome.SmartHomeMainActivity");
        o00000o0.O00000Oo = true;
        o00000o0.O00000o0 = false;
        f17248O000000o = o00000o0;
        O00000o0 o00000o02 = new O00000o0();
        o00000o02.f17250O000000o = O000000o("com.xiaomi.smarthome.framework.navigate.ShopLauncherMiddle");
        o00000o02.O00000Oo = false;
        o00000o02.O00000o0 = false;
        O00000Oo = o00000o02;
        O00000o0 o00000o03 = new O00000o0();
        o00000o03.f17250O000000o = O000000o("com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity");
        o00000o03.O00000Oo = true;
        o00000o03.O00000o0 = true;
        O00000o0 = o00000o03;
    }

    public static Class<?> O000000o(String str) {
        return cub.O00000Oo(Activity.class, str);
    }

    public static class O00000Oo implements O00000o0.O000000o {
        public final boolean O000000o(Uri uri) {
            if (uri == null) {
                return false;
            }
            try {
                UrlResolver.O000000o O000000o2 = UrlResolver.O000000o.O000000o(uri);
                if (O000000o2.O00000Oo != null) {
                    if (!O000000o2.O00000Oo.isEmpty()) {
                        String str = O000000o2.O00000Oo.get("url");
                        if (TextUtils.isEmpty(str)) {
                            return false;
                        }
                        String host = Uri.parse(str).getHost();
                        if (!TextUtils.isEmpty(host) && host.toLowerCase().endsWith(".mi.com")) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public static boolean O000000o(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        if (!scheme.equals("http") && !scheme.equals("https") && !scheme.equals("mihome") && !scheme.equals("smarthome") && !scheme.equals("mijia")) {
            return false;
        }
        String host = uri.getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        if (host.equals("home.mi.com") || host.equals("mihome.app") || host.equals("smarthome.app") || host.equals("device") || host.equals("scene")) {
            return true;
        }
        return false;
    }

    public static Uri O00000Oo(Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith("https://home.mi.com/index/login?followup=")) {
            return Uri.parse(Uri.decode(uri2.substring(41)));
        }
        return uri2.startsWith("mihome://shop?url=") ? Uri.parse(new String(Base64.decode(uri2.substring(18), 0))) : uri;
    }

    public static O00000o0 O00000o0(Uri uri) {
        if (uri == null || !O000000o(uri)) {
            return null;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        O00000o0 o00000o0 = O00000o.get(path);
        if (o00000o0 == null && O0000OoO(path)) {
            o00000o0 = O00000Oo;
        }
        if (o00000o0 == null && O00000o(path)) {
            o00000o0 = O00000oO.get("/device/*");
        }
        if (o00000o0 == null && O00000oO(path)) {
            o00000o0 = O00000o0;
        }
        if (o00000o0 == null) {
            o00000o0 = O00000oo.get(path);
        }
        if (o00000o0 == null) {
            o00000o0 = O0000O0o.get(path);
        }
        if (o00000o0 == null) {
            o00000o0 = O0000OOo.get(path);
        }
        O00000o0 o00000o02 = o00000o0 == null ? O0000Oo0.get(path) : o00000o0;
        if (o00000o02 == null || o00000o02.O000000o(uri)) {
            return o00000o02;
        }
        return null;
    }

    public static Map<String, String> O00000o(Uri uri) {
        HashMap hashMap = new HashMap();
        if (uri == null) {
            return hashMap;
        }
        for (String next : uri.getQueryParameterNames()) {
            hashMap.put(next, uri.getQueryParameter(next));
        }
        return hashMap;
    }

    public static boolean O00000Oo(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/main/login")) {
            return true;
        }
        return false;
    }

    public static boolean O00000o0(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/main")) {
            return true;
        }
        return false;
    }

    public static boolean O00000o(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/device")) {
            return true;
        }
        return false;
    }

    public static boolean O00000oO(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/connect")) {
            return true;
        }
        return false;
    }

    public static boolean O00000oo(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/message_center")) {
            return true;
        }
        return false;
    }

    public static boolean O0000O0o(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/uwb")) {
            return true;
        }
        return false;
    }

    public static boolean O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && TextUtils.equals(str, "scene") && str2.startsWith("/recommend")) {
            return true;
        }
        return false;
    }

    public static boolean O0000OOo(String str) {
        return "/device/setting_update".equals(str);
    }

    public static boolean O0000Oo0(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/cloud_device")) {
            return true;
        }
        return false;
    }

    public static boolean O0000Oo(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/share")) {
            return true;
        }
        return false;
    }

    public static boolean O0000OoO(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("/webapp")) {
            return false;
        }
        if (str.startsWith("/shop") || str.startsWith("/detail") || str.startsWith("/web")) {
            return true;
        }
        return false;
    }

    public static Class<?> O000000o(Uri uri, UrlResolver.O000000o o000000o) {
        O00000o0 o00000o0 = O00000o.get(o000000o.f7642O000000o);
        if (o00000o0 == null || !o00000o0.O000000o(uri)) {
            return null;
        }
        return o00000o0.f17250O000000o;
    }

    public static O000000o O0000Ooo(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("/device/")) {
            return null;
        }
        O000000o o000000o = new O000000o();
        o000000o.f17249O000000o = "";
        o000000o.O00000Oo = "";
        String substring = str.substring(8);
        int indexOf = substring.indexOf("/");
        if (indexOf < 0) {
            indexOf = substring.indexOf("?");
        }
        if (indexOf > 0) {
            o000000o.f17249O000000o = substring.substring(0, indexOf);
            o000000o.O00000Oo = substring.substring(indexOf);
        } else {
            o000000o.f17249O000000o = substring;
        }
        return o000000o;
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public Class<?> f17250O000000o;
        public boolean O00000Oo = true;
        public O000000o O00000o = null;
        public boolean O00000o0 = true;

        public interface O000000o {
            boolean O000000o(Uri uri);
        }

        public final boolean O000000o(Uri uri) {
            O000000o o000000o = this.O00000o;
            if (o000000o != null) {
                return o000000o.O000000o(uri);
            }
            return true;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f17249O000000o;
        public String O00000Oo;

        O000000o() {
        }
    }
}
