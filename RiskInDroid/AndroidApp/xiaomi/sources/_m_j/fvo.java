package _m_j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;

public final class fvo {

    /* renamed from: O000000o  reason: collision with root package name */
    private static fvo f17281O000000o;
    private static SharedPreferences O00000Oo = CommonApplication.getAppContext().getSharedPreferences("developer_setting", 0);

    private fvo() {
    }

    public static fvo O000000o() {
        if (f17281O000000o == null || O00000Oo == null) {
            f17281O000000o = new fvo();
        }
        return f17281O000000o;
    }

    public static boolean O00000Oo() {
        return O00000Oo.getBoolean("is_force_to_check_update_in_debug", false);
    }

    public static boolean O00000o0() {
        return O00000Oo.getBoolean("is_open_hide_device_entrance_in_debug", false);
    }

    public static void O000000o(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("is_open_hide_device_entrance_in_debug", z);
        edit.commit();
    }

    public static void O00000Oo(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("is_force_to_check_update_in_debug", z);
        edit.commit();
    }

    public static boolean O00000o() {
        return O00000Oo.getBoolean("rn_debug_enable", false);
    }

    public static boolean O00000oO() {
        return O00000Oo.getBoolean("rn_debug_enable_v2", false);
    }

    public static void O00000o0(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("rn_debug_enable_v2", z);
        edit.commit();
    }

    public static boolean O00000oo() {
        return O00000Oo.getBoolean("rn_debug_toast_sdk_version", false);
    }

    public static void O00000o(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("rn_debug_toast_sdk_version", z);
        edit.commit();
    }

    public static boolean O0000O0o() {
        return O00000Oo.getBoolean("rn_debug_fps_memory", false);
    }

    public static void O00000oO(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("rn_debug_fps_memory", z);
        edit.commit();
    }

    public static boolean O0000OOo() {
        return O00000Oo.getBoolean("rn_debug_force_use_inner_rn_sdk", false);
    }

    public static boolean O0000Oo0() {
        return O00000Oo.getBoolean("rn_debug_force_plaintext_transmission", false);
    }

    public static boolean O0000Oo() {
        return O00000Oo.getBoolean("rn_debug_force_all_model_support_reuse", false);
    }

    public static boolean O0000OoO() {
        return O00000Oo.getBoolean("rn_debug_force_all_model_close_support_reuse", false);
    }

    public static boolean O0000Ooo() {
        return O00000Oo.getBoolean("rn_debug_support_scan_debug_reuse", false);
    }

    public static void O00000oo(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("rn_debug_force_use_inner_rn_sdk", z);
        edit.commit();
    }

    public static void O0000O0o(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("rn_debug_force_plaintext_transmission", z);
        edit.apply();
    }

    public static void O0000OOo(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("rn_debug_force_all_model_support_reuse", z);
        edit.apply();
    }

    public static void O0000Oo0(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("rn_debug_force_all_model_close_support_reuse", z);
        edit.apply();
    }

    public static void O0000Oo(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("rn_debug_support_scan_debug_reuse", z);
        edit.apply();
    }

    public static String O0000o00() {
        return O00000Oo.getString("rn_debug_package_name_v2", "");
    }

    public static void O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putString("rn_debug_package_name_v2", str);
        edit.commit();
    }

    public static String O0000o0() {
        return O00000Oo.getString("rn_debug_package_name", "");
    }

    public static void O000000o(boolean z, String str, String str2, boolean z2) {
        hsi.O000000o(z2);
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("rn_debug_enable", z);
        if (TextUtils.equals(str, "*")) {
            fko.O000000o(CommonApplication.getAppContext(), str2);
        } else {
            fko.O000000o(CommonApplication.getAppContext(), "");
            edit.putString("rn_debug_package_name", str);
            edit.putString("rn_debug_model", str2);
        }
        edit.commit();
    }

    public static void O000000o(int i, int i2, boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putInt("rn_local_ping_retryCount", i);
        edit.putInt("rn_local_ping_timeout", i2);
        edit.putBoolean("rn_local_ping_isChecked", z);
        edit.commit();
    }

    public static int[] O0000o0O() {
        return new int[]{O00000Oo.getInt("rn_local_ping_retryCount", 0), O00000Oo.getInt("rn_local_ping_timeout", 0)};
    }

    public static boolean O0000o0o() {
        return O00000Oo.getBoolean("rn_local_ping_isChecked", false);
    }

    public static boolean O0000o() {
        return O00000Oo.getBoolean("debug_force_soft_decode", false);
    }

    public static void O0000OoO(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("debug_force_soft_decode", z);
        edit.commit();
    }

    public static boolean O0000oO0() {
        return O00000Oo.getBoolean("debug_save_video_raw_data", false);
    }

    public static boolean O0000oO() {
        return O00000Oo.getBoolean("debug_save_app_audio_raw_data", false);
    }

    public static void O0000Ooo(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("debug_save_video_raw_data", z);
        edit.commit();
    }

    public static void O0000o00(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("debug_save_app_audio_raw_data", z);
        edit.commit();
    }

    public static boolean O0000oOO() {
        return O00000Oo.getBoolean("debug_enable_rn_ijk", false);
    }

    public static void O0000o0(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("debug_enable_rn_ijk", z);
        edit.commit();
    }

    public static boolean O0000oOo() {
        return O00000Oo.getBoolean("debug_enable_camera_ijk", false);
    }

    public static void O0000o0O(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("debug_enable_camera_ijk", z);
        edit.commit();
    }

    public static boolean O0000oo0() {
        return gkv.O000000o() && O00000Oo.getBoolean("is_av_setting_enable", false);
    }

    public static void O0000o0o(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("is_av_setting_enable", z);
        edit.commit();
    }

    public static boolean O0000oo() {
        return gkv.O000000o() && O00000Oo.getBoolean("debug_scan_camera_force_api1", false);
    }

    public static void O0000o(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("debug_scan_camera_force_api1", z);
        edit.commit();
    }

    public static boolean O0000ooO() {
        return gkv.O000000o() && O00000Oo.getBoolean("super_resolution_enable", false);
    }

    public static void O0000oO0(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("super_resolution_enable", z);
        edit.commit();
    }

    public static boolean O0000ooo() {
        return gkv.O000000o() && O00000Oo.getBoolean("full_log_enable", false);
    }

    public static void O0000oO(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("full_log_enable", z);
        edit.commit();
    }

    public static boolean O00oOooO() {
        return O00000Oo.getBoolean("debug_enable_cloud_ijk", false);
    }

    public static void O0000oOO(boolean z) {
        SharedPreferences.Editor edit = O00000Oo.edit();
        edit.putBoolean("debug_enable_cloud_ijk", z);
        edit.commit();
    }
}
