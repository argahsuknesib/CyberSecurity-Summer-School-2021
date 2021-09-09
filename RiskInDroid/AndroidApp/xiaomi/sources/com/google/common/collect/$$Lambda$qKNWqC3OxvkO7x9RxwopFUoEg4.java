package com.google.common.collect;

import com.google.common.collect.MoreCollectors;
import java.util.function.Function;

/* renamed from: com.google.common.collect.-$$Lambda$qKNWqC3OxvkO7x9RxwopFUo-Eg4  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$qKNWqC3OxvkO7x9RxwopFUoEg4 implements Function {
    public static final /* synthetic */ $$Lambda$qKNWqC3OxvkO7x9RxwopFUoEg4 INSTANCE = new $$Lambda$qKNWqC3OxvkO7x9RxwopFUoEg4();

    private /* synthetic */ $$Lambda$qKNWqC3OxvkO7x9RxwopFUoEg4() {
    }

    public final Object apply(Object obj) {
        return ((MoreCollectors.ToOptionalState) obj).getOptional();
    }
}
