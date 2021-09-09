package com.google.common.hash;

import java.util.function.BinaryOperator;

/* renamed from: com.google.common.hash.-$$Lambda$BloomFilter$j8mscn2wdfq_052DogsIYVyRf94  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$BloomFilter$j8mscn2wdfq_052DogsIYVyRf94 implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$BloomFilter$j8mscn2wdfq_052DogsIYVyRf94 INSTANCE = new $$Lambda$BloomFilter$j8mscn2wdfq_052DogsIYVyRf94();

    private /* synthetic */ $$Lambda$BloomFilter$j8mscn2wdfq_052DogsIYVyRf94() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((BloomFilter) obj).putAll((BloomFilter) obj2);
    }
}
