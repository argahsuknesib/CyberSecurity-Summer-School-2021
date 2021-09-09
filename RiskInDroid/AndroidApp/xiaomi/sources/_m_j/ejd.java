package _m_j;

import android.content.Context;
import android.widget.Toast;
import com.xiaomi.passport.snscorelib.internal.request.SNSRequest;
import com.xiaomi.smarthome.R;

public final class ejd extends eiv {
    public ejd(eiv eiv) {
        super(eiv);
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(Context context, Throwable th) {
        if (!(th instanceof SNSRequest.BindLimitException)) {
            return false;
        }
        Toast.makeText(context, (int) R.string.sns_bind_limit, 0).show();
        return true;
    }
}
