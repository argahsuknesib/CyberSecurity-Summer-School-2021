package com.miui.tsmclient.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.CardInfoManager;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.entity.TransferOutOrderInfo;
import com.miui.tsmclient.entity.j;
import com.miui.tsmclient.net.request.g;
import com.miui.tsmclient.util.LogUtils;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class o extends BaseModel {

    /* renamed from: a  reason: collision with root package name */
    protected l f3885a;
    private g b;

    static class a extends SecureRequest<j> {

        /* renamed from: a  reason: collision with root package name */
        private CardInfo f3886a;

        public a(PayableCardInfo payableCardInfo) {
            super(1, "api/%s/transferCard/prepareTransferOut", TypeToken.get(j.class));
            this.f3886a = payableCardInfo;
            addParams("claimedBalance", String.valueOf(payableCardInfo.mCardBalance)).addParams("cardName", payableCardInfo.mCardType).addParams("contact", payableCardInfo.getPhoneNumber()).addParams("deviceModel", com.miui.tsmclient.util.a.b(payableCardInfo)).addParams("miuiRomType", com.miui.tsmclient.util.a.a(payableCardInfo)).addParams("miuiSystemVersion", com.miui.tsmclient.util.a.a());
            if (!TextUtils.isEmpty(payableCardInfo.mRealCardNo)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("logicalNo", payableCardInfo.mRealCardNo);
                    addParams("extra", jSONObject.toString());
                } catch (JSONException e) {
                    LogUtils.e("CreateTransferOutOrderRequest addParams throws e", e);
                }
            }
        }

        public void addExtraParams() throws IOException {
            super.addExtraParams();
            try {
                addParams("cplc", this.f3886a.getTerminal().getCPLC());
            } catch (IOException | InterruptedException e) {
                throw new IOException("CreateTransferOutOrderRequest getExtraParams failed", e);
            }
        }
    }

    private BaseResponse c(PayableCardInfo payableCardInfo) {
        try {
            j jVar = (j) HttpClient.getInstance(getContext()).execute(new a(payableCardInfo)).getResult();
            if (jVar != null) {
                LogUtils.d("createTransferOutOrder, code:" + jVar.getErrorCode() + ", msg:" + jVar.getErrorDesc());
                TransferOutOrderInfo a2 = jVar.a();
                if (a2 == null) {
                    return new BaseResponse(jVar.getErrorCode(), jVar.getErrorDesc(), new Object[0]);
                }
                a2.setOrderType("TRANSFER");
                payableCardInfo.setUnfinishTransferOutInfo(a2);
                return new BaseResponse(0, new Object[0]);
            }
        } catch (Exception e) {
            LogUtils.e("CreateTransferOutOrderRequest ExecutionException occurred", e);
        }
        return new BaseResponse(-2, new Object[0]);
    }

    public BaseResponse a(PayableCardInfo payableCardInfo) {
        BaseResponse a2 = this.f3885a.a(getContext(), payableCardInfo, null);
        if (a2.mResultCode != 0) {
            return a2;
        }
        BaseResponse c = c(payableCardInfo);
        return c.mResultCode != 0 ? c : b(payableCardInfo);
    }

    public BaseResponse b(PayableCardInfo payableCardInfo) {
        TransferOutOrderInfo unfinishTransferOutInfo = payableCardInfo.getUnfinishTransferOutInfo();
        Bundle bundle = new Bundle();
        if (unfinishTransferOutInfo != null) {
            bundle.putString("order_id", unfinishTransferOutInfo.getOrderId());
            bundle.putString("authentication_code", unfinishTransferOutInfo.getTransferOutToken());
        }
        return CardInfoManager.getInstance(getContext()).transferOut(payableCardInfo, bundle);
    }

    /* access modifiers changed from: protected */
    public void onInit() {
        this.f3885a = new l(getContext());
    }

    public void release() {
        HttpClient.getInstance(getContext()).cancel(this.b);
    }
}
