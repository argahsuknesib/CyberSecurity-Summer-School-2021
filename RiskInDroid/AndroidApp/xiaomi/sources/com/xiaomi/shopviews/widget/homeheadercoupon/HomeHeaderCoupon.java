package com.xiaomi.shopviews.widget.homeheadercoupon;

import _m_j.duo;
import _m_j.duq;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.shopviews.model.HomeSectionBody;
import com.xiaomi.smarthome.R;

public class HomeHeaderCoupon extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public ImageView f3946O000000o;
    public ListView O00000Oo;
    private TextView O00000o;
    private long O00000o0 = 0;
    private CountDownTimer O00000oO;
    private TextView O00000oo;
    private RelativeLayout O0000O0o;
    private TextView O0000OOo;
    private CountDownTimer O0000Oo0;

    public HomeHeaderCoupon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(context, R.layout.listitem_header_coupon, this);
        this.O0000O0o = (RelativeLayout) findViewById(R.id.rootview_header_coupon);
        this.f3946O000000o = (ImageView) findViewById(R.id.iv_bg);
        this.O00000oo = (TextView) findViewById(R.id.tv_couponInfo);
        this.O0000OOo = (TextView) findViewById(R.id.tv_timeInfo);
        this.O00000o = (TextView) findViewById(R.id.tv_timeCountDown);
        this.O00000Oo = (ListView) findViewById(R.id.lv_bubble);
    }

    private void setBgColor(HomeSectionBody homeSectionBody) {
        if (!TextUtils.isEmpty(homeSectionBody.mBgColor)) {
            int parseColor = Color.parseColor(homeSectionBody.mBgColor);
            if (getBackground() == null || !(getBackground() instanceof ColorDrawable) || ((ColorDrawable) getBackground()).getColor() != parseColor) {
                setBackgroundColor(parseColor);
            }
        }
    }

    private void setBubbleInfo(HomeSectionBody homeSectionBody) {
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }

    private void setCouponInfo(HomeSectionBody homeSectionBody) {
        if (!TextUtils.isEmpty(homeSectionBody.mActionText)) {
            this.O00000oo.setText(homeSectionBody.mActionText);
            if (homeSectionBody.padding > 0) {
                ((RelativeLayout.LayoutParams) this.O00000oo.getLayoutParams()).bottomMargin = duo.O000000o(duq.O000000o().O00000oo, 1080, homeSectionBody.padding).f14953O000000o;
            }
            if (!TextUtils.isEmpty(homeSectionBody.coupon_color)) {
                getResources().getColor(R.color.white);
                while (true) {
                    try {
                        this.O00000oo.setTextColor(Color.parseColor(homeSectionBody.coupon_color));
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void setViewHeightInfo(HomeSectionBody homeSectionBody) {
        int i = homeSectionBody.mHeight;
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.O0000O0o.getLayoutParams();
            duo.O000000o O000000o2 = duo.O000000o(duq.O000000o().O00000oo, 1080, i);
            layoutParams.height = O000000o2.f14953O000000o;
            ((RelativeLayout.LayoutParams) this.f3946O000000o.getLayoutParams()).height = O000000o2.f14953O000000o;
        }
    }

    private void O000000o() {
        CountDownTimer countDownTimer = this.O00000oO;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.O00000oO = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O000000o();
        O00000Oo();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        O000000o();
        O00000Oo();
    }

    private void O00000Oo() {
        CountDownTimer countDownTimer = this.O0000Oo0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
