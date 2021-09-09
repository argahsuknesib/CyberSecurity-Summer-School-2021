package com.mibi.sdk.component.recharge;

import android.util.Log;
import com.mibi.sdk.common.exception.PaymentException;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseRechargeMethodParser implements RechargeMethodParser {
    public abstract RechargeMethod newRechargeMethod();

    public RechargeMethod parse(String str, JSONObject jSONObject) throws JSONException {
        RechargeMethod newRechargeMethod = newRechargeMethod();
        newRechargeMethod.mChannel = jSONObject.getString("channel");
        newRechargeMethod.mTitle = jSONObject.getString("title");
        newRechargeMethod.mContentHint = jSONObject.optString("contentHint");
        newRechargeMethod.mDiscountDesc = jSONObject.optString("discountDesc");
        newRechargeMethod.mDiscountRate = jSONObject.optDouble("discount", 1.0d);
        JSONObject optJSONObject = jSONObject.optJSONObject("entry");
        if (optJSONObject != null) {
            newRechargeMethod.mContentHintEntryData = new EntryData();
            try {
                newRechargeMethod.mContentHintEntryData.parseEntryData(optJSONObject);
            } catch (PaymentException e) {
                Log.e("BaseRechargeMhdParser", "BaseRechargeMethodParser PaymentException ", e);
            }
        }
        return newRechargeMethod;
    }
}
