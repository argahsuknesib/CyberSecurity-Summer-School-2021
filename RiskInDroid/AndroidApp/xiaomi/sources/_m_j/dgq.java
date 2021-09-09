package _m_j;

import _m_j.dgp;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.List;
import java.util.UUID;

public class dgq {

    /* renamed from: O000000o  reason: collision with root package name */
    public static dgp f14612O000000o = null;
    private static boolean O00000Oo = false;
    /* access modifiers changed from: private */
    public static long O00000o = 300000;
    /* access modifiers changed from: private */
    public static int O00000o0 = 10;
    /* access modifiers changed from: private */
    public static long O00000oO = 30000;
    /* access modifiers changed from: private */
    public static long O00000oo = 0;
    /* access modifiers changed from: private */
    public static int O0000O0o = 0;
    /* access modifiers changed from: private */
    public static long O0000OOo = 0;
    /* access modifiers changed from: private */
    public static long O0000Oo = 0;
    /* access modifiers changed from: private */
    public static long O0000Oo0 = 0;
    private static Application.ActivityLifecycleCallbacks O0000OoO = null;
    /* access modifiers changed from: private */
    public static Class<?> O0000Ooo = null;
    /* access modifiers changed from: private */
    public static boolean O0000o00 = true;

    static /* synthetic */ String O000000o(String str, String str2) {
        return dif.O000000o() + "  " + str + "  " + str2 + "\n";
    }

    static /* synthetic */ int O0000O0o() {
        int i = O0000O0o;
        O0000O0o = i + 1;
        return i;
    }

