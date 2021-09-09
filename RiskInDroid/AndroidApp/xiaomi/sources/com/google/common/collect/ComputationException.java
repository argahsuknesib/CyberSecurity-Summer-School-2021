package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public class ComputationException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public ComputationException(Throwable th) {
        super(th);
    }
}
