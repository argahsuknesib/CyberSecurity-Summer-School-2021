package com.mobikwik.sdk.lib.utils;

import android.content.Context;
import com.mobikwik.sdk.lib.model.PaymentsMappingAPIResponse;
import com.mobikwik.sdk.lib.payinstrument.Bank;
import com.mobikwik.sdk.lib.tasks.LoadPaymentsMapping;
import java.util.ArrayList;

public class PaymentUtils {

    public interface OnNetBankingLoadListener {
        void onError(String str);

        void onNetBankingLoaded(ArrayList arrayList);
    }

    private static void getNetBankingList(final boolean z, Context context, String str, int i, final OnNetBankingLoadListener onNetBankingLoadListener) {
        new LoadPaymentsMapping(context, str, i, new LoadPaymentsMapping.PaymentMappingLoadListener() {
            /* class com.mobikwik.sdk.lib.utils.PaymentUtils.AnonymousClass1 */

            public final void onMappingLoaded(PaymentsMappingAPIResponse paymentsMappingAPIResponse) {
                if (paymentsMappingAPIResponse == null || paymentsMappingAPIResponse.failure) {
                    OnNetBankingLoadListener.this.onError("Unexcepted Error");
                }
                String[] netBankingMappings = (z ? paymentsMappingAPIResponse.getData().getBankMappingMobikwik() : paymentsMappingAPIResponse.getData().getBankMappingMerchant()).getNetBankingMappings();
                ArrayList arrayList = new ArrayList();
                String[] names = PaymentOptionsDecoder.getNames(netBankingMappings);
                int i = 0;
                while (i < names.length) {
                    String str = names[i];
                    i++;
                    String bankCodeForPaymentOption = PaymentOptionsDecoder.getBankCodeForPaymentOption(netBankingMappings, i);
                    arrayList.add(new Bank(bankCodeForPaymentOption.substring(bankCodeForPaymentOption.indexOf(":") + 1, bankCodeForPaymentOption.length()), str));
                }
                OnNetBankingLoadListener.this.onNetBankingLoaded(arrayList);
            }
        }).execute(new Void[0]);
    }

    public static void getWalletNetBankingList(Context context, String str, int i, OnNetBankingLoadListener onNetBankingLoadListener) {
        getNetBankingList(true, context, str, i, onNetBankingLoadListener);
    }

    public static void getZaakPayNetBankingList(Context context, String str, int i, OnNetBankingLoadListener onNetBankingLoadListener) {
        getNetBankingList(false, context, str, i, onNetBankingLoadListener);
    }
}
