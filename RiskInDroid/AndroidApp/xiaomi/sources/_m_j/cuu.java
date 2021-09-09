package _m_j;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import java.util.List;

public final class cuu implements cur {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final cuu f14373O000000o = new cuu();
    private boolean O00000Oo = false;

    private int O000000o(cvg cvg, Intent intent, Context context, Integer num, boolean z) {
        if (!O000000o(context, intent)) {
            return 404;
        }
        if (O000000o(cvg, intent, z) == 200) {
            return 200;
        }
        return O000000o(cvg, context, intent, num, z);
    }

    private boolean O000000o(Context context, Intent intent) {
        if (!this.O00000Oo) {
            return true;
        }
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            return queryIntentActivities != null && queryIntentActivities.size() > 0;
        } catch (Exception unused) {
            cvb.O0000OOo();
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cvg.O000000o(java.lang.String, java.lang.Object):_m_j.cvg
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cvg.O000000o(java.lang.String, boolean):boolean
      _m_j.cvg.O000000o(java.lang.String, java.lang.Object):_m_j.cvg */
    private static int O000000o(cvg cvg, Intent intent, boolean z) {
        try {
            cuf cuf = (cuf) cvg.O000000o(cuf.class, "com.sankuai.waimai.router.activity.start_activity_action", null);
            if (!(cuf != null && cuf.O000000o(cvg, intent))) {
                return 500;
            }
            O000000o(cvg);
            if (z) {
                cvg.O000000o("com.sankuai.waimai.router.activity.started_activity", (Object) 1);
                new Object[1][0] = cvg;
                cvb.O00000o();
                return 200;
            }
            cvg.O000000o("com.sankuai.waimai.router.activity.started_activity", (Object) 2);
            new Object[1][0] = cvg;
            cvb.O00000o();
            return 200;
        } catch (ActivityNotFoundException unused) {
            cvb.O00000oO();
            return 404;
        } catch (SecurityException unused2) {
            cvb.O00000oO();
            return 403;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cvg.O000000o(java.lang.String, java.lang.Object):_m_j.cvg
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cvg.O000000o(java.lang.String, boolean):boolean
      _m_j.cvg.O000000o(java.lang.String, java.lang.Object):_m_j.cvg */
    private static int O000000o(cvg cvg, Context context, Intent intent, Integer num, boolean z) {
        try {
            Bundle bundle = (Bundle) cvg.O000000o(Bundle.class, "com.sankuai.waimai.router.activity.options", null);
            if (num == null || !(context instanceof Activity)) {
                oOOO00o0.O000000o(context, intent, bundle);
            } else {
                oOOO00o0.O000000o((Activity) context, intent, num.intValue(), bundle);
            }
            O000000o(cvg);
            if (z) {
                cvg.O000000o("com.sankuai.waimai.router.activity.started_activity", (Object) 1);
                new Object[1][0] = cvg;
                cvb.O00000o();
                return 200;
            }
            cvg.O000000o("com.sankuai.waimai.router.activity.started_activity", (Object) 2);
            new Object[1][0] = cvg;
            cvb.O00000o();
            return 200;
        } catch (ActivityNotFoundException unused) {
            cvb.O00000oO();
            return 404;
        } catch (SecurityException unused2) {
            cvb.O00000oO();
            return 403;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cvg.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cvg.O000000o(java.lang.String, java.lang.Object):_m_j.cvg
      _m_j.cvg.O000000o(java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cuu.O000000o(_m_j.cvg, android.content.Intent, android.content.Context, java.lang.Integer, boolean):int
     arg types: [_m_j.cvg, android.content.Intent, android.content.Context, java.lang.Integer, int]
     candidates:
      _m_j.cuu.O000000o(_m_j.cvg, android.content.Context, android.content.Intent, java.lang.Integer, boolean):int
      _m_j.cuu.O000000o(_m_j.cvg, android.content.Intent, android.content.Context, java.lang.Integer, boolean):int */
    public final int O000000o(cvg cvg, Intent intent) {
        if (cvg == null || intent == null) {
            return 500;
        }
        Context context = cvg.f14384O000000o;
        Bundle bundle = (Bundle) cvg.O000000o(Bundle.class, "com.sankuai.waimai.router.activity.intent_extra", null);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        Integer num = (Integer) cvg.O000000o(Integer.class, "com.sankuai.waimai.router.activity.flags", null);
        if (num != null) {
            intent.setFlags(num.intValue());
        }
        Integer num2 = (Integer) cvg.O000000o(Integer.class, "com.sankuai.waimai.router.activity.request_code", null);
        boolean O000000o2 = cvg.O000000o("com.sankuai.waimai.router.activity.limit_package", false);
        intent.setPackage(context.getPackageName());
        int O000000o3 = O000000o(cvg, intent, context, num2, true);
        if (O000000o2 || O000000o3 == 200) {
            return O000000o3;
        }
        intent.setPackage(null);
        return O000000o(cvg, intent, context, num2, false);
    }

    private static void O000000o(cvg cvg) {
        Context context = cvg.f14384O000000o;
        int[] iArr = (int[]) cvg.O000000o(int[].class, "com.sankuai.waimai.router.activity.animation", null);
        if ((context instanceof Activity) && iArr != null && iArr.length == 2) {
            ((Activity) context).overridePendingTransition(iArr[0], iArr[1]);
        }
    }
}
