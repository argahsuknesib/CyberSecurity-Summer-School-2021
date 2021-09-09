package com.mibi.sdk.channel.alipay.b;

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
import org.json.JSONObject;

public final class b extends RxBasePartnerTask<a> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f5115O000000o;

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5116a;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        try {
            Connection createNoAccountConnection = ConnectionFactory.createNoAccountConnection(this.mContext, jSONObject.getString("url"), false);
            createNoAccountConnection.setUseGet(true);
            String requestString = createNoAccountConnection.requestString();
            if (!TextUtils.isEmpty(requestString)) {
                aVar.f5116a = requestString;
                return;
            }
            throw new ResultException("result has error");
        } catch (Exception e) {
            throw new ResultException(e);
        }
    }

    public b(Context context, Session session, String str) {
        super(context, session, a.class);
        this.f5115O000000o = str;
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        Connection createPartnerConnection = ConnectionFactory.createPartnerConnection(getSession(), getPartnerUserId(this.f5115O000000o), CommonConstants.getUrl("p/partner/recharge/alipayApk"));
        createPartnerConnection.getParameter().addAll(sortedParameter);
        addPartnerParams(createPartnerConnection, this.f5115O000000o);
        return createPartnerConnection;
    }
}
