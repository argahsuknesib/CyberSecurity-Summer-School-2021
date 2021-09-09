package _m_j;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.shopviews.widget.recycleview.FullyGridLayoutManager;
import com.xiaomi.smarthome.R;

public final class evz extends euk<ewr, vr> {
    public eum O00000o;
    public vs O00000o0;
    private ewa O00000oO;
    private RecyclerView O00000oo;
    private exh O0000O0o = new exh(dul.O000000o(eui.f15823O000000o, 10.0f));

    public final int O000000o() {
        return 10;
    }

    public final int O00000Oo() {
        return R.layout.recommend_view;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, final int i) {
        final ewr ewr = (ewr) obj;
        View view = vrVar.itemView;
        CustomTextView customTextView = (CustomTextView) view.findViewById(R.id.customTextView);
        if (!TextUtils.isEmpty(ewr.O00000o)) {
            customTextView.setVisibility(0);
            customTextView.setText(ewr.O00000o);
        } else {
            customTextView.setVisibility(8);
        }
        this.O00000oo = (RecyclerView) view.findViewById(R.id.rycRecommend);
        this.O00000oo.setLayoutManager(new FullyGridLayoutManager(this.f2565O000000o));
        if (this.O00000oo.getItemDecorationCount() == 0) {
            this.O00000oo.addItemDecoration(this.O0000O0o);
        }
        this.O00000oO = new ewa(this.f2565O000000o, ewr, this.O00000o);
        this.O00000oo.setAdapter(this.O00000oO);
        this.O00000oo.setNestedScrollingEnabled(false);
        if (ewr.O0000oo0 == null || ewr.O0000oo0.size() <= 4 || ewr.O0000oo) {
            this.O00000oO.O000000o(ewr.O0000oo0);
        } else {
            this.O00000oO.O000000o(ewr.O0000oo0.subList(0, 4));
        }
        CustomTextView customTextView2 = (CustomTextView) view.findViewById(R.id.tv_view_more);
        if (ewr.O0000oo0 == null || ewr.O0000oo0.size() <= 4 || ewr.O0000oo) {
            customTextView2.setVisibility(8);
        } else {
            customTextView2.setVisibility(0);
        }
        customTextView2.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.evz.AnonymousClass1 */

            public final void onClick(View view) {
                ewr.O0000oo = true;
                evz.this.O00000o0.notifyItemChanged(i);
                if (evz.this.O00000o != null) {
                    evz.this.O00000o.O000000o("view_more_click", "audio");
                }
            }
        });
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewr) obj, i);
    }

    public evz(eum eum, vs vsVar) {
        this.O00000o = eum;
        this.O00000o0 = vsVar;
    }
}
