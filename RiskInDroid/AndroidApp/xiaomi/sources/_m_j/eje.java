package _m_j;

import android.content.Context;
import com.xiaomi.passport.snscorelib.internal.request.SNSRequest;

public final class eje extends eiv {
    private final ekk O00000Oo;

    public eje(ekk ekk, eiv eiv) {
        super(eiv);
        this.O00000Oo = ekk;
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(Context context, Throwable th) {
        if (!(th instanceof SNSRequest.NeedLoginForBindException)) {
            return false;
        }
        this.O00000Oo.onUseManualInputLogin();
        return true;
    }
}
