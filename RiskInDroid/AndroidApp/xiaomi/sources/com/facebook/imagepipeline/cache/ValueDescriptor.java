package com.facebook.imagepipeline.cache;

public interface ValueDescriptor<V> {
    int getSizeInBytes(Object obj);
}
