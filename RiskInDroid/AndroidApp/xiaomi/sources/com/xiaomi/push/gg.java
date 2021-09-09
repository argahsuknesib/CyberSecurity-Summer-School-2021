package com.xiaomi.push;

import _m_j.eqt;
import _m_j.equ;
import java.io.PrintStream;
import java.io.PrintWriter;

public class gg extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private eqt f6384a = null;

    /* renamed from: a  reason: collision with other field name */
    private equ f42a = null;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f43a = null;

    public gg() {
    }

    public gg(eqt eqt) {
        this.f6384a = eqt;
    }

    public gg(String str) {
        super(str);
    }

    public gg(String str, Throwable th) {
        super(str);
        this.f43a = th;
    }

    public gg(Throwable th) {
        this.f43a = th;
    }

    public Throwable a() {
        return this.f43a;
    }

    public String getMessage() {
        eqt eqt;
        equ equ;
        String message = super.getMessage();
        return (message != null || (equ = this.f42a) == null) ? (message != null || (eqt = this.f6384a) == null) ? message : eqt.toString() : equ.toString();
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f43a != null) {
            printStream.println("Nested Exception: ");
            this.f43a.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f43a != null) {
            printWriter.println("Nested Exception: ");
            this.f43a.printStackTrace(printWriter);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        equ equ = this.f42a;
        if (equ != null) {
            sb.append(equ);
        }
        eqt eqt = this.f6384a;
        if (eqt != null) {
            sb.append(eqt);
        }
        if (this.f43a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f43a);
        }
        return sb.toString();
    }
}
