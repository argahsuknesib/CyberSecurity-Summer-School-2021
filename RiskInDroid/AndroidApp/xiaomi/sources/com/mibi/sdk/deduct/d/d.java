package com.mibi.sdk.deduct.d;

import android.content.Context;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.account.loader.FakeAccountLoader;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.component.recharge.Recharge;
import com.mibi.sdk.component.recharge.RechargeType;
import com.mibi.sdk.deduct.e;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends RxBasePaymentTask<a> {

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<RechargeType> f5134a = new ArrayList<>();
        /* access modifiers changed from: private */
        public HashMap<String, RechargeType> b = new HashMap<>();
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        a aVar = (a) obj;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("totalData");
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    RechargeType rechargeType = new RechargeType();
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("data");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                        String string = jSONObject3.getString("channel");
                        jSONObject3.getString("title");
                        Recharge recharge = e.O000000o().f5141O000000o.get(string);
                        if (recharge != null) {
                            rechargeType.mRechargeMethods.add(recharge.getParser().parse(string, jSONObject3));
                            aVar.b.put(string, rechargeType);
                        }
                    }
                    rechargeType.mType = jSONObject2.getString("type");
                    rechargeType.mIcon = jSONObject2.getString("iconUrl");
                    rechargeType.mTitle = jSONObject2.getString("title");
                    rechargeType.mTitleHint = jSONObject2.optString("titleHint");
                    rechargeType.mFavorite = jSONObject2.optBoolean("isFavorite", false);
                    rechargeType.mCurrencyUnit = jSONObject2.getString("currencyUnit");
                    aVar.f5134a.add(rechargeType);
                }
                return;
            }
            throw new ResultException("recharge methods should not be empty");
        } catch (JSONException e) {
            throw new ResultException(e);
        }
    }

    public d(Context context, Session session) {
        super(context, session, a.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        SortedParameter sortedParameter2;
        Connection connection;
        String string = sortedParameter.getString("processId");
        String string2 = sortedParameter.getString("channels");
        if (this.mSession.getAccountLoader() instanceof FakeAccountLoader) {
            connection = ConnectionFactory.createNoAccountConnection(this.mContext, CommonConstants.getUrl("p/na/deductCharges"));
            sortedParameter2 = connection.getParameter();
        } else {
            connection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/deductCharges"), this.mSession);
            sortedParameter2 = connection.getParameter();
        }
        sortedParameter2.add("oaid", Client.getOaid());
        sortedParameter2.add("processId", string);
        sortedParameter2.add("package", Client.getAppInfo().getPackage());
        sortedParameter2.add("channels", string2);
        sortedParameter2.add("deductPay", Boolean.TRUE);
        sortedParameter2.add("platform", Client.getPlatform());
        sortedParameter2.add("os", Client.getOS());
        sortedParameter2.add("miuiVersion", Client.getMiuiVersion());
        sortedParameter2.add("miuiUiVersionCode", Integer.valueOf(Client.getMiuiUiVersionCode()));
        sortedParameter2.add("mibiUiVersionCode", Integer.valueOf(Client.getMibiUiVersionCode()));
        sortedParameter2.add("mncmcc", Client.getTelephonyInfo().getSimOperator());
        connection.setUseGet(true);
        return connection;
    }
}
