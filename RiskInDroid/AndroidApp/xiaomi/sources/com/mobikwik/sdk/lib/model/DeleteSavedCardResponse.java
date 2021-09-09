package com.mobikwik.sdk.lib.model;

import java.util.List;

public class DeleteSavedCardResponse extends ApiResponse {
    public DeleteSavedCardResponse() {
    }

    public DeleteSavedCardResponse(String str, String str2, String str3, Double d, String str4, List list) {
        super(str, str2, str3);
    }

    public void initiateFrom(GenricApiResp genricApiResp) {
        this.statuscode = genricApiResp.getStatuscode();
        this.status = genricApiResp.getStatus();
        this.statusdescription = genricApiResp.getStatusdescription();
    }
}
