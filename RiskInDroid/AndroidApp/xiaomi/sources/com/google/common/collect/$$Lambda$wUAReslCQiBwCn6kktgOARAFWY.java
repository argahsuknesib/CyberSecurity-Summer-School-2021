package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$wUARe-slCQiBwCn6kktgOARAFWY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$wUAReslCQiBwCn6kktgOARAFWY implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$wUAReslCQiBwCn6kktgOARAFWY INSTANCE = new $$Lambda$wUAReslCQiBwCn6kktgOARAFWY();

    private /* synthetic */ $$Lambda$wUAReslCQiBwCn6kktgOARAFWY() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableSet.Builder) obj).combine((ImmutableSet.Builder) obj2);
    }
}
