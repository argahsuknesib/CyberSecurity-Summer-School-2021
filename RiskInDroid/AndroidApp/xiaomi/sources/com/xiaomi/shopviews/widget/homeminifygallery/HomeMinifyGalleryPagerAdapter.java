package com.xiaomi.shopviews.widget.homeminifygallery;

import _m_j.duh;
import _m_j.dun;
import _m_j.eun;
import _m_j.ewv;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.shopviews.adapter.adapter.BasePageAdapter;
import com.xiaomi.shopviews.model.HomeSectionItem;
import com.xiaomi.smarthome.R;

public class HomeMinifyGalleryPagerAdapter extends BasePageAdapter<HomeSectionItem> {
    private Context O00000Oo;

    public float getPageWidth(int i) {
        return 0.7777778f;
    }

    public final /* synthetic */ void O000000o(View view, Object obj) {
        final HomeSectionItem homeSectionItem = (HomeSectionItem) obj;
        if (homeSectionItem != null) {
            TextView textView = (TextView) view.findViewById(R.id.listitem_home_minify_gallery_viewpager_price);
            duh.O000000o().O000000o(homeSectionItem.mImageUrl, (ImageView) view.findViewById(R.id.listitem_home_minify_gallery_viewpager_image));
            ((TextView) view.findViewById(R.id.listitem_home_minify_gallery_viewpager_title)).setText(homeSectionItem.mCommentBrief);
            ((TextView) view.findViewById(R.id.listitem_home_minify_gallery_viewpager_from)).setText(this.O00000Oo.getString(R.string.listitem_home_minify_gallery_viewpager_from_text, homeSectionItem.mCommentAuthor));
            ((TextView) view.findViewById(R.id.listitem_home_minify_gallery_viewpager_name)).setText(homeSectionItem.mProductName);
            String str = homeSectionItem.mProductPrice;
            if (textView != null) {
                if (ewv.O000000o(str)) {
                    textView.setText(str);
                } else {
                    textView.setText("");
                }
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.shopviews.widget.homeminifygallery.HomeMinifyGalleryPagerAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                }
            });
            dun.O000000o(this.O00000Oo, textView);
        }
    }

    public HomeMinifyGalleryPagerAdapter(Context context) {
        super(context);
        this.O00000Oo = context;
    }

    public int getItemPosition(Object obj) {
        return this.f3589O000000o.contains(((View) obj).getTag()) ? -1 : -2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, Object obj, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.listitem_home_minify_gallerypager, viewGroup, false);
        int O000000o2 = eun.O000000o().O000000o(eun.O0000o00);
        int O000000o3 = eun.O000000o().O000000o(eun.O0000Ooo);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.height = O000000o3;
        layoutParams.width = O000000o2;
        ((ImageView) inflate.findViewById(R.id.listitem_home_minify_gallery_viewpager_image)).setLayoutParams(layoutParams);
        return inflate;
    }
}
