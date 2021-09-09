package com.xiaomi.mico.common.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.common.adapter.MiCoinPriceAdapter;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.music.PaymentWebActivity;
import com.xiaomi.smarthome.R;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MiCoinPriceAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private final ArrayList<PriceItem> priceItems;
    public int selectedPosition = 0;

    public class ItemViewHolder_ViewBinding implements Unbinder {
        private ItemViewHolder target;

        public ItemViewHolder_ViewBinding(ItemViewHolder itemViewHolder, View view) {
            this.target = itemViewHolder;
            itemViewHolder.tvCount = (TextView) Utils.findRequiredViewAsType(view, R.id.mico_tvCount, "field 'tvCount'", TextView.class);
            itemViewHolder.tvPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.mico_tvPrice, "field 'tvPrice'", TextView.class);
        }

        public void unbind() {
            ItemViewHolder itemViewHolder = this.target;
            if (itemViewHolder != null) {
                this.target = null;
                itemViewHolder.tvCount = null;
                itemViewHolder.tvPrice = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public MiCoinPriceAdapter(Context context) {
        this.priceItems = PriceItem.getPriceItems(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i == 0 ? R.layout.mico_list_item_mi_coin_selected : R.layout.mico_list_item_mi_coin_normal, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        double screenWidthPixels = (double) DisplayUtils.getScreenWidthPixels(inflate.getContext());
        Double.isNaN(screenWidthPixels);
        layoutParams.width = (int) (0.31d * screenWidthPixels);
        Double.isNaN(screenWidthPixels);
        layoutParams.height = (int) (screenWidthPixels * 0.2d);
        inflate.setLayoutParams(layoutParams);
        return new ItemViewHolder(inflate);
    }

    public int getItemViewType(int i) {
        return i == this.selectedPosition ? 0 : 1;
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        if (!ContainerUtil.isEmpty(this.priceItems)) {
            ((ItemViewHolder) o000OOo0).bindView(this.priceItems.get(i), i);
        }
    }

    public int getItemCount() {
        return ContainerUtil.getSize(this.priceItems);
    }

    public void startPaymentWebActivity(Activity activity) {
        this.priceItems.get(this.selectedPosition).startPaymentWebActivity(activity);
    }

    class ItemViewHolder extends RecyclerView.O000OOo0 {
        protected int position;
        @BindView(6594)
        TextView tvCount;
        @BindView(6595)
        TextView tvPrice;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.common.adapter.$$Lambda$MiCoinPriceAdapter$ItemViewHolder$ws6i10vzccly9YMItpLUeVaDBA */

                public final void onClick(View view) {
                    MiCoinPriceAdapter.ItemViewHolder.this.lambda$new$0$MiCoinPriceAdapter$ItemViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$MiCoinPriceAdapter$ItemViewHolder(View view) {
            handleItemClick();
        }

        private void handleItemClick() {
            int i = MiCoinPriceAdapter.this.selectedPosition;
            MiCoinPriceAdapter miCoinPriceAdapter = MiCoinPriceAdapter.this;
            miCoinPriceAdapter.selectedPosition = this.position;
            miCoinPriceAdapter.notifyItemChanged(i);
            MiCoinPriceAdapter miCoinPriceAdapter2 = MiCoinPriceAdapter.this;
            miCoinPriceAdapter2.notifyItemChanged(miCoinPriceAdapter2.selectedPosition);
        }

        public void bindView(PriceItem priceItem, int i) {
            this.position = i;
            this.tvPrice.setText(priceItem.salePrice);
            this.tvCount.setText(priceItem.coinCount);
        }
    }

    public static class PriceItem {
        String coinCount;
        private long rechargeFee;
        String salePrice;

        @SuppressLint({"StringFormatInvalid"})
        PriceItem(Context context, long j) {
            this.coinCount = getFormatMiCoin(j);
            this.salePrice = String.format(context.getString(R.string.single_episode_purchase_yuan), Long.valueOf(j));
            this.rechargeFee = j * 100;
        }

        public static String getFormatMiCoin(long j) {
            return new DecimalFormat("##0.00").format(j);
        }

        public static String getFormatMiCoin(float f) {
            return new DecimalFormat("##0.00").format((double) f);
        }

        static ArrayList<PriceItem> getPriceItems(Context context) {
            ArrayList<PriceItem> arrayList = new ArrayList<>();
            arrayList.add(new PriceItem(context, 3));
            arrayList.add(new PriceItem(context, 6));
            arrayList.add(new PriceItem(context, 30));
            arrayList.add(new PriceItem(context, 60));
            arrayList.add(new PriceItem(context, 108));
            arrayList.add(new PriceItem(context, 208));
            return arrayList;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
         arg types: [java.lang.String, int]
         candidates:
          ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
        /* access modifiers changed from: package-private */
        public void startPaymentWebActivity(Activity activity) {
            Intent intent = new Intent(activity, PaymentWebActivity.class);
            intent.putExtra("common_web_title", "");
            intent.putExtra("common_web_url", getPaymentUrl());
            intent.putExtra("fullscreen", false);
            intent.addFlags(268435456);
            activity.startActivity(intent);
        }

        private String getPaymentUrl() {
            Uri.Builder appendQueryParameter = Uri.parse(ApiConstants.isPrevEnv() ? "https://preview-payment.mina.mi.com" : "https://payment.api.mina.mi.com").buildUpon().appendEncodedPath("/payment/micoin/recharge/index").appendQueryParameter("fee", String.valueOf(this.rechargeFee));
            if (ApiConstants.isPrevEnv()) {
                appendQueryParameter.appendQueryParameter("environment", "1");
            }
            return appendQueryParameter.build().toString();
        }
    }
}
