package com.xiaomi.smarthome.miio.consumables;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class Consumable implements Serializable {
    private static Pattern pattern = Pattern.compile("[0-9]*");
    public String buyUrl;
    public int days = -999;
    public String daysText;
    public String description = null;
    public String model;
    public int parentPos;
    public double percentage;
    public String prop;
    public String remark;
    public boolean reset;
    public String state;

    public static Consumable parseFrom(Context context, JSONObject jSONObject) {
        String quantityString;
        Consumable consumable = new Consumable();
        if (jSONObject == null) {
            return consumable;
        }
        if (jSONObject.has("description")) {
            consumable.description = jSONObject.optString("description");
        }
        if (jSONObject.has("value")) {
            consumable.state = jSONObject.optString("value");
            if (TextUtils.isEmpty(consumable.state)) {
                consumable.percentage = 0.0d;
            } else if (isNumeric(consumable.state)) {
                try {
                    consumable.percentage = Double.parseDouble(consumable.state);
                } catch (Exception unused) {
                    consumable.percentage = -1.0d;
                }
            } else if (consumable.state.startsWith("-")) {
                consumable.percentage = -9999.0d;
            } else if (TextUtils.equals("LOW", consumable.state)) {
                consumable.percentage = -9998.0d;
            } else if (TextUtils.equals("ok", consumable.state.toLowerCase())) {
                consumable.percentage = 9999.0d;
            }
        }
        if (jSONObject.has("days")) {
            String optString = jSONObject.optString("days");
            if (!TextUtils.isEmpty(optString) && isNumeric(optString)) {
                try {
                    consumable.days = Integer.parseInt(optString);
                    Resources resources = context.getResources();
                    int i = consumable.days;
                    quantityString = resources.getQuantityString(R.plurals.consumables_remain_days, i, Integer.valueOf(i));
                } catch (Exception unused2) {
                    consumable.days = -999;
                    Resources resources2 = context.getResources();
                    int i2 = consumable.days;
                    quantityString = resources2.getQuantityString(R.plurals.consumables_remain_days, i2, Integer.valueOf(i2));
                } catch (Throwable th) {
                    Resources resources3 = context.getResources();
                    int i3 = consumable.days;
                    consumable.daysText = resources3.getQuantityString(R.plurals.consumables_remain_days, i3, Integer.valueOf(i3));
                    throw th;
                }
                consumable.daysText = quantityString;
            }
        }
        if (jSONObject.has("daysText")) {
            consumable.daysText = jSONObject.optString("daysText");
        }
        if (jSONObject.has("extra")) {
            consumable.buyUrl = jSONObject.optString("extra");
        }
        if (jSONObject.has("prop")) {
            consumable.prop = jSONObject.optString("prop");
        }
        if (jSONObject.has("reset")) {
            consumable.reset = jSONObject.optBoolean("reset");
        }
        if (jSONObject.has("remark")) {
            consumable.remark = jSONObject.optString("remark");
        }
        if (jSONObject.has("percentage")) {
            consumable.percentage = jSONObject.optDouble("percentage");
        }
        if (isNumeric(consumable.state)) {
            if (consumable.percentage < 0.0d) {
                consumable.percentage = 0.0d;
            }
            if (consumable.percentage > 100.0d) {
                consumable.percentage = 100.0d;
            }
        }
        if (consumable.description == null) {
            consumable.description = "";
        }
        return consumable;
    }

    public static JSONObject toJson(Consumable consumable) {
        JSONObject jSONObject = new JSONObject();
        if (consumable == null) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(consumable.state)) {
                jSONObject.put("value", consumable.state);
            }
            if (!TextUtils.isEmpty(consumable.description)) {
                jSONObject.put("description", consumable.description);
            }
            if (!TextUtils.isEmpty(consumable.buyUrl)) {
                jSONObject.put("extra", consumable.buyUrl);
            }
            if (consumable.days >= 0) {
                jSONObject.put("days", consumable.days);
                jSONObject.put("daysText", consumable.daysText);
            }
            if (!TextUtils.isEmpty(consumable.prop)) {
                jSONObject.put("prop", consumable.prop);
            }
            if (!TextUtils.isEmpty(consumable.remark)) {
                jSONObject.put("remark", consumable.remark);
            }
            jSONObject.put("reset", consumable.reset);
            jSONObject.put("percentage", consumable.percentage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean isNumeric(String str) {
        if (!TextUtils.isEmpty(str) && pattern.matcher(str).matches()) {
            return true;
        }
        return false;
    }
}
