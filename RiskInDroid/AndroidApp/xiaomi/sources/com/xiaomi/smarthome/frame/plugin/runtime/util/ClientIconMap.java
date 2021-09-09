package com.xiaomi.smarthome.frame.plugin.runtime.util;

import com.xiaomi.smarthome.R;
import java.util.HashMap;

public class ClientIconMap {
    private static HashMap<String, Integer[]> iconName2Res;
    private static HashMap<String, Integer[]> iconNameClose2Res;
    private static HashMap<String, Integer[]> iconNameOffline2Res;

    static {
        HashMap<String, Integer[]> hashMap = new HashMap<>();
        iconName2Res = hashMap;
        Integer valueOf = Integer.valueOf((int) R.drawable.device_list_remote_control_normal);
        Integer valueOf2 = Integer.valueOf((int) R.drawable.lock_list_remote_control_normal);
        hashMap.put("xiaomi.ir.v1", new Integer[]{valueOf, valueOf2});
        HashMap<String, Integer[]> hashMap2 = iconName2Res;
        Integer valueOf3 = Integer.valueOf((int) R.drawable.device_list_intelligent_curtain);
        Integer valueOf4 = Integer.valueOf((int) R.drawable.lock_list_curtain_normal);
        hashMap2.put("xiaomi.curtain.v1", new Integer[]{valueOf3, valueOf4});
        iconName2Res.put("xiaomi.ble.v1", new Integer[]{Integer.valueOf((int) R.drawable.intelligent_ble), Integer.valueOf((int) R.drawable.lock_list_bracelet_normal)});
        iconName2Res.put("xiaomi.myphone.v1", new Integer[]{Integer.valueOf((int) R.drawable.device_list_phone), Integer.valueOf((int) R.drawable.lock_list_phone_normal)});
        HashMap<String, Integer[]> hashMap3 = iconName2Res;
        Integer valueOf5 = Integer.valueOf((int) R.drawable.device_list_yeelight_real);
        hashMap3.put("yeelink.light.rgb1", new Integer[]{valueOf5, Integer.valueOf((int) R.drawable.lock_list_yeelight_normal)});
        iconName2Res.put("yeelight.rgb.v1", new Integer[]{valueOf5, Integer.valueOf((int) R.drawable.lock_list_yeelight_normal)});
        iconName2Res.put("xiaomi.phone_ir.t1", new Integer[]{valueOf, valueOf2});
        iconName2Res.put("xiaomi.phone_ir.v1", new Integer[]{valueOf, valueOf2});
        HashMap<String, Integer[]> hashMap4 = new HashMap<>();
        iconNameClose2Res = hashMap4;
        Integer valueOf6 = Integer.valueOf((int) R.drawable.lock_list_remote_control_disabled);
        hashMap4.put("xiaomi.ir.v1", new Integer[]{valueOf, valueOf6});
        iconNameClose2Res.put("xiaomi.curtain.v1", new Integer[]{valueOf3, valueOf4});
        iconNameClose2Res.put("xiaomi.ble.v1", new Integer[]{Integer.valueOf((int) R.drawable.intelligent_ble), Integer.valueOf((int) R.drawable.lock_list_bracelet_normal)});
        iconNameClose2Res.put("xiaomi.myphone.v1", new Integer[]{Integer.valueOf((int) R.drawable.device_list_phone), Integer.valueOf((int) R.drawable.lock_list_phone_normal)});
        HashMap<String, Integer[]> hashMap5 = iconNameClose2Res;
        Integer valueOf7 = Integer.valueOf((int) R.drawable.lock_list_yeelight_pressed);
        hashMap5.put("yeelink.light.rgb1", new Integer[]{valueOf5, valueOf7});
        iconNameClose2Res.put("yeelight.rgb.v1", new Integer[]{valueOf5, valueOf7});
        iconNameClose2Res.put("xiaomi.phone_ir.t1", new Integer[]{valueOf, valueOf6});
        iconNameClose2Res.put("xiaomi.phone_ir.v1", new Integer[]{valueOf, valueOf6});
        HashMap<String, Integer[]> hashMap6 = new HashMap<>();
        iconNameOffline2Res = hashMap6;
        hashMap6.put("xiaomi.ir.v1", new Integer[]{valueOf, valueOf6});
        iconNameOffline2Res.put("xiaomi.curtain.v1", new Integer[]{valueOf3, valueOf4});
        iconNameOffline2Res.put("xiaomi.ble.v1", new Integer[]{Integer.valueOf((int) R.drawable.miband_offline), Integer.valueOf((int) R.drawable.lock_list_bracelet_off)});
        iconNameOffline2Res.put("yeelink.light.rgb1", new Integer[]{valueOf5, valueOf7});
        iconNameOffline2Res.put("yeelight.rgb.v1", new Integer[]{valueOf5, valueOf7});
        iconNameOffline2Res.put("xiaomi.phone_ir.t1", new Integer[]{valueOf, valueOf6});
        iconNameOffline2Res.put("xiaomi.phone_ir.v1", new Integer[]{valueOf, valueOf6});
    }

    public static int getResource(String str) {
        Integer[] numArr;
        if (str == null || (numArr = iconName2Res.get(str)) == null || numArr.length <= 0) {
            return 0;
        }
        return numArr[0].intValue();
    }
}
