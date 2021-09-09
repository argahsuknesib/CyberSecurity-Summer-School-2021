package com.xiaomi.shopviews.widget.homepanicbuyview;

import _m_j.duh;
import _m_j.duj;
import _m_j.dul;
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
import com.xiaomi.shopviews.widget.homepanicbuyview.HomePanicBuyTabView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class HomePanicBuyView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f3966O000000o;
    public boolean O00000Oo = false;
    ArrayList<HomeSectionItem> O00000o;
    public HorizontalAdapter O00000o0;
    public HomePanicBuyTabView O00000oO;
    public exf O00000oo = new exf();
    CustRecylerView O0000O0o;
    public FlashTimerView O0000OOo;
    public int O0000Oo = 0;
    public ImageView O0000Oo0;
    private TextView O0000OoO;
    private FlashTimerView O0000Ooo;
    private RelativeLayout O0000o0;
    private LinearLayout O0000o00;
    private RelativeLayout O0000o0O;

    public HomePanicBuyView(Context context) {
        super(context);
        O00000Oo();
    }

    public HomePanicBuyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000Oo();
    }

    public HomePanicBuyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000Oo();
    }

    private void O000000o() {
        CustRecylerView custRecylerView = this.O0000O0o;
        if (custRecylerView != null) {
            custRecylerView.removeAllViews();
        }
        this.O0000Ooo.O000000o();
        this.O0000OOo.O000000o();
        this.O00000oo.O000000o();
    }

    private void O00000Oo() {
        inflate(getContext(), R.layout.listitem_panic_buy_view, this);
        this.O0000o0O = (RelativeLayout) findViewById(R.id.time_or_remind_wrap);
        FlashTimerView flashTimerView = (FlashTimerView) findViewById(R.id.count_down_view);
        this.O0000Ooo = flashTimerView;
        flashTimerView.setItemBackground(getResources().getDrawable(R.drawable.bg_panic_buy_count_down));
        this.O0000Ooo.setItemTextColor(getResources().getColorStateList(R.color.panic_buy_count_down_color));
        this.O0000OoO = (TextView) findViewById(R.id.current_active_remind);
        CustRecylerView custRecylerView = (CustRecylerView) findViewById(R.id.recycler_view);
        this.O0000O0o = custRecylerView;
        custRecylerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f3966O000000o = new O000000o();
        this.O0000O0o.addItemDecoration(this.f3966O000000o);
        this.O00000o0 = new HorizontalAdapter(getContext());
        this.O0000O0o.setAdapter(this.O00000o0);
        this.O0000o00 = (LinearLayout) findViewById(R.id.panic_buy_tab_view_container);
        this.O00000oO = (HomePanicBuyTabView) findViewById(R.id.panic_buy_tab_view);
        this.O0000o0 = (RelativeLayout) findViewById(R.id.single_tab_container);
        this.O0000Oo0 = (ImageView) findViewById(R.id.single_title_img);
        FlashTimerView flashTimerView2 = (FlashTimerView) findViewById(R.id.single_count_down_view);
        this.O0000OOo = flashTimerView2;
        flashTimerView2.setItemBackground(getResources().getDrawable(R.drawable.bg_panic_buy_count_down));
        this.O0000OOo.setItemTextColor(getResources().getColorStateList(R.color.panic_buy_count_down_color));
        this.O00000oO.setOnItemClickListener(new HomePanicBuyTabView.O000000o() {
            /* class com.xiaomi.shopviews.widget.homepanicbuyview.HomePanicBuyView.AnonymousClass1 */

            public final void O000000o(HomeSectionItem homeSectionItem) {
                int i;
                HomePanicBuyView homePanicBuyView = HomePanicBuyView.this;
                if (!duj.O000000o(homePanicBuyView.O00000o)) {
                    i = 0;
                    while (i < homePanicBuyView.O00000o.size() && !homePanicBuyView.O00000o.get(i).equals(homeSectionItem)) {
                        i++;
                    }
                } else {
                    i = 0;
                }
                homePanicBuyView.O0000Oo = i;
                HomePanicBuyView.this.O00000oo.O000000o(homeSectionItem, false);
                HomePanicBuyView homePanicBuyView2 = HomePanicBuyView.this;
                homePanicBuyView2.O00000o0.f3968O000000o = homeSectionItem.mStartTime;
                ArrayList<HomeSectionItem> arrayList = homeSectionItem.mItems;
                if (duj.O000000o(arrayList)) {
                    return;
                }
                if (arrayList.size() == 1) {
                    homePanicBuyView2.O0000O0o.removeItemDecoration(homePanicBuyView2.f3966O000000o);
                    homePanicBuyView2.O0000O0o.getLayoutParams().height = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 690.0f);
                    homePanicBuyView2.O00000o0.O000000o(arrayList);
                    return;
                }
                homePanicBuyView2.O0000O0o.removeItemDecoration(homePanicBuyView2.f3966O000000o);
                homePanicBuyView2.f3966O000000o.f3970O000000o = arrayList.size();
                homePanicBuyView2.O0000O0o.addItemDecoration(homePanicBuyView2.f3966O000000o);
                homePanicBuyView2.O0000O0o.getLayoutParams().height = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 690.0f);
                homePanicBuyView2.O00000o0.O000000o(arrayList);
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
        int f3970O000000o = 0;

        public final void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            if (i == 0) {
                rect.set(dul.O000000o(recyclerView.getContext(), 16.0f), 0, dul.O000000o(recyclerView.getContext(), 8.0f), 0);
            } else if (i == this.f3970O000000o - 1) {
                rect.set(0, 0, dul.O000000o(recyclerView.getContext(), 16.0f), 0);
            } else {
                rect.set(0, 0, dul.O000000o(recyclerView.getContext(), 8.0f), 0);
            }
        }
    }

    static class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f3971O000000o;
        public LinearLayout O00000Oo;
        public ImageView O00000o;
        public ImageView O00000o0;
        public ewu O00000oO;
        public TextView O00000oo;
        public TextView O0000O0o;
        public TextView O0000OOo;
        public TextView O0000Oo;
        public TextView O0000Oo0;
        private ImageView O0000OoO;

        public O00000Oo(View view) {
            super(view);
            this.O00000Oo = (LinearLayout) view.findViewById(R.id.content_container);
            this.O00000o = (ImageView) view.findViewById(R.id.recycler_img);
            this.O00000oo = (TextView) view.findViewById(R.id.text_favor);
            this.O0000OoO = (ImageView) view.findViewById(R.id.listitem_home_tag_image);
            this.O0000O0o = (TextView) view.findViewById(R.id.text_title);
            this.f3971O000000o = (TextView) view.findViewById(R.id.btn_action);
            this.O0000Oo0 = (TextView) view.findViewById(R.id.tv_viewhelper_price);
            this.O0000Oo = (TextView) view.findViewById(R.id.tv_viewhelper_price_qi);
            this.O0000OOo = (TextView) view.findViewById(R.id.tv_viewhelper_marketprice);
            dun.O000000o(view.getContext(), this.O0000Oo0);
            dun.O000000o(view.getContext(), this.O0000OOo);
            this.O00000oO = new ewu(view);
            this.O00000o0 = (ImageView) view.findViewById(R.id.img_sell_out);
        }
    }

    static class HorizontalAdapter extends RecyclerView.O000000o<O00000Oo> {

        /* renamed from: O000000o  reason: collision with root package name */
        long f3968O000000o;
        private int O00000Oo = 0;
        private boolean O00000o;
        private boolean O00000o0;
        private String O00000oO;
        private Context O00000oo;
        private ArrayList<HomeSectionItem> O0000O0o = new ArrayList<>();

        public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            new ColorDrawable(ewe.f15881O000000o);
            HomeSectionItem homeSectionItem = this.O0000O0o.get(i);
            if (getItemViewType(i) == 0) {
                duh.O000000o().O000000o(homeSectionItem.mImageUrl, o00000Oo.O00000o);
            } else {
                duh.O000000o().O000000o(homeSectionItem.mSmallImgUrl, o00000Oo.O00000o);
            }
            if (!TextUtils.isEmpty(homeSectionItem.mProductName)) {
                o00000Oo.O0000O0o.setText(Html.fromHtml(homeSectionItem.mProductName));
            }
            if (this.O00000o) {
                ((ViewGroup.MarginLayoutParams) o00000Oo.O00000Oo.getLayoutParams()).topMargin = dul.O000000o(this.O00000oo, 8.0f);
            } else {
                ((ViewGroup.MarginLayoutParams) o00000Oo.O00000Oo.getLayoutParams()).topMargin = 0;
            }
            o00000Oo.f3971O000000o.setText(this.O00000oO);
            ewv.O00000Oo(o00000Oo.O0000Oo0, o00000Oo.O0000OOo, o00000Oo.O0000Oo, homeSectionItem);
            o00000Oo.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.shopviews.widget.homepanicbuyview.HomePanicBuyView.HorizontalAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                }
            });
            o00000Oo.O00000oO.O000000o(homeSectionItem);
            if (TextUtils.isEmpty(homeSectionItem.mFavorDesc)) {
                o00000Oo.O00000oo.setVisibility(8);
            } else {
                o00000Oo.O00000oo.setVisibility(0);
                o00000Oo.O00000oo.setText(Html.fromHtml(homeSectionItem.mFavorDesc));
            }
            if (!TextUtils.isEmpty(homeSectionItem.sell_out_img)) {
                o00000Oo.O00000o0.setVisibility(0);
            } else {
                o00000Oo.O00000o0.setVisibility(8);
            }
        }

        public HorizontalAdapter(Context context) {
            this.O00000oo = context;
        }

        public int getItemCount() {
            return this.O0000O0o.size();
        }

        public int getItemViewType(int i) {
            return this.O00000o0 ^ true ? 1 : 0;
        }

        public final void O000000o(ArrayList<HomeSectionItem> arrayList) {
            this.O0000O0o.clear();
            if (arrayList == null || arrayList.size() != 1) {
                this.O00000o0 = false;
            } else {
                this.O00000o0 = true;
            }
            this.O0000O0o.addAll(arrayList);
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
                View inflate = LayoutInflater.from(this.O00000oo).inflate((int) R.layout.listitem_panic_buy_recycler_big_item_view, viewGroup, false);
                O00000Oo o00000Oo = new O00000Oo(inflate);
                inflate.getLayoutParams().width = duq.O000000o().O00000oo;
                o00000Oo.O00000Oo.getLayoutParams().width = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 984.0f);
                o00000Oo.O00000Oo.getLayoutParams().height = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 644.0f);
                o00000Oo.O00000o.getLayoutParams().height = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 492.0f);
                return o00000Oo;
            }
            O00000Oo o00000Oo2 = new O00000Oo(LayoutInflater.from(this.O00000oo).inflate((int) R.layout.listitem_panic_buy_recycler_short_item_view, viewGroup, false));
            o00000Oo2.O00000Oo.getLayoutParams().width = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 480.0f);
            o00000Oo2.O00000Oo.getLayoutParams().height = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 644.0f);
            o00000Oo2.O00000o.getLayoutParams().height = (int) ((((float) duq.O000000o().O00000oo) / 1080.0f) * 320.0f);
            return o00000Oo2;
        }
    }
}
