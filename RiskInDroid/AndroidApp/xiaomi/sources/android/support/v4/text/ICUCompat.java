package android.support.v4.text;

import android.os.Build;
import java.util.Locale;

public final class ICUCompat {
    private static final ICUCompatImpl IMPL;

    interface ICUCompatImpl {
        String maximizeAndGetScript(Locale locale);
    }

    static class ICUCompatImplBase implements ICUCompatImpl {
        public String maximizeAndGetScript(Locale locale) {
            return null;
        }

        ICUCompatImplBase() {
        }
    }

    static class ICUCompatImplIcs implements ICUCompatImpl {
        ICUCompatImplIcs() {
        }

        public String maximizeAndGetScript(Locale locale) {
            return ICUCompatIcs.maximizeAndGetScript(locale);
        }
    }

    static class ICUCompatImplLollipop implements ICUCompatImpl {
        ICUCompatImplLollipop() {
        }

        public String maximizeAndGetScript(Locale locale) {
            return ICUCompatApi23.maximizeAndGetScript(locale);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            IMPL = new ICUCompatImplLollipop();
        } else if (i >= 14) {
            IMPL = new ICUCompatImplIcs();
        } else {
            IMPL = new ICUCompatImplBase();
        }
    }

    public static String maximizeAndGetScript(Locale locale) {
        return IMPL.maximizeAndGetScript(locale);
    }

    private ICUCompat() {
    }
}
