package _m_j;

import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.plugin.DeviceConstant;

public final class chu {

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final chu f13841O000000o = new chu((byte) 0);
    }

    /* synthetic */ chu(byte b) {
        this();
    }

    private chu() {
    }

    public static boolean O000000o(String str) {
        return (str.equals("mijia.camera.v3") && !CommonApplication.getAppContext().getSharedPreferences("mijia.camera.v3", 0).getBoolean("is_support_rn", false)) || "chuangmi.camera.ipc009".equals(str) || "chuangmi.camera.ipc019".equals(str) || DeviceConstant.isNativePlugin(str) || "isa.camera.hlc6".equals(str);
    }

    public static int O00000Oo(String str) {
        return ("chuangmi.camera.ipc009".equals(str) || "chuangmi.camera.ipc019".equals(str) || DeviceConstant.isNewChuangmi(str) || "isa.camera.hlc6".equals(str)) ? 0 : 1;
    }
}
