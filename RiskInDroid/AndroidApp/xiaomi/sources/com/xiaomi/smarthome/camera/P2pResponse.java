package com.xiaomi.smarthome.camera;

public interface P2pResponse {
    void onError(int i);

    void onResponse(int i, byte[] bArr);
}
