package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class HttpException extends IOException {

    /* renamed from: O000000o  reason: collision with root package name */
    static Class f15428O000000o;
    private final Throwable cause;
    private String reason;
    private int reasonCode;

    public HttpException() {
        this.reasonCode = 200;
        this.cause = null;
    }

    public HttpException(String str) {
        super(str);
        this.reasonCode = 200;
        this.cause = null;
    }

    public HttpException(String str, Throwable th) {
        super(str);
        Class cls;
        Class cls2;
        this.reasonCode = 200;
        this.cause = th;
        try {
            Class[] clsArr = new Class[1];
            if (f15428O000000o == null) {
                cls = class$("java.lang.Throwable");
                f15428O000000o = cls;
            } else {
                cls = f15428O000000o;
            }
            clsArr[0] = cls;
            if (f15428O000000o == null) {
                cls2 = class$("java.lang.Throwable");
                f15428O000000o = cls2;
            } else {
                cls2 = f15428O000000o;
            }
            cls2.getMethod("initCause", clsArr).invoke(this, th);
        } catch (Exception unused) {
        }
    }

    private static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public Throwable getCause() {
        return this.cause;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        try {
            getClass().getMethod("getStackTrace", new Class[0]);
            super.printStackTrace(printStream);
        } catch (Exception unused) {
            super.printStackTrace(printStream);
            if (this.cause != null) {
                printStream.print("Caused by: ");
                this.cause.printStackTrace(printStream);
            }
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        try {
            getClass().getMethod("getStackTrace", new Class[0]);
            super.printStackTrace(printWriter);
        } catch (Exception unused) {
            super.printStackTrace(printWriter);
            if (this.cause != null) {
                printWriter.print("Caused by: ");
                this.cause.printStackTrace(printWriter);
            }
        }
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReasonCode(int i) {
        this.reasonCode = i;
    }

    public int getReasonCode() {
        return this.reasonCode;
    }
}
