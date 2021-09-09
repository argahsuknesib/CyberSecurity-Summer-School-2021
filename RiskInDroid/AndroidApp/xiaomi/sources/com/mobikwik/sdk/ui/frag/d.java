package com.mobikwik.sdk.ui.frag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.mobikwik.sdk.lib.Transaction;
import com.mobikwik.sdk.lib.TransactionConfiguration;
import com.mobikwik.sdk.lib.model.PaymentsMappingAPIResponse;
import com.mobikwik.sdk.lib.payapi.CCAvenuePaymentApi;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.PaymentOptionsDecoder;
import com.mobikwik.sdk.ui.data.b;
import com.xiaomi.smarthome.R;

public class d extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    a f5314a;
    private PaymentsMappingAPIResponse.PaymentsMapping b;
    /* access modifiers changed from: private */
    public Activity c;
    private Transaction d;
    private TransactionConfiguration e;
    private boolean f;

    public interface a {
        void a(Bundle bundle);
    }

    /* access modifiers changed from: private */
    public void a(Intent intent, boolean z, int i) {
        String str;
        String str2;
        if (z) {
            int i2 = i + 1;
            str2 = PaymentOptionsDecoder.getBankCodeForPaymentOption(this.b.getCreditCardMappings(), i2);
            PaymentsMappingAPIResponse.PaymentsMapping paymentsMapping = this.b;
            str = PaymentOptionsDecoder.getPGUrlForPaymentOption(paymentsMapping, paymentsMapping.getCreditCardMappings(), i2);
        } else {
            int i3 = i + 1;
            str2 = PaymentOptionsDecoder.getBankCodeForPaymentOption(this.b.getDebitCardMappings(), i3);
            PaymentsMappingAPIResponse.PaymentsMapping paymentsMapping2 = this.b;
            str = PaymentOptionsDecoder.getPGUrlForPaymentOption(paymentsMapping2, paymentsMapping2.getDebitCardMappings(), i3);
        }
        String str3 = str;
        if (str2.compareTo("NULL") == 0) {
            return;
        }
        if (!str2.startsWith("CCAVE")) {
            Bundle bundle = new Bundle();
            bundle.putString("bankid", str2);
            bundle.putString("postUrl", str3);
            a aVar = this.f5314a;
            if (aVar != null) {
                aVar.a(bundle);
            }
        } else if (Network.isConnected(this.c)) {
            String amount = this.d.getAmount();
            if (this.f) {
                amount = b.b(this.c).e();
            }
            String str4 = amount;
            String substring = str2.substring(str2.indexOf(":") + 1, str2.length());
            String cCAVMerchantIdForAmount = PaymentOptionsDecoder.getCCAVMerchantIdForAmount(str4, this.f, this.b);
            String str5 = str4;
            CCAvenuePaymentApi cCAvenuePaymentApi = new CCAvenuePaymentApi(this.d.getUser(), str5, this.d.getOrderId(), substring, "NonMoto", this.e.getMode(), this.f, this.e.getMbkId(), str3, this.e.getPgResponseUrl(), this.e.getChecksumUrl(), cCAVMerchantIdForAmount);
            Intent intent2 = new Intent();
            intent2.putExtra("KEY_API", cCAvenuePaymentApi);
            intent2.putExtra("KEY_IS_WALLET", this.f);
            intent2.putExtra("KEY_PG_AMOUNT", str4);
            intent2.putExtra("KEY_RESPONSE_URL", this.e.getPgResponseUrl());
            this.c.startActivityForResult(intent2, 0);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof a) {
            this.f5314a = (a) activity;
        }
        this.c = activity;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = b.b(this.c).d();
        this.e = b.b(this.c).f();
        this.f = b.b(this.c).j();
        this.b = this.f ? b.b(this.c).c().getBankMappingMobikwik() : b.b(this.c).c().getBankMappingMerchant();
        View inflate = layoutInflater.inflate((int) R.layout.mk_frag_debit_cards, viewGroup, false);
        ListView listView = (ListView) inflate.findViewById(R.id.list_debitcards);
        listView.setAdapter((ListAdapter) new ArrayAdapter(this.c, 17367043, PaymentOptionsDecoder.getNames(this.b.getDebitCardMappings())));
        listView.setOnItemClickListener(new e(this));
        if (PaymentOptionsDecoder.isAllCardNonCCAvenue(this.b.getDebitCardMappings())) {
            a(this.c.getIntent(), false, 0);
        }
        return inflate;
    }
}
