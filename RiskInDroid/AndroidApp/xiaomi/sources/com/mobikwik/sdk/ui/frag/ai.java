package com.mobikwik.sdk.ui.frag;

import android.app.Activity;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.model.GenerateOTPResponse;
import com.mobikwik.sdk.lib.utils.Utils;
import com.mobikwik.sdk.lib.wallet.WalletResponseCallback;

class ai implements WalletResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f5310a;
    final /* synthetic */ y b;

    ai(y yVar, boolean z) {
        this.b = yVar;
        this.f5310a = z;
    }

    /* renamed from: a */
    public void onTaskCompleted(GenerateOTPResponse generateOTPResponse, GenerateOTPResponse generateOTPResponse2) {
        if (this.b.d != null && this.b.d.isShowing()) {
            this.b.d.dismiss();
        }
        if (SDKErrorCodes.SUCCESS.getErrorCode().equals(generateOTPResponse.getStatuscode())) {
            this.b.a(this.f5310a, generateOTPResponse.getStatusdescription());
            return;
        }
        Activity f = this.b.f5336a;
        Utils.sendResultBack(f, null, generateOTPResponse.getStatuscode(), generateOTPResponse.getStatusdescription());
    }

    public void onError(String str, String str2) {
        if (this.b.d != null && this.b.d.isShowing()) {
            this.b.d.dismiss();
        }
        Utils.sendResultBack(this.b.f5336a, null, str, str2);
    }
}
