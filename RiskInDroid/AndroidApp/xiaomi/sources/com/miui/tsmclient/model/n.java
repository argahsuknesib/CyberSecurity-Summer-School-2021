package com.miui.tsmclient.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.CardInfoManager;
import com.miui.tsmclient.entity.GroupConfigInfo;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.entity.ReturnCardPayAccountExtra;
import com.miui.tsmclient.entity.TransferOutOrderInfo;
import com.miui.tsmclient.entity.j;
import com.miui.tsmclient.net.request.ConfigListRequest;
import com.miui.tsmclient.util.LogUtils;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class n extends BaseModel {

    static class a extends SecureRequest<j> {

        /* renamed from: a  reason: collision with root package name */
        private CardInfo f3884a;

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        public a(PayableCardInfo payableCardInfo, Bundle bundle) {
            super(1, "api/%s/returnCard/prepareReturn", TypeToken.get(j.class));
            String str;
            this.f3884a = payableCardInfo;
            addParams("claimedBalance", String.valueOf(payableCardInfo.mCardBalance)).addParams("cardName", payableCardInfo.mCardType).addParams("contact", payableCardInfo.getPhoneNumber()).addParams("deviceModel", com.miui.tsmclient.util.a.b(payableCardInfo)).addParams("miuiRomType", com.miui.tsmclient.util.a.a(payableCardInfo)).addParams("miuiSystemVersion", com.miui.tsmclient.util.a.a());
            if (payableCardInfo.mSupportPhoneReturnCard || payableCardInfo.mSupportWearableReturnCard) {
                str = "RETURN";
            } else {
                str = payableCardInfo.mSupportMoveCardReturnCard ? "RETURN_ON_SHIFT" : str;
                if (bundle != null) {
                    addParams("contact", bundle.getString(ReturnCardPayAccountExtra.KEY_RETURN_CARD_PHONE_NUMBER));
                    addParams("reasonCode", bundle.getString(ReturnCardPayAccountExtra.KEY_RETURN_CARD_REASON_CODE));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("payAccountType", bundle.getString(ReturnCardPayAccountExtra.KEY_RETURN_CARD_PAY_ACCOUNT_TYPE));
                        jSONObject.put("payAccountName", bundle.getString(ReturnCardPayAccountExtra.KEY_RETURN_CARD_PAY_ACCOUNT_NAME));
                        jSONObject.put("payAccountId", bundle.getString(ReturnCardPayAccountExtra.KEY_RETURN_CARD_PAY_ACCOUNT_ID));
                        addParams("payAccountInfo", jSONObject.toString());
                    } catch (JSONException e) {
                        LogUtils.e("CreateReturnCardRequest addParams fails", e);
                    }
                }
                if (TextUtils.isEmpty(payableCardInfo.mRealCardNo)) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("logicalNo", payableCardInfo.mRealCardNo);
                        addParams("extra", jSONObject2.toString());
                        return;
                    } catch (JSONException e2) {
                        LogUtils.e("CreateReturnCardRequest addParams fails", e2);
                        return;
                    }
                } else {
                    return;
                }
            }
            addParams("source", str);
            if (bundle != null) {
            }
            if (TextUtils.isEmpty(payableCardInfo.mRealCardNo)) {
            }
        }

        public void addExtraParams() throws IOException {
            super.addExtraParams();
            try {
                addParams("cplc", this.f3884a.getTerminal().getCPLC());
            } catch (IOException | InterruptedException e) {
                throw new IOException("CreateReturnCardRequest getExtraParams failed", e);
            }
        }
    }

    private BaseResponse b(PayableCardInfo payableCardInfo, Bundle bundle) {
        try {
            j jVar = (j) HttpClient.getInstance(getContext()).execute(new a(payableCardInfo, bundle)).getResult();
            if (jVar != null) {
                LogUtils.d("createReturnCardRequest, code:" + jVar.getErrorCode() + ", msg:" + jVar.getErrorDesc());
                TransferOutOrderInfo a2 = jVar.a();
                if (a2 == null) {
                    return new BaseResponse(jVar.getErrorCode(), jVar.getErrorDesc(), new Object[0]);
                }
                a2.setOrderType("RETURN");
                payableCardInfo.setUnfinishTransferOutInfo(a2);
                return new BaseResponse(0, new Object[0]);
            }
        } catch (Exception e) {
            LogUtils.e("createReturnCardRequest ExecutionException occurred", e);
        }
        return new BaseResponse(-2, new Object[0]);
    }

    public BaseResponse a(PayableCardInfo payableCardInfo) {
        TransferOutOrderInfo unfinishTransferOutInfo = payableCardInfo.getUnfinishTransferOutInfo();
        Bundle bundle = new Bundle();
        if (unfinishTransferOutInfo == null) {
            return new BaseResponse(-2, new Object[0]);
        }
        bundle.putString("orderId", unfinishTransferOutInfo.getOrderId());
        bundle.putString("authentication_code", unfinishTransferOutInfo.getTransferOutToken());
        bundle.putBoolean("extras_key_internal_return", true);
        BaseResponse returnCard = CardInfoManager.getInstance(getContext()).returnCard(payableCardInfo, bundle);
        if (returnCard.isSuccess()) {
            try {
                GroupConfigInfo groupConfigInfo = (GroupConfigInfo) HttpClient.getInstance(getContext()).execute(new ConfigListRequest(payableCardInfo, "RETURN_SUCCESS_MSG", null)).getResult();
                if (groupConfigInfo == null) {
                    return returnCard;
                }
                List<String> contentList = groupConfigInfo.getContentList(null, "RETURN_SUCCESS_MSG");
                if (contentList.size() > 0) {
                    returnCard.mMsg = contentList.get(0);
                }
            } catch (IOException e) {
                LogUtils.e("querying client config return success msg exception".concat(String.valueOf(e)));
            }
        }
        return returnCard;
    }

    public BaseResponse a(PayableCardInfo payableCardInfo, Bundle bundle) {
        BaseResponse b = b(payableCardInfo, bundle);
        return b.mResultCode != 0 ? b : a(payableCardInfo);
    }
}
