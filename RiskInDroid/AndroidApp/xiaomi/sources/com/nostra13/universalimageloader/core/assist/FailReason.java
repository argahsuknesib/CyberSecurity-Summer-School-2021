package com.nostra13.universalimageloader.core.assist;

public final class FailReason {

    /* renamed from: O000000o  reason: collision with root package name */
    private final FailType f5361O000000o;
    private final Throwable O00000Oo;

    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th) {
        this.f5361O000000o = failType;
        this.O00000Oo = th;
    }
}
