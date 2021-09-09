package _m_j;

import android.os.Build;
import android.system.Os;
import java.io.File;

public final class enj {
    public static long O000000o(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        try {
            if (new File(str).exists()) {
                return Os.stat(str).st_size;
            }
            return 0;
        } catch (Exception e) {
            duv.O000000o(e);
            return 0;
        }
    }
}
