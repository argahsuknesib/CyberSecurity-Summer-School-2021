package com.mi.global.shop.adapter;

import _m_j.cbj;
import _m_j.ccd;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.newmodel.home.NewHomeBlockInfoItem;
import com.xiaomi.smarthome.R;

@Deprecated
public class AdHomeSectionGridAdapter extends ArrayAdapter<NewHomeBlockInfoItem> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f4727O000000o = cbj.O000000o.f13594O000000o.O00000o0(21);
    public final int O00000Oo = cbj.O000000o.f13594O000000o.O00000o0(19);
    Context O00000o0;
    private ImageView O0000O0o;

    public final /* bridge */ /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        return O000000o(context, (NewHomeBlockInfoItem) obj);
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        final NewHomeBlockInfoItem newHomeBlockInfoItem = (NewHomeBlockInfoItem) obj;
        if (newHomeBlockInfoItem != null) {
            TextUtils.isEmpty(newHomeBlockInfoItem.getImageUrl());
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.adapter.AdHomeSectionGridAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    AdHomeSectionGridAdapter adHomeSectionGridAdapter = AdHomeSectionGridAdapter.this;
                    ccd.O000000o(adHomeSectionGridAdapter.O00000o0, newHomeBlockInfoItem);
                }
            });
        }
    }

    public AdHomeSectionGridAdapter(Context context) {
        super(context);
        this.O00000o0 = context;
    }

    private View O000000o(Context context, NewHomeBlockInfoItem newHomeBlockInfoItem) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_home_ad_item, (ViewGroup) null);
        this.O0000O0o = (ImageView) inflate.findViewById(R.id.home_ad_item_image);
        this.O0000O0o.setMaxWidth(this.O00000Oo / 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.O0000O0o.getLayoutParams();
        layoutParams.width = this.O00000Oo / 2;
        if (!TextUtils.isEmpty(newHomeBlockInfoItem.mImageHeight)) {
            try {
                Integer.parseInt(newHomeBlockInfoItem.mImageHeight);
            } catch (Exception unused) {
            }
        }
        this.O0000O0o.setLayoutParams(layoutParams);
        ((LinearLayout) inflate.findViewById(R.id.container)).setBackgroundDrawable(inflate.getResources().getDrawable(R.drawable.shop_home_grid_item_bg));
        return inflate;
    }
}
