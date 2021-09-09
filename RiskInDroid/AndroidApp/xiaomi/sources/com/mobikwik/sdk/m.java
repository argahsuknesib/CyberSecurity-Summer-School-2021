package com.mobikwik.sdk;

import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.model.GenerateOTPResponse;
import com.mobikwik.sdk.lib.model.SavedCardResponse;
import com.mobikwik.sdk.lib.model.UserBalanceResponse;
import com.mobikwik.sdk.lib.wallet.WalletResponseCallback;
import com.mobikwik.sdk.ui.data.b;
import java.util.List;

class m implements WalletResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f5291a;
    final /* synthetic */ PaymentActivity b;

    m(PaymentActivity paymentActivity, b bVar) {
        this.b = paymentActivity;
        this.f5291a = bVar;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mobikwik.sdk.PaymentActivity.a(com.mobikwik.sdk.PaymentActivity, boolean, java.lang.String):void
     arg types: [com.mobikwik.sdk.PaymentActivity, int, java.lang.String]
     candidates:
      com.mobikwik.sdk.PaymentActivity.a(android.content.Intent, java.lang.String, java.lang.String):void
      com.mobikwik.sdk.PaymentActivity.a(com.mobikwik.sdk.PaymentActivity, boolean, java.lang.String):void */
    /* renamed from: a */
    public void onTaskCompleted(UserBalanceResponse userBalanceResponse, GenerateOTPResponse generateOTPResponse) {
        if (SDKErrorCodes.SUCCESS.getErrorCode().equals(userBalanceResponse.getStatuscode())) {
            if (this.b.f5277a != null && this.b.f5277a.isShowing()) {
                this.b.f5277a.dismiss();
            }
            Double valueOf = Double.valueOf(userBalanceResponse.getBalance());
            if (userBalanceResponse.getStoredCards() != null) {
                List storedCards = userBalanceResponse.getStoredCards();
                this.f5291a.a((SavedCardResponse.CardDetails[]) storedCards.toArray(new SavedCardResponse.CardDetails[storedCards.size()]));
            }
            this.b.a(valueOf);
        } else if (!SDKErrorCodes.INVALID_TOKEN.getErrorCode().equals(userBalanceResponse.getStatuscode())) {
            if (this.b.f5277a != null && this.b.f5277a.isShowing()) {
                this.b.f5277a.dismiss();
            }
            PaymentActivity paymentActivity = this.b;
            paymentActivity.a(null, userBalanceResponse.getStatuscode(), userBalanceResponse.getStatusdescription());
        } else if (generateOTPResponse == null) {
            this.b.a(false);
        } else {
            if (this.b.f5277a != null && this.b.f5277a.isShowing()) {
                this.b.f5277a.dismiss();
            }
            if (SDKErrorCodes.SUCCESS.getErrorCode().equals(generateOTPResponse.getStatuscode())) {
                this.b.a(false, generateOTPResponse.getStatusdescription());
                return;
            }
            PaymentActivity paymentActivity2 = this.b;
            paymentActivity2.a(null, generateOTPResponse.getStatuscode(), generateOTPResponse.getStatusdescription());
        }
    }

    public void onError(String str, String str2) {
        if (this.b.f5277a != null && this.b.f5277a.isShowing()) {
            this.b.f5277a.dismiss();
        }
        this.b.a(null, str, str2);
    }
}
