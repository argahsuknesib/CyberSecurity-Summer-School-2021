package _m_j;

import _m_j.fn;
import android.app.Application;
import androidx.fragment.app.FragmentActivity;

public final class fo {
    public static fn O000000o(FragmentActivity fragmentActivity) {
        Application application = fragmentActivity.getApplication();
        if (application != null) {
            if (fn.O000000o.f16682O000000o == null) {
                fn.O000000o.f16682O000000o = new fn.O000000o(application);
            }
            return new fn(fragmentActivity.getViewModelStore(), fn.O000000o.f16682O000000o);
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }
}
