package _m_j;

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

public final class evj extends RecyclerView.O000000o<O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public ewr f15852O000000o;
    public eum O00000Oo;
    private Context O00000o0;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        O000000o o000000o = (O000000o) o000OOo0;
        final ewr.O000000o o000000o2 = this.f15852O000000o.O0000oo0.get(i);
        if (o000000o2.O00000o != null && !TextUtils.isEmpty(o000000o2.O00000o)) {
            CustomTextView customTextView = o000000o.f15854O000000o;
            customTextView.setText(o000000o2.O00000o);
        }
        o000000o.itemView.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.evj.AnonymousClass1 */

            public final void onClick(View view) {
                String str = o000000o2.O00000o0;
                if (evj.this.O00000Oo != null && str != null && !TextUtils.isEmpty(str)) {
                    evj.this.O00000Oo.O000000o(evj.this.f15852O000000o.O00000Oo, o000000o2, "");
                }
            }
        });
        String str = o000000o2.O00000Oo;
        if (!TextUtils.isEmpty(str)) {
            Option option = new Option();
            option.O00000Oo = R.drawable.default_pic_small_inverse;
            duh.O000000o().O000000o(ewt.O000000o(str), o000000o.O00000Oo, option);
            eum eum = this.O00000Oo;
            if (eum != null) {
                eum.O000000o(this.f15852O000000o.O00000Oo, o000000o2);
            }
        }
    }

    public evj(Context context, ewr ewr, eum eum) {
        this.O00000o0 = context;
        this.f15852O000000o = ewr;
        this.O00000Oo = eum;
    }

    public final int getItemCount() {
        return this.f15852O000000o.O0000oo0.size();
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        CustomTextView f15854O000000o;
        ImageView O00000Oo;
        LinearLayout O00000o0;

        O000000o(View view) {
            super(view);
            this.O00000Oo = (ImageView) view.findViewById(R.id.model_entry_image);
            this.f15854O000000o = (CustomTextView) view.findViewById(R.id.model_entry_name);
            this.O00000o0 = (LinearLayout) view.findViewById(R.id.id_root_ll);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.discover_quick_ntrance_list_item, viewGroup, false);
        inflate.getLayoutParams().width = (int) (((float) Resources.getSystem().getDisplayMetrics().widthPixels) / 4.0f);
        return new O000000o(inflate);
    }
}
