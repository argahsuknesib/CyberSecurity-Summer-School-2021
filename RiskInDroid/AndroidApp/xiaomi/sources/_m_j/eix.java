package _m_j;

import android.content.Context;
import android.widget.Toast;
import com.xiaomi.accountsdk.account.exception.InvalidVerifyCodeException;
import com.xiaomi.passport.ui.data.PhoneAccount;
import com.xiaomi.smarthome.R;

public final class eix extends eiv {
    private final ekk O00000Oo;
    private final PhoneAccount O00000o0;

    public eix(ekk ekk, PhoneAccount phoneAccount, eiv eiv) {
        super(eiv);
        this.O00000Oo = ekk;
        this.O00000o0 = phoneAccount;
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(Context context, Throwable th) {
        if (!(th instanceof InvalidVerifyCodeException)) {
            return false;
        }
        Toast.makeText(context, (int) R.string.request_error_invalid_token, 0).show();
        this.O00000Oo.onRequestSendTicketAndLogin(this.O00000o0);
        return true;
    }
}
