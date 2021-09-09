package io.realm;

import java.util.Locale;

public interface OrderedCollectionChangeSet {

    public enum State {
        INITIAL,
        UPDATE,
        ERROR
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f15333O000000o;
        public final int O00000Oo;

        public O000000o(int i, int i2) {
            this.f15333O000000o = i;
            this.O00000Oo = i2;
        }

        public final String toString() {
            return String.format(Locale.ENGLISH, "startIndex: %d, length: %d", Integer.valueOf(this.f15333O000000o), Integer.valueOf(this.O00000Oo));
        }
    }
}
