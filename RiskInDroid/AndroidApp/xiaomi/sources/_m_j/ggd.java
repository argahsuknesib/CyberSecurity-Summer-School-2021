package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ggd {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final List<String> f17733O000000o;

    static {
        ArrayList arrayList = new ArrayList();
        f17733O000000o = arrayList;
        arrayList.add("yeelink.light.virtual");
        f17733O000000o.add("philips.light.virtual");
    }

    public static boolean O000000o(String str) {
        if (!TextUtils.isEmpty(str) && f17733O000000o.contains(str)) {
            return true;
        }
        return false;
    }

    public static List<Device> O000000o() {
        ArrayList arrayList = new ArrayList();
        Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
        ArrayList<Device> arrayList2 = new ArrayList<>();
        for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
            Device device = (Device) value.getValue();
            if (device.isVirtualDevice()) {
                arrayList2.add(device);
            }
        }
        if (arrayList2.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList3 = new ArrayList();
        for (Device device2 : arrayList2) {
            if (f17733O000000o.contains(device2.model)) {
                arrayList3.add(device2);
            }
        }
        return arrayList3;
    }
}
