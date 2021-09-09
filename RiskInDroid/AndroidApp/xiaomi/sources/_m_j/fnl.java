package _m_j;

import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.KeyValuePair;
import com.xiaomi.smarthome.frame.plugin.host.PluginUPnPHostApi;
import java.util.List;

public final class fnl extends PluginUPnPHostApi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Byte[] f16697O000000o = new Byte[0];

    public final String getRootNodeValue(String str, String str2) {
        return "";
    }

    public fnl() {
        fnd.O000000o();
    }

    public final void invokeServiceAction(String str, String str2, String str3, List<KeyValuePair> list, Callback<String> callback) {
        if (callback != null) {
            callback.onFailure(-1, "this method is Deprecated");
        }
    }
}
