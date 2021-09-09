package com.mibi.sdk.deduct.d;

import android.content.Context;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.account.loader.FakeAccountLoader;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import org.json.JSONObject;

public final class j extends RxBasePaymentTask<a> {

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5140a;
        public String b;
        public String c;
        public String d;
        public int e;
        public int f;
    }

    public final /* synthetic */ void parseResultInCommon(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        super.parseResultInCommon(jSONObject, aVar);
        aVar.f5140a = jSONObject.optString("status");
        aVar.b = jSONObject.optString("marketDeductId");
        aVar.c = jSONObject.optString("orderId");
        aVar.d = jSONObject.optString("chargeStatus");
        aVar.e = jSONObject.optInt("payStatus");
        aVar.f = jSONObject.optInt("deductSignStatus");
    }

    public j(Context context, Session session) {
        super(context, session, a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        Connection connection;
        String string = sortedParameter.getString("processId");
        if (this.mSession.getAccountLoader() instanceof FakeAccountLoader) {
            connection = ConnectionFactory.createNoAccountConnection(this.mContext, CommonConstants.getUrl("p/na/deductSignAndPay/result"));
        } else {
            connection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/deductSignAndPay/result"), this.mSession);
        }
        SortedParameter parameter = connection.getParameter();
        parameter.add("processId", string);
        parameter.add("oaid", Client.getOaid());
        return connection;
    }
}
