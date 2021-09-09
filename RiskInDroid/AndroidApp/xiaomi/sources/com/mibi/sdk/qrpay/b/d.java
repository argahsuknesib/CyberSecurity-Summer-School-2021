package com.mibi.sdk.qrpay.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends RxBasePaymentTask<a> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f5172O000000o;

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5173a;
        public int b;
        public String c;
        public String d;
        public long e;
        public String f;
    }

    public final /* synthetic */ boolean parseResultInError(JSONObject jSONObject, Object obj) throws PaymentException {
        return O000000o(jSONObject, (a) obj);
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        try {
            String str = this.f5172O000000o;
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject(str);
                String string = jSONObject2.getString("orderDesc");
                long j = jSONObject2.getLong("orderFee");
                String string2 = jSONObject2.getString("orderId");
                aVar.d = string;
                aVar.e = j;
                aVar.f = string2;
            }
        } catch (JSONException e) {
            Log.d("RxNoAccountPaymentTask", "noAccount order content error!");
            throw new ResultException(e);
        } catch (Exception e2) {
            MibiLog.d("RxNoAccountPaymentTask", "parse order failed : " + e2.getMessage(), e2);
            throw new ResultException(e2);
        }
    }

    public d(Context context, Session session) {
        super(context, session, a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        String string2 = sortedParameter.getString("channels");
        this.f5172O000000o = sortedParameter.getString("order");
        Connection createNoAccountConnection = ConnectionFactory.createNoAccountConnection(this.mContext, CommonConstants.getUrl("/p/na/createNaTrade"));
        SortedParameter parameter = createNoAccountConnection.getParameter();
        parameter.add("processId", string);
        parameter.add("oaid", Client.getOaid());
        parameter.add("channels", string2);
        parameter.add("order", this.f5172O000000o);
        parameter.add("platform", Client.getPlatform());
        parameter.add("package", Client.getAppInfo().getPackage());
        parameter.add("channels", string2);
        parameter.add("os", Client.getOS());
        parameter.add("miuiVersion", Client.getMiuiVersion());
        parameter.add("miuiUiVersionCode", Integer.valueOf(Client.getMiuiUiVersionCode()));
        parameter.add("mibiUiVersionCode", Integer.valueOf(Client.getMibiUiVersionCode()));
        parameter.add("mncmcc", Client.getTelephonyInfo().getSimOperator());
        createNoAccountConnection.setUseGet(false);
        return createNoAccountConnection;
    }

    private static boolean O000000o(JSONObject jSONObject, a aVar) throws PaymentException {
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject == null) {
            return false;
        }
        aVar.f5173a = optJSONObject.toString();
        try {
            aVar.b = jSONObject.getInt("errcode");
            aVar.c = jSONObject.optString("errDesc");
            return true;
        } catch (JSONException e) {
            throw new ResultException("error code not exists", e);
        }
    }
}
