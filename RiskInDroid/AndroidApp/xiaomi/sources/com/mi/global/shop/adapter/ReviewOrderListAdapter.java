package com.mi.global.shop.adapter;

import _m_j.cbq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.activity.ReviewSubmitAcitvity;
import com.mi.global.shop.model.orderreview.OrderReviewModel;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public final class ReviewOrderListAdapter extends RecyclerView.O000000o<ReviewViewHolder> {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f4752O000000o;
    public Activity O00000Oo;
    public O000000o O00000o;
    public ArrayList<OrderReviewModel.OrderReviewItemModel> O00000o0 = new ArrayList<>();

    public interface O000000o {
        void onLoadMore();
    }

    public class ReviewViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ReviewViewHolder f4755O000000o;

        public ReviewViewHolder_ViewBinding(ReviewViewHolder reviewViewHolder, View view) {
            this.f4755O000000o = reviewViewHolder;
            reviewViewHolder.ivOrder = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.iv_order, "field 'ivOrder'", SimpleDraweeView.class);
            reviewViewHolder.itemTitle = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_title, "field 'itemTitle'", CustomTextView.class);
            reviewViewHolder.itemRating = (RatingBar) Utils.findRequiredViewAsType(view, R.id.item_rating, "field 'itemRating'", RatingBar.class);
        }

        public void unbind() {
            ReviewViewHolder reviewViewHolder = this.f4755O000000o;
            if (reviewViewHolder != null) {
                this.f4755O000000o = null;
                reviewViewHolder.ivOrder = null;
                reviewViewHolder.itemTitle = null;
                reviewViewHolder.itemRating = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        O000000o o000000o;
        final ReviewViewHolder reviewViewHolder = (ReviewViewHolder) o000OOo0;
        if (i == this.O00000o0.size() - 2 && (o000000o = this.O00000o) != null) {
            o000000o.onLoadMore();
        }
        final OrderReviewModel.OrderReviewItemModel orderReviewItemModel = this.O00000o0.get(i);
        cbq.O000000o(orderReviewItemModel.goods_img, reviewViewHolder.ivOrder);
        reviewViewHolder.itemTitle.setText(orderReviewItemModel.goods_name);
        reviewViewHolder.itemRating.setRating(0.0f);
        reviewViewHolder.itemRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            /* class com.mi.global.shop.adapter.ReviewOrderListAdapter.AnonymousClass1 */

            public final void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
                if (f != 0.0f) {
                    Intent intent = new Intent(ReviewOrderListAdapter.this.f4752O000000o, ReviewSubmitAcitvity.class);
                    intent.putExtra("order_item_id", orderReviewItemModel.order_item_id);
                    intent.putExtra("goods_sku", orderReviewItemModel.goods_sku);
                    intent.putExtra("goods_name", orderReviewItemModel.goods_name);
                    intent.putExtra("goods_img", orderReviewItemModel.goods_img);
                    intent.putExtra("orderRating", f);
                    ReviewOrderListAdapter.this.O00000Oo.startActivityForResult(intent, 100);
                }
                reviewViewHolder.itemRating.setRating(0.0f);
            }
        });
        reviewViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.adapter.ReviewOrderListAdapter.AnonymousClass2 */

            public final void onClick(View view) {
                Intent intent = new Intent(ReviewOrderListAdapter.this.f4752O000000o, ReviewSubmitAcitvity.class);
                intent.putExtra("order_item_id", orderReviewItemModel.order_item_id);
                intent.putExtra("goods_sku", orderReviewItemModel.goods_sku);
                intent.putExtra("goods_name", orderReviewItemModel.goods_name);
                intent.putExtra("goods_img", orderReviewItemModel.goods_img);
                ReviewOrderListAdapter.this.O00000Oo.startActivityForResult(intent, 100);
            }
        });
    }

    public ReviewOrderListAdapter(Context context, Activity activity) {
        this.f4752O000000o = context;
        this.O00000Oo = activity;
    }

    public final int getItemCount() {
        return this.O00000o0.size();
    }

    static class ReviewViewHolder extends RecyclerView.O000OOo0 {
        @BindView(2131493521)
        RatingBar itemRating;
        @BindView(2131493523)
        CustomTextView itemTitle;
        @BindView(2131493558)
        SimpleDraweeView ivOrder;

        ReviewViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ReviewViewHolder(LayoutInflater.from(this.f4752O000000o).inflate((int) R.layout.shop_order_review_item, viewGroup, false));
    }
}
