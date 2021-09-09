package com.google.protobuf;

interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = new MutabilityOracle() {
        /* class com.google.protobuf.MutabilityOracle.AnonymousClass1 */

        public final void ensureMutable() {
            throw new UnsupportedOperationException();
        }
    };

    void ensureMutable();
}
