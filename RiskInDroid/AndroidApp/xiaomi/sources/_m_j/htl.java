package _m_j;

import com.xiaomi.smarthome.device.Device;
import java.util.List;

public interface htl {
    void onDeviceConnectionFailure();

    void onDeviceConnectionSuccess(List<Device> list);
}
