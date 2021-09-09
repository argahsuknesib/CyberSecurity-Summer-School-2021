package _m_j;

import _m_j.hcc;
import android.text.TextUtils;
import android.text.method.ArrowKeyMovementMethod;
import android.util.Log;
import android.widget.TextView;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueDefinition;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueList;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.State;
import java.util.List;
import java.util.Map;

public final class hfa {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    public static String O000000o(SpecProperty specProperty, Object obj) {
        List<ValueDefinition> values;
        if (specProperty == null) {
            gsy.O000000o(4, "mijia-card", "getValueDescription property is null");
            return null;
        }
        ConstraintValue constraintValue = specProperty.getPropertyDefinition().getConstraintValue();
        if (obj != null && (constraintValue instanceof ValueList) && (values = ((ValueList) constraintValue).values()) != null && values.size() > 0) {
            for (ValueDefinition next : values) {
                Object valueObject = next.valueObject();
                if (obj.equals(valueObject) || String.valueOf(obj).equals(String.valueOf(valueObject))) {
                    return next.description();
                }
                while (r4.hasNext()) {
                }
            }
        }
        return null;
    }

    public static int O00000Oo(SpecProperty specProperty, Object obj) {
        List<ValueDefinition> values;
        ConstraintValue constraintValue = specProperty.getPropertyDefinition().getConstraintValue();
        if (obj == null || !(constraintValue instanceof ValueList) || (values = ((ValueList) constraintValue).values()) == null || values.size() <= 0) {
            return -1;
        }
        for (int i = 0; i < values.size(); i++) {
            Object valueObject = values.get(i).valueObject();
            if (obj.equals(valueObject) || String.valueOf(obj).equals(String.valueOf(valueObject))) {
                return i;
            }
        }
        return -1;
    }

    public static Number O000000o(double d, double d2, double d3, double d4, String str) {
        if (d4 <= 0.0d) {
            d4 = 1.0d;
        }
        double d5 = (double) ((int) ((d - d2) / d4));
        Double.isNaN(d5);
        double min = Math.min(d3, Math.max(d2, (d5 * d4) + d2));
        if (hhc.O000000o(str) || !String.valueOf(d4).contains(".")) {
            return Long.valueOf(Math.round(min));
        }
        return Double.valueOf(min);
    }

    public static boolean O000000o(Object obj) {
        return Boolean.TRUE.equals(obj) || hhc.O000000o(obj, 0.0d) > 0.0d || "true".equals(obj);
    }

    public static String O000000o(String str, Device device, Spec.SpecItem specItem, String str2, State state) {
        Spec spec;
        String str3;
        String state2 = state.toString();
        String str4 = null;
        String str5 = "";
        if (specItem == null) {
            spec = null;
            str3 = str5;
        } else {
            str3 = specItem.getDefinition().getDescription();
            spec = specItem.getParent();
        }
        if (spec != null) {
            str5 = spec.getTypeName();
        }
        String O00000Oo = O00000Oo(device);
        hcz instance = hcz.getInstance();
        if (TextUtils.isEmpty(str2)) {
            str2 = str3;
        } else if (!str2.equals(str3)) {
            str4 = instance.getCardIconPath(instance.translateName(str + O00000Oo + "_" + str5 + "_" + str3 + "_" + str2 + "_" + state2));
        }
        if (str4 == null) {
            str4 = instance.getCardIconPath(instance.translateName(str + O00000Oo + "_" + str5 + "_" + str2 + "_" + state2));
        }
        if (str4 == null) {
            str4 = instance.getCardIconPath(instance.translateName(str + str5 + "_" + str2 + "_" + state2));
        }
        if (str4 == null) {
            str4 = instance.getCardIconPath(instance.translateName(str + str2 + "_" + state2));
        }
        if (str4 == null) {
            gsy.O00000o0(LogType.CARD, "mijia-card", "CardItem.getCardDrawable not match:" + O00000Oo + "_" + str5 + "_" + str3 + "_" + str2 + "_" + state2);
        } else {
            gsy.O00000Oo("mijia-card", "CardItem.getCardDrawable match:".concat(String.valueOf(str4)));
        }
        return str4;
    }

    public static SpecAction O000000o(SpecDevice specDevice, hdb hdb) {
        Map<Integer, SpecAction> actions;
        if (hdb != null && !TextUtils.isEmpty(hdb.O0000Ooo)) {
            String[] split = hdb.O0000Ooo.split(":");
            if (split.length == 3) {
                for (Map.Entry<Integer, SpecService> value : specDevice.getServices().entrySet()) {
                    SpecService specService = (SpecService) value.getValue();
                    if (TextUtils.equals(split[1], specService.getTypeName()) && (actions = specService.getActions()) != null) {
                        for (Map.Entry<Integer, SpecAction> value2 : actions.entrySet()) {
                            SpecAction specAction = (SpecAction) value2.getValue();
                            if (TextUtils.equals(split[2], specAction.getActionDefinition().getTypeName())) {
                                return specAction;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public static List<PropertyParam> O000000o(String str, int i, Spec.SpecItem[] specItemArr, List<PropertyParam> list) {
        return fax.O000000o(str, i, specItemArr, list);
    }

    public static void O000000o(TextView textView, String str) {
        if (textView != null) {
            if (str == null) {
                textView.setText("");
                return;
            }
            String[] split = str.split("\\n");
            textView.setSingleLine(false);
            textView.setGravity(17);
            textView.setMaxLines(Math.max(1, split.length));
            textView.setHorizontallyScrolling(true);
            textView.setMovementMethod(ArrowKeyMovementMethod.getInstance());
            textView.setText(str);
        }
    }

    public static <T, E extends hcc.O000000o<T>> T O000000o(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        return objArr[0];
    }

    public static String O000000o(Device device) {
        if (device == null) {
            return null;
        }
        return device.specUrn;
    }

    public static String O00000Oo(Device device) {
        try {
            if (!TextUtils.isEmpty(device.specUrn)) {
                return device.specUrn.split(":")[3];
            }
            return null;
        } catch (Exception e) {
            Log.e("SpecUtils", "getTypeName", e);
            return null;
        }
    }
}
