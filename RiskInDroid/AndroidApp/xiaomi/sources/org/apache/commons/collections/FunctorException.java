package org.apache.commons.collections;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class FunctorException extends RuntimeException {
    private static final boolean JDK_SUPPORTS_NESTED;

    /* renamed from: O000000o  reason: collision with root package name */
    static Class f15421O000000o;
    private final Throwable rootCause;

    private static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    static {
        Class cls;
        boolean z = false;
        try {
            if (f15421O000000o == null) {
                cls = class$("java.lang.Throwable");
                f15421O000000o = cls;
            } else {
                cls = f15421O000000o;
            }
            cls.getDeclaredMethod("getCause", new Class[0]);
            z = true;
        } catch (NoSuchMethodException unused) {
        }
        JDK_SUPPORTS_NESTED = z;
    }

    public FunctorException() {
        this.rootCause = null;
    }

    public FunctorException(String str) {
        super(str);
        this.rootCause = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctorException(Throwable th) {
        super(th == null ? null : th.getMessage());
        this.rootCause = th;
    }

    public FunctorException(String str, Throwable th) {
        super(str);
        this.rootCause = th;
    }

    public Throwable getCause() {
        return this.rootCause;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.PrintWriter.<init>(java.io.OutputStream, boolean):void}
     arg types: [java.io.PrintStream, int]
     candidates:
      ClspMth{java.io.PrintWriter.<init>(java.io.File, java.lang.String):void throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException}
      ClspMth{java.io.PrintWriter.<init>(java.lang.String, java.lang.String):void throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException}
      ClspMth{java.io.PrintWriter.<init>(java.io.Writer, boolean):void}
      ClspMth{java.io.PrintWriter.<init>(java.io.OutputStream, boolean):void} */
    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            PrintWriter printWriter = new PrintWriter((OutputStream) printStream, false);
            printStackTrace(printWriter);
            printWriter.flush();
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        synchronized (printWriter) {
            super.printStackTrace(printWriter);
            if (this.rootCause != null && !JDK_SUPPORTS_NESTED) {
                printWriter.print("Caused by: ");
                this.rootCause.printStackTrace(printWriter);
            }
        }
    }
}
