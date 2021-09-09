package com.mibi.sdk.model.progress;

import android.content.Context;
import android.text.TextUtils;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.account.loader.FakeAccountLoader;
import com.mibi.sdk.common.exception.NoPrivacyRightException;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import com.xiaomi.smarthome.R;
import org.json.JSONException;
import org.json.JSONObject;

public class RxStartProcessTask extends RxBasePaymentTask<Result> {

    public static class Result {
        public String mProcessId;
    }

    RxStartProcessTask(Context context, Session session) {
        super(context, session, Result.class);
    }

    public Connection getConnection(SortedParameter sortedParameter) {
        Connection connection;
        if (this.mSession.getAccountLoader() instanceof FakeAccountLoader) {
            connection = ConnectionFactory.createNoAccountConnection(this.mContext, CommonConstants.getUrl("/p/na/getProcessId"));
        } else {
            connection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/getProcessIdV2"), this.mSession);
        }
        connection.getParameter().add("oaid", Client.getOaid());
        return connection;
    }

    /* access modifiers changed from: protected */
    public void parseResultInSuccess(JSONObject jSONObject, Result result) throws PaymentException {
        boolean optBoolean = jSONObject.optBoolean("userRevoke", false);
        boolean optBoolean2 = jSONObject.optBoolean("needPrivacyAuthorize", false);
        if (optBoolean || optBoolean2) {
            throw new NoPrivacyRightException(this.mContext.getResources().getString(R.string.mibi_error_privacy_summary));
        }
        try {
            String string = jSONObject.getString("processId");
            if (!TextUtils.isEmpty(string)) {
                result.mProcessId = string;
                return;
            }
            throw new ResultException("processId is empty!");
        } catch (JSONException e) {
            throw new ResultException(e);
        }
    }
}
