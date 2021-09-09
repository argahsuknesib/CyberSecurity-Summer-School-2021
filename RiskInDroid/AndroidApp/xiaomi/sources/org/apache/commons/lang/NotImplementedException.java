package org.apache.commons.lang;

import _m_j.jcz;
import _m_j.jda;
import java.io.PrintStream;
import java.io.PrintWriter;
import org.apache.commons.lang.exception.NestableDelegate;

public class NotImplementedException extends UnsupportedOperationException implements jda {
    private static final long serialVersionUID = -6894122266938754088L;
    private Throwable cause;
    private NestableDelegate delegate;

    public NotImplementedException() {
        super("Code is not implemented");
        this.delegate = new NestableDelegate(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotImplementedException(String str) {
        super(str == null ? "Code is not implemented" : str);
        this.delegate = new NestableDelegate(this);
    }

    public NotImplementedException(Throwable th) {
        super("Code is not implemented");
        this.delegate = new NestableDelegate(this);
        this.cause = th;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotImplementedException(String str, Throwable th) {
        super(str == null ? "Code is not implemented" : str);
        this.delegate = new NestableDelegate(this);
        this.cause = th;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public NotImplementedException(Class cls) {
        super(r2);
        String str;
        if (cls == null) {
            str = "Code is not implemented";
        } else {
            str = "Code is not implemented in ".concat(String.valueOf(cls));
        }
        this.delegate = new NestableDelegate(this);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public String getMessage() {
        if (super.getMessage() != null) {
            return super.getMessage();
        }
        Throwable th = this.cause;
        if (th != null) {
            return th.toString();
        }
        return null;
    }

    public String getMessage(int i) {
        if (i == 0) {
            return super.getMessage();
        }
        return this.delegate.O000000o(i);
    }

    public String[] getMessages() {
        return this.delegate.O000000o();
    }

    public Throwable getThrowable(int i) {
        return this.delegate.O00000Oo(i);
    }

    public int getThrowableCount() {
        return jcz.O00000Oo(this.delegate.nestable);
    }

    public Throwable[] getThrowables() {
        return jcz.O00000o0(this.delegate.nestable);
    }

    public int indexOfThrowable(Class cls) {
        return this.delegate.O000000o(cls, 0);
    }

    public int indexOfThrowable(Class cls, int i) {
        return this.delegate.O000000o(cls, i);
    }

    public void printStackTrace() {
        this.delegate.O000000o(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        this.delegate.O000000o(printStream);
    }

    public void printStackTrace(PrintWriter printWriter) {
        this.delegate.O000000o(printWriter);
    }

    public final void printPartialStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
    }
}
