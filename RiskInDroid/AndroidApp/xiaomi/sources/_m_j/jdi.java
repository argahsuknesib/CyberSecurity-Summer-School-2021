package _m_j;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public final class jdi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f1776O000000o = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.PrintWriter.<init>(java.io.Writer, boolean):void}
     arg types: [java.io.StringWriter, int]
     candidates:
      ClspMth{java.io.PrintWriter.<init>(java.io.File, java.lang.String):void throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException}
      ClspMth{java.io.PrintWriter.<init>(java.io.OutputStream, boolean):void}
      ClspMth{java.io.PrintWriter.<init>(java.lang.String, java.lang.String):void throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException}
      ClspMth{java.io.PrintWriter.<init>(java.io.Writer, boolean):void} */
    public static String O000000o(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.getBuffer().toString();
    }
}
