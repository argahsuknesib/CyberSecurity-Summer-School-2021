package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.xiaomi.smarthome.R;

class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    private boolean mHasTickMarkTint = false;
    private boolean mHasTickMarkTintMode = false;
    private Drawable mTickMark;
    private ColorStateList mTickMarkTintList = null;
    private PorterDuff.Mode mTickMarkTintMode = null;
    private final SeekBar mView;

    AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.mView = seekBar;
    }

    /* access modifiers changed from: package-private */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        super.loadFromAttributes(attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, new int[]{16843074, R.attr.tickMark, R.attr.tickMarkTint, R.attr.tickMarkTintMode}, i, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            this.mView.setThumb(drawableIfKnown);
        }
        setTickMark(obtainStyledAttributes.getDrawable(1));
        if (obtainStyledAttributes.hasValue(3)) {
            this.mTickMarkTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(3, -1), this.mTickMarkTintMode);
            this.mHasTickMarkTintMode = true;
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.mTickMarkTintList = obtainStyledAttributes.getColorStateList(2);
            this.mHasTickMarkTint = true;
        }
        obtainStyledAttributes.recycle();
        applyTickMarkTint();
    }

    /* access modifiers changed from: package-private */
    public void setTickMark(@Nullable Drawable drawable) {
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTickMark = drawable;
        if (drawable != null) {
            drawable.setCallback(this.mView);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.mView));
            if (drawable.isStateful()) {
                drawable.setState(this.mView.getDrawableState());
            }
            applyTickMarkTint();
        }
        this.mView.invalidate();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Drawable getTickMark() {
        return this.mTickMark;
    }

    /* access modifiers changed from: package-private */
    public void setTickMarkTintList(@Nullable ColorStateList colorStateList) {
        this.mTickMarkTintList = colorStateList;
        this.mHasTickMarkTint = true;
        applyTickMarkTint();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    /* access modifiers changed from: package-private */
    public void setTickMarkTintMode(@Nullable PorterDuff.Mode mode) {
        this.mTickMarkTintMode = mode;
        this.mHasTickMarkTintMode = true;
        applyTickMarkTint();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public PorterDuff.Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    private void applyTickMarkTint() {
        if (this.mTickMark == null) {
            return;
        }
        if (this.mHasTickMarkTint || this.mHasTickMarkTintMode) {
            this.mTickMark = DrawableCompat.wrap(this.mTickMark.mutate());
            if (this.mHasTickMarkTint) {
                DrawableCompat.setTintList(this.mTickMark, this.mTickMarkTintList);
            }
            if (this.mHasTickMarkTintMode) {
                DrawableCompat.setTintMode(this.mTickMark, this.mTickMarkTintMode);
            }
            if (this.mTickMark.isStateful()) {
                this.mTickMark.setState(this.mView.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(11)
    @RequiresApi(11)
    public void jumpDrawablesToCurrentState() {
        Drawable drawable = this.mTickMark;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    public void drawableStateChanged() {
        Drawable drawable = this.mTickMark;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.mView.getDrawableState())) {
            this.mView.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawTickMarks(Canvas canvas) {
        if (this.mTickMark != null) {
            int max = this.mView.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = this.mTickMark.getIntrinsicWidth();
                int intrinsicHeight = this.mTickMark.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.mTickMark.setBounds(-i2, -i, i2, i);
                float width = ((float) ((this.mView.getWidth() - this.mView.getPaddingLeft()) - this.mView.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.mView.getPaddingLeft(), (float) (this.mView.getHeight() / 2));
                for (int i3 = 0; i3 <= max; i3++) {
                    this.mTickMark.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
