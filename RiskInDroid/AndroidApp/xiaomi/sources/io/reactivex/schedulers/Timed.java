package io.reactivex.schedulers;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

public final class Timed<T> {
    final long time;
    final TimeUnit unit;
    final T value;

    public Timed(@NonNull T t, long j, @NonNull TimeUnit timeUnit) {
        this.value = t;
        this.time = j;
        this.unit = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
    }

    @NonNull
    public final T value() {
        return this.value;
    }

    @NonNull
    public final TimeUnit unit() {
        return this.unit;
    }

    public final long time() {
        return this.time;
    }

    public final long time(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.time, this.unit);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Timed) {
            Timed timed = (Timed) obj;
            if (!ObjectHelper.equals(this.value, timed.value) || this.time != timed.time || !ObjectHelper.equals(this.unit, timed.unit)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        T t = this.value;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.time;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.unit.hashCode();
    }

    public final String toString() {
        return "Timed[time=" + this.time + ", unit=" + this.unit + ", value=" + ((Object) this.value) + "]";
    }
}
