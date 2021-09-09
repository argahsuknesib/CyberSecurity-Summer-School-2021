package com.mobikwik.sdk.lib.model;

public class CreateWalletResponse extends ApiResponse {
    String token;

    public CreateWalletResponse() {
    }

    public CreateWalletResponse(String str, String str2, String str3, String str4) {
        super(str, str2, str3);
        this.token = str4;
    }

    public String getToken() {
        return this.token;
    }

    public void initiateFrom(GenricApiResp genricApiResp) {
        this.statuscode = genricApiResp.getStatuscode();
        this.status = genricApiResp.getStatus();
        this.statusdescription = genricApiResp.getStatusdescription();
        this.token = genricApiResp.getToken();
    }
}
