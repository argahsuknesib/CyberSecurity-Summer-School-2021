package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;

public final class clk {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f14071O000000o;
    public SharedPreferences O00000Oo;
    public boolean O00000o = false;
    public SharedPreferences O00000o0;
    public boolean O00000oO = false;
    public boolean O00000oo = false;
    public boolean O0000O0o = true;
    public boolean O0000OOo = false;
    public int O0000Oo = 5;
    public boolean O0000Oo0 = true;
    public boolean O0000OoO = true;
    public long O0000Ooo = 0;
    public String O0000o;
    public boolean O0000o0;
    public int O0000o00;
    public long O0000o0O = -1;
    public int O0000o0o = -1;
    private int O0000oO;
    private SharedPreferences O0000oO0;
    private boolean O0000oOO;
    private boolean O0000oOo = false;
    private boolean O0000oo = false;
    private boolean O0000oo0 = false;

    public final void O000000o(boolean z) {
        if (this.O0000OOo != z) {
            this.O0000OOo = z;
            this.O00000Oo.edit().putBoolean("correct_lens_distort", this.O0000OOo).apply();
        }
    }

    public final void O00000Oo(boolean z) {
        if (this.O0000o0 != z) {
            this.O0000o0 = z;
            this.O00000Oo.edit().putBoolean("only_wifi", this.O0000o0).apply();
        }
    }

    public clk(String str, String str2, String str3) {
        this.O00000Oo = XmPluginHostApi.instance().context().getSharedPreferences("mijia_camera_".concat(String.valueOf(str)), 0);
        Context context = XmPluginHostApi.instance().context();
        this.O0000oO0 = context.getSharedPreferences(str3 + str2, 0);
        Context context2 = XmPluginHostApi.instance().context();
        this.O00000o0 = context2.getSharedPreferences(str + str2, 0);
        this.O0000OOo = this.O00000Oo.getBoolean("correct_lens_distort", true);
        this.O0000oO = this.O00000Oo.getInt("rotation", 0);
        this.O0000o00 = this.O00000Oo.getInt("video_quality", 0);
        this.O0000o0 = this.O00000Oo.getBoolean("only_wifi", false);
        this.O0000oOO = this.O00000Oo.getBoolean("rote_save", false);
        this.O00000oo = this.O00000Oo.getBoolean("privacy_need", true);
        this.O0000O0o = this.O00000Oo.getBoolean("alarm_guide", true);
        this.O00000o = this.O0000oO0.getBoolean("need_guide", true);
        this.O00000oO = this.O00000Oo.getBoolean("need_guide2", true);
        this.O0000oOo = this.O0000oO0.getBoolean("need_cloud_guide", true);
        this.O0000oo0 = this.O00000Oo.getBoolean("has_cloud_video_tips_clicked", false);
        this.O0000o0o = this.O00000Oo.getInt("cloud_vip", -1);
        this.O0000o = this.O00000Oo.getString("cloudVipEnd", "");
        this.f14071O000000o = this.O00000o0.getString("alarm_event_type", "Default");
        this.O0000OoO = this.O00000Oo.getBoolean("daily_story_guide", true);
    }

    public final void O000000o(int i) {
        if (this.O0000o00 != i) {
            this.O0000o00 = i;
            this.O00000Oo.edit().putInt("video_quality", this.O0000o00).apply();
        }
    }

    public final void O00000o0(boolean z) {
        this.O00000Oo.edit().putBoolean("is_valid_cloud_video_user", z).apply();
    }

    public final void O00000Oo(int i) {
        this.O00000Oo.edit().putInt("camera_vip_status", i).apply();
    }

    public final void O00000o(boolean z) {
        this.O00000Oo.edit().putBoolean("is_in_expire_window", !z).apply();
    }

    public final boolean O000000o() {
        return this.O00000Oo.getBoolean("is_in_expire_window", false);
    }

    public final boolean O00000Oo() {
        this.O0000oo = this.O00000Oo.getBoolean("is_valid_cloud_video_user", false);
        return this.O0000oo;
    }

    public final void O00000o0() {
        if (this.O0000oOO) {
            this.O0000oOO = false;
            this.O00000Oo.edit().putBoolean("rote_save", false).apply();
        }
    }

    public final void O00000o() {
        if (this.O00000o) {
            this.O00000o = false;
            this.O0000oO0.edit().putBoolean("need_guide", false).apply();
        }
    }

    public final void O00000oO(boolean z) {
        if (this.O00000oo != z) {
            this.O00000oo = z;
            this.O00000Oo.edit().putBoolean("privacy_need", z).apply();
        }
    }

    public final void O000000o(long j) {
        if (this.O0000o0O != j) {
            this.O0000o0O = j;
            this.O00000Oo.edit().putLong("newAlarmFirstTime", j).apply();
        }
    }

    public final void O00000oO() {
        if (this.O0000O0o) {
            this.O0000O0o = false;
            this.O00000Oo.edit().putBoolean("alarm_guide", false).apply();
        }
    }

    public final void O00000oo() {
        if (!this.O0000oo0) {
            this.O0000oo0 = true;
            this.O00000Oo.edit().putBoolean("has_cloud_video_tips_clicked", true).apply();
        }
    }

    public final void O00000Oo(long j) {
        this.O0000Ooo = j;
        this.O0000oO0.edit().putLong("first_cloud_video_show_time", j).apply();
    }

    public final void O000000o(String str) {
        if (!str.equals(this.O0000o)) {
            this.O0000o = str;
            this.O00000Oo.edit().putString("cloudVipEnd", str).apply();
        }
    }

    public final void O00000Oo(String str) {
        if (!TextUtils.isEmpty(str) && !this.f14071O000000o.equals(str)) {
            this.f14071O000000o = str;
            this.O00000o0.edit().putString("alarm_event_type", str).apply();
        }
    }

    public final boolean O0000O0o() {
        if (this.O0000oo0) {
            return false;
        }
        long j = this.O0000Ooo;
        if (j == 0) {
            return true;
        }
        if (j <= 0 || System.currentTimeMillis() - j >= 259200000) {
            return false;
        }
        return true;
    }
}
