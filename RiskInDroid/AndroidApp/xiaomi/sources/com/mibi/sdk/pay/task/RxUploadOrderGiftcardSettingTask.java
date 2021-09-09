package com.mibi.sdk.pay.task;

import android.content.Context;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;

public class RxUploadOrderGiftcardSettingTask extends RxBasePaymentTask<Result> {

    public static class Result {
    }

    public RxUploadOrderGiftcardSettingTask(Context context, Session session) {
        super(context, session, Result.class);
    }

    public Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        boolean z = sortedParameter.getBoolean("useGiftcard");
        boolean z2 = sortedParameter.getBoolean("usePartnerGiftcard");
        long j = sortedParameter.getLong("discountGiftcardId", 0);
        Connection createAccountConnection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/checkGiftcard"), this.mSession);
        SortedParameter parameter = createAccountConnection.getParameter();
        parameter.add("processId", string);
        parameter.add("useGiftcard", Boolean.valueOf(z));
        parameter.add("usePartnerGiftcard", Boolean.valueOf(z2));
        parameter.add("discountGiftcardId", Long.valueOf(j));
        return createAccountConnection;
    }
}
