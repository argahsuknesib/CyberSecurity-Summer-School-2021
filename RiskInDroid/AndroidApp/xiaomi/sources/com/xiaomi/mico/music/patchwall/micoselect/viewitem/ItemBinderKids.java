package com.xiaomi.mico.music.patchwall.micoselect.viewitem;

import _m_j.gpc;
import _m_j.hxi;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.music.patchwall.adapter.KidsBlockAdapter;
import com.xiaomi.mico.music.patchwall.decor.SpacingItemDecoration;
import com.xiaomi.mico.music.patchwall.micoselect.FloorChildClickListener;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection;
import com.xiaomi.smarthome.R;

public class ItemBinderKids extends BaseItemBinder<KidsViewHolder> {
    String mType;

    public ItemBinderKids(Context context, String str) {
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
    public KidsViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new KidsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.mico_select_view_patchwall_block, viewGroup, false));
    }

    class KidsViewHolder extends BaseItemBinder.ViewHolder {
        private KidsBlockAdapter blockAdapter;
        private GridLayoutManager layoutManager;
        RecyclerView recyclerView;
        private SpacingItemDecoration spacingItemDecoration;
        private int spanCount;

        public KidsViewHolder(View view) {
            super(view);
            this.recyclerView = (RecyclerView) view.findViewById(R.id.mico_patchwall_block);
        }

        public void updateData(ViewSection viewSection, int i) {
            if (this.blockAdapter == null) {
                this.spanCount = viewSection.block.blockUiType.columns;
                this.layoutManager = new GridLayoutManager(this.itemView.getContext(), this.spanCount);
                this.spacingItemDecoration = new SpacingItemDecoration(this.spanCount, gpc.O00000o0(this.itemView.getContext(), 10.0f), false, gpc.O00000o0(this.itemView.getContext(), 6.0f));
                this.blockAdapter = new KidsBlockAdapter(this.itemView.getContext(), "", new FloorChildClickListener() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderKids.KidsViewHolder.AnonymousClass1 */

                    public void onClick(Object obj, int i) {
                        if (TextUtils.equals(ItemBinderKids.this.mType, "kid")) {
                            hxi.O00000o.O000000o(i + 1, "", "", 4);
                        } else {
                            TextUtils.equals(ItemBinderKids.this.mType, "uncleCassie");
                        }
                    }
                });
                this.recyclerView.setLayoutManager(this.layoutManager);
                this.recyclerView.addItemDecoration(this.spacingItemDecoration);
                this.recyclerView.setNestedScrollingEnabled(false);
                this.recyclerView.setItemViewCacheSize(0);
                this.recyclerView.setHasFixedSize(false);
                this.recyclerView.setAdapter(this.blockAdapter);
            } else if (this.spanCount != viewSection.block.blockUiType.columns) {
                this.spanCount = viewSection.block.blockUiType.columns;
                this.layoutManager.setSpanCount(this.spanCount);
                this.spacingItemDecoration.setSpanCount(this.spanCount);
                this.recyclerView.removeItemDecoration(this.spacingItemDecoration);
                this.recyclerView.addItemDecoration(this.spacingItemDecoration);
            }
            this.blockAdapter.updateUiTypeAndDataList(viewSection.block);
        }
    }
}
