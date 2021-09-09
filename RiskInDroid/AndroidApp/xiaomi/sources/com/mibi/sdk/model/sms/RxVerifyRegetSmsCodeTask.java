package com.mibi.sdk.model.sms;

import android.content.Context;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;

public class RxVerifyRegetSmsCodeTask extends RxBasePaymentTask<Result> {

    public static class Result {
    }

    public RxVerifyRegetSmsCodeTask(Context context, Session session) {
        super(context, session, Result.class);
    }

    public Connection getConnection(SortedParameter sortedParameter) {
        ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/sendSmsCode"), this.mSession).getParameter().add("processId", sortedParameter.getString("processId"));
        return null;
    }
}
