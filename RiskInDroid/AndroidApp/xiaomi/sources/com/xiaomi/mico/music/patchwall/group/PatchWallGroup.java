package com.xiaomi.mico.music.patchwall.group;

import android.text.TextUtils;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;

public class PatchWallGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
    protected final PatchWall.Block block;
    protected final int rows;
    protected final int textHeight;

    public int getItemCount() {
        return 1;
    }

    public PatchWallGroup(PatchWall.Block block2, int i, int i2) {
        this.block = block2;
        this.rows = i;
        this.textHeight = i2;
    }

    public String getID() {
        return String.valueOf(this.block.id);
    }

    public int getHeaderCount() {
        return !TextUtils.isEmpty(this.block.title) ? 1 : 0;
    }

    public int getItemViewType(int i) {
        return isHeader(i) ? 1 : 2;
    }

    public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        if (!isHeader(i) || !(viewHolder instanceof HeaderViewHolder)) {
            ((BlockViewHolder) viewHolder).bindView(this.block, this.rows, this.textHeight);
        } else {
            ((HeaderViewHolder) viewHolder).bindView(this.block);
        }
    }
}
