package com.mi.global.shop.activity;

import _m_j.byl;
import _m_j.cak;
import _m_j.cal;
import _m_j.cam;
import _m_j.cas;
import _m_j.cav;
import _m_j.ced;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.volley.Request;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.expresstrack.NewExpressInfoData;
import com.mi.global.shop.newmodel.expresstrack.NewExpressInfoResult;
import com.mi.global.shop.newmodel.expresstrack.NewExpressTraceItem;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.xiaomi.smarthome.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TrackAcitvity extends BaseActivity {
    private static final String O00000Oo = "TrackAcitvity";

    /* renamed from: O000000o  reason: collision with root package name */
    protected NewExpressInfoData f4712O000000o;
    private String O00000o0;
    @BindView(2131493337)
    CustomTextView expressName;
    @BindView(2131493338)
    CustomTextView expressSn;
    public SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @BindView(2131493568)
    ImageView ivShipping;
    @BindView(2131493691)
    LinearLayout loading;
    @BindView(2131494163)
    NoScrollListView trackItemList;
    @BindView(2131494216)
    CustomTextView tvExpressHint;

    public void onCreate(Bundle bundle) {
        Request request;
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_track);
        ButterKnife.bind(this);
        setTitle(getString(R.string.track));
        this.mBackView.setVisibility(0);
        findViewById(R.id.title_bar_cart_view).setVisibility(4);
        this.loading.setVisibility(0);
        this.trackItemList = (NoScrollListView) findViewById(R.id.trackItemList);
        this.O00000o0 = getIntent().getStringExtra("expresssn");
        Uri.Builder buildUpon = Uri.parse(cav.O0000oOo()).buildUpon();
        buildUpon.appendQueryParameter("deliverId", this.O00000o0);
        buildUpon.appendQueryParameter("ot", "5");
        String builder = buildUpon.toString();
        AnonymousClass1 r0 = new cak<NewExpressInfoResult>() {
            /* class com.mi.global.shop.activity.TrackAcitvity.AnonymousClass1 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                TrackAcitvity.this.f4712O000000o = ((NewExpressInfoResult) baseResult).data;
                TrackAcitvity.this.O00000Oo();
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                TrackAcitvity.this.finish();
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(builder, NewExpressInfoResult.class, r0);
        } else {
            request = new cal(builder, NewExpressInfoResult.class, r0);
        }
        request.setTag(O00000Oo);
        ced.f13683O000000o.add(request);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        this.loading.setVisibility(8);
        CustomTextView customTextView = this.expressName;
        customTextView.setText(getString(R.string.transport_company) + " " + this.f4712O000000o.expressInfo.express_name);
        CustomTextView customTextView2 = this.expressSn;
        customTextView2.setText(getString(R.string.tracking_number) + " " + this.f4712O000000o.expressInfo.express_sn);
        O000000o o000000o = new O000000o(this);
        if (this.f4712O000000o.expressInfo.express_trace == null || this.f4712O000000o.expressInfo.express_trace.size() == 0) {
            this.tvExpressHint.setVisibility(0);
        } else {
            this.tvExpressHint.setVisibility(8);
        }
        try {
            if (!(getIntent().getStringExtra("order_placed") == null || getIntent().getStringExtra("order_paid") == null)) {
                NewExpressTraceItem newExpressTraceItem = new NewExpressTraceItem();
                newExpressTraceItem.time = getIntent().getStringExtra("order_paid");
                newExpressTraceItem.city = "";
                newExpressTraceItem.track = getString(R.string.order_status_paid);
                NewExpressTraceItem newExpressTraceItem2 = new NewExpressTraceItem();
                newExpressTraceItem2.time = getIntent().getStringExtra("order_placed");
                newExpressTraceItem.city = "";
                newExpressTraceItem2.track = getString(R.string.order_status_placed);
                this.f4712O000000o.expressInfo.express_trace.add(newExpressTraceItem);
                this.f4712O000000o.expressInfo.express_trace.add(newExpressTraceItem2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        o000000o.O000000o((List) this.f4712O000000o.expressInfo.express_trace);
        this.trackItemList.setDividerHeight(0);
        this.trackItemList.setAdapter((ListAdapter) o000000o);
    }

    public void onResume() {
        super.onResume();
    }

    public class O000000o extends ArrayAdapter<NewExpressTraceItem> {
        private Drawable O00000Oo;
        private Drawable O00000o0;
        private Drawable O0000O0o;
        private Drawable O0000OOo;

        public final /* synthetic */ void O000000o(View view, int i, Object obj) {
            NewExpressTraceItem newExpressTraceItem = (NewExpressTraceItem) obj;
            O00000Oo o00000Oo = (O00000Oo) view.getTag();
            if (!TextUtils.isEmpty(newExpressTraceItem.city)) {
                CustomTextView customTextView = o00000Oo.O00000o0;
                customTextView.setText("[" + newExpressTraceItem.city + "]" + newExpressTraceItem.track);
            } else {
                o00000Oo.O00000o0.setText(newExpressTraceItem.track);
            }
            o00000Oo.O00000o.setText(TrackAcitvity.this.formatter.format(new Date(cas.O000000o(newExpressTraceItem.time) * 1000)));
            if (cas.O000000o(newExpressTraceItem.time) != 0) {
                o00000Oo.O00000o.setVisibility(0);
            } else {
                o00000Oo.O00000oO.setImageDrawable(this.O0000OOo);
                o00000Oo.O00000oo.setImageDrawable(this.O0000OOo);
                o00000Oo.O00000o.setVisibility(4);
            }
            if (i == 0) {
                o00000Oo.f4715O000000o.setVisibility(8);
                o00000Oo.O00000Oo.setVisibility(0);
                o00000Oo.O00000oO.setVisibility(4);
            } else {
                o00000Oo.f4715O000000o.setVisibility(0);
                o00000Oo.O00000Oo.setVisibility(8);
                o00000Oo.O00000oO.setVisibility(0);
            }
            if (i == TrackAcitvity.this.f4712O000000o.expressInfo.express_trace.size() - 1) {
                o00000Oo.O00000oo.setVisibility(4);
            } else {
                o00000Oo.O00000oo.setVisibility(0);
            }
        }

        public O000000o(Context context) {
            super(context);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, ?[OBJECT, ARRAY], int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_track_item, (ViewGroup) null, false);
            O00000Oo o00000Oo = new O00000Oo();
            o00000Oo.f4715O000000o = (ImageView) inflate.findViewById(R.id.track_status_image_normal);
            o00000Oo.O00000Oo = (ImageView) inflate.findViewById(R.id.track_status_image_selected);
            o00000Oo.O00000o0 = (CustomTextView) inflate.findViewById(R.id.track_info);
            o00000Oo.O00000o = (CustomTextView) inflate.findViewById(R.id.track_time);
            o00000Oo.O00000oO = (ImageView) inflate.findViewById(R.id.line_top);
            o00000Oo.O00000oo = (ImageView) inflate.findViewById(R.id.line_bottom);
            inflate.setTag(o00000Oo);
            this.O00000Oo = context.getResources().getDrawable(R.drawable.shop_order_progress_circle_green);
            this.O00000o0 = context.getResources().getDrawable(R.drawable.shop_order_progress_circle_grey);
            this.O0000O0o = context.getResources().getDrawable(R.drawable.shop_order_progress_green_bg);
            this.O0000OOo = context.getResources().getDrawable(R.drawable.shop_order_progress_grey_bg);
            return inflate;
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        ImageView f4715O000000o;
        ImageView O00000Oo;
        CustomTextView O00000o;
        CustomTextView O00000o0;
        ImageView O00000oO;
        ImageView O00000oo;

        O00000Oo() {
        }
    }
}
