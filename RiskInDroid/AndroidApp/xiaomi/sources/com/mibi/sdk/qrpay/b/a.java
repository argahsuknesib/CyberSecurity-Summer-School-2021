package com.mibi.sdk.qrpay.b;

import android.content.Context;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import org.json.JSONObject;

public final class a extends RxBasePaymentTask<C0043a> {

    /* renamed from: com.mibi.sdk.qrpay.b.a$a  reason: collision with other inner class name */
    public static class C0043a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5169a;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        C0043a aVar = (C0043a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        aVar.f5169a = jSONObject.optString("qr_code");
    }

    public a(Context context, Session session) {
        super(context, session, C0043a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        Connection connection;
        String string = sortedParameter.getString("processId");
        long j = sortedParameter.getLong("chargeFee");
        if (this.mSession.isFakeAccountLoader()) {
            connection = ConnectionFactory.createNoAccountConnection(getContext(), CommonConstants.getUrl("p/na/recharge/alipayQRCode"));
        } else {
            connection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/recharge/alipayQRCode"), getSession());
        }
        SortedParameter parameter = connection.getParameter();
        parameter.add("oaid", Client.getOaid());
        parameter.add("processId", string);
        parameter.add("chargeFee", Long.valueOf(j));
        return connection;
    }
}
