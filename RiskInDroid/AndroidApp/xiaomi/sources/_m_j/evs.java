package _m_j;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;

public final class evs extends euk<ewr, vr> {
    public eum O00000o0;

    public final int O000000o() {
        return 8;
    }

    public final int O00000Oo() {
        return R.layout.home_discover_show_list_item;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        final ewr ewr = (ewr) obj;
        View view = vrVar.itemView;
        if (!TextUtils.isEmpty(ewr.O00000o)) {
            ((CustomTextView) view.findViewById(R.id.tv_discover_title)).setText(ewr.O00000o);
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        evt evt = new evt(view.getContext(), ewr, this.O00000o0);
        recyclerView.setAdapter(evt);
        CustomTextView customTextView = (CustomTextView) view.findViewById(R.id.tv_view_more);
        if (ewr.O0000oo0 == null || ewr.O0000oo0.size() <= 3) {
            customTextView.setVisibility(8);
            evt.O000000o(ewr.O0000oo0);
        } else {
            customTextView.setVisibility(0);
            evt.O000000o(ewr.O0000oo0.subList(0, 3));
        }
        customTextView.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.evs.AnonymousClass1 */

            public final void onClick(View view) {
                if (evs.this.O00000o0 != null) {
                    eum eum = evs.this.O00000o0;
                    ewr ewr = ewr;
                    eum.O000000o(ewr, ewr.O00000Oo, (Object) null);
                    evs.this.O00000o0.O000000o("view_more_click", "home_discover");
                }
            }
        });
        customTextView.setVisibility(8);
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewr) obj, i);
    }

    public evs() {
    }

    public evs(eum eum) {
        this.O00000o0 = eum;
    }
}
