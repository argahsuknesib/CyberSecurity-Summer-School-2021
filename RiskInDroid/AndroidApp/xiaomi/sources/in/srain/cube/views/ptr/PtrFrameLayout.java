package in.srain.cube.views.ptr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import in.srain.cube.views.ptr.util.PtrCLog;

public class PtrFrameLayout extends ViewGroup {
    public static boolean DEBUG = false;
    private static byte FLAG_AUTO_REFRESH_AT_ONCE = 1;
    private static byte FLAG_AUTO_REFRESH_BUT_LATER = 2;
    private static byte FLAG_ENABLE_NEXT_PTR_AT_ONCE = 4;
    private static byte FLAG_PIN_CONTENT = 8;
    private static int ID = 1;
    private static byte MASK_AUTO_REFRESH = 3;
    protected final String LOG_TAG;
    private int mContainerId;
    protected View mContent;
    private boolean mDisableWhenHorizontalMove;
    private int mDurationToClose;
    private int mDurationToCloseHeader;
    private int mFlag;
    private boolean mHasSendCancelEvent;
    private int mHeaderHeight;
    private int mHeaderId;
    private View mHeaderView;
    private boolean mKeepHeaderWhenRefresh;
    private MotionEvent mLastMoveEvent;
    private int mLoadingMinTime;
    private long mLoadingStartTime;
    private int mPagingTouchSlop;
    private Runnable mPerformRefreshCompleteDelay;
    private boolean mPreventForHorizontal;
    private PtrHandler mPtrHandler;
    public PtrIndicator mPtrIndicator;
    private PtrUIHandlerHolder mPtrUIHandlerHolder;
    private boolean mPullToRefresh;
    private PtrUIHandlerHook mRefreshCompleteHook;
    private ScrollChecker mScrollChecker;
    private byte mStatus;

    /* access modifiers changed from: protected */
    public void onPositionChange(boolean z, byte b, PtrIndicator ptrIndicator) {
    }

    @Deprecated
    public void setInterceptEventWhileWorking(boolean z) {
    }

    public PtrFrameLayout(Context context) {
        this(context, null);
    }

