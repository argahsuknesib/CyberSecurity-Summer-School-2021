package _m_j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.xiaomi.push.fc;
import com.xiaomi.push.fe;
import com.xiaomi.push.service.XMJobService;

public final class epp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static O000000o f15707O000000o;
    private static final String O00000Oo = XMJobService.class.getCanonicalName();
    private static int O00000o0 = 0;

    public interface O000000o {
        void O000000o();

        void O000000o(boolean z);

        boolean O00000Oo();
    }

    public static synchronized void O000000o() {
        synchronized (epp.class) {
            if (f15707O000000o != null) {
                duv.O000000o("[Alarm] stop alarm.");
                f15707O000000o.O000000o();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        if (_m_j.epp.O00000Oo.equals(_m_j.esu.O000000o(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007c, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099  */
    public static void O000000o(Context context) {
        fc fcVar;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            fcVar = new fc(applicationContext);
        } else {
            int i = 0;
            boolean z = true;
            try {
                PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4);
                if (packageInfo.services != null) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    int length = serviceInfoArr.length;
                    boolean z2 = false;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        try {
                            ServiceInfo serviceInfo = serviceInfoArr[i];
                            if ("android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                if (!O00000Oo.equals(serviceInfo.name)) {
                                    try {
                                    } catch (Exception unused) {
                                    }
                                }
                                z2 = true;
                                if (z2) {
                                    break;
                                }
                            }
                            if (O00000Oo.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                break;
                            }
                            i++;
                        } catch (Exception e) {
                            e = e;
                            z = z2;
                            duv.O000000o("check service err : " + e.getMessage());
                            if (!z) {
                            }
                            int i2 = Build.VERSION.SDK_INT;
                            fcVar = new fc(applicationContext);
                            f15707O000000o = fcVar;
                        }
                    }
                } else {
                    z = false;
                }
            } catch (Exception e2) {
                e = e2;
                z = false;
                duv.O000000o("check service err : " + e.getMessage());
                if (!z) {
                }
                int i22 = Build.VERSION.SDK_INT;
                fcVar = new fc(applicationContext);
                f15707O000000o = fcVar;
            }
            if (!z || !esu.O00000Oo(applicationContext)) {
                int i222 = Build.VERSION.SDK_INT;
                fcVar = new fc(applicationContext);
            } else {
                throw new RuntimeException("Should export service: " + O00000Oo + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
            }
        }
        f15707O000000o = fcVar;
    }

    public static synchronized void O000000o(Context context, int i) {
        synchronized (epp.class) {
            int i2 = O00000o0;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i == 2) {
                    O00000o0 = 2;
                } else {
                    O00000o0 = 0;
                }
            }
            if (i2 != O00000o0 && O00000o0 == 2) {
                O000000o();
                f15707O000000o = new fe(context);
            }
        }
    }

    public static synchronized void O000000o(boolean z) {
        synchronized (epp.class) {
            if (f15707O000000o == null) {
                duv.O000000o("timer is not initialized");
                return;
            }
            duv.O000000o("[Alarm] register alarm. (" + z + ")");
            f15707O000000o.O000000o(z);
        }
    }

    public static synchronized boolean O00000Oo() {
        synchronized (epp.class) {
            if (f15707O000000o == null) {
                return false;
            }
            boolean O00000Oo2 = f15707O000000o.O00000Oo();
            return O00000Oo2;
        }
    }
}
