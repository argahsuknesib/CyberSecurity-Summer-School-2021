package org.apache.commons.lang3.exception;

import _m_j.jdh;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public class ContextedException extends Exception implements jdh {
    private static final long serialVersionUID = 20110706;
    private final jdh exceptionContext;

    public ContextedException() {
        this.exceptionContext = new DefaultExceptionContext();
    }

    public ContextedException(String str) {
        super(str);
        this.exceptionContext = new DefaultExceptionContext();
    }

    public ContextedException(Throwable th) {
        super(th);
        this.exceptionContext = new DefaultExceptionContext();
    }

    public ContextedException(String str, Throwable th) {
        super(str, th);
        this.exceptionContext = new DefaultExceptionContext();
    }

    public ContextedException(String str, Throwable th, jdh jdh) {
        super(str, th);
        this.exceptionContext = jdh == null ? new DefaultExceptionContext() : jdh;
    }

    public ContextedException addContextValue(String str, Object obj) {
        this.exceptionContext.addContextValue(str, obj);
        return this;
    }

    public ContextedException setContextValue(String str, Object obj) {
        this.exceptionContext.setContextValue(str, obj);
        return this;
    }

    public List<Object> getContextValues(String str) {
        return this.exceptionContext.getContextValues(str);
    }

    public Object getFirstContextValue(String str) {
        return this.exceptionContext.getFirstContextValue(str);
    }

    public List<Pair<String, Object>> getContextEntries() {
        return this.exceptionContext.getContextEntries();
    }

    public Set<String> getContextLabels() {
        return this.exceptionContext.getContextLabels();
    }

    public String getMessage() {
        return getFormattedExceptionMessage(super.getMessage());
    }

    public String getRawMessage() {
        return super.getMessage();
    }

    public String getFormattedExceptionMessage(String str) {
        return this.exceptionContext.getFormattedExceptionMessage(str);
    }
}
