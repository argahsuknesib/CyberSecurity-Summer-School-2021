package com.tsmclient.smartcard.handler;

import android.nfc.tech.IsoDep;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.apdu.ReadRecordCommand;
import com.tsmclient.smartcard.exception.CardStatusException;
import com.tsmclient.smartcard.exception.UnProcessableCardException;
import com.tsmclient.smartcard.model.TradeLog;
import com.tsmclient.smartcard.terminal.IScTerminal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseTransCardHandler implements ISmartCardHandler<IsoDep> {
    private Map<String, String> mCardInfoMap = new HashMap();
    protected boolean mInternalRead;
    protected IsoDep mTech;
    protected IScTerminal mTerminal;

    /* access modifiers changed from: protected */
    public int getAtc() throws IOException, UnProcessableCardException {
        return -999;
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, String> getCardNumAndValidDate() throws IOException, UnProcessableCardException;

    /* access modifiers changed from: protected */
    public abstract String getCardType();

    public int getTechType() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void otherVerify() throws IOException, UnProcessableCardException {
    }

    /* access modifiers changed from: protected */
    public void readCardStatus(Map<String, String> map) throws IOException, UnProcessableCardException, CardStatusException {
    }

    /* access modifiers changed from: protected */
    public abstract void selectVerify() throws IOException, UnProcessableCardException;

    public Bundle onHandleCard(IsoDep isoDep) throws IOException, UnProcessableCardException {
        this.mTech = isoDep;
        this.mInternalRead = false;
        return doHandleCard(new Bundle());
    }

    public Bundle onHandleCard(IScTerminal iScTerminal, Bundle bundle) throws IOException, UnProcessableCardException {
        this.mTerminal = iScTerminal;
        this.mInternalRead = true;
        if (bundle == null) {
            bundle = new Bundle();
        }
        return doHandleCard(bundle);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0188  */
    public Bundle doHandleCard(Bundle bundle) throws IOException, UnProcessableCardException {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = new Bundle();
        selectVerify();
        try {
            readCardStatus(this.mCardInfoMap);
            this.mCardInfoMap.putAll(getCardNumAndValidDate());
            i2 = getAtc();
            try {
                otherVerify();
                i = getBalance();
                try {
                    if (!bundle.getBoolean("KEY_READ_CARD_OPTION_SKIP_RECORD", false)) {
                        readRecord(arrayList, false);
                    }
                } catch (CardStatusException unused) {
                }
            } catch (CardStatusException unused2) {
                i = -999;
                bundle2.putBoolean("success", true);
                bundle2.putInt("card_type", 2);
                bundle2.putString("card_id", getCardType());
                if (this.mCardInfoMap.get("account_num") != null) {
                }
                if (this.mCardInfoMap.get("account_real_num") != null) {
                }
                if (this.mCardInfoMap.get("valid_start") != null) {
                }
                if (this.mCardInfoMap.get("valid_end") != null) {
                }
                if (i2 != -999) {
                }
                bundle2.putInt("e_balance", i);
                bundle2.putParcelableArrayList("trade_log", arrayList);
                if (this.mCardInfoMap.containsKey("status_negative")) {
                }
                if (this.mCardInfoMap.containsKey("in_black_list")) {
                }
                if (this.mCardInfoMap.containsKey("card_locked")) {
                }
                if (this.mCardInfoMap.containsKey("card_exception")) {
                }
                if (this.mCardInfoMap.containsKey("overdrawn")) {
                }
                if (this.mCardInfoMap.containsKey("is_valid_start_date")) {
                }
                if (this.mCardInfoMap.containsKey("is_valid_end_date")) {
                }
                if (this.mCardInfoMap.containsKey("area_code")) {
                }
                return bundle2;
            }
        } catch (CardStatusException unused3) {
            i2 = -999;
            i = -999;
            bundle2.putBoolean("success", true);
            bundle2.putInt("card_type", 2);
            bundle2.putString("card_id", getCardType());
            if (this.mCardInfoMap.get("account_num") != null) {
            }
            if (this.mCardInfoMap.get("account_real_num") != null) {
            }
            if (this.mCardInfoMap.get("valid_start") != null) {
            }
            if (this.mCardInfoMap.get("valid_end") != null) {
            }
            if (i2 != -999) {
            }
            bundle2.putInt("e_balance", i);
            bundle2.putParcelableArrayList("trade_log", arrayList);
            if (this.mCardInfoMap.containsKey("status_negative")) {
            }
            if (this.mCardInfoMap.containsKey("in_black_list")) {
            }
            if (this.mCardInfoMap.containsKey("card_locked")) {
            }
            if (this.mCardInfoMap.containsKey("card_exception")) {
            }
            if (this.mCardInfoMap.containsKey("overdrawn")) {
            }
            if (this.mCardInfoMap.containsKey("is_valid_start_date")) {
            }
            if (this.mCardInfoMap.containsKey("is_valid_end_date")) {
            }
            if (this.mCardInfoMap.containsKey("area_code")) {
            }
            return bundle2;
        }
        bundle2.putBoolean("success", true);
        bundle2.putInt("card_type", 2);
        bundle2.putString("card_id", getCardType());
        if (this.mCardInfoMap.get("account_num") != null) {
            bundle2.putString("account_num", this.mCardInfoMap.get("account_num"));
        }
        if (this.mCardInfoMap.get("account_real_num") != null) {
            bundle2.putString("account_real_num", this.mCardInfoMap.get("account_real_num"));
        }
        if (this.mCardInfoMap.get("valid_start") != null) {
            bundle2.putString("valid_start", this.mCardInfoMap.get("valid_start"));
        }
        if (this.mCardInfoMap.get("valid_end") != null) {
            bundle2.putString("valid_end", this.mCardInfoMap.get("valid_end"));
        }
        if (i2 != -999) {
            bundle2.putInt("atc", i2);
        }
        bundle2.putInt("e_balance", i);
        bundle2.putParcelableArrayList("trade_log", arrayList);
        if (this.mCardInfoMap.containsKey("status_negative")) {
            bundle2.putInt("status_negative", Integer.valueOf(this.mCardInfoMap.get("status_negative")).intValue());
        }
        if (this.mCardInfoMap.containsKey("in_black_list")) {
            bundle2.putInt("in_black_list", Integer.valueOf(this.mCardInfoMap.get("in_black_list")).intValue());
        }
        if (this.mCardInfoMap.containsKey("card_locked")) {
            bundle2.putInt("card_locked", Integer.valueOf(this.mCardInfoMap.get("card_locked")).intValue());
        }
        if (this.mCardInfoMap.containsKey("card_exception")) {
            bundle2.putInt("card_exception", Integer.valueOf(this.mCardInfoMap.get("card_exception")).intValue());
        }
        if (this.mCardInfoMap.containsKey("overdrawn")) {
            bundle2.putInt("overdrawn", Integer.valueOf(this.mCardInfoMap.get("overdrawn")).intValue());
        }
        if (this.mCardInfoMap.containsKey("is_valid_start_date")) {
            bundle2.putBoolean("is_valid_start_date", Boolean.valueOf(this.mCardInfoMap.get("is_valid_start_date")).booleanValue());
        }
        if (this.mCardInfoMap.containsKey("is_valid_end_date")) {
            bundle2.putBoolean("is_valid_end_date", Boolean.valueOf(this.mCardInfoMap.get("is_valid_end_date")).booleanValue());
        }
        if (this.mCardInfoMap.containsKey("area_code")) {
            bundle2.putString("area_code", String.valueOf(this.mCardInfoMap.get("area_code")));
        }
        return bundle2;
    }

    /* access modifiers changed from: protected */
    public int getBalance() throws IOException, UnProcessableCardException {
        byte[] transceive = transceive(GET_BALANCE_CMD.toBytes());
        if (transceive == null || transceive.length < 2) {
            throw new IOException("failed to get balance");
        } else if (!ByteArray.equals(STATUS_OK, ByteArray.wrap(transceive, transceive.length - 2, 2))) {
            return -999;
        } else {
            return Coder.bytesToInt(transceive, 0, 4);
        }
    }

    /* access modifiers changed from: protected */
    public void readRecord(ArrayList<TradeLog> arrayList, boolean z, byte b, byte b2, boolean z2) throws IOException {
        ReadRecordCommand readRecordCommand = new ReadRecordCommand();
        int i = 1;
        readRecordCommand.setP1((byte) 1);
        readRecordCommand.setP2((byte) -59);
        byte[] transceive = transceive(readRecordCommand.toRawAPDU().toBytes());
        if (transceive == null) {
            return;
        }
        if (transceive.length < 2) {
            throw new IOException("failed to get record");
        } else if (ByteArray.equals(STATUS_ERROR_PARAM, ByteArray.wrap(transceive, transceive.length - 2, 2)) || z) {
            readRecordCommand.setP2(b);
            readRecordCommand.setSfi(b2);
            readRecordCommand.setP1(Coder.toBytesLow(1));
            byte[] transceive2 = transceive(readRecordCommand.toRawAPDU().toBytes());
            if (transceive2 != null && ByteArray.wrap(transceive2).length() != 2) {
                while (!ByteArray.equals(STATUS_RECORD_END, ByteArray.wrap(transceive2)) && i < 11 && !ByteArray.equals(EMPTY_RECORD, ByteArray.wrap(transceive2, 0, transceive2.length - 2)) && !ByteArray.equals(EMPTY_RECORD_TWO, ByteArray.wrap(transceive2, 0, transceive2.length - 2))) {
                    processPerLog(transceive2, arrayList, z2);
                    i++;
                    readRecordCommand.setP1(Coder.toBytesLow(i));
                    transceive2 = transceive(readRecordCommand.toRawAPDU().toBytes());
                    if (transceive2 == null) {
                        return;
                    }
                }
            }
        } else {
            processAllLog(ByteArray.wrap(transceive, 0, transceive.length - 2), arrayList, z2);
        }
    }

    /* access modifiers changed from: protected */
    public void readRecord(ArrayList<TradeLog> arrayList, boolean z) throws IOException {
        readRecord(arrayList, z, (byte) -60, (byte) 0, false);
    }

    private void processAllLog(ByteArray byteArray, ArrayList<TradeLog> arrayList, boolean z) {
        int length = byteArray.length() / 23;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte[] bytes = byteArray.duplicate(i2, 23).toBytes();
            if (!ByteArray.equals(ByteArray.wrap(bytes), EMPTY_RECORD)) {
                processPerLog(bytes, arrayList, z);
                i2 += 23;
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void processPerLog(byte[] bArr, ArrayList<TradeLog> arrayList, boolean z) {
        int bytesToInt = Coder.bytesToInt(bArr, 5, 4);
        if (bytesToInt != Integer.MIN_VALUE) {
            TradeLog tradeLog = new TradeLog();
            int i = 0;
            int bytesToInt2 = Coder.bytesToInt(bArr, 0, 2);
            if (bytesToInt2 > 0) {
                tradeLog.setTradeID(bytesToInt2);
            }
            if (getConsumeTag().contains(bArr[9])) {
                tradeLog.setTradeType(1);
            } else {
                tradeLog.setTradeType(2);
            }
            tradeLog.setAuAmount((float) bytesToInt);
            String bytesToHexString = Coder.bytesToHexString(ByteArray.wrap(bArr, 10, 6).toBytes());
            if (!TextUtils.isEmpty(bytesToHexString)) {
                tradeLog.setTerminalNo(bytesToHexString);
            }
            if (z) {
                i = 2;
            }
            tradeLog.setTradeDate(Coder.bytesToHexString(ByteArray.wrap(bArr, i + 16, 4 - i).toBytes()));
            tradeLog.setTradeTime(Coder.bytesToHexString(ByteArray.wrap(bArr, 20, 3).toBytes()));
            arrayList.add(tradeLog);
        }
    }

    /* access modifiers changed from: protected */
    public ByteArray getConsumeTag() {
        return ByteArray.wrap(new byte[]{10, 17, 9, 6, 5});
    }

    /* access modifiers changed from: protected */
    public byte[] transceive(byte[] bArr) throws IOException {
        if (this.mInternalRead) {
            try {
                return this.mTerminal.transmit(bArr).toBytes();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new IOException("transceive is interrupted");
            }
        } else {
            Log.v("CardHandler", "send: " + ByteArray.wrap(bArr));
            byte[] transceive = this.mTech.transceive(bArr);
            StringBuilder sb = new StringBuilder("receive: ");
            sb.append(transceive == null ? null : ByteArray.wrap(transceive));
            Log.v("CardHandler", sb.toString());
            return transceive;
        }
    }

    /* access modifiers changed from: protected */
    public void assertResponse(byte[] bArr, ByteArray byteArray, String str) throws IOException, UnProcessableCardException {
        if (bArr == null || bArr.length < 2) {
            throw new IOException(str);
        }
        ByteArray wrap = ByteArray.wrap(bArr, bArr.length - 2, 2);
        if (!ByteArray.equals(byteArray, wrap)) {
            Log.d("CardHandler", "assertPattern expect: " + byteArray + ", but: " + wrap + " on " + getClass().getSimpleName());
            throw new UnProcessableCardException(getClass().getSimpleName() + ": unsupported card type");
        }
    }

    /* access modifiers changed from: protected */
    public void assertResponse(byte[] bArr, String str) throws IOException, UnProcessableCardException {
        assertResponse(bArr, STATUS_OK, str);
    }

    /* access modifiers changed from: protected */
    public void updateCardInfo(String str, String str2) {
        this.mCardInfoMap.put(str, str2);
    }
}
