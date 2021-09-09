package _m_j;

import com.mibi.sdk.channel.mipay.d;
import com.mibi.sdk.component.recharge.BaseRechargeMethodParser;
import com.mibi.sdk.component.recharge.RechargeMethod;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cff extends BaseRechargeMethodParser {
    public final RechargeMethod parse(String str, JSONObject jSONObject) throws JSONException {
        d dVar = (d) super.parse(str, jSONObject);
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        dVar.mMinMoneyValue = jSONObject2.getLong("minValue");
        dVar.mMaxMoneyValue = jSONObject2.getLong("maxValue");
        dVar.mWarnValue = jSONObject2.optLong("warnValue");
        JSONArray jSONArray = jSONObject2.getJSONArray("values");
        for (int i = 0; i < jSONArray.length(); i++) {
            dVar.mMoneyValues.add(Long.valueOf(jSONArray.getLong(i)));
        }
        dVar.mMinMibiValue = dVar.mMinMoneyValue;
        dVar.mMaxMibiValue = dVar.mMaxMoneyValue;
        dVar.mWarnMibiValue = dVar.mWarnValue;
        dVar.mMibiValues = dVar.mMoneyValues;
        return dVar;
    }

    public final RechargeMethod newRechargeMethod() {
        return new d();
    }
}
