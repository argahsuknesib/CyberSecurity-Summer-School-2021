package _m_j;

import _m_j.dxr;
import _m_j.dyq;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.miot.support.monitor.leak.Retryable;
import java.util.concurrent.TimeUnit;

public final class dyu extends dzb<dyu> {
    public static volatile dza O00000o;
    private static final long O00000oo = TimeUnit.SECONDS.toMillis(5);

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f15081O000000o = false;
    public Application O00000Oo;
    public long O00000o0;
    public Application.ActivityLifecycleCallbacks O00000oO = new Application.ActivityLifecycleCallbacks() {
        /* class _m_j.dyu.AnonymousClass1 */

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f15082O000000o = false;
        int O00000Oo = 0;

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            if (dyu.O00000o != null) {
                dyu.O00000o.O000000o(activity.getComponentName().getClassName());
            }
            this.O00000Oo++;
            if (this.f15082O000000o) {
                this.f15082O000000o = false;
                dyp O000000o2 = dyq.O000000o.f15075O000000o.O000000o("fps");
                if (O000000o2 != null) {
                    O000000o2.O000000o(true);
                    if (TextUtils.equals("fps", "fps") && (O000000o2 instanceof dyg)) {
                        ((dyg) O000000o2).O00000o = true;
                        dxr.O000000o.f15041O000000o.O00000Oo();
                    }
                }
            }
        }

        public final void onActivityStopped(Activity activity) {
            this.O00000Oo--;
            if (this.O00000Oo <= 0) {
                boolean z = false;
                this.O00000Oo = 0;
                dyp O000000o2 = dyq.O000000o.f15075O000000o.O000000o("fps");
                if (O000000o2 != null) {
                    O000000o2.O000000o(false);
                }
                this.f15082O000000o = true;
                if (dyu.O00000o != null) {
                    dza dza = dyu.O00000o;
                    dza.O000000o();
                    if (dza.O00000o0.isEmpty()) {
                        return;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis - dyu.this.O00000o0) - (dxr.O000000o.f15041O000000o.O000000o().O00000Oo.min_check_interval_sec * 1000) > 0) {
                    z = true;
                }
                if (dyu.O00000o != null && z) {
                    dyu.this.O00000o0 = currentTimeMillis;
                    dza dza2 = dyu.O00000o;
                    dza2.O000000o();
                    for (String str : dza2.O00000oO.keySet()) {
                        dza2.O00000Oo.O000000o(new Retryable(dza2.O00000oO.get(str)) {
                            /* class _m_j.dza.AnonymousClass1 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ dyx f15092O000000o;

                            {
                                this.f15092O000000o = r2;
                            }

                            public final Retryable.Result O000000o() {
                                return dza.this.O000000o(this.f15092O000000o);
                            }
                        });
                    }
                }
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            if (dyu.O00000o != null) {
                dza dza = dyu.O00000o;
                String className = activity.getComponentName().getClassName();
                dza.O00000o0.add(className);
                dza.O00000oO.put(className, new dyx(activity, className, "", dza.O00000o));
            }
        }
    };
    private final Context O0000O0o;
    private boolean O0000OOo = true;

    dyu(Context context) {
        this.O0000O0o = context.getApplicationContext();
    }

    public final dza O000000o() {
        if (O00000o == null) {
            dza O00000o2 = O00000o();
            if (O00000o2 != dza.f15091O000000o) {
                O00000o = O00000o2;
                if (this.O0000OOo) {
                    O00000o0();
                }
            }
            return O00000o2;
        }
        throw new UnsupportedOperationException("buildAndInstall() should only be called once.");
    }

    /* access modifiers changed from: protected */
    public final dzc O00000Oo() {
        return new dyv(O00000oo);
    }

    public final void O00000o0() {
        Context context = this.O0000O0o;
        if (context != null && this.O0000OOo && !this.f15081O000000o) {
            if (this.O00000Oo == null) {
                this.O00000Oo = (Application) context.getApplicationContext();
            }
            this.O00000Oo.registerActivityLifecycleCallbacks(this.O00000oO);
            this.f15081O000000o = true;
        }
    }
}
