package _m_j;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.device.BtDevice;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile;
import java.util.List;

public final class foc {
    public static void O000000o(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.value", str2);
        CoreApi.O000000o().O00000Oo(str, 1, bundle);
    }

    public static void O00000Oo(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.value", str2);
        CoreApi.O000000o().O00000Oo(str, 16, bundle);
    }

    public static void O00000o0(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.value", str2);
        CoreApi.O000000o().O00000Oo(str, 2, bundle);
    }

    public static String O000000o(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 2, bundle);
        return bundle.getString("extra.result", "");
    }

    public static int O00000Oo(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 12, bundle);
        return bundle.getInt("extra.result", 0);
    }

    public static int O00000o0(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 14, bundle);
        return bundle.getInt("extra.result", -60);
    }

    public static String O00000o(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 4, bundle);
        return bundle.getString("extra.result", "");
    }

    public static void O00000o(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.value", str2);
        CoreApi.O000000o().O00000Oo(str, 10, bundle);
    }

    public static String O00000oO(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 10, bundle);
        return bundle.getString("extra.result", "");
    }

    public static byte[] O00000oo(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 8, bundle);
        return bundle.getByteArray("extra.result");
    }

    public static BleGattProfile O0000O0o(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 9, bundle);
        return (BleGattProfile) bundle.getParcelable("extra.result");
    }

    public static void O000000o(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("extra.value", i);
        CoreApi.O000000o().O00000Oo(str, 5, bundle);
    }

    public static int O0000OOo(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 5, bundle);
        return bundle.getInt("extra.result", 0);
    }

    public static void O0000Oo0(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("extra.value", 0);
        CoreApi.O000000o().O00000Oo(str, 15, bundle);
    }

    public static String O0000Oo(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 6, bundle);
        return bundle.getString("extra.result", "");
    }

    public static byte[] O0000OoO(String str) {
        String O0000Oo = O0000Oo(str);
        return TextUtils.isEmpty(O0000Oo) ? got.f18097O000000o : got.O000000o(O0000Oo);
    }

    public static void O00000oO(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo("BleCacheUtil set prop mac is empty");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            fte.O00000Oo("BleCacheUtil set prop token empty");
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra.value", str2);
        CoreApi.O000000o().O00000Oo(str, 6, bundle);
    }

    public static String O0000Ooo(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 19, bundle);
        return bundle.getString("extra.result", "");
    }

    public static void O00000oo(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo(String.format("setPropLtmk mac null", new Object[0]));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra.value", str2);
        CoreApi.O000000o().O00000Oo(str, 19, bundle);
    }

    public static void O000000o(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            fte.O00000Oo(String.format("setPropExtra mac null", new Object[0]));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra.key", str2);
        bundle.putString("extra.value", str3);
        CoreApi.O000000o().O00000Oo(str, 7, bundle);
    }

    public static String O0000O0o(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("extra.key", str2);
        CoreApi.O000000o().O000000o(str, 7, bundle);
        return bundle.getString("extra.result", "");
    }

    public static String O0000o00(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 21, bundle);
        return bundle.getString("extra.result", "");
    }

    public static void O0000OOo(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo(String.format("setPropPincode mac null", new Object[0]));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra.value", str2);
        CoreApi.O000000o().O00000Oo(str, 21, bundle);
    }

    public static int O0000o0(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 22, bundle);
        return bundle.getInt("extra.result", 0);
    }

    public static void O00000Oo(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo(String.format("setPropLtmkEncryptType mac null", new Object[0]));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("extra.value", i);
        CoreApi.O000000o().O00000Oo(str, 22, bundle);
    }

    public static boolean O0000o0O(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 23, bundle);
        return bundle.getBoolean("extra.result", true);
    }

    public static void O000000o(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            fte.O00000Oo(String.format("setPropShowPincode mac null", new Object[0]));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("extra.value", z);
        CoreApi.O000000o().O00000Oo(str, 23, bundle);
    }

    public static String O0000o0o(String str) {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o(str, 20, bundle);
        return bundle.getString("extra.result", "");
    }

    public static List<BleDevice> O000000o() {
        Bundle bundle = new Bundle();
        CoreApi.O000000o().O000000o((String) null, 101, bundle);
        bundle.setClassLoader(BtDevice.class.getClassLoader());
        return fog.O000000o(bundle.getParcelableArrayList("extra.devices"));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.foc.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.foc.O000000o(java.lang.String, int):void
      _m_j.foc.O000000o(java.lang.String, java.lang.String):void
      _m_j.foc.O000000o(java.lang.String, boolean):void */
    public static void O0000o(String str) {
        fte.O00000Oo("BleCacheUtils, remove PropToken ,Ltmk, pincode ...");
        O00000oO(str, "");
        O00000oo(str, "");
        O0000OOo(str, "");
        O00000Oo(str, 0);
        O000000o(str, true);
    }
}
