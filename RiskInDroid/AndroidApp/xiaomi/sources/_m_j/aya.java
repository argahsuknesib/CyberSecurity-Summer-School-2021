package _m_j;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.O000OOo0;
import java.util.List;

public abstract class aya<GVH extends RecyclerView.O000OOo0, CVH extends RecyclerView.O000OOo0> extends RecyclerView.O000000o<RecyclerView.O000OOo0> implements axr<GVH, CVH> {
    public int getChildItemViewType(int i, int i2) {
        return 0;
    }

    public int getGroupItemViewType(int i) {
        return 0;
    }

    public final int getItemCount() {
        return 0;
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
    }

    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public boolean onHookGroupCollapse(int i, boolean z) {
        return true;
    }

    public boolean onHookGroupExpand(int i, boolean z) {
        return true;
    }

    public void onBindGroupViewHolder(GVH gvh, int i, int i2, List<Object> list) {
        onBindGroupViewHolder(gvh, i, i2);
    }

    public void onBindChildViewHolder(CVH cvh, int i, int i2, int i3, List<Object> list) {
        onBindChildViewHolder(cvh, i, i2, i3);
    }
}
