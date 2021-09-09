package _m_j;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import io.reactivex.Observable;

public final class dgb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Object f14595O000000o = new Object();
    dgc O00000Oo;

    public dgb(Activity activity) {
        dgc dgc = (dgc) activity.getFragmentManager().findFragmentByTag("RxPermissions");
        if (dgc == null) {
            dgc = new dgc();
            FragmentManager fragmentManager = activity.getFragmentManager();
            fragmentManager.beginTransaction().add(dgc, "RxPermissions").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        this.O00000Oo = dgc;
    }

    /* access modifiers changed from: package-private */
    public final Observable<?> O000000o(String... strArr) {
        for (String containsKey : strArr) {
            if (!this.O00000Oo.f14599O000000o.containsKey(containsKey)) {
                return Observable.empty();
            }
        }
        return Observable.just(f14595O000000o);
    }

    static boolean O000000o() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
