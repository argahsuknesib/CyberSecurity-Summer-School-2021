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
import org.json.JSONException;
import org.json.JSONObject;

public final class g extends RxBasePaymentTask<a> {

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5137a;
        public String b;
        public String c;
        public String d;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        aVar.f5137a = jSONObject.optString("requestData");
        try {
            aVar.b = jSONObject.getString("goodsName");
            aVar.c = jSONObject.getString("merchantName");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aVar.d = jSONObject.optString("cancelMerchantName", "");
    }

    public g(Context context, Session session) {
        super(context, session, a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        Connection createAccountConnection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/deductSign/mipay"), this.mSession);
        SortedParameter parameter = createAccountConnection.getParameter();
        parameter.add("deductChannel", e.a.MIPAY.b());
        parameter.add("processId", string);
        return createAccountConnection;
    }
}
