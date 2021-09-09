package com.smarthome.connect.view;

import _m_j.gpc;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.smarthome.connect.view.BaseBindView;
import com.xiaomi.smarthome.R;

public class CommonBindView extends BaseBindView {

    /* renamed from: O000000o  reason: collision with root package name */
    public LayoutInflater f5632O000000o;
    public LinearLayout O00000Oo;
    private TextView O00000o;
    private LinearLayout O00000o0;
    private TextView O00000oO;

    public final void O000000o(int i) {
    }

    public final void O000000o(View.OnClickListener onClickListener) {
    }

    public final void O00000o() {
    }

    public final void O00000o0() {
    }

    public final void O00000oO() {
    }

    public final void O00000oo() {
    }

    public void setBindFailed(int i) {
    }

    public void setCurrentIndex(int i) {
    }

    public void setLeftBtnListener(View.OnClickListener onClickListener) {
    }

    public void setLeftRightBtnVisibility(int i) {
    }

    public void setProgress(int i) {
    }

    public void setRightBtnListener(View.OnClickListener onClickListener) {
    }

    public CommonBindView(Context context) {
        super(context);
        O0000O0o();
    }

    public CommonBindView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O0000O0o();
    }

    public CommonBindView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O0000O0o();
    }

    private void O0000O0o() {
        this.f5632O000000o = LayoutInflater.from(getContext());
        this.f5632O000000o.inflate((int) R.layout.miconnect_common_bind_layout, this);
        this.O00000Oo = (LinearLayout) findViewById(R.id.step_container);
        this.O00000o = (TextView) findViewById(R.id.connect_failed_tips);
        this.O00000oO = (TextView) findViewById(R.id.common_bottom_tv);
        this.O00000oO.setVisibility(8);
    }

    public final void O000000o() {
        this.O00000Oo.removeAllViews();
        this.O00000oO.setVisibility(8);
        this.O00000o.setVisibility(8);
    }

    public final void O00000Oo() {
        this.O00000oO.setVisibility(8);
        this.O00000o.setVisibility(8);
    }

    public void setConnectFailedTipsVisibility(int i) {
        this.O00000o.setVisibility(i);
    }

    public void setConnectFailedTipsText(String str) {
        this.O00000o.setText(str);
    }

    public void setConnectFailedTipsListener(View.OnClickListener onClickListener) {
        this.O00000o.setOnClickListener(onClickListener);
    }

    public void setCommonBtnVisibility(int i) {
        TextView textView = this.O00000oO;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    public void setCommonBtnText(String str) {
        TextView textView = this.O00000oO;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setCommonBtnListener(View.OnClickListener onClickListener) {
        this.O00000oO.setOnClickListener(onClickListener);
    }

    public final void O000000o(int i, int i2) {
        O000000o(getResources().getString(i), getResources().getString(i2));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.LinearLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o(String str, String str2) {
        this.O00000o0 = (LinearLayout) this.f5632O000000o.inflate((int) R.layout.miconnect_common_bind_step_item, (ViewGroup) this.O00000Oo, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = gpc.O000000o(23.0f);
        this.O00000o0.setLayoutParams(layoutParams);
        this.O00000Oo.addView(this.O00000o0);
        O000000o(BaseBindView.StepStatus.LOADING, str);
    }

    public int getStepIndex() {
        return this.O00000Oo.getChildCount();
    }

    public final void O000000o(BaseBindView.StepStatus stepStatus, CharSequence charSequence) {
        ClickableSpan[] clickableSpanArr;
        LinearLayout linearLayout = this.O00000o0;
        if (linearLayout != null) {
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.step_icon);
            TextView textView = (TextView) this.O00000o0.findViewById(R.id.step_title);
            if (imageView != null && textView != null) {
                if (!(!(charSequence instanceof SpannableString) || (clickableSpanArr = (ClickableSpan[]) ((SpannableString) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class)) == null || clickableSpanArr.length == 0)) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                textView.setText(charSequence);
                int i = AnonymousClass1.f5633O000000o[stepStatus.ordinal()];
                if (i == 1) {
                    imageView.setImageResource(R.drawable.mj_webp_widget_loading);
                    Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.miconnect_rotate_infinite);
                    loadAnimation.setDuration(1000);
                    imageView.startAnimation(loadAnimation);
                    textView.setTextColor(getResources().getColor(R.color.mj_color_black));
                } else if (i == 2) {
                    imageView.clearAnimation();
                    imageView.setImageResource(R.drawable.miconnect_common_bind_success_icon);
                    textView.setTextColor(getResources().getColor(R.color.mj_color_gray_normal));
                } else if (i == 3) {
                    imageView.clearAnimation();
                    imageView.setImageResource(R.drawable.miconnect_common_bind_failed_icon);
                    textView.setTextColor(getResources().getColor(R.color.mj_color_gray_normal));
                }
            }
        }
    }

    /* renamed from: com.smarthome.connect.view.CommonBindView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5633O000000o = new int[BaseBindView.StepStatus.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f5633O000000o[BaseBindView.StepStatus.LOADING.ordinal()] = 1;
            f5633O000000o[BaseBindView.StepStatus.SUCCESS.ordinal()] = 2;
            try {
                f5633O000000o[BaseBindView.StepStatus.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void O000000o(BaseBindView.StepStatus stepStatus, int i, int i2) {
        O000000o(stepStatus, getResources().getString(i));
    }

    public final void O000000o(BaseBindView.StepStatus stepStatus, CharSequence charSequence, int i, boolean z) {
        O000000o(stepStatus, charSequence);
    }

    public final void O000000o(BaseBindView.StepStatus stepStatus, String str, int i) {
        O000000o(stepStatus, str);
    }
}
