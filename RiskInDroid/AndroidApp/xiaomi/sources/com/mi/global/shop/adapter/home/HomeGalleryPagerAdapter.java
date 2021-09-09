package com.mi.global.shop.adapter.home;

import _m_j.cbq;
import _m_j.ccd;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.adapter.BasePageIndicatorAdapter;
import com.mi.global.shop.newmodel.home.NewHomeBlockInfoItem;
import com.xiaomi.smarthome.R;

public class HomeGalleryPagerAdapter extends BasePageIndicatorAdapter<NewHomeBlockInfoItem> {
    public Context O00000o0;

    public final /* synthetic */ void O000000o(View view, Object obj) {
        final NewHomeBlockInfoItem newHomeBlockInfoItem = (NewHomeBlockInfoItem) obj;
        if (newHomeBlockInfoItem != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.adapter.home.HomeGalleryPagerAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    ccd.O000000o(HomeGalleryPagerAdapter.this.O00000o0, newHomeBlockInfoItem);
                }
            });
            String imageUrl = newHomeBlockInfoItem.getImageUrl();
            if (!TextUtils.isEmpty(imageUrl)) {
                NewHomeBlockInfoItem newHomeBlockInfoItem2 = (NewHomeBlockInfoItem) view.getTag();
                if (newHomeBlockInfoItem2 == null || !imageUrl.equals(newHomeBlockInfoItem2.getImageUrl())) {
                    if (newHomeBlockInfoItem2 == null) {
                        newHomeBlockInfoItem2 = new NewHomeBlockInfoItem();
                    }
                    newHomeBlockInfoItem2.mImageUrl = imageUrl;
                    view.setTag(newHomeBlockInfoItem2);
                    cbq.O000000o(imageUrl, (SimpleDraweeView) view);
                }
            }
        }
    }

    public HomeGalleryPagerAdapter(Context context) {
        super(context);
        this.O00000o0 = context;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(this.O00000o0).inflate((int) R.layout.shop_gallery_image_view, viewGroup, false);
    }
}
