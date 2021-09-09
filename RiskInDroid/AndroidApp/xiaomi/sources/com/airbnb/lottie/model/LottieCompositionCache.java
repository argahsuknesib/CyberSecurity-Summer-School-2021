package com.airbnb.lottie.model;

import _m_j.o0oOo0O0;
import com.airbnb.lottie.LottieComposition;

public class LottieCompositionCache {
    private static final LottieCompositionCache INSTANCE = new LottieCompositionCache();
    private final o0oOo0O0<String, LottieComposition> cache = new o0oOo0O0<>(10485760);

    public static LottieCompositionCache getInstance() {
        return INSTANCE;
    }

    LottieCompositionCache() {
    }

    public LottieComposition get(String str) {
        if (str == null) {
            return null;
        }
        return this.cache.get(str);
    }

    public void put(String str, LottieComposition lottieComposition) {
        if (str != null) {
            this.cache.put(str, lottieComposition);
        }
    }
}
