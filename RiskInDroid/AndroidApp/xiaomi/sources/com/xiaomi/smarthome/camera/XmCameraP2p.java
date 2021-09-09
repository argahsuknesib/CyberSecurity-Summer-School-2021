package com.xiaomi.smarthome.camera;

public interface XmCameraP2p {
    void connect();

    void direction(byte[] bArr);

    boolean isConnected();

    boolean isPaused();

    void pause(IClientListener iClientListener);

    void playBack(byte[] bArr);

    void playBackSpeed(byte[] bArr);

    void reconnect();

    void release(boolean z, IClientListener iClientListener);

    boolean resume();

    void runInP2pThread(Runnable runnable);

    void sendAudioData(byte[] bArr, int i);

    int sendIOCtrl(int i, byte[] bArr);

    void sendMsg(int i, int i2, byte[] bArr, P2pResponse p2pResponse);

    void setClientListener(IClientListener iClientListener);

    void setQuality(int i);

    void startSpeak();

    void stopSpeak();

    void updateInfo(XmP2PInfo xmP2PInfo);
}
