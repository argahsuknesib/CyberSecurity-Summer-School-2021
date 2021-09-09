package miuix.view;

import android.util.Log;
import androidx.annotation.Keep;
import miui.util.HapticFeedbackUtil;

@Keep
public class PlatformConstants {
    public static final int VERSION;

    static {
        int i;
        try {
            i = (Class.forName("miui.util.HapticFeedbackUtil").getMethod("isSupportLinearMotorVibrate", new Class[]{Integer.TYPE}) == null || Class.forName("miui.view.MiuiHapticFeedbackConstants").getDeclaredField("FLAG_MIUI_HAPTIC_VERSION") == null) ? 0 : 4;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.w("HapticCompat", "MIUI Haptic Implementation not found.", e);
            i = -1;
        } catch (NoSuchFieldException e2) {
            Log.w("HapticCompat", "error when getting FLAG_MIUI_HAPTIC_VERSION.", e2);
            i = checkVersion();
        }
        VERSION = i;
        Log.i("HapticCompat", String.format("Platform version: %d.", Integer.valueOf(VERSION)));
    }

    static int checkVersion() {
        if (HapticFeedbackUtil.isSupportLinearMotorVibrate(268435470)) {
            return 4;
        }
        if (HapticFeedbackUtil.isSupportLinearMotorVibrate(268435469)) {
            return 3;
        }
        if (HapticFeedbackUtil.isSupportLinearMotorVibrate(268435468)) {
            return 2;
        }
        return HapticFeedbackUtil.isSupportLinearMotorVibrate(268435465) ? 1 : 0;
    }
}
