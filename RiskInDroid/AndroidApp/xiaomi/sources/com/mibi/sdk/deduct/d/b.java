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

public final class b extends RxBasePaymentTask<a> {

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5132a;
        public String b;
        public String c;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        aVar.f5132a = jSONObject.optString("deductChannel");
        aVar.b = jSONObject.optString("orderDesc");
        aVar.c = jSONObject.optString("extraInfo");
    }

    public b(Context context, Session session) {
        super(context, session, a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        SortedParameter sortedParameter2;
        Connection connection;
        String string = sortedParameter.getString("processId");
        String string2 = sortedParameter.getString("deductSignAndPayOrder");
        if (this.mSession.getAccountLoader() instanceof FakeAccountLoader) {
            connection = ConnectionFactory.createNoAccountConnection(this.mContext, CommonConstants.getUrl("p/na/deductSignAndPay/checkParam"));
            sortedParameter2 = connection.getParameter();
        } else {
            connection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/deductSignAndPay/checkParam"), this.mSession);
            sortedParameter2 = connection.getParameter();
        }
        sortedParameter2.add("oaid", Client.getOaid());
        sortedParameter2.add("deductSignAndPayOrder", string2);
        sortedParameter2.add("processId", string);
        return connection;
    }
}
