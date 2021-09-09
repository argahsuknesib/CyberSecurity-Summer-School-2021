package com.google.common.collect;

import com.google.common.collect.ImmutableRangeMap;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$-zFfqyVq5T798wGUZivKwgD4lls  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$zFfqyVq5T798wGUZivKwgD4lls implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$zFfqyVq5T798wGUZivKwgD4lls INSTANCE = new $$Lambda$zFfqyVq5T798wGUZivKwgD4lls();

    private /* synthetic */ $$Lambda$zFfqyVq5T798wGUZivKwgD4lls() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableRangeMap.Builder) obj).combine((ImmutableRangeMap.Builder) obj2);
    }
}
