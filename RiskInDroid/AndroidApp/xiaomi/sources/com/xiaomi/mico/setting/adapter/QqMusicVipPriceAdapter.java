package com.xiaomi.mico.setting.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.Payment;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.setting.adapter.QqMusicVipPriceAdapter;
import com.xiaomi.smarthome.R;
import java.util.List;

public class QqMusicVipPriceAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private List<Payment.PriceItem> priceItems;
    public int selectedPosition = 1;
    private SupportContractListener supportContractListener;

    public interface SupportContractListener {
        void onSupportContractChanged(Payment.PriceItem priceItem);
    }

    public QqMusicVipPriceAdapter(SupportContractListener supportContractListener2) {
        this.supportContractListener = supportContractListener2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        double screenWidthPixels = (double) DisplayUtils.getScreenWidthPixels(viewGroup.getContext());
        Double.isNaN(screenWidthPixels);
        int i2 = (int) (0.36d * screenWidthPixels);
        if (i == 2) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.list_item_qq_music_header_view, viewGroup, false);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = viewGroup.getContext().getResources().getDimensionPixelOffset(R.dimen.size_17dp);
            inflate.setLayoutParams(layoutParams);
            return new HeaderViewHolder(inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(i == 0 ? R.layout.list_item_qq_music_vip_selected : R.layout.list_item_qq_music_vip, viewGroup, false);
        ViewGroup.LayoutParams layoutParams2 = inflate2.getLayoutParams();
        layoutParams2.height = i2;
        Double.isNaN(screenWidthPixels);
        layoutParams2.width = (int) (screenWidthPixels * 0.296d);
        inflate2.setLayoutParams(layoutParams2);
        return new ItemViewHolder(inflate2);
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 2;
        }
        return i == this.selectedPosition ? 0 : 1;
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        if (!ContainerUtil.isEmpty(this.priceItems) && i != 0) {
            ((ItemViewHolder) o000OOo0).bindView(this.priceItems.get(i), i);
        }
    }

    public int getItemCount() {
        return ContainerUtil.getSize(this.priceItems);
    }

    public void setData(List<Payment.PriceItem> list) {
        if (!ContainerUtil.isEmpty(list)) {
            this.priceItems = list;
            int i = 0;
            list.add(0, new Payment.PriceItem());
            while (true) {
                if (i >= this.priceItems.size()) {
                    break;
                } else if (list.get(i).selected) {
                    this.selectedPosition = i;
                    break;
                } else {
                    i++;
                }
            }
            notifyDataSetChanged();
            notifySupportContractStateChanged();
        }
    }

    public void startPaymentWebActivity(Activity activity) {
        if (!ContainerUtil.isEmpty(this.priceItems) && this.selectedPosition <= this.priceItems.size()) {
            this.priceItems.get(this.selectedPosition).startPaymentWebActivity(activity);
        }
    }

    class ItemViewHolder extends RecyclerView.O000OOo0 {
        protected int position;
        TextView tvMonth;
        TextView tvPrice;
        TextView tvSpecialOffer;
        TextView tvSrcPrice;

        ItemViewHolder(View view) {
            super(view);
            this.tvSpecialOffer = (TextView) view.findViewById(R.id.tvSpecialOffer);
            this.tvMonth = (TextView) view.findViewById(R.id.tvMonth);
            this.tvPrice = (TextView) view.findViewById(R.id.tvPrice);
            this.tvSrcPrice = (TextView) view.findViewById(R.id.tvSrcPrice);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.adapter.$$Lambda$QqMusicVipPriceAdapter$ItemViewHolder$7pAd3cXCvrwhtiVQTNbeuRH25M */

                public final void onClick(View view) {
                    QqMusicVipPriceAdapter.ItemViewHolder.this.lambda$new$0$QqMusicVipPriceAdapter$ItemViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$QqMusicVipPriceAdapter$ItemViewHolder(View view) {
            handleItemClick();
        }

        private void handleItemClick() {
            int i = QqMusicVipPriceAdapter.this.selectedPosition;
            QqMusicVipPriceAdapter qqMusicVipPriceAdapter = QqMusicVipPriceAdapter.this;
            qqMusicVipPriceAdapter.selectedPosition = this.position;
            qqMusicVipPriceAdapter.notifyItemChanged(i);
            QqMusicVipPriceAdapter qqMusicVipPriceAdapter2 = QqMusicVipPriceAdapter.this;
            qqMusicVipPriceAdapter2.notifyItemChanged(qqMusicVipPriceAdapter2.selectedPosition);
            QqMusicVipPriceAdapter.this.notifySupportContractStateChanged();
        }

        public void bindView(Payment.PriceItem priceItem, int i) {
            this.position = i;
            if (ContainerUtil.hasData(priceItem.subtitle)) {
                this.tvSpecialOffer.setVisibility(0);
                this.tvSpecialOffer.setText(priceItem.subtitle);
            } else {
                this.tvSpecialOffer.setVisibility(8);
            }
            this.tvMonth.setText(priceItem.shortName);
            this.tvPrice.setText(String.valueOf(priceItem.getSalePrice()));
            if (priceItem.showOriginSalePrice()) {
                this.tvSrcPrice.setVisibility(0);
                this.tvSrcPrice.setText(String.format(this.tvMonth.getContext().getString(R.string.original_price_prefix), Long.valueOf(priceItem.getOriginalSalePrice())));
                return;
            }
            this.tvSrcPrice.setVisibility(4);
        }
    }

    class HeaderViewHolder extends RecyclerView.O000OOo0 {
        HeaderViewHolder(View view) {
            super(view);
        }
    }

    public void notifySupportContractStateChanged() {
        if (this.supportContractListener != null) {
            this.supportContractListener.onSupportContractChanged(this.priceItems.get(this.selectedPosition));
        }
    }
}
