package _m_j;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

public final class by {

    /* renamed from: O000000o  reason: collision with root package name */
    Object f13399O000000o;

    private by(Object obj) {
        this.f13399O000000o = obj;
    }

    public static by O000000o(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new by(PointerIcon.getSystemIcon(context, 1002));
        }
        return new by(null);
    }
}
