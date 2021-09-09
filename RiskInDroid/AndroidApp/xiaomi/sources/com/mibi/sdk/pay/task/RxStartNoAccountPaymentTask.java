package com.mibi.sdk.pay.task;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RxStartNoAccountPaymentTask extends RxBasePaymentTask<Result> {
    private String mOrder;

    public static class Result implements Serializable {
        public String mOrderDesc;
        public long mOrderFee;
        public ArrayList<RechargeType> mRechargeTypes = new ArrayList<>();
        public String mResult;
        public int mResultErrorCode;
        public String mResultErrorDesc;
        public String mTradeId;
    }

    public RxStartNoAccountPaymentTask(Context context, Session session) {
        super(context, session, Result.class);
    }

    public Connection getConnection(SortedParameter sortedParameter) {
        String string = sortedParameter.getString("processId");
        String string2 = sortedParameter.getString("channels");
        this.mOrder = sortedParameter.getString("order");
        Connection createNoAccountConnection = ConnectionFactory.createNoAccountConnection(this.mContext, CommonConstants.getUrl("/p/na/createNaTrade"));
        SortedParameter parameter = createNoAccountConnection.getParameter();
        parameter.add("processId", string);
        parameter.add("oaid", Client.getOaid());
        parameter.add("channels", string2);
        parameter.add("order", this.mOrder);
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

    /* access modifiers changed from: protected */
    public boolean parseResultInError(JSONObject jSONObject, Result result) throws PaymentException {
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject == null) {
            return false;
        }
        result.mResult = optJSONObject.toString();
        try {
            result.mResultErrorCode = jSONObject.getInt("errcode");
            result.mResultErrorDesc = jSONObject.optString("errDesc");
            return true;
        } catch (JSONException e) {
            throw new ResultException("error code not exists", e);
        }
    }

    /* access modifiers changed from: protected */
    public void parseResultInSuccess(JSONObject jSONObject, Result result) throws PaymentException {
        try {
            parseRechargeItemsData(jSONObject, result);
            parseOrder(this.mOrder, result);
        } catch (JSONException e) {
            throw new ResultException(e);
        }
    }

    private void parseRechargeItemsData(JSONObject jSONObject, Result result) throws JSONException, ResultException {
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
                    }
                }
                rechargeType.mType = jSONObject2.getString("type");
                rechargeType.mIcon = jSONObject2.getString("iconUrl");
                rechargeType.mTitle = jSONObject2.getString("title");
                rechargeType.mTitleHint = jSONObject2.optString("titleHint");
                rechargeType.mFavorite = jSONObject2.optBoolean("isFavorite", false);
                rechargeType.mCurrencyUnit = jSONObject2.getString("currencyUnit");
                result.mRechargeTypes.add(rechargeType);
            }
            return;
        }
        throw new ResultException("recharge methods should not be empty");
    }

    private void parseOrder(String str, Result result) throws ResultException {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("orderDesc");
                long j = jSONObject.getLong("orderFee");
                String string2 = jSONObject.getString("orderId");
                result.mOrderDesc = string;
                result.mOrderFee = j;
                result.mTradeId = string2;
            } catch (JSONException e) {
                Log.d("RxNoAccountPaymentTask", "noAccount order content error!");
                throw new ResultException(e);
            }
        }
    }
}
