package android.support.v4.text;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(23)
@RequiresApi(23)
class ICUCompatApi23 {
    private static Method sAddLikelySubtagsMethod;

    ICUCompatApi23() {
    }

    static {
        try {
            sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static String maximizeAndGetScript(Locale locale) {
        try {
            return ((Locale) sAddLikelySubtagsMethod.invoke(null, locale)).getScript();
        } catch (InvocationTargetException e) {
            Log.w("ICUCompatIcs", e);
            return locale.getScript();
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompatIcs", e2);
            return locale.getScript();
        }
    }
}
