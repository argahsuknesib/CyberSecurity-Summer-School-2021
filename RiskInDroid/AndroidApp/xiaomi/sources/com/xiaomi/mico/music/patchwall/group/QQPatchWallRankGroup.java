package com.xiaomi.mico.music.patchwall.group;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.music.patchwall.adapter.QQRankBlockAdapter;
import com.xiaomi.smarthome.R;

public class QQPatchWallRankGroup extends PatchWallGroup {
    public QQPatchWallRankGroup(PatchWall.Block block) {
        super(block, 0, 0);
    }

    public int getItemViewType(int i) {
        return isHeader(i) ? 4 : 8;
    }

    public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        if (isHeader(i)) {
            ((QQHeaderViewHolder) viewHolder).bindView(this.block);
        } else if (viewHolder instanceof QQRankBlockViewHolder) {
            ((QQRankBlockViewHolder) viewHolder).bindView(this.block, this.rows, this.textHeight);
        }
    }

    public static class QQRankBlockViewHolder extends ItemClickableAdapter.ViewHolder {
        private QQRankBlockAdapter blockAdapter;
        RecyclerView recyclerView;

        public QQRankBlockViewHolder(View view) {
            super(view, null);
            this.recyclerView = (RecyclerView) view.findViewById(R.id.mico_patchwall_block);
            this.recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            this.recyclerView.setHasFixedSize(false);
            this.recyclerView.setItemViewCacheSize(0);
            this.recyclerView.setNestedScrollingEnabled(false);
        }

        /* access modifiers changed from: package-private */
        public void bindView(PatchWall.Block block, int i, int i2) {
            QQRankBlockAdapter qQRankBlockAdapter = this.blockAdapter;
            if (qQRankBlockAdapter == null) {
                this.blockAdapter = new QQRankBlockAdapter(this.itemView.getContext(), block);
                this.recyclerView.setAdapter(this.blockAdapter);
                return;
            }
            qQRankBlockAdapter.updateUiTypeAndDataList(block);
        }
    }
}
