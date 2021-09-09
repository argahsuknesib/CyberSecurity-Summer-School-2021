package com.tsmclient.smartcard.handler;

import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.apdu.ReadBinaryCommand;
import com.tsmclient.smartcard.apdu.SelectCommand;
import com.tsmclient.smartcard.exception.UnProcessableCardException;
import com.tsmclient.smartcard.model.TradeLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SuZhouTongCardHandler extends BaseTransCardHandler {
    private static final ByteArray GET_BALANCE_CMD = ByteArray.wrap(new byte[]{Byte.MIN_VALUE, 92, 0, 1, 4});
    private static final ByteArray PIN_AUTH_CMD = ByteArray.wrap(new byte[]{0, 32, 0, 0, 3, 18, 52, 86});
    private static final ByteArray SUZHOUTONG_AID = ByteArray.wrap(new byte[]{83, 85, 88, 73, 78, 46, 77, 70});

    /* access modifiers changed from: protected */
    public String getCardType() {
        return "SUZHOUTONG";
    }

    /* access modifiers changed from: protected */
    public void selectVerify() throws IOException, UnProcessableCardException {
        SelectCommand selectCommand = new SelectCommand();
        selectCommand.setP1((byte) 4);
        selectCommand.setData(SUZHOUTONG_AID);
        assertResponse(transceive(selectCommand.toRawAPDU().toBytes()), "failed to select SUZHOUTONG AID");
        selectCommand.setP1((byte) 0);
        selectCommand.setData(ByteArray.wrap(new byte[]{-33, 1}));
        assertResponse(transceive(selectCommand.toRawAPDU().toBytes()), "failed to select DF 01");
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getCardNumAndValidDate() throws IOException, UnProcessableCardException {
        HashMap hashMap = new HashMap();
        ReadBinaryCommand readBinaryCommand = new ReadBinaryCommand();
        readBinaryCommand.setP1((byte) -107);
        byte[] transceive = transceive(readBinaryCommand.toRawAPDU().toBytes());
        assertResponse(transceive, "failed to get card num");
        String bytesToHexString = Coder.bytesToHexString(ByteArray.wrap(transceive, 0, 8).toBytes());
        String bytesToHexString2 = Coder.bytesToHexString(ByteArray.wrap(transceive, 20, 4).toBytes());
        String bytesToHexString3 = Coder.bytesToHexString(ByteArray.wrap(transceive, 24, 4).toBytes());
        hashMap.put("account_num", bytesToHexString);
        hashMap.put("valid_start", bytesToHexString2);
        hashMap.put("valid_end", bytesToHexString3);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public int getBalance() throws IOException, UnProcessableCardException {
        assertResponse(transceive(PIN_AUTH_CMD.toBytes()), "failed to auth pin");
        byte[] transceive = transceive(GET_BALANCE_CMD.toBytes());
        assertResponse(transceive, "failed to get balance");
        return Coder.bytesToInt(ByteArray.wrap(transceive, 0, 4).toBytes());
    }

    /* access modifiers changed from: protected */
    public void readRecord(ArrayList<TradeLog> arrayList, boolean z) throws IOException {
        try {
            assertResponse(transceive(PIN_AUTH_CMD.toBytes()), "failed to auth pin");
            super.readRecord(arrayList, z);
        } catch (UnProcessableCardException unused) {
        }
    }
}
