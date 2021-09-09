package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public interface hdg<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> {
    void getProfilePropsFromServer(boolean z, Device device, JSONArray jSONArray, fsm<Object, fso> fsm, String str);

    void getSpecPropsFromServer(boolean z, Device device, List<PropertyParam> list, fsm<List<PropertyParam>, fso> fsm);

    void sendRequest(E e, hdb hdb, Device device, T t, Object obj, fsm<JSONObject, fso> fsm);
}
