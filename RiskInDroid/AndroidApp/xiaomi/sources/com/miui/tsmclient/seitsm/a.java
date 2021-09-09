package com.miui.tsmclient.seitsm;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.miui.tsmclient.account.AccountInfo;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.MifareCardInfo;
import com.miui.tsmclient.entity.MifareTag;
import com.miui.tsmclient.entity.UserExceptionLogInfo;
import com.miui.tsmclient.model.e.g;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.net.AuthRequest;
import com.miui.tsmclient.net.BaseAuthManager;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.util.DeviceUtils;
import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.Coder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends BaseAuthManager {
    private String a(CardInfo cardInfo) throws com.miui.tsmclient.seitsm.a.a {
        try {
            return cardInfo.getTerminal().getCPLC();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LogUtils.e("failed to get cplc", e);
            throw new com.miui.tsmclient.seitsm.a.a(11);
        } catch (IOException e2) {
            LogUtils.e("failed to get cplc", e2);
            throw new com.miui.tsmclient.seitsm.a.a(13);
        }
    }

    private String b(CardInfo cardInfo) throws com.miui.tsmclient.seitsm.a.a {
        try {
            return cardInfo.getTerminal().getSeid();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LogUtils.e("failed to get seId", e);
            throw new com.miui.tsmclient.seitsm.a.a(11);
        } catch (IOException e2) {
            LogUtils.e("failed to get seId", e2);
            throw new com.miui.tsmclient.seitsm.a.a(13);
        }
    }

    public TsmRpcModels.CommonResponse a(Context context) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        try {
            return TsmRpcModels.CommonResponse.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/se/deleteAllBankCard", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).create())));
        } catch (AuthApiException e2) {
            LogUtils.e("deleteAllBankCards failed, code: " + e2.mErrorCode + ", msg:" + e2.mErrorMsg, e2);
            throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
        } catch (InvalidProtocolBufferException e3) {
            LogUtils.e("deleteAllBankCards failed", e3);
            throw new com.miui.tsmclient.seitsm.a.a(16);
        }
    }

    public TsmRpcModels.CommonResponse a(Context context, Bundle bundle) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        if (bundle != null) {
            String deviceId = DeviceUtils.getDeviceId(context, null);
            if (!TextUtils.isEmpty(deviceId)) {
                String string = bundle.getString("card_reference_id");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        return TsmRpcModels.CommonResponse.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/unionPayQr/deleteQrBankCard", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(TsmRpcModels.DeleteQrBankCardRequest.newBuilder().setDeviceId(deviceId).setCardReferenceId(string).build().toByteArray())).create())));
                    } catch (AuthApiException e2) {
                        LogUtils.e("deleteQrBankCard failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
                        throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
                    } catch (InvalidProtocolBufferException e3) {
                        LogUtils.e("deleteQrBankCard failed", e3);
                        throw new com.miui.tsmclient.seitsm.a.a(16);
                    }
                } else {
                    LogUtils.d("failed to delete qr bank card, cardReferencedId is null");
                    throw new com.miui.tsmclient.seitsm.a.a(1);
                }
            } else {
                LogUtils.d("failed to delete qr bank card, deviceId is null");
                throw new com.miui.tsmclient.seitsm.a.a(1);
            }
        } else {
            LogUtils.d("failed to delete qr bank card, extras is null");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        }
    }

    public TsmRpcModels.CommonResponse a(Context context, UserExceptionLogInfo userExceptionLogInfo) throws com.miui.tsmclient.seitsm.a.a {
        if (userExceptionLogInfo == null) {
            return null;
        }
        AccountInfo e = e(context);
        String a2 = a(new CardInfo("DUMMY"));
        AuthRequest.AuthRequestBuilder newBuilder = AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/se/uploadExceptionUserLog", AuthRequest.RespContentType.protobuf);
        newBuilder.addParams("cplc", a2);
        for (Map.Entry next : userExceptionLogInfo.getParams().entrySet()) {
            newBuilder.addParams((String) next.getKey(), (String) next.getValue());
        }
        try {
            return TsmRpcModels.CommonResponse.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, newBuilder.create())));
        } catch (AuthApiException e2) {
            LogUtils.e("uploadExceptionUserLog failed, code: " + e2.mErrorCode + ", msg:" + e2.mErrorMsg, e2);
            throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
        } catch (InvalidProtocolBufferException e3) {
            LogUtils.e("uploadExceptionUserLog failed", e3);
            throw new com.miui.tsmclient.seitsm.a.a(16);
        }
    }

    public TsmRpcModels.CommonResponse a(Context context, TsmRpcModels.TsmSessionInfo tsmSessionInfo, boolean z, TsmRpcModels.SeOperationType seOperationType, List<TsmRpcModels.SeAPDUResponseItem> list) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        if (tsmSessionInfo == null) {
            LogUtils.w("failed to process finishing notification, session info is null");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        } else if (seOperationType != null) {
            try {
                return TsmRpcModels.CommonResponse.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/se/processFinishNotify", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(TsmRpcModels.ProcessFinishNotifyRequest.newBuilder().setSessionId(tsmSessionInfo.getSessionId()).setActionResult(z).setActionType(seOperationType).addAllResponse(list).build().toByteArray())).create())));
            } catch (AuthApiException e2) {
                LogUtils.e("processFinishNotify failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
                throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
            } catch (InvalidProtocolBufferException e3) {
                LogUtils.e("processFinishNotify failed", e3);
                throw new com.miui.tsmclient.seitsm.a.a(16);
            }
        } else {
            LogUtils.w("failed to process finishing notification, se operation type is null");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        }
    }

    public TsmRpcModels.CommonResponse a(Context context, MifareCardInfo... mifareCardInfoArr) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        CardInfo cardInfo = new CardInfo("DUMMY");
        String a2 = a(cardInfo);
        String b = b(cardInfo);
        if (mifareCardInfoArr == null || mifareCardInfoArr.length <= 0) {
            LogUtils.w("failed to update mifare card, card info is null");
        }
        ArrayList arrayList = new ArrayList();
        for (MifareCardInfo mifareCardInfo : mifareCardInfoArr) {
            arrayList.add(TsmRpcModels.DoorCardInfo.newBuilder().setAid(mifareCardInfo.mAid == null ? "" : mifareCardInfo.mAid).setCardType(TsmRpcModels.DoorCardType.valueOf(mifareCardInfo.getMifareCardType())).setName(mifareCardInfo.mCardName).setFingerFlag(mifareCardInfo.mFingerAuthFlag).setProductId(mifareCardInfo.getProductId()).setBusinessId(mifareCardInfo.getBusinessId()).setSeId(b).build());
        }
        try {
            return TsmRpcModels.CommonResponse.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/doorCard/update", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(TsmRpcModels.UpdateDoorCardRequest.newBuilder().setCplc(a2).addAllCardInfo(arrayList).build().toByteArray())).create())));
        } catch (AuthApiException e2) {
            LogUtils.e("updateMifareCard failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
            throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
        } catch (InvalidProtocolBufferException e3) {
            LogUtils.e("updateMifareCard failed", e3);
            throw new com.miui.tsmclient.seitsm.a.a(16);
        }
    }

    public TsmRpcModels.DoorCardInfo a(Context context, String str, int i, String str2) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        TsmRpcModels.DoorCardType valueOf = TsmRpcModels.DoorCardType.valueOf(i);
        if (valueOf != null) {
            CardInfo cardInfo = new CardInfo("DUMMY");
            String a2 = a(cardInfo);
            String b = b(cardInfo);
            TsmRpcModels.DeviceInfo.Builder deviceModel = TsmRpcModels.DeviceInfo.newBuilder().setDeviceModel(com.miui.tsmclient.util.a.b((CardInfo) null));
            TsmRpcModels.DeviceInfo build = deviceModel.setLang(Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry()).setMiuiSystemVersion(com.miui.tsmclient.util.a.a()).setMiuiRomType(com.miui.tsmclient.util.a.a((CardInfo) null)).setTsmclientVersionCode(DeviceUtils.getAppVersionCode(context)).setSeId(b).build();
            TsmRpcModels.QueryDoorCardRequest.Builder cardType = TsmRpcModels.QueryDoorCardRequest.newBuilder().setCplc(a2).setAid(str).setCardType(valueOf);
            if (str2 == null) {
                str2 = "";
            }
            try {
                TsmRpcModels.QueryDoorCardInfoResponse parseFrom = TsmRpcModels.QueryDoorCardInfoResponse.parseFrom(Coder.decodeBase64ToByteArray((String) sendGetRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/doorCard/query/byAid", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(cardType.setProductId(str2).setDeviceInfo(build).build().toByteArray())).create())));
                if (parseFrom != null && parseFrom.getCardInfoListList() != null && parseFrom.getCardInfoListList().size() > 0) {
                    return parseFrom.getCardInfoListList().get(0);
                }
                throw new com.miui.tsmclient.seitsm.a.a(16);
            } catch (AuthApiException e2) {
                LogUtils.e("queryMifareCardInfoByAid failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
                throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
            } catch (InvalidProtocolBufferException e3) {
                LogUtils.e("queryMifareCardInfoByAid failed", e3);
                throw new com.miui.tsmclient.seitsm.a.a(16);
            }
        } else {
            LogUtils.w("failed to query door card info by aid, card type is empty.");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        }
    }

    public TsmRpcModels.QueryBankCardInfoResponse a(Context context, String str) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        TsmRpcModels.QueryBankCardInfoRequest.Builder cplc = TsmRpcModels.QueryBankCardInfoRequest.newBuilder().setCplc(a(new CardInfo("DUMMY")));
        if (!TextUtils.isEmpty(str)) {
            cplc.setAid(str);
        }
        try {
            return TsmRpcModels.QueryBankCardInfoResponse.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/se/queryBankCardInfo", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(cplc.build().toByteArray())).create())));
        } catch (AuthApiException e2) {
            LogUtils.e("queryBankCardInfo failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
            throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
        } catch (InvalidProtocolBufferException e3) {
            LogUtils.e("queryBankCardInfo failed", e3);
            throw new com.miui.tsmclient.seitsm.a.a(16);
        }
    }

    public TsmRpcModels.TsmAPDUCommand a(Context context, TsmRpcModels.TsmSessionInfo tsmSessionInfo, CardInfo cardInfo, Bundle bundle) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        if (tsmSessionInfo != null) {
            try {
                return TsmRpcModels.TsmAPDUCommand.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/se/pullPersoData", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(TsmRpcModels.PullPersoDataRequest.newBuilder().setSessionId(tsmSessionInfo.getSessionId()).build().toByteArray())).create())));
            } catch (AuthApiException e2) {
                LogUtils.e("pullPersoData failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
                throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
            } catch (InvalidProtocolBufferException e3) {
                LogUtils.e("pullPersoData failed", e3);
                throw new com.miui.tsmclient.seitsm.a.a(16);
            }
        } else {
            LogUtils.w("failed to pull personal data, session info is null");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        }
    }

    public TsmRpcModels.TsmAPDUCommand a(Context context, TsmRpcModels.TsmSessionInfo tsmSessionInfo, CardInfo cardInfo, String str, Bundle bundle) throws com.miui.tsmclient.seitsm.a.a {
        String str2;
        AccountInfo e = e(context);
        if (tsmSessionInfo == null) {
            LogUtils.w("failed to start top-up operation, session info is null");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(cardInfo.mAid)) {
            LogUtils.w("failed to start top-up operation, authenticationCode is empty or appAid is empty");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        } else {
            TsmRpcModels.TopUpOperation.Builder newBuilder = TsmRpcModels.TopUpOperation.newBuilder();
            TsmRpcModels.TopUpOperation.Builder authenticationCode = newBuilder.setSessionId(tsmSessionInfo.getSessionId()).setAid(cardInfo.mAid).setAuthenticationCode(ByteString.copyFrom(Coder.hexStringToBytes(str)));
            if (TextUtils.isEmpty(cardInfo.mCardNo)) {
                str2 = "";
            } else if (TextUtils.isEmpty(cardInfo.mRealCardNo)) {
                str2 = cardInfo.mCardNo;
            } else {
                str2 = cardInfo.mCardNo + ";" + cardInfo.mRealCardNo;
            }
            authenticationCode.setCardNumber(str2).setBalance(cardInfo.mCardBalance);
            if (bundle != null) {
                String string = bundle.getString("extra_city_id");
                if (!TextUtils.isEmpty(string)) {
                    newBuilder.setCityId(string);
                }
            }
            if (bundle != null && bundle.containsKey("need_phone_number")) {
                String string2 = bundle.getString("need_phone_number");
                if (!TextUtils.isEmpty(string2)) {
                    newBuilder.setExtra(string2);
                }
            }
            try {
                return TsmRpcModels.TsmAPDUCommand.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/se/topUp", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(newBuilder.build().toByteArray())).create())));
            } catch (AuthApiException e2) {
                LogUtils.e("startTopupOperation failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
                throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
            } catch (InvalidProtocolBufferException e3) {
                LogUtils.e("startTopupOperation failed", e3);
                throw new com.miui.tsmclient.seitsm.a.a(16);
            }
        }
    }

    public TsmRpcModels.TsmAPDUCommand a(Context context, TsmRpcModels.TsmSessionInfo tsmSessionInfo, g gVar) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        if (tsmSessionInfo != null) {
            try {
                return TsmRpcModels.TsmAPDUCommand.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, gVar.d(), AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(TsmRpcModels.PullBusCardDataRequest.newBuilder().setSessionId(tsmSessionInfo.getSessionId()).build().toByteArray())).create())));
            } catch (AuthApiException e2) {
                LogUtils.e(gVar.c() + ": pullBusCardPersoData failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
                throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
            } catch (InvalidProtocolBufferException e3) {
                LogUtils.e(gVar.c() + ": pullBusCardPersoData failed", e3);
                throw new com.miui.tsmclient.seitsm.a.a(16);
            }
        } else {
            LogUtils.w(gVar.c() + ": failed to pull bus card personal data, session info is null");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x016a  */
    public TsmRpcModels.TsmAPDUCommand a(Context context, TsmRpcModels.TsmSessionInfo tsmSessionInfo, TsmRpcModels.SeOperationType seOperationType, CardInfo cardInfo, Bundle bundle) throws com.miui.tsmclient.seitsm.a.a {
        JSONObject jSONObject;
        String string;
        String string2;
        AccountInfo e = e(context);
        if (tsmSessionInfo == null) {
            LogUtils.w("failed to start se operation, session info is null");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        } else if (seOperationType != null) {
            TsmRpcModels.SeOperation.Builder type = TsmRpcModels.SeOperation.newBuilder().setSessionId(tsmSessionInfo.getSessionId()).setType(seOperationType);
            if (cardInfo != null && !TextUtils.isEmpty(cardInfo.mAid)) {
                type.setAid(cardInfo.mAid);
            }
            if (bundle != null) {
                String string3 = bundle.getString("authentication_code");
                if (!TextUtils.isEmpty(string3)) {
                    type.setAuthenticationCode(ByteString.copyFrom(Coder.hexStringToBytes(string3)));
                }
                String string4 = bundle.getString("extra_city_id");
                if (!TextUtils.isEmpty(string4)) {
                    type.setCityId(string4);
                }
                String string5 = bundle.getString("extra_source_channel");
                if (!TextUtils.isEmpty(string5)) {
                    type.setSourceChannel(string5);
                }
                String string6 = bundle.getString("need_phone_number");
                JSONObject jSONObject2 = null;
                try {
                    jSONObject2 = !TextUtils.isEmpty(string6) ? new JSONObject(string6) : new JSONObject();
                    if (cardInfo != null && !TextUtils.isEmpty(cardInfo.mCardType)) {
                        jSONObject2.put("card_name", cardInfo.mCardType);
                    }
                    jSONObject2.putOpt("serviceType", Integer.valueOf(bundle.getInt("serviceType", -1)));
                    jSONObject2.putOpt("only_sync_card", Boolean.valueOf(bundle.getBoolean("only_sync_card")));
                    jSONObject2.putOpt("nfc_id", bundle.get("nfc_id"));
                    String string7 = bundle.getString("business_id");
                    if (!TextUtils.isEmpty(string7)) {
                        jSONObject2.putOpt("business_id", string7);
                    }
                    String string8 = bundle.getString("callerPackageName");
                    if (!TextUtils.isEmpty(string8)) {
                        jSONObject2.putOpt("callerPackageName", string8);
                    }
                    String string9 = bundle.getString("door_card_business_id");
                    if (!TextUtils.isEmpty(string9)) {
                        jSONObject2.putOpt("door_card_business_id", string9);
                    }
                    if (bundle.containsKey("sync_operation")) {
                        jSONObject2.putOpt("sync_operation", Integer.valueOf(bundle.getInt("sync_operation")));
                    }
                } catch (JSONException e2) {
                    LogUtils.e("failed to start se operation", e2);
                }
                String string10 = bundle.getString("extra_data");
                if (!TextUtils.isEmpty(string10)) {
                    try {
                        jSONObject = new JSONObject(string10);
                        if (jSONObject2 == null) {
                            string = bundle.getString("orderId");
                            if (!TextUtils.isEmpty(string)) {
                                if (jSONObject == null) {
                                    try {
                                        jSONObject = new JSONObject();
                                    } catch (Exception e3) {
                                        LogUtils.e("failed to start se operation, put orderId failed", e3);
                                    }
                                }
                                jSONObject.put("orderId", string);
                            }
                            string2 = bundle.getString("spOrderId");
                            if (!TextUtils.isEmpty(string2)) {
                                if (jSONObject == null) {
                                    try {
                                        jSONObject = new JSONObject();
                                    } catch (Exception e4) {
                                        LogUtils.e("failed to start se operation, put spOrderId failed", e4);
                                    }
                                }
                                jSONObject.put("spOrderId", string2);
                            }
                            if (jSONObject != null) {
                                LogUtils.v("json: " + jSONObject.toString());
                                type.setExtra(jSONObject.toString());
                            }
                        } else {
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                jSONObject2.put(next, jSONObject.opt(next));
                            }
                        }
                    } catch (Exception e5) {
                        LogUtils.e("parse extraData failed", e5);
                    }
                }
                jSONObject = jSONObject2;
                string = bundle.getString("orderId");
                if (!TextUtils.isEmpty(string)) {
                }
                string2 = bundle.getString("spOrderId");
                if (!TextUtils.isEmpty(string2)) {
                }
                if (jSONObject != null) {
                }
            }
            try {
                return TsmRpcModels.TsmAPDUCommand.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/se/startSeOperation", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(type.build().toByteArray())).create())));
            } catch (AuthApiException e6) {
                LogUtils.e("startSeOperation failed, code: " + e6.mErrorCode + ", msg: " + e6.mErrorMsg, e6);
                throw new com.miui.tsmclient.seitsm.a.a(e6.mErrorCode, e6.mErrorMsg);
            } catch (InvalidProtocolBufferException e7) {
                LogUtils.e("startSeOperation failed", e7);
                throw new com.miui.tsmclient.seitsm.a.a(16);
            }
        } else {
            LogUtils.w("failed to start se operation, operation type is null");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        }
    }

    public TsmRpcModels.TsmAPDUCommand a(Context context, TsmRpcModels.TsmSessionInfo tsmSessionInfo, String str) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        try {
            return TsmRpcModels.TsmAPDUCommand.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/eid/enroll", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(TsmRpcModels.EnrollEidRequest.newBuilder().setSessionId(tsmSessionInfo.getSessionId()).setSpToken(str).build().toByteArray())).create())));
        } catch (AuthApiException e2) {
            LogUtils.e("installEidCard failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
            throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
        } catch (InvalidProtocolBufferException e3) {
            LogUtils.e("installEidCard failed", e3);
            throw new com.miui.tsmclient.seitsm.a.a(16);
        }
    }

    public TsmRpcModels.TsmAPDUCommand a(Context context, TsmRpcModels.TsmSessionInfo tsmSessionInfo, String str, MifareTag mifareTag, int i, String str2, String str3, Bundle bundle) throws com.miui.tsmclient.seitsm.a.a {
        String string = bundle.getString("communityCode");
        String string2 = bundle.getString("businessId");
        String string3 = bundle.getString("ticket");
        boolean z = bundle.getBoolean("overWrite");
        String string4 = bundle.getString("issuerId");
        AccountInfo e = e(context);
        TsmRpcModels.DoorCardType valueOf = TsmRpcModels.DoorCardType.valueOf(i);
        if (valueOf == null) {
            LogUtils.w("failed to install door card, card type is empty.");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        } else if (mifareTag == null && i == 0) {
            LogUtils.w("failed to install door card, tag info is null");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        } else {
            TsmRpcModels.MifareCardParam.Builder newBuilder = TsmRpcModels.MifareCardParam.newBuilder();
            if (mifareTag != null) {
                if (!TextUtils.isEmpty(mifareTag.getUid())) {
                    newBuilder.setUid(mifareTag.getUid());
                }
                if (!TextUtils.isEmpty(mifareTag.getAtqa())) {
                    newBuilder.setAtqa(mifareTag.getAtqa());
                }
                if (!TextUtils.isEmpty(mifareTag.getSak())) {
                    newBuilder.setSak(mifareTag.getSak());
                }
                if (!TextUtils.isEmpty(mifareTag.getBlockContent())) {
                    newBuilder.setContent(mifareTag.getBlockContent());
                }
                newBuilder.setSize(mifareTag.getSize());
            }
            TsmRpcModels.EnrollDoorCardRequest.Builder sessionId = TsmRpcModels.EnrollDoorCardRequest.newBuilder().setSessionId(tsmSessionInfo.getSessionId());
            String str4 = "";
            if (str == null) {
                str = str4;
            }
            TsmRpcModels.EnrollDoorCardRequest.Builder productId = sessionId.setProductId(str);
            if (string4 == null) {
                string4 = str4;
            }
            TsmRpcModels.EnrollDoorCardRequest.Builder mifareCardParam = productId.setIssuerId(string4).setCardType(valueOf).setMifareCardParam(newBuilder);
            if (str2 != null) {
                str4 = str2;
            }
            TsmRpcModels.EnrollDoorCardRequest.Builder issuerToken = mifareCardParam.setIssuerToken(str4);
            if (TextUtils.isEmpty(str3)) {
                str3 = "tsmclient";
            }
            try {
                return TsmRpcModels.TsmAPDUCommand.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/doorCard/enroll", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(issuerToken.setApplyChannel(str3).setBusinessId(string2).setCommunityCode(string).setTicket(string3).setOverwrite(z).build().toByteArray())).create())));
            } catch (AuthApiException e2) {
                LogUtils.e("installDoorCard failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
                throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
            } catch (InvalidProtocolBufferException e3) {
                LogUtils.e("installDoorCard failed", e3);
                throw new com.miui.tsmclient.seitsm.a.a(16);
            }
        }
    }

    public TsmRpcModels.TsmAPDUCommand a(Context context, TsmRpcModels.TsmSessionInfo tsmSessionInfo, List<TsmRpcModels.SeAPDUResponseItem> list) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        if (tsmSessionInfo != null) {
            try {
                return TsmRpcModels.TsmAPDUCommand.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/se/processSeResponse", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(TsmRpcModels.SeAPDUResponse.newBuilder().setSessionId(tsmSessionInfo.getSessionId()).addAllResponse(list).build().toByteArray())).create())));
            } catch (AuthApiException e2) {
                LogUtils.e("processSeResponse failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
                throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
            } catch (InvalidProtocolBufferException e3) {
                LogUtils.e("processSeResponse failed", e3);
                throw new com.miui.tsmclient.seitsm.a.a(16);
            }
        } else {
            LogUtils.w("failed to process se response, session info is null");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        }
    }

    public TsmRpcModels.TsmSessionInfo a(Context context, CardInfo cardInfo) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        String a2 = a(cardInfo);
        String deviceId = DeviceUtils.getDeviceId(context, cardInfo);
        if (!TextUtils.isEmpty(deviceId)) {
            TsmRpcModels.DeviceInfo.Builder deviceModel = TsmRpcModels.DeviceInfo.newBuilder().setDeviceModel(com.miui.tsmclient.util.a.b(cardInfo));
            try {
                return TsmRpcModels.TsmSessionInfo.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/se/createSession", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(TsmRpcModels.SeInfo.newBuilder().setCplc(ByteString.copyFrom(Coder.hexStringToBytes(a2))).setDeviceType(com.miui.tsmclient.util.a.b(cardInfo)).setDeviceId(deviceId).setActionSource(TsmRpcModels.ActionSource.APP_CLIENT).setDeviceInfo(deviceModel.setLang(Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry()).setMiuiSystemVersion(com.miui.tsmclient.util.a.a()).setMiuiRomType(com.miui.tsmclient.util.a.a(cardInfo)).setTsmclientVersionCode(com.miui.tsmclient.util.a.a(context)).build()).build().toByteArray())).create())));
            } catch (AuthApiException e2) {
                LogUtils.e("createSession failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
                throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
            } catch (InvalidProtocolBufferException e3) {
                LogUtils.e("createSession failed", e3);
                throw new com.miui.tsmclient.seitsm.a.a(16);
            }
        } else {
            throw new com.miui.tsmclient.seitsm.a.a(15);
        }
    }

    public TsmRpcModels.TsmStartActionResponse a(Context context, CardInfo cardInfo, TsmRpcModels.SeOperationType seOperationType, String str) throws AuthApiException, com.miui.tsmclient.seitsm.a.a {
        AccountInfo accountInfo = getAccountInfo(context);
        String a2 = a(cardInfo);
        String deviceId = DeviceUtils.getDeviceId(context, null);
        TsmRpcModels.DeviceInfo.Builder deviceModel = TsmRpcModels.DeviceInfo.newBuilder().setDeviceModel(com.miui.tsmclient.util.a.b(cardInfo));
        try {
            return TsmRpcModels.TsmStartActionResponse.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/se/startAction", AuthRequest.RespContentType.protobuf).addParams("userId", accountInfo.getUserId()).addParams("req", Coder.encodeBase64Coder(TsmRpcModels.TsmStartActionInfo.newBuilder().setSeInfo(TsmRpcModels.SeInfo.newBuilder().setCplc(ByteString.copyFrom(Coder.hexStringToBytes(a2))).setDeviceType(com.miui.tsmclient.util.a.b(cardInfo)).setDeviceId(deviceId).setActionSource(TsmRpcModels.ActionSource.APP_CLIENT).setDeviceInfo(deviceModel.setLang(Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry()).setMiuiSystemVersion(com.miui.tsmclient.util.a.a()).setMiuiRomType(com.miui.tsmclient.util.a.a((CardInfo) null)).setTsmclientVersionCode(com.miui.tsmclient.util.a.a(context)).build()).build()).setActionName(seOperationType).setParams(str).build().toByteArray())).create())));
        } catch (AuthApiException e) {
            LogUtils.e("startAction failed, code: " + e.mErrorCode + ", msg: " + e.mErrorMsg, e);
            throw new com.miui.tsmclient.seitsm.a.a(e.mErrorCode, e.mErrorMsg);
        } catch (InvalidProtocolBufferException e2) {
            LogUtils.e("startAction failed", e2);
            throw new com.miui.tsmclient.seitsm.a.a(16);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String sendRequest(Context context, AccountInfo accountInfo, AuthRequest authRequest) throws AuthApiException {
        return (String) super.sendRequest(context, accountInfo, authRequest);
    }

    public TsmRpcModels.QueryDoorCardInfoResponse b(Context context) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        CardInfo cardInfo = new CardInfo("DUMMY");
        String a2 = a(cardInfo);
        String b = b(cardInfo);
        TsmRpcModels.DeviceInfo.Builder deviceModel = TsmRpcModels.DeviceInfo.newBuilder().setDeviceModel(com.miui.tsmclient.util.a.b((CardInfo) null));
        try {
            return TsmRpcModels.QueryDoorCardInfoResponse.parseFrom(Coder.decodeBase64ToByteArray((String) sendGetRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/doorCard/list", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("cplc", a2).addParams("req", Coder.encodeBase64Coder(deviceModel.setLang(Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry()).setMiuiSystemVersion(com.miui.tsmclient.util.a.a()).setMiuiRomType(com.miui.tsmclient.util.a.a((CardInfo) null)).setTsmclientVersionCode(DeviceUtils.getAppVersionCode(context)).setSeId(b).build().toByteArray())).create())));
        } catch (AuthApiException e2) {
            LogUtils.e("queryMifareCardList failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
            throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
        } catch (InvalidProtocolBufferException e3) {
            LogUtils.e("queryMifareCardList failed", e3);
            throw new com.miui.tsmclient.seitsm.a.a(16);
        }
    }

    public TsmRpcModels.EidInfoResponse c(Context context) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        try {
            return TsmRpcModels.EidInfoResponse.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/eid/queryEidInfo", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("cplc", a(new CardInfo("DUMMY"))).create())));
        } catch (AuthApiException e2) {
            LogUtils.e("queryEidCard failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
            throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
        } catch (InvalidProtocolBufferException e3) {
            LogUtils.e("queryEidCard failed", e3);
            throw new com.miui.tsmclient.seitsm.a.a(16);
        }
    }

    public TsmRpcModels.BankCardListForQrResponse d(Context context) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo e = e(context);
        String deviceId = DeviceUtils.getDeviceId(context, null);
        if (!TextUtils.isEmpty(deviceId)) {
            try {
                return TsmRpcModels.BankCardListForQrResponse.parseFrom(Coder.decodeBase64ToByteArray(sendRequest(context, e, AuthRequest.AuthRequestBuilder.newBuilder(e, "api/%s/unionPayQr/getBankCardList", AuthRequest.RespContentType.protobuf).addParams("userId", e.getUserId()).addParams("req", Coder.encodeBase64Coder(TsmRpcModels.BankCardListForQrRequest.newBuilder().setDeviceId(deviceId).build().toByteArray())).create())));
            } catch (AuthApiException e2) {
                LogUtils.e("getBankCardListForQR failed, code: " + e2.mErrorCode + ", msg: " + e2.mErrorMsg, e2);
                throw new com.miui.tsmclient.seitsm.a.a(e2.mErrorCode, e2.mErrorMsg);
            } catch (InvalidProtocolBufferException e3) {
                LogUtils.e("getBankCardListForQR failed", e3);
                throw new com.miui.tsmclient.seitsm.a.a(16);
            }
        } else {
            LogUtils.d("failed to get bank card list for qr, param is null");
            throw new com.miui.tsmclient.seitsm.a.a(1);
        }
    }

    /* access modifiers changed from: protected */
    public AccountInfo e(Context context) throws com.miui.tsmclient.seitsm.a.a {
        AccountInfo loadAccountInfo = this.mAccountManager.loadAccountInfo(context);
        if (loadAccountInfo != null && loadAccountInfo.isValid()) {
            return loadAccountInfo;
        }
        throw new com.miui.tsmclient.seitsm.a.a(14);
    }
}
