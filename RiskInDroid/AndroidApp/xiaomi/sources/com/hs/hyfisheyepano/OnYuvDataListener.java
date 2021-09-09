package com.hs.hyfisheyepano;

public interface OnYuvDataListener {
    void onParam(String str);

    void onTimestamp(long j);

    void onYuv(byte[] bArr, int i, int i2);
}
