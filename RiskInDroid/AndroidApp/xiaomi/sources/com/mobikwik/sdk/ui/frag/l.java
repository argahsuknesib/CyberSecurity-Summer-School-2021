package com.mobikwik.sdk.ui.frag;

import android.content.Intent;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.model.GenerateOTPResponse;
import com.mobikwik.sdk.lib.wallet.WalletResponseCallback;
import com.mobikwik.sdk.ui.frag.f;

class l implements WalletResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f5322a;

    l(f fVar) {
        this.f5322a = fVar;
    }

    /* renamed from: a */
    public void onTaskCompleted(GenerateOTPResponse generateOTPResponse, GenerateOTPResponse generateOTPResponse2) {
        if (this.f5322a.j != null && this.f5322a.j.isShowing()) {
            this.f5322a.j.dismiss();
        }
        if (SDKErrorCodes.SUCCESS.getErrorCode().equals(generateOTPResponse.getStatuscode())) {
            String unused = this.f5322a.h = generateOTPResponse.getStatusdescription();
            this.f5322a.d();
        } else if (this.f5322a.f instanceof f.a) {
            Intent intent = new Intent();
            intent.putExtra("statuscode", generateOTPResponse.getStatuscode());
            intent.putExtra("statusmessage", generateOTPResponse.getStatusdescription());
            ((f.a) this.f5322a.f).a(0, intent);
        }
    }

    public void onError(String str, String str2) {
        if (this.f5322a.j != null && this.f5322a.j.isShowing()) {
            this.f5322a.j.dismiss();
        }
        if (this.f5322a.f instanceof f.a) {
            Intent intent = new Intent();
            intent.putExtra("statuscode", str);
            intent.putExtra("statusmessage", str2);
            ((f.a) this.f5322a.f).a(0, intent);
        }
    }
}
