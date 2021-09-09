package _m_j;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.push.hr;
import com.xiaomi.push.hx;

public final class eok implements Application.ActivityLifecycleCallbacks {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f15677O000000o = "";
    private String O00000Oo;
    private Context O00000o0;

    public eok(Context context, String str) {
        this.O00000o0 = context;
        this.f15677O000000o = str;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.O00000Oo)) {
            this.O00000Oo = activity.getLocalClassName();
        }
        this.f15677O000000o = String.valueOf(System.currentTimeMillis() / 1000);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (!TextUtils.isEmpty(this.f15677O000000o) && !TextUtils.isEmpty(localClassName)) {
            this.O00000Oo = "";
            if (TextUtils.isEmpty(this.O00000Oo) || TextUtils.equals(this.O00000Oo, localClassName)) {
                hx hxVar = new hx();
                hxVar.f64a = this.O00000o0.getPackageName() + "|" + localClassName + ":" + this.f15677O000000o + "," + String.valueOf(System.currentTimeMillis() / 1000);
                hxVar.O000000o(System.currentTimeMillis());
                hxVar.f63a = hr.s;
                eos.O000000o(this.O00000o0, hxVar);
                this.f15677O000000o = "";
                this.O00000Oo = "";
                return;
            }
            this.f15677O000000o = "";
        }
    }
}
