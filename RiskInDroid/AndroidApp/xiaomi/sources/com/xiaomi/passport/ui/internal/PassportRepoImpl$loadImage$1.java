package com.xiaomi.passport.ui.internal;

import _m_j.iwb;
import _m_j.ixe;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.SimpleRequestForAccount;
import java.security.InvalidParameterException;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PassportRepoImpl$loadImage$1 extends Lambda implements iwb<Bitmap> {
    final /* synthetic */ String $url;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassportRepoImpl$loadImage$1(String str) {
        super(0);
        this.$url = str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [com.xiaomi.accountsdk.request.SimpleRequest$StreamContent, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public Bitmap invoke() {
        if (!TextUtils.isEmpty(this.$url)) {
            SimpleRequest.StreamContent asStream = SimpleRequestForAccount.getAsStream(this.$url, null, null);
            try {
                ixe.O000000o((Object) asStream, "c");
                return BitmapFactory.decodeStream(asStream.getStream());
            } finally {
                asStream.closeStream();
            }
        } else {
            throw new InvalidParameterException();
        }
    }
}
