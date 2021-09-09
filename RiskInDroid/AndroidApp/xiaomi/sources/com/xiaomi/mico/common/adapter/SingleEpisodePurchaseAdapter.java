package com.xiaomi.mico.common.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.common.adapter.SingleEpisodePurchaseAdapter;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.widget.SingleEpisodePurchaseHelper;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class SingleEpisodePurchaseAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    public SingleEpisodePurchaseHelper.SingleEpisodePurchaseItem currentPurchaseItem;
    public OnPurchaseChoiceChangeListener purchaseChoiceChangeListener;
    private ArrayList<SingleEpisodePurchaseHelper.SingleEpisodePurchaseItem> singleEpisodePurchaseItems;

    public interface OnPurchaseChoiceChangeListener {
        void onPurchaseChoiceChange(SingleEpisodePurchaseHelper.SingleEpisodePurchaseItem singleEpisodePurchaseItem);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        int screenWidthPixels = DisplayUtils.getScreenWidthPixels(viewGroup.getContext());
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i == 0 ? R.layout.list_item_single_episode_purchase : R.layout.list_item_single_episode_purchase_selected, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        float f = (float) screenWidthPixels;
        layoutParams.height = (int) (0.1875f * f);
        layoutParams.width = (int) (f * 0.465f);
        inflate.setLayoutParams(layoutParams);
        return new ItemViewHolder(inflate);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        SingleEpisodePurchaseHelper.SingleEpisodePurchaseItem item = getItem(i);
        if (item != null) {
            ((ItemViewHolder) o000OOo0).bindView(item);
        }
    }

    public int getItemViewType(int i) {
        SingleEpisodePurchaseHelper.SingleEpisodePurchaseItem item = getItem(i);
        if (item != null && item.isSelected) {
            return 1;
        }
        return 0;
    }

    public int getItemCount() {
        int size = ContainerUtil.getSize(this.singleEpisodePurchaseItems);
        if (size == 0) {
            return 4;
        }
        return size;
    }

    public SingleEpisodePurchaseHelper.SingleEpisodePurchaseItem getItem(int i) {
        if (ContainerUtil.isEmpty(this.singleEpisodePurchaseItems) || i >= ContainerUtil.getSize(this.singleEpisodePurchaseItems)) {
            return null;
        }
        return this.singleEpisodePurchaseItems.get(i);
    }

    public void setData(ArrayList<SingleEpisodePurchaseHelper.SingleEpisodePurchaseItem> arrayList) {
        this.singleEpisodePurchaseItems = arrayList;
        if (!ContainerUtil.isEmpty(arrayList)) {
            this.currentPurchaseItem = arrayList.get(0);
            this.currentPurchaseItem.isSelected = true;
            notifyDataSetChanged();
        }
    }

    public SingleEpisodePurchaseHelper.SingleEpisodePurchaseItem getCurrentPurchaseItem() {
        return this.currentPurchaseItem;
    }

    class ItemViewHolder extends RecyclerView.O000OOo0 {
        private SingleEpisodePurchaseHelper.SingleEpisodePurchaseItem singleEpisodePurchaseItem;
        TextView tvEpisodeCount;
        TextView tvPrice;

        ItemViewHolder(View view) {
            super(view);
            this.tvEpisodeCount = (TextView) view.findViewById(R.id.tvEpisodeCount);
            this.tvPrice = (TextView) view.findViewById(R.id.tvPrice);
            view.findViewById(R.id.itemRoot).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.common.adapter.$$Lambda$SingleEpisodePurchaseAdapter$ItemViewHolder$CBTINkoMdEo1GgVi8x9N6KRAr8 */

                public final void onClick(View view) {
                    SingleEpisodePurchaseAdapter.ItemViewHolder.this.lambda$new$0$SingleEpisodePurchaseAdapter$ItemViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$SingleEpisodePurchaseAdapter$ItemViewHolder(View view) {
            onClick();
        }

        /* access modifiers changed from: package-private */
        public void onClick() {
            if (SingleEpisodePurchaseAdapter.this.currentPurchaseItem != null && this.singleEpisodePurchaseItem != null && !SingleEpisodePurchaseAdapter.this.currentPurchaseItem.equals(this.singleEpisodePurchaseItem)) {
                SingleEpisodePurchaseAdapter.this.currentPurchaseItem.isSelected = false;
                SingleEpisodePurchaseAdapter singleEpisodePurchaseAdapter = SingleEpisodePurchaseAdapter.this;
                singleEpisodePurchaseAdapter.currentPurchaseItem = this.singleEpisodePurchaseItem;
                singleEpisodePurchaseAdapter.currentPurchaseItem.isSelected = true;
                if (SingleEpisodePurchaseAdapter.this.purchaseChoiceChangeListener != null) {
                    SingleEpisodePurchaseAdapter.this.purchaseChoiceChangeListener.onPurchaseChoiceChange(SingleEpisodePurchaseAdapter.this.currentPurchaseItem);
                }
                SingleEpisodePurchaseAdapter.this.notifyDataSetChanged();
            }
        }

        public void bindView(SingleEpisodePurchaseHelper.SingleEpisodePurchaseItem singleEpisodePurchaseItem2) {
            this.singleEpisodePurchaseItem = singleEpisodePurchaseItem2;
            this.tvEpisodeCount.setText(singleEpisodePurchaseItem2.purchaseCount);
            this.tvPrice.setText(singleEpisodePurchaseItem2.purchasePriceStr);
        }
    }

    public void setOnPurchaseChoiceChangeListener(OnPurchaseChoiceChangeListener onPurchaseChoiceChangeListener) {
        this.purchaseChoiceChangeListener = onPurchaseChoiceChangeListener;
    }
}
