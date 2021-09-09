package _m_j;

import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfo;

public interface gfk {
    void checkBleUpdateInfo(String str, BleMeshFirmwareUpdateInfo bleMeshFirmwareUpdateInfo);

    void onCheckFail(int i);

    void onInstalling();

    void onSuccess();

    void onUpgradeFail(int i);

    void onUpgrading();

    void showLog(String str);

    void showProgress(int i);
}
