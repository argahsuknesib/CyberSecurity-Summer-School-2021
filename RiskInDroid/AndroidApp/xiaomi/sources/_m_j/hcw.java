package _m_j;

import android.content.ComponentName;
import android.content.Context;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.controls.MiControlsProviderService;
import com.xiaomi.smarthome.device.api.spec.operation.ActionParam;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.newui.card.DeviceCardApi;
import java.util.List;
import org.json.JSONArray;

@RouterService
public class hcw implements fay {
    private static hcw instance = new hcw();

    @cug
    public static hcw provideInstance() {
        gsy.O000000o(4, "mijia-card", "provideInstance DeviceCardApiInternal:" + instance);
        return instance;
    }

    public void setDeviceSpecProp(Context context, PropertyParam propertyParam, fsm<PropertyParam, fso> fsm) {
        DeviceCardApi.SpecPropertyApi.instance.setDeviceSpecProp(context, propertyParam, fsm);
    }

    public void setDeviceSpecAction(Context context, ActionParam actionParam, fsm<ActionParam, fso> fsm) {
        DeviceCardApi.SpecActionApi.instance.setDeviceSpecAction(context, actionParam, fsm);
    }

    public void getDeviceProfileProp(Context context, JSONArray jSONArray, fsm<String, fso> fsm, String str) {
        DeviceCardApi.O000000o(context, jSONArray, fsm, str);
    }

    public void initMiControlsProviderService(Context context) {
        exz exz = exz.f15941O000000o;
        if (exz.O00000Oo()) {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, MiControlsProviderService.class), 1, 1);
            gsy.O000000o(4, "SHApplication", "setComponentEnabledSetting MiControlsProviderService true");
            return;
        }
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, MiControlsProviderService.class), 2, 1);
        gsy.O000000o(4, "SHApplication", "setComponentEnabledSetting MiControlsProviderService false");
    }

    public fsn getDeviceSpecProp(Context context, List<PropertyParam> list, fsm<List<PropertyParam>, fso> fsm) {
        return DeviceCardApi.O000000o(context, list, 2, fsm);
    }
}
