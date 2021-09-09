package org.apache.commons.lang.exception;

import _m_j.jcz;
import _m_j.jda;
import java.io.PrintStream;
import java.io.PrintWriter;

public class NestableException extends Exception implements jda {
    private static final long serialVersionUID = 1;
    private Throwable cause = null;
    protected NestableDelegate delegate = new NestableDelegate(this);

    public NestableException() {
    }

    public NestableException(String str) {
        super(str);
    }

    public NestableException(Throwable th) {
        this.cause = th;
    }

    public NestableException(String str, Throwable th) {
        super(str);
        this.cause = th;
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
