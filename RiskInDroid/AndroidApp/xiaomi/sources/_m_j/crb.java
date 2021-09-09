package _m_j;

import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class crb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Pattern f14270O000000o = Pattern.compile("\\$\\d+$");
    private static final ThreadLocal<String> O00000Oo = new ThreadLocal<>();
    private static int O00000o0 = Integer.MAX_VALUE;

    private static String O000000o() {
        String str = O00000Oo.get();
        if (str != null) {
            O00000Oo.remove();
            return str;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length >= 5) {
            String className = stackTrace[4].getClassName();
            Matcher matcher = f14270O000000o.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String replace = className.replace("Impl", "").replace("RxBle", "");
            return "RxBle#" + replace.substring(replace.lastIndexOf(46) + 1);
        }
        throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
    }

    private static String O00000o0(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    public static void O000000o(String str, Object... objArr) {
        O000000o(2, O00000o0(str, objArr), (Throwable) null);
    }

    public static void O00000Oo(String str, Object... objArr) {
        O000000o(5, O00000o0(str, objArr), (Throwable) null);
    }

    public static void O000000o(Throwable th, String str, Object... objArr) {
        O000000o(5, O00000o0(str, objArr), th);
    }

    private static void O000000o(int i, String str, Throwable th) {
        if (i >= O00000o0) {
            if (str == null || str.length() == 0) {
                if (th != null) {
                    str = Log.getStackTraceString(th);
                } else {
                    return;
                }
            } else if (th != null) {
                str = str + "\n" + Log.getStackTraceString(th);
            }
            O000000o(i, O000000o(), str);
        }
    }

    private static void O000000o(int i, String str, String str2) {
        if (str2.length() < 4000) {
            Log.println(i, str, str2);
            return;
        }
        for (String println : str2.split("\n")) {
            Log.println(i, str, println);
        }
    }
}
