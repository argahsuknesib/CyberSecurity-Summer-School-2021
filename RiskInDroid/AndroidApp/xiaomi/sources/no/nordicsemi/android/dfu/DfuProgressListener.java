package no.nordicsemi.android.dfu;

public interface DfuProgressListener {
    void onDeviceConnected(String str);

    void onDeviceConnecting(String str);

    void onDeviceDisconnected(String str);

    void onDeviceDisconnecting(String str);

    void onDfuAborted(String str);

    void onDfuCompleted(String str);

    void onDfuProcessStarted(String str);

    void onDfuProcessStarting(String str);

    void onEnablingDfuMode(String str);

    void onError(String str, int i, int i2, String str2);

    void onFirmwareValidating(String str);

    void onProgressChanged(String str, int i, float f, float f2, int i2, int i3);
}
