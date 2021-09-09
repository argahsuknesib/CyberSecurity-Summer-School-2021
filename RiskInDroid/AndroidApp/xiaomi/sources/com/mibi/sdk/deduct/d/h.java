package com.mibi.sdk.deduct.d;

import android.content.Context;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
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

public final class h extends RxBasePaymentTask<a> {

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5138a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public int m;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        try {
            aVar.f5138a = jSONObject.getString("url");
            aVar.b = jSONObject.getString("appid");
            aVar.m = jSONObject.getInt("businessType");
            aVar.c = jSONObject.getString("contract_code");
            aVar.d = jSONObject.getString("contract_display_account");
            aVar.e = jSONObject.getString("mch_id");
            aVar.f = jSONObject.getString("notify_url");
            aVar.g = jSONObject.getString("plan_id");
            aVar.h = jSONObject.getString("request_serial");
            aVar.j = jSONObject.getString("timestamp");
            aVar.k = jSONObject.getString("version");
            aVar.l = jSONObject.getString("sign");
            aVar.i = jSONObject.getString("return_app");
        } catch (JSONException unused) {
            throw new ResultException("wxpay deduct result error");
        }
    }

    public h(Context context, Session session) {
        super(context, session, a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        Connection createAccountConnection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/deductSign/wxpay"), this.mSession);
        SortedParameter parameter = createAccountConnection.getParameter();
        parameter.add("processId", string);
        parameter.add("deductChannel", e.a.WXPAY.b());
        parameter.add("oaid", Client.getOaid());
        return createAccountConnection;
    }
}
