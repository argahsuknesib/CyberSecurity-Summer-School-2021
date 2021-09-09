package com.mibi.sdk.model.auth;

import android.content.Context;
import android.text.TextUtils;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class RxCheckAuthTask extends RxBasePaymentTask<Result> {

    public static class Result implements Serializable {
        public long mBalance;
        public String mBindPhoneUrl;
        public int mErrorCode;
        public String mErrorDesc;
        public long mGiftcardValue;
        public long mPartnerGiftcardValue;
        public String mPhoneNum;
        public boolean mUseGiftcard;
        public boolean mUsePartnerGiftcard;
    }

    RxCheckAuthTask(Context context, Session session) {
        super(context, session, Result.class);
    }

    public Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        String string2 = sortedParameter.getString("fullAuth");
        String string3 = sortedParameter.getString("smsCode");
        Connection createAccountConnection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/checkAuth"), this.mSession);
        SortedParameter parameter = createAccountConnection.getParameter();
        parameter.add("processId", string);
        if (!TextUtils.isEmpty(string2)) {
            parameter.add("fullAuth", string2);
        }
        if (!TextUtils.isEmpty(string3)) {
            parameter.add("smsCode", string3);
        }
        return createAccountConnection;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mibi.sdk.task.RxBasePaymentTask.parseResultInCommon(org.json.JSONObject, java.lang.Object):void
     arg types: [org.json.JSONObject, com.mibi.sdk.model.auth.RxCheckAuthTask$Result]
     candidates:
      com.mibi.sdk.model.auth.RxCheckAuthTask.parseResultInCommon(org.json.JSONObject, com.mibi.sdk.model.auth.RxCheckAuthTask$Result):void
      com.mibi.sdk.task.RxBasePaymentTask.parseResultInCommon(org.json.JSONObject, java.lang.Object):void */
    /* access modifiers changed from: protected */
    public void parseResultInCommon(JSONObject jSONObject, Result result) throws PaymentException {
        super.parseResultInCommon(jSONObject, (Object) result);
        long optLong = jSONObject.optLong("balance", -1);
        long optLong2 = jSONObject.optLong("giftcardValue", -1);
        boolean optBoolean = jSONObject.optBoolean("useGiftcard", true);
        long optLong3 = jSONObject.optLong("partnerGiftcardValue", -1);
        boolean optBoolean2 = jSONObject.optBoolean("usePartnerGiftcard", true);
        result.mBalance = optLong;
        result.mGiftcardValue = optLong2;
        result.mUseGiftcard = optBoolean;
        result.mPartnerGiftcardValue = optLong3;
        result.mUsePartnerGiftcard = optBoolean2;
    }

    /* access modifiers changed from: protected */
    public boolean parseResultInError(JSONObject jSONObject, Result result) throws PaymentException {
        if (result.mErrorCode == 7002) {
            result.mBindPhoneUrl = jSONObject.optString("bindPhoneUrl");
            return false;
        } else if (result.mErrorCode != 7001) {
            return false;
        } else {
            try {
                result.mPhoneNum = jSONObject.getString("phoneWithMask");
                return false;
            } catch (JSONException e) {
                throw new ResultException(e);
            }
        }
    }
}
