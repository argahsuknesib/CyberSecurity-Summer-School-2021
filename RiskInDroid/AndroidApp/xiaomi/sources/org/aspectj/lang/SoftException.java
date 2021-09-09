package org.aspectj.lang;

import java.io.PrintStream;
import java.io.PrintWriter;

public class SoftException extends RuntimeException {
    private static final boolean HAVE_JAVA_14;
    Throwable inner;

    static {
        boolean z;
        try {
            Class.forName("java.nio.Buffer");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        HAVE_JAVA_14 = z;
    }

    public SoftException(Throwable th) {
        this.inner = th;
    }

    public Throwable getWrappedThrowable() {
        return this.inner;
    }

    public Throwable getCause() {
        return this.inner;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Throwable th = this.inner;
        if (!HAVE_JAVA_14 && th != null) {
            printStream.print("Caused by: ");
            th.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Throwable th = this.inner;
        if (!HAVE_JAVA_14 && th != null) {
            printWriter.print("Caused by: ");
            th.printStackTrace(printWriter);
        }
    }
}
