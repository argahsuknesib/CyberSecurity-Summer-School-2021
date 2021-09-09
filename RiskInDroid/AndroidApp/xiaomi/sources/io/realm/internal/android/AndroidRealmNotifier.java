package io.realm.internal.android;

import _m_j.irw;
import android.os.Handler;
import android.os.Looper;
import io.realm.internal.Keep;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.RealmNotifier;

@Keep
public class AndroidRealmNotifier extends RealmNotifier {
    private Handler handler;

    public AndroidRealmNotifier(OsSharedRealm osSharedRealm, irw irw) {
        super(osSharedRealm);
        if (irw.O000000o()) {
            this.handler = new Handler(Looper.myLooper());
        } else {
            this.handler = null;
        }
    }

    public boolean post(Runnable runnable) {
        Handler handler2 = this.handler;
        return handler2 != null && handler2.post(runnable);
    }
}
