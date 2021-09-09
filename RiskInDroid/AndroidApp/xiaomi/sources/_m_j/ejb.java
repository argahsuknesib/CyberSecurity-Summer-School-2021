package _m_j;

import android.content.Context;
import android.widget.Toast;
import com.xiaomi.accountsdk.account.exception.TokenExpiredException;
import com.xiaomi.smarthome.R;

public final class ejb extends eiv {
    private final efp O00000Oo;
    private final String O00000o0;

    public ejb(efp efp, String str, eiv eiv) {
        super(eiv);
        this.O00000Oo = efp;
        this.O00000o0 = str;
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(Context context, Throwable th) {
        if (!(th instanceof TokenExpiredException)) {
            return false;
        }
        Toast.makeText(context, (int) R.string.request_error_invalid_token, 0).show();
        efp efp = this.O00000Oo;
        new eih();
        efp.gotoFragment(eih.O000000o(this.O00000o0, (String) null), true);
        return true;
    }
}