    public PtrFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PtrFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatus = 1;
        StringBuilder sb = new StringBuilder("ptr-frame-");
        int i2 = ID + 1;
        ID = i2;
        sb.append(i2);
        this.LOG_TAG = sb.toString();
        this.mHeaderId = 0;
        this.mContainerId = 0;
        this.mDurationToClose = 200;
        this.mDurationToCloseHeader = 1000;
        this.mKeepHeaderWhenRefresh = true;
        this.mPullToRefresh = false;
        this.mPtrUIHandlerHolder = PtrUIHandlerHolder.create();
        this.mDisableWhenHorizontalMove = false;
        this.mFlag = 0;
        this.mPreventForHorizontal = false;
        this.mLoadingMinTime = 500;
        this.mLoadingStartTime = 0;
        this.mHasSendCancelEvent = false;
        this.mPerformRefreshCompleteDelay = new Runnable() {
            /* class in.srain.cube.views.ptr.PtrFrameLayout.AnonymousClass1 */

            public void run() {
                PtrFrameLayout.this.performRefreshComplete();
            }
        };
        this.mPtrIndicator = new PtrIndicator();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.ptr_content, R.attr.ptr_duration_to_close, R.attr.ptr_duration_to_close_header, R.attr.ptr_header, R.attr.ptr_keep_header_when_refresh, R.attr.ptr_pull_to_fresh, R.attr.ptr_ratio_of_header_height_to_refresh, R.attr.ptr_resistance}, 0, 0);
        if (obtainStyledAttributes != null) {
            this.mHeaderId = obtainStyledAttributes.getResourceId(3, this.mHeaderId);
            this.mContainerId = obtainStyledAttributes.getResourceId(0, this.mContainerId);
            PtrIndicator ptrIndicator = this.mPtrIndicator;
            ptrIndicator.setResistance(obtainStyledAttributes.getFloat(7, ptrIndicator.getResistance()));
            this.mDurationToClose = obtainStyledAttributes.getInt(1, this.mDurationToClose);
            this.mDurationToCloseHeader = obtainStyledAttributes.getInt(2, this.mDurationToCloseHeader);
            this.mPtrIndicator.setRatioOfHeaderHeightToRefresh(obtainStyledAttributes.getFloat(6, this.mPtrIndicator.getRatioOfHeaderToHeightRefresh()));
            this.mKeepHeaderWhenRefresh = obtainStyledAttributes.getBoolean(4, this.mKeepHeaderWhenRefresh);
            this.mPullToRefresh = obtainStyledAttributes.getBoolean(5, this.mPullToRefresh);
            obtainStyledAttributes.recycle();
        }
        this.mScrollChecker = new ScrollChecker();
        this.mPagingTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x005c, code lost:
        if (r2 == r0) goto L_0x005e;
     */
    public void onFinishInflate() {
        int childCount = getChildCount();
        if (childCount <= 2) {
            if (childCount == 2) {
                int i = this.mHeaderId;
                if (i != 0 && this.mHeaderView == null) {
                    this.mHeaderView = findViewById(i);
                }
                int i2 = this.mContainerId;
                if (i2 != 0 && this.mContent == null) {
                    this.mContent = findViewById(i2);
                }
                if (this.mContent == null || this.mHeaderView == null) {
                    View childAt = getChildAt(0);
                    View childAt2 = getChildAt(1);
                    if (childAt instanceof PtrUIHandler) {
                        this.mHeaderView = childAt;
                    } else {
                        if (childAt2 instanceof PtrUIHandler) {
                            this.mHeaderView = childAt2;
                        } else if (this.mContent == null && this.mHeaderView == null) {
                            this.mHeaderView = childAt;
                        } else {
                            View view = this.mHeaderView;
                            if (view == null) {
                                if (this.mContent == childAt) {
                                    childAt = childAt2;
                                }
                                this.mHeaderView = childAt;
                            }
                        }
                        this.mContent = childAt;
                    }
                    childAt = childAt2;
                    this.mContent = childAt;
                }
            } else if (childCount == 1) {
                this.mContent = getChildAt(0);
            } else {
                TextView textView = new TextView(getContext());
                textView.setClickable(true);
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText("The content view in PtrFrameLayout is empty. Do you forget to specify its id in xml layout file?");
                this.mContent = textView;
                addView(this.mContent);
            }
            View view2 = this.mHeaderView;
            if (view2 != null) {
                view2.bringToFront();
            }
            super.onFinishInflate();
            return;
        }
        throw new IllegalStateException("PtrFrameLayout only can host 2 elements");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ScrollChecker scrollChecker = this.mScrollChecker;
        if (scrollChecker != null) {
            scrollChecker.destroy();
        }
        Runnable runnable = this.mPerformRefreshCompleteDelay;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (DEBUG) {
            PtrCLog.d(this.LOG_TAG, "onMeasure frame: width: %s, height: %s, padding: %s %s %s %s", Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getPaddingLeft()), Integer.valueOf(getPaddingRight()), Integer.valueOf(getPaddingTop()), Integer.valueOf(getPaddingBottom()));
        }
        View view = this.mHeaderView;
        if (view != null) {
            measureChildWithMargins(view, i, 0, i2, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mHeaderView.getLayoutParams();
            this.mHeaderHeight = this.mHeaderView.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            this.mPtrIndicator.setHeaderHeight(this.mHeaderHeight);
        }
        View view2 = this.mContent;
        if (view2 != null) {
            measureContentView(view2, i, i2);
            if (DEBUG) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mContent.getLayoutParams();
                PtrCLog.d(this.LOG_TAG, "onMeasure content, width: %s, height: %s, margin: %s %s %s %s", Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()), Integer.valueOf(marginLayoutParams2.leftMargin), Integer.valueOf(marginLayoutParams2.topMargin), Integer.valueOf(marginLayoutParams2.rightMargin), Integer.valueOf(marginLayoutParams2.bottomMargin));
                PtrCLog.d(this.LOG_TAG, "onMeasure, currentPos: %s, lastPos: %s, top: %s", Integer.valueOf(this.mPtrIndicator.getCurrentPosY()), Integer.valueOf(this.mPtrIndicator.getLastPosY()), Integer.valueOf(this.mContent.getTop()));
            }
        }
    }

    private void measureContentView(View view, int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin, marginLayoutParams.height));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layoutChildren();
    }

    private void layoutChildren() {
        int currentPosY = this.mPtrIndicator.getCurrentPosY();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        View view = this.mHeaderView;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i = marginLayoutParams.leftMargin + paddingLeft;
            int i2 = ((marginLayoutParams.topMargin + paddingTop) + currentPosY) - this.mHeaderHeight;
            int measuredWidth = this.mHeaderView.getMeasuredWidth() + i;
            int measuredHeight = this.mHeaderView.getMeasuredHeight() + i2;
            this.mHeaderView.layout(i, i2, measuredWidth, measuredHeight);
            if (DEBUG) {
                PtrCLog.d(this.LOG_TAG, "onLayout header: %s %s %s %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
            }
        }
        if (this.mContent != null) {
            if (isPinContent()) {
                currentPosY = 0;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mContent.getLayoutParams();
            int i3 = paddingLeft + marginLayoutParams2.leftMargin;
            int i4 = paddingTop + marginLayoutParams2.topMargin + currentPosY;
            int measuredWidth2 = this.mContent.getMeasuredWidth() + i3;
            int measuredHeight2 = this.mContent.getMeasuredHeight() + i4;
            if (DEBUG) {
                PtrCLog.d(this.LOG_TAG, "onLayout content: %s %s %s %s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(measuredWidth2), Integer.valueOf(measuredHeight2));
            }
            this.mContent.layout(i3, i4, measuredWidth2, measuredHeight2);
        }
    }

    public boolean dispatchTouchEventSupper(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r0 != 3) goto L_0x00e9;
     */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        PtrHandler ptrHandler;
        if (!isEnabled() || this.mContent == null || this.mHeaderView == null) {
            return dispatchTouchEventSupper(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.mLastMoveEvent = motionEvent;
                    this.mPtrIndicator.onMove(motionEvent.getX(), motionEvent.getY());
                    float offsetX = this.mPtrIndicator.getOffsetX();
                    float offsetY = this.mPtrIndicator.getOffsetY();
                    if (this.mDisableWhenHorizontalMove && !this.mPreventForHorizontal && Math.abs(offsetX) > ((float) this.mPagingTouchSlop) && Math.abs(offsetX) > Math.abs(offsetY) && this.mPtrIndicator.isInStartPosition()) {
                        this.mPreventForHorizontal = true;
                    }
                    if (this.mPreventForHorizontal) {
                        return dispatchTouchEventSupper(motionEvent);
                    }
                    boolean z = offsetY > 0.0f;
                    boolean z2 = !z;
                    boolean hasLeftStartPosition = this.mPtrIndicator.hasLeftStartPosition();
                    if (DEBUG) {
                        PtrHandler ptrHandler2 = this.mPtrHandler;
                        PtrCLog.v(this.LOG_TAG, "ACTION_MOVE: offsetY:%s, currentPos: %s, moveUp: %s, canMoveUp: %s, moveDown: %s: canMoveDown: %s", Float.valueOf(offsetY), Integer.valueOf(this.mPtrIndicator.getCurrentPosY()), Boolean.valueOf(z2), Boolean.valueOf(hasLeftStartPosition), Boolean.valueOf(z), Boolean.valueOf(ptrHandler2 != null && ptrHandler2.checkCanDoRefresh(this, this.mContent, this.mHeaderView)));
                    }
                    if (z && (ptrHandler = this.mPtrHandler) != null && !ptrHandler.checkCanDoRefresh(this, this.mContent, this.mHeaderView)) {
                        return dispatchTouchEventSupper(motionEvent);
                    }
                    if ((z2 && hasLeftStartPosition) || z) {
                        movePos(offsetY);
                        return true;
                    }
                }
                return dispatchTouchEventSupper(motionEvent);
            }
            this.mPtrIndicator.onRelease();
            if (!this.mPtrIndicator.hasLeftStartPosition()) {
                return dispatchTouchEventSupper(motionEvent);
            }
            if (DEBUG) {
                PtrCLog.d(this.LOG_TAG, "call onRelease when user release");
            }
            onRelease(false);
            if (!this.mPtrIndicator.hasMovedAfterPressedDown()) {
                return dispatchTouchEventSupper(motionEvent);
            }
            sendCancelEvent();
            return true;
        }
        this.mHasSendCancelEvent = false;
        this.mPtrIndicator.onPressDown(motionEvent.getX(), motionEvent.getY());
        this.mScrollChecker.abortIfWorking();
        this.mPreventForHorizontal = false;
        dispatchTouchEventSupper(motionEvent);
        return true;
    }

    public void movePos(float f) {
        if (f >= 0.0f || !this.mPtrIndicator.isInStartPosition()) {
            int currentPosY = ((int) f) + this.mPtrIndicator.getCurrentPosY();
            if (this.mPtrIndicator.willOverTop(currentPosY)) {
                if (DEBUG) {
                    PtrCLog.e(this.LOG_TAG, String.format("over top", new Object[0]));
                }
                currentPosY = 0;
            }
            this.mPtrIndicator.setCurrentPos(currentPosY);
            updatePos(currentPosY - this.mPtrIndicator.getLastPosY());
        } else if (DEBUG) {
            PtrCLog.e(this.LOG_TAG, String.format("has reached the top", new Object[0]));
        }
    }

    private void updatePos(int i) {
        if (i != 0) {
            boolean isUnderTouch = this.mPtrIndicator.isUnderTouch();
            if (isUnderTouch && !this.mHasSendCancelEvent && this.mPtrIndicator.hasMovedAfterPressedDown()) {
                this.mHasSendCancelEvent = true;
                sendCancelEvent();
            }
            if ((this.mPtrIndicator.hasJustLeftStartPosition() && this.mStatus == 1) || (this.mPtrIndicator.goDownCrossFinishPosition() && this.mStatus == 4 && isEnabledNextPtrAtOnce())) {
                this.mStatus = 2;
                this.mPtrUIHandlerHolder.onUIRefreshPrepare(this);
                if (DEBUG) {
                    PtrCLog.i(this.LOG_TAG, "PtrUIHandler: onUIRefreshPrepare, mFlag %s", Integer.valueOf(this.mFlag));
                }
            }
            if (this.mPtrIndicator.hasJustBackToStartPosition()) {
                tryToNotifyReset();
                if (isUnderTouch) {
                    sendDownEvent();
                }
            }
            if (this.mStatus == 2) {
                if (isUnderTouch && !isAutoRefresh() && this.mPullToRefresh && this.mPtrIndicator.crossRefreshLineFromTopToBottom()) {
                    tryToPerformRefresh();
                }
                if (performAutoRefreshButLater() && this.mPtrIndicator.hasJustReachedHeaderHeightFromTopToBottom()) {
                    tryToPerformRefresh();
                }
            }
            if (DEBUG) {
                PtrCLog.v(this.LOG_TAG, "updatePos: change: %s, current: %s last: %s, top: %s, headerHeight: %s", Integer.valueOf(i), Integer.valueOf(this.mPtrIndicator.getCurrentPosY()), Integer.valueOf(this.mPtrIndicator.getLastPosY()), Integer.valueOf(this.mContent.getTop()), Integer.valueOf(this.mHeaderHeight));
            }
            this.mHeaderView.offsetTopAndBottom(i);
            if (!isPinContent()) {
                this.mContent.offsetTopAndBottom(i);
            }
            invalidate();
            if (this.mPtrUIHandlerHolder.hasHandler()) {
                this.mPtrUIHandlerHolder.onUIPositionChange(this, isUnderTouch, this.mStatus, this.mPtrIndicator);
            }
            onPositionChange(isUnderTouch, this.mStatus, this.mPtrIndicator);
        }
    }

    public int getHeaderHeight() {
        return this.mHeaderHeight;
    }

    private void onRelease(boolean z) {
        tryToPerformRefresh();
        byte b = this.mStatus;
        if (b == 3) {
            if (!this.mKeepHeaderWhenRefresh) {
                tryScrollBackToTopWhileLoading();
            } else if (this.mPtrIndicator.isOverOffsetToKeepHeaderWhileLoading() && !z) {
                this.mScrollChecker.tryToScrollTo(this.mPtrIndicator.getOffsetToKeepHeaderWhileLoading(), this.mDurationToClose);
            }
        } else if (b == 4) {
            notifyUIRefreshComplete(false);
        } else {
            tryScrollBackToTopAbortRefresh();
        }
    }

    public void setRefreshCompleteHook(PtrUIHandlerHook ptrUIHandlerHook) {
        this.mRefreshCompleteHook = ptrUIHandlerHook;
        ptrUIHandlerHook.setResumeAction(new Runnable() {
            /* class in.srain.cube.views.ptr.PtrFrameLayout.AnonymousClass2 */

            public void run() {
                if (PtrFrameLayout.DEBUG) {
                    PtrCLog.d(PtrFrameLayout.this.LOG_TAG, "mRefreshCompleteHook resume.");
                }
                PtrFrameLayout.this.notifyUIRefreshComplete(true);
            }
        });
    }

    private void tryScrollBackToTop() {
        if (!this.mPtrIndicator.isUnderTouch()) {
            this.mScrollChecker.tryToScrollTo(0, this.mDurationToCloseHeader);
        }
    }

    private void tryScrollBackToTopWhileLoading() {
        tryScrollBackToTop();
    }

    private void tryScrollBackToTopAfterComplete() {
        tryScrollBackToTop();
    }

    private void tryScrollBackToTopAbortRefresh() {
        tryScrollBackToTop();
    }

    private boolean tryToPerformRefresh() {
        if (this.mStatus != 2) {
            return false;
        }
        if ((this.mPtrIndicator.isOverOffsetToKeepHeaderWhileLoading() && isAutoRefresh()) || this.mPtrIndicator.isOverOffsetToRefresh()) {
            this.mStatus = 3;
            performRefresh();
        }
        return false;
    }

    private void performRefresh() {
        this.mLoadingStartTime = System.currentTimeMillis();
        if (this.mPtrUIHandlerHolder.hasHandler()) {
            this.mPtrUIHandlerHolder.onUIRefreshBegin(this);
            if (DEBUG) {
                PtrCLog.i(this.LOG_TAG, "PtrUIHandler: onUIRefreshBegin");
            }
        }
        PtrHandler ptrHandler = this.mPtrHandler;
        if (ptrHandler != null) {
            ptrHandler.onRefreshBegin(this);
        }
    }

    private boolean tryToNotifyReset() {
        byte b = this.mStatus;
        if ((b != 4 && b != 2) || !this.mPtrIndicator.isInStartPosition()) {
            return false;
        }
        if (this.mPtrUIHandlerHolder.hasHandler()) {
            this.mPtrUIHandlerHolder.onUIReset(this);
            if (DEBUG) {
                PtrCLog.i(this.LOG_TAG, "PtrUIHandler: onUIReset");
            }
        }
        this.mStatus = 1;
        clearFlag();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPtrScrollAbort() {
        if (this.mPtrIndicator.hasLeftStartPosition() && isAutoRefresh()) {
            if (DEBUG) {
                PtrCLog.d(this.LOG_TAG, "call onRelease after scroll abort");
            }
            onRelease(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onPtrScrollFinish() {
        if (this.mPtrIndicator.hasLeftStartPosition() && isAutoRefresh()) {
            if (DEBUG) {
                PtrCLog.d(this.LOG_TAG, "call onRelease after scroll finish");
            }
            onRelease(true);
        }
    }

    public boolean isRefreshing() {
        return this.mStatus == 3;
    }

    public final void refreshComplete() {
        if (DEBUG) {
            PtrCLog.i(this.LOG_TAG, "refreshComplete");
        }
        PtrUIHandlerHook ptrUIHandlerHook = this.mRefreshCompleteHook;
        if (ptrUIHandlerHook != null) {
            ptrUIHandlerHook.reset();
        }
        int currentTimeMillis = (int) (((long) this.mLoadingMinTime) - (System.currentTimeMillis() - this.mLoadingStartTime));
        if (currentTimeMillis <= 0) {
            if (DEBUG) {
                PtrCLog.d(this.LOG_TAG, "performRefreshComplete at once");
            }
            performRefreshComplete();
            return;
        }
        postDelayed(this.mPerformRefreshCompleteDelay, (long) currentTimeMillis);
        if (DEBUG) {
            PtrCLog.d(this.LOG_TAG, "performRefreshComplete after delay: %s", Integer.valueOf(currentTimeMillis));
        }
    }

    public void performRefreshComplete() {
        this.mStatus = 4;
        if (!this.mScrollChecker.mIsRunning || !isAutoRefresh()) {
            notifyUIRefreshComplete(false);
        } else if (DEBUG) {
            PtrCLog.d(this.LOG_TAG, "performRefreshComplete do nothing, scrolling: %s, auto refresh: %s", Boolean.valueOf(this.mScrollChecker.mIsRunning), Integer.valueOf(this.mFlag));
        }
    }

    public void notifyUIRefreshComplete(boolean z) {
        if (!this.mPtrIndicator.hasLeftStartPosition() || z || this.mRefreshCompleteHook == null) {
            if (this.mPtrUIHandlerHolder.hasHandler()) {
                if (DEBUG) {
                    PtrCLog.i(this.LOG_TAG, "PtrUIHandler: onUIRefreshComplete");
                }
                this.mPtrUIHandlerHolder.onUIRefreshComplete(this);
            }
            this.mPtrIndicator.onUIRefreshComplete();
            tryScrollBackToTopAfterComplete();
            tryToNotifyReset();
            return;
        }
        if (DEBUG) {
            PtrCLog.d(this.LOG_TAG, "notifyUIRefreshComplete mRefreshCompleteHook run.");
        }
        this.mRefreshCompleteHook.takeOver();
    }

    public void autoRefresh() {
        autoRefresh(true, this.mDurationToCloseHeader);
    }

    public void autoRefresh(boolean z) {
        autoRefresh(z, this.mDurationToCloseHeader);
    }

    private void clearFlag() {
        this.mFlag &= MASK_AUTO_REFRESH ^ -1;
    }

    public void autoRefresh(boolean z, int i) {
        if (this.mStatus == 1) {
            this.mFlag |= z ? FLAG_AUTO_REFRESH_AT_ONCE : FLAG_AUTO_REFRESH_BUT_LATER;
            this.mStatus = 2;
            if (this.mPtrUIHandlerHolder.hasHandler()) {
                this.mPtrUIHandlerHolder.onUIRefreshPrepare(this);
                if (DEBUG) {
                    PtrCLog.i(this.LOG_TAG, "PtrUIHandler: onUIRefreshPrepare, mFlag %s", Integer.valueOf(this.mFlag));
                }
            }
            this.mScrollChecker.tryToScrollTo(this.mPtrIndicator.getOffsetToRefresh(), i);
            if (z) {
                this.mStatus = 3;
                performRefresh();
            }
        }
    }

    public boolean isAutoRefresh() {
        return (this.mFlag & MASK_AUTO_REFRESH) > 0;
    }

    private boolean performAutoRefreshButLater() {
        return (this.mFlag & MASK_AUTO_REFRESH) == FLAG_AUTO_REFRESH_BUT_LATER;
    }

    public boolean isEnabledNextPtrAtOnce() {
        return (this.mFlag & FLAG_ENABLE_NEXT_PTR_AT_ONCE) > 0;
    }

    public void setEnabledNextPtrAtOnce(boolean z) {
        if (z) {
            this.mFlag |= FLAG_ENABLE_NEXT_PTR_AT_ONCE;
        } else {
            this.mFlag &= FLAG_ENABLE_NEXT_PTR_AT_ONCE ^ -1;
        }
    }

    public boolean isPinContent() {
        return (this.mFlag & FLAG_PIN_CONTENT) > 0;
    }

    public void setPinContent(boolean z) {
        if (z) {
            this.mFlag |= FLAG_PIN_CONTENT;
        } else {
            this.mFlag &= FLAG_PIN_CONTENT ^ -1;
        }
    }

    public void disableWhenHorizontalMove(boolean z) {
        this.mDisableWhenHorizontalMove = z;
    }

    public void setLoadingMinTime(int i) {
        this.mLoadingMinTime = i;
    }

    public View getContentView() {
        return this.mContent;
    }

    public void setPtrHandler(PtrHandler ptrHandler) {
        this.mPtrHandler = ptrHandler;
    }

    public void addPtrUIHandler(PtrUIHandler ptrUIHandler) {
        PtrUIHandlerHolder.addHandler(this.mPtrUIHandlerHolder, ptrUIHandler);
    }

    public void removePtrUIHandler(PtrUIHandler ptrUIHandler) {
        this.mPtrUIHandlerHolder = PtrUIHandlerHolder.removeHandler(this.mPtrUIHandlerHolder, ptrUIHandler);
    }

    public void setPtrIndicator(PtrIndicator ptrIndicator) {
        PtrIndicator ptrIndicator2 = this.mPtrIndicator;
        if (!(ptrIndicator2 == null || ptrIndicator2 == ptrIndicator)) {
            ptrIndicator.convertFrom(ptrIndicator2);
        }
        this.mPtrIndicator = ptrIndicator;
    }

    public float getResistance() {
        return this.mPtrIndicator.getResistance();
    }

    public void setResistance(float f) {
        this.mPtrIndicator.setResistance(f);
    }

    public float getDurationToClose() {
        return (float) this.mDurationToClose;
    }

    public void setDurationToClose(int i) {
        this.mDurationToClose = i;
    }

    public long getDurationToCloseHeader() {
        return (long) this.mDurationToCloseHeader;
    }

    public void setDurationToCloseHeader(int i) {
        this.mDurationToCloseHeader = i;
    }

    public void setRatioOfHeaderHeightToRefresh(float f) {
        this.mPtrIndicator.setRatioOfHeaderHeightToRefresh(f);
    }

    public int getOffsetToRefresh() {
        return this.mPtrIndicator.getOffsetToRefresh();
    }

    public void setOffsetToRefresh(int i) {
        this.mPtrIndicator.setOffsetToRefresh(i);
    }

    public float getRatioOfHeaderToHeightRefresh() {
        return this.mPtrIndicator.getRatioOfHeaderToHeightRefresh();
    }

    public int getOffsetToKeepHeaderWhileLoading() {
        return this.mPtrIndicator.getOffsetToKeepHeaderWhileLoading();
    }

    public void setOffsetToKeepHeaderWhileLoading(int i) {
        this.mPtrIndicator.setOffsetToKeepHeaderWhileLoading(i);
    }

    public boolean isKeepHeaderWhenRefresh() {
        return this.mKeepHeaderWhenRefresh;
    }

    public void setKeepHeaderWhenRefresh(boolean z) {
        this.mKeepHeaderWhenRefresh = z;
    }

    public boolean isPullToRefresh() {
        return this.mPullToRefresh;
    }

    public void setPullToRefresh(boolean z) {
        this.mPullToRefresh = z;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public void setHeaderView(View view) {
        View view2 = this.mHeaderView;
        if (!(view2 == null || view == null || view2 == view)) {
            removeView(view2);
        }
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new LayoutParams(-1, -2));
        }
        this.mHeaderView = view;
        addView(view);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private void sendCancelEvent() {
        if (DEBUG) {
            PtrCLog.d(this.LOG_TAG, "send cancel event");
        }
        MotionEvent motionEvent = this.mLastMoveEvent;
        if (motionEvent != null) {
            dispatchTouchEventSupper(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime() + ((long) ViewConfiguration.getLongPressTimeout()), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
        }
    }

    private void sendDownEvent() {
        if (DEBUG) {
            PtrCLog.d(this.LOG_TAG, "send down event");
        }
        MotionEvent motionEvent = this.mLastMoveEvent;
        dispatchTouchEventSupper(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    class ScrollChecker implements Runnable {
        public boolean mIsRunning = false;
        private int mLastFlingY;
        private Scroller mScroller;
        private int mStart;
        private int mTo;

        public ScrollChecker() {
            this.mScroller = new Scroller(PtrFrameLayout.this.getContext());
        }

        public void run() {
            boolean z = !this.mScroller.computeScrollOffset() || this.mScroller.isFinished();
            int currY = this.mScroller.getCurrY();
            int i = currY - this.mLastFlingY;
            if (PtrFrameLayout.DEBUG && i != 0) {
                PtrCLog.v(PtrFrameLayout.this.LOG_TAG, "scroll: %s, start: %s, to: %s, currentPos: %s, current :%s, last: %s, delta: %s", Boolean.valueOf(z), Integer.valueOf(this.mStart), Integer.valueOf(this.mTo), Integer.valueOf(PtrFrameLayout.this.mPtrIndicator.getCurrentPosY()), Integer.valueOf(currY), Integer.valueOf(this.mLastFlingY), Integer.valueOf(i));
            }
            if (!z) {
                this.mLastFlingY = currY;
                PtrFrameLayout.this.movePos((float) i);
                PtrFrameLayout.this.post(this);
                return;
            }
            finish();
        }

        private void finish() {
            if (PtrFrameLayout.DEBUG) {
                PtrCLog.v(PtrFrameLayout.this.LOG_TAG, "finish, currentPos:%s", Integer.valueOf(PtrFrameLayout.this.mPtrIndicator.getCurrentPosY()));
            }
            reset();
            PtrFrameLayout.this.onPtrScrollFinish();
        }

        private void reset() {
            this.mIsRunning = false;
            this.mLastFlingY = 0;
            PtrFrameLayout.this.removeCallbacks(this);
        }

        public void destroy() {
            reset();
            if (!this.mScroller.isFinished()) {
                this.mScroller.forceFinished(true);
            }
        }

        public void abortIfWorking() {
            if (this.mIsRunning) {
                if (!this.mScroller.isFinished()) {
                    this.mScroller.forceFinished(true);
                }
                PtrFrameLayout.this.onPtrScrollAbort();
                reset();
            }
        }

        public void tryToScrollTo(int i, int i2) {
            if (!PtrFrameLayout.this.mPtrIndicator.isAlreadyHere(i)) {
                this.mStart = PtrFrameLayout.this.mPtrIndicator.getCurrentPosY();
                this.mTo = i;
                int i3 = i - this.mStart;
                if (PtrFrameLayout.DEBUG) {
                    PtrCLog.d(PtrFrameLayout.this.LOG_TAG, "tryToScrollTo: start: %s, distance:%s, to:%s", Integer.valueOf(this.mStart), Integer.valueOf(i3), Integer.valueOf(i));
                }
                PtrFrameLayout.this.removeCallbacks(this);
                this.mLastFlingY = 0;
                if (!this.mScroller.isFinished()) {
                    this.mScroller.forceFinished(true);
                }
                this.mScroller.startScroll(0, 0, 0, i3, i2);
                PtrFrameLayout.this.post(this);
                this.mIsRunning = true;
            }
        }
    }
}
