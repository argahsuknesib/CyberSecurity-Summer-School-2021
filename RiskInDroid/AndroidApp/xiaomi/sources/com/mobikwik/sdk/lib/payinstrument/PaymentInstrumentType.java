package com.mobikwik.sdk.lib.payinstrument;

public enum PaymentInstrumentType {
    CREDIT_CARD("CC"),
    DEBIT_CARD("DC"),
    SAVED_CARD("SC"),
    NETBANKING("NB"),
    MK_WALLET("MW");
    
    String type;

    private PaymentInstrumentType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    public final String toString() {
        return this.type;
    }
}
