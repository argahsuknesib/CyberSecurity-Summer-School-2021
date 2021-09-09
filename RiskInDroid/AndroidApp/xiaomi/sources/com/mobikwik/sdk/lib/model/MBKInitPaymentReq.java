package com.mobikwik.sdk.lib.model;

import com.mobikwik.sdk.lib.payinstrument.Bank;
import com.mobikwik.sdk.lib.payinstrument.Card;

public class MBKInitPaymentReq {
    public String amount;
    public Card cardBanking;
    public int client;
    public String clientVersion;
    public String deviceId;
    public String deviceName;
    public String memberId;
    public String merchantName;
    public String mid;
    public String mobileNumber;
    public Bank netBanking;
    public String orderId;
    public String otp;
    private String password = "test";
    public String payMode;
    public String plateform;
    public String token;
    public String txnAmount;
    public String txnHash;
    public String txnId;
}
