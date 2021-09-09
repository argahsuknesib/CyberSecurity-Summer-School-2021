package com.mibi.sdk.channel.wxpay.b;

import android.content.Context;
import android.util.Log;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePartnerTask;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends RxBasePartnerTask<C0040a> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f5128O000000o;

    /* renamed from: com.mibi.sdk.channel.wxpay.b.a$a  reason: collision with other inner class name */
    public static class C0040a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5129a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        C0040a aVar = (C0040a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        try {
            Connection createNoAccountConnection = ConnectionFactory.createNoAccountConnection(this.mContext, jSONObject.getString("url"), false);
            createNoAccountConnection.setUseGet(true);
            JSONObject requestJSON = createNoAccountConnection.requestJSON();
            Log.d("RxPartnerWXpayTask", "parseWeixinOrderResult");
            try {
                String string = requestJSON.getString("appid");
                String string2 = requestJSON.getString("noncestr");
                String string3 = requestJSON.getString("package");
                String string4 = requestJSON.getString("partnerid");
                String string5 = requestJSON.getString("prepayid");
                String string6 = requestJSON.getString("sign");
                String string7 = requestJSON.getString("timestamp");
                if (Utils.checkStrings(string, string2, string3, string4, string5, string6, string7)) {
                    aVar.f5129a = string;
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
                Log.d("RxPartnerWXpayTask", "RxWXPayTask order json exception", e);
            } catch (ResultException e2) {
                Log.d("RxPartnerWXpayTask", "RxWXPayTask order content exception", e2);
            }
        } catch (Exception e3) {
            throw new ResultException(e3);
        }
    }

    public a(Context context, Session session, String str) {
        super(context, session, C0040a.class);
        this.f5128O000000o = str;
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        sortedParameter.getString("processId");
        sortedParameter.getLong("chargeFee");
        Connection createPartnerConnection = ConnectionFactory.createPartnerConnection(getSession(), getPartnerUserId(this.f5128O000000o), CommonConstants.getUrl("p/partner/recharge/wxpayApk"));
        createPartnerConnection.getParameter().addAll(sortedParameter);
        addPartnerParams(createPartnerConnection, this.f5128O000000o);
        return createPartnerConnection;
    }
}
