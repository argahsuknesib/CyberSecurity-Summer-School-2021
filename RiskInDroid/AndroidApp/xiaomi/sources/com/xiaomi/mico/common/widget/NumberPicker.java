package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class NumberPicker extends LinearLayout {
    public static final char[] DIGIT_CHARACTERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final int[] PRESSED_STATE_SET = {16842919};
    private static int TEXT_COLOR_LABEL = -33444;
    public static final Formatter TWO_DIGIT_FORMATTER = new Formatter() {
        /* class com.xiaomi.mico.common.widget.NumberPicker.AnonymousClass1 */
        final Object[] mArgs = new Object[1];
        final StringBuilder mBuilder = new StringBuilder();
        final java.util.Formatter mFmt = new java.util.Formatter(this.mBuilder, Locale.US);

        public final String format(int i) {
            this.mArgs[0] = Integer.valueOf(i);
            StringBuilder sb = this.mBuilder;
            sb.delete(0, sb.length());
            this.mFmt.format("%02d", this.mArgs);
            return this.mFmt.toString();
        }
    };
    private final int ATTR_INDEX_LABEL;
    private final int ATTR_INDEX_TEXTSIZE;
    private int MAX_HEIGHT;
    private final int[] MiuiNumberPicker_Styleable;
    private float SELECTION_DIVIDERS_DISTANCE;
    private float TEXT_MAX_ASCENT;
    private int TEXT_SIZE_LABEL;
    private int TEXT_SIZE_MAX;
    private int TEXT_SIZE_MIN;
    private AccessibilityNodeProviderImpl mAccessibilityNodeProvider;
    private final Scroller mAdjustScroller;
    private BeginSoftInputOnLongPressCommand mBeginSoftInputOnLongPressCommand;
    public int mBottomSelectionDividerBottom;
    private ChangeCurrentByOneFromLongPressCommand mChangeCurrentByOneFromLongPressCommand;
    private final boolean mComputeMaxWidth;
    private int mCurrentScrollOffset;
    public boolean mDecrementVirtualButtonPressed;
    private float mDisplayedMaxTextWidth;
    public String[] mDisplayedValues;
    private final Scroller mFlingScroller;
    private Formatter mFormatter;
    private final boolean mHasSelectorWheel;
    private int mHighlightBackgroundResId;
    public boolean mIncrementVirtualButtonPressed;
    public boolean mIngonreMoveEvents;
    private int mInitialScrollOffset;
    public final EditText mInputText;
    private CharSequence mLabel;
    private Paint mLabelPaint;
    private long mLastDownEventTime;
    private float mLastDownEventY;
    private float mLastDownOrMoveEventY;
    private int mLastHandledDownDpadKeyCode;
    private int mLastHoveredChildVirtualViewId;
    public long mLongPressUpdateInterval;
    private final int mMaxHeight;
    public int mMaxValue;
    private int mMaxWidth;
    private int mMaximumFlingVelocity;
    private final int mMinHeight;
    public int mMinValue;
    private final int mMinWidth;
    private int mMinimumFlingVelocity;
    private boolean mNoHighlightBeforeChange;
    private int mNormalBackgroundResId;
    private OnScrollListener mOnScrollListener;
    private OnValueChangeListener mOnValueChangeListener;
    private final PressedStateHelper mPressedStateHelper;
    private int mPreviousScrollerY;
    private int mScrollState;
    public final int mSelectionDividerHeight;
    private final int mSelectionDividersDistance;
    private int mSelectorElementHeight;
    private final SparseArray<String> mSelectorIndexToStringCache;
    private final int[] mSelectorIndices;
    private int mSelectorTextGapHeight;
    private final Paint mSelectorWheelPaint;
    private SetSelectionCommand mSetSelectionCommand;
    private boolean mShowSoftInputOnTap;
    private int mSoundId;
    private SoundPool mSoundPlayer;
    private final int mTextSize;
    public int mTopSelectionDividerTop;
    private int mTouchSlop;
    public int mValue;
    private boolean mValueChanged;
    private VelocityTracker mVelocityTracker;
    private final Drawable mVirtualButtonPressedDrawable;
    public boolean mWrapSelectorWheel;

    public interface Formatter {
        String format(int i);
    }

    public interface OnScrollListener {
        void onScrollStateChange(NumberPicker numberPicker, int i);
    }

    public interface OnValueChangeListener {
        void onValueChange(NumberPicker numberPicker, int i, int i2);
    }

    private float getTextSize(float f, int i, int i2) {
        return f >= 1.0f ? (float) i2 : (f * ((float) (i2 - i))) + ((float) i);
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    public NumberPicker(Context context) {
        this(context, null);
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.numberPickerStyle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.mico.common.widget.NumberPicker, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public NumberPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        int i2;
        int i3;
        this.mLongPressUpdateInterval = 300;
        this.mSelectorIndexToStringCache = new SparseArray<>();
        this.mSelectorIndices = new int[5];
        this.mInitialScrollOffset = Integer.MIN_VALUE;
        this.mScrollState = 0;
        this.mLastHandledDownDpadKeyCode = -1;
        this.TEXT_SIZE_MAX = 18;
        this.TEXT_SIZE_MIN = 14;
        this.TEXT_SIZE_LABEL = 10;
        this.SELECTION_DIVIDERS_DISTANCE = 56.0f;
        this.MAX_HEIGHT = 260;
        this.MiuiNumberPicker_Styleable = new int[]{16842901, 16843087};
        this.ATTR_INDEX_TEXTSIZE = 0;
        this.ATTR_INDEX_LABEL = 1;
        this.mNoHighlightBeforeChange = false;
        float f = getResources().getDisplayMetrics().density;
        if (f != 1.0f) {
            this.TEXT_SIZE_MIN = (int) (((float) this.TEXT_SIZE_MIN) * f);
            this.TEXT_SIZE_MAX = (int) (((float) this.TEXT_SIZE_MAX) * f);
            this.TEXT_SIZE_LABEL = (int) (((float) this.TEXT_SIZE_LABEL) * f);
            this.SELECTION_DIVIDERS_DISTANCE *= f;
            this.MAX_HEIGHT = (int) (((float) this.MAX_HEIGHT) * f);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, this.MiuiNumberPicker_Styleable, 0, 0);
        this.mLabel = obtainStyledAttributes.getText(1);
        this.TEXT_SIZE_MAX = obtainStyledAttributes.getDimensionPixelSize(0, this.TEXT_SIZE_MAX);
        obtainStyledAttributes.recycle();
        this.mSoundPlayer = new SoundPool(1, 1, 0);
        this.mSoundId = this.mSoundPlayer.load(getContext(), R.raw.numberpicker_value_change, 1);
        this.mHasSelectorWheel = true;
        this.mSelectionDividerHeight = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.mSelectionDividersDistance = (int) this.SELECTION_DIVIDERS_DISTANCE;
        this.mMinHeight = -1;
        this.mMaxHeight = this.MAX_HEIGHT;
        int i4 = this.mMinHeight;
        if (i4 == -1 || (i3 = this.mMaxHeight) == -1 || i4 <= i3) {
            this.mMinWidth = -1;
            this.mMaxWidth = -1;
            int i5 = this.mMinWidth;
            if (i5 == -1 || (i2 = this.mMaxWidth) == -1 || i5 <= i2) {
                this.mComputeMaxWidth = this.mMaxWidth == -1;
                this.mVirtualButtonPressedDrawable = getResources().getDrawable(R.drawable.bg_picker_virtual);
                this.mPressedStateHelper = new PressedStateHelper();
                setWillNotDraw(!this.mHasSelectorWheel);
                ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate((int) R.layout.widget_number_picker, (ViewGroup) this, true);
                this.mInputText = (EditText) findViewById(R.id.number_picker_input);
                this.mInputText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    /* class com.xiaomi.mico.common.widget.NumberPicker.AnonymousClass2 */

                    public void onFocusChange(View view, boolean z) {
                        if (z) {
                            NumberPicker.this.mInputText.selectAll();
                            return;
                        }
                        NumberPicker.this.mInputText.setSelection(0, 0);
                        NumberPicker.this.validateInputTextView(view);
                    }
                });
                this.mInputText.setFilters(new InputFilter[]{new InputTextFilter()});
                this.mInputText.setRawInputType(2);
                this.mInputText.setImeOptions(6);
                this.mInputText.setVisibility(4);
                this.mInputText.setGravity(3);
                if (Build.VERSION.SDK_INT >= 14) {
                    this.mInputText.setScaleX(0.0f);
                }
                this.mInputText.setSaveEnabled(false);
                EditText editText = this.mInputText;
                editText.setPadding(30, editText.getPaddingTop(), 30, this.mInputText.getPaddingRight());
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
                this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
                this.mTextSize = (int) this.mInputText.getTextSize();
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize((float) this.TEXT_SIZE_MAX);
                paint.setTypeface(this.mInputText.getTypeface());
                paint.setColor(this.mInputText.getTextColors().getColorForState(ENABLED_STATE_SET, -1));
                this.mSelectorWheelPaint = paint;
                this.TEXT_MAX_ASCENT = paint.ascent();
                this.mLabelPaint = new Paint();
                this.mLabelPaint.setAntiAlias(true);
                this.mLabelPaint.setFakeBoldText(true);
                this.mLabelPaint.setColor(TEXT_COLOR_LABEL);
                this.mLabelPaint.setTextSize((float) this.TEXT_SIZE_LABEL);
                if (Build.VERSION.SDK_INT >= 14) {
                    this.mFlingScroller = new Scroller(getContext(), null, true);
                } else {
                    this.mFlingScroller = new Scroller(getContext(), null);
                }
                this.mAdjustScroller = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
                updateInputTextView();
                if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
                    setImportantForAccessibility(1);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        throw new IllegalArgumentException("minHeight > maxHeight");
    }

    public void setNoHighlightBeforeChange(boolean z) {
        this.mNoHighlightBeforeChange = z;
    }

    public void setBackgroundResIds(int i, int i2) {
        this.mHighlightBackgroundResId = i2;
        this.mNormalBackgroundResId = i;
    }

    public void updateBackground() {
        int i = shouldShowNormalState() ? this.mNormalBackgroundResId : this.mHighlightBackgroundResId;
        if (i > 0) {
            setBackgroundResource(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.mHasSelectorWheel) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.mInputText.getMeasuredWidth();
        int measuredHeight2 = this.mInputText.getMeasuredHeight();
        int i5 = (measuredWidth - measuredWidth2) / 2;
        int i6 = (measuredHeight - measuredHeight2) / 2;
        this.mInputText.layout(i5, i6, measuredWidth2 + i5, measuredHeight2 + i6);
        if (z) {
            initializeSelectorWheel();
            initializeFadingEdges();
            int height = getHeight();
            int i7 = this.mSelectionDividersDistance;
            int i8 = this.mSelectionDividerHeight;
            this.mTopSelectionDividerTop = ((height - i7) / 2) - i8;
            this.mBottomSelectionDividerBottom = this.mTopSelectionDividerTop + (i8 * 2) + i7;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!this.mHasSelectorWheel) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(makeMeasureSpec(i, this.mMaxWidth), makeMeasureSpec(i2, this.mMaxHeight));
        setMeasuredDimension(resolveSizeAndStateRespectingMinSize(this.mMinWidth, getMeasuredWidth(), i), resolveSizeAndStateRespectingMinSize(this.mMinHeight, getMeasuredHeight(), i2));
    }

    private boolean moveToFinalScrollerPosition(Scroller scroller) {
        scroller.forceFinished(true);
        int finalY = scroller.getFinalY() - scroller.getCurrY();
        int i = this.mInitialScrollOffset - ((this.mCurrentScrollOffset + finalY) % this.mSelectorElementHeight);
        if (i == 0) {
            return false;
        }
        int abs = Math.abs(i);
        int i2 = this.mSelectorElementHeight;
        if (abs > i2 / 2) {
            i = i > 0 ? i - i2 : i + i2;
        }
        scrollBy(0, finalY + i);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mHasSelectorWheel || !isEnabled() || motionEvent.getActionMasked() != 0) {
            return false;
        }
        removeAllCallbacks();
        this.mInputText.setVisibility(4);
        float y = motionEvent.getY();
        this.mLastDownEventY = y;
        this.mLastDownOrMoveEventY = y;
        this.mLastDownEventTime = motionEvent.getEventTime();
        this.mIngonreMoveEvents = false;
        this.mShowSoftInputOnTap = false;
        float f = this.mLastDownEventY;
        if (f < ((float) this.mTopSelectionDividerTop)) {
            if (this.mScrollState == 0) {
                this.mPressedStateHelper.buttonPressDelayed(2);
            }
        } else if (f > ((float) this.mBottomSelectionDividerBottom) && this.mScrollState == 0) {
            this.mPressedStateHelper.buttonPressDelayed(1);
        }
        if (!this.mFlingScroller.isFinished()) {
            this.mFlingScroller.forceFinished(true);
            this.mAdjustScroller.forceFinished(true);
            onScrollStateChange(0);
        } else if (!this.mAdjustScroller.isFinished()) {
            this.mFlingScroller.forceFinished(true);
            this.mAdjustScroller.forceFinished(true);
        } else {
            float f2 = this.mLastDownEventY;
            if (f2 < ((float) this.mTopSelectionDividerTop)) {
                postChangeCurrentByOneFromLongPress(false, (long) ViewConfiguration.getLongPressTimeout());
            } else if (f2 > ((float) this.mBottomSelectionDividerBottom)) {
                postChangeCurrentByOneFromLongPress(true, (long) ViewConfiguration.getLongPressTimeout());
            } else {
                this.mShowSoftInputOnTap = true;
                postBeginSoftInputOnLongPressCommand();
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !this.mHasSelectorWheel) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            removeBeginSoftInputCommand();
            removeChangeCurrentByOneFromLongPress();
            this.mPressedStateHelper.cancel();
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumFlingVelocity);
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) > this.mMinimumFlingVelocity) {
                fling(yVelocity);
                onScrollStateChange(2);
            } else {
                int y = (int) motionEvent.getY();
                int abs = (int) Math.abs(((float) y) - this.mLastDownEventY);
                long eventTime = motionEvent.getEventTime() - this.mLastDownEventTime;
                if (abs > this.mTouchSlop || eventTime >= ((long) ViewConfiguration.getTapTimeout())) {
                    ensureScrollWheelAdjusted();
                } else if (this.mShowSoftInputOnTap) {
                    this.mShowSoftInputOnTap = false;
                } else {
                    int i = (y / this.mSelectorElementHeight) - 2;
                    if (i > 0) {
                        changeValueByOne(true);
                        this.mPressedStateHelper.buttonTapped(1);
                    } else if (i < 0) {
                        changeValueByOne(false);
                        this.mPressedStateHelper.buttonTapped(2);
                    }
                }
                onScrollStateChange(0);
            }
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        } else if (actionMasked == 2 && !this.mIngonreMoveEvents) {
            float y2 = motionEvent.getY();
            if (this.mScrollState == 1) {
                scrollBy(0, (int) (y2 - this.mLastDownOrMoveEventY));
                invalidate();
            } else if (((int) Math.abs(y2 - this.mLastDownEventY)) > this.mTouchSlop) {
                removeAllCallbacks();
                onScrollStateChange(1);
            }
            this.mLastDownOrMoveEventY = y2;
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            removeAllCallbacks();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004b, code lost:
        requestFocus();
        r5.mLastHandledDownDpadKeyCode = r0;
        removeAllCallbacks();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        if (r5.mFlingScroller.isFinished() == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        if (r0 != 20) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
        changeValueByOne(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0063, code lost:
        return true;
     */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19 || keyCode == 20) {
            if (this.mHasSelectorWheel) {
                int action = keyEvent.getAction();
                if (action != 0) {
                    if (action == 1 && this.mLastHandledDownDpadKeyCode == keyCode) {
                        this.mLastHandledDownDpadKeyCode = -1;
                        return true;
                    }
                } else if (!this.mWrapSelectorWheel) {
                }
            }
        } else if (keyCode == 23 || keyCode == 66) {
            removeAllCallbacks();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            removeAllCallbacks();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i;
        if (!this.mHasSelectorWheel && Build.VERSION.SDK_INT >= 14) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (!((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            return false;
        }
        int y = (int) motionEvent.getY();
        if (y < this.mTopSelectionDividerTop) {
            i = 3;
        } else {
            i = y > this.mBottomSelectionDividerBottom ? 1 : 2;
        }
        int actionMasked = motionEvent.getActionMasked();
        AccessibilityNodeProviderImpl accessibilityNodeProviderImpl = (AccessibilityNodeProviderImpl) getAccessibilityNodeProvider();
        if (actionMasked == 7) {
            int i2 = this.mLastHoveredChildVirtualViewId;
            if (i2 == i || i2 == -1) {
                return false;
            }
            accessibilityNodeProviderImpl.sendAccessibilityEventForVirtualView(i2, 256);
            accessibilityNodeProviderImpl.sendAccessibilityEventForVirtualView(i, NotificationCompat.FLAG_HIGH_PRIORITY);
            this.mLastHoveredChildVirtualViewId = i;
            accessibilityNodeProviderImpl.performAction(i, 64, null);
            return false;
        } else if (actionMasked == 9) {
            accessibilityNodeProviderImpl.sendAccessibilityEventForVirtualView(i, NotificationCompat.FLAG_HIGH_PRIORITY);
            this.mLastHoveredChildVirtualViewId = i;
            accessibilityNodeProviderImpl.performAction(i, 64, null);
            return false;
        } else if (actionMasked != 10) {
            return false;
        } else {
            accessibilityNodeProviderImpl.sendAccessibilityEventForVirtualView(i, 256);
            this.mLastHoveredChildVirtualViewId = -1;
            return false;
        }
    }

    public void computeScroll() {
        Scroller scroller = this.mFlingScroller;
        if (scroller.isFinished()) {
            scroller = this.mAdjustScroller;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currY = scroller.getCurrY();
        if (this.mPreviousScrollerY == 0) {
            this.mPreviousScrollerY = scroller.getStartY();
        }
        scrollBy(0, currY - this.mPreviousScrollerY);
        this.mPreviousScrollerY = currY;
        if (scroller.isFinished()) {
            onScrollerFinished(scroller);
        } else {
            invalidate();
        }
    }

    public void scrollBy(int i, int i2) {
        int[] iArr = this.mSelectorIndices;
        if (!this.mWrapSelectorWheel && i2 > 0 && iArr[2] <= this.mMinValue) {
            this.mCurrentScrollOffset = this.mInitialScrollOffset;
        } else if (this.mWrapSelectorWheel || i2 >= 0 || iArr[2] < this.mMaxValue) {
            this.mCurrentScrollOffset += i2;
            while (true) {
                int i3 = this.mCurrentScrollOffset;
                if (i3 - this.mInitialScrollOffset <= this.mSelectorTextGapHeight) {
                    break;
                }
                this.mCurrentScrollOffset = i3 - this.mSelectorElementHeight;
                decrementSelectorIndices(iArr);
                setValueInternal(iArr[2], true);
                if (!this.mWrapSelectorWheel && iArr[2] <= this.mMinValue) {
                    this.mCurrentScrollOffset = this.mInitialScrollOffset;
                }
            }
            while (true) {
                int i4 = this.mCurrentScrollOffset;
                if (i4 - this.mInitialScrollOffset < (-this.mSelectorTextGapHeight)) {
                    this.mCurrentScrollOffset = i4 + this.mSelectorElementHeight;
                    incrementSelectorIndices(iArr);
                    setValueInternal(iArr[2], true);
                    if (!this.mWrapSelectorWheel && iArr[2] >= this.mMaxValue) {
                        this.mCurrentScrollOffset = this.mInitialScrollOffset;
                    }
                } else {
                    return;
                }
            }
        } else {
            this.mCurrentScrollOffset = this.mInitialScrollOffset;
        }
    }

    public void setLabel(String str) {
        CharSequence charSequence;
        if ((this.mLabel == null && str != null) || ((charSequence = this.mLabel) != null && !charSequence.equals(str))) {
            this.mLabel = str;
            invalidate();
        }
    }

    public void setLabelTextSize(int i) {
        this.TEXT_SIZE_LABEL = i;
        Paint paint = this.mLabelPaint;
        if (paint != null) {
            paint.setTextSize((float) this.TEXT_SIZE_LABEL);
            this.TEXT_MAX_ASCENT = this.mLabelPaint.ascent() - 6.0f;
        }
        invalidate();
    }

    public void setLabelTextColor(int i) {
        TEXT_COLOR_LABEL = i;
        Paint paint = this.mLabelPaint;
        if (paint != null) {
            paint.setColor(TEXT_COLOR_LABEL);
        }
        invalidate();
    }

    public void setTextSizeMax(int i) {
        this.TEXT_SIZE_MAX = i;
    }

    public void setTextSizeMin(int i) {
        this.TEXT_SIZE_MIN = i;
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangeListener) {
        this.mOnValueChangeListener = onValueChangeListener;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public void setFormatter(Formatter formatter) {
        if (formatter != this.mFormatter) {
            this.mFormatter = formatter;
            initializeSelectorWheelIndices();
            updateInputTextView();
        }
    }

    public void setValue(int i) {
        setValueInternal(i, false);
    }

    private void tryComputeMaxWidth() {
        if (this.mComputeMaxWidth) {
            float f = -1.0f;
            this.mSelectorWheelPaint.setTextSize((float) this.TEXT_SIZE_MAX);
            String[] strArr = this.mDisplayedValues;
            int i = 0;
            if (strArr == null) {
                float f2 = 0.0f;
                while (i < 9) {
                    float measureText = this.mSelectorWheelPaint.measureText(String.valueOf(i));
                    if (measureText > f2) {
                        f2 = measureText;
                    }
                    i++;
                }
                f = (float) ((int) (((float) formatNumber(this.mMaxValue).length()) * f2));
            } else {
                int length = strArr.length;
                while (i < length) {
                    float measureText2 = this.mSelectorWheelPaint.measureText(this.mDisplayedValues[i]);
                    if (measureText2 > f) {
                        f = measureText2;
                    }
                    i++;
                }
            }
            this.mDisplayedMaxTextWidth = f;
            float paddingLeft = f + ((float) (this.mInputText.getPaddingLeft() + this.mInputText.getPaddingRight())) + ((float) getPaddingLeft()) + ((float) getPaddingRight());
            if (((float) this.mMaxWidth) != paddingLeft) {
                int i2 = this.mMinWidth;
                if (paddingLeft > ((float) i2)) {
                    this.mMaxWidth = (int) paddingLeft;
                } else {
                    this.mMaxWidth = i2;
                }
            }
        }
    }

    public boolean getWrapSelectorWheel() {
        return this.mWrapSelectorWheel;
    }

    public void setWrapSelectorWheel(boolean z) {
        boolean z2 = this.mMaxValue - this.mMinValue >= this.mSelectorIndices.length;
        if ((!z || z2) && z != this.mWrapSelectorWheel) {
            this.mWrapSelectorWheel = z;
        }
        refreshWheel();
    }

    public void setOnLongPressUpdateInterval(long j) {
        this.mLongPressUpdateInterval = j;
    }

    public int getValue() {
        return this.mValue;
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    public void setMinValue(int i) {
        if (this.mMinValue != i) {
            if (i >= 0) {
                this.mMinValue = i;
                int i2 = this.mMinValue;
                if (i2 > this.mValue) {
                    this.mValue = i2;
                }
                setWrapSelectorWheel(this.mMaxValue - this.mMinValue > this.mSelectorIndices.length);
                initializeSelectorWheelIndices();
                updateInputTextView();
                tryComputeMaxWidth();
                invalidate();
                return;
            }
            throw new IllegalArgumentException("minValue must be >= 0");
        }
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public void setMaxValue(int i) {
        if (this.mMaxValue != i) {
            if (i >= 0) {
                this.mMaxValue = i;
                int i2 = this.mMaxValue;
                if (i2 < this.mValue) {
                    this.mValue = i2;
                }
                setWrapSelectorWheel(this.mMaxValue - this.mMinValue > this.mSelectorIndices.length);
                initializeSelectorWheelIndices();
                updateInputTextView();
                tryComputeMaxWidth();
                invalidate();
                return;
            }
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
    }

    public String[] getDisplayedValues() {
        return this.mDisplayedValues;
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.mDisplayedValues != strArr) {
            this.mDisplayedValues = strArr;
            if (this.mDisplayedValues != null) {
                this.mInputText.setRawInputType(524289);
            } else {
                this.mInputText.setRawInputType(2);
            }
            updateInputTextView();
            initializeSelectorWheelIndices();
            tryComputeMaxWidth();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllCallbacks();
        this.mSoundPlayer.release();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.mHasSelectorWheel) {
            super.onDraw(canvas);
            return;
        }
        int width = getWidth();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        float right = (float) ((((getRight() - getLeft()) + paddingLeft) - paddingRight) / 2);
        float f = (float) this.mCurrentScrollOffset;
        Drawable drawable = this.mVirtualButtonPressedDrawable;
        if (drawable != null && this.mScrollState == 0) {
            if (this.mDecrementVirtualButtonPressed) {
                drawable.setState(PRESSED_STATE_SET);
                this.mVirtualButtonPressedDrawable.setBounds(paddingLeft, 0, width - paddingRight, this.mTopSelectionDividerTop);
                this.mVirtualButtonPressedDrawable.draw(canvas);
            }
            if (this.mIncrementVirtualButtonPressed) {
                this.mVirtualButtonPressedDrawable.setState(PRESSED_STATE_SET);
                this.mVirtualButtonPressedDrawable.setBounds(paddingLeft, this.mBottomSelectionDividerBottom, width - paddingRight, getBottom());
                this.mVirtualButtonPressedDrawable.draw(canvas);
            }
        }
        float f2 = (float) (this.mInitialScrollOffset + (this.mSelectorElementHeight * 2));
        SparseArray<String> sparseArray = this.mSelectorIndexToStringCache;
        int[] iArr = this.mSelectorIndices;
        float f3 = f;
        for (int i : iArr) {
            String str = sparseArray.get(i);
            float abs = shouldShowNormalState() ? 2.0f : Math.abs(f2 - f3) / ((float) this.mSelectorElementHeight);
            float textSize = getTextSize(abs, this.TEXT_SIZE_MAX, this.TEXT_SIZE_MIN);
            this.mSelectorWheelPaint.setTextSize(textSize);
            this.mSelectorWheelPaint.setColor(getAlphaGradient(abs, getResources().getColor(R.color.mj_color_gray_light), false));
            canvas.drawText(str, right, ((textSize - ((float) this.TEXT_SIZE_MIN)) / 2.0f) + f3, this.mSelectorWheelPaint);
            if (abs < 1.0f) {
                this.mSelectorWheelPaint.setColor(getAlphaGradient(abs, TEXT_COLOR_LABEL, true));
                canvas.drawText(str, right, ((textSize - ((float) this.TEXT_SIZE_MIN)) / 2.0f) + f3, this.mSelectorWheelPaint);
            }
            f3 += (float) this.mSelectorElementHeight;
        }
        if (!TextUtils.isEmpty(this.mLabel)) {
            canvas.drawText(this.mLabel.toString(), right + (this.mDisplayedMaxTextWidth / 2.0f), f2 + ((float) ((this.TEXT_SIZE_MAX - this.TEXT_SIZE_MIN) / 2)) + this.TEXT_MAX_ASCENT + ((float) this.TEXT_SIZE_LABEL), this.mLabelPaint);
        }
    }

    private boolean shouldShowNormalState() {
        return this.mNoHighlightBeforeChange && !this.mValueChanged;
    }

    private int getAlphaGradient(float f, int i, boolean z) {
        float f2;
        if (f >= 1.0f) {
            return i;
        }
        if (z) {
            f2 = ((-f) * ((float) Color.alpha(i))) + ((float) Color.alpha(i));
        } else {
            f2 = f * ((float) Color.alpha(i));
        }
        return (((int) f2) << 24) | (i & 16777215);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 15) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(NumberPicker.class.getName());
            accessibilityEvent.setScrollable(true);
            accessibilityEvent.setScrollY((this.mMinValue + this.mValue) * this.mSelectorElementHeight);
            accessibilityEvent.setMaxScrollY((this.mMaxValue - this.mMinValue) * this.mSelectorElementHeight);
        }
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (!this.mHasSelectorWheel && Build.VERSION.SDK_INT >= 16) {
            return super.getAccessibilityNodeProvider();
        }
        if (this.mAccessibilityNodeProvider == null) {
            this.mAccessibilityNodeProvider = new AccessibilityNodeProviderImpl();
        }
        return this.mAccessibilityNodeProvider;
    }

    private int makeMeasureSpec(int i, int i2) {
        if (i2 == -1) {
            return i;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i2), 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        if (mode == 1073741824) {
            return i;
        }
        throw new IllegalArgumentException("Unknown measure mode: ".concat(String.valueOf(mode)));
    }

    private int resolveSizeAndStateRespectingMinSize(int i, int i2, int i3) {
        if (i != -1) {
            int max = Math.max(i, i2);
            if (Build.VERSION.SDK_INT >= 11) {
                return resolveSizeAndState(max, i3, 0);
            }
        }
        return i2;
    }

    private void initializeSelectorWheelIndices() {
        this.mSelectorIndexToStringCache.clear();
        int[] iArr = this.mSelectorIndices;
        int value = getValue();
        for (int i = 0; i < this.mSelectorIndices.length; i++) {
            int i2 = (i - 2) + value;
            if (this.mWrapSelectorWheel) {
                i2 = getWrappedSelectorIndex(i2);
            }
            iArr[i] = i2;
            ensureCachedScrollSelectorValue(iArr[i]);
        }
    }

    private void setValueInternal(int i, boolean z) {
        int i2;
        if (this.mValue != i) {
            this.mValueChanged = true;
            if (this.mWrapSelectorWheel) {
                i2 = getWrappedSelectorIndex(i);
            } else {
                i2 = Math.min(Math.max(i, this.mMinValue), this.mMaxValue);
            }
            int i3 = this.mValue;
            this.mValue = i2;
            updateInputTextView();
            if (z) {
                notifyChange(i3, i2);
            }
            initializeSelectorWheelIndices();
            invalidate();
        }
    }

    public void changeValueByOne(boolean z) {
        if (this.mHasSelectorWheel) {
            this.mInputText.setVisibility(4);
            if (!moveToFinalScrollerPosition(this.mFlingScroller)) {
                moveToFinalScrollerPosition(this.mAdjustScroller);
            }
            this.mPreviousScrollerY = 0;
            if (z) {
                this.mFlingScroller.startScroll(0, 0, 0, -this.mSelectorElementHeight, 300);
            } else {
                this.mFlingScroller.startScroll(0, 0, 0, this.mSelectorElementHeight, 300);
            }
            invalidate();
        } else if (z) {
            setValueInternal(this.mValue + 1, true);
        } else {
            setValueInternal(this.mValue - 1, true);
        }
    }

    private void initializeSelectorWheel() {
        initializeSelectorWheelIndices();
        int[] iArr = this.mSelectorIndices;
        this.mSelectorTextGapHeight = (int) ((((float) ((getBottom() - getTop()) - (iArr.length * this.mTextSize))) / ((float) iArr.length)) + 0.5f);
        this.mSelectorElementHeight = this.mTextSize + this.mSelectorTextGapHeight;
        this.mInitialScrollOffset = (this.mInputText.getBaseline() + this.mInputText.getTop()) - (this.mSelectorElementHeight * 2);
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        updateInputTextView();
    }

    private void initializeFadingEdges() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - this.mTextSize) / 2);
    }

    private void onScrollerFinished(Scroller scroller) {
        if (scroller == this.mFlingScroller) {
            if (!ensureScrollWheelAdjusted()) {
                updateInputTextView();
            }
            onScrollStateChange(0);
        } else if (this.mScrollState != 1) {
            updateInputTextView();
        }
    }

    private void onScrollStateChange(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            OnScrollListener onScrollListener = this.mOnScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChange(this, i);
            }
        }
    }

    private void fling(int i) {
        this.mPreviousScrollerY = 0;
        if (i > 0) {
            this.mFlingScroller.fling(0, 0, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        } else {
            this.mFlingScroller.fling(0, Integer.MAX_VALUE, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        }
        invalidate();
    }

    public int getWrappedSelectorIndex(int i) {
        int i2 = this.mMaxValue;
        if (i > i2) {
            int i3 = this.mMinValue;
            return (i3 + ((i - i2) % (i2 - i3))) - 1;
        }
        int i4 = this.mMinValue;
        return i < i4 ? (i2 - ((i4 - i) % (i2 - i4))) + 1 : i;
    }

    private void incrementSelectorIndices(int[] iArr) {
        int i = 0;
        while (i < iArr.length - 1) {
            int i2 = i + 1;
            iArr[i] = iArr[i2];
            i = i2;
        }
        int i3 = iArr[iArr.length - 2] + 1;
        if (this.mWrapSelectorWheel && i3 > this.mMaxValue) {
            i3 = this.mMinValue;
        }
        iArr[iArr.length - 1] = i3;
        ensureCachedScrollSelectorValue(i3);
    }

    private void decrementSelectorIndices(int[] iArr) {
        for (int length = iArr.length - 1; length > 0; length--) {
            iArr[length] = iArr[length - 1];
        }
        int i = iArr[1] - 1;
        if (this.mWrapSelectorWheel && i < this.mMinValue) {
            i = this.mMaxValue;
        }
        iArr[0] = i;
        ensureCachedScrollSelectorValue(i);
    }

    private void ensureCachedScrollSelectorValue(int i) {
        String str;
        SparseArray<String> sparseArray = this.mSelectorIndexToStringCache;
        if (sparseArray.get(i) == null) {
            int i2 = this.mMinValue;
            if (i < i2 || i > this.mMaxValue) {
                str = "";
            } else {
                String[] strArr = this.mDisplayedValues;
                str = strArr != null ? strArr[i - i2] : formatNumber(i);
            }
            sparseArray.put(i, str);
        }
    }

    public String formatNumber(int i) {
        Formatter formatter = this.mFormatter;
        return formatter != null ? formatter.format(i) : String.valueOf(i);
    }

    public void validateInputTextView(View view) {
        String valueOf = String.valueOf(((TextView) view).getText());
        if (TextUtils.isEmpty(valueOf)) {
            updateInputTextView();
        } else {
            setValueInternal(getSelectedPos(valueOf.toString()), true);
        }
    }

    private boolean updateInputTextView() {
        String[] strArr = this.mDisplayedValues;
        String formatNumber = strArr == null ? formatNumber(this.mValue) : strArr[this.mValue - this.mMinValue];
        if (TextUtils.isEmpty(formatNumber) || formatNumber.equals(this.mInputText.getText().toString())) {
            return false;
        }
        this.mInputText.setText(formatNumber);
        return true;
    }

    private void notifyChange(int i, int i2) {
        this.mSoundPlayer.play(this.mSoundId, 1.0f, 1.0f, 0, 0, 1.0f);
        OnValueChangeListener onValueChangeListener = this.mOnValueChangeListener;
        if (onValueChangeListener != null) {
            onValueChangeListener.onValueChange(this, i, this.mValue);
        }
    }

    private void postChangeCurrentByOneFromLongPress(boolean z, long j) {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand == null) {
            this.mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
        } else {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
        this.mChangeCurrentByOneFromLongPressCommand.setStep(z);
        postDelayed(this.mChangeCurrentByOneFromLongPressCommand, j);
    }

    private void removeChangeCurrentByOneFromLongPress() {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand != null) {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
    }

    private void postBeginSoftInputOnLongPressCommand() {
        BeginSoftInputOnLongPressCommand beginSoftInputOnLongPressCommand = this.mBeginSoftInputOnLongPressCommand;
        if (beginSoftInputOnLongPressCommand == null) {
            this.mBeginSoftInputOnLongPressCommand = new BeginSoftInputOnLongPressCommand();
        } else {
            removeCallbacks(beginSoftInputOnLongPressCommand);
        }
        postDelayed(this.mBeginSoftInputOnLongPressCommand, (long) ViewConfiguration.getLongPressTimeout());
    }

    private void removeBeginSoftInputCommand() {
        BeginSoftInputOnLongPressCommand beginSoftInputOnLongPressCommand = this.mBeginSoftInputOnLongPressCommand;
        if (beginSoftInputOnLongPressCommand != null) {
            removeCallbacks(beginSoftInputOnLongPressCommand);
        }
    }

    private void removeAllCallbacks() {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand != null) {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
        SetSelectionCommand setSelectionCommand = this.mSetSelectionCommand;
        if (setSelectionCommand != null) {
            removeCallbacks(setSelectionCommand);
        }
        BeginSoftInputOnLongPressCommand beginSoftInputOnLongPressCommand = this.mBeginSoftInputOnLongPressCommand;
        if (beginSoftInputOnLongPressCommand != null) {
            removeCallbacks(beginSoftInputOnLongPressCommand);
        }
        this.mPressedStateHelper.cancel();
    }

    public int getSelectedPos(String str) {
        if (this.mDisplayedValues == null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return this.mMinValue;
            }
        } else {
            for (int i = 0; i < this.mDisplayedValues.length; i++) {
                str = str.toLowerCase();
                if (this.mDisplayedValues[i].toLowerCase().startsWith(str)) {
                    return this.mMinValue + i;
                }
            }
            return Integer.parseInt(str);
        }
    }

    public void postSetSelectionCommand(int i, int i2) {
        SetSelectionCommand setSelectionCommand = this.mSetSelectionCommand;
        if (setSelectionCommand == null) {
            this.mSetSelectionCommand = new SetSelectionCommand();
        } else {
            removeCallbacks(setSelectionCommand);
        }
        SetSelectionCommand setSelectionCommand2 = this.mSetSelectionCommand;
        setSelectionCommand2.mSelectionStart = i;
        setSelectionCommand2.mSelectionEnd = i2;
        post(setSelectionCommand2);
    }

    class InputTextFilter extends NumberKeyListener {
        public int getInputType() {
            return 1;
        }

        InputTextFilter() {
        }

        /* access modifiers changed from: protected */
        public char[] getAcceptedChars() {
            return NumberPicker.DIGIT_CHARACTERS;
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (NumberPicker.this.mDisplayedValues == null) {
                CharSequence filter = super.filter(charSequence, i, i2, spanned, i3, i4);
                if (filter == null) {
                    filter = charSequence.subSequence(i, i2);
                }
                String str = String.valueOf(spanned.subSequence(0, i3)) + ((Object) filter) + ((Object) spanned.subSequence(i4, spanned.length()));
                if ("".equals(str)) {
                    return str;
                }
                if (NumberPicker.this.getSelectedPos(str) > NumberPicker.this.mMaxValue || str.length() > String.valueOf(NumberPicker.this.mMaxValue).length()) {
                    return "";
                }
                return filter;
            }
            String valueOf = String.valueOf(charSequence.subSequence(i, i2));
            if (TextUtils.isEmpty(valueOf)) {
                return "";
            }
            String str2 = String.valueOf(spanned.subSequence(0, i3)) + ((Object) valueOf) + ((Object) spanned.subSequence(i4, spanned.length()));
            String lowerCase = String.valueOf(str2).toLowerCase();
            for (String str3 : NumberPicker.this.mDisplayedValues) {
                if (str3.toLowerCase().startsWith(lowerCase)) {
                    NumberPicker.this.postSetSelectionCommand(str2.length(), str3.length());
                    return str3.subSequence(i3, str3.length());
                }
            }
            return "";
        }
    }

    private boolean ensureScrollWheelAdjusted() {
        int i = this.mInitialScrollOffset - this.mCurrentScrollOffset;
        if (i == 0) {
            return false;
        }
        this.mPreviousScrollerY = 0;
        int abs = Math.abs(i);
        int i2 = this.mSelectorElementHeight;
        if (abs > i2 / 2) {
            if (i > 0) {
                i2 = -i2;
            }
            i += i2;
        }
        this.mAdjustScroller.startScroll(0, 0, 0, i, 800);
        invalidate();
        return true;
    }

    class PressedStateHelper implements Runnable {
        private final int MODE_PRESS = 1;
        private final int MODE_TAPPED = 2;
        private int mManagedButton;
        private int mMode;

        PressedStateHelper() {
        }

        public void cancel() {
            this.mMode = 0;
            this.mManagedButton = 0;
            NumberPicker.this.removeCallbacks(this);
            if (NumberPicker.this.mIncrementVirtualButtonPressed) {
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.mIncrementVirtualButtonPressed = false;
                numberPicker.invalidate(0, numberPicker.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
            }
            if (NumberPicker.this.mDecrementVirtualButtonPressed) {
                NumberPicker numberPicker2 = NumberPicker.this;
                numberPicker2.mDecrementVirtualButtonPressed = false;
                numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.mTopSelectionDividerTop);
            }
        }

        public void buttonPressDelayed(int i) {
            cancel();
            this.mMode = 1;
            this.mManagedButton = i;
            NumberPicker.this.postDelayed(this, (long) ViewConfiguration.getTapTimeout());
        }

        public void buttonTapped(int i) {
            cancel();
            this.mMode = 2;
            this.mManagedButton = i;
            NumberPicker.this.post(this);
        }

        public void run() {
            int i = this.mMode;
            if (i == 1) {
                int i2 = this.mManagedButton;
                if (i2 == 1) {
                    NumberPicker numberPicker = NumberPicker.this;
                    numberPicker.mIncrementVirtualButtonPressed = true;
                    numberPicker.invalidate(0, numberPicker.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                } else if (i2 == 2) {
                    NumberPicker numberPicker2 = NumberPicker.this;
                    numberPicker2.mDecrementVirtualButtonPressed = true;
                    numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.mTopSelectionDividerTop);
                }
            } else if (i == 2) {
                int i3 = this.mManagedButton;
                if (i3 == 1) {
                    if (!NumberPicker.this.mIncrementVirtualButtonPressed) {
                        NumberPicker.this.postDelayed(this, (long) ViewConfiguration.getPressedStateDuration());
                    }
                    NumberPicker numberPicker3 = NumberPicker.this;
                    numberPicker3.mIncrementVirtualButtonPressed = !numberPicker3.mIncrementVirtualButtonPressed;
                    NumberPicker numberPicker4 = NumberPicker.this;
                    numberPicker4.invalidate(0, numberPicker4.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                } else if (i3 == 2) {
                    if (!NumberPicker.this.mDecrementVirtualButtonPressed) {
                        NumberPicker.this.postDelayed(this, (long) ViewConfiguration.getPressedStateDuration());
                    }
                    NumberPicker numberPicker5 = NumberPicker.this;
                    numberPicker5.mDecrementVirtualButtonPressed = !numberPicker5.mDecrementVirtualButtonPressed;
                    NumberPicker numberPicker6 = NumberPicker.this;
                    numberPicker6.invalidate(0, 0, numberPicker6.getRight(), NumberPicker.this.mTopSelectionDividerTop);
                }
            }
        }
    }

    class SetSelectionCommand implements Runnable {
        public int mSelectionEnd;
        public int mSelectionStart;

        SetSelectionCommand() {
        }

        public void run() {
            NumberPicker.this.mInputText.setSelection(this.mSelectionStart, this.mSelectionEnd);
        }
    }

    class ChangeCurrentByOneFromLongPressCommand implements Runnable {
        private boolean mIncrement;

        ChangeCurrentByOneFromLongPressCommand() {
        }

        public void setStep(boolean z) {
            this.mIncrement = z;
        }

        public void run() {
            NumberPicker.this.changeValueByOne(this.mIncrement);
            NumberPicker numberPicker = NumberPicker.this;
            numberPicker.postDelayed(this, numberPicker.mLongPressUpdateInterval);
        }
    }

    public static class CustomEditText extends AppCompatEditText {
        public CustomEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void onEditorAction(int i) {
            super.onEditorAction(i);
            if (i == 6) {
                clearFocus();
            }
        }
    }

    class BeginSoftInputOnLongPressCommand implements Runnable {
        BeginSoftInputOnLongPressCommand() {
        }

        public void run() {
            NumberPicker.this.mIngonreMoveEvents = true;
        }
    }

    class AccessibilityNodeProviderImpl extends AccessibilityNodeProvider {
        private int mAccessibilityFocusedView = Integer.MIN_VALUE;
        private final int[] mTempArray = new int[2];
        private final Rect mTempRect = new Rect();

        AccessibilityNodeProviderImpl() {
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            if (i == -1) {
                return createAccessibilityNodeInfoForNumberPicker(NumberPicker.this.getScrollX(), NumberPicker.this.getScrollY(), NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.getScrollY() + (NumberPicker.this.getBottom() - NumberPicker.this.getTop()));
            }
            if (i == 1) {
                return createAccessibilityNodeInfoForVirtualButton(1, getVirtualIncrementButtonText(), NumberPicker.this.getScrollX(), NumberPicker.this.mBottomSelectionDividerBottom - NumberPicker.this.mSelectionDividerHeight, NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.getScrollY() + (NumberPicker.this.getBottom() - NumberPicker.this.getTop()));
            }
            if (i == 2) {
                return createAccessibiltyNodeInfoForInputText(NumberPicker.this.getScrollX(), NumberPicker.this.mTopSelectionDividerTop + NumberPicker.this.mSelectionDividerHeight, NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.mBottomSelectionDividerBottom - NumberPicker.this.mSelectionDividerHeight);
            }
            if (i != 3) {
                return super.createAccessibilityNodeInfo(i);
            }
            return createAccessibilityNodeInfoForVirtualButton(3, getVirtualDecrementButtonText(), NumberPicker.this.getScrollX(), NumberPicker.this.getScrollY(), NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.mTopSelectionDividerTop + NumberPicker.this.mSelectionDividerHeight);
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return Collections.emptyList();
            }
            String lowerCase = str.toLowerCase();
            ArrayList arrayList = new ArrayList();
            if (i == -1) {
                findAccessibilityNodeInfosByTextInChild(lowerCase, 3, arrayList);
                findAccessibilityNodeInfosByTextInChild(lowerCase, 2, arrayList);
                findAccessibilityNodeInfosByTextInChild(lowerCase, 1, arrayList);
                return arrayList;
            } else if (i != 1 && i != 2 && i != 3) {
                return super.findAccessibilityNodeInfosByText(str, i);
            } else {
                findAccessibilityNodeInfosByTextInChild(lowerCase, i, arrayList);
                return arrayList;
            }
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            boolean z = false;
            if (i != -1) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            if (i2 != 16) {
                                if (i2 != 64) {
                                    if (i2 != 128 || this.mAccessibilityFocusedView != i) {
                                        return false;
                                    }
                                    this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                                    sendAccessibilityEventForVirtualView(i, 65536);
                                    NumberPicker numberPicker = NumberPicker.this;
                                    numberPicker.invalidate(0, 0, numberPicker.getRight(), NumberPicker.this.mTopSelectionDividerTop);
                                    return true;
                                } else if (this.mAccessibilityFocusedView == i) {
                                    return false;
                                } else {
                                    this.mAccessibilityFocusedView = i;
                                    sendAccessibilityEventForVirtualView(i, 32768);
                                    NumberPicker numberPicker2 = NumberPicker.this;
                                    numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.mTopSelectionDividerTop);
                                    return true;
                                }
                            } else if (!NumberPicker.this.isEnabled()) {
                                return false;
                            } else {
                                if (i == 1) {
                                    z = true;
                                }
                                NumberPicker.this.changeValueByOne(z);
                                sendAccessibilityEventForVirtualView(i, 1);
                                return true;
                            }
                        }
                    } else if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 == 16) {
                                return NumberPicker.this.isEnabled();
                            }
                            if (i2 != 64) {
                                if (i2 != 128) {
                                    return NumberPicker.this.mInputText.performAccessibilityAction(i2, bundle);
                                }
                                if (this.mAccessibilityFocusedView != i) {
                                    return false;
                                }
                                this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                                sendAccessibilityEventForVirtualView(i, 65536);
                                NumberPicker.this.mInputText.invalidate();
                                return true;
                            } else if (this.mAccessibilityFocusedView == i) {
                                return false;
                            } else {
                                this.mAccessibilityFocusedView = i;
                                sendAccessibilityEventForVirtualView(i, 32768);
                                NumberPicker.this.mInputText.invalidate();
                                return true;
                            }
                        } else if (!NumberPicker.this.isEnabled() || !NumberPicker.this.mInputText.isFocused()) {
                            return false;
                        } else {
                            NumberPicker.this.mInputText.clearFocus();
                            return true;
                        }
                    } else if (!NumberPicker.this.isEnabled() || NumberPicker.this.mInputText.isFocused()) {
                        return false;
                    } else {
                        return NumberPicker.this.mInputText.requestFocus();
                    }
                } else if (i2 != 16) {
                    if (i2 != 64) {
                        if (i2 != 128 || this.mAccessibilityFocusedView != i) {
                            return false;
                        }
                        this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                        sendAccessibilityEventForVirtualView(i, 65536);
                        NumberPicker numberPicker3 = NumberPicker.this;
                        numberPicker3.invalidate(0, numberPicker3.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                        return true;
                    } else if (this.mAccessibilityFocusedView == i) {
                        return false;
                    } else {
                        this.mAccessibilityFocusedView = i;
                        sendAccessibilityEventForVirtualView(i, 32768);
                        NumberPicker numberPicker4 = NumberPicker.this;
                        numberPicker4.invalidate(0, numberPicker4.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                        return true;
                    }
                } else if (!NumberPicker.this.isEnabled()) {
                    return false;
                } else {
                    NumberPicker.this.changeValueByOne(true);
                    sendAccessibilityEventForVirtualView(i, 1);
                    return true;
                }
            } else if (i2 != 64) {
                if (i2 != 128) {
                    if (i2 != 4096) {
                        if (i2 == 8192) {
                            if (!NumberPicker.this.isEnabled() || (!NumberPicker.this.getWrapSelectorWheel() && NumberPicker.this.getValue() <= NumberPicker.this.getMinValue())) {
                                return false;
                            }
                            NumberPicker.this.changeValueByOne(false);
                            return true;
                        }
                    } else if (!NumberPicker.this.isEnabled() || (!NumberPicker.this.getWrapSelectorWheel() && NumberPicker.this.getValue() >= NumberPicker.this.getMaxValue())) {
                        return false;
                    } else {
                        NumberPicker.this.changeValueByOne(true);
                        return true;
                    }
                } else if (this.mAccessibilityFocusedView != i) {
                    return false;
                } else {
                    this.mAccessibilityFocusedView = Integer.MIN_VALUE;
                    return true;
                }
            } else if (this.mAccessibilityFocusedView == i) {
                return false;
            } else {
                this.mAccessibilityFocusedView = i;
                return true;
            }
            return super.performAction(i, i2, bundle);
        }

        public void sendAccessibilityEventForVirtualView(int i, int i2) {
            if (i != 1) {
                if (i == 2) {
                    sendAccessibilityEventForVirtualText(i2);
                } else if (i == 3 && hasVirtualDecrementButton()) {
                    sendAccessibilityEventForVirtualButton(i, i2, getVirtualDecrementButtonText());
                }
            } else if (hasVirtualIncrementButton()) {
                sendAccessibilityEventForVirtualButton(i, i2, getVirtualIncrementButtonText());
            }
        }

        private void sendAccessibilityEventForVirtualText(int i) {
            if (((AccessibilityManager) NumberPicker.this.getContext().getSystemService("accessibility")).isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
                NumberPicker.this.mInputText.onInitializeAccessibilityEvent(obtain);
                NumberPicker.this.mInputText.onPopulateAccessibilityEvent(obtain);
                obtain.setSource(NumberPicker.this, 2);
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.requestSendAccessibilityEvent(numberPicker, obtain);
            }
        }

        private void sendAccessibilityEventForVirtualButton(int i, int i2, String str) {
            if (((AccessibilityManager) NumberPicker.this.getContext().getSystemService("accessibility")).isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
                obtain.setClassName(Button.class.getName());
                obtain.setPackageName(NumberPicker.this.getContext().getPackageName());
                obtain.getText().add(str);
                obtain.setEnabled(NumberPicker.this.isEnabled());
                obtain.setSource(NumberPicker.this, i);
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.requestSendAccessibilityEvent(numberPicker, obtain);
            }
        }

        private void findAccessibilityNodeInfosByTextInChild(String str, int i, List<AccessibilityNodeInfo> list) {
            if (i == 1) {
                String virtualIncrementButtonText = getVirtualIncrementButtonText();
                if (!TextUtils.isEmpty(virtualIncrementButtonText) && virtualIncrementButtonText.toString().toLowerCase().contains(str)) {
                    list.add(createAccessibilityNodeInfo(1));
                }
            } else if (i == 2) {
                Editable text = NumberPicker.this.mInputText.getText();
                if (TextUtils.isEmpty(text) || !text.toString().toLowerCase().contains(str)) {
                    Editable text2 = NumberPicker.this.mInputText.getText();
                    if (!TextUtils.isEmpty(text2) && text2.toString().toLowerCase().contains(str)) {
                        list.add(createAccessibilityNodeInfo(2));
                        return;
                    }
                    return;
                }
                list.add(createAccessibilityNodeInfo(2));
            } else if (i == 3) {
                String virtualDecrementButtonText = getVirtualDecrementButtonText();
                if (!TextUtils.isEmpty(virtualDecrementButtonText) && virtualDecrementButtonText.toString().toLowerCase().contains(str)) {
                    list.add(createAccessibilityNodeInfo(3));
                }
            }
        }

        private AccessibilityNodeInfo createAccessibiltyNodeInfoForInputText(int i, int i2, int i3, int i4) {
            AccessibilityNodeInfo createAccessibilityNodeInfo = NumberPicker.this.mInputText.createAccessibilityNodeInfo();
            createAccessibilityNodeInfo.setSource(NumberPicker.this, 2);
            if (this.mAccessibilityFocusedView != 2) {
                createAccessibilityNodeInfo.addAction(64);
            }
            if (this.mAccessibilityFocusedView == 2) {
                createAccessibilityNodeInfo.addAction((int) NotificationCompat.FLAG_HIGH_PRIORITY);
            }
            Rect rect = this.mTempRect;
            rect.set(i, i2, i3, i4);
            createAccessibilityNodeInfo.setVisibleToUser(NumberPicker.this.getVisibility() == 0);
            createAccessibilityNodeInfo.setBoundsInParent(rect);
            int[] iArr = this.mTempArray;
            NumberPicker.this.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            createAccessibilityNodeInfo.setBoundsInScreen(rect);
            return createAccessibilityNodeInfo;
        }

        private AccessibilityNodeInfo createAccessibilityNodeInfoForVirtualButton(int i, String str, int i2, int i3, int i4, int i5) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setClassName(Button.class.getName());
            obtain.setPackageName(NumberPicker.this.getContext().getPackageName());
            obtain.setSource(NumberPicker.this, i);
            obtain.setParent(NumberPicker.this);
            obtain.setText(str);
            obtain.setClickable(true);
            obtain.setLongClickable(true);
            obtain.setEnabled(NumberPicker.this.isEnabled());
            Rect rect = this.mTempRect;
            rect.set(i2, i3, i4, i5);
            obtain.setVisibleToUser(NumberPicker.this.getVisibility() == 0);
            obtain.setBoundsInParent(rect);
            int[] iArr = this.mTempArray;
            NumberPicker.this.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            obtain.setBoundsInScreen(rect);
            if (this.mAccessibilityFocusedView != i) {
                obtain.addAction(64);
            }
            if (this.mAccessibilityFocusedView == i) {
                obtain.addAction((int) NotificationCompat.FLAG_HIGH_PRIORITY);
            }
            if (NumberPicker.this.isEnabled()) {
                obtain.addAction(16);
            }
            return obtain;
        }

        private AccessibilityNodeInfo createAccessibilityNodeInfoForNumberPicker(int i, int i2, int i3, int i4) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setClassName(NumberPicker.class.getName());
            obtain.setPackageName(NumberPicker.this.getContext().getPackageName());
            obtain.setSource(NumberPicker.this);
            if (hasVirtualDecrementButton()) {
                obtain.addChild(NumberPicker.this, 3);
            }
            obtain.addChild(NumberPicker.this, 2);
            if (hasVirtualIncrementButton()) {
                obtain.addChild(NumberPicker.this, 1);
            }
            obtain.setParent((View) NumberPicker.this.getParentForAccessibility());
            obtain.setEnabled(NumberPicker.this.isEnabled());
            obtain.setScrollable(true);
            Rect rect = this.mTempRect;
            rect.set(i, i2, i3, i4);
            obtain.setBoundsInParent(rect);
            obtain.setVisibleToUser(NumberPicker.this.getVisibility() == 0);
            int[] iArr = this.mTempArray;
            NumberPicker.this.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            obtain.setBoundsInScreen(rect);
            if (this.mAccessibilityFocusedView != -1) {
                obtain.addAction(64);
            }
            if (this.mAccessibilityFocusedView == -1) {
                obtain.addAction((int) NotificationCompat.FLAG_HIGH_PRIORITY);
            }
            if (NumberPicker.this.isEnabled()) {
                if (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() < NumberPicker.this.getMaxValue()) {
                    obtain.addAction(4096);
                }
                if (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() > NumberPicker.this.getMinValue()) {
                    obtain.addAction(8192);
                }
            }
            return obtain;
        }

        private boolean hasVirtualDecrementButton() {
            return NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() > NumberPicker.this.getMinValue();
        }

        private boolean hasVirtualIncrementButton() {
            return NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() < NumberPicker.this.getMaxValue();
        }

        private String getVirtualDecrementButtonText() {
            int i = NumberPicker.this.mValue - 1;
            if (NumberPicker.this.mWrapSelectorWheel) {
                i = NumberPicker.this.getWrappedSelectorIndex(i);
            }
            if (i < NumberPicker.this.mMinValue) {
                return null;
            }
            if (NumberPicker.this.mDisplayedValues == null) {
                return NumberPicker.this.formatNumber(i);
            }
            return NumberPicker.this.mDisplayedValues[i - NumberPicker.this.mMinValue];
        }

        private String getVirtualIncrementButtonText() {
            int i = NumberPicker.this.mValue + 1;
            if (NumberPicker.this.mWrapSelectorWheel) {
                i = NumberPicker.this.getWrappedSelectorIndex(i);
            }
            if (i > NumberPicker.this.mMaxValue) {
                return null;
            }
            if (NumberPicker.this.mDisplayedValues == null) {
                return NumberPicker.this.formatNumber(i);
            }
            return NumberPicker.this.mDisplayedValues[i - NumberPicker.this.mMinValue];
        }
    }

    private void refreshWheel() {
        initializeSelectorWheelIndices();
        invalidate();
    }
}
