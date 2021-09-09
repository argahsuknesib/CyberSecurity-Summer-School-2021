package com.tsmclient.smartcard.handler.config;

import android.text.TextUtils;
import android.util.Log;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.exception.CardStatusException;
import com.tsmclient.smartcard.exception.UnProcessableCardException;
import com.tsmclient.smartcard.handler.BaseTransCardHandler;
import com.tsmclient.smartcard.model.ConfigRules;
import com.tsmclient.smartcard.model.TradeLog;
import com.tsmclient.smartcard.terminal.response.ScResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class ConfigCardHandler extends BaseTransCardHandler {
    private String mCardType;
    private Map<String, ScResponse> mCommandResult = new HashMap();
    private ConfigRules mConfigRules;

    public ConfigCardHandler(String str, ConfigRules configRules) {
        this.mCardType = str;
        this.mConfigRules = configRules;
    }

    public String getCardType() {
        return this.mCardType;
    }

    public void selectVerify() throws IOException, UnProcessableCardException {
        if (this.mConfigRules != null) {
            Log.d("ConfigCardHandler", "selectVerify card:" + this.mCardType + ", version:" + this.mConfigRules.mVersion + ", engine:3");
            executeCommands(this.mConfigRules.mSelectVerifyCommandList);
            return;
        }
        throw new IOException("config rules of " + this.mCardType + " can't be null");
    }

    public void otherVerify() throws IOException, UnProcessableCardException {
        executeCommands(this.mConfigRules.mOtherVerifyCommandList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057 A[SYNTHETIC, Splitter:B:18:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007c  */
    public int getBalance() throws IOException, UnProcessableCardException {
        int i;
        String str;
        List<ConfigRules.ParseDataCommand> list = this.mConfigRules.mReadBalanceCommandList;
        if (list == null || list.isEmpty()) {
            return super.getBalance();
        }
        HashMap hashMap = new HashMap();
        try {
            executeCommandsWithElements(list, hashMap);
        } catch (CardStatusException e) {
            Log.e("ConfigCardHandler", "CardStatusException occurred on getBalance.", e);
        }
        String str2 = (String) hashMap.get("e_balance");
        int i2 = 0;
        if (!TextUtils.isEmpty(str2)) {
            try {
                i = Coder.hexStringToInt(str2);
            } catch (Exception e2) {
                Log.d("ConfigCardHandler", "getBalance failed: " + e2.getMessage());
            }
            str = (String) hashMap.get("overdrawn");
            if (!TextUtils.isEmpty(str)) {
                try {
                    i2 = Coder.hexStringToInt(str);
                    updateCardInfo("overdrawn", String.valueOf(i2));
                } catch (Exception e3) {
                    Log.d("ConfigCardHandler", "getOverdraw failed: " + e3.getMessage());
                }
            }
            return i2 >= 0 ? i : i - i2;
        }
        i = 0;
        str = (String) hashMap.get("overdrawn");
        if (!TextUtils.isEmpty(str)) {
        }
        if (i2 >= 0) {
        }
    }

    public void readRecord(ArrayList<TradeLog> arrayList, boolean z) throws IOException {
        List<ConfigRules.ReadRecordCommand> readRecordCommandList = this.mConfigRules.getReadRecordCommandList();
        if (readRecordCommandList.isEmpty()) {
            super.readRecord(arrayList, z);
            return;
        }
        try {
            for (ConfigRules.ReadRecordCommand next : readRecordCommandList) {
                if (next.isExecute(this.mInternalRead)) {
                    executeCommands(next.mPreReadCommandList);
                    if (next.isReadRecordInstructionListEmpty()) {
                        super.readRecord(arrayList, z);
                    } else {
                        for (ConfigRules.ReadRecordInstruction next2 : next.getReadRecordInstructionList()) {
                            readRecord(arrayList, next2.mSkipOnceRead, next2.getP2(), next2.getSfi(), next2.isSkipParsingYear());
                        }
                    }
                }
            }
        } catch (UnProcessableCardException unused) {
            throw new IOException("failed to get record");
        }
    }

    public Map<String, String> getCardNumAndValidDate() throws IOException, UnProcessableCardException {
        HashMap hashMap = new HashMap();
        try {
            executeCommandsWithElements(this.mConfigRules.mCardNumValidDateCommandList, hashMap);
        } catch (CardStatusException e) {
            Log.e("ConfigCardHandler", "CardStatusException occurred on getCardNumAndValidDate.", e);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        Date date = new Date();
        boolean z = false;
        simpleDateFormat.setLenient(false);
        String str = (String) hashMap.get("valid_start");
        if (!TextUtils.isEmpty(str)) {
            try {
                hashMap.put("is_valid_start_date", String.valueOf(!date.before(simpleDateFormat.parse(str))));
            } catch (ParseException e2) {
                hashMap.put("is_valid_start_date", Boolean.FALSE.toString());
                Log.e("ConfigCardHandler", "parse start date failed.", e2);
            }
        }
        String str2 = (String) hashMap.get("valid_end");
        if (!TextUtils.isEmpty(str2)) {
            try {
                Date parse = simpleDateFormat.parse(str2);
                Calendar instance = Calendar.getInstance();
                instance.setTime(parse);
                instance.add(5, 1);
                if (!date.after(instance.getTime())) {
                    z = true;
                }
                hashMap.put("is_valid_end_date", String.valueOf(z));
            } catch (ParseException e3) {
                hashMap.put("is_valid_end_date", Boolean.FALSE.toString());
                Log.e("ConfigCardHandler", "parse end date failed.", e3);
            }
        }
        return hashMap;
    }

    public void readCardStatus(Map<String, String> map) throws IOException, UnProcessableCardException, CardStatusException {
        super.readCardStatus(map);
        executeCommandsWithElements(this.mConfigRules.mReadCardStatusCommandList, map);
    }

    private void mapValue(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        if (map != null && !map.isEmpty()) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (Pattern.compile((String) next.getKey()).matcher(str2).matches()) {
                    str2 = (String) next.getValue();
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(str2)) {
            map2.remove(str);
        } else {
            map2.put(str, str2);
        }
    }

    private void executeCommandsWithElements(List<ConfigRules.ParseDataCommand> list, Map<String, String> map) throws IOException, UnProcessableCardException, CardStatusException {
        ScResponse executeCommand;
        if (list != null) {
            for (ConfigRules.ParseDataCommand next : list) {
                if (next.isExecute(this.mInternalRead) && (executeCommand = executeCommand(next)) != null) {
                    if (!TextUtils.isEmpty(next.mResponseKey)) {
                        mapValue(next.mResponseKey, executeCommand.getStatus().toString(), next.mResponseMap, map);
                        if (!TextUtils.isEmpty(next.mExpectResponse)) {
                            Log.d("ConfigCardHandler", "responseKey: " + next.mResponseKey + ", expect: " + next.mExpectResponse);
                            assertPattern(next.mExpectResponse, map.get(next.mResponseKey), next.mResponseExceptionType);
                        }
                    }
                    if (next.mElementList != null) {
                        ByteArray data = executeCommand.getData();
                        int length = data.length();
                        for (ConfigRules.Element next2 : next.mElementList) {
                            if (next2.mOffset + next2.mLength <= length) {
                                String bytesToHexString = Coder.bytesToHexString(data.duplicate(next2.mOffset, next2.mLength).toBytes());
                                if (next2.mHexOffset >= 0) {
                                    if (bytesToHexString == null || bytesToHexString.length() < next2.mHexOffset + next2.mHexLength) {
                                        throw new UnProcessableCardException(this.mCardType + ": unsupported card type. Caused by HexOffset of " + next2.mKey);
                                    }
                                    bytesToHexString = bytesToHexString.substring(next2.mHexOffset, next2.mHexOffset + next2.mHexLength);
                                }
                                StringBuilder sb = new StringBuilder();
                                if (!TextUtils.isEmpty(next2.mPrefixHex)) {
                                    sb.append(next2.mPrefixHex);
                                }
                                if (bytesToHexString == null) {
                                    bytesToHexString = "";
                                }
                                sb.append(bytesToHexString);
                                if (!TextUtils.isEmpty(next2.mSuffixHex)) {
                                    sb.append(next2.mSuffixHex);
                                }
                                mapValue(next2.mKey, sb.toString(), next2.mValueMap, map);
                                if (!TextUtils.isEmpty(next2.mExpectValue)) {
                                    Log.d("ConfigCardHandler", "element: " + next2.mKey + ", expect: " + next2.mExpectValue);
                                    assertPattern(next2.mExpectValue, map.get(next2.mKey), next2.mValueExceptionType);
                                }
                            } else {
                                throw new UnProcessableCardException(this.mCardType + ": unsupported card type. Caused by Offset of " + next2.mKey);
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    private void executeCommands(List<ConfigRules.Command> list) throws IOException, UnProcessableCardException {
        if (list != null) {
            for (ConfigRules.Command next : list) {
                if (next.isExecute(this.mInternalRead)) {
                    executeCommand(next);
                }
            }
        }
    }

    private ScResponse executeCommand(ConfigRules.Command command) throws IOException, UnProcessableCardException {
        String str;
        if (command == null || TextUtils.isEmpty(command.mApdu) || 3 < command.mMinVersion) {
            return null;
        }
        if (command.mMaxVersion != -1 && 3 > command.mMaxVersion) {
            return null;
        }
        if (!TextUtils.isEmpty(command.mPreConditionKey)) {
            ScResponse scResponse = this.mCommandResult.get(command.mPreConditionKey);
            try {
                String str2 = command.mPreConditionExpectStatus;
                String str3 = "";
                if (scResponse == null) {
                    str = str3;
                } else {
                    str = scResponse.getStatus().toString();
                }
                assertPattern(str2, str);
                String str4 = command.mPreConditionExpectData;
                if (scResponse != null) {
                    str3 = scResponse.getData().toString();
                }
                assertPattern(str4, str3);
            } catch (UnProcessableCardException e) {
                Log.d("ConfigCardHandler", "precondition failed: " + e.getMessage());
                return null;
            }
        }
        Log.d("ConfigCardHandler", "executeCommand send: " + command.mApdu);
        ResponseImpl responseImpl = new ResponseImpl(transceive(Coder.hexStringToBytes(command.mApdu)));
        Log.d("ConfigCardHandler", "executeCommand receive: " + responseImpl.toString());
        this.mCommandResult.put(command.mApdu, responseImpl);
        assertPattern(command.mExpectStatus, responseImpl.getStatus().toString());
        assertPattern(command.mExpectData, responseImpl.getData().toString());
        return responseImpl;
    }

    private void assertPattern(String str, String str2, int i) throws UnProcessableCardException, CardStatusException {
        if (!TextUtils.isEmpty(str) && !Pattern.compile(str).matcher(str2).matches()) {
            Log.d("ConfigCardHandler", "assertPattern expect: " + str + ", but: " + str2 + ", throw: " + i);
            if (i == 1) {
                throw new CardStatusException(this.mCardType + " status is abnormal. Caused by " + str2 + " not matching " + str);
            }
            throw new UnProcessableCardException(this.mCardType + ": unsupported card type. Caused by " + str2 + " not matching " + str);
        }
    }

    private void assertPattern(String str, String str2) throws UnProcessableCardException {
        try {
            assertPattern(str, str2, 0);
        } catch (CardStatusException e) {
            Log.e("ConfigCardHandler", "CardStatusException occurred", e);
        }
    }
}
