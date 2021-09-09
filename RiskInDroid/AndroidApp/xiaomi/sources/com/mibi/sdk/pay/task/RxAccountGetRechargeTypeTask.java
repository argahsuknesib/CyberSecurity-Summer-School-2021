package com.mibi.sdk.pay.task;

import android.content.Context;
import android.text.TextUtils;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.SortedParameter;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ResultException;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.component.recharge.Recharge;
import com.mibi.sdk.component.recharge.RechargeManager;
import com.mibi.sdk.component.recharge.RechargeType;
import com.mibi.sdk.network.Connection;
import com.mibi.sdk.network.ConnectionFactory;
import com.mibi.sdk.task.RxBasePaymentTask;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class RxAccountGetRechargeTypeTask extends RxBasePaymentTask<Result> {

    public static class Result implements Serializable {
        public String mDirectPayDiscount;
        public RechargeType mLastChargeType;
        public HashMap<String, RechargeType> mRechargeMethodTypeMap = new HashMap<>();
        public ArrayList<RechargeType> mRechargeTypes = new ArrayList<>();
        public boolean mShowAll;
    }

    public final /* synthetic */ void parseResultInSuccess(JSONObject jSONObject, Object obj) throws PaymentException {
        Result result = (Result) obj;
        try {
            result.mShowAll = jSONObject.optBoolean("showAll", false);
            result.mDirectPayDiscount = jSONObject.optString("directPayDiscount");
            String optString = jSONObject.optString("lastCPT", "");
            JSONArray jSONArray = jSONObject.getJSONArray("totalData");
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    RechargeType rechargeType = new RechargeType();
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("data");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                        String string = jSONObject3.getString("channel");
                        Recharge recharge = RechargeManager.get().getRecharge(string);
                        if (recharge != null) {
                            rechargeType.mRechargeMethods.add(recharge.getParser().parse(string, jSONObject3));
                            result.mRechargeMethodTypeMap.put(string, rechargeType);
                        }
                    }
                    if (TextUtils.equals(optString, rechargeType.mType)) {
                        result.mLastChargeType = rechargeType;
                    }
                    rechargeType.mType = jSONObject2.getString("type");
                    rechargeType.mIcon = jSONObject2.getString("iconUrl");
                    rechargeType.mTitle = jSONObject2.getString("title");
                    rechargeType.mTitleHint = jSONObject2.getString("titleHint");
                    rechargeType.mFavorite = jSONObject2.optBoolean("isFavorite", false);
                    rechargeType.mCurrencyUnit = jSONObject2.getString("currencyUnit");
                    result.mRechargeTypes.add(rechargeType);
                }
                return;
            }
            throw new ResultException("recharge methods should not be empty");
        } catch (JSONException e) {
            throw new ResultException(e);
        }
    }

    public RxAccountGetRechargeTypeTask(Context context, Session session) {
        super(context, session, Result.class);
    }

    public final Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        long j = sortedParameter.getLong("chargeFee");
        String string2 = sortedParameter.getString("channels");
        Connection createAccountConnection = ConnectionFactory.createAccountConnection(CommonConstants.getUrl("p/chargesV1"), this.mSession);
        SortedParameter parameter = createAccountConnection.getParameter();
        parameter.add("processId", string);
        if (j > 0) {
            parameter.add("chargeFee", Long.valueOf(j));
        }
        parameter.add("platform", Client.getPlatform());
        parameter.add("package", Client.getAppInfo().getPackage());
        parameter.add("channels", string2);
        parameter.add("os", Client.getOS());
        parameter.add("miuiVersion", Client.getMiuiVersion());
        parameter.add("miuiUiVersionCode", Integer.valueOf(Client.getMiuiUiVersionCode()));
        parameter.add("mibiUiVersionCode", Integer.valueOf(Client.getMibiUiVersionCode()));
        parameter.add("mncmcc", Client.getTelephonyInfo().getSimOperator());
        createAccountConnection.setUseGet(true);
        return createAccountConnection;
    }
}
