package com.xiaomi.mico.common.recyclerview.adapter;

import android.view.View;
import android.widget.CheckBox;
import com.xiaomi.mico.common.editorbar.ActionMenu;
import com.xiaomi.mico.common.editorbar.EditorBar;
import com.xiaomi.mico.common.editorbar.Selector;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter.ViewHolder;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class EditableAdapter<VH extends ItemClickableAdapter.ViewHolder, T> extends SingleAdapter<VH, T> implements Selector {
    private EditorBar editorBar;
    public List<Integer> selectedPositions = new ArrayList();
    private boolean unLongClickable;

    public EditableAdapter(final EditorBar editorBar2, final ActionMenu.MenuCallback menuCallback) {
        this.editorBar = editorBar2;
        if (menuCallback != null) {
            this.onItemLongClickListener = new ItemClickableAdapter.OnItemLongClickListener() {
                /* class com.xiaomi.mico.common.recyclerview.adapter.EditableAdapter.AnonymousClass1 */

                public void onItemLongClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
                    if (editorBar2.isCanEdit() && EditableAdapter.this.getDataSize() > 0) {
                        if (i > 0) {
                            EditableAdapter.this.selectedPositions.add(Integer.valueOf(i));
                        }
                        editorBar2.startAction(menuCallback);
                    }
                }
            };
        }
    }

    public void setOnItemLongClickListener(ItemClickableAdapter.OnItemLongClickListener onItemLongClickListener) {
        throw new IllegalStateException("Must not call setOnItemLongClickListener for EditableAdapter");
    }

    public void addDataList(List<T> list) {
        super.addDataList(list);
        if (this.editorBar.isInEditorMode()) {
            notifyCountChange();
        }
    }

    public void onActionStarted() {
        notifyDataSetChanged();
    }

    public void onActionFinished() {
        this.selectedPositions.clear();
        notifyDataSetChanged();
    }

    public int getTotalCount() {
        return getDataSize();
    }

    public int getSelectedCount() {
        return this.selectedPositions.size();
    }

    public void selectAll() {
        this.selectedPositions.clear();
        for (int i = 0; i < getItemCount(); i++) {
            if (!isHeaderByPosition(i)) {
                this.selectedPositions.add(Integer.valueOf(i));
            }
        }
        notifyCountChange();
        notifyDataSetChanged();
    }

    public void selectNone() {
        this.selectedPositions.clear();
        notifyCountChange();
        notifyDataSetChanged();
    }

    public List<Integer> getSelectedPositions() {
        List<Integer> list = this.selectedPositions;
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.selectedPositions.size());
        arrayList.addAll(this.selectedPositions);
        return arrayList;
    }

    public void removeSelectedPositions(List<Integer> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Integer intValue : list) {
            arrayList.add(getData(intValue.intValue()));
        }
        this.dataList.removeAll(arrayList);
        notifyDataSetChanged();
    }

    public void notifyCountChange() {
        this.editorBar.onCountChange(getSelectedCount(), getTotalCount());
    }

    /* access modifiers changed from: protected */
    public void onBindItemViewHolder(VH vh, int i) {
        super.onBindItemViewHolder(vh, i);
        ItemViewHolder itemViewHolder = (ItemViewHolder) vh;
        itemViewHolder.bindView(this.editorBar.isInEditorMode(), this.selectedPositions.contains(Integer.valueOf(i)));
        if (this.editorBar.isInEditorMode()) {
            itemViewHolder.registerClickEvents(new ItemClickableAdapter.OnItemClickListener() {
                /* class com.xiaomi.mico.common.recyclerview.adapter.EditableAdapter.AnonymousClass2 */

                public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
                    CheckBox checkBox = ((ItemViewHolder) viewHolder).checkBox;
                    if (EditableAdapter.this.selectedPositions.contains(Integer.valueOf(i))) {
                        EditableAdapter.this.selectedPositions.remove(Integer.valueOf(i));
                        checkBox.setChecked(false);
                    } else {
                        EditableAdapter.this.selectedPositions.add(Integer.valueOf(i));
                        checkBox.setChecked(true);
                    }
                    EditableAdapter.this.notifyCountChange();
                }
            }, null);
        } else {
            itemViewHolder.registerClickEvents(this.onItemClickListener, this.onItemLongClickListener);
        }
    }

    public static class ItemViewHolder extends ItemClickableAdapter.ViewHolder {
        CheckBox checkBox;

        public ItemViewHolder(View view, ItemClickableAdapter.OnItemClickListener onItemClickListener) {
            super(view, onItemClickListener);
            this.checkBox = (CheckBox) view.findViewById(R.id.editable_item_checkbox);
        }

        /* access modifiers changed from: protected */
        public void bindView(boolean z, boolean z2) {
            if (z) {
                this.checkBox.setVisibility(0);
                this.checkBox.setChecked(z2);
                return;
            }
            this.checkBox.setVisibility(8);
        }

        /* access modifiers changed from: package-private */
        public void registerClickEvents(ItemClickableAdapter.OnItemClickListener onItemClickListener, ItemClickableAdapter.OnItemLongClickListener onItemLongClickListener) {
            registerItemClickEvent(onItemClickListener);
            registerItemLongClickEvent(onItemLongClickListener);
        }
    }

    public void setUnLongClickable(boolean z) {
        this.unLongClickable = z;
    }
}
