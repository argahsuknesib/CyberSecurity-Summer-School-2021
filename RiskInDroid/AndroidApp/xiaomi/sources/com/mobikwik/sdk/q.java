package com.mobikwik.sdk;

import com.mobikwik.sdk.lib.payinstrument.PaymentInstrumentType;

/* synthetic */ class q {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f5295a = new int[PaymentInstrumentType.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    static {
        f5295a[PaymentInstrumentType.SAVED_CARD.ordinal()] = 1;
        f5295a[PaymentInstrumentType.CREDIT_CARD.ordinal()] = 2;
        f5295a[PaymentInstrumentType.DEBIT_CARD.ordinal()] = 3;
        try {
            f5295a[PaymentInstrumentType.NETBANKING.ordinal()] = 4;
        } catch (NoSuchFieldError unused) {
        }
    }
}
