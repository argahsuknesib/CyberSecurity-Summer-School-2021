package _m_j;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;

public final class evl extends vx<ewr, vr> {
    private eum O00000o0;

    public final int O000000o() {
        return 12;
    }

    public final int O00000Oo() {
        return R.layout.comment_list_item;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        ewr ewr = (ewr) obj;
        View view = vrVar.itemView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 4));
            recyclerView.setAdapter(new evj(vrVar.itemView.getContext(), ewr, this.O00000o0));
        }
    }

    public evl() {
    }

    public evl(eum eum) {
        this.O00000o0 = eum;
    }
}
