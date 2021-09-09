package com.mibi.sdk.task.handler;

import android.os.Bundle;
import com.mibi.sdk.common.exception.CertificateDateNotValidException;
import com.mibi.sdk.common.exception.ConnectionException;
import com.mibi.sdk.common.exception.NetworkException;
import com.mibi.sdk.task.handler.ExceptionDispatcher;

public class ConnectionExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    public Class<? extends Throwable> registeredException() {
        return ConnectionException.class;
    }

    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        if (th instanceof ConnectionException) {
            Throwable cause = th.getCause();
            if (cause instanceof CertificateDateNotValidException) {
                return exceptionDispatcher.dispatchAs(cause, bundle, CertificateDateNotValidException.class);
            }
            return exceptionDispatcher.dispatchAs(th, bundle, NetworkException.class);
        }
        throw new IllegalStateException();
    }
}
