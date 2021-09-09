package miuix.view;

import _m_j.izf;
import _m_j.izg;
import android.util.Log;
import android.view.View;
import androidx.annotation.Keep;

@Keep
class ExtendedVibrator implements izg {
    private ExtendedVibrator() {
    }

    public boolean performHapticFeedback(View view, int i) {
        if (i == izf.f1665O000000o) {
            return view.performHapticFeedback(2);
        }
        return false;
    }

    static {
        initialize();
    }

    private static void initialize() {
        if (PlatformConstants.VERSION < 0) {
            Log.w("ExtendedVibrator", "MiuiHapticFeedbackConstants not found.");
            return;
        }
        HapticCompat.registerProvider(new ExtendedVibrator());
        Log.i("ExtendedVibrator", "setup ExtendedVibrator success.");
    }
}
