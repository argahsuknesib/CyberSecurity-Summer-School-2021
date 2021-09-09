package com.mi.global.shop.activity;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.EmptyLoadingViewPlus;
import com.xiaomi.smarthome.R;

public class ReviewListAcitvity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ReviewListAcitvity f4678O000000o;

    public ReviewListAcitvity_ViewBinding(ReviewListAcitvity reviewListAcitvity, View view) {
        this.f4678O000000o = reviewListAcitvity;
        reviewListAcitvity.reviewRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.review_recycleView, "field 'reviewRecycleView'", RecyclerView.class);
        reviewListAcitvity.loading = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.loading, "field 'loading'", LinearLayout.class);
        reviewListAcitvity.emptyError = (EmptyLoadingViewPlus) Utils.findRequiredViewAsType(view, R.id.empty_error, "field 'emptyError'", EmptyLoadingViewPlus.class);
        reviewListAcitvity.llTips = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tips, "field 'llTips'", LinearLayout.class);
        reviewListAcitvity.llNoneReview = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_none_review, "field 'llNoneReview'", LinearLayout.class);
    }

    public void unbind() {
        ReviewListAcitvity reviewListAcitvity = this.f4678O000000o;
        if (reviewListAcitvity != null) {
            this.f4678O000000o = null;
            reviewListAcitvity.reviewRecycleView = null;
            reviewListAcitvity.loading = null;
            reviewListAcitvity.emptyError = null;
            reviewListAcitvity.llTips = null;
            reviewListAcitvity.llNoneReview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
