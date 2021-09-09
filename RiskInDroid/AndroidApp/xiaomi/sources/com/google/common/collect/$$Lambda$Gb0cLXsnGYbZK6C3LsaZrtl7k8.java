package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$Gb0cLX-snGYbZK6C3LsaZrtl7k8  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Gb0cLXsnGYbZK6C3LsaZrtl7k8 implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$Gb0cLXsnGYbZK6C3LsaZrtl7k8 INSTANCE = new $$Lambda$Gb0cLXsnGYbZK6C3LsaZrtl7k8();

    private /* synthetic */ $$Lambda$Gb0cLXsnGYbZK6C3LsaZrtl7k8() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableSortedSet.Builder) obj).combine((ImmutableSet.Builder) ((ImmutableSortedSet.Builder) obj2));
    }
}
