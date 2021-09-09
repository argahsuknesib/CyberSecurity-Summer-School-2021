package android.support.v13.app;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import com.google.android.gms.common.internal.GmsLogger;

@TargetApi(GmsLogger.MAX_PII_TAG_LENGTH)
@RequiresApi(GmsLogger.MAX_PII_TAG_LENGTH)
class FragmentCompatICSMR1 {
    FragmentCompatICSMR1() {
    }

    public static void setUserVisibleHint(Fragment fragment, boolean z) {
        if (fragment.getFragmentManager() != null) {
            fragment.setUserVisibleHint(z);
        }
    }
}
