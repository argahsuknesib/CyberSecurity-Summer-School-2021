package _m_j;

import _m_j.ewr;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public final class evt extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

    /* renamed from: O000000o  reason: collision with root package name */
    public eum f15869O000000o;
    public ewr O00000Oo;
    private List<ewr.O000000o> O00000o = new ArrayList();
    private Context O00000o0;

    public evt(Context context, ewr ewr, eum eum) {
        this.O00000o0 = context;
        this.O00000Oo = ewr;
        this.f15869O000000o = eum;
    }

    public final void O000000o(List<ewr.O000000o> list) {
        if (list != null) {
            this.O00000o.clear();
            this.O00000o.addAll(list);
            notifyDataSetChanged();
        }
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, final int i) {
        String O000000o2;
        String O000000o3;
        final ewr.O000000o o000000o = this.O00000o.get(i);
        if ((o000OOo0 instanceof O00000Oo) && i == 0) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            if (o000000o.O0000oO0 != null && !TextUtils.isEmpty(o000000o.O0000oO0)) {
                try {
                    final ewf ewf = (ewf) new Gson().fromJson(o000000o.O0000oO0, ewf.class);
                    if (ewf != null) {
                        String str = ewf.O00000o;
                        if (str != null && !TextUtils.isEmpty(str)) {
                            o00000Oo.O00000o0.setText(str);
                        }
                        if (!(ewf.f15882O000000o == null || (O000000o3 = eww.O000000o(ewf.f15882O000000o.longValue())) == null || TextUtils.isEmpty(O000000o3))) {
                            o00000Oo.O00000oO.setText(O000000o3);
                        }
                        o00000Oo.itemView.setOnClickListener(new View.OnClickListener() {
                            /* class _m_j.evt.AnonymousClass1 */

                            public final void onClick(View view) {
                                if (evt.this.f15869O000000o != null) {
                                    evt.this.f15869O000000o.O000000o(evt.this.O00000Oo.O00000Oo, o000000o, ewf.O00000o0);
                                    evt.this.f15869O000000o.O000000o(String.format("place%s_click", Integer.valueOf(i + 1)), "home_discover");
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (o000000o.O00000o != null && !TextUtils.isEmpty(o000000o.O00000o)) {
                o00000Oo.O00000Oo.setText(o000000o.O00000o);
            }
            int i2 = Resources.getSystem().getDisplayMetrics().widthPixels;
            if (i2 != 0) {
                double O000000o4 = (double) (i2 - dul.O000000o(eui.f15823O000000o, 30.0f));
                Double.isNaN(O000000o4);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) o00000Oo.f15875O000000o.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = (int) (O000000o4 / 2.1d);
                o00000Oo.f15875O000000o.setLayoutParams(layoutParams);
            }
            if (o000000o.O00000Oo != null && !TextUtils.isEmpty(o000000o.O00000Oo)) {
                Option option = new Option();
                option.O00000Oo = R.drawable.default_pic_small_inverse;
                option.O0000O0o = dul.O000000o(o00000Oo.f15875O000000o.getContext(), 10.0f);
                duh.O000000o().O000000o(o000000o.O00000Oo, o00000Oo.f15875O000000o, option);
            }
            o00000Oo.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.evt.AnonymousClass2 */

                public final void onClick(View view) {
                }
            });
            eum eum = this.f15869O000000o;
            if (eum != null) {
                eum.O000000o(this.O00000Oo.O00000Oo, o000000o);
            }
        } else if (o000OOo0 instanceof O000000o) {
            O000000o o000000o2 = (O000000o) o000OOo0;
            if (o000000o.O0000oO0 != null && !TextUtils.isEmpty(o000000o.O0000oO0)) {
                try {
                    final ewf ewf2 = (ewf) new Gson().fromJson(o000000o.O0000oO0, ewf.class);
                    if (ewf2 != null) {
                        String str2 = ewf2.O00000o;
                        if (str2 != null && !TextUtils.isEmpty(str2)) {
                            o000000o2.O00000o0.setText(str2);
                        }
                        if (!(ewf2.f15882O000000o == null || (O000000o2 = eww.O000000o(ewf2.f15882O000000o.longValue())) == null || TextUtils.isEmpty(O000000o2))) {
                            o000000o2.O00000oO.setText(O000000o2);
                        }
                        o000000o2.itemView.setOnClickListener(new View.OnClickListener() {
                            /* class _m_j.evt.AnonymousClass3 */

                            public final void onClick(View view) {
                                if (evt.this.f15869O000000o != null) {
                                    evt.this.f15869O000000o.O000000o(evt.this.O00000Oo.O00000Oo, o000000o, ewf2.O00000o0);
                                    evt.this.f15869O000000o.O000000o(String.format("place%s_click", Integer.valueOf(i + 1)), "home_discover");
                                }
                            }
                        });
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (o000000o.O00000o != null && !TextUtils.isEmpty(o000000o.O00000o)) {
                o000000o2.O00000Oo.setText(o000000o.O00000o);
            }
            if (o000000o.O00000Oo != null && !TextUtils.isEmpty(o000000o.O00000Oo)) {
                Option option2 = new Option();
                option2.O00000Oo = R.drawable.default_pic_small_inverse;
                option2.O0000O0o = dul.O000000o(o000000o2.f15874O000000o.getContext(), 10.0f);
                duh.O000000o().O000000o(o000000o.O00000Oo, o000000o2.f15874O000000o, option2);
            }
            eum eum2 = this.f15869O000000o;
            if (eum2 != null) {
                eum2.O000000o(this.O00000Oo.O00000Oo, o000000o);
            }
            o000000o2.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.evt.AnonymousClass4 */

                public final void onClick(View view) {
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new O00000Oo(LayoutInflater.from(this.O00000o0).inflate((int) R.layout.home_discover_list_top_item, viewGroup, false));
        }
        return new O000000o(LayoutInflater.from(this.O00000o0).inflate((int) R.layout.home_discover_list_normal_item, viewGroup, false));
    }

    public final int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i != 0) {
            return 2;
        }
        return super.getItemViewType(i);
    }

    public final int getItemCount() {
        return this.O00000o.size();
    }

    static class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        ImageView f15875O000000o;
        CustomTextView O00000Oo;
        ImageView O00000o;
        CustomTextView O00000o0;
        CustomTextView O00000oO;

        O00000Oo(View view) {
            super(view);
            this.f15875O000000o = (ImageView) view.findViewById(R.id.iv_product_image);
            this.O00000Oo = (CustomTextView) view.findViewById(R.id.tv_title);
            this.O00000o = (ImageView) view.findViewById(R.id.iv_like);
            this.O00000o0 = (CustomTextView) view.findViewById(R.id.tv_like_number);
            this.O00000oO = (CustomTextView) view.findViewById(R.id.tv_time);
        }
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        ImageView f15874O000000o;
        CustomTextView O00000Oo;
        ImageView O00000o;
        CustomTextView O00000o0;
        CustomTextView O00000oO;

        O000000o(View view) {
            super(view);
            this.f15874O000000o = (ImageView) view.findViewById(R.id.iv_product_image);
            this.O00000Oo = (CustomTextView) view.findViewById(R.id.tv_title);
            this.O00000o = (ImageView) view.findViewById(R.id.iv_like);
            this.O00000o0 = (CustomTextView) view.findViewById(R.id.tv_like_number);
            this.O00000oO = (CustomTextView) view.findViewById(R.id.tv_time);
        }
    }
}
