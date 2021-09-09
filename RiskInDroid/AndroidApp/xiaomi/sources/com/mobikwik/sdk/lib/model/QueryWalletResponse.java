package com.mobikwik.sdk.lib.model;

public class QueryWalletResponse extends ApiResponse {
    String cell;
    String email;

    public QueryWalletResponse() {
    }

    public QueryWalletResponse(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3);
        this.email = str4;
        this.cell = str5;
    }

    public String getCell() {
        return this.cell;
    }

    public String getEmail() {
        return this.email;
    }

    public void initiateFrom(GenricApiResp genricApiResp) {
        this.statuscode = genricApiResp.getStatuscode();
        this.status = genricApiResp.getStatus();
        this.statusdescription = genricApiResp.getStatusdescription();
        this.email = genricApiResp.getEmail();
        this.cell = genricApiResp.getCell();
    }
}
