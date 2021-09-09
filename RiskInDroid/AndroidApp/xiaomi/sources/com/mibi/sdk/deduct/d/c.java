package com.mibi.sdk.deduct.d;

import android.content.Context;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends RxBasePaymentTask<a> {

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public int f5133a;
        public String b;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        try {
            aVar.f5133a = jSONObject.getInt("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aVar.b = jSONObject.optString("result");
    }

    public c(Context context, Session session) {
        super(context, session, a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        Connection createAccountConnection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/deductSign/result"), this.mSession);
        createAccountConnection.getParameter().add("processId", string);
        return createAccountConnection;
    }
}
