package _m_j;

import _m_j.hcc;
import _m_j.hcu;
import _m_j.hee;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.definitions.data.Access;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueDefinition;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueList;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueRange;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.State;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hej extends hcc.O000000o<Spec.SpecItem> {
    public final ArrayList<String> O0000OOo;
    public final Access O0000Oo0;

    public final /* synthetic */ int O000000o(Object obj) {
        return ((SpecProperty) ((Spec.SpecItem) obj)).getPropertyDefinition().getConstraintValue().size();
    }

    public final /* synthetic */ Object O000000o(Object obj, int i) {
        return ((SpecProperty) ((Spec.SpecItem) obj)).getPropertyDefinition().getConstraintValue().getIndexValue(i);
    }

    public final /* bridge */ /* synthetic */ String O000000o(Device device, Object obj) {
        return O000000o(device, (Spec.SpecItem) obj);
    }

    public final /* bridge */ /* synthetic */ String O000000o(Device device, Object obj, Object obj2) {
        return O000000o(device, (Spec.SpecItem) obj, obj2);
    }

    public final /* bridge */ /* synthetic */ String O000000o(Device device, Object obj, Object obj2, State state) {
        return O000000o(device, (Spec.SpecItem) obj, obj2, state);
    }

    public final /* synthetic */ void O000000o(hdb hdb, Device device, Object obj, Object obj2, fsm fsm) {
        Spec.SpecItem specItem = (Spec.SpecItem) obj;
        SpecAction O000000o2 = hfa.O000000o(hcz.getInstance().getSpecInstance(device), hdb);
        if (device == null) {
            if (fsm != null) {
                fsm.onFailure(new fso(-1, "device == null " + hdb + " " + specItem + " " + obj2));
            }
        } else if (O000000o2 != null) {
            hcz.getInstance().setDeviceAction(device.did, O000000o2, specItem, null);
        } else if (specItem != null) {
            hcz.getInstance().setDeviceProp(device.did, (SpecProperty) specItem, obj2, fsm);
        } else {
            LogType logType = LogType.CARD;
            gsy.O00000o0(logType, "mijia-card", "SpecCardType.sendRequest mPair null device:" + device + " prop:" + specItem + " value:" + obj2);
        }
    }

    public final /* synthetic */ Object O00000Oo(Device device, Object obj) {
        return O00000o0(device, (Spec.SpecItem) obj);
    }

    public final /* synthetic */ String O00000Oo(Device device, Object obj, Object obj2) {
        hee.O00000Oo O00000o0 = O00000o0(device, (Spec.SpecItem) obj, obj2);
        if (O00000o0 == null) {
            return null;
        }
        return O00000o0.O00000oO;
    }

    public final /* synthetic */ Pair O00000o(Device device, Object obj) {
        Spec.SpecItem specItem = (Spec.SpecItem) obj;
        Map<String, hdi> propsMap = hcz.getInstance().getPropsMap(device.did);
        Object obj2 = null;
        if (propsMap == null) {
            return null;
        }
        hdi hdi = propsMap.get(fax.O000000o(specItem));
        if (hdi != null) {
            obj2 = hdi.f18812O000000o;
        }
        return new Pair(obj2, Long.valueOf(O00000o(device, specItem)));
    }

    public final /* synthetic */ Object O00000o0(Device device, Object obj) {
        return O00000Oo(device, (Spec.SpecItem) obj);
    }

    public final /* synthetic */ long O00000oO(Device device, Object obj) {
        return O00000o(device, (Spec.SpecItem) obj);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public hej(JSONObject jSONObject) {
        super(jSONObject, hee.O000000o(jSONObject == null ? null : jSONObject.optJSONObject("prop")));
        int length;
        if (jSONObject == null) {
            this.O0000OOo = null;
            this.O0000Oo0 = null;
            return;
        }
        this.O00000oo.f18836O000000o = this.O00000o0;
        JSONArray optJSONArray = jSONObject.optJSONArray("desc_sort");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("access");
        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
            this.O0000Oo0 = null;
        } else {
            this.O0000Oo0 = hfc.O000000o(optJSONArray2);
        }
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            this.O0000OOo = null;
            return;
        }
        this.O0000OOo = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            this.O0000OOo.add(hcg.O000000o(optJSONArray.optString(i)));
        }
    }

    private static long O00000o(Device device, Spec.SpecItem specItem) {
        return hcg.O000000o(hcz.getInstance().getPropsMap(device.did), fax.O000000o(specItem));
    }

    public static String O000000o(Device device, Spec.SpecItem specItem) {
        return (device == null || specItem == null) ? "" : O000000o(device, specItem, (Object) null);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:10:0x0063 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:12:0x0081 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:14:0x0099 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:16:0x009f */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, int):int
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, double):double
      _m_j.hhc.O000000o(java.lang.Object, int):int */
    public final hdj O000000o(Spec.SpecItem specItem, Object obj, Device device) {
        Pair<String, fkv<Object, Object>> pair;
        hcu hcu;
        Number number;
        Object stepValueObject;
        if (!(specItem instanceof SpecProperty)) {
            return new hdj(String.valueOf(obj), "");
        }
        String O00000Oo = hfa.O00000Oo(device);
        SpecProperty specProperty = (SpecProperty) specItem;
        String unit = specProperty.getPropertyDefinition().getUnit();
        hez hez = null;
        if (!(specItem == null || specItem.getParent() == null)) {
            String typeName = specItem.getParent().getTypeName();
            String description = specItem.getDefinition().getDescription();
            hcz instance = hcz.getInstance();
            if (TextUtils.isEmpty(unit)) {
                unit = description;
            } else {
                hez = instance.getUnitMap(O00000Oo + "_" + typeName + "_" + description + "_" + unit);
            }
            if (hez == null) {
                hez = instance.getUnitMap(O00000Oo + "_" + typeName + "_" + unit);
            }
            if (hez == null) {
                hez = instance.getUnitMap(typeName + "_" + unit);
            }
            if (hez == null) {
                hez = instance.getUnitMap(unit);
            }
            if (hez == null) {
                gsy.O000000o(6, "mijia-card", "CardItem.getSpecPropValueName notmatch:" + O00000Oo + "_" + typeName + "_" + description + "_" + unit);
            }
        }
        if (hez == null) {
            pair = fju.O000000o().O00000Oo(this.O00000oo.O00000oo.O00000o0);
            hcu = this.O00000oo.O00000oo;
        } else {
            pair = fju.O000000o().O00000Oo(hez.O00000Oo);
            hcu complexUnitMap = hcz.getInstance().getComplexUnitMap((String) pair.first);
            hcu = hez;
            if (complexUnitMap != null) {
                hcu = complexUnitMap;
            }
        }
        String str = (String) pair.first;
        if (obj == null || "null".equals(obj)) {
            return hcu.O000000o("", str);
        }
        Object call = ((fkv) pair.second).call(obj);
        if (call instanceof Number) {
            number = (Number) call;
        } else {
            String valueOf = String.valueOf(call);
            try {
                number = Double.valueOf(Double.parseDouble(valueOf));
            } catch (NumberFormatException e) {
                Log.e("mijia-card", "SpecCardType.formatValue", e);
                return hcu.O000000o(valueOf, str);
            }
        }
        String str2 = this.O00000oo.O00000oO;
        Locale O00000o0 = fdc.O000000o().O00000o0(CommonApplication.getAppContext());
        Locale locale = O00000o0 == null ? Locale.getDefault() : O00000o0;
        gsy.O000000o(6, "mijia-card", "SpecCardType.formatValue Locale:".concat(String.valueOf(O00000o0)));
        if (!TextUtils.isEmpty(str2)) {
            return hcu.O000000o(number, str, new hcu.O000000o(locale, str2) {
                /* class _m_j.$$Lambda$hej$bVXDkZLhzjVeWGucVp3I2nxb8XY */
                private final /* synthetic */ Locale f$0;
                private final /* synthetic */ String f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final String format(Number number) {
                    return String.format(this.f$0, this.f$1, Double.valueOf(number.doubleValue()));
                }
            });
        }
        ConstraintValue constraintValue = specProperty.getPropertyDefinition().getConstraintValue();
        NumberFormat numberInstance = NumberFormat.getNumberInstance(locale);
        numberInstance.setRoundingMode(RoundingMode.HALF_UP);
        if ((constraintValue instanceof ValueRange) && (stepValueObject = ((ValueRange) constraintValue).stepValueObject()) != null) {
            String[] split = stepValueObject.toString().split("\\.");
            if (split.length != 2 || hhc.O000000o((Object) split[1], 0) <= 0) {
                numberInstance.setMaximumFractionDigits(0);
            } else {
                int length = split[1].length();
                numberInstance.setMaximumFractionDigits(length);
                numberInstance.setMinimumFractionDigits(length);
            }
            return hcu.O000000o(number, str, new hcu.O000000o(numberInstance) {
                /* class _m_j.$$Lambda$hej$ZwxdzQsYwDMw_4s4XTM35mnlwRA */
                private final /* synthetic */ NumberFormat f$0;

                {
                    this.f$0 = r1;
                }

                public final String format(Number number) {
                    return this.f$0.format(number.doubleValue());
                }
            });
        } else if (!hhc.O000000o(specProperty.getPropertyDefinition().getFormatString())) {
            return hcu.O000000o(number, str, $$Lambda$dkX1RBB0OtgHvQKIncsoQBYCu7I.INSTANCE);
        } else {
            numberInstance.setMaximumFractionDigits(0);
            return hcu.O000000o(number, str, new hcu.O000000o(numberInstance) {
                /* class _m_j.$$Lambda$hej$bH4Fqu1DxDpPWIrjKpSlouxwbw */
                private final /* synthetic */ NumberFormat f$0;

                {
                    this.f$0 = r1;
                }

                public final String format(Number number) {
                    return this.f$0.format(number.doubleValue());
                }
            });
        }
    }

    public static String O000000o(Device device, Spec.SpecItem specItem, Object obj) {
        if (specItem == null || !(specItem instanceof SpecProperty)) {
            return String.valueOf(obj);
        }
        if (obj != null) {
            String valueName = hcz.getInstance().getValueName(device, specItem, hfa.O000000o((SpecProperty) specItem, obj), obj);
            if (!TextUtils.isEmpty(valueName)) {
                return valueName;
            }
        }
        return hcz.getInstance().getValueName(device, specItem, null, null);
    }

    public static String O000000o(Device device, Spec.SpecItem specItem, String str, State state) {
        return hfa.O000000o("CardItemspec_", device, specItem, str, state);
    }

    public static String O000000o(Device device, Spec.SpecItem specItem, Object obj, State state) {
        String O000000o2;
        if (!(specItem instanceof SpecProperty)) {
            return new StringBuilder("res://drawable/2132083142").toString();
        }
        if (state == null) {
            state = State.NOR;
        }
        String O000000o3 = hfa.O000000o((SpecProperty) specItem, obj);
        if (TextUtils.isEmpty(O000000o3)) {
            O000000o3 = specItem.getDefinition().getDescription();
            if (!hfa.O000000o(obj) && (O000000o2 = O000000o(device, specItem, "Not ".concat(String.valueOf(O000000o3)), state)) != null) {
                return O000000o2;
            }
        }
        String O000000o4 = O000000o(device, specItem, O000000o3, state);
        if (O000000o4 != null) {
            return O000000o4;
        }
        try {
            return new StringBuilder("res://drawable/2132083143").toString();
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    public static String O00000Oo(Device device, Spec.SpecItem specItem, Object obj) {
        hee.O00000Oo O00000o0 = O00000o0(device, specItem, obj);
        if (O00000o0 == null) {
            return null;
        }
        return O00000o0.O00000oo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    private static hee.O00000Oo O00000o0(Device device, Spec.SpecItem specItem, Object obj) {
        List<hee.O00000Oo> list;
        if ((specItem instanceof SpecProperty) && specItem.getParent() != null) {
            String typeName = specItem.getParent().getTypeName();
            String description = specItem.getDefinition().getDescription();
            String O00000Oo = hfa.O00000Oo(device);
            hcz instance = hcz.getInstance();
            String O000000o2 = hfa.O000000o((SpecProperty) specItem, obj);
            if (TextUtils.isEmpty(O000000o2)) {
                list = null;
                O000000o2 = description;
            } else if (!O000000o2.equals(description)) {
                list = instance.getPropExtraMap(O00000Oo + "_" + typeName + "_" + description + "_" + O000000o2);
            } else {
                list = null;
            }
            if (list == null) {
                list = instance.getPropExtraMap(O00000Oo + "_" + typeName + "_" + O000000o2);
            }
            if (list == null) {
                list = instance.getPropExtraMap(typeName + "_" + O000000o2);
            }
            if (list == null) {
                list = instance.getPropExtraMap(O000000o2);
            }
            if (list == null) {
                gsy.O00000Oo("mijia-card", "model:" + device.model + " getSpecPropTextColor not match " + O00000Oo + "_" + typeName + "_" + description);
                return null;
            }
            for (hee.O00000Oo next : list) {
                if (next.f18837O000000o == null) {
                    double O000000o3 = hhc.O000000o(obj, -1.0d);
                    if (O000000o3 >= next.O00000o0 && O000000o3 <= next.O00000o) {
                        return next;
                    }
                } else {
                    if (String.valueOf(next.f18837O000000o).equals(String.valueOf(obj))) {
                    }
                    return next;
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    public static Object O00000Oo(Device device, Spec.SpecItem specItem) {
        if (!(specItem instanceof SpecProperty)) {
            return "";
        }
        Object O00000o0 = O00000o0(device, specItem);
        SpecProperty specProperty = (SpecProperty) specItem;
        ConstraintValue constraintValue = specProperty.getPropertyDefinition().getConstraintValue();
        if (O00000o0 != null && !"".equals(O00000o0)) {
            if (constraintValue instanceof ValueList) {
                List<ValueDefinition> values = ((ValueList) constraintValue).values();
                if (values != null && values.size() > 1) {
                    int i = 0;
                    while (i < values.size()) {
                        ValueDefinition valueDefinition = values.get(i);
                        if (!O00000o0.equals(valueDefinition.valueObject()) && !String.valueOf(O00000o0).equals(String.valueOf(valueDefinition.valueObject()))) {
                            i++;
                        } else if (i == 0) {
                            return values.get(1).valueObject();
                        } else {
                            return values.get(0).valueObject();
                        }
                    }
                }
            } else if (constraintValue instanceof ValueRange) {
                ValueRange valueRange = (ValueRange) constraintValue;
                Object minValueObject = valueRange.minValueObject();
                return (O00000o0.equals(minValueObject) || String.valueOf(O00000o0).equals(String.valueOf(minValueObject))) ? valueRange.maxValueObject() : minValueObject;
            }
        }
        if (O00000o0 == null) {
            if ("bool".equalsIgnoreCase(specProperty.getFormatString())) {
                return Boolean.TRUE;
            }
            return 1;
        } else if (Boolean.TRUE.equals(O00000o0)) {
            return Boolean.FALSE;
        } else {
            if (Boolean.FALSE.equals(O00000o0)) {
                return Boolean.TRUE;
            }
            if (hhc.O000000o(O00000o0, 0.0d) > 0.0d) {
                return 0;
            }
            return 1;
        }
    }

    public static Object O00000o0(Device device, Spec.SpecItem specItem) {
        return hcz.getInstance().getPropValue(device.did, specItem);
    }

    public final boolean O000000o(Device device, hdb hdb) {
        boolean z;
        if (this.O00000o == null || this.O00000o.size() == 0) {
            return true;
        }
        if (hdb == null) {
            hdb = (hdb) this.O00000o.get(0);
        }
        if (hdb == null) {
            return true;
        }
        List<Pair<String, Object>> list = hdb.O00000oo;
        List<Pair<String, Object>> list2 = hdb.O0000O0o;
        if (list == null && list2 == null) {
            return true;
        }
        Map<String, ArrayList<Spec.SpecItem>> map = null;
        if (list != null) {
            map = fax.O000000o(hcz.getInstance().getSpecInstance(device));
            for (Pair next : list) {
                Object obj = next.second;
                Object O000000o2 = O000000o(device, map.get(next.first));
                gsy.O00000Oo("mijia-card", "isEnable spec prop:" + ((String) next.first) + " current desc:" + O000000o2 + ", enable desc:" + obj);
                if (String.valueOf(obj).equalsIgnoreCase(String.valueOf(O000000o2)) || ((obj instanceof Boolean) && String.valueOf(((Boolean) obj).booleanValue() ? 1 : 0).equalsIgnoreCase(String.valueOf(O000000o2)))) {
                    return true;
                }
            }
            z = false;
        } else {
            z = true;
        }
        if (list2 == null) {
            return z;
        }
        if (map == null) {
            map = fax.O000000o(hcz.getInstance().getSpecInstance(device));
        }
        for (Pair next2 : list2) {
            Object obj2 = next2.second;
            Object O000000o3 = O000000o(device, map.get(next2.first));
            gsy.O00000Oo("mijia-card", "isEnable spec prop:" + ((String) next2.first) + " current desc:" + O000000o3 + ", disable desc:" + obj2);
            if (String.valueOf(obj2).equalsIgnoreCase(String.valueOf(O000000o3)) || ((obj2 instanceof Boolean) && String.valueOf(((Boolean) obj2).booleanValue() ? 1 : 0).equalsIgnoreCase(String.valueOf(O000000o3)))) {
                return false;
            }
        }
        return true;
    }

    private static Object O000000o(Device device, ArrayList<Spec.SpecItem> arrayList) {
        String str = null;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        Spec.SpecItem specItem = arrayList.get(0);
        Object O00000o0 = O00000o0(device, specItem);
        if (specItem instanceof SpecProperty) {
            str = hfa.O000000o((SpecProperty) specItem, O00000o0);
        }
        return (str == null || "".equals(str)) ? O00000o0 : str;
    }
}
