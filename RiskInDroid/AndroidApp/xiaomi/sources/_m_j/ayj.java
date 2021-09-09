package _m_j;

import _m_j.ayh;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.util.Log;
import java.util.Map;
import java.util.UUID;

public final class ayj {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f12705O000000o = false;
    public static final Map<Activity, String> O00000Oo = new o0O0OOO0();
    static final Application.ActivityLifecycleCallbacks O00000o = new Application.ActivityLifecycleCallbacks() {
        /* class _m_j.ayj.AnonymousClass1 */

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            String string;
            if (bundle != null && (string = bundle.getString("com.hannesdorfmann.mosby3.MosbyPresenterManagerActivityId")) != null) {
                ayj.O00000Oo.put(activity, string);
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            String str = ayj.O00000Oo.get(activity);
            if (str != null) {
                bundle.putString("com.hannesdorfmann.mosby3.MosbyPresenterManagerActivityId", str);
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            String str;
            if (!activity.isChangingConfigurations() && (str = ayj.O00000Oo.get(activity)) != null) {
                ayh ayh = ayj.O00000o0.get(str);
                if (ayh != null) {
                    ayh.f12703O000000o.clear();
                    ayj.O00000o0.remove(str);
                }
                if (ayj.O00000o0.isEmpty()) {
                    activity.getApplication().unregisterActivityLifecycleCallbacks(ayj.O00000o);
                    if (ayj.f12705O000000o) {
                        Log.d("PresenterManager", "Unregistering ActivityLifecycleCallbacks");
                    }
                }
            }
            ayj.O00000Oo.remove(activity);
        }
    };
    public static final Map<String, ayh> O00000o0 = new o0O0OOO0();

    private static ayh O000000o(Activity activity) {
        if (activity != null) {
            String str = O00000Oo.get(activity);
            if (str == null) {
                return null;
            }
            return O00000o0.get(str);
        }
        throw new NullPointerException("Activity is null");
    }

    public static <P> P O000000o(Activity activity, String str) {
        ayh.O000000o o000000o;
        if (activity == null) {
            throw new NullPointerException("Activity is null");
        } else if (str != null) {
            ayh O000000o2 = O000000o(activity);
            if (O000000o2 == null || (o000000o = O000000o2.f12703O000000o.get(str)) == null) {
                return null;
            }
            return o000000o.f12704O000000o;
        } else {
            throw new NullPointerException("View id is null");
        }
    }

    public static Activity O000000o(Context context) {
        if (context == null) {
            throw new NullPointerException("context == null");
        } else if (context instanceof Activity) {
            return (Activity) context;
        } else {
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            throw new IllegalStateException("Could not find the surrounding Activity");
        }
    }

    public static void O00000Oo(Activity activity, String str) {
        if (activity != null) {
            ayh O000000o2 = O000000o(activity);
            if (O000000o2 == null) {
                return;
            }
            if (str != null) {
                O000000o2.f12703O000000o.remove(str);
                return;
            }
            throw new NullPointerException("View Id is null");
        }
        throw new NullPointerException("Activity is null");
    }

    public static void O000000o(Activity activity, String str, ayr<? extends ays> ayr) {
        if (activity == null) {
            throw new NullPointerException("Activity is null");
        } else if (activity != null) {
            String str2 = O00000Oo.get(activity);
            if (str2 == null) {
                str2 = UUID.randomUUID().toString();
                O00000Oo.put(activity, str2);
                if (O00000Oo.size() == 1) {
                    activity.getApplication().registerActivityLifecycleCallbacks(O00000o);
                    if (f12705O000000o) {
                        Log.d("PresenterManager", "Registering ActivityLifecycleCallbacks");
                    }
                }
            }
            ayh ayh = O00000o0.get(str2);
            if (ayh == null) {
                ayh = new ayh();
                O00000o0.put(str2, ayh);
            }
            if (str == null) {
                throw new NullPointerException("ViewId is null");
            } else if (ayr != null) {
                ayh.O000000o o000000o = ayh.f12703O000000o.get(str);
                if (o000000o == null) {
                    ayh.O000000o o000000o2 = new ayh.O000000o();
                    o000000o2.f12704O000000o = ayr;
                    ayh.f12703O000000o.put(str, o000000o2);
                    return;
                }
                o000000o.f12704O000000o = ayr;
            } else {
                throw new NullPointerException("Presenter is null");
            }
        } else {
            throw new NullPointerException("Activity is null");
        }
    }
}
