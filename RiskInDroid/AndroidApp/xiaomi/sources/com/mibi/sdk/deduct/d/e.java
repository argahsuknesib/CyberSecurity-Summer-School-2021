package com.mibi.sdk.deduct.d;

import android.content.Context;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import org.json.JSONObject;

public final class e extends RxBasePaymentTask<a> {

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5135a;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        aVar.f5135a = jSONObject.optString("url");
    }

    public e(Context context, Session session) {
        super(context, session, a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        Connection createAccountConnection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/deductSign/alipay"), this.mSession);
        SortedParameter parameter = createAccountConnection.getParameter();
        parameter.add("processId", string);
        parameter.add("deductChannel", e.a.ALIPAY.b());
        return createAccountConnection;
    }
}
