package com.mobikwik.sdk.ui.frag;

import android.content.Intent;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.model.CreateWalletResponse;
import com.mobikwik.sdk.lib.model.GenerateOTPResponse;
import com.mobikwik.sdk.lib.utils.UIFunctions;
import com.mobikwik.sdk.lib.wallet.WalletResponseCallback;
import com.mobikwik.sdk.ui.data.a;
import com.mobikwik.sdk.ui.frag.f;

class j implements WalletResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f5320a;

    j(f fVar) {
        this.f5320a = fVar;
    }

    /* renamed from: a */
    public void onTaskCompleted(CreateWalletResponse createWalletResponse, GenerateOTPResponse generateOTPResponse) {
        if (this.f5320a.j != null && this.f5320a.j.isShowing()) {
            this.f5320a.j.dismiss();
        }
        if (this.f5320a.f instanceof f.a) {
            f.a aVar = (f.a) this.f5320a.f;
            if (SDKErrorCodes.SUCCESS.getErrorCode().equals(createWalletResponse.getStatuscode())) {
                a.a(this.f5320a.f, this.f5320a.i.getUser(), createWalletResponse.getToken());
                Intent intent = new Intent();
                intent.putExtra("balance", Double.parseDouble("0.0"));
                intent.putExtra("NEWUSER", "true");
                aVar.a(-1, intent);
            } else if (SDKErrorCodes.INVALID_OTP.getErrorCode().equals(createWalletResponse.getStatuscode())) {
                UIFunctions.showToastLong(this.f5320a.getActivity(), "Please Enter correct OTP");
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("statuscode", createWalletResponse.getStatuscode());
                intent2.putExtra("statusmessage", createWalletResponse.getStatusdescription());
                aVar.a(0, intent2);
            }
        }
    }

    public void onError(String str, String str2) {
        if (this.f5320a.j != null && this.f5320a.j.isShowing()) {
            this.f5320a.j.dismiss();
        }
        if (this.f5320a.f instanceof f.a) {
            Intent intent = new Intent();
            intent.putExtra("statuscode", str);
            intent.putExtra("statusmessage", str2);
            ((f.a) this.f5320a.f).a(0, intent);
        }
    }
}
