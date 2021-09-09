package com.xiaomi.shopviews.widget.homeseckill;

import _m_j.duh;
import _m_j.dul;
import _m_j.duq;
import _m_j.ewe;
import _m_j.ewu;
import _m_j.ewv;
import _m_j.exg;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
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
import com.xiaomi.shopviews.model.HomeSectionBody;
import com.xiaomi.shopviews.model.HomeSectionItem;
import com.xiaomi.shopviews.widget.hdhorizontalrecyclergoods.CustRecylerView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class HomeSecKillView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public HomeSectionBody f3982O000000o;
    CountDownTimer O00000Oo;
    public TextView O00000o;
    public TextView O00000o0;
    public TextView O00000oO;
    private long O00000oo;
    private DividerItemDecoration O0000O0o;
    private O000000o O0000OOo;
    private View O0000Oo;
    private CustRecylerView O0000Oo0;
    private ImageView O0000OoO;
    private TextView O0000Ooo;

    public HomeSecKillView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000Oo();
    }

    public HomeSecKillView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000Oo();
    }

    private void O000000o() {
        CustRecylerView custRecylerView = this.O0000Oo0;
        if (custRecylerView != null) {
            custRecylerView.removeAllViews();
        }
    }

    private long getCountDownTime() {
        HomeSectionBody homeSectionBody = this.f3982O000000o;
        if (homeSectionBody == null) {
            return 0;
        }
        long j = (homeSectionBody.mEndTime - this.f3982O000000o.mServerTime) * 1000;
        long currentTimeMillis = System.currentTimeMillis() - this.O00000oo;
        if (j <= 0 || currentTimeMillis >= j) {
            return 0;
        }
        return j - currentTimeMillis;
    }

    private void O00000Oo() {
        double O000000o2 = (double) ((duq.O000000o().O00000oo - dul.O000000o(getContext(), 8.0f)) - (dul.O000000o(getContext(), 6.0f) * 3));
        Double.isNaN(O000000o2);
        int i = (int) (O000000o2 / 3.3d);
        inflate(getContext(), R.layout.listitem_seckill_view, this);
        this.O0000Oo = findViewById(R.id.layout_title);
        this.O0000OoO = (ImageView) findViewById(R.id.iv_countdown_title);
        this.O0000Ooo = (TextView) findViewById(R.id.tv_countdownDesc);
        this.O00000o0 = (TextView) findViewById(R.id.tv_countdown_hour);
        this.O00000o = (TextView) findViewById(R.id.tv_countdown_minute);
        this.O00000oO = (TextView) findViewById(R.id.tv_countdown_second);
        this.O0000Oo0 = (CustRecylerView) findViewById(R.id.recycler_view);
        ((RelativeLayout.LayoutParams) this.O0000OoO.getLayoutParams()).height = (duq.O000000o().O00000oo * 120) / 1080;
        this.O0000Oo0.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.O0000O0o = new DividerItemDecoration(getContext());
        this.O0000Oo0.addItemDecoration(this.O0000O0o);
        O000000o(i, i);
    }

    private void O00000o0() {
        CountDownTimer countDownTimer = this.O00000Oo;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.O00000Oo = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O00000o0();
        O000000o();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        O00000o0();
        O000000o();
    }

    private void O000000o(int i, int i2) {
        this.O0000Oo0.getLayoutParams().height = dul.O000000o(getContext(), 38.0f) + i2;
        this.O0000OOo = new O000000o(getContext(), i, i2);
        this.O0000Oo0.setAdapter(this.O0000OOo);
    }

    static class DividerItemDecoration extends RecyclerView.O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private Drawable f3983O000000o;

        public DividerItemDecoration(Context context) {
            this.f3983O000000o = context.getResources().getDrawable(R.drawable.horizontal_recycler_divider_big);
        }

        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            if (i == 0) {
                rect.set(dul.O000000o(recyclerView.getContext(), 8.0f), 0, this.f3983O000000o.getIntrinsicWidth(), 0);
            } else {
                rect.set(0, 0, this.f3983O000000o.getIntrinsicWidth(), 0);
            }
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
            int paddingTop = recyclerView.getPaddingTop();
            int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
                Drawable drawable = this.f3983O000000o;
                drawable.setBounds(right, paddingTop, drawable.getIntrinsicHeight() + right, height);
                this.f3983O000000o.draw(canvas);
            }
        }
    }

    static class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public exg f3986O000000o;
        public ewu O00000Oo;
        public ImageView O00000o0;

        public O00000Oo(View view, int i, int i2) {
            super(view);
            this.O00000o0 = (ImageView) view.findViewById(R.id.recycler_img);
            if (i2 > 0 && i > 0) {
                view.getLayoutParams().width = i;
                this.O00000o0.getLayoutParams().height = i2;
                this.O00000o0.getLayoutParams().width = i;
            }
            this.f3986O000000o = new exg(view);
            this.O00000Oo = new ewu(view);
        }
    }

    static class O000000o extends RecyclerView.O000000o<O00000Oo> {

        /* renamed from: O000000o  reason: collision with root package name */
        private boolean f3984O000000o;
        private Context O00000Oo;
        private int O00000o;
        private ArrayList<HomeSectionItem> O00000o0 = new ArrayList<>();
        private int O00000oO;

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            int size;
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            if (this.f3984O000000o && (size = this.O00000o0.size()) > 0 && (i = i % size) < 0) {
                i += size;
            }
            new ColorDrawable(ewe.f15881O000000o);
            HomeSectionItem homeSectionItem = this.O00000o0.get(i);
            duh.O000000o().O000000o(homeSectionItem.mImageUrl, o00000Oo.O00000o0);
            exg exg = o00000Oo.f3986O000000o;
            ewv.O000000o(exg.O00000Oo, exg.f15917O000000o, exg.O00000o0, this.O00000o0.get(i));
            o00000Oo.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.shopviews.widget.homeseckill.HomeSecKillView.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                }
            });
            o00000Oo.O00000Oo.O000000o(homeSectionItem);
        }

        public O000000o(Context context, int i, int i2) {
            this.O00000Oo = context;
            this.O00000oO = i;
            this.O00000o = i2;
        }

        public final int getItemCount() {
            if (this.f3984O000000o) {
                return Integer.MAX_VALUE;
            }
            return this.O00000o0.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O00000Oo(LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.listitem_home_seckill_item, viewGroup, false), this.O00000oO, this.O00000o);
        }
    }
}
