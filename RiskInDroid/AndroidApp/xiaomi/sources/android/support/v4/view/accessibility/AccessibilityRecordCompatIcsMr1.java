package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityRecord;
import com.google.android.gms.common.internal.GmsLogger;

@TargetApi(GmsLogger.MAX_PII_TAG_LENGTH)
@RequiresApi(GmsLogger.MAX_PII_TAG_LENGTH)
class AccessibilityRecordCompatIcsMr1 {
    AccessibilityRecordCompatIcsMr1() {
    }

    public static int getMaxScrollX(Object obj) {
        return ((AccessibilityRecord) obj).getMaxScrollX();
    }

    public static int getMaxScrollY(Object obj) {
        return ((AccessibilityRecord) obj).getMaxScrollY();
    }

    public static void setMaxScrollX(Object obj, int i) {
        ((AccessibilityRecord) obj).setMaxScrollX(i);
    }

    public static void setMaxScrollY(Object obj, int i) {
        ((AccessibilityRecord) obj).setMaxScrollY(i);
    }
}
