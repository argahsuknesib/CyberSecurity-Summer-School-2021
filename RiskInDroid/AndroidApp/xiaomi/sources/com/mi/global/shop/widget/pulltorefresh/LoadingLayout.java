package com.mi.global.shop.widget.pulltorefresh;

import _m_j.cbq;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.util.SkinUtil;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public abstract class LoadingLayout extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    static final Interpolator f5040O000000o = new LinearInterpolator();
    ViewGroup O00000Oo;
    protected final ProgressBar O00000o;
    protected final ImageView O00000o0;
    final CustomTextView O00000oO;
    CharSequence O00000oo;
    CharSequence O0000O0o;
    private boolean O0000OOo;
    private ImageView O0000Oo;
    private final CustomTextView O0000Oo0;
    private CharSequence O0000OoO;
    private CharSequence O0000Ooo;
    private boolean O0000o;
    private SimpleDraweeView O0000o0;
    private SimpleDraweeView O0000o00;
    private DraweeController O0000o0O;
    private Animatable O0000o0o;

    /* access modifiers changed from: protected */
    public abstract void O000000o();

    /* access modifiers changed from: protected */
    public abstract void O00000Oo();

    /* access modifiers changed from: protected */
    public abstract int getDefaultDrawableResId();

    public LoadingLayout(Context context, boolean z) {
        super(context);
        this.O0000o = z;
        if (z) {
            LayoutInflater.from(context).inflate((int) R.layout.shop_pull_to_refresh_header_vertical_rn, this);
        } else {
            LayoutInflater.from(context).inflate((int) R.layout.shop_pull_to_refresh_header_vertical, this);
        }
        this.O00000oo = context.getString(R.string.cube_ptr_pull_down);
        this.O0000OoO = context.getString(R.string.cube_ptr_refreshing);
        this.O0000O0o = context.getString(R.string.cube_ptr_release_to_refresh);
        this.O0000Ooo = context.getString(R.string.cube_ptr_refresh_complete);
        this.O00000Oo = (ViewGroup) findViewById(R.id.fl_inner);
        this.O00000oO = (CustomTextView) this.O00000Oo.findViewById(R.id.pull_to_refresh_text);
        this.O00000o = (ProgressBar) this.O00000Oo.findViewById(R.id.pull_to_refresh_progress);
        this.O0000Oo0 = (CustomTextView) this.O00000Oo.findViewById(R.id.pull_to_refresh_sub_text);
        this.O00000o0 = (ImageView) this.O00000Oo.findViewById(R.id.pull_to_refresh_image);
        if (!z) {
            this.O0000Oo = (ImageView) this.O00000Oo.findViewById(R.id.pull_to_refresh_dancing_ellipsis);
        }
        ((FrameLayout.LayoutParams) this.O00000Oo.getLayoutParams()).gravity = 80;
        setLoadingDrawable(context.getResources().getDrawable(getDefaultDrawableResId()));
        O00000o();
    }

    public LoadingLayout(Context context) {
        super(context);
        LayoutInflater.from(context).inflate((int) R.layout.shop_pull_to_refresh_header_vertical_festivalstyle, this);
        this.O0000o00 = (SimpleDraweeView) findViewById(R.id.gif_bg);
        this.O0000o0 = (SimpleDraweeView) findViewById(R.id.pull_bg);
        this.O0000o0O = ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(SkinUtil.O000000o("KEY_FESTIVAL_PULL_GIF_ITEM")).setAutoPlayAnimations(true)).build();
        this.O0000o00.setController(this.O0000o0O);
        this.O0000o00.setVisibility(8);
        this.O0000o0o = this.O0000o0O.getAnimatable();
        this.O00000Oo = (ViewGroup) findViewById(R.id.fl_inner);
        if (SkinUtil.O000000o("KEY_FESTIVAL_PULL_BG") != null) {
            cbq.O000000o(SkinUtil.O000000o("KEY_FESTIVAL_PULL_BG"), this.O0000o0);
        }
        this.O00000oO = (CustomTextView) this.O00000Oo.findViewById(R.id.pull_to_refresh_text);
        this.O00000o = (ProgressBar) this.O00000Oo.findViewById(R.id.pull_to_refresh_progress);
        this.O0000Oo0 = (CustomTextView) this.O00000Oo.findViewById(R.id.pull_to_refresh_sub_text);
        this.O00000o0 = (ImageView) this.O00000Oo.findViewById(R.id.pull_to_refresh_image);
        if (!this.O0000o) {
            this.O0000Oo = (ImageView) this.O00000Oo.findViewById(R.id.pull_to_refresh_dancing_ellipsis);
        }
        ((FrameLayout.LayoutParams) this.O00000Oo.getLayoutParams()).gravity = 80;
        setLoadingDrawable(context.getResources().getDrawable(getDefaultDrawableResId()));
        O00000o();
    }

    public final void setHeight(int i) {
        getLayoutParams().height = i;
        requestLayout();
    }

    public final void setWidth(int i) {
        getLayoutParams().width = i;
        requestLayout();
    }

    public final int getContentSize() {
        return this.O00000Oo.getHeight();
    }

    public final void O00000o0() {
        CustomTextView customTextView = this.O00000oO;
        if (customTextView != null) {
            customTextView.setText(this.O0000OoO);
        }
        if (!this.O0000o) {
            ((AnimationDrawable) this.O0000Oo.getBackground()).start();
        }
        if (this.O0000OOo) {
            ((AnimationDrawable) this.O00000o0.getDrawable()).start();
        } else {
            O000000o();
        }
        CustomTextView customTextView2 = this.O0000Oo0;
        if (customTextView2 != null) {
            customTextView2.setVisibility(8);
        }
    }

    public final void O00000o() {
        CustomTextView customTextView = this.O00000oO;
        if (customTextView != null) {
            customTextView.setText(this.O0000Ooo);
        }
        this.O00000o0.setVisibility(0);
        if (!this.O0000o) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.O0000Oo.getBackground();
            animationDrawable.stop();
            animationDrawable.selectDrawable(0);
        }
        if (this.O0000OOo) {
            ((AnimationDrawable) this.O00000o0.getDrawable()).stop();
        } else {
            O00000Oo();
        }
        CustomTextView customTextView2 = this.O0000Oo0;
        if (customTextView2 == null) {
            return;
        }
        if (TextUtils.isEmpty(customTextView2.getText())) {
            this.O0000Oo0.setVisibility(8);
        } else {
            this.O0000Oo0.setVisibility(0);
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    public final void setLoadingDrawable(Drawable drawable) {
        this.O00000o0.setImageDrawable(drawable);
        this.O0000OOo = drawable instanceof AnimationDrawable;
    }

    public void setPullLabel(CharSequence charSequence) {
        this.O00000oo = charSequence;
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        this.O0000OoO = charSequence;
    }

    public void setReleaseLabel(CharSequence charSequence) {
        this.O0000O0o = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.O00000oO.setTypeface(typeface);
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.O0000Oo0 == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.O0000Oo0.setVisibility(8);
            return;
        }
        this.O0000Oo0.setText(charSequence);
        if (8 == this.O0000Oo0.getVisibility()) {
            this.O0000Oo0.setVisibility(0);
        }
    }

    private void setSubTextAppearance(int i) {
        CustomTextView customTextView = this.O0000Oo0;
        if (customTextView != null) {
            customTextView.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        CustomTextView customTextView = this.O0000Oo0;
        if (customTextView != null) {
            customTextView.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        CustomTextView customTextView = this.O00000oO;
        if (customTextView != null) {
            customTextView.setTextAppearance(getContext(), i);
        }
        CustomTextView customTextView2 = this.O0000Oo0;
        if (customTextView2 != null) {
            customTextView2.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        CustomTextView customTextView = this.O00000oO;
        if (customTextView != null) {
            customTextView.setTextColor(colorStateList);
        }
        CustomTextView customTextView2 = this.O0000Oo0;
        if (customTextView2 != null) {
            customTextView2.setTextColor(colorStateList);
        }
    }

    public Animatable getAnimatable() {
        return this.O0000o0o;
    }

    public void setAnimatable(Animatable animatable) {
        this.O0000o0o = animatable;
    }

    public SimpleDraweeView getGif_bg() {
        return this.O0000o00;
    }

    public void setGif_bg(SimpleDraweeView simpleDraweeView) {
        this.O0000o00 = simpleDraweeView;
    }

    public void setRn(boolean z) {
        this.O0000o = z;
    }
}
