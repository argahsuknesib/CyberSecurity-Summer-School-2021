package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.List;

public class geq {
    private static volatile geq O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public List<gyf> f17600O000000o;

    public interface O000000o {
        void O000000o(boolean z);
    }

    public static geq O000000o() {
        if (O00000Oo == null) {
            synchronized (geq.class) {
                if (O00000Oo == null) {
                    O00000Oo = new geq();
                }
            }
        }
        return O00000Oo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (r4.equals(r2) != false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006a, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006c, code lost:
        return false;
     */
    public final synchronized boolean O00000Oo() {
        boolean z = false;
        if (this.f17600O000000o != null) {
            if (this.f17600O000000o.size() > 0) {
                int i = 0;
                while (true) {
                    boolean z2 = true;
                    if (i >= this.f17600O000000o.size()) {
                        z = true;
                        break;
                    }
                    gyf gyf = this.f17600O000000o.get(i);
                    if (!gyf.O0000OOo) {
                        try {
                            Device O000000o2 = fno.O000000o().O000000o(gyf.O00000Oo);
                            if (O000000o2 != null) {
                                if (O000000o2.isOnline) {
                                    String str = gyf.O00000Oo;
                                    String str2 = gyf.O0000O0o;
                                    if (!TextUtils.isEmpty(str)) {
                                        String O000000o3 = gpv.O000000o(ServiceApplication.getAppContext(), "setting_main_model_update_ignore_prefix".concat(String.valueOf(str)), (String) null);
                                        if (!TextUtils.isEmpty(O000000o3)) {
                                        }
                                    }
                                    z2 = false;
                                    if (!z2) {
                                        break;
                                    }
                                }
                            }
                        } catch (Exception unused) {
                            continue;
                        }
                    }
                    i++;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005c, code lost:
        return;
     */
    public final synchronized void O00000o0() {
        if (this.f17600O000000o != null) {
            if (this.f17600O000000o.size() > 0) {
                for (int i = 0; i < this.f17600O000000o.size(); i++) {
                    gyf gyf = this.f17600O000000o.get(i);
                    if (!gyf.O0000OOo) {
                        try {
                            Device O000000o2 = fno.O000000o().O000000o(gyf.O00000Oo);
                            if (O000000o2 != null) {
                                if (O000000o2.isOnline) {
                                    String str = gyf.O00000Oo;
                                    String str2 = gyf.O0000O0o;
                                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                        gpv.O00000Oo(ServiceApplication.getAppContext(), "setting_main_model_update_ignore_prefix".concat(String.valueOf(str)), str2);
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
    }

    public final synchronized void O00000o() {
        List<PluginDownloadTask> list = guo.O000000o().O00000Oo;
        if (list != null) {
            for (PluginDownloadTask next : list) {
                String str = next.f6738O000000o;
                int i = next.O00000Oo;
                if (CoreApi.O000000o().O0000Oo(str) != null) {
                    LogType logType = LogType.GENERAL;
                    gsy.O000000o(logType, "ProfileRedPointManager", "setAllPluginUpdateIgnore" + str + "******" + i);
                    gpv.O00000Oo(ServiceApplication.getAppContext(), "setting_main_plugin_update_ignore_prefix".concat(String.valueOf(str)), String.valueOf(i));
                }
            }
        }
    }

    public final synchronized void O00000oO() {
        gpv.O000000o(ServiceApplication.getAppContext(), "setting_main_app_update_ignore_prefix", gyh.O00000Oo().getNewVersionCode());
    }
}
