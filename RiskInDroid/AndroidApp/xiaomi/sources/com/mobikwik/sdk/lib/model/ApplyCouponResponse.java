package com.mobikwik.sdk.lib.model;

public class ApplyCouponResponse extends ApiResponse {
    public ApplyCouponResponse() {
    }

    public ApplyCouponResponse(String str, String str2, String str3, Double d, String str4) {
        super(str, str2, str3);
    }

    public void initiateFrom(GenricApiResp genricApiResp) {
        this.statuscode = genricApiResp.getStatuscode();
        this.status = genricApiResp.getStatus();
        this.statusdescription = genricApiResp.getStatusdescription();
    }
}
