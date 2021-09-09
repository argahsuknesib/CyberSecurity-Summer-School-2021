package androidx.lifecycle;

import _m_j.fa;
import _m_j.fl;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.lifecycle.Lifecycle;

public class LifecycleService extends Service implements fa {

    /* renamed from: O000000o  reason: collision with root package name */
    private final fl f2879O000000o = new fl(this);

    public void onCreate() {
        this.f2879O000000o.O000000o(Lifecycle.Event.ON_CREATE);
        super.onCreate();
    }

    public IBinder onBind(Intent intent) {
        this.f2879O000000o.O000000o(Lifecycle.Event.ON_START);
        return null;
    }

    public void onStart(Intent intent, int i) {
        this.f2879O000000o.O000000o(Lifecycle.Event.ON_START);
        super.onStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        fl flVar = this.f2879O000000o;
        flVar.O000000o(Lifecycle.Event.ON_STOP);
        flVar.O000000o(Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
    }

    public Lifecycle getLifecycle() {
        return this.f2879O000000o.f16558O000000o;
    }
}
