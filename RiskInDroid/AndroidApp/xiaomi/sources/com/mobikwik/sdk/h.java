package com.mobikwik.sdk;

import android.content.DialogInterface;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.utils.Utils;

class h implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PGWebView f5286a;

    h(PGWebView pGWebView) {
        this.f5286a = pGWebView;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Utils.sendResultBack(this.f5286a, null, SDKErrorCodes.USER_CANCELLED_TRANSACTION.getErrorCode(), SDKErrorCodes.USER_CANCELLED_TRANSACTION.getErrorDescription());
    }
}
