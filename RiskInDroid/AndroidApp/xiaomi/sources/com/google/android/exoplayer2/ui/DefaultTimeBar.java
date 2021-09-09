package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.xiaomi.smarthome.R;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

public class DefaultTimeBar extends View implements TimeBar {
    private int adGroupCount;
    private long[] adGroupTimesMs;
    private final Paint adMarkerPaint;
    private final int adMarkerWidth;
    private final int barHeight;
    private final Rect bufferedBar;
    private final Paint bufferedPaint;
    private long bufferedPosition;
    private final float density;
    private long duration;
    private final int fineScrubYThreshold;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private int keyCountIncrement;
    private long keyTimeIncrement;
    private int lastCoarseScrubXPosition;
    private Rect lastExclusionRectangle;
    private final CopyOnWriteArraySet<TimeBar.OnScrubListener> listeners;
    private final int[] locationOnScreen;
    private boolean[] playedAdGroups;
    private final Paint playedAdMarkerPaint;
    private final Paint playedPaint;
    private long position;
    private final Rect progressBar;
    private long scrubPosition;
    private final Rect scrubberBar;
    private final int scrubberDisabledSize;
    private final int scrubberDraggedSize;
    private final Drawable scrubberDrawable;
    private final int scrubberEnabledSize;
    private final int scrubberPadding;
    private final Paint scrubberPaint;
    private float scrubberScale;
    private ValueAnimator scrubberScalingAnimator;
    private boolean scrubbing;
    private final Rect seekBounds;
    private final Runnable stopScrubbingRunnable;
    private final Point touchPosition;
    private final int touchTargetHeight;
    private final Paint unplayedPaint;

    private static int dpToPx(float f, int i) {
        return (int) ((((float) i) * f) + 0.5f);
    }

    private static int pxToDp(float f, int i) {
        return (int) (((float) i) / f);
    }

