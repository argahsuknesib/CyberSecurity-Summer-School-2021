package com.miui.tsmclient.hcievent;

import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;

public class CQV2HciHandler extends AbsTransportationEventHandler {
    private static final ByteArray AID = ByteArray.wrap(new byte[]{67, 81, 81, 80, 65, 89, 46, 83, 89, 83, 51, 49});

    /* access modifiers changed from: protected */
    public HciEventInfo doHandleData(String str, long j, ByteArray byteArray) {
        ByteArray duplicate = byteArray.duplicate(2, 4);
        ByteArray duplicate2 = byteArray.duplicate(20, 4);
        ByteArray duplicate3 = byteArray.duplicate(7, 6);
        HciEventInfo hciEventInfo = new HciEventInfo(str, j, Coder.bytesToInt(duplicate.toBytes()), Coder.bytesToInt(duplicate2.toBytes()), false);
        hciEventInfo.setTerminalNo(Coder.bytesToHexString(duplicate3.toBytes()));
        return hciEventInfo;
    }

    public boolean isSupport(byte[] bArr, byte[] bArr2) {
        return ByteArray.equals(ByteArray.wrap(bArr), AID) && (bArr2 == null ? 0 : bArr2.length) == 24;
    }
}
