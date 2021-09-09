package _m_j;

import _m_j.ewr;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public final class ewa extends RecyclerView.O000000o<O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public ewr f15878O000000o;
    eum O00000Oo;
    private List<ewr.O000000o> O00000o = new ArrayList();
    private Context O00000o0;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, final int i) {
        O000000o o000000o = (O000000o) o000OOo0;
        final ewr.O000000o o000000o2 = this.O00000o.get(i);
        if (!TextUtils.isEmpty(o000000o2.O0000oOO)) {
            ((GradientDrawable) o000000o.O0000O0o.getBackground()).setColor(Color.parseColor(o000000o2.O0000oOO));
        }
        if (!TextUtils.isEmpty(o000000o2.O0000O0o)) {
            o000000o.O00000oO.setVisibility(0);
            duh.O000000o().O000000o(o000000o2.O0000O0o, o000000o.O00000oO);
            o000000o.O00000oo.setVisibility(4);
        } else {
            o000000o.O00000oO.setVisibility(4);
        }
        if (!TextUtils.isEmpty(o000000o2.O00oOooo)) {
            o000000o.O00000oo.setVisibility(0);
            o000000o.O00000oo.setText(o000000o2.O00oOooo);
            o000000o.O00000oO.setVisibility(4);
        } else {
            o000000o.O00000oo.setVisibility(4);
        }
        if (!TextUtils.isEmpty(o000000o2.O00000Oo)) {
            dui O000000o2 = duh.O000000o();
            String O000000o3 = ewt.O000000o(o000000o2.O00000Oo);
            ImageView imageView = o000000o.f15880O000000o;
            Option option = new Option();
            option.O00000Oo = R.drawable.default_pic_small_inverse;
            O000000o2.O000000o(O000000o3, imageView, option);
        }
        o000000o.O00000Oo.setText(o000000o2.O00000o);
        String str = "";
        if (!TextUtils.isEmpty(o000000o2.O00000oO)) {
            CustomTextView customTextView = o000000o.O00000o0;
            StringBuilder sb = new StringBuilder();
            sb.append(o000000o2.O00oOoOo ? str : eul.O00000oo());
            sb.append(o000000o2.O00000oO);
            customTextView.setText(sb.toString());
        }
        if (!TextUtils.isEmpty(o000000o2.O00000oo) && !o000000o2.O00000oO.equals(o000000o2.O00000oo)) {
            CustomTextView customTextView2 = o000000o.O00000o;
            StringBuilder sb2 = new StringBuilder();
            if (!o000000o2.O00oOoOo) {
                str = eul.O00000oo();
            }
            sb2.append(str);
            sb2.append(o000000o2.O00000oo);
            customTextView2.setText(sb2.toString());
            o000000o.O00000o.getPaint().setAntiAlias(true);
            o000000o.O00000o.getPaint().setFlags(16);
        }
        o000000o.itemView.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.ewa.AnonymousClass1 */

            public final void onClick(View view) {
                ewa ewa = ewa.this;
                String str = ewa.f15878O000000o.O00000Oo;
                ewr.O000000o o000000o = o000000o2;
                if (ewa.O00000Oo != null) {
                    ewa.O00000Oo.O000000o(str, o000000o, "");
                }
                ewa ewa2 = ewa.this;
                String format = String.format("place%s_click", Integer.valueOf(i + 1));
                if (ewa2.O00000Oo != null) {
                    ewa2.O00000Oo.O000000o(format, "audio");
                }
            }
        });
        String str2 = this.f15878O000000o.O00000Oo;
        eum eum = this.O00000Oo;
        if (eum != null) {
            eum.O000000o(str2, o000000o2);
        }
    }

    public ewa(Context context, ewr ewr, eum eum) {
        this.O00000o0 = context;
        this.f15878O000000o = ewr;
        this.O00000Oo = eum;
    }

    public final void O000000o(List<ewr.O000000o> list) {
        if (list != null) {
            this.O00000o.clear();
            this.O00000o.addAll(list);
            notifyDataSetChanged();
        }
    }

    public final int getItemCount() {
        return this.O00000o.size();
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        ImageView f15880O000000o;
        CustomTextView O00000Oo;
        CustomTextView O00000o;
        CustomTextView O00000o0;
        ImageView O00000oO;
        CustomTextView O00000oo;
        RelativeLayout O0000O0o;

        O000000o(View view) {
            super(view);
            this.O0000O0o = (RelativeLayout) view.findViewById(R.id.layout_container);
            this.O00000oO = (ImageView) view.findViewById(R.id.corner_mark_img);
            this.O00000oo = (CustomTextView) view.findViewById(R.id.corner_mark_txt);
            this.f15880O000000o = (ImageView) view.findViewById(R.id.item_image);
            this.O00000Oo = (CustomTextView) view.findViewById(R.id.item_title);
            this.O00000o0 = (CustomTextView) view.findViewById(R.id.item_price);
            this.O00000o = (CustomTextView) view.findViewById(R.id.item_price_origin);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(this.O00000o0).inflate((int) R.layout.recommend_item, viewGroup, false));
    }
}
