package com.xiaomi.mico.common.adapter;

import android.view.ViewGroup;
import com.xiaomi.mico.api.model.GetPurchasedRecordResponse;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.music.adapter.LovableAdapter;
import com.xiaomi.mico.music.viewholder.DefaultViewHolder;

public class PurchasedRecordAdapter extends LovableAdapter<ItemClickableAdapter.ViewHolder, GetPurchasedRecordResponse.PurchasedItem> {
    public ItemClickableAdapter.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        return new DefaultViewHolder.Lovable(viewGroup, this.onItemClickListener, null);
    }

    public void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        super.onBindItemViewHolder(viewHolder, i);
        ((DefaultViewHolder.Lovable) viewHolder).bindViewV2((GetPurchasedRecordResponse.PurchasedItem) getData(i), "");
    }
}
