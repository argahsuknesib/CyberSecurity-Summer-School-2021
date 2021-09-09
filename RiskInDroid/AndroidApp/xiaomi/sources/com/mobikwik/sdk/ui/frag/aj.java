package com.mobikwik.sdk.ui.frag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.mobikwik.sdk.PGWebView;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.Transaction;
import com.mobikwik.sdk.lib.TransactionConfiguration;
import com.mobikwik.sdk.lib.model.PaymentsMappingAPIResponse;
import com.mobikwik.sdk.lib.model.SavedCardResponse;
import com.mobikwik.sdk.lib.payapi.MBKPaymentAPI;
import com.mobikwik.sdk.lib.payapi.ZaakpayPaymentAPI;
import com.mobikwik.sdk.lib.payinstrument.Card;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.PaymentOptionsDecoder;
import com.mobikwik.sdk.lib.utils.Utils;
import com.mobikwik.sdk.ui.data.a;
import com.mobikwik.sdk.ui.data.b;

public class aj extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private PaymentsMappingAPIResponse.PaymentsMapping.ZaakPayPublicKey f5311a;
    protected String b;
    protected String c;
    String d = null;
    String e;
    protected String f;
    protected String g;
    int h = 0;
    protected SavedCardResponse.CardDetails i;
    protected boolean j;
    protected Activity k;
    protected Transaction l;
    protected TransactionConfiguration m;
    protected PaymentsMappingAPIResponse.PaymentsMapping n;
    protected String o;
    protected String p;
    protected String q;
    protected boolean r;
    private boolean s;
    private String t;

    /* access modifiers changed from: protected */
    public String a() {
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.mobikwik.sdk.lib.payapi.ZaakpayPaymentAPI} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: com.mobikwik.sdk.lib.payapi.ZaakpayPaymentAPI} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: com.mobikwik.sdk.lib.payapi.MBKPaymentAPI} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: com.mobikwik.sdk.lib.payapi.ZaakpayPaymentAPI} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    public void b() {
        ZaakpayPaymentAPI zaakpayPaymentAPI;
        if (Network.isConnected(this.k)) {
            Card.Builder builder = new Card.Builder();
            builder.setCardCVV(this.g);
            SavedCardResponse.CardDetails cardDetails = this.i;
            if (cardDetails == null) {
                builder.setCardExpMonth(this.b).setCardExpYear(this.c).setCardNumber(this.f).setNameOnCard(a());
                builder.setStoreThisCard(this.j);
            } else {
                builder.setCardId(cardDetails.cardId);
            }
            Card build = builder.build();
            if (PaymentOptionsDecoder.getBankCodeForPaymentOption(this.n.getCreditCardMappings(), 1).startsWith("MBK")) {
                this.s = true;
                b b2 = b.b(this.k);
                zaakpayPaymentAPI = new MBKPaymentAPI(build, this.n.getMbkKey(), this.l.getUser(), this.p, this.l.getOrderId(), this.m.getMode(), this.m.getMbkId(), this.l.getAmount(), true, a.a(this.k, this.l.getUser()), b2.f().getMerchantName(), b2.i());
            } else {
                this.e = PaymentOptionsDecoder.getZaakpayMerchantIdForAmount(this.p, this.r, this.n);
                if (this.e != null) {
                    Utils.print("ZaakpayCardPaymentFragment.payNow() " + this.e);
                    this.f5311a = PaymentOptionsDecoder.getZaakpayKeyForMerchantId(this.e, this.n);
                    if (this.f5311a != null) {
                        Utils.print("ZaakpayCardPaymentFragment.payNow() " + this.f5311a);
                        PaymentsMappingAPIResponse.PaymentsMapping paymentsMapping = this.n;
                        zaakpayPaymentAPI = new ZaakpayPaymentAPI(build, this.f5311a, this.l.getUser(), this.p, this.l.getOrderId(), this.m.getMode(), this.r, this.m.getMbkId(), PaymentOptionsDecoder.getPGUrlForPaymentOption(paymentsMapping, paymentsMapping.getCreditCardMappings(), 1), this.t, this.m.getChecksumUrl(), this.e);
                    }
                }
                Utils.sendResultBack(this.k, null, SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
                return;
            }
            Intent intent = new Intent();
            intent.setClass(this.k.getBaseContext(), PGWebView.class);
            intent.putExtra("KEY_API", zaakpayPaymentAPI);
            intent.putExtra("KEY_IS_WALLET", this.r);
            intent.putExtra("KEY_PG_AMOUNT", this.p);
            intent.putExtra("KEY_RESPONSE_URL", this.t);
            this.k.startActivityForResult(intent, 0);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.k = activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.l = b.b(this.k).d();
        this.m = b.b(this.k).f();
        this.o = this.m.getMerchantName();
        this.r = b.b(this.k).j();
        if (this.r) {
            this.n = b.b(this.k).c().getBankMappingMobikwik();
            this.p = b.b(this.k).e();
            str = b.b(this.k).k();
        } else {
            this.n = b.b(this.k).c().getBankMappingMerchant();
            this.p = this.l.getAmount();
            str = this.m.getPgResponseUrl();
        }
        this.t = str;
        Utils.print("ZaakpayCardPaymentFragment Amount " + this.p);
        this.e = PaymentOptionsDecoder.getZaakpayMerchantIdForAmount(this.p, this.r, this.n);
        Utils.print("ZaakpayCardPaymentFragment merchantId " + this.e);
        String str2 = this.e;
        if (str2 != null) {
            this.f5311a = PaymentOptionsDecoder.getZaakpayKeyForMerchantId(str2, this.n);
            Utils.print("ZaakpayCardPaymentFragment zaakpayKey " + this.f5311a);
            if (this.f5311a != null) {
                return super.onCreateView(layoutInflater, viewGroup, bundle);
            }
        }
        Utils.sendResultBack(this.k, null, SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
        return null;
    }
}
