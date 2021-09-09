package com.miui.tsmclient.hcievent;

import com.miui.tsmclient.entity.CardConfigManager;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.terminal.APDUConstants;

public class CityUCardHciHandler extends AbsTransportationEventHandler {
    /* access modifiers changed from: protected */
    public HciEventInfo doHandleData(String str, long j, ByteArray byteArray) {
        int i;
        int i2;
        int i3;
        int i4;
        int length = byteArray.length();
        CardConfigManager.CardConfig cardConfig = CardConfigManager.getInstance().getCardConfig(str);
        if (cardConfig == null || cardConfig.getHCIRule(str) == null) {
            i4 = 23;
            i3 = 1;
            i2 = 19;
            i = 6;
        } else {
            CardConfigManager.HCIRule hCIRule = cardConfig.getHCIRule(str);
            i4 = hCIRule.getDataLength();
            i3 = hCIRule.getTradeAmountOffset();
            i2 = hCIRule.getBalanceOffset();
            i = hCIRule.getTerminalNo();
        }
        if (i4 > length) {
            return null;
        }
        String str2 = str;
        long j2 = j;
        HciEventInfo hciEventInfo = new HciEventInfo(str2, j2, Coder.bytesToInt(byteArray.duplicate(i3, 4).toBytes()), Coder.bytesToInt(byteArray.duplicate(i2, 4).toBytes()), false);
        if (i > 0) {
            hciEventInfo.setTerminalNo(Coder.bytesToHexString(byteArray.duplicate(i, 6).toBytes()));
        }
        return hciEventInfo;
    }

    public boolean isSupport(byte[] bArr, byte[] bArr2) {
        ByteArray wrap = ByteArray.wrap(bArr);
        boolean z = ByteArray.equals(wrap, APDUConstants.AID_HZT) || ByteArray.equals(wrap, APDUConstants.AID_LNT) || ByteArray.equals(wrap, APDUConstants.AID_SUZHOUTONG) || ByteArray.equals(wrap, APDUConstants.AID_WHT);
        CardConfigManager.CardConfig cardConfig = CardConfigManager.getInstance().getCardConfig(Coder.bytesToHexString(bArr));
        return z || (cardConfig != null && cardConfig.isSupportCityUHci(wrap.toString()));
    }
}
