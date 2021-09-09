package miuix.view;

import _m_j.izf;
import _m_j.izg;
import android.util.Log;
import android.view.View;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

public class HapticCompat {

    /* renamed from: O000000o  reason: collision with root package name */
    private static List<izg> f15392O000000o = new ArrayList();

    static {
        O000000o("miuix.view.LinearVibrator", "miuix.view.ExtendedVibrator");
    }

    @Keep
    public static boolean performHapticFeedback(View view, int i) {
        if (i < 268435456) {
            Log.i("HapticCompat", String.format("perform haptic: 0x%08x", Integer.valueOf(i)));
            return view.performHapticFeedback(i);
        } else if (i > izf.O0000o) {
            Log.w("HapticCompat", String.format("illegal feedback constant, should be in range [0x%08x..0x%08x]", 268435456, Integer.valueOf(izf.O0000o)));
            return false;
        } else {
            for (izg performHapticFeedback : f15392O000000o) {
                if (performHapticFeedback.performHapticFeedback(view, i)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Keep
    static void registerProvider(izg izg) {
        f15392O000000o.add(izg);
    }

    private static void O000000o(String... strArr) {
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            Log.i("HapticCompat", "loading provider: ".concat(String.valueOf(str)));
            try {
                Class.forName(str, true, HapticCompat.class.getClassLoader());
            } catch (ClassNotFoundException e) {
                Log.w("HapticCompat", String.format("load provider %s failed.", str), e);
            }
        }
    }
}
