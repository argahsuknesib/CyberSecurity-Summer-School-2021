package _m_j;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class jnx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final List<String> f1986O000000o = Arrays.asList("raw", "drawable", "mipmap");

    public static O000000o O000000o(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet == null || imageView.isInEditMode()) {
            return new O000000o();
        }
        O000000o o000000o = new O000000o(imageView, attributeSet, i, i2);
        int i3 = o000000o.O00000o;
        if (i3 >= 0) {
            O000000o(i3, imageView.getDrawable());
            O000000o(i3, imageView.getBackground());
        }
        return o000000o;
    }

    public static void O000000o(int i, Drawable drawable) {
        if (drawable instanceof jnw) {
            ((jnw) drawable).O000000o(i);
        }
    }

    public static boolean O000000o(ImageView imageView, boolean z, int i) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (!f1986O000000o.contains(resources.getResourceTypeName(i))) {
                    return false;
                }
                jnw jnw = new jnw(resources, i);
                if (z) {
                    imageView.setImageDrawable(jnw);
                    return true;
                }
                imageView.setBackground(jnw);
                return true;
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return false;
    }

    public static boolean O000000o(ImageView imageView, Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            imageView.setImageDrawable(new jnw(imageView.getContext().getContentResolver(), uri));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
     arg types: [int, android.util.TypedValue, int]
     candidates:
      ClspMth{android.content.res.Resources.getValue(java.lang.String, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException}
      ClspMth{android.content.res.Resources.getValue(int, android.util.TypedValue, boolean):void throws android.content.res.Resources$NotFoundException} */
    static float O000000o(Resources resources, int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.density;
        if (i2 == 0) {
            i2 = 160;
        } else if (i2 == 65535) {
            i2 = 0;
        }
        int i3 = resources.getDisplayMetrics().densityDpi;
        if (i2 <= 0 || i3 <= 0) {
            return 1.0f;
        }
        return ((float) i3) / ((float) i2);
    }

    public static class O00000Oo {
        public final int O00000o;
        public boolean O00000o0;

        public O00000Oo(View view, AttributeSet attributeSet, int i, int i2) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.freezesAnimation, R.attr.gif, R.attr.loopCount, R.attr.paused}, i, i2);
            this.O00000o0 = obtainStyledAttributes.getBoolean(0, false);
            this.O00000o = obtainStyledAttributes.getInt(2, -1);
            obtainStyledAttributes.recycle();
        }

        public O00000Oo() {
            this.O00000o0 = false;
            this.O00000o = -1;
        }
    }

    public static class O000000o extends O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f1987O000000o;
        public final int O00000Oo;

        O000000o(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
            super(imageView, attributeSet, i, i2);
            this.f1987O000000o = O000000o(imageView, attributeSet, true);
            this.O00000Oo = O000000o(imageView, attributeSet, false);
        }

        O000000o() {
            this.f1987O000000o = 0;
            this.O00000Oo = 0;
        }

        private static int O000000o(ImageView imageView, AttributeSet attributeSet, boolean z) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z ? "src" : "background", 0);
            if (attributeResourceValue > 0) {
                if (!jnx.f1986O000000o.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) || jnx.O000000o(imageView, z, attributeResourceValue)) {
                    return 0;
                }
                return attributeResourceValue;
            }
            return 0;
        }
    }
}
