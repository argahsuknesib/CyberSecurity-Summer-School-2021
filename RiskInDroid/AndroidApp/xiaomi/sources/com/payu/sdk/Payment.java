package com.payu.sdk;

import com.mi.global.shop.buy.payu.PayU;
import com.payu.sdk.exceptions.MissingParameterException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class Payment extends HashMap<String, String> {
    public String get(String str) {
        String str2 = (String) super.get((Object) str);
        if (str2 == null) {
            str2 = "";
        }
        try {
            if (!str.contentEquals("surl")) {
                if (!str.contentEquals("furl")) {
                    return str2;
                }
            }
            return URLEncoder.encode(str2, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void put(String str, double d) {
        super.put(str, String.valueOf(d));
    }

    public PayU.PaymentMode getMode() {
        return PayU.PaymentMode.valueOf(get("mode"));
    }

    public double getAmount() {
        return Double.valueOf(get("amount")).doubleValue();
    }

    public String getTxnId() {
        return get("txnid");
    }

    public String getProductInfo() {
        return get("productinfo");
    }

    public String getSurl() {
        return get("surl");
    }

    public String getFurl() {
        return get("furl");
    }

    public class Builder {
        private Payment payment = new Payment();

        public Builder() {
        }

        public Builder set(String str, String str2) {
            this.payment.put(str, str2);
            return this;
        }

        public String get(String str) {
            return this.payment.get(str);
        }

        public Payment create() throws MissingParameterException {
            String[] strArr = {"amount", "txnid", "productinfo", "surl", "mode"};
            for (int i = 0; i < 5; i++) {
                String str = strArr[i];
                if (!this.payment.containsKey(str) || this.payment.get(str) == null || this.payment.get(str).equals("")) {
                    throw new MissingParameterException("Missing required parameter".concat(String.valueOf(str)));
                }
            }
            if (Double.valueOf(this.payment.get("amount")).doubleValue() > 0.0d) {
                return this.payment;
            }
            throw new MissingParameterException("Amount cannot be less than zero");
        }
    }
}
