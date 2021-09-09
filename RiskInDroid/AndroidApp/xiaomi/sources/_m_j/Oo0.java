package _m_j;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public final class Oo0 extends OOo0000 {

    /* renamed from: O000000o  reason: collision with root package name */
    private final WeakReference<Context> f12341O000000o;

    public Oo0(Context context, Resources resources) {
        super(resources);
        this.f12341O000000o = new WeakReference<>(context);
    }

    public final Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f12341O000000o.get();
        if (!(drawable == null || context == null)) {
            o0OOoOoo.O000000o().O000000o(context, i, drawable);
        }
        return drawable;
    }
}
