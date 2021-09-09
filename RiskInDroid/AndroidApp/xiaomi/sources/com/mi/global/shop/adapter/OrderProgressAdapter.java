package com.mi.global.shop.adapter;

import _m_j.cbj;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.newmodel.order.NewTraceItem;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public final class OrderProgressAdapter extends RecyclerView.O000000o<OrderProgressViewHolder> {

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<NewTraceItem> f4747O000000o = new ArrayList<>();
    private Context O00000Oo;
    private Drawable O00000o;
    private Activity O00000o0;
    private Drawable O00000oO;
    private Drawable O00000oo;
    private Drawable O0000O0o;

    public class OrderProgressViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private OrderProgressViewHolder f4748O000000o;

        public OrderProgressViewHolder_ViewBinding(OrderProgressViewHolder orderProgressViewHolder, View view) {
            this.f4748O000000o = orderProgressViewHolder;
            orderProgressViewHolder.tvOrderProgressTitle = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_order_progress_title, "field 'tvOrderProgressTitle'", CustomTextView.class);
            orderProgressViewHolder.lineLeft = (ImageView) Utils.findRequiredViewAsType(view, R.id.line_left, "field 'lineLeft'", ImageView.class);
            orderProgressViewHolder.centerCircle = (ImageView) Utils.findRequiredViewAsType(view, R.id.center_circle, "field 'centerCircle'", ImageView.class);
            orderProgressViewHolder.lineRight = (ImageView) Utils.findRequiredViewAsType(view, R.id.line_right, "field 'lineRight'", ImageView.class);
            orderProgressViewHolder.tvOrderProgressTime = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_order_progress_time, "field 'tvOrderProgressTime'", CustomTextView.class);
        }

        public void unbind() {
            OrderProgressViewHolder orderProgressViewHolder = this.f4748O000000o;
            if (orderProgressViewHolder != null) {
                this.f4748O000000o = null;
                orderProgressViewHolder.tvOrderProgressTitle = null;
                orderProgressViewHolder.lineLeft = null;
                orderProgressViewHolder.centerCircle = null;
                orderProgressViewHolder.lineRight = null;
                orderProgressViewHolder.tvOrderProgressTime = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        OrderProgressViewHolder orderProgressViewHolder = (OrderProgressViewHolder) o000OOo0;
        NewTraceItem newTraceItem = this.f4747O000000o.get(i);
        if (this.f4747O000000o.size() > 0) {
            ViewGroup.LayoutParams layoutParams = orderProgressViewHolder.itemView.getLayoutParams();
            layoutParams.width = cbj.O000000o.f13594O000000o.O00000o(30) / this.f4747O000000o.size();
            orderProgressViewHolder.itemView.setLayoutParams(layoutParams);
        }
        orderProgressViewHolder.tvOrderProgressTitle.setText(newTraceItem.text);
        try {
            orderProgressViewHolder.tvOrderProgressTime.setText(new SimpleDateFormat("MM/dd HH:mm").format(Long.valueOf(Long.parseLong(newTraceItem.time) * 1000)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!newTraceItem.time.equals("0")) {
            orderProgressViewHolder.tvOrderProgressTitle.setTextColor(Color.rgb(110, 182, 85));
            orderProgressViewHolder.tvOrderProgressTime.setTextColor(Color.rgb(221, 221, 221));
            orderProgressViewHolder.centerCircle.setImageDrawable(this.O00000o);
            orderProgressViewHolder.lineLeft.setImageDrawable(this.O00000oo);
            if (i < this.f4747O000000o.size() - 1 && !this.f4747O000000o.get(i + 1).time.equals("0")) {
                orderProgressViewHolder.lineRight.setImageDrawable(this.O00000oo);
            }
            orderProgressViewHolder.tvOrderProgressTime.setVisibility(0);
        } else {
            orderProgressViewHolder.tvOrderProgressTitle.setTextColor(Color.rgb(176, 176, 176));
            orderProgressViewHolder.tvOrderProgressTime.setTextColor(Color.rgb(221, 221, 221));
            orderProgressViewHolder.centerCircle.setImageDrawable(this.O00000oO);
            orderProgressViewHolder.lineLeft.setImageDrawable(this.O0000O0o);
            orderProgressViewHolder.lineRight.setImageDrawable(this.O0000O0o);
            orderProgressViewHolder.tvOrderProgressTime.setVisibility(4);
        }
        if (i == 0) {
            orderProgressViewHolder.lineLeft.setVisibility(4);
        } else {
            orderProgressViewHolder.lineLeft.setVisibility(0);
        }
        if (i == this.f4747O000000o.size() - 1) {
            orderProgressViewHolder.lineRight.setVisibility(4);
        } else {
            orderProgressViewHolder.lineRight.setVisibility(0);
        }
    }

    public OrderProgressAdapter(Context context, Activity activity) {
        this.O00000Oo = context;
        this.O00000o0 = activity;
        this.O00000o = context.getResources().getDrawable(R.drawable.shop_order_progress_circle_green);
        this.O00000oO = context.getResources().getDrawable(R.drawable.shop_order_progress_circle_grey);
        this.O00000oo = context.getResources().getDrawable(R.drawable.shop_order_progress_green_bg);
        this.O0000O0o = context.getResources().getDrawable(R.drawable.shop_order_progress_grey_bg);
    }

    public final int getItemCount() {
        return this.f4747O000000o.size();
    }

    static class OrderProgressViewHolder extends RecyclerView.O000OOo0 {
        @BindView(2131493152)
        ImageView centerCircle;
        @BindView(2131493629)
        ImageView lineLeft;
        @BindView(2131493630)
        ImageView lineRight;
        @BindView(2131494238)
        CustomTextView tvOrderProgressTime;
        @BindView(2131494239)
        CustomTextView tvOrderProgressTitle;

        OrderProgressViewHolder(View view) {
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
        return new OrderProgressViewHolder(LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.shop_order_progress_item, viewGroup, false));
    }
}
