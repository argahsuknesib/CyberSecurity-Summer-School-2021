package com.xiaomi.mico.music.patchwall.micoselect.viewitem;

import _m_j.hxi;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.music.patchwall.adapter.BlockAdapter;
import com.xiaomi.mico.music.patchwall.adapter.BlockItemDecoration;
import com.xiaomi.mico.music.patchwall.adapter.BlockLayoutManager;
import com.xiaomi.mico.music.patchwall.micoselect.FloorChildClickListener;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection;
import com.xiaomi.smarthome.R;
import java.util.List;

public class ItemBinderCommon extends BaseItemBinder<CommonViewHolder> {
    int mTextHeight = this.mContext.getResources().getDimensionPixelOffset(R.dimen.mico_player_music_item_height);
    String mType;

    public ItemBinderCommon(Context context, String str) {
        super(context);
        this.mType = str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public CommonViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.mico_select_view_patchwall_block, viewGroup, false);
        inflate.setFocusableInTouchMode(false);
        return new CommonViewHolder(inflate);
    }

    class CommonViewHolder extends BaseItemBinder.ViewHolder {
        private BlockAdapter blockAdapter;
        private BlockLayoutManager layoutManager = new BlockLayoutManager();
        RecyclerView recyclerView;

        public CommonViewHolder(View view) {
            super(view);
            this.recyclerView = (RecyclerView) view.findViewById(R.id.mico_patchwall_block);
            this.recyclerView.setLayoutManager(this.layoutManager);
            this.recyclerView.setHasFixedSize(true);
            this.recyclerView.setItemViewCacheSize(0);
            this.recyclerView.setNestedScrollingEnabled(false);
            int dimensionPixelOffset = view.getResources().getDimensionPixelOffset(R.dimen.mico_music_section_item_grid_padding);
            this.recyclerView.addItemDecoration(new BlockItemDecoration(dimensionPixelOffset, dimensionPixelOffset));
        }

        public void updateData(ViewSection viewSection, int i) {
            boolean equals = "block_grid_circle".equals(viewSection.block.blockUiType.name);
            int i2 = 0;
            boolean z = "block_grid".equals(viewSection.block.blockUiType.name) || "block_grid_circle".equals(viewSection.block.blockUiType.name) || "block_grid_rich".equals(viewSection.block.blockUiType.name) || "block_grid_feature".equals(viewSection.block.blockUiType.name);
            BlockLayoutManager blockLayoutManager = this.layoutManager;
            int i3 = viewSection.block.blockUiType.columns;
            int rows = ItemBinderCommon.this.getRows(viewSection.block.items);
            float f = viewSection.block.blockUiType.ratio;
            if (z) {
                i2 = ItemBinderCommon.this.mTextHeight;
            }
            blockLayoutManager.setLayoutFrame(i3, rows, f, i2);
            BlockAdapter blockAdapter2 = this.blockAdapter;
            if (blockAdapter2 == null) {
                this.blockAdapter = new BlockAdapter(this.itemView.getContext(), equals, z, viewSection.block, new FloorChildClickListener() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderCommon.CommonViewHolder.AnonymousClass1 */

                    public void onClick(Object obj, int i) {
                        if (TextUtils.equals(ItemBinderCommon.this.mType, "audioBook")) {
                            hxi.O00000o.O000000o(i + 1, "", "", 5);
                        } else {
                            TextUtils.equals(ItemBinderCommon.this.mType, "miMusic");
                        }
                    }
                });
                this.recyclerView.setAdapter(this.blockAdapter);
                return;
            }
            blockAdapter2.updateUiTypeAndDataList(equals, z, viewSection.block);
        }
    }

    public int getRows(List<PatchWall.Item> list) {
        PatchWall.Item item = list.get(list.size() - 1);
        return item.itemUiType.pos.y + item.itemUiType.pos.h;
    }
}
