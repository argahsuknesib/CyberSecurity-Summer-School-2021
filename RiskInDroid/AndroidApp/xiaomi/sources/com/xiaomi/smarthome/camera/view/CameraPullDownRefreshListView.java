package com.xiaomi.smarthome.camera.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;

public class CameraPullDownRefreshListView extends ListView {
    private final int FRAME_DURATION = 16;
    private final float MAXIMUM_VELOCITY = 1.5f;
    private boolean isDown = false;
    private Animation mAnimRotate;
    private Animation mAnimRotateBack;
    private boolean mCanPullDown = true;
    private boolean mCanRefresh = false;
    private View mContainer = null;
    private int mCurOffsetY = 0;
    private BuncingHandler mHandler = new BuncingHandler(this);
    private View mHeader = null;
    private OnInterceptListener mInterceptListener;
    private boolean mIsRefreshing = false;
    public boolean mLastItemVisible = false;
    private int mMaxHeaderHeight = Integer.MAX_VALUE;
    private float mMaximumVelocity;
    public OnLastItemVisibleListener mOnLastItemVisibleListener = null;
    private int mOriHeight = 0;
    private boolean mPullDownEnabled = true;
    private CharSequence mPullDownToRefreshText;
    private OnRefreshListener mRefreshListener;
    private CharSequence mReleaseText;
    private boolean mShowRefreshProgress = true;
    private float mStartY = 0.0f;
    private int mTriggerRefreshThreshold;

    public interface OnInterceptListener {
        boolean needInterceptAnimation();

        void onInterceptAnimation();
    }

    public interface OnLastItemVisibleListener {
        void onLastItemVisible();
    }

    public interface OnRefreshListener {
        void startRefresh();
    }

    public CameraPullDownRefreshListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public CameraPullDownRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CameraPullDownRefreshListView(Context context) {
        super(context);
        init();
    }

    public void setOnLastItemVisibleListener(OnLastItemVisibleListener onLastItemVisibleListener) {
        this.mOnLastItemVisibleListener = onLastItemVisibleListener;
    }

    public void setRefreshListener(OnRefreshListener onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
    }

    public void setInterceptListener(OnInterceptListener onInterceptListener) {
        this.mInterceptListener = onInterceptListener;
    }

    public void setShowRefreshProgress(boolean z) {
        this.mShowRefreshProgress = z;
    }

    public boolean isRefreshing() {
        return this.mIsRefreshing;
    }

    public void doRefresh() {
        if (!this.mIsRefreshing && this.mRefreshListener != null) {
            preRefresh();
            this.mRefreshListener.startRefresh();
        }
    }

    private void preRefresh() {
        this.mIsRefreshing = true;
        ((TextView) findViewById(R.id.pull_header_txt)).setText((int) R.string.refreshing);
        if (this.mShowRefreshProgress) {
            findViewById(R.id.pull_header_prog).setVisibility(0);
        }
        View findViewById = findViewById(R.id.pull_header_indc);
        findViewById.clearAnimation();
        findViewById.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
        if (this.mCurOffsetY == 0) {
            this.mCurOffsetY = getContext().getResources().getDimensionPixelSize(R.dimen.pull_down_header_height);
        }
        layoutParams.height = this.mCurOffsetY + this.mOriHeight;
        this.mContainer.setLayoutParams(layoutParams);
    }

    public void setProgressDrawable(Drawable drawable) {
        ((ProgressBar) findViewById(R.id.pull_header_prog)).setIndeterminateDrawable(drawable);
    }

    public void postRefresh() {
        this.mIsRefreshing = false;
        ((TextView) findViewById(R.id.pull_header_txt)).setText(this.mPullDownToRefreshText);
        findViewById(R.id.pull_header_prog).setVisibility(8);
        View findViewById = findViewById(R.id.pull_header_indc);
        findViewById.clearAnimation();
        findViewById.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
        layoutParams.height = this.mOriHeight + this.mCurOffsetY;
        this.mContainer.setLayoutParams(layoutParams);
        this.mHandler.sendEmptyMessageDelayed(0, 16);
    }

    public void setOriHeight(int i) {
        this.mOriHeight = i;
        findViewById(R.id.pull_header).getLayoutParams().height = this.mOriHeight;
        this.mHeader.findViewById(R.id.empty_view).getLayoutParams().height = this.mOriHeight;
    }

    public void setPullDownEnabled(boolean z) {
        this.mPullDownEnabled = z;
    }

