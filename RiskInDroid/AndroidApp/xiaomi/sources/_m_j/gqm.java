package _m_j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public final class gqm extends BitmapDrawable {
    public final boolean isStateful() {
        return true;
    }

    public gqm(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
        setState(new int[]{16842919, 16842913, 16842910});
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        for (int i : iArr) {
            if (i == 16842919) {
                setAlpha(120);
            } else if (i == 16842913) {
                setAlpha(255);
            } else if (i == 16842910) {
                setAlpha(255);
            }
        }
        return true;
    }
}
