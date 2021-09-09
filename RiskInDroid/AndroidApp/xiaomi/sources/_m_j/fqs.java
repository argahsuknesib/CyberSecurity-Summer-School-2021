package _m_j;

import com.xiaomi.smarthome.R;
import java.util.HashMap;

public final class fqs {

    /* renamed from: O000000o  reason: collision with root package name */
    private static HashMap<String, Integer[]> f16907O000000o;
    private static HashMap<String, Integer[]> O00000Oo;
    private static HashMap<String, Integer> O00000o;
    private static HashMap<String, Integer[]> O00000o0;

    static {
        HashMap<String, Integer[]> hashMap = new HashMap<>();
        f16907O000000o = hashMap;
        Integer valueOf = Integer.valueOf((int) R.drawable.device_list_remote_control_normal);
        Integer valueOf2 = Integer.valueOf((int) R.drawable.lock_list_remote_control_normal);
        hashMap.put("xiaomi.ir.v1", new Integer[]{valueOf, valueOf2});
        HashMap<String, Integer[]> hashMap2 = f16907O000000o;
        Integer valueOf3 = Integer.valueOf((int) R.drawable.device_list_intelligent_curtain);
        Integer valueOf4 = Integer.valueOf((int) R.drawable.lock_list_curtain_normal);
        hashMap2.put("xiaomi.curtain.v1", new Integer[]{valueOf3, valueOf4});
        f16907O000000o.put("xiaomi.ble.v1", new Integer[]{Integer.valueOf((int) R.drawable.intelligent_ble), Integer.valueOf((int) R.drawable.lock_list_bracelet_normal)});
        f16907O000000o.put("xiaomi.myphone.v1", new Integer[]{Integer.valueOf((int) R.drawable.device_list_phone), Integer.valueOf((int) R.drawable.lock_list_phone_normal)});
        HashMap<String, Integer[]> hashMap3 = f16907O000000o;
        Integer valueOf5 = Integer.valueOf((int) R.drawable.device_list_yeelight_real);
        hashMap3.put("yeelink.light.rgb1", new Integer[]{valueOf5, Integer.valueOf((int) R.drawable.lock_list_yeelight_normal)});
        f16907O000000o.put("yeelight.rgb.v1", new Integer[]{valueOf5, Integer.valueOf((int) R.drawable.lock_list_yeelight_normal)});
        f16907O000000o.put("xiaomi.phone_ir.t1", new Integer[]{valueOf, valueOf2});
        f16907O000000o.put("xiaomi.phone_ir.v1", new Integer[]{valueOf, valueOf2});
        HashMap<String, Integer[]> hashMap4 = new HashMap<>();
        O00000Oo = hashMap4;
        Integer valueOf6 = Integer.valueOf((int) R.drawable.lock_list_remote_control_disabled);
        hashMap4.put("xiaomi.ir.v1", new Integer[]{valueOf, valueOf6});
        O00000Oo.put("xiaomi.curtain.v1", new Integer[]{valueOf3, valueOf4});
        O00000Oo.put("xiaomi.ble.v1", new Integer[]{Integer.valueOf((int) R.drawable.intelligent_ble), Integer.valueOf((int) R.drawable.lock_list_bracelet_normal)});
        O00000Oo.put("xiaomi.myphone.v1", new Integer[]{Integer.valueOf((int) R.drawable.device_list_phone), Integer.valueOf((int) R.drawable.lock_list_phone_normal)});
        HashMap<String, Integer[]> hashMap5 = O00000Oo;
        Integer valueOf7 = Integer.valueOf((int) R.drawable.lock_list_yeelight_pressed);
        hashMap5.put("yeelink.light.rgb1", new Integer[]{valueOf5, valueOf7});
        O00000Oo.put("yeelight.rgb.v1", new Integer[]{valueOf5, valueOf7});
        O00000Oo.put("xiaomi.phone_ir.t1", new Integer[]{valueOf, valueOf6});
        O00000Oo.put("xiaomi.phone_ir.v1", new Integer[]{valueOf, valueOf6});
        HashMap<String, Integer[]> hashMap6 = new HashMap<>();
        O00000o0 = hashMap6;
        hashMap6.put("xiaomi.ir.v1", new Integer[]{valueOf, valueOf6});
        O00000o0.put("xiaomi.curtain.v1", new Integer[]{valueOf3, valueOf4});
        O00000o0.put("xiaomi.ble.v1", new Integer[]{Integer.valueOf((int) R.drawable.miband_offline), Integer.valueOf((int) R.drawable.lock_list_bracelet_off)});
        O00000o0.put("yeelink.light.rgb1", new Integer[]{valueOf5, valueOf7});
        O00000o0.put("yeelight.rgb.v1", new Integer[]{valueOf5, valueOf7});
        O00000o0.put("xiaomi.phone_ir.t1", new Integer[]{valueOf, valueOf6});
        O00000o0.put("xiaomi.phone_ir.v1", new Integer[]{valueOf, valueOf6});
        HashMap<String, Integer> hashMap7 = new HashMap<>();
        O00000o = hashMap7;
        hashMap7.put("ir.others", Integer.valueOf((int) R.drawable.ir_others));
        O00000o.put("ir.stb", Integer.valueOf((int) R.drawable.ir_stb));
        O00000o.put("ir.tv", Integer.valueOf((int) R.drawable.ir_tv));
        O00000o.put("ir.dvd", Integer.valueOf((int) R.drawable.ir_dvd));
        O00000o.put("ir.projector", Integer.valueOf((int) R.drawable.ir_projector));
        O00000o.put("ir.fan", Integer.valueOf((int) R.drawable.ir_fan));
        O00000o.put("ir.air", Integer.valueOf((int) R.drawable.ir_air));
        O00000o.put("ir.purifier", Integer.valueOf((int) R.drawable.ir_purifier));
        O00000o.put("ir.box", Integer.valueOf((int) R.drawable.ir_box));
        O00000o.put("ir.micontroller", Integer.valueOf((int) R.drawable.ir_mi_controller));
        O00000o.put("ir.camera", Integer.valueOf((int) R.drawable.ir_camera));
        O00000o.put("ir.amplifier", Integer.valueOf((int) R.drawable.ir_amplifier));
    }

    public static int O000000o(String str) {
        Integer[] numArr;
        if (str == null || (numArr = f16907O000000o.get(str)) == null || numArr.length <= 0) {
            return 0;
        }
        return numArr[0].intValue();
    }

    public static int O00000Oo(String str) {
        if (str == null || str.isEmpty() || O00000o.get(str) == null) {
            return 0;
        }
        return O00000o.get(str).intValue();
    }
}
