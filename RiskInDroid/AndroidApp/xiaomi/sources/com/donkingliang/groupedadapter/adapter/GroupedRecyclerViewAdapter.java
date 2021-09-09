package com.donkingliang.groupedadapter.adapter;

import _m_j.dm;
import _m_j.we;
import _m_j.wf;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

public abstract class GroupedRecyclerViewAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

    /* renamed from: TYPE_CHILD */
    public static final int type_child = 2132213794;

    /* renamed from: TYPE_FOOTER */
    public static final int type_footer = 2132213795;

    /* renamed from: TYPE_HEADER */
    public static final int type_header = 2132213796;
    public boolean isDataChanged;
    protected Context mContext;
    public O00000Oo mOnChildClickListener;
    public O00000o0 mOnFooterClickListener;
    public O00000o mOnHeaderClickListener;
    protected ArrayList<wf> mStructures;
    private int mTempPosition;
    private boolean mUseBinding;

    public interface O00000Oo {
        void onChildClick(GroupedRecyclerViewAdapter groupedRecyclerViewAdapter, we weVar, int i, int i2);
    }

    public interface O00000o {
    }

    public interface O00000o0 {
    }

    public abstract int getChildLayout(int i);

    public abstract int getChildrenCount(int i);

    public abstract int getFooterLayout(int i);

    public abstract int getGroupCount();

    public abstract int getHeaderLayout(int i);

    public abstract boolean hasFooter(int i);

    public abstract boolean hasHeader(int i);

    public abstract void onBindChildViewHolder(we weVar, int i, int i2);

    public abstract void onBindFooterViewHolder(we weVar, int i);

    public abstract void onBindHeaderViewHolder(we weVar, int i);

    public GroupedRecyclerViewAdapter(Context context) {
        this(context, false);
    }

    public GroupedRecyclerViewAdapter(Context context, boolean z) {
        this.mStructures = new ArrayList<>();
        this.mContext = context;
        this.mUseBinding = z;
        registerAdapterDataObserver(new O000000o());
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        structureChanged();
    }

    public void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
        super.onViewAttachedToWindow(o000OOo0);
        if (isStaggeredGridLayout(o000OOo0)) {
            handleLayoutIfStaggeredGridLayout(o000OOo0, o000OOo0.getLayoutPosition());
        }
    }

    private boolean isStaggeredGridLayout(RecyclerView.O000OOo0 o000OOo0) {
        ViewGroup.LayoutParams layoutParams = o000OOo0.itemView.getLayoutParams();
        return layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams);
    }

    private void handleLayoutIfStaggeredGridLayout(RecyclerView.O000OOo0 o000OOo0, int i) {
        if (judgeType(i) == type_header || judgeType(i) == type_footer) {
            ((StaggeredGridLayoutManager.LayoutParams) o000OOo0.itemView.getLayoutParams()).O00000Oo = true;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.mUseBinding) {
            return new we(dm.O000000o(LayoutInflater.from(this.mContext), getLayoutId(this.mTempPosition, i), viewGroup).O0000O0o);
        }
        return new we(LayoutInflater.from(this.mContext).inflate(getLayoutId(this.mTempPosition, i), viewGroup, false));
    }

    public void onBindViewHolder(final RecyclerView.O000OOo0 o000OOo0, int i) {
        int judgeType = judgeType(i);
        final int groupPositionForPosition = getGroupPositionForPosition(i);
        if (judgeType == type_header) {
            if (this.mOnHeaderClickListener != null) {
                o000OOo0.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter.AnonymousClass1 */

                    public final void onClick(View view) {
                    }
                });
            }
            onBindHeaderViewHolder((we) o000OOo0, groupPositionForPosition);
        } else if (judgeType == type_footer) {
            if (this.mOnFooterClickListener != null) {
                o000OOo0.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter.AnonymousClass2 */

                    public final void onClick(View view) {
                    }
                });
            }
            onBindFooterViewHolder((we) o000OOo0, groupPositionForPosition);
        } else if (judgeType == type_child) {
            final int childPositionForPosition = getChildPositionForPosition(groupPositionForPosition, i);
            if (this.mOnChildClickListener != null) {
                o000OOo0.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter.AnonymousClass3 */

                    public final void onClick(View view) {
                        if (GroupedRecyclerViewAdapter.this.mOnChildClickListener != null) {
                            GroupedRecyclerViewAdapter.this.mOnChildClickListener.onChildClick(GroupedRecyclerViewAdapter.this, (we) o000OOo0, groupPositionForPosition, childPositionForPosition);
                        }
                    }
                });
            }
            onBindChildViewHolder((we) o000OOo0, groupPositionForPosition, childPositionForPosition);
        }
    }

    public int getItemCount() {
        if (this.isDataChanged) {
            structureChanged();
        }
        return count();
    }

    public int getItemViewType(int i) {
        this.mTempPosition = i;
        int groupPositionForPosition = getGroupPositionForPosition(i);
        int judgeType = judgeType(i);
        if (judgeType == type_header) {
            return getHeaderViewType(groupPositionForPosition);
        }
        if (judgeType == type_footer) {
            return getFooterViewType(groupPositionForPosition);
        }
        if (judgeType == type_child) {
            return getChildViewType(groupPositionForPosition, getChildPositionForPosition(groupPositionForPosition, i));
        }
        return super.getItemViewType(i);
    }

    public int getHeaderViewType(int i) {
        return type_header;
    }

    public int getFooterViewType(int i) {
        return type_footer;
    }

    public int getChildViewType(int i, int i2) {
        return type_child;
    }

    private int getLayoutId(int i, int i2) {
        int judgeType = judgeType(i);
        if (judgeType == type_header) {
            return getHeaderLayout(i2);
        }
        if (judgeType == type_footer) {
            return getFooterLayout(i2);
        }
        if (judgeType == type_child) {
            return getChildLayout(i2);
        }
        return 0;
    }

    private int count() {
        return countGroupRangeItem(0, this.mStructures.size());
    }

    public int judgeType(int i) {
        int size = this.mStructures.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            wf wfVar = this.mStructures.get(i3);
            if (wfVar.f2572O000000o && i < (i2 = i2 + 1)) {
                return type_header;
            }
            i2 += wfVar.O00000o0;
            if (i < i2) {
                return type_child;
            }
            if (wfVar.O00000Oo && i < (i2 = i2 + 1)) {
                return type_footer;
            }
        }
        throw new IndexOutOfBoundsException("can't determine the item type of the position.position = " + i + ",item count = " + getItemCount());
    }

    private void structureChanged() {
        this.mStructures.clear();
        int groupCount = getGroupCount();
        for (int i = 0; i < groupCount; i++) {
            this.mStructures.add(new wf(hasHeader(i), hasFooter(i), getChildrenCount(i)));
        }
        this.isDataChanged = false;
    }

    public int getGroupPositionForPosition(int i) {
        int size = this.mStructures.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += countGroupItem(i3);
            if (i < i2) {
                return i3;
            }
        }
        return -1;
    }

    public int getChildPositionForPosition(int i, int i2) {
        if (i < 0 || i >= this.mStructures.size()) {
            return -1;
        }
        int countGroupRangeItem = countGroupRangeItem(0, i + 1);
        wf wfVar = this.mStructures.get(i);
        int i3 = (wfVar.O00000o0 - (countGroupRangeItem - i2)) + (wfVar.O00000Oo ? 1 : 0);
        if (i3 >= 0) {
            return i3;
        }
        return -1;
    }

    public int getPositionForGroupHeader(int i) {
        if (i < 0 || i >= this.mStructures.size() || !this.mStructures.get(i).f2572O000000o) {
            return -1;
        }
        return countGroupRangeItem(0, i);
    }

    public int getPositionForGroupFooter(int i) {
        if (i < 0 || i >= this.mStructures.size() || !this.mStructures.get(i).O00000Oo) {
            return -1;
        }
        return countGroupRangeItem(0, i + 1) - 1;
    }

    public int getPositionForChild(int i, int i2) {
        if (i < 0 || i >= this.mStructures.size()) {
            return -1;
        }
        wf wfVar = this.mStructures.get(i);
        if (wfVar.O00000o0 > i2) {
            return countGroupRangeItem(0, i) + i2 + (wfVar.f2572O000000o ? 1 : 0);
        }
        return -1;
    }

    public int countGroupItem(int i) {
        int i2 = 0;
        if (i < 0 || i >= this.mStructures.size()) {
            return 0;
        }
        wf wfVar = this.mStructures.get(i);
        if (wfVar.f2572O000000o) {
            i2 = 1;
        }
        int i3 = i2 + wfVar.O00000o0;
        return wfVar.O00000Oo ? i3 + 1 : i3;
    }

    public int countGroupRangeItem(int i, int i2) {
        int size = this.mStructures.size();
        int i3 = i;
        int i4 = 0;
        while (i3 < size && i3 < i + i2) {
            i4 += countGroupItem(i3);
            i3++;
        }
        return i4;
    }

    @Deprecated
    public void changeDataSet() {
        notifyDataChanged();
    }

    public void notifyDataChanged() {
        this.isDataChanged = true;
        notifyDataSetChanged();
    }

    @Deprecated
    public void changeGroup(int i) {
        notifyGroupChanged(i);
    }

    public void notifyGroupChanged(int i) {
        int positionForGroupHeader = getPositionForGroupHeader(i);
        int countGroupItem = countGroupItem(i);
        if (positionForGroupHeader >= 0 && countGroupItem > 0) {
            notifyItemRangeChanged(positionForGroupHeader, countGroupItem);
        }
    }

    @Deprecated
    public void changeRangeGroup(int i, int i2) {
        notifyGroupRangeChanged(i, i2);
    }

    public void notifyGroupRangeChanged(int i, int i2) {
        int i3;
        int positionForGroupHeader = getPositionForGroupHeader(i);
        int i4 = i2 + i;
        if (i4 <= this.mStructures.size()) {
            i3 = countGroupRangeItem(i, i4);
        } else {
            i3 = countGroupRangeItem(i, this.mStructures.size());
        }
        if (positionForGroupHeader >= 0 && i3 > 0) {
            notifyItemRangeChanged(positionForGroupHeader, i3);
        }
    }

    @Deprecated
    public void changeHeader(int i) {
        notifyHeaderChanged(i);
    }

    public void notifyHeaderChanged(int i) {
        int positionForGroupHeader = getPositionForGroupHeader(i);
        if (positionForGroupHeader >= 0) {
            notifyItemChanged(positionForGroupHeader);
        }
    }

    @Deprecated
    public void changeFooter(int i) {
        notifyFooterChanged(i);
    }

    public void notifyFooterChanged(int i) {
        int positionForGroupFooter = getPositionForGroupFooter(i);
        if (positionForGroupFooter >= 0) {
            notifyItemChanged(positionForGroupFooter);
        }
    }

    @Deprecated
    public void changeChild(int i, int i2) {
        notifyChildChanged(i, i2);
    }

    public void notifyChildChanged(int i, int i2) {
        int positionForChild = getPositionForChild(i, i2);
        if (positionForChild >= 0) {
            notifyItemChanged(positionForChild);
        }
    }

    @Deprecated
    public void changeRangeChild(int i, int i2, int i3) {
        notifyChildRangeChanged(i, i2, i3);
    }

    public void notifyChildRangeChanged(int i, int i2, int i3) {
        int positionForChild;
        if (i < this.mStructures.size() && (positionForChild = getPositionForChild(i, i2)) >= 0) {
            wf wfVar = this.mStructures.get(i);
            if (wfVar.O00000o0 >= i2 + i3) {
                notifyItemRangeChanged(positionForChild, i3);
            } else {
                notifyItemRangeChanged(positionForChild, wfVar.O00000o0 - i2);
            }
        }
    }

    @Deprecated
    public void changeChildren(int i) {
        notifyChildrenChanged(i);
    }

    public void notifyChildrenChanged(int i) {
        int positionForChild;
        if (i >= 0 && i < this.mStructures.size() && (positionForChild = getPositionForChild(i, 0)) >= 0) {
            notifyItemRangeChanged(positionForChild, this.mStructures.get(i).O00000o0);
        }
    }

    @Deprecated
    public void removeAll() {
        notifyDataRemoved();
    }

    public void notifyDataRemoved() {
        notifyItemRangeRemoved(0, getItemCount());
        this.mStructures.clear();
    }

    @Deprecated
    public void removeGroup(int i) {
        notifyGroupRemoved(i);
    }

    public void notifyGroupRemoved(int i) {
        int positionForGroupHeader = getPositionForGroupHeader(i);
        int countGroupItem = countGroupItem(i);
        if (positionForGroupHeader >= 0 && countGroupItem > 0) {
            notifyItemRangeRemoved(positionForGroupHeader, countGroupItem);
            notifyItemRangeChanged(positionForGroupHeader, getItemCount() - countGroupItem);
            this.mStructures.remove(i);
        }
    }

    @Deprecated
    public void removeRangeGroup(int i, int i2) {
        notifyGroupRangeRemoved(i, i2);
    }

    public void notifyGroupRangeRemoved(int i, int i2) {
        int i3;
        int positionForGroupHeader = getPositionForGroupHeader(i);
        int i4 = i2 + i;
        if (i4 <= this.mStructures.size()) {
            i3 = countGroupRangeItem(i, i4);
        } else {
            i3 = countGroupRangeItem(i, this.mStructures.size());
        }
        if (positionForGroupHeader >= 0 && i3 > 0) {
            notifyItemRangeRemoved(positionForGroupHeader, i3);
            notifyItemRangeChanged(positionForGroupHeader, getItemCount() - i3);
            this.mStructures.remove(i);
        }
    }

    @Deprecated
    public void removeHeader(int i) {
        notifyHeaderRemoved(i);
    }

    public void notifyHeaderRemoved(int i) {
        int positionForGroupHeader = getPositionForGroupHeader(i);
        if (positionForGroupHeader >= 0) {
            notifyItemRemoved(positionForGroupHeader);
            notifyItemRangeChanged(positionForGroupHeader, getItemCount() - positionForGroupHeader);
            this.mStructures.get(i).f2572O000000o = false;
        }
    }

    @Deprecated
    public void removeFooter(int i) {
        notifyFooterRemoved(i);
    }

    public void notifyFooterRemoved(int i) {
        int positionForGroupFooter = getPositionForGroupFooter(i);
        if (positionForGroupFooter >= 0) {
            notifyItemRemoved(positionForGroupFooter);
            notifyItemRangeChanged(positionForGroupFooter, getItemCount() - positionForGroupFooter);
            this.mStructures.get(i).O00000Oo = false;
        }
    }

    @Deprecated
    public void removeChild(int i, int i2) {
        notifyChildRemoved(i, i2);
    }

    public void notifyChildRemoved(int i, int i2) {
        int positionForChild = getPositionForChild(i, i2);
        if (positionForChild >= 0) {
            wf wfVar = this.mStructures.get(i);
            notifyItemRemoved(positionForChild);
            notifyItemRangeChanged(positionForChild, getItemCount() - positionForChild);
            wfVar.O00000o0--;
        }
    }

    @Deprecated
    public void removeRangeChild(int i, int i2, int i3) {
        notifyChildRangeRemoved(i, i2, i3);
    }

    public void notifyChildRangeRemoved(int i, int i2, int i3) {
        int positionForChild;
        if (i < this.mStructures.size() && (positionForChild = getPositionForChild(i, i2)) >= 0) {
            wf wfVar = this.mStructures.get(i);
            int i4 = wfVar.O00000o0;
            if (i4 < i2 + i3) {
                i3 = i4 - i2;
            }
            notifyItemRangeRemoved(positionForChild, i3);
            notifyItemRangeChanged(positionForChild, getItemCount() - i3);
            wfVar.O00000o0 = i4 - i3;
        }
    }

    @Deprecated
    public void removeChildren(int i) {
        notifyChildrenRemoved(i);
    }

    public void notifyChildrenRemoved(int i) {
        int positionForChild;
        if (i < this.mStructures.size() && (positionForChild = getPositionForChild(i, 0)) >= 0) {
            wf wfVar = this.mStructures.get(i);
            int i2 = wfVar.O00000o0;
            notifyItemRangeRemoved(positionForChild, i2);
            notifyItemRangeChanged(positionForChild, getItemCount() - i2);
            wfVar.O00000o0 = 0;
        }
    }

    @Deprecated
    public void insertGroup(int i) {
        notifyGroupInserted(i);
    }

    public void notifyGroupInserted(int i) {
        wf wfVar = new wf(hasHeader(i), hasFooter(i), getChildrenCount(i));
        if (i < this.mStructures.size()) {
            this.mStructures.add(i, wfVar);
        } else {
            this.mStructures.add(wfVar);
            i = this.mStructures.size() - 1;
        }
        int countGroupRangeItem = countGroupRangeItem(0, i);
        int countGroupItem = countGroupItem(i);
        if (countGroupItem > 0) {
            notifyItemRangeInserted(countGroupRangeItem, countGroupItem);
            notifyItemRangeChanged(countGroupItem + countGroupRangeItem, getItemCount() - countGroupRangeItem);
        }
    }

    @Deprecated
    public void insertRangeGroup(int i, int i2) {
        notifyGroupRangeInserted(i, i2);
    }

    public void notifyGroupRangeInserted(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(new wf(hasHeader(i3), hasFooter(i3), getChildrenCount(i3)));
        }
        if (i < this.mStructures.size()) {
            this.mStructures.addAll(i, arrayList);
        } else {
            this.mStructures.addAll(arrayList);
            i = this.mStructures.size() - arrayList.size();
        }
        int countGroupRangeItem = countGroupRangeItem(0, i);
        int countGroupRangeItem2 = countGroupRangeItem(i, i2);
        if (countGroupRangeItem2 > 0) {
            notifyItemRangeInserted(countGroupRangeItem, countGroupRangeItem2);
            notifyItemRangeChanged(countGroupRangeItem2 + countGroupRangeItem, getItemCount() - countGroupRangeItem);
        }
    }

    @Deprecated
    public void insertHeader(int i) {
        notifyHeaderInserted(i);
    }

    public void notifyHeaderInserted(int i) {
        if (i < this.mStructures.size() && getPositionForGroupHeader(i) < 0) {
            this.mStructures.get(i).f2572O000000o = true;
            int countGroupRangeItem = countGroupRangeItem(0, i);
            notifyItemInserted(countGroupRangeItem);
            notifyItemRangeChanged(countGroupRangeItem + 1, getItemCount() - countGroupRangeItem);
        }
    }

    @Deprecated
    public void insertFooter(int i) {
        notifyFooterInserted(i);
    }

    public void notifyFooterInserted(int i) {
        if (i < this.mStructures.size() && getPositionForGroupFooter(i) < 0) {
            this.mStructures.get(i).O00000Oo = true;
            int countGroupRangeItem = countGroupRangeItem(0, i + 1);
            notifyItemInserted(countGroupRangeItem);
            notifyItemRangeChanged(countGroupRangeItem + 1, getItemCount() - countGroupRangeItem);
        }
    }

    @Deprecated
    public void insertChild(int i, int i2) {
        notifyChildInserted(i, i2);
    }

    public void notifyChildInserted(int i, int i2) {
        if (i < this.mStructures.size()) {
            wf wfVar = this.mStructures.get(i);
            int positionForChild = getPositionForChild(i, i2);
            if (positionForChild < 0) {
                positionForChild = wfVar.O00000o0 + countGroupRangeItem(0, i) + (wfVar.f2572O000000o ? 1 : 0);
            }
            wfVar.O00000o0++;
            notifyItemInserted(positionForChild);
            notifyItemRangeChanged(positionForChild + 1, getItemCount() - positionForChild);
        }
    }

    @Deprecated
    public void insertRangeChild(int i, int i2, int i3) {
        notifyChildRangeInserted(i, i2, i3);
    }

    public void notifyChildRangeInserted(int i, int i2, int i3) {
        if (i < this.mStructures.size()) {
            int countGroupRangeItem = countGroupRangeItem(0, i);
            wf wfVar = this.mStructures.get(i);
            if (wfVar.f2572O000000o) {
                countGroupRangeItem++;
            }
            if (i2 >= wfVar.O00000o0) {
                i2 = wfVar.O00000o0;
            }
            int i4 = countGroupRangeItem + i2;
            if (i3 > 0) {
                wfVar.O00000o0 += i3;
                notifyItemRangeInserted(i4, i3);
                notifyItemRangeChanged(i3 + i4, getItemCount() - i4);
            }
        }
    }

    @Deprecated
    public void insertChildren(int i) {
        notifyChildrenInserted(i);
    }

    public void notifyChildrenInserted(int i) {
        if (i < this.mStructures.size()) {
            int countGroupRangeItem = countGroupRangeItem(0, i);
            wf wfVar = this.mStructures.get(i);
            if (wfVar.f2572O000000o) {
                countGroupRangeItem++;
            }
            int childrenCount = getChildrenCount(i);
            if (childrenCount > 0) {
                wfVar.O00000o0 = childrenCount;
                notifyItemRangeInserted(countGroupRangeItem, childrenCount);
                notifyItemRangeChanged(childrenCount + countGroupRangeItem, getItemCount() - countGroupRangeItem);
            }
        }
    }

    public void setOnHeaderClickListener(O00000o o00000o) {
        this.mOnHeaderClickListener = o00000o;
    }

    public void setOnFooterClickListener(O00000o0 o00000o0) {
        this.mOnFooterClickListener = o00000o0;
    }

    public void setOnChildClickListener(O00000Oo o00000Oo) {
        this.mOnChildClickListener = o00000Oo;
    }

    class O000000o extends RecyclerView.O00000o0 {
        O000000o() {
        }

        public final void onChanged() {
            GroupedRecyclerViewAdapter.this.isDataChanged = true;
        }

        public final void onItemRangeChanged(int i, int i2) {
            GroupedRecyclerViewAdapter.this.isDataChanged = true;
        }

        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }

        public final void onItemRangeInserted(int i, int i2) {
            GroupedRecyclerViewAdapter.this.isDataChanged = true;
        }

        public final void onItemRangeRemoved(int i, int i2) {
            GroupedRecyclerViewAdapter.this.isDataChanged = true;
        }
    }
}
