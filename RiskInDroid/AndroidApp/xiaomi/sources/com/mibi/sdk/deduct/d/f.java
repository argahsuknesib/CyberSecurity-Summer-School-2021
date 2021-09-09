package com.mibi.sdk.deduct.d;

import android.content.Context;
import android.util.Log;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.account.loader.FakeAccountLoader;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import org.json.JSONObject;

public final class f extends RxBasePaymentTask<a> {

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5136a;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        try {
            aVar.f5136a = jSONObject.optString("url");
            Connection createNoAccountConnection = ConnectionFactory.createNoAccountConnection(this.mContext, aVar.f5136a, false);
            createNoAccountConnection.setUseGet(true);
            JSONObject requestJSON = createNoAccountConnection.requestJSON();
            int optInt = requestJSON.optInt("errcode");
            if (optInt == 200) {
                aVar.f5136a = requestJSON.optString("url");
                return;
            }
            String str = "get alipay url error , errorCode : " + optInt;
            Log.e("RxDoAlipaySignDeduct", str);
            throw new ResultException(str);
        } catch (Exception e) {
            Log.e("RxDoAlipaySignDeduct", "parse alipay url error ");
            throw new ResultException(e);
        }
    }

    public f(Context context, Session session) {
        super(context, session, a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        Connection connection;
        String string = sortedParameter.getString("processId");
        if (this.mSession.getAccountLoader() instanceof FakeAccountLoader) {
            connection = ConnectionFactory.createNoAccountConnection(this.mContext, CommonConstants.getUrl("p/na/deductSignAndPay/alipay"));
        } else {
            connection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/deductSignAndPay/alipay"), this.mSession);
        }
        SortedParameter parameter = connection.getParameter();
        parameter.add("processId", string);
        parameter.add("deductChannel", e.a.ALIPAY.b());
        parameter.add("oaid", Client.getOaid());
        return connection;
    }
}
