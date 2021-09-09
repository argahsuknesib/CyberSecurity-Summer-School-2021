package com.xiaomi.mico.common.immersionmenu;

import _m_j.gku;
import _m_j.go;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.common.util.BitmapUtil;
import com.xiaomi.mico.common.util.KeyboardUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;

public class ImmersionPopupWindowV3 extends PopupWindow {
    private RecyclerView.O000000o mAdapter;
    private AnimationListener mAnimationListener = new AnimationListener();
    public View mContentView;
    public Context mContext;
    public LayoutAnimationController mFadeInAnimationController;
    public LayoutAnimationController mFadeOutAnimationController;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    public RangeRatio mRangeRatio;
    public FrameLayout mRootView;

    public ImmersionPopupWindowV3(Context context) {
        super(context);
        this.mContext = context;
        this.mFadeInAnimationController = AnimationUtils.loadLayoutAnimation(context, R.anim.mico_immersion_layout_fade_in);
        this.mFadeOutAnimationController = AnimationUtils.loadLayoutAnimation(context, R.anim.mico_immersion_layout_fade_out);
        setFocusable(true);
        setWindowLayoutMode(-1, -1);
        this.mRootView = new FrameLayout(context);
        this.mRootView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.immersionmenu.ImmersionPopupWindowV3.AnonymousClass1 */

            public void onClick(View view) {
                new Object[1][0] = "popupWindow dismiss.";
                ImmersionPopupWindowV3.this.dismiss();
            }
        });
        super.setContentView(this.mRootView);
    }

    public void setContentView(View view) {
        this.mContentView = view;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public void setAdapter(RecyclerView.O000000o o000000o) {
        this.mAdapter = o000000o;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.FrameLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void show(Activity activity, int i, int i2) {
        if (this.mContentView == null) {
            RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(activity).inflate((int) R.layout.mico_widget_immersion_recycler_view, (ViewGroup) this.mRootView, false);
            recyclerView.setLayoutAnimation(this.mFadeInAnimationController);
            recyclerView.setLayoutAnimationListener(this.mAnimationListener);
            this.mAnimationListener.setIsInAnimation(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(activity, 1, false));
            recyclerView.setItemAnimator(new go());
            recyclerView.setAdapter(this.mAdapter);
            this.mContentView = recyclerView;
        }
        if (!(this.mRootView.getChildCount() == 1 && this.mRootView.getChildAt(0) == this.mContentView)) {
            this.mRootView.removeAllViews();
            this.mRootView.addView(this.mContentView);
            ViewGroup.LayoutParams layoutParams = this.mContentView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = i;
        }
        KeyboardUtils.hideKeyboard(this.mContext, this.mContentView.getWindowToken());
        if (gku.O000000o(ServiceApplication.getAppContext())) {
            if (i2 == -1) {
                i2 = activity.getResources().getColor(17170444);
            }
            setBackgroundDrawable(new ColorDrawable(Color.argb(153, Color.red(i2), Color.green(i2), Color.blue(i2))));
        } else {
            setBackgroundDrawable(new ClipDrawable(getBlurBackground(activity, i2)));
        }
        showAtLocation(this.mContentView, 0, 0, 0);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    private Drawable getBlurBackground(Activity activity, int i) {
        if (i == -1) {
            i = activity.getResources().getColor(R.color.mj_color_gray_heavier);
        }
        ColorDrawable colorDrawable = new ColorDrawable(Color.argb(230, Color.red(i), Color.green(i), Color.blue(i)));
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            return colorDrawable;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Bitmap.Config.ARGB_8888);
            decorView.draw(new Canvas(createBitmap));
            Bitmap blur = BitmapUtil.blur(activity, createBitmap, 3, 25);
            Canvas canvas = new Canvas(blur);
            colorDrawable.setBounds(0, 0, blur.getWidth(), blur.getHeight());
            colorDrawable.draw(canvas);
            return new BitmapDrawable(activity.getResources(), blur);
        } catch (OutOfMemoryError unused) {
            return colorDrawable;
        }
    }

    public void dismiss() {
        superDismiss();
    }

    private void dismiss(boolean z) {
        if (z) {
            dismiss();
        } else {
            superDismiss();
        }
    }

    public void superDismiss() {
        super.dismiss();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public Animator getBackgroundAnimator(LayoutAnimationController layoutAnimationController, boolean z) {
        ObjectAnimator objectAnimator;
        long j;
        long j2 = 0;
        if (z) {
            this.mRangeRatio = new RangeRatio(getBackground());
            objectAnimator = ObjectAnimator.ofFloat(this.mRangeRatio, "ratio", 0.0f, 1.0f);
            objectAnimator.setInterpolator(new DecelerateInterpolator());
            j = layoutAnimationController.getAnimation().getDuration();
        } else {
            this.mRangeRatio = new RangeRatio(getBackground());
            objectAnimator = ObjectAnimator.ofFloat(this.mRangeRatio, "ratio", 1.0f, 0.0f);
            objectAnimator.setInterpolator(new AccelerateInterpolator());
            View view = this.mContentView;
            int i = 1;
            if (view instanceof ListView) {
                i = ((ListView) view).getAdapter().getCount() - 1;
            }
            long duration = layoutAnimationController.getAnimation().getDuration();
            j2 = Math.max(((long) (((float) layoutAnimationController.getAnimation().getDuration()) * ((layoutAnimationController.getDelay() * ((float) i)) + 1.0f))) - duration, 0L);
            j = duration;
        }
        objectAnimator.setDuration(j);
        objectAnimator.setStartDelay(j2);
        return objectAnimator;
    }

    static class RangeRatio {
        Drawable drawable;
        float ratio;

        private RangeRatio(Drawable drawable2) {
            this.drawable = drawable2;
        }

        @Keep
        public void setRatio(float f) {
            this.ratio = f;
            this.drawable.invalidateSelf();
        }
    }

    class ClipDrawable extends StateListDrawable {
        private Drawable footerBackground;

        private ClipDrawable(Drawable drawable) {
            this.footerBackground = ImmersionPopupWindowV3.this.mContext.getResources().getDrawable(R.drawable.mico_bg_immersion_fill);
            addState(new int[0], drawable);
        }

        public void draw(Canvas canvas) {
            float f = ImmersionPopupWindowV3.this.mRangeRatio != null ? ImmersionPopupWindowV3.this.mRangeRatio.ratio : 0.0f;
            canvas.save();
            int bottom = (int) (((float) (ImmersionPopupWindowV3.this.mContentView.getBottom() + ImmersionPopupWindowV3.this.mRootView.getTop())) * f);
            canvas.clipRect(ImmersionPopupWindowV3.this.mContentView.getLeft(), 0, ImmersionPopupWindowV3.this.mContentView.getRight(), bottom);
            super.draw(canvas);
            canvas.restore();
            Rect bounds = getBounds();
            this.footerBackground.setBounds(bounds.left, bottom, bounds.right, bounds.bottom);
            this.footerBackground.setAlpha((int) (f * 255.0f));
            this.footerBackground.draw(canvas);
        }
    }

    class AnimationListener implements Animation.AnimationListener {
        private Animator backgroundAnimator;
        private boolean inAnimation;

        public void onAnimationRepeat(Animation animation) {
        }

        private AnimationListener() {
        }

        public void setIsInAnimation(boolean z) {
            this.inAnimation = z;
        }

        public void onAnimationStart(Animation animation) {
            this.backgroundAnimator = ImmersionPopupWindowV3.this.getBackgroundAnimator(this.inAnimation ? ImmersionPopupWindowV3.this.mFadeInAnimationController : ImmersionPopupWindowV3.this.mFadeOutAnimationController, this.inAnimation);
            Animator animator = this.backgroundAnimator;
            if (animator != null) {
                animator.start();
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (ImmersionPopupWindowV3.this.mContentView instanceof ViewGroup) {
                ((ViewGroup) ImmersionPopupWindowV3.this.mContentView).setLayoutAnimation(null);
            }
            if (!this.inAnimation) {
                ImmersionPopupWindowV3.this.superDismiss();
            }
        }
    }
}
