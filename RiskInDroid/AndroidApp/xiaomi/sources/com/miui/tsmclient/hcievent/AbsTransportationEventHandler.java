package com.miui.tsmclient.hcievent;

import com.miui.tsmclient.entity.CardConfigManager;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;

public abstract class AbsTransportationEventHandler implements IHciEventHandler {
    /* access modifiers changed from: protected */
    public abstract HciEventInfo doHandleData(String str, long j, ByteArray byteArray);

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.hcievent.HciEventInfo.<init>(java.lang.String, long, boolean):void
     arg types: [java.lang.String, long, int]
     candidates:
      com.miui.tsmclient.hcievent.HciEventInfo.<init>(java.lang.String, long, int):void
      com.miui.tsmclient.hcievent.HciEventInfo.<init>(java.lang.String, long, boolean):void */
    public final HciEventInfo handleData(byte[] bArr, long j, byte[] bArr2) {
        String bytesToHexString = Coder.bytesToHexString(bArr);
        if (bArr2 == null || bArr2.length == 0) {
            return new HciEventInfo(bytesToHexString, j, false);
        }
        HciEventInfo doHandleData = doHandleData(bytesToHexString, j, ByteArray.wrap(bArr2));
        if (doHandleData != null) {
            CardConfigManager.CardConfig cardConfig = CardConfigManager.getInstance().getCardConfig(bytesToHexString);
            doHandleData.setData(Coder.bytesToHexString(bArr2));
            if (cardConfig != null) {
                bytesToHexString = cardConfig.getCardAid();
            }
            doHandleData.setHeadAid(bytesToHexString);
        }
        return doHandleData;
    }
}
