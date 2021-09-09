package com.mobikwik.sdk;

import android.content.Intent;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.Transaction;
import com.mobikwik.sdk.lib.TransactionConfiguration;
import com.mobikwik.sdk.lib.model.PaymentsMappingAPIResponse;
import com.mobikwik.sdk.lib.model.SavedCardResponse;
import com.mobikwik.sdk.lib.payinstrument.PaymentInstrumentType;
import com.mobikwik.sdk.lib.tasks.GetSavedCards;
import com.mobikwik.sdk.lib.tasks.LoadPaymentsMapping;
import com.mobikwik.sdk.lib.utils.Utils;
import com.mobikwik.sdk.ui.data.b;
import java.util.ArrayList;

class a implements LoadPaymentsMapping.PaymentMappingLoadListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Transaction f5279a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ b c;
    final /* synthetic */ TransactionConfiguration d;
    final /* synthetic */ MobikwikSDK e;

    a(MobikwikSDK mobikwikSDK, Transaction transaction, ArrayList arrayList, b bVar, TransactionConfiguration transactionConfiguration) {
        this.e = mobikwikSDK;
        this.f5279a = transaction;
        this.b = arrayList;
        this.c = bVar;
        this.d = transactionConfiguration;
    }

    public void onMappingLoaded(PaymentsMappingAPIResponse paymentsMappingAPIResponse) {
        if (paymentsMappingAPIResponse == null) {
            if (this.e.b != null && this.e.b.isShowing()) {
                this.e.b.dismiss();
            }
            this.e.a((Intent) null, SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), SDKErrorCodes.INTERNET_NOT_WORKING.getErrorDescription());
            return;
        }
        ArrayList enabledOptions = paymentsMappingAPIResponse.getData().getEnabledOptions();
        if (enabledOptions == null) {
            if (this.e.b != null && this.e.b.isShowing()) {
                this.e.b.dismiss();
            }
            this.e.a((Intent) null, SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), SDKErrorCodes.INTERNET_NOT_WORKING.getErrorDescription());
        } else if (enabledOptions.size() == 0) {
            if (this.e.b != null && this.e.b.isShowing()) {
                this.e.b.dismiss();
            }
            this.e.a((Intent) null, "1", "Payment option not enabled");
        } else {
            if (this.f5279a.getPaymentType() == null) {
                for (int i = 0; i < enabledOptions.size(); i++) {
                    this.b.add(enabledOptions.get(i));
                }
            } else if (enabledOptions.contains(this.f5279a.getPaymentType())) {
                this.b.add(this.f5279a.getPaymentType());
            } else {
                this.e.a((Intent) null, "1", "Payment option not enabled");
                return;
            }
            if (this.f5279a.getUser() == null || Utils.isNull(this.f5279a.getUser().getEmail())) {
                if (!this.b.contains(PaymentInstrumentType.MK_WALLET)) {
                    this.e.a((Intent) null, "1", "Email id null or blank");
                    return;
                } else {
                    this.b.clear();
                    this.b.add(PaymentInstrumentType.MK_WALLET);
                }
            }
            this.c.a(paymentsMappingAPIResponse.getData());
            String fetchSavedCardUrl = this.d.getFetchSavedCardUrl();
            if (Utils.isNull(fetchSavedCardUrl) || !this.b.contains(PaymentInstrumentType.SAVED_CARD) || this.f5279a.getUser() == null) {
                if (this.e.b != null && this.e.b.isShowing()) {
                    this.e.b.dismiss();
                }
                this.e.a(this.b, (SavedCardResponse.CardDetails[]) null);
                return;
            }
            new GetSavedCards(this.e, fetchSavedCardUrl + "?email=" + this.f5279a.getUser().getEmail(), new b(this)).execute(new Void[0]);
        }
    }
}
