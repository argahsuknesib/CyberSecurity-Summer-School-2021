package _m_j;

public final class buu {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f13299O000000o = false;
    private static int O00000Oo = -1;

    private static String O000000o() {
        if (O00000Oo == -1) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (stackTrace[i].getMethodName().equals("getTraceInfo")) {
                    O00000Oo = i2 + 1;
                    break;
                } else {
                    i2++;
                    i++;
                }
            }
        }
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[O00000Oo + 1];
        return stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + " - [" + stackTraceElement.getMethodName() + "]";
    }

    public static void O000000o(String str) {
        if (f13299O000000o && str != null) {
            gsy.O000000o(3, "HttpDnsSDK", Thread.currentThread().getId() + " - " + O000000o() + " - " + str);
        }
    }

    public static void O000000o(Throwable th) {
        if (f13299O000000o) {
            th.printStackTrace();
        }
    }

    public static void O00000Oo(String str) {
        if (f13299O000000o && str != null) {
            gsy.O000000o(6, "HttpDnsSDK", Thread.currentThread().getId() + " - " + O000000o() + " - " + str);
        }
    }
}
