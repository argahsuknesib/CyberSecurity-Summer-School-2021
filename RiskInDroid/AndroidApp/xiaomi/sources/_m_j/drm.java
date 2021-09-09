package _m_j;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.Method;

@TargetApi(14)
public final class drm {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final O000000o f14874O000000o;

    @TargetApi(16)
    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        static Method f14875O000000o;

        O000000o() {
        }
    }

    @TargetApi(18)
    static class O00000Oo extends O000000o {
        O00000Oo() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            f14874O000000o = new O00000Oo();
        } else {
            f14874O000000o = new O000000o();
        }
    }

    public static boolean O000000o(ViewGroup viewGroup) {
        LayoutTransition layoutTransition;
        if (viewGroup == null || (layoutTransition = viewGroup.getLayoutTransition()) == null || !layoutTransition.isRunning()) {
            return false;
        }
        if (O000000o.f14875O000000o == null) {
            O000000o.f14875O000000o = drl.O00000Oo(LayoutTransition.class, "cancel", new Class[0]);
        }
        drl.O000000o(viewGroup.getLayoutTransition(), O000000o.f14875O000000o);
        return true;
    }
}
