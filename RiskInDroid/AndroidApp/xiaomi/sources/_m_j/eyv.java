package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import com.xiaomi.smarthome.ad.PluginAdCloseCache;
import com.xiaomi.smarthome.ad.api.AdPosition;
import com.xiaomi.smarthome.ad.api.Advertisement;
import com.xiaomi.smarthome.ad.api.IAdCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class eyv {
    private static volatile eyv O0000OOo;

    /* renamed from: O000000o  reason: collision with root package name */
    public String f15956O000000o = "";
    public Map<String, IAdCallback> O00000Oo = new HashMap();
    public IAdCallback O00000o;
    public IAdCallback O00000o0;
    public List<AdPosition> O00000oO = new ArrayList();
    public PluginAdCloseCache O00000oo;
    public Handler O0000O0o;
    private HandlerThread O0000Oo0;

    private eyv(Context context) {
        this.O00000oo = PluginAdCloseCache.O000000o(context);
        this.O0000Oo0 = new HandlerThread("plugin_id");
        this.O0000Oo0.start();
        this.O0000O0o = new Handler(this.O0000Oo0.getLooper());
    }

    public static eyv O000000o(Context context) {
        if (O0000OOo == null) {
            synchronized (eyv.class) {
                if (O0000OOo == null) {
                    O0000OOo = new eyv(context);
                }
            }
        }
        return O0000OOo;
    }

    public final void O000000o(String str) {
        if (this.f15956O000000o.equals(str)) {
            this.O00000oO.clear();
            this.O00000Oo.clear();
        }
    }

    public final boolean O000000o(AdPosition adPosition) {
        if (adPosition == null || adPosition.O00000Oo.size() == 0) {
            return false;
        }
        Advertisement O000000o2 = eyy.O000000o(adPosition);
        PluginAdCloseCache pluginAdCloseCache = this.O00000oo;
        long j = O000000o2.f4149O000000o;
        SharedPreferences sharedPreferences = pluginAdCloseCache.f4146O000000o;
        if (!sharedPreferences.getBoolean("show_" + String.valueOf(j), false)) {
            return true;
        }
        PluginAdCloseCache pluginAdCloseCache2 = this.O00000oo;
        long j2 = O000000o2.f4149O000000o;
        SharedPreferences sharedPreferences2 = pluginAdCloseCache2.f4146O000000o;
        if (sharedPreferences2.getBoolean("close_" + String.valueOf(j2), false)) {
            return false;
        }
        return true;
    }
}
