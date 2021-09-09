package com.mobikwik.sdk.lib.wallet;

import com.mobikwik.sdk.lib.model.ApiResponse;
import com.mobikwik.sdk.lib.model.GenerateOTPResponse;

public interface WalletResponseCallback {
    void onError(String str, String str2);

    void onTaskCompleted(ApiResponse apiResponse, GenerateOTPResponse generateOTPResponse);
}
