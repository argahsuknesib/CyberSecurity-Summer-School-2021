package _m_j;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class con implements cok {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Reference<View> f14171O000000o;
    protected boolean O00000Oo;

    /* access modifiers changed from: protected */
    public abstract void O000000o(Bitmap bitmap, View view);

    /* access modifiers changed from: protected */
    public abstract void O000000o(Drawable drawable, View view);

    public con(View view) {
        this(view, (byte) 0);
    }

    private con(View view, byte b) {
        if (view != null) {
            this.f14171O000000o = new WeakReference(view);
            this.O00000Oo = true;
            return;
        }
        throw new IllegalArgumentException("view must not be null");
    }

    public int O000000o() {
        View view = this.f14171O000000o.get();
        int i = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(!this.O00000Oo || layoutParams == null || layoutParams.width == -2)) {
            i = view.getWidth();
        }
        return (i > 0 || layoutParams == null) ? i : layoutParams.width;
    }

    public int O00000Oo() {
        View view = this.f14171O000000o.get();
        int i = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(!this.O00000Oo || layoutParams == null || layoutParams.height == -2)) {
            i = view.getHeight();
        }
        return (i > 0 || layoutParams == null) ? i : layoutParams.height;
    }

    public ViewScaleType O00000o0() {
        return ViewScaleType.CROP;
    }

    public View O00000o() {
        return this.f14171O000000o.get();
    }

    public final boolean O00000oO() {
        return this.f14171O000000o.get() == null;
    }

    public final int O00000oo() {
        View view = this.f14171O000000o.get();
        return view == null ? super.hashCode() : view.hashCode();
    }

    public final boolean O000000o(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f14171O000000o.get();
            if (view != null) {
                O000000o(drawable, view);
                return true;
            }
        } else {
            cou.O00000o0("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    public final boolean O000000o(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f14171O000000o.get();
            if (view != null) {
                O000000o(bitmap, view);
                return true;
            }
        } else {
            cou.O00000o0("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }
}
