package com.google.common.collect;

import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$Multimaps$EGq-BcBjNFW4VPyKfp3wZs77_0A  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Multimaps$EGqBcBjNFW4VPyKfp3wZs77_0A implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$Multimaps$EGqBcBjNFW4VPyKfp3wZs77_0A INSTANCE = new $$Lambda$Multimaps$EGqBcBjNFW4VPyKfp3wZs77_0A();

    private /* synthetic */ $$Lambda$Multimaps$EGqBcBjNFW4VPyKfp3wZs77_0A() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((Multimap) obj).putAll((Multimap) obj2);
    }
}
