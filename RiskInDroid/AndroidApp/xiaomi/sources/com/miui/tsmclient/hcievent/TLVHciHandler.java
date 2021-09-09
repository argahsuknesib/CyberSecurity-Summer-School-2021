package com.miui.tsmclient.hcievent;

import android.text.TextUtils;
import com.miui.tsmclient.entity.CardConfigManager;
import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.exception.InvalidTLVException;
import com.tsmclient.smartcard.exception.TagNotFoundException;
import com.tsmclient.smartcard.tlv.ITLVObject;
import com.tsmclient.smartcard.tlv.TLVParser;
import java.util.regex.Pattern;

public class TLVHciHandler extends AbsTransportationEventHandler {
    private byte[] getTagValue(ITLVObject iTLVObject, String[] strArr) throws TagNotFoundException {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String hexStringToBytes : strArr) {
            iTLVObject = iTLVObject.getValue().findTLV(ByteArray.wrap(Coder.hexStringToBytes(hexStringToBytes)));
        }
        return iTLVObject.getValue().toBytes().toBytes();
    }

    private boolean isHciTradeEvent(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            return Pattern.compile(str).matcher(Coder.bytesToHexString(bArr)).matches();
        }
        LogUtils.d("regex is empty");
        return true;
    }

    /* access modifiers changed from: protected */
    public HciEventInfo doHandleData(String str, long j, ByteArray byteArray) {
        String str2;
        CardConfigManager.CardConfig cardConfig = CardConfigManager.getInstance().getCardConfig(str);
        if (cardConfig == null || cardConfig.getHciTLVRule(str) == null) {
            return null;
        }
        CardConfigManager.HciTLVRule hciTLVRule = cardConfig.getHciTLVRule(str);
        int tLVDataOffset = hciTLVRule.getTLVDataOffset();
        try {
            ITLVObject parse = TLVParser.parse(byteArray.duplicate(tLVDataOffset, byteArray.length() - tLVDataOffset));
            ByteArray wrap = ByteArray.wrap(getTagValue(parse, hciTLVRule.getTradeAmountTags()));
            if (hciTLVRule.getTradeAmountOffset() >= 0) {
                wrap = wrap.duplicate(hciTLVRule.getTradeAmountOffset(), 4);
            }
            ByteArray wrap2 = ByteArray.wrap(getTagValue(parse, hciTLVRule.getBalanceTags()));
            if (hciTLVRule.getBalanceOffset() >= 0) {
                wrap2 = wrap2.duplicate(hciTLVRule.getBalanceOffset(), 4);
            }
            HciEventInfo hciEventInfo = new HciEventInfo(str, j, Coder.bytesToInt(wrap.toBytes()), Coder.bytesToInt(wrap2.toBytes()), false);
            ByteArray wrap3 = ByteArray.wrap(getTagValue(parse, hciTLVRule.getTerminalNoTags()));
            if (hciTLVRule.getTradeAmountOffset() >= 0) {
                wrap3 = wrap3.duplicate(hciTLVRule.getTerminalNoOffset(), 6);
            }
            hciEventInfo.setTerminalNo(Coder.bytesToHexString(wrap3.toBytes()));
            return hciEventInfo;
        } catch (InvalidTLVException e) {
            e = e;
            str2 = "invalid tlv";
            LogUtils.e(str2, e);
            return null;
        } catch (IllegalArgumentException e2) {
            e = e2;
            str2 = "invalid tlv tags";
            LogUtils.e(str2, e);
            return null;
        } catch (TagNotFoundException e3) {
            e = e3;
            str2 = "error when parse tlv";
            LogUtils.e(str2, e);
            return null;
        }
    }

    public boolean isSupport(byte[] bArr, byte[] bArr2) {
        String bytesToHexString;
        CardConfigManager.CardConfig cardConfig;
        if (!(bArr2 == null || (cardConfig = CardConfigManager.getInstance().getCardConfig((bytesToHexString = Coder.bytesToHexString(bArr)))) == null || cardConfig.getHciTLVRule(bytesToHexString) == null)) {
            CardConfigManager.HciTLVRule hciTLVRule = cardConfig.getHciTLVRule(bytesToHexString);
            if (bArr2.length > hciTLVRule.getTLVDataOffset()) {
                return isHciTradeEvent(ByteArray.wrap(bArr2, 0, hciTLVRule.getTLVDataOffset()).toBytes(), hciTLVRule.getHciPrefix());
            }
        }
        return false;
    }
}
