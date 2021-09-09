package com.xiaomi.mico.music.patchwall.micoselect.viewitem;

import _m_j.hxi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.music.patchwall.adapter.DedaoBlockAdapter;
import com.xiaomi.mico.music.patchwall.decor.SpacingItemDecoration;
import com.xiaomi.mico.music.patchwall.micoselect.FloorChildClickListener;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection;
import com.xiaomi.smarthome.R;

public class ItemBinderDedao extends BaseItemBinder<CommonViewHolder> {
    public DedaoBlockAdapter blockAdapter;
    public GridLayoutManager layoutManager;
    RecyclerView recyclerView;
    public SpacingItemDecoration spacingItemDecoration;
    public int spanCount;

    public ItemBinderDedao(Context context) {
        super(context);
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
        public CommonViewHolder(View view) {
            super(view);
            ItemBinderDedao.this.recyclerView = (RecyclerView) view.findViewById(R.id.mico_patchwall_block);
        }

        public void updateData(ViewSection viewSection, int i) {
            if (ItemBinderDedao.this.blockAdapter == null) {
                ItemBinderDedao.this.spanCount = viewSection.block.blockUiType.columns;
                ItemBinderDedao.this.layoutManager = new GridLayoutManager(this.itemView.getContext(), ItemBinderDedao.this.spanCount);
                ItemBinderDedao itemBinderDedao = ItemBinderDedao.this;
                itemBinderDedao.spacingItemDecoration = new SpacingItemDecoration(itemBinderDedao.spanCount, DisplayUtils.dip2px(this.itemView.getContext(), 10.0f), false, DisplayUtils.dip2px(this.itemView.getContext(), 10.0f));
                ItemBinderDedao.this.blockAdapter = new DedaoBlockAdapter(this.itemView.getContext(), "block_type_dedao", new FloorChildClickListener() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderDedao.CommonViewHolder.AnonymousClass1 */

                    public void onClick(Object obj, int i) {
                        hxi.O00000o.O000000o(i + 1, "", "", 6);
                    }
                });
                ItemBinderDedao.this.recyclerView.setLayoutManager(ItemBinderDedao.this.layoutManager);
                ItemBinderDedao.this.recyclerView.addItemDecoration(ItemBinderDedao.this.spacingItemDecoration);
                ItemBinderDedao.this.recyclerView.setNestedScrollingEnabled(false);
                ItemBinderDedao.this.recyclerView.setItemViewCacheSize(0);
                ItemBinderDedao.this.recyclerView.setHasFixedSize(false);
                ItemBinderDedao.this.recyclerView.setAdapter(ItemBinderDedao.this.blockAdapter);
            } else if (ItemBinderDedao.this.spanCount != viewSection.block.blockUiType.columns) {
                ItemBinderDedao.this.spanCount = viewSection.block.blockUiType.columns;
                ItemBinderDedao.this.layoutManager.setSpanCount(ItemBinderDedao.this.spanCount);
                ItemBinderDedao.this.spacingItemDecoration.setSpanCount(ItemBinderDedao.this.spanCount);
                ItemBinderDedao.this.recyclerView.removeItemDecoration(ItemBinderDedao.this.spacingItemDecoration);
                ItemBinderDedao.this.recyclerView.addItemDecoration(ItemBinderDedao.this.spacingItemDecoration);
            }
            ItemBinderDedao.this.blockAdapter.updateSelectUiTypeAndDataList(viewSection.block);
        }
    }
}
