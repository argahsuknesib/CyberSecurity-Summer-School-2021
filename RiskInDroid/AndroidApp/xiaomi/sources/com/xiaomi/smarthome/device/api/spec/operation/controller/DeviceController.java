package com.xiaomi.smarthome.device.api.spec.operation.controller;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.ActionParam;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyListener;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceController extends SpecDevice {
    private static Map<String, DeviceController> mControllerCache = new HashMap();
    private String did;

    public DeviceController(String str, String str2, String str3, List<ServiceController> list) {
        super(str2, str3);
        this.did = str;
        for (ServiceController next : list) {
            getServices().put(Integer.valueOf(next.getIid()), next);
        }
    }

    public static DeviceController getDeviceController(String str) {
        if (mControllerCache.get(str) != null) {
            return mControllerCache.get(str);
        }
        DeviceController specDeviceController = XmPluginHostApi.instance().getSpecDeviceController(str);
        if (specDeviceController == null) {
            return new DeviceController(str, "", "", new ArrayList());
        }
        mControllerCache.put(str, specDeviceController);
        return specDeviceController;
    }

    public void getSpecProperties(Context context, List<PropertyParam> list, final Callback<List<PropertyParam>> callback) {
        XmPluginHostApi.instance().getPropertyValues(context, list, new Callback<List<PropertyParam>>() {
            /* class com.xiaomi.smarthome.device.api.spec.operation.controller.DeviceController.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<PropertyParam>) ((List) obj));
            }

            public void onSuccess(List<PropertyParam> list) {
                DeviceController.this.updateValue(list);
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(list);
                }
            }

            public void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        });
    }

    public void updateValue(List<PropertyParam> list) {
        if (list != null) {
            for (PropertyParam next : list) {
                ServiceController serviceController = (ServiceController) getServices().get(Integer.valueOf(next.getSiid()));
                if (serviceController != null) {
                    serviceController.updateValue(next, false);
                }
            }
        }
    }

    public void setSpecProperty(Context context, PropertyParam propertyParam, Callback<Object> callback) {
        ServiceController serviceController;
        if (propertyParam != null && (serviceController = (ServiceController) getServices().get(Integer.valueOf(propertyParam.getSiid()))) != null) {
            serviceController.setSpecProperty(context, propertyParam, callback);
        }
    }

    public void doAction(Context context, ActionParam actionParam, Callback<List<Object>> callback) {
        ServiceController serviceController;
        if (actionParam != null && (serviceController = (ServiceController) getServices().get(Integer.valueOf(actionParam.getSiid()))) != null) {
            serviceController.doAction(context, actionParam, callback);
        }
    }

    public ServiceController getServiceController(int i) {
        return (ServiceController) getServices().get(Integer.valueOf(i));
    }

    public PropertyController getPropertyController(int i, int i2) {
        ServiceController serviceController = getServiceController(i);
        if (serviceController != null) {
            return (PropertyController) serviceController.getProperties().get(Integer.valueOf(i2));
        }
        return null;
    }

    public Object getPropertyValue(int i, int i2) {
        PropertyController propertyController = getPropertyController(i, i2);
        if (propertyController != null) {
            return propertyController.getValue();
        }
        return null;
    }

    public ActionController getActionController(int i, int i2) {
        ServiceController serviceController = getServiceController(i);
        if (serviceController != null) {
            return (ActionController) serviceController.getActions().get(Integer.valueOf(i2));
        }
        return null;
    }

    public PropertyParam newPropertyParam(int i, int i2) {
        return newPropertyParam(i, i2, null);
    }

    public PropertyParam newPropertyParam(int i, int i2, Object obj) {
        PropertyController propertyController;
        ServiceController serviceController = (ServiceController) getServices().get(Integer.valueOf(i));
        if (serviceController == null || (propertyController = (PropertyController) serviceController.getProperties().get(Integer.valueOf(i2))) == null) {
            return null;
        }
        return propertyController.getParamObj(this.did, i, i2, obj);
    }

    public ActionParam newActionParam(int i, int i2, List<Object> list) {
        ActionController actionController;
        ServiceController serviceController = (ServiceController) getServices().get(Integer.valueOf(i));
        if (serviceController == null || (actionController = (ActionController) serviceController.getActions().get(Integer.valueOf(i2))) == null) {
            return null;
        }
        return actionController.getParamObj(this.did, i, i2, list);
    }

    public void subscribeProperty(DeviceStat deviceStat, List<PropertyParam> list, Callback<Void> callback) {
        ArrayList arrayList = new ArrayList();
        for (PropertyParam next : list) {
            arrayList.add("prop." + next.getSiid() + "." + next.getPiid());
        }
        XmPluginHostApi.instance().subscribeDevice(deviceStat.did, deviceStat.pid, arrayList, 3, callback);
    }

    public void unSubscribeProperty(DeviceStat deviceStat, List<PropertyParam> list, Callback<Void> callback) {
        ArrayList arrayList = new ArrayList();
        for (PropertyParam next : list) {
            arrayList.add("prop." + next.getSiid() + "." + next.getPiid());
        }
        XmPluginHostApi.instance().unsubscribeDevice(deviceStat.did, deviceStat.pid, arrayList, callback);
    }

    public void onSubscribeData(String str) {
        PropertyController propertyController;
        JSONArray optJSONArray;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String[] split = optJSONObject.optString("key").split("\\.");
                    if (!(split.length < 3 || (propertyController = getPropertyController(Integer.valueOf(split[1]).intValue(), Integer.valueOf(split[2]).intValue())) == null || (optJSONArray = optJSONObject.optJSONArray("value")) == null || optJSONArray.length() == 0)) {
                        PropertyParam newPropertyParam = newPropertyParam(Integer.valueOf(split[1]).intValue(), Integer.valueOf(split[2]).intValue(), optJSONArray.opt(0));
                        newPropertyParam.setResultCode(0);
                        propertyController.updateValue(newPropertyParam, true);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void setPropertyListener(int i, int i2, PropertyListener propertyListener) {
        PropertyController propertyController = getPropertyController(i, i2);
        if (propertyController != null) {
            propertyController.setListener(propertyListener);
        }
    }

    public void removePropertyListener(int i, int i2) {
        PropertyController propertyController = getPropertyController(i, i2);
        if (propertyController != null) {
            propertyController.removeListener();
        }
    }

    public void removeAllListener() {
        Map<Integer, SpecService> services = getServices();
        if (services != null) {
            for (SpecService properties : services.values()) {
                Map<Integer, SpecProperty> properties2 = properties.getProperties();
                if (properties2 != null) {
                    Iterator<SpecProperty> it = properties2.values().iterator();
                    while (it.hasNext()) {
                        ((PropertyController) it.next()).removeListener();
                    }
                }
            }
        }
    }

    public Pair<Integer, Integer> getPropertyIid(String str) {
        for (SpecService next : getServices().values()) {
            Iterator<SpecProperty> it = next.getProperties().values().iterator();
            while (true) {
                if (it.hasNext()) {
                    SpecProperty next2 = it.next();
                    String type = next2.getPropertyDefinition().getType();
                    if (!TextUtils.isEmpty(type)) {
                        String[] split = type.split(":");
                        if (split.length > 4 && split[3].equals(str)) {
                            return new Pair<>(Integer.valueOf(next.getIid()), Integer.valueOf(next2.getIid()));
                        }
                    }
                }
            }
        }
        return null;
    }

    public Pair<Integer, Integer> getActionIid(String str) {
        for (SpecService next : getServices().values()) {
            Iterator<SpecAction> it = next.getActions().values().iterator();
            while (true) {
                if (it.hasNext()) {
                    SpecAction next2 = it.next();
                    String type = next2.getActionDefinition().getType();
                    if (!TextUtils.isEmpty(type)) {
                        String[] split = type.split(":");
                        if (split.length > 4 && split[3].equals(str)) {
                            return new Pair<>(Integer.valueOf(next.getIid()), Integer.valueOf(next2.getIid()));
                        }
                    }
                }
            }
        }
        return null;
    }
}
