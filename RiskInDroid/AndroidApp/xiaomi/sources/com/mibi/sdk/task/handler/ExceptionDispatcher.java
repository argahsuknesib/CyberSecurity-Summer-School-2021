package com.mibi.sdk.task.handler;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

public class ExceptionDispatcher {
    private Map<Class<? extends Throwable>, ExceptionHandler> mDispatchMaps = new HashMap();

    public interface ExceptionHandler {
        boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher);

        Class<? extends Throwable> registeredException();
    }

    public ExceptionDispatcher register(ExceptionHandler exceptionHandler) {
        if (exceptionHandler == null || exceptionHandler.registeredException() == null) {
            throw new IllegalStateException();
        }
        this.mDispatchMaps.put(exceptionHandler.registeredException(), exceptionHandler);
        return this;
    }

    public boolean dispatch(Throwable th) {
        return dispatchAs(th, new Bundle(), th.getClass());
    }

    public boolean dispatchAs(Throwable th, Bundle bundle, Class<? extends Throwable> cls) {
        if (!cls.isAssignableFrom(th.getClass())) {
            return false;
        }
        while (cls != null && Throwable.class.isAssignableFrom(cls)) {
            ExceptionHandler exceptionHandler = this.mDispatchMaps.get(cls);
            if (exceptionHandler != null && exceptionHandler.handle(th, bundle, this)) {
                return true;
            }
            cls = cls.getSuperclass();
        }
        return false;
    }
}
