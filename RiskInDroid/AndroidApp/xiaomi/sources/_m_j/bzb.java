package _m_j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.buy.payu.PayU;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollGridView;
import com.mi.global.shop.widget.NoScrollListView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public final class bzb {

    /* renamed from: O000000o  reason: collision with root package name */
    public CustomTextView f13447O000000o;
    public CustomTextView O00000Oo;
    public NoScrollGridView O00000o;
    public CustomTextView O00000o0;
    public O000000o O00000oO;
    public Context O00000oo;
    public List<bzn> O0000O0o;
    public O00000o0 O0000OOo;
    public bza O0000Oo;
    public bzn O0000Oo0;
    private View O0000OoO;
    private NoScrollListView O0000Ooo;
    private boolean O0000o00 = false;

    public bzb(Context context, View view) {
        this.O00000oo = context;
        this.O0000OoO = view;
        if (PayU.O00000oO != null && PayU.O00000oO.size() > 0 && "BFL".equals(PayU.O00000oO.get(0).O00000Oo) && PayU.O00000oO.get(0).O00000o.booleanValue()) {
            this.O0000o00 = true;
        }
        this.O0000Oo = new bza(context, view.findViewById(R.id.emi_card_pane), this.O0000o00) {
            /* class _m_j.bzb.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final boolean O00000o0() {
                boolean z;
                if (bzb.this.O0000Oo0 == null) {
                    return false;
                }
                int i = 0;
                while (true) {
                    if (i >= bzb.this.O0000Oo0.O00000oO.size()) {
                        z = false;
                        break;
                    } else if (bzb.this.O0000Oo0.O00000oO.get(i).O0000O0o) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z || !super.O00000o0()) {
                    return false;
                }
                return true;
            }

            public final void O00000Oo() {
                super.O00000Oo();
            }
        };
        O000000o();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        this.O0000O0o = new ArrayList();
        double amount = ((ConfirmActivity) this.O00000oo).getAmount();
        float f = Float.MAX_VALUE;
        if (PayU.O00000oO != null) {
            for (int i = 0; i < PayU.O00000oO.size(); i++) {
                bzn bzn = PayU.O00000oO.get(i);
                if (bzn.f13495O000000o < f) {
                    f = bzn.f13495O000000o;
                }
                if (amount >= ((double) bzn.f13495O000000o)) {
                    this.O0000O0o.add(bzn);
                } else if (amount > 3000.0d && i == 0 && "BFL".equals(bzn.O00000Oo)) {
                    this.O0000O0o.add(bzn);
                }
            }
        }
        if (this.O0000O0o.size() == 0) {
            this.O0000OoO.findViewById(R.id.emi_pane).setVisibility(8);
            ((LinearLayout) this.O0000OoO.findViewById(R.id.ll_emi_less_than_min)).setVisibility(0);
            ((CustomTextView) this.O0000OoO.findViewById(R.id.emi_less_than_min_tip)).setText(this.O00000oo.getResources().getString(R.string.emi_amount_less_than_min, Float.valueOf(f)));
            ((Button) this.O0000OoO.findViewById(R.id.bt_back_pay)).setOnClickListener(new View.OnClickListener() {
                /* class _m_j.bzb.AnonymousClass2 */

                public final void onClick(View view) {
                    ((Activity) bzb.this.O00000oo).onBackPressed();
                }
            });
            return;
        }
        this.O0000OoO.findViewById(R.id.emi_pane).setVisibility(0);
        this.O0000OoO.findViewById(R.id.ll_emi_less_than_min).setVisibility(8);
        if (this.O0000O0o.size() > 0) {
            bzn bzn2 = this.O0000O0o.get(0);
            if ("BFL".equals(bzn2.O00000Oo) && !bzn2.O00000o.booleanValue() && this.O0000O0o.size() > 1) {
                bzn2 = this.O0000O0o.get(1);
            }
            bzn2.O00000oo = true;
            this.O0000Oo.O0000ooO = bzn2.O0000OOo;
            if (bzn2.O00000oO != null && bzn2.O00000oO.size() > 0) {
                this.O0000Oo.O0000oOO = bzn2.O00000oO.get(0).f13496O000000o;
                this.O0000Oo.O0000oo0 = bzn2.O00000oO.get(0).O00000oO;
                this.O0000Oo.O0000oOo = bzn2.O00000Oo;
            }
            for (int i2 = 0; i2 < this.O0000O0o.size(); i2++) {
                bzn bzn3 = this.O0000O0o.get(i2);
                if (bzn3.O00000oO != null && bzn3.O00000oO.size() > 0) {
                    bzn3.O00000oO.get(0).O0000O0o = true;
                }
            }
        }
        this.f13447O000000o = (CustomTextView) this.O0000OoO.findViewById(R.id.tv_bank_special);
        this.O00000Oo = (CustomTextView) this.O0000OoO.findViewById(R.id.tv_month_special);
        this.O00000o0 = (CustomTextView) this.O0000OoO.findViewById(R.id.tv_bfl_less_than_min);
        if (this.O0000O0o.size() > 0) {
            bzn bzn4 = this.O0000O0o.get(0);
            if ("BFL".equals(bzn4.O00000Oo) && !bzn4.O00000o.booleanValue() && this.O0000O0o.size() > 1) {
                bzn4 = this.O0000O0o.get(1);
            }
            this.f13447O000000o.setText(bzn4.O0000O0o);
            if (bzn4.O00000oO.size() > 0) {
                this.O00000Oo.setText(bzn4.O00000oO.get(0).O0000OOo);
            }
        }
        this.O00000o = (NoScrollGridView) this.O0000OoO.findViewById(R.id.bank_grid_view);
        this.O00000oO = new O000000o(this.O00000oo);
        this.O00000oO.O000000o(this.O0000O0o);
        this.O00000o.setAdapter((ListAdapter) this.O00000oO);
        this.O0000Ooo = (NoScrollListView) this.O0000OoO.findViewById(R.id.plan_list_view);
        this.O0000OOo = new O00000o0(this.O00000oo);
        this.O0000Ooo.setAdapter((ListAdapter) this.O0000OOo);
        O00000Oo();
    }

    private void O00000Oo() {
        this.O0000Oo0 = null;
        int i = 0;
        while (true) {
            if (i >= this.O0000O0o.size()) {
                break;
            } else if (this.O0000O0o.get(i).O00000oo) {
                this.O0000Oo0 = this.O0000O0o.get(i);
                break;
            } else {
                i++;
            }
        }
        bzn bzn = this.O0000Oo0;
        if (bzn != null) {
            this.O0000OOo.O000000o(bzn.O00000oO);
        }
    }

    public class O000000o extends ArrayAdapter<bzn> {
        public final /* synthetic */ void O000000o(View view, final int i, Object obj) {
            final bzn bzn = (bzn) obj;
            O00000Oo o00000Oo = (O00000Oo) view.getTag();
            if (bzl.O000000o(bzn.O00000Oo.toUpperCase()) != null) {
                o00000Oo.O00000o0.setImageDrawable(bzl.O000000o(bzn.O00000Oo.toUpperCase()));
            } else if (!TextUtils.isEmpty(bzn.O00000o0)) {
                cbq.O000000o(bzn.O00000o0, o00000Oo.O00000o0);
            } else {
                o00000Oo.O00000o0.setImageDrawable(null);
            }
            if (bzn.O00000oo) {
                o00000Oo.f13451O000000o.setVisibility(0);
                o00000Oo.O00000Oo.setVisibility(0);
            } else {
                o00000Oo.f13451O000000o.setVisibility(8);
                o00000Oo.O00000Oo.setVisibility(8);
            }
            if ("BFL".equals(bzn.O00000Oo)) {
                if (bzn.O00000o.booleanValue()) {
                    o00000Oo.O00000o.setVisibility(0);
                    bzb.this.O00000o0.setVisibility(8);
                } else {
                    view.setEnabled(false);
                    o00000Oo.O00000o0.setImageDrawable(this.O00000o.getResources().getDrawable(R.drawable.netbank_bfl_grey));
                    bzb.this.O00000o0.setText(bzn.O0000Oo0);
                    bzb.this.O00000o0.setVisibility(0);
                    bzb.this.O00000o0.setWidth(bzb.this.O00000o.getColumnWidth());
                }
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.bzb.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    cbe.O000000o(String.format("bank%s_click", Integer.valueOf(i + 1)), "EMI");
                    bzb.this.O0000Oo0 = bzn;
                    if (bzb.this.O0000Oo0.O00000Oo.equals("BFL")) {
                        cbe.O000000o("pay_channel_click", "EMI", "key", bzb.this.O0000Oo0.O00000Oo);
                        bzb.this.O0000Oo.O000000o(true);
                        bzb.this.O0000Oo.O0000ooO = bzb.this.O0000Oo0.O0000OOo;
                    } else {
                        bzb.this.O0000Oo.O000000o(false);
                    }
                    bzb.this.O0000Oo.O0000oOo = bzb.this.O0000Oo0.O00000Oo;
                    bzn.O00000oo = true;
                    for (int i = 0; i < bzb.this.O0000O0o.size(); i++) {
                        if (!bzb.this.O0000O0o.get(i).equals(bzn)) {
                            bzb.this.O0000O0o.get(i).O00000oo = false;
                        }
                    }
                    bzb.this.O00000oO.notifyDataSetChanged();
                    if (!(bzb.this.O0000Oo0 == null || bzb.this.O0000OOo == null)) {
                        bzb.this.O0000OOo.O000000o(bzb.this.O0000Oo0.O00000oO);
                    }
                    bzb.this.f13447O000000o.setText(bzn.O0000O0o);
                    if (bzn.O00000oO.size() > 0) {
                        bzb.this.O00000Oo.setText(bzn.O00000oO.get(0).O0000OOo);
                    }
                }
            });
        }

        public O000000o(Context context) {
            super(context);
        }

        public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_buy_confirm_payment_emi_bank, (ViewGroup) null);
            O00000Oo o00000Oo = new O00000Oo();
            o00000Oo.O00000o0 = (SimpleDraweeView) inflate.findViewById(R.id.bank_logo);
            o00000Oo.f13451O000000o = (ImageView) inflate.findViewById(R.id.bank_logo_border);
            o00000Oo.O00000Oo = (ImageView) inflate.findViewById(R.id.bank_logo_corner);
            o00000Oo.O00000o = (CustomTextView) inflate.findViewById(R.id.bank_no_cost_emi);
            inflate.setTag(o00000Oo);
            return inflate;
        }
    }

    public class O00000o0 extends ArrayAdapter<bzo> {
        private Context O00000Oo;

        public final /* synthetic */ void O000000o(View view, final int i, Object obj) {
            final bzo bzo = (bzo) obj;
            O00000o o00000o = (O00000o) view.getTag();
            if (bzo.O0000O0o) {
                o00000o.O00000Oo.setVisibility(0);
                o00000o.f13452O000000o.setVisibility(0);
            } else {
                o00000o.O00000Oo.setVisibility(8);
                o00000o.f13452O000000o.setVisibility(8);
            }
            o00000o.O00000oO.setText(bzo.O00000oo);
            CustomTextView customTextView = o00000o.O00000o;
            customTextView.setText(cad.O00000o0() + bzo.O00000o);
            o00000o.O00000o0.setText(bzo.O00000o0);
            view.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.bzb.O00000o0.AnonymousClass1 */

                public final void onClick(View view) {
                    cbe.O000000o(String.format("plan%s_click", Integer.valueOf(i + 1)), "EMI");
                    if ("BFL".equals(bzb.this.O0000Oo0.O00000Oo)) {
                        cbe.O000000o("pay_plan_click", "EMI", "key", bzo.O00000oo);
                    }
                    bzo.O0000O0o = true;
                    for (int i = 0; i < bzb.this.O0000Oo0.O00000oO.size(); i++) {
                        if (!bzb.this.O0000Oo0.O00000oO.get(i).equals(bzo)) {
                            bzb.this.O0000Oo0.O00000oO.get(i).O0000O0o = false;
                        }
                    }
                    bzb.this.O0000OOo.notifyDataSetChanged();
                    bzb.this.O00000Oo.setText(bzo.O0000OOo);
                    bzb.this.O0000Oo.O0000oOO = bzo.f13496O000000o;
                    bzb.this.O0000Oo.O0000oo0 = bzo.O00000oO;
                    bzb.this.O0000Oo.O0000oo = bzo.O00000oo;
                    bzb.this.O0000Oo.O00000Oo();
                }
            });
        }

        public O00000o0(Context context) {
            super(context);
            this.O00000Oo = context;
        }

        public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_buy_confirm_payment_emi_plan, (ViewGroup) null);
            O00000o o00000o = new O00000o();
            o00000o.O00000oO = (CustomTextView) inflate.findViewById(R.id.emi_tenure);
            o00000o.O00000o = (CustomTextView) inflate.findViewById(R.id.emi_monthly_installment);
            o00000o.O00000o0 = (CustomTextView) inflate.findViewById(R.id.emi_interest);
            o00000o.O00000Oo = (ImageView) inflate.findViewById(R.id.plan_border);
            o00000o.f13452O000000o = (ImageView) inflate.findViewById(R.id.plan_corner);
            inflate.setTag(o00000o);
            return inflate;
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        ImageView f13451O000000o;
        ImageView O00000Oo;
        CustomTextView O00000o;
        SimpleDraweeView O00000o0;

        O00000Oo() {
        }
    }

    static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        ImageView f13452O000000o;
        ImageView O00000Oo;
        CustomTextView O00000o;
        CustomTextView O00000o0;
        CustomTextView O00000oO;

        O00000o() {
        }
    }
}
