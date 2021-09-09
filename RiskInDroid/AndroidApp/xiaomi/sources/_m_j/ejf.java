package _m_j;

import android.content.Context;
import com.xiaomi.passport.snscorelib.internal.request.SNSRequest;

public final class ejf extends eiv {
    private final ehr O00000Oo;
    private final efp O00000o0;

    public ejf(ehr ehr, efp efp, eiv eiv) {
        super(eiv);
        this.O00000o0 = efp;
        this.O00000Oo = ehr;
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(Context context, Throwable th) {
        if (!(th instanceof SNSRequest.RedirectToWebLoginException)) {
            return false;
        }
        efp efp = this.O00000o0;
        new eih();
        efp.gotoFragment(eih.O000000o((SNSRequest.RedirectToWebLoginException) th, this.O00000Oo), true);
        return true;
    }
}
