package com.xiaomi.shopviews.widget.hdhorizontalrecyclergoods;

import _m_j.dul;
import _m_j.ewe;
import _m_j.ewu;
import _m_j.ewv;
import _m_j.exc;
import _m_j.exd;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.shopviews.model.HomeSectionItem;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class HDHorizontalRecyclerGoodsView2 extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private DividerItemDecoration f3931O000000o;
    private HorizontalAdapter O00000Oo;
    private int O00000o;
    private int O00000o0;
    private CustRecylerView O00000oO;

    public HDHorizontalRecyclerGoodsView2(Context context) {
        super(context);
        O00000Oo();
    }

    public HDHorizontalRecyclerGoodsView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000Oo();
    }

    public HDHorizontalRecyclerGoodsView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000Oo();
    }

    private void O000000o() {
        CustRecylerView custRecylerView = this.O00000oO;
        if (custRecylerView != null) {
            custRecylerView.removeAllViews();
        }
    }

    private void O00000Oo() {
        inflate(getContext(), R.layout.listitem_horizontal_recycler_view2, this);
        CustRecylerView custRecylerView = (CustRecylerView) findViewById(R.id.recycler_view);
        this.O00000oO = custRecylerView;
        custRecylerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f3931O000000o = new DividerItemDecoration(getContext());
        this.O00000oO.addItemDecoration(this.f3931O000000o);
        O00000o0();
        this.O00000o0 = getResources().getColor(R.color.btn_buy_red);
        this.O00000o = getResources().getColor(R.color.home_text_color_white);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O000000o();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        O000000o();
    }

    private void O00000o0() {
        this.O00000Oo = new HorizontalAdapter(getContext());
        this.O00000oO.setAdapter(this.O00000Oo);
    }

    static class DividerItemDecoration extends RecyclerView.O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private Drawable f3932O000000o;

        public DividerItemDecoration(Context context) {
            this.f3932O000000o = context.getResources().getDrawable(R.drawable.hd_horizontal_recycler_divider);
        }

        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            if (i == 0) {
                rect.set(dul.O000000o(recyclerView.getContext(), 6.0f), 0, this.f3932O000000o.getIntrinsicWidth(), 0);
            } else {
                rect.set(0, 0, this.f3932O000000o.getIntrinsicWidth(), 0);
            }
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
            int paddingTop = recyclerView.getPaddingTop();
            int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
                Drawable drawable = this.f3932O000000o;
                drawable.setBounds(right, paddingTop, drawable.getIntrinsicHeight() + right, height);
                this.f3932O000000o.draw(canvas);
            }
        }
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public exc f3935O000000o;
        public ewu O00000Oo;
        public ImageView O00000o;
        public exd O00000o0;

        public O000000o(View view) {
            super(view);
            this.O00000o = (ImageView) view.findViewById(R.id.recycler_img);
            this.O00000o0 = new exd(view);
            this.O00000Oo = new ewu(view);
            this.f3935O000000o = new exc(view);
        }
    }

    static class HorizontalAdapter extends RecyclerView.O000000o<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        private boolean f3933O000000o;
        private int O00000Oo;
        private Context O00000o;
        private int O00000o0;
        private ArrayList<HomeSectionItem> O00000oO = new ArrayList<>();
        private View O00000oo;

        public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            int size;
            O000000o o000000o = (O000000o) o000OOo0;
            if (this.f3933O000000o && (size = this.O00000oO.size()) > 0 && (i = i % size) < 0) {
                i += size;
            }
            new ColorDrawable(ewe.f15881O000000o);
            HomeSectionItem homeSectionItem = this.O00000oO.get(i);
            exd exd = o000000o.O00000o0;
            int i2 = this.O00000Oo;
            int i3 = this.O00000o0;
            if (!TextUtils.isEmpty(homeSectionItem.mProductName)) {
                exd.O00000oo.setText(Html.fromHtml(homeSectionItem.mProductName));
            } else {
                exd.O00000oo.setText("");
            }
            if (TextUtils.isEmpty(homeSectionItem.mProductBrief)) {
                exd.f15913O000000o.setVisibility(4);
            } else {
                exd.f15913O000000o.setVisibility(0);
                exd.f15913O000000o.setText(Html.fromHtml(homeSectionItem.mProductBrief));
            }
            TextView textView = exd.O00000o0;
            TextView textView2 = exd.O00000o;
            TextView textView3 = exd.O00000oO;
            textView.setTextColor(i2);
            textView3.setTextColor(i2);
            if (!(textView == null || textView2 == null || textView3 == null || homeSectionItem == null)) {
                if (ewv.O000000o(homeSectionItem.mProductPrice)) {
                    SpannableString O00000o02 = ewv.O00000o0(homeSectionItem.mProductPrice);
                    O00000o02.setSpan(new StyleSpan(1), 0, O00000o02.length(), 18);
                    textView.setText(O00000o02);
                    if (homeSectionItem.showPriceQi) {
                        textView3.setVisibility(0);
                    } else {
                        textView3.setVisibility(8);
                    }
                    if (ewv.O000000o(homeSectionItem.mProductPrice, homeSectionItem.mProductMarketPrice)) {
                        textView2.setVisibility(0);
                        textView2.setText(ewv.O00000Oo(homeSectionItem.mProductMarketPrice));
                    } else {
                        textView2.setVisibility(8);
                    }
                } else {
                    textView.setText("");
                    textView3.setVisibility(4);
                    textView2.setVisibility(4);
                }
            }
            GradientDrawable gradientDrawable = (GradientDrawable) exd.O00000Oo.getBackground();
            if (gradientDrawable != null) {
                gradientDrawable.setColor(i2);
                exd.O00000Oo.setBackgroundDrawable(gradientDrawable);
            }
            exd.O00000Oo.setTextColor(i3);
            if (!TextUtils.isEmpty(homeSectionItem.mBtnTxt)) {
                exd.O00000Oo.setText(homeSectionItem.mBtnTxt);
            } else {
                exd.O00000Oo.setText("立即购买");
            }
            o000000o.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.shopviews.widget.hdhorizontalrecyclergoods.HDHorizontalRecyclerGoodsView2.HorizontalAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                }
            });
            o000000o.O00000Oo.O000000o(homeSectionItem);
            exc exc = o000000o.f3935O000000o;
            ArrayList<String> arrayList = homeSectionItem.mProductTagArray;
            if (arrayList == null || arrayList.size() == 0) {
                exc.f15912O000000o.setVisibility(0);
                exc.O000000o(arrayList);
                return;
            }
            exc.f15912O000000o.setVisibility(8);
        }

        public HorizontalAdapter(Context context) {
            this.O00000o = context;
        }

        public int getItemCount() {
            if (this.f3933O000000o) {
                return Integer.MAX_VALUE;
            }
            return this.O00000oO.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.item_horizontal_recycler_view2, viewGroup, false);
            View findViewById = inflate.findViewById(R.id.rootView);
            this.O00000oo = findViewById;
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(dul.O000000o(viewGroup.getContext(), 152.0f), -2));
            return new O000000o(inflate);
        }
    }
}
