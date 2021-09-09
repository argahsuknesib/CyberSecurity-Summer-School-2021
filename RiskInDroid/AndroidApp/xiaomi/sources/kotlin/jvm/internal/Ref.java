package kotlin.jvm.internal;

import java.io.Serializable;

public final class Ref {

    public static final class ObjectRef<T> implements Serializable {
        public T element;

        public final String toString() {
            return String.valueOf(this.element);
        }
    }

    public static final class BooleanRef implements Serializable {
        public boolean element;

        public final String toString() {
            return String.valueOf(this.element);
        }
    }
}
