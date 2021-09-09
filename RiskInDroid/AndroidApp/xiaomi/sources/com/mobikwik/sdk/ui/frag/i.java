package com.mobikwik.sdk.ui.frag;

import android.content.Intent;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.model.GenerateOTPResponse;
import com.mobikwik.sdk.lib.model.SavedCardResponse;
import com.mobikwik.sdk.lib.model.UserBalanceResponse;
import com.mobikwik.sdk.lib.utils.UIFunctions;
import com.mobikwik.sdk.lib.wallet.WalletResponseCallback;
import com.mobikwik.sdk.ui.data.a;
import com.mobikwik.sdk.ui.frag.f;
import java.util.List;

class i implements WalletResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f5319a;

    i(f fVar) {
        this.f5319a = fVar;
    }

    /* renamed from: a */
    public void onTaskCompleted(UserBalanceResponse userBalanceResponse, GenerateOTPResponse generateOTPResponse) {
        if (this.f5319a.j != null && this.f5319a.j.isShowing()) {
            this.f5319a.j.dismiss();
        }
        if (this.f5319a.f instanceof f.a) {
            f.a aVar = (f.a) this.f5319a.f;
            if (SDKErrorCodes.SUCCESS.getErrorCode().equals(userBalanceResponse.getStatuscode())) {
                if (userBalanceResponse.getStoredCards() != null) {
                    List storedCards = userBalanceResponse.getStoredCards();
                    this.f5319a.b.a((SavedCardResponse.CardDetails[]) storedCards.toArray(new SavedCardResponse.CardDetails[storedCards.size()]));
                }
                Double valueOf = Double.valueOf(userBalanceResponse.getBalance());
                a.a(this.f5319a.f, this.f5319a.i.getUser(), userBalanceResponse.getToken());
                Intent intent = new Intent();
                intent.putExtra("balance", valueOf);
                aVar.a(-1, intent);
            } else if (SDKErrorCodes.INVALID_OTP.getErrorCode().equals(userBalanceResponse.getStatuscode())) {
                UIFunctions.showToastLong(this.f5319a.getActivity(), "Please Enter correct OTP");
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("statuscode", userBalanceResponse.getStatuscode());
                intent2.putExtra("statusmessage", userBalanceResponse.getStatusdescription());
                aVar.a(0, intent2);
            }
        }
    }

    public void onError(String str, String str2) {
        if (this.f5319a.j != null && this.f5319a.j.isShowing()) {
            this.f5319a.j.dismiss();
        }
        if (this.f5319a.f instanceof f.a) {
            Intent intent = new Intent();
            intent.putExtra("statuscode", str);
            intent.putExtra("statusmessage", str2);
            ((f.a) this.f5319a.f).a(0, intent);
        }
    }
}
