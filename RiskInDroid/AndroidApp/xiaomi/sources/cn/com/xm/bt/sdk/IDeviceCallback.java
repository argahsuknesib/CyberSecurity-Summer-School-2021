package cn.com.xm.bt.sdk;

public interface IDeviceCallback {
    void onAuthStateChanged(int i, int i2);

    void onConnectionStateChanged(int i);

    byte[] onSignature(String str, String str2);
}
