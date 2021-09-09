package com.miui.tsmclient.hcievent;

import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.terminal.APDUConstants;

public class SZTHciHandler extends AbsTransportationEventHandler {
    /* access modifiers changed from: protected */
    public HciEventInfo doHandleData(String str, long j, ByteArray byteArray) {
        ByteArray byteArray2 = byteArray;
        int length = byteArray.length();
        ByteArray byteArray3 = ByteArray.EMPTY;
        ByteArray byteArray4 = ByteArray.EMPTY;
        ByteArray byteArray5 = ByteArray.EMPTY;
        boolean z = true;
        if (23 <= length) {
            byteArray3 = byteArray2.duplicate(1, 4);
            byteArray4 = byteArray2.duplicate(19, 4);
        } else if (17 == length) {
            byteArray3 = byteArray2.duplicate(3, 4);
            byteArray4 = byteArray2.duplicate(7, 4);
            byteArray5 = byteArray2.duplicate(11, 6);
            if (ByteArray.equals(ByteArray.wrap((byte) 0), byteArray2.duplicate(1, 1))) {
                z = false;
            }
        }
        HciEventInfo hciEventInfo = new HciEventInfo(str, j, Coder.bytesToInt(byteArray3.toBytes()), z ? Coder.bytesToInt(byteArray4.toBytes()) - Integer.MIN_VALUE : 0, false);
        hciEventInfo.setTradeState(z);
        hciEventInfo.setTerminalNo(Coder.bytesToHexString(byteArray5.toBytes()));
        return hciEventInfo;
    }

    public boolean isSupport(byte[] bArr, byte[] bArr2) {
        return ByteArray.equals(ByteArray.wrap(bArr), APDUConstants.AID_SZT);
    }
}
