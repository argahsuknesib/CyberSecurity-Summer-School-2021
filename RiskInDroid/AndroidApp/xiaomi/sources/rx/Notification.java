package rx;

public final class Notification<T> {
    private static final Notification<Void> ON_COMPLETED = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind kind;
    private final Throwable throwable;
    private final T value;

    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> createOnNext(T t) {
        return new Notification<>(Kind.OnNext, t, null);
    }

    public static <T> Notification<T> createOnError(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> createOnCompleted() {
        return ON_COMPLETED;
    }

    @Deprecated
    public static <T> Notification<T> createOnCompleted(Class<T> cls) {
        return ON_COMPLETED;
    }

    private Notification(Kind kind2, T t, Throwable th) {
        this.value = t;
        this.throwable = th;
        this.kind = kind2;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final T getValue() {
        return this.value;
    }

    public final boolean hasValue() {
        return isOnNext() && this.value != null;
    }

    public final boolean hasThrowable() {
        return isOnError() && this.throwable != null;
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final boolean isOnError() {
        return getKind() == Kind.OnError;
    }

    public final boolean isOnCompleted() {
        return getKind() == Kind.OnCompleted;
    }

    public final boolean isOnNext() {
        return getKind() == Kind.OnNext;
    }

    public final void accept(Observer<? super T> observer) {
        if (this.kind == Kind.OnNext) {
            observer.onNext(getValue());
        } else if (this.kind == Kind.OnCompleted) {
            observer.onCompleted();
        } else {
            observer.onError(getThrowable());
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(' ');
        sb.append(getKind());
        if (hasValue()) {
            sb.append(' ');
            sb.append(getValue());
        }
        if (hasThrowable()) {
            sb.append(' ');
            sb.append(getThrowable().getMessage());
        }
        sb.append(']');
        return sb.toString();
    }

    public final int hashCode() {
        int hashCode = getKind().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        return hasThrowable() ? (hashCode * 31) + getThrowable().hashCode() : hashCode;
    }

    public final boolean equals(Object obj) {
        T t;
        T t2;
        Throwable th;
        Throwable th2;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Notification notification = (Notification) obj;
        return notification.getKind() == getKind() && ((t = this.value) == (t2 = notification.value) || (t != null && t.equals(t2))) && ((th = this.throwable) == (th2 = notification.throwable) || (th != null && th.equals(th2)));
    }
}
