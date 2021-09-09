package _m_j;

import com.google.android.play.core.splitinstall.SplitInstallHelper;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.HashSet;
import java.util.Set;

public class fya {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Set<String> f17402O000000o;
    private static volatile boolean O00000Oo = false;

    static {
        HashSet hashSet = new HashSet();
        f17402O000000o = hashSet;
        hashSet.add("RnOpencv");
    }

    public static boolean O000000o(String str) {
        return f17402O000000o.contains(str);
    }

    public static boolean O000000o() {
        fxx.O000000o();
        if (!fxx.O000000o("RnOpencv")) {
            fyc.O00000o0("RnLibLoaderUtil", "ensureOpencvLibLoaded,opencv has not installed");
            return false;
        }
        if (!O00000Oo) {
            synchronized (fya.class) {
                if (!O00000Oo) {
                    try {
                        SplitInstallHelper.loadLibrary(CommonApplication.getAppContext().createPackageContext(CommonApplication.getAppContext().getPackageName(), 0), "opencv_java3");
                        fyc.O00000Oo("RnLibLoaderUtil", "ensureOpencvLibLoaded,load opencv_java3 success");
                        O00000Oo = true;
                    } catch (Throwable th) {
                        fyc.O000000o("RnLibLoaderUtil", "ensureOpencvLibLoaded,load opencv_java3 error(catched):", th);
                    }
                }
            }
        }
        return O00000Oo;
    }
}
