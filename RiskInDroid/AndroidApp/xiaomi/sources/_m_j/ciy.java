package _m_j;

import android.content.Context;
import android.os.Build;
import android.widget.FrameLayout;
import com.mijia.generalplayer.config.CameraPlayerConfig;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.plugin.DeviceConstant;

public final class ciy {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f13930O000000o;
    private static boolean O00000Oo;

    static {
        boolean z;
        CameraPlayerConfig O00000Oo2 = cjo.O000000o().O00000Oo();
        boolean z2 = false;
        if (O00000Oo2 == null) {
            gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", "isInternalGeneralplayerEnbale getFailed");
            z = false;
        } else {
            if (O00000Oo2.internal_generalplayer_enable) {
                if (cjo.O000000o(O00000Oo2.internal_generalplayer_disable_devices)) {
                    gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", "isInternalGeneralplayerEnbale in disable list");
                } else if (cjo.O000000o(O00000Oo2.super_resolution_support_devices)) {
                    gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", "in super_resolution_support_devices list");
                } else {
                    z = true;
                    gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", String.format("isInternalGeneralplayerEnable result:%b, MANUFACTURER:%s, product:%s, hardware:%s", Boolean.valueOf(z), Build.MANUFACTURER, Build.PRODUCT, Build.HARDWARE));
                }
            }
            z = false;
            gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", String.format("isInternalGeneralplayerEnable result:%b, MANUFACTURER:%s, product:%s, hardware:%s", Boolean.valueOf(z), Build.MANUFACTURER, Build.PRODUCT, Build.HARDWARE));
        }
        f13930O000000o = z;
        CameraPlayerConfig O00000Oo3 = cjo.O000000o().O00000Oo();
        if (O00000Oo3 == null) {
            gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", "isForceSoftDecodeEnable getFailed");
        } else {
            z2 = cjo.O000000o(O00000Oo3.force_soft_decode_devices);
            gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", "isForceSoftDecodeEnable:".concat(String.valueOf(z2)));
        }
        O00000Oo = z2;
    }

    public static cjg O000000o(Context context, cid cid, cia cia) {
        fvo.O000000o();
        if (fvo.O0000oo0()) {
            fvo.O000000o();
            f13930O000000o = fvo.O0000oOo();
        }
        if (f13930O000000o && !DeviceConstant.isNotSupportGeneralPlayer(cid.getModel())) {
            return new ciz(context, cid, cia);
        }
        return new cjb(context, cid, cia);
    }

    public static cjh O000000o(String str, FrameLayout frameLayout) {
        fvo.O000000o();
        if (fvo.O0000oo0()) {
            fvo.O000000o();
            f13930O000000o = fvo.O0000oOo();
        }
        boolean z = false;
        boolean z2 = f13930O000000o && !DeviceConstant.isNotSupportGeneralPlayer(str);
        if (!z2) {
            CameraPlayerConfig O00000Oo2 = cjo.O000000o().O00000Oo();
            if (O00000Oo2 == null) {
                gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", "isSuperResolutionEnable getFailed");
            } else {
                z = cjo.O000000o(O00000Oo2.super_resolution_support_devices);
                gsy.O00000o0(LogType.CAMERA, "CameraPlayerConfigManager", "isSuperResolutionEnable:".concat(String.valueOf(z)));
            }
            ckh.O0000Oo0 = z;
        }
        fvo.O000000o();
        if (!fvo.O0000oo0()) {
            ckh.O00000oO = O00000Oo;
        }
        if (z2) {
            return new cja(frameLayout);
        }
        return new cjc(frameLayout);
    }
}
