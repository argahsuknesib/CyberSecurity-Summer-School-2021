package com.google.common.collect;

import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$ImmutableMultiset$ndF2gsjcu9kVYBgBq_5wPZ70vMw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ImmutableMultiset$ndF2gsjcu9kVYBgBq_5wPZ70vMw implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$ImmutableMultiset$ndF2gsjcu9kVYBgBq_5wPZ70vMw INSTANCE = new $$Lambda$ImmutableMultiset$ndF2gsjcu9kVYBgBq_5wPZ70vMw();

    private /* synthetic */ $$Lambda$ImmutableMultiset$ndF2gsjcu9kVYBgBq_5wPZ70vMw() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((Multiset) obj).addAll((Multiset) obj2);
    }
}
