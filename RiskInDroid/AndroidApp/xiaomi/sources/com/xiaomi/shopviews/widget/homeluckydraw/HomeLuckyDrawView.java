package com.xiaomi.shopviews.widget.homeluckydraw;

import _m_j.duq;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class HomeLuckyDrawView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f3956O000000o = "HomeLuckyDrawView";
    private boolean O00000Oo;
    private TextView O00000o = ((TextView) findViewById(R.id.btn_jump_coupon));
    private ImageView O00000o0 = ((ImageView) findViewById(R.id.bg_image));
    private Button O00000oO = ((Button) findViewById(R.id.btn_lucky));
    private LinearLayout O00000oo = ((LinearLayout) findViewById(R.id.container));
    private RelativeLayout O0000O0o = ((RelativeLayout) findViewById(R.id.root_view));
    private TextView O0000OOo = ((TextView) findViewById(R.id.text_title_count));
    private TextView O0000Oo = ((TextView) findViewById(R.id.text_title_right));
    private TextView O0000Oo0 = ((TextView) findViewById(R.id.text_title_left));

    public HomeLuckyDrawView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate((int) R.layout.listitem_home_lucky_draw, this);
        this.O0000O0o.getLayoutParams().height = (int) ((((float) duq.O000000o().O00000oo) * 370.0f) / 1080.0f);
        this.O00000o0.getLayoutParams().height = (int) ((((float) duq.O000000o().O00000oo) * 370.0f) / 1080.0f);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O00000Oo = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O00000Oo = false;
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.O00000Oo = true;
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.O00000Oo = false;
    }
}
