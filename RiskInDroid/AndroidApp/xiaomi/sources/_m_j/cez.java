package _m_j;

import com.mibi.sdk.channel.alipay.b;
import com.mibi.sdk.component.recharge.BaseRechargeMethodParser;
import com.mibi.sdk.component.recharge.RechargeMethod;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cez extends BaseRechargeMethodParser {
    public final RechargeMethod parse(String str, JSONObject jSONObject) throws JSONException {
        b bVar = (b) super.parse(str, jSONObject);
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        bVar.mMinMoneyValue = jSONObject2.getLong("minValue");
        bVar.mMaxMoneyValue = jSONObject2.getLong("maxValue");
        bVar.mWarnValue = jSONObject2.optLong("warnValue");
        JSONArray jSONArray = jSONObject2.getJSONArray("values");
        for (int i = 0; i < jSONArray.length(); i++) {
            bVar.mMoneyValues.add(Long.valueOf(jSONArray.getLong(i)));
        }
        bVar.mMinMibiValue = bVar.mMinMoneyValue;
        bVar.mMaxMibiValue = bVar.mMaxMoneyValue;
        bVar.mWarnMibiValue = bVar.mWarnValue;
        bVar.mMibiValues = bVar.mMoneyValues;
        return bVar;
    }

    public final RechargeMethod newRechargeMethod() {
        return new b();
    }
}
