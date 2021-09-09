package _m_j;

import _m_j.ewn;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.shopviews.adapter.productshow.ProductShowListAdapter3;
import com.xiaomi.shopviews.widget.recycleview.FullyGridLayoutManager;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public final class evx extends euk<ewn, vr> {
    private RecyclerView O00000o;
    private ProductShowListAdapter3 O00000o0;

    public final int O000000o() {
        return 27;
    }

    public final int O00000Oo() {
        return R.layout.product_show_view3;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        this.O00000o = (RecyclerView) vrVar.itemView.findViewById(R.id.rycRecommend);
        this.O00000o.setLayoutManager(new FullyGridLayoutManager(this.f2565O000000o));
        this.O00000o0 = new ProductShowListAdapter3(this.f2565O000000o);
        this.O00000o.setAdapter(this.O00000o0);
        this.O00000o.setNestedScrollingEnabled(false);
        ProductShowListAdapter3 productShowListAdapter3 = this.O00000o0;
        ArrayList<ewn.O000000o> arrayList = ((ewn) obj).f15893O000000o;
        if (arrayList != null) {
            productShowListAdapter3.f3926O000000o.clear();
            productShowListAdapter3.f3926O000000o.addAll(arrayList);
            productShowListAdapter3.notifyDataSetChanged();
        }
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewn) obj, i);
    }
}
