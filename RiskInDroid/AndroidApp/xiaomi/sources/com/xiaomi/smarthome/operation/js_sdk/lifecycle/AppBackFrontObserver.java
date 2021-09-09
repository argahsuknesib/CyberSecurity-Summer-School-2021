package com.xiaomi.smarthome.operation.js_sdk.lifecycle;

import _m_j.ez;
import _m_j.fa;
import _m_j.fi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import com.xiaomi.smarthome.application.ServiceApplication;

public class AppBackFrontObserver implements ez {

    /* renamed from: O000000o  reason: collision with root package name */
    public CurrentAppState f10519O000000o = null;
    public O000000o O00000Oo;
    private final Application.ActivityLifecycleCallbacks O00000o0 = new Application.ActivityLifecycleCallbacks() {
        /* class com.xiaomi.smarthome.operation.js_sdk.lifecycle.AppBackFrontObserver.AnonymousClass1 */

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
            if (AppBackFrontObserver.this.O00000Oo != null && AppBackFrontObserver.this.f10519O000000o != CurrentAppState.FRONT) {
                AppBackFrontObserver.this.f10519O000000o = CurrentAppState.FRONT;
                AppBackFrontObserver.this.O00000Oo.O000000o();
            }
        }
    };

    public enum CurrentAppState {
        BACK,
        FRONT
    }

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    @fi(O000000o = Lifecycle.Event.ON_CREATE)
    public void onCreate(fa faVar) {
        ServiceApplication.getApplication().registerActivityLifecycleCallbacks(this.O00000o0);
    }

    @fi(O000000o = Lifecycle.Event.ON_DESTROY)
    public void onDestroy(fa faVar) {
        ServiceApplication.getApplication().unregisterActivityLifecycleCallbacks(this.O00000o0);
    }
}
