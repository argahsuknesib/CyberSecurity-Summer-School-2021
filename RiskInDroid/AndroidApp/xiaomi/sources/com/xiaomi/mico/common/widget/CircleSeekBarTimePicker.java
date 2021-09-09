package com.xiaomi.mico.common.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.xiaomi.smarthome.R;

public class CircleSeekBarTimePicker extends View {
    private boolean isCanTouch;
    private boolean isHasCache;
    private boolean isHasPointerShadow;
    private boolean isHasReachedCornerRound;
    private boolean isHasWheelShadow;
    private boolean isScrollOneCircle;
    private Bitmap mCacheBitmap;
    private Canvas mCacheCanvas;
    private OnSeekBarChangeListener mChangListener;
    private double mCurAngle;
    private int mCurProcess;
    private float mDefShadowOffset;
    private int mMaxProcess;
    private int mPointerColor;
    private Paint mPointerPaint;
    private float mPointerRadius;
    private float mPointerShadowRadius;
    private int mReachedColor;
    private Paint mReachedEdgePaint;
    private Paint mReachedPaint;
    private float mReachedWidth;
    private Bitmap mThumbBitmap;
    private int mThumbHalfSize;
    private int mThumbSize;
    private int mUnreachedColor;
    private float mUnreachedRadius;
    private float mUnreachedWidth;
    private float mWheelCurX;
    private float mWheelCurY;
    private Paint mWheelPaint;
    private float mWheelShadowRadius;
    private RectF thumbRect;

    public interface OnSeekBarChangeListener {
        void onChanged(CircleSeekBarTimePicker circleSeekBarTimePicker, int i);
    }

    public CircleSeekBarTimePicker(Context context) {
        this(context, null);
    }

