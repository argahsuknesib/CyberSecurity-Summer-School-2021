package com.miui.tsmclient.hcievent;

import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.exception.InvalidTLVException;
import com.tsmclient.smartcard.exception.TagNotFoundException;
import com.tsmclient.smartcard.terminal.APDUConstants;
import com.tsmclient.smartcard.tlv.TLVParser;

public class BankHciEventHandler implements IHciEventHandler {
    private ByteArray TAG_AMOUNT = ByteArray.wrap(new byte[]{-97, 2});
    private ByteArray TAG_CURRENCY = ByteArray.wrap(new byte[]{95, 42});
    private ByteArray TAG_TIME = ByteArray.wrap(new byte[]{-102, 3});
    private ByteArray TAG_TRANSACTION_EVENT = ByteArray.wrap(new byte[]{-30, 1});

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.hcievent.HciEventInfo.<init>(java.lang.String, long, boolean):void
     arg types: [java.lang.String, long, int]
     candidates:
      com.miui.tsmclient.hcievent.HciEventInfo.<init>(java.lang.String, long, int):void
      com.miui.tsmclient.hcievent.HciEventInfo.<init>(java.lang.String, long, boolean):void */
    public HciEventInfo handleData(byte[] bArr, long j, byte[] bArr2) {
        if (bArr2 == null || bArr2.length == 0 || !ByteArray.equals(this.TAG_TRANSACTION_EVENT, ByteArray.wrap(bArr2, 0, 2))) {
            return null;
        }
        if (bArr2.length >= 36) {
            try {
                return new HciEventInfo(Coder.bytesToHexString(bArr), j, Integer.valueOf(Coder.bytesToHexString(TLVParser.parse(ByteArray.wrap(bArr2, bArr2.length - 36, 36)).getValue().findTLV(this.TAG_AMOUNT).getValue().toBytes().toBytes())).intValue(), true);
            } catch (InvalidTLVException | TagNotFoundException e) {
                LogUtils.e("failed to handle bank hci event data", e);
            }
        }
        return new HciEventInfo(Coder.bytesToHexString(bArr), j, true);
    }

    public boolean isSupport(byte[] bArr, byte[] bArr2) {
        return Coder.bytesToHexString(bArr).startsWith(Coder.bytesToHexString(APDUConstants.PBOC_CARD_AID_PREFFIX));
    }
}
