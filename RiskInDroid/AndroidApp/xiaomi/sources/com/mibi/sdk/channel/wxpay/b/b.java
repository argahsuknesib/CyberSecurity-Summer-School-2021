package com.mibi.sdk.channel.wxpay.b;

import android.content.Context;
import android.util.Log;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends RxBasePaymentTask<a> {

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5130a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        try {
            Connection createNoAccountConnection = ConnectionFactory.createNoAccountConnection(this.mContext, jSONObject.getString("url"), false);
            createNoAccountConnection.setUseGet(true);
            JSONObject requestJSON = createNoAccountConnection.requestJSON();
            Log.d("RxWXPayTask", "parseWeixinOrderResult");
            try {
                String string = requestJSON.getString("appid");
                String string2 = requestJSON.getString("noncestr");
                String string3 = requestJSON.getString("package");
                String string4 = requestJSON.getString("partnerid");
                String string5 = requestJSON.getString("prepayid");
                String string6 = requestJSON.getString("sign");
                String string7 = requestJSON.getString("timestamp");
                if (Utils.checkStrings(string, string2, string3, string4, string5, string6, string7)) {
                    aVar.f5130a = string;
                    aVar.b = string4;
                    aVar.c = string5;
                    aVar.d = string3;
                    aVar.e = string2;
                    aVar.f = string7;
                    aVar.g = string6;
                    return;
                }
                throw new ResultException("RxWXPayTask result has error");
            } catch (JSONException e) {
                Log.d("RxWXPayTask", "RxWXPayTask order json exception", e);
            } catch (ResultException e2) {
                Log.d("RxWXPayTask", "RxWXPayTask order content exception", e2);
            }
        } catch (Exception e3) {
            throw new ResultException(e3);
        }
    }

    public b(Context context, Session session) {
        super(context, session, a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        Connection connection;
        String string = sortedParameter.getString("processId");
        long j = sortedParameter.getLong("chargeFee");
        if (this.mSession.isFakeAccountLoader()) {
            connection = ConnectionFactory.createNoAccountConnection(getContext(), CommonConstants.getUrl("p/na/recharge/wxpayApk"));
        } else {
            connection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/recharge/wxpayApk"), getSession());
        }
        SortedParameter parameter = connection.getParameter();
        parameter.add("oaid", Client.getOaid());
        parameter.add("processId", string);
        parameter.add("chargeFee", Long.valueOf(j));
        parameter.add("channel", "WXPAY");
        return connection;
    }
}
