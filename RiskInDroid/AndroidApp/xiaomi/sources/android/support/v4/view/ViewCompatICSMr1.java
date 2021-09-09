package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import com.google.android.gms.common.internal.GmsLogger;

@TargetApi(GmsLogger.MAX_PII_TAG_LENGTH)
@RequiresApi(GmsLogger.MAX_PII_TAG_LENGTH)
class ViewCompatICSMr1 {
    ViewCompatICSMr1() {
    }

    public static boolean hasOnClickListeners(View view) {
        return view.hasOnClickListeners();
    }
}
