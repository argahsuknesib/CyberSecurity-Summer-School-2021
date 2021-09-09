package com.miui.tsmclient.hcievent;

public interface IHciEventHandler {
    HciEventInfo handleData(byte[] bArr, long j, byte[] bArr2);

    boolean isSupport(byte[] bArr, byte[] bArr2);
}
