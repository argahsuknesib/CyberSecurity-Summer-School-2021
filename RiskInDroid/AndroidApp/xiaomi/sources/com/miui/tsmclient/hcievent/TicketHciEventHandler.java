package com.miui.tsmclient.hcievent;

import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.terminal.APDUConstants;

public class TicketHciEventHandler extends AbsTransportationEventHandler {
    /* access modifiers changed from: protected */
    public HciEventInfo doHandleData(String str, long j, ByteArray byteArray) {
        int i = 0;
        byte b = byteArray.get(0);
        if (b != 1) {
            i = b == 16 ? 1 : b == -1 ? 2 : -1;
        }
        return new HciEventInfo(str, j, i);
    }

    public boolean isSupport(byte[] bArr, byte[] bArr2) {
        ByteArray wrap = ByteArray.wrap(bArr);
        return ByteArray.equals(wrap, APDUConstants.AID_ST_ONE_DAY_PASS) || ByteArray.equals(wrap, APDUConstants.AID_ST_THREE_DAY_PASS);
    }
}
