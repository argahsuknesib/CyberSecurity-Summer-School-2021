package com.xiaomi.shopviews.adapter.countdown;

import _m_j.duh;
import _m_j.dul;
import _m_j.eum;
import _m_j.ewr;
import _m_j.ewt;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class CommentViewAdapter extends RecyclerView.O000000o<O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<ewr.O000000o> f3895O000000o;
    eum O00000Oo;
    private Context O00000o;
    public ewr O00000o0;

    public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, final int i) {
        O000000o o000000o = (O000000o) o000OOo0;
        final ewr.O000000o o000000o2 = this.f3895O000000o.get(i);
        int O000000o2 = i == 0 ? dul.O000000o(this.O00000o, 8.0f) : 0;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) o000000o.O0000O0o.getLayoutParams();
        layoutParams.leftMargin = O000000o2;
        o000000o.O0000O0o.setLayoutParams(layoutParams);
        Option option = new Option();
        option.O0000O0o = dul.O000000o(o000000o.f3897O000000o.getContext(), 10.0f);
        option.O00000Oo = R.drawable.default_pic_small_inverse;
        duh.O000000o().O000000o(ewt.O000000o(o000000o2.O00000Oo), o000000o.f3897O000000o, option);
        Option option2 = new Option();
        option2.O0000OOo = true;
        option2.O00000Oo = R.drawable.icon_user_default_head;
        option2.O00000o = R.drawable.icon_user_default_head;
        duh.O000000o().O000000o(ewt.O000000o(o000000o2.O000O00o), o000000o.O00000o0, option2);
        if (!TextUtils.isEmpty(o000000o2.O0000OOo)) {
            o000000o.O00000o.setText(o000000o2.O0000OOo);
        } else {
            o000000o.O00000o.setVisibility(4);
        }
        o000000o.O00000oO.setNumStars(5);
        if (!TextUtils.isEmpty(o000000o2.O0000OoO)) {
            o000000o.O00000oO.setRating(Float.parseFloat(o000000o2.O0000OoO));
        } else {
            o000000o.O00000oO.setRating(5.0f);
        }
        if (!TextUtils.isEmpty(o000000o2.O0000Oo0)) {
            o000000o.O00000oo.setText(o000000o2.O0000Oo0);
        } else {
            o000000o.O00000oo.setVisibility(4);
        }
        if (!TextUtils.isEmpty(o000000o2.O00oOooO)) {
            o000000o.O00000oo.setTextColor(Color.parseColor(o000000o2.O00oOooO));
        }
        o000000o.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.shopviews.adapter.countdown.CommentViewAdapter.AnonymousClass1 */

            public final void onClick(View view) {
                CommentViewAdapter commentViewAdapter = CommentViewAdapter.this;
                String str = commentViewAdapter.O00000o0.O00000Oo;
                ewr.O000000o o000000o = o000000o2;
                if (commentViewAdapter.O00000Oo != null) {
                    commentViewAdapter.O00000Oo.O000000o(str, o000000o, "");
                }
                CommentViewAdapter commentViewAdapter2 = CommentViewAdapter.this;
                String format = String.format("place%s_click", Integer.valueOf(i + 1));
                if (commentViewAdapter2.O00000Oo != null) {
                    commentViewAdapter2.O00000Oo.O000000o(format, "hot_reviews");
                }
            }
        });
        String str = this.O00000o0.O00000Oo;
        eum eum = this.O00000Oo;
        if (eum != null) {
            eum.O000000o(str, o000000o2);
        }
    }

    public CommentViewAdapter(Context context) {
        this.f3895O000000o = new ArrayList();
        this.O00000o = context;
    }

    public CommentViewAdapter(Context context, ewr ewr, eum eum) {
        this(context);
        this.O00000o0 = ewr;
        this.O00000Oo = eum;
    }

    public int getItemCount() {
        return this.f3895O000000o.size();
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        ImageView f3897O000000o;
        CustomTextView O00000Oo;
        CustomTextView O00000o;
        ImageView O00000o0;
        RatingBar O00000oO;
        CustomTextView O00000oo;
        RelativeLayout O0000O0o;

        O000000o(View view) {
            super(view);
            this.f3897O000000o = (ImageView) view.findViewById(R.id.product_image);
            this.O00000Oo = (CustomTextView) view.findViewById(R.id.product_name);
            this.O00000o0 = (ImageView) view.findViewById(R.id.user_header);
            this.O00000o = (CustomTextView) view.findViewById(R.id.user_name);
            this.O00000oO = (RatingBar) view.findViewById(R.id.rating_bar);
            this.O00000oo = (CustomTextView) view.findViewById(R.id.tv_description);
            this.O0000O0o = (RelativeLayout) view.findViewById(R.id.layout_root);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(this.O00000o).inflate((int) R.layout.comment_adapter_list_item, viewGroup, false));
    }
}
