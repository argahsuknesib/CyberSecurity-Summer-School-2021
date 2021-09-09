package com.xiaomi.smarthome.device.api.spec.operation.controller;

import android.content.Context;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.spec.definitions.PropertyDefinition;
import com.xiaomi.smarthome.device.api.spec.definitions.data.DataValue;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyListener;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;

@Deprecated
public class PropertyController extends SpecProperty {
    private PropertyListener mListener;

    public PropertyController(int i, PropertyDefinition propertyDefinition) {
        super(i, propertyDefinition);
    }

    public void updateValue(PropertyParam propertyParam, boolean z) {
        PropertyListener propertyListener;
        if (propertyParam.getResultCode() == 0 && setValue(propertyParam.getValue()) && z && (propertyListener = this.mListener) != null) {
            propertyListener.onDataChanged(propertyParam.getValue());
        }
    }

    public void setSpecProperty(Context context, PropertyParam propertyParam, final Callback<Object> callback) {
        if (!validateParam(propertyParam.getValue()) && callback != null) {
            callback.onFailure(-1, "set value wrong type");
        }
        XmPluginHostApi.instance().setPropertyValue(context, propertyParam, new Callback<PropertyParam>() {
            /* class com.xiaomi.smarthome.device.api.spec.operation.controller.PropertyController.AnonymousClass1 */

            public void onSuccess(PropertyParam propertyParam) {
                if (PropertyController.this.setValue(propertyParam.getValue())) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(propertyParam.getValue());
                        return;
                    }
                    return;
                }
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onFailure(-1, "set value failed");
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

    private boolean validateParam(Object obj) {
        DataValue createValue = getPropertyDefinition().getFormat().createValue(obj);
        if (createValue != null && getPropertyDefinition().validate(createValue)) {
            return true;
        }
        return false;
    }

    public PropertyParam getParamObj(String str, int i, int i2, Object obj) {
        return new PropertyParam(str, i, i2).setValue(obj);
    }

    public void setListener(PropertyListener propertyListener) {
        this.mListener = propertyListener;
    }

    public void removeListener() {
        this.mListener = null;
    }
}
