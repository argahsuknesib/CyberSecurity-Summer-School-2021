package androidx.appcompat.widget;

import _m_j.OOO0oO;
import _m_j.OOOO00O;
import _m_j.Oo000;
import _m_j.ca;
import _m_j.db;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView extends ImageView implements ca, db {
    private final OOO0oO mBackgroundTintHelper;
    private final OOOO00O mImageHelper;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        Oo000.O000000o(this, getContext());
        this.mBackgroundTintHelper = new OOO0oO(this);
        this.mBackgroundTintHelper.O000000o(attributeSet, i);
        this.mImageHelper = new OOOO00O(this);
        this.mImageHelper.O000000o(attributeSet, i);
    }

    public void setImageResource(int i) {
        OOOO00O oooo00o = this.mImageHelper;
        if (oooo00o != null) {
            oooo00o.O000000o(i);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        OOOO00O oooo00o = this.mImageHelper;
        if (oooo00o != null) {
            oooo00o.O00000o();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        OOOO00O oooo00o = this.mImageHelper;
        if (oooo00o != null) {
            oooo00o.O00000o();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        OOOO00O oooo00o = this.mImageHelper;
        if (oooo00o != null) {
            oooo00o.O00000o();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            return oOO0oO.O00000Oo();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            return oOO0oO.O00000o0();
        }
        return null;
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        OOOO00O oooo00o = this.mImageHelper;
        if (oooo00o != null) {
            oooo00o.O000000o(colorStateList);
        }
    }

    public ColorStateList getSupportImageTintList() {
        OOOO00O oooo00o = this.mImageHelper;
        if (oooo00o != null) {
            return oooo00o.O00000Oo();
        }
        return null;
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        OOOO00O oooo00o = this.mImageHelper;
        if (oooo00o != null) {
            oooo00o.O000000o(mode);
        }
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        OOOO00O oooo00o = this.mImageHelper;
        if (oooo00o != null) {
            return oooo00o.O00000o0();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O00000o();
        }
        OOOO00O oooo00o = this.mImageHelper;
        if (oooo00o != null) {
            oooo00o.O00000o();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.mImageHelper.O000000o() && super.hasOverlappingRendering();
    }
}
