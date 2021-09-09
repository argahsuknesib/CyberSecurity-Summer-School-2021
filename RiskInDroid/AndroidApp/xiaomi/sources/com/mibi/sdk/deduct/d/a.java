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
import org.json.JSONObject;

public final class a extends RxBasePaymentTask<C0041a> {

    /* renamed from: com.mibi.sdk.deduct.d.a$a  reason: collision with other inner class name */
    public static class C0041a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5131a;
        public String b;
        public String c;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        C0041a aVar = (C0041a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        aVar.f5131a = jSONObject.optString("deductChannel");
        aVar.b = jSONObject.optString("orderDesc");
        aVar.c = jSONObject.optString("extraInfo");
    }

    public a(Context context, Session session) {
        super(context, session, C0041a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        String string2 = sortedParameter.getString("deductSignOrder");
        Connection createAccountConnection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/deductSign/checkParam"), this.mSession);
        SortedParameter parameter = createAccountConnection.getParameter();
        parameter.add("deductSignOrder", string2);
        parameter.add("processId", string);
        return createAccountConnection;
    }
}
