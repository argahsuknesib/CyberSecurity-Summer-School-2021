package com.xiaomi.smarthome.device.api.spec.operation.controller;

import android.content.Context;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.ActionParam;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import java.util.List;

public class ServiceController extends SpecService {
    public ServiceController(int i, String str, String str2, String str3, List<PropertyController> list, List<ActionController> list2) {
        super(i, str, str2, str3);
        for (PropertyController next : list) {
            getProperties().put(Integer.valueOf(next.getIid()), next);
        }
        for (ActionController next2 : list2) {
            getActions().put(Integer.valueOf(next2.getIid()), next2);
        }
    }

    public void updateValue(PropertyParam propertyParam, boolean z) {
        PropertyController propertyController = (PropertyController) getProperties().get(Integer.valueOf(propertyParam.getPiid()));
        if (propertyController != null) {
            propertyController.updateValue(propertyParam, z);
        }
    }

    public void setSpecProperty(Context context, PropertyParam propertyParam, Callback<Object> callback) {
        PropertyController propertyController = (PropertyController) getProperties().get(Integer.valueOf(propertyParam.getPiid()));
        if (propertyController != null) {
            propertyController.setSpecProperty(context, propertyParam, callback);
        }
    }

    public void doAction(Context context, ActionParam actionParam, Callback<List<Object>> callback) {
        ActionController actionController = (ActionController) getActions().get(Integer.valueOf(actionParam.getAiid()));
        if (actionController != null) {
            actionController.doAction(context, actionParam, callback);
        }
    }
}
