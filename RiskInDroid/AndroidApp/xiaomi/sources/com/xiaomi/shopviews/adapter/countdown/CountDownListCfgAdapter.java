package com.xiaomi.shopviews.adapter.countdown;

import _m_j.duh;
import _m_j.dul;
import _m_j.eui;
import _m_j.eul;
import _m_j.eum;
import _m_j.ewr;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class CountDownListCfgAdapter extends RecyclerView.O000000o<O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<ewr.O000000o> f3902O000000o;
    eum O00000Oo;
    private Context O00000o;
    public ewr O00000o0;

    public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, final int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        O000000o o000000o = (O000000o) o000OOo0;
        int i6 = -1;
        int i7 = 0;
        if (this.f3902O000000o.size() == 1) {
            int O000000o2 = dul.O000000o(this.O00000o, 220.0f);
            int i8 = Resources.getSystem().getDisplayMetrics().widthPixels;
            if (i8 != 0) {
                O000000o2 = ((i8 - dul.O000000o(eui.f15823O000000o, 30.0f)) * 2) / 3;
            }
            i2 = O000000o2;
            i5 = 0;
            i4 = R.drawable.border_shadow_white;
            i3 = -1;
        } else {
            i6 = -2;
            int O000000o3 = dul.O000000o(this.O00000o, 7.0f);
            if (i == 0) {
                i7 = dul.O000000o(this.O00000o, 8.0f);
            }
            i3 = dul.O000000o(this.O00000o, 285.0f);
            i2 = dul.O000000o(this.O00000o, 190.0f);
            i5 = i7;
            i7 = O000000o3;
            i4 = R.drawable.border_shadow_white_half;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) o000000o.O00000oO.getLayoutParams();
        layoutParams.width = i6;
        layoutParams.topMargin = i7;
        layoutParams.leftMargin = i5;
        o000000o.O00000oO.setLayoutParams(layoutParams);
        o000000o.O00000oO.setBackgroundResource(i4);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) o000000o.O00000Oo.getLayoutParams();
        layoutParams2.width = i3;
        layoutParams2.height = i2;
        o000000o.O00000Oo.setLayoutParams(layoutParams2);
        ewr.O000000o o000000o2 = this.f3902O000000o.get(i);
        o000000o.f3905O000000o.setText(o000000o2.O00000o);
        o000000o.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.shopviews.adapter.countdown.CountDownListCfgAdapter.AnonymousClass1 */

            public final void onClick(View view) {
            }
        });
        String str = o000000o2.O00000Oo;
        Option option = new Option();
        option.O0000O0o = dul.O000000o(o000000o.O00000Oo.getContext(), 10.0f);
        option.O00000Oo = R.drawable.default_pic_small_inverse;
        option.O0000OoO = true;
        option.O0000Ooo = true;
        duh.O000000o().O000000o(str, o000000o.O00000Oo, option);
        String str2 = "";
        if (!TextUtils.isEmpty(this.f3902O000000o.get(i).O00000oO)) {
            CustomTextView customTextView = o000000o.O00000o0;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3902O000000o.get(i).O00oOoOo ? str2 : eul.O00000oo());
            sb.append(this.f3902O000000o.get(i).O00000oO);
            customTextView.setText(sb.toString());
        }
        if (!TextUtils.isEmpty(this.f3902O000000o.get(i).O00000oo)) {
            CustomTextView customTextView2 = o000000o.O00000o;
            StringBuilder sb2 = new StringBuilder();
            if (!this.f3902O000000o.get(i).O00oOoOo) {
                str2 = eul.O00000oo();
            }
            sb2.append(str2);
            sb2.append(this.f3902O000000o.get(i).O00000oo);
            customTextView2.setText(sb2.toString());
            o000000o.O00000o.getPaint().setAntiAlias(true);
            o000000o.O00000o.getPaint().setFlags(16);
        } else {
            o000000o.O00000o.setText(str2);
        }
        o000000o.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.shopviews.adapter.countdown.CountDownListCfgAdapter.AnonymousClass2 */

            public final void onClick(View view) {
                CountDownListCfgAdapter countDownListCfgAdapter = CountDownListCfgAdapter.this;
                String str = countDownListCfgAdapter.O00000o0.O00000Oo;
                ewr.O000000o o000000o = CountDownListCfgAdapter.this.f3902O000000o.get(i);
                if (countDownListCfgAdapter.O00000Oo != null) {
                    countDownListCfgAdapter.O00000Oo.O000000o(str, o000000o, "");
                }
                CountDownListCfgAdapter countDownListCfgAdapter2 = CountDownListCfgAdapter.this;
                String format = String.format("place%s_click", Integer.valueOf(i + 1));
                if (countDownListCfgAdapter2.O00000Oo != null) {
                    countDownListCfgAdapter2.O00000Oo.O000000o(format, "flashsale");
                }
            }
        });
        String str3 = this.O00000o0.O00000Oo;
        ewr.O000000o o000000o3 = this.f3902O000000o.get(i);
        eum eum = this.O00000Oo;
        if (eum != null) {
            eum.O000000o(str3, o000000o3);
        }
    }

    public CountDownListCfgAdapter(Context context, ewr ewr, eum eum) {
        this(context);
        this.O00000o0 = ewr;
        this.O00000Oo = eum;
    }

    public CountDownListCfgAdapter(Context context) {
        this.f3902O000000o = new ArrayList();
        this.O00000o = context;
    }

    public int getItemCount() {
        return this.f3902O000000o.size();
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        CustomTextView f3905O000000o;
        ImageView O00000Oo;
        CustomTextView O00000o;
        CustomTextView O00000o0;
        LinearLayout O00000oO;
        CustomTextView O00000oo;

        O000000o(View view) {
            super(view);
            this.O00000oO = (LinearLayout) view.findViewById(R.id.layout_root);
            this.f3905O000000o = (CustomTextView) view.findViewById(R.id.product_name);
            this.O00000Oo = (ImageView) view.findViewById(R.id.product_image);
            this.O00000o0 = (CustomTextView) view.findViewById(R.id.product_price);
            this.O00000o = (CustomTextView) view.findViewById(R.id.product_old_price);
            this.O00000oo = (CustomTextView) view.findViewById(R.id.btn_remind_me);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(this.O00000o).inflate((int) R.layout.countdown_list_item, viewGroup, false));
    }
}
