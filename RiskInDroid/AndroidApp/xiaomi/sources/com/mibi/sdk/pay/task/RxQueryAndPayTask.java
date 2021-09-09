package com.mibi.sdk.pay.task;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.account.loader.FakeAccountLoader;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.component.recharge.EntryData;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBaseQueryTask;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class RxQueryAndPayTask extends RxBaseQueryTask<Result> {

    public static class Result extends RxBaseQueryTask.Result implements Serializable {
        public EntryData mEntryData;
        public String mImageUrl;
        public long mPayFee;
        public int mPayStatus;
        public Bundle mResult;
    }

    public RxQueryAndPayTask(Context context, Session session) {
        super(context, session, Result.class);
    }

    public Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        if (this.mSession.getAccountLoader() instanceof FakeAccountLoader) {
            Connection createNoAccountConnection = ConnectionFactory.createNoAccountConnection(this.mContext, CommonConstants.getUrl("/p/na/recharge/result"));
            SortedParameter parameter = createNoAccountConnection.getParameter();
            parameter.add("processId", string);
            parameter.add("oaid", Client.getOaid());
            return createNoAccountConnection;
        }
        Connection createAccountConnection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/recharge/result"), this.mSession);
        createAccountConnection.getParameter().add("processId", string);
        return createAccountConnection;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mibi.sdk.task.RxBaseQueryTask.parseResultInSuccess(org.json.JSONObject, com.mibi.sdk.task.RxBaseQueryTask$Result):void
     arg types: [org.json.JSONObject, com.mibi.sdk.pay.task.RxQueryAndPayTask$Result]
     candidates:
      com.mibi.sdk.pay.task.RxQueryAndPayTask.parseResultInSuccess(org.json.JSONObject, com.mibi.sdk.pay.task.RxQueryAndPayTask$Result):void
      com.mibi.sdk.pay.task.RxQueryAndPayTask.parseResultInSuccess(org.json.JSONObject, java.lang.Object):void
      com.mibi.sdk.task.RxBaseQueryTask.parseResultInSuccess(org.json.JSONObject, java.lang.Object):void
      com.mibi.sdk.task.RxBasePaymentTask.parseResultInSuccess(org.json.JSONObject, java.lang.Object):void
      com.mibi.sdk.task.RxBaseQueryTask.parseResultInSuccess(org.json.JSONObject, com.mibi.sdk.task.RxBaseQueryTask$Result):void */
    /* access modifiers changed from: protected */
    public void parseResultInSuccess(JSONObject jSONObject, Result result) throws PaymentException {
        super.parseResultInSuccess(jSONObject, (RxBaseQueryTask.Result) result);
        if (result.mRechargeSuccess) {
            try {
                int i = jSONObject.getInt("payStatus");
                result.mPayStatus = i;
                if (i == 200) {
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                        long j = jSONObject.getLong("payFee");
                        result.mResult = getStandardResult(jSONObject2);
                        result.mPayFee = j;
                        if (TextUtils.isEmpty(result.mResult.getString("ret"))) {
                            throw new ResultException("result has error");
                        } else if (result.mPayFee >= 0) {
                            result.mImageUrl = jSONObject.optString("bannerPicUrl");
                            JSONObject optJSONObject = jSONObject.optJSONObject("entry");
                            if (optJSONObject != null) {
                                EntryData entryData = new EntryData();
                                entryData.parseEntryData(optJSONObject);
                                result.mEntryData = entryData;
                            }
                        } else {
                            throw new ResultException("result has error");
                        }
                    } catch (JSONException e) {
                        throw new ResultException(e);
                    }
                } else {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
                    long optLong = jSONObject.optLong("payFee", -1);
                    if (optJSONObject2 != null) {
                        result.mResult = getStandardResult(optJSONObject2);
                    }
                    if (optLong >= 0) {
                        result.mPayFee = optLong;
                    }
                }
            } catch (JSONException e2) {
                throw new ResultException(e2);
            }
        }
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
