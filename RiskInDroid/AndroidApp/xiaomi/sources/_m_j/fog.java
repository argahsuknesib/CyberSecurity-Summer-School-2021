package _m_j;

import com.xiaomi.smarthome.core.entity.device.BtDevice;
import com.xiaomi.smarthome.device.BleDevice;
import java.util.ArrayList;
import java.util.List;

public final class fog {
    public static List<BleDevice> O000000o(List<BtDevice> list) {
        ArrayList arrayList = new ArrayList();
        if (!gpn.O000000o(list)) {
            for (BtDevice O000000o2 : list) {
                arrayList.add(BleDevice.O000000o(O000000o2));
            }
        }
        return arrayList;
    }
}
