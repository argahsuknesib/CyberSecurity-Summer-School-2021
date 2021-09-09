package com.xiaomi.miot.support.monitor.leak;

public interface Retryable {

    public enum Result {
        DONE,
        RETRY,
        LEAKED
    }

    Result O000000o();
}
