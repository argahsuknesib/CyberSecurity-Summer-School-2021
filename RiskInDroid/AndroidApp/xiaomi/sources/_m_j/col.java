package _m_j;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.reflect.Field;

public final class col extends con {
    public col(ImageView imageView) {
        super(imageView);
    }

    public final int O000000o() {
        ImageView imageView;
        int O000000o2 = super.O000000o();
        return (O000000o2 > 0 || (imageView = (ImageView) this.f14171O000000o.get()) == null) ? O000000o2 : O000000o(imageView, "mMaxWidth");
    }

    public final int O00000Oo() {
        ImageView imageView;
        int O00000Oo = super.O00000Oo();
        return (O00000Oo > 0 || (imageView = (ImageView) this.f14171O000000o.get()) == null) ? O00000Oo : O000000o(imageView, "mMaxHeight");
    }

    public final ViewScaleType O00000o0() {
        ImageView imageView = (ImageView) this.f14171O000000o.get();
        if (imageView != null) {
            return ViewScaleType.fromImageView(imageView);
        }
        return super.O00000o0();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    private static int O000000o(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return intValue;
        } catch (Exception e) {
            cou.O000000o(e);
            return 0;
        }
    }

    public final /* bridge */ /* synthetic */ View O00000o() {
        return (ImageView) super.O00000o();
    }
}
