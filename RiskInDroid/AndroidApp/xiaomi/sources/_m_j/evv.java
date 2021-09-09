package _m_j;

import _m_j.ewm;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.shopviews.adapter.productshow.HomeHotAccessoriesListAdapter;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public final class evv extends euk<ewm, vr> {
    public final int O000000o() {
        return 21;
    }

    public final int O00000Oo() {
        return R.layout.hot_accessories_list_item;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        View view = vrVar.itemView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        HomeHotAccessoriesListAdapter homeHotAccessoriesListAdapter = new HomeHotAccessoriesListAdapter(view.getContext());
        recyclerView.setAdapter(homeHotAccessoriesListAdapter);
        ArrayList<ewm.O000000o> arrayList = ((ewm) obj).f15891O000000o;
        if (arrayList != null) {
            homeHotAccessoriesListAdapter.f3920O000000o.clear();
            homeHotAccessoriesListAdapter.f3920O000000o.addAll(arrayList);
            homeHotAccessoriesListAdapter.notifyDataSetChanged();
        }
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewm) obj, i);
    }
}
