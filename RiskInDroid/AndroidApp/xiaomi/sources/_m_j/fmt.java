package _m_j;

import android.content.Context;
import com.xiaomi.router.miio.miioplugin.DeviceStatus;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceStat;

public interface fmt extends gze {
    void bindDevice(Device device, Context context, fmo fmo);

    boolean canBeDeleted(Device device);

    boolean canBeShared(Device device);

    boolean canRename(Device device);

    CharSequence getStatusDescription(Device device, Context context);

    String getSubtitleByDesc(Device device, Context context, boolean z);

    boolean isNoneClickableDevice(Device device);

    boolean isSupportCommonSwitch(Device device);

    DeviceStat newDeviceStat(Device device);

    DeviceStatus newDeviceStatus(Device device);
}
