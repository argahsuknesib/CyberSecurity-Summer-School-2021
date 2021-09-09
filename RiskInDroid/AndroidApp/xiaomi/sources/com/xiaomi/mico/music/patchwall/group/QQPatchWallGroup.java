package com.xiaomi.mico.music.patchwall.group;

import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;

public class QQPatchWallGroup extends PatchWallGroup {
    public QQPatchWallGroup(PatchWall.Block block, int i, int i2) {
        super(block, i, i2);
    }

    public int getItemViewType(int i) {
        return isHeader(i) ? 4 : 7;
    }

    public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        if (isHeader(i)) {
            ((QQHeaderViewHolder) viewHolder).bindView(this.block);
        } else if (viewHolder instanceof QQBlockViewHolder) {
            ((QQBlockViewHolder) viewHolder).bindView(this.block, this.rows, this.textHeight);
        } else {
            super.onBindViewHolder(viewHolder, i);
        }
    }
}
