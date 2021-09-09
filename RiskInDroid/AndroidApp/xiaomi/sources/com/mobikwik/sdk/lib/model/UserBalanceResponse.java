package com.mobikwik.sdk.lib.model;

import java.util.List;

public class UserBalanceResponse extends ApiResponse {
    Double balanceamount;
    List storedCards;
    String token;

    public UserBalanceResponse() {
    }

    public UserBalanceResponse(String str, String str2, String str3, Double d, String str4, List list) {
        super(str, str2, str3);
        if (d != null) {
            this.balanceamount = d;
        }
        this.storedCards = list;
        this.token = str4;
    }

    public double getBalance() {
        return this.balanceamount.doubleValue();
    }

    public List getStoredCards() {
        return this.storedCards;
    }

    public String getToken() {
        return this.token;
    }

    public void initiateFrom(GenricApiResp genricApiResp) {
        this.statuscode = genricApiResp.getStatuscode();
        this.status = genricApiResp.getStatus();
        this.statusdescription = genricApiResp.getStatusdescription();
        this.token = genricApiResp.getToken();
        this.balanceamount = genricApiResp.getBalanceamount();
        this.storedCards = genricApiResp.getStoredCards();
    }
}
