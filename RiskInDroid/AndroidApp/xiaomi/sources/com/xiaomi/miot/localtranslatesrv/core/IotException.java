package com.xiaomi.miot.localtranslatesrv.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;

public class IotException extends Exception {
    public static final IotException ACTION_ARGUMENTS_ERROR = new IotException(-704220035, "action arguments error");
    public static final IotException ACTION_EXECUTE_ERROR = new IotException(-705201015, "action execute error");
    public static final IotException BAD_REQUEST = new IotException(-1, "bad request");
    public static final IotException DEVICE_NOT_FOUND = new IotException(1, "device not found");
    public static final IotException IRDEVICE_NOT_SUPPORT_OPERATION = new IotException(-704013101, "ir device not support operation");
    public static final IotException NOT_IMPLEMENTED = new IotException(2, "not implemented");
    public static final IotException PROPERTY_INVALID_VALUE = new IotException(3, "invalid property value");
    public static final IotException PROPERTY_READ_ERROR = new IotException(3, "property read error");
    public static final IotException PROPERTY_WRITE_ERROR = new IotException(-705201023, "property write error");
    private static final StackTraceElement[] UNASSIGNED_STACK = new StackTraceElement[0];
    private final int code;

    public IotException(int i, String str) {
        super(str, null, false, false);
        setStackTrace(UNASSIGNED_STACK);
        this.code = i;
    }

    private StringBuilder appendCause(StringBuilder sb, Throwable th) {
        while (th != null && !(th instanceof IotException)) {
            sb.append("Caused by: ");
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.close();
            sb.append(stringWriter.toString());
            th = th.getCause();
        }
        return sb;
    }

    @Deprecated
    public IotException detail(String str, String str2, Object... objArr) {
        return detail(str, null, str2, objArr);
    }

    @Deprecated
    public IotException detail(String str, Throwable th, String str2, Object... objArr) {
        if (th instanceof IotException) {
            return (IotException) th;
        }
        StringBuilder sb = new StringBuilder(getMessage());
        if (str2 != null) {
            sb.append(": ");
            sb.append(MessageFormat.format(str2, objArr));
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        new Throwable().printStackTrace(printWriter);
        printWriter.close();
        String stringWriter2 = stringWriter.toString();
        String substring = stringWriter2.substring(stringWriter2.indexOf(10, stringWriter2.indexOf(10, stringWriter2.indexOf(10) + 1) + 1));
        sb.append(10);
        sb.append(IotException.class.getName());
        sb.append(": ");
        sb.append(getMessage());
        sb.append(substring);
        return this;
    }

    @Deprecated
    public IotException detail(String str, Throwable th) {
        return detail(str, th, null, new Object[0]);
    }

    public int getCode() {
        return this.code;
    }
}
