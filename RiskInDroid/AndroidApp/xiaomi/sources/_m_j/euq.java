package _m_j;

import _m_j.ewr;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;

public final class euq extends euk<ewr, vr> {
    private eum O00000o0;

    public final int O000000o() {
        return 3;
    }

    public final int O00000Oo() {
        return R.layout.advertise_three_image_list_item;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        final ewr ewr = (ewr) obj;
        View view = vrVar.itemView;
        int i2 = Resources.getSystem().getDisplayMetrics().widthPixels;
        if (i2 != 0) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = (i2 * 11) / 12;
            layoutParams.bottomMargin = dul.O000000o(view.getContext(), 20.0f);
            view.setLayoutParams(layoutParams);
        }
        String str = "";
        if (ewr.O0000oo0.size() > 0) {
            Option option = new Option();
            option.O0000O0o = dul.O000000o(view.getContext(), 10.0f);
            option.O00000Oo = R.drawable.default_pic_small_inverse;
            option.O0000Oo = true;
            option.O0000Ooo = true;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.relativeLayout1);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setVisibility(0);
            duh.O000000o().O000000o(ewr.O0000oo0.get(0).O00000Oo, imageView, option);
            CustomTextView customTextView = (CustomTextView) view.findViewById(R.id.new_price);
            CustomTextView customTextView2 = (CustomTextView) view.findViewById(R.id.old_price);
            ((CustomTextView) view.findViewById(R.id.tv_title)).setText(ewr.O0000oo0.get(0).O00000o);
            if (!TextUtils.isEmpty(ewr.O0000oo0.get(0).O00000oO)) {
                StringBuilder sb = new StringBuilder();
                sb.append(ewr.O0000oo0.get(0).O00oOoOo ? str : eul.O00000oo());
                sb.append(ewr.O0000oo0.get(0).O00000oO);
                customTextView.setText(sb.toString());
            }
            if (!TextUtils.isEmpty(ewr.O0000oo0.get(0).O00000oo)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ewr.O0000oo0.get(0).O00oOoOo ? str : eul.O00000oo());
                sb2.append(ewr.O0000oo0.get(0).O00000oo);
                customTextView2.setText(sb2.toString());
            }
            customTextView2.getPaint().setAntiAlias(true);
            customTextView2.getPaint().setFlags(16);
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.euq.AnonymousClass1 */

                public final void onClick(View view) {
                    euq.this.O000000o(ewr.O00000Oo, ewr.O0000oo0.get(0));
                    euq.this.O000000o(String.format("place%s_click", 1), "referral");
                }
            });
            O00000Oo(ewr.O00000Oo, ewr.O0000oo0.get(0));
        }
        if (ewr.O0000oo0.size() > 1) {
            Option option2 = new Option();
            option2.O0000O0o = dul.O000000o(view.getContext(), 10.0f);
            option2.O00000Oo = R.drawable.default_pic_small_inverse;
            option2.O0000Oo0 = true;
            option2.O0000OoO = true;
            option2.O0000Ooo = true;
            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.relativeLayout2);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView2);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            duh.O000000o().O000000o(ewr.O0000oo0.get(1).O00000Oo, imageView2, option2);
            CustomTextView customTextView3 = (CustomTextView) view.findViewById(R.id.new_price2);
            CustomTextView customTextView4 = (CustomTextView) view.findViewById(R.id.old_price2);
            ((CustomTextView) view.findViewById(R.id.tv_title2)).setText(ewr.O0000oo0.get(1).O00000o);
            if (!TextUtils.isEmpty(ewr.O0000oo0.get(1).O00000oO)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(ewr.O0000oo0.get(1).O00oOoOo ? str : eul.O00000oo());
                sb3.append(ewr.O0000oo0.get(1).O00000oO);
                customTextView3.setText(sb3.toString());
            }
            if (!TextUtils.isEmpty(ewr.O0000oo0.get(1).O00000oo)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(ewr.O0000oo0.get(1).O00oOoOo ? str : eul.O00000oo());
                sb4.append(ewr.O0000oo0.get(1).O00000oo);
                customTextView4.setText(sb4.toString());
            }
            customTextView4.getPaint().setAntiAlias(true);
            customTextView4.getPaint().setFlags(16);
            relativeLayout2.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.euq.AnonymousClass2 */

                public final void onClick(View view) {
                    euq.this.O000000o(ewr.O00000Oo, ewr.O0000oo0.get(1));
                    euq.this.O000000o(String.format("place%s_click", 2), "referral");
                }
            });
            O00000Oo(ewr.O00000Oo, ewr.O0000oo0.get(1));
        }
        if (ewr.O0000oo0.size() > 2) {
            Option option3 = new Option();
            option3.O0000O0o = dul.O000000o(view.getContext(), 10.0f);
            option3.O00000Oo = R.drawable.default_pic_small_inverse;
            option3.O0000Oo0 = true;
            option3.O0000OoO = true;
            option3.O0000Oo = true;
            RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.relativeLayout3);
            ImageView imageView3 = (ImageView) view.findViewById(R.id.imageView3);
            imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
            duh.O000000o().O000000o(ewr.O0000oo0.get(2).O00000Oo, imageView3, option3);
            CustomTextView customTextView5 = (CustomTextView) view.findViewById(R.id.new_price3);
            CustomTextView customTextView6 = (CustomTextView) view.findViewById(R.id.old_price3);
            ((CustomTextView) view.findViewById(R.id.tv_title3)).setText(ewr.O0000oo0.get(2).O00000o);
            if (!TextUtils.isEmpty(ewr.O0000oo0.get(2).O00000oO)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(ewr.O0000oo0.get(2).O00oOoOo ? str : eul.O00000oo());
                sb5.append(ewr.O0000oo0.get(2).O00000oO);
                customTextView5.setText(sb5.toString());
            }
            if (!TextUtils.isEmpty(ewr.O0000oo0.get(2).O00000oo)) {
                StringBuilder sb6 = new StringBuilder();
                if (!ewr.O0000oo0.get(2).O00oOoOo) {
                    str = eul.O00000oo();
                }
                sb6.append(str);
                sb6.append(ewr.O0000oo0.get(2).O00000oo);
                customTextView6.setText(sb6.toString());
            }
            customTextView6.getPaint().setAntiAlias(true);
            customTextView6.getPaint().setFlags(16);
            relativeLayout3.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.euq.AnonymousClass3 */

                public final void onClick(View view) {
                    euq.this.O000000o(ewr.O00000Oo, ewr.O0000oo0.get(2));
                    euq.this.O000000o(String.format("place%s_click", 3), "referral");
                }
            });
            O00000Oo(ewr.O00000Oo, ewr.O0000oo0.get(2));
        }
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewr) obj, i);
    }

    public euq(eum eum) {
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

    private void O00000Oo(String str, ewr.O000000o o000000o) {
        eum eum = this.O00000o0;
        if (eum != null) {
            eum.O000000o(str, o000000o);
        }
    }
}
