package com.xiaomi.shopviews.widget.homepanicbuyview;

import _m_j.duj;
import _m_j.dun;
import _m_j.duq;
import _m_j.ewe;
import _m_j.ewu;
import _m_j.ewv;
import _m_j.exf;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.text.TextUtils;
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
import com.xiaomi.shopviews.widget.hdhorizontalrecyclergoods.CustRecylerView;
import com.xiaomi.shopviews.widget.homepanicbuyview.HomePanicBuyTabView2;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class HomePanicBuyView2 extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final int f3972O000000o = ((int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 426.0f));
    public static int O00000Oo = ((duq.O000000o().O00000oo / 1080) * 48);
    public static int O00000o0 = ((duq.O000000o().O00000oo / 1080) * 24);
    O000000o O00000o;
    public boolean O00000oO = false;
    HorizontalAdapter O00000oo;
    ArrayList<HomeSectionItem> O0000O0o;
    public HomePanicBuyTabView2 O0000OOo;
    CustRecylerView O0000Oo;
    public exf O0000Oo0 = new exf();
    public ImageView O0000OoO;
    public int O0000Ooo = 0;
    private FlashTimerView O0000o0;
    private LinearLayout O0000o00;
    private RelativeLayout O0000o0O;

    public HomePanicBuyView2(Context context) {
        super(context);
        O00000Oo();
    }

    public HomePanicBuyView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000Oo();
    }

    public HomePanicBuyView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000Oo();
    }

    private void O000000o() {
        FlashTimerView flashTimerView;
        this.O0000o0.O000000o();
        this.O0000Oo0.O000000o();
        HomePanicBuyTabView2 homePanicBuyTabView2 = this.O0000OOo;
        for (int i = 0; i < homePanicBuyTabView2.getChildCount(); i++) {
            View childAt = homePanicBuyTabView2.f3965O000000o.getChildAt(i);
            if (!(childAt == null || (flashTimerView = (FlashTimerView) childAt.findViewById(R.id.count_down_view)) == null)) {
                flashTimerView.O000000o();
            }
        }
        CustRecylerView custRecylerView = this.O0000Oo;
        if (custRecylerView != null) {
            custRecylerView.removeAllViews();
        }
    }

    private void O00000Oo() {
        inflate(getContext(), R.layout.listitem_panic_buy_view2, this);
        this.O0000Oo = (CustRecylerView) findViewById(R.id.recycler_view);
        this.O0000o00 = (LinearLayout) findViewById(R.id.panic_buy_tab_view_container);
        this.O0000Oo.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.O00000o = new O000000o();
        this.O0000Oo.addItemDecoration(this.O00000o);
        this.O00000oo = new HorizontalAdapter(getContext());
        this.O0000Oo.setAdapter(this.O00000oo);
        this.O0000OOo = (HomePanicBuyTabView2) findViewById(R.id.panic_buy_tab_view);
        this.O0000o0O = (RelativeLayout) findViewById(R.id.single_tab_container);
        this.O0000o0O.getLayoutParams().height = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 120.0f);
        this.O0000OoO = (ImageView) findViewById(R.id.single_title_img);
        ((RelativeLayout.LayoutParams) this.O0000OoO.getLayoutParams()).leftMargin = O00000Oo;
        FlashTimerView flashTimerView = (FlashTimerView) findViewById(R.id.single_count_down_view);
        this.O0000o0 = flashTimerView;
        flashTimerView.setItemBackground(getResources().getDrawable(R.drawable.bg_panic_buy_count_down));
        this.O0000o0.setItemTextColor(getResources().getColorStateList(R.color.panic_buy_count_down_color));
        this.O0000o0.O00000Oo();
        this.O0000OOo.setOnItemClickListener(new HomePanicBuyTabView2.O000000o() {
            /* class com.xiaomi.shopviews.widget.homepanicbuyview.HomePanicBuyView2.AnonymousClass1 */

            public final void O000000o(HomeSectionItem homeSectionItem) {
                int i;
                HomePanicBuyView2 homePanicBuyView2 = HomePanicBuyView2.this;
                if (!duj.O000000o(homePanicBuyView2.O0000O0o)) {
                    i = 0;
                    while (i < homePanicBuyView2.O0000O0o.size() && !homePanicBuyView2.O0000O0o.get(i).equals(homeSectionItem)) {
                        i++;
                    }
                } else {
                    i = 0;
                }
                homePanicBuyView2.O0000Ooo = i;
                HomePanicBuyView2.this.O0000Oo0.O000000o(homeSectionItem, false);
                HomePanicBuyView2 homePanicBuyView22 = HomePanicBuyView2.this;
                ArrayList<HomeSectionItem> arrayList = homeSectionItem.mItems;
                if (duj.O000000o(arrayList)) {
                    return;
                }
                if (arrayList.size() == 1) {
                    homePanicBuyView22.O0000Oo.removeItemDecoration(homePanicBuyView22.O00000o);
                    homePanicBuyView22.O0000Oo.getLayoutParams().height = HomePanicBuyView2.f3972O000000o;
                    homePanicBuyView22.O00000oo.O000000o(arrayList);
                    return;
                }
                homePanicBuyView22.O0000Oo.removeItemDecoration(homePanicBuyView22.O00000o);
                homePanicBuyView22.O00000o.f3976O000000o = arrayList.size();
                homePanicBuyView22.O0000Oo.addItemDecoration(homePanicBuyView22.O00000o);
                homePanicBuyView22.O0000Oo.getLayoutParams().height = HomePanicBuyView2.f3972O000000o;
                homePanicBuyView22.O00000oo.O000000o(arrayList);
            }
        });
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

    static class O000000o extends RecyclerView.O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        int f3976O000000o = 0;

        public final void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            int i2 = this.f3976O000000o;
            if (i2 == 1) {
                rect.set(HomePanicBuyView2.O00000Oo, 0, HomePanicBuyView2.O00000Oo, 0);
            } else if (i == 0) {
                rect.set(HomePanicBuyView2.O00000Oo, 0, HomePanicBuyView2.O00000o0, 0);
            } else if (i == i2 - 1) {
                rect.set(0, 0, HomePanicBuyView2.O00000Oo, 0);
            } else {
                rect.set(0, 0, HomePanicBuyView2.O00000o0, 0);
            }
        }
    }

    static class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public LinearLayout f3977O000000o;
        public ImageView O00000Oo;
        public ewu O00000o;
        public ImageView O00000o0;
        public TextView O00000oO;
        public TextView O00000oo;
        public TextView O0000O0o;
        public TextView O0000OOo;
        public TextView O0000Oo0;

        public O00000Oo(View view) {
            super(view);
            this.f3977O000000o = (LinearLayout) view.findViewById(R.id.content_container);
            this.O00000o0 = (ImageView) view.findViewById(R.id.recycler_img);
            this.O00000oO = (TextView) view.findViewById(R.id.text_favor);
            this.O00000oo = (TextView) view.findViewById(R.id.text_title);
            this.O0000OOo = (TextView) view.findViewById(R.id.tv_viewhelper_price);
            this.O0000Oo0 = (TextView) view.findViewById(R.id.tv_viewhelper_price_qi);
            this.O0000O0o = (TextView) view.findViewById(R.id.tv_viewhelper_marketprice);
            dun.O000000o(view.getContext(), this.O0000OOo);
            dun.O000000o(view.getContext(), this.O0000O0o);
            this.O00000o = new ewu(view);
            this.O00000Oo = (ImageView) view.findViewById(R.id.img_sell_out);
        }
    }

    static class HorizontalAdapter extends RecyclerView.O000000o<O00000Oo> {

        /* renamed from: O000000o  reason: collision with root package name */
        private Context f3974O000000o;
        private int O00000Oo;
        private ArrayList<HomeSectionItem> O00000o0 = new ArrayList<>();

        public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            ((ViewGroup.MarginLayoutParams) o00000Oo.f3977O000000o.getLayoutParams()).topMargin = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 18.0f);
            new ColorDrawable(ewe.f15881O000000o);
            HomeSectionItem homeSectionItem = this.O00000o0.get(i);
            if (!(getItemViewType(i) == 0 || getItemViewType(i) == 1)) {
                getItemViewType(i);
            }
            if (!TextUtils.isEmpty(homeSectionItem.mProductName)) {
                o00000Oo.O00000oo.setText(Html.fromHtml(homeSectionItem.mProductName));
            }
            ewv.O00000Oo(o00000Oo.O0000OOo, o00000Oo.O0000O0o, o00000Oo.O0000Oo0, homeSectionItem);
            o00000Oo.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.shopviews.widget.homepanicbuyview.HomePanicBuyView2.HorizontalAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                }
            });
            o00000Oo.O00000o.O000000o(homeSectionItem);
            if (TextUtils.isEmpty(homeSectionItem.mFavorDesc)) {
                o00000Oo.O00000oO.setVisibility(8);
            } else {
                o00000Oo.O00000oO.setVisibility(0);
                o00000Oo.O00000oO.setText(Html.fromHtml(homeSectionItem.mFavorDesc));
            }
            if (!TextUtils.isEmpty(homeSectionItem.sell_out_img)) {
                o00000Oo.O00000Oo.setVisibility(0);
            } else {
                o00000Oo.O00000Oo.setVisibility(8);
            }
        }

        public HorizontalAdapter(Context context) {
            this.f3974O000000o = context;
        }

        public int getItemCount() {
            return this.O00000o0.size();
        }

        public int getItemViewType(int i) {
            return this.O00000Oo;
        }

        public final void O000000o(ArrayList<HomeSectionItem> arrayList) {
            this.O00000o0.clear();
            if (arrayList == null || arrayList.size() == 1) {
                this.O00000Oo = 0;
            } else if (arrayList.size() == 2) {
                this.O00000Oo = 1;
            } else {
                this.O00000Oo = 2;
            }
            this.O00000o0.addAll(arrayList);
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                View inflate = LayoutInflater.from(this.f3974O000000o).inflate((int) R.layout.listitem_panic_buy_recycler_big_item_view2, viewGroup, false);
                O00000Oo o00000Oo = new O00000Oo(inflate);
                inflate.getLayoutParams().width = duq.O000000o().O00000oo;
                o00000Oo.f3977O000000o.getLayoutParams().width = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 984.0f);
                o00000Oo.f3977O000000o.getLayoutParams().height = HomePanicBuyView2.f3972O000000o;
                o00000Oo.O00000o0.getLayoutParams().height = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 300.0f);
                return o00000Oo;
            } else if (i == 1) {
                O00000Oo o00000Oo2 = new O00000Oo(LayoutInflater.from(this.f3974O000000o).inflate((int) R.layout.listitem_panic_buy_recycler_short_item_view2, viewGroup, false));
                o00000Oo2.f3977O000000o.getLayoutParams().width = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 480.0f);
                o00000Oo2.f3977O000000o.getLayoutParams().height = HomePanicBuyView2.f3972O000000o;
                o00000Oo2.O00000o0.getLayoutParams().height = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 270.0f);
                return o00000Oo2;
            } else {
                O00000Oo o00000Oo3 = new O00000Oo(LayoutInflater.from(this.f3974O000000o).inflate((int) R.layout.listitem_panic_buy_recycler_short_item_view2, viewGroup, false));
                o00000Oo3.f3977O000000o.getLayoutParams().width = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 405.0f);
                o00000Oo3.f3977O000000o.getLayoutParams().height = HomePanicBuyView2.f3972O000000o;
                o00000Oo3.O00000o0.getLayoutParams().height = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 270.0f);
                return o00000Oo3;
            }
        }
    }
}
