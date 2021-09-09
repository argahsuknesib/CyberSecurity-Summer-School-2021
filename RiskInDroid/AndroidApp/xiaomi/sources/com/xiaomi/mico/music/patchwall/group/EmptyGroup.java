package com.xiaomi.mico.music.patchwall.group;

import android.view.View;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;

public class EmptyGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
    public String getID() {
        return "EmptyGroup";
    }

    public int getItemViewType(int i) {
        return 10;
    }

    public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
    }

    public static class EmptyViewHolder extends ItemClickableAdapter.ViewHolder {
        public void refreshUI() {
        }

        public EmptyViewHolder(View view) {
            super(view, null);
        }
    }
}
