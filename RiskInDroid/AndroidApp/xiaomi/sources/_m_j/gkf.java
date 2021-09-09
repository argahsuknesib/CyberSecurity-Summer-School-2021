package _m_j;

import android.os.Bundle;

public interface gkf {
    htl getPollDeviceCallback();

    byte[] getScanRecord(String str);

    boolean isComboWithLogin();

    boolean isRestoreWifi();

    void notifyBleStatus(int i);

    void notifyMessage(int i, Bundle bundle);

    void onBindPassportSuccess();

    void onConnectBleResult(int i, String str, String str2);

    void onError(int i, Object obj);

    void onGetBindKeySuccess(String str);

    void onLoginResult(String str);

    void onSendPwdAndPwdResult(int i);

    void onStartConnectBle(String str);

    void onStartPollNewDevice();

    void receiveBleDisconnect(String str, String str2);

    void startPassportAuth();
}
