package com.xiaomi.mico.music.patchwall.group;

import android.text.TextUtils;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;

public class KidsPatchWallGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
    protected final PatchWall.Block block;

    public int getItemCount() {
        return 1;
    }

    public KidsPatchWallGroup(PatchWall.Block block2) {
        this.block = block2;
    }

    public String getID() {
        return String.valueOf(this.block.id);
    }

    public int getHeaderCount() {
        return !TextUtils.isEmpty(this.block.title) ? 1 : 0;
    }

    public int getItemViewType(int i) {
        return isHeader(i) ? 1 : 13;
    }

    public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        if (isHeader(i)) {
            ((HeaderViewHolder) viewHolder).bindView(this.block);
        } else {
            ((KidsBlockViewHolder) viewHolder).bindView(this.block);
        }
    }
}
