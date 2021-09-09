package com.tsmclient.smartcard.handler;

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

public class HZTCardHandler extends BaseTransCardHandler {
    private static final ByteArray FID = ByteArray.wrap(new byte[]{63, 1});
    private static final ByteArray GET_CARDNUM_CMD = ByteArray.wrap(new byte[]{0, -80, -107, 12, 8});
    private static final ByteArray HZT_ENTITY_AID = ByteArray.wrap(new byte[]{49, 80, 85, 66, 46, 83, 89, 83, 46, 68, 68, 70, 48, 49});

    /* access modifiers changed from: protected */
    public String getCardType() {
        return "HZT";
    }

    /* access modifiers changed from: protected */
    public void selectVerify() throws IOException, UnProcessableCardException {
        SelectCommand selectCommand = new SelectCommand();
        selectCommand.setP1((byte) 4);
        selectCommand.setData(this.mInternalRead ? APDUConstants.AID_HZT : HZT_ENTITY_AID);
        assertResponse(transceive(selectCommand.toRawAPDU().toBytes()), "failed to select HZT AID_APPLET");
        selectCommand.setP1((byte) 0);
        selectCommand.setData(FID);
        assertResponse(transceive(selectCommand.toRawAPDU().toBytes()), "failed to select HZT FID");
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getCardNumAndValidDate() throws IOException, UnProcessableCardException {
        HashMap hashMap = new HashMap();
        byte[] transceive = transceive(GET_CARDNUM_CMD.toBytes());
        assertResponse(transceive, "failed to get card num");
        hashMap.put("account_num", Coder.bytesToHexString(ByteArray.wrap(transceive, 0, transceive.length - 2).toBytes()));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void readRecord(ArrayList<TradeLog> arrayList, boolean z) throws IOException {
        ArrayList<TradeLog> arrayList2 = arrayList;
        readRecord(arrayList2, true, (byte) -44, (byte) 0, false);
        readRecord(arrayList, true, (byte) -124, (byte) 0, false);
        readRecord(arrayList2, true, (byte) -60, (byte) 0, false);
        Collections.sort(arrayList);
    }
}
