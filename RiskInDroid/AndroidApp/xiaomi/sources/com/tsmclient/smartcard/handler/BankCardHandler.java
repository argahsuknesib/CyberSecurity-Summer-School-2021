package com.tsmclient.smartcard.handler;

import android.nfc.tech.IsoDep;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.CardConstants;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.apdu.GPOCommand;
import com.tsmclient.smartcard.apdu.GetDataCommand;
import com.tsmclient.smartcard.apdu.ReadRecordCommand;
import com.tsmclient.smartcard.apdu.SelectCommand;
import com.tsmclient.smartcard.exception.InvalidTLVException;
import com.tsmclient.smartcard.exception.TagNotFoundException;
import com.tsmclient.smartcard.exception.UnProcessableCardException;
import com.tsmclient.smartcard.model.TradeLog;
import com.tsmclient.smartcard.terminal.APDUConstants;
import com.tsmclient.smartcard.terminal.CommandApdu;
import com.tsmclient.smartcard.terminal.IScTerminal;
import com.tsmclient.smartcard.terminal.response.ScResponse;
import com.tsmclient.smartcard.tlv.ITLVObject;
import com.tsmclient.smartcard.tlv.TLVParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BankCardHandler implements ISmartCardHandler<IsoDep> {
    private static final ByteArray AU_AMOUNT = ByteArray.wrap(new byte[]{0, 0, 0, 0, 0, 0});
    private static final ByteArray AU_AMOUNT_OTHER = ByteArray.wrap(new byte[]{0, 0, 0, 0, 0, 0});
    private static final ByteArray CUR_CODE = ByteArray.wrap(new byte[]{1, 86});
    private static final ByteArray NOT_EXISTS = ByteArray.wrap(new byte[]{106, -126});
    private static final ByteArray RANDOM_NUMBER = ByteArray.wrap(new byte[]{1, 2, 3, 4});
    private static final ByteArray TAG_AEF_ENTRANCE = ByteArray.wrap(new byte[]{97});
    private static final ByteArray TAG_AID = ByteArray.wrap(new byte[]{79});
    private static final ByteArray TAG_APP = ByteArray.wrap(new byte[]{80});
    private static final ByteArray TAG_BANK_CUSTOM_DATA = ByteArray.wrap(new byte[]{-65, 12});
    private static final ByteArray TAG_CARD_NUM = ByteArray.wrap(new byte[]{87});
    private static final ByteArray TAG_FCI_DATA_TEMPLATE = ByteArray.wrap(new byte[]{-91});
    private static final ByteArray TAG_PDOL = ByteArray.wrap(new byte[]{-97, 56});
    private static final ByteArray TER_TRADE_TYPE = ByteArray.wrap(new byte[]{126, 0, 0, 0});
    private static final ByteArray TRADE_TYPE = ByteArray.wrap(new byte[]{48});
    private static final ByteArray TVR = ByteArray.wrap(new byte[]{0, 0, 0, 0, 0});
    public static final ByteArray UNION_PAY_AID = ByteArray.wrap(new byte[]{-96, 0, 0, 3, 51});
    public static final ByteArray VISA_AID = ByteArray.wrap(new byte[]{-96, 0, 0, 0, 3});
    public static final ByteArray VISA_CREDIT = ByteArray.wrap(new byte[]{67, 82, 69, 68, 73, 84});
    public static final ByteArray VISA_DEBIT = ByteArray.wrap(new byte[]{68, 69, 66, 73, 84});
    private int mCardScheme;

    public int getTechType() {
        return 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0207  */
    public Bundle onHandleCard(IsoDep isoDep) throws IOException, UnProcessableCardException {
        ByteArray byteArray;
        ByteArray byteArray2;
        ByteArray byteArray3;
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        isoDep.transceive(ByteArray.wrap(new byte[]{0, -78, 1, 12, 0}).toBytes());
        SelectCommand selectCommand = new SelectCommand();
        selectCommand.setP1((byte) 4);
        selectCommand.setData(AID_PPSE);
        byte[] transceive = isoDep.transceive(selectCommand.toRawAPDU().toBytes());
        if (transceive == null || transceive.length < 2) {
            throw new IOException("failed to select PPSE");
        } else if (!ByteArray.equals(NOT_EXISTS, ByteArray.wrap(transceive))) {
            Log.d("BankCardHandler", "ppse = " + Coder.bytesToHexString(transceive));
            String str = null;
            try {
                byteArray = TLVParser.parse(ByteArray.wrap(transceive, 0, transceive.length - 2)).getValue().findTLV(TAG_FCI_DATA_TEMPLATE).getValue().findTLV(TAG_BANK_CUSTOM_DATA).getValue().findTLV(TAG_AEF_ENTRANCE).getValue().findTLV(TAG_AID).getValue().toBytes();
            } catch (InvalidTLVException unused) {
                Log.e("BankCardHandler", "invalid res: " + Coder.bytesToHexString(transceive));
                byteArray = null;
            } catch (TagNotFoundException e) {
                Log.e("BankCardHandler", "error when parse tlv", e);
                throw new UnProcessableCardException("BankCardHandler: unsupported card type");
            }
            if (byteArray != null) {
                selectCommand.setData(byteArray);
                byte[] transceive2 = isoDep.transceive(selectCommand.toRawAPDU().toBytes());
                if (transceive2 == null || transceive2.length < 2) {
                    throw new IOException("failed to select qPBOC");
                }
                Log.d("BankCardHandler", "Qppse = " + Coder.bytesToHexString(transceive2));
                byte[] entranceOfTrade = getEntranceOfTrade(transceive2);
                try {
                    ITLVObject findTLV = TLVParser.parse(ByteArray.wrap(transceive2, 0, transceive2.length - 2)).getValue().findTLV(TAG_FCI_DATA_TEMPLATE);
                    byteArray2 = findTLV.getValue().findTLV(TAG_APP).getValue().toBytes();
                    try {
                        byteArray3 = findTLV.getValue().findTLV(TAG_PDOL).getValue().toBytes();
                    } catch (InvalidTLVException unused2) {
                        Log.e("BankCardHandler", "Invalid res: " + Coder.bytesToHexString(transceive2));
                        byteArray3 = null;
                        if (byteArray3 != null) {
                        }
                    } catch (TagNotFoundException e2) {
                        e = e2;
                        Log.e("BankCardHandler", "Error when parse tlv", e);
                        byteArray3 = null;
                        if (byteArray3 != null) {
                        }
                    }
                } catch (InvalidTLVException unused3) {
                    byteArray2 = null;
                    Log.e("BankCardHandler", "Invalid res: " + Coder.bytesToHexString(transceive2));
                    byteArray3 = null;
                    if (byteArray3 != null) {
                    }
                } catch (TagNotFoundException e3) {
                    e = e3;
                    byteArray2 = null;
                    Log.e("BankCardHandler", "Error when parse tlv", e);
                    byteArray3 = null;
                    if (byteArray3 != null) {
                    }
                }
                if (byteArray3 != null) {
                    int cardType = getCardType(byteArray, byteArray2);
                    ByteArray gPOInputData = getGPOInputData(byteArray3);
                    GPOCommand gPOCommand = new GPOCommand();
                    gPOCommand.setData(gPOInputData);
                    byte[] transceive3 = isoDep.transceive(gPOCommand.toRawAPDU().toBytes());
                    if (transceive3 == null || transceive3.length < 2) {
                        throw new IOException("failed to get AFL");
                    }
                    ReadRecordCommand readRecordCommand = new ReadRecordCommand();
                    byte b = 1;
                    while (b <= 10) {
                        readRecordCommand.setP1(b);
                        readRecordCommand.setP2((byte) 12);
                        byte[] transceive4 = isoDep.transceive(readRecordCommand.toRawAPDU().toBytes());
                        if (transceive4 != null && transceive4.length >= 2) {
                            str = getCardNumString(transceive4);
                            if (!TextUtils.isEmpty(str)) {
                                break;
                            }
                            b = (byte) (b + 1);
                        } else {
                            throw new IOException("failed to read card number");
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        getTradeLog(isoDep, entranceOfTrade, getTradeLogFormat(isoDep), arrayList);
                        int atc = getATC(isoDep);
                        float eBalance = getEBalance(isoDep);
                        float ePerLimit = getEPerLimit(isoDep);
                        float eBanlanceLimit = getEBanlanceLimit(isoDep);
                        bundle.putBoolean("success", true);
                        bundle.putInt("card_type", 1);
                        bundle.putInt("card_scheme", this.mCardScheme);
                        bundle.putInt("bank_card_type", cardType);
                        bundle.putString("account_num", str);
                        bundle.putInt("atc", atc);
                        bundle.putFloat("e_balance", eBalance);
                        bundle.putFloat("per_limit", ePerLimit);
                        bundle.putFloat("e_balance_limit", eBanlanceLimit);
                        bundle.putParcelableArrayList("trade_log", arrayList);
                        return bundle;
                    }
                    throw new IOException("failed to get cardNum string");
                }
                throw new UnProcessableCardException("failed to get pdol");
            }
            throw new IOException("failed to get aid or appBytes");
        } else {
            throw new UnProcessableCardException("BankCardHandler: unsupported card type");
        }
    }

    public Bundle onHandleCard(IScTerminal iScTerminal, Bundle bundle) throws IOException, UnProcessableCardException {
        Bundle bundle2 = new Bundle();
        ArrayList arrayList = new ArrayList();
        try {
            if (ByteArray.equals(iScTerminal.transmit(APDUConstants.SELECT_CRS).getStatus(), ScResponse.STATUS_OK)) {
                byte[] bArr = APDUConstants.PBOC_CARD_AID_PREFFIX;
                byte[] bArr2 = new byte[(bArr.length + 2 + 5)];
                bArr2[0] = 79;
                bArr2[1] = (byte) (bArr.length & 255);
                System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
                System.arraycopy(APDUConstants.COMM_TAG_GET_STATUS.toBytes(), 0, bArr2, bArr.length + 2, APDUConstants.COMM_TAG_GET_STATUS.toBytes().length);
                CommandApdu clone = APDUConstants.COMM_PREFIX_GET_STATUS.clone();
                clone.setData(bArr2);
                ScResponse transmit = iScTerminal.transmit(clone.toBytes());
                if (ByteArray.equals(transmit.getStatus(), ScResponse.STATUS_REFERENCE_NOT_FOUND)) {
                    return null;
                }
                while (true) {
                    if (!ByteArray.equals(transmit.getStatus(), ScResponse.STATUS_MORE_DATA_AVAILABLE) && !ByteArray.equals(transmit.getStatus(), ScResponse.STATUS_OK)) {
                        break;
                    }
                    if (clone.getP2() != 1) {
                        clone.setP2(1);
                    }
                    List<ITLVObject> findTLVList = TLVParser.parseTLVValue(transmit.getData()).findTLVList(TAG_AEF_ENTRANCE);
                    SelectCommand selectCommand = new SelectCommand();
                    selectCommand.setP1((byte) 4);
                    for (ITLVObject value : findTLVList) {
                        ByteArray bytes = value.getValue().findTLV(TAG_AID).getValue().toBytes();
                        selectCommand.setData(bytes);
                        ScResponse transmit2 = iScTerminal.transmit(selectCommand.toRawAPDU().toBytes());
                        if (ByteArray.equals(transmit2.getStatus(), ScResponse.STATUS_OK)) {
                            ReadRecordCommand readRecordCommand = new ReadRecordCommand();
                            readRecordCommand.setP1((byte) 1);
                            readRecordCommand.setP2((byte) 12);
                            transmit2 = iScTerminal.transmit(readRecordCommand.toRawAPDU().toBytes());
                            String cardNumString = getCardNumString(transmit2.toBytes());
                            if (!TextUtils.isEmpty(cardNumString)) {
                                arrayList.add(bytes.toString() + "&" + cardNumString);
                            }
                        }
                        transmit = transmit2;
                    }
                }
                bundle2.putStringArrayList("extras_key_pan_list", arrayList);
                return bundle2;
            }
            throw new IOException("failed to select CRS");
        } catch (InvalidTLVException e) {
            Log.e("BankCardHandler", "onHandleCard return error when parse tlv", e);
        } catch (TagNotFoundException e2) {
            Log.e("BankCardHandler", "onHandleCard return error when parse tlv", e2);
        } catch (InterruptedException unused) {
            throw new IOException("onHandleCard is interrupted");
        }
    }

    private int getCardType(ByteArray byteArray, ByteArray byteArray2) throws UnProcessableCardException {
        if (byteArray == null || byteArray2 == null) {
            throw new UnProcessableCardException("BankCardHandler: unsupported card type");
        } else if (ByteArray.equals(byteArray.duplicate(0, 5), UNION_PAY_AID)) {
            this.mCardScheme = 1;
            byte b = byteArray.get(7);
            if (b == 1) {
                return 1;
            }
            if (b == 2) {
                return 2;
            }
            if (b == 3) {
                return 3;
            }
            if (b != 6) {
                return 1;
            }
            return 4;
        } else if (ByteArray.equals(byteArray.duplicate(0, 5), VISA_AID)) {
            this.mCardScheme = 2;
            return byteArray2.toString().contains(VISA_DEBIT.toString()) ? 1 : 2;
        } else {
            throw new UnProcessableCardException("BankCardHandler: unsupported card type");
        }
    }

    private void getTradeLog(IsoDep isoDep, byte[] bArr, byte[] bArr2, ArrayList<TradeLog> arrayList) throws IOException {
        byte bytesLow = Coder.toBytesLow((bArr[0] << 3) + 4);
        ReadRecordCommand readRecordCommand = new ReadRecordCommand();
        readRecordCommand.setP2(bytesLow);
        int i = 0;
        while (true) {
            if (i < Coder.bytesToInt(bArr[1])) {
                i++;
                readRecordCommand.setP1(Coder.toBytesLow(i));
                byte[] bArr3 = null;
                try {
                    bArr3 = isoDep.transceive(readRecordCommand.toRawAPDU().toBytes());
                } catch (IOException e) {
                    Log.e("BankCardHandler", "failed to get per log", e);
                }
                if (bArr3 == null) {
                    throw new IOException("failed to get per trade log");
                } else if (bArr3[0] != 106) {
                    arrayList.add(translateLog(bArr3, bArr2));
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private TradeLog translateLog(byte[] bArr, byte[] bArr2) {
        int i;
        int i2;
        int i3;
        String str;
        TradeLog tradeLog = new TradeLog();
        String str2 = null;
        int i4 = 3;
        int i5 = 0;
        while (i4 < bArr2.length) {
            if (bArr2[i4] == -102) {
                i4 += 2;
                StringBuilder sb = new StringBuilder("20");
                int i6 = i5 + 1;
                sb.append(Coder.bytesToHexString(bArr[i5]));
                int i7 = i6 + 1;
                sb.append(Coder.bytesToHexString(bArr[i6]));
                i5 = i7 + 1;
                sb.append(Coder.bytesToHexString(bArr[i7]));
                tradeLog.setTradeDate(sb.toString());
            } else {
                if (bArr2[i4] == -97) {
                    int i8 = i4 + 1;
                    if (bArr2[i8] == 33) {
                        i4 += 3;
                        StringBuilder sb2 = new StringBuilder();
                        int i9 = i5 + 1;
                        sb2.append(Coder.bytesToHexString(bArr[i5]));
                        int i10 = i9 + 1;
                        sb2.append(Coder.bytesToHexString(bArr[i9]));
                        i5 = i10 + 1;
                        sb2.append(Coder.bytesToHexString(bArr[i10]));
                        tradeLog.setTradeTime(sb2.toString());
                    } else {
                        if (bArr2[i8] == 2) {
                            i4 += 3;
                            tradeLog.setAuAmount(getRealMoney(bArr, i5, 5, i5 + 5, 1));
                        } else if (bArr2[i8] == 3) {
                            i4 += 3;
                        } else {
                            if (bArr2[i8] == 26) {
                                i3 = i4 + 3;
                                tradeLog.setCountryCode(" ");
                            } else if (bArr2[i8] == 78) {
                                i4 += 3;
                                if (!ByteArray.wrap(bArr).duplicate(i5, 20).toString().matches("0*")) {
                                    try {
                                        str = new String(ByteArray.wrap(bArr).duplicate(i5, 20).toBytes(), "GBK");
                                    } catch (UnsupportedEncodingException e) {
                                        Log.e("BankCardHandler", "failed to get shop name", e);
                                        str = str2;
                                    }
                                    tradeLog.setBusinessName(str);
                                    str2 = str;
                                } else {
                                    tradeLog.setBusinessName(null);
                                }
                                i5 += 20;
                            } else if (bArr2[i8] == 54) {
                                i3 = i4 + 3;
                            } else if (bArr2[i8] == 39) {
                                i = i4 + 3;
                                i5++;
                            }
                            i5 += 2;
                        }
                        i5 += 6;
                    }
                }
                if (bArr2[i4] != 95 || bArr2[i4 + 1] != 42) {
                    if (bArr2[i4] != -100) {
                        break;
                    }
                    i = i4 + 2;
                    byte b = bArr[i5];
                    if (b == 0) {
                        i2 = 1;
                    } else if (b == 1) {
                        i2 = 6;
                    } else if (b != 33) {
                        if (b != 48) {
                            if (b == 96) {
                                i2 = 5;
                            } else if (b == 99) {
                                i2 = 2;
                            }
                        }
                        i2 = 4;
                    } else {
                        i2 = 3;
                    }
                    tradeLog.setTradeType(i2);
                    i5++;
                } else {
                    i3 = i4 + 3;
                    ByteArray duplicate = ByteArray.wrap(bArr).duplicate(i5, 2);
                    if (CardConstants.sCurrencyCodeMap.containsKey(duplicate.toString())) {
                        tradeLog.setCurCode(CardConstants.sCurrencyCodeMap.get(duplicate.toString()).intValue());
                    }
                    i5 += 2;
                }
            }
        }
        return tradeLog;
    }

    private byte[] getTradeLogFormat(IsoDep isoDep) throws IOException {
        byte[] bArr;
        GetDataCommand getDataCommand = new GetDataCommand();
        getDataCommand.setP1((byte) -97);
        getDataCommand.setP2((byte) 79);
        try {
            bArr = isoDep.transceive(getDataCommand.toRawAPDU().toBytes());
        } catch (IOException e) {
            Log.e("BankCardHandler", "failed to get trade log format", e);
            bArr = null;
        }
        if (bArr != null) {
            return bArr;
        }
        throw new IOException("failed to get TradeLogFormat");
    }

    private byte[] getEntranceOfTrade(byte[] bArr) {
        int i = 0;
        while (true) {
            if (i < bArr.length - 1) {
                if (bArr[i] == -97 && bArr[i + 1] == 77) {
                    i += 3;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        if (i == bArr.length - 1) {
            return new byte[]{11, 10};
        }
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put(bArr[i]).put(bArr[i + 1]);
        return allocate.array();
    }

    private float getEBanlanceLimit(IsoDep isoDep) throws IOException {
        byte[] bArr;
        GetDataCommand getDataCommand = new GetDataCommand();
        getDataCommand.setP1((byte) -97);
        getDataCommand.setP2((byte) 119);
        try {
            bArr = isoDep.transceive(getDataCommand.toRawAPDU().toBytes());
        } catch (IOException e) {
            Log.e("BankCardHandler", "failed to get balance limit", e);
            bArr = null;
        }
        byte[] bArr2 = bArr;
        if (bArr2 != null) {
            return getRealMoney(bArr2, 3, 5, 8, 1);
        }
        throw new IOException("failed to get EBanlanceLimit");
    }

    private float getEPerLimit(IsoDep isoDep) throws IOException {
        byte[] bArr;
        GetDataCommand getDataCommand = new GetDataCommand();
        getDataCommand.setP1((byte) -97);
        getDataCommand.setP2((byte) 120);
        try {
            bArr = isoDep.transceive(getDataCommand.toRawAPDU().toBytes());
        } catch (IOException e) {
            Log.e("BankCardHandler", "failed to get per limit", e);
            bArr = null;
        }
        byte[] bArr2 = bArr;
        if (bArr2 != null) {
            return getRealMoney(bArr2, 3, 5, 8, 1);
        }
        throw new IOException("failed to get EPerLimit");
    }

    private float getEBalance(IsoDep isoDep) throws IOException {
        byte[] bArr;
        GetDataCommand getDataCommand = new GetDataCommand();
        getDataCommand.setP1((byte) -97);
        getDataCommand.setP2((byte) 121);
        try {
            bArr = isoDep.transceive(getDataCommand.toRawAPDU().toBytes());
        } catch (IOException e) {
            Log.e("BankCardHandler", "failed to get balance", e);
            bArr = null;
        }
        byte[] bArr2 = bArr;
        if (bArr2 != null) {
            return getRealMoney(bArr2, 3, 5, 8, 1);
        }
        throw new IOException("failed to get balance");
    }

    private int getATC(IsoDep isoDep) throws IOException {
        byte[] bArr;
        GetDataCommand getDataCommand = new GetDataCommand();
        getDataCommand.setP1((byte) -97);
        getDataCommand.setP2((byte) 54);
        try {
            bArr = isoDep.transceive(getDataCommand.toRawAPDU().toBytes());
        } catch (IOException e) {
            Log.e("BankCardHandler", "failed to get atc", e);
            bArr = null;
        }
        if (bArr != null) {
            return Coder.bytesToInt(bArr, 3, 2);
        }
        throw new IOException("failed to get ATC");
    }

    private String getCardNumString(byte[] bArr) {
        Boolean bool = Boolean.FALSE;
        try {
            ByteArray bytes = TLVParser.parse(ByteArray.wrap(bArr, 0, bArr.length - 2)).getValue().findTLV(TAG_CARD_NUM).getValue().toBytes();
            int i = 0;
            while (true) {
                if (((bytes.get(i) & 240) ^ 208) == 0) {
                    break;
                }
                i++;
                if (((bytes.get(i) & 15) ^ 13) == 0) {
                    i++;
                    bool = Boolean.TRUE;
                    break;
                }
            }
            String byteArray = ByteArray.wrap(bytes.toBytes(), 0, i).toString();
            if (bool.booleanValue()) {
                return byteArray.substring(0, byteArray.length() - 1);
            }
            return byteArray;
        } catch (InvalidTLVException e) {
            Log.e("BankCardHandler", "Invalid res: " + Coder.bytesToHexString(bArr), e);
            return null;
        } catch (TagNotFoundException e2) {
            Log.e("BankCardHandler", "Error when parse tlv", e2);
            return null;
        }
    }

    private ByteArray getGPOInputData(ByteArray byteArray) {
        byte b;
        byte b2;
        int i;
        ByteArray byteArray2 = byteArray;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            b = 102;
            b2 = 55;
            if (i3 >= byteArray.length()) {
                break;
            }
            if ((byteArray2.get(i3) & 31) == 31) {
                byte b3 = byteArray2.get(i3 + 1) & 255;
                if (b3 == 2 || b3 == 3) {
                    i4 += 6;
                } else {
                    if (b3 != 26) {
                        if (b3 == 33) {
                            i4 += 3;
                        } else if (b3 != 42) {
                            if (b3 == 55 || b3 == 102) {
                                i4 += 4;
                            }
                        }
                    }
                    i4 += 2;
                }
                i3 += 3;
            }
            byte b4 = byteArray2.get(i3) & 255;
            if (b4 == 149) {
                i = i4 + 5;
            } else if (b4 == 154) {
                i = i4 + 3;
            } else if (b4 != 156) {
                break;
            } else {
                i = i4 + 1;
            }
            i3 += 2;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i4 + 2);
        allocate.put((byte) -125).put(Coder.toBytesLow(i4));
        while (i2 < byteArray.length()) {
            if ((byteArray2.get(i2) & 31) == 31) {
                byte b5 = byteArray2.get(i2 + 1) & 255;
                if (b5 == 2) {
                    allocate.put(AU_AMOUNT.toBytes());
                } else if (b5 == 3) {
                    allocate.put(AU_AMOUNT_OTHER.toBytes());
                } else if (b5 == 26) {
                    allocate.put(CUR_CODE.toBytes());
                } else if (b5 != 33) {
                    if (b5 == 42) {
                        allocate.put(CUR_CODE.toBytes());
                    } else if (b5 == b2) {
                        allocate.put(RANDOM_NUMBER.toBytes());
                    } else if (b5 == b) {
                        allocate.put(TER_TRADE_TYPE.toBytes());
                    }
                    i2 += 3;
                } else {
                    allocate.put(Coder.str2Bcd(new SimpleDateFormat("HHmmss", Locale.getDefault()).format(new Date())));
                }
                i2 += 3;
                b = 102;
                b2 = 55;
            }
            byte b6 = byteArray2.get(i2) & 255;
            if (b6 == 149) {
                allocate.put(TVR.toBytes());
            } else if (b6 == 154) {
                allocate.put(Coder.str2Bcd(new SimpleDateFormat("yyMMdd", Locale.getDefault()).format(new Date())));
            } else if (b6 != 156) {
                break;
            } else {
                allocate.put(TRADE_TYPE.toBytes());
            }
            i2 += 2;
            b = 102;
            b2 = 55;
        }
        return ByteArray.wrap(allocate.array());
    }

    private float getRealMoney(byte[] bArr, int i, int i2, int i3, int i4) {
        return ((float) Integer.parseInt(Coder.bytesToHexString(ByteArray.wrap(bArr).duplicate(i, i2).toBytes()))) + (Float.parseFloat(Coder.bytesToHexString(ByteArray.wrap(bArr).duplicate(i3, i4).toBytes())) / 100.0f);
    }
}
