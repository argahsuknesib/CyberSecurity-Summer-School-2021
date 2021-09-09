package com.mobikwik.sdk.lib.model;

import com.google.gson.Gson;

public class WalletApiRequest {
    public String amount;
    public boolean autoSendOTP;
    public String cardId;
    public String cell;
    public String couponCode;
    public String deviceId;
    public String deviceName;
    public String email;
    public boolean forceFetchCards;
    public String merchantName;
    public String mid;
    public String orderId;
    public String otp;
    public String plateform;
    public String responseURL;
    public String token;
    public String txnHash;

    public String toString() {
        return new Gson().toJson(this);
    }
}
