package com.mobikwik.sdk.ui.frag;

import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.model.DeleteSavedCardResponse;
import com.mobikwik.sdk.lib.model.GenerateOTPResponse;
import com.mobikwik.sdk.lib.model.SavedCardResponse;
import com.mobikwik.sdk.lib.utils.UIFunctions;
import com.mobikwik.sdk.lib.wallet.WalletResponseCallback;

class s implements WalletResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SavedCardResponse.CardDetails f5330a;
    final /* synthetic */ o b;

    s(o oVar, SavedCardResponse.CardDetails cardDetails) {
        this.b = oVar;
        this.f5330a = cardDetails;
    }

    /* renamed from: a */
    public void onTaskCompleted(DeleteSavedCardResponse deleteSavedCardResponse, GenerateOTPResponse generateOTPResponse) {
        o oVar;
        SavedCardResponse.CardDetails cardDetails;
        if (this.b.u != null && this.b.u.isShowing()) {
            this.b.u.dismiss();
        }
        if (SDKErrorCodes.SUCCESS.getErrorCode().equals(deleteSavedCardResponse.getStatuscode())) {
            oVar = this.b;
            cardDetails = this.f5330a;
        } else {
            oVar = this.b;
            cardDetails = null;
        }
        oVar.a(cardDetails, deleteSavedCardResponse.getStatusdescription());
    }

    public void onError(String str, String str2) {
        if (this.b.u != null && this.b.u.isShowing()) {
            this.b.u.dismiss();
        }
        UIFunctions.showToastLong(this.b.k.getBaseContext(), str2);
    }
}
