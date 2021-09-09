package _m_j;

import android.os.Build;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.mijia.generalplayer.config.CameraPlayerConfig;
import com.xiaomi.smarthome.library.log.LogType;

public class cjo {
    private static volatile cjo O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    String f13946O000000o;

    private cjo() {
    }

    public static cjo O000000o() {
        if (O00000Oo == null) {
            synchronized (cjo.class) {
                if (O00000Oo == null) {
                    O00000Oo = new cjo();
                }
            }
        }
        return O00000Oo;
    }

    public final CameraPlayerConfig O00000Oo() {
        if (this.f13946O000000o == null) {
            this.f13946O000000o = gkv.f17949O000000o.getSharedPreferences("sp_camera_player_config", 0).getString("content", "");
        }
        if (!TextUtils.isEmpty(this.f13946O000000o)) {
            return (CameraPlayerConfig) new Gson().fromJson(this.f13946O000000o, CameraPlayerConfig.class);
        }
        return null;
    }

    public final boolean O00000o0() {
        CameraPlayerConfig O00000Oo2 = O00000Oo();
        if (O00000Oo2 == null) {
            gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", "isCloudGeneralplayerEnable getFailed");
            return false;
        }
        boolean z = O00000Oo2.cloud_generalplayer_enable;
        gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", String.format("isCloudGeneralplayerEnable result:%b", Boolean.valueOf(z)));
        return z;
    }

    public static boolean O000000o(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String equals : strArr) {
            if (Build.PRODUCT.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean O00000Oo(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String equals : strArr) {
            if (Build.MANUFACTURER.equals(equals)) {
                return true;
            }
        }
        return false;
    }
}
