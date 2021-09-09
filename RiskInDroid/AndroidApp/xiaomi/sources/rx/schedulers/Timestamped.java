package rx.schedulers;

public final class Timestamped<T> {
    private final long timestampMillis;
    private final T value;

    public Timestamped(long j, T t) {
        this.value = t;
        this.timestampMillis = j;
    }

    public final long getTimestampMillis() {
        return this.timestampMillis;
    }

    public final T getValue() {
        return this.value;
    }

    public final boolean equals(Object obj) {
        T t;
        T t2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Timestamped)) {
            return false;
        }
        Timestamped timestamped = (Timestamped) obj;
        return this.timestampMillis == timestamped.timestampMillis && ((t = this.value) == (t2 = timestamped.value) || (t != null && t.equals(t2)));
    }

    public final int hashCode() {
        long j = this.timestampMillis;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.value;
        return i + (t == null ? 0 : t.hashCode());
    }

    public final String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.timestampMillis), this.value.toString());
    }
}
