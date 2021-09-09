package com.github.ornolfr.ratingview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.xiaomi.smarthome.R;

public class RatingView extends View implements View.OnTouchListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f3606O000000o;
    private Bitmap O00000Oo;
    private Bitmap O00000o;
    private Bitmap O00000o0;
    private Rect O00000oO = new Rect();
    private boolean O00000oo;
    private float O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;

    public interface O000000o {
        void onRatingChange(float f, float f2);
    }

    public RatingView(Context context) {
        super(context);
        O000000o(null, 0, 0);
    }

    public RatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet, 0, 0);
    }

    public RatingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet, i, 0);
    }

    @TargetApi(21)
    public RatingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        O000000o(attributeSet, i, i2);
    }

    private void O000000o(AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.drawable_empty, R.attr.drawable_filled, R.attr.drawable_half, R.attr.drawable_margin, R.attr.drawable_size, R.attr.is_indicator, R.attr.max_count, R.attr.rating}, i, i2);
        this.O0000Oo = (int) obtainStyledAttributes.getDimension(3, TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()));
        this.O0000Oo0 = (int) obtainStyledAttributes.getDimension(4, TypedValue.applyDimension(1, 32.0f, getResources().getDisplayMetrics()));
        if (this.O0000Oo0 >= 0) {
            this.O0000OOo = obtainStyledAttributes.getInteger(6, 5);
            if (this.O0000OOo > 0) {
                this.O0000O0o = obtainStyledAttributes.getFloat(7, 3.5f);
                this.O00000oo = obtainStyledAttributes.getBoolean(5, false);
                this.O00000Oo = BitmapFactory.decodeResource(getContext().getResources(), obtainStyledAttributes.getResourceId(0, R.drawable.ic_star_empty));
                this.O00000o0 = BitmapFactory.decodeResource(getContext().getResources(), obtainStyledAttributes.getResourceId(2, R.drawable.ic_star_half));
                this.O00000o = BitmapFactory.decodeResource(getContext().getResources(), obtainStyledAttributes.getResourceId(1, R.drawable.ic_star_filled));
                obtainStyledAttributes.recycle();
                return;
            }
            throw new IllegalArgumentException("Max count < 1");
        }
        throw new IllegalArgumentException("Drawable size < 0");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.O0000Oo0;
        int i4 = this.O0000OOo;
        setMeasuredDimension(resolveSize((i3 * i4) + (this.O0000Oo * (i4 - 1)), i), resolveSize(this.O0000Oo0, i2));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.O00000oo) {
            setOnTouchListener(this);
        }
        if (this.O00000o != null && this.O00000o0 != null && this.O00000Oo != null) {
            Rect rect = this.O00000oO;
            int i = this.O0000Oo0;
            rect.set(0, 0, i, i);
            float f = this.O0000O0o;
            int i2 = (int) f;
            int round = this.O0000OOo - Math.round(f);
            if (this.O0000O0o - ((float) i2) >= 0.75f) {
                i2++;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                canvas.drawBitmap(this.O00000o, (Rect) null, this.O00000oO, (Paint) null);
                this.O00000oO.offset(this.O0000Oo0 + this.O0000Oo, 0);
            }
            float f2 = this.O0000O0o;
            float f3 = (float) i2;
            if (f2 - f3 >= 0.25f && f2 - f3 < 0.75f) {
                canvas.drawBitmap(this.O00000o0, (Rect) null, this.O00000oO, (Paint) null);
                this.O00000oO.offset(this.O0000Oo0 + this.O0000Oo, 0);
            }
            for (int i4 = 0; i4 < round; i4++) {
                canvas.drawBitmap(this.O00000Oo, (Rect) null, this.O00000oO, (Paint) null);
                this.O00000oO.offset(this.O0000Oo0 + this.O0000Oo, 0);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            return true;
        }
        if (actionMasked != 1) {
            return super.onTouchEvent(motionEvent);
        }
        double x = (double) ((motionEvent.getX() / ((float) getWidth())) * ((float) this.O0000OOo));
        Double.isNaN(x);
        setRating((float) Math.round(x + 0.5d));
        return false;
    }

    public void setOnRatingChangedListener(O000000o o000000o) {
        this.f3606O000000o = o000000o;
    }

    public void setIsIndicator(boolean z) {
        this.O00000oo = z;
        setOnTouchListener(this.O00000oo ? null : this);
    }

    public void setRating(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else {
            int i = this.O0000OOo;
            if (f > ((float) i)) {
                f = (float) i;
            }
        }
        O000000o o000000o = this.f3606O000000o;
        if (o000000o != null) {
            o000000o.onRatingChange(this.O0000O0o, f);
        }
        this.O0000O0o = f;
        invalidate();
    }

    public void setDrawableEmpty(Bitmap bitmap) {
        this.O00000Oo = bitmap;
        invalidate();
    }

    public void setDrawableHalf(Bitmap bitmap) {
        this.O00000o0 = bitmap;
        invalidate();
    }

    public void setDrawableFilled(Bitmap bitmap) {
        this.O00000o = bitmap;
        invalidate();
    }

    public float getRating() {
        return this.O0000O0o;
    }

    public int getMaxCount() {
        return this.O0000OOo;
    }

    public int getDrawableSize() {
        return this.O0000Oo0;
    }

    public int getDrawableMargin() {
        return this.O0000Oo;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3607O000000o = this.O0000O0o;
        savedState.O00000Oo = this.O00000oo;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.O0000O0o = savedState.f3607O000000o;
            this.O00000oo = savedState.O00000Oo;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.github.ornolfr.ratingview.RatingView.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        float f3607O000000o;
        boolean O00000Oo;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f3607O000000o = parcel.readFloat();
            this.O00000Oo = parcel.readInt() == 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f3607O000000o);
            parcel.writeInt(this.O00000Oo ? 1 : 0);
        }
    }
}
