package com.xiaomi.smarthome.camera.activity.timelapse;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public abstract class CustomBaseDialog extends Dialog {
    protected boolean mCancel;
    protected Context mContext;
    protected DisplayMetrics mDisplayMetrics;
    private boolean mIsPopupStyle;
    protected LinearLayout mLlControlHeight;
    protected LinearLayout mLlTop;
    protected float mMaxHeight;
    protected View mOnCreateView;
    protected int mOnCreateViewLayoutGravity = 17;
    protected AnimationSet mShowAnim;

    public abstract View onCreateView();

    public CustomBaseDialog(Context context, int i) {
        super(context);
        init(context);
        this.mOnCreateViewLayoutGravity = i;
    }

    public CustomBaseDialog(Context context, int i, int i2) {
        super(context, i);
        init(context);
        this.mOnCreateViewLayoutGravity = i2;
    }

    public CustomBaseDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener, int i) {
        super(context, z, onCancelListener);
        init(context, z);
        this.mOnCreateViewLayoutGravity = i;
    }

    private void init(Context context) {
        this.mContext = context;
        setDialogTheme();
    }

    private void init(Context context, boolean z) {
        this.mContext = context;
        setDialogTheme();
        this.mCancel = z;
    }

    private void setDialogTheme() {
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.mMaxHeight = (float) (this.mDisplayMetrics.heightPixels - getHeight(this.mContext));
        this.mLlTop = new LinearLayout(this.mContext);
        this.mLlTop.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mLlTop.setGravity(17);
        this.mLlControlHeight = new LinearLayout(this.mContext);
        this.mLlControlHeight.setOrientation(1);
        this.mOnCreateView = onCreateView();
        this.mLlControlHeight.addView(this.mOnCreateView);
        this.mLlTop.addView(this.mLlControlHeight);
        setContentView(this.mLlTop, new ViewGroup.LayoutParams(this.mDisplayMetrics.widthPixels, -1));
        this.mLlTop.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.CustomBaseDialog.AnonymousClass1 */

            public void onClick(View view) {
                if (CustomBaseDialog.this.mCancel) {
                    CustomBaseDialog.this.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mLlTop.setGravity(this.mOnCreateViewLayoutGravity);
        getWindow().setGravity(this.mOnCreateViewLayoutGravity);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        showByAnim(R.anim.alpha_in);
    }

    /* access modifiers changed from: protected */
    public void showByAnim(int i) {
        this.mShowAnim = new AnimationSet(true);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, i);
        loadAnimation.setDuration(200);
        this.mShowAnim.addAnimation(loadAnimation);
        this.mShowAnim.setDuration(200);
        this.mOnCreateView.setAnimation(this.mShowAnim);
        this.mShowAnim.start();
    }

    public static int getHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        return isFlymeOs4x() ? dimensionPixelSize * 2 : dimensionPixelSize;
    }

    public static boolean isFlymeOs4x() {
        if (!"4.4.4".equals(Build.VERSION.RELEASE)) {
            return false;
        }
        String str = Build.VERSION.INCREMENTAL;
        String str2 = Build.DISPLAY;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("Flyme_OS_4");
        }
        return str2.contains("Flyme OS 4");
    }

    public void dismiss() {
        dismissByAnim(R.anim.alpha_out);
    }

    /* access modifiers changed from: protected */
    public void dismissByAnim(int i) {
        this.mOnCreateView.clearAnimation();
        this.mShowAnim = new AnimationSet(true);
        this.mShowAnim.addAnimation(AnimationUtils.loadAnimation(this.mContext, i));
        this.mShowAnim.setDuration(200);
        this.mOnCreateView.setAnimation(this.mShowAnim);
        this.mShowAnim.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.camera.activity.timelapse.CustomBaseDialog.AnonymousClass2 */

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                CustomBaseDialog.super.dismiss();
            }
        });
        this.mShowAnim.start();
    }

    public void setTextById(int i, String str) {
        View findViewById = this.mOnCreateView.findViewById(i);
        if (findViewById instanceof TextView) {
            ((TextView) findViewById).setText(str);
        }
    }

    public void setClickListenerById(int i, View.OnClickListener onClickListener) {
        this.mOnCreateView.findViewById(i).setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: protected */
    public void superOnAttachedOnWindow() {
        super.onAttachedToWindow();
    }
}
