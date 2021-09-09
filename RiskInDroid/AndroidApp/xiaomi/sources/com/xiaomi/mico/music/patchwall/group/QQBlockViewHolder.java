package com.xiaomi.mico.music.patchwall.group;

import _m_j.gpc;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.music.patchwall.adapter.BlockLayoutManager;
import com.xiaomi.mico.music.patchwall.adapter.QQBlockAdapter;
import com.xiaomi.smarthome.R;

public class QQBlockViewHolder extends ItemClickableAdapter.ViewHolder {
    private QQBlockAdapter blockAdapter;
    private BlockLayoutManager layoutManager = new BlockLayoutManager();
    RecyclerView recyclerView;

    public QQBlockViewHolder(View view, RecyclerView.O000O00o o000O00o, RecyclerView.O0000Oo o0000Oo) {
        super(view, null);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.mico_patchwall_block);
        ((RecyclerView.LayoutParams) this.recyclerView.getLayoutParams()).bottomMargin = gpc.O00000o0(view.getContext(), 12.0f);
        this.recyclerView.setLayoutManager(this.layoutManager);
        if (o000O00o != null) {
            this.recyclerView.setRecycledViewPool(o000O00o);
        }
        this.recyclerView.setHasFixedSize(false);
        this.recyclerView.setItemViewCacheSize(0);
        this.recyclerView.setNestedScrollingEnabled(false);
        if (o0000Oo != null) {
            this.recyclerView.addItemDecoration(o0000Oo);
        }
    }

    public void bindView(PatchWall.Block block, int i, int i2) {
        boolean equals = "block_grid_circle".equals(block.blockUiType.name);
        boolean equals2 = "block_grid".equals(block.blockUiType.name);
        boolean z = "block_grid".equals(block.blockUiType.name) || "block_grid_circle".equals(block.blockUiType.name);
        BlockLayoutManager blockLayoutManager = this.layoutManager;
        int i3 = block.blockUiType.columns;
        float f = block.blockUiType.ratio;
        if (!z) {
            i2 = 0;
        }
        blockLayoutManager.setLayoutFrame(i3, i, f, i2);
        QQBlockAdapter qQBlockAdapter = this.blockAdapter;
        if (qQBlockAdapter == null) {
            this.blockAdapter = new QQBlockAdapter(this.itemView.getContext(), equals, equals2, z, block);
            this.recyclerView.setAdapter(this.blockAdapter);
            return;
        }
        qQBlockAdapter.updateUiTypeAndDataList(equals, equals2, z, block);
    }
}
