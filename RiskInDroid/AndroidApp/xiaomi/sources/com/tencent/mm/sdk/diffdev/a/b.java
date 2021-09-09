package com.tencent.mm.sdk.diffdev.a;

import android.util.Log;
import com.tencent.mm.sdk.diffdev.OAuthErrCode;
import com.tencent.mm.sdk.diffdev.OAuthListener;
import java.util.ArrayList;

final class b implements OAuthListener {
    final /* synthetic */ a ag;

    b(a aVar) {
        this.ag = aVar;
    }

    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
        d unused = this.ag.ae = null;
        ArrayList<OAuthListener> arrayList = new ArrayList<>();
        arrayList.addAll(this.ag.ad);
        for (OAuthListener onAuthFinish : arrayList) {
            onAuthFinish.onAuthFinish(oAuthErrCode, str);
        }
    }

    public final void onAuthGotQrcode(String str, byte[] bArr) {
        Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = ".concat(String.valueOf(str)));
        ArrayList<OAuthListener> arrayList = new ArrayList<>();
        arrayList.addAll(this.ag.ad);
        for (OAuthListener onAuthGotQrcode : arrayList) {
            onAuthGotQrcode.onAuthGotQrcode(str, bArr);
        }
    }

    public final void onQrcodeScanned() {
        Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        if (this.ag.ac != null) {
            this.ag.ac.post(new c(this));
        }
    }
}
