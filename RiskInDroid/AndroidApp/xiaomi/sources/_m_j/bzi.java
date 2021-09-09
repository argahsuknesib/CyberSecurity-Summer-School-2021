package _m_j;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import butterknife.ButterKnife;
import com.mi.global.shop.adapter.PromotionListAdapter;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.buy.PaymentListViewAdapter;
import com.mi.global.shop.buy.model.BuyOrderInfo;
import com.mi.global.shop.buy.model.BuyOrderItem;
import com.mi.global.shop.buy.payu.PayU;
import com.mi.global.shop.model.common.PayOption;
import com.mi.global.shop.newmodel.pay.payinfo.NewPayOption;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.mi.global.shop.widget.dialog.CustomTextDialog;
import com.squareup.wire.Wire;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bzi extends bzf implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private LinearLayout f13473O000000o;
    private ImageView O00000Oo;
    private View O00000o;
    private CustomTextView O00000o0;
    private NoScrollListView O00000oO;
    private PaymentListViewAdapter O00000oo;
    private ArrayList<O00000Oo> O0000O0o = new ArrayList<>();
    private View O0000OOo;
    private View O0000Oo;
    private View O0000Oo0;
    private LinearLayout O0000OoO = null;
    private BuyOrderInfo O0000Ooo;
    private CustomTextView O0000o;
    private PromotionListAdapter O0000o0;
    private NoScrollListView O0000o00;
    private LinearLayout O0000o0O;
    private CustomTextDialog O0000o0o;
    private LinearLayout O0000oO0;

    public void onCreate(Bundle bundle) {
        ccr.O00000Oo("OrderdetailFragment", "onCreate");
        if (bundle != null) {
            ccr.O00000Oo("OrderdetailFragment", "onCreate, savedInstanceState != null");
        }
        super.onCreate(bundle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null) {
            ccr.O00000Oo("OrderdetailFragment", "onCreateView resume from savedInstanceState");
        }
        if (this.O00000o == null) {
            ccr.O00000Oo("OrderdetailFragment", "onCreateView self == null");
            View inflate = layoutInflater.inflate((int) R.layout.shop_buy_confirm_orderdetail, viewGroup, false);
            ButterKnife.bind(inflate);
            this.O0000OoO = (LinearLayout) inflate.findViewById(R.id.orderdetail_tip_payfail);
            this.f13473O000000o = (LinearLayout) inflate.findViewById(R.id.orderdetail_detailist);
            this.O0000o00 = (NoScrollListView) inflate.findViewById(R.id.promoteListView);
            this.O0000o0 = new PromotionListAdapter(getActivity());
            this.O0000o00.setAdapter((ListAdapter) this.O0000o0);
            this.O0000o0O = (LinearLayout) inflate.findViewById(R.id.promotion_bottom_divider);
            this.O0000o0O.setVisibility(8);
            this.O00000Oo = (ImageView) inflate.findViewById(R.id.orderdetail_toggleicon);
            this.O00000o0 = (CustomTextView) inflate.findViewById(R.id.orderdetail_toggletext);
            this.O0000OOo = inflate.findViewById(R.id.card_list_view_separator);
            this.O0000Oo0 = inflate.findViewById(R.id.expandable_list_view_top_separator);
            this.O0000Oo = inflate.findViewById(R.id.expandable_list_view_bottom_separator);
            this.O0000o = (CustomTextView) inflate.findViewById(R.id.orderdetail_confirm_exchange_coupon);
            this.O0000oO0 = (LinearLayout) inflate.findViewById(R.id.layout_exchange_coupon_container);
            this.O00000o0.setOnClickListener(this);
            this.O00000Oo.setOnClickListener(this);
            this.O00000o = inflate;
            O000000o(((ConfirmActivity) getActivity()).getconfirmOrder(), ((ConfirmActivity) getActivity()).getMention());
        } else {
            ccr.O00000Oo("OrderdetailFragment", "onCreateView self != null");
            ViewGroup viewGroup2 = (ViewGroup) this.O00000o.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.O00000o);
                ccr.O00000Oo("OrderdetailFragment", "onCreateView remove from parent");
            }
        }
        ButterKnife.bind(this, this.O00000o);
        return this.O00000o;
    }

    public final void O000000o(Boolean bool) {
        if (this.O0000OoO != null) {
            if (bool.booleanValue()) {
                this.O0000OoO.setVisibility(0);
            } else {
                this.O0000OoO.setVisibility(8);
            }
        }
    }

    private void O000000o(BuyOrderInfo buyOrderInfo, String str) {
        long j;
        CustomTextView customTextView;
        LinearLayout linearLayout;
        BuyOrderInfo buyOrderInfo2 = buyOrderInfo;
        if (this.O00000o == null) {
            ccr.O00000Oo("OrderdetailFragment", "update mOrderdetailFragment selfView ==null, return");
        } else if (buyOrderInfo2 == null) {
            ccr.O00000Oo("OrderdetailFragment", "update mOrderdetailFragment confirmOrder ==null, return");
        } else {
            ccr.O00000Oo("OrderdetailFragment", "update mOrderdetailFragment, confirmOrder=" + buyOrderInfo.toString());
            this.O0000Ooo = buyOrderInfo2;
            LinearLayout linearLayout2 = (LinearLayout) this.O00000o.findViewById(R.id.orderdetail_detailist);
            O000000o o000000o = new O000000o(getActivity());
            o000000o.O000000o((List) buyOrderInfo2.O0000Ooo);
            ((NoScrollListView) this.O00000o.findViewById(R.id.buy_confirm_itemlist)).setAdapter((ListAdapter) o000000o);
            ((CustomTextView) this.O00000o.findViewById(R.id.orderdetail_total)).setText(cad.O00000o0() + bzt.O00000Oo(buyOrderInfo2.O0000O0o));
            CustomTextView customTextView2 = (CustomTextView) this.O00000o.findViewById(R.id.orderdetail_confirm_orderid);
            CustomTextView customTextView3 = (CustomTextView) this.O00000o.findViewById(R.id.orderdetail_confirm_subtotal);
            CustomTextView customTextView4 = (CustomTextView) this.O00000o.findViewById(R.id.orderdetail_confirm_subtotalamount);
            CustomTextView customTextView5 = (CustomTextView) this.O00000o.findViewById(R.id.orderdetail_confirm_shipping);
            CustomTextView customTextView6 = (CustomTextView) this.O00000o.findViewById(R.id.orderdetail_confirm_promote);
            CustomTextView customTextView7 = (CustomTextView) this.O00000o.findViewById(R.id.orderdetail_confirm_total);
            CustomTextView customTextView8 = (CustomTextView) this.O00000o.findViewById(R.id.orderdetail_confirm_consignee);
            CustomTextView customTextView9 = (CustomTextView) this.O00000o.findViewById(R.id.orderdetail_confirm_address);
            CustomTextView customTextView10 = (CustomTextView) this.O00000o.findViewById(R.id.orderdetail_confirm_phone);
            CustomTextView customTextView11 = (CustomTextView) this.O00000o.findViewById(R.id.confirm_ttl_tv);
            int i = 0;
            int i2 = 0;
            double d = 0.0d;
            while (i < buyOrderInfo2.O0000Ooo.size()) {
                try {
                    i2 += Integer.parseInt(buyOrderInfo2.O0000Ooo.get(i).O00000Oo);
                    d += Double.parseDouble(buyOrderInfo2.O0000Ooo.get(i).O00000o0);
                    linearLayout = linearLayout2;
                    customTextView = customTextView11;
                } catch (NumberFormatException e) {
                    linearLayout = linearLayout2;
                    customTextView = customTextView11;
                    ccr.O00000Oo("OrderdetailFragment", "NumberFormatException:" + e.toString());
                }
                i++;
                linearLayout2 = linearLayout;
                customTextView11 = customTextView;
            }
            LinearLayout linearLayout3 = linearLayout2;
            CustomTextView customTextView12 = customTextView11;
            customTextView4.setText(" X".concat(String.valueOf(i2)));
            customTextView5.setText(cad.O00000o0() + bzt.O00000Oo(buyOrderInfo2.O00000oo));
            if (buyOrderInfo2.O00000oO.compareTo("0") == 0) {
                ((LinearLayout) this.O00000o.findViewById(R.id.buy_confirm_promotelayout)).setVisibility(8);
            }
            customTextView6.setText("-" + cad.O00000o0() + bzt.O00000Oo(buyOrderInfo2.O00000oO));
            customTextView3.setText(cad.O00000o0() + bzt.O00000Oo(String.valueOf(d)));
            customTextView2.setText(buyOrderInfo2.f4863O000000o);
            customTextView7.setText(cad.O00000o0() + bzt.O00000Oo(buyOrderInfo2.O0000O0o));
            customTextView8.setText(buyOrderInfo2.O00000o0);
            customTextView9.setText(buyOrderInfo2.O00000o);
            customTextView10.setText(buyOrderInfo2.O00000Oo);
            if (TextUtils.isEmpty(buyOrderInfo2.O0000OoO)) {
                this.O0000oO0.setVisibility(8);
            } else {
                this.O0000oO0.setVisibility(0);
                CustomTextView customTextView13 = this.O0000o;
                customTextView13.setText("-" + cad.O00000o0() + bzt.O00000Oo(buyOrderInfo2.O0000OoO));
            }
            try {
                j = Long.parseLong(buyOrderInfo2.O0000Oo);
            } catch (Exception unused) {
                j = 0;
            }
            CustomTextView customTextView14 = customTextView12;
            customTextView14.setText(buyOrderInfo2.O0000Oo);
            if (((ConfirmActivity) getActivity()).getCountDownUtil() == null) {
                ((ConfirmActivity) getActivity()).setCountDownUtil(new cax(getActivity(), j));
                ((ConfirmActivity) getActivity()).getCountDownUtil().O000000o(customTextView14, getString(R.string.expired_order));
            }
            linearLayout3.setVisibility(8);
            if (this.O0000o00 == null || TextUtils.isEmpty(str)) {
                this.O0000o0O.setVisibility(8);
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    if (jSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i3);
                            bzr bzr = new bzr();
                            bzr.O00000Oo = jSONObject.optString("icon");
                            bzr.O00000o0 = jSONObject.optString("desc");
                            bzr.f13498O000000o = jSONObject.optString("type");
                            bzr.O00000o = jSONObject.optString("wap_url");
                            arrayList.add(bzr);
                        }
                        this.O0000o0.O000000o(arrayList);
                        this.O0000o0O.setVisibility(0);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.O0000O0o = PayU.O0000O0o;
            this.O00000oO = (NoScrollListView) this.O00000o.findViewById(R.id.BaseListView);
            this.O00000oo = new PaymentListViewAdapter(getActivity());
            this.O00000oo.O00000o0();
            this.O00000oo.O000000o((ArrayList) this.O0000O0o);
            this.O00000oO.setAdapter((ListAdapter) this.O00000oo);
            ArrayList<O00000Oo> arrayList2 = this.O0000O0o;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.O0000Oo.setVisibility(0);
            }
            this.O00000oO.setOnItemClickListener(this);
            this.O0000Ooo = buyOrderInfo2;
            ccr.O00000Oo("OrderdetailFragment", "update mOrderdetailFragment finish all");
        }
    }

    class O000000o extends ArrayAdapter<BuyOrderItem> {

        /* renamed from: O000000o  reason: collision with root package name */
        CustomTextView f13474O000000o;
        CustomTextView O00000Oo;
        CustomTextView O00000o0;

        public final /* bridge */ /* synthetic */ void O000000o(View view, int i, Object obj) {
        }

        public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
            BuyOrderItem buyOrderItem = (BuyOrderItem) obj;
            View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_buy_confirm_payment_orderitem, (ViewGroup) null);
            this.f13474O000000o = (CustomTextView) inflate.findViewById(R.id.orderdetail_confirm_itemname);
            this.O00000Oo = (CustomTextView) inflate.findViewById(R.id.orderdetail_confirm_itemamount);
            this.O00000o0 = (CustomTextView) inflate.findViewById(R.id.orderdetail_confirm_itemsubtotal);
            if (!TextUtils.isEmpty(buyOrderItem.f4864O000000o)) {
                this.f13474O000000o.setText(buyOrderItem.f4864O000000o);
            }
            if (!TextUtils.isEmpty(buyOrderItem.O00000Oo)) {
                CustomTextView customTextView = this.O00000Oo;
                customTextView.setText(" X" + buyOrderItem.O00000Oo);
            }
            if (!TextUtils.isEmpty(buyOrderItem.O00000o0)) {
                CustomTextView customTextView2 = this.O00000o0;
                customTextView2.setText(cad.O00000o0() + bzt.O00000Oo(buyOrderItem.O00000o0));
            }
            return inflate;
        }

        public O000000o(Context context) {
            super(context);
        }
    }

    public void onClick(View view) {
        Resources resources = byl.O00000oO().getResources();
        if (this.f13473O000000o.getVisibility() == 8) {
            this.f13473O000000o.setVisibility(0);
            this.O00000o0.setText((int) R.string.buy_confirm_hidedetail);
            this.O00000Oo.setImageDrawable(resources.getDrawable(R.drawable.shop_arrow_up));
            return;
        }
        this.f13473O000000o.setVisibility(8);
        this.O00000o0.setText((int) R.string.buy_confirm_showdetail);
        this.O00000Oo.setImageDrawable(resources.getDrawable(R.drawable.shop_arrow_down));
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f13475O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public String O00000oo;
        public boolean O0000O0o;
        public boolean O0000OOo = false;
        public ArrayList<O00000Oo> O0000Oo = new ArrayList<>();
        public String O0000Oo0;
        public int O0000OoO;

        private static O00000Oo O000000o(NewPayOption newPayOption) {
            O00000Oo o00000Oo = new O00000Oo();
            o00000Oo.f13475O000000o = (String) Wire.get(newPayOption.title, "");
            o00000Oo.O00000Oo = (String) Wire.get(newPayOption.subtitle, "");
            o00000Oo.O0000O0o = ((Boolean) Wire.get(Boolean.valueOf(newPayOption.enable), PayOption.DEFAULT_ENABLE)).booleanValue();
            o00000Oo.O00000o0 = (String) Wire.get(newPayOption.infotitle, "");
            o00000Oo.O00000o = (String) Wire.get(newPayOption.info, "");
            o00000Oo.O00000oO = (String) Wire.get(newPayOption.image, "");
            o00000Oo.O00000oo = (String) Wire.get(newPayOption.key, "");
            o00000Oo.O0000Oo0 = (String) Wire.get(newPayOption.upioptions, "");
            o00000Oo.O0000OoO = ((Integer) Wire.get(Integer.valueOf(newPayOption.upitype), 1)).intValue();
            return o00000Oo;
        }

        public static ArrayList<O00000Oo> O000000o(List<NewPayOption> list) {
            ArrayList<O00000Oo> arrayList = new ArrayList<>();
            if (list != null && list.size() > 0) {
                for (NewPayOption next : list) {
                    O00000Oo O000000o2 = O000000o(next);
                    ArrayList<O00000Oo> arrayList2 = new ArrayList<>();
                    if (next.subOptions != null) {
                        Iterator<NewPayOption> it = next.subOptions.iterator();
                        while (it.hasNext()) {
                            new O00000Oo();
                            arrayList2.add(O000000o(it.next()));
                        }
                    }
                    O000000o2.O0000Oo = arrayList2;
                    arrayList.add(O000000o2);
                }
            }
            return arrayList;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (adapterView == this.O00000oO) {
            Object itemAtPosition = adapterView.getItemAtPosition(i);
            if (itemAtPosition instanceof O00000Oo) {
                O00000Oo o00000Oo = (O00000Oo) itemAtPosition;
                if (!o00000Oo.O0000O0o) {
                    CustomTextDialog.Builder builder = new CustomTextDialog.Builder(getActivity());
                    if (!TextUtils.isEmpty(o00000Oo.O00000o)) {
                        builder.O00000Oo = o00000Oo.O00000o;
                        CustomTextDialog customTextDialog = new CustomTextDialog(builder.f4993O000000o, (byte) 0);
                        View inflate = ((LayoutInflater) builder.f4993O000000o.getSystemService("layout_inflater")).inflate((int) R.layout.shop_custom_text_dialog, (ViewGroup) null);
                        ButterKnife.bind(builder, inflate);
                        if (builder.O00000Oo != null) {
                            builder.tvText.setText(builder.O00000Oo);
                        }
                        customTextDialog.setCanceledOnTouchOutside(true);
                        customTextDialog.setContentView(inflate);
                        this.O0000o0o = customTextDialog;
                        this.O0000o0o.show();
                    }
                } else {
                    ccr.O00000Oo("OrderdetailFragment", "clicked:" + o00000Oo.f13475O000000o);
                    ConfirmActivity confirmActivity = (ConfirmActivity) getActivity();
                    if (confirmActivity != null) {
                        confirmActivity.onPaymentOptionSelected(o00000Oo.O00000oo);
                    }
                }
                cbe.O000000o(String.format("pay_method(%s)", o00000Oo.O00000oo), ConfirmActivity.class.getSimpleName());
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public final void O000000o() {
        O000000o(((ConfirmActivity) getActivity()).getconfirmOrder(), ((ConfirmActivity) getActivity()).getMention());
    }
}
