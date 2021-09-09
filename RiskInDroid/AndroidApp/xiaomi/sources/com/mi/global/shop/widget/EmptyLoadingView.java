package com.mi.global.shop.widget;

import _m_j.ccr;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mi.global.shop.loader.BaseResult;
import com.xiaomi.smarthome.R;

public class EmptyLoadingView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    protected RelativeLayout f4954O000000o;
    protected CustomTextView O00000Oo;
    protected int O00000o;
    protected ImageView O00000o0;
    protected CharSequence O00000oO;
    protected CommonButton O00000oo;
    public boolean O0000O0o;
    public O000000o O0000OOo;
    private Handler O0000Oo0;

    public interface O000000o {
    }

    public void O00000Oo() {
    }

    public EmptyLoadingView(Context context) {
        this(context, null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.mi.global.shop.widget.EmptyLoadingView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public EmptyLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000Oo0 = new Handler(Looper.getMainLooper());
        LayoutInflater.from(context).inflate((int) R.layout.shop_empty_loading, (ViewGroup) this, true);
        this.f4954O000000o = (RelativeLayout) findViewById(R.id.empty_progress_container);
        this.O00000Oo = (CustomTextView) findViewById(R.id.empty_text);
        this.O00000o0 = (ImageView) findViewById(R.id.empty_tip_icon);
        this.O00000oo = (CommonButton) findViewById(R.id.button);
    }

    public void setOnErrorReloadButtonClick(O000000o o000000o) {
        this.O0000OOo = o000000o;
    }

    public void O000000o(boolean z) {
        this.f4954O000000o.setVisibility(0);
        this.O00000Oo.setVisibility(8);
        this.O00000o0.setVisibility(8);
        this.O00000oo.setVisibility(8);
        O000000o(this);
    }

    private void O000000o(View view) {
        if (view.getVisibility() != 0) {
            view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shop_appear));
            view.setVisibility(0);
        }
        view.setBackgroundColor(Color.parseColor("#efeff0"));
        view.setAlpha(0.8f);
    }

    public void setEmptyText(int i) {
        this.O00000o = i;
    }

    public void setEmptyText(CharSequence charSequence) {
        this.O00000oO = charSequence;
    }

    public final void O000000o(BaseResult.ResultStatus resultStatus) {
        ccr.O00000Oo("EmptyLoadingView", "onError, hasData:false" + ",status:" + resultStatus);
        ((RelativeLayout.LayoutParams) this.f4954O000000o.getLayoutParams()).addRule(13);
        O000000o(this);
        this.f4954O000000o.setVisibility(8);
        this.O00000o0.setVisibility(0);
        this.O00000Oo.setVisibility(0);
        this.O00000Oo.setText(BaseResult.O000000o(resultStatus));
        this.O00000oo.setVisibility(0);
        if (resultStatus == BaseResult.ResultStatus.NETWROK_ERROR) {
            this.O00000oo.setText((int) R.string.shop_check_network);
        }
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.widget.EmptyLoadingView.AnonymousClass1 */

            public final void onClick(View view) {
            }
        });
    }

    public final void O000000o() {
        if (getVisibility() == 0) {
            if (isShown()) {
                startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shop_disappear));
            }
            setVisibility(8);
        }
    }
}
