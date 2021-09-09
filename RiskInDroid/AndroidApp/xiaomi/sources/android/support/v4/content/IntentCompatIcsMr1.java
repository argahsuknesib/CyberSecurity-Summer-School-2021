package android.support.v4.content;

import android.annotation.TargetApi;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import com.google.android.gms.common.internal.GmsLogger;

@TargetApi(GmsLogger.MAX_PII_TAG_LENGTH)
@RequiresApi(GmsLogger.MAX_PII_TAG_LENGTH)
class IntentCompatIcsMr1 {
    IntentCompatIcsMr1() {
    }

    public static Intent makeMainSelectorActivity(String str, String str2) {
        return Intent.makeMainSelectorActivity(str, str2);
    }
}
