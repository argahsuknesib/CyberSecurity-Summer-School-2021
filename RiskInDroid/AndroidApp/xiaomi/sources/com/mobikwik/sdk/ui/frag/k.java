package com.mobikwik.sdk.ui.frag;

import android.app.Activity;
import android.content.Intent;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.model.DebitWalletResponse;
import com.mobikwik.sdk.lib.model.GenerateOTPResponse;
import com.mobikwik.sdk.lib.utils.UIFunctions;
import com.mobikwik.sdk.lib.utils.Utils;
import com.mobikwik.sdk.lib.wallet.WalletResponseCallback;
import com.mobikwik.sdk.ui.data.a;
import com.mobikwik.sdk.ui.frag.f;

class k implements WalletResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f5321a;

    k(f fVar) {
        this.f5321a = fVar;
    }

    /* renamed from: a */
    public void onTaskCompleted(DebitWalletResponse debitWalletResponse, GenerateOTPResponse generateOTPResponse) {
        if (this.f5321a.j != null && this.f5321a.j.isShowing()) {
            this.f5321a.j.dismiss();
        }
        if (SDKErrorCodes.SUCCESS.getErrorCode().equals(debitWalletResponse.getStatuscode())) {
            a.a(this.f5321a.f, this.f5321a.i.getUser(), debitWalletResponse.getToken());
            Utils.sendResultBack(this.f5321a.f, null, "0", debitWalletResponse.getStatusdescription());
        } else if (SDKErrorCodes.INVALID_OTP.getErrorCode().equals(debitWalletResponse.getStatuscode())) {
            UIFunctions.showToastLong(this.f5321a.getActivity(), "Please Enter correct OTP");
        } else if (SDKErrorCodes.WALLET_INSUFFICIENT_BALANCE.getErrorCode().equals(debitWalletResponse.getStatuscode())) {
            a.a(this.f5321a.f, this.f5321a.i.getUser(), debitWalletResponse.getToken());
            if (this.f5321a.f instanceof f.a) {
                Intent intent = new Intent();
                intent.putExtra("balance", debitWalletResponse.getBalanceamount());
                intent.putExtra("NEWUSER", "false");
                ((f.a) this.f5321a.f).a(-1, intent);
            }
        } else {
            Activity c = this.f5321a.f;
            Utils.sendResultBack(c, null, debitWalletResponse.getStatuscode(), debitWalletResponse.getStatusdescription());
        }
    }

    public void onError(String str, String str2) {
        if (this.f5321a.j != null && this.f5321a.j.isShowing()) {
            this.f5321a.j.dismiss();
        }
        Utils.sendResultBack(this.f5321a.f, null, str, str2);
    }
}
