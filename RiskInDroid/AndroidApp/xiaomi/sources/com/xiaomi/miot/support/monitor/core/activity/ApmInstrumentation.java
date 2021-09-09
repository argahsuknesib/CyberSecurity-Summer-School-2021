package com.xiaomi.miot.support.monitor.core.activity;

import _m_j.dxr;
import _m_j.dyb;
import _m_j.dyg;
import _m_j.dyq;
import _m_j.dzg;
import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.miot.support.monitor.core.fps.FpsInfo;
import java.util.List;
import org.json.JSONException;

public class ApmInstrumentation extends Instrumentation {

    /* renamed from: O000000o  reason: collision with root package name */
    private Instrumentation f6035O000000o = null;

    public ApmInstrumentation(Instrumentation instrumentation) {
        if (instrumentation instanceof Instrumentation) {
            this.f6035O000000o = instrumentation;
        }
    }

    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Instrumentation instrumentation = this.f6035O000000o;
        if (instrumentation != null) {
            return instrumentation.newActivity(classLoader, str, intent);
        }
        return super.newActivity(classLoader, str, intent);
    }

    public void callApplicationOnCreate(Application application) {
        Instrumentation instrumentation = this.f6035O000000o;
        if (instrumentation != null) {
            instrumentation.callApplicationOnCreate(application);
        } else {
            super.callApplicationOnCreate(application);
        }
    }

    public void callActivityOnRestart(Activity activity) {
        super.callActivityOnRestart(activity);
        dyg dyg = (dyg) dyq.O000000o.f15075O000000o.O000000o("fps");
        if (dyg != null) {
            dyg.O000000o(activity.getComponentName().getClassName(), 2);
        }
    }

    public void callActivityOnStart(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        dyb.O00000Oo = currentTimeMillis;
        Instrumentation instrumentation = this.f6035O000000o;
        if (instrumentation != null) {
            instrumentation.callActivityOnStart(activity);
        } else {
            super.callActivityOnStart(activity);
        }
        dyb.O000000o(activity, 2, System.currentTimeMillis() - currentTimeMillis, 3);
    }

    public void callActivityOnResume(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        Instrumentation instrumentation = this.f6035O000000o;
        if (instrumentation != null) {
            instrumentation.callActivityOnResume(activity);
        } else {
            super.callActivityOnResume(activity);
        }
        dyb.O000000o(activity, 2, System.currentTimeMillis() - currentTimeMillis, 4);
    }

    public void callActivityOnStop(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        Instrumentation instrumentation = this.f6035O000000o;
        if (instrumentation != null) {
            instrumentation.callActivityOnStop(activity);
        } else {
            super.callActivityOnStop(activity);
        }
        dyb.O000000o(activity, 2, System.currentTimeMillis() - currentTimeMillis, 6);
    }

    public void callActivityOnPause(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        Instrumentation instrumentation = this.f6035O000000o;
        if (instrumentation != null) {
            instrumentation.callActivityOnPause(activity);
        } else {
            super.callActivityOnPause(activity);
        }
        dyb.O000000o(activity, 2, System.currentTimeMillis() - currentTimeMillis, 5);
        dyg dyg = (dyg) dyq.O000000o.f15075O000000o.O000000o("fps");
        if (dyg != null) {
            String className = activity.getComponentName().getClassName();
            if (dyg.f15065O000000o == 0) {
                dyg.f15065O000000o = dyg.O00000Oo;
            } else if (TextUtils.equals(dyg.O00000oo, className)) {
                float f = ((float) (dyg.O00000Oo - dyg.f15065O000000o)) / 1000000.0f;
                if (dyg.O00000o0 >= 30 && f > 0.0f) {
                    int i = (int) (((float) (dyg.O00000o0 * 1000)) / f);
                    StringBuilder sb = new StringBuilder("calculateFPS: ");
                    sb.append(f);
                    sb.append("  ");
                    sb.append(dyg.O00000Oo);
                    sb.append("  ");
                    sb.append(dyg.f15065O000000o);
                    sb.append(" ");
                    sb.append(dyg.O00000o0);
                    sb.append("  ");
                    sb.append(i);
                    sb.append("  actname = ");
                    sb.append(className);
                    sb.append("  cycleType=");
                    sb.append(dyg.O00000oO);
                    if (i > 0 && i <= 60) {
                        dzg.O000000o(new Runnable(new FpsInfo(className, i, dyg.O00000oO)) {
                            /* class _m_j.dya.AnonymousClass1 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ FpsInfo f15054O000000o;

                            {
                                this.f15054O000000o = r2;
                            }

                            public final void run() {
                                if (!dyq.O000000o.f15075O000000o.O00000Oo("fps")) {
                                    List list = dya.this.O00000o.get();
                                    if (list != null) {
                                        synchronized (dya.this.O00000oO) {
                                            if (list != null) {
                                                list.add(this.f15054O000000o);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    return;
                                }
                                if (!(dya.this.O00000o == null || dya.this.O00000o.get() == null || dya.this.O00000o.get().size() <= 0)) {
                                    dya dya = dya.this;
                                    List<FpsInfo> list2 = dya.O00000o.get();
                                    if (!(list2 == null || list2.size() == 0)) {
                                        synchronized (dya.O00000oO) {
                                            if (list2 != null) {
                                                if (list2.size() != 0) {
                                                    for (FpsInfo fpsInfo : list2) {
                                                        if (fpsInfo != null) {
                                                            new StringBuilder("reportFpsInfos: ").append(fpsInfo.toString());
                                                            try {
                                                                dxr.O000000o.f15041O000000o.O000000o().f15049O000000o.O000000o(105, dxr.O000000o.f15041O000000o.O000000o().O00000oO.report_type, fpsInfo.O000000o());
                                                            } catch (JSONException e) {
                                                                e.printStackTrace();
                                                            }
                                                        }
                                                    }
                                                    list2.clear();
                                                }
                                            }
                                        }
                                    }
                                }
                                try {
                                    dxr.O000000o.f15041O000000o.O000000o().f15049O000000o.O000000o(105, dxr.O000000o.f15041O000000o.O000000o().O00000oO.report_type, this.f15054O000000o.O000000o());
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    public void callActivityOnDestroy(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        Instrumentation instrumentation = this.f6035O000000o;
        if (instrumentation != null) {
            instrumentation.callActivityOnDestroy(activity);
        } else {
            super.callActivityOnDestroy(activity);
        }
        dyb.O000000o(activity, 2, System.currentTimeMillis() - currentTimeMillis, 7);
    }

    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        dyg dyg = (dyg) dyq.O000000o.f15075O000000o.O000000o("fps");
        if (dyg != null) {
            dyg.O000000o(activity.getComponentName().getClassName(), 1);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Instrumentation instrumentation = this.f6035O000000o;
        if (instrumentation != null) {
            instrumentation.callActivityOnCreate(activity, bundle);
        } else {
            super.callActivityOnCreate(activity, bundle);
        }
        dyb.O000000o(activity, currentTimeMillis);
    }
}
