package com.mobikwik.sdk.lib.model;

public class ApiResponseContainer {
    private GenricApiResp apiResponse;
    private GenerateOTPResponse otpResponse;

    public GenricApiResp getApiResponse() {
        return this.apiResponse;
    }

    public GenerateOTPResponse getOtpResponse() {
        return this.otpResponse;
    }
}
