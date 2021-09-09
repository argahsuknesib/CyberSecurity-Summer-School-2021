package com.mibi.sdk.pay.task;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import org.json.JSONObject;

public class RxDoPayTask extends RxBasePaymentTask<Result> {

    public static class Result {
        public Bundle mResult;
    }

    public RxDoPayTask(Context context, Session session) {
        super(context, session, Result.class);
    }

    public Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        boolean z = sortedParameter.getBoolean("useGiftcard");
        boolean z2 = sortedParameter.getBoolean("usePartnerGiftcard");
        long j = sortedParameter.getLong("discountGiftcardId", 0);
        Connection createAccountConnection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/doPay"), this.mSession);
        SortedParameter parameter = createAccountConnection.getParameter();
        parameter.add("processId", string);
        parameter.add("useGiftcard", Boolean.valueOf(z));
        parameter.add("usePartnerGiftcard", Boolean.valueOf(z2));
        parameter.add("discountGiftcardId", Long.valueOf(j));
        return createAccountConnection;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mibi.sdk.task.RxBasePaymentTask.parseResultInCommon(org.json.JSONObject, java.lang.Object):void
     arg types: [org.json.JSONObject, com.mibi.sdk.pay.task.RxDoPayTask$Result]
     candidates:
      com.mibi.sdk.pay.task.RxDoPayTask.parseResultInCommon(org.json.JSONObject, com.mibi.sdk.pay.task.RxDoPayTask$Result):void
      com.mibi.sdk.task.RxBasePaymentTask.parseResultInCommon(org.json.JSONObject, java.lang.Object):void */
    /* access modifiers changed from: protected */
    public void parseResultInCommon(JSONObject jSONObject, Result result) throws PaymentException {
        super.parseResultInCommon(jSONObject, (Object) result);
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject != null) {
            result.mResult = getStandardResult(optJSONObject);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mibi.sdk.task.RxBasePaymentTask.parseResultInError(org.json.JSONObject, java.lang.Object):boolean
     arg types: [org.json.JSONObject, com.mibi.sdk.pay.task.RxDoPayTask$Result]
     candidates:
      com.mibi.sdk.pay.task.RxDoPayTask.parseResultInError(org.json.JSONObject, com.mibi.sdk.pay.task.RxDoPayTask$Result):boolean
      com.mibi.sdk.task.RxBasePaymentTask.parseResultInError(org.json.JSONObject, java.lang.Object):boolean */
    /* access modifiers changed from: protected */
    public boolean parseResultInError(JSONObject jSONObject, Result result) throws PaymentException {
        super.parseResultInError(jSONObject, (Object) result);
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject == null) {
            return false;
        }
        result.mResult = getStandardResult(optJSONObject);
        return false;
    }

    private Bundle getStandardResult(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        if (jSONObject != null) {
            if (jSONObject.has("ret")) {
                bundle.putString("ret", jSONObject.optString("ret"));
            }
            if (jSONObject.has("senderSign")) {
                bundle.putString("senderSign", jSONObject.optString("senderSign"));
            }
        }
        return bundle;
    }
}
