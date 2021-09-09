package com.tsmclient.smartcard.handler;

import android.text.TextUtils;
import android.util.Log;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.apdu.ReadBinaryCommand;
import com.tsmclient.smartcard.apdu.SelectCommand;
import com.tsmclient.smartcard.exception.CardStatusException;
import com.tsmclient.smartcard.exception.InvalidTLVException;
import com.tsmclient.smartcard.exception.TagNotFoundException;
import com.tsmclient.smartcard.exception.UnProcessableCardException;
import com.tsmclient.smartcard.model.TradeLog;
import com.tsmclient.smartcard.terminal.APDUConstants;
import com.tsmclient.smartcard.tlv.ITLVObject;
import com.tsmclient.smartcard.tlv.TLVParser;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BMACCardHandler extends BaseTransCardHandler {
    private static final ByteArray BMAC_AID = ByteArray.wrap(new byte[]{-111, 86, 0, 0, 20, 1, 0, 1});
    private static final ByteArray PRE_SELECT_CMD = ByteArray.wrap(new byte[]{0, -92, 0, 0, 2, 63, 0});
    private static final ByteArray READ_BLACK_LIST_CMD = ByteArray.wrap(new byte[]{0, -80, -123, 0, 1});
    private static final ByteArray READ_CARD_STATAUS_CMD = ByteArray.wrap(new byte[]{0, -80, -124, 9, 1});
    private static final ByteArray READ_OVERDRAW_CMD = ByteArray.wrap(new byte[]{0, -80, -123, 5, 4});
    private static final ByteArray SELECT_DDF_CMD = ByteArray.wrap(new byte[]{0, -92, 0, 0, 2, 16, 1});

    /* access modifiers changed from: protected */
    public String getCardType() {
        return "BMAC";
    }

    /* access modifiers changed from: protected */
    public void selectVerify() throws IOException, UnProcessableCardException {
        String bytesToHexString;
        SelectCommand selectCommand = new SelectCommand();
        selectCommand.setP1((byte) 4);
        if (this.mInternalRead) {
            selectCommand.setData(BMAC_AID);
        } else {
            selectCommand.setData(AID_PSE);
        }
        byte[] transceive = transceive(selectCommand.toRawAPDU().toBytes());
        assertResponse(transceive, "failed to select BMAC");
        if (!this.mInternalRead) {
            boolean z = false;
            try {
                ITLVObject parse = TLVParser.parse(ByteArray.wrap(transceive).duplicate(0, transceive.length - 2));
                if (ByteArray.equals(APDUConstants.TAG_FCI_TEMPLATE, parse.getTag()) && (bytesToHexString = Coder.bytesToHexString(parse.getValue().findTLV(APDUConstants.TAG_FCI_2PAY).getValue().toBytes().toBytes())) != null && bytesToHexString.startsWith(AID_PSE.toString())) {
                    z = true;
                }
            } catch (InvalidTLVException e) {
                Log.e("BMACCardHandler", "failed to select BMAC PSE", e);
            } catch (TagNotFoundException e2) {
                Log.e("BMACCardHandler", "failed to select BMAC PSE", e2);
            }
            if (!z) {
                throw new UnProcessableCardException("BMACCardHandler: unsupported card type");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void otherVerify() throws IOException, UnProcessableCardException {
        assertResponse(transceive(SELECT_DDF_CMD.toBytes()), "failed to verify card");
    }

    /* access modifiers changed from: protected */
    public HashMap<String, String> getCardNumAndValidDate() throws IOException, UnProcessableCardException {
        HashMap<String, String> hashMap = new HashMap<>();
        ReadBinaryCommand readBinaryCommand = new ReadBinaryCommand();
        readBinaryCommand.setP1((byte) -124);
        byte[] transceive = transceive(readBinaryCommand.toRawAPDU().toBytes());
        assertResponse(transceive, "failed to get card num");
        String bytesToHexString = Coder.bytesToHexString(ByteArray.wrap(transceive, 0, 8).toBytes());
        String bytesToHexString2 = Coder.bytesToHexString(ByteArray.wrap(transceive, 24, 4).toBytes());
        String bytesToHexString3 = Coder.bytesToHexString(ByteArray.wrap(transceive, 28, 4).toBytes());
        hashMap.put("account_num", bytesToHexString);
        hashMap.put("valid_start", bytesToHexString2);
        hashMap.put("valid_end", bytesToHexString3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        Date date = new Date();
        simpleDateFormat.setLenient(false);
        try {
            if (date.before(simpleDateFormat.parse(bytesToHexString2))) {
                hashMap.put("is_valid_start_date", Boolean.FALSE.toString());
            }
        } catch (ParseException e) {
            hashMap.put("is_valid_start_date", Boolean.FALSE.toString());
            Log.e("BMACCardHandler", "parse start date failed.", e);
        }
        try {
            if (date.after(simpleDateFormat.parse(bytesToHexString3))) {
                hashMap.put("is_valid_end_date", Boolean.FALSE.toString());
            }
        } catch (ParseException e2) {
            hashMap.put("is_valid_end_date", Boolean.FALSE.toString());
            Log.e("BMACCardHandler", "parse end date failed.", e2);
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public int getAtc() throws IOException, UnProcessableCardException {
        ReadBinaryCommand readBinaryCommand = new ReadBinaryCommand();
        readBinaryCommand.setP1((byte) -123);
        byte[] transceive = transceive(readBinaryCommand.toRawAPDU().toBytes());
        assertResponse(transceive, "failed to get atc");
        return Coder.bytesToInt(transceive, 3, 2);
    }

    /* access modifiers changed from: protected */
    public ByteArray getConsumeTag() {
        return ByteArray.wrap(new byte[]{6});
    }

    /* access modifiers changed from: protected */
    public int getBalance() throws IOException, UnProcessableCardException {
        int balance = super.getBalance();
        assertResponse(transceive(PRE_SELECT_CMD.toBytes()), "select 1PAY.SYS.DDF01 failed.");
        byte[] transceive = transceive(READ_OVERDRAW_CMD.toBytes());
        assertResponse(transceive, "failed to read overdraw");
        int i = 0;
        if (transceive.length > 4) {
            String substring = Coder.bytesToHexString(transceive).substring(0, 8);
            if (!TextUtils.equals(substring, "FFFFFFFF")) {
                i = new BigInteger(substring, 16).intValue();
                updateCardInfo("overdrawn", String.valueOf(i));
                if (i < 0) {
                    return balance;
                }
            }
        }
        return balance - i;
    }

    /* access modifiers changed from: protected */
    public void readRecord(ArrayList<TradeLog> arrayList, boolean z) throws IOException {
        try {
            assertResponse(transceive(SELECT_DDF_CMD.toBytes()), "failed to verify card");
            super.readRecord(arrayList, z);
        } catch (UnProcessableCardException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void readCardStatus(Map<String, String> map) throws IOException, UnProcessableCardException, CardStatusException {
        super.readCardStatus(map);
        if (map == null) {
            map = new HashMap<>();
        }
        byte[] transceive = transceive(READ_CARD_STATAUS_CMD.toBytes());
        assertResponse(transceive, "read card status failed.");
        int i = 1;
        if (Coder.bytesToInt(transceive, 0, 1) == 2) {
            i = 0;
        }
        map.put("status_negative", String.valueOf(i));
        byte[] transceive2 = transceive(READ_BLACK_LIST_CMD.toBytes());
        assertResponse(transceive2, "read black list failed.");
        map.put("in_black_list", String.valueOf(TextUtils.equals(Coder.bytesToHexString(transceive2).substring(0, 2), "A5") ? 1 : 0));
    }
}
