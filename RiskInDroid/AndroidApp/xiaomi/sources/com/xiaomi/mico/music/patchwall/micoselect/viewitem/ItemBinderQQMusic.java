package com.xiaomi.mico.music.patchwall.micoselect.viewitem;

import _m_j.hxi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.music.patchwall.adapter.BlockItemDecoration;
import com.xiaomi.mico.music.patchwall.adapter.BlockLayoutManager;
import com.xiaomi.mico.music.patchwall.adapter.QQBlockAdapter;
import com.xiaomi.mico.music.patchwall.micoselect.FloorChildClickListener;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection;
import com.xiaomi.smarthome.R;
import java.util.List;

public class ItemBinderQQMusic extends BaseItemBinder<QQMusicViewHolder> {
    public RecyclerView.O0000Oo mItemDecoration;
    int mQQTextHeight = (this.mContext.getResources().getDimensionPixelOffset(R.dimen.mico_player_music_item_height2) + this.mContext.getResources().getDimensionPixelOffset(R.dimen.size_8dp));

    public ItemBinderQQMusic(Context context) {
        super(context);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.mico_music_section_item_grid_padding);
        this.mItemDecoration = new BlockItemDecoration(dimensionPixelOffset, dimensionPixelOffset);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public QQMusicViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new QQMusicViewHolder(layoutInflater.inflate((int) R.layout.mico_select_view_patchwall_block, viewGroup, false));
    }

    class QQMusicViewHolder extends BaseItemBinder.ViewHolder {
        private QQBlockAdapter blockAdapter;
        private BlockLayoutManager layoutManager = new BlockLayoutManager();
        RecyclerView recyclerView;

        public QQMusicViewHolder(View view) {
            super(view);
            this.recyclerView = (RecyclerView) view.findViewById(R.id.mico_patchwall_block);
            this.recyclerView.setLayoutManager(this.layoutManager);
            this.recyclerView.setHasFixedSize(false);
            RecyclerView.O000O00o o000O00o = new RecyclerView.O000O00o();
            o000O00o.O000000o(0, 10);
            this.recyclerView.setRecycledViewPool(o000O00o);
            this.recyclerView.setItemViewCacheSize(0);
            this.recyclerView.setNestedScrollingEnabled(false);
            this.recyclerView.addItemDecoration(ItemBinderQQMusic.this.mItemDecoration);
        }

        public void updateData(ViewSection viewSection, int i) {
            boolean equals = "block_grid_circle".equals(viewSection.block.blockUiType.name);
            boolean equals2 = "block_grid".equals(viewSection.block.blockUiType.name);
            int i2 = 0;
            boolean z = "block_grid".equals(viewSection.block.blockUiType.name) || "block_grid_circle".equals(viewSection.block.blockUiType.name);
            BlockLayoutManager blockLayoutManager = this.layoutManager;
            int i3 = viewSection.block.blockUiType.columns;
            int rows = ItemBinderQQMusic.this.getRows(viewSection.block.items);
            float f = viewSection.block.blockUiType.ratio;
            if (z) {
                i2 = ItemBinderQQMusic.this.mQQTextHeight;
            }
            blockLayoutManager.setLayoutFrame(i3, rows, f, i2);
            QQBlockAdapter qQBlockAdapter = this.blockAdapter;
            if (qQBlockAdapter == null) {
                this.blockAdapter = new QQBlockAdapter(this.itemView.getContext(), equals, equals2, z, viewSection.block, new FloorChildClickListener() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderQQMusic.QQMusicViewHolder.AnonymousClass1 */

                    public void onClick(Object obj, int i) {
                        hxi.O00000o.O000000o(i + 1, "", "", 2);
                    }
                });
                this.recyclerView.setAdapter(this.blockAdapter);
                return;
            }
            qQBlockAdapter.updateUiTypeAndDataList(equals, equals2, z, viewSection.block);
        }
    }

    public int getRows(List<PatchWall.Item> list) {
        PatchWall.Item item = list.get(list.size() - 1);
        return item.itemUiType.pos.y + item.itemUiType.pos.h;
    }
}
