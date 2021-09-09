package com.mi.global.shop.adapter;

import _m_j.bzr;
import _m_j.cbe;
import _m_j.cbq;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.dialog.PayActivityWebDialog;
import com.xiaomi.smarthome.R;

public class PromotionListAdapter extends ArrayAdapter<bzr> {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f4749O000000o;
    public PayActivityWebDialog O00000Oo;

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        final bzr bzr = (bzr) obj;
        O000000o o000000o = (O000000o) view.getTag();
        o000000o.O00000Oo.setText(bzr.O00000o0);
        if (!TextUtils.isEmpty(bzr.O00000Oo)) {
            cbq.O000000o(bzr.O00000Oo, o000000o.f4751O000000o);
        }
        final String str = bzr.O00000o;
        if (TextUtils.isEmpty(str)) {
            o000000o.O00000o0.setVisibility(8);
        } else {
            o000000o.O00000o0.setVisibility(0);
        }
        if (!TextUtils.isEmpty(str)) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.adapter.PromotionListAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    PayActivityWebDialog.Builder builder = new PayActivityWebDialog.Builder(PromotionListAdapter.this.O00000o);
                    builder.O00000Oo = str;
                    PromotionListAdapter promotionListAdapter = PromotionListAdapter.this;
                    PayActivityWebDialog payActivityWebDialog = new PayActivityWebDialog(builder.f5009O000000o, (byte) 0);
                    View inflate = ((LayoutInflater) builder.f5009O000000o.getSystemService("layout_inflater")).inflate((int) R.layout.shop_pay_activity_web_dialog, (ViewGroup) null);
                    ButterKnife.bind(builder, inflate);
                    builder.ivClose.setOnClickListener(new View.OnClickListener(payActivityWebDialog) {
                        /* class com.mi.global.shop.widget.dialog.PayActivityWebDialog.Builder.AnonymousClass1 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ PayActivityWebDialog f5010O000000o;

                        {
                            this.f5010O000000o = r2;
                        }

                        public final void onClick(View view) {
                            this.f5010O000000o.dismiss();
                        }
                    });
                    if (builder.O00000Oo != null && !TextUtils.isEmpty(builder.O00000Oo)) {
                        cbq.O000000o(builder.O00000Oo, builder.ivActivityImage);
                    }
                    payActivityWebDialog.setCanceledOnTouchOutside(true);
                    payActivityWebDialog.setContentView(inflate);
                    promotionListAdapter.O00000Oo = payActivityWebDialog;
                    PromotionListAdapter.this.O00000Oo.show();
                    cbe.O000000o(String.format("pay_promotion(%s)", bzr.O00000o0), ConfirmActivity.class.getSimpleName());
                }
            });
        }
    }

    public PromotionListAdapter(Context context) {
        super(context);
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        SimpleDraweeView f4751O000000o;
        CustomTextView O00000Oo;
        ImageView O00000o0;

        O000000o() {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_buy_confirm_orderdetail_promotion_hint, (ViewGroup) null, false);
        this.f4749O000000o = new O000000o();
        this.f4749O000000o.f4751O000000o = (SimpleDraweeView) inflate.findViewById(R.id.iv_promote_icon);
        this.f4749O000000o.O00000Oo = (CustomTextView) inflate.findViewById(R.id.tv_promote_text);
        this.f4749O000000o.O00000o0 = (ImageView) inflate.findViewById(R.id.iv_activity_arrow);
        inflate.setTag(this.f4749O000000o);
        return inflate;
    }
}
