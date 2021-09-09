package _m_j;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;

public final class oO00000o {
    public static void O000000o(String str, String str2) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(2, stackTrace.length - 1);
        String str3 = " ";
        for (int i = 1; i <= min; i++) {
            str3 = str3 + " ";
            Log.v(str, str2 + str3 + (".(" + stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber() + ") " + stackTrace[i].getMethodName()) + str3);
        }
    }

    public static String O000000o(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String O000000o(Context context, int i) {
        if (i == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i);
        } catch (Exception unused) {
            return "?".concat(String.valueOf(i));
        }
    }

    public static String O000000o(MotionLayout motionLayout, int i) {
        if (i == -1) {
            return "UNDEFINED";
        }
        return motionLayout.getContext().getResources().getResourceEntryName(i);
    }

    public static String O000000o() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }
}
