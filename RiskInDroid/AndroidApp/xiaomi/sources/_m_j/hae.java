package _m_j;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0003"}, d2 = {"isCompletelyShow", "", "Landroidx/recyclerview/widget/RecyclerView;", "smarthome-mainpage_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class hae {
    public static final boolean O000000o(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager) || ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() != 0) {
            return false;
        }
        return true;
    }
}
