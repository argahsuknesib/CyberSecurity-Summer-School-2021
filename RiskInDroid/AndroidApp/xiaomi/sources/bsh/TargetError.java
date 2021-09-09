package bsh;

import _m_j.kv;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

public class TargetError extends EvalError {
    boolean inNativeCode;
    Throwable target;

    public TargetError(String str, Throwable th, SimpleNode simpleNode, kv kvVar, boolean z) {
        super(str, simpleNode, kvVar);
        this.target = th;
        this.inNativeCode = z;
    }

    public TargetError(Throwable th, SimpleNode simpleNode, kv kvVar) {
        this("TargetError", th, simpleNode, kvVar, false);
    }

    public Throwable getTarget() {
        Throwable th = this.target;
        return th instanceof InvocationTargetException ? ((InvocationTargetException) th).getTargetException() : th;
    }

    public boolean inNativeCode() {
        return this.inNativeCode;
    }

    public void printStackTrace() {
        printStackTrace(false, System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        printStackTrace(false, printStream);
    }

    public void printStackTrace(boolean z, PrintStream printStream) {
        if (z) {
            super.printStackTrace(printStream);
            printStream.println("--- Target Stack Trace ---");
        }
        this.target.printStackTrace(printStream);
    }

    public String printTargetError(Throwable th) {
        String th2 = this.target.toString();
        if (!Capabilities.O00000Oo()) {
            return th2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(th2);
        stringBuffer.append("\n");
        stringBuffer.append(xPrintTargetError(th));
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append("\nTarget exception: ");
        stringBuffer.append(printTargetError(this.target));
        return stringBuffer.toString();
    }

    public String xPrintTargetError(Throwable th) {
        Interpreter interpreter = new Interpreter();
        try {
            interpreter.O000000o("target", th);
            return (String) interpreter.O000000o("import java.lang.reflect.UndeclaredThrowableException;String result=\"\";while ( target instanceof UndeclaredThrowableException ) {\ttarget=target.getUndeclaredThrowable(); \tresult+=\"Nested: \"+target.toString();}return result;");
        } catch (EvalError e) {
            StringBuffer stringBuffer = new StringBuffer("xprintarget: ");
            stringBuffer.append(e.toString());
            throw new InterpreterError(stringBuffer.toString());
        }
    }
}
