package com.xiaomi.mico.common.recyclerview.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter.ViewHolder;
import com.xiaomi.mico.common.util.RxUtil;
import rx.Subscription;
import rx.functions.Action1;

public abstract class ItemClickableAdapter<VH extends ViewHolder> extends RecyclerView.O000000o<VH> {
    protected OnItemClickListener onItemClickListener;
    protected OnItemLongClickListener onItemLongClickListener;

    public interface OnItemClickListener {
        void onItemClick(ViewHolder viewHolder, int i);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(ViewHolder viewHolder, int i);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener2) {
        this.onItemLongClickListener = onItemLongClickListener2;
    }

    public OnItemLongClickListener getOnItemLongClickListener() {
        return this.onItemLongClickListener;
    }

    public static class ViewHolder extends RecyclerView.O000OOo0 {
        private Subscription clickSubscription;
        private Subscription longClickSubscription;

        public ViewHolder(View view, OnItemClickListener onItemClickListener) {
            this(view, onItemClickListener, null);
        }

        public ViewHolder(View view, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
            super(view);
            ButterKnife.bind(this, view);
            registerItemClickEvent(onItemClickListener);
            registerItemLongClickEvent(onItemLongClickListener);
        }

        public void registerItemClickEvent(final OnItemClickListener onItemClickListener) {
            Subscription subscription = this.clickSubscription;
            if (subscription != null && !subscription.isUnsubscribed()) {
                this.clickSubscription.unsubscribe();
                this.clickSubscription = null;
            }
            if (onItemClickListener != null) {
                this.clickSubscription = RxUtil.debounceClick(this.itemView, new Action1<Void>() {
                    /* class com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter.ViewHolder.AnonymousClass1 */

                    public void call(Void voidR) {
                        OnItemClickListener onItemClickListener = onItemClickListener;
                        ViewHolder viewHolder = ViewHolder.this;
                        onItemClickListener.onItemClick(viewHolder, ((Integer) viewHolder.itemView.getTag()).intValue());
                    }
                });
            }
        }

        public void registerItemLongClickEvent(final OnItemLongClickListener onItemLongClickListener) {
            Subscription subscription = this.longClickSubscription;
            if (subscription != null && !subscription.isUnsubscribed()) {
                this.longClickSubscription.unsubscribe();
                this.longClickSubscription = null;
            }
            if (onItemLongClickListener != null) {
                this.longClickSubscription = RxUtil.debounceLongClick(this.itemView, new Action1<Void>() {
                    /* class com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter.ViewHolder.AnonymousClass2 */

                    public void call(Void voidR) {
                        OnItemLongClickListener onItemLongClickListener = onItemLongClickListener;
                        ViewHolder viewHolder = ViewHolder.this;
                        onItemLongClickListener.onItemLongClick(viewHolder, ((Integer) viewHolder.itemView.getTag()).intValue());
                    }
                });
            }
        }

        /* access modifiers changed from: protected */
        public void bindView(int i) {
            this.itemView.setTag(Integer.valueOf(i));
        }
    }
}
