package _m_j;

import android.content.Context;
import android.widget.Toast;
import com.xiaomi.accountsdk.account.exception.UserRestrictedException;
import com.xiaomi.smarthome.R;

public final class ejc extends eiv {
    public ejc(eiv eiv) {
        super(eiv);
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(Context context, Throwable th) {
        if (!(th instanceof UserRestrictedException)) {
            return false;
        }
        Toast.makeText(context, (int) R.string.passport_register_restricted, 0).show();
        return true;
    }
}
