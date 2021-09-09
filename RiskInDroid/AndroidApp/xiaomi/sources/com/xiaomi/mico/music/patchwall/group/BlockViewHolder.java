package com.xiaomi.mico.music.patchwall.group;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.music.patchwall.adapter.BlockAdapter;
import com.xiaomi.mico.music.patchwall.adapter.BlockItemDecoration;
import com.xiaomi.mico.music.patchwall.adapter.BlockLayoutManager;
import com.xiaomi.smarthome.R;

public class BlockViewHolder extends ItemClickableAdapter.ViewHolder {
    private BlockAdapter blockAdapter;
    private BlockLayoutManager layoutManager = new BlockLayoutManager();
    RecyclerView recyclerView;

    public BlockViewHolder(View view, RecyclerView.O000O00o o000O00o, RecyclerView.O0000Oo o0000Oo) {
        super(view, null);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.mico_patchwall_block);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.recyclerView.setRecycledViewPool(o000O00o);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setItemViewCacheSize(0);
        this.recyclerView.setNestedScrollingEnabled(false);
        int dimensionPixelOffset = view.getResources().getDimensionPixelOffset(R.dimen.mico_music_section_item_grid_padding);
        this.recyclerView.addItemDecoration(new BlockItemDecoration(dimensionPixelOffset, dimensionPixelOffset));
    }

    public void bindView(PatchWall.Block block, int i, int i2) {
        boolean equals = "block_grid_circle".equals(block.blockUiType.name);
        boolean z = "block_grid".equals(block.blockUiType.name) || "block_grid_circle".equals(block.blockUiType.name) || "block_grid_rich".equals(block.blockUiType.name) || "block_grid_feature".equals(block.blockUiType.name);
        BlockLayoutManager blockLayoutManager = this.layoutManager;
        int i3 = block.blockUiType.columns;
        float f = block.blockUiType.ratio;
        if (!z) {
            i2 = 0;
        }
        blockLayoutManager.setLayoutFrame(i3, i, f, i2);
        BlockAdapter blockAdapter2 = this.blockAdapter;
        if (blockAdapter2 == null) {
            this.blockAdapter = new BlockAdapter(this.itemView.getContext(), equals, z, block);
            this.recyclerView.setAdapter(this.blockAdapter);
            return;
        }
        blockAdapter2.updateUiTypeAndDataList(equals, z, block);
    }
}
