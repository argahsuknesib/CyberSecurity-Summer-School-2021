package _m_j;

import _m_j.ewj;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.shopviews.adapter.countdown.CrowdfundingMultipleAdapter;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public final class evg extends euk<ewj, vr> {
    public final int O000000o() {
        return 23;
    }

    public final int O00000Oo() {
        return R.layout.crowdfunding_multiple_list_item;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        View view = vrVar.itemView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        CrowdfundingMultipleAdapter crowdfundingMultipleAdapter = new CrowdfundingMultipleAdapter(view.getContext());
        recyclerView.setAdapter(crowdfundingMultipleAdapter);
        ArrayList<ewj.O000000o> arrayList = ((ewj) obj).f15886O000000o;
        if (arrayList != null) {
            crowdfundingMultipleAdapter.f3910O000000o.clear();
            crowdfundingMultipleAdapter.f3910O000000o.addAll(arrayList);
            crowdfundingMultipleAdapter.notifyDataSetChanged();
        }
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewj) obj, i);
    }
}
