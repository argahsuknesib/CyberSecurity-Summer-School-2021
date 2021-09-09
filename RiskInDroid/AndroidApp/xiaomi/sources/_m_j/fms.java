package _m_j;

import android.os.Bundle;
import com.xiaomi.smarthome.device.api.IBleCallback;

public interface fms {
    void bleMeshConnect(String str, String str2, IBleCallback iBleCallback);

    void bleStandardAuthConnect(String str, IBleCallback iBleCallback);

    void callBleApi(String str, int i, Bundle bundle, IBleCallback iBleCallback);

    void deviceRename(String str, String str2);

    String getMediaButtonModel();

    String getModelByMacFromRnruntime();

    void isBleGatewayExistInDeviceList(IBleCallback iBleCallback);

    void registerMediaButtonReceiver(String str);

    void secureConnect(String str, IBleCallback iBleCallback);

    void securityChipConnect(String str, IBleCallback iBleCallback);

    void securityChipSharedDeviceConnect(String str, IBleCallback iBleCallback);

    void unRegisterMediaButtonReceiver(String str);
}
