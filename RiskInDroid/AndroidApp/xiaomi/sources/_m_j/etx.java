package _m_j;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.router.miio.miioplugin.IPluginRequest;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.framework.plugin.PluginService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class etx {
    private static etx O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public IPluginRequest f15811O000000o;
    public volatile boolean O00000Oo = false;
    public List<WeakReference<O000000o>> O00000o0 = new ArrayList();
    private ServiceConnection O00000oO = new ServiceConnection() {
        /* class _m_j.etx.AnonymousClass1 */

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (etx.this) {
                etx.this.f15811O000000o = IPluginRequest.Stub.asInterface(iBinder);
                etx.this.O00000Oo = false;
                for (WeakReference next : etx.this.O00000o0) {
                    if (next.get() != null) {
                        ((O000000o) next.get()).onBindService(etx.this.f15811O000000o);
                    }
                }
                etx.this.O00000o0.clear();
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            etx etx = etx.this;
            etx.O00000Oo = false;
            etx.f15811O000000o = null;
            for (WeakReference next : etx.O00000o0) {
                if (next.get() != null) {
                    ((O000000o) next.get()).onBindService(etx.this.f15811O000000o);
                }
            }
            etx.this.O00000o0.clear();
        }
    };

    public interface O000000o {
        void onBindService(IPluginRequest iPluginRequest);
    }

    public static etx O000000o() {
        if (O00000o == null) {
            O00000o = new etx();
        }
        return O00000o;
    }

    private etx() {
    }

    public final IPluginRequest O00000Oo() {
        if (this.f15811O000000o == null) {
            CommonApplication.getAppContext().bindService(new Intent(CommonApplication.getAppContext(), PluginService.class), this.O00000oO, 1);
            this.O00000Oo = true;
        }
        return this.f15811O000000o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        return;
     */
    public final synchronized void O000000o(O000000o o000000o) {
        if (this.f15811O000000o != null) {
            if (o000000o != null) {
                o000000o.onBindService(this.f15811O000000o);
            }
        } else if (this.O00000Oo) {
            this.O00000o0.add(new WeakReference(o000000o));
        } else {
            CommonApplication.getAppContext().bindService(new Intent(CommonApplication.getAppContext(), PluginService.class), this.O00000oO, 1);
            this.O00000Oo = true;
        }
    }
}
