package com.miui.tsmclient.sesdk;

import android.accounts.Account;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.a.a;
import com.miui.tsmclient.account.TSMAccountManager;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.common.net.internal.okhttp.InternalIOException;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.CardInfoFactory;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.entity.UncompletedBusiness;
import com.miui.tsmclient.entity.h;
import com.miui.tsmclient.model.BaseModel;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.BaseTransitCardModel;
import com.miui.tsmclient.model.ErrorCode;
import com.miui.tsmclient.model.g;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.net.request.k;
import com.miui.tsmclient.net.request.l;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.NetworkUtil;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.model.TradeLog;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class CardOpenService extends Service {
    private a mService;

    public static final class CardData {
        @SerializedName("balance")
        public int mBalance;
        @SerializedName("cardBusinessStatus")
        public String mCardBusinessStatus;
        @SerializedName("cardBusinessStatusDesc")
        public String mCardBusinessStatusDesc;
        @SerializedName("cardNo")
        public String mCardNo;
        public int mDataType;
        @SerializedName("logicCardNo")
        public String mLogicCardNo;
        @SerializedName("tradeRecords")
        public List<TradeRecord> mTradeRecords;
        @SerializedName("validityDate")
        public String mValidityDate;

        public static class CardDataSerializer implements JsonSerializer<CardData> {
            public JsonElement serialize(CardData cardData, Type type, JsonSerializationContext jsonSerializationContext) {
                JsonObject jsonObject = new JsonObject();
                int i = cardData.mDataType;
                boolean z = i == 0;
                if ((i & 1) != 0 || z) {
                    jsonObject.addProperty("cardNo", cardData.mCardNo);
                    jsonObject.addProperty("logicCardNo", cardData.mLogicCardNo);
                }
                if ((i & 2) != 0 || z) {
                    jsonObject.addProperty("balance", Integer.valueOf(cardData.mBalance));
                }
                if ((i & 4) != 0 || z) {
                    jsonObject.addProperty("validityDate", cardData.mValidityDate);
                }
                if ((i & 8) != 0 || z) {
                    jsonObject.add("tradeRecords", jsonSerializationContext.serialize(cardData.mTradeRecords));
                }
                if (!TextUtils.isEmpty(cardData.mCardBusinessStatus)) {
                    jsonObject.addProperty("cardBusinessStatus", cardData.mCardBusinessStatus);
                }
                if (!TextUtils.isEmpty(cardData.mCardBusinessStatusDesc)) {
                    jsonObject.addProperty("cardBusinessStatusDesc", cardData.mCardBusinessStatusDesc);
                }
                return jsonObject;
            }
        }

        static final class TradeRecord {
            @SerializedName("tradeAmount")
            private int mTradeAmount;
            @SerializedName("tradeDate")
            private String mTradeDate;
            @SerializedName("tradeType")
            private int mTradeType;

            private TradeRecord(TradeLog tradeLog) {
                this.mTradeType = tradeLog.getTradeType();
                this.mTradeAmount = (int) tradeLog.getAuAmount();
                if (!TextUtils.isEmpty(tradeLog.getTradeDate()) && !TextUtils.isEmpty(tradeLog.getTradeTime())) {
                    this.mTradeDate = tradeLog.getTradeDate() + tradeLog.getTradeTime();
                }
            }
        }

        private CardData(CardInfo cardInfo, int i) {
            UncompletedBusiness uncompletedBusiness;
            this.mDataType = i;
            this.mCardNo = cardInfo.mCardNo == null ? "" : cardInfo.mCardNo;
            this.mLogicCardNo = cardInfo.mRealCardNo;
            this.mBalance = cardInfo.mCardBalance;
            this.mValidityDate = cardInfo.mEndDate;
            this.mTradeRecords = new ArrayList();
            if (cardInfo.mTradeLogs != null) {
                for (TradeLog tradeRecord : cardInfo.mTradeLogs) {
                    this.mTradeRecords.add(new TradeRecord(tradeRecord));
                }
            }
            if ((cardInfo instanceof PayableCardInfo) && (uncompletedBusiness = ((PayableCardInfo) cardInfo).getUncompletedBusiness()) != null) {
                this.mCardBusinessStatus = uncompletedBusiness.getBusinessStatus();
                this.mCardBusinessStatusDesc = uncompletedBusiness.getRespDesc();
            }
        }
    }

    public static final class Response {
        @SerializedName("data")
        private Object mData;
        @SerializedName("resultMsg")
        private String mMsg;
        @SerializedName("resultCode")
        private int mResultCode;

        Response(Context context, int i) {
            this(context, i, null);
        }

        Response(Context context, int i, Object obj) {
            this(context, i, null, obj);
        }

        Response(Context context, int i, String str, Object obj) {
            this.mResultCode = -1;
            this.mResultCode = i;
            this.mMsg = isSuccess() ? "" : ErrorCode.getErrorText(context, i, str);
            this.mData = obj;
        }

        public final boolean isSuccess() {
            return this.mResultCode == 0;
        }

        public final String toString() {
            return new GsonBuilder().registerTypeAdapter(CardData.class, new CardData.CardDataSerializer()).create().toJson(this);
        }
    }

    class ServiceImpl extends a.C0024a {
        private Context mContext;
        private MiPayService mMiPayService = new MiPayService();

        public ServiceImpl(Context context) {
            this.mContext = context;
        }

        private Response checkCallingApp(Map map) {
            String str = (String) map.get("cardType");
            String str2 = (String) map.get("spId");
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return new Response(this.mContext, 1);
            }
            Response response = new Response(this.mContext, 20);
            int callingUid = Binder.getCallingUid();
            PackageManager packageManager = this.mContext.getPackageManager();
            String[] packagesForUid = packageManager.getPackagesForUid(callingUid);
            if (packagesForUid == null || packagesForUid.length == 0) {
                return response;
            }
            int i = 0;
            try {
                String str3 = packagesForUid[0];
                map.put("callerPackageName", str3);
                LogUtils.d("CardOpenService checkCallingApp packageName:".concat(String.valueOf(str3)));
                PackageInfo packageInfo = packageManager.getPackageInfo(str3, 64);
                if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                    MessageDigest instance = MessageDigest.getInstance("SHA-1");
                    instance.update(packageInfo.signatures[0].toByteArray());
                    CommonResponseInfo commonResponseInfo = (CommonResponseInfo) HttpClient.getInstance(this.mContext).execute(new k(str2, str, Coder.bytesToHexString(instance.digest()))).getResult();
                    if (commonResponseInfo != null) {
                        Context context = this.mContext;
                        if (!commonResponseInfo.isSuccess()) {
                            i = commonResponseInfo.getErrorCode();
                        }
                        return new Response(context, i, commonResponseInfo.getErrorDesc(), null);
                    }
                }
            } catch (InternalIOException e) {
                return new Response(this.mContext, e.getErrorCode(), e.getMessage(), null);
            } catch (Exception e2) {
                LogUtils.e("checkCallingApp error occurred", e2);
            }
            return response;
        }

        private UncompletedBusiness checkTransCardUncompletedBusiness(String str) {
            List<UncompletedBusiness> list;
            try {
                list = ((BaseTransitCardModel) BaseModel.create(this.mContext, BaseTransitCardModel.class)).queryUncompletedBusiness(str);
            } catch (AuthApiException e) {
                LogUtils.e("checkTransCardUncompletedBusiness failed! :" + e.mErrorMsg);
                list = null;
            }
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (UncompletedBusiness) list.get(0);
        }

        private Bundle getBundle(Map map) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("out_operation", true);
            if (map != null) {
                bundle.putString("business_id", (String) map.get("businessId"));
                bundle.putString("callerPackageName", (String) map.get("callerPackageName"));
                Map map2 = (Map) map.get("extraData");
                if (map2 != null) {
                    bundle.putString("extra_data", new Gson().toJson(map2));
                }
            }
            return bundle;
        }

        private SeCard getCard(Map map) {
            String str = (String) map.get("cardType");
            try {
                List<SeCard> transitCardList = this.mMiPayService.getTransitCardList(str, false);
                if (!transitCardList.isEmpty()) {
                    return transitCardList.get(0);
                }
                return null;
            } catch (AuthApiException e) {
                LogUtils.e("getCard:" + str + " failed", e);
                return null;
            }
        }

        private Response getNfcEEStatus() {
            return new Response(this.mContext, CardInfoFactory.makeCardInfo("DUMMY", null).getDeviceInfo().isEseEnabled(this.mContext) ? 0 : 31);
        }

        private String getParam(Map map) {
            return new JSONObject((Map<?, ?>) map).toString();
        }

        private Map getParamMap(Map map) {
            HashMap hashMap = new HashMap();
            hashMap.put("out_operation", Boolean.TRUE);
            if (map != null) {
                hashMap.put("business_id", (String) map.get("businessId"));
                hashMap.put("callerPackageName", (String) map.get("callerPackageName"));
                Map map2 = (Map) map.get("extraData");
                if (map2 != null) {
                    hashMap.put("extra_data", new Gson().toJson(map2));
                }
            }
            return hashMap;
        }

        private void notify(String str, String str2) {
            Intent intent = new Intent("com.xiaomi.tsmclient.platform.action.UPDATE_CARD_INFO");
            intent.putExtra("action_type", str2);
            intent.putExtra("card_type", str);
            this.mContext.sendBroadcast(intent);
        }

        public String deleteCard(Map map) throws RemoteException {
            LogUtils.d("CardOpenService deleteCard called");
            Response checkCallingApp = checkCallingApp(map);
            if (!checkCallingApp.isSuccess()) {
                return checkCallingApp.toString();
            }
            long clearCallingIdentity = clearCallingIdentity();
            try {
                SeCard card = getCard(map);
                if (card == null) {
                    return new Response(this.mContext, 2).toString();
                }
                BaseResponse baseResponse = new BaseResponse();
                if (card.getCategory() == CardCategory.TRANSIT) {
                    baseResponse = card.returnCard(getParam(getParamMap(map)));
                }
                if (card.getCategory() == CardCategory.DOOR) {
                    baseResponse = card.delete(getParam(getParamMap(map)));
                }
                if (baseResponse.isSuccess()) {
                    notify(card.getId(), "delete");
                }
                String response = new Response(this.mContext, baseResponse.mResultCode, baseResponse.mMsg, null).toString();
                LogUtils.d("CardOpenService deleteCard: ".concat(String.valueOf(response)));
                restoreCallingIdentity(clearCallingIdentity);
                return response;
            } finally {
                restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public String getSeid(Map map) throws RemoteException {
            LogUtils.d("CardOpenService getSeid called");
            Response checkCallingApp = checkCallingApp(map);
            if (!checkCallingApp.isSuccess()) {
                return checkCallingApp.toString();
            }
            long clearCallingIdentity = clearCallingIdentity();
            try {
                SeCard card = getCard(map);
                if (card == null) {
                    String response = new Response(this.mContext, 2).toString();
                    restoreCallingIdentity(clearCallingIdentity);
                    return response;
                }
                String str = null;
                str = card.mCardInfo.getTerminal().getCPLC();
                if (TextUtils.isEmpty(str)) {
                    String response2 = new Response(this.mContext, 13).toString();
                    restoreCallingIdentity(clearCallingIdentity);
                    return response2;
                }
                try {
                    h hVar = (h) HttpClient.getInstance(this.mContext).execute(new l((String) map.get("spId"), (String) map.get("cardType"), str)).getResult();
                    if (hVar != null) {
                        String response3 = new Response(this.mContext, hVar.isSuccess() ? 0 : hVar.getErrorCode(), hVar.getErrorDesc(), hVar.a()).toString();
                        restoreCallingIdentity(clearCallingIdentity);
                        return response3;
                    }
                } catch (IOException e) {
                    LogUtils.e("execute GetSeidRequest failed", e);
                }
                String response4 = new Response(this.mContext, 2).toString();
                restoreCallingIdentity(clearCallingIdentity);
                return response4;
            } catch (Exception e2) {
                LogUtils.e("getCplc error on getSeid", e2);
            } catch (Throwable th) {
                restoreCallingIdentity(clearCallingIdentity);
                throw th;
            }
        }

        public String getServiceStatus(Map map) throws RemoteException {
            String str;
            LogUtils.d("CardOpenService getServiceStatus called");
            if (!NetworkUtil.isConnected(this.mContext)) {
                return new Response(this.mContext, 2).toString();
            }
            Response checkCallingApp = checkCallingApp(map);
            if (!checkCallingApp.isSuccess()) {
                return checkCallingApp.toString();
            }
            long clearCallingIdentity = clearCallingIdentity();
            try {
                Account account = new TSMAccountManager().getAccount(this.mContext);
                if (account != null) {
                    if (account.name != null) {
                        String str2 = (String) map.get("cardType");
                        String str3 = (String) map.get("spId");
                        SeCard card = getCard(map);
                        if (card == null) {
                            String response = new Response(this.mContext, 2).toString();
                            restoreCallingIdentity(clearCallingIdentity);
                            return response;
                        }
                        str = card.mCardInfo.getTerminal().getCPLC();
                        try {
                            CommonResponseInfo commonResponseInfo = (CommonResponseInfo) HttpClient.getInstance(this.mContext).execute(new com.miui.tsmclient.net.request.h(str3, str2, str, (String) map.get("actionType"))).getResult();
                            if (commonResponseInfo != null) {
                                Response nfcEEStatus = getNfcEEStatus();
                                if (!nfcEEStatus.isSuccess()) {
                                    String response2 = nfcEEStatus.toString();
                                    restoreCallingIdentity(clearCallingIdentity);
                                    return response2;
                                } else if (TextUtils.isEmpty(str)) {
                                    String response3 = new Response(this.mContext, 13).toString();
                                    restoreCallingIdentity(clearCallingIdentity);
                                    return response3;
                                } else {
                                    String response4 = new Response(this.mContext, commonResponseInfo.isSuccess() ? 0 : commonResponseInfo.getErrorCode(), commonResponseInfo.getErrorDesc(), null).toString();
                                    restoreCallingIdentity(clearCallingIdentity);
                                    return response4;
                                }
                            }
                        } catch (IOException e) {
                            LogUtils.e("execute TransitServiceStatusRequest failed", e);
                        }
                        String response5 = new Response(this.mContext, 2).toString();
                        LogUtils.d("CardOpenService getServiceStatus: ".concat(String.valueOf(response5)));
                        restoreCallingIdentity(clearCallingIdentity);
                        return response5;
                    }
                }
                String response6 = new Response(this.mContext, 14).toString();
                restoreCallingIdentity(clearCallingIdentity);
                return response6;
            } catch (Exception e2) {
                LogUtils.e("getCplc error on getServiceStatus", e2);
                str = null;
            } catch (Throwable th) {
                restoreCallingIdentity(clearCallingIdentity);
                throw th;
            }
        }

        public String issueCard(Map map) throws RemoteException {
            LogUtils.d("CardOpenService issueCard called");
            Response checkCallingApp = checkCallingApp(map);
            if (!checkCallingApp.isSuccess()) {
                return checkCallingApp.toString();
            }
            long clearCallingIdentity = clearCallingIdentity();
            try {
                SeCard card = getCard(map);
                if (card == null) {
                    return new Response(this.mContext, 2).toString();
                }
                BaseResponse issue = card.issue(getParam(getParamMap(map)));
                if (issue.isSuccess()) {
                    notify(card.getId(), "add");
                }
                String response = new Response(this.mContext, issue.mResultCode, issue.mMsg, null).toString();
                LogUtils.d("CardOpenService issueCard: ".concat(String.valueOf(response)));
                restoreCallingIdentity(clearCallingIdentity);
                return response;
            } finally {
                restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public String preIssueCard(Map map) throws RemoteException {
            LogUtils.d("CardOpenService preIssueCard called");
            Response checkCallingApp = checkCallingApp(map);
            if (!checkCallingApp.isSuccess()) {
                return checkCallingApp.toString();
            }
            long clearCallingIdentity = clearCallingIdentity();
            try {
                SeCard card = getCard(map);
                if (card == null) {
                    return new Response(this.mContext, 2).toString();
                }
                Bundle bundle = getBundle(map);
                bundle.putBoolean("pre_load", true);
                BaseResponse b = g.a((String) map.get("cardType")).b(this.mContext, card.mCardInfo, bundle);
                String response = new Response(this.mContext, b.mResultCode, b.mMsg, null).toString();
                LogUtils.d("CardOpenService preIssueCard: ".concat(String.valueOf(response)));
                restoreCallingIdentity(clearCallingIdentity);
                return response;
            } finally {
                restoreCallingIdentity(clearCallingIdentity);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A[Catch:{ IOException -> 0x008b, all -> 0x00a1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[SYNTHETIC, Splitter:B:18:0x0049] */
        public String queryCardInfo(Map map) throws RemoteException {
            int i;
            SeCard card;
            LogUtils.d("CardOpenService queryCardInfo called");
            Response checkCallingApp = checkCallingApp(map);
            if (!checkCallingApp.isSuccess()) {
                return checkCallingApp.toString();
            }
            int i2 = 0;
            if (map.containsKey("dataType")) {
                try {
                    i = ((Integer) map.get("dataType")).intValue();
                } catch (Exception e) {
                    LogUtils.e("queryCardInfo failed when parsing dataType", e);
                }
                long clearCallingIdentity = clearCallingIdentity();
                card = getCard(map);
                if (card != null) {
                    return new Response(this.mContext, 2).toString();
                }
                UncompletedBusiness checkTransCardUncompletedBusiness = checkTransCardUncompletedBusiness(card.getId());
                if (card.mCardInfo instanceof PayableCardInfo) {
                    ((PayableCardInfo) card.mCardInfo).setUncompletedBusiness(checkTransCardUncompletedBusiness);
                }
                card.updateContent();
                if (!card.isIssued()) {
                    i2 = 2003;
                }
                return new Response(this.mContext, i2, card.isIssued() ? null : "not exist", new CardData(card.mCardInfo, i)).toString();
            }
            i = 0;
            long clearCallingIdentity2 = clearCallingIdentity();
            try {
                card = getCard(map);
                if (card != null) {
                }
            } catch (IOException e2) {
                LogUtils.e("queryCardInfo failed", e2);
                return new Response(this.mContext, -1, null, null).toString();
            } finally {
                restoreCallingIdentity(clearCallingIdentity2);
            }
        }

        public String recharge(Map map) throws RemoteException {
            LogUtils.d("CardOpenService recharge called");
            Response checkCallingApp = checkCallingApp(map);
            if (!checkCallingApp.isSuccess()) {
                return checkCallingApp.toString();
            }
            long clearCallingIdentity = clearCallingIdentity();
            try {
                SeCard card = getCard(map);
                if (card == null) {
                    return new Response(this.mContext, 2).toString();
                }
                BaseResponse recharge = card.recharge(getParam(getParamMap(map)));
                if (recharge.isSuccess()) {
                    notify(card.getId(), "update");
                }
                String response = new Response(this.mContext, recharge.mResultCode, recharge.mMsg, null).toString();
                LogUtils.d("CardOpenService recharge: ".concat(String.valueOf(response)));
                restoreCallingIdentity(clearCallingIdentity);
                return response;
            } finally {
                restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        if (this.mService == null) {
            this.mService = new ServiceImpl(this);
        }
        return this.mService.asBinder();
    }
}
