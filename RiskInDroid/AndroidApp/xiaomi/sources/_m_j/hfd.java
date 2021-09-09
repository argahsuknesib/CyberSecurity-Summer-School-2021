package _m_j;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.device.api.spec.definitions.EventDefinition;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueDefinition;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueList;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueRange;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecEvent;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hfd {
    public static SpecDevice O000000o(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap;
        String O000000o2 = fli.O000000o(jSONObject.remove("description"));
        String O000000o3 = fli.O000000o(jSONObject.remove("type"));
        String O000000o4 = fli.O000000o(jSONObject.remove("name"));
        int O000000o5 = fli.O000000o(jSONObject.remove("iid"), 0);
        String O000000o6 = fli.O000000o(jSONObject.remove("protocol-version"));
        String O000000o7 = fli.O000000o(jSONObject.remove("class"));
        int O000000o8 = fli.O000000o(jSONObject.remove("dynamic"), Integer.MIN_VALUE);
        JSONArray O00000Oo = fli.O00000Oo(jSONObject.remove("modules"));
        if (O00000Oo != null) {
            linkedHashMap = new LinkedHashMap(0, 0.75f, false);
            for (int i = 0; i < O00000Oo.length(); i++) {
                SpecDevice O000000o9 = O000000o(O00000Oo.optJSONObject(i));
                linkedHashMap.put(Integer.valueOf(O000000o9.getIid()), O000000o9);
            }
        } else {
            linkedHashMap = null;
        }
        Map<Integer, SpecService> O000000o10 = hfg.O000000o(fli.O00000Oo(jSONObject.remove("services")));
        if (jSONObject.length() == 0) {
            jSONObject = null;
        }
        return new SpecDevice(O000000o5, O000000o3, O000000o4, O000000o2, O000000o6, O000000o7, O000000o8, O000000o10, linkedHashMap, jSONObject);
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x01cb A[Catch:{ JSONException -> 0x02eb }, LOOP:3: B:60:0x01c5->B:62:0x01cb, LOOP_END] */
    public static JSONObject O000000o(SpecDevice specDevice) {
        JSONObject jSONObject;
        String str;
        Iterator<Map.Entry<Integer, SpecService>> it;
        Map<Integer, SpecAction> actions;
        Map<Integer, SpecEvent> events;
        String str2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject2;
        Iterator<Map.Entry<Integer, SpecProperty>> it2;
        String str3 = "name";
        JSONObject jSONObject3 = null;
        if (specDevice == null) {
            return null;
        }
        JSONObject jSONObject4 = specDevice.getRefExtra() == null ? new JSONObject() : specDevice.getRefExtra();
        try {
            int iid = specDevice.getIid();
            if (iid != 0) {
                jSONObject4.put("iid", iid);
            }
            jSONObject4.put("type", specDevice.getType());
            jSONObject4.put("description", specDevice.getDescription());
            jSONObject4.put(str3, specDevice.getName());
            jSONObject4.put("protocol-version", specDevice.getVersionSpec());
            jSONObject4.put("class", specDevice.getClassSpec());
            int dynamic = specDevice.getDynamic();
            if (dynamic != Integer.MIN_VALUE) {
                jSONObject4.put("dynamic", dynamic);
            }
            Map<Integer, SpecService> services = specDevice.getServices();
            if (services != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<Map.Entry<Integer, SpecService>> it3 = services.entrySet().iterator();
                while (it3.hasNext()) {
                    SpecService specService = (SpecService) it3.next().getValue();
                    if (specService == null) {
                        str = str3;
                        jSONObject = jSONObject4;
                        it = it3;
                    } else {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("iid", specService.getIid());
                        jSONObject5.put("type", specService.getType());
                        jSONObject5.put(str3, specService.getName());
                        jSONObject5.put("description", specService.getDesc());
                        Map<Integer, SpecProperty> properties = specService.getProperties();
                        if (properties != null) {
                            if (properties.size() > 0) {
                                JSONArray jSONArray4 = new JSONArray();
                                Iterator<Map.Entry<Integer, SpecProperty>> it4 = properties.entrySet().iterator();
                                while (it4.hasNext()) {
                                    SpecProperty specProperty = (SpecProperty) it4.next().getValue();
                                    JSONObject jSONObject6 = new JSONObject();
                                    jSONObject6.put("type", specProperty.getType());
                                    jSONObject6.put(str3, specProperty.getName());
                                    jSONObject6.put("description", specProperty.getDescription());
                                    jSONObject6.put("format", specProperty.getFormatString());
                                    Iterator<Map.Entry<Integer, SpecService>> it5 = it3;
                                    jSONObject6.put("access", new JSONArray((Collection<?>) specProperty.access().toList()));
                                    ConstraintValue constraintValue = specProperty.getConstraintValue();
                                    if (constraintValue == null) {
                                        jSONObject2 = jSONObject4;
                                        it2 = it4;
                                    } else if (constraintValue instanceof ValueList) {
                                        JSONArray jSONArray5 = new JSONArray();
                                        Iterator<ValueDefinition> it6 = ((ValueList) constraintValue).values().iterator();
                                        while (it6.hasNext()) {
                                            ValueDefinition next = it6.next();
                                            Iterator<ValueDefinition> it7 = it6;
                                            JSONObject jSONObject7 = new JSONObject();
                                            Iterator<Map.Entry<Integer, SpecProperty>> it8 = it4;
                                            jSONObject = jSONObject4;
                                            try {
                                                jSONObject7.put("value", next.valueObject());
                                                jSONObject7.put("description", next.description());
                                                jSONArray5.put(jSONObject7);
                                                it6 = it7;
                                                it4 = it8;
                                                jSONObject4 = jSONObject;
                                            } catch (JSONException e) {
                                                e = e;
                                                jSONObject4 = jSONObject;
                                                Log.e("SpecDeviceCodec", "toJSONObject", e);
                                                return jSONObject4;
                                            }
                                        }
                                        jSONObject2 = jSONObject4;
                                        it2 = it4;
                                        jSONObject6.put("value-list", jSONArray5);
                                    } else {
                                        jSONObject2 = jSONObject4;
                                        it2 = it4;
                                        if (constraintValue instanceof ValueRange) {
                                            jSONObject6.put("value-range", new JSONArray((Collection<?>) ((ValueRange) constraintValue).toList()));
                                        }
                                    }
                                    String unit = specProperty.getUnit();
                                    if (!TextUtils.isEmpty(unit)) {
                                        jSONObject6.put("unit", unit);
                                    }
                                    jSONObject6.put("iid", specProperty.getIid());
                                    jSONArray4.put(jSONObject6);
                                    it3 = it5;
                                    it4 = it2;
                                    jSONObject4 = jSONObject2;
                                }
                                jSONObject = jSONObject4;
                                it = it3;
                                jSONObject5.put("properties", jSONArray4);
                                actions = specService.getActions();
                                if (actions != null && actions.size() > 0) {
                                    JSONArray jSONArray6 = new JSONArray();
                                    for (Map.Entry<Integer, SpecAction> value : actions.entrySet()) {
                                        SpecAction specAction = (SpecAction) value.getValue();
                                        JSONObject jSONObject8 = new JSONObject();
                                        jSONObject8.put("type", specAction.getType());
                                        jSONObject8.put(str3, specAction.getName());
                                        jSONObject8.put("description", specAction.getDescription());
                                        jSONObject8.put("in", new JSONArray((Collection<?>) specAction.getIn()));
                                        jSONObject8.put("out", new JSONArray((Collection<?>) specAction.getOut()));
                                        jSONObject8.put("iid", specAction.getIid());
                                        jSONArray6.put(jSONObject8);
                                    }
                                    jSONObject5.put("actions", jSONArray6);
                                }
                                events = specService.getEvents();
                                if (events != null || events.size() <= 0) {
                                    str = str3;
                                } else {
                                    JSONArray jSONArray7 = new JSONArray();
                                    for (Map.Entry<Integer, SpecEvent> value2 : events.entrySet()) {
                                        SpecEvent specEvent = (SpecEvent) value2.getValue();
                                        JSONObject jSONObject9 = new JSONObject();
                                        jSONObject9.put("type", specEvent.getType());
                                        jSONObject9.put(str3, specEvent.getName());
                                        jSONObject9.put("description", specEvent.getDescription());
                                        jSONObject9.put("iid", specEvent.getIid());
                                        EventDefinition.SpecArguments[] argumentsV3 = specEvent.getArgumentsV3();
                                        if (argumentsV3 == null) {
                                            str2 = str3;
                                            jSONArray = null;
                                        } else {
                                            jSONArray = new JSONArray();
                                            int length = argumentsV3.length;
                                            int i = 0;
                                            while (i < length) {
                                                EventDefinition.SpecArguments specArguments = argumentsV3[i];
                                                JSONObject jSONObject10 = new JSONObject();
                                                jSONObject10.put("format", specArguments.getFormat());
                                                jSONObject10.put("description", specArguments.getDescription());
                                                jSONArray.put(jSONObject10);
                                                i++;
                                                str3 = str3;
                                            }
                                            str2 = str3;
                                        }
                                        long[] arguments = specEvent.getArguments();
                                        if (arguments == null) {
                                            jSONArray2 = null;
                                        } else {
                                            jSONArray2 = new JSONArray();
                                            for (long put : arguments) {
                                                jSONArray2.put(put);
                                            }
                                        }
                                        if (jSONArray != null) {
                                            jSONObject9.put("arguments", jSONArray);
                                        } else if (jSONArray2 != null) {
                                            jSONObject9.put("arguments", jSONArray2);
                                        }
                                        jSONArray7.put(jSONObject9);
                                        str3 = str2;
                                    }
                                    str = str3;
                                    jSONObject5.put("events", jSONArray7);
                                }
                                jSONObject3 = jSONObject5;
                            }
                        }
                        jSONObject = jSONObject4;
                        it = it3;
                        actions = specService.getActions();
                        JSONArray jSONArray62 = new JSONArray();
                        while (r3.hasNext()) {
                        }
                        jSONObject5.put("actions", jSONArray62);
                        events = specService.getEvents();
                        if (events != null) {
                        }
                        str = str3;
                        jSONObject3 = jSONObject5;
                    }
                    if (jSONObject3 != null) {
                        jSONArray3.put(jSONObject3);
                    }
                    it3 = it;
                    str3 = str;
                    jSONObject4 = jSONObject;
                    jSONObject3 = null;
                }
                JSONObject jSONObject11 = jSONObject4;
                jSONObject4.put("services", jSONArray3);
            }
            Map<Integer, SpecDevice> devices = specDevice.getDevices();
            if (devices != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (Map.Entry<Integer, SpecDevice> value3 : devices.entrySet()) {
                    JSONObject O000000o2 = O000000o((SpecDevice) value3.getValue());
                    if (O000000o2 != null) {
                        jSONArray8.put(O000000o2);
                    }
                }
                jSONObject4.put("modules", jSONArray8);
            }
        } catch (JSONException e2) {
            e = e2;
            Log.e("SpecDeviceCodec", "toJSONObject", e);
            return jSONObject4;
        }
        return jSONObject4;
    }
}
