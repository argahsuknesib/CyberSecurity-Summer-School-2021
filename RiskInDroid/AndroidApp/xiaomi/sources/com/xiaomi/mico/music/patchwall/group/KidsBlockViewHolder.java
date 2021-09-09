package com.xiaomi.mico.music.patchwall.group;

import _m_j.gpc;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.music.patchwall.adapter.KidsBlockAdapter;
import com.xiaomi.mico.music.patchwall.decor.SpacingItemDecoration;
import com.xiaomi.smarthome.R;

public class KidsBlockViewHolder extends ItemClickableAdapter.ViewHolder {
    private KidsBlockAdapter blockAdapter;
    private GridLayoutManager layoutManager;
    RecyclerView recyclerView;
    private SpacingItemDecoration spacingItemDecoration;
    private int spanCount;

    public KidsBlockViewHolder(View view) {
        super(view, null);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.mico_patchwall_block);
    }

    public void bindView(PatchWall.Block block) {
        if (this.blockAdapter == null) {
            this.spanCount = block.blockUiType.columns;
            this.layoutManager = new GridLayoutManager(this.itemView.getContext(), this.spanCount);
            this.spacingItemDecoration = new SpacingItemDecoration(this.spanCount, this.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.mico_common_space_decoration), false, gpc.O00000o0(this.itemView.getContext(), 6.0f));
            this.blockAdapter = new KidsBlockAdapter(this.itemView.getContext(), "");
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
