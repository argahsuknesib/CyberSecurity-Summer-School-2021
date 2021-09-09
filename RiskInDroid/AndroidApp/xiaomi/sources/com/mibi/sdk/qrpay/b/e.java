package com.mibi.sdk.qrpay.b;

import android.content.Context;
import android.text.TextUtils;
import com.mibi.sdk.QrChannel;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends RxBasePaymentTask<a> {

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public String f5174a;
        public ArrayList<QrChannel> b;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        super.parseResultInSuccess(jSONObject, aVar);
        aVar.f5174a = jSONObject.optString("qrPayUrl");
        String optString = jSONObject.optString("icons");
        if (TextUtils.isEmpty(optString)) {
            MibiLog.e("RxUnitedQrPayTask", "icons is null");
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(optString);
            aVar.b = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                QrChannel qrChannel = new QrChannel();
                qrChannel.mIcon = Utils.joinUrl("http://file.market.xiaomi.com/mfc/download/", jSONObject2.getString("icon"));
                qrChannel.mChannel = jSONObject2.getString("channel");
                qrChannel.mTitle = jSONObject2.getString("title");
                aVar.b.add(qrChannel);
            }
        } catch (Exception e) {
            MibiLog.d("RxUnitedQrPayTask", "parse channels error : " + e.getMessage(), e);
        }
    }

    public e(Context context, Session session) {
        super(context, session, a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        long j = sortedParameter.getLong("chargeFee");
        Connection createAccountConnection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("/p/unitedQrPayment"), getSession());
        SortedParameter parameter = createAccountConnection.getParameter();
        parameter.add("oaid", Client.getOaid());
        parameter.add("processId", string);
        parameter.add("chargeFee", Long.valueOf(j));
        return createAccountConnection;
    }
}
