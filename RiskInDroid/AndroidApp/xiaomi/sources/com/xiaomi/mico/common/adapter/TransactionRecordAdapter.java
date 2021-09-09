package com.xiaomi.mico.common.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.mico.api.model.Payment;
import com.xiaomi.mico.common.adapter.TransactionRecordAdapter;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.smarthome.R;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import rx.functions.Action1;

public class TransactionRecordAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private ArrayList<Payment.TransactionRecordItem> transactionRecordItems = new ArrayList<>();

    public interface ViewHolderInterface {
        void bindView(Payment.TransactionRecordItem transactionRecordItem);
    }

    public class RechargeItemViewHolder_ViewBinding implements Unbinder {
        private RechargeItemViewHolder target;

        public RechargeItemViewHolder_ViewBinding(RechargeItemViewHolder rechargeItemViewHolder, View view) {
            this.target = rechargeItemViewHolder;
            rechargeItemViewHolder.time = (TextView) Utils.findRequiredViewAsType(view, R.id.pay_time, "field 'time'", TextView.class);
            rechargeItemViewHolder.tvTransactionPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTransactionPrice, "field 'tvTransactionPrice'", TextView.class);
        }

        public void unbind() {
            RechargeItemViewHolder rechargeItemViewHolder = this.target;
            if (rechargeItemViewHolder != null) {
                this.target = null;
                rechargeItemViewHolder.time = null;
                rechargeItemViewHolder.tvTransactionPrice = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class ItemViewHolder_ViewBinding implements Unbinder {
        private ItemViewHolder target;

        public ItemViewHolder_ViewBinding(ItemViewHolder itemViewHolder, View view) {
            this.target = itemViewHolder;
            itemViewHolder.name = (TextView) Utils.findRequiredViewAsType(view, R.id.product_name, "field 'name'", TextView.class);
            itemViewHolder.time = (TextView) Utils.findRequiredViewAsType(view, R.id.pay_time, "field 'time'", TextView.class);
            itemViewHolder.tvTransactionPrice = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTransactionPrice, "field 'tvTransactionPrice'", TextView.class);
            itemViewHolder.cover = (ImageView) Utils.findRequiredViewAsType(view, R.id.cover, "field 'cover'", ImageView.class);
        }

        public void unbind() {
            ItemViewHolder itemViewHolder = this.target;
            if (itemViewHolder != null) {
                this.target = null;
                itemViewHolder.name = null;
                itemViewHolder.time = null;
                itemViewHolder.tvTransactionPrice = null;
                itemViewHolder.cover = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(z ? R.layout.mico_list_item_transaction_record : R.layout.mico_list_item_transaction_record_recharge, viewGroup, false);
        return z ? new ItemViewHolder(inflate) : new RechargeItemViewHolder(inflate);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        if (!ContainerUtil.isEmpty(this.transactionRecordItems)) {
            ((ViewHolderInterface) o000OOo0).bindView(this.transactionRecordItems.get(i));
        }
    }

    public int getItemCount() {
        return ContainerUtil.getSize(this.transactionRecordItems);
    }

    public int getItemViewType(int i) {
        if (!ContainerUtil.isEmpty(this.transactionRecordItems) && !this.transactionRecordItems.get(i).isRecharge()) {
            return 1;
        }
        return 0;
    }

    public void addData(ArrayList<Payment.TransactionRecordItem> arrayList) {
        this.transactionRecordItems.addAll(arrayList);
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.O000OOo0 implements ViewHolderInterface {
        @BindView(6062)
        ImageView cover;
        @BindView(6844)
        TextView name;
        @BindView(6780)
        TextView time;
        @BindView(7309)
        TextView tvTransactionPrice;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @SuppressLint({"DefaultLocale"})
        public void bindView(Payment.TransactionRecordItem transactionRecordItem) {
            boolean isBalanceIncrease = transactionRecordItem.isBalanceIncrease();
            TextView textView = this.name;
            textView.setText(isBalanceIncrease ? textView.getContext().getString(R.string.common_refund) : transactionRecordItem.productName);
            String str = transactionRecordItem.pictureUrl;
            ImageView imageView = this.cover;
            MusicHelper.loadCenterCover(str, R.drawable.img_cover_default_rectangle, R.drawable.img_cover_default_rectangle, imageView, new CropSquareTransformation(imageView.getContext().getResources().getDimensionPixelOffset(R.dimen.size_8dp)), this.cover.getContext().getResources().getDimensionPixelOffset(R.dimen.size_50dp));
            this.time.setText(updateTimeString(transactionRecordItem.timeStamp));
            this.tvTransactionPrice.setText(TransactionRecordAdapter.formatMiCoin(transactionRecordItem.getTotalFee(), isBalanceIncrease));
            TextView textView2 = this.tvTransactionPrice;
            textView2.setTextColor(textView2.getContext().getResources().getColor(isBalanceIncrease ? R.color.mj_color_red_normal : R.color.mj_color_black));
            RxUtil.debounceClick(this.itemView, new Action1(transactionRecordItem) {
                /* class com.xiaomi.mico.common.adapter.$$Lambda$TransactionRecordAdapter$ItemViewHolder$xkBPYdOBVbDHqZI8iKgEUrWquq4 */
                private final /* synthetic */ Payment.TransactionRecordItem f$1;

                {
                    this.f$1 = r2;
                }

                public final void call(Object obj) {
                    TransactionRecordAdapter.ItemViewHolder.this.lambda$bindView$0$TransactionRecordAdapter$ItemViewHolder(this.f$1, (Void) obj);
                }
            });
        }

        public /* synthetic */ void lambda$bindView$0$TransactionRecordAdapter$ItemViewHolder(Payment.TransactionRecordItem transactionRecordItem, Void voidR) {
            SchemaManager.handleSchema(this.itemView.getContext(), transactionRecordItem.action);
        }

        private String updateTimeString(long j) {
            return new SimpleDateFormat("yyyy.MM.dd HH:mm").format(new Date(j));
        }
    }

    class RechargeItemViewHolder extends RecyclerView.O000OOo0 implements ViewHolderInterface {
        @BindView(6780)
        TextView time;
        @BindView(7309)
        TextView tvTransactionPrice;

        RechargeItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            RxUtil.debounceClick(view, $$Lambda$TransactionRecordAdapter$RechargeItemViewHolder$HLgGiUAl9xgSaYJFEUbw_aedLA.INSTANCE);
        }

        @SuppressLint({"DefaultLocale"})
        public void bindView(Payment.TransactionRecordItem transactionRecordItem) {
            this.time.setText(updateTimeString(transactionRecordItem.timeStamp));
            this.tvTransactionPrice.setText(TransactionRecordAdapter.formatMiCoin(transactionRecordItem.getTotalFee(), transactionRecordItem.isBalanceIncrease()));
        }

        private String updateTimeString(long j) {
            return new SimpleDateFormat("yyyy.MM.dd HH:mm").format(new Date(j));
        }
    }

    public static String formatMiCoin(float f, boolean z) {
        return new DecimalFormat(z ? "+0.00" : "-0.00").format((double) f);
    }
}
