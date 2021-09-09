package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.scene.ConstantType;
import org.json.JSONObject;

public final class hpx implements hrd {

    /* renamed from: O000000o  reason: collision with root package name */
    double f512O000000o = Double.MIN_VALUE;
    double O00000Oo = Double.MAX_VALUE;
    public String O00000o;
    double O00000o0 = Double.MIN_VALUE;
    public String O00000oO;
    public int O00000oo;

    public final Object O00000o0() {
        return null;
    }

    public hpx(String str) {
        this.O00000oO = str;
        if (TextUtils.equals(str, ConstantType.TriggerConditionType.CLOUD_SUNSET.key)) {
            this.O00000oo = 0;
        } else if (TextUtils.equals(str, ConstantType.TriggerConditionType.CLOUD_SUNRISE.key)) {
            this.O00000oo = 1;
        } else if (TextUtils.equals(str, ConstantType.TriggerConditionType.CLOUD_TEMPERATURE.key)) {
            this.O00000oo = 2;
        } else if (TextUtils.equals(str, ConstantType.TriggerConditionType.CLOUD_HUMIDITY.key)) {
            this.O00000oo = 3;
        } else if (TextUtils.equals(str, ConstantType.TriggerConditionType.CLOUD_AQI.key)) {
            this.O00000oo = 4;
        }
    }

    public final String O000000o() {
        return this.O00000oO;
    }

    public final String O00000Oo() {
        if (TextUtils.equals(this.O00000oO, ConstantType.TriggerConditionType.CLOUD_SUNSET.key)) {
            return ServiceApplication.getAppContext().getString(R.string.sunset);
        }
        if (TextUtils.equals(this.O00000oO, ConstantType.TriggerConditionType.CLOUD_SUNRISE.key)) {
            return ServiceApplication.getAppContext().getString(R.string.sunrise);
        }
        return null;
    }

    public final int O00000o() {
        int i = this.O00000oo;
        if (i == 2 || i == 3 || i == 4) {
            return ConstantType.ValueType.TYPE_INTERVAL.type;
        }
        return ConstantType.ValueType.TYPE_UNKWON.type;
    }

    public final void O000000o(Object obj) {
        if (obj != null && (obj instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            this.f512O000000o = jSONObject.optDouble("min", Double.MIN_VALUE);
            this.O00000Oo = jSONObject.optDouble("max", Double.MAX_VALUE);
            this.O00000o0 = jSONObject.optDouble("equals", Double.MIN_VALUE);
        }
    }
}
