package _m_j;

import _m_j.dxr;
import _m_j.dya;
import _m_j.dyq;
import android.app.Activity;
import android.text.TextUtils;
import com.xiaomi.miot.support.monitor.core.activity.ActivityInfo;
import java.util.List;
import org.json.JSONException;

public final class dyb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static long f15058O000000o;
    public static long O00000Oo;
    public static int O00000o0;

    public static void O000000o(Activity activity, int i, long j, int i2) {
        if (activity != null && activity.getClass() != null && !TextUtils.isEmpty(activity.getClass().getCanonicalName())) {
            final Activity activity2 = activity;
            final int i3 = i2;
            final int i4 = i;
            final long j2 = j;
            dzg.O000000o(new Runnable() {
                /* class _m_j.dyb.AnonymousClass1 */

                public final void run() {
                    List list;
                    String canonicalName = activity2.getClass().getCanonicalName();
                    if (i3 == 1) {
                        Activity O000000o2 = dzf.O000000o();
                        if (O000000o2 != null && O000000o2.getClass() != null) {
                            String canonicalName2 = O000000o2.getClass().getCanonicalName();
                            if (TextUtils.isEmpty(canonicalName2) || !TextUtils.equals(canonicalName, canonicalName2)) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    ActivityInfo activityInfo = new ActivityInfo();
                    activityInfo.O00000Oo();
                    activityInfo.activityName = canonicalName;
                    activityInfo.startType = i4;
                    activityInfo.time = j2;
                    activityInfo.lifeCycle = i3;
                    dya dya = dya.O000000o.f15057O000000o;
                    if (!dyq.O000000o.f15075O000000o.O00000Oo("activity")) {
                        List list2 = dya.O00000Oo.get();
                        if (list2 != null) {
                            synchronized (dya.O00000o0) {
                                if (list2 != null) {
                                    list2.add(activityInfo);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    if (!(dya.O00000Oo == null || dya.O00000Oo.get() == null || dya.O00000Oo.get().size() <= 0 || !dyq.O000000o.f15075O000000o.O00000Oo("activity") || (list = dya.O00000Oo.get()) == null || list.size() == 0)) {
                        synchronized (dya.O00000o0) {
                            if (list != null) {
                                if (list.size() != 0) {
                                    for (ActivityInfo activityInfo2 : dya.O00000Oo.get()) {
                                        if (activityInfo2 != null) {
                                            try {
                                                dxr.O000000o.f15041O000000o.O000000o().f15049O000000o.O000000o(103, dxr.O000000o.f15041O000000o.O000000o().O00000o.report_type, activityInfo2.O000000o());
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                    list.clear();
                                }
                            }
                        }
                    }
                    try {
                        dxr.O000000o.f15041O000000o.O000000o().f15049O000000o.O000000o(103, dxr.O000000o.f15041O000000o.O000000o().O00000o.report_type, activityInfo.O000000o());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public static void O000000o(Activity activity, long j) {
        O00000o0 = 1;
        activity.getWindow().getDecorView().post(new O000000o(activity, O00000o0, j));
        O000000o(activity, O00000o0, System.currentTimeMillis() - j, 2);
    }

    static class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private Activity f15060O000000o;
        private int O00000Oo;
        private long O00000o0;

        public O000000o(Activity activity, int i, long j) {
            this.O00000o0 = j;
            this.f15060O000000o = activity;
            this.O00000Oo = i;
        }

        public final void run() {
            dyb.O000000o(this.f15060O000000o, this.O00000Oo, System.currentTimeMillis() - this.O00000o0, 1);
        }
    }
}
