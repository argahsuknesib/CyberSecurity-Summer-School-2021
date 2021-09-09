package _m_j;

import android.content.pm.PackageManager;
import android.util.Log;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class fxx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f17390O000000o = (CommonApplication.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "rn_common_ext_module_cache");
    private static final Set<String> O00000Oo;
    private static final Map<String, String> O00000o0;
    private static volatile fxx O00000oo;
    private Map<String, Object> O00000o = new ConcurrentHashMap();
    private Map<String, List<O000000o>> O00000oO = new ConcurrentHashMap();

    public interface O000000o {
        void O000000o(boolean z, String str);
    }

    static {
        HashSet hashSet = new HashSet();
        O00000Oo = hashSet;
        hashSet.add("null");
        HashMap hashMap = new HashMap();
        O00000o0 = hashMap;
        hashMap.put("RnOpencv", "opencv");
    }

    public static fxx O000000o() {
        if (O00000oo == null) {
            synchronized (fxy.class) {
                if (O00000oo == null) {
                    O00000oo = new fxx();
                }
            }
        }
        return O00000oo;
    }

    private fxx() {
        fyc.O00000Oo("RnCommonExtModuleManager", "google play only");
    }

    private static String O00000o0(String str) {
        return O00000o0.get(str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fxx.O000000o(java.lang.String, boolean, java.lang.String):void
     arg types: [java.lang.String, int, java.lang.String]
     candidates:
      _m_j.fxx.O000000o(java.lang.String, java.lang.String, com.xiaomi.smarthome.ExternalLoadManager$O000000o):java.lang.Integer
      _m_j.fxx.O000000o(java.lang.String, boolean, java.lang.String):void */
    public final synchronized void O000000o(String str, O000000o o000000o) {
        List list = this.O00000oO.get(str);
        if (list == null) {
            list = new CopyOnWriteArrayList();
            this.O00000oO.put(str, list);
        }
        boolean z = list.size() > 0;
        list.add(o000000o);
        if (z) {
            fyc.O00000Oo("RnCommonExtModuleManager", "module " + str + " is downloading");
        } else if (O000000o(str)) {
            fyc.O00000Oo("RnCommonExtModuleManager", "already installed,moduleId:".concat(String.valueOf(str)));
            O000000o(str, true, "");
        } else {
            String O00000o02 = O00000o0(str);
            ExternalLoadManager.instance.downExternal(O00000o02, new fkv(str, O00000o02) {
                /* class _m_j.$$Lambda$fxx$JFHg96nyI98L5p_nzYXk0wEi7mg */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final Object call(Object obj) {
                    return fxx.this.O000000o(this.f$1, this.f$2, (ExternalLoadManager.O000000o) obj);
                }
            });
        }
    }

    public static boolean O000000o(String str) {
        ExternalLoadManager.O000000o loadInfo = ExternalLoadManager.instance.getLoadInfo(O00000o0(str));
        if (loadInfo == null) {
            return false;
        }
        int i = loadInfo.f4013O000000o;
        return i == 2 || i == 3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0047, code lost:
        return;
     */
    private synchronized void O000000o(String str, boolean z, String str2) {
        List<O000000o> list = this.O00000oO.get(str);
        if (list != null) {
            if (list.size() != 0) {
                for (O000000o O000000o2 : list) {
                    try {
                        O000000o2.O000000o(z, str2);
                    } catch (Throwable th) {
                        fyc.O00000o0("RnCommonExtModuleManager", "notifyDownloadResult,callback error:" + Log.getStackTraceString(th));
                    }
                }
                this.O00000oO.clear();
            }
        }
    }

    public static InputStream O00000Oo(String str) throws IOException {
        try {
            return CommonApplication.getAppContext().createPackageContext(CommonApplication.getAppContext().getPackageName(), 0).getResources().getAssets().open(str);
        } catch (PackageManager.NameNotFoundException e) {
            fyc.O000000o("RnCommonExtModuleManager", "openAsset error(catched):", e);
            return CommonApplication.getAppContext().getResources().getAssets().open(str);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fxx.O000000o(java.lang.String, boolean, java.lang.String):void
     arg types: [java.lang.String, int, java.lang.String]
     candidates:
      _m_j.fxx.O000000o(java.lang.String, java.lang.String, com.xiaomi.smarthome.ExternalLoadManager$O000000o):java.lang.Integer
      _m_j.fxx.O000000o(java.lang.String, boolean, java.lang.String):void */
    /* access modifiers changed from: private */
    public /* synthetic */ Integer O000000o(String str, String str2, ExternalLoadManager.O000000o o000000o) throws RuntimeException {
        int i = o000000o.f4013O000000o;
        if (i == 2 || i == 3) {
            fyc.O00000o0("RnCommonExtModuleManager", "download success");
            O000000o(str, true, "");
        } else if (i != 4) {
            fyc.O00000o0("RnCommonExtModuleManager", String.format("download progress,moduleId:%s,status:%d,progress:%s", str, Integer.valueOf(i), Float.valueOf(o000000o.O00000o0)));
        } else {
            fyc.O00000o0("RnCommonExtModuleManager", "download failed");
            O000000o(str, false, String.format("download error,moduleId:%s,dfId:%s", str, str2));
        }
        return Integer.valueOf(i);
    }
}
