package com.mibi.sdk.deduct.d;

import android.content.Context;
import android.util.Log;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.account.loader.FakeAccountLoader;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends RxBasePaymentTask<a> {

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5139a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        try {
            aVar.f5139a = jSONObject.getString("url");
            Connection createNoAccountConnection = ConnectionFactory.createNoAccountConnection(this.mContext, aVar.f5139a, false);
            createNoAccountConnection.setUseGet(true);
            JSONObject requestJSON = createNoAccountConnection.requestJSON();
            try {
                String string = requestJSON.getString("appid");
                String string2 = requestJSON.getString("noncestr");
                String string3 = requestJSON.getString("package");
                String string4 = requestJSON.getString("partnerid");
                String string5 = requestJSON.getString("prepayid");
                String string6 = requestJSON.getString("sign");
                String string7 = requestJSON.getString("timestamp");
                if (Utils.checkStrings(string, string2, string3, string4, string5, string6, string7)) {
                    aVar.b = string;
                    aVar.c = string4;
                    aVar.d = string5;
                    aVar.e = string3;
                    aVar.f = string2;
                    aVar.g = string7;
                    aVar.h = string6;
                    return;
                }
                throw new ResultException("RxWXPayTask result has error");
            } catch (JSONException e) {
                Log.d("RxDoWxpaySignDeduct", "RxDoWxpaySignDeductTask order json exception", e);
            } catch (ResultException e2) {
                Log.d("RxDoWxpaySignDeduct", "RxDoWxpaySignDeductTask order content exception", e2);
            }
        } catch (JSONException unused) {
            throw new ResultException("wxpay sign deduct result error");
        } catch (Exception e3) {
            throw new ResultException(e3);
        }
    }

    public i(Context context, Session session) {
        super(context, session, a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        Connection connection;
        String string = sortedParameter.getString("processId");
        if (this.mSession.getAccountLoader() instanceof FakeAccountLoader) {
            connection = ConnectionFactory.createNoAccountConnection(this.mContext, CommonConstants.getUrl("p/na/deductSignAndPay/wxpay"));
        } else {
            connection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/deductSignAndPay/wxpay"), this.mSession);
        }
        SortedParameter parameter = connection.getParameter();
        parameter.add("processId", string);
        parameter.add("deductChannel", e.a.WXPAY.b());
        parameter.add("oaid", Client.getOaid());
        return connection;
    }
}
