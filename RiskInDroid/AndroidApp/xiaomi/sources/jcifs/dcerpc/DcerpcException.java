package jcifs.dcerpc;

import _m_j.itu;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class DcerpcException extends IOException implements itu {
    private int error;
    private Throwable rootCause;

    public DcerpcException(String str) {
        super(str);
    }

    public DcerpcException(String str, Throwable th) {
        super(str);
        this.rootCause = th;
    }

    public int getErrorCode() {
        return this.error;
    }

    public Throwable getRootCause() {
        return this.rootCause;
    }

    public String toString() {
        if (this.rootCause == null) {
            return super.toString();
        }
        StringWriter stringWriter = new StringWriter();
        this.rootCause.printStackTrace(new PrintWriter(stringWriter));
        return super.toString() + "\n" + stringWriter;
    }
}
