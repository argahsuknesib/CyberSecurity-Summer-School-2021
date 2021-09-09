package com.xiaomi.passport.ui.internal;

import _m_j.efz;
import _m_j.egs;
import _m_j.iwb;
import _m_j.ixe;
import android.graphics.Bitmap;
import android.util.Pair;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xiaomi/passport/ui/internal/Captcha;", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PassportRepoImpl$getCaptchaImage$1 extends Lambda implements iwb<efz> {
    final /* synthetic */ String $url;
    final /* synthetic */ egs this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassportRepoImpl$getCaptchaImage$1(egs egs, String str) {
        super(0);
        this.this$0 = egs;
        this.$url = str;
    }

    public final /* synthetic */ Object invoke() {
        Pair<Bitmap, String> O00000o = egs.O00000o(this.$url);
        Object obj = O00000o.second;
        ixe.O000000o(obj, "captcha.second");
        return new efz((Bitmap) O00000o.first, (String) obj, this.$url);
    }
}
