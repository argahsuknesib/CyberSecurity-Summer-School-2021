package _m_j;

public final class bnz {
    private static int O000000o(String str, String str2, String str3) {
        return gsy.O000000o(6, String.format("%s %s %s", "SinVoice", str, str2), str3);
    }

    public static final int O000000o(String str, String str2) {
        return O000000o(str, "", O000000o(str2));
    }

    private static final String O000000o(String str) {
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[2];
        return String.format("File:%s, Function:%s, Line:%d, ThreadId:%d, %s", stackTraceElement.getFileName(), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()), Long.valueOf(Thread.currentThread().getId()), str);
    }
}
