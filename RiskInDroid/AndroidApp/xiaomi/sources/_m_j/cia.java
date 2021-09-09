package _m_j;

public interface cia {
    void onConnected();

    void onDisConnected();

    void onDisconnectedWithCode(int i);

    void onPauseCamera();

    void onPrepare(int i);

    void onRetry(int i, String str, int i2);

    void onServerCmd(int i, byte[] bArr);

    void onVideoInfo(int i, int i2, int i3, int i4, int i5);

    void onVideoPlayError(int i, String str);
}
