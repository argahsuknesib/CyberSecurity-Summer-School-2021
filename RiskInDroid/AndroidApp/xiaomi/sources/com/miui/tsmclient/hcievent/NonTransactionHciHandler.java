package com.miui.tsmclient.hcievent;

import com.miui.tsmclient.entity.f;
import com.miui.tsmclient.hcievent.HciEventInfo;
import com.miui.tsmclient.model.h;
import com.tsmclient.smartcard.Coder;

public class NonTransactionHciHandler implements IHciEventHandler {
    private f mNonTransactionHciEvent;

    public HciEventInfo handleData(byte[] bArr, long j, byte[] bArr2) {
        f fVar = this.mNonTransactionHciEvent;
        if (fVar != null) {
            f.a b = fVar.b(Coder.bytesToHexString(bArr2));
            HciEventInfo hciEventInfo = new HciEventInfo(Coder.bytesToHexString(bArr), HciEventInfo.HciEventType.getHciEventType(b.c()));
            hciEventInfo.mTradeTime = j;
            hciEventInfo.setTradeState(b.b());
            hciEventInfo.setDescription(b.a());
            return hciEventInfo;
        }
        throw new IllegalArgumentException(Coder.bytesToHexString(bArr) + " is not supported");
    }

    public boolean isSupport(byte[] bArr, byte[] bArr2) {
        this.mNonTransactionHciEvent = h.a().a(Coder.bytesToHexString(bArr));
        return this.mNonTransactionHciEvent != null;
    }
}
