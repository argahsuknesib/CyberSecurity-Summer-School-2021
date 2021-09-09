package com.airbnb.lottie;

import java.util.Arrays;

public final class LottieResult<V> {
    private final Throwable exception;
    private final V value;

    public LottieResult(Object obj) {
        this.value = obj;
        this.exception = null;
    }

    public LottieResult(Throwable th) {
        this.exception = th;
        this.value = null;
    }

    public final V getValue() {
        return this.value;
    }

    public final Throwable getException() {
        return this.exception;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult lottieResult = (LottieResult) obj;
        if (getValue() != null && getValue().equals(lottieResult.getValue())) {
            return true;
        }
        if (getException() == null || lottieResult.getException() == null) {
            return false;
        }
        return getException().toString().equals(getException().toString());
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), getException()});
    }
}
