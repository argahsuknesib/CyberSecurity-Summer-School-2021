package com.mi.global.shop.imageselector.adapter;

import _m_j.cab;
import _m_j.cbq;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class FolderAdapter extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<cab> f4885O000000o = new ArrayList();
    int O00000Oo;
    private Context O00000o;
    public int O00000o0 = 0;
    private LayoutInflater O00000oO;

    public long getItemId(int i) {
        return (long) i;
    }

    public FolderAdapter(Context context) {
        this.O00000o = context;
        this.O00000oO = (LayoutInflater) context.getSystemService("layout_inflater");
        this.O00000Oo = this.O00000o.getResources().getDimensionPixelOffset(R.dimen.folder_cover_size);
    }

    public int getCount() {
        return this.f4885O000000o.size();
    }

    /* renamed from: O000000o */
    public final cab getItem(int i) {
        return this.f4885O000000o.get(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View getView(int i, View view, ViewGroup viewGroup) {
        O000000o o000000o;
        if (view == null) {
            view = this.O00000oO.inflate((int) R.layout.shop_mis_list_item_folder, viewGroup, false);
            o000000o = new O000000o(view);
        } else {
            o000000o = (O000000o) view.getTag();
        }
        if (o000000o != null) {
            cab O000000o2 = getItem(i);
            if (O000000o2 != null) {
                o000000o.O00000Oo.setText(O000000o2.f13512O000000o);
                if (O000000o2.O00000o != null) {
                    o000000o.O00000o0.setText(String.format("(%d)", Integer.valueOf(O000000o2.O00000o.size())));
                } else {
                    o000000o.O00000o0.setText("(*)");
                }
                if (O000000o2.O00000o0 != null) {
                    cbq.O000000o(O000000o2.O00000o0.f4887O000000o, o000000o.f4886O000000o, R.dimen.folder_cover_size, R.dimen.folder_cover_size);
                } else {
                    o000000o.f4886O000000o.setImageResource(R.drawable.shop_default_pic_small_inverse);
                }
            }
            if (this.O00000o0 == i) {
                o000000o.O00000o.setVisibility(0);
            } else {
                o000000o.O00000o.setVisibility(4);
            }
        }
        return view;
    }

    public final void O00000Oo(int i) {
        if (this.O00000o0 != i) {
            this.O00000o0 = i;
            notifyDataSetChanged();
        }
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        SimpleDraweeView f4886O000000o;
        CustomTextView O00000Oo;
        ImageView O00000o;
        CustomTextView O00000o0;

        O000000o(View view) {
            this.f4886O000000o = (SimpleDraweeView) view.findViewById(R.id.cover);
            this.O00000Oo = (CustomTextView) view.findViewById(R.id.name);
            this.O00000o0 = (CustomTextView) view.findViewById(R.id.size);
            this.O00000o = (ImageView) view.findViewById(R.id.indicator);
            view.setTag(this);
        }
    }
}
