package com.xiaomi.shopviews.widget.homebanner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.xiaomi.smarthome.R;

public class HomeBannerView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f3936O000000o = 0;
    private ImageView O00000Oo = null;

    public HomeBannerView(Context context) {
        super(context);
        O000000o(context);
    }

    public HomeBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public HomeBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(Context context) {
        inflate(context, R.layout.listitem_home_bannerview2, this);
        this.O00000Oo = (ImageView) findViewById(R.id.listitem_home_banner_image);
    }
}
