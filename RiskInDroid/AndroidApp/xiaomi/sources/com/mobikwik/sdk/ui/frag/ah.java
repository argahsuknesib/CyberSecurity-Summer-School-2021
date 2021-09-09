package com.mobikwik.sdk.ui.frag;

import android.app.Activity;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.model.DebitWalletResponse;
import com.mobikwik.sdk.lib.model.GenerateOTPResponse;
import com.mobikwik.sdk.lib.utils.Utils;
import com.mobikwik.sdk.lib.wallet.WalletResponseCallback;

class ah implements WalletResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f5309a;

    ah(y yVar) {
        this.f5309a = yVar;
    }

    /* renamed from: a */
    public void onTaskCompleted(DebitWalletResponse debitWalletResponse, GenerateOTPResponse generateOTPResponse) {
        if (this.f5309a.d != null && this.f5309a.d.isShowing()) {
            this.f5309a.d.dismiss();
        }
        if (SDKErrorCodes.SUCCESS.getErrorCode().equals(debitWalletResponse.getStatuscode())) {
            Utils.sendResultBack(this.f5309a.f5336a, null, "0", debitWalletResponse.getStatusdescription());
        } else if (!SDKErrorCodes.INVALID_TOKEN.getErrorCode().equals(debitWalletResponse.getStatuscode())) {
            if (this.f5309a.d != null && this.f5309a.d.isShowing()) {
                this.f5309a.d.dismiss();
            }
            Activity f = this.f5309a.f5336a;
            Utils.sendResultBack(f, null, debitWalletResponse.getStatuscode(), debitWalletResponse.getStatusdescription());
        } else if (generateOTPResponse == null) {
            this.f5309a.a(false);
        } else if (SDKErrorCodes.SUCCESS.getErrorCode().equals(generateOTPResponse.getStatuscode())) {
            this.f5309a.a(false, generateOTPResponse.getStatusdescription());
        } else {
            Activity f2 = this.f5309a.f5336a;
            Utils.sendResultBack(f2, null, generateOTPResponse.getStatuscode(), generateOTPResponse.getStatusdescription());
        }
    }

    public void onError(String str, String str2) {
        if (this.f5309a.d != null && this.f5309a.d.isShowing()) {
            this.f5309a.d.dismiss();
        }
        Utils.sendResultBack(this.f5309a.f5336a, null, str, str2);
    }
}
