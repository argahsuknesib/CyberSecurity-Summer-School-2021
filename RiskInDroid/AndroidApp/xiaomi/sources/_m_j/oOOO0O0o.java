package _m_j;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class oOOO0O0o {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final Class<?> f2315O000000o = O00000o();
    protected static final Field O00000Oo = O00000Oo();
    protected static final Method O00000o = O000000o(f2315O000000o);
    protected static final Field O00000o0 = O00000o0();
    protected static final Method O00000oO = O00000Oo(f2315O000000o);
    protected static final Method O00000oo = O00000o0(f2315O000000o);
    private static final Handler O0000O0o = new Handler(Looper.getMainLooper());

    static boolean O000000o(Activity activity) {
        Object obj;
        final Application application;
        final O000000o o000000o;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (O000000o() && O00000oo == null) {
            return false;
        } else {
            if (O00000oO == null && O00000o == null) {
                return false;
            }
            try {
                final Object obj2 = O00000o0.get(activity);
                if (obj2 == null || (obj = O00000Oo.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                o000000o = new O000000o(activity);
                application.registerActivityLifecycleCallbacks(o000000o);
                O0000O0o.post(new Runnable() {
                    /* class _m_j.oOOO0O0o.AnonymousClass1 */

                    public final void run() {
                        O000000o.this.f2319O000000o = obj2;
                    }
                });
                if (O000000o()) {
                    O00000oo.invoke(obj, obj2, null, null, 0, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.FALSE);
                } else {
                    activity.recreate();
                }
                O0000O0o.post(new Runnable() {
                    /* class _m_j.oOOO0O0o.AnonymousClass2 */

                    public final void run() {
                        application.unregisterActivityLifecycleCallbacks(o000000o);
                    }
                });
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    static final class O000000o implements Application.ActivityLifecycleCallbacks {

        /* renamed from: O000000o  reason: collision with root package name */
        Object f2319O000000o;
        private Activity O00000Oo;
        private boolean O00000o = false;
        private boolean O00000o0 = false;
        private boolean O00000oO = false;

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        O000000o(Activity activity) {
            this.O00000Oo = activity;
        }

        public final void onActivityStarted(Activity activity) {
            if (this.O00000Oo == activity) {
                this.O00000o0 = true;
            }
        }

        public final void onActivityPaused(Activity activity) {
            if (this.O00000o && !this.O00000oO && !this.O00000o0 && oOOO0O0o.O000000o(this.f2319O000000o, activity)) {
                this.O00000oO = true;
                this.f2319O000000o = null;
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            if (this.O00000Oo == activity) {
                this.O00000Oo = null;
                this.O00000o = true;
            }
        }
    }

    protected static boolean O000000o(Object obj, Activity activity) {
        try {
            final Object obj2 = O00000o0.get(activity);
            if (obj2 != obj) {
                return false;
            }
            final Object obj3 = O00000Oo.get(activity);
            O0000O0o.postAtFrontOfQueue(new Runnable() {
                /* class _m_j.oOOO0O0o.AnonymousClass3 */

                public final void run() {
                    try {
                        if (oOOO0O0o.O00000o != null) {
                            oOOO0O0o.O00000o.invoke(obj3, obj2, Boolean.FALSE, "AppCompat recreation");
                            return;
                        }
                        oOOO0O0o.O00000oO.invoke(obj3, obj2, Boolean.FALSE);
                    } catch (RuntimeException e) {
                        if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                            throw e;
                        }
                    } catch (Throwable th) {
                        Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    private static Method O000000o(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method O00000Oo(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean O000000o() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    private static Method O00000o0(Class<?> cls) {
        if (O000000o() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field O00000Oo() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field O00000o0() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> O00000o() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }
}
