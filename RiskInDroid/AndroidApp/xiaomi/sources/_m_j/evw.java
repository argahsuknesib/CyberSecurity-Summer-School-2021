package _m_j;

import _m_j.ewr;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.shopviews.adapter.productshow.ProductShowListAdapter1;
import com.xiaomi.smarthome.R;
import java.util.List;

public final class evw extends euk<ewr, vr> {
    private eum O00000o0;

    public final int O000000o() {
        return 4;
    }

    public final int O00000Oo() {
        return R.layout.product_show_list_item_1;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        ewr ewr = (ewr) obj;
        View view = vrVar.itemView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        ProductShowListAdapter1 productShowListAdapter1 = new ProductShowListAdapter1(view.getContext(), ewr, this.O00000o0);
        recyclerView.setAdapter(productShowListAdapter1);
        List<ewr.O000000o> list = ewr.O0000oo0;
        if (list != null) {
            productShowListAdapter1.f3923O000000o.clear();
            productShowListAdapter1.f3923O000000o.addAll(list);
            productShowListAdapter1.notifyDataSetChanged();
        }
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewr) obj, i);
    }

    public evw(eum eum) {
        this.O00000o0 = eum;
    }
}
