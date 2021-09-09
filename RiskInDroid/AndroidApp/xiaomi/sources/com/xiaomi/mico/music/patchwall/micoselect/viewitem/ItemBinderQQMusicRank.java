package com.xiaomi.mico.music.patchwall.micoselect.viewitem;

import _m_j.hxi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.music.patchwall.adapter.QQRankBlockAdapter;
import com.xiaomi.mico.music.patchwall.micoselect.FloorChildClickListener;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection;
import com.xiaomi.smarthome.R;

public class ItemBinderQQMusicRank extends BaseItemBinder<QQMusicRankViewHolder> {
    public ItemBinderQQMusicRank(Context context) {
        super(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public QQMusicRankViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new QQMusicRankViewHolder(layoutInflater.inflate((int) R.layout.mico_select_view_patchwall_block_rank, viewGroup, false));
    }

    class QQMusicRankViewHolder extends BaseItemBinder.ViewHolder {
        private QQRankBlockAdapter blockAdapter;
        RecyclerView recyclerView;

        public QQMusicRankViewHolder(View view) {
            super(view);
            this.recyclerView = (RecyclerView) view.findViewById(R.id.mico_patchwall_block_rank);
            this.recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            this.recyclerView.setHasFixedSize(false);
            this.recyclerView.setItemViewCacheSize(0);
            this.recyclerView.setNestedScrollingEnabled(false);
        }

        public void updateData(ViewSection viewSection, int i) {
            QQRankBlockAdapter qQRankBlockAdapter = this.blockAdapter;
            if (qQRankBlockAdapter == null) {
                this.blockAdapter = new QQRankBlockAdapter(this.itemView.getContext(), viewSection.block, new FloorChildClickListener() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderQQMusicRank.QQMusicRankViewHolder.AnonymousClass1 */

                    public void onClick(Object obj, int i) {
                        hxi.O00000o.O000000o(i + 1, "", "", 3);
                    }
                });
                this.recyclerView.setAdapter(this.blockAdapter);
                return;
            }
            qQRankBlockAdapter.updateUiTypeAndDataList(viewSection.block);
        }
    }
}