    public DefaultTimeBar(Context context) {
        this(context, null);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        AttributeSet attributeSet3 = attributeSet2;
        this.seekBounds = new Rect();
        this.progressBar = new Rect();
        this.bufferedBar = new Rect();
        this.scrubberBar = new Rect();
        this.playedPaint = new Paint();
        this.bufferedPaint = new Paint();
        this.unplayedPaint = new Paint();
        this.adMarkerPaint = new Paint();
        this.playedAdMarkerPaint = new Paint();
        this.scrubberPaint = new Paint();
        this.scrubberPaint.setAntiAlias(true);
        this.listeners = new CopyOnWriteArraySet<>();
        this.locationOnScreen = new int[2];
        this.touchPosition = new Point();
        this.density = context.getResources().getDisplayMetrics().density;
        this.fineScrubYThreshold = dpToPx(this.density, -50);
        int dpToPx = dpToPx(this.density, 4);
        int dpToPx2 = dpToPx(this.density, 26);
        int dpToPx3 = dpToPx(this.density, 4);
        int dpToPx4 = dpToPx(this.density, 12);
        int dpToPx5 = dpToPx(this.density, 0);
        int dpToPx6 = dpToPx(this.density, 16);
        if (attributeSet3 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet3, new int[]{R.attr.ad_marker_color, R.attr.ad_marker_width, R.attr.bar_height, R.attr.buffered_color, R.attr.played_ad_marker_color, R.attr.played_color, R.attr.scrubber_color, R.attr.scrubber_disabled_size, R.attr.scrubber_dragged_size, R.attr.scrubber_drawable, R.attr.scrubber_enabled_size, R.attr.touch_target_height, R.attr.unplayed_color}, 0, 0);
            try {
                this.scrubberDrawable = obtainStyledAttributes.getDrawable(9);
                if (this.scrubberDrawable != null) {
                    setDrawableLayoutDirection(this.scrubberDrawable);
                    dpToPx2 = Math.max(this.scrubberDrawable.getMinimumHeight(), dpToPx2);
                }
                this.barHeight = obtainStyledAttributes.getDimensionPixelSize(2, dpToPx);
                this.touchTargetHeight = obtainStyledAttributes.getDimensionPixelSize(11, dpToPx2);
                this.adMarkerWidth = obtainStyledAttributes.getDimensionPixelSize(1, dpToPx3);
                this.scrubberEnabledSize = obtainStyledAttributes.getDimensionPixelSize(10, dpToPx4);
                this.scrubberDisabledSize = obtainStyledAttributes.getDimensionPixelSize(7, dpToPx5);
                this.scrubberDraggedSize = obtainStyledAttributes.getDimensionPixelSize(8, dpToPx6);
                int i2 = obtainStyledAttributes.getInt(5, -1);
                int i3 = obtainStyledAttributes.getInt(6, -1);
                int i4 = obtainStyledAttributes.getInt(3, -855638017);
                int i5 = obtainStyledAttributes.getInt(12, 872415231);
                int i6 = obtainStyledAttributes.getInt(0, -1291845888);
                int i7 = obtainStyledAttributes.getInt(4, 872414976);
                this.playedPaint.setColor(i2);
                this.scrubberPaint.setColor(i3);
                this.bufferedPaint.setColor(i4);
                this.unplayedPaint.setColor(i5);
                this.adMarkerPaint.setColor(i6);
                this.playedAdMarkerPaint.setColor(i7);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.barHeight = dpToPx;
            this.touchTargetHeight = dpToPx2;
            this.adMarkerWidth = dpToPx3;
            this.scrubberEnabledSize = dpToPx4;
            this.scrubberDisabledSize = dpToPx5;
            this.scrubberDraggedSize = dpToPx6;
            this.playedPaint.setColor(-1);
            this.scrubberPaint.setColor(-1);
            this.bufferedPaint.setColor(-855638017);
            this.unplayedPaint.setColor(872415231);
            this.adMarkerPaint.setColor(-1291845888);
            this.playedAdMarkerPaint.setColor(872414976);
            this.scrubberDrawable = null;
        }
        this.formatBuilder = new StringBuilder();
        this.formatter = new Formatter(this.formatBuilder, Locale.getDefault());
        this.stopScrubbingRunnable = new Runnable() {
            /* class com.google.android.exoplayer2.ui.$$Lambda$DefaultTimeBar$Qcgn0kqjCzq5x_ej2phsDpb1YTU */

            public final void run() {
                DefaultTimeBar.this.lambda$new$0$DefaultTimeBar();
            }
        };
        Drawable drawable = this.scrubberDrawable;
        if (drawable != null) {
            this.scrubberPadding = (drawable.getMinimumWidth() + 1) / 2;
        } else {
            this.scrubberPadding = (Math.max(this.scrubberDisabledSize, Math.max(this.scrubberEnabledSize, this.scrubberDraggedSize)) + 1) / 2;
        }
        this.scrubberScale = 1.0f;
        this.scrubberScalingAnimator = new ValueAnimator();
        this.scrubberScalingAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.exoplayer2.ui.$$Lambda$DefaultTimeBar$blt1q3w42nX81PPKXBFZvsouJg */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DefaultTimeBar.this.lambda$new$1$DefaultTimeBar(valueAnimator);
            }
        });
        this.duration = -9223372036854775807L;
        this.keyTimeIncrement = -9223372036854775807L;
        this.keyCountIncrement = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public /* synthetic */ void lambda$new$0$DefaultTimeBar() {
        stopScrubbing(false);
    }

    public /* synthetic */ void lambda$new$1$DefaultTimeBar(ValueAnimator valueAnimator) {
        this.scrubberScale = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.seekBounds);
    }

    public void showScrubber() {
        showScrubber(0);
    }

    public void showScrubber(long j) {
        if (this.scrubberScalingAnimator.isStarted()) {
            this.scrubberScalingAnimator.cancel();
        }
        this.scrubberScalingAnimator.setFloatValues(this.scrubberScale, 1.0f);
        this.scrubberScalingAnimator.setDuration(j);
        this.scrubberScalingAnimator.start();
    }

    public void hideScrubber() {
        hideScrubber(0);
    }

    public void hideScrubber(long j) {
        if (this.scrubberScalingAnimator.isStarted()) {
            this.scrubberScalingAnimator.cancel();
        }
        this.scrubberScalingAnimator.setFloatValues(this.scrubberScale, 0.0f);
        this.scrubberScalingAnimator.setDuration(j);
        this.scrubberScalingAnimator.start();
    }

    public void setPlayedColor(int i) {
        this.playedPaint.setColor(i);
        invalidate(this.seekBounds);
    }

    public void setScrubberColor(int i) {
        this.scrubberPaint.setColor(i);
        invalidate(this.seekBounds);
    }

    public void setBufferedColor(int i) {
        this.bufferedPaint.setColor(i);
        invalidate(this.seekBounds);
    }

    public void setUnplayedColor(int i) {
        this.unplayedPaint.setColor(i);
        invalidate(this.seekBounds);
    }

    public void setAdMarkerColor(int i) {
        this.adMarkerPaint.setColor(i);
        invalidate(this.seekBounds);
    }

    public void setPlayedAdMarkerColor(int i) {
        this.playedAdMarkerPaint.setColor(i);
        invalidate(this.seekBounds);
    }

    public void addListener(TimeBar.OnScrubListener onScrubListener) {
        this.listeners.add(onScrubListener);
    }

    public void removeListener(TimeBar.OnScrubListener onScrubListener) {
        this.listeners.remove(onScrubListener);
    }

    public void setKeyTimeIncrement(long j) {
        Assertions.checkArgument(j > 0);
        this.keyCountIncrement = -1;
        this.keyTimeIncrement = j;
    }

    public void setKeyCountIncrement(int i) {
        Assertions.checkArgument(i > 0);
        this.keyCountIncrement = i;
        this.keyTimeIncrement = -9223372036854775807L;
    }

    public void setPosition(long j) {
        this.position = j;
        setContentDescription(getProgressText());
        update();
    }

    public void setBufferedPosition(long j) {
        this.bufferedPosition = j;
        update();
    }

    public void setDuration(long j) {
        this.duration = j;
        if (this.scrubbing && j == -9223372036854775807L) {
            stopScrubbing(true);
        }
        update();
    }

    public long getPreferredUpdateDelay() {
        int pxToDp = pxToDp(this.density, this.progressBar.width());
        if (pxToDp == 0) {
            return Long.MAX_VALUE;
        }
        long j = this.duration;
        if (j == 0 || j == -9223372036854775807L) {
            return Long.MAX_VALUE;
        }
        return j / ((long) pxToDp);
    }

    public void setAdGroupTimesMs(long[] jArr, boolean[] zArr, int i) {
        Assertions.checkArgument(i == 0 || !(jArr == null || zArr == null));
        this.adGroupCount = i;
        this.adGroupTimesMs = jArr;
        this.playedAdGroups = zArr;
        update();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.scrubbing && !z) {
            stopScrubbing(true);
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        drawTimeBar(canvas);
        drawPlayhead(canvas);
        canvas.restore();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r3 != 3) goto L_0x0076;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (isEnabled() && this.duration > 0) {
            Point resolveRelativeTouchPosition = resolveRelativeTouchPosition(motionEvent);
            int i = resolveRelativeTouchPosition.x;
            int i2 = resolveRelativeTouchPosition.y;
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (this.scrubbing) {
                            if (i2 < this.fineScrubYThreshold) {
                                int i3 = this.lastCoarseScrubXPosition;
                                positionScrubber((float) (i3 + ((i - i3) / 3)));
                            } else {
                                this.lastCoarseScrubXPosition = i;
                                positionScrubber((float) i);
                            }
                            updateScrubbing(getScrubberPosition());
                            update();
                            invalidate();
                            return true;
                        }
                    }
                }
                if (this.scrubbing) {
                    if (motionEvent.getAction() == 3) {
                        z = true;
                    }
                    stopScrubbing(z);
                    return true;
                }
            } else {
                float f = (float) i;
                if (isInSeekBar(f, (float) i2)) {
                    positionScrubber(f);
                    startScrubbing(getScrubberPosition());
                    update();
                    invalidate();
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001a  */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            long positionIncrement = getPositionIncrement();
            if (i != 66) {
                switch (i) {
                    case 21:
                        positionIncrement = -positionIncrement;
                        if (scrubIncrementally(positionIncrement)) {
                            removeCallbacks(this.stopScrubbingRunnable);
                            postDelayed(this.stopScrubbingRunnable, 1000);
                            return true;
                        }
                        break;
                    case 22:
                        if (scrubIncrementally(positionIncrement)) {
                        }
                        break;
                }
            }
            if (this.scrubbing) {
                stopScrubbing(false);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.scrubbing && !z) {
            stopScrubbing(false);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.scrubberDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.touchTargetHeight;
        } else if (mode != 1073741824) {
            size = Math.min(this.touchTargetHeight, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        updateDrawableState();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = (i6 - this.touchTargetHeight) / 2;
        int i8 = this.touchTargetHeight;
        int i9 = ((i8 - this.barHeight) / 2) + i7;
        this.seekBounds.set(getPaddingLeft(), i7, i5 - getPaddingRight(), i8 + i7);
        this.progressBar.set(this.seekBounds.left + this.scrubberPadding, i9, this.seekBounds.right - this.scrubberPadding, this.barHeight + i9);
        if (Util.SDK_INT >= 29) {
            setSystemGestureExclusionRectsV29(i5, i6);
        }
        update();
    }

    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.scrubberDrawable;
        if (drawable != null && setDrawableLayoutDirection(drawable, i)) {
            invalidate();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.duration > 0) {
            if (Util.SDK_INT >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                return;
            }
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.duration <= 0) {
            return false;
        }
        if (i == 8192) {
            if (scrubIncrementally(-getPositionIncrement())) {
                stopScrubbing(false);
            }
        } else if (i != 4096) {
            return false;
        } else {
            if (scrubIncrementally(getPositionIncrement())) {
                stopScrubbing(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    private void startScrubbing(long j) {
        this.scrubPosition = j;
        this.scrubbing = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<TimeBar.OnScrubListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onScrubStart(this, j);
        }
    }

    private void updateScrubbing(long j) {
        if (this.scrubPosition != j) {
            this.scrubPosition = j;
            Iterator<TimeBar.OnScrubListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onScrubMove(this, j);
            }
        }
    }

    private void stopScrubbing(boolean z) {
        removeCallbacks(this.stopScrubbingRunnable);
        this.scrubbing = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<TimeBar.OnScrubListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onScrubStop(this, this.scrubPosition, z);
        }
    }

    private boolean scrubIncrementally(long j) {
        if (this.duration <= 0) {
            return false;
        }
        long j2 = this.scrubbing ? this.scrubPosition : this.position;
        long constrainValue = Util.constrainValue(j2 + j, 0, this.duration);
        if (constrainValue == j2) {
            return false;
        }
        if (!this.scrubbing) {
            startScrubbing(constrainValue);
        } else {
            updateScrubbing(constrainValue);
        }
        update();
        return true;
    }

    private void update() {
        this.bufferedBar.set(this.progressBar);
        this.scrubberBar.set(this.progressBar);
        long j = this.scrubbing ? this.scrubPosition : this.position;
        if (this.duration > 0) {
            this.bufferedBar.right = Math.min(this.progressBar.left + ((int) ((((long) this.progressBar.width()) * this.bufferedPosition) / this.duration)), this.progressBar.right);
            this.scrubberBar.right = Math.min(this.progressBar.left + ((int) ((((long) this.progressBar.width()) * j) / this.duration)), this.progressBar.right);
        } else {
            this.bufferedBar.right = this.progressBar.left;
            this.scrubberBar.right = this.progressBar.left;
        }
        invalidate(this.seekBounds);
    }

    private void positionScrubber(float f) {
        this.scrubberBar.right = Util.constrainValue((int) f, this.progressBar.left, this.progressBar.right);
    }

    private Point resolveRelativeTouchPosition(MotionEvent motionEvent) {
        getLocationOnScreen(this.locationOnScreen);
        this.touchPosition.set(((int) motionEvent.getRawX()) - this.locationOnScreen[0], ((int) motionEvent.getRawY()) - this.locationOnScreen[1]);
        return this.touchPosition;
    }

    private long getScrubberPosition() {
        if (this.progressBar.width() <= 0 || this.duration == -9223372036854775807L) {
            return 0;
        }
        return (((long) this.scrubberBar.width()) * this.duration) / ((long) this.progressBar.width());
    }

    private boolean isInSeekBar(float f, float f2) {
        return this.seekBounds.contains((int) f, (int) f2);
    }

    private void drawTimeBar(Canvas canvas) {
        int height = this.progressBar.height();
        int centerY = this.progressBar.centerY() - (height / 2);
        int i = height + centerY;
        if (this.duration <= 0) {
            canvas.drawRect((float) this.progressBar.left, (float) centerY, (float) this.progressBar.right, (float) i, this.unplayedPaint);
            return;
        }
        int i2 = this.bufferedBar.left;
        int i3 = this.bufferedBar.right;
        int max = Math.max(Math.max(this.progressBar.left, i3), this.scrubberBar.right);
        if (max < this.progressBar.right) {
            canvas.drawRect((float) max, (float) centerY, (float) this.progressBar.right, (float) i, this.unplayedPaint);
        }
        int max2 = Math.max(i2, this.scrubberBar.right);
        if (i3 > max2) {
            canvas.drawRect((float) max2, (float) centerY, (float) i3, (float) i, this.bufferedPaint);
        }
        if (this.scrubberBar.width() > 0) {
            canvas.drawRect((float) this.scrubberBar.left, (float) centerY, (float) this.scrubberBar.right, (float) i, this.playedPaint);
        }
        if (this.adGroupCount != 0) {
            long[] jArr = (long[]) Assertions.checkNotNull(this.adGroupTimesMs);
            boolean[] zArr = (boolean[]) Assertions.checkNotNull(this.playedAdGroups);
            int i4 = this.adMarkerWidth / 2;
            for (int i5 = 0; i5 < this.adGroupCount; i5++) {
                int min = this.progressBar.left + Math.min(this.progressBar.width() - this.adMarkerWidth, Math.max(0, ((int) ((((long) this.progressBar.width()) * Util.constrainValue(jArr[i5], 0, this.duration)) / this.duration)) - i4));
                canvas.drawRect((float) min, (float) centerY, (float) (min + this.adMarkerWidth), (float) i, zArr[i5] ? this.playedAdMarkerPaint : this.adMarkerPaint);
            }
        }
    }

    private void drawPlayhead(Canvas canvas) {
        int i;
        if (this.duration > 0) {
            int constrainValue = Util.constrainValue(this.scrubberBar.right, this.scrubberBar.left, this.progressBar.right);
            int centerY = this.scrubberBar.centerY();
            Drawable drawable = this.scrubberDrawable;
            if (drawable == null) {
                if (this.scrubbing || isFocused()) {
                    i = this.scrubberDraggedSize;
                } else {
                    i = isEnabled() ? this.scrubberEnabledSize : this.scrubberDisabledSize;
                }
                canvas.drawCircle((float) constrainValue, (float) centerY, (float) ((int) ((((float) i) * this.scrubberScale) / 2.0f)), this.scrubberPaint);
                return;
            }
            int intrinsicWidth = ((int) (((float) drawable.getIntrinsicWidth()) * this.scrubberScale)) / 2;
            int intrinsicHeight = ((int) (((float) this.scrubberDrawable.getIntrinsicHeight()) * this.scrubberScale)) / 2;
            this.scrubberDrawable.setBounds(constrainValue - intrinsicWidth, centerY - intrinsicHeight, constrainValue + intrinsicWidth, centerY + intrinsicHeight);
            this.scrubberDrawable.draw(canvas);
        }
    }

    private void updateDrawableState() {
        Drawable drawable = this.scrubberDrawable;
        if (drawable != null && drawable.isStateful() && this.scrubberDrawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void setSystemGestureExclusionRectsV29(int i, int i2) {
        Rect rect = this.lastExclusionRectangle;
        if (rect == null || rect.width() != i || this.lastExclusionRectangle.height() != i2) {
            this.lastExclusionRectangle = new Rect(0, 0, i, i2);
            setSystemGestureExclusionRects(Collections.singletonList(this.lastExclusionRectangle));
        }
    }

    private String getProgressText() {
        return Util.getStringForTime(this.formatBuilder, this.formatter, this.position);
    }

    private long getPositionIncrement() {
        long j = this.keyTimeIncrement;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.duration;
        if (j2 == -9223372036854775807L) {
            return 0;
        }
        return j2 / ((long) this.keyCountIncrement);
    }

    private boolean setDrawableLayoutDirection(Drawable drawable) {
        return Util.SDK_INT >= 23 && setDrawableLayoutDirection(drawable, getLayoutDirection());
    }

    private static boolean setDrawableLayoutDirection(Drawable drawable, int i) {
        return Util.SDK_INT >= 23 && drawable.setLayoutDirection(i);
    }
}
