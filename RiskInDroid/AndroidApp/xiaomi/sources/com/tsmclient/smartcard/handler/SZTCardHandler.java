package com.tsmclient.smartcard.handler;

import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.ReaderUtil;
import com.tsmclient.smartcard.apdu.ReadBinaryCommand;
import com.tsmclient.smartcard.apdu.SelectCommand;
import com.tsmclient.smartcard.exception.UnProcessableCardException;
import com.tsmclient.smartcard.terminal.APDUConstants;
import java.io.IOException;
import java.util.HashMap;

public class SZTCardHandler extends BaseTransCardHandler {
    private static final ByteArray SZT_CARD_AID = ByteArray.wrap(new byte[]{80, 65, 89, 46, 83, 90, 84});
    private static final ByteArray SZT_FID = ByteArray.wrap(new byte[]{16, 1});

    /* access modifiers changed from: protected */
    public String getCardType() {
        return "SZT";
    }

    /* access modifiers changed from: protected */
    public void selectVerify() throws IOException, UnProcessableCardException {
        SelectCommand selectCommand = new SelectCommand();
        selectCommand.setP1((byte) 4);
        if (this.mInternalRead) {
            selectCommand.setData(APDUConstants.AID_SZT);
            assertResponse(transceive(selectCommand.toRawAPDU().toBytes()), "failed to select SZT AID");
            selectCommand.setP1((byte) 0);
            selectCommand.setData(SZT_FID);
            assertResponse(transceive(selectCommand.toRawAPDU().toBytes()), "failed to select SZT FID");
            return;
        }
        selectCommand.setData(SZT_CARD_AID);
        assertResponse(transceive(selectCommand.toRawAPDU().toBytes()), "failed to select SZT AID");
    }

    /* access modifiers changed from: protected */
    public HashMap<String, String> getCardNumAndValidDate() throws IOException, UnProcessableCardException {
        HashMap<String, String> hashMap = new HashMap<>();
        ReadBinaryCommand readBinaryCommand = new ReadBinaryCommand();
        readBinaryCommand.setP1((byte) -107);
        byte[] transceive = transceive(readBinaryCommand.toRawAPDU().toBytes());
        assertResponse(transceive, "failed to get card num");
        String cardNum = getCardNum(ByteArray.wrap(transceive, 16, 4));
        String bytesToHexString = Coder.bytesToHexString(ByteArray.wrap(transceive, 20, 4).toBytes());
        String bytesToHexString2 = Coder.bytesToHexString(ByteArray.wrap(transceive, 24, 4).toBytes());
        hashMap.put("account_num", cardNum);
        hashMap.put("valid_start", bytesToHexString);
        hashMap.put("valid_end", bytesToHexString2);
        return hashMap;
    }

    private String getCardNum(ByteArray byteArray) {
        return Integer.toString(Coder.bytesToInt(Coder.str2Bcd(ReaderUtil.invertString(Coder.bytesToHexString(byteArray.toBytes()), 2))));
    }

    /* access modifiers changed from: protected */
    public int getBalance() throws IOException, UnProcessableCardException {
        byte[] transceive = transceive(GET_BALANCE_CMD.toBytes());
        assertResponse(transceive, "failed to get balance");
        return Coder.bytesToInt(ByteArray.wrap(transceive, 0, 4).toBytes()) - Integer.MIN_VALUE;
    }
}
