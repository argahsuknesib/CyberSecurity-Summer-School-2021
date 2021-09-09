package com.mobikwik.sdk.lib.model;

public class DebitWalletResponse extends ApiResponse {
    Double balanceamount;
    String token;

    public DebitWalletResponse() {
    }

    public DebitWalletResponse(String str, String str2, String str3, Double d, String str4) {
        super(str, str2, str3);
        this.token = str4;
        this.balanceamount = d;
    }

    public Double getBalanceamount() {
        return this.balanceamount;
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
    }
}
