package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.net.URL;

public final class djm {

    /* renamed from: O000000o  reason: collision with root package name */
    private static djm f14723O000000o;
    private volatile WeakReference<SharedPreferences> O00000Oo = null;

    public static synchronized djm O000000o() {
        djm djm;
        synchronized (djm.class) {
            if (f14723O000000o == null) {
                f14723O000000o = new djm();
            }
            djm = f14723O000000o;
        }
        return djm;
    }

    public final String O000000o(Context context, String str) {
        if (this.O00000Oo == null || this.O00000Oo.get() == null) {
            this.O00000Oo = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                diz.O00000oO("openSDK_LOG.ServerSetting", "Get host error. url=".concat(String.valueOf(str)));
                return str;
            }
            String string = this.O00000Oo.get().getString(host, null);
            if (string != null) {
                if (!host.equals(string)) {
                    String replace = str.replace(host, string);
                    diz.O000000o("openSDK_LOG.ServerSetting", "return environment url : ".concat(String.valueOf(replace)));
                    return replace;
                }
            }
            diz.O000000o("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e) {
            diz.O00000oO("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e.getMessage());
            return str;
        }
    }
}
