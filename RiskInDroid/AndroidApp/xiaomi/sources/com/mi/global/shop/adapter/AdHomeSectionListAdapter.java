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
public class AdHomeSectionListAdapter extends ArrayAdapter<NewHomeBlockInfoItem> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f4729O000000o = cbj.O000000o.f13594O000000o.O00000o0(21);
    public final int O00000Oo = cbj.O000000o.f13594O000000o.O00000o0(19);
    Context O00000o0;
    private ImageView O0000O0o;

    public final /* bridge */ /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        return O000000o(context, (NewHomeBlockInfoItem) obj);
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        final NewHomeBlockInfoItem newHomeBlockInfoItem = (NewHomeBlockInfoItem) obj;
        if (newHomeBlockInfoItem != null) {
            if (!TextUtils.isEmpty(newHomeBlockInfoItem.getImageUrl())) {
                this.O0000O0o = (ImageView) view.findViewById(R.id.home_ad_item_image);
            }
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.adapter.AdHomeSectionListAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    AdHomeSectionListAdapter adHomeSectionListAdapter = AdHomeSectionListAdapter.this;
                    ccd.O000000o(adHomeSectionListAdapter.O00000o0, newHomeBlockInfoItem);
                }
            });
        }
    }

    public AdHomeSectionListAdapter(Context context) {
        super(context);
        this.O00000o0 = context;
    }

    private View O000000o(Context context, NewHomeBlockInfoItem newHomeBlockInfoItem) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_home_ad_item, (ViewGroup) null);
        this.O0000O0o = (ImageView) inflate.findViewById(R.id.home_ad_item_image);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.O0000O0o.getLayoutParams();
        layoutParams.width = this.O00000Oo;
        if (!TextUtils.isEmpty(newHomeBlockInfoItem.mImageHeight)) {
            try {
                Integer.parseInt(newHomeBlockInfoItem.mImageHeight);
            } catch (Exception unused) {
            }
        }
        this.O0000O0o.setLayoutParams(layoutParams);
        return inflate;
    }
}