    public CircleSeekBarTimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleSeekBarTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttrs(attributeSet, i);
        initPadding();
        initPaints();
    }

    private void initPaints() {
        this.mDefShadowOffset = getDimen(R.dimen.def_shadow_offset);
        this.mWheelPaint = new Paint(1);
        this.mWheelPaint.setColor(this.mUnreachedColor);
        this.mWheelPaint.setStyle(Paint.Style.STROKE);
        this.mWheelPaint.setStrokeWidth(this.mUnreachedWidth);
        if (this.isHasWheelShadow) {
            Paint paint = this.mWheelPaint;
            float f = this.mWheelShadowRadius;
            float f2 = this.mDefShadowOffset;
            paint.setShadowLayer(f, f2, f2, -12303292);
        }
        this.mReachedPaint = new Paint(1);
        this.mReachedPaint.setColor(this.mReachedColor);
        this.mReachedPaint.setStyle(Paint.Style.STROKE);
        this.mReachedPaint.setStrokeWidth(this.mReachedWidth);
        if (this.isHasReachedCornerRound) {
            this.mReachedPaint.setStrokeCap(Paint.Cap.ROUND);
        }
        this.mPointerPaint = new Paint(1);
        this.mPointerPaint.setColor(this.mPointerColor);
        this.mPointerPaint.setStyle(Paint.Style.FILL);
        if (this.isHasPointerShadow) {
            Paint paint2 = this.mPointerPaint;
            float f3 = this.mPointerShadowRadius;
            float f4 = this.mDefShadowOffset;
            paint2.setShadowLayer(f3, f4, f4, -12303292);
        }
        this.mReachedEdgePaint = new Paint(this.mReachedPaint);
        this.mReachedEdgePaint.setStyle(Paint.Style.FILL);
        this.mThumbBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_thumb_alarm);
        this.mThumbSize = this.mThumbBitmap.getWidth();
        this.mThumbHalfSize = this.mThumbSize / 2;
        this.thumbRect = new RectF();
    }

    private void initAttrs(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.wheel_can_touch, R.attr.wheel_cur_process, R.attr.wheel_has_cache, R.attr.wheel_has_pointer_shadow, R.attr.wheel_has_wheel_shadow, R.attr.wheel_max_process, R.attr.wheel_pointer_color, R.attr.wheel_pointer_radius, R.attr.wheel_pointer_shadow_radius, R.attr.wheel_reached_color, R.attr.wheel_reached_has_corner_round, R.attr.wheel_reached_width, R.attr.wheel_scroll_only_one_circle, R.attr.wheel_shadow_radius, R.attr.wheel_unreached_color, R.attr.wheel_unreached_width}, i, 0);
        this.mMaxProcess = obtainStyledAttributes.getInt(5, 100);
        this.mCurProcess = obtainStyledAttributes.getInt(1, 0);
        int i2 = this.mCurProcess;
        int i3 = this.mMaxProcess;
        if (i2 > i3) {
            this.mCurProcess = i3;
        }
        this.mReachedColor = obtainStyledAttributes.getColor(9, getColor(R.color.mj_color_red_normal));
        this.mUnreachedColor = obtainStyledAttributes.getColor(14, getColor(R.color.mj_color_white));
        this.mUnreachedWidth = obtainStyledAttributes.getDimension(15, getDimen(R.dimen.def_wheel_width));
        this.isHasReachedCornerRound = obtainStyledAttributes.getBoolean(10, true);
        this.mReachedWidth = obtainStyledAttributes.getDimension(11, this.mUnreachedWidth);
        this.mPointerColor = obtainStyledAttributes.getColor(6, getColor(R.color.mj_color_white));
        this.mPointerRadius = obtainStyledAttributes.getDimension(7, this.mReachedWidth / 2.0f);
        this.isHasWheelShadow = obtainStyledAttributes.getBoolean(4, false);
        if (this.isHasWheelShadow) {
            this.mWheelShadowRadius = obtainStyledAttributes.getDimension(13, getDimen(R.dimen.def_shadow_radius));
        }
        this.isHasPointerShadow = obtainStyledAttributes.getBoolean(3, false);
        if (this.isHasPointerShadow) {
            this.mPointerShadowRadius = obtainStyledAttributes.getDimension(8, getDimen(R.dimen.def_shadow_radius));
        }
        this.isHasCache = obtainStyledAttributes.getBoolean(2, this.isHasWheelShadow);
        this.isCanTouch = obtainStyledAttributes.getBoolean(0, true);
        this.isScrollOneCircle = obtainStyledAttributes.getBoolean(12, false);
        if (this.isHasPointerShadow || this.isHasWheelShadow) {
            setSoftwareLayer();
        }
        obtainStyledAttributes.recycle();
    }

    private void initPadding() {
        int i;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int i2 = 0;
        if (Build.VERSION.SDK_INT >= 17) {
            i2 = getPaddingStart();
            i = getPaddingEnd();
        } else {
            i = 0;
        }
        int max = Math.max(paddingLeft, Math.max(paddingTop, Math.max(paddingRight, Math.max(paddingBottom, Math.max(i2, i)))));
        setPadding(max, max, max, max);
    }

    @TargetApi(23)
    private int getColor(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return getContext().getColor(i);
        }
        return ContextCompat.O00000o0(getContext(), i);
    }

    private float getDimen(int i) {
        return getResources().getDimension(i);
    }

    private void setSoftwareLayer() {
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int min = Math.min(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension(min, min);
        refershPosition();
        refershUnreachedWidth();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.getWidth();
        getPaddingLeft();
        getPaddingRight();
        canvas.drawArc(new RectF(((float) getPaddingLeft()) + (this.mUnreachedWidth / 2.0f), ((float) getPaddingTop()) + (this.mUnreachedWidth / 2.0f), ((float) (canvas.getWidth() - getPaddingRight())) - (this.mUnreachedWidth / 2.0f), ((float) (canvas.getHeight() - getPaddingBottom())) - (this.mUnreachedWidth / 2.0f)), -90.0f, (float) this.mCurAngle, false, this.mReachedPaint);
        float f = this.mWheelCurX;
        int i = this.mThumbHalfSize;
        float f2 = f - ((float) i);
        float f3 = this.mWheelCurY - ((float) i);
        canvas.drawBitmap(this.mThumbBitmap, f2, f3, this.mPointerPaint);
        RectF rectF = this.thumbRect;
        rectF.left = f2;
        rectF.top = f3;
        int i2 = this.mThumbSize;
        rectF.right = f2 + ((float) i2);
        rectF.bottom = f3 + ((float) i2);
    }

    private void buildCache(float f, float f2, float f3) {
        this.mCacheBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.mCacheCanvas = new Canvas(this.mCacheBitmap);
        this.mCacheCanvas.drawCircle(f, f2, f3, this.mWheelPaint);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        double d;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (motionEvent.getAction() == 0 && !isTouchThumb(x, y)) {
            return false;
        }
        if (!this.isCanTouch || (motionEvent.getAction() != 2 && !isTouchThumb(x, y))) {
            return super.onTouchEvent(motionEvent);
        }
        float computeCos = computeCos(x, y);
        if (x < ((float) (getWidth() / 2))) {
            d = (Math.acos((double) computeCos) * 57.29577951308232d) + 180.0d;
        } else {
            d = 180.0d - (Math.acos((double) computeCos) * 57.29577951308232d);
        }
        float f = -1.0f;
        if (!this.isScrollOneCircle) {
            this.mCurAngle = d;
        } else if (this.mCurAngle > 270.0d && d < 90.0d) {
            this.mCurAngle = 360.0d;
            this.mCurProcess = getSelectedValue();
            refershWheelCurPosition((double) f);
            this.mChangListener.onChanged(this, this.mCurProcess);
            invalidate();
            return true;
        } else if (this.mCurAngle >= 90.0d || d <= 270.0d) {
            this.mCurAngle = d;
        } else {
            this.mCurAngle = 0.0d;
            this.mCurProcess = getSelectedValue();
            refershWheelCurPosition((double) f);
            if (this.mChangListener != null && (motionEvent.getAction() & 3) > 0) {
                this.mChangListener.onChanged(this, this.mCurProcess);
            }
            invalidate();
            return true;
        }
        f = computeCos;
        this.mCurProcess = getSelectedValue();
        refershWheelCurPosition((double) f);
        this.mChangListener.onChanged(this, this.mCurProcess);
        invalidate();
        return true;
    }

    private boolean isTouch(float f, float f2) {
        double width = (double) ((((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) + getCircleWidth()) / 2.0f);
        double width2 = (double) (getWidth() / 2);
        double height = (double) (getHeight() / 2);
        double d = (double) f;
        Double.isNaN(width2);
        Double.isNaN(d);
        double pow = Math.pow(width2 - d, 2.0d);
        double d2 = (double) f2;
        Double.isNaN(height);
        Double.isNaN(d2);
        Double.isNaN(width);
        Double.isNaN(width);
        return pow + Math.pow(height - d2, 2.0d) < width * width;
    }

    private boolean isTouchThumb(float f, float f2) {
        return this.thumbRect.contains(f, f2);
    }

    private float getCircleWidth() {
        return Math.max(this.mUnreachedWidth, Math.max(this.mReachedWidth, this.mPointerRadius));
    }

    private void refershUnreachedWidth() {
        this.mUnreachedRadius = (((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) - this.mUnreachedWidth) / 2.0f;
    }

    private void refershWheelCurPosition(double d) {
        this.mWheelCurX = calcXLocationInWheel(this.mCurAngle, d);
        this.mWheelCurY = calcYLocationInWheel(d);
    }

    private void refershPosition() {
        double d = (double) this.mCurProcess;
        double d2 = (double) this.mMaxProcess;
        Double.isNaN(d);
        Double.isNaN(d2);
        this.mCurAngle = (d / d2) * 360.0d;
        refershWheelCurPosition(-Math.cos(Math.toRadians(this.mCurAngle)));
    }

    private float calcXLocationInWheel(double d, double d2) {
        double d3;
        if (d < 180.0d) {
            double measuredWidth = (double) (getMeasuredWidth() / 2);
            double sqrt = Math.sqrt(1.0d - (d2 * d2));
            double d4 = (double) this.mUnreachedRadius;
            Double.isNaN(d4);
            Double.isNaN(measuredWidth);
            d3 = measuredWidth + (sqrt * d4);
        } else {
            double measuredWidth2 = (double) (getMeasuredWidth() / 2);
            double sqrt2 = Math.sqrt(1.0d - (d2 * d2));
            double d5 = (double) this.mUnreachedRadius;
            Double.isNaN(d5);
            Double.isNaN(measuredWidth2);
            d3 = measuredWidth2 - (sqrt2 * d5);
        }
        return (float) d3;
    }

    private float calcYLocationInWheel(double d) {
        return ((float) (getMeasuredWidth() / 2)) + (this.mUnreachedRadius * ((float) d));
    }

    private float computeCos(float f, float f2) {
        float width = f - ((float) (getWidth() / 2));
        float height = f2 - ((float) (getHeight() / 2));
        return height / ((float) Math.sqrt((double) ((width * width) + (height * height))));
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state", super.onSaveInstanceState());
        bundle.putInt("max_process", this.mMaxProcess);
        bundle.putInt("cur_process", this.mCurProcess);
        bundle.putInt("reached_color", this.mReachedColor);
        bundle.putFloat("reached_width", this.mReachedWidth);
        bundle.putBoolean("reached_corner_round", this.isHasReachedCornerRound);
        bundle.putInt("unreached_color", this.mUnreachedColor);
        bundle.putFloat("unreached_width", this.mUnreachedWidth);
        bundle.putInt("pointer_color", this.mPointerColor);
        bundle.putFloat("pointer_radius", this.mPointerRadius);
        bundle.putBoolean("pointer_shadow", this.isHasPointerShadow);
        bundle.putFloat("pointer_shadow_radius", this.mPointerShadowRadius);
        bundle.putBoolean("wheel_shadow", this.isHasWheelShadow);
        bundle.putFloat("wheel_shadow_radius", this.mPointerShadowRadius);
        bundle.putBoolean("wheel_has_cache", this.isHasCache);
        bundle.putBoolean("wheel_can_touch", this.isCanTouch);
        bundle.putBoolean("wheel_scroll_only_one_circle", this.isScrollOneCircle);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("state"));
            this.mMaxProcess = bundle.getInt("max_process");
            this.mCurProcess = bundle.getInt("cur_process");
            this.mReachedColor = bundle.getInt("reached_color");
            this.mReachedWidth = bundle.getFloat("reached_width");
            this.isHasReachedCornerRound = bundle.getBoolean("reached_corner_round");
            this.mUnreachedColor = bundle.getInt("unreached_color");
            this.mUnreachedWidth = bundle.getFloat("unreached_width");
            this.mPointerColor = bundle.getInt("pointer_color");
            this.mPointerRadius = bundle.getFloat("pointer_radius");
            this.isHasPointerShadow = bundle.getBoolean("pointer_shadow");
            this.mPointerShadowRadius = bundle.getFloat("pointer_shadow_radius");
            this.isHasWheelShadow = bundle.getBoolean("wheel_shadow");
            this.mPointerShadowRadius = bundle.getFloat("wheel_shadow_radius");
            this.isHasCache = bundle.getBoolean("wheel_has_cache");
            this.isCanTouch = bundle.getBoolean("wheel_can_touch");
            this.isScrollOneCircle = bundle.getBoolean("wheel_scroll_only_one_circle");
            initPaints();
        } else {
            super.onRestoreInstanceState(parcelable);
        }
        OnSeekBarChangeListener onSeekBarChangeListener = this.mChangListener;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onChanged(this, this.mCurProcess);
        }
    }

    private int getSelectedValue() {
        return Math.round(((float) this.mMaxProcess) * (((float) this.mCurAngle) / 360.0f));
    }

    public int getCurProcess() {
        return this.mCurProcess;
    }

    public void setCurProcess(int i) {
        int i2 = this.mMaxProcess;
        if (i <= i2) {
            i2 = i;
        }
        this.mCurProcess = i2;
        OnSeekBarChangeListener onSeekBarChangeListener = this.mChangListener;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onChanged(this, i);
        }
        refershPosition();
        invalidate();
    }

    public int getMaxProcess() {
        return this.mMaxProcess;
    }

    public void setMaxProcess(int i) {
        this.mMaxProcess = i;
        refershPosition();
        invalidate();
    }

    public int getReachedColor() {
        return this.mReachedColor;
    }

    public void setReachedColor(int i) {
        this.mReachedColor = i;
        this.mReachedPaint.setColor(i);
        this.mReachedEdgePaint.setColor(i);
        invalidate();
    }

    public int getUnreachedColor() {
        return this.mUnreachedColor;
    }

    public void setUnreachedColor(int i) {
        this.mUnreachedColor = i;
        this.mWheelPaint.setColor(i);
        invalidate();
    }

    public float getReachedWidth() {
        return this.mReachedWidth;
    }

    public void setReachedWidth(float f) {
        this.mReachedWidth = f;
        this.mReachedPaint.setStrokeWidth(f);
        this.mReachedEdgePaint.setStrokeWidth(f);
        invalidate();
    }

    public boolean isHasReachedCornerRound() {
        return this.isHasReachedCornerRound;
    }

    public void setHasReachedCornerRound(boolean z) {
        this.isHasReachedCornerRound = z;
        this.mReachedPaint.setStrokeCap(z ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        invalidate();
    }

    public float getUnreachedWidth() {
        return this.mUnreachedWidth;
    }

    public void setUnreachedWidth(float f) {
        this.mUnreachedWidth = f;
        this.mWheelPaint.setStrokeWidth(f);
        refershUnreachedWidth();
        invalidate();
    }

    public int getPointerColor() {
        return this.mPointerColor;
    }

    public void setPointerColor(int i) {
        this.mPointerColor = i;
        this.mPointerPaint.setColor(i);
    }

    public float getPointerRadius() {
        return this.mPointerRadius;
    }

    public void setPointerRadius(float f) {
        this.mPointerRadius = f;
        this.mPointerPaint.setStrokeWidth(f);
        invalidate();
    }

    public boolean isHasWheelShadow() {
        return this.isHasWheelShadow;
    }

    public void setWheelShadow(float f) {
        this.mWheelShadowRadius = f;
        if (f == 0.0f) {
            this.isHasWheelShadow = false;
            this.mWheelPaint.clearShadowLayer();
            this.mCacheCanvas = null;
            this.mCacheBitmap.recycle();
            this.mCacheBitmap = null;
        } else {
            Paint paint = this.mWheelPaint;
            float f2 = this.mWheelShadowRadius;
            float f3 = this.mDefShadowOffset;
            paint.setShadowLayer(f2, f3, f3, -12303292);
            setSoftwareLayer();
        }
        invalidate();
    }

    public float getWheelShadowRadius() {
        return this.mWheelShadowRadius;
    }

    public boolean isHasPointerShadow() {
        return this.isHasPointerShadow;
    }

    public float getPointerShadowRadius() {
        return this.mPointerShadowRadius;
    }

    public void setPointerShadowRadius(float f) {
        this.mPointerShadowRadius = f;
        if (this.mPointerShadowRadius == 0.0f) {
            this.isHasPointerShadow = false;
            this.mPointerPaint.clearShadowLayer();
        } else {
            Paint paint = this.mPointerPaint;
            float f2 = this.mDefShadowOffset;
            paint.setShadowLayer(f, f2, f2, -12303292);
            setSoftwareLayer();
        }
        invalidate();
    }

    public void setOnSeekBarChangeListener(OnSeekBarChangeListener onSeekBarChangeListener) {
        this.mChangListener = onSeekBarChangeListener;
    }
}
