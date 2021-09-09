package com.miui.tsmclient.net;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.miui.tsmclient.account.AccountInfo;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.entity.ActionToken;
import com.miui.tsmclient.entity.CardGroupType;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.CardInfoFactory;
import com.miui.tsmclient.entity.DeductInfo;
import com.miui.tsmclient.entity.FmshUserInfo;
import com.miui.tsmclient.entity.MifareCardInfo;
import com.miui.tsmclient.entity.MifareTag;
import com.miui.tsmclient.entity.OrderDetailInfo;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.entity.RefundInfo;
import com.miui.tsmclient.entity.TransferOutOrderInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.ErrorCode;
import com.miui.tsmclient.net.AuthRequest;
import com.miui.tsmclient.net.TSMAuthContants;
import com.miui.tsmclient.pay.OrderInfo;
import com.miui.tsmclient.util.DeviceUtils;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.TSMLocationService;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TSMAuthManager extends BaseAuthManager {
    public FmshUserInfo getFmshUserInfo(Context context, String str, String str2) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        AuthRequest.AuthRequestBuilder addParams = AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/user/bizPassV2", AuthRequest.RespContentType.json).addParams("cplc", getCplc(new CardInfo("DUMMY"))).addParams("deviceModel", DeviceUtils.getDeviceModel(null)).addParams("type", str);
        if (!TextUtils.isEmpty(str2)) {
            addParams.addParams("appNo", str2);
        }
        return (FmshUserInfo) new Gson().fromJson(((JSONObject) sendRequest(context, accountInfo, addParams.create())).toString(), FmshUserInfo.class);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public JSONObject createOrder(Context context, int i, CardInfo cardInfo, Bundle bundle) throws AuthApiException {
        CardInfo cardInfo2 = cardInfo;
        Bundle bundle2 = bundle;
        AccountInfo accountInfo = getAccountInfo(context);
        AccountInfo accountInfo2 = accountInfo;
        AuthRequest.AuthRequestBuilder addParams = AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/sporder/v2/create", AuthRequest.RespContentType.json).addParams("feeId", String.valueOf(i)).addParams("seId", getSEId(cardInfo2)).addParams("deviceModel", DeviceUtils.getDeviceModel(cardInfo)).addParams("cardNo", cardInfo2.mCardNo).addParams("balance", String.valueOf(cardInfo2.mCardBalance)).addParams("deviceId", DeviceUtils.getDeviceId(context, cardInfo2)).addParams("cplc", getCplc(cardInfo2)).addParams("miuiRomType", DeviceUtils.getMIUIRomType(cardInfo)).addParams("miuiSystemVersion", DeviceUtils.getRomVersion());
        Location lastLocation = TSMLocationService.getInstance(context).getLastLocation();
        if (lastLocation != null) {
            LogUtils.d("createOrderV2 la:" + lastLocation.getLatitude() + ", lo:" + lastLocation.getLongitude());
            addParams.addParams("la", String.valueOf(lastLocation.getLatitude())).addParams("lo", String.valueOf(lastLocation.getLongitude()));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packageName", context.getPackageName());
            jSONObject.put("supportCoupon", true);
            if (bundle2 != null) {
                if (bundle2.containsKey("cityId")) {
                    addParams.addParams("cityId", String.valueOf(bundle2.getInt("cityId", 5200)));
                }
                if (bundle2.containsKey("extraCustomFee")) {
                    addParams.addParams("extraCustomFee", bundle2.getString("extraCustomFee"));
                    LogUtils.d("createOrder extraCustomFee:" + bundle2.getString("extraCustomFee"));
                }
                if (bundle2.containsKey("transferOrderId")) {
                    jSONObject.put("transferOrderId", bundle2.getString("transferOrderId"));
                }
                if (bundle2.containsKey("couponId")) {
                    jSONObject.put("couponId", bundle2.getLong("couponId"));
                }
                if (bundle2.containsKey("payChannel")) {
                    jSONObject.put("payChannel", bundle2.getString("payChannel"));
                }
                if (bundle2.containsKey("qrCode")) {
                    jSONObject.put("qrCode", bundle2.getBoolean("qrCode"));
                }
                if (bundle2.containsKey("payType")) {
                    jSONObject.put("payType", bundle2.getString("payType"));
                }
                if (bundle2.containsKey("phone")) {
                    jSONObject.put("phone", bundle2.getString("phone"));
                }
                if (bundle2.containsKey("captcha")) {
                    jSONObject.put("captcha", bundle2.getString("captcha"));
                }
            }
        } catch (JSONException e) {
            LogUtils.e("createOrder called! parse  error.", e);
        }
        if (jSONObject.length() > 0) {
            addParams.addParams("extra", jSONObject.toString());
        }
        JSONObject jSONObject2 = (JSONObject) sendRequest(context, accountInfo2, addParams.create());
        LogUtils.t("createOrder api response: ".concat(String.valueOf(jSONObject2.toString())));
        return jSONObject2;
    }

    public JSONArray queryByUserId(Context context) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        CardInfo cardInfo = new CardInfo("DUMMY");
        JSONArray jSONArray = (JSONArray) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/sporder/queryByUserId", AuthRequest.RespContentType.json).addParams("seId", getSEId(cardInfo)).addParams("deviceModel", DeviceUtils.getDeviceModel(cardInfo)).addParams("supportCardTransfer", "true").create());
        LogUtils.d("queryByUserId api response: " + jSONArray.toString());
        return jSONArray;
    }

    public JSONObject acquireToken(Context context, CardInfo cardInfo) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        JSONObject jSONObject = (JSONObject) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/sporder/acquireToken", AuthRequest.RespContentType.json).addParams("seId", getSEId(cardInfo)).addParams("deviceModel", DeviceUtils.getDeviceModel(cardInfo)).addParams("cardName", cardInfo.mCardType).addParams("deviceId", DeviceUtils.getDeviceId(context, cardInfo)).addParams("miuiRomType", DeviceUtils.getMIUIRomType(cardInfo)).addParams("miuiSystemVersion", DeviceUtils.getRomVersion()).create());
        LogUtils.d("acquireToken api response: " + jSONObject.toString());
        return jSONObject;
    }

    public JSONArray queryCardProduct(Context context, String str) throws IOException, AuthApiException {
        return queryCardProduct(context, CardGroupType.TRANSCARD, str, null);
    }

    public JSONArray queryCardProduct(Context context, CardGroupType cardGroupType) throws IOException, AuthApiException {
        return queryCardProduct(context, cardGroupType, null, null);
    }

    public JSONArray queryCardProduct(Context context, CardGroupType cardGroupType, String str, Location location) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        CardInfo makeCardInfo = CardInfoFactory.makeCardInfo(TextUtils.isEmpty(str) ? "DUMMY" : str, null);
        AuthRequest.AuthRequestBuilder addParams = AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/spcard/v2/queryCardProduct", AuthRequest.RespContentType.json).addParams("cplc", getCplc(makeCardInfo)).addParams("type", String.valueOf(cardGroupType.getId())).addParams("deviceModel", DeviceUtils.getDeviceModel(makeCardInfo)).addParams("lang", Locale.getDefault().toString()).addParams("miuiRomType", DeviceUtils.getMIUIRomType(makeCardInfo)).addParams("miuiSystemVersion", DeviceUtils.getRomVersion()).addParams("supportCardTransfer", "true");
        if (!TextUtils.isEmpty(str)) {
            addParams.addParams("cardName", str);
        }
        addLocationParams(addParams, location);
        JSONArray jSONArray = (JSONArray) sendRequest(context, accountInfo, addParams.create());
        LogUtils.d("queryCardProduct api response: " + jSONArray.toString());
        return jSONArray;
    }

    public JSONArray queryCardProductGroup(Context context, CardGroupType cardGroupType, String str, Location location) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        CardInfo makeCardInfo = CardInfoFactory.makeCardInfo(TextUtils.isEmpty(str) ? "DUMMY" : str, null);
        AuthRequest.AuthRequestBuilder addParams = AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/spcard/v3/queryCardProduct", AuthRequest.RespContentType.json).addParams("cplc", getCplc(makeCardInfo)).addParams("type", String.valueOf(cardGroupType.getId())).addParams("deviceModel", DeviceUtils.getDeviceModel(makeCardInfo)).addParams("lang", Locale.getDefault().toString()).addParams("supportCardTransfer", "true");
        if (!TextUtils.isEmpty(str)) {
            addParams.addParams("cardName", str);
        }
        addLocationParams(addParams, location);
        JSONArray jSONArray = (JSONArray) sendRequest(context, accountInfo, addParams.create());
        LogUtils.d("queryCardProductGroup api response: " + jSONArray.toString());
        return jSONArray;
    }

    public JSONArray queryChildCardProduct(Context context, String str) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        CardInfo makeCardInfo = CardInfoFactory.makeCardInfo(TextUtils.isEmpty(str) ? "DUMMY" : str, null);
        JSONArray jSONArray = (JSONArray) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/spcard/queryCardByCardFamily", AuthRequest.RespContentType.json).addParams("cardFamily", str).addParams("cplc", getCplc(makeCardInfo)).addParams("deviceModel", DeviceUtils.getDeviceModel(makeCardInfo)).addParams("lang", Locale.getDefault().toString()).addParams("miuiRomType", DeviceUtils.getMIUIRomType(makeCardInfo)).addParams("miuiSystemVersion", DeviceUtils.getRomVersion()).create());
        LogUtils.d("queryChildCardProduct api response: " + jSONArray.toString());
        return jSONArray;
    }

    public OrderInfo queryByOrderId(Context context, String str) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        JSONObject jSONObject = (JSONObject) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/sporder/queryByOrderId", AuthRequest.RespContentType.json).addParams("orderId", str).create());
        if (jSONObject == null) {
            return null;
        }
        LogUtils.d("queryByOrderId api response: " + jSONObject.toString());
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.parse(jSONObject);
        return orderInfo;
    }

    public JSONObject refundOrderById(Context context, String str) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        JSONObject jSONObject = (JSONObject) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/sporder/refundOrderById", AuthRequest.RespContentType.json).addParams("orderId", str).create());
        LogUtils.d("refundOrderById api response: " + jSONObject.toString());
        return jSONObject;
    }

    public JSONObject queryAllServiceProtocol(Context context, String str, TSMAuthContants.ActionType actionType) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        return (JSONObject) sendGetRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/serviceProtocol/queryAll", AuthRequest.RespContentType.json).addParams("seId", getSEId(CardInfoFactory.makeCardInfo(str, null))).addParams("deviceModel", DeviceUtils.getDeviceModel(null)).addParams("miuiRomType", DeviceUtils.getMIUIRomType(null)).addParams("miuiSystemVersion", DeviceUtils.getRomVersion()).addParams("cardName", str).addParams("actionType", actionType.toString()).create());
    }

    public JSONObject confirmProtocolVersion(Context context, long j) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        return (JSONObject) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/serviceProtocol/confirm", AuthRequest.RespContentType.json).addParams("id", String.valueOf(j)).addParams("seId", getSEId(new CardInfo("DUMMY"))).create());
    }

    public List<TransferOutOrderInfo> queryWithdrawCardOrder(Context context) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        JSONArray jSONArray = (JSONArray) sendGetRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/returnCard/queryUncompletedMoveOuts", AuthRequest.RespContentType.json).addParams("cplc", getCplc(new CardInfo("DUMMY"))).create());
        LogUtils.d("queryUncompletedMoveOutsApi response:" + jSONArray.toString());
        return (List) new Gson().fromJson(jSONArray.toString(), new TypeToken<List<TransferOutOrderInfo>>() {
            /* class com.miui.tsmclient.net.TSMAuthManager.AnonymousClass1 */
        }.getType());
    }

    public BaseResponse uploadTransferOutResult(Context context, CardInfo cardInfo, Bundle bundle) {
        String str;
        int i;
        if (bundle == null) {
            bundle = new Bundle();
        }
        PayableCardInfo payableCardInfo = cardInfo instanceof PayableCardInfo ? (PayableCardInfo) cardInfo : null;
        if (payableCardInfo == null || payableCardInfo.getUnfinishTransferOutInfo() == null) {
            return new BaseResponse(1, new Object[0]);
        }
        try {
            AccountInfo accountInfo = getAccountInfo(context);
            String str2 = (String) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/transferCard/confirmTransferOut", null).addParams("orderId", bundle.getString("order_id")).addParams("cplc", getCplc(payableCardInfo)).create());
            LogUtils.d("uploadTransferOutResult api response: ".concat(String.valueOf(str2)));
            CommonResponseInfo commonResponseInfo = (CommonResponseInfo) new Gson().fromJson(str2, CommonResponseInfo.class);
            if (commonResponseInfo == null) {
                i = 16;
                str = "";
            } else {
                str = commonResponseInfo.getErrorDesc();
                if (commonResponseInfo.getErrorCode() == 200) {
                    i = 0;
                } else {
                    i = commonResponseInfo.getErrorCode();
                }
            }
        } catch (AuthApiException e) {
            LogUtils.e("confirmTransferOut failed with an apiException, code:" + e.mErrorCode + ", msg:" + e.mErrorMsg, e);
            int i2 = e.mErrorCode;
            str = e.mErrorMsg;
            i = i2;
        }
        return new BaseResponse(i, str, new Object[0]);
    }

    public JSONArray queryAccountTransitCards(Context context) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        return (JSONArray) sendGetRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/afterSale/query/byUserAndCplc", AuthRequest.RespContentType.json).addParams("cplc", getCplc(new CardInfo("DUMMY"))).create());
    }

    public DeductInfo queryDeductContract(Context context, CardInfo cardInfo) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        JSONObject jSONObject = (JSONObject) sendGetRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/merchantDeduct/queryContract", AuthRequest.RespContentType.json).addParams("cplc", getCplc(cardInfo)).addParams("cardName", cardInfo.mCardType).create());
        LogUtils.d("queryDeductContract api response:" + jSONObject.toString());
        return (DeductInfo) new Gson().fromJson(jSONObject.toString(), DeductInfo.class);
    }

    public BaseResponse createDeductOrder(Context context, CardInfo cardInfo, DeductInfo deductInfo) {
        try {
            AccountInfo accountInfo = getAccountInfo(context);
            JSONObject jSONObject = (JSONObject) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/merchantDeduct/createOrder", AuthRequest.RespContentType.json).addParams("feeId", String.valueOf(deductInfo.getFeeId())).addParams("seId", getSEId(cardInfo)).addParams("deviceModel", DeviceUtils.getDeviceModel(cardInfo)).addParams("cardNo", cardInfo.mCardNo).addParams("balance", String.valueOf(cardInfo.mCardBalance)).addParams("deviceId", DeviceUtils.getDeviceId(context, cardInfo)).addParams("cplc", getCplc(cardInfo)).addParams("deductId", deductInfo.getDeductId()).create());
            LogUtils.d("createDeductOrder api response: " + jSONObject.toString());
            return new BaseResponse(0, "", jSONObject.optString("orderId"));
        } catch (AuthApiException e) {
            LogUtils.e("createDeductOrder failed with an apiException, code:" + e.mErrorCode + ", msg:" + e.mErrorMsg, e);
            return new BaseResponse(e.mErrorCode, e.mErrorMsg, new Object[0]);
        }
    }

    public OrderInfo queryOrderInfoByOrderId(Context context, String str) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        JSONObject jSONObject = (JSONObject) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/sporder/queryByOrderId", AuthRequest.RespContentType.json).addParams("orderId", str).create());
        LogUtils.d("queryByOrderId api response: " + jSONObject.toString());
        return (OrderInfo) new GsonBuilder().registerTypeAdapter(OrderInfo.OrderStatus.class, new OrderInfo.OrderStatusDeserializer()).registerTypeAdapter(ActionToken.TokenType.class, new ActionToken.TokenTypeDeserializer()).create().fromJson(jSONObject.toString(), OrderInfo.class);
    }

    public BaseResponse uploadSwipeCardHciTradeInfo(Context context, String str) {
        int i;
        String str2;
        try {
            AccountInfo accountInfo = getAccountInfo(context);
            CardInfo cardInfo = new CardInfo("DUMMY");
            sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/op/transitCard/saveHciRecord", AuthRequest.RespContentType.json).addParams("deviceModel", DeviceUtils.getDeviceModel(cardInfo)).addParams("cplc", getCplc(cardInfo)).addParams("miuiRomType", DeviceUtils.getMIUIRomType(null)).addParams("miuiSystemVersion", DeviceUtils.getRomVersion()).addParams("message", str).create());
            LogUtils.d("uploadSwipeCardHciTradeInfo success");
            str2 = "";
            i = 0;
        } catch (AuthApiException e) {
            LogUtils.e("uploadSwipeCardHciTradeInfo failed with an exception", e);
            i = e.mErrorCode;
            str2 = e.mErrorMsg;
        }
        return new BaseResponse(i, str2, new Object[0]);
    }

    public BaseResponse uploadSwipeCardErrorInfo(Context context, String str) {
        int i;
        String str2;
        try {
            AccountInfo accountInfo = getAccountInfo(context);
            sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/statistics/swipe/uploadError", AuthRequest.RespContentType.json).addParams("message", str).create());
            LogUtils.d("uploadSwipeCardErrorInfo success");
            str2 = "";
            i = 0;
        } catch (AuthApiException e) {
            LogUtils.e("uploadSwipeCardErrorInfo failed with an exception", e);
            i = e.mErrorCode;
            str2 = e.mErrorMsg;
        }
        return new BaseResponse(i, str2, new Object[0]);
    }

    public BaseResponse uploadDefaultTransCardTradeLogs(Context context, String str) {
        int i;
        String str2;
        try {
            AccountInfo accountInfo = getAccountInfo(context);
            sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/op/transitCard/saveTradeInfo", AuthRequest.RespContentType.json).addParams("cplc", getCplc(new CardInfo("DUMMY"))).addParams("cardInfo", str).create());
            LogUtils.d("uploadDefaultTransCardTradeLogs success");
            str2 = "";
            i = 0;
        } catch (AuthApiException e) {
            LogUtils.e("uploadSwipeCardHciTradeInfo failed with an exception", e);
            i = e.mErrorCode;
            str2 = e.mErrorMsg;
        }
        return new BaseResponse(i, str2, new Object[0]);
    }

    public OrderDetailInfo getOrderDetailById(Context context, CardInfo cardInfo, String str) throws AuthApiException {
        if (cardInfo == null || TextUtils.isEmpty(str)) {
            LogUtils.e("getOrderDetailById failed. params is invalid");
            throw new AuthApiException(1);
        }
        AccountInfo accountInfo = getAccountInfo(context);
        String jSONObject = ((JSONObject) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/sporder/queryOrderDetail", AuthRequest.RespContentType.json).addParams("orderId", str).addParams("deviceModel", DeviceUtils.getDeviceModel(cardInfo)).addParams("aid", cardInfo.mAid).addParams("cardName", cardInfo.mCardType).addParams("cplc", getCplc(cardInfo)).create())).toString();
        LogUtils.d("getOrderDetailById api response: ".concat(String.valueOf(jSONObject)));
        return (OrderDetailInfo) new GsonBuilder().registerTypeAdapter(ActionToken.TokenType.class, new ActionToken.TokenTypeDeserializer()).registerTypeAdapter(OrderInfo.OrderStatus.class, new OrderInfo.OrderStatusDeserializer()).create().fromJson(jSONObject, OrderDetailInfo.class);
    }

    public JSONObject updateCardBaseInfo(Context context, String str) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        return (JSONObject) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/cardInfo/update", AuthRequest.RespContentType.json).addParams("cplc", getCplc(new CardInfo("DUMMY"))).addParams("message", str).create());
    }

    public RefundInfo refund(Context context, String str) throws AuthApiException {
        if (!TextUtils.isEmpty(str)) {
            AccountInfo accountInfo = getAccountInfo(context);
            String jSONObject = ((JSONObject) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/sporder/refundOrderById", AuthRequest.RespContentType.json).addParams("orderId", str).create())).toString();
            LogUtils.d("refund api response: ".concat(String.valueOf(jSONObject)));
            return (RefundInfo) new Gson().fromJson(jSONObject, RefundInfo.class);
        }
        throw new AuthApiException(1);
    }

    public JSONArray queryCloudTransitCard(Context context, CardGroupType cardGroupType, String str, Location location) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        CardInfo makeCardInfo = CardInfoFactory.makeCardInfo(TextUtils.isEmpty(str) ? "DUMMY" : str, null);
        AuthRequest.AuthRequestBuilder addParams = AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/spcard/v2/queryShiftInCardProducts", AuthRequest.RespContentType.json).addParams("cplc", getCplc(makeCardInfo)).addParams("type", String.valueOf(cardGroupType.getId())).addParams("deviceModel", DeviceUtils.getDeviceModel(makeCardInfo)).addParams("tsmclientVersionCode", String.valueOf(DeviceUtils.getAppVersionCode(context))).addParams("tsmclientVersionName", String.valueOf(DeviceUtils.getAppVersionName(context))).addParams("supportCardTransfer", "true");
        if (!TextUtils.isEmpty(str)) {
            addParams.addParams("cardName", str);
        }
        addLocationParams(addParams, location);
        JSONArray jSONArray = (JSONArray) sendRequest(context, accountInfo, addParams.create());
        LogUtils.d("queryCloudTransitCard api response: " + jSONArray.toString());
        return jSONArray;
    }

    public JSONArray queryRecommendedTransitCard(Context context, CardGroupType cardGroupType, String str, int i) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        if (TextUtils.isEmpty(str)) {
            str = "DUMMY";
        }
        CardInfo makeCardInfo = CardInfoFactory.makeCardInfo(str, null);
        JSONArray jSONArray = (JSONArray) sendGetRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/spcard/v3/getCityRecommandCards", AuthRequest.RespContentType.json).addParams("cplc", getCplc(makeCardInfo)).addParams("type", String.valueOf(cardGroupType.getId())).addParams("deviceModel", DeviceUtils.getDeviceModel(makeCardInfo)).addParams("tsmclientVersionName", String.valueOf(DeviceUtils.getAppVersionName(context))).addParams("supportCardTransfer", "true").addParams("cityId", String.valueOf(i)).create());
        LogUtils.d("queryRecommendedTransitCard api response: " + jSONArray.toString());
        return jSONArray;
    }

    public boolean checkMifareIssued(Context context, MifareTag mifareTag) throws AuthApiException {
        if (mifareTag == null) {
            return false;
        }
        AccountInfo accountInfo = getAccountInfo(context);
        JSONObject jSONObject = (JSONObject) sendGetRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/doorCardV2/checkIfIssued", AuthRequest.RespContentType.json).addParams("cplc", getCplc(CardInfoFactory.makeCardInfo("DUMMY", null))).addParams("vcUid", mifareTag.getUid()).create());
        LogUtils.d("checkMifareIssued api response: " + jSONObject.toString());
        return jSONObject.optBoolean("exist");
    }

    public String checkPayString(Context context, String str, String str2) throws AuthApiException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        AccountInfo accountInfo = getAccountInfo(context);
        CardInfo makeCardInfo = CardInfoFactory.makeCardInfo("DUMMY", null);
        JSONObject jSONObject = (JSONObject) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/unionPayQrScan/verifyUrl", AuthRequest.RespContentType.json).addParams("deviceModel", DeviceUtils.getDeviceModel(makeCardInfo)).addParams("deviceId", DeviceUtils.getDeviceId(context, makeCardInfo)).addParams("cplc", getCplc(makeCardInfo)).addParams("payString", str).addParams("payType", str2).create());
        if (TextUtils.equals(jSONObject.optString("respCode"), "SUCCESS")) {
            return jSONObject.optString("payString");
        }
        return "";
    }

    public String addUserAuthCode(Context context, String str) throws AuthApiException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        AccountInfo accountInfo = getAccountInfo(context);
        CardInfo makeCardInfo = CardInfoFactory.makeCardInfo("DUMMY", null);
        return ((JSONObject) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/unionPayQrScan/generateUserAuthCode", AuthRequest.RespContentType.json).addParams("deviceModel", DeviceUtils.getDeviceModel(makeCardInfo)).addParams("deviceId", DeviceUtils.getDeviceId(context, makeCardInfo)).addParams("cplc", getCplc(makeCardInfo)).addParams("payUrl", str).create())).optString("payUrl");
    }

    public String communityDummyCardDelete(Context context, String str) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        return (String) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/v3/delete", AuthRequest.RespContentType.json).addParams("seId", getSEId(new CardInfo("DUMMY"))).addParams("userId", accountInfo.getUserId()).addParams("businessId", str).create());
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void updateCommunityCardFlowStatus(Context context, MifareCardInfo mifareCardInfo) throws AuthApiException {
        char c;
        AccountInfo accountInfo = getAccountInfo(context);
        JSONObject jSONObject = (JSONObject) sendGetRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/v3/flowcontrol/query", AuthRequest.RespContentType.json).addParams("cplc", getCplc(mifareCardInfo)).addParams("partnerId", "XIAOMI").addParams("userId", accountInfo.getUserId()).addParams("deviceModel", DeviceUtils.getDeviceModel(mifareCardInfo)).addParams("productId", mifareCardInfo.getProductId()).addParams("communityCode", mifareCardInfo.getCommunityCode()).addParams("businessId", mifareCardInfo.getBusinessId()).create());
        String optString = jSONObject.optString("status");
        String optString2 = jSONObject.optString("ticket");
        String optString3 = jSONObject.optString("nextStep");
        switch (optString.hashCode()) {
            case -56618343:
                if (optString.equals("PHONE_VERIFIED")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -36275482:
                if (optString.equals("PRIVILEGE_CHANGED")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 2402104:
                if (optString.equals("NONE")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 35394935:
                if (optString.equals("PENDING")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 174130302:
                if (optString.equals("REJECTED")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1967871671:
                if (optString.equals("APPROVED")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0 || c == 1) {
            mifareCardInfo.setCommunityCardFlowStatus(2);
        } else if (c == 2) {
            mifareCardInfo.setCommunityCardFlowStatus(1);
        } else if (c == 3 || c == 4) {
            mifareCardInfo.setTicket(optString2);
            mifareCardInfo.setCommunityCardFlowStatus(3);
        } else if (c != 5) {
            mifareCardInfo.setCommunityCardFlowStatus(0);
        } else if ("DELETE".equals(optString3)) {
            mifareCardInfo.setCommunityCardFlowStatus(5);
        } else if ("RE_ISSUE".equals(optString3)) {
            mifareCardInfo.setTicket(optString2);
            mifareCardInfo.setCommunityCardFlowStatus(4);
        }
    }

    public BaseResponse sendVerificationCode(Context context, String str, String str2, String str3) {
        try {
            AccountInfo accountInfo = getAccountInfo(context);
            sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/spcard/sendCaptcha", AuthRequest.RespContentType.json).addParams("phone", str).addParams("cardName", str2).addParams("cplc", getCplc(CardInfoFactory.makeCardInfo(TextUtils.isEmpty(str2) ? "DUMMY" : str2, null))).addParams("actionType", str3).create());
            return new BaseResponse(0, new Object[0]);
        } catch (AuthApiException e) {
            return new BaseResponse(e.mErrorCode, ErrorCode.getErrorText(context, e.mErrorCode, e.mErrorMsg), new Object[0]);
        }
    }

    public JSONArray queryUncompletedBusiness(Context context, String str) throws AuthApiException {
        AccountInfo accountInfo = getAccountInfo(context);
        CardInfo cardInfo = new CardInfo("DUMMY");
        JSONArray jSONArray = (JSONArray) sendRequest(context, accountInfo, AuthRequest.AuthRequestBuilder.newBuilder(accountInfo, "api/%s/spcard/queryUncompletedBusinessList", AuthRequest.RespContentType.json).addParams("cplc", getCplc(cardInfo)).addParams("seId", getSEId(cardInfo)).addParams("cardName", str).addParams("deviceModel", DeviceUtils.getDeviceModel(cardInfo)).addParams("packageName", context.getPackageName()).create());
        LogUtils.t("queryUncompletedBusiness api response: " + jSONArray.toString());
        return jSONArray;
    }

    /* access modifiers changed from: protected */
    public Object sendRequest(Context context, AccountInfo accountInfo, AuthRequest authRequest) throws AuthApiException {
        return super.sendRequest(context, accountInfo, authRequest);
    }

    /* access modifiers changed from: protected */
    public Object sendGetRequest(Context context, AccountInfo accountInfo, AuthRequest authRequest) throws AuthApiException {
        return super.sendGetRequest(context, accountInfo, authRequest);
    }

    /* access modifiers changed from: protected */
    public String getCplc(CardInfo cardInfo) throws AuthApiException {
        try {
            return cardInfo.getTerminal().getCPLC();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LogUtils.e("failed to get cplc", e);
            throw new AuthApiException(11);
        } catch (IOException e2) {
            LogUtils.e("failed to get cplc", e2);
            throw new AuthApiException(10);
        }
    }

    /* access modifiers changed from: protected */
    public String getSEId(CardInfo cardInfo) throws AuthApiException {
        try {
            String seid = cardInfo.getTerminal().getSeid();
            if (!TextUtils.isEmpty(seid)) {
                return seid;
            }
            throw new AuthApiException(13);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LogUtils.e("failed to get seId", e);
            throw new AuthApiException(11);
        } catch (IOException e2) {
            LogUtils.e("failed to get seId", e2);
            throw new AuthApiException(10);
        }
    }

    /* access modifiers changed from: protected */
    public void addLocationParams(AuthRequest.AuthRequestBuilder authRequestBuilder, Location location) {
        if (location != null) {
            authRequestBuilder.addParams("la", String.valueOf(location.getLatitude())).addParams("lo", String.valueOf(location.getLongitude()));
        }
    }
}
