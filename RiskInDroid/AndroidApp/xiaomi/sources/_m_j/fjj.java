package _m_j;

import _m_j.fjf;
import com.xiaomi.smarthome.core.entity.device.ScanType;
import com.xiaomi.smarthome.device.Device;
import java.util.List;

public final class fjj extends fjl {
    public final void O000000o(ScanType scanType, fjf.O000000o o000000o) {
        if (scanType.ordinal() != ScanType.ALL.ordinal()) {
            o000000o.O000000o(O000000o(null));
            return;
        }
        List<Device> O00000oO = fqc.O0000O0o().O00000oO();
        o000000o.O000000o(O000000o(O00000oO));
        this.f16478O000000o.addAll(O00000oO);
    }
}
