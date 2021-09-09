package com.xiaomi.mico.common.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.mico.common.util.ImmersionUtil;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;
import rx.functions.Action1;

public class TitleBar extends FrameLayout {
    View divider;
    TextView leftButton;
    ImageView leftIcon;
    TextView rightButton;
    ImageView rightIcon;
    FrameLayout rootView;
    TextView tvTitle;

    public interface OnLeftButtonClickListener {
        void onLeftButtonClick();
    }

    public interface OnLeftIconClickListener {
        void onLeftIconClick();
    }

    public interface OnRightButtonClickListener {
        void onRightButtonClick();
    }

    public interface OnRightIconClickListener {
        void onRightIconClick();
    }

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public FrameLayout getRootView() {
        return this.rootView;
    }

    private void init(Context context, AttributeSet attributeSet) {
        int i;
        boolean z;
        int i2;
        String str;
        int i3;
        LayoutInflater.from(context).inflate((int) R.layout.widget_title_bar, this);
        this.tvTitle = (TextView) findViewById(R.id.title_bar_title);
        this.leftIcon = (ImageView) findViewById(R.id.title_bar_left_icon);
        this.rightIcon = (ImageView) findViewById(R.id.title_bar_right_icon);
        this.leftButton = (TextView) findViewById(R.id.title_bar_left_button);
        this.rightButton = (TextView) findViewById(R.id.title_bar_right_button);
        this.divider = findViewById(R.id.title_bar_divider);
        this.rootView = (FrameLayout) findViewById(R.id.title_bar_root);
        int color = getResources().getColor(R.color.mj_color_black_100_transparent);
        String str2 = null;
        int i4 = R.drawable.mj_color_white;
        boolean z2 = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.tb_bg, R.attr.tb_has_back, R.attr.tb_has_divider, R.attr.tb_left_icon, R.attr.tb_right_button_text, R.attr.tb_right_button_text_color, R.attr.tb_right_icon, R.attr.tb_title, R.attr.tb_title_color});
            i4 = obtainStyledAttributes.getResourceId(0, R.drawable.mj_color_white);
            str2 = obtainStyledAttributes.getString(7);
            color = obtainStyledAttributes.getColor(8, color);
            z2 = obtainStyledAttributes.getBoolean(1, true);
            i = obtainStyledAttributes.getResourceId(3, -1);
            i3 = obtainStyledAttributes.getResourceId(6, -1);
            str = obtainStyledAttributes.getString(4);
            i2 = obtainStyledAttributes.getColor(5, color);
            z = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
        } else {
            i2 = color;
            str = null;
            i = -1;
            i3 = -1;
            z = false;
        }
        setBackgroundResource(i4);
        setTitle(str2);
        this.tvTitle.setTextColor(color);
        if (z2 && i == -1) {
            i = R.drawable.mj_common_title_bar_return;
        }
        if (i != -1) {
            setLeftIcon(i);
        } else {
            showLeftIcon(false);
        }
        if (i3 != -1) {
            setRightIcon(i3);
        } else {
            showRightIcon(false);
        }
        if (!TextUtils.isEmpty(str)) {
            setRightButtonText(str);
        } else {
            showRightButton(false);
        }
        this.rightButton.setTextColor(i2);
        if (z) {
            this.divider.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (!isInEditMode()) {
            ImmersionUtil.setImmersivePaddingIfNeeded((Activity) getContext(), this);
        }
    }

    public TitleBar setTitle(CharSequence charSequence) {
        this.tvTitle.setText(charSequence);
        return this;
    }

    public TitleBar setTitle(int i) {
        this.tvTitle.setText(i);
        return this;
    }

    public TitleBar setTitleVisibility(boolean z) {
        if (z) {
            this.tvTitle.setVisibility(0);
        } else {
            this.tvTitle.setVisibility(4);
        }
        return this;
    }

    public void setTitleMarquee() {
        TextView textView = this.tvTitle;
        if (textView != null) {
            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            this.tvTitle.setSingleLine(true);
            this.tvTitle.setSelected(true);
            this.tvTitle.setFocusable(true);
            this.tvTitle.setFocusableInTouchMode(true);
        }
    }

    public TextView getTitleView() {
        return this.tvTitle;
    }

    public void showLeftIcon(boolean z) {
        this.leftIcon.setVisibility(z ? 0 : 8);
    }

    public void setLeftIcon(int i) {
        showLeftIcon(true);
        this.leftIcon.setImageResource(i);
    }

    public void showRightIcon(boolean z) {
        this.rightIcon.setVisibility(z ? 0 : 8);
    }

    public TitleBar setRightIcon(int i) {
        showRightIcon(true);
        this.rightIcon.setImageResource(i);
        return this;
    }

    public void showRightButton(boolean z) {
        this.rightButton.setVisibility(z ? 0 : 8);
    }

    public void showLeftButton(boolean z) {
        if (this.leftButton.getText().toString().length() > 0) {
            this.leftButton.setVisibility(z ? 0 : 8);
        }
    }

    public TextView getRightButton() {
        return this.rightButton;
    }

    public TextView getLeftButton() {
        return this.leftButton;
    }

    public void setLeftButtonText(CharSequence charSequence) {
        showLeftButton(true);
        this.leftButton.setText(charSequence);
    }

    public TitleBar setRightButtonText(CharSequence charSequence) {
        showRightButton(true);
        this.rightButton.setText(charSequence);
        return this;
    }

    public TitleBar setRightButtonTextColor(int i) {
        this.rightButton.setTextColor(getResources().getColor(i));
        return this;
    }

    public void setTitleTextColorBlack() {
        this.tvTitle.setTextColor(getResources().getColor(R.color.mj_color_black));
    }

    public TitleBar enableRightButton(boolean z) {
        this.rightButton.setEnabled(z);
        return this;
    }

    public TitleBar setOnLeftIconClickListener(OnLeftIconClickListener onLeftIconClickListener) {
        RxUtil.debounceClick(this.leftIcon, new Action1() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$TitleBar$o_3gKwEvNcFn0gzxIlMx5ucAGQs */

            public final void call(Object obj) {
                TitleBar.OnLeftIconClickListener.this.onLeftIconClick();
            }
        });
        return this;
    }

    public ImageView getRightIcon() {
        return this.rightIcon;
    }

    public ImageView getLeftIcon() {
        return this.leftIcon;
    }

    public TitleBar setOnRightIconClickListener(OnRightIconClickListener onRightIconClickListener) {
        RxUtil.debounceClick(this.rightIcon, new Action1() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$TitleBar$hUDyduCvPSWoLR0JTIbR3E6z1U */

            public final void call(Object obj) {
                TitleBar.OnRightIconClickListener.this.onRightIconClick();
            }
        });
        return this;
    }

    public TitleBar setOnRightButtonClickListener(OnRightButtonClickListener onRightButtonClickListener) {
        RxUtil.debounceClick(this.rightButton, new Action1() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$TitleBar$kUvKy4TfhzTi9M65lF_flJyvWs */

            public final void call(Object obj) {
                TitleBar.OnRightButtonClickListener.this.onRightButtonClick();
            }
        });
        return this;
    }

    public void setOnLeftButtonClickListener(OnLeftButtonClickListener onLeftButtonClickListener) {
        RxUtil.debounceClick(this.leftButton, new Action1() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$TitleBar$n6Gd3QA4xM24Nyc65s9KLFBO_EQ */

            public final void call(Object obj) {
                TitleBar.OnLeftButtonClickListener.this.onLeftButtonClick();
            }
        });
    }

    public View getDivider() {
        return this.divider;
    }

    public void setTitleViewMainStyle() {
        this.tvTitle.setTextSize(17.0f);
        this.tvTitle.setTypeface(Typeface.defaultFromStyle(1));
        this.divider.setVisibility(0);
    }

    public void setTitleBold() {
        this.tvTitle.setTextSize(17.0f);
        this.tvTitle.setTypeface(Typeface.defaultFromStyle(1));
    }

    public void showDivider() {
        this.divider.setVisibility(0);
    }
}
