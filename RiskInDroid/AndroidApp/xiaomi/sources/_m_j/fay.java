package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.device.api.spec.operation.ActionParam;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import java.util.List;
import org.json.JSONArray;

public interface fay extends gze {
    void getDeviceProfileProp(Context context, JSONArray jSONArray, fsm<String, fso> fsm, String str);

    fsn getDeviceSpecProp(Context context, List<PropertyParam> list, fsm<List<PropertyParam>, fso> fsm);

    void initMiControlsProviderService(Context context);

    void setDeviceSpecAction(Context context, ActionParam actionParam, fsm<ActionParam, fso> fsm);

    void setDeviceSpecProp(Context context, PropertyParam propertyParam, fsm<PropertyParam, fso> fsm);
}
