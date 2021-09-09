package com.mi.global.shop.adapter.home;

import _m_j.cbj;
import _m_j.cbq;
import _m_j.ccd;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.newmodel.home.NewHomeBlockInfoItem;
import com.xiaomi.smarthome.R;

public class HomeImageGridAdapter extends ArrayAdapter<NewHomeBlockInfoItem> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f4787O000000o = "HomeImageGridAdapter";

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        final NewHomeBlockInfoItem newHomeBlockInfoItem = (NewHomeBlockInfoItem) obj;
        if (newHomeBlockInfoItem != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.adapter.home.HomeImageGridAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    ccd.O000000o(HomeImageGridAdapter.this.O00000o, newHomeBlockInfoItem);
                }
            });
            ccd.O000000o(newHomeBlockInfoItem);
            String imageUrl = newHomeBlockInfoItem.getImageUrl();
            if (!TextUtils.isEmpty(imageUrl) && !imageUrl.equals(view.getTag())) {
                view.setTag(imageUrl);
                cbq.O000000o(imageUrl, (SimpleDraweeView) view);
            }
        }
    }

    public HomeImageGridAdapter(Context context) {
        super(context);
        this.O00000o = context;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_gallery_image_view, viewGroup, false);
        inflate.getLayoutParams().height = cbj.O000000o.f13594O000000o.O00000o0(26);
        return inflate;
    }
}
