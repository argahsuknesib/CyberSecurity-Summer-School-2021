package com.tsmclient.smartcard.handler;

import android.text.TextUtils;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.apdu.SelectCommand;
import com.tsmclient.smartcard.exception.UnProcessableCardException;
import com.tsmclient.smartcard.model.TradeLog;
import com.tsmclient.smartcard.terminal.APDUConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CSTCardHandler extends BaseTransCardHandler {
    private static final ByteArray FID_00 = ByteArray.wrap(new byte[]{63, 0});
    private static final ByteArray FID_01 = ByteArray.wrap(new byte[]{63, 1});
    private static final ByteArray GET_BALANCE_CMD = ByteArray.wrap(new byte[]{Byte.MIN_VALUE, 92, 0, 2, 4});
    private static final ByteArray GET_CARDNUM_CMD = ByteArray.wrap(new byte[]{0, -80, -107, 0, 30});
    private static final ByteArray GET_REAL_CARDNUM_CMD = ByteArray.wrap(new byte[]{Byte.MIN_VALUE, -54, 0, 0, 9});
    private static final ByteArray READ_CARD_STATAUS_CMD = ByteArray.wrap(new byte[]{0, -78, 2, -72, 48});
    private final String HAS_BEEN_BACK_CARD = "01111";
    private final String ILLEGAL_CARD_NUMBER = "0000000000000000";

    /* access modifiers changed from: protected */
    public String getCardType() {
        return "CHANGSHA";
    }

    /* access modifiers changed from: protected */
    public void selectVerify() throws IOException, UnProcessableCardException {
        SelectCommand selectCommand = new SelectCommand();
        selectCommand.setP1((byte) 4);
        selectCommand.setData(APDUConstants.AID_CST);
        assertResponse(transceive(selectCommand.toRawAPDU().toBytes()), "failed to select CST AID_APPLET");
        selectCommand.setP1((byte) 0);
        selectCommand.setData(FID_00);
        assertResponse(transceive(selectCommand.toRawAPDU().toBytes()), "failed to select CST FID00");
        selectCommand.setP1((byte) 0);
        selectCommand.setData(FID_01);
        assertResponse(transceive(selectCommand.toRawAPDU().toBytes()), "failed to select CST FID01");
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getCardNumAndValidDate() throws IOException, UnProcessableCardException {
        HashMap hashMap = new HashMap();
        byte[] transceive = transceive(GET_CARDNUM_CMD.toBytes());
        assertResponse(transceive, "failed to get logic card num");
        String bytesToHexString = Coder.bytesToHexString(ByteArray.wrap(transceive, 12, 8).toBytes());
        if (!bytesToHexString.equals("0000000000000000")) {
            hashMap.put("account_num", bytesToHexString);
            byte[] transceive2 = transceive(GET_REAL_CARDNUM_CMD.toBytes());
            assertResponse(transceive2, "failed to get real card num");
            hashMap.put("account_real_num", Coder.bytesToHexString(ByteArray.wrap(transceive2, 1, 4).toBytes()));
            return hashMap;
        }
        throw new UnProcessableCardException(getClass().getSimpleName() + " illegal card number");
    }

    /* access modifiers changed from: protected */
    public int getBalance() throws IOException, UnProcessableCardException {
        byte[] transceive = transceive(GET_BALANCE_CMD.toBytes());
        assertResponse(transceive, "failed to get balance");
        return Coder.bytesToInt(ByteArray.wrap(transceive, 0, 4).toBytes());
    }

    /* access modifiers changed from: protected */
    public void readRecord(ArrayList<TradeLog> arrayList, boolean z) throws IOException {
        readRecord(arrayList, true, (byte) -60, (byte) 23, false);
        Collections.sort(arrayList);
    }

    /* access modifiers changed from: protected */
    public void readCardStatus(Map<String, String> map) throws IOException, UnProcessableCardException {
        if (map != null) {
            byte[] transceive = transceive(READ_CARD_STATAUS_CMD.toBytes());
            if (transceive.length < 5) {
                map.put("status_negative", "1");
                return;
            }
            map.put("status_negative", String.valueOf(TextUtils.equals(String.format("%08d", new Object[]{Integer.valueOf(Integer.parseInt(Integer.toBinaryString(ByteArray.wrap(transceive).get(4))))}).substring(0, 5), "01111") ? 1 : 0));
        }
    }
}
