package com.xiaomi.shopviews.widget.homecoupon;

import _m_j.duh;
import _m_j.dui;
import _m_j.duj;
import _m_j.duq;
import _m_j.dur;
import _m_j.ewe;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.shopviews.model.HomeSection;
import com.xiaomi.shopviews.model.HomeSectionItem;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class HomeCouponView_11_11 extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ColorDrawable f3937O000000o = new ColorDrawable(ewe.f15881O000000o);
    private static final String O00000o0 = HomeCouponView_11_11.class.getSimpleName();
    public HomeSection O00000Oo;
    private O000000o O00000o;
    private HorizontalAdapter O00000oO;
    private ImageView O00000oo;
    private RelativeLayout O0000O0o;
    private RecyclerView O0000OOo;
    private Runnable O0000Oo0;

    public HomeCouponView_11_11(Context context) {
        super(context);
        this.O0000Oo0 = new Runnable() {
            /* class com.xiaomi.shopviews.widget.homecoupon.HomeCouponView_11_11.AnonymousClass1 */

            public final void run() {
                HomeCouponView_11_11 homeCouponView_11_11 = HomeCouponView_11_11.this;
                homeCouponView_11_11.O000000o(homeCouponView_11_11.O00000Oo);
            }
        };
        O000000o();
    }

    public HomeCouponView_11_11(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000Oo0 = new Runnable() {
            /* class com.xiaomi.shopviews.widget.homecoupon.HomeCouponView_11_11.AnonymousClass2 */

            public final void run() {
                HomeCouponView_11_11 homeCouponView_11_11 = HomeCouponView_11_11.this;
                homeCouponView_11_11.O000000o(homeCouponView_11_11.O00000Oo);
            }
        };
        O000000o();
    }

    public HomeCouponView_11_11(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Oo0 = new Runnable() {
            /* class com.xiaomi.shopviews.widget.homecoupon.HomeCouponView_11_11.AnonymousClass3 */

            public final void run() {
                HomeCouponView_11_11 homeCouponView_11_11 = HomeCouponView_11_11.this;
                homeCouponView_11_11.O000000o(homeCouponView_11_11.O00000Oo);
            }
        };
        O000000o();
    }

    private void O000000o() {
        inflate(getContext(), R.layout.listitem_home_horizontal_recycler_coupon, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.O0000OOo = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.O00000oO = new HorizontalAdapter(getContext());
        this.O0000OOo.setAdapter(this.O00000oO);
        this.O00000oo = (ImageView) findViewById(R.id.bg_image);
        this.O00000oo.getLayoutParams().height = (duq.O000000o().O00000oo * 275) / 1080;
        this.O00000oo.getLayoutParams().width = duq.O000000o().O00000oo;
        this.O0000O0o = (RelativeLayout) findViewById(R.id.list_container);
        this.O0000O0o.getLayoutParams().height = (duq.O000000o().O00000oo * 275) / 1080;
    }

    private void O00000Oo() {
        RecyclerView recyclerView = this.O0000OOo;
        if (recyclerView != null) {
            recyclerView.removeAllViews();
        }
        removeCallbacks(this.O0000Oo0);
    }

    public final void O000000o(HomeSection homeSection) {
        this.O00000Oo = homeSection;
        dui O000000o2 = duh.O000000o();
        String str = homeSection.mBody.mImageUrl;
        ImageView imageView = this.O00000oo;
        Option option = new Option();
        option.O00000o0 = f3937O000000o;
        O000000o2.O000000o(str, imageView, option);
        HorizontalAdapter horizontalAdapter = this.O00000oO;
        float f = homeSection.mBody.mTextSize;
        horizontalAdapter.f3941O000000o = homeSection.mBody.mTextColor;
        horizontalAdapter.O00000Oo = f;
        long O000000o3 = dur.O000000o(homeSection.mBody.mServerTime * 1000);
        long j = homeSection.mBody.mStartTime * 1000;
        removeCallbacks(this.O0000Oo0);
        if (O000000o3 < j || j == 0) {
            if (j != 0) {
                postDelayed(this.O0000Oo0, j - O000000o3);
            }
            O000000o(homeSection.mBody.mItems);
            return;
        }
        O000000o(homeSection.mBody.mNextItems);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O00000Oo();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        O00000Oo();
    }

    private void O000000o(ArrayList<HomeSectionItem> arrayList) {
        if (!duj.O000000o(arrayList)) {
            O000000o o000000o = this.O00000o;
            if (o000000o != null) {
                this.O0000OOo.removeItemDecoration(o000000o);
            }
            if (arrayList.size() <= 3) {
                this.O00000o = new O000000o(getContext(), 2);
            } else {
                this.O00000o = new O000000o(getContext(), 0);
            }
            this.O0000OOo.addItemDecoration(this.O00000o);
            this.O00000oO.O000000o(arrayList);
        }
    }

    static class O000000o extends RecyclerView.O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private Drawable f3943O000000o;

        public O000000o(Context context, int i) {
            if (i == 0) {
                this.f3943O000000o = context.getResources().getDrawable(R.drawable.horizontal_recycler_coupon_divider1);
            } else {
                this.f3943O000000o = context.getResources().getDrawable(R.drawable.horizontal_recycler_coupon_divider);
            }
        }

        public final void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            if (i == 0) {
                rect.set(this.f3943O000000o.getIntrinsicWidth(), 0, this.f3943O000000o.getIntrinsicWidth(), 0);
            } else {
                rect.set(0, 0, this.f3943O000000o.getIntrinsicWidth(), 0);
            }
        }
    }

    static class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f3944O000000o;
        public int O00000Oo = -1;
        public ImageView O00000o0;

        public O00000Oo(View view) {
            super(view);
            this.O00000o0 = (ImageView) view.findViewById(R.id.coupon_img);
            this.O00000o0.getLayoutParams().height = (duq.O000000o().O00000oo * 190) / 1080;
            this.f3944O000000o = (TextView) view.findViewById(R.id.text_title);
        }
    }

    static class HorizontalAdapter extends RecyclerView.O000000o<O00000Oo> {

        /* renamed from: O000000o  reason: collision with root package name */
        String f3941O000000o;
        float O00000Oo;
        private ArrayList<HomeSectionItem> O00000o = new ArrayList<>();
        private Context O00000o0;

        public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            Drawable drawable;
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            final HomeSectionItem homeSectionItem = this.O00000o.get(i);
            if (o00000Oo.O00000Oo == i) {
                drawable = o00000Oo.O00000o0.getDrawable();
            } else {
                drawable = HomeCouponView_11_11.f3937O000000o;
            }
            o00000Oo.O00000Oo = i;
            dui O000000o2 = duh.O000000o();
            String str = homeSectionItem.mImageUrl;
            ImageView imageView = o00000Oo.O00000o0;
            Option option = new Option();
            option.O00000o0 = drawable;
            O000000o2.O000000o(str, imageView, option);
            if (!TextUtils.isEmpty(homeSectionItem.mTitle)) {
                o00000Oo.f3944O000000o.setVisibility(0);
                o00000Oo.f3944O000000o.setText(Html.fromHtml(homeSectionItem.mTitle));
                if (!TextUtils.isEmpty(this.f3941O000000o)) {
                    o00000Oo.f3944O000000o.setTextColor(Color.parseColor(this.f3941O000000o));
                }
                if (this.O00000Oo > 0.0f) {
                    o00000Oo.f3944O000000o.setTextSize(1, this.O00000Oo);
                }
            } else {
                o00000Oo.f3944O000000o.setVisibility(8);
            }
            o00000Oo.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.shopviews.widget.homecoupon.HomeCouponView_11_11.HorizontalAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    HomeSectionItem homeSectionItem = homeSectionItem;
                    if (homeSectionItem != null && homeSectionItem.mCanGet && !homeSectionItem.isRequesting) {
                        homeSectionItem.isRequesting = true;
                    }
                }
            });
        }

        public HorizontalAdapter(Context context) {
            this.O00000o0 = context;
        }

        public int getItemCount() {
            return this.O00000o.size();
        }

        public final void O000000o(ArrayList<HomeSectionItem> arrayList) {
            this.O00000o.clear();
            this.O00000o.addAll(arrayList);
            notifyDataSetChanged();
        }

        public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O00000Oo(LayoutInflater.from(this.O00000o0).inflate((int) R.layout.listitem_home_horizontal_item_coupon, (ViewGroup) null));
        }
    }
}
