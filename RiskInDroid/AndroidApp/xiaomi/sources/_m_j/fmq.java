package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.RouterDevice;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.miio.device.GeneralAPDevice;
import com.xiaomi.smarthome.miio.device.TemporaryDevice;
import java.util.List;

public interface fmq extends gze {
    void addChangeNetWorkId(int i);

    void addGeneralAPDevice(Device device);

    void addIrController(Activity activity, int i);

    void bindMiTVDevice(Context context, MiTVDevice miTVDevice, ftt<Void> ftt);

    void bindRouterDevice(Context context, RouterDevice routerDevice, ftt<Void> ftt);

    String[] findDeviceIdsByGroupInfo(fni fni);

    fni findVirtualGroupByModel(List<fni> list, String str);

    List<fni> getAllModelGroups();

    int getChangeNetworkId();

    DeviceTagInterface<Device> getDeviceTagManager();

    TemporaryDevice getTemporaryDevice(String str);

    List<fni> getUsableGroups();

    GeneralAPDevice newGeneralAPDevice(String str);

    void setGeneralAPDeviceEnable(boolean z, String str);

    void setTemporaryDeviceShow(String str, boolean z);

    boolean shouldTemporaryDeviceShow(String str);

    void startIRPlugin(Context context, Intent intent);

    void updateUsableGroupInfo(List<fni> list);
}
