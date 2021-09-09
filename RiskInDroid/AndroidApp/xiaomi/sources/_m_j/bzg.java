package _m_j;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.fragment.app.Fragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.buy.payu.PayU;
import com.mi.global.shop.widget.CommonButton;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollGridView;
import com.payu.sdk.Params;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bzg extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    public O0000O0o f13458O000000o;
    public String O00000Oo = "";
    public ArrayList<O000000o> O00000o;
    public ArrayList<O000000o> O00000o0;
    public O00000Oo O00000oO;
    private View O00000oo;
    private NoScrollGridView O0000O0o;

    public final void onCreate(Bundle bundle) {
        ccr.O00000Oo("NBfragment", "onCreate");
        super.onCreate(bundle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ccr.O00000Oo("NBfragment", "onCreateView");
        View view = this.O00000oo;
        if (view == null) {
            this.O00000oo = layoutInflater.inflate((int) R.layout.shop_buy_confirm_payment_netbank, viewGroup, false);
            this.O00000o0 = new ArrayList<>();
            this.O00000o = new ArrayList<>();
            if (PayU.O00000Oo != null && PayU.O00000Oo.has("all_json")) {
                try {
                    JSONObject jSONObject = new JSONObject(PayU.O00000Oo.optString("all_json"));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String obj = keys.next().toString();
                        String obj2 = jSONObject.getJSONObject(obj).get("name").toString();
                        String obj3 = jSONObject.getJSONObject(obj).get("img").toString();
                        if (jSONObject.getJSONObject(obj).get("enable").toString().equalsIgnoreCase("true")) {
                            O000000o o000000o = new O000000o();
                            o000000o.f13460O000000o = obj;
                            o000000o.O00000Oo = obj2;
                            o000000o.O00000o0 = obj3;
                            this.O00000o0.add(o000000o);
                        }
                    }
                    ccr.O00000Oo("NBfragment", "Get all bank:" + this.O00000o0.size());
                    JSONArray jSONArray = PayU.O00000Oo.getJSONArray("recommend");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String obj4 = jSONArray.get(i).toString();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= this.O00000o0.size()) {
                                break;
                            }
                            O000000o o000000o2 = this.O00000o0.get(i2);
                            if (o000000o2.f13460O000000o.equalsIgnoreCase(obj4)) {
                                O000000o o000000o3 = new O000000o();
                                o000000o3.f13460O000000o = o000000o2.f13460O000000o;
                                o000000o3.O00000o0 = o000000o2.O00000o0;
                                o000000o3.O00000Oo = o000000o2.O00000Oo;
                                this.O00000o.add(o000000o3);
                                break;
                            }
                            i2++;
                        }
                    }
                    ccr.O00000Oo("NBfragment", "initData Done, recommed:" + this.O00000o.size());
                } catch (Exception e) {
                    ccr.O00000Oo("NBfragment", "initData Exception:" + e.toString());
                }
            }
            View view2 = this.O00000oo;
            this.f13458O000000o = new O0000O0o();
            this.O0000O0o = (NoScrollGridView) view2.findViewById(R.id.buy_confirm_netbank_grid_view);
            this.O00000oO = new O00000Oo(getActivity());
            this.O00000oO.O000000o((List) this.O00000o);
            this.O0000O0o.setAdapter((ListAdapter) this.O00000oO);
            this.f13458O000000o.f13465O000000o = (Spinner) view2.findViewById(R.id.buy_confirm_payment_netbank_droplist);
            this.f13458O000000o.O00000o = (CommonButton) view2.findViewById(R.id.buy_confirm_netbank_payorder);
            this.f13458O000000o.O00000o.setEnabled(false);
            this.f13458O000000o.O00000Oo = (ImageView) view2.findViewById(R.id.bank_logo_border);
            this.f13458O000000o.O00000o0 = (ImageView) view2.findViewById(R.id.bank_logo_corner);
            String[] strArr = new String[(this.O00000o0.size() + 1)];
            strArr[0] = byl.O00000oO().getString(R.string.buy_confirm_NetBank_choosepromote);
            for (int i3 = 1; i3 < strArr.length; i3++) {
                strArr[i3] = this.O00000o0.get(i3 - 1).O00000Oo;
            }
            if (strArr.length > 1) {
                Arrays.sort(strArr, 1, strArr.length);
            }
            this.f13458O000000o.f13465O000000o.setAdapter((SpinnerAdapter) new ArrayAdapter(byl.O00000oO(), (int) R.layout.shop_buy_confirm_payment_spinneritem, strArr));
            this.f13458O000000o.f13465O000000o.setOnItemSelectedListener(new O00000o());
            this.f13458O000000o.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.bzg.AnonymousClass1 */

                public final void onClick(View view) {
                    if (TextUtils.isEmpty(bzg.this.O00000Oo)) {
                        ccr.O00000Oo("NBfragment", "bank Code = null.");
                        return;
                    }
                    Params params = new Params();
                    params.put("bankcode", bzg.this.O00000Oo);
                    ccr.O00000Oo("NBfragment", "submit bank Code = " + bzg.this.O00000Oo);
                    bzt.O000000o(((ConfirmActivity) bzg.this.getActivity()).getconfirmOrder().f4863O000000o, "payu_india", "netbank", (ConfirmActivity) bzg.this.getActivity(), PayU.PaymentMode.NB, params, "", "", "", "", "");
                }
            });
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.O00000oo);
                ccr.O00000Oo("NBfragment", "onCreateView remove from parent");
            }
        }
        return this.O00000oo;
    }

    class O00000o implements AdapterView.OnItemSelectedListener {
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }

        O00000o() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            ccr.O00000Oo("NBfragment", "onItemSelected position:".concat(String.valueOf(i)));
            if (i == 0) {
                bzg bzg = bzg.this;
                bzg.O00000Oo = "";
                bzg.f13458O000000o.O00000o.setEnabled(false);
                bzg.this.f13458O000000o.O00000Oo.setVisibility(4);
                bzg.this.f13458O000000o.O00000o0.setVisibility(4);
            } else {
                CustomTextView customTextView = (CustomTextView) view;
                if (customTextView != null) {
                    String charSequence = customTextView.getText().toString();
                    ccr.O00000Oo("NBfragment", "onItemSelected name on position:".concat(String.valueOf(charSequence)));
                    bzg.this.f13458O000000o.O00000o.setEnabled(true);
                    bzg.this.O00000Oo = "";
                    for (int i2 = 0; i2 < bzg.this.O00000o0.size(); i2++) {
                        if (charSequence.equalsIgnoreCase(bzg.this.O00000o0.get(i2).O00000Oo)) {
                            bzg bzg2 = bzg.this;
                            bzg2.O00000Oo = bzg2.O00000o0.get(i2).f13460O000000o;
                        }
                    }
                    ccr.O00000Oo("NBfragment", "onItemSelected Bank code:" + bzg.this.O00000Oo);
                    bzg.this.f13458O000000o.O00000Oo.setVisibility(0);
                    bzg.this.f13458O000000o.O00000o0.setVisibility(0);
                } else {
                    return;
                }
            }
            for (int i3 = 0; i3 < bzg.this.O00000o.size(); i3++) {
                bzg.this.O00000o.get(i3).O00000o = Boolean.FALSE;
            }
            bzg.this.O00000oO.notifyDataSetChanged();
        }
    }

    class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public Spinner f13465O000000o;
        public ImageView O00000Oo;
        public CommonButton O00000o;
        public ImageView O00000o0;

        O0000O0o() {
        }
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f13460O000000o = "";
        public String O00000Oo = "";
        public Boolean O00000o = Boolean.FALSE;
        public String O00000o0 = "";

        public O000000o() {
        }
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        ImageView f13464O000000o;
        ImageView O00000Oo;
        SimpleDraweeView O00000o0;

        O00000o0() {
        }
    }

    public class O00000Oo extends com.mi.global.shop.adapter.util.ArrayAdapter<O000000o> {
        private Context O00000Oo;
        private O00000o0 O00000o0;

        public final /* synthetic */ void O000000o(View view, int i, Object obj) {
            final O000000o o000000o = (O000000o) obj;
            O00000o0 o00000o0 = (O00000o0) view.getTag();
            if (bzl.O000000o(o000000o.f13460O000000o) != null) {
                o00000o0.O00000o0.setImageDrawable(bzl.O000000o(o000000o.f13460O000000o));
            } else {
                Uri parse = Uri.parse(o000000o.O00000o0);
                if (parse != null) {
                    cbq.O000000o(parse, o00000o0.O00000o0);
                }
            }
            if (o000000o.O00000o.booleanValue()) {
                o00000o0.f13464O000000o.setVisibility(0);
                o00000o0.O00000Oo.setVisibility(0);
            } else {
                o00000o0.f13464O000000o.setVisibility(4);
                o00000o0.O00000Oo.setVisibility(4);
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.bzg.O00000Oo.AnonymousClass1 */

                public final void onClick(View view) {
                    ccr.O00000Oo("NBfragment", "shortcuts clicket, view:" + view.toString());
                    ccr.O00000Oo("NBfragment", "shortcuts clicket, code:" + o000000o.f13460O000000o + ",status:" + o000000o.O00000o);
                    bzg.this.O00000Oo = o000000o.f13460O000000o;
                    if (TextUtils.isEmpty(bzg.this.O00000Oo)) {
                        bzg.this.f13458O000000o.O00000o.setEnabled(false);
                    } else {
                        bzg.this.f13458O000000o.O00000o.setEnabled(true);
                    }
                    for (int i = 0; i < bzg.this.O00000o.size(); i++) {
                        if (!bzg.this.O00000o.get(i).f13460O000000o.equalsIgnoreCase(bzg.this.O00000Oo)) {
                            bzg.this.O00000o.get(i).O00000o = Boolean.FALSE;
                        } else {
                            bzg.this.O00000o.get(i).O00000o = Boolean.TRUE;
                        }
                    }
                    bzg.this.f13458O000000o.O00000Oo.setVisibility(4);
                    bzg.this.f13458O000000o.O00000o0.setVisibility(4);
                    bzg.this.O00000oO.notifyDataSetChanged();
                }
            });
        }

        public O00000Oo(Context context) {
            super(context);
            this.O00000Oo = context;
        }

        public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_buy_confirm_payment_netbank_recommendbank, (ViewGroup) null);
            this.O00000o0 = new O00000o0();
            this.O00000o0.O00000o0 = (SimpleDraweeView) inflate.findViewById(R.id.bank_logo);
            this.O00000o0.f13464O000000o = (ImageView) inflate.findViewById(R.id.bank_logo_border);
            this.O00000o0.O00000Oo = (ImageView) inflate.findViewById(R.id.bank_logo_corner);
            inflate.setTag(this.O00000o0);
            return inflate;
        }
    }
}
