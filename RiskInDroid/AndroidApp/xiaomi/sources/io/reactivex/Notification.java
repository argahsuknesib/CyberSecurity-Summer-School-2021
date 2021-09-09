package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

public final class Notification<T> {
    static final Notification<Object> COMPLETE = new Notification<>(null);
    final Object value;

    private Notification(Object obj) {
        this.value = obj;
    }

    public final boolean isOnComplete() {
        return this.value == null;
    }

    public final boolean isOnError() {
        return NotificationLite.isError(this.value);
    }

    public final boolean isOnNext() {
        Object obj = this.value;
        return obj != null && !NotificationLite.isError(obj);
    }

    @Nullable
    public final T getValue() {
        Object obj = this.value;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return this.value;
    }

    @Nullable
    public final Throwable getError() {
        Object obj = this.value;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return ObjectHelper.equals(this.value, ((Notification) obj).value);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.value;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        Object obj = this.value;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.value + "]";
    }

    @NonNull
    public static <T> Notification<T> createOnNext(@NonNull T t) {
        ObjectHelper.requireNonNull(t, "value is null");
        return new Notification<>(t);
    }

    @NonNull
    public static <T> Notification<T> createOnError(@NonNull Throwable th) {
        ObjectHelper.requireNonNull(th, "error is null");
        return new Notification<>(NotificationLite.error(th));
    }

    @NonNull
    public static <T> Notification<T> createOnComplete() {
        return COMPLETE;
    }
}