    public void setPullDownHeaderVisibility(int i) {
        findViewById(R.id.pull_header_container).setVisibility(i);
    }

    public void setPullDownTextColor(int i) {
        ((TextView) findViewById(R.id.pull_header_txt)).setTextColor(i);
    }

    public void setPullDownTextSize(int i) {
        ((TextView) findViewById(R.id.pull_header_txt)).setTextSize((float) i);
    }

    public void setPullDownText(CharSequence charSequence, CharSequence charSequence2) {
        this.mPullDownToRefreshText = charSequence;
        ((TextView) findViewById(R.id.pull_header_txt)).setText(this.mPullDownToRefreshText);
        this.mReleaseText = charSequence2;
    }

    public void setPullDownTextColorLine2(int i) {
        ((TextView) findViewById(R.id.pull_header_txt_line2)).setTextColor(i);
    }

    public void setPullDownLine2Text(CharSequence charSequence) {
        TextView textView = (TextView) findViewById(R.id.pull_header_txt_line2);
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(0);
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
    }

    public void setIndicatorDrawable(Drawable drawable) {
        ((ImageView) findViewById(R.id.pull_header_indc)).setImageDrawable(drawable);
    }

    public void setMaxPullDownFromRes(int i) {
        this.mMaxHeaderHeight = getResources().getDimensionPixelSize(i);
    }

