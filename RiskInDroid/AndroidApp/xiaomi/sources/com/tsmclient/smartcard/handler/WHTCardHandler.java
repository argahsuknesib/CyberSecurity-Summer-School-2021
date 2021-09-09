package com.tsmclient.smartcard.handler;

import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.apdu.ReadBinaryCommand;
import com.tsmclient.smartcard.apdu.SelectCommand;
import com.tsmclient.smartcard.exception.UnProcessableCardException;
import com.tsmclient.smartcard.terminal.APDUConstants;
import java.io.IOException;
import java.util.HashMap;

public class WHTCardHandler extends BaseTransCardHandler {
    private static final ByteArray PIN_AUTH_CMD = ByteArray.wrap(new byte[]{0, 32, 0, 0, 3, 18, 52, 86});
    private static final ByteArray SELECT_MF = ByteArray.wrap(new byte[]{63, 0});
    private static final ByteArray WHT_ENTITY_AID = ByteArray.wrap(new byte[]{65, 80, 49, 46, 87, 72, 67, 84, 67});
    private boolean mIsSeCard;

    /* access modifiers changed from: protected */
    public String getCardType() {
        return "WHT";
    }

    /* access modifiers changed from: protected */
    public void selectVerify() throws IOException, UnProcessableCardException {
        SelectCommand selectCommand = new SelectCommand();
        selectCommand.setP1((byte) 4);
        selectCommand.setData(this.mInternalRead ? APDUConstants.AID_WHT : WHT_ENTITY_AID);
        byte[] transceive = transceive(selectCommand.toRawAPDU().toBytes());
        this.mIsSeCard = this.mInternalRead;
        if (transceive == null || transceive.length < 2) {
            throw new IOException("failed to select WHT AID");
        }
        if (!this.mInternalRead && !ByteArray.equals(STATUS_OK, ByteArray.wrap(transceive, transceive.length - 2, 2))) {
            selectCommand.setData(APDUConstants.AID_WHT);
            transceive = transceive(selectCommand.toRawAPDU().toBytes());
            this.mIsSeCard = true;
        }
        assertResponse(transceive, "failed to select WHT AID");
        if (this.mIsSeCard) {
            selectCommand.setP1((byte) 0);
            selectCommand.setData(ByteArray.wrap(new byte[]{16, 1}));
            assertResponse(transceive(selectCommand.toRawAPDU().toBytes()), "failed to select 10 01");
        } else if (!this.mInternalRead) {
            selectCommand.setP1((byte) 0);
            selectCommand.setData(SELECT_MF);
            assertResponse(transceive(selectCommand.toRawAPDU().toBytes()), "failed to select MF");
        }
    }

    /* access modifiers changed from: protected */
    public void otherVerify() throws IOException, UnProcessableCardException {
        if (!this.mIsSeCard) {
            SelectCommand selectCommand = new SelectCommand();
            selectCommand.setP1((byte) 4);
            selectCommand.setData(WHT_ENTITY_AID);
            assertResponse(transceive(selectCommand.toRawAPDU().toBytes()), "failed to select MF");
        }
    }

    /* access modifiers changed from: protected */
    public HashMap<String, String> getCardNumAndValidDate() throws IOException, UnProcessableCardException {
        if (this.mIsSeCard) {
            assertResponse(transceive(PIN_AUTH_CMD.toBytes()), "failed to auth pin");
        }
        HashMap<String, String> hashMap = new HashMap<>();
        ReadBinaryCommand readBinaryCommand = new ReadBinaryCommand();
        if (this.mIsSeCard) {
            readBinaryCommand.setP1((byte) -107);
            byte[] transceive = transceive(readBinaryCommand.toRawAPDU().toBytes());
            assertResponse(transceive, "failed to get card num");
            String cardNum = getCardNum(ByteArray.wrap(transceive, 12, 8).toBytes());
            String bytesToHexString = Coder.bytesToHexString(ByteArray.wrap(transceive, 20, 4).toBytes());
            String bytesToHexString2 = Coder.bytesToHexString(ByteArray.wrap(transceive, 24, 4).toBytes());
            hashMap.put("account_num", cardNum);
            hashMap.put("valid_start", bytesToHexString);
            hashMap.put("valid_end", bytesToHexString2);
        } else {
            readBinaryCommand.setP1((byte) -118);
            byte[] transceive2 = transceive(readBinaryCommand.toRawAPDU().toBytes());
            assertResponse(transceive2, "failed to get card num");
            String bytesToHexString3 = Coder.bytesToHexString(ByteArray.wrap(transceive2, 0, 5).toBytes());
            readBinaryCommand.setP1((byte) -123);
            byte[] transceive3 = transceive(readBinaryCommand.toRawAPDU().toBytes());
            assertResponse(transceive3, "failed to get valid time");
            String bytesToHexString4 = Coder.bytesToHexString(ByteArray.wrap(transceive3, 20, 4).toBytes());
            String bytesToHexString5 = Coder.bytesToHexString(ByteArray.wrap(transceive3, 16, 4).toBytes());
            hashMap.put("account_num", bytesToHexString3);
            hashMap.put("valid_start", bytesToHexString4);
            hashMap.put("valid_end", bytesToHexString5);
        }
        return hashMap;
    }

    private static String getCardNum(byte[] bArr) {
        String bytesToHexString = Coder.bytesToHexString(bArr);
        if (bytesToHexString == null || bytesToHexString.length() != 16) {
            return null;
        }
        String substring = bytesToHexString.substring(7);
        int i = 0;
        int i2 = 0;
        while (i < substring.length()) {
            int intValue = Integer.valueOf(String.valueOf(substring.charAt(i)), 16).intValue();
            i2 = i == 0 ? intValue : i2 ^ intValue;
            i++;
        }
        return substring + (i2 % 10);
    }
}
