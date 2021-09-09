package _m_j;

import _m_j.bzi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.mi.global.shop.activity.PayResultWebActivity;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.buy.adapter.WalletAdapter;
import com.mi.global.shop.buy.model.BuyOrderInfo;
import com.mi.global.shop.buy.payu.PayU;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.pay.payparam.NewPayGoResult;
import com.mi.global.shop.widget.CommonButton;
import com.mi.multimonitor.CrashReport;
import com.mobikwik.sdk.MobikwikSDK;
import com.mobikwik.sdk.lib.Transaction;
import com.mobikwik.sdk.lib.TransactionConfiguration;
import com.mobikwik.sdk.lib.User;
import com.mobikwik.sdk.lib.payinstrument.PaymentInstrumentType;
import com.payu.sdk.Params;
import com.payu.sdk.Payment;
import com.payu.sdk.ProcessPaymentActivity;
import com.payu.sdk.exceptions.HashException;
import com.payu.sdk.exceptions.MissingParameterException;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class bzj extends Fragment implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    HashMap<String, String> f13476O000000o;
    double O00000Oo = -1.0d;
    private View O00000o;
    public bzp O00000o0;
    private CommonButton O00000oO;
    private RecyclerView O00000oo;
    private WalletAdapter O0000O0o;

    public final void onCreate(Bundle bundle) {
        ccr.O00000Oo("Walletfragment", "onCreate");
        super.onCreate(bundle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ccr.O00000Oo("Walletfragment", "onCreateView");
        View view = this.O00000o;
        if (view == null) {
            this.O00000o = layoutInflater.inflate((int) R.layout.shop_buy_confirm_payment_wallet, viewGroup, false);
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.O00000o);
                ccr.O00000Oo("Walletfragment", "onCreateView remove from parent");
            }
        }
        this.O00000oo = (RecyclerView) this.O00000o.findViewById(R.id.wallet_recycleview);
        this.O00000oo.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.O0000O0o = new WalletAdapter(getActivity());
        this.O00000oo.addItemDecoration(new cbx(getActivity(), cdy.O000000o(0.0f), getResources().getColor(R.color.divider_color)));
        this.O00000oo.setAdapter(this.O0000O0o);
        if (PayU.O0000O0o != null && PayU.O0000O0o.size() > 0) {
            Iterator<bzi.O00000Oo> it = PayU.O0000O0o.iterator();
            while (it.hasNext()) {
                bzi.O00000Oo next = it.next();
                if (next.O00000oo.equals("wallet")) {
                    if (next.O0000Oo != null && next.O0000Oo.size() > 0) {
                        for (int i = 0; i < next.O0000Oo.size(); i++) {
                            if (i == 0) {
                                next.O0000Oo.get(i).O0000OOo = true;
                            } else {
                                next.O0000Oo.get(i).O0000OOo = false;
                            }
                        }
                    }
                    WalletAdapter walletAdapter = this.O0000O0o;
                    ArrayList<bzi.O00000Oo> arrayList = next.O0000Oo;
                    if (arrayList != null) {
                        walletAdapter.f4859O000000o.clear();
                        walletAdapter.f4859O000000o.addAll(arrayList);
                        walletAdapter.notifyDataSetChanged();
                    }
                }
            }
        }
        this.O00000oO = (CommonButton) this.O00000o.findViewById(R.id.buy_confirm_wallet_payorder);
        this.O00000oO.setOnClickListener(this);
        return this.O00000o;
    }

    private static String O00000Oo() {
        if (PayU.O0000O0o == null || PayU.O0000O0o.size() <= 0) {
            return "";
        }
        Iterator<bzi.O00000Oo> it = PayU.O0000O0o.iterator();
        while (it.hasNext()) {
            bzi.O00000Oo next = it.next();
            if (next.O00000oo.equals("wallet")) {
                Iterator<bzi.O00000Oo> it2 = next.O0000Oo.iterator();
                while (it2.hasNext()) {
                    bzi.O00000Oo next2 = it2.next();
                    if (next2.O0000OOo) {
                        return next2.O00000oo;
                    }
                }
                continue;
            }
        }
        return "";
    }

    private void O00000Oo(String str, final String str2) {
        Request request;
        Uri.Builder buildUpon = Uri.parse(cav.O000Oooo()).buildUpon();
        buildUpon.appendQueryParameter("id", str);
        buildUpon.appendQueryParameter("bank", str2);
        buildUpon.appendQueryParameter("type", "wallet");
        AnonymousClass1 r3 = new cak<NewPayGoResult>() {
            /* class _m_j.bzj.AnonymousClass1 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                NewPayGoResult newPayGoResult = (NewPayGoResult) baseResult;
                ((ConfirmActivity) bzj.this.getActivity()).hideLoading();
                if (newPayGoResult.data != null) {
                    String str = newPayGoResult.data.params;
                    try {
                        bzj bzj = bzj.this;
                        JSONObject jSONObject = new JSONObject(str);
                        Iterator<String> keys = jSONObject.keys();
                        HashMap<String, String> hashMap = new HashMap<>();
                        PayU.O0000OoO = null;
                        while (keys.hasNext()) {
                            String obj = keys.next().toString();
                            try {
                                if (obj.equals("hash")) {
                                    PayU.O0000OoO = jSONObject.getString("hash");
                                } else if (obj.equals("amount")) {
                                    bzj.O00000Oo = Double.parseDouble(jSONObject.getString("amount"));
                                } else if (obj.equals("supportStoreCards")) {
                                    PayU.O0000o00 = Boolean.parseBoolean(jSONObject.getString("supportStoreCards"));
                                } else if (obj.equals("key")) {
                                    PayU.f4867O000000o = jSONObject.getString("key");
                                }
                                hashMap.put(obj, jSONObject.getString(obj));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        bzj.f13476O000000o = hashMap;
                        if (str2.equals("payu_india")) {
                            bzj.this.O000000o();
                        } else if (str2.equals("mobikwik")) {
                            bzj.this.O00000o0 = bzj.O000000o(str);
                            bzj bzj2 = bzj.this;
                            if (bzj2.O00000o0 == null) {
                                bzj2.O00000Oo("");
                            }
                            TransactionConfiguration transactionConfiguration = new TransactionConfiguration();
                            transactionConfiguration.setDebitWallet(true);
                            transactionConfiguration.setPgResponseUrl(bzj2.O00000o0.O00000oo);
                            transactionConfiguration.setChecksumUrl(bzj2.O00000o0.O00000oO);
                            transactionConfiguration.setMerchantName(bzj2.O00000o0.O0000O0o);
                            transactionConfiguration.setMbkId(bzj2.O00000o0.O00000o);
                            if (!TextUtils.isEmpty(bzj2.O00000o0.O0000OOo)) {
                                ((ConfirmActivity) bzj2.getActivity()).setAfterPaySuccessUrl(cbm.O000000o(bzj2.O00000o0.O0000OOo));
                            }
                            ccr.O00000Oo("Walletfragment", "MbkModel.pg_response_url:" + bzj2.O00000o0.O00000oo);
                            ccr.O00000Oo("Walletfragment", "MbkModel.checksum_url:" + bzj2.O00000o0.O00000oO);
                            ccr.O00000Oo("Walletfragment", "MbkModel.merchant_name:" + bzj2.O00000o0.O0000O0o);
                            ccr.O00000Oo("Walletfragment", "MbkModel.mid:" + bzj2.O00000o0.O00000o);
                            ccr.O00000Oo("Walletfragment", "MbkModel.order_id:" + bzj2.O00000o0.f13497O000000o);
                            ccr.O00000Oo("Walletfragment", "MbkModel.amount:" + bzj2.O00000o0.O00000Oo);
                            if (byl.O0000OOo()) {
                                transactionConfiguration.setMode("0");
                            } else {
                                transactionConfiguration.setMode("1");
                            }
                            Transaction newTransaction = Transaction.Factory.newTransaction(new User("", ""), bzj2.O00000o0.f13497O000000o, bzj2.O00000o0.O00000Oo, PaymentInstrumentType.MK_WALLET);
                            Intent intent = new Intent(bzj2.getActivity(), MobikwikSDK.class);
                            intent.putExtra("MK_EXT_TXN_CONFIG", transactionConfiguration);
                            intent.putExtra("MK_EXT_TXN", newTransaction);
                            bzj2.getActivity().startActivityForResult(intent, 101);
                        } else if (str2.equals("paytm")) {
                            bzj.this.O000000o(str, newPayGoResult.data.ext);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        CrashReport.postCrash(Thread.currentThread(), e2);
                        bzj.this.O00000Oo("");
                    }
                }
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                bzj.this.O00000Oo(str);
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(buildUpon.toString(), NewPayGoResult.class, r3);
        } else {
            request = new cal(buildUpon.toString(), NewPayGoResult.class, r3);
        }
        request.setTag("Walletfragment");
        ced.f13683O000000o.add(request);
        ((ConfirmActivity) getActivity()).showLoading();
    }

    public final void O000000o() throws MissingParameterException, HashException {
        Payment payment = new Payment();
        payment.getClass();
        Payment.Builder builder = new Payment.Builder();
        Params params = new Params();
        HashMap<String, String> hashMap = this.f13476O000000o;
        String[] strArr = {"txnid", "productinfo", "amount", "firstname", "email", "phone", "surl", "furl", "key", "hash"};
        for (int i = 0; i < 10; i++) {
            builder.set(strArr[i], hashMap.get(strArr[i]));
            params.put(strArr[i], hashMap.get(strArr[i]));
        }
        builder.set("mode", PayU.PaymentMode.PAYU_MONEY.toString());
        String O000000o2 = PayU.O000000o(getActivity()).O000000o(builder.create(), params);
        Intent intent = new Intent(getActivity(), ProcessPaymentActivity.class);
        intent.putExtra("postData", O000000o2);
        intent.addFlags(67108864);
        ((ConfirmActivity) getActivity()).startActivityForResult(intent, 100);
    }

    public static bzp O000000o(String str) {
        bzp bzp = new bzp();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bzp.O00000Oo = jSONObject.optString("amount");
            bzp.O00000oO = jSONObject.optString("checksum_url");
            bzp.O0000O0o = jSONObject.optString("merchant_name");
            bzp.O00000o = jSONObject.optString("mid");
            bzp.f13497O000000o = jSONObject.optString("order_id");
            bzp.O00000o0 = jSONObject.optString("payment_type");
            bzp.O00000oo = jSONObject.optString("pg_response_url");
            bzp.O0000OOo = jSONObject.optString("afterPaySuccessUrl");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bzp;
    }

    public final void O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            cec.O000000o(byl.O00000oO(), (int) R.string.buy_confirm_order_payfailed, 1);
        } else {
            cec.O000000o(byl.O00000oO(), str, 1);
        }
        ((ConfirmActivity) getActivity()).hideLoading();
    }

    public final void onClick(View view) {
        Request request;
        if (view == this.O00000oO) {
            try {
                BuyOrderInfo buyOrderInfo = ((ConfirmActivity) getActivity()).getconfirmOrder();
                if (O00000Oo().equals("payu_money")) {
                    O00000Oo(buyOrderInfo.f4863O000000o, "payu_india");
                }
                if (O00000Oo().equals("mobikwik")) {
                    String str = buyOrderInfo.f4863O000000o;
                    Uri.Builder buildUpon = Uri.parse(cav.O000Oooo()).buildUpon();
                    buildUpon.appendQueryParameter("id", str);
                    buildUpon.appendQueryParameter("bank", "mobikwik");
                    buildUpon.appendQueryParameter("type", "wallet");
                    buildUpon.appendQueryParameter("redirect", "1");
                    AnonymousClass2 r1 = new cak<NewPayGoResult>() {
                        /* class _m_j.bzj.AnonymousClass2 */

                        public final /* synthetic */ void O000000o(BaseResult baseResult) {
                            NewPayGoResult newPayGoResult = (NewPayGoResult) baseResult;
                            ((ConfirmActivity) bzj.this.getActivity()).hideLoading();
                            if (newPayGoResult.data != null) {
                                String str = newPayGoResult.data.html;
                                if (TextUtils.isEmpty(str)) {
                                    bzj.this.O00000Oo("");
                                }
                                Intent intent = new Intent(bzj.this.getActivity(), PayResultWebActivity.class);
                                intent.putExtra("htmlString", str);
                                bzj.this.getActivity().startActivityForResult(intent, 101);
                            }
                        }

                        public final void O000000o(String str) {
                            super.O000000o(str);
                            bzj.this.O00000Oo(str);
                        }
                    };
                    if (byl.O0000OoO()) {
                        request = new cam(buildUpon.toString(), NewPayGoResult.class, r1);
                    } else {
                        request = new cal(buildUpon.toString(), NewPayGoResult.class, r1);
                    }
                    request.setTag("Walletfragment");
                    ced.f13683O000000o.add(request);
                    ((ConfirmActivity) getActivity()).showLoading();
                }
                if (O00000Oo().equals("paytm")) {
                    O00000Oo(buyOrderInfo.f4863O000000o, "paytm");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(String str, String str2) {
        cqp cqp;
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (byl.O0000OOo()) {
            cqp = cqp.O00000Oo();
        } else {
            cqp = cqp.O00000o0();
        }
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("afterPaySuccessUrl");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (str2.indexOf("##" + next + "##") == -1) {
                    hashMap.put(next, jSONObject.getString(next));
                }
            }
            final String O000000o2 = cbm.O000000o(string);
            cqp.O000000o(new cqo(hashMap));
            cqp.O000000o(getActivity(), new cqq() {
                /* class _m_j.bzj.AnonymousClass3 */

                public final void O000000o(String str) {
                    Log.d("Payment Transaction", "Payment Transaction : ".concat(String.valueOf(str)));
                }

                public final void O000000o(Bundle bundle) {
                    Log.d("Payment Transaction", "Payment Transaction : " + bundle.toString());
                    try {
                        String string = bundle.getString("RESPCODE");
                        String string2 = bundle.getString("RESPMSG");
                        if (string.equals("01")) {
                            ((ConfirmActivity) bzj.this.getActivity()).onPaytmTransactionSuccess(O000000o2);
                        } else {
                            cec.O000000o(bzj.this.getActivity(), string2, 0);
                        }
                    } catch (Exception unused) {
                        cec.O000000o(bzj.this.getActivity(), "Payment Failed", 0);
                    }
                }

                public final void O000000o() {
                    Log.d("Payment Transaction", "Payment Transaction networkNotAvailable");
                }

                public final void O00000Oo(String str) {
                    Log.d("Payment Transaction", "Payment Transaction ".concat(String.valueOf(str)));
                }

                public final void O00000o0(String str) {
                    Log.d("Payment Transaction", "Payment Transaction Failed ".concat(String.valueOf(str)));
                }

                public final void O00000Oo() {
                    Log.d("Payment Transaction", "Payment Transaction Failed onBackPressedCancelTransaction");
                }
            });
        } catch (Exception unused) {
            cec.O000000o(getActivity(), "params error", 0);
        }
    }
}
