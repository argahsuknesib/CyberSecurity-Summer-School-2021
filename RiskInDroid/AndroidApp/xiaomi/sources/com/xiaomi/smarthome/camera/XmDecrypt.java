package com.xiaomi.smarthome.camera;

public interface XmDecrypt {
    String byteToString(byte[] bArr);

    void getKeyPair(byte[] bArr, byte[] bArr2);

    byte[] getShareKey(byte[] bArr, byte[] bArr2);

    byte[] stringToByte(String str);
}
