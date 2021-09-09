package _m_j;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

public final class o000 extends Resources {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f2220O000000o = false;
    private final WeakReference<Context> O00000Oo;

    public o000(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.O00000Oo = new WeakReference<>(context);
    }

    public final Drawable getDrawable(int i) throws Resources.NotFoundException {
        Context context = this.O00000Oo.get();
        if (context != null) {
            return o0OOoOoo.O000000o().O000000o(context, this, i);
        }
        return super.getDrawable(i);
    }

    /* access modifiers changed from: package-private */
    public final Drawable O000000o(int i) {
        return super.getDrawable(i);
    }

    public static void O000000o(boolean z) {
        f2220O000000o = true;
    }

    public static boolean O000000o() {
        return f2220O000000o && Build.VERSION.SDK_INT <= 20;
    }
}
