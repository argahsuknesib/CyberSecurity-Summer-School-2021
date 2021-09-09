package _m_j;

import android.util.Pair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class fbk implements fbb {
    public final Pair<SpecService, SpecProperty> checkSupportPower(Device device) {
        return null;
    }

    public final void destroy() {
    }

    public final String getCardIconPath(String str) {
        return null;
    }

    public final Object getPropValue(String str, String str2) {
        return null;
    }

    public final SpecDevice getSpecInstance(Device device) {
        return null;
    }

    public final String getSpecInstanceStr(String str) {
        return null;
    }

    public final String getSpecProptyValueStr(String str) {
        return null;
    }

    public final String getValueName(Device device, Spec.SpecItem specItem, String str, Object obj) {
        return null;
    }

    public final void isReady(Runnable runnable) {
    }

    public final Object notifyPropChangedListener(String str, String str2, Object obj, long j, byte b) {
        return null;
    }

    public final void registerStateChangedListener(hda hda) {
    }

    public final void setDeviceProp(String str, SpecProperty specProperty, Object obj, fsm<JSONObject, fso> fsm) {
    }

    public final void unregisterStateChangedListener(hda hda) {
    }

    public final Map<String, hdi> removePropMap(String str) {
        return new HashMap();
    }

    public final Spec.SpecItem[] getGridCardProperty(Device device, int i) {
        return new Spec.SpecItem[0];
    }

    public final Map<String, hdi> getPropsMap(String str) {
        return new HashMap();
    }
}
