package com.mibi.sdk.channel.mipay.b;

import android.content.Context;
import android.text.TextUtils;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends RxBasePaymentTask<C0039a> {

    /* renamed from: com.mibi.sdk.channel.mipay.b.a$a  reason: collision with other inner class name */
    public static class C0039a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5118a;
        public String b;
        public String c;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        C0039a aVar = (C0039a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        try {
            String string = jSONObject.getString("chargeOrderId");
            String string2 = jSONObject.getString("url");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                throw new ResultException("result has error");
            }
            aVar.f5118a = string;
            aVar.b = string2;
            try {
                Connection createNoAccountConnection = ConnectionFactory.createNoAccountConnection(this.mContext, aVar.b, false);
                createNoAccountConnection.setUseGet(true);
                String requestString = createNoAccountConnection.requestString();
                if (!TextUtils.isEmpty(requestString)) {
                    aVar.c = requestString;
                    return;
                }
                throw new ResultException("result has error");
            } catch (Exception e) {
                throw new ResultException(e);
            }
        } catch (JSONException e2) {
            throw new ResultException(e2);
        }
    }

    public a(Context context, Session session) {
        super(context, session, C0039a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        Connection connection;
        String string = sortedParameter.getString("processId");
        long j = sortedParameter.getLong("chargeFee");
        if (this.mSession.isFakeAccountLoader()) {
            connection = ConnectionFactory.createNoAccountConnection(getContext(), CommonConstants.getUrl("p/na/recharge/mipayApk"));
        } else {
            connection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/recharge/mipayApk"), getSession());
        }
        SortedParameter parameter = connection.getParameter();
        parameter.add("oaid", Client.getOaid());
        parameter.add("processId", string);
        parameter.add("chargeFee", Long.valueOf(j));
        parameter.add("channel", "MIPAY");
        return connection;
    }
}
