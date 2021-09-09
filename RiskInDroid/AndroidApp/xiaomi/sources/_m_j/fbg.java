package _m_j;

import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public interface fbg extends gze {
    <T> void callMethod(String str, String str2, Callback<T> callback, Parser<T> parser);

    frb createDevicePropSubscriber();

    void dataReadyRefresh();

    int generateNonce();

    Map<String, Device> getAllDevices();

    Device getDeviceByDid(String str);

    boolean isPluginNotRelease(String str);

    void operateCardStat(Device device);

    void registerDeviceRefreshListener(fbf fbf);

    void report_spec_result(long j, String str, boolean z, int i, List<String> list, String str2, String str3);

    fsn rpcAsync(String str, String str2, String str3, fsm<JSONObject, fso> fsm);
}
