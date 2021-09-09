package com.mibi.sdk.channel.alipay.b;

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
import org.json.JSONObject;

public final class a extends RxBasePaymentTask<C0038a> {

    /* renamed from: com.mibi.sdk.channel.alipay.b.a$a  reason: collision with other inner class name */
    public static class C0038a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5114a;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        C0038a aVar = (C0038a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        try {
            Connection createNoAccountConnection = ConnectionFactory.createNoAccountConnection(this.mContext, jSONObject.getString("url"), false);
            createNoAccountConnection.setUseGet(true);
            String requestString = createNoAccountConnection.requestString();
            if (!TextUtils.isEmpty(requestString)) {
                aVar.f5114a = requestString;
                return;
            }
            throw new ResultException("result has error");
        } catch (Exception e) {
            throw new ResultException(e);
        }
    }

    public a(Context context, Session session) {
        super(context, session, C0038a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        Connection connection;
        String string = sortedParameter.getString("processId");
        long j = sortedParameter.getLong("chargeFee");
        if (this.mSession.isFakeAccountLoader()) {
            connection = ConnectionFactory.createNoAccountConnection(getContext(), CommonConstants.getUrl("p/na/recharge/alipayApk"));
        } else {
            connection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/recharge/alipayApk"), getSession());
        }
        SortedParameter parameter = connection.getParameter();
        parameter.add("oaid", Client.getOaid());
        parameter.add("processId", string);
        parameter.add("chargeFee", Long.valueOf(j));
        parameter.add("channel", "ALIPAY");
        return connection;
    }
}
