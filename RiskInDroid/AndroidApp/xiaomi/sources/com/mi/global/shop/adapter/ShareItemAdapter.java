package com.mi.global.shop.adapter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class ShareItemAdapter extends ArrayAdapter<ResolveInfo> {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f4756O000000o;
    private PackageManager O00000Oo;

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        ResolveInfo resolveInfo = (ResolveInfo) obj;
        O000000o o000000o = (O000000o) view.getTag();
        o000000o.f4757O000000o.setImageDrawable(resolveInfo.loadIcon(this.O00000Oo));
        o000000o.O00000Oo.setText(resolveInfo.loadLabel(this.O00000Oo).toString());
    }

    public ShareItemAdapter(Context context) {
        super(context);
        this.O00000Oo = context.getPackageManager();
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        ImageView f4757O000000o;
        CustomTextView O00000Oo;

        O000000o() {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_item_system_share, (ViewGroup) null, false);
        this.f4756O000000o = new O000000o();
        this.f4756O000000o.f4757O000000o = (ImageView) inflate.findViewById(R.id.iv_app_icon);
        this.f4756O000000o.O00000Oo = (CustomTextView) inflate.findViewById(R.id.tv_app_name);
        inflate.setTag(this.f4756O000000o);
        return inflate;
    }
}
