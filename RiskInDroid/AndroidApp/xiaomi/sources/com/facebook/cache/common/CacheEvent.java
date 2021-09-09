package com.facebook.cache.common;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;

public interface CacheEvent {
    CacheKey getCacheKey();

    long getCacheLimit();

    long getCacheSize();

    CacheEventListener.EvictionReason getEvictionReason();

    IOException getException();

    long getItemSize();

    String getResourceId();
}
