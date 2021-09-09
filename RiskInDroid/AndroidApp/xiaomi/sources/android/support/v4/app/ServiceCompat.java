package android.support.v4.app;

import android.app.Service;
import android.support.annotation.RestrictTo;
import android.support.v4.os.BuildCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat {
    static final ServiceCompatImpl IMPL;

    interface ServiceCompatImpl {
        void stopForeground(Service service, int i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    static class BaseServiceCompatImpl implements ServiceCompatImpl {
        BaseServiceCompatImpl() {
        }

        public void stopForeground(Service service, int i) {
            boolean z = true;
            if ((i & 1) == 0) {
                z = false;
            }
            service.stopForeground(z);
        }
    }

    static class Api24ServiceCompatImpl implements ServiceCompatImpl {
        Api24ServiceCompatImpl() {
        }

        public void stopForeground(Service service, int i) {
            ServiceCompatApi24.stopForeground(service, i);
        }
    }

    static {
        if (BuildCompat.isAtLeastN()) {
            IMPL = new Api24ServiceCompatImpl();
        } else {
            IMPL = new BaseServiceCompatImpl();
        }
    }

    public static void stopForeground(Service service, int i) {
        IMPL.stopForeground(service, i);
    }
}