    /* JADX WARN: Type inference failed for: r12v11, types: [android.content.Context] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067  */
    public static void O00000o0(Context context, dgj dgj) {
        boolean z;
        boolean z2;
        boolean z3;
        if (dgj != null) {
            z2 = dgj.O00000o0();
            z = dgj.O0000Ooo();
        } else {
            z = true;
            z2 = false;
        }
        if (z2) {
            dgs O000000o2 = dgs.O000000o(context);
            List<UserInfoBean> O000000o3 = dgp.O000000o(O000000o2.O00000oo);
            if (O000000o3 != null) {
                int i = 0;
                while (true) {
                    if (i >= O000000o3.size()) {
                        break;
                    }
                    UserInfoBean userInfoBean = O000000o3.get(i);
                    if (userInfoBean.O0000o0.equals(O000000o2.O0000o0) && userInfoBean.O00000Oo == 1) {
                        long O00000Oo2 = dif.O00000Oo();
                        if (O00000Oo2 <= 0) {
                            break;
                        } else if (userInfoBean.O00000oO >= O00000Oo2) {
                            if (userInfoBean.O00000oo <= 0) {
                                dgp dgp = f14612O000000o;
                                dic O000000o4 = dic.O000000o();
                                if (O000000o4 != null) {
                                    O000000o4.O000000o(new Runnable() {
                                        /* class _m_j.dgp.AnonymousClass2 */

                                        public final void run() {
                                            try {
                                                dgp.this.O00000Oo();
                                            } catch (Throwable th) {
                                                did.O000000o(th);
                                            }
                                        }
                                    });
                                }
                            }
                            z3 = false;
                        }
                    }
                    i++;
                }
                if (!z3) {
                    z = false;
                } else {
                    return;
                }
            }
            z3 = true;
            if (!z3) {
            }
        }
        dgs O000000o5 = dgs.O000000o();
        Application application = null;
        if (O000000o5 != null) {
            String str = null;
            boolean z4 = false;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (stackTraceElement.getMethodName().equals("onCreate")) {
                    str = stackTraceElement.getClassName();
                }
                if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                    z4 = true;
                }
            }
            if (str == null) {
                str = "unknown";
            } else if (z4) {
                O000000o5.O000000o(true);
            } else {
                str = "background";
            }
            O000000o5.O0000ooO = str;
        }
        if (z && Build.VERSION.SDK_INT >= 14) {
            if (context.getApplicationContext() instanceof Application) {
                application = context.getApplicationContext();
            }
            if (application != null) {
                try {
                    if (O0000OoO == null) {
                        O0000OoO = new Application.ActivityLifecycleCallbacks() {
                            /* class _m_j.dgq.AnonymousClass2 */

                            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                            }

                            public final void onActivityStarted(Activity activity) {
                            }

                            public final void onActivityStopped(Activity activity) {
                            }

                            public final void onActivityResumed(Activity activity) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (dgq.O0000Ooo == null || dgq.O0000Ooo.getName().equals(name)) {
                                    did.O00000o0(">>> %s onResumed <<<", name);
                                    dgs O000000o2 = dgs.O000000o();
                                    if (O000000o2 != null) {
                                        O000000o2.O000OO0o.add(dgq.O000000o(name, "onResumed"));
                                        O000000o2.O000000o(true);
                                        O000000o2.O0000ooO = name;
                                        O000000o2.O0000ooo = System.currentTimeMillis();
                                        O000000o2.O000O00o = O000000o2.O0000ooo - dgq.O0000Oo0;
                                        long O00000o = O000000o2.O0000ooo - dgq.O0000OOo;
                                        if (O00000o > (dgq.O00000oo > 0 ? dgq.O00000oo : dgq.O00000oO)) {
                                            synchronized (O000000o2.O000OOo0) {
                                                O000000o2.O00000Oo = UUID.randomUUID().toString();
                                            }
                                            dgq.O0000O0o();
                                            did.O000000o("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(O00000o / 1000), Long.valueOf(dgq.O00000oO / 1000));
                                            if (dgq.O0000O0o % dgq.O00000o0 == 0) {
                                                dgq.f14612O000000o.O000000o(4, dgq.O0000o00);
                                                return;
                                            }
                                            dgq.f14612O000000o.O000000o(4, false);
                                            long currentTimeMillis = System.currentTimeMillis();
                                            if (currentTimeMillis - dgq.O0000Oo > dgq.O00000o) {
                                                long unused = dgq.O0000Oo = currentTimeMillis;
                                                did.O000000o("add a timer to upload hot start user info", new Object[0]);
                                                if (dgq.O0000o00) {
                                                    dic.O000000o().O000000o(new dgp.O000000o(null, true), dgq.O00000o);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            public final void onActivityPaused(Activity activity) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (dgq.O0000Ooo == null || dgq.O0000Ooo.getName().equals(name)) {
                                    did.O00000o0(">>> %s onPaused <<<", name);
                                    dgs O000000o2 = dgs.O000000o();
                                    if (O000000o2 != null) {
                                        O000000o2.O000OO0o.add(dgq.O000000o(name, "onPaused"));
                                        O000000o2.O000000o(false);
                                        O000000o2.O00oOooO = System.currentTimeMillis();
                                        O000000o2.O00oOooo = O000000o2.O00oOooO - O000000o2.O0000ooo;
                                        long unused = dgq.O0000OOo = O000000o2.O00oOooO;
                                        if (O000000o2.O00oOooo < 0) {
                                            O000000o2.O00oOooo = 0;
                                        }
                                        if (activity != null) {
                                            O000000o2.O0000ooO = "background";
                                        } else {
                                            O000000o2.O0000ooO = "unknown";
                                        }
                                    }
                                }
                            }

                            public final void onActivityDestroyed(Activity activity) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (dgq.O0000Ooo == null || dgq.O0000Ooo.getName().equals(name)) {
                                    did.O00000o0(">>> %s onDestroyed <<<", name);
                                    dgs O000000o2 = dgs.O000000o();
                                    if (O000000o2 != null) {
                                        O000000o2.O000OO0o.add(dgq.O000000o(name, "onDestroyed"));
                                    }
                                }
                            }

                            public final void onActivityCreated(Activity activity, Bundle bundle) {
                                String name = activity != null ? activity.getClass().getName() : "unknown";
                                if (dgq.O0000Ooo == null || dgq.O0000Ooo.getName().equals(name)) {
                                    did.O00000o0(">>> %s onCreated <<<", name);
                                    dgs O000000o2 = dgs.O000000o();
                                    if (O000000o2 != null) {
                                        O000000o2.O000OO0o.add(dgq.O000000o(name, "onCreated"));
                                    }
                                }
                            }
                        };
                    }
                    application.registerActivityLifecycleCallbacks(O0000OoO);
                } catch (Exception e) {
                    if (!did.O000000o(e)) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (O0000o00) {
            O0000Oo0 = System.currentTimeMillis();
            f14612O000000o.O000000o(1, false);
            did.O000000o("[session] launch app, new start", new Object[0]);
            f14612O000000o.O000000o();
            dic.O000000o().O000000o(new dgp.O00000o0(21600000), 21600000);
        }
    }

    public static void O000000o(final Context context, final dgj dgj) {
        long j;
        if (!O00000Oo) {
            O0000o00 = dgs.O000000o(context).O0000O0o;
            f14612O000000o = new dgp(context, O0000o00);
            O00000Oo = true;
            if (dgj != null) {
                O0000Ooo = dgj.O00000oO();
                j = dgj.O0000OOo();
            } else {
                j = 0;
            }
            if (j <= 0) {
                O00000o0(context, dgj);
            } else {
                dic.O000000o().O000000o(new Runnable() {
                    /* class _m_j.dgq.AnonymousClass1 */

                    public final void run() {
                        dgq.O00000o0(context, dgj);
                    }
                }, j);
            }
        }
    }

    public static void O000000o(StrategyBean strategyBean, boolean z) {
        dic O000000o2;
        dgp dgp = f14612O000000o;
        if (!(dgp == null || z || (O000000o2 = dic.O000000o()) == null)) {
            O000000o2.O000000o(new Runnable() {
                /* class _m_j.dgp.AnonymousClass2 */

                public final void run() {
                    try {
                        dgp.this.O00000Oo();
                    } catch (Throwable th) {
                        did.O000000o(th);
                    }
                }
            });
        }
        if (strategyBean != null) {
            if (strategyBean.O0000o > 0) {
                O00000oO = strategyBean.O0000o;
            }
            if (strategyBean.O0000oo > 0) {
                O00000o0 = strategyBean.O0000oo;
            }
            if (strategyBean.O0000ooO > 0) {
                O00000o = strategyBean.O0000ooO;
            }
        }
    }

    public static void O000000o() {
        dgp dgp = f14612O000000o;
        if (dgp != null) {
            dgp.O000000o(2, false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    public static void O000000o(Context context) {
        if (O00000Oo && context != null) {
            Application application = null;
            if (Build.VERSION.SDK_INT >= 14) {
                if (context.getApplicationContext() instanceof Application) {
                    application = context.getApplicationContext();
                }
                if (application != null) {
                    try {
                        if (O0000OoO != null) {
                            application.unregisterActivityLifecycleCallbacks(O0000OoO);
                        }
                    } catch (Exception e) {
                        if (!did.O000000o(e)) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            O00000Oo = false;
        }
    }
}
