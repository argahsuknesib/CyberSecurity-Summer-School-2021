package com.mibi.sdk.channel.mipay.b;

import android.content.Context;
import android.text.TextUtils;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePartnerTask;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends RxBasePartnerTask<a> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f5119O000000o;

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5120a;
        public String b;
        public String c;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        try {
            String string = jSONObject.getString("chargeOrderId");
            String string2 = jSONObject.getString("url");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                throw new ResultException("result has error");
            }
            aVar.f5120a = string;
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

    public b(Context context, Session session, String str) {
        super(context, session, a.class);
        this.f5119O000000o = str;
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        Connection createPartnerConnection = ConnectionFactory.createPartnerConnection(getSession(), getPartnerUserId(this.f5119O000000o), CommonConstants.getUrl("p/partner/recharge/mipayApk"));
        createPartnerConnection.getParameter().addAll(sortedParameter);
        addPartnerParams(createPartnerConnection, this.f5119O000000o);
        return createPartnerConnection;
    }
}
