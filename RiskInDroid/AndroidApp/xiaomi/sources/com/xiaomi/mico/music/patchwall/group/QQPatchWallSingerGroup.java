package com.xiaomi.mico.music.patchwall.group;

import _m_j.gpc;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.itemdecoration.GridSpacingItemDecoration;
import com.xiaomi.mico.music.patchwall.adapter.QQSingerBlockAdapter;
import com.xiaomi.smarthome.R;

public class QQPatchWallSingerGroup extends PatchWallGroup {
    public QQPatchWallSingerGroup(PatchWall.Block block, int i, int i2) {
        super(block, i, i2);
    }

    public int getItemViewType(int i) {
        return isHeader(i) ? 4 : 9;
    }

    public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        if (isHeader(i)) {
            ((QQHeaderViewHolder) viewHolder).bindView(this.block);
        } else if (viewHolder instanceof QQSingerBlockViewHolder) {
            ((QQSingerBlockViewHolder) viewHolder).bindView(this.block, this.rows, this.textHeight);
        }
    }

    public static class QQSingerBlockViewHolder extends ItemClickableAdapter.ViewHolder {
        private QQSingerBlockAdapter blockAdapter;
        RecyclerView recyclerView;
        private int spacing;

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void
         arg types: [android.content.Context, int, int, int]
         candidates:
          androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, android.util.AttributeSet, int, int):void
          androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void */
        public QQSingerBlockViewHolder(View view) {
            super(view, null);
            this.recyclerView = (RecyclerView) view.findViewById(R.id.mico_patchwall_block);
            this.spacing = gpc.O00000o0(view.getContext(), 12.0f);
            this.recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 3, 1, false));
            this.recyclerView.setHasFixedSize(false);
            this.recyclerView.setItemViewCacheSize(0);
            this.recyclerView.setNestedScrollingEnabled(false);
            this.recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, this.spacing, false));
        }

        /* access modifiers changed from: package-private */
        public void bindView(PatchWall.Block block, int i, int i2) {
            QQSingerBlockAdapter qQSingerBlockAdapter = this.blockAdapter;
            if (qQSingerBlockAdapter == null) {
                this.blockAdapter = new QQSingerBlockAdapter(this.itemView.getContext(), block);
                this.recyclerView.setAdapter(this.blockAdapter);
                return;
            }
            qQSingerBlockAdapter.updateUiTypeAndDataList(block);
        }
    }
}
