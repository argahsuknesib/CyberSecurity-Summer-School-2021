package com.google.common.collect;

import com.google.common.collect.MoreCollectors;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$T3Z3qL6s2UgnlIibFIHZE8hnQd8  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$T3Z3qL6s2UgnlIibFIHZE8hnQd8 implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$T3Z3qL6s2UgnlIibFIHZE8hnQd8 INSTANCE = new $$Lambda$T3Z3qL6s2UgnlIibFIHZE8hnQd8();

    private /* synthetic */ $$Lambda$T3Z3qL6s2UgnlIibFIHZE8hnQd8() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((MoreCollectors.ToOptionalState) obj).combine((MoreCollectors.ToOptionalState) obj2);
    }
}
