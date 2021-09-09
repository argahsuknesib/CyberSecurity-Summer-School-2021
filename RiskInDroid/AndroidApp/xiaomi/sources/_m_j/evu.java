package _m_j;

import _m_j.ewr;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.List;

public final class evu extends euk<ewr, vr> {
    private eum O00000o0;

    public final int O000000o() {
        return 9;
    }

    public final int O00000Oo() {
        return R.layout.product_show_view_item_5;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        final ewr ewr = (ewr) obj;
        View view = vrVar.itemView;
        CustomTextView customTextView = (CustomTextView) view.findViewById(R.id.titleText);
        if (!TextUtils.isEmpty(ewr.O00000o)) {
            customTextView.setVisibility(0);
            customTextView.setText(ewr.O00000o);
        } else {
            customTextView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(ewr.O0000Oo0)) {
            customTextView.setTextColor(Color.parseColor(ewr.O0000Oo0));
        }
        List<ewr.O000000o> list = ewr.O0000oo0;
        if (list != null && list.size() > 0) {
            ewr.O000000o o000000o = list.get(0);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_image);
            int i2 = Resources.getSystem().getDisplayMetrics().widthPixels;
            if (i2 != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = ((i2 - dul.O000000o(eui.f15823O000000o, 30.0f)) * 2) / 3;
                imageView.setLayoutParams(layoutParams);
            }
            if (!TextUtils.isEmpty(o000000o.O00000Oo)) {
                Option option = new Option();
                option.O0000O0o = dul.O000000o(imageView.getContext(), 10.0f);
                option.O00000Oo = R.drawable.default_pic_small_inverse;
                option.O0000OoO = true;
                option.O0000Ooo = true;
                duh.O000000o().O000000o(ewt.O000000o(o000000o.O00000Oo), imageView, option);
            }
            CustomTextView customTextView2 = (CustomTextView) view.findViewById(R.id.item_title);
            customTextView2.setText(o000000o.O00000o);
            if (!TextUtils.isEmpty(o000000o.O0000oo0)) {
                customTextView2.setTextColor(Color.parseColor(o000000o.O0000oo0));
            }
            CustomTextView customTextView3 = (CustomTextView) view.findViewById(R.id.item_desc);
            customTextView3.setText(o000000o.O0000Oo0);
            if (!TextUtils.isEmpty(o000000o.O00oOooO)) {
                customTextView3.setTextColor(Color.parseColor(o000000o.O00oOooO));
            }
            CustomTextView customTextView4 = (CustomTextView) view.findViewById(R.id.item_price);
            TextUtils.isEmpty(o000000o.O00000oO);
            StringBuilder sb = new StringBuilder();
            String str = "";
            sb.append(o000000o.O00oOoOo ? str : eul.O00000oo());
            sb.append(o000000o.O00000oO);
            customTextView4.setText(sb.toString());
            CustomTextView customTextView5 = (CustomTextView) view.findViewById(R.id.item_price_origin);
            if (TextUtils.isEmpty(o000000o.O00000oo) || o000000o.O00000oO.equals(o000000o.O00000oo)) {
                customTextView5.setVisibility(4);
            } else {
                customTextView5.setVisibility(0);
                StringBuilder sb2 = new StringBuilder();
                if (!o000000o.O00oOoOo) {
                    str = eul.O00000oo();
                }
                sb2.append(str);
                sb2.append(o000000o.O00000oo);
                customTextView5.setText(sb2.toString());
                customTextView5.getPaint().setAntiAlias(true);
                customTextView5.getPaint().setFlags(16);
            }
            CustomTextView customTextView6 = (CustomTextView) view.findViewById(R.id.buy_btn);
            vrVar.O000000o(R.id.buy_btn);
            customTextView6.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.evu.AnonymousClass1 */

                public final void onClick(View view) {
                    if (ewr.O0000oo0 != null && ewr.O0000oo0.size() > 0) {
                        evu.this.O000000o(ewr.O00000Oo, ewr.O0000oo0.get(0));
                        evu.this.O000000o("buy_click", "featured_products");
                    }
                }
            });
            if (!TextUtils.isEmpty(o000000o.O0000ooO)) {
                customTextView6.setText(o000000o.O0000ooO);
            }
            if (!TextUtils.isEmpty(o000000o.O0000ooo)) {
                customTextView6.setTextColor(Color.parseColor(o000000o.O0000ooo));
                ((GradientDrawable) customTextView6.getBackground()).setStroke(dul.O000000o(customTextView6.getContext(), 1.0f), Color.parseColor(o000000o.O0000ooo));
            }
            String str2 = ewr.O00000Oo;
            eum eum = this.O00000o0;
            if (eum != null) {
                eum.O000000o(str2, o000000o);
            }
        }
    }

    public final /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        ewr ewr = (ewr) obj;
        super.O00000Oo(vrVar, ewr, i);
        if (ewr.O0000oo0 != null && ewr.O0000oo0.size() > 0) {
            O000000o(ewr.O00000Oo, ewr.O0000oo0.get(0));
            O000000o("picture_click", "featured_products");
        }
    }

    public evu(eum eum) {
        this.O00000o0 = eum;
    }

    public final void O000000o(String str, ewr.O000000o o000000o) {
        eum eum = this.O00000o0;
        if (eum != null) {
            eum.O000000o(str, o000000o, "");
        }
    }

    public final void O000000o(String str, String str2) {
        eum eum = this.O00000o0;
        if (eum != null) {
            eum.O000000o(str, str2);
        }
    }
}
