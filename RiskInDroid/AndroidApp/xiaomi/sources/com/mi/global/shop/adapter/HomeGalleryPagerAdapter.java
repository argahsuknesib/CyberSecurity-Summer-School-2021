package com.mi.global.shop.adapter;

import _m_j.cba;
import _m_j.cbj;
import _m_j.ccr;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mi.global.shop.model.HomeThemeItem;
import com.mi.global.shop.widget.ResponsiveRelativeLayout;
import com.xiaomi.smarthome.R;

@Deprecated
public class HomeGalleryPagerAdapter extends BasePageIndicatorAdapter<HomeThemeItem> {
    private ImageView O00000o;
    public Context O00000o0;

    public final /* synthetic */ void O000000o(View view, Object obj) {
        final HomeThemeItem homeThemeItem = (HomeThemeItem) obj;
        if (homeThemeItem != null) {
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.adapter.HomeGalleryPagerAdapter.AnonymousClass2 */

                public final void onClick(View view) {
                    cba.O000000o(HomeGalleryPagerAdapter.this.O00000o0, homeThemeItem);
                }
            });
            String str = homeThemeItem.mImageUrl;
            if (str != null && !str.startsWith("http://")) {
                str = "http:".concat(String.valueOf(str));
            }
            ccr.O00000Oo("HomeGalleryPagerAdapter", "imageUrl:".concat(String.valueOf(str)));
        }
    }

    public HomeGalleryPagerAdapter(Context context) {
        super(context);
        this.O00000o0 = context;
    }

    public final /* synthetic */ View O000000o(Context context, ViewGroup viewGroup) {
        AnonymousClass1 r6 = new ResponsiveRelativeLayout(context) {
            /* class com.mi.global.shop.adapter.HomeGalleryPagerAdapter.AnonymousClass1 */

            public final Drawable getForegroundDrawable() {
                return getResources().getDrawable(R.drawable.shop_selector_home_staritem);
            }
        };
        int O00000o02 = cbj.O000000o.f13594O000000o.O00000o0(19);
        int O00000o03 = cbj.O000000o.f13594O000000o.O00000o0(20);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.height = O00000o03;
        layoutParams.width = O00000o02;
        r6.setLayoutParams(layoutParams);
        r6.setMinimumHeight(O00000o03);
        this.O00000o = new ImageView(context);
        this.O00000o.setScaleType(ImageView.ScaleType.FIT_XY);
        this.O00000o.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        r6.addView(this.O00000o);
        return r6;
    }
}
