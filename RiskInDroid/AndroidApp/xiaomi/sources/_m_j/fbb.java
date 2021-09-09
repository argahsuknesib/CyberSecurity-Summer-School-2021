package _m_j;

import android.util.Pair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import java.util.Map;
import org.json.JSONObject;

public interface fbb extends gze {
    Pair<SpecService, SpecProperty> checkSupportPower(Device device);

    void destroy();

    String getCardIconPath(String str);

    Spec.SpecItem[] getGridCardProperty(Device device, int i);

    Object getPropValue(String str, String str2);

    Map<String, hdi> getPropsMap(String str);

    SpecDevice getSpecInstance(Device device);

    String getSpecInstanceStr(String str);

    String getSpecProptyValueStr(String str);

    String getValueName(Device device, Spec.SpecItem specItem, String str, Object obj);

    void isReady(Runnable runnable);

    Object notifyPropChangedListener(String str, String str2, Object obj, long j, byte b);

    void registerStateChangedListener(hda hda);

    Map<String, hdi> removePropMap(String str);

    void setDeviceProp(String str, SpecProperty specProperty, Object obj, fsm<JSONObject, fso> fsm);

    void unregisterStateChangedListener(hda hda);
}
