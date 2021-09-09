package _m_j;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ex {

    /* renamed from: O000000o  reason: collision with root package name */
    private static AtomicBoolean f15908O000000o = new AtomicBoolean(false);

    public static void O000000o(Context context) {
        if (!f15908O000000o.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new O000000o());
        }
    }

    static class O000000o extends et {
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        O000000o() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            fk.O000000o(activity);
        }
    }
}
