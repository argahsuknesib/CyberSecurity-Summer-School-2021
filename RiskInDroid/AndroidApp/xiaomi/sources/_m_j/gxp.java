package _m_j;

import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.miio.miband.data.PluginDeviceDownloadItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class gxp {

    /* renamed from: O000000o  reason: collision with root package name */
    public static HashMap<String, PluginDeviceDownloadItem> f18480O000000o;
    private static volatile gxp O00000o0;
    public List<O000000o> O00000Oo = null;

    public interface O000000o {
        void O000000o();
    }

    public static gxp O000000o() {
        if (O00000o0 == null) {
            synchronized (gxp.class) {
                if (O00000o0 == null) {
                    O00000o0 = new gxp();
                }
            }
        }
        return O00000o0;
    }

    public final void O00000Oo() {
        for (O000000o O000000o2 : this.O00000Oo) {
            O000000o2.O000000o();
        }
    }

    public class O00000Oo extends SendMessageCallback {
        private String O00000Oo;

        public O00000Oo(String str) {
            this.O00000Oo = str;
        }

        public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
            if (gxp.f18480O000000o.get(this.O00000Oo) == null) {
                PluginDeviceDownloadItem pluginDeviceDownloadItem = new PluginDeviceDownloadItem();
                pluginDeviceDownloadItem.O00000Oo = this.O00000Oo;
                pluginDeviceDownloadItem.O00000o0 = PluginDeviceDownloadItem.Status.DOWNLOADING;
                gxp.f18480O000000o.put(this.O00000Oo, pluginDeviceDownloadItem);
            }
            gxp.this.O00000Oo();
        }

        public final void onDownloadProgress(String str, float f) {
            PluginDeviceDownloadItem pluginDeviceDownloadItem = gxp.f18480O000000o.get(this.O00000Oo);
            if (pluginDeviceDownloadItem != null) {
                pluginDeviceDownloadItem.f9756O000000o = f;
            }
            gxp.this.O00000Oo();
        }

        public final void onDownloadSuccess(String str) {
            PluginDeviceDownloadItem pluginDeviceDownloadItem = gxp.f18480O000000o.get(this.O00000Oo);
            if (pluginDeviceDownloadItem != null) {
                pluginDeviceDownloadItem.O00000o0 = PluginDeviceDownloadItem.Status.DOWNLOADING_SUCCESS;
            }
            gxp.this.O00000Oo();
            gxp.f18480O000000o.remove(this.O00000Oo);
        }

        public final void onDownloadFailure(PluginError pluginError) {
            PluginDeviceDownloadItem pluginDeviceDownloadItem = gxp.f18480O000000o.get(this.O00000Oo);
            if (pluginDeviceDownloadItem != null) {
                pluginDeviceDownloadItem.O00000o0 = PluginDeviceDownloadItem.Status.DOWNLOADING_FAILURE;
            }
            gxp.this.O00000Oo();
            gxp.f18480O000000o.remove(this.O00000Oo);
        }

        public final void onDownloadCancel() {
            PluginDeviceDownloadItem pluginDeviceDownloadItem = gxp.f18480O000000o.get(this.O00000Oo);
            if (pluginDeviceDownloadItem != null) {
                pluginDeviceDownloadItem.O00000o0 = PluginDeviceDownloadItem.Status.DOWNLOADING_FAILURE;
            }
            gxp.this.O00000Oo();
            gxp.f18480O000000o.remove(this.O00000Oo);
        }
    }

    private gxp() {
        f18480O000000o = new HashMap<>(5);
        this.O00000Oo = new ArrayList();
    }

    public static PluginDeviceDownloadItem O000000o(String str) {
        return f18480O000000o.get(str);
    }
}
