package _m_j;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.RouterDevice;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miio.device.GeneralAPDevice;
import java.util.List;

public final class fml {
    public static String O000000o() {
        return Build.MODEL + "_ir";
    }

    public static boolean O000000o(Device device) {
        if (device == null || device.isOwner() || O000000o(device.did) || device.isVirtualDevice() || (device instanceof MiTVDevice) || (device instanceof RouterDevice) || (device instanceof GeneralAPDevice)) {
            return false;
        }
        if (!(device instanceof BleDevice) || !((BleDevice) device).O00000oO()) {
            return true;
        }
        return false;
    }

    public static boolean O000000o(String str) {
        if (!TextUtils.isEmpty(str) && str.equals(O000000o())) {
            return true;
        }
        return false;
    }

    public static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("xiaomi.tv");
    }

    public static int O000000o(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        String[] split = str.split("[._]");
        String[] split2 = str2.split("[._]");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        while (i < min) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt != parseInt2) {
                    return parseInt - parseInt2;
                }
                i++;
            } catch (Exception e) {
                gnk.O00000Oo(gnk.O00000Oo(e));
                return 0;
            }
        }
        return split.length - split2.length;
    }

    public static String O00000o0(String str) {
        PluginDeviceInfo O00000oO;
        if (str == null || !CoreApi.O000000o().O00000o(str) || (O00000oO = CoreApi.O000000o().O00000oO(str)) == null) {
            return null;
        }
        return O00000oO.O0000o0();
    }

    public static String O00000Oo(Device device) {
        try {
            if (!TextUtils.isEmpty(device.specUrn)) {
                return device.specUrn.split(":")[3];
            }
            return null;
        } catch (Exception e) {
            Log.e("DeviceUtils", "getTypeName", e);
            return null;
        }
    }

    public static boolean O000000o(PluginDeviceInfo pluginDeviceInfo) {
        if (pluginDeviceInfo == null || pluginDeviceInfo.O00000o() != 4) {
            return false;
        }
        List<Integer> O0000O0o = pluginDeviceInfo.O0000O0o();
        if (O0000O0o == null || O0000O0o.size() == 0 || O0000O0o.contains(2)) {
            return true;
        }
        return false;
    }
}
