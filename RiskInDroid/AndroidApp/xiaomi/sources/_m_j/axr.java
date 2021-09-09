package _m_j;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.O000OOo0;

public interface axr<GVH extends RecyclerView.O000OOo0, CVH extends RecyclerView.O000OOo0> {
    int getChildCount(int i);

    long getChildId(int i, int i2);

    int getChildItemViewType(int i, int i2);

    int getGroupCount();

    long getGroupId(int i);

    int getGroupItemViewType(int i);

    void onBindChildViewHolder(CVH cvh, int i, int i2, int i3);

    void onBindGroupViewHolder(GVH gvh, int i, int i2);

    boolean onCheckCanExpandOrCollapseGroup(GVH gvh, int i, int i2, int i3, boolean z);

    CVH onCreateChildViewHolder(ViewGroup viewGroup, int i);

    GVH onCreateGroupViewHolder(ViewGroup viewGroup, int i);

    boolean onHookGroupCollapse(int i, boolean z);

    boolean onHookGroupExpand(int i, boolean z);
}
