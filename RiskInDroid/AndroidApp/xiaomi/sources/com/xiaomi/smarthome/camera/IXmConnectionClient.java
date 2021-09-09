package com.xiaomi.smarthome.camera;

public interface IXmConnectionClient {

    public interface XmActionCallback {
        void onFailed(int i, String str);

        void onSuccess(String str, Object obj);
    }

    boolean isConnected();

    boolean isPaused();

    void pauseRN(ICameraPlayerListener iCameraPlayerListener);

    void reconnect();

    void releaseRN(boolean z, ICameraPlayerListener iCameraPlayerListener);

    void releaseRN(boolean z, ICameraPlayerListener iCameraPlayerListener, boolean z2);

    boolean resume();

    void runInP2pThread(Runnable runnable);

    void sendAudioData(byte[] bArr, int i);

    void sendP2pCmd(int i, String str, XmActionCallback xmActionCallback);

    void sendP2pCmd(int i, byte[] bArr, XmActionCallback xmActionCallback);

    void sendRdtCmd(byte[] bArr, XmActionCallback xmActionCallback);

    void sendRdtCmd(byte[] bArr, boolean z, XmActionCallback xmActionCallback);

    void setAutoVideo(boolean z);

    void setCallStatus(boolean z);

    void setCurrentDeviceUseFixedRdtChannel(boolean z);

    void setStreamClient(ICameraPlayerListener iCameraPlayerListener);

    void startConnect(int i, XmActionCallback xmActionCallback);

    void startConnect(XmActionCallback xmActionCallback);

    void startConnect(XmActionCallback xmActionCallback, MissConfig missConfig);

    void updateInfo(XmP2PInfo xmP2PInfo);

    void useHualaiEncrypted(boolean z);

    void wakeUpDevice(XmActionCallback xmActionCallback);
}
