package _m_j;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

@TargetApi(14)
public final class eac implements Application.ActivityLifecycleCallbacks {

    /* renamed from: O000000o  reason: collision with root package name */
    private Set<String> f15117O000000o = new HashSet();

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("messageId");
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (!TextUtils.isEmpty(stringExtra) && intExtra > 0 && !this.f15117O000000o.contains(stringExtra)) {
                this.f15117O000000o.add(stringExtra);
                if (intExtra == 3000) {
                    epj.O000000o(activity.getApplicationContext()).O000000o(activity.getPackageName(), epi.O000000o(intExtra), stringExtra, 3008, null);
                } else if (intExtra == 1000) {
                    epj.O000000o(activity.getApplicationContext()).O000000o(activity.getPackageName(), epi.O000000o(intExtra), stringExtra, 1008, null);
                }
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public static void O000000o(Context context) {
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new eac());
    }
}
