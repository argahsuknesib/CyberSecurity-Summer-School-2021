package com.facebook.common.time;

import com.facebook.common.internal.DoNotStrip;

public interface MonotonicClock {
    @DoNotStrip
    long now();
}
