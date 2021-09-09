package com.mobikwik.sdk.lib.model;

public class GenerateOTPResponse extends ApiResponse {
    public GenerateOTPResponse() {
    }

    public GenerateOTPResponse(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public void initiateFrom(GenricApiResp genricApiResp) {
        this.statuscode = genricApiResp.getStatuscode();
        this.status = genricApiResp.getStatus();
        this.statusdescription = genricApiResp.getStatusdescription();
    }
}
