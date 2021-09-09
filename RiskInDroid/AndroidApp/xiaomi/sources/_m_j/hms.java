package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import com.xiaomi.smarthome.uwb.kuailian.callback.IConfigCompletionHandler;
import java.util.List;

public interface hms {
    void addBlackListForDevicePushBindManager(PushBindEntity pushBindEntity);

    void checkAiotDeviceWifi();

    void clearDevicePushBind();

    void doBindForDevicePushBindManager(String str);

    void doOpenUwbBleConfigActivity(String str, String str2, IConfigCompletionHandler iConfigCompletionHandler);

    void doScanOnPause(hmv hmv);

    void doScanOnResume(hmv hmv);

    Class<?> getDeviceObserveServiceClass();

    List<Device> getGatewayDevices(String str);

    Class<?> getResetPageRouteClass();

    Class<?> getScanBarcodeActivityClass();

    boolean isFindDeviceDialogShowing();

    void onFinishSmartConfig(String str, boolean z);

    void onStartSmartConfig(String str);

    void pauseMainConnectScanManager();

    void pauseXiaoMiRouterConnectionManager();

    void resumeMainConnectScanManager();

    void resumeXiaoMiRouterConnectionManager(Context context);

    void startDeviceObserveService();
}
