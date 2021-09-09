package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.device.BtDevice;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import java.util.List;

public final class fpx extends fqa {
    public final void O000000o(Context context) {
        fec.O000000o(context).O000000o();
    }

    public final void O000000o(fkv<Integer, Integer> fkv) throws Exception {
        ffr.O000000o(fkv);
    }

    public final List<Device> O000000o() {
        return fiz.O000000o().O00000o0();
    }

    public final void O000000o(List<Device> list) {
        fiz O000000o2 = fiz.O000000o();
        ArrayList arrayList = new ArrayList();
        for (Device next : list) {
            if (next.getPid() == 6 || TextUtils.equals(next.getModel(), "lumi.lock.wbmcn1") || fec.O00000o0().O0000OOo(next.getModel())) {
                arrayList.add(new BtDevice(next));
            }
        }
        synchronized (O000000o2.O00000Oo) {
            O000000o2.O000000o(arrayList);
        }
    }

    public final boolean O000000o(Device device) {
        return device instanceof BtDevice;
    }

    public final boolean O00000Oo(Device device) {
        if (device instanceof BtDevice) {
            BtDevice btDevice = (BtDevice) device;
            if (btDevice.getMac().equals(btDevice.getDid()) || ffr.O0000o0(btDevice.getMac()) != 2) {
                return true;
            }
        }
        return false;
    }
}
