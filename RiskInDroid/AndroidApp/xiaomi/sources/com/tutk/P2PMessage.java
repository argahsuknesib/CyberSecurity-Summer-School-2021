package com.tutk;

import com.xiaomi.smarthome.camera.P2pResponse;

public class P2PMessage {
    public byte[] data;
    public boolean idDataEncrypted;
    public boolean isPureData;
    public int msgId = 0;
    public int reqId;
    public int resId;
    public P2pResponse resp;

    public P2PMessage(int i, int i2, int i3, byte[] bArr, P2pResponse p2pResponse) {
        this.msgId = i;
        this.resp = p2pResponse;
        this.resId = i3;
        this.reqId = i2;
        this.data = bArr;
    }

    public P2PMessage(byte[] bArr, P2pResponse p2pResponse) {
        this.data = bArr;
        this.resp = p2pResponse;
        this.isPureData = true;
    }

    public P2PMessage(int i, int i2, byte[] bArr, P2pResponse p2pResponse) {
        this.msgId = i;
        this.resp = p2pResponse;
        this.resId = i2;
        this.reqId = i;
        this.data = bArr;
    }

    public P2PMessage(byte[] bArr, P2pResponse p2pResponse, boolean z) {
        this.data = bArr;
        this.resp = p2pResponse;
        this.isPureData = true;
        this.idDataEncrypted = z;
    }
}
