package com.mobikwik.sdk.ui.frag;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.fragment.app.Fragment;
import com.mobikwik.sdk.PGWebView;
import com.mobikwik.sdk.lib.Transaction;
import com.mobikwik.sdk.lib.model.PaymentsMappingAPIResponse;
import com.mobikwik.sdk.lib.payapi.CCAvenuePaymentApi;
import com.mobikwik.sdk.lib.payapi.MBKPaymentAPI;
import com.mobikwik.sdk.lib.payapi.ZaakpayPaymentAPI;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.PaymentOptionsDecoder;
import com.mobikwik.sdk.ui.data.a;
import com.mobikwik.sdk.ui.data.b;
import com.xiaomi.smarthome.R;
import java.io.Serializable;

public class m extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private PaymentsMappingAPIResponse.PaymentsMapping f5323a;
    private Activity b;
    private Transaction c;
    private String d;
    private b e;

    private void a(Spinner spinner) {
        int bankPositionForBankId = PaymentOptionsDecoder.getBankPositionForBankId(this.f5323a.getNetBankingMappings(), this.b.getPreferences(0).getString("key_bank_id", ""));
        if (bankPositionForBankId > 0) {
            spinner.setSelection(bankPositionForBankId);
        }
    }

    private void a(String str) {
        SharedPreferences.Editor edit = this.b.getPreferences(0).edit();
        edit.putString("key_bank_id", str);
        edit.commit();
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.mobikwik.sdk.lib.payapi.ZaakpayPaymentAPI] */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.mobikwik.sdk.lib.payapi.MBKPaymentAPI] */
    /* JADX WARN: Type inference failed for: r5v10, types: [com.mobikwik.sdk.lib.payapi.CCAvenuePaymentApi] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void a(int i) {
        ? r2;
        int i2 = i;
        if (Network.isConnected(this.b)) {
            String bankCodeForPaymentOption = PaymentOptionsDecoder.getBankCodeForPaymentOption(this.f5323a.getNetBankingMappings(), i2);
            a(bankCodeForPaymentOption);
            PaymentsMappingAPIResponse.PaymentsMapping paymentsMapping = this.f5323a;
            String pGUrlForPaymentOption = PaymentOptionsDecoder.getPGUrlForPaymentOption(paymentsMapping, paymentsMapping.getNetBankingMappings(), i2);
            if (i2 != 0) {
                String pgResponseUrl = this.e.f().getPgResponseUrl();
                if (bankCodeForPaymentOption.startsWith("CCAVE")) {
                    String substring = bankCodeForPaymentOption.substring(bankCodeForPaymentOption.indexOf(":") + 1, bankCodeForPaymentOption.length());
                    String cCAVMerchantIdForAmount = PaymentOptionsDecoder.getCCAVMerchantIdForAmount(this.d, this.e.j(), this.f5323a);
                    String pgResponseUrl2 = this.e.f().getPgResponseUrl();
                    String checksumUrl = this.e.f().getChecksumUrl();
                    if (this.e.j()) {
                        pgResponseUrl2 = b.b(this.b).k();
                    }
                    r2 = new CCAvenuePaymentApi(this.c.getUser(), this.d, this.c.getOrderId(), substring, "netBanking", this.e.f().getMode(), this.e.j(), this.e.f().getMbkId(), pGUrlForPaymentOption, pgResponseUrl2, checksumUrl, cCAVMerchantIdForAmount);
                } else if (bankCodeForPaymentOption.startsWith("MBK")) {
                    r2 = new MBKPaymentAPI(bankCodeForPaymentOption.substring(bankCodeForPaymentOption.indexOf(":") + 1, bankCodeForPaymentOption.length()), this.c.getUser(), this.d, this.c.getOrderId(), this.e.f().getMode(), this.e.f().getMbkId(), this.c.getAmount(), true, a.a(this.b, this.c.getUser()), this.e.f().getMerchantName(), this.e.i());
                } else {
                    String zaakpayMerchantIdForAmount = PaymentOptionsDecoder.getZaakpayMerchantIdForAmount(this.d, this.e.j(), this.f5323a);
                    String substring2 = bankCodeForPaymentOption.substring(bankCodeForPaymentOption.indexOf(":") + 1, bankCodeForPaymentOption.length());
                    String pgResponseUrl3 = this.e.f().getPgResponseUrl();
                    String checksumUrl2 = this.e.f().getChecksumUrl();
                    if (this.e.j()) {
                        pgResponseUrl3 = b.b(this.b).k();
                    }
                    r2 = new ZaakpayPaymentAPI(substring2, this.c.getUser(), this.d, this.c.getOrderId(), this.e.f().getMode(), this.e.j(), this.e.f().getMbkId(), pGUrlForPaymentOption, pgResponseUrl3, checksumUrl2, zaakpayMerchantIdForAmount);
                }
                Intent intent = new Intent();
                intent.setClass(this.b.getBaseContext(), PGWebView.class);
                intent.putExtra("KEY_API", (Serializable) r2);
                intent.putExtra("KEY_IS_WALLET", this.e.j());
                intent.putExtra("KEY_PG_AMOUNT", this.d);
                intent.putExtra("KEY_RESPONSE_URL", pgResponseUrl);
                this.b.startActivityForResult(intent, 0);
            }
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.b = activity;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = b.b(this.b).d();
        this.e = b.b(this.b);
        this.f5323a = this.e.j() ? b.b(this.b).c().getBankMappingMobikwik() : b.b(this.b).c().getBankMappingMerchant();
        this.d = this.e.j() ? b.b(this.b).e() : this.c.getAmount();
        View inflate = layoutInflater.inflate((int) R.layout.mk_frag_netbanking, viewGroup, false);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.spinner_netBanking);
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(this.b, 17367043, PaymentOptionsDecoder.getNames(this.f5323a.getNetBankingMappings())));
        inflate.findViewById(R.id.btnNetbankingContinue).setOnClickListener(new n(this, spinner));
        a(spinner);
        return inflate;
    }
}
