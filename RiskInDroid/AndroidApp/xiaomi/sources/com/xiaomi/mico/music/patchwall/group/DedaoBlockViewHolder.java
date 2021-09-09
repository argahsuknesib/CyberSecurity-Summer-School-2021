package com.xiaomi.mico.music.patchwall.group;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.music.patchwall.adapter.DedaoBlockAdapter;
import com.xiaomi.mico.music.patchwall.decor.SpacingItemDecoration;
import com.xiaomi.smarthome.R;

public class DedaoBlockViewHolder extends ItemClickableAdapter.ViewHolder {
    private DedaoBlockAdapter blockAdapter;
    private GridLayoutManager layoutManager;
    RecyclerView recyclerView;
    private SpacingItemDecoration spacingItemDecoration;
    private int spanCount;

    public DedaoBlockViewHolder(View view) {
        super(view, null);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.mico_patchwall_block);
    }

    public void bindView(PatchWall.Block block) {
        if (this.blockAdapter == null) {
            this.spanCount = block.blockUiType.columns;
            this.layoutManager = new GridLayoutManager(this.itemView.getContext(), this.spanCount);
            this.spacingItemDecoration = new SpacingItemDecoration(this.spanCount, DisplayUtils.dip2px(this.itemView.getContext(), 10.0f), false, DisplayUtils.dip2px(this.itemView.getContext(), 10.0f));
            this.blockAdapter = new DedaoBlockAdapter(this.itemView.getContext(), "block_type_dedao");
            this.recyclerView.setLayoutManager(this.layoutManager);
            this.recyclerView.addItemDecoration(this.spacingItemDecoration);
            this.recyclerView.setNestedScrollingEnabled(false);
            this.recyclerView.setItemViewCacheSize(0);
            this.recyclerView.setHasFixedSize(false);
            this.recyclerView.setAdapter(this.blockAdapter);
        } else if (this.spanCount != block.blockUiType.columns) {
            this.spanCount = block.blockUiType.columns;
            this.layoutManager.setSpanCount(this.spanCount);
            this.spacingItemDecoration.setSpanCount(this.spanCount);
            this.recyclerView.removeItemDecoration(this.spacingItemDecoration);
            this.recyclerView.addItemDecoration(this.spacingItemDecoration);
        }
        this.blockAdapter.updateUiTypeAndDataList(block);
    }
}