    @SuppressLint({"NewApi"})
    private void init() {
        if (Build.VERSION.SDK_INT >= 14) {
            setOverScrollMode(2);
        }
        if (!isInEditMode()) {
            this.mMaximumVelocity = (getResources().getDisplayMetrics().density * 1.5f) + 0.5f;
            this.mPullDownToRefreshText = getContext().getString(R.string.pull_down_refresh);
            this.mReleaseText = getContext().getString(R.string.release_to_refresh);
            this.mTriggerRefreshThreshold = getResources().getDimensionPixelSize(R.dimen.pull_down_refresh_threshold);
            this.mHeader = LayoutInflater.from(getContext()).inflate((int) R.layout.sm_widget_pull_header, (ViewGroup) null);
            this.mContainer = this.mHeader.findViewById(R.id.pull_header);
            addHeaderView(this.mHeader);
            setOnScrollListener(new AbsListView.OnScrollListener() {
                /* class com.xiaomi.smarthome.camera.view.CameraPullDownRefreshListView.AnonymousClass1 */

                public void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i == 0 && CameraPullDownRefreshListView.this.mOnLastItemVisibleListener != null && CameraPullDownRefreshListView.this.mLastItemVisible) {
                        CameraPullDownRefreshListView.this.mOnLastItemVisibleListener.onLastItemVisible();
                    }
                }

                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (CameraPullDownRefreshListView.this.mOnLastItemVisibleListener != null) {
                        CameraPullDownRefreshListView cameraPullDownRefreshListView = CameraPullDownRefreshListView.this;
                        boolean z = true;
                        if (i3 <= 0 || i + i2 < i3 - 1) {
                            z = false;
                        }
                        cameraPullDownRefreshListView.mLastItemVisible = z;
                    }
                }
            });
        }
    }

    public void setCanPullDown(boolean z) {
        this.mCanPullDown = z;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanPullDown) {
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (ArrayIndexOutOfBoundsException | IndexOutOfBoundsException unused) {
                return false;
            }
        } else {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        boolean z = this.isDown;
                        if (z) {
                            TextView textView = (TextView) findViewById(R.id.pull_header_txt);
                            ImageView imageView = (ImageView) findViewById(R.id.pull_header_indc);
                            float y = motionEvent.getY();
                            if (y - this.mStartY > 10.0f) {
                                ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
                                this.mCurOffsetY = (int) ((y - this.mStartY) / 2.0f);
                                int i = this.mCurOffsetY;
                                int i2 = this.mOriHeight;
                                int i3 = i + i2;
                                int i4 = this.mMaxHeaderHeight;
                                if (i3 < i4) {
                                    layoutParams.height = i + i2;
                                    this.mContainer.setLayoutParams(layoutParams);
                                    if (this.mCurOffsetY >= this.mTriggerRefreshThreshold) {
                                        if (!this.mCanRefresh) {
                                            if (textView != null) {
                                                textView.setText(this.mReleaseText);
                                            }
                                            if (this.mAnimRotate == null) {
                                                this.mAnimRotate = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_180);
                                                this.mAnimRotate.setFillAfter(true);
                                            }
                                            if (imageView != null) {
                                                imageView.startAnimation(this.mAnimRotate);
                                            }
                                            this.mCanRefresh = true;
                                        }
                                    } else if (this.mCanRefresh) {
                                        if (textView != null) {
                                            textView.setText(this.mPullDownToRefreshText);
                                        }
                                        if (this.mAnimRotateBack == null) {
                                            this.mAnimRotateBack = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_back_180);
                                            this.mAnimRotateBack.setFillAfter(true);
                                        }
                                        if (imageView != null) {
                                            imageView.startAnimation(this.mAnimRotateBack);
                                        }
                                        this.mCanRefresh = false;
                                    }
                                } else {
                                    this.mCurOffsetY = Math.max(0, i4 - i2);
                                }
                                motionEvent.setAction(3);
                                try {
                                    super.dispatchTouchEvent(motionEvent);
                                    return true;
                                } catch (ArrayIndexOutOfBoundsException | IndexOutOfBoundsException unused2) {
                                    return false;
                                }
                            }
                        } else if (this.mPullDownEnabled && !z && !this.mIsRefreshing && getFirstVisiblePosition() <= 0 && this.mHeader.getTop() >= 0) {
                            this.isDown = true;
                            this.mStartY = motionEvent.getY();
                            this.mCanRefresh = false;
                        }
                    } else if (action == 3) {
                        onViewHide();
                    }
                } else if (this.isDown) {
                    OnInterceptListener onInterceptListener = this.mInterceptListener;
                    if (onInterceptListener == null || !onInterceptListener.needInterceptAnimation()) {
                        this.mHandler.sendEmptyMessage(0);
                        if (this.mCanRefresh) {
                            doRefresh();
                        }
                        this.isDown = false;
                    } else if (this.mCanRefresh) {
                        this.mInterceptListener.onInterceptAnimation();
                    } else {
                        this.mHandler.sendEmptyMessage(0);
                        this.isDown = false;
                    }
                }
            } else if (this.mPullDownEnabled) {
                this.mCanRefresh = false;
                if (!this.mIsRefreshing && getFirstVisiblePosition() <= 0) {
                    this.isDown = true;
                    this.mStartY = motionEvent.getY();
                }
            }
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (ArrayIndexOutOfBoundsException | IndexOutOfBoundsException unused3) {
                return false;
            }
        }
    }

    public void onViewHide() {
        if (this.isDown) {
            this.mHandler.sendEmptyMessage(0);
        }
        this.isDown = false;
    }

    public boolean getIsDown() {
        if ((this.mIsRefreshing || getFirstVisiblePosition() > 0 || this.mHeader.getTop() < 0) && !this.mIsRefreshing) {
            return false;
        }
        return true;
    }

    public void resume() {
        onViewHide();
        doRefresh();
    }

    public void doAnimation() {
        int i;
        ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
        if (this.mCurOffsetY >= 0) {
            this.mCurOffsetY = (int) (((float) this.mCurOffsetY) - ((this.mIsRefreshing ? this.mMaximumVelocity : this.mMaximumVelocity / 2.0f) * 16.0f));
            if (!this.mIsRefreshing || this.mCurOffsetY > (i = this.mTriggerRefreshThreshold)) {
                int i2 = this.mCurOffsetY;
                if (i2 <= 0) {
                    this.mCurOffsetY = 0;
                    layoutParams.height = this.mCurOffsetY + this.mOriHeight;
                    this.mContainer.setLayoutParams(layoutParams);
                    this.mHandler.removeMessages(0);
                    return;
                }
                layoutParams.height = i2 + this.mOriHeight;
                this.mContainer.setLayoutParams(layoutParams);
            } else {
                this.mCurOffsetY = i;
                layoutParams.height = this.mCurOffsetY + this.mOriHeight;
                this.mContainer.setLayoutParams(layoutParams);
                this.mHandler.removeMessages(0);
                return;
            }
        }
        this.mHandler.sendEmptyMessageDelayed(0, 16);
    }

    static final class BuncingHandler extends Handler {
        private WeakReference<CameraPullDownRefreshListView> mReference;

        public BuncingHandler(CameraPullDownRefreshListView cameraPullDownRefreshListView) {
            this.mReference = new WeakReference<>(cameraPullDownRefreshListView);
        }

        public final void handleMessage(Message message) {
            CameraPullDownRefreshListView cameraPullDownRefreshListView = this.mReference.get();
            if (cameraPullDownRefreshListView != null) {
                if (message.what == 0) {
                    cameraPullDownRefreshListView.doAnimation();
                }
                super.handleMessage(message);
            }
        }
    }
}
