package _m_j;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

final class esp implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f15775O000000o;
    final /* synthetic */ ComponentName O00000Oo;

    esp(Context context, ComponentName componentName) {
        this.f15775O000000o = context;
        this.O00000Oo = componentName;
    }

    public final void run() {
        try {
            PackageManager packageManager = this.f15775O000000o.getPackageManager();
            if (packageManager.getComponentEnabledSetting(this.O00000Oo) != 2) {
                packageManager.setComponentEnabledSetting(this.O00000Oo, 2, 1);
            }
        } catch (Throwable th) {
            duv.O000000o("close static register of network status receiver failed:".concat(String.valueOf(th)));
        }
    }
}
