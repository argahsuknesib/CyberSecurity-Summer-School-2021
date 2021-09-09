package _m_j;

import android.content.Intent;
import com.tencent.mmkv.MMKV;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.common.floatingview.FloatPositionEntity;
import com.xiaomi.smarthome.library.log.LogType;

public final class gns {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f18056O000000o = "FloatViewHelper";

    public static boolean O000000o(String str) {
        return str.equals("DeviceLauncher2") || str.equals("LoginTransitActivity") || str.equals("SmartHomeLauncherActivity");
    }

    public static boolean O000000o() {
        return gfr.O0000o00 | gfr.f17662O000000o;
    }

    public static void O000000o(int i) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        O000000o(z);
    }

    public static int O00000Oo() {
        return O00000o0() ? 1 : 0;
    }

    public static void O000000o(boolean z) {
        MMKV.O000000o("smart.float.feed.cache").putBoolean("float_show_status_flag", z);
        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("action_float_view_status_change"));
    }

    public static boolean O00000o0() {
        return MMKV.O000000o("smart.float.feed.cache").getBoolean("float_show_status_flag", true);
    }

    public static void O000000o(float f, float f2) {
        MMKV O000000o2 = MMKV.O000000o("smart.float.feed.cache");
        O000000o2.putFloat("float_feed_x", f);
        O000000o2.putFloat("float_feed_y", f2);
    }

    public static FloatPositionEntity O00000o() {
        FloatPositionEntity floatPositionEntity = new FloatPositionEntity();
        MMKV O000000o2 = MMKV.O000000o("smart.float.feed.cache");
        floatPositionEntity.x = O000000o2.getFloat("float_feed_x", -1.0f);
        floatPositionEntity.y = O000000o2.getFloat("float_feed_y", -1.0f);
        return floatPositionEntity;
    }

    public static void O00000Oo(float f, float f2) {
        MMKV O000000o2 = MMKV.O000000o("smart.float.feed.cache");
        O000000o2.putFloat("up_feed_x", f);
        O000000o2.putFloat("up_feed_y", f2);
    }

    public static FloatPositionEntity O00000oO() {
        FloatPositionEntity floatPositionEntity = new FloatPositionEntity();
        MMKV O000000o2 = MMKV.O000000o("smart.float.feed.cache");
        floatPositionEntity.x = O000000o2.getFloat("up_feed_x", 50000.0f);
        floatPositionEntity.y = O000000o2.getFloat("up_feed_y", 50000.0f);
        return floatPositionEntity;
    }

    public static void O00000Oo(boolean z) {
        gsy.O00000o0(LogType.GENERAL, "zhudong", "saveLoginStatus_isLogin:".concat(String.valueOf(z)));
        MMKV.O000000o("smart.float.feed.cache").putBoolean("login_status", z);
    }

    public static boolean O00000oo() {
        return MMKV.O000000o("smart.float.feed.cache").getBoolean("login_status", false);
    }

    public static void O0000O0o() {
        MMKV.O000000o("smart.float.feed.cache").putBoolean("first_install_show", false);
    }

    public static boolean O0000OOo() {
        return MMKV.O000000o("smart.float.feed.cache").getBoolean("first_install_show", true);
    }
}
