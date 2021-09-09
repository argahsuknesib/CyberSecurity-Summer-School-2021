package _m_j;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.xiaomi.passport.LocalFeatures.LocalFeaturesImpl;
import com.xiaomi.passport.accountmanager.MiAccountManager;

public final class fao {
    public static void O000000o(Activity activity, String str) {
        LocalFeaturesImpl.O000000o(MiAccountManager.O00000Oo(activity).f6195O000000o).O000000o(str, activity, $$Lambda$fao$AysswzezxnQaEoAWsadyDOfNAQ.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(ees ees) {
        try {
            Bundle bundle = (Bundle) ees.getResult();
            if (bundle != null) {
                gsy.O00000Oo("QRLoginHelper", "result: ".concat(String.valueOf(bundle.getBoolean("booleanResult"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
            gsy.O00000Oo("QRLoginHelper", "startLogin: failed:  " + Log.getStackTraceString(e));
        }
    }
}
