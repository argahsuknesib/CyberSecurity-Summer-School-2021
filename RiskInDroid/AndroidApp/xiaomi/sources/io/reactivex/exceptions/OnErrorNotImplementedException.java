package io.reactivex.exceptions;

import io.reactivex.annotations.NonNull;

public final class OnErrorNotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnErrorNotImplementedException(String str, @NonNull Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public OnErrorNotImplementedException(@NonNull Throwable th) {
        this("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | ".concat(String.valueOf(th)), th);
    }
}
