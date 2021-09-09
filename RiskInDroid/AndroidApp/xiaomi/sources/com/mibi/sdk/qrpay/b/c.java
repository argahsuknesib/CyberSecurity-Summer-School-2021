package com.mibi.sdk.qrpay.b;

import android.content.Context;
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

public final class c extends RxBasePaymentTask<a> {

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5171a;
        public int b;
        public String c;
        public long d;
        public String e;
    }

    public final /* synthetic */ boolean parseResultInError(JSONObject jSONObject, Object obj) throws PaymentException {
        return O000000o(jSONObject, (a) obj);
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        try {
            String string = jSONObject.getString("title");
            long j = jSONObject.getLong("price");
            String string2 = jSONObject.getString("marketType");
            if (Utils.checkStrings(string, string2, jSONObject.getString("tradeId"))) {
                aVar.d = j;
                aVar.e = string2;
                return;
            }
            throw new ResultException("result has error");
        } catch (JSONException e) {
            throw new ResultException(e);
        }
    }

    public c(Context context, Session session) {
        super(context, session, a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        String string2 = sortedParameter.getString("order");
        Connection createAccountConnection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/checkPayment"), this.mSession);
        SortedParameter parameter = createAccountConnection.getParameter();
        parameter.add("processId", string);
        parameter.add("isPad", Boolean.valueOf(Utils.isPad()));
        parameter.add("order", string2);
        return createAccountConnection;
    }

    private static boolean O000000o(JSONObject jSONObject, a aVar) throws PaymentException {
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject == null) {
            return false;
        }
        aVar.f5171a = optJSONObject.toString();
        try {
            aVar.b = jSONObject.getInt("errcode");
            aVar.c = jSONObject.optString("errDesc");
            return true;
        } catch (JSONException e) {
            throw new ResultException("error code not exists", e);
        }
    }
}
