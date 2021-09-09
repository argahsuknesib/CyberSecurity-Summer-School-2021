package pl.droidsonroids.gif;

import _m_j.jnx;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class GifImageView extends ImageView {
    private boolean mFreezesAnimation;

    public GifImageView(Context context) {
        super(context);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        postInit(jnx.O000000o(this, attributeSet, 0, 0));
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        postInit(jnx.O000000o(this, attributeSet, i, 0));
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        postInit(jnx.O000000o(this, attributeSet, i, i2));
    }

    private void postInit(jnx.O000000o o000000o) {
        this.mFreezesAnimation = o000000o.O00000o0;
        if (o000000o.f1987O000000o > 0) {
            super.setImageResource(o000000o.f1987O000000o);
        }
        if (o000000o.O00000Oo > 0) {
            super.setBackgroundResource(o000000o.O00000Oo);
        }
    }

    public void setImageURI(Uri uri) {
        if (!jnx.O000000o(this, uri)) {
            super.setImageURI(uri);
        }
    }

    public void setImageResource(int i) {
        if (!jnx.O000000o(this, true, i)) {
            super.setImageResource(i);
        }
    }

    public void setBackgroundResource(int i) {
        if (!jnx.O000000o(this, false, i)) {
            super.setBackgroundResource(i);
        }
    }

    public Parcelable onSaveInstanceState() {
        Drawable drawable = null;
        Drawable drawable2 = this.mFreezesAnimation ? getDrawable() : null;
        if (this.mFreezesAnimation) {
            drawable = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawable2, drawable);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.O000000o(getDrawable(), 0);
        gifViewSavedState.O000000o(getBackground(), 1);
    }

    public void setFreezesAnimation(boolean z) {
        this.mFreezesAnimation = z;
    }
}
