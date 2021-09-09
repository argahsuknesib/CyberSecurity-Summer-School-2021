package com.xiaomi.onetrack.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import com.xiaomi.onetrack.c.g;
import com.xiaomi.onetrack.h.h;
import com.xiaomi.onetrack.h.q;

class j implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f6102a;
    private int b = 0;
    private int c;
    private long d;
    private boolean e;
    private boolean f;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    j(f fVar) {
        this.f6102a = fVar;
    }

    public void onActivityStarted(Activity activity) {
        if (this.b == 0) {
            this.f6102a.b.a(1);
            this.e = true;
            this.f = false;
            h.a();
        } else {
            this.e = false;
        }
        this.b++;
        q.a("OneTrackImp", "onActivityStarted: " + activity.getLocalClassName());
    }

    public void onActivityResumed(Activity activity) {
        this.f6102a.b(this.f);
        this.c = System.identityHashCode(activity);
        this.d = SystemClock.elapsedRealtime();
        this.f6102a.a(activity.getClass().getName(), this.e);
        if (q.f6178a) {
            q.a("OneTrackImp", "onActivityResumed:" + activity.getLocalClassName() + " isAppStart:" + this.e);
        }
        this.e = false;
        this.f6102a.d();
    }

    public void onActivityPaused(Activity activity) {
        this.f6102a.a(activity.getClass().getName(), this.c == System.identityHashCode(activity) ? SystemClock.elapsedRealtime() - this.d : 0);
        if (q.f6178a) {
            q.a("OneTrackImp", "onActivityPaused:" + activity.getLocalClassName());
        }
    }

    public void onActivityStopped(Activity activity) {
        this.b--;
        if (this.b == 0) {
            this.f6102a.b.a(2);
            if (g.b()) {
                this.f6102a.k();
            }
            this.f = true;
            this.e = false;
        } else {
            this.f = false;
        }
        this.f6102a.b(this.f);
        q.a("OneTrackImp", "onActivityStopped: " + activity.getLocalClassName());
    }
}
