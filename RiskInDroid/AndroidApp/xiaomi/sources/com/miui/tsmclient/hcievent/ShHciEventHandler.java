package com.miui.tsmclient.hcievent;

import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.terminal.APDUConstants;

public class ShHciEventHandler extends AbsTransportationEventHandler {
    /* access modifiers changed from: protected */
    public HciEventInfo doHandleData(String str, long j, ByteArray byteArray) {
        return new HciEventInfo(str, j, Coder.bytesToInt(byteArray.duplicate(4, 4).toBytes()), Coder.bytesToInt(byteArray.duplicate(0, 4).toBytes()) - 800, false);
    }

    public boolean isSupport(byte[] bArr, byte[] bArr2) {
        return ByteArray.equals(ByteArray.wrap(bArr), APDUConstants.AID_SPTC);
    }
}
