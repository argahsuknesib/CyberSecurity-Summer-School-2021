package com.mobikwik.sdk.lib.model;

public abstract class ApiResponse {
    protected String status;
    protected String statuscode;
    protected String statusdescription;

    public ApiResponse() {
    }

    public ApiResponse(String str, String str2, String str3) {
        this.statuscode = str;
        this.statusdescription = str2;
        this.status = str3;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStatuscode() {
        return this.statuscode;
    }

    public String getStatusdescription() {
        return this.statusdescription;
    }

    public abstract void initiateFrom(GenricApiResp genricApiResp);
}
