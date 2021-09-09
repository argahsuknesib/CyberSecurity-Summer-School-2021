package com.mobikwik.sdk.lib.payinstrument;

import com.mobikwik.sdk.lib.utils.Utils;
import java.io.Serializable;

public class Bank implements PaymentInstrument, Serializable {
    private String bankCode;
    private String bankName;

    public Bank(String str, String str2) {
        this.bankCode = str;
        this.bankName = str2;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public String getBankName() {
        return this.bankName;
    }

    public boolean isValid() {
        return !Utils.isNull(this.bankCode) && !Utils.isNull(this.bankName);
    }
}
