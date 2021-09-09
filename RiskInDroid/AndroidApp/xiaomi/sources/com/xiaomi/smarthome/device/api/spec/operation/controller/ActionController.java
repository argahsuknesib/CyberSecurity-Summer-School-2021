package com.xiaomi.smarthome.device.api.spec.operation.controller;

import android.content.Context;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.spec.definitions.ActionDefinition;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.operation.ActionParam;
import java.util.List;

public class ActionController extends SpecAction {
    public ActionController(int i, ActionDefinition actionDefinition) {
        super(i, actionDefinition);
    }

    public void doAction(Context context, ActionParam actionParam, final Callback<List<Object>> callback) {
        XmPluginHostApi.instance().doAction(context, actionParam, new Callback<ActionParam>() {
            /* class com.xiaomi.smarthome.device.api.spec.operation.controller.ActionController.AnonymousClass1 */

            public void onSuccess(ActionParam actionParam) {
                ActionController.this.setOut(actionParam.getOut());
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(actionParam.getOut());
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

    public ActionParam getParamObj(String str, int i, int i2, List<Object> list) {
        return new ActionParam(str, i, i2, list);
    }
}
