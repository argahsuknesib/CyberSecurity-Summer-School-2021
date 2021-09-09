package _m_j;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.xiaomi.smarthome.device.api.spec.definitions.PropertyDefinition;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecEvent;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class fax {
    public static String O000000o(int i, int i2, int i3) {
        return O000000o("prop", i, i2, i3);
    }

    public static String O00000Oo(int i, int i2, int i3) {
        return O000000o("action", i, i2, i3);
    }

    private static String O00000o0(int i, int i2, int i3) {
        return O000000o("event", i, i2, i3);
    }

    private static String O000000o(String str, int i, int i2, int i3) {
        if (i > 0) {
            return str + "." + i + "." + i2 + "." + i3;
        }
        return str + "." + i2 + "." + i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045 A[ADDED_TO_REGION] */
    public static String O000000o(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -1422950858) {
            if (hashCode != 97) {
                if (hashCode != 101) {
                    if (hashCode == 96891546 && str.equals("event")) {
                        c = 1;
                        if (c != 0 || c == 1) {
                            return "event";
                        }
                        return (c == 2 || c == 3) ? "action" : "prop";
                    }
                } else if (str.equals("e")) {
                    c = 0;
                    if (c != 0) {
                    }
                    return "event";
                }
            } else if (str.equals("a")) {
                c = 2;
                if (c != 0) {
                }
                return "event";
            }
        } else if (str.equals("action")) {
            c = 3;
            if (c != 0) {
            }
            return "event";
        }
        c = 65535;
        if (c != 0) {
        }
        return "event";
    }

    public static String O000000o(Spec.SpecItem specItem) {
        if (specItem instanceof SpecAction) {
            return O00000Oo(Spec.getIid(specItem, 2), Spec.getIid(specItem, 1), Spec.getIid(specItem, 0));
        }
        if (specItem instanceof SpecEvent) {
            return O00000o0(Spec.getIid(specItem, 2), Spec.getIid(specItem, 1), Spec.getIid(specItem, 0));
        }
        return O000000o(Spec.getIid(specItem, 2), Spec.getIid(specItem, 1), Spec.getIid(specItem, 0));
    }

    public static List<PropertyParam> O000000o(String str, int i, Spec.SpecItem[] specItemArr, List<PropertyParam> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (specItemArr != null) {
            for (Spec.SpecItem specItem : specItemArr) {
                if (specItem instanceof SpecProperty) {
                    SpecProperty specProperty = (SpecProperty) specItem;
                    PropertyDefinition propertyDefinition = specProperty.getPropertyDefinition();
                    if (propertyDefinition.readable() || propertyDefinition.notifiable()) {
                        list.add(new PropertyParam(str, specProperty, i));
                    }
                }
                gsy.O00000Oo("mijia-card", "transformParam did:" + str + " can not read servicePair:" + specItem);
            }
        }
        return list;
    }

    private static void O000000o(Map<String, ArrayList<Spec.SpecItem>> map, SpecService specService, Spec.SpecItem specItem) {
        String str;
        String str2 = null;
        if (specItem instanceof SpecProperty) {
            str2 = "p";
            str = "pi";
        } else if (specItem instanceof SpecAction) {
            str2 = "a";
            str = "ai";
        } else if (specItem instanceof SpecEvent) {
            str2 = "e";
            str = "ei";
        } else {
            str = null;
        }
        String str3 = str2 + ":" + specService.getTypeName() + ":" + specItem.getDefinition().getTypeName();
        ArrayList arrayList = map.get(str3);
        if (arrayList == null) {
            arrayList = new ArrayList(2);
            map.put(str3, arrayList);
        }
        arrayList.add(specItem);
        String str4 = str + ":" + specService.getIid() + ":" + specItem.getIid();
        ArrayList arrayList2 = map.get(str4);
        if (arrayList2 == null) {
            arrayList2 = new ArrayList(2);
            map.put(str4, arrayList2);
        }
        arrayList2.add(specItem);
    }

    public static Map<String, ArrayList<Spec.SpecItem>> O000000o(SpecDevice specDevice) {
        Map<Integer, SpecService> services;
        ArrayMap arrayMap = new ArrayMap();
        if (!(specDevice == null || (services = specDevice.getServices()) == null)) {
            for (Map.Entry<Integer, SpecService> value : services.entrySet()) {
                SpecService specService = (SpecService) value.getValue();
                if (specService != null && (TextUtils.isEmpty("miot-spec-v2") || "miot-spec-v2".equals(specService.getSchema()))) {
                    Map<Integer, SpecProperty> properties = specService.getProperties();
                    if (properties != null) {
                        for (Map.Entry<Integer, SpecProperty> value2 : properties.entrySet()) {
                            SpecProperty specProperty = (SpecProperty) value2.getValue();
                            if (specProperty != null && (TextUtils.isEmpty("miot-spec-v2") || "miot-spec-v2".equals(specProperty.getSchema()))) {
                                O000000o(arrayMap, specService, specProperty);
                            }
                        }
                    }
                    Map<Integer, SpecAction> actions = specService.getActions();
                    if (actions != null) {
                        for (Map.Entry<Integer, SpecAction> value3 : actions.entrySet()) {
                            SpecAction specAction = (SpecAction) value3.getValue();
                            if (specAction != null && (TextUtils.isEmpty("miot-spec-v2") || "miot-spec-v2".equals(specAction.getSchema()))) {
                                O000000o(arrayMap, specService, specAction);
                            }
                        }
                    }
                    Map<Integer, SpecEvent> events = specService.getEvents();
                    if (events != null) {
                        for (Map.Entry<Integer, SpecEvent> value4 : events.entrySet()) {
                            SpecEvent specEvent = (SpecEvent) value4.getValue();
                            if (specEvent != null && (TextUtils.isEmpty("miot-spec-v2") || "miot-spec-v2".equals(specEvent.getSchema()))) {
                                O000000o(arrayMap, specService, specEvent);
                            }
                        }
                    }
                }
            }
        }
        return arrayMap;
    }
}
