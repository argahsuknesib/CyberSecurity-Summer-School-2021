package android.support.v7.widget.helper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.animation.AnimatorListenerCompat;
import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchUIUtilImpl;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    int mActionState = 0;
    int mActivePointerId = -1;
    Callback mCallback;
    private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
    private List<Integer> mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    GestureDetectorCompat mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    float mMaxSwipeVelocity;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() {
        /* class android.support.v7.widget.helper.ItemTouchHelper.AnonymousClass2 */

        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            RecoverAnimation findAnimation;
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 0) {
                ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(0);
                ItemTouchHelper.this.mInitialTouchX = motionEvent.getX();
                ItemTouchHelper.this.mInitialTouchY = motionEvent.getY();
                ItemTouchHelper.this.obtainVelocityTracker();
                if (ItemTouchHelper.this.mSelected == null && (findAnimation = ItemTouchHelper.this.findAnimation(motionEvent)) != null) {
                    ItemTouchHelper.this.mInitialTouchX -= findAnimation.mX;
                    ItemTouchHelper.this.mInitialTouchY -= findAnimation.mY;
                    ItemTouchHelper.this.endRecoverAnimation(findAnimation.mViewHolder, true);
                    if (ItemTouchHelper.this.mPendingCleanup.remove(findAnimation.mViewHolder.itemView)) {
                        ItemTouchHelper.this.mCallback.clearView(ItemTouchHelper.this.mRecyclerView, findAnimation.mViewHolder);
                    }
                    ItemTouchHelper.this.select(findAnimation.mViewHolder, findAnimation.mActionState);
                    ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                    itemTouchHelper.updateDxDy(motionEvent, itemTouchHelper.mSelectedFlags, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                itemTouchHelper2.mActivePointerId = -1;
                itemTouchHelper2.select(null, 0);
            } else if (ItemTouchHelper.this.mActivePointerId != -1 && (findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId)) >= 0) {
                ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
            }
            if (ItemTouchHelper.this.mVelocityTracker != null) {
                ItemTouchHelper.this.mVelocityTracker.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.mSelected != null;
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            if (ItemTouchHelper.this.mVelocityTracker != null) {
                ItemTouchHelper.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.mActivePointerId != -1) {
                int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
                }
                RecyclerView.ViewHolder viewHolder = ItemTouchHelper.this.mSelected;
                if (viewHolder != null) {
                    int i = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked != 3) {
                                if (actionMasked == 6) {
                                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                                    if (motionEvent.getPointerId(actionIndex) == ItemTouchHelper.this.mActivePointerId) {
                                        if (actionIndex == 0) {
                                            i = 1;
                                        }
                                        ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(i);
                                        ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                                        itemTouchHelper.updateDxDy(motionEvent, itemTouchHelper.mSelectedFlags, actionIndex);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } else if (ItemTouchHelper.this.mVelocityTracker != null) {
                                ItemTouchHelper.this.mVelocityTracker.clear();
                            }
                        } else if (findPointerIndex >= 0) {
                            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                            itemTouchHelper2.updateDxDy(motionEvent, itemTouchHelper2.mSelectedFlags, findPointerIndex);
                            ItemTouchHelper.this.moveIfNecessary(viewHolder);
                            ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
                            ItemTouchHelper.this.mScrollRunnable.run();
                            ItemTouchHelper.this.mRecyclerView.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    ItemTouchHelper.this.select(null, 0);
                    ItemTouchHelper.this.mActivePointerId = -1;
                }
            }
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.select(null, 0);
            }
        }
    };
    View mOverdrawChild = null;
    int mOverdrawChildPosition = -1;
    final List<View> mPendingCleanup = new ArrayList();
    List<RecoverAnimation> mRecoverAnimations = new ArrayList();
    RecyclerView mRecyclerView;
    final Runnable mScrollRunnable = new Runnable() {
        /* class android.support.v7.widget.helper.ItemTouchHelper.AnonymousClass1 */

        public void run() {
            if (ItemTouchHelper.this.mSelected != null && ItemTouchHelper.this.scrollIfNecessary()) {
                if (ItemTouchHelper.this.mSelected != null) {
                    ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                    itemTouchHelper.moveIfNecessary(itemTouchHelper.mSelected);
                }
                ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
                ViewCompat.postOnAnimation(ItemTouchHelper.this.mRecyclerView, this);
            }
        }
    };
    RecyclerView.ViewHolder mSelected = null;
    int mSelectedFlags;
    float mSelectedStartX;
    float mSelectedStartY;
    private int mSlop;
    private List<RecyclerView.ViewHolder> mSwapTargets;
    float mSwipeEscapeVelocity;
    private final float[] mTmpPosition = new float[2];
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;

    public interface ViewDropHandler {
        void prepareForDrop(View view, View view2, int i, int i2);
    }

    public void onChildViewAttachedToWindow(View view) {
    }

    public ItemTouchHelper(Callback callback) {
        this.mCallback = callback;
    }

    private static boolean hitTest(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                destroyCallbacks();
            }
            this.mRecyclerView = recyclerView;
            if (this.mRecyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.mSwipeEscapeVelocity = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
                this.mMaxSwipeVelocity = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
                setupCallbacks();
            }
        }
    }

    private void setupCallbacks() {
        this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
        initGestureDetector();
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            this.mCallback.clearView(this.mRecyclerView, this.mRecoverAnimations.get(0).mViewHolder);
        }
        this.mRecoverAnimations.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        releaseVelocityTracker();
    }

    private void initGestureDetector() {
        if (this.mGestureDetector == null) {
            this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), new ItemTouchHelperGestureListener());
        }
    }

    private void getSelectedDxDy(float[] fArr) {
        if ((this.mSelectedFlags & 12) != 0) {
            fArr[0] = (this.mSelectedStartX + this.mDx) - ((float) this.mSelected.itemView.getLeft());
        } else {
            fArr[0] = ViewCompat.getTranslationX(this.mSelected.itemView);
        }
        if ((this.mSelectedFlags & 3) != 0) {
            fArr[1] = (this.mSelectedStartY + this.mDy) - ((float) this.mSelected.itemView.getTop());
        } else {
            fArr[1] = ViewCompat.getTranslationY(this.mSelected.itemView);
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float[] fArr = this.mTmpPosition;
            float f3 = fArr[0];
            f = fArr[1];
            f2 = f3;
        } else {
            f2 = 0.0f;
            f = 0.0f;
        }
        this.mCallback.onDrawOver(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f2, f);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2;
        this.mOverdrawChildPosition = -1;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float[] fArr = this.mTmpPosition;
            float f3 = fArr[0];
            f = fArr[1];
            f2 = f3;
        } else {
            f2 = 0.0f;
            f = 0.0f;
        }
        this.mCallback.onDraw(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f2, f);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012c  */
    public void select(RecyclerView.ViewHolder viewHolder, int i) {
        boolean z;
        boolean z2;
        ViewParent parent;
        int i2;
        float f;
        float f2;
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        int i3 = i;
        if (viewHolder2 != this.mSelected || i3 != this.mActionState) {
            this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
            int i4 = this.mActionState;
            endRecoverAnimation(viewHolder2, true);
            this.mActionState = i3;
            if (i3 == 2) {
                this.mOverdrawChild = viewHolder2.itemView;
                addChildDrawingOrderCallback();
            }
            int i5 = (1 << ((i3 * 8) + 8)) - 1;
            RecyclerView.ViewHolder viewHolder3 = this.mSelected;
            if (viewHolder3 != null) {
                if (viewHolder3.itemView.getParent() != null) {
                    if (i4 == 2) {
                        i2 = 0;
                    } else {
                        i2 = swipeIfNecessary(viewHolder3);
                    }
                    releaseVelocityTracker();
                    if (i2 == 1 || i2 == 2) {
                        f = Math.signum(this.mDy) * ((float) this.mRecyclerView.getHeight());
                        f2 = 0.0f;
                    } else {
                        if (i2 == 4 || i2 == 8 || i2 == 16 || i2 == 32) {
                            f2 = Math.signum(this.mDx) * ((float) this.mRecyclerView.getWidth());
                        } else {
                            f2 = 0.0f;
                        }
                        f = 0.0f;
                    }
                    int i6 = i4 == 2 ? 8 : i2 > 0 ? 2 : 4;
                    getSelectedDxDy(this.mTmpPosition);
                    float[] fArr = this.mTmpPosition;
                    float f3 = fArr[0];
                    float f4 = fArr[1];
                    AnonymousClass3 r14 = r0;
                    RecyclerView.ViewHolder viewHolder4 = viewHolder3;
                    final int i7 = i2;
                    final RecyclerView.ViewHolder viewHolder5 = viewHolder4;
                    AnonymousClass3 r0 = new RecoverAnimation(viewHolder3, i6, i4, f3, f4, f2, f) {
                        /* class android.support.v7.widget.helper.ItemTouchHelper.AnonymousClass3 */

                        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
                            super.onAnimationEnd(valueAnimatorCompat);
                            if (!this.mOverridden) {
                                if (i7 <= 0) {
                                    ItemTouchHelper.this.mCallback.clearView(ItemTouchHelper.this.mRecyclerView, viewHolder5);
                                } else {
                                    ItemTouchHelper.this.mPendingCleanup.add(viewHolder5.itemView);
                                    this.mIsPendingCleanup = true;
                                    int i = i7;
                                    if (i > 0) {
                                        ItemTouchHelper.this.postDispatchSwipe(this, i);
                                    }
                                }
                                if (ItemTouchHelper.this.mOverdrawChild == viewHolder5.itemView) {
                                    ItemTouchHelper.this.removeChildDrawingOrderCallbackIfNecessary(viewHolder5.itemView);
                                }
                            }
                        }
                    };
                    r14.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, i6, f2 - f3, f - f4));
                    this.mRecoverAnimations.add(r14);
                    r14.start();
                    z = true;
                } else {
                    RecyclerView.ViewHolder viewHolder6 = viewHolder3;
                    removeChildDrawingOrderCallbackIfNecessary(viewHolder6.itemView);
                    this.mCallback.clearView(this.mRecyclerView, viewHolder6);
                    z = false;
                }
                this.mSelected = null;
            } else {
                z = false;
            }
            if (viewHolder2 != null) {
                this.mSelectedFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, viewHolder2) & i5) >> (this.mActionState * 8);
                this.mSelectedStartX = (float) viewHolder2.itemView.getLeft();
                this.mSelectedStartY = (float) viewHolder2.itemView.getTop();
                this.mSelected = viewHolder2;
                if (i3 == 2) {
                    z2 = false;
                    this.mSelected.itemView.performHapticFeedback(0);
                    parent = this.mRecyclerView.getParent();
                    if (parent != null) {
                        if (this.mSelected != null) {
                            z2 = true;
                        }
                        parent.requestDisallowInterceptTouchEvent(z2);
                    }
                    if (!z) {
                        this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
                    }
                    this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
                    this.mRecyclerView.invalidate();
                }
            }
            z2 = false;
            parent = this.mRecyclerView.getParent();
            if (parent != null) {
            }
            if (!z) {
            }
            this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
            this.mRecyclerView.invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void postDispatchSwipe(final RecoverAnimation recoverAnimation, final int i) {
        this.mRecyclerView.post(new Runnable() {
            /* class android.support.v7.widget.helper.ItemTouchHelper.AnonymousClass4 */

            public void run() {
                if (ItemTouchHelper.this.mRecyclerView != null && ItemTouchHelper.this.mRecyclerView.isAttachedToWindow() && !recoverAnimation.mOverridden && recoverAnimation.mViewHolder.getAdapterPosition() != -1) {
                    RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.mRecyclerView.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemTouchHelper.this.hasRunningRecoverAnim()) {
                        ItemTouchHelper.this.mCallback.onSwiped(recoverAnimation.mViewHolder, i);
                    } else {
                        ItemTouchHelper.this.mRecyclerView.post(this);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean hasRunningRecoverAnim() {
        int size = this.mRecoverAnimations.size();
        for (int i = 0; i < size; i++) {
            if (!this.mRecoverAnimations.get(i).mEnded) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c5, code lost:
        if (r1 > 0) goto L_0x00c9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0104 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0110  */
    public boolean scrollIfNecessary() {
        int i;
        int i2;
        int i3;
        int width;
        if (this.mSelected == null) {
            this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mDragScrollStartTimeInMs;
        long j2 = j == Long.MIN_VALUE ? 0 : currentTimeMillis - j;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (this.mTmpRect == null) {
            this.mTmpRect = new Rect();
        }
        layoutManager.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
        if (layoutManager.canScrollHorizontally()) {
            int i4 = (int) (this.mSelectedStartX + this.mDx);
            int paddingLeft = (i4 - this.mTmpRect.left) - this.mRecyclerView.getPaddingLeft();
            if (this.mDx < 0.0f && paddingLeft < 0) {
                i = paddingLeft;
                if (layoutManager.canScrollVertically()) {
                }
                i2 = 0;
                if (i != 0) {
                }
                int i5 = i;
                if (i2 == 0) {
                }
                if (i3 == 0) {
                }
                if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
                }
                this.mRecyclerView.scrollBy(i3, i2);
                return true;
            } else if (this.mDx > 0.0f && (width = ((i4 + this.mSelected.itemView.getWidth()) + this.mTmpRect.right) - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight())) > 0) {
                i = width;
                if (layoutManager.canScrollVertically()) {
                    int i6 = (int) (this.mSelectedStartY + this.mDy);
                    int paddingTop = (i6 - this.mTmpRect.top) - this.mRecyclerView.getPaddingTop();
                    if (this.mDy < 0.0f && paddingTop < 0) {
                        i2 = paddingTop;
                        if (i != 0) {
                            i = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), i, this.mRecyclerView.getWidth(), j2);
                        }
                        int i52 = i;
                        if (i2 == 0) {
                            i3 = i52;
                            i2 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), i2, this.mRecyclerView.getHeight(), j2);
                        } else {
                            i3 = i52;
                        }
                        if (i3 == 0 || i2 != 0) {
                            if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
                                this.mDragScrollStartTimeInMs = currentTimeMillis;
                            }
                            this.mRecyclerView.scrollBy(i3, i2);
                            return true;
                        }
                        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
                        return false;
                    } else if (this.mDy > 0.0f) {
                        i2 = ((i6 + this.mSelected.itemView.getHeight()) + this.mTmpRect.bottom) - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
                    }
                }
                i2 = 0;
                if (i != 0) {
                }
                int i522 = i;
                if (i2 == 0) {
                }
                if (i3 == 0) {
                }
                if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
                }
                this.mRecyclerView.scrollBy(i3, i2);
                return true;
            }
        }
        i = 0;
        if (layoutManager.canScrollVertically()) {
        }
        i2 = 0;
        if (i != 0) {
        }
        int i5222 = i;
        if (i2 == 0) {
        }
        if (i3 == 0) {
        }
        if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
        }
        this.mRecyclerView.scrollBy(i3, i2);
        return true;
    }

    private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        List<RecyclerView.ViewHolder> list = this.mSwapTargets;
        if (list == null) {
            this.mSwapTargets = new ArrayList();
            this.mDistances = new ArrayList();
        } else {
            list.clear();
            this.mDistances.clear();
        }
        int boundingBoxMargin = this.mCallback.getBoundingBoxMargin();
        int round = Math.round(this.mSelectedStartX + this.mDx) - boundingBoxMargin;
        int round2 = Math.round(this.mSelectedStartY + this.mDy) - boundingBoxMargin;
        int i = boundingBoxMargin * 2;
        int width = viewHolder2.itemView.getWidth() + round + i;
        int height = viewHolder2.itemView.getHeight() + round2 + i;
        int i2 = (round + width) / 2;
        int i3 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = layoutManager.getChildAt(i4);
            if (childAt != viewHolder2.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(childAt);
                if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, childViewHolder)) {
                    int abs = Math.abs(i2 - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i3 - ((childAt.getTop() + childAt.getBottom()) / 2));
                    int i5 = (abs * abs) + (abs2 * abs2);
                    int size = this.mSwapTargets.size();
                    int i6 = 0;
                    int i7 = 0;
                    while (i6 < size && i5 > this.mDistances.get(i6).intValue()) {
                        i7++;
                        i6++;
                    }
                    this.mSwapTargets.add(i7, childViewHolder);
                    this.mDistances.add(i7, Integer.valueOf(i5));
                }
            }
            i4++;
            viewHolder2 = viewHolder;
        }
        return this.mSwapTargets;
    }

    /* access modifiers changed from: package-private */
    public void moveIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (!this.mRecyclerView.isLayoutRequested() && this.mActionState == 2) {
            float moveThreshold = this.mCallback.getMoveThreshold(viewHolder);
            int i = (int) (this.mSelectedStartX + this.mDx);
            int i2 = (int) (this.mSelectedStartY + this.mDy);
            if (((float) Math.abs(i2 - viewHolder.itemView.getTop())) >= ((float) viewHolder.itemView.getHeight()) * moveThreshold || ((float) Math.abs(i - viewHolder.itemView.getLeft())) >= ((float) viewHolder.itemView.getWidth()) * moveThreshold) {
                List<RecyclerView.ViewHolder> findSwapTargets = findSwapTargets(viewHolder);
                if (findSwapTargets.size() != 0) {
                    RecyclerView.ViewHolder chooseDropTarget = this.mCallback.chooseDropTarget(viewHolder, findSwapTargets, i, i2);
                    if (chooseDropTarget == null) {
                        this.mSwapTargets.clear();
                        this.mDistances.clear();
                        return;
                    }
                    int adapterPosition = chooseDropTarget.getAdapterPosition();
                    int adapterPosition2 = viewHolder.getAdapterPosition();
                    if (this.mCallback.onMove(this.mRecyclerView, viewHolder, chooseDropTarget)) {
                        this.mCallback.onMoved(this.mRecyclerView, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i, i2);
                    }
                }
            }
        }
    }

    public void onChildViewDetachedFromWindow(View view) {
        removeChildDrawingOrderCallbackIfNecessary(view);
        RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
        if (childViewHolder != null) {
            RecyclerView.ViewHolder viewHolder = this.mSelected;
            if (viewHolder == null || childViewHolder != viewHolder) {
                endRecoverAnimation(childViewHolder, false);
                if (this.mPendingCleanup.remove(childViewHolder.itemView)) {
                    this.mCallback.clearView(this.mRecyclerView, childViewHolder);
                    return;
                }
                return;
            }
            select(null, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public int endRecoverAnimation(RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder == viewHolder) {
                recoverAnimation.mOverridden |= z;
                if (!recoverAnimation.mEnded) {
                    recoverAnimation.cancel();
                }
                this.mRecoverAnimations.remove(size);
                return recoverAnimation.mAnimationType;
            }
        }
        return 0;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    /* access modifiers changed from: package-private */
    public void obtainVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent motionEvent) {
        View findChildView;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int i = this.mActivePointerId;
        if (i == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.mInitialTouchX);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.mInitialTouchY);
        int i2 = this.mSlop;
        if (abs < ((float) i2) && abs2 < ((float) i2)) {
            return null;
        }
        if (abs > abs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.canScrollVertically()) && (findChildView = findChildView(motionEvent)) != null) {
            return this.mRecyclerView.getChildViewHolder(findChildView);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean checkSelectForSwipe(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.ViewHolder findSwipedView;
        int absoluteMovementFlags;
        if (this.mSelected != null || i != 2 || this.mActionState == 2 || !this.mCallback.isItemViewSwipeEnabled() || this.mRecyclerView.getScrollState() == 1 || (findSwipedView = findSwipedView(motionEvent)) == null || (absoluteMovementFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, findSwipedView) & 65280) >> 8) == 0) {
            return false;
        }
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.mInitialTouchX;
        float f2 = y - this.mInitialTouchY;
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        int i3 = this.mSlop;
        if (abs < ((float) i3) && abs2 < ((float) i3)) {
            return false;
        }
        if (abs > abs2) {
            if (f < 0.0f && (absoluteMovementFlags & 4) == 0) {
                return false;
            }
            if (f > 0.0f && (absoluteMovementFlags & 8) == 0) {
                return false;
            }
        } else if (f2 < 0.0f && (absoluteMovementFlags & 1) == 0) {
            return false;
        } else {
            if (f2 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                return false;
            }
        }
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.mActivePointerId = motionEvent.getPointerId(0);
        select(findSwipedView, 1);
        return true;
    }

    /* access modifiers changed from: package-private */
    public View findChildView(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (hitTest(view, x, y, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
                return view;
            }
        }
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            View view2 = recoverAnimation.mViewHolder.itemView;
            if (hitTest(view2, x, y, recoverAnimation.mX, recoverAnimation.mY)) {
                return view2;
            }
        }
        return this.mRecyclerView.findChildViewUnder(x, y);
    }

    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        if (!this.mCallback.hasDragFlag(this.mRecyclerView, viewHolder)) {
            Log.e("ItemTouchHelper", "Start drag has been called but swiping is not enabled");
        } else if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            obtainVelocityTracker();
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            select(viewHolder, 2);
        }
    }

    public void startSwipe(RecyclerView.ViewHolder viewHolder) {
        if (!this.mCallback.hasSwipeFlag(this.mRecyclerView, viewHolder)) {
            Log.e("ItemTouchHelper", "Start swipe has been called but dragging is not enabled");
        } else if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        } else {
            obtainVelocityTracker();
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            select(viewHolder, 1);
        }
    }

    /* access modifiers changed from: package-private */
    public RecoverAnimation findAnimation(MotionEvent motionEvent) {
        if (this.mRecoverAnimations.isEmpty()) {
            return null;
        }
        View findChildView = findChildView(motionEvent);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder.itemView == findChildView) {
                return recoverAnimation;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* access modifiers changed from: package-private */
    public void updateDxDy(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        this.mDx = x - this.mInitialTouchX;
        this.mDy = y - this.mInitialTouchY;
        if ((i & 4) == 0) {
            this.mDx = Math.max(0.0f, this.mDx);
        }
        if ((i & 8) == 0) {
            this.mDx = Math.min(0.0f, this.mDx);
        }
        if ((i & 1) == 0) {
            this.mDy = Math.max(0.0f, this.mDy);
        }
        if ((i & 2) == 0) {
            this.mDy = Math.min(0.0f, this.mDy);
        }
    }

    private int swipeIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (this.mActionState == 2) {
            return 0;
        }
        int movementFlags = this.mCallback.getMovementFlags(this.mRecyclerView, viewHolder);
        int convertToAbsoluteDirection = (this.mCallback.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 65280) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i = (movementFlags & 65280) >> 8;
        if (Math.abs(this.mDx) > Math.abs(this.mDy)) {
            int checkHorizontalSwipe = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkHorizontalSwipe > 0) {
                return (i & checkHorizontalSwipe) == 0 ? Callback.convertToRelativeDirection(checkHorizontalSwipe, ViewCompat.getLayoutDirection(this.mRecyclerView)) : checkHorizontalSwipe;
            }
            int checkVerticalSwipe = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkVerticalSwipe > 0) {
                return checkVerticalSwipe;
            }
        } else {
            int checkVerticalSwipe2 = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkVerticalSwipe2 > 0) {
                return checkVerticalSwipe2;
            }
            int checkHorizontalSwipe2 = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkHorizontalSwipe2 > 0) {
                return (i & checkHorizontalSwipe2) == 0 ? Callback.convertToRelativeDirection(checkHorizontalSwipe2, ViewCompat.getLayoutDirection(this.mRecyclerView)) : checkHorizontalSwipe2;
            }
        }
        return 0;
    }

    private int checkHorizontalSwipe(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = 8;
        int i3 = this.mDx > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null && this.mActivePointerId >= 0) {
            velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            float xVelocity = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
            float yVelocity = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
            if (xVelocity <= 0.0f) {
                i2 = 4;
            }
            float abs = Math.abs(xVelocity);
            if ((i2 & i) != 0 && i3 == i2 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(yVelocity)) {
                return i2;
            }
        }
        float width = ((float) this.mRecyclerView.getWidth()) * this.mCallback.getSwipeThreshold(viewHolder);
        if ((i & i3) == 0 || Math.abs(this.mDx) <= width) {
            return 0;
        }
        return i3;
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = 2;
        int i3 = this.mDy > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null && this.mActivePointerId >= 0) {
            velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            float xVelocity = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
            float yVelocity = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
            if (yVelocity <= 0.0f) {
                i2 = 1;
            }
            float abs = Math.abs(yVelocity);
            if ((i2 & i) != 0 && i2 == i3 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(xVelocity)) {
                return i2;
            }
        }
        float height = ((float) this.mRecyclerView.getHeight()) * this.mCallback.getSwipeThreshold(viewHolder);
        if ((i & i3) == 0 || Math.abs(this.mDy) <= height) {
            return 0;
        }
        return i3;
    }

    private void addChildDrawingOrderCallback() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.mChildDrawingOrderCallback == null) {
                this.mChildDrawingOrderCallback = new RecyclerView.ChildDrawingOrderCallback() {
                    /* class android.support.v7.widget.helper.ItemTouchHelper.AnonymousClass5 */

                    public int onGetChildDrawingOrder(int i, int i2) {
                        if (ItemTouchHelper.this.mOverdrawChild == null) {
                            return i2;
                        }
                        int i3 = ItemTouchHelper.this.mOverdrawChildPosition;
                        if (i3 == -1) {
                            i3 = ItemTouchHelper.this.mRecyclerView.indexOfChild(ItemTouchHelper.this.mOverdrawChild);
                            ItemTouchHelper.this.mOverdrawChildPosition = i3;
                        }
                        if (i2 == i - 1) {
                            return i3;
                        }
                        return i2 < i3 ? i2 : i2 + 1;
                    }
                };
            }
            this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeChildDrawingOrderCallbackIfNecessary(View view) {
        if (view == this.mOverdrawChild) {
            this.mOverdrawChild = null;
            if (this.mChildDrawingOrderCallback != null) {
                this.mRecyclerView.setChildDrawingOrderCallback(null);
            }
        }
    }

    public static abstract class Callback {
        private static final Interpolator sDragScrollInterpolator = new Interpolator() {
            /* class android.support.v7.widget.helper.ItemTouchHelper.Callback.AnonymousClass1 */

            public final float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        };
        private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator() {
            /* class android.support.v7.widget.helper.ItemTouchHelper.Callback.AnonymousClass2 */

            public final float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
        private static final ItemTouchUIUtil sUICallback;
        private int mCachedMaxScrollSpeed = -1;

        public static int convertToRelativeDirection(int i, int i2) {
            int i3;
            int i4 = i & 789516;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ -1);
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= -789517 & i6;
                i3 = (i6 & 789516) << 2;
            }
            return i5 | i3;
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3;
            int i4 = i & 3158064;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ -1);
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= -3158065 & i6;
                i3 = (i6 & 3158064) >> 2;
            }
            return i5 | i3;
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int i);

        static {
            if (Build.VERSION.SDK_INT >= 21) {
                sUICallback = new ItemTouchUIUtilImpl.Lollipop();
            } else if (Build.VERSION.SDK_INT >= 11) {
                sUICallback = new ItemTouchUIUtilImpl.Honeycomb();
            } else {
                sUICallback = new ItemTouchUIUtilImpl.Gingerbread();
            }
        }

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return sUICallback;
        }

        public static int makeMovementFlags(int i, int i2) {
            int makeFlag = makeFlag(0, i2 | i);
            return makeFlag(2, i) | makeFlag(1, i2) | makeFlag;
        }

        /* access modifiers changed from: package-private */
        public final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        /* access modifiers changed from: package-private */
        public boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & 16711680) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & 65280) != 0;
        }

        public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int i, int i2) {
            int i3;
            int bottom;
            int top;
            int abs;
            int left;
            int abs2;
            int right;
            RecyclerView.ViewHolder viewHolder2 = viewHolder;
            int width = i + viewHolder2.itemView.getWidth();
            int height = i2 + viewHolder2.itemView.getHeight();
            int left2 = i - viewHolder2.itemView.getLeft();
            int top2 = i2 - viewHolder2.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder3 = null;
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.ViewHolder viewHolder4 = list.get(i5);
                if (left2 <= 0 || (right = viewHolder4.itemView.getRight() - width) >= 0 || viewHolder4.itemView.getRight() <= viewHolder2.itemView.getRight() || (i3 = Math.abs(right)) <= i4) {
                    i3 = i4;
                } else {
                    viewHolder3 = viewHolder4;
                }
                if (left2 < 0 && (left = viewHolder4.itemView.getLeft() - i) > 0 && viewHolder4.itemView.getLeft() < viewHolder2.itemView.getLeft() && (abs2 = Math.abs(left)) > i3) {
                    i3 = abs2;
                    viewHolder3 = viewHolder4;
                }
                if (top2 < 0 && (top = viewHolder4.itemView.getTop() - i2) > 0 && viewHolder4.itemView.getTop() < viewHolder2.itemView.getTop() && (abs = Math.abs(top)) > i3) {
                    i3 = abs;
                    viewHolder3 = viewHolder4;
                }
                if (top2 <= 0 || (bottom = viewHolder4.itemView.getBottom() - height) >= 0 || viewHolder4.itemView.getBottom() <= viewHolder2.itemView.getBottom() || (i4 = Math.abs(bottom)) <= i3) {
                    i4 = i3;
                } else {
                    viewHolder3 = viewHolder4;
                }
            }
            return viewHolder3;
        }

        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
                sUICallback.onSelected(viewHolder.itemView);
            }
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                recoverAnimation.update();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
        }

        /* access modifiers changed from: package-private */
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            List<RecoverAnimation> list2 = list;
            int size = list.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list2.get(i2);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
            for (int i3 = size - 1; i3 >= 0; i3--) {
                RecoverAnimation recoverAnimation2 = list2.get(i3);
                if (recoverAnimation2.mEnded && !recoverAnimation2.mIsPendingCleanup) {
                    list2.remove(i3);
                } else if (!recoverAnimation2.mEnded) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            sUICallback.clearView(viewHolder.itemView);
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            sUICallback.onDraw(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            sUICallback.onDrawOver(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200 : 250;
            }
            if (i == 8) {
                return itemAnimator.getMoveDuration();
            }
            return itemAnimator.getRemoveDuration();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.min(float, float):float}
         arg types: [int, float]
         candidates:
          ClspMth{java.lang.Math.min(double, double):double}
          ClspMth{java.lang.Math.min(long, long):long}
          ClspMth{java.lang.Math.min(int, int):int}
          ClspMth{java.lang.Math.min(float, float):float} */
        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            float f = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i2)) * getMaxDragScroll(recyclerView))) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= 2000) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (((float) signum) * sDragScrollInterpolator.getInterpolation(f));
            if (interpolation == 0) {
                return i2 > 0 ? 1 : -1;
            }
            return interpolation;
        }
    }

    public static abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int i, int i2) {
            this.mDefaultSwipeDirs = i2;
            this.mDefaultDragDirs = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.mDefaultSwipeDirs = i;
        }

        public void setDefaultDragDirs(int i) {
            this.mDefaultDragDirs = i;
        }

        public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultSwipeDirs;
        }

        public int getDragDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultDragDirs;
        }

        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }
    }

    class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        ItemTouchHelperGestureListener() {
        }

        public void onLongPress(MotionEvent motionEvent) {
            RecyclerView.ViewHolder childViewHolder;
            View findChildView = ItemTouchHelper.this.findChildView(motionEvent);
            if (findChildView != null && (childViewHolder = ItemTouchHelper.this.mRecyclerView.getChildViewHolder(findChildView)) != null && ItemTouchHelper.this.mCallback.hasDragFlag(ItemTouchHelper.this.mRecyclerView, childViewHolder) && motionEvent.getPointerId(0) == ItemTouchHelper.this.mActivePointerId) {
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                float x = motionEvent.getX(findPointerIndex);
                float y = motionEvent.getY(findPointerIndex);
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                itemTouchHelper.mInitialTouchX = x;
                itemTouchHelper.mInitialTouchY = y;
                itemTouchHelper.mDy = 0.0f;
                itemTouchHelper.mDx = 0.0f;
                if (itemTouchHelper.mCallback.isLongPressDragEnabled()) {
                    ItemTouchHelper.this.select(childViewHolder, 2);
                }
            }
        }
    }

    class RecoverAnimation implements AnimatorListenerCompat {
        final int mActionState;
        final int mAnimationType;
        boolean mEnded = false;
        private float mFraction;
        public boolean mIsPendingCleanup;
        boolean mOverridden = false;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;
        private final ValueAnimatorCompat mValueAnimator;
        final RecyclerView.ViewHolder mViewHolder;
        float mX;
        float mY;

        public void onAnimationRepeat(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4) {
            this.mActionState = i2;
            this.mAnimationType = i;
            this.mViewHolder = viewHolder;
            this.mStartDx = f;
            this.mStartDy = f2;
            this.mTargetX = f3;
            this.mTargetY = f4;
            this.mValueAnimator = AnimatorCompatHelper.emptyValueAnimator();
            this.mValueAnimator.addUpdateListener(new AnimatorUpdateListenerCompat(ItemTouchHelper.this) {
                /* class android.support.v7.widget.helper.ItemTouchHelper.RecoverAnimation.AnonymousClass1 */

                public void onAnimationUpdate(ValueAnimatorCompat valueAnimatorCompat) {
                    RecoverAnimation.this.setFraction(valueAnimatorCompat.getAnimatedFraction());
                }
            });
            this.mValueAnimator.setTarget(viewHolder.itemView);
            this.mValueAnimator.addListener(this);
            setFraction(0.0f);
        }

        public void setDuration(long j) {
            this.mValueAnimator.setDuration(j);
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }

        public void update() {
            float f = this.mStartDx;
            float f2 = this.mTargetX;
            if (f == f2) {
                this.mX = ViewCompat.getTranslationX(this.mViewHolder.itemView);
            } else {
                this.mX = f + (this.mFraction * (f2 - f));
            }
            float f3 = this.mStartDy;
            float f4 = this.mTargetY;
            if (f3 == f4) {
                this.mY = ViewCompat.getTranslationY(this.mViewHolder.itemView);
            } else {
                this.mY = f3 + (this.mFraction * (f4 - f3));
            }
        }

        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
            if (!this.mEnded) {
                this.mViewHolder.setIsRecyclable(true);
            }
            this.mEnded = true;
        }

        public void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat) {
            setFraction(1.0f);
        }
    }
}
