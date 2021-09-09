package com.xiaomi.shopviews.widget.homeminifygallery;

import _m_j.dul;
import _m_j.eun;
import android.content.Context;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.smarthome.R;

public class HomeMinifyGalleryView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private HomeMinifyGalleryPagerAdapter f3962O000000o;
    private ViewPager O00000Oo = ((ViewPager) findViewById(R.id.listitem_home_minify_gallery_viewpager));

    public HomeMinifyGalleryView(Context context) {
        super(context);
        inflate(context, R.layout.listitem_home_minify_galleryview, this);
        this.f3962O000000o = new HomeMinifyGalleryPagerAdapter(context);
        this.O00000Oo.setAdapter(this.f3962O000000o);
        this.O00000Oo.setPageMargin(dul.O000000o(getContext(), 8.0f));
        setMinimumHeight(eun.O000000o().O000000o(eun.O0000OoO));
    }
}
